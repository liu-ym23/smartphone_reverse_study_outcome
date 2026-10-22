package com.vv;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.VivoPushException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class VvPushAdapter extends com.bytedance.push.third.b implements IPushAdapter {
    private static final String TAG = "VivoPush";
    private static int VV_PUSH = -1;
    private static boolean hasSendValidToken;
    private static boolean sHasRegistered;
    private final long DIALOG_SHOW_TIME_OUT;
    private final String SUCCESS;
    private volatile boolean appStatusHasChanged;
    private boolean hasShown;
    private final Handler mHandler;

    /* JADX INFO: loaded from: classes41.dex */
    public class a implements IPushActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f462929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f462930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VvPushAdapter f462931c;

        /* JADX INFO: renamed from: com.vv.VvPushAdapter$a$a, reason: collision with other inner class name */
        public class C5559a implements IPushQueryActionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f462932a;

            public C5559a(a r100) {
                this.f462932a = r100;
            }

            @Override // com.vivo.push.listener.IPushRequestListener
            public final void onFail(Integer r100) {
                PushSupporter.logger().e(VvPushAdapter.TAG, "onFail,error code: " + r100);
            }

            @Override // com.vivo.push.listener.IPushRequestListener
            public final void onSuccess(String r100) {
                String r101 = r100;
                if (TextUtils.isEmpty(r101) == true) goto L6;
                PushSupporter.logger().i(VvPushAdapter.TAG, "success get token");
                PushSupporter.logger().d(VvPushAdapter.TAG, "token = " + r101);
                VvPushAdapter.access$000(this.f462932a.f462931c).post(new com.vv.a(this, r101));
                return;
            }
        }

        @Override // com.vivo.push.IPushActionListener
        public final void onStateChanged(int r100) {
            if (r100 == 0) goto L5;
            PushSupporter.monitor().monitorRegisterSenderFailed(this.f462929a, 104, String.valueOf(r100), "vivo channel register failed");
            PushSupporter.logger().e(VvPushAdapter.TAG, "open push error [" + r100 + "] ，please check the official documentation of the vendor");
        L6:
            PushClient.getInstance(this.f462930b).getRegId(new C5559a(this));
            return;
        L5:
            PushSupporter.logger().i(VvPushAdapter.TAG, "open push success");
            goto L6
        }

        public a(VvPushAdapter r100, int r101, Context r102) {
            this.f462931c = r100;
            this.f462929a = r101;
            this.f462930b = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f462934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f462935c;

        public final void a() {
            PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(this.f462933a, "vv", VvPushAdapter.getVvPush(), 0, this.f462934b, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), null);     // Catch: Throwable -> L9
            RequestResultCallback r100 = this.f462935c;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L12:
            return;
        L5:
            if (this.f462934b == false) goto L7;
            r100.onUserAgree(true);     // Catch: Throwable -> L9
            goto L12
        L7:
            r100.onUserReject();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            com.bytedance.push.utils.f.f(VvPushAdapter.TAG, "onUserClickResult error ", th);
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

        public b(String r100, boolean r101, RequestResultCallback r102) {
            this.f462933a = r100;
            this.f462934b = r101;
            this.f462935c = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class c implements IPushActionListener {
        public c() {
        }

        @Override // com.vivo.push.IPushActionListener
        public final void onStateChanged(int r100) {
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "onStateChanged() called with: i = [" + r100 + "]");
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class d implements IPushActionListener {
        public d() {
        }

        @Override // com.vivo.push.IPushActionListener
        public final void onStateChanged(int r100) {
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "onStateChanged() called with: i = [" + r100 + "]");
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f462936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f462937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f462938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f462940e;

        public class a implements IPushRequestCallback<Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f462941a;

            public a(e r100) {
                this.f462941a = r100;
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            public final void onError(int r100) {
                this.f462941a.f462938c[0] = Boolean.FALSE;
                PushSupporter.logger().e(VvPushAdapter.TAG, "[setProfileId]failed set profile id:" + r100);
                this.f462941a.f462940e[0] = "vv error:" + r100;
                this.f462941a.f462939d.countDown();
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            public final void onSuccess(Integer r100) {
                PushSupporter.logger().d(VvPushAdapter.TAG, "[setProfileId]success set profile id:" + r100);
                e r101 = this.f462941a;
                r101.f462938c[0] = Boolean.TRUE;
                r101.f462939d.countDown();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            PushClient.getInstance(this.f462936a).addProfileId(this.f462937b, new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(Context r100, String r101, Boolean[] r102, CountDownLatch r103, String[] r104) {
            this.f462936a = r100;
            this.f462937b = r101;
            this.f462938c = r102;
            this.f462939d = r103;
            this.f462940e = r104;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class f implements IPushRequestCallback<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f462942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f462943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f462944c;

        @Override // com.vivo.push.restructure.request.IPushRequestCallback
        public final void onError(int r100) {
            this.f462942a[0] = Boolean.FALSE;
            PushSupporter.logger().d(VvPushAdapter.TAG, "[deleteProfileId]failed set profile id:" + r100);
            this.f462944c[0] = "vv error:" + r100;
            this.f462943b.countDown();
        }

        @Override // com.vivo.push.restructure.request.IPushRequestCallback
        public final void onSuccess(Integer r100) {
            PushSupporter.logger().d(VvPushAdapter.TAG, "[deleteProfileId]success delete profile id:" + r100);
            this.f462942a[0] = Boolean.TRUE;
            this.f462943b.countDown();
        }

        public f(Boolean[] r100, CountDownLatch r101, String[] r102) {
            this.f462942a = r100;
            this.f462943b = r101;
            this.f462944c = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class g implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f462946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f462947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VvPushAdapter f462948d;

        public class a implements oqc.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f462949a;

            public a(g r100) {
                this.f462949a = r100;
            }
        }

        public final void a(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "requestNotificationOfficial show success");
            VvPushAdapter.access$100(this.f462948d, this.f462945a, this.f462946b, "vv", true, "success", this.f462947c);
            oqc.b r101 = oqc.b.f524912b;
            r101.f524913a = new a(this);
            return;
        L5:
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "requestNotificationOfficial show failed");
            VvPushAdapter.access$300(this.f462948d, this.f462945a, this.f462946b, "vv", false, "failed", this.f462947c);
            oqc.b.f524912b.f524913a = null;
        }

        public g(VvPushAdapter r100, String r101, int r102, RequestResultCallback r103) {
            this.f462948d = r100;
            this.f462945a = r101;
            this.f462946b = r102;
            this.f462947c = r103;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class h implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f462951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f462952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f462953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ VvPushAdapter f462954e;

        @Override // java.util.Observer
        public void update(Observable r100, Object r110) {
            boolean r101 = ((Boolean) r110).booleanValue();
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "app status changed,isInBackGround:" + r101 + " appStatusHasChange：" + VvPushAdapter.access$400(this.f462954e));
            if (r101 == false) goto L7;
            VvPushAdapter.access$402(this.f462954e, true);
            if (VvPushAdapter.access$500(this.f462954e) == false) goto L7;
            VvPushAdapter.access$600(this.f462954e, this.f462950a, this.f462951b, "vv", true, "success", this.f462952c);
        L7:
            if (r101 == false) goto L9;
            return;
        L9:
            if (VvPushAdapter.access$400(this.f462954e) == true) goto L11;
            return;
        L11:
            if (ToolUtils.areNotificationsEnabled(this.f462953d) != ToolUtils.TRUE) goto L13;
            VvPushAdapter.access$200(this.f462954e, this.f462950a, true, this.f462952c);
        L14:
            s67.d.a().deleteObserver(this);
            return;
        L13:
            VvPushAdapter.access$200(this.f462954e, this.f462950a, false, this.f462952c);
            goto L14
        }

        public h(VvPushAdapter r100, String r101, int r102, RequestResultCallback r103, Context r104) {
            this.f462954e = r100;
            this.f462950a = r101;
            this.f462951b = r102;
            this.f462952c = r103;
            this.f462953d = r104;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f462956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RequestResultCallback f462957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VvPushAdapter f462958d;

        public final void a() {
            com.bytedance.push.utils.f.b(VvPushAdapter.TAG, "backup detect dialog show result now, hasShown:" + VvPushAdapter.access$500(this.f462958d) + " appStatusHasChanged:" + VvPushAdapter.access$400(this.f462958d));
            if (VvPushAdapter.access$500(this.f462958d) == true) goto L5;
        L8:
            VvPushAdapter.access$502(this.f462958d, false);
            return;
        L5:
            if (VvPushAdapter.access$400(this.f462958d) == false) goto L7;
            VvPushAdapter.access$700(this.f462958d, this.f462955a, this.f462956b, "vv", true, "success", this.f462957c);
            goto L8
        L7:
            VvPushAdapter.access$800(this.f462958d, this.f462955a, this.f462956b, "vv", false, "time out", this.f462957c);
            goto L8
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

        public i(VvPushAdapter r100, String r101, int r102, RequestResultCallback r103) {
            this.f462958d = r100;
            this.f462955a = r101;
            this.f462956b = r102;
            this.f462957c = r103;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class j implements IPushActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f462959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f462960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f462961c;

        public class a implements IPushActionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f462962a;

            public a(j r100) {
                this.f462962a = r100;
            }

            @Override // com.vivo.push.IPushActionListener
            public final void onStateChanged(int r100) {
                if (r100 != 0) goto L6;
                k r101 = this.f462962a.f462961c;
                if (r101 == null) goto L10;
                ((g) r101).a(true);
                return;
            L10:
                return;
            L6:
                com.bytedance.push.utils.f.e(VvPushAdapter.TAG, "NotifyGuideDialog show failed");
                k r102 = this.f462962a.f462961c;
                if (r102 == null) goto L12;
                ((g) r102).a(false);
                return;
            }
        }

        @Override // com.vivo.push.IPushActionListener
        public final void onStateChanged(int r100) {
            if (r100 != 0) goto L4;
            PushClient.getInstance(this.f462959a).showNotifyGuideDialog(this.f462960b, new a(this));
            return;
        L4:
            com.bytedance.push.utils.f.e(VvPushAdapter.TAG, "NotifyGuideDialog is not allowed: " + r100);
            k r101 = this.f462961c;
            if (r101 == null) goto L9;
            ((g) r101).a(false);
            return;
        }

        public j(Context r100, Activity r101, k r102) {
            this.f462959a = r100;
            this.f462960b = r101;
            this.f462961c = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface k {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.push.third.b
    public int getPushType() {
        return 11;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context r100, int r101, Object r102) {
    }

    public static int getVvPush() {
        if (VV_PUSH != (-1)) goto L6;
        VV_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(VvPushAdapter.class.getName());
    L6:
        return VV_PUSH;
    }

    private Boolean isPushServiceAvailable() {
        PackageInfo r100 = AppProvider.getApp().getPackageManager().getPackageInfo("com.vivo.pushservice", 0);     // Catch: Exception -> L10
        com.bytedance.push.utils.f.e(TAG, "com.vivo.pushservice versionName: " + r100.versionName);     // Catch: Exception -> L10
        if (r100.versionCode < 5380000) goto L8;
        com.bytedance.push.utils.f.e(TAG, "com.vivo.pushservice versionCode: " + r100.versionCode + " is available!");     // Catch: Exception -> L10
        return Boolean.TRUE;
    L8:
        com.bytedance.push.utils.f.e(TAG, "com.vivo.pushservice versionCode: " + r100.versionCode + " version not supported!");     // Catch: Exception -> L10
        return Boolean.FALSE;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private String requestNotificationInternal() {
        PushSupporter.logger().d(TAG, "requestNotificationInternal");
        Application r100 = AppProvider.getApp();
        IBinder r101 = (IBinder) INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r101 != null) goto L7;
        PushSupporter.logger().e(TAG, "get service failed.");     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        return "notification service is null";
    L7:
        Parcel r102 = Parcel.obtain();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        Parcel r103 = Parcel.obtain();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        INVOKEINTERFACE_com_vv_VvPushAdapter_com_obric_assistant_interaction_impl_BinderLancet_transact(r101, 1598968902, r102, r103, 0);     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        String r104 = r103.readString();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r104 != null) goto L10;
        return "readString is null";
    L10:
        if (r104.equals("") == true) goto L26;
        Object r105 = INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r104.concat("$Stub")).getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r101});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r105 == null) goto L15;
        r105.getClass().getDeclaredMethod("requestNotificationPermission", new Class[]{String.class}).invoke(r105, new Object[]{r100.getPackageName()});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        return "success";
    L15:
        return "asInterface is null";
    L26:
        return "readString is null";
    L22:
        e = move-exception;
        return "not support device:" + e.getLocalizedMessage();
    L19:
        th = move-exception;
        com.bytedance.push.utils.f.f(TAG, "requestNotificationInternal error ", th);
        return "exception:" + th.getLocalizedMessage();
    }

    public VvPushAdapter() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.appStatusHasChanged = false;
        this.hasShown = false;
        this.DIALOG_SHOW_TIME_OUT = 2000;
        this.SUCCESS = "success";
    }

    public static boolean hasTryRegistered() {
        return sHasRegistered;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ Handler access$000(VvPushAdapter r100) {
        return r100.mHandler;
    }

    public static /* synthetic */ boolean access$400(VvPushAdapter r100) {
        return r100.appStatusHasChanged;
    }

    public static /* synthetic */ boolean access$500(VvPushAdapter r100) {
        return r100.hasShown;
    }

    private void requestNotificationOfficial(k r100) {
        PushSupporter.logger().d(TAG, "requestNotificationOfficial");
        Application r101 = AppProvider.getApp();
        Activity r102 = ActivityLifecycleObserver.getIns().getTopActivity();     // Catch: Exception -> L5
        PushClient.getInstance(r101).isNotifyGuideDialogAllowed(r102, new j(r101, r102, r100));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.push.utils.f.f(TAG, "requestNotificationOfficial error ", e);
        if (r100 == null) goto L12;
        ((g) r100).a(false);
        return;
    }

    public static /* synthetic */ boolean access$402(VvPushAdapter r100, boolean r101) {
        r100.appStatusHasChanged = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(VvPushAdapter r100, boolean r101) {
        r100.hasShown = r101;
        return r101;
    }

    public static void sendToken(Context r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        com.bytedance.push.utils.f.b(TAG, "[sendToken]hasSendValidToken:" + hasSendValidToken);
        if (hasSendValidToken == true) goto L13;
        hasSendValidToken = true;
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r100, getVvPush(), r101);
        return;
    L13:
        return;
    L10:
        if (PushSupporter.thirdService().isMainProcess(r100) == false) goto L15;
        PushSupporter.monitor().monitorRegisterSenderFailed(getVvPush(), 102, "0", "token is empty");
        return;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String r100, Context r101) throws Exception {
        PushClient.getInstance(r101).checkManifest();     // Catch: VivoPushException -> L5
        return true;
    L5:
        e = move-exception;
        com.bytedance.push.utils.f.e(r100, "VivoPush Errcode = " + e.getCode() + " " + e.getMessage());
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.push.third.b
    public boolean deleteProfileId(Context r110, String r111) {
        long r100 = System.currentTimeMillis();
        int r101 = PushClient.getInstance(r110).isSupportSyncProfileInfo();     // Catch: Throwable -> L20
        PushSupporter.logger().i(TAG, "[deleteProfileId]supportProfile:" + r101 + " profileId:" + r111);     // Catch: Throwable -> L20
        String r102 = null;
        if (r101 != 0) goto L18;
        CountDownLatch r103 = new CountDownLatch(1);     // Catch: Throwable -> L20
        Boolean[] r104 = {null};     // Catch: Throwable -> L20
        String[] r105 = {""};     // Catch: Throwable -> L20
        PushClient.getInstance(r110).deleteProfileId(r111, new f(r104, r103, r105));     // Catch: Throwable -> L20
        r103.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8 Throwable -> L20
    L10:
        Boolean r112 = r104[0];     // Catch: Throwable -> L20
        if (r112 != null) goto L13;
        int r113 = 4;
    L19:
        String r106 = r102;
    L22:
        onDeleteProfileIdResult(getVvPush(), r100, r113, r106);
        if (r113 != 1) goto L30;
        return true;
    L30:
        return false;
    L13:
        if (r112.booleanValue() == false) goto L15;
        r113 = 1;
        goto L19
    L15:
        com.bytedance.push.utils.f.b(TAG, "error msg is :" + r105[0]);     // Catch: Throwable -> L20
        r102 = r105[0];     // Catch: Throwable -> L20
        r113 = 6;
        goto L19
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L10
    L18:
        r113 = 3;
    L20:
        th = move-exception;
        r106 = th.getLocalizedMessage();
        r113 = 5;
        goto L22
    }

    @Override // com.bytedance.push.third.b
    public String isBusinessAlertDialogAvailable(Context r100, boolean r101) {
        if (isPushAvailable(r100, VV_PUSH) == true) goto L6;
        com.bytedance.push.utils.f.g(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
        return "push is not available";
    L6:
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.d().H() == true) goto L10;
        com.bytedance.push.utils.f.g(TAG, "[isBusinessAlertDialogAvailable]return false because enableVvBusinessNotificationDialog is false");
        return "enableVvBusinessNotificationDialog is false";
    L10:
        com.bytedance.push.utils.f.g(TAG, "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L25;
        String r102 = Build.BRAND;
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L9:
        String r103 = Build.MODEL;
        if (TextUtils.isEmpty(r103) == false) goto L12;
    L14:
        String r104 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r104) == false) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == true) goto L22;
        return false;
    L22:
        if (PushClient.getInstance(r100.getApplicationContext()).isSupport() == false) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (r104.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L19;
    L8:
        r105 = true;
        goto L20
    L12:
        if (r103.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L14;
    L7:
        if (r102.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L9;
    L25:
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context r100, int r101) {
        PushSupporter.logger().i(TAG, "registerVivoPush");     // Catch: Exception -> L8
        if (PushSupporter.logger().debug() == false) goto L6;
        PushClient.getInstance(r100).checkManifest();     // Catch: Exception -> L8
    L6:
        sHasRegistered = true;     // Catch: Exception -> L8
        PushClient.getInstance(r100.getApplicationContext()).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());     // Catch: Exception -> L8
        PushClient.getInstance(r100).turnOnPush(new a(this, r101, r100));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        PushSupporter.logger().e(TAG, "error when register vv push ", e);
        e.printStackTrace();
    }

    @Override // com.bytedance.push.third.b
    public boolean setProfileId(Context r110, String r111) {
        long r100 = System.currentTimeMillis();
        int r101 = PushClient.getInstance(r110).isSupportSyncProfileInfo();     // Catch: Throwable -> L21
        PushSupporter.logger().i(TAG, "[setProfileId]supportProfile:" + r101 + " profileId len:" + r111.length() + " profileId：" + r111);     // Catch: Throwable -> L21
        if (r101 != 0) goto L18;
        CountDownLatch r102 = new CountDownLatch(1);     // Catch: Throwable -> L21
        Boolean[] r103 = {null};     // Catch: Throwable -> L21
        String[] r104 = {""};     // Catch: Throwable -> L21
        PushThreadHandlerManager.inst().postRunnable(new e(r110, r111, r103, r102, r104));     // Catch: Throwable -> L21
        r102.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8 Throwable -> L21
    L10:
        Boolean r105 = r103[0];     // Catch: Throwable -> L21
        if (r105 != null) goto L13;
        int r106 = 4;
    L19:
        String r107 = null;
    L20:
        String r108 = r107;
    L23:
        com.bytedance.push.utils.f.b(TAG, "onSetProfileIdResult,resultStatus:" + r106 + " extra:" + r108);
        onSetProfileIdResult(getVvPush(), r100, r106, r108);
        if (r106 != 1) goto L31;
        return true;
    L31:
        return false;
    L13:
        if (r105.booleanValue() == false) goto L15;
        r106 = 1;
        goto L19
    L15:
        com.bytedance.push.utils.f.b(TAG, "error msg is :" + r104[0]);     // Catch: Throwable -> L21
        r107 = r104[0];     // Catch: Throwable -> L21
        r106 = 6;
        goto L20
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L10
    L18:
        r106 = 3;
    L21:
        th = move-exception;
        r108 = th.getLocalizedMessage();
        r106 = 5;
        goto L23
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context r100, int r101) {
        PushClient.getInstance(r100).turnOffPush(new d());     // Catch: Throwable -> L4
        PushSupporter.logger().i(TAG, "unregisterPush");     // Catch: Throwable -> L4
        return;
    }

    private void onUserClickResult(String r100, boolean r101, RequestResultCallback r102) {
        com.bytedance.push.utils.f.g(TAG, "on request vv notification permission result,report click event,hasAgree:" + r101);
        PushThreadHandlerManager.inst().postRunnable(new b(r100, r101, r102));
    }

    private void setComponentStatus(Context r100, Class r101, boolean r102) {
        ComponentName r103 = new ComponentName(r100, r101);
        PushSupporter.logger().i(TAG, "set " + r101.getName() + " to:" + r102);
        PackageManager r104 = r100.getPackageManager();
        if (r102 == false) goto L5;
        int r105 = 1;
    L11:
        r104.setComponentEnabledSetting(r103, r105, 1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r105 = 2;
        goto L11
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context r100, String r101, int r102) {
        PushSupporter.logger().i(TAG, "setAlias alias = " + r101);     // Catch: Throwable -> L5
        PushClient.getInstance(r100).bindAlias(r101, new c());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ void access$200(VvPushAdapter r100, String r101, boolean r102, RequestResultCallback r103) {
        r100.onUserClickResult(r101, r102, r103);
    }

    private void requestNotificationHook(String r110, int r111, int r112, RequestResultCallback r113) {
        Application r100 = AppProvider.getApp();
        if (this.hasShown == false) goto L5;
        com.bytedance.push.utils.f.e(TAG, "can't requestNotificationPermission because cur has showing");
    L5:
        this.hasShown = true;
        this.appStatusHasChanged = false;
        this.hasCallbackShowResult = false;
        s67.d.a().addObserver(new h(this, r110, r111, r113, r100));
        String r101 = requestNotificationInternal();
        if (TextUtils.equals(r101, "success") == true) goto L8;
        onGuideRequestResult(r110, r111, "vv", false, r101, r113);
        this.hasShown = false;
        return;
    L8:
        com.bytedance.push.utils.f.b(TAG, "backup detect dialog show result after 2000");
        PushThreadHandlerManager.inst().postRunnable(new i(this, r110, r111, r113), 2000);
    }

    @Override // com.bytedance.push.third.b
    public synchronized boolean requestNotificationPermission(String r110, int r111, int r112, RequestResultCallback r113) {
        monitor-enter(this);
        PushSupporter.logger().d(TAG, "[requestNotificationPermission]");     // Catch: Throwable -> L31
        if (r111 == getVvPush()) goto L10;
        com.bytedance.push.utils.f.e(TAG, "invalid push_type:" + r111);     // Catch: Throwable -> L31
        onGuideRequestResult(r110, r111, "vv", false, "invalid push_type:" + r111, r113);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L10:
        if (ToolUtils.areNotificationsEnabled(AppProvider.getApp()) != 1) goto L15;
        com.bytedance.push.utils.f.e(TAG, "cur notification are enabled,needn't request");     // Catch: Throwable -> L31
        onGuideRequestResult(r110, r111, "vv", false, "cur notification are enabled,needn't request", r113);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L15:
        if (ActivityLifecycleObserver.getIns().getTopActivity() != null) goto L19;
        com.bytedance.push.utils.f.e(TAG, "can't requestNotificationPermission on vv device because topActivity is null");     // Catch: Throwable -> L31
        onGuideRequestResult(r110, r111, "vv", false, "topActivity is null,app is not in the foreground!", r113);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L19:
        this.hasCallbackShowResult = false;     // Catch: Throwable -> L31
        this.hasCallbackClickResult = false;     // Catch: Throwable -> L31
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        if (r100 < 30) goto L25;
        if (r100 > 32) goto L25;
        requestNotificationHook(r110, r111, r112, r113);     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return true;
    L25:
        if (r100 < 28) goto L29;
        if (isPushServiceAvailable().booleanValue() == false) goto L29;
        requestNotificationOfficial(new g(this, r110, r111, r113));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_vv_VvPushAdapter_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }

    public static /* synthetic */ void access$100(VvPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, RequestResultCallback r106) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void access$300(VvPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, RequestResultCallback r106) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void access$600(VvPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, RequestResultCallback r106) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void access$700(VvPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, RequestResultCallback r106) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void access$800(VvPushAdapter r100, String r101, int r102, String r103, boolean r104, String r105, RequestResultCallback r106) {
        r100.onGuideRequestResult(r101, r102, r103, r104, r105, r106);
    }
}
