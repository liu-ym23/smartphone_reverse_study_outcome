package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f525633d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f525634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICronetAppProvider f525635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ICronetDepend f525636c;

    public final List<String> a() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getAbSdkVersion();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (List) yx5.a.b(r101).call("getAbSdkVersion").get();
    }

    public final String b() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getBypassBOEJSON();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r101).call("getBypassBOEJSON").get();
    }

    public final String c() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getCronetSoPath();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r101).call("getCronetSoPath").get();
    }

    public final String d() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getStoreIdcRuleJSON();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r101).call("getStoreIdcRuleJSON").get();
    }

    public final Map<String, String> f() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getTNCRequestHeader();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (Map) yx5.a.b(r101).call("getTNCRequestHeader").get();
    }

    public final Map<String, String> g() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getTNCRequestQuery();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return null;
    L14:
        return (Map) yx5.a.b(r101).call("getTNCRequestQuery").get();
    }

    public final boolean i() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.isBOEProxyEnabled();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return false;
    L14:
        return ((Boolean) yx5.a.b(r101).call("isBOEProxyEnabled").get()).booleanValue();
    }

    public final boolean j() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r100 = this.f525635b;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.needCustomLoadLibrary();
    L10:
        Object r101 = this.f525634a;     // Catch: Throwable -> L15
        if (r101 != null) goto L14;
        return false;
    L14:
        return ((Boolean) yx5.a.b(r101).call("needCustomLoadLibrary").get()).booleanValue();
    }

    public static c h() {
        if (f525633d != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525633d != null) goto L9;
        f525633d = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f525633d;
    }

    public c() {
    }

    public final String e(String r100) {
        Object r101 = this.f525634a;     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return "";
    L6:
        return (String) yx5.a.b(r101).call(r100).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public final void l(AbsCronetDependAdapter r100) {
        if (r100 == null) goto L19;
        List r101 = i.a(r100.getClass());     // Catch: Throwable -> L25
        if (r101 == null) goto L17;
        ArrayList r102 = (ArrayList) r101;     // Catch: Throwable -> L25
        if (r102.isEmpty() == true) goto L33;
        Iterator r103 = r102.iterator();     // Catch: Throwable -> L25
    L10:
        if (r103.hasNext() == false) goto L19;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) r103.next()).getName()) == false) goto L10;
        if (d.a().loggerDebug() == false) goto L16;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L25
    L16:
        this.f525634a = r100;     // Catch: Throwable -> L25
        goto L19
    L33:
        return;
    L17:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r100 instanceof ICronetAppProvider) == false) goto L22;
        this.f525635b = r100;     // Catch: Throwable -> L25
    L22:
        if ((r100 instanceof ICronetDepend) == false) goto L34;
        this.f525636c = r100;     // Catch: Throwable -> L25
        return;
    }

    public final void k(String r100, String r101) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "Send monitor json = " + r100 + ", log type =" + r101);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = this.f525635b;     // Catch: Throwable -> L16
        if (r102 != null) goto L10;
        return;
    L10:
        r102.sendAppMonitorEvent(r100, r101);     // Catch: Throwable -> L16
        return;
    L11:
        Object r103 = this.f525634a;     // Catch: Throwable -> L16
        if (r103 != null) goto L14;
        return;
    L14:
        yx5.a.b(r103).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r100, r101});     // Catch: Throwable -> L16
    }
}
