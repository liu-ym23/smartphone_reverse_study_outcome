package com.larus.home.impl.main.side_bar.view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class j2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k2 f345748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ eb9.n f345749b;

    public /* synthetic */ j2(k2 r100, eb9.n r101) {
        this.f345748a = r100;
        this.f345749b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        k2 r101 = this.f345748a;
        eb9.n r102 = this.f345749b;
        RecyclerView.Adapter<?> r103 = (RecyclerView.Adapter) r100;
        Intrinsics.checkNotNullParameter(r103, "candidate");
        return Integer.valueOf(r101.f345755d.invoke(r103, r102).intValue());
    }
}
