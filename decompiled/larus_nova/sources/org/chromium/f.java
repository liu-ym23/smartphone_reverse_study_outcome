package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.ttnet.org.chromium.net.TTAppSecurityManager;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements TTAppSecurityManager.ITTSystemApiSandbox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f525643a;

    public static f a() {
        if (f525643a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525643a != null) goto L9;
        f525643a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f525643a;
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final String getNetworkOperator() {
        c r100 = c.h();
        r100.getClass();
        String r101 = "";
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r101;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r102 = r100.f525635b;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        r101 = r102.getNetworkOperator();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r103 = r100.f525634a;     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        r101 = (String) yx5.a.b(r103).call("getNetworkOperator").get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final String getSimOperator() {
        c r100 = c.h();
        r100.getClass();
        String r101 = "";
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r101;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r102 = r100.f525635b;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        r101 = r102.getSimOperator();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r103 = r100.f525634a;     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        r101 = (String) yx5.a.b(r103).call(BpeaManager.getSimOperator).get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final int getWifiFrequency() {
        c r100 = c.h();
        r100.getClass();
        int r101 = 0;
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r101;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r102 = r100.f525635b;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        r101 = r102.getWifiFrequency();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r103 = r100.f525634a;     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        r101 = ((Integer) yx5.a.b(r103).call("getWifiFrequency").get()).intValue();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public final int getWifiRssi() {
        c r100 = c.h();
        r100.getClass();
        int r101 = 0;
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return r101;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r102 = r100.f525635b;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        r101 = r102.getWifiRssi();     // Catch: Throwable -> L14
    L17:
        goto L16
    L9:
        Object r103 = r100.f525634a;     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        r101 = ((Integer) yx5.a.b(r103).call("getWifiRssi").get()).intValue();     // Catch: Throwable -> L14
        goto L17
    }

    public f() {
    }
}
