package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CustomMoreItem extends com.bytedance.ee.bear.more.protocol3.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f234906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f234907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f234908f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomMoreItem f234909a;

        public b(CustomMoreItem r100) {
            this.f234909a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CustomMoreItem.k(this.f234909a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomMoreItem f234910a;

        public c(CustomMoreItem r100) {
            this.f234910a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CustomMoreItem.k(this.f234910a);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        boolean r100 = this.f234907e.b(this.f234908f, true);     // Catch: Throwable -> L5
    L8:
        if (r100 == true) goto L10;
        return null;
    L10:
        d r101 = this.f234906d;
        if ((r101 instanceof d.a) == false) goto L15;
        tt5.a.h("CustomMoreItem", "buildUIItem: FullyCustom, itemId=" + this.f234905c);
        return new g0(this.f234905c, new CustomMoreItem$buildUIItem$1(this), new b(this));
    L15:
        if ((r101 instanceof d.b) == false) goto L18;
        String r102 = ((d.b) r101).f234948a;
    L24:
        d r103 = this.f234906d;
        if ((r103 instanceof d.b) == false) goto L28;
        int r104 = ((d.b) r103).f234949b;
    L34:
        d r105 = this.f234906d;
        if ((r105 instanceof d.b) == false) goto L38;
        Integer r106 = ((d.b) r105).f234950c;
    L44:
        d r107 = this.f234906d;
        if ((r107 instanceof d.b) == false) goto L48;
        Integer r108 = ((d.b) r107).f234951d;
    L54:
        com.bytedance.ee.bear.more.protocol3.f.i r109 = new com.bytedance.ee.bear.more.protocol3.f.i(this.f234905c, r104, r102, 10);
        d r110 = this.f234906d;
        if ((r110 instanceof d.b) == false) goto L58;
        com.bytedance.ee.bear.more.protocol3.e.f r111 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
    L63:
        com.bytedance.ee.bear.more.protocol3.e r112 = r111;
    L64:
        com.bytedance.ee.bear.more.protocol3.k r113 = com.bytedance.ee.bear.more.protocol3.g.i(this, r109, r112, CollectionsKt.listOf(new BizChecker(true)), null, new c(this), 8);
        if (r106 != null) goto L67;
        if (r108 != null) goto L67;
    L69:
        return r113;
    L67:
        if (r113 == null) goto L69;
        r113.f234903c = new h0(r106, r108, 9);
        goto L69
    L58:
        if ((r110 instanceof d.C3369d) == false) goto L61;
        ((d.C3369d) r110).getClass();
        r112 = new com.bytedance.ee.bear.more.protocol3.e.h(false, 6);
        goto L64
    L61:
        if ((r110 instanceof d.c) == true) goto L70;
        r111 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false);
        goto L63
    L70:
        ((d.c) this.f234906d).getClass();
        new com.bytedance.ee.bear.more.protocol3.e.g(false, null);
        throw null;
    L48:
        if ((r107 instanceof d.C3369d) == false) goto L51;
        ((d.C3369d) r107).getClass();
    L53:
        r108 = null;
        goto L54
    L51:
        if ((r107 instanceof d.c) == false) goto L53;
        ((d.c) r107).getClass();
        goto L53
    L38:
        if ((r105 instanceof d.C3369d) == false) goto L41;
        ((d.C3369d) r105).getClass();
    L43:
        r106 = null;
        goto L44
    L41:
        if ((r105 instanceof d.c) == false) goto L43;
        ((d.c) r105).getClass();
        goto L43
    L28:
        if ((r103 instanceof d.C3369d) == false) goto L31;
        ((d.C3369d) r103).getClass();
    L33:
        r104 = 0;
        goto L34
    L31:
        if ((r103 instanceof d.c) == false) goto L33;
        ((d.c) r103).getClass();
        goto L33
    L18:
        if ((r101 instanceof d.C3369d) == false) goto L21;
        ((d.C3369d) r101).getClass();
    L23:
        r102 = null;
        goto L24
    L21:
        if ((r101 instanceof d.c) == false) goto L23;
        ((d.c) r101).getClass();
    L5:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "delegate.isVisible error, itemId=" + this.f234905c, th, false);
        r100 = false;
        goto L8
    }

    public static final void k(CustomMoreItem r100) {
        r100.getClass();
        tt5.a.h("CustomMoreItem", "click, itemId=" + r100.f234905c);
        i r101 = r100.f234907e.a(r100.f234908f);     // Catch: Throwable -> L5
    L8:
        if (Intrinsics.areEqual(r101, i.a.f234979a) == false) goto L11;
        tt5.a.h("CustomMoreItem", "click consumed by host, itemId=" + r100.f234905c);
        return;
    L11:
        if (Intrinsics.areEqual(r101, i.b.f234980a) == false) goto L21;
        q r102 = r100.f234908f.e6(r100.f234905c);
        if (r102 != null) goto L22;
        tt5.a.k("CustomMoreItem", "click fallback but baseline is null, itemId=" + r100.f234905c);
        return;
    L22:
        r102.a(r100.f234908f);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "baseline.onClick error, itemId=" + r100.f234905c, th, false);
        Unit r103 = Unit.INSTANCE;
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    L5:
        th = move-exception;
        tt5.a.e("CustomMoreItem", "delegate.onClick error, itemId=" + r100.f234905c, th, false);
        r101 = i.b.f234980a;
        goto L8
    }

    public CustomMoreItem(String r100, d r101, q r102, x r103) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r102, "delegate");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f234905c = r100;
        this.f234906d = r101;
        this.f234907e = r102;
        this.f234908f = r103;
    }
}
