package com.bytedance.ee.bear.widget;

import android.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.SuggestionSpan;
import android.util.AttributeSet;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.widgets.MaxHeightLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import io.reactivex.Single;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AtEditText extends SpaceEditText implements sa5.r, kn4.m {
    public static final /* synthetic */ int M1 = 0;
    public boolean G1;
    public boolean H1;
    public Fragment L1;
    public l V0;
    public MaxHeightLayout b1;
    public AtFinderView g1;
    public View h1;
    public kn4.g k1;
    public Context p1;
    public a v1;
    public c x1;
    public b y1;

    public interface a {
        void a();

        boolean b();
    }

    public interface b {
        void a();

        boolean onPaste(String r1);
    }

    public interface c {
        void a(boolean r1);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public boolean y(boolean r1) {
        return true;
    }

    public final void D() {
        kn4.g r0 = this.k1;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public final boolean F() {
        kn4.g r0 = this.k1;
        if (r0 == null) goto L5;
        boolean r1 = r0.isShowing();
    L6:
        if (r1 == false) goto L15;
        Context r2 = this.p1;
        if ((r2 instanceof Activity) == true) goto L10;
        rcb.c.c(r2);
        D();
        return true;
    L10:
        if (rcb.c.e((Activity) r2) == true) goto L15;
        D();
        return true;
    L15:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public void I() {
        kn4.g r0 = this.k1;
        if (r0 == null) goto L5;
        r0.show();
        return;
    L5:
        tt5.a.d("AtEditText", "showAtWindow: mAtWindow is null");
    }

    public l getPresenter() {
        if (this.V0 != null) goto L6;
        this.V0 = new l(this);
    L6:
        return this.V0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J() {
        int r0 = getSelectionStart();
        int r1 = getSelectionEnd();
        getPresenter().d().e = true;
        Editable r2 = getText();
        if (r2 != null) goto L7;
        tt5.a.d("AtEditText", "triggerAt: editable is null");
        return;
    L7:
        if (r0 == (-1)) goto L11;
        if (r1 == (-1)) goto L11;
        r2.replace(r0, r1, "@");
        return;
    L11:
        r2.replace(0, r2.length(), "@");
    }

    public final void Sw() {
        getPresenter().Sw();
    }

    public Single<String> getRichText() {
        return getPresenter().g();
    }

    public final void gr() {
        getPresenter().gr();
    }

    public kn4.g getAtWindow() {
        return this.k1;
    }

    public AtEditText(Context r2) {
        this(r2, null);
    }

    private void setAtTriggerListener(com.bytedance.ee.bear.widget.b.a r2) {
        getPresenter().d().a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(kn4.h r10) {
        if (this.k1 != null) goto L36;
        int r0 = r10.k;
        if (r0 != 0) goto L7;
        View r1 = LayoutInflater.from(this.p1).inflate(2131558731, null);
        this.h1 = r1;
        AtFinderView r2 = (AtFinderView) r1.findViewById(2131363311);
        this.g1 = r2;
        r2.setAtCommonConfig(r10.e);
        this.g1.setAtFinderViewDelegate(new d(this));
        this.b1 = (MaxHeightLayout) this.h1.findViewById(2131363309);
        d0 r3 = new d0(getContext(), this.h1, this.b1, this.g1, r10);
        this.k1 = r3;
        int r4 = r10.h;
        if (r4 == 0) goto L28;
        r3.e(r4);
    L28:
        View r5 = r10.f;
        if (r5 == null) goto L31;
        this.k1.h(r5);
    L31:
        View r11 = r10.g;
        if (r11 == null) goto L41;
        this.k1.d(r11);
        return;
    L41:
        return;
    L7:
        if (r0 != 1) goto L9;
        AtFinderView r6 = r10.l;
        if (r6 == null) goto L24;
        r6.setAtCommonConfig(r10.e);
        this.k1 = new z(getContext(), r10);
        return;
    L24:
        throw new NullPointerException("AtFinderView is null");
    L9:
        if (r0 == 2) goto L11;
        tt5.a.h("AtEditText", "bindAtWindow(): viewType is Undefined");
        return;
    L11:
        View r7 = r10.m;
        this.h1 = r7;
        this.g1 = (AtFinderView) r7.findViewById(2131363311);
        MaxHeightLayout r8 = (MaxHeightLayout) this.h1.findViewById(2131363309);
        this.g1.setAtCommonConfig(r10.e);
        this.g1.setAtFinderViewDelegate(new e(this));
        x r9 = new x(getContext(), this.h1, r8, this.g1, this, this.L1, r10);
        this.k1 = r9;
        int r12 = r10.h;
        if (r12 == 0) goto L14;
        r9.e(r12);
    L14:
        View r13 = r10.f;
        if (r13 == null) goto L17;
        this.k1.h(r13);
    L17:
        View r14 = r10.g;
        if (r14 == null) goto L38;
        this.k1.d(r14);
        return;
    L38:
        return;
    L36:
        throw new IllegalStateException("AtWindow already exist!!!");
    }

    public final void G(bo4.a r2) {
        getPresenter().j(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchKeyEvent(KeyEvent r1) {
        return super/*android.widget.EditText*/.dispatchKeyEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchKeyEventPreIme(KeyEvent r3) {
        if (r3.getKeyCode() != 4) goto L9;
        a r0 = this.v1;
        if (r0 == null) goto L9;
        return r0.b();
    L9:
        return super/*android.widget.EditText*/.dispatchKeyEventPreIme(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public boolean onTextContextMenuItem(int r13) {
        boolean r1 = false;
        if (getText() != null) goto L5;
        int r0 = 0;
    L7:
        if (isFocused() == false) goto L9;
        int r2 = getSelectionStart();
        int r3 = getSelectionEnd();
        int r4 = Math.max(0, Math.min(r2, r3));
        r0 = Math.max(0, Math.max(r2, r3));
    L11:
        if (r13 != 16908321) goto L13;
    L73:
        final SpannableStringBuilder r5 = (SpannableStringBuilder) ((SpannableStringBuilder) getText()).subSequence(r4, r0);
        CharSequence r6 = getEditableText().subSequence(r4, r0);
        getPresenter().getClass();
        tt5.a.b("DocEditTextPresenter", "filterCopiedText: ");
        un5.i[] r7 = (un5.i[]) r5.getSpans(0, r5.length(), un5.i.class);
        if (r7.length == 0) goto L85;
        int r8 = r7.length;
        int r9 = 0;
    L77:
        if (r9 >= r8) goto L82;
        un5.i r10 = r7[r9];
        if ((r10 instanceof un5.d) == false) goto L81;
        r5.delete(r5.getSpanStart(r10), r5.getSpanEnd(r10));
    L81:
        r5.removeSpan(r10);
        r9 = r9 + 1;
        goto L77
    L82:
        SuggestionSpan[] r11 = (SuggestionSpan[]) r5.getSpans(0, r5.length(), SuggestionSpan.class);
        int r12 = r11.length;
        int r14 = 0;
    L83:
        if (r14 >= r12) goto L85;
        r5.removeSpan(r11[r14]);
        r14 = r14 + 1;
    L85:
        boolean r15 = this.p0;
        setCopySecurityEnable(false);
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).c();
        super.onTextContextMenuItem(r13);
        setCopySecurityEnable(r15);
        if ((r6 instanceof SpannableStringBuilder) == true) goto L88;
    L94:
        A(ClipData.newPlainText("", r5));
    L95:
        return true;
    L88:
        if (this.H1 == true) goto L90;
    L92:
        if (r1 == false) goto L94;
        com.bytedance.ee.bear.utils.f.a((SpannableStringBuilder) r6, r5.toString(), getPresenter().e()).subscribe(new f(this), new g(this, r5));
        goto L95
    L90:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.copy.atmention.support") == false) goto L92;
        r1 = true;
        goto L92
    L13:
        if (r13 == 16908320) goto L73;
        if (r13 == 16908322) goto L21;
        if (r13 == 16908337) goto L21;
        return super.onTextContextMenuItem(r13);
    L21:
        ClipData r16 = getPrimaryClip();
        if (r13 != 16908322) goto L45;
        if (this.H1 == true) goto L26;
    L28:
        boolean r17 = false;
    L29:
        if (r17 == false) goto L45;
        if (r16 == null) goto L45;
        String[] r18 = r16.getDescription().filterMimeTypes("text/html");
        if (r18 == null) goto L45;
        if (r18.length <= 0) goto L45;
        final l r19 = getPresenter();
        final b r20 = this.y1;
        r19.getClass();
        final String r21 = r16.getItemAt(0).getHtmlText();
        if (TextUtils.isEmpty(r21) == true) goto L41;
        Matcher r110 = r19.h.matcher(r21);
        if (r110.find() == false) goto L41;
        Single.just(r110.group(1)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).map(new i(r19)).map(new eb5.b()).map(r19.f()).subscribe(new j(r19, r20, r21), new k());
        boolean r22 = true;
    L42:
        if (r22 == false) goto L45;
        return true;
    L41:
        r22 = false;
        goto L42
    L26:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.copy.atmention.support") == false) goto L28;
        r17 = true;
    L45:
        if (this.y1 == null) goto L54;
        if (r16 == null) goto L54;
        if (r16.getItemCount() <= 0) goto L54;
        if (r16.getItemAt(0).getText() == null) goto L54;
        if (this.y1.onPaste(r16.getItemAt(0).getText().toString()) == false) goto L54;
        return true;
    L54:
        if (r13 == 16908322) goto L56;
    L58:
        if (r13 != 16908322) goto L60;
        boolean r111 = 1;
    L61:
        ClipData r23 = getPrimaryClip();
        if (r23 != null) goto L65;
    L72:
        return true;
    L65:
        if (Build.VERSION.SDK_INT >= 31) goto L96;
        H(r23, r4, r0, r111);
        goto L72
    L96:
        performReceiveContent(new ContentInfo.Builder(r23, 1).setFlags(!r111).build());     // Catch: Exception -> L69
    L69:
        e = move-exception;
        tt5.a.e("AtEditText", "performReceiveContent error, fallback to legacy paste", e, false);
        H(r23, r4, r0, r111);
        goto L72
    L60:
        r111 = 0;
        goto L61
    L56:
        if (Build.VERSION.SDK_INT < 23) goto L58;
        r13 = R.id.pasteAsPlainText;
        goto L58
    L9:
        r4 = 0;
        goto L11
    L5:
        r0 = getText().length();
        goto L7
    }

    public void setAtWindow(kn4.g r1) {
        this.k1 = r1;
    }

    public void setCopyAtMentionEnable(boolean r1) {
        this.H1 = r1;
    }

    public void setFragment(Fragment r1) {
        this.L1 = r1;
    }

    public void setOnPasteListener(b r1) {
        this.y1 = r1;
    }

    public void setOpenMentionListener(c r1) {
        this.x1 = r1;
    }

    public void setPreImeListener(a r1) {
        this.v1 = r1;
    }

    public void setRichText(String r2) {
        getPresenter().q(r2);
    }

    public void setText(String r1) {
        setRichText(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextSimple(String r1) {
        super/*android.widget.EditText*/.setText(r1);
    }

    public AtEditText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void E(un5.a.InterfaceC0318a r5, fc5.d r6) {
        if (this.G1 == true) goto L5;
        l r0 = getPresenter();
        BitableAtEditText r3 = (BitableAtEditText) this;
        r0.i = new fc5.c(r3, getPresenter(), r5, r6);
    L5:
        this.G1 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r3, KeyEvent r4) {
        if (r4.getKeyCode() != 66) goto L8;
        a r0 = this.v1;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        return super/*android.widget.EditText*/.onKeyDown(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSelectionChanged(int r10, int r11) {
        super/*android.widget.EditText*/.onSelectionChanged(r10, r11);
        tt5.a.b("AtEditText", "onSelectionChanged: start = " + r10 + ", end = " + r11);
        l r0 = getPresenter();
        r0.getClass();
        tt5.a.b("DocEditTextPresenter", "onSelectionChanged: start = " + r10 + ", end = " + r11);
        SpannableStringBuilder r1 = (SpannableStringBuilder) ((AtEditText) r0.b()).getText();
        un5.i[] r2 = (un5.i[]) r1.getSpans(r10, r11, un5.i.class);
        int r3 = r2.length;
        int r4 = 0;
        int r5 = r10;
        int r6 = r11;
    L3:
        if (r4 >= r3) goto L13;
        un5.i r7 = r2[r4];
        if (r7.E() == true) goto L12;
        int r8 = r1.getSpanStart(r7);
        int r9 = r1.getSpanEnd(r7);
        if (r10 != r11) goto L11;
        if (r8 == r10) goto L12;
        if (r9 == r11) goto L12;
    L11:
        r5 = Math.min(r8, r5);
        r6 = Math.max(r9, r6);
    L12:
        r4 = r4 + 1;
        goto L3
    L13:
        int r12 = ((AtEditText) r0.b()).getText().length();
        if (r5 >= r6) goto L26;
        if (r5 < 0) goto L27;
        if (r6 > r12) goto L28;
        if (r10 != r11) goto L19;
        ((AtEditText) r0.b()).setSelection(r6);
        return;
    L19:
        ((AtEditText) r0.b()).setSelection(r5, r6);
        return;
    L28:
        return;
    L27:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.EditText*/.setText(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.H1 = false;
        tt5.a.b("AtEditText", "init: ");
        this.p1 = r1;
        setAtTriggerListener(new h(this));
        setOnKeyListener(new com.bytedance.ee.bear.widget.c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(ClipData r7, int r8, int r9, boolean r10) {
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r0 >= r7.getItemCount()) goto L20;
        if (r10 == false) goto L7;
        CharSequence r2 = r7.getItemAt(r0).coerceToStyledText(getContext());
    L10:
        if (r2 == null) goto L19;
        if (r1 == true) goto L17;
        Selection.setSelection(getText(), r9);
        if (getText() == null) goto L15;
        getText().replace(r8, r9, r2);
    L15:
        r1 = true;
        goto L19
    L17:
        if (getText() == null) goto L19;
        getText().insert(getSelectionEnd(), "\n");
        getText().insert(getSelectionEnd(), r2);
    L19:
        r0 = r0 + 1;
        goto L4
    L7:
        r2 = r7.getItemAt(r0).coerceToText(getContext());
        if ((r2 instanceof Spanned) == false) goto L10;
        r2 = r2.toString();
        goto L10
    }
}
