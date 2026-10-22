package com.ss.android.lark.widget.photo.preview.ocr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/ocr/BubbleLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "cornerRadius", "", "value", "arrowCenterX", "getArrowCenterX", "()F", "setArrowCenterX", "(F)V", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f447025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f447026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f447027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f447028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f447029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f447030f;

    public BubbleLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BubbleLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getArrowCenterX() {
        return this.f447029e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Drawable r101 = this.f447030f;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f447026b.reset();
        this.f447027c.set(0.0f, 0.0f, getWidth(), (getHeight() - getPaddingBottom()) + UIUtils.dp2px(getContext(), 1.0f));
        RectF r102 = this.f447027c;
        float r103 = this.f447028d;
        r100.drawRoundRect(r102, r103, r103, this.f447025a);
        float r104 = r101.getIntrinsicWidth() / 2.0f;
        float r105 = RangesKt.coerceIn(this.f447029e, this.f447028d + r104, (getWidth() - r104) - this.f447028d);
        int r106 = r100.save();
        r100.translate(r105 - r104, r100.getHeight() - getPaddingBottom());     // Catch: Throwable -> L9
        r101.draw(r100);     // Catch: Throwable -> L9
        r100.restoreToCount(r106);
        return;
    L9:
        th = move-exception;
        r100.restoreToCount(r106);
        throw th;
    }

    public final void setArrowCenterX(float r100) {
        if (this.f447029e != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f447029e = r100;
        invalidate();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public BubbleLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f447025a = r103;
        this.f447026b = new Path();
        this.f447027c = new RectF();
        this.f447028d = UIUtils.dp2px(r100, 8.0f);
        Drawable r104 = ContextCompat.getDrawable(r100, R.drawable.menu_ocr_bg_arrow);
        int r105 = 0;
        if (r104 == null) goto L5;
        r104.setBounds(0, 0, r104.getIntrinsicWidth(), r104.getIntrinsicHeight());
    L5:
        this.f447030f = r104;
        setWillNotDraw(false);
        setLayerType(1, null);
        if (r104 == null) goto L8;
        r105 = r104.getIntrinsicHeight();
    L8:
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r105);
        r103.setColor(ContextCompat.getColor(r100, R.color.bg_body));
        r103.setStyle(Paint.Style.FILL);
    }

    public /* synthetic */ BubbleLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
