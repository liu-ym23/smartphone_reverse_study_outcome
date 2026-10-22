package com.larus.bmhome.taskskill.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f314624a;

    /* JADX INFO: renamed from: com.larus.bmhome.taskskill.view.a$a, reason: collision with other inner class name */
    public static final class C4105a {
    }

    static {
    }

    public a(Drawable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        r100.setBounds(0, 0, r101, r101);
        this.f314624a = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f314624a.getBounds().width();
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        int r109 = r100.save();
        r100.translate(r104, ((r107 + r105) - this.f314624a.getBounds().height()) / 2.0f);     // Catch: Throwable -> L6
        this.f314624a.draw(r100);     // Catch: Throwable -> L6
        r100.restoreToCount(r109);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r109);
        throw th;
    }
}
