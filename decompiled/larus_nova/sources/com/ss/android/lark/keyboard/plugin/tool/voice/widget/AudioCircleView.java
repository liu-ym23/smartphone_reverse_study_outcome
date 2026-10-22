package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class AudioCircleView extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f430865s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f430866t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f430867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f430868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f430869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f430870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f430871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f430872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f430873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f430874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f430875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f430876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f430877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f430878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f430879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f430880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f430881o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f430882p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f430883q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f430884r;

    static {
        f430865s = UIHelper.getColor(R.color.primary_pri_400);
        f430866t = UIHelper.getColor(R.color.primary_content_default);
        UIHelper.getColor(R.color.ud_R400);
        UIHelper.getColor(R.color.ud_R500);
    }

    public RectF getInnerBound() {
        return this.f430879m;
    }

    public float getScale() {
        return this.f430876j;
    }

    public AudioCircleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = getMeasuredWidth() / 2;
        int r102 = getMeasuredHeight() - r101;
        float r103 = this.f430872f;
        if (r103 <= this.f430870d) goto L5;
        r100.drawCircle(r101, r102, r103, this.f430869c);
    L5:
        float r104 = this.f430871e;
        if (r104 <= this.f430870d) goto L8;
        r100.drawCircle(r101, r102, r104, this.f430868b);
    L8:
        float r105 = r101;
        float r106 = r102;
        r100.drawCircle(r105, r106, this.f430870d * this.f430876j, this.f430867a);
        Drawable r107 = this.f430875i;
        r107.setBounds(r101 - (r107.getIntrinsicWidth() / 2), r102 - (this.f430875i.getIntrinsicHeight() / 2), r101 + (this.f430875i.getIntrinsicWidth() / 2), r102 + (this.f430875i.getIntrinsicHeight() / 2));
        this.f430875i.draw(r100);
        RectF r108 = this.f430879m;
        float r109 = this.f430870d;
        r108.set(r105 - r109, r106 - r109, r105 + r109, r106 + r109);
    }

    public void setAmplitudeAnimate(final int r100) {
        post(new vob.a(this, r100));
    }

    public void setIcon(int r100) {
        Drawable r101 = UIUtils.getDrawable(getContext(), r100);
        this.f430875i = r101;
        r101.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.static_white), PorterDuff.Mode.SRC_ATOP));
        invalidate();
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        Paint r101 = this.f430867a;
        Resources r102 = getResources();
        if (r100 == false) goto L5;
        int r103 = R.color.function_info_fill_solid_01;
    L6:
        r101.setColorFilter(new PorterDuffColorFilter(r102.getColor(r103), PorterDuff.Mode.SRC_ATOP));
        return;
    L5:
        r103 = R.color.lkui_transparent;
        goto L6
    }

    public void setRadius(int r100) {
        this.f430870d = r100;
        invalidate();
    }

    public void setScale(float r100) {
        this.f430876j = r100;
        invalidate();
    }

    public AudioCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AudioCircleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f430867a = new Paint(1);
        this.f430868b = new Paint(1);
        this.f430869c = new Paint(1);
        this.f430870d = UIHelper.dp2px(60.0f);
        this.f430871e = 0.0f;
        this.f430872f = 0.0f;
        this.f430873g = UIHelper.dp2px(40.0f);
        this.f430874h = UIHelper.dp2px(0.0f);
        this.f430876j = 1.0f;
        this.f430879m = new RectF();
        this.f430880n = f430865s;
        this.f430881o = f430866t;
        this.f430882p = new float[]{0.0f, 1.0f};
        this.f430883q = 0.0f;
        Drawable r103 = UIUtils.getDrawable(getContext(), R.drawable.ud_icon_voice_outlined);
        this.f430875i = r103;
        r103.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.static_white), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r110, int r111, int r112, int r113) {
        super.onSizeChanged(r110, r111, r112, r113);
        int r114 = r110 / 2;
        this.f430877k = r114;
        int r115 = r111 - r114;
        this.f430878l = r115;
        int r116 = this.f430880n;
        int r100 = this.f430881o;
        this.f430867a.setShader(new RadialGradient(this.f430877k, this.f430878l, this.f430870d, new int[]{r116, r100}, this.f430882p, Shader.TileMode.CLAMP));
        float r117 = r114;
        float r101 = this.f430871e;
        float r102 = this.f430873g;
        float r118 = r115;
        this.f430868b.setShader(new LinearGradient((r117 - r101) - r102, (r118 + r101) + r102, (r117 + r101) + r102, (r118 - r101) - r102, r116, r100, Shader.TileMode.CLAMP));
        this.f430868b.setAlpha(25);
        float r103 = this.f430872f;
        float r104 = this.f430874h;
        this.f430869c.setShader(new LinearGradient((r117 - r103) - r104, (r118 + r103) + r104, (r117 + r103) + r104, (r118 - r103) - r104, r116, r100, Shader.TileMode.CLAMP));
        this.f430869c.setAlpha(51);
    }
}
