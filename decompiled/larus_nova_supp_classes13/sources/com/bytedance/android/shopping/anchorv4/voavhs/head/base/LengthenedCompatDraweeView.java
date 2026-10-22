package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/LengthenedCompatDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "", "ratio", "", "setHeightRatio", "getHeightRatio", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LengthenedCompatDraweeView extends SimpleDraweeView {
    public float a;

    public LengthenedCompatDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LengthenedCompatDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final float getHeightRatio() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHeightRatio(float r1) {
        this.a = r1;
        requestLayout();
    }

    public final void onMeasure(int r3, int r4) {
        super/*com.facebook.drawee.view.DraweeView*/.onMeasure(r3, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r3) * this.a), View.MeasureSpec.getMode(r3)));
    }

    public LengthenedCompatDraweeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 1.0f;
    }

    public /* synthetic */ LengthenedCompatDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
