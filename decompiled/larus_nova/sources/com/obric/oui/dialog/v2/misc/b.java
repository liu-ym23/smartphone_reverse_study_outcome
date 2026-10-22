package com.obric.oui.dialog.v2.misc;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.r;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends r {
    public OInputLayout B;
    public OInputLayout C;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.misc.b$b, reason: collision with other inner class name */
    public static final class C4673b {
    }

    static {
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_simple_form_dialog;
    }

    public final C4673b getModifier() {
        return null;
    }

    private final FrameLayout getBodyContainer() {
        throw null;
    }

    public final FrameLayout getFooterContainer() {
        throw null;
    }

    public final OInputLayout getInputView1() {
        return this.B;
    }

    public final FrameLayout getInputView1Container() {
        throw null;
    }

    public final OInputLayout getInputView2() {
        return this.C;
    }

    public final FrameLayout getInputView2Container() {
        throw null;
    }

    public final OButton getNegativeButton() {
        throw null;
    }

    public final OButton getPositiveButton() {
        throw null;
    }

    public final OTextView getSubtitleTextView() {
        throw null;
    }

    public final OTextView getTitleTextView() {
        throw null;
    }

    public final void setInputView1(OInputLayout r100) {
        this.B = r100;
    }

    public final void setInputView2(OInputLayout r100) {
        this.C = r100;
    }

    public final void setSubtitleText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r102 = getSubtitleTextView();
        r102.setVisibility(0);
        r102.setText(r100);
        xla.c.a(r102, r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setTitleText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L13;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r102 = getSubtitleTextView().getLayoutParams();
        if (r102 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = 0;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        OTextView r103 = getTitleTextView();
        r103.setVisibility(0);
        r103.setText(r100);
        OTextView r104 = getSubtitleTextView();
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L18;
        int r106 = pla.d.n(r104, 8);
        ((ViewGroup.MarginLayoutParams) r105).topMargin = r106;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r101 = false;
        goto L7
    }
}
