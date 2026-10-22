package com.obric.oui.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.GetChars;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class u extends PasswordTransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f401043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f401044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f401045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f401046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f401047e;

    public static class a extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f401048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f401049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f401051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401052e;

        public a(int r100, float r101, float r102, int r103) {
            this.f401052e = false;
            this.f401048a = r100;
            this.f401049b = r101;
            this.f401050c = r102;
            this.f401051d = r103;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            if (r104 == null) goto L5;
            Paint.FontMetricsInt r105 = r100.getFontMetricsInt();
            r104.ascent = r105.ascent;
            r104.descent = r105.descent;
            r104.top = r105.top;
            r104.bottom = r105.bottom;
        L5:
            if (r102 >= 0) goto L7;
        L11:
            boolean r106 = false;
        L12:
            if (r106 == false) goto L14;
            float r107 = r100.getTextSize();
            float r108 = (this.f401049b * r107) + (r107 * this.f401050c);
        L16:
            return (int) Math.ceil(r108);
        L14:
            r108 = r100.measureText(r101, r102, r103);
            goto L16
        L7:
            if (r102 >= r101.length()) goto L11;
            if (r101.charAt(r102) != 8226) goto L11;
            r106 = true;
            goto L12
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
            if (r112 >= 0) goto L5;
        L9:
            boolean r100 = false;
        L10:
            if (r100 == true) goto L13;
            r110.drawText(r111, r112, r113, r114, r116, r211);
            return;
        L13:
            float r101 = r211.getTextSize();
            float r102 = this.f401049b * r101;
            float r103 = (r101 * this.f401050c) + r102;
            float r104 = r102 / 2.0f;
            float r105 = r114 + r104;
            float r106 = (r115 + r210) / 2.0f;
            Paint.Style r107 = r211.getStyle();
            r211.setStyle(Paint.Style.FILL);
            if (this.f401052e == false) goto L16;
            int r108 = r211.getColor();
            r211.setColor(this.f401051d);
            r110.drawRect(Math.round(r114), r115, Math.round((r114 + r103) + 0.5f), r210, r211);
            r211.setColor(r108);
        L16:
            r110.drawCircle(r105, r106, r104, r211);
            r211.setStyle(r107);
            return;
        L5:
            if (r112 >= r111.length()) goto L9;
            if (r111.charAt(r112) != 8226) goto L9;
            r100 = true;
            goto L10
        }
    }

    public static class b implements Spanned, GetChars {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f401053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f401054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f401056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401057e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<a> f401058f;

        public final CharSequence b() {
            CharSequence r100 = this.f401053a;
            if (r100 != null) goto L7;
            return "";
        L7:
            return r100;
        }

        @Override // java.lang.CharSequence
        public final int length() {
            return b().length();
        }

        @Override // java.lang.CharSequence
        public final String toString() {
            return b().toString();
        }

        public final void a(int r100) {
        L3:
            if (this.f401058f.size() >= r100) goto L5;
            a r101 = new a(this.f401058f.size(), this.f401054b, this.f401055c, this.f401056d);
            r101.f401052e = this.f401057e;
            this.f401058f.add(r101);
            goto L3
        L5:
            int r102 = r100 + 16;
            if (this.f401058f.size() <= (r102 + 32)) goto L11;
            ArrayList<a> r103 = this.f401058f;
            r103.subList(r102, r103.size()).clear();
            return;
        }

        @Override // java.lang.CharSequence
        public final char charAt(int r100) {
            return b().charAt(r100);
        }

        @Override // android.text.Spanned
        public final int getSpanEnd(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            CharSequence r101 = b();
            if ((r101 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r101).getSpanEnd(r100);
        L5:
            return ((a) r100).f401048a + 1;
        }

        @Override // android.text.Spanned
        public final int getSpanFlags(Object r100) {
            if ((r100 instanceof a) == false) goto L6;
            return 33;
        L6:
            CharSequence r101 = b();
            if ((r101 instanceof Spanned) == true) goto L9;
            return 0;
        L9:
            return ((Spanned) r101).getSpanFlags(r100);
        }

        @Override // android.text.Spanned
        public final int getSpanStart(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            CharSequence r101 = b();
            if ((r101 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r101).getSpanStart(r100);
        L5:
            return ((a) r100).f401048a;
        }

        @Override // java.lang.CharSequence
        public final CharSequence subSequence(int r100, int r101) {
            return b().subSequence(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.Spanned
        public final <T> T[] getSpans(int r100, int r101, Class<T> r110) {
            CharSequence r102 = b();
            ArrayList r103 = new ArrayList();
            int r104 = 0;
            if ((r102 instanceof Spanned) == false) goto L8;
            Object[] r105 = ((Spanned) r102).getSpans(r100, r101, r110);
            int r106 = r105.length;
            int r107 = 0;
        L5:
            if (r107 >= r106) goto L8;
            r103.add(r105[r107]);
            r107 = r107 + 1;
        L8:
            if (r110.isAssignableFrom(a.class) == false) goto L10;
        L13:
            a(length());
            int r108 = Math.max(r100, 0);
            int r109 = Math.min(r101, length());
        L14:
            if (r108 >= r109) goto L19;
            if (r102.charAt(r108) != 8226) goto L18;
            r103.add(r110.cast((a) ListProtector.get(this.f401058f, r108)));
        L18:
            r108 = r108 + 1;
        L19:
            T[] r111 = (T[]) ((Object[]) Array.newInstance(r110, r103.size()));
        L21:
            if (r104 >= r103.size()) goto L23;
            r111[r104] = ListProtector.get(r103, r104);
            r104 = r104 + 1;
            goto L21
        L23:
            return r111;
        L10:
            if (r110.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r110.isAssignableFrom(Object.class) == false) goto L19;
            goto L13
        }

        @Override // android.text.Spanned
        public final int nextSpanTransition(int r100, int r101, Class r102) {
            CharSequence r103 = b();
            if ((r103 instanceof Spanned) == false) goto L5;
            int r104 = ((Spanned) r103).nextSpanTransition(r100, r101, r102);
        L6:
            if (r102 != null) goto L8;
        L13:
            a(length());
            int r105 = Math.max(r100, 0);
            int r106 = Math.min(r101, length());
        L14:
            if (r105 >= r106) goto L21;
            if (r103.charAt(r105) != 8226) goto L20;
            if (r105 <= r100) goto L19;
            r104 = Math.min(r104, r105);
        L19:
            r104 = Math.min(r104, r105 + 1);
        L20:
            r105 = r105 + 1;
        L21:
            return r104;
        L8:
            if (r102.isAssignableFrom(a.class) == true) goto L13;
            if (r102.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r102.isAssignableFrom(Object.class) == false) goto L21;
        L5:
            r104 = r101;
            goto L6
        }

        public b(CharSequence r100, float r101, float r102, int r103) {
            this.f401057e = false;
            this.f401058f = new ArrayList();
            this.f401053a = r100;
            this.f401054b = r101;
            this.f401055c = r102;
            this.f401056d = r103;
        }

        @Override // android.text.GetChars
        public final void getChars(int r100, int r101, char[] r102, int r103) {
            CharSequence r104 = b();
            if ((r104 instanceof GetChars) == false) goto L5;
            ((GetChars) r104).getChars(r100, r101, r102, r103);
            return;
        L5:
            TextUtils.getChars(r104, r100, r101, r102, r103);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence r100, View r101) {
        CharSequence r102 = super.getTransformation(r100, r101);
        b r103 = this.f401047e;
        if (r103 != null) goto L6;
        this.f401047e = new b(r102, this.f401043a, this.f401044b, this.f401045c);
    L9:
        b r104 = this.f401047e;
        boolean r105 = this.f401046d;
        r104.f401057e = r105;
        int r106 = 0;
    L11:
        if (r106 >= r104.f401058f.size()) goto L14;
        ((a) ListProtector.get(r104.f401058f, r106)).f401052e = r105;
        r106 = r106 + 1;
        goto L11
    L14:
        return this.f401047e;
    L6:
        if (r103.f401053a == r102) goto L9;
        r103.f401053a = r102;
        goto L9
    }

    public u(float r100, float r101, int r102) {
        this.f401046d = false;
        this.f401043a = r100;
        this.f401044b = r101;
        this.f401045c = r102;
    }
}
