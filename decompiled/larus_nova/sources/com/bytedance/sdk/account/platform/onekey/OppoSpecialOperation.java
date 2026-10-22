package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class OppoSpecialOperation {
    private static final String DEFAULT_REQUEST_URL = "https://security.snssdk.com/passport/token/beat/v2/";
    private static final String PURE_DATA_REQUESTED = "pure_data_requested";
    private static final String SHARED_NAME = "bd_onekey_special_operate";
    private static final String SPECIAL_DEVICE_BRAND = "OPPO";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f269271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f269272b;

        @Override // java.lang.Runnable
        public final void run() {
            OppoSpecialOperation.access$000(this.f269271a, this.f269272b);     // Catch: Throwable -> L4 Exception -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        }

        public a(Context r100, boolean r101) {
            this.f269271a = r100;
            this.f269272b = r101;
        }
    }

    public OppoSpecialOperation() {
    }

    private static boolean isSpecialOppoDevices() {
        if ("OPPO".equalsIgnoreCase(Build.BRAND) == false) goto L9;
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L9;
        if (r100 > 28) goto L9;
        return true;
    L9:
        return false;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_bytedance_sdk_account_platform_onekey_OppoSpecialOperation_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private static boolean hasPureDataRequested(Context r100) {
        return r100.getSharedPreferences(SHARED_NAME, 0).getBoolean(PURE_DATA_REQUESTED, false);
    }

    private static void setHasPureDataRequested(Context r100) {
        r100.getSharedPreferences(SHARED_NAME, 0).edit().putBoolean(PURE_DATA_REQUESTED, true).commit();
    }

    public static /* synthetic */ void access$000(Context r100, boolean r101) {
        pureDataRequest(r100, r101);
    }

    public static void optOppoGetPhone(Context r100, boolean r101) {
        Context r102 = r100.getApplicationContext();
        if (isSpecialOppoDevices() == true) goto L6;
        return;
    L6:
        if (NetworkTypeHelper.getNetworkStatus(r102) != 3) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return;
    L12:
        if (hasPureDataRequested(r102) == false) goto L14;
        return;
    L14:
        ThreadMethodProxy.start(new PthreadThreadV2(new a(r102, r101), "OppoSpecialOperation"));
        return;
    L8:
        r103 = false;
        goto L9
    }

    private static void pureDataRequest(Context r100, boolean r101) {
        if (r100 == null) goto L26;
        WifiManager r102 = (WifiManager) r100.getApplicationContext().getSystemService("wifi");
        if (r102 != null) goto L24;
        return;
    L24:
        WifiInfo r103 = (WifiInfo) BpeaManager.invokeDeviceInfoApi(r100, "wifi", BpeaManager.getConnectionInfo, new Object[0]);     // Catch: Throwable -> L8
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        int r104 = r103.getNetworkId();
        r102.disableNetwork(r104);
        r102.disconnect();
        if (r101 == true) goto L14;
        Thread.sleep(500);     // Catch: Exception -> L17
    L21:
    L19:
        r102.enableNetwork(r104, true);
        r102.reconnect();
        return;
    L14:
        Thread.sleep(50);     // Catch: Exception -> L17
        INVOKEVIRTUAL_com_bytedance_sdk_account_platform_onekey_OppoSpecialOperation_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(DEFAULT_REQUEST_URL)).connect();     // Catch: Exception -> L17
        setHasPureDataRequested(r100);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L8:
        r103 = null;
        goto L9
    }
}
