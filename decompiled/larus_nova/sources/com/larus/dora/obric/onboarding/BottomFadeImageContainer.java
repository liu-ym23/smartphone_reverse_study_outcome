package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/obric/onboarding/BottomFadeImageContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fadeHeight", "", "maskPaint", "Landroid/graphics/Paint;", "bottomGradient", "Landroid/graphics/LinearGradient;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomFadeImageContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f340706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f340707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearGradient f340708c;

    public BottomFadeImageContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomFadeImageContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        LinearGradient r100 = this.f340708c;
        if (r100 != null) goto L5;
    L9:
        super.dispatchDraw(r110);
        return;
    L5:
        if (this.f340706a <= 0.0f) goto L9;
        int r101 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r110);
        float r102 = getHeight() - Math.min(this.f340706a, getHeight());
        this.f340707b.setShader(r100);
        r110.drawRect(0.0f, r102, getWidth(), getHeight(), this.f340707b);
        this.f340707b.setShader(null);
        r110.restoreToCount(r101);
    }

    public BottomFadeImageContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f340706a = getResources().getDimension(R.dimen.larus_dp_58);
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f340707b = r103;
    }

    public /* synthetic */ BottomFadeImageContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        if (r100 <= 0) goto L8;
        if (r110 <= 0) goto L8;
        float r101 = r110;
        this.f340708c = new LinearGradient(0.0f, r101 - Math.min(this.f340706a, r101), 0.0f, r101, new int[]{-16777216, 0}, null, Shader.TileMode.CLAMP);
        return;
    L8:
        this.f340708c = null;
    }
}
