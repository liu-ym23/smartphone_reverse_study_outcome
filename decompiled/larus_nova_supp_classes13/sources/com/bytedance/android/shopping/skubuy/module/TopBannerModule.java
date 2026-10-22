package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopBannerModule<STATE extends v43.b, PROPS extends u33.a> extends s33.b<STATE, PROPS> {
    public final String b;
    public Function1<? super Boolean, Unit> c;
    public k43.c d;

    public final void A() {
        if (this.d == null) goto L10;
        Function1<? super Boolean, Unit> r0 = this.c;
        if (r0 == null) goto L11;
        Map<Function1<Boolean, Unit>, ul.c> r1 = ai3.f.a;
        Intrinsics.checkNotNullParameter(r0, "callback");
        Map<Function1<Boolean, Unit>, ul.c> r2 = ai3.f.a;
        ul.c r3 = (ul.c) ((LinkedHashMap) r2).get(r0);
        if (r3 == null) goto L12;
        ul.b.a(r3);
        ul.c r4 = r2.remove(r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void y() {
        Object r0 = ((s33.b) this).a.e.g.get(WidgetName.TOP.getValue());
        if ((r0 instanceof k43.c) == true) goto L5;
        r0 = null;
    L5:
        k43.c r1 = (k43.c) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        this.d = r1;
        Function1<Boolean, Unit> r2 = new TopBannerModule$pageDidMount$1(this);
        this.c = r2;
        Map<Function1<Boolean, Unit>, ul.c> r3 = ai3.f.a;
        Intrinsics.checkNotNullParameter(r2, "callback");
        ai3.e r4 = new ai3.e(r2);
        ai3.f.a.put(r2, r4);
        ul.b.b(r4);
    }

    public final String j() {
        return this.b;
    }

    public TopBannerModule(l33.b<STATE, PROPS> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = "TopStrandModule";
    }
}
