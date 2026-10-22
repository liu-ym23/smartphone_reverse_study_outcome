package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.abscontainer.arch.core.data.RefreshProtocolSource;
import com.bytedance.android.shopping.abscontainer.common_biz.widget.error.ErrorButtonAction;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.a;
import v43.b;
import v43.n;
import v43.o;
import v43.s;
import v43.t;
import v43.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuBuyCoreFlowModule<STATE extends v43.b & v43.a & s & o & n, PROPS extends u33.a> extends s33.b<STATE, PROPS> {
    public final String b;
    public final com.bytedance.android.shopping.skubuy.cache.a c;
    public long d;
    public k33.a e;
    public boolean f;
    public int g;

    public final void x() {
    }

    public final void B() {
        ((s33.b) this).a.a.a().c(new y43.a(true, true, false, false, 24));
        ((s33.b) this).a.a.g().c(new x43.a(126));
        ((s33.b) this).a.d.g().a(null, null, null);
    }

    public final void c() {
        ((s33.b) this).a.a.a().c(new y43.a(false, false, false, false, 30));
    }

    public final com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a d() {
        return new com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.a(!this.f);
    }

    public final void y() {
        ((s33.b) this).a.a.a().a(new f(this));
        ((s33.b) this).a.a.g().a(new g(this));
        Lazy r0 = SkuBuyResponseCacheHelper.a;
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r1 = SkuBuyResponseCacheHelper.b(this.c);
        if (r1 == null) goto L5;
        n33.a r2 = r1.a;
    L6:
        if (r2 == null) goto L8;
        ((s33.b) this).a.d.c().a();
        ((s33.b) this).a.d.c().h(r2, RefreshProtocolSource.QUERY, new n33.d("biz_first_enter", null));
        ((s33.b) this).a.d.a().c(MapsKt.mapOf(TuplesKt.to("has_used_cache", "1")));
        ((s33.b) this).a.a.a().c(new y43.a(false, false, false, false, 30));
        return;
    L8:
        ((s33.b) this).a.a.a().c(new y43.a(true, true, false, true, 16));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final String j() {
        return this.b;
    }

    public SkuBuyCoreFlowModule(l33.b<STATE, PROPS> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = "CoreFlowModule";
        Lazy r0 = SkuBuyResponseCacheHelper.a;
        this.c = SkuBuyResponseCacheHelper.a(r2.c.a.getSchemaModel());
    }

    public final void e(n33.c r15) {
        Intrinsics.checkNotNullParameter(r15, "response");
        int r0 = this.g;
        if (r0 > 0) goto L5;
    L8:
        ((s33.b) this).a.a.a().c(new y43.a(false, false, false, false, 30));
        n33.a r16 = r15.a;
        if (r16 == null) goto L12;
        final Map r17 = r16.f();
        if (r17 == null) goto L12;
    L13:
        Object r5 = r17.get("icon");
        Object r9 = null;
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        String r6 = (String) r5;
        Object r4 = r17.get("title");
        if ((r4 instanceof String) == true) goto L19;
        r4 = null;
    L19:
        String r10 = (String) r4;
        Object r3 = r17.get("description");
        if ((r3 instanceof String) == true) goto L22;
        r3 = null;
    L22:
        String r11 = (String) r3;
        Object r2 = r17.get("button_text");
        if ((r2 instanceof String) == true) goto L25;
        r2 = null;
    L25:
        String r12 = (String) r2;
        Object r1 = r17.get("button_action");
        if ((r1 instanceof String) == false) goto L29;
        r9 = r1;
    L29:
        ((s33.b) this).a.a.g().c(new x43.a(true, true, r6, r10, r11, r12, (String) r9));
        ((s33.b) this).a.e.f.c(new SkuBuyCoreFlowModule$flowQueryFetchFailed$1(this, r17));
        ((s33.b) this).a.e.f.b(new SkuBuyCoreFlowModule$flowQueryFetchFailed$2(this));
        return;
    L12:
        r17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon", "https://p6-piu.byteimg.com/tos-cn-i-8jisjyls3a/c5f693c88544439089cde4031581841b~tplv-8jisjyls3a-image.image"), TuplesKt.to("title", "网络异常"), TuplesKt.to("description", "请重新刷新页面"), TuplesKt.to("button_text", "刷新"), TuplesKt.to("button_action", ErrorButtonAction.REFRESH.getValue()), TuplesKt.to("debounce_time", 0)});
        goto L13
    L5:
        if (r15.c == null) goto L8;
        this.g = r0 - 1;
        ((s33.b) this).a.a.I(true);
        n r18 = ((s33.b) this).a.a;
        r18.i(r18.L() + 1);
        B();
    }

    public final void f(n33.f r8) {
        Intrinsics.checkNotNullParameter(r8, "response");
        boolean r2 = false;
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(((s33.b) this).a.d.c(), null) == false) goto L14;
        Object r0 = r8.e.get("query_version");
        if ((r0 instanceof Integer) == true) goto L7;
        r0 = null;
    L7:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L10;
        int r3 = r1.intValue();
    L12:
        if (r3 >= ((s33.b) this).a.a.h()) goto L14;
        return;
    L10:
        r3 = 0;
    L14:
        ((s33.b) this).a.a.g().c(new x43.a(126));
        ((s33.b) this).a.a.B(r8);
        if (((s33.b) this).a.a.h() != 0) goto L17;
        r2 = true;
    L17:
        this.f = r2;
        ((s33.b) this).a.d.c().h(r8.b, RefreshProtocolSource.QUERY, new n33.d("biz_first_enter", r8.c));
        ((s33.b) this).a.d.e().c(new SkuBuyCoreFlowModule$flowQueryFetchSucceed$2(this, r8, null));
    }

    public final void h(com.bytedance.kmp.ec.yata.common.biz.callback.a r9) {
        Intrinsics.checkNotNullParameter(r9, "model");
        String r0 = r9.b;
        t r1 = ((s33.b) this).a.a.A();
        Object r2 = null;
        if (r1 == null) goto L12;
        List r3 = r1.b;
        if (r3 == null) goto L12;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((u) r6).b, r0) == false) goto L8;
        r4.add(r6);
    L13:
        b43.c r7 = b43.c.a;
        if (r4 == null) goto L16;
        boolean r8 = r4.isEmpty();
    L17:
        if (r8 == true) goto L19;
        return;
    L19:
        String r10 = r9.c;
        Object r11 = ((s33.b) this).a.d.c().e("delay_loading_map");
        if ((r11 instanceof Map) == true) goto L22;
        r11 = null;
    L22:
        Map r12 = (Map) r11;
        if (r12 == null) goto L25;
        Object r13 = r12.get(r10);
    L27:
        if ((r13 instanceof Integer) == false) goto L30;
        r2 = r13;
    L30:
        Integer r14 = (Integer) r2;
        if (r14 == null) goto L33;
        int r15 = r14.intValue();
    L34:
        if (r15 <= 0) goto L39;
        ((s33.b) this).a.a.a().c(new y43.a(true, false, false, true, 16));
        k33.a r16 = this.e;
        if (r16 == null) goto L38;
        r16.cancel();
    L38:
        this.e = ((s33.b) this).a.d.e().a(r15, new SkuBuyCoreFlowModule$flowUplinkStart$1(this));
        return;
    L39:
        ((s33.b) this).a.a.a().c(new y43.a(true, false, true, true, 16));
        return;
    L33:
        r15 = 0;
        goto L34
    L25:
        r13 = null;
        goto L27
    L16:
        r8 = true;
    L12:
        r4 = null;
        goto L13
    }

    public final void g(com.bytedance.kmp.ec.yata.common.biz.callback.a r8, n33.c r9) {
        Intrinsics.checkNotNullParameter(r8, "model");
        Intrinsics.checkNotNullParameter(r9, "response");
        k33.a r10 = this.e;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        ((s33.b) this).a.a.a().c(new y43.a(false, false, false, false, 30));
        n33.a r11 = r9.a;
        String r0 = null;
        if (r11 == null) goto L8;
        String r12 = r11.b();
    L9:
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L22;
        j33.e r14 = ((s33.b) this).a.d.b();
        n33.a r15 = r9.a;
        if (r15 == null) goto L19;
        r0 = r15.b();
    L19:
        if (r0 != null) goto L21;
        r0 = "";
    L21:
        r14.showToast(r0);
        return;
    L22:
        n33.a r16 = r9.a;
        if (r16 == null) goto L25;
        r0 = r16.g();
    L25:
        if (r0 != null) goto L29;
        ((s33.b) this).a.d.b().showToast("网络存在异常，请稍后重试");
        return;
    L29:
        return;
    L11:
        if (r12.length() == 0) goto L14;
        r13 = false;
        goto L15
    L8:
        r12 = null;
        goto L9
    }

    public final void i(com.bytedance.kmp.ec.yata.common.biz.callback.a r2, n33.f r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "response");
        k33.a r4 = this.e;
        if (r4 == null) goto L6;
        r4.cancel();
        return;
    }
}
