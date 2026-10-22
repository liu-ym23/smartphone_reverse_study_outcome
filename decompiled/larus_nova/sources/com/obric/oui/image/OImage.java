package com.obric.oui.image;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import cma.b;
import cma.c;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/image/OImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/image/OImageShape;", "shape", "", "setImageShape", "", "radiusDp", "setRadiusDp", "radiusPx", "setRadiusPx", "getImageShape", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OImage extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f401066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f401067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f401068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f401069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f401070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f401071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f401072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OImageShape f401073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f401074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f401075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f401076k;

    public static final class a {
    }

    static {
    }

    public OImage(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OImage(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final OImageShape getImageShape() {
        return this.f401073h;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = getWidth();
        float r102 = getHeight();
        if (r101 <= 0.0f) goto L32;
        if (r102 <= 0.0f) goto L32;
        this.f401067b.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f401067b.isEmpty() == false) goto L11;
        Intrinsics.stringPlus("Skip draw due to empty clip bounds rect=", this.f401067b);
        return;
    L11:
        boolean r103 = this.f401070e.f24240b;
        if (r103 == false) goto L14;
        float r104 = RangesKt.coerceAtLeast(this.f401074i - this.f401075j, 0.0f);
    L15:
        if (r103 == false) goto L21;
        this.f401068c.set(this.f401067b);
        RectF r105 = this.f401068c;
        float r106 = this.f401075j;
        r105.inset(r106, r106);
        if (this.f401068c.isEmpty() == false) goto L20;
        Intrinsics.stringPlus("Stroke ON but skip content draw due to empty content bounds rect=", this.f401068c);
        return;
    L20:
        RectF r107 = this.f401068c;
    L22:
        this.f401066a.reset();
        this.f401066a.addRoundRect(r107, r104, r104, Path.Direction.CW);
        int r108 = r100.save();
        r100.clipPath(this.f401066a);
        super.onDraw(r100);
        r100.restoreToCount(r108);
        if (r103 == true) goto L25;
        return;
    L25:
        this.f401069d.set(this.f401067b);
        float r109 = this.f401075j / 2.0f;
        this.f401069d.inset(r109, r109);
        if (this.f401069d.isEmpty() == false) goto L29;
        Intrinsics.stringPlus("Stroke ON but skip due to empty stroke bounds rect=", this.f401069d);
        return;
    L29:
        float r110 = RangesKt.coerceAtLeast(this.f401074i - r109, 0.0f);
        r100.drawRoundRect(this.f401069d, r110, r110, this.f401076k);
        return;
    L21:
        r107 = this.f401067b;
        goto L22
    L14:
        r104 = this.f401074i;
    }

    public final void setImageShape(OImageShape r100) {
        Intrinsics.checkNotNullParameter(r100, "shape");
        if (r100 != this.f401073h) goto L6;
        Intrinsics.stringPlus("Skip setImageShape because shape is unchanged: ", r100);
        return;
    L6:
        this.f401073h = r100;
        this.f401074i = c.a(r100, this.f401072g, this.f401071f);
        Objects.toString(r100);
        invalidate();
    }

    public final void setRadiusDp(float r100) {
        Resources r101 = getContext().getResources();
        setRadiusPx(r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final void setRadiusPx(float r100) {
        if (this.f401072g != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f401072g = r100;
        this.f401074i = c.a(this.f401073h, r100, this.f401071f);
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public OImage(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401066a = new Path();
        this.f401067b = new RectF();
        this.f401068c = new RectF();
        this.f401069d = new RectF();
        this.f401070e = b.a.a(b.f24238f, r100, r101, r102);
        this.f401071f = r100.getResources().getDimension(R.dimen.oui_image_rounded_radius);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.radius}, r102, 0);     // Catch: Throwable -> L9
        float r105 = r104.getDimension(0, 0.0f);     // Catch: Throwable -> L6
        r104.recycle();     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(Float.valueOf(r105));     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L15;
        r106 = Float.valueOf(0.0f);
    L15:
        float r107 = ((Number) r106).floatValue();
        this.f401072g = r107;
        OImageShape r108 = this.f401070e.f24239a;
        this.f401073h = r108;
        this.f401074i = c.a(r108, r107, this.f401071f);
        float r109 = r100.getResources().getDimension(R.dimen.oui_image_stroke_width);
        this.f401075j = r109;
        Paint r110 = new Paint(1);
        r110.setStyle(Paint.Style.STROKE);
        r110.setColor(ContextCompat.getColor(r100, R.color.oui_line_1));
        r110.setStrokeWidth(r109);
        this.f401076k = r110;
        return;
    L6:
        th = move-exception;
        r104.recycle();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public /* synthetic */ OImage(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
