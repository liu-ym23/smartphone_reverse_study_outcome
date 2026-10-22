package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.movable.MarkdownMovableView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MarkdownMovableView f414926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CotMovableRenderState f414927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f414928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, Float, Unit> f414929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<String, Float> f414930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f414931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f414932g;

    public c() {
        throw null;
    }

    public final void a() {
        this.f414931f = null;
        this.f414930e = null;
        CotMovableRenderState r100 = this.f414927b;
        r100.f414872a.incrementAndGet();
        r100.f414873b = null;
        r100.f414874c = CotMovableRenderState.Status.IDLE;
    }

    public final void b() {
        this.f414926a.removeOnLayoutChangeListener(this.f414932g);
        a();
        this.f414926a.d();
        this.f414926a.setTag(R.id.cot_movable_render_delegate, null);
    }

    public c(final MarkdownMovableView r100, CotMovableRenderState r101) {
        Function0<Boolean> r102 = new CotMovableRenderDelegate$1(r100);
        CotMovableRenderDelegate$2 r103 = new CotMovableRenderDelegate$2(r100);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "renderState");
        Intrinsics.checkNotNullParameter(r102, "isCurrentRenderValid");
        Intrinsics.checkNotNullParameter(r103, "submitRender");
        this.f414926a = r100;
        this.f414927b = r101;
        this.f414928c = r102;
        this.f414929d = r103;
        b r104 = new b(this);
        this.f414932g = r104;
        r100.addOnLayoutChangeListener(r104);
    }

    public final void c(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "markdown");
        Float r102 = Float.valueOf(r101);
        boolean r103 = true;
        if (r102.floatValue() <= 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L21;
        Integer r105 = Integer.valueOf(this.f414926a.getWidth());
        if (r105.intValue() > 0) goto L15;
        r103 = false;
    L15:
        if (r103 == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        r102 = Float.valueOf(com.ss.android.lark.movable.utils.b.f(r105.intValue(), this.f414926a.getContext()));
        goto L21
    L20:
        r102 = null;
    L21:
        if (r102 != null) goto L23;
        this.f414931f = r100;
        return;
    L23:
        this.f414931f = null;
        d(r100, r102.floatValue());
        return;
    L5:
        r104 = false;
        goto L7
    }

    public final void d(String r100, float r101) {
        Pair<String, Float> r102 = TuplesKt.to(r100, Float.valueOf(r101));
        if (Intrinsics.areEqual(r102, this.f414930e) == false) goto L23;
        CotMovableRenderState r103 = this.f414927b;
        boolean r104 = this.f414928c.invoke().booleanValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, ChameleonOpenTracker.Stage.RENDER);
        boolean r105 = true;
        if (Intrinsics.areEqual(r102, r103.f414873b) == false) goto L21;
        CotMovableRenderState.Status r106 = r103.f414874c;
        int r107 = CotMovableRenderState.a.f414877a[r106.ordinal()];
        if (r107 != 1) goto L10;
    L20:
        r105 = false;
        goto L21
    L10:
        if (r107 != 2) goto L12;
        if (r104 == true) goto L20;
    L12:
        if (r107 == 3) goto L21;
        if (r107 == 4) goto L21;
        throw new NoWhenBranchMatchedException();
    L21:
        if (r105 == true) goto L23;
        return;
    L23:
        CotMovableRenderState r108 = this.f414927b;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r102, ChameleonOpenTracker.Stage.RENDER);
        r108.f414872a.incrementAndGet();
        r108.f414873b = r102;
        r108.f414874c = CotMovableRenderState.Status.PENDING;
        this.f414929d.invoke(r100, Float.valueOf(r101));
        this.f414930e = r102;
    }
}
