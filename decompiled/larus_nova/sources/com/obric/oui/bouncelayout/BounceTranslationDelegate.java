package com.obric.oui.bouncelayout;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class BounceTranslationDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Float> f398908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<BounceEdgeEffect[]> f398909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f398910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Float, Unit> f398911d;

    public final void a() {
        BounceEdgeEffect[] r100 = this.f398909b.invoke();
        int r101 = 0;
        if (this.f398910c != null) goto L11;
        int r102 = r100.length;
    L5:
        if (r101 >= r102) goto L10;
        BounceEdgeEffect r103 = r100[r101];
        r101 = r101 + 1;
        if (r103 == null) goto L5;
        r103.f398884g = null;
        goto L5
    L10:
        return;
    L11:
        int r104 = r100.length;
    L12:
        if (r101 >= r104) goto L17;
        BounceEdgeEffect r105 = r100[r101];
        r101 = r101 + 1;
        if (r105 == null) goto L12;
        r105.f398884g = this.f398911d;
        goto L12
    }

    public BounceTranslationDelegate(Function0<Float> r100, Function0<BounceEdgeEffect[]> r101) {
        Intrinsics.checkNotNullParameter(r100, "getTotalTranslation");
        Intrinsics.checkNotNullParameter(r101, "effectsProvider");
        this.f398908a = r100;
        this.f398909b = r101;
        this.f398911d = new BounceTranslationDelegate$callback$1(this);
    }
}
