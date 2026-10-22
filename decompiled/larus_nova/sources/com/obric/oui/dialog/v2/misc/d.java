package com.obric.oui.dialog.v2.misc;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.r;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends r {
    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_status_dialog;
    }

    private final View getButtonContainerView() {
        throw null;
    }

    private final OButton getNegativeButton() {
        throw null;
    }

    private final OButton getPositiveButton() {
        throw null;
    }

    private final OTextView getSubtitleTextView() {
        throw null;
    }

    private final OTextView getTitleTextView() {
        throw null;
    }

    public final ODownloadProgressView getProcessView() {
        throw null;
    }

    public final void setSubtitleText(String r100) {
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

    public final void setTitleText(String r100) {
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
