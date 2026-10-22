package com.hw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import com.bytedance.push.utils.f;
import com.huawei.GetTokenAndUploadRunnable;
import com.huawei.HMSUtils;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.HmsProfile;
import com.huawei.hms.push.plugin.notification.HmsNotificationManagerEx;
import com.huawei.hms.push.plugin.notification.NotificationStatus;
import com.huawei.hms.utils.Util;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import j77.i;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class HWPushAdapter extends com.bytedance.push.third.b implements IPushAdapter {
    private static int HW_PUSH = -1;
    public static final String TAG = "HWPush";
    private volatile boolean appStatusHasChanged;
    private int dialogRequestPushType;
    private boolean hasShown;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f278271a;

        @Override // java.lang.Runnable
        public final void run() {
            LocalSettings r100 = (LocalSettings) i.a(this.f278271a, LocalSettings.class);     // Catch: Throwable -> L6
            if (r100.U() != 0) goto L9;
            f.g(HWPushAdapter.TAG, "update LastHwDialogShowTime to cur time because app first launch");     // Catch: Throwable -> L6
            r100.e0(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(Context r100) {
            this.f278271a = r100;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f278272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f278273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f278274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f278275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f278276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HWPushAdapter f278277f;

        public class a implements OnFailureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f278278a;

            public a(b r100) {
                this.f278278a = r100;
            }

            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception r110) {
                f.e(HWPushAdapter.TAG, "[huaweiPushPermissionDialog] onFailure:" + r110.getLocalizedMessage());
                HWPushAdapter.access$002(this.f278278a.f278277f, false);
                b r100 = this.f278278a;
                HWPushAdapter r101 = r100.f278277f;
                String r102 = r100.f278274c;
                int r103 = r100.f278276e;
                String r104 = "onError:" + r110.getLocalizedMessage();
                b r111 = this.f278278a;
                HWPushAdapter.access$100(r101, r102, r103, "hms", false, r104, r111.f278275d, r111.f278273b);
            }
        }

        /* JADX INFO: renamed from: com.hw.HWPushAdapter$b$b, reason: collision with other inner class name */
        public class C3877b implements OnSuccessListener<NotificationStatus> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f278279a;

            public C3877b(b r100) {
                this.f278279a = r100;
            }

            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(NotificationStatus r110) {
                NotificationStatus r111 = r110;
                f.g(HWPushAdapter.TAG, "[huaweiPushPermissionDialog] onSuccess ,notificationStatus.getStatus: " + r111.getStatus());
                HWPushAdapter.access$002(this.f278279a.f278277f, false);
                f.g(HWPushAdapter.TAG, "enable notification status success,topActivity:" + this.f278279a.f278272a);     // Catch: Throwable -> L9
                b r100 = this.f278279a;     // Catch: Throwable -> L9
                HWPushAdapter.access$202(r100.f278277f, r100.f278273b);     // Catch: Throwable -> L9
                b r101 = this.f278279a;     // Catch: Throwable -> L9
                HWPushAdapter.access$302(r101.f278277f, r101.f278274c);     // Catch: Throwable -> L9
                if (this.f278279a.f278275d != 0) goto L6;
                int r102 = com.bytedance.push.third.b.REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_SYS_DIALOG;
            L7:
                ActivityLifecycleObserver.getIns().addObserver(new com.hw.a(this, r102));     // Catch: Throwable -> L9
                r111.startResolutionForResult(this.f278279a.f278272a, r102);     // Catch: Throwable -> L9
                b r112 = this.f278279a;     // Catch: Throwable -> L9
                HWPushAdapter.access$500(r112.f278277f, r112.f278274c, r112.f278276e, "hms", true, "success", r112.f278275d, r112.f278273b);     // Catch: Throwable -> L9
                ((LocalSettings) i.a(AppProvider.getApp(), LocalSettings.class)).e0(System.currentTimeMillis());     // Catch: Throwable -> L9
                return;
            L6:
                r102 = com.bytedance.push.third.b.REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_CUSTOM_DIALOG;
            L9:
                th = move-exception;
                f.e(HWPushAdapter.TAG, "enable notification catch exception: " + th.getMessage());
                b r103 = this.f278279a;
                HWPushAdapter r104 = r103.f278277f;
                String r105 = r103.f278274c;
                int r106 = r103.f278276e;
                String r107 = "error when startResolutionForResult:" + th.getLocalizedMessage();
                b r113 = this.f278279a;
                HWPushAdapter.access$600(r104, r105, r106, "hms", false, r107, r113.f278275d, r113.f278273b);
            }
        }

        public final void a() {
            HmsNotificationManagerEx.getInstance(this.f278272a).enableNotification().addOnSuccessListener(new C3877b(this)).addOnFailureListener(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            f.e(HWPushAdapter.TAG, "[requestNotificationPermissionInternal] exception:" + th.getLocalizedMessage());
            HWPushAdapter.access$002(this.f278277f, false);
            HWPushAdapter.access$700(this.f278277f, this.f278274c, this.f278276e, "hms", false, "exception:" + th.getLocalizedMessage(), this.f278275d, this.f278273b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(HWPushAdapter r100, Activity r101, RequestResultCallback r102, String r103, int r104, int r105) {
            this.f278277f = r100;
            this.f278272a = r101;
            this.f278273b = r102;
            this.f278274c = r103;
            this.f278275d = r104;
            this.f278276e = r105;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f278280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f278281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f278282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HWPushAdapter f278283d;

        public final void a() {
            f.g(HWPushAdapter.TAG, "[onUserClickResultInternal]hasCallbackClickResult:" + HWPushAdapter.access$800(this.f278283d));
            if (HWPushAdapter.access$900(this.f278283d) == false) goto L5;
            return;
        L5:
            HWPushAdapter.access$1002(this.f278283d, true);
        L16:
            th = move-exception;
            f.f(HWPushAdapter.TAG, "onUserClickResult error ", th);
            return;
        L7:
            if (this.f278280a != 0) goto L9;
            PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(HWPushAdapter.access$1100(this.f278283d), "hms", HWPushAdapter.getHwPush(), this.f278280a, this.f278281b, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), null);     // Catch: Throwable -> L16
        L9:
            RequestResultCallback r100 = this.f278282c;     // Catch: Throwable -> L16
            if (r100 != null) goto L12;
            return;
        L12:
            if (this.f278281b == false) goto L14;
            r100.onUserAgree(true);     // Catch: Throwable -> L16
            return;
        L14:
            r100.onUserReject();     // Catch: Throwable -> L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(HWPushAdapter r100, int r101, boolean r102, RequestResultCallback r103) {
            this.f278283d = r100;
            this.f278280a = r101;
            this.f278281b = r102;
            this.f278282c = r103;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public class d implements OnCompleteListener<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task[] f278284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f278285b;

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void onComplete(Task<Void> r100) {
            f.g(HWPushAdapter.TAG, "onComplete add profile id,task is :" + r100.isSuccessful());
            this.f278284a[0] = r100;
            this.f278285b.countDown();
        }

        public d(Task[] r100, CountDownLatch r101) {
            this.f278284a = r100;
            this.f278285b = r101;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public class e implements OnCompleteListener<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task[] f278286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f278287b;

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void onComplete(Task<Void> r100) {
            f.g(HWPushAdapter.TAG, "onComplete delete profile id,task is :" + r100.isSuccessful());
            this.f278286a[0] = r100;
            this.f278287b.countDown();
        }

        public e(Task[] r100, CountDownLatch r101) {
            this.f278286a = r100;
            this.f278287b = r101;
        }
    }

    @Override // com.bytedance.push.third.b
    public int getPushType() {
        return 7;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context r100, int r101, Object r102) {
    }

    public static int getHwPush() {
        if (HW_PUSH != (-1)) goto L6;
        HW_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(HWPushAdapter.class.getName());
    L6:
        return HW_PUSH;
    }

    public HWPushAdapter() {
        this.hasShown = false;
        this.dialogRequestPushType = -1;
        this.appStatusHasChanged = false;
    }

    public static /* synthetic */ String access$1100(HWPushAdapter r100) {
        return r100.mCurScenes;
    }

    public static /* synthetic */ boolean access$800(HWPushAdapter r100) {
        return r100.hasCallbackClickResult;
    }

    public static /* synthetic */ boolean access$900(HWPushAdapter r100) {
        return r100.hasCallbackClickResult;
    }

    public static /* synthetic */ boolean access$002(HWPushAdapter r100, boolean r101) {
        r100.hasShown = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1002(HWPushAdapter r100, boolean r101) {
        r100.hasCallbackClickResult = r101;
        return r101;
    }

    public static /* synthetic */ RequestResultCallback access$202(HWPushAdapter r100, RequestResultCallback r101) {
        r100.mRequestResultCallback = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(HWPushAdapter r100, String r101) {
        r100.mCurScenes = r101;
        return r101;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String r100, Context r101) throws Exception {
        if (TextUtils.isEmpty(Util.getAppId(r101)) == false) goto L5;
        f.b(r100, "HWPush. You need to declare metadata \"com.huawei.hms.client.appid \" in AndroidManifest.xml");
        boolean r102 = false;
    L7:
        return ManifestUtils.checkService(r101, r100, TAG, Collections.singletonList(Component.Builder.create("com.huawei.MessageService").setProcess(r101.getPackageName()).addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.huawei.push.action.MESSAGING_EVENT"))).build())) & r102;
    L5:
        r102 = true;
        goto L7
    }

    @Override // com.bytedance.push.third.b
    public boolean deleteProfileId(Context r110, String r111) {
        long r100 = System.currentTimeMillis();
        boolean r101 = HmsProfile.getInstance(r110).isSupportProfile();     // Catch: Throwable -> L18
        PushSupporter.logger().d(TAG, "[deleteProfileId]supportProfile:" + r101);     // Catch: Throwable -> L18
        String r102 = null;
        if (r101 == false) goto L20;
        f.g(TAG, "cur device support profile id,delete profile id,profileId is " + r111);     // Catch: Throwable -> L18
        CountDownLatch r103 = new CountDownLatch(1);     // Catch: Throwable -> L18
        Task[] r104 = {null};     // Catch: Throwable -> L18
        HmsProfile.getInstance(r110).deleteProfile(r111).addOnCompleteListener(new e(r104, r103));     // Catch: Throwable -> L18
        r103.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8 Throwable -> L18
    L10:
        Task r105 = r104[0];     // Catch: Throwable -> L18
        f.g(TAG, "finished delete profile id,task is :" + r105);     // Catch: Throwable -> L18
        if (r105 == null) goto L17;
        f.g(TAG, "finished delete profile id,success:" + r105.isSuccessful());     // Catch: Throwable -> L18
        if (r105.isSuccessful() == false) goto L15;
        int r106 = 1;
    L21:
        String r112 = r102;
    L23:
        onDeleteProfileIdResult(getHwPush(), r100, r106, r112);
        if (r106 != 1) goto L31;
        return true;
    L31:
        return false;
    L15:
        f.g(TAG, "delete profile id error msg is :" + r105.getException().getLocalizedMessage());     // Catch: Throwable -> L18
        r102 = r105.getException().getLocalizedMessage();     // Catch: Throwable -> L18
        r106 = 6;
        goto L21
    L17:
        r106 = 4;
        goto L21
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        goto L10
    L20:
        r106 = 3;
    L18:
        th = move-exception;
        r112 = th.getLocalizedMessage();
        r106 = 5;
        goto L23
    }

    @Override // com.bytedance.push.third.b
    public String isBusinessAlertDialogAvailable(Context r100, boolean r101) {
        if (isPushAvailable(r100, HW_PUSH) == true) goto L6;
        f.g(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
        return "push is not available";
    L6:
        com.ss.android.pushmanager.setting.b.b().getClass();
        PushOnlineSettings r102 = com.ss.android.pushmanager.setting.b.d();
        if (r102.y() == true) goto L10;
        f.g(TAG, "[isBusinessAlertDialogAvailable]return false because enableHmsBusinessNotificationDialog is false");
        return "enableHmsBusinessNotificationDialog is false";
    L10:
        if (r101 == false) goto L19;
        LocalSettings r103 = (LocalSettings) i.a(r100, LocalSettings.class);
        if (r103.U() != 0) goto L16;
        f.i(TAG, "[isBusinessAlertDialogAvailable]return false  because lastHwDialogShowTime is 0");
        r103.e0(System.currentTimeMillis());
        return "lastHwDialogShowTime is 0";
    L16:
        if ((System.currentTimeMillis() - r103.U()) >= r102.T()) goto L19;
        f.i(TAG, "[isBusinessAlertDialogAvailable]return false because frequency control");
        return "frequency control";
    L19:
        f.g(TAG, "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context r100, int r101) {
        PushThreadHandlerManager.inst().postRunnable(new a(r100));
        return HMSUtils.isHMSAvailable(r100);
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context r100, int r101) {
        if (r100 != null) goto L4;
    L11:
        if (r100 != null) goto L13;
        String r102 = "context is null";
    L14:
        PushSupporter.monitor().monitorRegisterSenderFailed(r101, 101, "0", r102);
        return;
    L13:
        r102 = "register channel error";
        goto L14
    L4:
        if (r101 != getHwPush()) goto L11;
        if (PushSupporter.logger().debug() == false) goto L9;
        PushSupporter.logger().d(TAG, "registerHWPush");
    L9:
        ThreadPlus.submitRunnable(new GetTokenAndUploadRunnable(r100));
    }

    @Override // com.bytedance.push.third.b
    public boolean setProfileId(Context r110, String r111) {
        long r100 = System.currentTimeMillis();
        String r101 = null;
        int r102 = 2;
        if (TextUtils.isEmpty(r111) == false) goto L6;
    L23:
        int r112 = r102;
    L24:
        String r113 = r101;
    L26:
        onSetProfileIdResult(getHwPush(), r100, r112, r113);
        if (r112 != 1) goto L33;
        return true;
    L33:
        return false;
    L6:
        if (HmsProfile.getInstance(r110).isSupportProfile() == false) goto L19;
        f.g(TAG, "cur device support profile id,set profile id,profileId is " + r111);     // Catch: Throwable -> L21
        CountDownLatch r103 = new CountDownLatch(1);     // Catch: Throwable -> L21
        Task[] r104 = {null};     // Catch: Throwable -> L21
        HmsProfile.getInstance(r110).addProfile(2, r111).addOnCompleteListener(new d(r104, r103));     // Catch: Throwable -> L21
        r103.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L10 Throwable -> L21
    L12:
        Task r114 = r104[0];     // Catch: Throwable -> L21
        f.g(TAG, "finished add profile id,task is :" + r114);     // Catch: Throwable -> L21
        if (r114 == null) goto L18;
        f.g(TAG, "finished add profile id,success:" + r114.isSuccessful());     // Catch: Throwable -> L21
        if (r114.isSuccessful() == false) goto L17;
        r102 = 1;
        goto L23
    L17:
        f.g(TAG, "error msg is :" + r114.getException().getLocalizedMessage());     // Catch: Throwable -> L21
        r101 = r114.getException().getLocalizedMessage();     // Catch: Throwable -> L21
        r112 = 6;
        goto L24
    L18:
        r102 = 4;
        goto L23
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L12
    L19:
        f.g(TAG, "cur device not support profile id set,can't set profile id");     // Catch: Throwable -> L21
        r102 = 3;
    L21:
        th = move-exception;
        th.printStackTrace();
        f.e(TAG, "error when trySetProfileId:" + th.getLocalizedMessage());
        r113 = th.getLocalizedMessage();
        r112 = 5;
        goto L26
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context r100, int r101) {
        if (PushSupporter.logger().debug() == false) goto L6;
        PushSupporter.logger().d(TAG, "unregisterPush");
    L6:
        if (DeviceUtils.isEmui() == true) goto L15;
        return;
    L15:
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (TextUtils.isEmpty(PushSupporter.thirdService().getToken(r100, r101)) == true) goto L17;
        HmsInstanceId.getInstance(r100).deleteToken(Util.getAppId(r100), HmsMessaging.DEFAULT_TOKEN_SCOPE);     // Catch: Throwable -> L12
        return;
    }

    @Override // com.bytedance.push.third.b
    public void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 == 61520) goto L5;
        if (r100 == 61521) goto L5;
        return;
    L5:
        f.g(TAG, "on request hw notification permission result,resultCode is " + r101);
        boolean r103 = true;
        if (r100 != 61521) goto L8;
        int r104 = 1;
    L10:
        if (r101 == (-1)) goto L13;
        r103 = false;
    L13:
        onUserClickResult(r103, r104, r100, this.mRequestResultCallback);
        return;
    L8:
        r104 = 0;
        goto L10
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == getHwPush()) goto L7;
        return;
    L7:
        if (PushSupporter.logger().debug() == false) goto L11;
        PushSupporter.logger().d(TAG, "setAlias");
        return;
    }

    private void onUserClickResult(boolean r100, int r101, int r102, RequestResultCallback r103) {
        f.g(TAG, "[onUserClickResult]on request hw notification permission result,report click event,hasAgree:" + r100 + " sysAlertStyle:" + r101);
        PushThreadHandlerManager.inst().postRunnable(new c(this, r101, r100, r103));
    }

    @Override // com.bytedance.push.third.b
    public boolean requestNotificationPermission(String r110, int r111, int r112, RequestResultCallback r113) {
        Activity r100 = ActivityLifecycleObserver.getIns().getTopActivity();
        if (r100 != null) goto L7;
        f.e(TAG, "can't requestNotificationPermission on hw device because topActivity is null");
        onGuideRequestResult(r110, r111, "hms", false, "topActivity is null,app is not in the foreground!", r113);
        return false;
    L7:
        if (this.hasShown == false) goto L10;
        f.e(TAG, "can't requestNotificationPermission because cur has showing");
        onGuideRequestResult(r110, r111, "hms", false, "cur has showing", r113);
        return false;
    L10:
        this.hasShown = true;
        this.hasCallbackShowResult = false;
        this.hasCallbackClickResult = false;
        this.dialogRequestPushType = r111;
        requestNotificationPermissionInternal(r110, r111, r100, r113, r112, r113);
        return true;
    }

    public static /* synthetic */ void access$400(HWPushAdapter r100, boolean r101, int r102, int r103, RequestResultCallback r104) {
        r100.onUserClickResult(r101, r102, r103, r104);
    }

    private void requestNotificationPermissionInternal(String r100, int r110, Activity r111, RequestResultCallback r112, int r113, RequestResultCallback r114) {
        PushThreadHandlerManager.inst().postRunnable(new b(this, r111, r112, r100, r113, r110));
    }

    public static /* synthetic */ void access$100(HWPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, int r106, RequestResultCallback r107) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ void access$500(HWPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, int r106, RequestResultCallback r107) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ void access$600(HWPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, int r106, RequestResultCallback r107) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ void access$700(HWPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, int r106, RequestResultCallback r107) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106, r107);
    }
}
