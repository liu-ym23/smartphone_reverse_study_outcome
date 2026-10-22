package com.bytedance.locallife.live.goodsshelves.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.bytedance.locallife.live.util.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f259884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f259885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f259886c;

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
    }

    public c(int r100, Float r101, Float r102) {
        this.f259884a = r100;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = (int) j0.b(r102.floatValue());
    L6:
        this.f259885b = r104;
        if (r101 == null) goto L9;
        r103 = (int) j0.b(r101.floatValue());
    L9:
        this.f259886c = r103;
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (this.f259884a + this.f259885b) + this.f259886c;
    }
}
