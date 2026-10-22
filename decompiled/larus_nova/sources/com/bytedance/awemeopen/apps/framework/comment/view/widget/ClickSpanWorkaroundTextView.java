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

/* JADX INFO: loaded from: classes14.dex */
public class ClickSpanWorkaroundTextView extends DmtTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MentionTextView.c f194310a;

    public ClickSpanWorkaroundTextView(Context r100) {
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        super.onTouchEvent(r100);     // Catch: Exception -> L5
    L7:
        int r101 = r100.getAction();
        if (r101 != 0) goto L10;
        MentionTextView.c r102 = (MentionTextView.c) x(r100, MentionTextView.c.class);
        if (r102 == null) goto L38;
        r102.a(true);
        this.f194310a = r102;
        return true;
    L38:
        if (x(r100, ClickableSpan.class) != null) goto L44;
        return false;
    L44:
        return true;
    L10:
        if (r101 != 1) goto L12;
        MentionTextView.c r103 = this.f194310a;
        if (r103 != null) goto L29;
    L32:
        return false;
    L29:
        if (r103 != x(r100, MentionTextView.c.class)) goto L32;
        this.f194310a.a(false);
        this.f194310a.onClick(this);
        this.f194310a = null;
        return true;
    L12:
        if (r101 != 2) goto L14;
        MentionTextView.c r104 = this.f194310a;
        if (r104 != null) goto L23;
    L25:
        return false;
    L23:
        if (r104 == x(r100, MentionTextView.c.class)) goto L25;
        this.f194310a.a(false);
        this.f194310a = null;
        goto L25
    L14:
        if (r101 == 3) goto L16;
        return false;
    L16:
        MentionTextView.c r105 = this.f194310a;
        if (r105 == null) goto L19;
        r105.a(false);
        this.f194310a = null;
    L19:
        return false;
    L5:
        e = move-exception;
        AoLogger.c("ClickSpanWorkaroundTextView", new Object[]{e});
        goto L7
    }

    public ClickSpanWorkaroundTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final <T extends ClickableSpan> T x(MotionEvent r110, Class<T> r111) {
        if ((getText() instanceof Spanned) == true) goto L5;
        return null;
    L5:
        Spanned r100 = (Spanned) getText();
        int r101 = (((int) r110.getX()) - getTotalPaddingLeft()) + getScrollX();
        int r112 = (((int) r110.getY()) - getTotalPaddingTop()) + getScrollY();
        Layout r102 = getLayout();
        if (r102 != null) goto L39;
        return null;
    L39:
        int r113 = r102.getLineForVertical(r112);     // Catch: Exception -> L38
        float r103 = r101;
        if (r102.getLineWidth(r113) >= r103) goto L11;
        return null;
    L11:
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L38
        boolean r105 = true;
        if (r104 >= 28) goto L14;
    L26:
        int r106 = r102.getOffsetForHorizontal(r113, r103);     // Catch: Exception -> L38
    L27:
        ClickableSpan[] r114 = (ClickableSpan[]) r100.getSpans(r106, r106, r111);
        if (r114.length <= 0) goto L42;
        ClickableSpan r115 = r114[0];
        if (r106 >= r100.getSpanStart(r115)) goto L32;
    L34:
        r105 = false;
    L35:
        if (r105 == true) goto L37;
        return null;
    L37:
        return (T) r114[0];
    L32:
        if (r106 > r100.getSpanEnd(r115)) goto L34;
    L42:
        return null;
    L14:
        if ((r102.getText() instanceof PrecomputedText) == false) goto L26;
        if (r104 >= 28) goto L17;
    L25:
        r106 = 0;
        goto L27
    L17:
        if ((r102.getText() instanceof PrecomputedText) == false) goto L25;
        TextPaint r107 = getPaint();     // Catch: Exception -> L38
        int r108 = r102.getLineStart(r113);     // Catch: Exception -> L38
        int r116 = r102.getLineStart(r113 + 1);     // Catch: Exception -> L38
        int r109 = r108 + 1;     // Catch: Exception -> L38
    L19:
        if (r109 > r116) goto L24;
        if (r107.measureText(r102.getText(), r108, r109) >= r103) goto L22;
        r109 = r109 + 1;     // Catch: Exception -> L38
        goto L19
    L22:
        r108 = r109;
    L24:
        r106 = r108 - 1;     // Catch: Exception -> L38
        goto L27
    L44:
        return null;
    }

    public ClickSpanWorkaroundTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
