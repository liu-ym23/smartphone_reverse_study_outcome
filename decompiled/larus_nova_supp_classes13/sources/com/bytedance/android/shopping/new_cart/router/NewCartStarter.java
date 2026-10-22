package com.bytedance.android.shopping.new_cart.router;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.utils.g;
import com.bytedance.android.shopping.new_cart.yata.abilities.CartYataLogImpl;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.imagepipeline.common.Priority;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NewCartStarter {
    public static e t;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;
    public String l;
    public final String m;
    public final CartYataLogImpl n;
    public final int o;
    public final List<String> p;
    public final boolean q;
    public final Lazy r;
    public final String s;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public NewCartStarter(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.s = r2;
        this.m = "YATA-CartStarter-".concat(r2);
        this.n = new CartYataLogImpl();
        this.o = 6;
        ECSettingKeys.j.getClass();
        this.p = ECSettingKeys.h().a();
        this.q = ECSettingKeys.h().e();
        this.r = LazyKt.lazy(new NewCartStarter$isCacheResponseValid$2(this));
    }

    public final void c(e r13) {
        if (this.q == false) goto L36;
        if (r13 == null) goto L46;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r14 = r13.g();
        if (r14 == null) goto L47;
        Map r15 = r14.getData();
        if (r15 == null) goto L48;
        Collection r16 = r15.values();
        if (r16 == null) goto L49;
        Iterator r17 = r16.iterator();
        int r0 = 0;
    L13:
        if (r17.hasNext() == false) goto L50;
        p r1 = (p) r17.next();
        if (r0 >= 5) goto L13;
        if (Intrinsics.areEqual(q.c(r1), "product_card") == false) goto L13;
        Map r2 = r1.h();
        Object r3 = null;
        if (r2 == null) goto L21;
        Object r4 = r2.get("basic_info");
    L22:
        Map r5 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r4);
        if (r5 == null) goto L25;
        Object r6 = r5.get("spec_pic");
    L27:
        if ((r6 instanceof String) == false) goto L30;
        r3 = r6;
    L30:
        final String r7 = (String) r3;
        String r8 = a2.d("ec_cart_product_cover");
        if (r8 != null) goto L33;
        r8 = "unknown";
    L33:
        r r9 = new r("ec_cart", r8);
        Lazy r10 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", new NewCartStarter$preloadProductCover$1$1(r7));
        r0 = r0 + 1;
        if (r7 == null) goto L13;
        ImageExtensionsKt.B(r7, r9, null, null, Priority.IMMEDIATE, null, null, false, 192);
        goto L13
    L25:
        r6 = null;
        goto L27
    L21:
        r4 = null;
        goto L22
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    }

    public static final void a(NewCartStarter r5, Throwable r6) {
        String r0 = r5.s;
        e r1 = new e(null);
        boolean r3 = true;
        r1.d(1);
        Unit r4 = Unit.INSTANCE;
        s0.b(new com.bytedance.android.shopping.new_cart.router.a(r0, r1));
        int r2 = ECCartMonitorReporter.d;
        ECCartMonitorReporter r7 = ECCartMonitorReporter.a.a();
        String r8 = r5.k;
        r7.getClass();
        ECCartMonitorReporter.d(r8, "request_end");
        String r9 = r6.getMessage();
        String r10 = "";
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        if (r9.length() == 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L11;
        EnsureManager.ensureNotReachHere(r6);
        r9 = g.a(r6);
    L11:
        StringBuilder r11 = new StringBuilder();
        r11.append(r9);
        r11.append("; cause: ");
        Throwable r12 = r6.getCause();
        if (r12 == null) goto L14;
        String r13 = r12.getMessage();
    L15:
        r11.append(r13);
        String r14 = r11.toString();
        com.bytedance.android.shopping.new_cart.utils.a.j("PREFETCH-ON-Error", r14, null, 4);
        String r15 = r5.a;
        if (r15 == null) goto L19;
        r10 = r15;
    L19:
        com.bytedance.android.shopping.new_cart.utils.a.b(r14, r10);
        return;
    L14:
        r13 = null;
        goto L15
    }
}
