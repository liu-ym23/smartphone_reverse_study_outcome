package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectLKUIRoundLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "generateLayoutParams", "Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;", "generateDefaultLayoutParams", "LayoutParams", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBubbleContainerLayout extends MeasureDetectLKUIRoundLinearLayout {

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0006\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b\u0006\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "weight", "", "(IIF)V", "p", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/LinearLayout$LayoutParams;)V", "(Lcom/ss/android/lark/chatwindow/view/widget/ChatBubbleContainerLayout$LayoutParams;)V", "fitParentWidth", "", "getFitParentWidth", "()Z", "setFitParentWidth", "(Z)V", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f417127a;

        public LayoutParams(LinearLayout.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "p");
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.fixParentWidth});
            this.f417127a = r102.getBoolean(0, false);
            r102.recycle();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public ChatBubbleContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public ChatBubbleContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.ss.android.lark.chatwindow.view.widget.MeasureDetectLKUIRoundLinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        Iterator<View> r103 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r103.hasNext() == false) goto L19;
        View r104 = r103.next();
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof LayoutParams) == false) goto L8;
        LayoutParams r106 = (LayoutParams) r105;
    L10:
        if (r106 == null) goto L14;
        boolean r107 = true;
        if (r106.f417127a != true) goto L14;
    L15:
        if (r107 == false) goto L4;
        if (r104.getMeasuredWidth() >= r102) goto L4;
        r104.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    L14:
        r107 = false;
        goto L15
    L8:
        r106 = null;
        goto L10
    }
}
