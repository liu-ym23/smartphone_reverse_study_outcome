package com.obric.oui.animation.easy;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements b.a<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<b<View>, Unit> f398749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<b<View>, Unit> f398750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<b<View>, Unit> f398751c;

    @Override // com.obric.oui.animation.easy.b.a
    public final void a(b<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f398750b.invoke(r100);
    }

    @Override // com.obric.oui.animation.easy.b.a
    public final void b(b<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f398749a.invoke(r100);
    }

    @Override // com.obric.oui.animation.easy.b.a
    public final void c(b<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f398751c.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super b<View>, Unit> r100, Function1<? super b<View>, Unit> r101, Function1<? super b<View>, Unit> r102) {
        this.f398749a = r100;
        this.f398750b = r101;
        this.f398751c = r102;
    }
}
