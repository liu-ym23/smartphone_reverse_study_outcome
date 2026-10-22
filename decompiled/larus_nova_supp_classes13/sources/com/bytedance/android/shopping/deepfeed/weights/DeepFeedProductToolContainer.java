package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductToolContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductToolContainer extends ConstraintLayout {
    public final ProductCardProgressIndicator a;
    public final FrameLayout b;
    public final VideoCoverLayout c;
    public final ConstraintLayout d;
    public final ProductTextView e;
    public final DeepFeedProductHeaderTabLayout f;

    public DeepFeedProductToolContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductToolContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedProductToolContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(r2, 2131564633, this);
        this.a = (ProductCardProgressIndicator) findViewById(2131383321);
        this.b = (FrameLayout) findViewById(2131372754);
        this.c = (VideoCoverLayout) findViewById(2131392309);
        ConstraintLayout r5 = findViewById(2131385355);
        this.d = r5;
        if (r5 == null) goto L5;
        r5.setVisibility(8);
    L5:
        ProductTextView r6 = (ProductTextView) findViewById(2131385358);
        r6.setWeight(500);
        com.bytedance.android.shopping.deepfeed.ui.view.a r7 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r6.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r2, 12));
        Unit r8 = Unit.INSTANCE;
        this.e = r6;
        this.f = (DeepFeedProductHeaderTabLayout) findViewById(2131368680);
    }

    public /* synthetic */ DeepFeedProductToolContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
