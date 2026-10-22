package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECUpdateHeightConstraintLayout;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUpdateHeightConstraintLayout extends ECRoundedConstraintLayout {
    public int g;

    public ECUpdateHeightConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECUpdateHeightConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout
    public final void onMeasure(int r2, int r3) {
        if (this.g > 0) goto L6;
        super.onMeasure(r2, r3);
        return;
    L6:
        super.onMeasure(r2, r3);
        int r0 = getMeasuredWidth();
        if (r0 > 0) goto L10;
        super.onMeasure(r2, r3);
        return;
    L10:
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(r0 + this.g, 1073741824));
    }

    public ECUpdateHeightConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECUpdateHeightConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
