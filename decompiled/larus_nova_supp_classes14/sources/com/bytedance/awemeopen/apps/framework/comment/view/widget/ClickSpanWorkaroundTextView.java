package com.bytedance.awemeopen.apps.framework.comment.view.widget;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ClickSpanWorkaroundTextView extends DmtTextView {
    public MentionTextView.c a;

    public ClickSpanWorkaroundTextView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r6) {
        super/*android.widget.TextView*/.onTouchEvent(r6);     // Catch: Exception -> L5
    L7:
        int r2 = r6.getAction();
        if (r2 != 0) goto L10;
        MentionTextView.c r3 = (MentionTextView.c) x(r6, MentionTextView.c.class);
        if (r3 == null) goto L38;
        r3.a(true);
        this.a = r3;
        return true;
    L38:
        if (x(r6, ClickableSpan.class) != null) goto L44;
        return false;
    L44:
        return true;
    L10:
        if (r2 != 1) goto L12;
        MentionTextView.c r4 = this.a;
        if (r4 != null) goto L29;
    L32:
        return false;
    L29:
        if (r4 != x(r6, MentionTextView.c.class)) goto L32;
        this.a.a(false);
        this.a.onClick(this);
        this.a = null;
        return true;
    L12:
        if (r2 != 2) goto L14;
        MentionTextView.c r0 = this.a;
        if (r0 != null) goto L23;
    L25:
        return false;
    L23:
        if (r0 == x(r6, MentionTextView.c.class)) goto L25;
        this.a.a(false);
        this.a = null;
        goto L25
    L14:
        if (r2 == 3) goto L16;
        return false;
    L16:
        MentionTextView.c r7 = this.a;
        if (r7 == null) goto L19;
        r7.a(false);
        this.a = null;
    L19:
        return false;
    L5:
        e = move-exception;
        AoLogger.c("ClickSpanWorkaroundTextView", new Object[]{e});
        goto L7
    }

    public ClickSpanWorkaroundTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ClickableSpan> T x(MotionEvent r11, Class<T> r12) {
        if ((getText() instanceof Spanned) == true) goto L5;
        return null;
    L5:
        Spanned r0 = (Spanned) getText();
        int r2 = (((int) r11.getX()) - getTotalPaddingLeft()) + getScrollX();
        int r13 = (((int) r11.getY()) - getTotalPaddingTop()) + getScrollY();
        Layout r3 = getLayout();
        if (r3 != null) goto L39;
        return null;
    L39:
        int r14 = r3.getLineForVertical(r13);     // Catch: Exception -> L38
        float r4 = r2;
        if (r3.getLineWidth(r14) >= r4) goto L11;
        return null;
    L11:
        int r5 = Build.VERSION.SDK_INT;     // Catch: Exception -> L38
        boolean r6 = true;
        if (r5 >= 28) goto L14;
    L26:
        int r7 = r3.getOffsetForHorizontal(r14, r4);     // Catch: Exception -> L38
    L27:
        ClickableSpan[] r15 = (ClickableSpan[]) r0.getSpans(r7, r7, r12);
        if (r15.length <= 0) goto L42;
        ClickableSpan r16 = r15[0];
        if (r7 >= r0.getSpanStart(r16)) goto L32;
    L34:
        r6 = false;
    L35:
        if (r6 == true) goto L37;
        return null;
    L37:
        return (T) r15[0];
    L32:
        if (r7 > r0.getSpanEnd(r16)) goto L34;
    L42:
        return null;
    L14:
        if ((r3.getText() instanceof PrecomputedText) == false) goto L26;
        if (r5 >= 28) goto L17;
    L25:
        r7 = 0;
        goto L27
    L17:
        if ((r3.getText() instanceof PrecomputedText) == false) goto L25;
        TextPaint r8 = getPaint();     // Catch: Exception -> L38
        int r9 = r3.getLineStart(r14);     // Catch: Exception -> L38
        int r17 = r3.getLineStart(r14 + 1);     // Catch: Exception -> L38
        int r10 = r9 + 1;     // Catch: Exception -> L38
    L19:
        if (r10 > r17) goto L24;
        if (r8.measureText(r3.getText(), r9, r10) >= r4) goto L22;
        r10 = r10 + 1;     // Catch: Exception -> L38
        goto L19
    L22:
        r9 = r10;
    L24:
        r7 = r9 - 1;     // Catch: Exception -> L38
        goto L27
    L44:
        return null;
    }

    public ClickSpanWorkaroundTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
