package lk6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends ReplacementSpan implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f509577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f509578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f509579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f509580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f509581f;

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
    }

    public b() {
        this.f509578c = 1;
    }

    @Override // lk6.a
    public final void setWidthAndHeight(int r100, int r101) {
        this.f509576a = r100;
        this.f509577b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        int r105 = (this.f509576a + this.f509580e) + this.f509581f;
        if (r104 != null) goto L5;
    L15:
        return r105;
    L5:
        switch(this.f509578c) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        int r106 = (r104.bottom + r104.top) / 2;
        int r107 = this.f509577b / 2;
    L10:
        int r108 = r106 - r107;
    L14:
        int r109 = r108 + this.f509579d;
        r104.top = r109;
        r104.ascent = r109;
        int r110 = this.f509577b;
        r104.bottom = r110 + r109;
        r104.descent = r110 + r109;
        goto L15
    L7:
        r108 = r104.ascent;
        goto L14
    L8:
        r108 = r104.top;
        goto L14
    L9:
        r106 = r104.descent;
        r107 = this.f509577b;
        goto L10
    L11:
        r108 = -this.f509577b;
        goto L14
    L12:
        r106 = (r104.descent + r104.ascent) / 2;
        r107 = this.f509577b / 2;
        goto L10
    L13:
        r106 = (r104.bottom + r104.top) / 2;
        r107 = this.f509577b / 2;
        goto L10
    }
}
