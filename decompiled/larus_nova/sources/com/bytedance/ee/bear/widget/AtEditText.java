package com.bytedance.ee.bear.widget;

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
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.widgets.MaxHeightLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import io.reactivex.Single;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes18.dex */
public class AtEditText extends SpaceEditText implements sa5.r, kn4.m {
    public static final /* synthetic */ int M1 = 0;
    public boolean G1;
    public boolean H1;
    public Fragment L1;
    public l V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public MaxHeightLayout f239849b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public AtFinderView f239850g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public View f239851h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public kn4.g f239852k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public Context f239853p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public a f239854v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public c f239855x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public b f239856y1;

    public interface a {
        void a();

        boolean b();
    }

    public interface b {
        void a();

        boolean onPaste(String r100);
    }

    public interface c {
        void a(boolean r100);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public boolean y(boolean r100) {
        return true;
    }

    public final void D() {
        kn4.g r100 = this.f239852k1;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public final boolean F() {
        kn4.g r100 = this.f239852k1;
        if (r100 == null) goto L5;
        boolean r101 = r100.isShowing();
    L6:
        if (r101 == false) goto L15;
        Context r102 = this.f239853p1;
        if ((r102 instanceof Activity) == true) goto L10;
        rcb.c.c(r102);
        D();
        return true;
    L10:
        if (rcb.c.e((Activity) r102) == true) goto L15;
        D();
        return true;
    L15:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public void I() {
        kn4.g r100 = this.f239852k1;
        if (r100 == null) goto L5;
        r100.show();
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

    public final void J() {
        int r100 = getSelectionStart();
        int r101 = getSelectionEnd();
        getPresenter().d().f239904e = true;
        Editable r102 = getText();
        if (r102 != null) goto L7;
        tt5.a.d("AtEditText", "triggerAt: editable is null");
        return;
    L7:
        if (r100 == (-1)) goto L11;
        if (r101 == (-1)) goto L11;
        r102.replace(r100, r101, "@");
        return;
    L11:
        r102.replace(0, r102.length(), "@");
    }

    @Override // kn4.m
    public final void Sw() {
        getPresenter().Sw();
    }

    public Single<String> getRichText() {
        return getPresenter().g();
    }

    @Override // kn4.m
    public final void gr() {
        getPresenter().gr();
    }

    public kn4.g getAtWindow() {
        return this.f239852k1;
    }

    public AtEditText(Context r100) {
        this(r100, null);
    }

    private void setAtTriggerListener(com.bytedance.ee.bear.widget.b.a r100) {
        getPresenter().d().f239900a = r100;
    }

    public final void C(kn4.h r110) {
        if (this.f239852k1 != null) goto L36;
        int r100 = r110.f504240k;
        if (r100 != 0) goto L7;
        View r101 = LayoutInflater.from(this.f239853p1).inflate(R.layout.at_atfinder_popupwindow, null);
        this.f239851h1 = r101;
        AtFinderView r102 = (AtFinderView) r101.findViewById(R.id.at_finder_view);
        this.f239850g1 = r102;
        r102.setAtCommonConfig(r110.f504234e);
        this.f239850g1.setAtFinderViewDelegate(new d(this));
        this.f239849b1 = (MaxHeightLayout) this.f239851h1.findViewById(R.id.at_container);
        d0 r103 = new d0((FragmentActivity) getContext(), this.f239851h1, this.f239849b1, this.f239850g1, r110);
        this.f239852k1 = r103;
        int r104 = r110.f504237h;
        if (r104 == 0) goto L28;
        r103.e(r104);
    L28:
        View r105 = r110.f504235f;
        if (r105 == null) goto L31;
        this.f239852k1.h(r105);
    L31:
        View r111 = r110.f504236g;
        if (r111 == null) goto L41;
        this.f239852k1.d(r111);
        return;
    L41:
        return;
    L7:
        if (r100 != 1) goto L9;
        AtFinderView r106 = r110.f504241l;
        if (r106 == null) goto L24;
        r106.setAtCommonConfig(r110.f504234e);
        this.f239852k1 = new z((FragmentActivity) getContext(), r110);
        return;
    L24:
        throw new NullPointerException("AtFinderView is null");
    L9:
        if (r100 == 2) goto L11;
        tt5.a.h("AtEditText", "bindAtWindow(): viewType is Undefined");
        return;
    L11:
        View r107 = r110.f504242m;
        this.f239851h1 = r107;
        this.f239850g1 = (AtFinderView) r107.findViewById(R.id.at_finder_view);
        MaxHeightLayout r108 = (MaxHeightLayout) this.f239851h1.findViewById(R.id.at_container);
        this.f239850g1.setAtCommonConfig(r110.f504234e);
        this.f239850g1.setAtFinderViewDelegate(new e(this));
        x r109 = new x((FragmentActivity) getContext(), this.f239851h1, r108, this.f239850g1, this, this.L1, r110);
        this.f239852k1 = r109;
        int r112 = r110.f504237h;
        if (r112 == 0) goto L14;
        r109.e(r112);
    L14:
        View r113 = r110.f504235f;
        if (r113 == null) goto L17;
        this.f239852k1.h(r113);
    L17:
        View r114 = r110.f504236g;
        if (r114 == null) goto L38;
        this.f239852k1.d(r114);
        return;
    L38:
        return;
    L36:
        throw new IllegalStateException("AtWindow already exist!!!");
    }

    public final void G(bo4.a r100) {
        getPresenter().j(r100);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent r100) {
        if (r100.getKeyCode() != 4) goto L9;
        a r101 = this.f239854v1;
        if (r101 == null) goto L9;
        return r101.b();
    L9:
        return super.dispatchKeyEventPreIme(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r110) {
        boolean r100 = false;
        if (getText() != null) goto L5;
        int r101 = 0;
    L7:
        if (isFocused() == false) goto L9;
        int r102 = getSelectionStart();
        int r103 = getSelectionEnd();
        int r104 = Math.max(0, Math.min(r102, r103));
        r101 = Math.max(0, Math.max(r102, r103));
    L11:
        if (r110 != 16908321) goto L13;
    L73:
        final SpannableStringBuilder r105 = (SpannableStringBuilder) ((SpannableStringBuilder) getText()).subSequence(r104, r101);
        CharSequence r106 = getEditableText().subSequence(r104, r101);
        getPresenter().getClass();
        tt5.a.b("DocEditTextPresenter", "filterCopiedText: ");
        un5.i[] r107 = (un5.i[]) r105.getSpans(0, r105.length(), un5.i.class);
        if (r107.length == 0) goto L85;
        int r108 = r107.length;
        int r109 = 0;
    L77:
        if (r109 >= r108) goto L82;
        un5.i r111 = r107[r109];
        if ((r111 instanceof un5.d) == false) goto L81;
        r105.delete(r105.getSpanStart(r111), r105.getSpanEnd(r111));
    L81:
        r105.removeSpan(r111);
        r109 = r109 + 1;
        goto L77
    L82:
        SuggestionSpan[] r112 = (SuggestionSpan[]) r105.getSpans(0, r105.length(), SuggestionSpan.class);
        int r113 = r112.length;
        int r114 = 0;
    L83:
        if (r114 >= r113) goto L85;
        r105.removeSpan(r112[r114]);
        r114 = r114 + 1;
    L85:
        boolean r115 = this.f240349p0;
        setCopySecurityEnable(false);
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).c();
        super.onTextContextMenuItem(r110);
        setCopySecurityEnable(r115);
        if ((r106 instanceof SpannableStringBuilder) == true) goto L88;
    L94:
        A(ClipData.newPlainText("", r105));
    L95:
        return true;
    L88:
        if (this.H1 == true) goto L90;
    L92:
        if (r100 == false) goto L94;
        com.bytedance.ee.bear.utils.f.a((SpannableStringBuilder) r106, r105.toString(), getPresenter().e()).subscribe(new f(this), new g(this, r105));
        goto L95
    L90:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.copy.atmention.support") == false) goto L92;
        r100 = true;
        goto L92
    L13:
        if (r110 == 16908320) goto L73;
        if (r110 == 16908322) goto L21;
        if (r110 == 16908337) goto L21;
        return super.onTextContextMenuItem(r110);
    L21:
        ClipData r116 = getPrimaryClip();
        if (r110 != 16908322) goto L45;
        if (this.H1 == true) goto L26;
    L28:
        boolean r117 = false;
    L29:
        if (r117 == false) goto L45;
        if (r116 == null) goto L45;
        String[] r118 = r116.getDescription().filterMimeTypes("text/html");
        if (r118 == null) goto L45;
        if (r118.length <= 0) goto L45;
        final l r119 = getPresenter();
        final b r120 = this.f239856y1;
        r119.getClass();
        final String r121 = r116.getItemAt(0).getHtmlText();
        if (TextUtils.isEmpty(r121) == true) goto L41;
        Matcher r122 = r119.f239938h.matcher(r121);
        if (r122.find() == false) goto L41;
        Single.just(r122.group(1)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).map(new i(r119)).map(new eb5.b()).map(r119.f()).subscribe(new j(r119, r120, r121), new k());
        boolean r123 = true;
    L42:
        if (r123 == false) goto L45;
        return true;
    L41:
        r123 = false;
        goto L42
    L26:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.copy.atmention.support") == false) goto L28;
        r117 = true;
    L45:
        if (this.f239856y1 == null) goto L54;
        if (r116 == null) goto L54;
        if (r116.getItemCount() <= 0) goto L54;
        if (r116.getItemAt(0).getText() == null) goto L54;
        if (this.f239856y1.onPaste(r116.getItemAt(0).getText().toString()) == false) goto L54;
        return true;
    L54:
        if (r110 == 16908322) goto L56;
    L58:
        if (r110 != 16908322) goto L60;
        boolean r124 = 1;
    L61:
        ClipData r125 = getPrimaryClip();
        if (r125 != null) goto L65;
    L72:
        return true;
    L65:
        if (Build.VERSION.SDK_INT >= 31) goto L96;
        H(r125, r104, r101, r124);
        goto L72
    L96:
        performReceiveContent(new ContentInfo.Builder(r125, 1).setFlags(!r124).build());     // Catch: Exception -> L69
    L69:
        e = move-exception;
        tt5.a.e("AtEditText", "performReceiveContent error, fallback to legacy paste", e, false);
        H(r125, r104, r101, r124);
        goto L72
    L60:
        r124 = 0;
        goto L61
    L56:
        if (Build.VERSION.SDK_INT < 23) goto L58;
        r110 = android.R.id.pasteAsPlainText;
        goto L58
    L9:
        r104 = 0;
        goto L11
    L5:
        r101 = getText().length();
        goto L7
    }

    public void setAtWindow(kn4.g r100) {
        this.f239852k1 = r100;
    }

    public void setCopyAtMentionEnable(boolean r100) {
        this.H1 = r100;
    }

    public void setFragment(Fragment r100) {
        this.L1 = r100;
    }

    public void setOnPasteListener(b r100) {
        this.f239856y1 = r100;
    }

    public void setOpenMentionListener(c r100) {
        this.f239855x1 = r100;
    }

    public void setPreImeListener(a r100) {
        this.f239854v1 = r100;
    }

    public void setRichText(String r100) {
        getPresenter().q(r100);
    }

    public void setText(String r100) {
        setRichText(r100);
    }

    public void setTextSimple(String r100) {
        super.setText(r100);
    }

    public AtEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void E(un5.a.InterfaceC7903a r100, fc5.d r101) {
        if (this.G1 == true) goto L5;
        l r102 = getPresenter();
        BitableAtEditText r103 = (BitableAtEditText) this;
        r102.f239939i = new fc5.c(r103, getPresenter(), r100, r101);
    L5:
        this.G1 = true;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r101.getKeyCode() != 66) goto L8;
        a r102 = this.f239854v1;
        if (r102 == null) goto L8;
        r102.a();
    L8:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r110, int r111) {
        super.onSelectionChanged(r110, r111);
        tt5.a.b("AtEditText", "onSelectionChanged: start = " + r110 + ", end = " + r111);
        l r100 = getPresenter();
        r100.getClass();
        tt5.a.b("DocEditTextPresenter", "onSelectionChanged: start = " + r110 + ", end = " + r111);
        SpannableStringBuilder r101 = (SpannableStringBuilder) r100.b().getText();
        un5.i[] r102 = (un5.i[]) r101.getSpans(r110, r111, un5.i.class);
        int r103 = r102.length;
        int r104 = 0;
        int r105 = r110;
        int r106 = r111;
    L3:
        if (r104 >= r103) goto L13;
        un5.i r107 = r102[r104];
        if (r107.E() == true) goto L12;
        int r108 = r101.getSpanStart(r107);
        int r109 = r101.getSpanEnd(r107);
        if (r110 != r111) goto L11;
        if (r108 == r110) goto L12;
        if (r109 == r111) goto L12;
    L11:
        r105 = Math.min(r108, r105);
        r106 = Math.max(r109, r106);
    L12:
        r104 = r104 + 1;
        goto L3
    L13:
        int r112 = r100.b().getText().length();
        if (r105 >= r106) goto L26;
        if (r105 < 0) goto L27;
        if (r106 > r112) goto L28;
        if (r110 != r111) goto L19;
        r100.b().setSelection(r106);
        return;
    L19:
        r100.b().setSelection(r105, r106);
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
    }

    public AtEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.H1 = false;
        tt5.a.b("AtEditText", "init: ");
        this.f239853p1 = r100;
        setAtTriggerListener(new h(this));
        setOnKeyListener(new com.bytedance.ee.bear.widget.c(this));
    }

    public final void H(ClipData r100, int r101, int r102, boolean r110) {
        int r103 = 0;
        boolean r104 = false;
    L4:
        if (r103 >= r100.getItemCount()) goto L20;
        if (r110 == false) goto L7;
        CharSequence r105 = r100.getItemAt(r103).coerceToStyledText(getContext());
    L10:
        if (r105 == null) goto L19;
        if (r104 == true) goto L17;
        Selection.setSelection(getText(), r102);
        if (getText() == null) goto L15;
        getText().replace(r101, r102, r105);
    L15:
        r104 = true;
        goto L19
    L17:
        if (getText() == null) goto L19;
        getText().insert(getSelectionEnd(), "\n");
        getText().insert(getSelectionEnd(), r105);
    L19:
        r103 = r103 + 1;
        goto L4
    L7:
        r105 = r100.getItemAt(r103).coerceToText(getContext());
        if ((r105 instanceof Spanned) == false) goto L10;
        r105 = r105.toString();
        goto L10
    }
}
