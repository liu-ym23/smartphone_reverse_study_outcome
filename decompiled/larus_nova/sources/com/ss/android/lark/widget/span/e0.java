package com.ss.android.lark.widget.span;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class e0 implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f448671a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f448672a;

        public final int hashCode() {
            return Objects.hash(new Object[]{Float.valueOf(this.f448672a)});
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L15;
            if (this.f448672a == ((a) r100).f448672a) goto L16;
            return false;
        L16:
            return true;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f448671a});
    }

    public e0(a r100) {
        this.f448671a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (e0.class == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f448671a.equals(((e0) r100).f448671a);
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        int r106 = ((Spanned) r100).getSpanEnd(this);
        boolean r107 = true;
        if (r106 != r102) goto L5;
    L8:
        if (r107 == false) goto L11;
        int r108 = r105.bottom;
        int r109 = (int) (((double) (this.f448671a.f448672a - (r108 - r105.top))) + 0.5d);
        r105.descent += r109;
        r105.bottom = r108 + r109;
        return;
    L11:
        return;
    L5:
        if (r106 == (r102 - 1)) goto L8;
        r107 = false;
        goto L8
    }
}
