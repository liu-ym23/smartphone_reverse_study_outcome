package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol2.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "请使用ui-base-widget中")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "Landroid/widget/LinearLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECRoundedLinearLayout extends LinearLayout {
    public float a;

    public ECRoundedLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECRoundedLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        int r0 = (this.a > 0.0f ? 1 : (this.a == 0.0f ? 0 : -1));
        super.dispatchDraw(r3);
    }

    public final void setRadius(float r3) {
        this.a = r3;
        if (r3 <= 0) goto L11;
        ViewOutlineProvider r0 = getOutlineProvider();
        if ((r0 instanceof r) == true) goto L7;
        r0 = null;
    L7:
        r r1 = (r) r0;
        if (r1 == null) goto L12;
        r1.a = r3;
        return;
    L12:
        return;
    }

    public ECRoundedLinearLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        TypedArray r7 = r4.getTheme().obtainStyledAttributes(r5, new int[]{2130973851}, r6, 0);
        if (r7.hasValue(0) == false) goto L5;
        this.a = r7.getDimensionPixelOffset(0, 0);
    L5:
        r7.recycle();
    }

    public /* synthetic */ ECRoundedLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        float r5 = this.a;
        int r6 = (r5 > 0.0f ? 1 : (r5 == 0.0f ? 0 : -1));
        if (r5 <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new r(this.a, r1, r2));
        return;
    }
}
