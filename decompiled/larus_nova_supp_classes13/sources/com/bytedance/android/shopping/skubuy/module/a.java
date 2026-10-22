package com.bytedance.android.shopping.skubuy.module;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t43.d;
import u33.a;
import v43.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<STATE extends o, PROPS extends u33.a & t43.d> extends s33.b<STATE, PROPS> {
    public final String b;
    public final l33.b<STATE, PROPS> c;

    public final void A() {
        this.c.d.d().a("ecom.sku.dismiss", MapsKt.mapOf(new Pair[]{TuplesKt.to("sku_session_id", this.c.c.b()), TuplesKt.to("stage", "will_dismiss"), TuplesKt.to("close_type", this.c.a.K())}));
    }

    public final void y() {
        this.c.d.d().a("ecom.sku.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("stage", "will_show"), TuplesKt.to("sku_session_id", this.c.c.b())}));
    }

    public final String j() {
        return this.b;
    }

    public a(l33.b<STATE, PROPS> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.c = r2;
        this.b = "PageExposeModule";
    }
}
