package com.bytedance.push.third;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.utils.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final int REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_CUSTOM_DIALOG = 61521;
    public static final int REQUEST_CODE_REQUEST_NOTIFICATION_PERMISSION_BY_SYS_DIALOG = 61520;
    public static final int SYS_ALERT_STYLE_CUSTOM = 1;
    public static final int SYS_ALERT_STYLE_ORIGIN = 0;
    public final long PROFILE_ID_OPERATE_TIMEOUT;
    public final int PROFILE_STATUS_EXCEPTION;
    public final int PROFILE_STATUS_NOT_SUPPORT;
    public final int PROFILE_STATUS_PROFILE_ID_IS_EMPTY;
    public final int PROFILE_STATUS_SETTINGS_NOT_ENABLE;
    public final int PROFILE_STATUS_SUCCESS;
    public final int PROFILE_STATUS_SYS_FAILED;
    public final int PROFILE_STATUS_TIMEOUT;
    public final int PROFILE_STATUS_UNKNOWN;
    protected boolean hasCallbackClickResult;
    protected boolean hasCallbackShowResult;
    protected String mCurScenes;
    protected RequestResultCallback mRequestResultCallback;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f267034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f267035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f267036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f267037d;

        @Override // java.lang.Runnable
        public final void run() {
            PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onProfileIdOperateResult(1, this.f267034a, this.f267035b, this.f267036c, this.f267037d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(int r100, int r101, long r102, String r103) {
            this.f267034a = r100;
            this.f267035b = r101;
            this.f267036c = r102;
            this.f267037d = r103;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.push.third.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public class RunnableC3737b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f267038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f267039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f267040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f267041d;

        @Override // java.lang.Runnable
        public final void run() {
            PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onProfileIdOperateResult(2, this.f267038a, this.f267039b, this.f267040c, this.f267041d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3737b(int r100, int r101, long r102, String r103) {
            this.f267038a = r100;
            this.f267039b = r101;
            this.f267040c = r102;
            this.f267041d = r103;
        }
    }

    public abstract int getPushType();

    public abstract String isBusinessAlertDialogAvailable(Context r100, boolean r101);

    public b() {
        this.PROFILE_STATUS_UNKNOWN = -1;
        this.PROFILE_STATUS_SETTINGS_NOT_ENABLE = 0;
        this.PROFILE_STATUS_SUCCESS = 1;
        this.PROFILE_STATUS_PROFILE_ID_IS_EMPTY = 2;
        this.PROFILE_STATUS_NOT_SUPPORT = 3;
        this.PROFILE_STATUS_TIMEOUT = 4;
        this.PROFILE_STATUS_EXCEPTION = 5;
        this.PROFILE_STATUS_SYS_FAILED = 6;
        this.PROFILE_ID_OPERATE_TIMEOUT = 10000;
        this.hasCallbackShowResult = false;
        this.hasCallbackClickResult = false;
    }

    public void addCommonEventParams(JSONObject r100) {
    L11:
        th = move-exception;
        com.bytedance.push.utils.f.e(getClass().getName(), "[addCommonEventParams]exception:" + th.getLocalizedMessage());
        return;
    L3:
        if (j.h() == false) goto L5;
        Object r101 = RomUtils.OS_HARMONY;
    L6:
        r100.put("os_detail_type", r101);     // Catch: Throwable -> L11
        String r102 = j.b();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r100.put("extra_rom_version", r102);     // Catch: Throwable -> L11
    L9:
        r100.put("device_manufacturer", Build.MANUFACTURER.toLowerCase());     // Catch: Throwable -> L11
        return;
    L5:
        r101 = "android";
        goto L6
    }

    public boolean requestOpNotificationPermission(int r100) {
        com.bytedance.push.utils.f.b(getClass().getName(), "[requestOpNotificationPermission]default implement");
        return false;
    }

    public boolean deleteProfileId(Context r100, String r101) {
        com.bytedance.push.utils.f.b(getClass().getName(), "[deleteProfileId]default implement");
        return false;
    }

    public boolean setProfileId(Context r100, String r101) {
        com.bytedance.push.utils.f.b(getClass().getName(), "[setProfileId]default implement");
        return false;
    }

    public void onActivityResult(int r100, int r101, Intent r102) {
        com.bytedance.push.utils.f.b(getClass().getName(), "[onActivityResult]default implement");
    }

    public void onDeleteProfileIdResult(int r100, long r110, int r111, String r112) {
        ThreadPlus.submitRunnable(new RunnableC3737b(r100, r111, System.currentTimeMillis() - r110, r112));
    }

    public void onSetProfileIdResult(int r100, long r110, int r111, String r112) {
        ThreadPlus.submitRunnable(new a(r100, r111, System.currentTimeMillis() - r110, r112));
    }

    public boolean requestNotificationPermission(String r100, int r101, int r102, RequestResultCallback r103) {
        com.bytedance.push.utils.f.b(getClass().getName(), "[requestNotificationPermission]default implement");
        return false;
    }

    public synchronized void onGuideRequestResult(String r100, int r110, String r111, boolean r112, String r113, RequestResultCallback r114) {
        monitor-enter(this);
        onGuideRequestResult(r100, r110, r111, r112, r113, 0, r114);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void onGuideRequestResult(String r100, int r110, String r111, boolean r112, String r113, int r114, RequestResultCallback r115) {
        monitor-enter(this);
        com.bytedance.push.utils.f.b(getClass().getName(), "[onGuideRequestResult]hasCallbackShowResult:" + this.hasCallbackShowResult);     // Catch: Throwable -> L16
        if (this.hasCallbackShowResult == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.hasCallbackShowResult = true;     // Catch: Throwable -> L16
        if (r114 != 0) goto L12;
        PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogRequestResultEvent(r100, r111, r114, r110, r112, r113);     // Catch: Throwable -> L16
    L12:
        if (r115 == null) goto L14;
        r115.onRequestResult(r112, r113);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
