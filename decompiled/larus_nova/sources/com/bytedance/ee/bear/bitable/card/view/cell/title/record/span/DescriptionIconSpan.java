package com.bytedance.ee.bear.bitable.card.view.cell.title.record.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.style.ImageSpan;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class DescriptionIconSpan extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f208280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DescriptionIconState f208281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f208282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f208283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f208284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f208285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f208286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f208287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f208288i;

    public static final enum DescriptionIconState extends Enum<DescriptionIconState> {
        public static final DescriptionIconState STATE_NORMAL = null;
        public static final DescriptionIconState STATE_PRESS = null;
        public static final DescriptionIconState STATE_SELECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DescriptionIconState[] f208289a = null;

        static {
            DescriptionIconState r100 = new DescriptionIconState("STATE_NORMAL", 0);
            STATE_NORMAL = r100;
            DescriptionIconState r101 = new DescriptionIconState("STATE_PRESS", 1);
            STATE_PRESS = r101;
            DescriptionIconState r102 = new DescriptionIconState("STATE_SELECT", 2);
            STATE_SELECT = r102;
            f208289a = new DescriptionIconState[]{r100, r101, r102};
        }

        public static DescriptionIconState[] values() {
            return (DescriptionIconState[]) f208289a.clone();
        }

        public static DescriptionIconState valueOf(String r100) {
            return (DescriptionIconState) r27.a.a(DescriptionIconState.class, r100);
        }

        public DescriptionIconState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f208290a = null;

        static {
            int[] r100 = new int[DescriptionIconState.values().length];
            f208290a = r100;
            r100[DescriptionIconState.STATE_SELECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f208290a[DescriptionIconState.STATE_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f208290a[DescriptionIconState.STATE_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final Drawable a() {
        if (this.f208282c != null) goto L6;
        Drawable r100 = this.f208280a.getResources().getDrawable(this.f208285f).mutate();
        int r101 = this.f208287h;
        r100.setBounds(0, 0, r101, r101);
        r100.setTint(this.f208280a.getResources().getColor(R.color.icon_n2));
        GradientDrawable r102 = (GradientDrawable) this.f208280a.getDrawable(R.drawable.bitable_description_icon_bg).mutate();
        int r103 = this.f208286g;
        r102.setBounds(0, 0, r103, r103);
        r102.setColor(this.f208280a.getResources().getColor(R.color.lkui_transparent));
        LayerDrawable r104 = new LayerDrawable(new Drawable[]{r102, r100});
        int r105 = (this.f208286g - this.f208287h) / 2;
        r104.setLayerInset(1, r105, r105, r105, r105);
        int r106 = this.f208286g;
        r104.setBounds(0, 0, r106, r106);
        this.f208282c = r104;
    L6:
        return this.f208282c;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        DescriptionIconState r100 = this.f208281b;
        if (r100 == null) goto L23;
        int r101 = a.f208290a[r100.ordinal()];
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L23;
        return a();
    L13:
        if (this.f208283d != null) goto L16;
        Drawable r102 = this.f208280a.getResources().getDrawable(this.f208285f).mutate();
        int r103 = this.f208287h;
        r102.setBounds(0, 0, r103, r103);
        r102.setTint(this.f208280a.getResources().getColor(R.color.icon_n2));
        GradientDrawable r104 = (GradientDrawable) this.f208280a.getDrawable(R.drawable.bitable_description_icon_bg).mutate();
        int r105 = this.f208286g;
        r104.setBounds(0, 0, r105, r105);
        r104.setColor(this.f208280a.getResources().getColor(R.color.udtoken_btn_text_bg_neutral_hover));
        r104.setAlpha(25);
        LayerDrawable r106 = new LayerDrawable(new Drawable[]{r104, r102});
        int r110 = (this.f208286g - this.f208287h) / 2;
        r106.setLayerInset(1, r110, r110, r110, r110);
        int r107 = this.f208286g;
        r106.setBounds(0, 0, r107, r107);
        this.f208283d = r106;
    L16:
        return this.f208283d;
    L18:
        if (this.f208284e != null) goto L21;
        Drawable r108 = this.f208280a.getResources().getDrawable(this.f208285f).mutate();
        int r109 = this.f208287h;
        r108.setBounds(0, 0, r109, r109);
        r108.setTint(this.f208280a.getResources().getColor(R.color.primary_fill_default));
        GradientDrawable r111 = (GradientDrawable) this.f208280a.getDrawable(R.drawable.bitable_description_icon_bg).mutate();
        int r112 = this.f208286g;
        r111.setBounds(0, 0, r112, r112);
        r111.setColor(this.f208280a.getResources().getColor(R.color.primary_fill_default));
        r111.setAlpha(25);
        LayerDrawable r113 = new LayerDrawable(new Drawable[]{r111, r108});
        int r114 = (this.f208286g - this.f208287h) / 2;
        r113.setLayerInset(1, r114, r114, r114, r114);
        int r115 = this.f208286g;
        r113.setBounds(0, 0, r115, r115);
        this.f208284e = r113;
    L21:
        return this.f208284e;
    L23:
        return a();
    }

    public DescriptionIconSpan(Context r100, int r101) {
        super(r100, R.drawable.ud_icon_info_outlined);
        this.f208280a = r100;
        this.f208285f = R.drawable.ud_icon_info_outlined;
        this.f208287h = r100.getResources().getDimensionPixelSize(r101);
        this.f208286g = r100.getResources().getDimensionPixelSize(R.dimen.bitable_descrpition_bg_size);
        this.f208288i = r100.getResources().getDimensionPixelSize(R.dimen.bitable_descrpition_icon_space);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return r105.right + this.f208288i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Drawable r108 = getDrawable();
        r100.save();
        int r109 = r107 - r108.getBounds().bottom;
        int r111 = ((ImageSpan) this).mVerticalAlignment;
        if (r111 != 1) goto L5;
        r109 = r109 - r110.getFontMetricsInt().descent;
    L7:
        int r112 = 0;
        if (r104 <= 0.0f) goto L10;
        r112 = Math.max(0, this.f208288i - ((this.f208286g - this.f208287h) / 2));
    L10:
        r100.translate(r104 + r112, r109);
        r108.draw(r100);
        r100.restore();
        return;
    L5:
        if (r111 != 2) goto L7;
        r109 = ((r107 - r105) / 2) - (r108.getBounds().height() / 2);
        goto L7
    }
}
