package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public class OTextClock extends TextClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Character> f403236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f403237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CharSequence f403238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile TextView.BufferType f403239d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403240a = null;

        static {
            int[] r100 = new int[Layout.Alignment.values().length];
            f403240a = r100;
            r100[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f403240a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f403240a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f403241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f403242b;

        public b(float r100) {
            this.f403242b = -1.0f;
            this.f403241a = r100;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            if (this.f403242b >= 0.0f) goto L6;
            this.f403242b = r100.measureText(r101, r102, r103);
        L6:
            return (int) (this.f403242b * this.f403241a);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
            if (this.f403242b >= 0.0f) goto L6;
            this.f403242b = r118.measureText(r111, r112, r113);
        L6:
            float r100 = this.f403242b;
            float r101 = this.f403241a * r100;
            int r102 = a.f403240a[Layout.Alignment.ALIGN_CENTER.ordinal()];
            if (r102 != 1) goto L9;
            float r103 = (r100 - r101) / 2.0f;
        L13:
            float r104 = r114 - r103;
        L14:
            r110.drawText(r111, r112, r113, r104, r116, r118);
            return;
        L9:
            if (r102 == 2) goto L11;
            r104 = r114;
            goto L14
        L11:
            r103 = r100 - r101;
            goto L13
        }
    }

    public final void a() {
        if (this.f403238c != null) goto L5;
        return;
    L5:
        if (this.f403238c.length() > 0) goto L7;
        return;
    L7:
        if ((!this.f403236a.isEmpty()) == false) goto L15;
        String r100 = this.f403238c.toString();
        SpannableString r101 = new SpannableString(r100);
        HashSet r102 = new HashSet(this.f403236a);
        float r103 = this.f403237b;
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        char r105 = ((Character) r104.next()).charValue();
        int r106 = r100.indexOf(r105);
    L12:
        if (r106 < 0) goto L10;
        int r107 = r106 + 1;
        r101.setSpan(new b(r103), r106, r107, 33);
        r106 = r100.indexOf(r105, r107);
        goto L12
    L14:
        super.setText(r101, this.f403239d);
    L16:
        invalidate();
        return;
    L15:
        super.setText(this.f403238c, this.f403239d);
        goto L16
    }

    public OTextClock(Context r100) {
        super(r100);
        this.f403236a = ConcurrentHashMap.newKeySet();
        this.f403237b = 1.0f;
        this.f403238c = "";
        this.f403239d = TextView.BufferType.NORMAL;
    }

    public void setRatio(float r100) {
        this.f403237b = r100;
        a();
    }

    public void setTargetCharacters(char[] r100) {
        this.f403236a.clear();
        if (r100 == null) goto L7;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        char r103 = r100[r102];
        this.f403236a.add(Character.valueOf(r103));
        r102 = r102 + 1;
    L7:
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r100) {
        super.setTextSize(r100);
        a();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r100) {
        super.setTypeface(r100);
        a();
    }

    public OTextClock(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f403236a = ConcurrentHashMap.newKeySet();
        this.f403237b = 1.0f;
        this.f403238c = "";
        this.f403239d = TextView.BufferType.NORMAL;
    }

    @Override // android.widget.TextView
    public final void setLineSpacing(float r100, float r101) {
        super.setLineSpacing(r100, r101);
        a();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f403238c = r100;
        this.f403239d = r101;
        a();
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        super.setTextSize(r100, r101);
        a();
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface r100, int r101) {
        super.setTypeface(r100, r101);
        a();
    }

    public OTextClock(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f403236a = ConcurrentHashMap.newKeySet();
        this.f403237b = 1.0f;
        this.f403238c = "";
        this.f403239d = TextView.BufferType.NORMAL;
    }
}
