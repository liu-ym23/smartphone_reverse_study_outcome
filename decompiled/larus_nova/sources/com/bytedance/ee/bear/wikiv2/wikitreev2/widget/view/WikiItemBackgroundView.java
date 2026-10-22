package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiItemBackgroundView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/IBackgroundPressedItemListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setBackgroundVisible", "", "visible", "", "updateLayoutParamsByLeafView", "leafView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "parentViewWidth", "parentViewScrollX", "onItemTouch", "view", "event", "Landroid/view/MotionEvent;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiItemBackgroundView extends FrameLayout implements b {
    public WikiItemBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public WikiItemBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public WikiItemBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void setBackgroundVisible(boolean r100) {
        if (r100 == true) goto L4;
        Drawable r101 = null;
    L5:
        setBackground(r101);
        invalidate();
        return;
    L4:
        r101 = AppCompatResources.getDrawable(getContext(), R.drawable.wiki_item_pressed_shape);
        goto L5
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b
    public final void a(WikItemLeafView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == null) goto L13;
        int r102 = r101.getAction();
        if (r102 != 0) goto L7;
    L10:
        boolean r103 = true;
    L11:
        r100.getBackgroundView().setBackgroundVisible(r103);
        return;
    L7:
        if (r102 == 2) goto L10;
        r103 = false;
        goto L11
    }

    public final void b(WikItemLeafView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "leafView");
        r100.c(this);
        int r103 = r100.getPressedGravityType();
        int r104 = r100.getPressedInnerMarginStart();
        int r105 = r100.getPressedContainerWidth();
        int r106 = r100.getPressedContainerHeight();
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if ((r107 instanceof FrameLayout.LayoutParams) == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        int r109 = r108.gravity;
        if (r105 <= r101) goto L8;
        int r110 = r102 + r104;
    L10:
        if (r101 == r108.width) goto L12;
    L17:
        r108.width = r101;
        r108.height = r106;
        r108.setMarginStart(r110);
        r108.gravity = r103;
        setLayoutParams(r107);
        return;
    L12:
        if (r106 != r108.height) goto L17;
        if (r110 != r108.getMarginStart()) goto L17;
        if (r103 != r108.gravity) goto L17;
        return;
    L8:
        r110 = r104 + 0;
        r101 = r105;
        goto L10
    }

    public WikiItemBackgroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        setClickable(false);
    }
}
