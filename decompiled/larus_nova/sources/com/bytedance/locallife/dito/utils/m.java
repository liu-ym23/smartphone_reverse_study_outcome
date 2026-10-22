package com.bytedance.locallife.dito.utils;

import android.graphics.Bitmap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements lp6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Bitmap, Unit> f258707a;

    @Override // lp6.c
    public final void onFail() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super Bitmap, Unit> r100) {
        this.f258707a = r100;
    }

    @Override // lp6.c
    public final void onCompleted(Bitmap r100) {
        this.f258707a.invoke(r100);
    }
}
