package com.larus.asr.session.clicktalk;

import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class s implements a3a.b, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f287647a;

    public s(t r100) {
        this.f287647a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a3a.b) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f287647a, t.class, "onAutoStopEvent", "onAutoStopEvent(Lcom/larus/voicecall/api/autostop/AutoStopAsrEvent;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // a3a.b
    public final void onEvent(a3a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        t r101 = this.f287647a;
        r101.getClass();
        if ((r100 instanceof a3a.a.C0009a) == false) goto L6;
        j r102 = new j.a(((a3a.a.C0009a) r100).f1683a);
    L38:
        r101.f287648a.onEvent(r102);
        return;
    L6:
        if ((r100 instanceof a3a.a.l) == false) goto L9;
        a3a.a.l r103 = (a3a.a.l) r100;
        r102 = new j.n(r103.f1701b, r103.f1702c);
        goto L38
    L9:
        if ((r100 instanceof a3a.a.e) == false) goto L12;
        a3a.a.e r104 = (a3a.a.e) r100;
        r102 = new j.f(r104.f1692a, r104.f1693b);
        goto L38
    L12:
        if ((r100 instanceof a3a.a.f) == false) goto L15;
        r102 = new j.g(((a3a.a.f) r100).f1694a);
        goto L38
    L15:
        if ((r100 instanceof a3a.a.h) == false) goto L18;
        r102 = new j.i(((a3a.a.h) r100).f1696a);
        goto L38
    L18:
        if ((r100 instanceof a3a.a.g) == false) goto L21;
        r102 = j.h.f287626a;
        goto L38
    L21:
        if ((r100 instanceof a3a.a.b) == false) goto L24;
        r102 = new j.b(((a3a.a.b) r100).f1686a);
        goto L38
    L24:
        if ((r100 instanceof a3a.a.c) == false) goto L27;
        r102 = new j.c(((a3a.a.c) r100).f1687a);
        goto L38
    L27:
        if ((r100 instanceof a3a.a.k) == false) goto L30;
        r102 = j.l.f287630a;
        goto L38
    L30:
        if ((r100 instanceof a3a.a.i) == false) goto L33;
        r102 = j.C3949j.f287628a;
        goto L38
    L33:
        if ((r100 instanceof a3a.a.j) == false) goto L36;
        r102 = j.k.f287629a;
        goto L38
    L36:
        if ((r100 instanceof a3a.a.d) == false) goto L41;
        a3a.a.d r105 = (a3a.a.d) r100;
        r102 = new j.d(r105.f1688a, r105.f1689b, r105.f1690c, r105.f1691d);
        goto L38
    L41:
        throw new NoWhenBranchMatchedException();
    }
}
