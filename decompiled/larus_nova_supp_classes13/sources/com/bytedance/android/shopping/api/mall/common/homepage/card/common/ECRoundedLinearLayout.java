package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import com.bytedance.android.ec.hybrid.list.view.ECPredictHeightLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedLinearLayout;", "Lcom/bytedance/android/ec/hybrid/list/view/ECPredictHeightLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECRoundedLinearLayout extends ECPredictHeightLayout {
    public float b;

    public ECRoundedLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECRoundedLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        int r0 = (this.b > 0.0f ? 1 : (this.b == 0.0f ? 0 : -1));
        super/*android.widget.LinearLayout*/.dispatchDraw(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRadius(float r3) {
        this.b = r3;
        if (r3 <= 0) goto L11;
        ViewOutlineProvider r0 = getOutlineProvider();
        if ((r0 instanceof d) == true) goto L7;
        r0 = null;
    L7:
        d r1 = (d) r0;
        if (r1 == null) goto L12;
        r1.a = r3;
        return;
    L12:
        return;
    }

    public ECRoundedLinearLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, new int[]{2130972522, 2130973851}, r5, 0);
        if (r6.hasValue(1) == false) goto L5;
        this.b = r6.getDimensionPixelOffset(1, 0);
    L5:
        r6.recycle();
    }

    public /* synthetic */ ECRoundedLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.LinearLayout*/.onSizeChanged(r1, r2, r3, r4);
        float r5 = this.b;
        int r6 = (r5 > 0.0f ? 1 : (r5 == 0.0f ? 0 : -1));
        if (r5 <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new d(this.b, r1, r2));
        return;
    }
}
