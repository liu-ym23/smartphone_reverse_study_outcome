package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTextOrImageView extends ConstraintLayout {
    public final ImageView a;
    public final ProductTextView b;

    public ProductTextOrImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductTextOrImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5(String r3, Integer r4) {
        if (r3 == null) goto L6;
        this.b.setText(r3);
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        return;
    L6:
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
        this.a.setImageResource(r5);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductTextOrImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(r2, 2131564632, this);
        this.a = (ImageView) findViewById(2131368735);
        ProductTextView r5 = (ProductTextView) findViewById(2131368736);
        this.b = r5;
        com.bytedance.android.shopping.deepfeed.ui.view.a r6 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r5.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r2, 13));
    }

    public /* synthetic */ ProductTextOrImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
