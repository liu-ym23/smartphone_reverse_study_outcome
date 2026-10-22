package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiItemBackgroundView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/IBackgroundPressedItemListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setBackgroundVisible", "", "visible", "", "updateLayoutParamsByLeafView", "leafView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "parentViewWidth", "parentViewScrollX", "onItemTouch", "view", "event", "Landroid/view/MotionEvent;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiItemBackgroundView extends FrameLayout implements b {
    public WikiItemBackgroundView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public WikiItemBackgroundView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public WikiItemBackgroundView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void setBackgroundVisible(boolean r2) {
        if (r2 == true) goto L4;
        Drawable r3 = null;
    L5:
        setBackground(r3);
        invalidate();
        return;
    L4:
        r3 = AppCompatResources.getDrawable(getContext(), 2131256609);
        goto L5
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b
    public final void a(WikItemLeafView r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 == null) goto L13;
        int r4 = r3.getAction();
        if (r4 != 0) goto L7;
    L10:
        boolean r5 = true;
    L11:
        r2.getBackgroundView().setBackgroundVisible(r5);
        return;
    L7:
        if (r4 == 2) goto L10;
        r5 = false;
        goto L11
    }

    public final void b(WikItemLeafView r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "leafView");
        r7.c(this);
        int r0 = r7.getPressedGravityType();
        int r1 = r7.getPressedInnerMarginStart();
        int r2 = r7.getPressedContainerWidth();
        int r10 = r7.getPressedContainerHeight();
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        int r5 = r4.gravity;
        if (r2 <= r8) goto L8;
        int r11 = r9 + r1;
    L10:
        if (r8 == r4.width) goto L12;
    L17:
        r4.width = r8;
        r4.height = r10;
        r4.setMarginStart(r11);
        r4.gravity = r0;
        setLayoutParams(r3);
        return;
    L12:
        if (r10 != r4.height) goto L17;
        if (r11 != r4.getMarginStart()) goto L17;
        if (r0 != r4.gravity) goto L17;
        return;
    L8:
        r11 = r1 + 0;
        r8 = r2;
        goto L10
    }

    public WikiItemBackgroundView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        setClickable(false);
    }
}
