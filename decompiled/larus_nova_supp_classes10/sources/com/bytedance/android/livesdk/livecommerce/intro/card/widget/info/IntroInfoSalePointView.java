package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoSalePointView;", "Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroInfoSalePointView extends AutoHideLinearLayout {
    public final List<GradientAndItalicTextView> b;
    public final List<Space> c;

    public IntroInfoSalePointView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new ArrayList();
        this.c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        if ((r2 instanceof GradientAndItalicTextView) == false) goto L6;
        ((ArrayList) this.b).add(r2);
        return;
    L6:
        if ((r2 instanceof Space) == false) goto L10;
        ((ArrayList) this.c).add(r2);
        return;
    }

    public IntroInfoSalePointView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new ArrayList();
        this.c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    public IntroInfoSalePointView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new ArrayList();
        this.c = new ArrayList();
        setOrientation(0);
        setGravity(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final boolean e(View r2, boolean r3, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if ((r2 instanceof TextView) == false) goto L12;
        if (UtilityKotlinExtentionsKt.e((TextView) r2) == false) goto L12;
        if (indexOfChild(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.e(r2, r3, r4, r5, r6, r7);
    }
}
