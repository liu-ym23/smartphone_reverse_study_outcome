package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.R;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Rect;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.at.AtConstant$Zone;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.bytedance.supervisor.token.Token;
import hp4.v;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public class BitableAtEditText extends AtEditText implements gp4.g, com.bytedance.ee.bear.bitable.common.widgets.flex.c.b, View.OnTouchListener {
    public c P1;
    public v Q1;
    public final com.bytedance.ee.bear.bitable.common.widgets.flex.c S1;
    public boolean T1;
    public boolean V1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final boolean f208210b2;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public View.OnTouchListener f208211g2;

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public String getCopyToken() {
        return "LARK-PSDA-bitable_edit_text_base_set_clipboard";
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public String getPasteToken() {
        return "LARK-PSDA-bitable_edit_text_base_get_clipboard";
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final boolean p() {
        return canScrollVertically(1);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final boolean s() {
        return canScrollVertically(-1);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public c getPresenter() {
        if (this.P1 != null) goto L6;
        this.P1 = new c(this);
    L6:
        return this.P1;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public ClipData getPrimaryClip() {
        String r100 = this.Q1.getEncryptedId();     // Catch: Throwable -> L10
        String r101 = this.Q1.P0();     // Catch: Throwable -> L10
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L9;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).k(r100, new Token(getPasteToken()));
    L9:
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).l(new Token(getPasteToken()));
    L11:
        return super.getPrimaryClip();
    }

    public final int K() {
        if (ku5.c.k(getContext()) == true) goto L5;
    L9:
        double r100 = com.bytedance.ee.util.ui.n.t();
        double r101 = 0.15d;
    L8:
        return (int) (r100 * r101);
    L5:
        if (com.bytedance.ee.util.ui.n.C(getContext()) == false) goto L9;
        r100 = com.bytedance.ee.util.ui.n.t();
        r101 = 0.1d;
        goto L8
    }

    public final void L() {
        if (isFocused() == true) goto L6;
        requestFocus();
    L6:
        if (isCursorVisible() == true) goto L8;
    L12:
        setSelection(length());
        return;
    L8:
        if (getSelectionStart() == (-1)) goto L12;
        if (getSelectionEnd() == (-1)) goto L12;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCursorVisible(false);
        setCursorVisible(true);
        v r100 = this.Q1;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.canEdit() == true) goto L9;
        setCursorVisible(false);
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPresenter().v();
    }

    public v getCopyChecker() {
        return this.Q1;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public /* bridge */ /* synthetic */ com.bytedance.ee.bear.widget.l getPresenter() {
        return getPresenter();
    }

    public BitableAtEditText(Context r100) {
        this(r100, null);
        if (this.f208210b2 == false) goto L5;
        tt5.a.h("BitableAtEditText", "unset onTouchListener internal");
        return;
    L5:
        super.setOnTouchListener(this);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean A(ClipData r100) {
        String r101 = this.Q1.P0();     // Catch: Throwable -> L16
        String r102 = this.Q1.getEncryptedId();     // Catch: Throwable -> L16
        if (com.bytedance.ee.bear.bitable.utils.g.b() == true) goto L5;
    L7:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).m(r100, this.f240349p0, new Token(getCopyToken()));     // Catch: Throwable -> L16
    L8:
        v r103 = this.Q1;     // Catch: Throwable -> L16
        if (r103 == null) goto L11;
        boolean r104 = r103.t1();     // Catch: Throwable -> L16
    L12:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();     // Catch: Throwable -> L16
        jg5.k.a.f499019a.d(r104, true);     // Catch: Throwable -> L16
        return true;
    L11:
        r104 = false;
        goto L12
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).g(r102, r100, this.f240349p0, new Token(getCopyToken()));     // Catch: Throwable -> L16
    L17:
        return super.A(r100);
    }

    public final void M(float r100) {
        setMaxHeight((int) (((getLineHeight() * r100) + getPaddingTop()) + getPaddingBottom()));
        this.T1 = true;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final void a(boolean r100) {
        if (getParent() != null) goto L5;
        return;
    L5:
        if (getSelectionStart() == getSelectionEnd()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        getParent().requestDisallowInterceptTouchEvent(r100);
        return;
    L12:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.T1 == false) goto L6;
        this.S1.a(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908321) goto L10;
        v r101 = this.Q1;
        if (r101 == null) goto L34;
        if (r101.S1(r100) == true) goto L34;
        return true;
    L34:
        return super.onTextContextMenuItem(r100);
    L10:
        if (r100 != 16908320) goto L23;
        v r102 = this.Q1;
        if (r102 != null) goto L14;
    L17:
        v r103 = this.Q1;
        if (r103 == null) goto L34;
        if (r103.S1(r100) == true) goto L34;
        return true;
    L14:
        if (r102.canEdit() == true) goto L17;
        return onTextContextMenuItem(R.id.copy);
    L23:
        if (r100 != 16908319) goto L26;
        Selection.selectAll(getText());
        goto L34
    L26:
        if (r100 != 16908322) goto L34;
        v r104 = this.Q1;
        if (r104 == null) goto L34;
        if (r104.canEdit() == true) goto L34;
        Selection.removeSelection(getText());
        return true;
    }

    @Override // com.larksuite.component.universe_design.edittext.UDEditText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.V1 == true) goto L17;
        return false;
    L17:
    L14:
        e = move-exception;
        tt5.a.e("BitableAtEditText", "onTouchEvent error", e, false);
        return false;
    L6:
        if (r100.getAction() == 0) goto L8;
    L12:
        return super.onTouchEvent(r100);
    L8:
        if (isFocusable() == false) goto L12;
        if (isFocusableInTouchMode() == false) goto L12;
        requestFocus();     // Catch: Exception -> L14
        goto L12
    }

    public void setFocusableAndClickable(boolean r100) {
        setFocusable(r100);
        setFocusableInTouchMode(r100);
        setClickable(r100);
        setLongClickable(r100);
    }

    @Override // gp4.g
    public void setIPermissionCopyChecker(v r100) {
        this.Q1 = r100;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r100) {
        tt5.a.h("BitableAtEditText", "setOnTouchListener l=" + r100);
        if (this.f208210b2 == true) goto L5;
        this.f208211g2 = r100;
    L5:
        super.setOnTouchListener(r100);
    }

    public void setPresenter(c r100) {
        this.P1 = r100;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r100) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == true) goto L5;
        return true;
    L5:
        if (r100 == false) goto L11;
        v r101 = this.Q1;
        if (r101 != null) goto L9;
        return true;
    L9:
        if (r101.canCopy() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public BitableAtEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        if (this.f208210b2 == false) goto L5;
        tt5.a.h("BitableAtEditText", "unset onTouchListener internal");
        return;
    L5:
        super.setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        View.OnTouchListener r102 = this.f208211g2;
        if (r102 == null) goto L7;
        return r102.onTouch(r100, r101);
    L7:
        if (r101.getAction() != 0) goto L15;
        tt5.a.b("BitableAtEditText", "onTouch action down");
        if (isFocusable() == true) goto L11;
        return false;
    L11:
        if (isFocusableInTouchMode() == false) goto L17;
        requestFocus();
        return false;
    L17:
        return false;
    L15:
        return false;
    }

    public BitableAtEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.S1 = new com.bytedance.ee.bear.bitable.common.widgets.flex.c(this);
        this.T1 = false;
        this.V1 = true;
        boolean r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.bitableedittext.selectionclick.disable");
        this.f208210b2 = r103;
        if (r103 == false) goto L5;
        tt5.a.h("BitableAtEditText", "unset onTouchListener internal");
        return;
    L5:
        super.setOnTouchListener(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        v r103 = this.Q1;
        if (r103 != null) goto L5;
    L7:
        super.onFocusChanged(r100, r101, r102);
        return;
    L5:
        if (r103.canEdit() == true) goto L7;
        rcb.c.b(this);
        goto L7
    }

    public final void N(String r100, int r101, View r110, AtFinderView r111, ArrayList r112, kn4.g.b r113) {
        if (getAtWindow() != null) goto L11;
        com.bytedance.ee.bear.document.at.m.a();
        kn4.h r102 = new kn4.h(kn4.f.a().a(), AtUtils.h(sbb.e.d(r101)), r100, AtConstant$Zone.FX_BAR, "text");
        r102.f504237h = K();
        r102.f504235f = r110;
        r102.f504236g = null;
        r102.f504245p = kn4.f.a().b();
        if (r111 == null) goto L7;
        r102.f504241l = r111;
        r102.f504240k = 1;
    L7:
        if (r112 == null) goto L9;
        r102.f504239j = AtUtils.c();
    L9:
        C(r102);
        getAtWindow().b(r113);
        getAtWindow().f(new a((BitableTextFieldEditor) this));
        return;
    }
}
