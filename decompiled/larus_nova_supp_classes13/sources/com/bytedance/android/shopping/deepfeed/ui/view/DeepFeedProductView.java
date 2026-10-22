package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedAiContainerView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedAiLoadingContainer;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductAbilityView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderTabLayout;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductToolContainer;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedSearchBarView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010,\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006A"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/DeepFeedProductView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "alpha", "", "setAlpha", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderView;", "a", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderView;", "getHeaderView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderView;", "headerView", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoView;", "b", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoView;", "getInfoView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoView;", "infoView", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityView;", "c", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityView;", "getAbilityView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityView;", "abilityView", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductToolContainer;", "d", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductToolContainer;", "getToolContainer", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductToolContainer;", "toolContainer", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView;", "e", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView;", "getAiRecView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView;", "aiRecView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "getInfoContainer", "()Landroid/view/ViewGroup;", "infoContainer", "g", "getCenterAiRecView", "centerAiRecView", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiLoadingContainer;", "h", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiLoadingContainer;", "getAiLoadingContainer", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiLoadingContainer;", "aiLoadingContainer", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedSearchBarView;", "k", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedSearchBarView;", "getSearchBarView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedSearchBarView;", "searchBarView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductView extends ConstraintLayout {
    public final DeepFeedProductHeaderView a;
    public final DeepFeedProductInfoView b;
    public final DeepFeedProductAbilityView c;
    public final DeepFeedProductToolContainer d;
    public final DeepFeedAiContainerView e;
    public final ViewGroup f;
    public final DeepFeedAiContainerView g;
    public final DeepFeedAiLoadingContainer h;
    public final View i;
    public final boolean j;
    public final DeepFeedSearchBarView k;
    public com.bytedance.android.shopping.deepfeed.action.h l;

    public DeepFeedProductView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final DeepFeedProductAbilityView getAbilityView() {
        return this.c;
    }

    public final DeepFeedAiLoadingContainer getAiLoadingContainer() {
        return this.h;
    }

    public final DeepFeedAiContainerView getAiRecView() {
        return this.e;
    }

    public final DeepFeedAiContainerView getCenterAiRecView() {
        return this.g;
    }

    public final DeepFeedProductHeaderView getHeaderView() {
        return this.a;
    }

    public final ViewGroup getInfoContainer() {
        return this.f;
    }

    public final DeepFeedProductInfoView getInfoView() {
        return this.b;
    }

    public final DeepFeedSearchBarView getSearchBarView() {
        return this.k;
    }

    public final DeepFeedProductToolContainer getToolContainer() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r2) {
        if (r2 == false) goto L5;
        ViewExtensionsKt.g(this, 18.0f, 18.0f, 0.0f, 0.0f);
        return;
    L5:
        ViewExtensionsKt.g(this, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAlpha(float r2) {
        if (this.j == false) goto L6;
        super/*android.view.ViewGroup*/.setAlpha(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedProductView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.j = true;
        ViewGroup.inflate(r6, 2131564650, this);
        this.c = (DeepFeedProductAbilityView) findViewById(2131368650);
        this.f = (ViewGroup) findViewById(2131368681);
        this.b = (DeepFeedProductInfoView) findViewById(2131368652);
        DeepFeedProductHeaderView r9 = (DeepFeedProductHeaderView) findViewById(2131368651);
        this.a = r9;
        this.k = (DeepFeedSearchBarView) findViewById(2131368649);
        this.e = (DeepFeedAiContainerView) findViewById(2131368706);
        this.g = (DeepFeedAiContainerView) findViewById(2131368674);
        this.i = findViewById(2131368673);
        this.h = (DeepFeedAiLoadingContainer) findViewById(2131368667);
        DeepFeedProductToolContainer r10 = (DeepFeedProductToolContainer) findViewById(2131368705);
        this.d = r10;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "headerView");
        ProductCardProgressIndicator r11 = r10.a;
        FrameLayout r0 = r10.b;
        VideoCoverLayout r1 = r10.c;
        ConstraintLayout r2 = r10.d;
        ProductTextView r3 = r10.e;
        DeepFeedProductHeaderTabLayout r12 = r10.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "progressIndicator");
        Intrinsics.checkNotNullParameter(r0, "progressIndicatorContainer");
        Intrinsics.checkNotNullParameter(r3, "searchContent");
        Intrinsics.checkNotNullParameter(r12, "headerTabLayout");
        r9.b = r11;
        r9.c = r0;
        r9.d = r1;
        r9.w = r2;
        r9.x = r3;
        r9.y = r12;
        if (r1 == null) goto L6;
        r1.setCallback(new com.bytedance.android.shopping.deepfeed.weights.i(r9, r2));
        return;
    }

    public /* synthetic */ DeepFeedProductView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
