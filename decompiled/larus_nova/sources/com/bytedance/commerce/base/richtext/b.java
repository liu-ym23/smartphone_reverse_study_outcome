package com.bytedance.commerce.base.richtext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202928a = 0;

    public static final class a extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f202929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f202930b;

        public a(int r100) {
            this.f202930b = r100;
            Paint r101 = new Paint();
            this.f202929a = r101;
            r101.setColor(0);
            r101.setStyle(Paint.Style.FILL);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            return this.f202930b;
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
            r100.drawRect(r111, r112, r111 + this.f202930b, r114, this.f202929a);
        }
    }

    static {
    }
}
