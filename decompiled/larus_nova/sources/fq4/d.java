package fq4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends LinkMovementMethod {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f478415b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f478416a;

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean bottom(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineEnd(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineStart(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageDown(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageUp(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean top(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r100, Spannable r101) {
        return false;
    }

    public d() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r110, MotionEvent r111) {
        int r101 = r111.getAction();
        if (r101 == 1) goto L5;
        if (r101 == 0) goto L5;
    L21:
        return false;
    L5:
        int r102 = (int) r111.getX();
        int r112 = (int) r111.getY();
        int r103 = r102 - r100.getTotalPaddingLeft();
        int r113 = r112 - r100.getTotalPaddingTop();
        int r104 = r103 + r100.getScrollX();
        int r114 = r113 + r100.getScrollY();
        Layout r105 = r100.getLayout();
        int r115 = r105.getLineForVertical(r114);
        float r106 = r104;
        int r107 = r105.getOffsetForHorizontal(r115, r106);
        ClickableSpan[] r108 = (ClickableSpan[]) r110.getSpans(r107, r107, ClickableSpan.class);
        if (r108.length == 0) goto L20;
        if (r101 == 1) goto L9;
        this.f478416a = System.currentTimeMillis();
    L19:
        return true;
    L9:
        if (r115 == (r100.getLineCount() - 1)) goto L11;
    L13:
        boolean r116 = false;
    L14:
        tt5.a.b("NoScrollingLinkMovement", "touch area: " + r116);
        if ((System.currentTimeMillis() - this.f478416a) >= 500) goto L19;
        if (r116 == true) goto L19;
        r108[0].onClick(r100);
        goto L19
    L11:
        if (r106 <= r105.getLineRight(r100.getLineCount() - 1)) goto L13;
        r116 = true;
        goto L14
    L20:
        Selection.removeSelection(r110);
        goto L21
    }
}
