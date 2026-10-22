package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B\u0011\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/VideoCoverFrameView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "color", "", "setStrokeColor", "strokeWidth", "setStrokeWidth", "d", "I", "getItemCount", "()I", "setItemCount", "(I)V", "itemCount", "e", "Ljava/lang/Integer;", "getFixSize", "()Ljava/lang/Integer;", "setFixSize", "(Ljava/lang/Integer;)V", "fixSize", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "getRecommendTag", "()Landroid/graphics/Bitmap;", "setRecommendTag", "(Landroid/graphics/Bitmap;)V", "recommendTag", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class VideoCoverFrameView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f455078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f455079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f455080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f455082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f455083f;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap r100 = this.f455083f;
        if (r100 != null) goto L5;
    L9:
        this.f455083f = null;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        Bitmap r101 = this.f455083f;
        if (r101 == null) goto L9;
        r101.recycle();
        goto L9
    }

    public final Integer getFixSize() {
        return this.f455082e;
    }

    public final int getItemCount() {
        return this.f455081d;
    }

    public final Bitmap getRecommendTag() {
        return this.f455083f;
    }

    public VideoCoverFrameView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        this.f455078a = r101;
        this.f455080c = new RectF();
        new Paint(2);
        this.f455081d = 7;
        r101.setStyle(Paint.Style.STROKE);
        r101.setColor(-1);
        int r102 = (int) i.a(r100, 2);
        float r103 = r102;
        this.f455079b = r103;
        r101.setStrokeWidth(r103);
        setPadding(r102, r102, r102, r102);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.f455080c;
        float r102 = this.f455079b;
        r100.drawRoundRect(r101, r102, r102, this.f455078a);
    }

    public final void setFixSize(Integer r100) {
        this.f455082e = r100;
    }

    public final void setItemCount(int r100) {
        this.f455081d = r100;
    }

    public final void setRecommendTag(Bitmap r100) {
        this.f455083f = r100;
    }

    public final void setStrokeColor(int r100) {
        this.f455078a.setColor(r100);
    }

    public final void setStrokeWidth(int r100) {
        this.f455078a.setStrokeWidth(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = (int) (getMeasuredWidth() / i.a(getContext(), 34.0f));
        this.f455081d = r102;
        if (r102 == 0) goto L14;
        Integer r103 = this.f455082e;
        if (r103 == null) goto L11;
        if (r103 != null) goto L9;
    L10:
        int r104 = getMeasuredWidth();
        Integer r105 = this.f455082e;
        Intrinsics.checkNotNull(r105);
        int r106 = r104 / r105.intValue();
    L12:
        int r107 = getMeasuredHeight();
        float r108 = this.f455079b / 2;
        this.f455080c.set(r108, r108, r106 - r108, r107 - r108);
        setMeasuredDimension(r106, r107);
        return;
    L9:
        if (r102 != r103.intValue()) goto L10;
    L11:
        r106 = getMeasuredWidth() / this.f455081d;
        goto L12
    }
}
