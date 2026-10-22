package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CustomMoreItem extends com.bytedance.ee.bear.more.protocol3.g {
    public final String c;
    public final d d;
    public final q e;
    public final x f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CustomMoreItem a;

        public b(CustomMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            CustomMoreItem.k(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CustomMoreItem a;

        public c(CustomMoreItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            CustomMoreItem.k(this.a);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        boolean r3 = this.e.b(this.f, true);     // Catch: Throwable -> L5
    L8:
        if (r3 == true) goto L10;
        return null;
    L10:
        d r4 = this.d;
        if ((r4 instanceof d.a) == false) goto L15;
        tt5.a.h("CustomMoreItem", "buildUIItem: FullyCustom, itemId=" + this.c);
        return new g0(this.c, new CustomMoreItem$buildUIItem$1(this), new b(this));
    L15:
        if ((r4 instanceof d.b) == false) goto L18;
        String r0 = ((d.b) r4).a;
    L24:
        d r5 = this.d;
        if ((r5 instanceof d.b) == false) goto L28;
        int r6 = ((d.b) r5).b;
    L34:
        d r7 = this.d;
        if ((r7 instanceof d.b) == false) goto L38;
        Integer r8 = ((d.b) r7).c;
    L44:
        d r9 = this.d;
        if ((r9 instanceof d.b) == false) goto L48;
        Integer r10 = ((d.b) r9).d;
    L54:
        com.bytedance.ee.bear.more.protocol3.f.i r11 = new com.bytedance.ee.bear.more.protocol3.f.i(this.c, r6, r0, 10);
        d r1 = this.d;
        if ((r1 instanceof d.b) == false) goto L58;
        com.bytedance.ee.bear.more.protocol3.e.f r2 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
    L63:
        com.bytedance.ee.bear.more.protocol3.e r12 = r2;
    L64:
        com.bytedance.ee.bear.more.protocol3.k r13 = com.bytedance.ee.bear.more.protocol3.g.i(this, r11, r12, CollectionsKt.listOf(new BizChecker(true)), null, new c(this), 8);
        if (r8 != null) goto L67;
        if (r10 != null) goto L67;
    L69:
        return r13;
    L67:
        if (r13 == null) goto L69;
        r13.c = new h0(r8, r10, 9);
        goto L69
    L58:
        if ((r1 instanceof d.C0122d) == false) goto L61;
        ((d.C0122d) r1).getClass();
        r12 = new com.bytedance.ee.bear.more.protocol3.e.h(false, 6);
        goto L64
    L61:
        if ((r1 instanceof d.c) == true) goto L70;
        r2 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
        goto L63
    L70:
        ((d.c) this.d).getClass();
        new com.bytedance.ee.bear.more.protocol3.e.g(false, null);
        throw null;
    L48:
        if ((r9 instanceof d.C0122d) == false) goto L51;
        ((d.C0122d) r9).getClass();
    L53:
        r10 = null;
        goto L54
    L51:
        if ((r9 instanceof d.c) == false) goto L53;
        ((d.c) r9).getClass();
        goto L53
    L38:
        if ((r7 instanceof d.C0122d) == false) goto L41;
        ((d.C0122d) r7).getClass();
    L43:
        r8 = null;
        goto L44
    L41:
        if ((r7 instanceof d.c) == false) goto L43;
        ((d.c) r7).getClass();
        goto L43
    L28:
        if ((r5 instanceof d.C0122d) == false) goto L31;
        ((d.C0122d) r5).getClass();
    L33:
        r6 = 0;
        goto L34
    L31:
        if ((r5 instanceof d.c) == false) goto L33;
        ((d.c) r5).getClass();
        goto L33
    L18:
        if ((r4 instanceof d.C0122d) == false) goto L21;
        ((d.C0122d) r4).getClass();
    L23:
        r0 = null;
        goto L24
    L21:
        if ((r4 instanceof d.c) == false) goto L23;
        ((d.c) r4).getClass();
    L5:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "delegate.isVisible error, itemId=" + this.c, th, false);
        r3 = false;
        goto L8
    }

    public static final void k(CustomMoreItem r5) {
        r5.getClass();
        tt5.a.h("CustomMoreItem", "click, itemId=" + r5.c);
        i r2 = r5.e.a(r5.f);     // Catch: Throwable -> L5
    L8:
        if (Intrinsics.areEqual(r2, i.a.a) == false) goto L11;
        tt5.a.h("CustomMoreItem", "click consumed by host, itemId=" + r5.c);
        return;
    L11:
        if (Intrinsics.areEqual(r2, i.b.a) == false) goto L21;
        q r3 = r5.f.e6(r5.c);
        if (r3 != null) goto L22;
        tt5.a.k("CustomMoreItem", "click fallback but baseline is null, itemId=" + r5.c);
        return;
    L22:
        r3.a(r5.f);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "baseline.onClick error, itemId=" + r5.c, th, false);
        Unit r6 = Unit.INSTANCE;
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    L5:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "delegate.onClick error, itemId=" + r5.c, th, false);
        r2 = i.b.a;
        goto L8
    }

    public CustomMoreItem(String r2, d r3, q r4, x r5) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r4, "delegate");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
