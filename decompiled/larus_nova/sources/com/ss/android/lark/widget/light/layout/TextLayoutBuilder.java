package com.ss.android.lark.widget.light.layout;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import com.larus.nova.R;
import com.ss.android.lark.widget.light.viewstub.ViewHolderSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TextLayoutBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LruCache<Integer, Layout> f446124h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f446125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f446126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f446127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f446128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f446129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f446130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f446131g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MeasureMode {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextPaint f446132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f446133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f446134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f446135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f446136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f446137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f446138g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f446139h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f446140i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f446141j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TextUtils.TruncateAt f446142k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f446143l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f446144m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f446145n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Layout.Alignment f446146o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final TextDirectionHeuristicCompat f446147p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f446148q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f446149r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public com.ss.android.lark.widget.light.viewstub.f f446150s;

        public final void a() {
            if (this.f446149r == false) goto L6;
            TextPaint r100 = new TextPaint(this.f446132a);
            r100.set(this.f446132a);
            this.f446132a = r100;
            this.f446149r = false;
            return;
        }

        public final int hashCode() {
            int r100 = (((this.f446132a.getColor() + 31) * 31) + Float.floatToIntBits(this.f446132a.getTextSize())) * 31;
            int r101 = 0;
            if (this.f446132a.getTypeface() == null) goto L5;
            int r102 = this.f446132a.getTypeface().hashCode();
        L6:
            int r103 = (((((((((r100 + r102) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + 0) * 31;
            TextPaint r104 = this.f446132a;
            int r105 = (((((((((((((((((((r103 + r104.linkColor) * 31) + Float.floatToIntBits(r104.density)) * 31) + Arrays.hashCode(this.f446132a.drawableState)) * 31) + 0) * 31) + 0) * 31) + Float.floatToIntBits(this.f446136e)) * 31) + Float.floatToIntBits(this.f446137f)) * 31) + Float.floatToIntBits(this.f446138g)) * 31) + (this.f446139h ? 1 : 0)) * 31) + (this.f446140i ? 1 : 0)) * 31;
            TextUtils.TruncateAt r106 = this.f446142k;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (((((((r105 + r107) * 31) + this.f446143l) * 31) + (this.f446144m ? 1 : 0)) * 31) + this.f446145n) * 31;
            Layout.Alignment r109 = this.f446146o;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            TextDirectionHeuristicCompat r112 = this.f446147p;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (((((((((r111 + r113) * 31) + this.f446148q) * 31) + 0) * 31) + Arrays.hashCode(null)) * 31) + Arrays.hashCode(null)) * 31;
            CharSequence r115 = this.f446135d;
            if (r115 == null) goto L22;
            r101 = r115.hashCode();
        L22:
            return ((r114 + r101) * 31) + this.f446133b;
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public a() {
            boolean r100 = true;
            this.f446132a = new TextPaint(1);
            this.f446134c = 0;
            this.f446136e = 1.0f;
            this.f446137f = 0.0f;
            this.f446138g = Float.MAX_VALUE;
            this.f446139h = true;
            if (Build.VERSION.SDK_INT >= 28) goto L6;
            r100 = false;
        L6:
            this.f446140i = r100;
            this.f446141j = false;
            this.f446142k = null;
            this.f446143l = 0;
            this.f446144m = false;
            this.f446145n = Integer.MAX_VALUE;
            this.f446146o = Layout.Alignment.ALIGN_NORMAL;
            this.f446147p = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
            this.f446148q = 0;
            this.f446149r = false;
            this.f446150s = com.ss.android.lark.widget.light.viewstub.f.f446339a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L57:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L57;
            a r101 = (a) r100;
            if (this.f446133b == r101.f446133b) goto L13;
        L55:
            return false;
        L13:
            if (Float.compare(0.0f, 0.0f) != 0) goto L55;
            if (Float.compare(0.0f, 0.0f) != 0) goto L55;
            if (Float.compare(0.0f, 0.0f) != 0) goto L55;
            if (this.f446134c != r101.f446134c) goto L55;
            if (Float.compare(r101.f446136e, this.f446136e) != 0) goto L55;
            if (Float.compare(r101.f446137f, this.f446137f) != 0) goto L55;
            if (Float.compare(r101.f446138g, this.f446138g) != 0) goto L55;
            if (this.f446139h != r101.f446139h) goto L55;
            if (this.f446140i != r101.f446140i) goto L55;
            if (this.f446144m != r101.f446144m) goto L55;
            if (this.f446145n != r101.f446145n) goto L55;
            if (this.f446148q != r101.f446148q) goto L55;
            if (this.f446149r != r101.f446149r) goto L55;
            if (Objects.equals(this.f446132a, r101.f446132a) == false) goto L55;
            if (Objects.equals(this.f446135d, r101.f446135d) == false) goto L55;
            if (this.f446142k != r101.f446142k) goto L55;
            if (this.f446143l != r101.f446143l) goto L55;
            if (this.f446146o != r101.f446146o) goto L55;
            if (Objects.equals(this.f446147p, r101.f446147p) == false) goto L55;
            if (Arrays.equals(null, null) == false) goto L55;
            if (Arrays.equals(null, null) == false) goto L55;
            return true;
        }
    }

    static {
        f446124h = new LruCache(100);
    }

    public static void b() {
        f446124h.evictAll();
    }

    public final Layout a() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        CharSequence r100 = this.f446127c.f446135d;
        if ((r100 instanceof Spanned) == false) goto L10;
        Spanned r101 = (Spanned) r100;
        if (((com.ss.android.lark.widget.light.viewstub.h[]) r101.getSpans(0, r101.length(), com.ss.android.lark.widget.light.viewstub.h.class)).length != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L10;
        SpannableStringBuilder r103 = new SpannableStringBuilder(r100.toString());
        Spanned r104 = (Spanned) r100;
        Object[] r105 = r104.getSpans(0, r104.length(), Object.class);
        int r106 = r105.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L20;
        Object r108 = r105[r107];
        if ((r108 instanceof ViewHolderSpan) == true) goto L19;
        int r109 = r104.getSpanStart(r108);
        int r110 = r104.getSpanEnd(r108);
        int r111 = r104.getSpanFlags(r108);
        r103.setSpan(r108, r109, r110, r111);
        if ((r108 instanceof com.ss.android.lark.widget.light.viewstub.h) == false) goto L19;
        r103.setSpan(new ViewHolderSpan(this.f446127c.f446150s, (com.ss.android.lark.widget.light.viewstub.h) r108), r109, r110, r111);
    L19:
        r107 = r107 + 1;
        goto L12
    L20:
        h(r103);
        boolean r112 = true;
    L22:
        if (this.f446130f == false) goto L26;
        f r113 = this.f446128d;
        if (r113 == null) goto L26;
        return r113;
    L26:
        CharSequence r114 = this.f446127c.f446135d;
        if (r114 != null) goto L29;
    L75:
        return null;
    L29:
        if (r114.length() == 0) goto L31;
    L33:
        d r115 = new d(this.f446127c);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r115, "coordinator");
        CharSequence r116 = this.f446127c.f446135d;
        if ((r116 instanceof Spanned) == false) goto L36;
        Spanned r117 = (Spanned) r116;
    L37:
        if (r117 == null) goto L43;
        Iterator r118 = ArrayIteratorKt.iterator((ViewHolderSpan[]) r117.getSpans(0, r117.length(), ViewHolderSpan.class));
    L41:
        if (r118.hasNext() == false) goto L43;
        ((ViewHolderSpan) r118.next()).a().setTag(R.id.tag_text_layout_build_coordinator, r115);
    L43:
        boolean r119 = !r112;
        if (this.f446130f == false) goto L49;
        if (r119 == false) goto L49;
        int r120 = this.f446127c.hashCode();
        Layout r121 = f446124h.get(Integer.valueOf(r120));
        if (r121 == null) goto L50;
        return r121;
    L50:
        this.f446127c.getClass();
        a r122 = this.f446127c;
        int r123 = (int) Math.ceil(Layout.getDesiredWidth(r122.f446135d, r122.f446132a));
        a r124 = this.f446127c;
        int r125 = r123 + r124.f446134c;
        int r126 = Math.round((r124.f446132a.getFontMetricsInt(null) * r124.f446136e) + r124.f446137f);
        if (this.f446126b != 1) goto L53;
        int r127 = Math.min(r125, this.f446125a * r126);
    L54:
        f r128 = new f(Math.max(r127, 0), this.f446127c);
        monitor-enter(r115);
        Intrinsics.checkNotNullParameter(r128, "layout");     // Catch: Throwable -> L72
        Iterator r129 = ((ArrayList) r115.f446155b).iterator();     // Catch: Throwable -> L72
    L58:
        if (r129.hasNext() == false) goto L60;
        ((Function1) r129.next()).invoke(r128);     // Catch: Throwable -> L72
        goto L58
    L60:
        ((ArrayList) r115.f446155b).clear();     // Catch: Throwable -> L72
        monitor-exit(r115);
        if (this.f446130f == false) goto L66;
        if (r119 == false) goto L66;
        this.f446128d = r128;
        f446124h.put(Integer.valueOf(r120), r128);
    L66:
        this.f446127c.f446149r = true;
        if (this.f446131g == false) goto L71;
        b r130 = this.f446129e;
        if (r130 == null) goto L71;
        r130.a(r128);
    L71:
        return r128;
    L72:
        th = move-exception;
        throw th;
    L53:
        r127 = Math.min(r125, this.f446125a);
    L49:
        r120 = -1;
        goto L50
    L36:
        r117 = null;
        goto L37
    L31:
        if (this.f446127c.f446141j == true) goto L33;
    L8:
        r102 = false;
    L10:
        r112 = false;
        goto L22
    }

    public TextLayoutBuilder() {
        this.f446125a = Integer.MAX_VALUE;
        this.f446126b = 2;
        this.f446127c = new a();
        this.f446128d = null;
        this.f446130f = true;
        this.f446131g = false;
    }

    public final void c(Layout.Alignment r100) {
        a r101 = this.f446127c;
        if (r101.f446146o == r100) goto L6;
        r101.f446146o = r100;
        this.f446128d = null;
        return;
    }

    public final void d(TextUtils.TruncateAt r100) {
        a r101 = this.f446127c;
        if (r101.f446142k == r100) goto L6;
        r101.f446142k = r100;
        this.f446128d = null;
        return;
    }

    public final void e(int r100) {
        a r101 = this.f446127c;
        if (r101.f446145n == r100) goto L6;
        r101.f446145n = r100;
        this.f446128d = null;
        return;
    }

    public final void f(int r100) {
        this.f446125a = r100;
        this.f446126b = 2;
        this.f446127c.f446133b = r100;
    }

    public final void g(boolean r100) {
        a r101 = this.f446127c;
        if (r101.f446141j == r100) goto L8;
        r101.f446141j = r100;
        if (r101.f446135d.length() != 0) goto L9;
        this.f446128d = null;
        return;
    L9:
        return;
    }

    public final void h(CharSequence r100) {
        if (r100 != this.f446127c.f446135d) goto L6;
        return;
    L6:
        if ((r100 instanceof SpannableStringBuilder) == true) goto L18;
    L12:
        if (r100 != null) goto L14;
    L16:
        this.f446127c.f446135d = r100;
        this.f446128d = null;
        return;
    L14:
        if (r100.equals(this.f446127c.f446135d) == false) goto L16;
        return;
    L18:
        r100.hashCode();     // Catch: NullPointerException -> L9
    L9:
        e = move-exception;
        throw new IllegalArgumentException("The given text contains a null span. Due to an Android framework bug, this will cause an exception later down the line.", e);
    }

    public final void i(int r100) {
        this.f446127c.a();
        a r101 = this.f446127c;
        r101.getClass();
        r101.f446132a.setColor(r100);
        this.f446128d = null;
    }

    public final void j(int r100) {
        float r101 = r100;
        if (this.f446127c.f446132a.getTextSize() == r101) goto L6;
        this.f446127c.a();
        this.f446127c.f446132a.setTextSize(r101);
        this.f446128d = null;
        return;
    }

    public final void k(float r100) {
        a r101 = this.f446127c;
        if (r101.f446138g == Float.MAX_VALUE) goto L5;
        return;
    L5:
        if (r101.f446137f == r100) goto L9;
        r101.f446137f = r100;
        this.f446128d = null;
        return;
    }

    public final void l(float r100) {
        a r101 = this.f446127c;
        if (r101.f446138g == Float.MAX_VALUE) goto L5;
        return;
    L5:
        if (r101.f446136e == r100) goto L9;
        r101.f446136e = r100;
        this.f446128d = null;
        return;
    }

    public final void m(Typeface r100) {
        if (this.f446127c.f446132a.getTypeface() == r100) goto L6;
        this.f446127c.a();
        this.f446127c.f446132a.setTypeface(r100);
        this.f446128d = null;
        return;
    }
}
