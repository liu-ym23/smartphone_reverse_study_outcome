package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f232003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f232004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f232005c;

    public a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        this.f232003a = 100;
        this.f232004b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        long r101 = System.currentTimeMillis();
        if ((r101 - this.f232005c) < this.f232003a) goto L6;
        this.f232005c = r101;
        this.f232004b.invoke(r100);
        return;
    }
}
