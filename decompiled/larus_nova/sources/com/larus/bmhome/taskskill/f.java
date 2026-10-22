package com.larus.bmhome.taskskill;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f314286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f314287b;

    public f(Drawable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f314286a = r102;
        r100.setBounds(0, 0, r101, r101);
        this.f314287b = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f314287b.getBounds().width() + (this.f314286a * 2);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        int r109 = r100.save();
        r100.translate(r104 + this.f314286a, ((r107 + r105) - this.f314287b.getBounds().height()) / 2);     // Catch: Throwable -> L6
        this.f314287b.draw(r100);     // Catch: Throwable -> L6
        r100.restoreToCount(r109);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r109);
        throw th;
    }
}
