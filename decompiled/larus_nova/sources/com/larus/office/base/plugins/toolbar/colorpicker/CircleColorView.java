package com.larus.office.base.plugins.toolbar.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import en9.k;
import en9.l;
import en9.m;
import in9.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00102\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ%\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010%J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\b\u0010&\u001a\u00020\u0010H\u0002J$\u0010'\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160)H\u0002J$\u0010+\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160)H\u0002J&\u0010,\u001a\u00020\u00102\b\b\u0001\u0010-\u001a\u00020\u00072\b\b\u0001\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u0007H\u0002J\u001a\u00100\u001a\u00020\u00102\b\b\u0001\u00101\u001a\u00020\u00072\b\b\u0001\u00102\u001a\u00020\u0007J\u0018\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J(\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/colorpicker/CircleColorView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "boardPaint", "showBoard", "", "setBoard", "", "isShow", "currentColor", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/Shader;", "gradientAlpha", "", "gradientBaseColorString", "", "gradientOffset", "Ljava/lang/Float;", "setColor", "color", "colorValue", "Lcom/larus/office/base/plugins/toolbar/model/ColorValueItem;", "gradientDetail", "Lcom/larus/office/base/plugins/toolbar/colorpicker/GradientDetail;", "setGradientColor", "alpha", "baseColor", "offset", "(FLjava/lang/String;Ljava/lang/Float;)V", "updateGradient", "createRadialGradient", "colors", "", "positions", "updateMultiColorGradient", "setLinearGradient", "startColor", "endColor", "angle", "setRadialGradient", "centerColor", "edgeColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleColorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f360816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f360817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f360818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f360819d;

    public CircleColorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleColorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        m r100 = this.f360819d;
        float[] r101 = null;
        if (r100 == null) goto L5;
        List<l> r102 = r100.f473232c;
    L6:
        List<l> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return;
    L15:
        if (getWidth() > 0) goto L17;
        return;
    L17:
        if (getHeight() <= 0) goto L72;
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        m r107 = this.f360819d;
        if (r107 == null) goto L31;
        List<l> r108 = r107.f473232c;
        if (r108 == null) goto L31;
        Iterator<T> r109 = r108.iterator();
    L25:
        if (r109.hasNext() == false) goto L31;
        l r110 = (l) r109.next();
        int r111 = Color.parseColor(r110.f473228b);     // Catch: IllegalArgumentException -> L29
        r105.add(Integer.valueOf(Color.argb((int) (r110.f473227a * 255), Color.red(r111), Color.green(r111), Color.blue(r111))));     // Catch: IllegalArgumentException -> L29
        r106.add(Float.valueOf(r110.f473229c));     // Catch: IllegalArgumentException -> L29
    L31:
        if (r105.size() < 2) goto L70;
        m r112 = this.f360819d;
        if (r112 == null) goto L35;
        String r113 = r112.f473231b;
    L37:
        if (Intrinsics.areEqual(r113, "linear") == false) goto L46;
        m r114 = this.f360819d;
        if (r114 == null) goto L41;
        double r115 = r114.f473230a;
    L42:
        float r116 = (float) Math.toRadians(r115);
        float r117 = getWidth() / 2.0f;
        float r118 = getHeight() / 2.0f;
        float r119 = Math.max(getWidth(), getHeight()) / 2.0f;
        double r120 = r116;
        float r121 = r117 - (((float) Math.cos(r120)) * r119);
        float r122 = r118 - (((float) Math.sin(r120)) * r119);
        float r123 = r117 + (((float) Math.cos(r120)) * r119);
        float r124 = r118 + (((float) Math.sin(r120)) * r119);
        int[] r125 = CollectionsKt.toIntArray(r105);
        if (r106.size() != r105.size()) goto L45;
        r101 = CollectionsKt.toFloatArray(r106);
    L45:
        this.f360816a.setShader(new LinearGradient(r121, r122, r123, r124, r125, r101, Shader.TileMode.CLAMP));
        return;
    L41:
        r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L42
    L46:
        float r126 = getWidth();
        m r127 = this.f360819d;
        float r128 = 0.5f;
        if (r127 == null) goto L49;
        float r129 = r127.f473233d;
    L50:
        float r130 = r126 * r129;
        float r131 = getHeight();
        m r132 = this.f360819d;
        if (r132 == null) goto L53;
        r128 = r132.f473234e;
    L53:
        float r133 = r131 * r128;
        float r134 = RangesKt.coerceAtMost(getWidth(), getHeight()) / 2.0f;
        m r135 = this.f360819d;
        if (r135 == null) goto L56;
        float r136 = r135.f473235f;
    L57:
        float r137 = r134 * r136;
        int[] r138 = CollectionsKt.toIntArray(r105);
        if (r106.size() != r105.size()) goto L60;
        r101 = CollectionsKt.toFloatArray(r106);
    L60:
        this.f360816a.setShader(new RadialGradient(r130, r133, r137, r138, r101, Shader.TileMode.CLAMP));
        return;
    L56:
        r136 = 1.0f;
        goto L57
    L49:
        r129 = 0.5f;
        goto L50
    L35:
        r113 = null;
        goto L37
    L70:
        return;
    L72:
        return;
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = Math.min(getWidth(), getHeight()) / 2.0f;
        r100.drawCircle(r101, r102, r103, this.f360816a);
        if (this.f360818c == false) goto L6;
        r100.drawCircle(r101, r102, r103 - (this.f360817b.getStrokeWidth() / 2), this.f360817b);
        return;
    }

    public final void setBoard(boolean r100) {
        this.f360818c = r100;
        invalidate();
    }

    public final void setColor(int r100) {
        this.f360816a.setColor(r100);
        invalidate();
    }

    public final void setGradientColor(m r100) {
        Intrinsics.checkNotNullParameter(r100, "gradientDetail");
        this.f360819d = r100;
        a();
        invalidate();
    }

    public final void setColor(d r100) {
        k.f473226a.getClass();
        k.a(this, r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(r102, r102);
    }

    public CircleColorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        this.f360816a = r103;
        Paint r104 = new Paint(1);
        r104.setAntiAlias(true);
        r104.setStyle(Paint.Style.STROKE);
        r104.setColor(r100.getResources().getColor(R.color.larus_neutral_transparent_1));
        r104.setStrokeWidth(c7.b(Double.valueOf(1.5d)));
        r104.setFilterBitmap(true);
        this.f360817b = r104;
    }

    public /* synthetic */ CircleColorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f360819d == null) goto L8;
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L10;
        a();
        return;
    L10:
        return;
    L9:
        return;
    }
}
