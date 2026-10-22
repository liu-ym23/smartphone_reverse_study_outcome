package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends LinkMovementMethod {
    public static final i b = null;
    public ProfileSignatureView.c a;

    public static final class a {
    }

    static {
        b = new i();
    }

    public i() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r9, Spannable r10, MotionEvent r11) {
        if (r11 == null) goto L65;
        if (r9 == null) goto L65;
        if (r10 == null) goto L65;
        Intrinsics.checkNotNullParameter(r9, "tv");
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(ProfileSignatureView.c.class, "clazz");
        CharSequence r1 = r9.getText();
        if ((r1 instanceof Spanned) == false) goto L35;
        float r2 = (r11.getX() - r9.getTotalPaddingLeft()) + r9.getScrollX();
        float r5 = (r11.getY() - r9.getTotalPaddingTop()) + r9.getScrollY();
        Layout r6 = r9.getLayout();
        int r7 = r6.getLineForVertical((int) r5);     // Catch: Exception -> L66
        if (r7 == (r6.getLineCount() - 1)) goto L13;
    L15:
        int r3 = r6.getOffsetForHorizontal(r7, r2);     // Catch: Exception -> L66
        Spanned r4 = (Spanned) r1;
        ClickableSpan[] r0 = (ClickableSpan[]) r4.getSpans(r3, r3, ProfileSignatureView.c.class);
        if (r0 != null) goto L19;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L35;
        ClickableSpan r12 = r0[0];
        if (r3 >= r4.getSpanStart(r12)) goto L30;
    L32:
        boolean r13 = false;
    L33:
        if (r13 == false) goto L35;
        ClickableSpan r14 = r0[0];
    L36:
        ProfileSignatureView.c r15 = (ProfileSignatureView.c) r14;
        if (r15 == null) goto L39;
        int r16 = r11.getAction();
        if (r16 == 0) goto L62;
        if (r16 == 1) goto L57;
        if (r16 == 2) goto L53;
        if (r16 != 3) goto L61;
        if (this.a == null) goto L61;
        this.a = null;
        return true;
    L61:
        return super.onTouchEvent(r9, r10, r11);
    L53:
        if (Intrinsics.areEqual(this.a, r15) == true) goto L55;
        this.a = null;
    L55:
        return true;
    L57:
        if (Intrinsics.areEqual(r15, this.a) == false) goto L61;
        r15.onClick(r9);
        this.a = null;
        return true;
    L62:
        this.a = r15;
        return true;
    L39:
        return super.onTouchEvent(r9, r10, r11);
    L30:
        if (r3 > r4.getSpanEnd(r12)) goto L32;
        r13 = true;
        goto L33
    L19:
        if (r0.length != 0) goto L21;
        boolean r17 = true;
    L23:
        if ((!r17) != true) goto L25;
        r8 = true;
        goto L26
    L21:
        r17 = false;
        goto L23
    L13:
        if (r6.getLineWidth(r7) >= r2) goto L15;
    L35:
        r14 = null;
    L65:
        return super.onTouchEvent(r9, r10, r11);
    }
}
