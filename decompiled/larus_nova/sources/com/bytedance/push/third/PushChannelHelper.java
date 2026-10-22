package com.bytedance.push.third;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import org.json.JSONArray;
import v67.o;
import v67.x;

/* JADX INFO: loaded from: classes3.dex */
public class PushChannelHelper extends a {
    public static final int ADM_PUSH = 14;
    public static final int FCM_PUSH = 5;
    public static final int HONOR_PUSH = 22;
    public static final int HW_PUSH = 7;
    public static final int MATRIX_PUSH = 26;
    public static final int MI_PUSH = 1;
    public static final int MZ_PUSH = 8;
    public static final int OP_PUSH = 10;
    public static final int SMT_PUSH = 16;
    public static final int UM_PUSH = 6;
    public static final int UNKNOWN = -1;
    public static final int VV_PUSH = 11;
    private static volatile PushChannelHelper sPushChannelHelper;
    private final String TAG;
    private b curSysPushAdapter;

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PushType {
    }

    @Override // com.bytedance.push.third.a
    public int getTryRegisterChannelId() {
        return 6;
    }

    public boolean isDirectOpenActivitySender(int r100) {
        if (r100 != 10) goto L5;
    L18:
        return true;
    L5:
        if (r100 == 16) goto L18;
        if (r100 == 7) goto L18;
        if (r100 == 11) goto L18;
        if (r100 == 20) goto L18;
        if (r100 == 22) goto L18;
        if (r100 == 26) goto L18;
        return false;
    }

