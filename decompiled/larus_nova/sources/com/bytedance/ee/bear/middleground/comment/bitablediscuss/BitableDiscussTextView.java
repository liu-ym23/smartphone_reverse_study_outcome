package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussTextView;", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDiscussTextView extends CommentTextView {
    public BitableDiscussTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 == 0) goto L6;
        if (r101 == 1) goto L6;
    L18:
        return super.onTouchEvent(r100);
    L6:
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        int r105 = r103 - getTotalPaddingLeft();
        int r106 = r104 - getTotalPaddingTop();
        int r107 = r105 + getScrollX();
        int r108 = r106 + getScrollY();
        Layout r109 = getLayout();
        int r110 = r109.getOffsetForHorizontal(r109.getLineForVertical(r108), r107);
        if ((getText() instanceof Spannable) == false) goto L9;
        CharSequence r111 = getText();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.text.Spannable");
        Spannable r112 = (Spannable) r111;
    L10:
        if (r112 == null) goto L18;
        ClickableSpan[] r113 = (ClickableSpan[]) r112.getSpans(r110, r110, ClickableSpan.class);
        Intrinsics.checkNotNull(r113);
        if (r113.length == 0) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L18;
        return false;
    L9:
        r112 = null;
        goto L10
    }

    public BitableDiscussTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public BitableDiscussTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
