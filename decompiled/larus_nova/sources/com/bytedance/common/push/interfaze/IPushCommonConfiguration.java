package com.bytedance.common.push.interfaze;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.interfaze.SensorAbility;
import com.bytedance.common.model.SyncConfig;
import com.bytedance.common.proxy.IActualObjGetterForHandlerBeDynamicProxy;
import com.bytedance.common.push.user.AccountSDKImpl;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.frontier.FrontierStrategy;
import com.bytedance.push.utils.f;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;
import r67.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IPushCommonConfiguration {
    private final String TAG;

    public boolean addInstrumentationListener(IInstrumentationListener r100) {
        return false;
    }

    public boolean autoRequestNotificationPermission() {
        return true;
    }

    public boolean defaultEnableUnDuplicateMessage() {
        return false;
    }

    public boolean disableAutoStartChildProcess() {
        return false;
    }

    public boolean enableExceptionInDebugModeWhenFatalError() {
        return true;
    }

    public boolean enableInstrKa() {
        return true;
    }

    public boolean enableMonitorNotificationClick() {
        return false;
    }

    public boolean fixAssociationStartMonitorServiceAnr() {
        return true;
    }

    public int getAppIconResId() {
        return R.drawable.status_icon;
    }

    public IEventReportListener getEventReportListener() {
        return null;
    }

    /* JADX INFO: renamed from: getFrontierService */
    public a mo8562getFrontierService() {
        return null;
    }

    public IHostSysAccountConfig getHostSysAccountConfig() {
        return null;
    }

    public IHostWidgetService getHostWidgetService() {
        return null;
    }

    public NetworkClient getNetworkClient() {
        return null;
    }

    public String getSessionId() {
        return "";
    }

    public SyncConfig getSyncConfig() {
        return null;
    }

    public boolean hasAgreedForPrivacyDialog() {
        return true;
    }

    public void invokeActivityLifeCycleMethod(Method r100, Activity r101) {
    }

    public boolean isGuestMode() {
        return false;
    }

    public void onRemoteViewsServiceGetView(int r100) {
    }

    public boolean optActivityThreadHandlerGetScreenState() {
        return true;
    }

    public boolean optAnr() {
        return false;
    }

    public boolean optMainProcessInitTimeCost() {
        return false;
    }

    public boolean optMainProcessInitTimeCostV2() {
        return false;
    }

    public boolean optUidChangeByHostInvoke() {
        return false;
    }

    public void requestPermissions(Activity r100, String[] r101, int r102) {
    }

    public IAccountService getAccountService() {
        return new AccountSDKImpl();
    }

    public IActualObjGetterForHandlerBeDynamicProxy getActualObjGetterForHandlerBeDynamicProxy() {
        return new AnonymousClass2(this);
    }

    public String getProfileId() {
        IAccountService r100 = getAccountService();
        String r101 = null;
        if (r100 == null) goto L13;
        String r102 = r100.getSecUid();
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r101 = DigestUtils.md5Hex(r102);     // Catch: Throwable -> L8
        f.b("IPushCommonConfiguration", "success md5 sec_uid,sec_uid:" + r102 + " profile_id:" + r101);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        f.f("IPushCommonConfiguration", "error when md5 sec_uid ", th);
        return r101;
    L14:
        return null;
    L13:
        return null;
    }

    public SensorAbility getSensorAbility() {
        return new AnonymousClass1(this);
    }

    public IPushCommonConfiguration() {
        this.TAG = "IPushCommonConfiguration";
    }

    public FrontierStrategy getFrontierMode() {
        return FrontierStrategy.STRATEGY_USE_HOST;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, 2);
    L7:
        return INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_common_push_interfaze_IPushCommonConfiguration_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r111, null, null, 3, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, r111);
    L35:
        return r100.registerReceiver(r101, r110, r111);
    }
}
