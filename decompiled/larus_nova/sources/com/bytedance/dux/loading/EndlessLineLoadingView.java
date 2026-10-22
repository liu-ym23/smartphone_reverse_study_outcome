package com.bytedance.dux.loading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/dux/loading/EndlessLineLoadingView;", "Lcom/bytedance/dux/loading/LineLoadingView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class EndlessLineLoadingView extends LineLoadingView {

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EndlessLineLoadingView f205244a;

        public a(EndlessLineLoadingView r100) {
            this.f205244a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            float r101 = 1;
            this.f205244a.getIndicatorPaint().setAlpha((int) ((r101 - r100.getAnimatedFraction()) * 255));
            float r102 = 2;
            this.f205244a.getIndicatorRect().left = ((r101 - r100.getAnimatedFraction()) * this.f205244a.getWidth()) / r102;
            this.f205244a.getIndicatorRect().right = ((r101 + r100.getAnimatedFraction()) * this.f205244a.getWidth()) / r102;
            this.f205244a.invalidate();
        }
    }

    public EndlessLineLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public EndlessLineLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.dux.loading.LineLoadingView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(getBoundsRect(), getBgPaint());
        r100.drawRect(getIndicatorRect(), getIndicatorPaint());
    }

    public EndlessLineLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        getIndicatorPaint().setColor((int) BodyPartID.bodyIdMax);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.addUpdateListener(new a(this));
        r103.setDuration(500);
        r103.setRepeatCount(-1);
    }

    public /* synthetic */ EndlessLineLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
