package com.obric.oui.dialog.v2.selection;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.r;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends r {
    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_selection_dialog;
    }

    private final ViewGroup getBodyContainerView() {
        throw null;
    }

    private final ViewGroup getButtonContainerView() {
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

    public final void setContainerView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r100);
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
        ViewGroup.LayoutParams r104 = getSubtitleTextView().getLayoutParams();
        if (r104 == null) goto L18;
        int r105 = d.c(getContext(), 8);
        ((ViewGroup.MarginLayoutParams) r104).topMargin = r105;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r101 = false;
        goto L7
    }
}
