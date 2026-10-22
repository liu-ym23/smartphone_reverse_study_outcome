package me5;

import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends j66.a {
    public final String b;

    /* JADX INFO: renamed from: me5.a$a, reason: collision with other inner class name */
    public static final class C0265a {
    }

    static {
    }

    public a() {
        this.b = "ccm.request";
    }

    public String getName() {
        return this.b;
    }

    public static void f(Pair r4, String r5, j66.a.a r6) {
        int r0 = ((Number) r4.getFirst()).intValue();
        Integer r7 = (Integer) r4.getSecond();
        tt5.a.h("ccm-lynx: CCMNetRequestMethod", "callbackRequestFailure mainCode: " + r0 + " subCode: " + r7 + ", msg: " + r5);
        k66.b r1 = new k66.b();
        r1.a = r7;
        StringBuilder r2 = new StringBuilder("request error: ");
        r2.append(r7);
        r1.b = r2.toString();
        Unit r8 = Unit.INSTANCE;
        r6.b(r0, r5, r1);
    }
}
