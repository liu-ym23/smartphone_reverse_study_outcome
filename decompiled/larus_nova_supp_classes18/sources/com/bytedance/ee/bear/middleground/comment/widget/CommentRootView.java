package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0014J\b\u0010\u001b\u001a\u00020\u000fH\u0014J\b\u0010\u001c\u001a\u00020\u000fH\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentRootView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "", "isShown", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "onAttachedToWindow", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentRootView extends FrameLayout {
    public String a;

    @Override // android.view.View
    public final boolean isShown() {
        return super.isShown();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h(this.a, "onAttachedToWindow ");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h(this.a, "onDetachedFromWindow ");
    }

    public final String getLogTag() {
        return this.a;
    }

    public CommentRootView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setLogTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public CommentRootView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "Comment#CommentRootView";
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "changedView");
        super.onVisibilityChanged(r3, r4);
        tt5.a.h(this.a, "onVisibilityChanged " + r4);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        tt5.a.h(this.a, "onSizeChanged " + r4 + ' ' + r5 + ' ' + r6 + ' ' + r7);
    }
}
