package com.bytedance.android.livesdk.livecommerce.userinfo.title.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/views/ECIntroductionRotationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIntroductionRotationView extends FrameLayout {
    public ECIntroductionRotationView$bindData$1 a;
    public final TextView b;
    public final TextView c;
    public int d;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECIntroductionRotationView$bindData$1 r0 = this.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.a = null;
    }

    public ECIntroductionRotationView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        int r4 = ECIntroductionLayout.g;
        TextView r5 = ECIntroductionLayout.a.a(getContext());
        this.b = r5;
        TextView r0 = ECIntroductionLayout.a.a(getContext());
        this.c = r0;
        this.d = -1;
        addView(r5);
        addView(r0);
    }

    public ECIntroductionRotationView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        int r4 = ECIntroductionLayout.g;
        TextView r5 = ECIntroductionLayout.a.a(getContext());
        this.b = r5;
        TextView r6 = ECIntroductionLayout.a.a(getContext());
        this.c = r6;
        this.d = -1;
        addView(r5);
        addView(r6);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (this.d <= 0) goto L10;
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r1 = (this.d + getPaddingLeft()) + getPaddingRight();
        if (r0 == Integer.MIN_VALUE) goto L8;
        if (r0 == 1073741824) goto L9;
        r7 = r1;
    L9:
        r5 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
        goto L10
    L8:
        r7 = Math.min(r1, r7);
    L10:
        super.onMeasure(r5, r6);
    }

    public ECIntroductionRotationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = ECIntroductionLayout.g;
        TextView r6 = ECIntroductionLayout.a.a(getContext());
        this.b = r6;
        TextView r7 = ECIntroductionLayout.a.a(getContext());
        this.c = r7;
        this.d = -1;
        addView(r6);
        addView(r7);
    }
}
