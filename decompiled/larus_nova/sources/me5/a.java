package me5;

import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public class a extends j66.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513479b;

    /* JADX INFO: renamed from: me5.a$a, reason: collision with other inner class name */
    public static final class C6809a {
    }

    static {
    }

    public a() {
        this.f513479b = "ccm.request";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f513479b;
    }

    public static void f(Pair r100, String r101, j66.a.InterfaceC6395a r102) {
        int r103 = ((Number) r100.getFirst()).intValue();
        Integer r104 = (Integer) r100.getSecond();
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "callbackRequestFailure mainCode: " + r103 + " subCode: " + r104 + ", msg: " + r101);
        k66.b r105 = new k66.b();
        r105.f501966a = r104;
        StringBuilder r106 = new StringBuilder("request error: ");
        r106.append(r104);
        r105.f501967b = r106.toString();
        Unit r107 = Unit.INSTANCE;
        r102.b(r103, r101, r105);
    }
}
