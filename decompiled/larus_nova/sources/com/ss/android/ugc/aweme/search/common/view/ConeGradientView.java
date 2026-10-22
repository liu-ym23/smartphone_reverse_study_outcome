package com.ss.android.ugc.aweme.search.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/ConeGradientView;", "Landroid/view/View;", "", "newCornerRadius", "", "setCornerRadius", "Landroid/graphics/Matrix;", "e", "Landroid/graphics/Matrix;", "getShaderMatrix", "()Landroid/graphics/Matrix;", "setShaderMatrix", "(Landroid/graphics/Matrix;)V", "shaderMatrix", "Landroid/graphics/SweepGradient;", "f", "Landroid/graphics/SweepGradient;", "getShader", "()Landroid/graphics/SweepGradient;", "setShader", "(Landroid/graphics/SweepGradient;)V", "shader", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConeGradientView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f452298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f452299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f452300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f452301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Matrix f452302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SweepGradient f452303f;

    public final SweepGradient getShader() {
        return this.f452303f;
    }

    public final Matrix getShaderMatrix() {
        return this.f452302e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = getWidth();
        float r101 = getHeight();
        float r102 = this.f452301d;
        r110.drawRoundRect(0.0f, 0.0f, r100, r101, r102, r102, this.f452298a);
    }

    public final void setCornerRadius(float r100) {
        this.f452301d = r100;
        invalidate();
    }

    public final void setShader(SweepGradient r100) {
        this.f452303f = r100;
    }

    public final void setShaderMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f452302e = r100;
    }

    public ConeGradientView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f452298a = new Paint(1);
        this.f452299b = new int[]{ContextCompat.getColor(r100, R.color.ec_search_gradient_view_color_1), ContextCompat.getColor(r100, R.color.ec_search_gradient_view_color_2), ContextCompat.getColor(r100, R.color.ec_search_gradient_view_color_3), ContextCompat.getColor(r100, R.color.ec_search_gradient_view_color_4), ContextCompat.getColor(r100, R.color.ec_search_gradient_view_color_1)};
        this.f452300c = new float[]{0.0f, 0.12f, 0.25f, 0.7f, 1.0f};
        this.f452301d = DimensUtilKt.a(19);
        this.f452302e = new Matrix();
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.coneCornerRadius});
        this.f452301d = r102.getDimension(0, DimensUtilKt.a(19));     // Catch: Throwable -> L6
        r102.recycle();
        return;
    L6:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = getWidth() / 2.0f;
        float r105 = getHeight() / 2.0f;
        this.f452303f = new SweepGradient(r104, r105, this.f452299b, this.f452300c);
        if (getWidth() > 0) goto L5;
    L7:
        float r106 = 0.118f;
    L8:
        this.f452302e.setScale(1.0f, r106, r104, r105);
        SweepGradient r107 = this.f452303f;
        if (r107 == null) goto L11;
        r107.setLocalMatrix(this.f452302e);
    L11:
        this.f452298a.setShader(this.f452303f);
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        r106 = getHeight() / getWidth();
        goto L8
    }
}
