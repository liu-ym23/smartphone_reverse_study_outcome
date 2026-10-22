package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f276928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f276929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f276930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private UpdateBean f276931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f276932e;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    private Activity b() {
        WeakReference<Activity> r100 = this.f276928a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        c.f276994b.b(b());
        this.f276928a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    public UpdateAdapter() {
        this.f276932e = false;
    }

    private void a() {
        Activity r100 = b();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L10;
        r100.finish();
        return;
    }

    private void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_adapter_ui_UpdateAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private void a(Intent r100) {
        int r101 = -1;
        r101 = r100.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);     // Catch: Throwable -> L5
    L6:
        if (r101 != 0) goto L9;
        HMSLog.i("UpdateAdapter", "Error resolved successfully!");
        SystemManager.getInstance().notifyUpdateResult(0);
        return;
    L9:
        if (r101 != 13) goto L12;
        HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
        SystemManager.getInstance().notifyUpdateResult(13);
        return;
    L12:
        if (r101 != 8) goto L14;
        HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
        SystemManager.getInstance().notifyUpdateResult(8);
        return;
    L14:
        HMSLog.i("UpdateAdapter", "Other error codes.");
        SystemManager.getInstance().notifyUpdateResult(r101);
        return;
    L5:
        HMSLog.w("UpdateAdapter", "get extra_result failed, throwable occur.");
        goto L6
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        if (r100 != null) goto L7;
        HMSLog.i("UpdateAdapter", "activity == null");
        c();
        return;
    L7:
        if (r100.isFinishing() == false) goto L10;
        HMSLog.i("UpdateAdapter", "activity is finishing");
        c();
        return;
    L10:
        this.f276929b = r100.getApplicationContext();
        this.f276928a = new WeakReference(r100);
        c.f276994b.a(b());
        Intent r101 = r100.getIntent();
        if (r101 != null) goto L38;
        c();
        return;
    L38:
        this.f276930c = r101.getIntExtra("update_version", 0);     // Catch: Throwable -> L17
    L20:
        if (this.f276930c != 0) goto L24;
        c();
        return;
    L24:
        if (r101.hasExtra("installHMS") == false) goto L27;
        this.f276932e = true;
    L27:
        if (a(r101, r100) == false) goto L36;
        return;
    L36:
    L33:
        th = move-exception;
        HMSLog.e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th.getMessage());
        c();
        return;
    L30:
        if (AvailableUtil.isInstallerLibExist(this.f276929b) == false) goto L40;
        UpdateBean r102 = (UpdateBean) a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{r100, Integer.valueOf(this.f276930c), Boolean.valueOf(this.f276932e)});     // Catch: Throwable -> L33
        this.f276931d = r102;     // Catch: Throwable -> L33
        a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{r100, r102, 1001});     // Catch: Throwable -> L33
        this.f276931d = null;     // Catch: Throwable -> L33
        return;
    L40:
        return;
    L17:
        th = move-exception;
        HMSLog.e("UpdateAdapter", "get update_version:" + th.getMessage());
        goto L20
    }

    private boolean a(Intent r100, Activity r101) {
        if (r100.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false) == false) goto L10;
        HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String r102 = HMSPackageManager.getInstance(r101.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(r102) == false) goto L8;
        HMSLog.w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
        c();
        return true;
    L8:
        ComponentName r103 = new ComponentName(r102, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent r104 = new Intent();
        r104.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, r101.getApplicationContext().getPackageName());
        r104.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, r102);
        r104.setComponent(r103);
        r101.startActivityForResult(r104, 1001);
        return true;
    L10:
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }

    private static Object a(String r100, String r101, Object[] r102) throws Throwable {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        HMSLog.e("UpdateAdapter", "className is empty.");
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        HMSLog.e("UpdateAdapter", "methodName is empty.");
        return null;
    L10:
        if (r102 != null) goto L13;
        HMSLog.e("UpdateAdapter", "args is null.");
        return null;
    L13:
        Class<?>[] r103 = new Class[r102.length];
        int r104 = 0;
    L15:
        if (r104 >= r102.length) goto L33;
        Object r105 = r102[r104];
        if ((r105 instanceof Activity) == false) goto L20;
        r103[r104] = Activity.class;
    L32:
        r104 = r104 + 1;
        goto L15
    L20:
        if ((r105 instanceof Context) == false) goto L23;
        r103[r104] = Context.class;
        goto L32
    L23:
        if ((r105 instanceof UpdateBean) == false) goto L26;
        r103[r104] = UpdateBean.class;
        goto L32
    L26:
        if ((r105 instanceof Integer) == false) goto L29;
        r103[r104] = Integer.TYPE;
        goto L32
    L29:
        if ((r105 instanceof Boolean) == false) goto L31;
        r103[r104] = Boolean.TYPE;
        goto L32
    L31:
        HMSLog.e("UpdateAdapter", "not set args[" + r104 + "] type");
        goto L32
    L33:
        Class r106 = INVOKESTATIC_com_huawei_hms_adapter_ui_UpdateAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
        return r106.getMethod(r101, r103).invoke(r106.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), r102);
    }

    public static Object invokeMethod(String r100, String r101, Object[] r102) {
        return a(r100, r101, r102);
    L4:
        th = move-exception;
        HMSLog.e("UpdateAdapter", "invoke " + r100 + "." + r101 + " fail. " + th.getMessage());
        return null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 == getRequestCode()) goto L6;
        this.f276931d = null;
        return false;
    L6:
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + r101);
        if (AvailableUtil.isInstallerLibExist(this.f276929b) == false) goto L16;
        if (r101 != 1214) goto L16;
        HMSLog.i("UpdateAdapter", "Enter update escape route");
        Activity r103 = b();
        if (r103 != null) goto L14;
        HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
        this.f276931d = null;
        return true;
    L14:
        invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{r103, 1001, this.f276931d});
        this.f276931d = null;
    L16:
        if (r101 != (-1)) goto L25;
        if (r102 != null) goto L43;
    L41:
        a();
        return true;
    L43:
        int r104 = r102.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);     // Catch: Throwable -> L20
    L21:
        if (r104 != 1) goto L24;
        HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
        SystemManager.getInstance().notifyUpdateResult(0);
        this.f276931d = null;
        a();
        return true;
    L24:
        a(r102);
    L20:
        HMSLog.w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
        r104 = 0;
        goto L21
    L25:
        if (r101 != 0) goto L39;
        HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
        this.f276931d = null;
        Activity r105 = b();
        if (r105 != null) goto L29;
        return true;
    L29:
        String r106 = HMSPackageManager.getInstance(r105.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(r106) == false) goto L33;
        r106 = "com.huawei.hwid";
    L33:
        if (this.f276932e == false) goto L35;
    L38:
        HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
        SystemManager.getInstance().notifyUpdateResult(13);
        goto L41
    L35:
        if (a(r105, r106, this.f276930c) == true) goto L38;
        SystemManager.getInstance().notifyUpdateResult(0);
        goto L41
    L39:
        if (r101 != 1) goto L41;
        SystemManager.getInstance().notifyUpdateResult(28);
        goto L41
    }

    private boolean a(Context r100, String r101, int r102) {
        if (r100 != null) goto L5;
    L15:
        HMSLog.w("UpdateAdapter", "Please check your params, one of params is invalid.");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 == 0) goto L15;
        PackageManagerHelper r103 = new PackageManagerHelper(r100);
        PackageManagerHelper.PackageStates r104 = r103.getPackageStates(r101);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(r104) == false) goto L12;
        return true;
    L12:
        if (r103.getPackageVersionCode(r101) >= r102) goto L17;
        return true;
    L17:
        return false;
    }
}
