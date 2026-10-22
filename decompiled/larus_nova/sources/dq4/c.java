package dq4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f469664a;

    public c() {
        this.f469664a = false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r110) {
        int r102 = 0;
        this.f469664a = false;
        int r103 = r110.getAction();
        if (r103 == 1) goto L14;
        if (r103 == 0) goto L14;
        if (r103 != 3) goto L13;
        b[] r104 = (b[]) r101.getSpans(0, r101.length(), b.class);
        int r111 = r104.length;
    L9:
        if (r102 >= r111) goto L11;
        r104[r102].a(r100);
        r102 = r102 + 1;
        goto L9
    L11:
        return true;
    L13:
        return super.onTouchEvent(r100, r101, r110);
    L14:
        int r105 = (int) r110.getX();
        int r112 = (int) r110.getY();
        int r106 = r105 - r100.getTotalPaddingLeft();
        int r113 = r112 - r100.getTotalPaddingTop();
        int r107 = r106 + r100.getScrollX();
        int r114 = r113 + r100.getScrollY();
        Layout r108 = r100.getLayout();
        int r115 = r108.getLineForVertical(r114);
        float r109 = r107;
        int r116 = r108.getOffsetForHorizontal(r115, r109);
        b[] r117 = (b[]) r101.getSpans(r116, r116, b.class);
        if (r117.length == 0) goto L29;
        b r118 = r117[0];
        if (r115 == (r100.getLineCount() - 1)) goto L19;
    L21:
        if (r102 != 0) goto L29;
        this.f469664a = true;
        if (r103 == 0) goto L27;
        if (r103 != 1) goto L29;
        r118.onClick(r100);
        goto L29
    L27:
        r118.b(r100);
        goto L29
    L19:
        if (r109 <= r108.getLineRight(r115)) goto L21;
        r102 = 1;
    L29:
        if (Selection.getSelectionStart(r101) != (-1)) goto L31;
        Selection.setSelection(r101, r101.length());
    L31:
        return true;
    }
}
