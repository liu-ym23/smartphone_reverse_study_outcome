package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussTextView;", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDiscussTextView extends CommentTextView {
    public BitableDiscussTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        boolean r1 = true;
        if (r0 == 0) goto L6;
        if (r0 == 1) goto L6;
    L18:
        return super/*android.widget.TextView*/.onTouchEvent(r5);
    L6:
        int r2 = (int) r5.getX();
        int r3 = (int) r5.getY();
        int r4 = r2 - getTotalPaddingLeft();
        int r6 = r3 - getTotalPaddingTop();
        int r7 = r4 + getScrollX();
        int r8 = r6 + getScrollY();
        Layout r9 = getLayout();
        int r10 = r9.getOffsetForHorizontal(r9.getLineForVertical(r8), r7);
        if ((getText() instanceof Spannable) == false) goto L9;
        CharSequence r11 = getText();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.text.Spannable");
        Spannable r12 = (Spannable) r11;
    L10:
        if (r12 == null) goto L18;
        ClickableSpan[] r13 = (ClickableSpan[]) r12.getSpans(r10, r10, ClickableSpan.class);
        Intrinsics.checkNotNull(r13);
        if (r13.length == 0) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L18;
        return false;
    L9:
        r12 = null;
        goto L10
    }

    public BitableDiscussTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public BitableDiscussTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
