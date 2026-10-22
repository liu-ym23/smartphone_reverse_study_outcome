package com.larksuite.component.ui.imageview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import h18.e;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class LKUIBadgeDrawable2 extends Drawable implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f284145i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f284146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f284147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f284148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f284149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f284150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<View> f284151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f284152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f284153h;

    public static final class a {
        @JvmStatic
        public static LKUIBadgeDrawable2 a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r101 < 0) goto L6;
            if (r101 >= 2) goto L6;
            boolean r102 = true;
        L7:
            if (r102 == false) goto L19;
            Object r103 = r100.getTag(R.id.lkui_tag_key_view_badge_drawable);
            if (r103 != null) goto L11;
        L12:
            r103 = new LKUIBadgeDrawable2[2];
        L13:
            LKUIBadgeDrawable2[] r104 = (LKUIBadgeDrawable2[]) r103;
            if (r104[r101] != null) goto L16;
            r104[r101] = new LKUIBadgeDrawable2(r100);
        L16:
            r100.setTag(R.id.lkui_tag_key_view_badge_drawable, r104);
            LKUIBadgeDrawable2 r105 = r104[r101];
            Intrinsics.checkNotNull(r105);
            return r105;
        L11:
            if ((r103 instanceof Object[]) == true) goto L13;
        L19:
            throw new IndexOutOfBoundsException("only support 2 badge");
        L6:
            r102 = false;
            goto L7
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LKUIBadgeDrawable2 f284154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f284155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f284156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f284157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f284158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f284159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f284160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f284161h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Drawable f284162i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f284163j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f284164k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ LKUIBadgeDrawable2 f284165l;

        public final LKUIBadgeDrawable2 a() {
            LKUIBadgeDrawable2 r100 = this.f284154a;
            WeakReference<View> r101 = r100.f284151f;
            View r102 = null;
            if (r101 == null) goto L5;
            View r103 = r101.get();
        L7:
            if (Intrinsics.areEqual(this, r100.a()) == true) goto L25;
            if (r103 == null) goto L25;
            b r104 = r100.a();
            r104.getClass();
            Intrinsics.checkNotNullParameter(this, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            r104.f284155b = this.f284155b;
            r104.f284156c = this.f284156c;
            r104.f284159f = this.f284159f;
            r104.f284157d = this.f284157d;
            r104.f284158e = this.f284158e;
            r104.f284161h = this.f284161h;
            r104.f284160g = this.f284160g;
            r104.f284162i = this.f284162i;
            r104.f284163j = this.f284163j;
            r104.f284164k = this.f284164k;
            WeakReference<View> r105 = r100.f284151f;
            if (r105 == null) goto L13;
            r102 = r105.get();
        L13:
            if (r102 != null) goto L15;
        L17:
            boolean r106 = false;
        L18:
            if (r106 == true) goto L23;
            ViewGroup r107 = (ViewGroup) r103.getParent();
            if (r107 == null) goto L22;
            r103 = r107;
        L22:
            r103.getOverlay().remove(r100);
            r103.getOverlay().add(r100);
            r100.f284153h = true;
            r100.d();
            r103.addOnLayoutChangeListener(r100);
            goto L25
        L23:
            r100.d();
            goto L25
        L15:
            if (r100.f284153h == false) goto L17;
            r106 = true;
        L25:
            return this.f284154a;
        L5:
            r103 = null;
            goto L7
        }

        public final int hashCode() {
            int r100 = this.f284154a.hashCode() * 31;
            String r101 = this.f284155b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (((((((((r100 + r103) * 31) + Float.floatToIntBits(this.f284156c)) * 31) + Float.floatToIntBits(this.f284157d)) * 31) + Float.floatToIntBits(this.f284158e)) * 31) + this.f284159f) * 31;
            Drawable r105 = this.f284160g;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (((r104 + r106) * 31) + Float.floatToIntBits(this.f284161h)) * 31;
            Drawable r108 = this.f284162i;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return ((((r107 + r102) * 31) + this.f284163j) * 31) + this.f284164k;
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.imageview.LKUIBadgeDrawable2.Model");
            b r102 = (b) r100;
            if (Intrinsics.areEqual(this.f284154a, r102.f284154a) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f284155b, r102.f284155b) == true) goto L19;
            return false;
        L19:
            if (this.f284156c != r102.f284156c) goto L21;
            boolean r103 = true;
        L22:
            if (r103 == true) goto L25;
            return false;
        L25:
            if (this.f284157d != r102.f284157d) goto L27;
            boolean r104 = true;
        L28:
            if (r104 == true) goto L31;
            return false;
        L31:
            if (this.f284158e != r102.f284158e) goto L33;
            boolean r105 = true;
        L34:
            if (r105 == true) goto L37;
            return false;
        L37:
            if (this.f284159f == r102.f284159f) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.f284160g, r102.f284160g) == true) goto L43;
            return false;
        L43:
            if (this.f284161h != r102.f284161h) goto L45;
            boolean r106 = true;
        L46:
            if (r106 == true) goto L49;
            return false;
        L49:
            if (Intrinsics.areEqual(this.f284162i, r102.f284162i) == true) goto L52;
            return false;
        L52:
            if (this.f284163j == r102.f284163j) goto L55;
            return false;
        L55:
            if (this.f284164k == r102.f284164k) goto L57;
            return false;
        L57:
            return true;
        L45:
            r106 = false;
            goto L46
        L33:
            r105 = false;
            goto L34
        L27:
            r104 = false;
            goto L28
        L21:
            r103 = false;
            goto L22
        L8:
            r101 = null;
            goto L10
        }

        public b(LKUIBadgeDrawable2 r100, LKUIBadgeDrawable2 r101) {
            Intrinsics.checkNotNullParameter(r101, "drawable");
            this.f284165l = r100;
            this.f284154a = r101;
            this.f284156c = 10.0f;
            this.f284157d = 15.0f;
            this.f284158e = 10.0f;
            this.f284159f = -1;
            this.f284163j = 1;
            this.f284164k = 3;
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final b a() {
        return (b) this.f284149d.getValue();
    }

    public final com.larksuite.component.ui.imageview.b b() {
        return (com.larksuite.component.ui.imageview.b) this.f284152g.getValue();
    }

    public final b c() {
        b r100 = (b) this.f284150e.getValue();
        r100.f284155b = null;
        r100.f284156c = 10.0f;
        r100.f284157d = 15.0f;
        r100.f284158e = 10.0f;
        r100.f284161h = 0.0f;
        r100.f284159f = -1;
        r100.f284160g = null;
        r100.f284162i = null;
        r100.f284163j = 1;
        r100.f284164k = 3;
        return (b) this.f284150e.getValue();
    }

    public final void d() {
        WeakReference<View> r100 = this.f284151f;
        if (r100 == null) goto L71;
        View r101 = r100.get();
        if (r101 == null) goto L72;
        Rect r102 = new Rect();
        r101.getDrawingRect(r102);
        ViewGroup r103 = (ViewGroup) r101.getParent();
        if (r103 == null) goto L10;
        r103.offsetDescendantRectToMyCoords(r101, r102);
    L10:
        if (r102.isEmpty() == false) goto L12;
        return;
    L12:
        int r104 = r101.getPaddingLeft();
        int r105 = r101.getPaddingTop();
        int r106 = r101.getPaddingRight();
        int r107 = r101.getPaddingBottom();
        com.larksuite.component.ui.imageview.b r108 = b();
        String r109 = a().f284155b;
        if (Intrinsics.areEqual(r108.f284188b, r109) == true) goto L15;
        r108.f284189c = -1.0f;
        r108.f284188b = r109;
    L15:
        com.larksuite.component.ui.imageview.b r110 = b();
        float r111 = a().f284156c;
        if (r110.f284187a.getTextSize() != r111) goto L18;
        boolean r112 = true;
    L19:
        if (r112 == true) goto L21;
        r110.f284187a.setTextSize(r111);
        r110.f284189c = -1.0f;
        r110.f284190d = -1.0f;
    L21:
        float r113 = b().a();
        com.larksuite.component.ui.imageview.b r114 = b();
        float r115 = r114.f284190d;
        if (r115 > 0.0f) goto L25;
        Paint.FontMetrics r116 = r114.f284187a.getFontMetrics();
        r115 = r116.descent - r116.ascent;
    L25:
        Drawable r117 = a().f284160g;
        if (r117 == null) goto L28;
        float r118 = r117.getIntrinsicWidth();
    L29:
        Drawable r119 = a().f284160g;
        if (r119 == null) goto L32;
        float r120 = r119.getIntrinsicHeight();
    L33:
        Drawable r121 = a().f284162i;
        if (r121 == null) goto L36;
        float r122 = r121.getIntrinsicWidth();
    L37:
        Drawable r123 = a().f284162i;
        if (r123 == null) goto L40;
        float r124 = r123.getIntrinsicHeight();
    L42:
        if (r113 <= 0.0f) goto L44;
        float r125 = 2;
        float r126 = Math.max(r113 + (a().f284157d * r125), r122) / r125;
        float r127 = Math.max(r115 + (a().f284158e * r125), r124) / r125;
    L45:
        this.f284147b = r102.right - r106;
        if (a().f284163j != 1) goto L48;
        float r128 = r102.top + r105;
    L49:
        this.f284148c = r128;
        if (a().f284164k != 2) goto L57;
        this.f284147b -= r126;
        float r129 = this.f284148c;
        if (a().f284163j != 1) goto L54;
        float r130 = r127;
    L55:
        this.f284148c = r129 + r130;
    L63:
        Drawable r131 = a().f284162i;
        if (r131 == null) goto L66;
        float r132 = this.f284147b;
        float r133 = this.f284148c;
        r131.setBounds((int) (r132 - r126), (int) (r133 - r127), (int) (r132 + r126), (int) (r133 + r127));
    L66:
        Drawable r134 = a().f284160g;
        if (r134 == null) goto L69;
        float r135 = this.f284147b;
        float r136 = 2;
        float r137 = r118 / r136;
        float r138 = this.f284148c;
        float r139 = r120 / r136;
        r134.setBounds((int) (r135 - r137), (int) (r138 - r139), (int) (r135 + r137), (int) (r138 + r139));
    L69:
        Rect r140 = (Rect) this.f284146a.getValue();
        float r141 = this.f284147b;
        float r142 = this.f284148c;
        r140.set((int) (r141 - r126), (int) (r142 - r127), (int) (r141 + r126), (int) (r142 + r127));
        invalidateSelf();
        return;
    L54:
        r130 = -r127;
        goto L55
    L57:
        if (a().f284164k != 3) goto L63;
        this.f284147b -= (((r102.width() - r104) - r106) / 2) * 0.2929f;
        float r143 = (((r102.height() - r105) - r107) / 2) * 0.2929f;
        float r144 = this.f284148c;
        if (a().f284163j == 1) goto L62;
        r143 = -r143;
    L62:
        this.f284148c = r144 + r143;
        goto L63
    L48:
        r128 = r102.bottom - r107;
        goto L49
    L44:
        float r145 = 2;
        r126 = Math.max(r118, r122) / r145;
        r127 = Math.max(r120, r124) / r145;
        goto L45
    L40:
        r124 = 0.0f;
        goto L42
    L36:
        r122 = 0.0f;
        goto L37
    L32:
        r120 = 0.0f;
        goto L33
    L28:
        r118 = 0.0f;
        goto L29
    L18:
        r112 = false;
        goto L19
    L72:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((Rect) this.f284146a.getValue()).height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((Rect) this.f284146a.getValue()).width();
    }

    public LKUIBadgeDrawable2() {
        this.f284146a = LazyKt.lazy(LKUIBadgeDrawable2$badgeBounds$2.INSTANCE);
        this.f284149d = LazyKt.lazy(new LKUIBadgeDrawable2$currentModel$2(this));
        this.f284150e = LazyKt.lazy(new LKUIBadgeDrawable2$updateModel$2(this));
        this.f284152g = LazyKt.lazy(LKUIBadgeDrawable2$textDrawableHelper$2.INSTANCE);
    }

    public LKUIBadgeDrawable2(View r100) {
        this();
        this.f284151f = new WeakReference(r100);
        com.larksuite.component.ui.imageview.b r101 = b();
        int r102 = e.f483540a;
        Typeface r103 = e.a(r100.getContext());
        r101.f284187a.setTypeface(r103);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (isVisible() == false) goto L39;
        WeakReference<View> r101 = this.f284151f;
        if (r101 == null) goto L7;
        View r102 = r101.get();
    L8:
        boolean r103 = false;
        if (r102 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L42;
        Drawable r105 = a().f284162i;
        if (r105 == null) goto L19;
        r105.draw(r100);
    L19:
        Drawable r106 = a().f284160g;
        if (r106 == null) goto L22;
        r106.draw(r100);
    L22:
        String r107 = a().f284155b;
        if (r107 != null) goto L25;
    L28:
        boolean r108 = true;
    L30:
        if ((!r108) == false) goto L40;
        com.larksuite.component.ui.imageview.b r109 = b();
        r109.f284187a.setColor(a().f284159f);
        com.larksuite.component.ui.imageview.b r110 = b();
        int r111 = ((Rect) this.f284146a.getValue()).centerX();
        int r112 = ((Rect) this.f284146a.getValue()).centerY();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
        CharSequence r113 = r110.f284188b;
        if (r113 != null) goto L34;
    L35:
        r103 = true;
    L36:
        if (r103 == true) goto L41;
        r110.f284187a.setTextAlign(Paint.Align.CENTER);
        CharSequence r114 = r110.f284188b;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.String");
        r100.drawText((String) r114, r111, r112 - ((r110.f284187a.descent() + r110.f284187a.ascent()) / 2), r110.f284187a);
        return;
    L41:
        return;
    L34:
        if (r113.length() != 0) goto L36;
    L40:
        return;
    L25:
        if (r107.length() == 0) goto L28;
        r108 = false;
        goto L30
    L42:
        return;
    L11:
        if (this.f284153h == false) goto L13;
        r104 = true;
        goto L14
    L7:
        r102 = null;
        goto L8
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        d();
    }
}
