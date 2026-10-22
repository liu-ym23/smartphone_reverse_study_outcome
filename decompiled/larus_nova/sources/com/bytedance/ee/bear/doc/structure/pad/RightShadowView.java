package com.bytedance.ee.bear.doc.structure.pad;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/RightShadowView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shadowPaint", "Landroid/graphics/Paint;", "shadowWidth", "getShadowWidth", "()I", "setShadowWidth", "(I)V", "shadowRect", "Landroid/graphics/RectF;", "updateShadow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RightShadowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f218219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f218220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f218221c;

    public RightShadowView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RightShadowView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getShadowWidth() {
        return this.f218220b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f218220b > 0) goto L5;
        return;
    L5:
        r100.drawRect(this.f218221c, this.f218219a);
    }

    public final void setShadowWidth(int r100) {
        this.f218220b = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(getMeasuredWidth() + this.f218220b, getMeasuredHeight());
        RectF r102 = this.f218221c;
        r102.left = getMeasuredWidth() - this.f218220b;
        r102.top = 0.0f;
        r102.right = getMeasuredWidth();
        r102.bottom = getMeasuredHeight();
    }

    public RightShadowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(UDColorUtils.getColor(r100, R.color.shadow_default_md));
        r103.setMaskFilter(new BlurMaskFilter(u0c.a.a(8), BlurMaskFilter.Blur.NORMAL));
        this.f218219a = r103;
        this.f218220b = u0c.a.a(8);
        this.f218221c = new RectF();
    }

    public /* synthetic */ RightShadowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
