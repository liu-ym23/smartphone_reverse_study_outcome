package com.ss.android.ugc.aweme.search.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!B\u001b\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b \u0010$B#\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b \u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECSearchBrandRedGradientBackgroundView;", "Landroid/widget/FrameLayout;", "", "b", "I", "getStartColor", "()I", "setStartColor", "(I)V", "startColor", "c", "getEndColor", "setEndColor", "endColor", "", "d", "[F", "getStops", "()[F", "setStops", "([F)V", "stops", "", "e", "Z", "getEnableGradientDraw", "()Z", "setEnableGradientDraw", "(Z)V", "enableGradientDraw", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBrandRedGradientBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f451377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f451378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f451379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f451380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f451381e;

    public final boolean getEnableGradientDraw() {
        return this.f451381e;
    }

    public final int getEndColor() {
        return this.f451379c;
    }

    public final int getStartColor() {
        return this.f451378b;
    }

    public final float[] getStops() {
        return this.f451380d;
    }

    public ECSearchBrandRedGradientBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f451377a = new Paint(1);
        this.f451378b = ColorProtector.parseColor("#FF9624");
        this.f451379c = Color.argb(0, 255, 98, 36);
        this.f451380d = new float[]{0.0208f, 0.369f};
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f451381e == false) goto L5;
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f451377a);
    L5:
        super.onDraw(r100);
    }

    public final void setEnableGradientDraw(boolean r100) {
        this.f451381e = r100;
    }

    public final void setEndColor(int r100) {
        this.f451379c = r100;
    }

    public final void setStartColor(int r100) {
        this.f451378b = r100;
    }

    public final void setStops(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f451380d = r100;
    }

    public ECSearchBrandRedGradientBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f451377a = new Paint(1);
        this.f451378b = ColorProtector.parseColor("#FF9624");
        this.f451379c = Color.argb(0, 255, 98, 36);
        this.f451380d = new float[]{0.0208f, 0.369f};
    }

    public ECSearchBrandRedGradientBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f451377a = new Paint(1);
        this.f451378b = ColorProtector.parseColor("#FF9624");
        this.f451379c = Color.argb(0, 255, 98, 36);
        this.f451380d = new float[]{0.0208f, 0.369f};
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        if (this.f451381e == false) goto L8;
        if (r110 <= 0) goto L9;
        if (r100 <= 0) goto L10;
        float r113 = r110;
        float r101 = r100 / r113;
        float r114 = 101.0f * r101;
        this.f451377a.setShader(new LinearGradient(0.0f, 0.0f, (r114 / ((r101 * r101) + 100.0f)) * r113, ((r114 * r101) / (((10.0f * r101) * r101) + 1000.0f)) * r113, new int[]{this.f451378b, this.f451379c}, this.f451380d, Shader.TileMode.CLAMP));
        Unit r102 = Unit.INSTANCE;
        return;
    L10:
        return;
    L9:
        return;
    }
}