    @Override // com.bytedance.push.third.a
    public boolean isNeedUnzip(int r100) {
        if (r100 != 11) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isHWPushAvailable() {
        return a.mAllowPushSet.contains(7);
    }

    @Override // com.bytedance.push.third.a
    public String getCurBusinessSysAlertTypeForCustomDialog() {
        com.bytedance.push.utils.f.b("PushChannelHelper", "[getCurBusinessSysAlertType]");
        int r100 = getCurBusinessSysAlertType(AppProvider.getApp(), true);
        if (r100 != 7) goto L5;
        return "hms";
    L5:
        if (r100 != 11) goto L7;
        return "vv";
    L7:
        if (r100 == 22) goto L10;
        return "unknown";
    L10:
        return RomUtils.BRAND_HONOR;
    }

    @Override // com.bytedance.push.third.a
    public void initChannels() {
        if (this.mPushChannelMap.size() != 0) goto L6;
        super.initChannels();
        Application r100 = AppProvider.getApp();
        this.mPushChannelMap.put(1, new e(1, "com.xm.MiPushAdapter", "xm/MiPush", new j87.c(r100)));
        this.mPushChannelMap.put(6, new e(6, "com.um.UmPushAdapter", "um", new j87.a(r100)));
        this.mPushChannelMap.put(7, new e(7, "com.hw.HWPushAdapter", "hw", new j87.a(r100)));
        this.mPushChannelMap.put(8, new e(8, "com.mz.MzPushAdapter", "mz", new j87.c(r100)));
        this.mPushChannelMap.put(10, new e(10, "com.coloros.OpPushAdapter", "op", new j87.c(r100)));
        this.mPushChannelMap.put(11, new e(11, "com.vv.VvPushAdapter", "vv", new j87.a(r100)));
        this.mPushChannelMap.put(16, new e(16, "com.smt.SmtPushAdapter", "SmtPush", new j87.a(r100)));
        this.mPushChannelMap.put(5, new e(5, "com.fcm.FcmPushAdapter", "fcm", new j87.a(r100)));
        this.mPushChannelMap.put(14, new e(14, "com.adm.push.AdmPushAdapter", "amazon", new j87.a(AppProvider.getApp())));
        this.mPushChannelMap.put(22, new e(22, "com.honor.HonorPushAdapter", "honorPush", new j87.a(r100)));
        this.mPushChannelMap.put(23, new e(23, "com.um.mini.UmPushAdapter", "um_mini", new j87.a(r100)));
        this.mPushChannelMap.put(26, new e(26, "com.matrix.MatrixPushAdapter", "matrix", new j87.a(r100)));
        return;
    }

    public static boolean isAliYunPushAvailable() {
        a.initAllowPushSet();
        return false;
    }

    public static boolean isMZPushAvailable() {
        a.initAllowPushSet();
        return a.mAllowPushSet.contains(8);
    }

    public static boolean isMiPushAvailable() {
        a.initAllowPushSet();
        return a.mAllowPushSet.contains(1);
    }

    public static boolean isOpPushAvailable() {
        a.initAllowPushSet();
        return a.mAllowPushSet.contains(10);
    }

    public static boolean isUmPushAvailable() {
        a.initAllowPushSet();
        return a.mAllowPushSet.contains(6);
    }

    public static boolean isVivoPushAvailable() {
        a.initAllowPushSet();
        return a.mAllowPushSet.contains(11);
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ JSONArray buildApplogHeader() {
        return super.buildApplogHeader();
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ Set getChannels() {
        return super.getChannels();
    }

    @Override // com.bytedance.push.third.a
    public boolean isSupportSystemPushPermissionDialog() {
        Application r100 = AppProvider.getApp();
        IPushAdapter r101 = inst(r100).getAdapterInstance(10);
        IPushAdapter r102 = inst(r100).getAdapterInstance(7);
        IPushAdapter r103 = inst(r100).getAdapterInstance(11);
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
    L9:
        if (r103 != null) goto L11;
    L13:
        return false;
    L11:
        if (r103.isPushAvailable(r100, 11) == false) goto L13;
    L12:
        return true;
    L8:
        if (r102.isPushAvailable(r100, 7) == true) goto L12;
    L5:
        if (r101.isPushAvailable(r100, 10) == true) goto L12;
        goto L6
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ boolean requestNotificationPermissionBySysAlertForOp() {
        return super.requestNotificationPermissionBySysAlertForOp();
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ void resetPushChannels() {
        super.resetPushChannels();
    }

    private PushChannelHelper(Context r100) {
        this.TAG = "PushChannelHelper";
        AppProvider.initApp((Application) r100.getApplicationContext());
    }

    public static PushChannelHelper inst(Context r100) {
        if (sPushChannelHelper != null) goto L15;
        monitor-enter(PushChannelHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sPushChannelHelper != null) goto L9;
        sPushChannelHelper = new PushChannelHelper(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PushChannelHelper.class);     // Catch: Throwable -> L11
    L15:
        return sPushChannelHelper;
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ IPushAdapter getAdapterInstance(int r100) {
        return super.getAdapterInstance(r100);
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ int getChannelId(String r100) {
        return super.getChannelId(r100);
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ String getSenderNameById(int r100) {
        return super.getSenderNameById(r100);
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ boolean hasSupportChannel(String r100) {
        return super.hasSupportChannel(r100);
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ boolean isLocalSupportChannel(int r100) {
        return super.isLocalSupportChannel(r100);
    }

    @Override // com.bytedance.push.third.a
    public boolean isSysChannel(int r100) {
        if (r100 != 7) goto L5;
        return true;
    L5:
        if (r100 != 10) goto L7;
        return true;
    L7:
        if (r100 == 11) goto L20;
        if (r100 != 1) goto L12;
        if (ToolUtils.isMiui() == false) goto L12;
        return true;
    L12:
        if (r100 != 22) goto L14;
        return true;
    L14:
        if (r100 == 26) goto L23;
        return false;
    L23:
        return true;
    L20:
        return true;
    }

    @Override // com.bytedance.push.third.a
    public /* bridge */ /* synthetic */ boolean needDisableWhenStrictMode(int r100) {
        return super.needDisableWhenStrictMode(r100);
    }

    @Override // com.bytedance.push.third.a
    public boolean requestMiRemoveVoipNotification(Context r100) {
        IPushAdapter r101 = inst(AppProvider.getApp()).getAdapterInstance(1);
        if (r101 != null) goto L11;
        com.bytedance.push.utils.f.e("PushChannelHelper", "requestMiRemoveVoipNotification can't find adapter for type:1");
        return false;
    L11:
        return r101.requestRemoveVoipNotification(r100, 1);
    L6:
        th = move-exception;
        com.bytedance.push.utils.f.e("PushChannelHelper", "requestMiRemoveVoipNotification error" + Log.getStackTraceString(th));
        return false;
    }

    private int getCurBusinessSysAlertType(Context r100, boolean r101) {
        Object r102 = getAdapterInstance(10);
        if ((r102 instanceof b) == false) goto L7;
        String r103 = ((b) r102).isBusinessAlertDialogAvailable(r100, r101);
        com.bytedance.push.utils.f.b("PushChannelHelper", "[getCurBusinessSysAlertType]op businessAlertDialogAvailable:" + r103);
        if (TextUtils.equals(r103, "1") == false) goto L7;
        return 10;
    L7:
        Object r104 = inst(r100).getAdapterInstance(22);
        if ((r104 instanceof b) == false) goto L12;
        String r105 = ((b) r104).isBusinessAlertDialogAvailable(r100, r101);
        com.bytedance.push.utils.f.b("PushChannelHelper", "[getCurBusinessSysAlertType]honor businessAlertDialogAvailable:" + r105);
        if (TextUtils.equals(r105, "1") == false) goto L12;
        return 22;
    L12:
        Object r106 = inst(r100).getAdapterInstance(7);
        if ((r106 instanceof b) == false) goto L17;
        String r107 = ((b) r106).isBusinessAlertDialogAvailable(r100, r101);
        com.bytedance.push.utils.f.b("PushChannelHelper", "[getCurBusinessSysAlertType]hw businessAlertDialogAvailable:" + r107);
        if (TextUtils.equals(r107, "1") == false) goto L17;
        return 7;
    L17:
        Object r108 = inst(r100).getAdapterInstance(11);
        if ((r108 instanceof b) == false) goto L22;
        String r109 = ((b) r108).isBusinessAlertDialogAvailable(r100, r101);
        com.bytedance.push.utils.f.b("PushChannelHelper", "[getCurBusinessSysAlertType]vv businessAlertDialogAvailable:" + r109);
        if (TextUtils.equals(r109, "1") == false) goto L24;
        return 11;
    L24:
        return -1;
    L22:
        return -1;
    }

    @Override // com.bytedance.push.third.a
    public Pair<String, String> getPushConfig(int r100, com.bytedance.push.c r101) {
        StringBuilder r102 = new StringBuilder("[getPushConfig]pushType:");
        r102.append(r100);
        r102.append(" configuration:");
        r102.append(r101);
        r102.append(" mKeyConfiguration:");
        if (r101 != null) goto L5;
        Object r103 = "null configuration";
    L6:
        r102.append(r103);
        com.bytedance.push.utils.f.g("PushChannelHelper", r102.toString());
        if (r100 != 1) goto L11;
        return r101.f266776p.a();
    L11:
        if (r100 != 8) goto L15;
        return r101.f266776p.b();
    L15:
        if (r100 != 10) goto L19;
        return r101.f266776p.c();
    L19:
        if (r100 == 26) goto L21;
        return null;
    L21:
        return r101.f266776p.d();
    L5:
        r103 = r101.f266776p;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.push.third.a
    public boolean requestHwNotificationPermission(String r100, RequestResultCallback r101) {
        com.bytedance.push.utils.f.b("PushChannelHelper", "[requestHwNotificationPermission]");
        Application r102 = AppProvider.getApp();
        IPushAdapter r103 = inst(r102).getAdapterInstance(7);
        if (r103 != 0) goto L5;
    L10:
        com.bytedance.push.utils.f.i("PushChannelHelper", "requestHwNotificationPermission is not support on cur device");
        if (r101 == null) goto L13;
        r101.onRequestResult(false, "requestHwNotificationPermission is not support on cur device");
    L13:
        return false;
    L5:
        if (r103.isPushAvailable(r102, 7) == false) goto L10;
        if ((r103 instanceof b) == false) goto L10;
        com.bytedance.push.utils.f.b("PushChannelHelper", "[requestHwNotificationPermission]use hwPushAdapter");
        b r104 = (b) r103;
        this.curSysPushAdapter = r104;
        return r104.requestNotificationPermission(r100, 7, 0, r101);
    }

    @Override // com.bytedance.push.third.a
    public void requestNotificationPermissionByBusinessAlert(String r100, RequestResultCallback r101) {
        requestNotificationPermissionByBusinessAlert(r100, null, true, r101);
    }

    @Override // com.bytedance.push.third.a
    public void setPushTokenListener(o r100, int r101) {
        IPushAdapter r102 = inst(AppProvider.getApp()).getAdapterInstance(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof x) == false) goto L9;
        ((x) r102).setPushTokenListener(r100);
        return;
    }

    @Override // com.bytedance.push.third.a
    public void onActivityResult(int r100, int r101, Intent r102) {
        com.bytedance.push.utils.f.b("PushChannelHelper", "[onActivityResult]curSysPushAdapter:" + this.curSysPushAdapter);
        b r103 = this.curSysPushAdapter;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.push.third.a
    public synchronized void requestNotificationPermissionByBusinessAlert(final String r110, View r111, boolean r112, final RequestResultCallback r113) {
        monitor-enter(this);
        com.bytedance.push.utils.f.b("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]customDialogView:" + r111);     // Catch: Throwable -> L30
        Application r100 = AppProvider.getApp();     // Catch: Throwable -> L30
        boolean r101 = true;
        if (ToolUtils.areNotificationsEnabled(r100) != 1) goto L9;
        com.bytedance.push.utils.f.i("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]return false because notification are enabled status");     // Catch: Throwable -> L30
        r113.onRequestResult(false, "notification are enabled");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L9:
        Application r102 = AppProvider.getApp();     // Catch: Throwable -> L30
        if (r111 != null) goto L13;
        r101 = false;
    L13:
        final int r103 = getCurBusinessSysAlertType(r102, r101);     // Catch: Throwable -> L30
        if ((-1) != r103) goto L18;
        com.bytedance.push.utils.f.i("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]return false because curBusinessSysAlertType is unknown");     // Catch: Throwable -> L30
        r113.onRequestResult(false, "unknown curBusinessSysAlertType");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L18:
        final IPushAdapter r104 = inst(r100).getAdapterInstance(r103);     // Catch: Throwable -> L30
        if ((r104 instanceof b) == true) goto L35;
        com.bytedance.push.utils.f.i("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]invalid  pushAdapter:" + r104);     // Catch: Throwable -> L30
        r113.onRequestResult(false, "invalid  pushAdapter:" + r104);     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L35:
        b r105 = (b) r104;     // Catch: Throwable -> L25
        this.curSysPushAdapter = r105;     // Catch: Throwable -> L25
        if (r111 != null) goto L23;
        r105.requestNotificationPermission(r110, r103, 0, r113);     // Catch: Throwable -> L25
    L34:
    L23:
        PushServiceManager.get().getIPermissionBootExternalService().requestNotificationPermissionByBusinessAlert(r110, r111, r112, new AnonymousClass1(this, r104, r110, r103, r113));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.bytedance.push.utils.f.e("PushChannelHelper", "requestNotificationPermission error" + Log.getStackTraceString(th));     // Catch: Throwable -> L30
        r113.onRequestResult(false, "exception:" + th.getLocalizedMessage());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
