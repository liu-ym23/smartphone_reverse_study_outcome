package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;
import com.bytedance.android.shopping.deepfeed.utlis.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductMarqueeTextView;", "Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedMarqueeTextView;", "", "weight", "", "setWeight", "(Ljava/lang/Integer;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductMarqueeTextView extends DeepFeedMarqueeTextView {
    public final com.bytedance.android.shopping.deepfeed.ui.view.a u;

    public ProductMarqueeTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductMarqueeTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        Scroller r0 = this.b;
        if (r0 == null) goto L6;
        r0.startScroll(0, 0, 0, 0, 0);
    L6:
        setCurrentLoop(0);
        setScrollEnd(false);
        setHasAdjusted(false);
        setMFirst(true);
        scrollTo(0, 0);
        Scroller r1 = getMScroller();
        if (r1 == null) goto L10;
        r1.forceFinished(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setWeight(Integer r3) {
        if (r3 == null) goto L7;
        r3.intValue();
        ConcurrentHashMap<String, j.a> r0 = j.a;
        Typeface r4 = j.c("DouyinNumberABC-Medium", getContext(), r3);
        if (r4 == null) goto L8;
        setTypeface(r4);
        return;
    L8:
        return;
    }

    public final void onMeasure(int r2, int r3) {
        com.bytedance.android.shopping.deepfeed.ui.view.a r0 = this.u;
        if (r0 == null) goto L5;
        Pair<Integer, Integer> r1 = r0.b(r2, r3);
    L6:
        if (r1 == null) goto L8;
        super.onMeasure(((Number) r1.getFirst()).intValue(), ((Number) r1.getSecond()).intValue());
        return;
    L8:
        super.onMeasure(r2, r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedMarqueeTextView
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        z();
        super.onVisibilityChanged(r2, r3);
    }

    public ProductMarqueeTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        com.bytedance.android.shopping.deepfeed.ui.view.a r5 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        this.u = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        setWeight(400);
    }

    public /* synthetic */ ProductMarqueeTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
