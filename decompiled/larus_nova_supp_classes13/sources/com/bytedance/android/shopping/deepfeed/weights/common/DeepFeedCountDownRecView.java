package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedCountDownRecView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedCountDownRecView extends ConstraintLayout {
    public DeepFeedCountDownRecView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedCountDownRecView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedCountDownRecView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        ViewGroup.inflate(r5, 2131564628, this);
        AppCompatTextView r8 = (DeepFeedCountdownView) findViewById(2131368677);
        com.bytedance.android.shopping.deepfeed.ui.view.a r9 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r8.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r5, 11));
        SimpleDraweeView r10 = findViewById(2131368678);
        if (f.b() == false) goto L15;
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        if (r0 == null) goto L14;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r1).height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16);
        r1.topToTop = 0;
        r1.bottomToBottom = -1;
        r8.setLayoutParams(r1);
        ConstraintLayout.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L12;
        ConstraintLayout.LayoutParams r12 = r11;
        r12.topToTop = 0;
        r12.bottomToBottom = -1;
        r10.setLayoutParams(r12);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public /* synthetic */ DeepFeedCountDownRecView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
