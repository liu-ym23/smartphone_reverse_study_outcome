package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import com.larksuite.framework.utils.b0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f439432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f439433b = null;

    static {
        f439433b = new NoCopySpan.Concrete();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return super.canSelectArbitrarily();
    }

    public b() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r100, Spannable r101) {
        if (a(3, r100, r101) == false) goto L7;
        return true;
    L7:
        return super.down(r100, r101);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void initialize(TextView r100, Spannable r101) {
        Selection.removeSelection(r101);
        r101.removeSpan(f439433b);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r100, Spannable r101) {
        if (a(2, r100, r101) == false) goto L7;
        return true;
    L7:
        return super.left(r100, r101);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r100, Spannable r101) {
        if (a(3, r100, r101) == false) goto L7;
        return true;
    L7:
        return super.right(r100, r101);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r100, Spannable r101) {
        if (a(2, r100, r101) == false) goto L7;
        return true;
    L7:
        return super.up(r100, r101);
    }

    public static boolean a(int r100, TextView r101, Spannable r110) {
        Layout r102 = r101.getLayout();
        int r103 = r101.getTotalPaddingTop() + r101.getTotalPaddingBottom();
        int r104 = r101.getScrollY();
        int r105 = (r101.getHeight() + r104) - r103;
        int r106 = r102.getLineForVertical(r104);
        int r107 = r102.getLineForVertical(r105);
        int r108 = r102.getLineStart(r106);
        int r109 = r102.getLineEnd(r107);
        d[] r111 = (d[]) r110.getSpans(r108, r109, d.class);
        d[] r112 = (d[]) r110.getSpans(r108, r109, d.class);
        int r113 = Selection.getSelectionStart(r110);
        int r114 = Selection.getSelectionEnd(r110);
        int r115 = Math.min(r113, r114);
        int r116 = Math.max(r113, r114);
        if (r115 >= 0) goto L8;
        if (r110.getSpanStart(f439433b) < 0) goto L8;
        r115 = r110.length();
        r116 = r115;
    L8:
        if (r115 <= r109) goto L10;
        r116 = Integer.MAX_VALUE;
        r115 = Integer.MAX_VALUE;
    L10:
        int r117 = -1;
        if (r116 >= r108) goto L14;
        r116 = -1;
        r115 = -1;
    L14:
        if (r100 != 1) goto L16;
        if (r115 != r116) goto L46;
        return false;
    L46:
        d[] r118 = (d[]) r110.getSpans(r115, r116, d.class);
        if (r118.length != 1) goto L50;
        r118[0].c(r101);
    L52:
        return false;
    L50:
        if (r112.length != 1) goto L52;
        r112[0].c(r101);
        goto L52
    L16:
        if (r100 != 2) goto L18;
        int r119 = -1;
        int r120 = 0;
    L34:
        if (r120 >= r111.length) goto L41;
        int r121 = r110.getSpanEnd(r111[r120]);
        if (r121 < r116) goto L38;
        if (r115 == r116) goto L38;
    L40:
        r120 = r120 + 1;
    L38:
        if (r121 <= r119) goto L40;
        r117 = r110.getSpanStart(r111[r120]);
        r119 = r121;
        goto L40
    L41:
        if (r117 < 0) goto L52;
        Selection.setSelection(r110, r119, r117);
        return true;
    L18:
        if (r100 != 3) goto L52;
        int r122 = 0;
        int r123 = Integer.MAX_VALUE;
        int r124 = Integer.MAX_VALUE;
    L22:
        if (r122 >= r111.length) goto L29;
        int r125 = r110.getSpanStart(r111[r122]);
        if (r125 > r115) goto L26;
        if (r115 == r116) goto L26;
    L28:
        r122 = r122 + 1;
    L26:
        if (r125 >= r124) goto L28;
        r123 = r110.getSpanEnd(r111[r122]);
        r124 = r125;
        goto L28
    L29:
        if (r123 >= Integer.MAX_VALUE) goto L52;
        Selection.setSelection(r110, r124, r123);
        return true;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void onTakeFocus(TextView r100, Spannable r101, int r102) {
        Selection.removeSelection(r101);
        if ((r102 & 1) == 0) goto L5;
        r101.setSpan(f439433b, 0, 0, 34);
        return;
    L5:
        r101.removeSpan(f439433b);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r110) {
        int r102 = r110.getAction();
        if (r102 == 1) goto L5;
        if (r102 == 0) goto L5;
    L35:
        return super.onTouchEvent(r100, r101, r110);
    L5:
        int r103 = (int) r110.getX();
        int r104 = (int) r110.getY();
        int r105 = r103 - r100.getTotalPaddingLeft();
        int r106 = r104 - r100.getTotalPaddingTop();
        int r107 = r105 + r100.getScrollX();
        int r108 = r106 + r100.getScrollY();
        Layout r109 = r100.getLayout();
        int r111 = r109.getLineForVertical(r108);
        float r112 = r107;
        int r113 = r109.getOffsetForHorizontal(r111, r112);
        if (r109.getLineRight(r111) >= r112) goto L8;
    L36:
        return true;
    L8:
        if (r109.getLineLeft(r111) > r112) goto L36;
        d[] r114 = (d[]) r101.getSpans(r113, r113, d.class);
        if (r114.length == 0) goto L28;
        d r115 = r114[0];
        if (r102 != 1) goto L15;
        r115.c(r100);
    L27:
        return true;
    L15:
        if (r102 != 0) goto L27;
        if (r100.getContext().getApplicationInfo().targetSdkVersion >= 28) goto L37;
    L26:
        Selection.setSelection(r101, r101.getSpanStart(r115), r101.getSpanEnd(r115));
        goto L27
    L37:
        Method r116 = b0.b(TextView.class, "hideFloatingToolbar", new Class[]{Integer.class});     // Catch: Throwable -> L22 IllegalAccessException -> L24
        if (r116 == null) goto L26;
        r116.setAccessible(true);     // Catch: Throwable -> L22 IllegalAccessException -> L24
        r116.invoke(r100, new Object[]{200});     // Catch: Throwable -> L22 IllegalAccessException -> L24
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L28:
        a[] r117 = (a[]) r101.getSpans(r113, r113, a.class);
        if (r117.length == 0) goto L33;
        a r118 = r117[0];
        if (r102 != 1) goto L35;
        r118.c(r100);
        goto L35
    L33:
        Selection.removeSelection(r101);
        goto L35
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod
    public final boolean handleMovementKey(TextView r100, Spannable r101, int r102, int r103, KeyEvent r104) {
        return super.canSelectArbitrarily();
    }
}
