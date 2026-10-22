package com.larus.common_ui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.c7;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0011H\u0007J\b\u0010\u001e\u001a\u00020\u0011H\u0007J\u0012\u0010\u001f\u001a\u00020\u001b2\n\u0010 \u001a\u00020!\"\u00020\u0007J\u0017\u0010\"\u001a\u00020\u001b2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001bH\u0002J\u0016\u0010\u0016\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020\u001bJ(\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0014J\u0012\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u000fH\u0002R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/common_ui/blur/BlurView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "circleRectHeight", "getCircleRectHeight", "()I", "blurCircleDrawable", "Lcom/larus/common_ui/blur/BlurCircleDrawable;", "radiusWidthRatio", "", "defaultRoundRectWidthPx", "roundRectWidthPx", "roundRectHeightPx", "roundRectRadiusPx", "showHighlight", "", "highlightRadius", "blurCircleHighlight", "setGoldHighLightColor", "", "setCircleScale", "scale", "getCircleScale", "setCircleColor", "color", "", "setRoundRectWidthOverride", "widthPx", "(Ljava/lang/Float;)V", "applyRoundRectGeometry", "centerX", "centerY", "dismissHighlight", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "updateHighlightRoundRectSize", "highlightDrawable", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BlurView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f326867k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f326868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f326869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f326870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f326871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f326872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f326873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f326874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f326875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f326876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f326877j;

    public static final class a {
        public a() {
        }

        public static final int a(int... r100) {
            int r101 = BlurView.f326867k;
            int r102 = 0;
            if (r100.length != 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            return 0;
        L9:
            if (r100.length == 1) goto L26;
            int r104 = r100.length;
            int r105 = 0;
        L12:
            if (r102 >= r104) goto L21;
            int r106 = r100[r102];
            if (r106 == 0) goto L19;
            if (r105 != 0) goto L18;
            r105 = r106;
            goto L19
        L18:
            r105 = ColorUtils.blendARGB(r105, Color.rgb(Color.red(r106), Color.green(r106), Color.blue(r106)), Color.alpha(r106) / 255.0f);
        L19:
            r102 = r102 + 1;
            goto L12
        L21:
            return r105;
        L26:
            return r100[0];
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
        new a();
    }

    public BlurView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BlurView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f326877j != null) goto L5;
        return;
    L5:
        this.f326875h = false;
        invalidate();
        b r100 = this.f326877j;
        if (r100 == null) goto L9;
        r100.invalidateSelf();
        return;
    }

    public final float getCircleScale() {
        return this.f326869b.f326891h;
    }

    public final int getCircleRectHeight() {
        return this.f326868a;
    }

    public final void c(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        float r101 = (getWidth() * this.f326870c) * this.f326869b.f326891h;
        if (r101 <= 0.0f) goto L7;
        float r102 = this.f326876i / r101;
    L8:
        float r103 = this.f326872e * r102;
        float r104 = this.f326873f * r102;
        float r105 = this.f326874g * r102;
        r100.f326892i = r103;
        r100.f326893j = r104;
        r100.f326894k = r105;
        r100.invalidateSelf();
        return;
    L7:
        r102 = 1.0f;
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f326875h == true) goto L5;
    L12:
        this.f326869b.draw(r100);
        return;
    L5:
        if (this.f326877j == null) goto L12;
        int r101 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        this.f326869b.draw(r100);
        b r102 = this.f326877j;
        if (r102 == null) goto L10;
        r102.draw(r100);
    L10:
        r100.restoreToCount(r101);
    }

    public final void setCircleColor(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        int r101 = a.a(Arrays.copyOf(r100, r100.length));
        if (r101 == 0) goto L6;
        b r102 = this.f326869b;
        r102.getClass();
        Bitmap r103 = Bitmap.createBitmap(new int[]{r101}, 1, 1, Bitmap.Config.ARGB_8888);
        Paint r104 = r102.f326887d;
        Shader.TileMode r105 = Shader.TileMode.CLAMP;
        r104.setShader(new BitmapShader(r103, r105, r105));
        r102.invalidateSelf();
        return;
    }

    public final void setCircleScale(float r100) {
        this.f326869b.a(r100);
        c(this.f326877j);
    }

    public final void setRoundRectWidthOverride(Float r100) {
        boolean r101 = false;
        if (r100 == null) goto L20;
        float r102 = r100.floatValue();
        if (Float.isInfinite(r102) == false) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L20;
        float r105 = r100.floatValue();
    L22:
        if (this.f326872e != r105) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L26;
        return;
    L26:
        this.f326872e = r105;
        b r106 = this.f326869b;
        float r107 = this.f326873f;
        float r108 = this.f326874g;
        r106.f326892i = r105;
        r106.f326893j = r107;
        r106.f326894k = r108;
        r106.invalidateSelf();
        c(this.f326877j);
        return;
    L12:
        if (r102 <= 0.0f) goto L14;
        r104 = true;
        goto L15
    L7:
        if (Float.isNaN(r102) == true) goto L9;
        r103 = true;
    L20:
        r105 = this.f326871d;
        goto L22
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f326869b) goto L10;
        if (r100 == this.f326877j) goto L10;
        return false;
    }

    public final void b(float r100, float r101) {
        b r102 = this.f326877j;
        if (r102 != null) goto L5;
        return;
    L5:
        this.f326875h = true;
        if (r102 == null) goto L8;
        float r103 = this.f326876i;
        r102.setBounds((int) (r100 - r103), (int) (r101 - r103), (int) (r100 + r103), (int) (r101 + r103));
    L8:
        b r104 = this.f326877j;
        if (r104 == null) goto L12;
        r104.invalidateSelf();
        return;
    }

    public BlurView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        float r100 = c7.b(Float.valueOf(476.0f));
        this.f326871d = r100;
        this.f326872e = r100;
        float r101 = c7.b(Float.valueOf(471.0f));
        this.f326873f = r101;
        float r102 = c7.b(Float.valueOf(193.0f));
        this.f326874g = r102;
        TypedArray r103 = r210.obtainStyledAttributes(r211, new int[]{R.attr.larus_circle_blurRadius, R.attr.larus_circle_coverColor, R.attr.larus_circle_highlightColor, R.attr.larus_circle_highlightRadius, R.attr.larus_circle_highlightShow, R.attr.larus_circle_radiusRatio, R.attr.larus_circle_rectHeight, R.attr.larus_circle_scale, R.attr.larus_circle_shadowColor});
        int r104 = r103.getColor(8, ContextCompat.getColor(r210, c.b(R.attr.larus_primary_50, r210, R.color.larus_primary_50)));
        int r105 = r103.getColor(1, 654311423);
        float r110 = r103.getFloat(5, 0.923f);
        this.f326870c = r110;
        int r111 = (int) r103.getDimension(6, r103.getResources().getDimension(c.b(R.attr.larus_dp_120, null, R.dimen.larus_dp_120)));
        this.f326868a = r111;
        float r106 = r103.getFloat(7, 1.0f);
        float r112 = r103.getDimension(0, r103.getResources().getDimension(c.b(R.attr.larus_dp_60, null, R.dimen.larus_dp_60)));
        this.f326875h = r103.getBoolean(4, false);
        float r107 = r103.getDimension(3, 0.0f);
        this.f326876i = r107;
        int r113 = r103.getColor(2, -14846990);
        r103.recycle();
        b r108 = new b(a.a(new int[]{r104, r105}), r112, r110, r111, null);
        this.f326869b = r108;
        r108.a(r106);
        r108.setCallback(this);
        if (r107 > 0.0f) goto L5;
        this.f326877j = null;
    L8:
        r108.f326892i = this.f326872e;
        r108.f326893j = r101;
        r108.f326894k = r102;
        r108.invalidateSelf();
        c(this.f326877j);
        if (Build.VERSION.SDK_INT >= 28) goto L12;
        setLayerType(1, null);
        return;
    L12:
        return;
    L5:
        int r109 = (int) (2 * r107);
        b r114 = new b(r113, r107, 0.5f, r109, new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f326877j = r114;
        c(r114);
        b r115 = this.f326877j;
        if (r115 == null) goto L8;
        r115.setBounds(0, 0, r109, r109);
        goto L8
    }

    public /* synthetic */ BlurView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f326869b.setBounds(0, 0, r100, r101);
        c(this.f326877j);
    }
}
