package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f208243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f208244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f208245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f208246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f208247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f208248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f208249g;

    public class a extends ArrowKeyMovementMethod {
        public a() {
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        public final boolean down(TextView r100, Spannable r101) {
            return super.down(r100, r101);
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        public final boolean left(TextView r100, Spannable r101) {
            return super.left(r100, r101);
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        public final boolean right(TextView r100, Spannable r101) {
            return super.right(r100, r101);
        }

        @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
        public final boolean up(TextView r100, Spannable r101) {
            return super.up(r100, r101);
        }
    }

    public e() {
        this.f208244b = new a();
        this.f208245c = true;
        this.f208249g = 0.0f;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r100, Spannable r101) {
        if (super.down(r100, r101) == false) goto L7;
        return true;
    L7:
        return this.f208244b.down(r100, r101);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r100, Spannable r101) {
        boolean r102 = super.left(r100, r101);
        if (r102 == false) goto L11;
        return true;
    L11:
        return this.f208244b.left(r100, r101);
    L8:
        e = move-exception;
        tt5.a.d("EditSupportLinkMovementMethod", e.getMessage());
        return r102;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r100, Spannable r101) {
        boolean r102 = super.right(r100, r101);
        if (r102 == false) goto L11;
        return true;
    L11:
        return this.f208244b.right(r100, r101);
    L8:
        e = move-exception;
        tt5.a.d("EditSupportLinkMovementMethod", e.getMessage());
        return r102;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r100, Spannable r101) {
        if (super.up(r100, r101) == false) goto L7;
        return true;
    L7:
        return this.f208244b.up(r100, r101);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r110, Spannable r111, MotionEvent r112) {
        int r100 = r112.getAction();
        if (r100 == 1) goto L22;
        if (r100 == 0) goto L22;
        if (this.f208245c == false) goto L21;
        if (r100 != 0) goto L11;
        this.f208247e = r112.getX();
        this.f208248f = r112.getY();
        this.f208246d = false;
        goto L21
    L11:
        if (r112.getAction() != 2) goto L21;
        float r101 = r112.getX();
        float r102 = r112.getY();
        Context r103 = r110.getContext();
        if (this.f208249g != 0.0f) goto L16;
        this.f208249g = ViewConfiguration.get(r103).getScaledTouchSlop();
    L16:
        if (Math.abs(this.f208247e - r101) <= this.f208249g) goto L18;
    L19:
        this.f208246d = true;
        goto L21
    L18:
        if (Math.abs(this.f208248f - r102) > this.f208249g) goto L19;
    L21:
        return super.onTouchEvent(r110, r111, r112);
    L22:
        int r104 = (int) r112.getX();
        int r105 = (int) r112.getY();
        int r106 = r104 - r110.getTotalPaddingLeft();
        int r107 = r105 - r110.getTotalPaddingTop();
        int r108 = r106 + r110.getScrollX();
        int r109 = r107 + r110.getScrollY();
        Layout r113 = r110.getLayout();
        int r114 = r113.getLineForVertical(r109);
        float r115 = r108;
        int r116 = r113.getOffsetForHorizontal(r114, r115);
        ClickableSpan[] r117 = (ClickableSpan[]) r111.getSpans(r116, r116, ClickableSpan.class);
        if (r117.length == 0) goto L42;
        ClickableSpan r118 = r117[0];
        if (r100 != 1) goto L51;
        if (r111.getSpanEnd(r118) != r116) goto L29;
        boolean r119 = true;
    L31:
        if (r114 == (r110.getLineCount() - 1)) goto L33;
    L35:
        boolean r120 = false;
    L36:
        if (r119 == true) goto L39;
        if (r120 == true) goto L39;
        r118.onClick(r110);
    L39:
        d r121 = this.f208243a;
        if (r121 == null) goto L51;
        r121.F1(r110);
        goto L51
    L33:
        if (r115 <= r113.getLineRight(r114)) goto L35;
        r120 = true;
        goto L36
    L29:
        r119 = false;
    L51:
        if (this.f208245c == false) goto L58;
        if (Selection.getSelectionStart(r111) != (-1)) goto L61;
        if (r111.length() != 0) goto L61;
        Selection.setSelection(r111, 0);
    L61:
        if (this.f208245c == false) goto L63;
        Touch.onTouchEvent(r110, r111, r112);
    L63:
        return true;
    L58:
        if (Selection.getSelectionStart(r111) != (-1)) goto L61;
        Selection.setSelection(r111, r111.length());
        goto L61
    L42:
        if (r100 != 1) goto L51;
        d r122 = this.f208243a;
        if (r122 == null) goto L51;
        if (this.f208245c == true) goto L48;
    L49:
        r122.F1(r110);
        goto L51
    L48:
        if (this.f208246d == true) goto L51;
        goto L49
    }
}
