package com.ss.android.lark.message.card.view;

import android.view.View;
import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class CardViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CardViewHolder f431930a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        CardViewHolder r100 = this.f431930a;
        if (r100 == null) goto L7;
        this.f431930a = null;
        r100.mRootLayout = null;
        r100.mHeaderContainer = null;
        r100.mCardContentLayout = null;
        r100.mTranslateStub = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CardViewHolder_ViewBinding(CardViewHolder r100, View r101) {
        this.f431930a = r100;
        r100.mRootLayout = (LKUIRoundLinearLayout) Utils.findRequiredViewAsType(r101, R.id.root, "field 'mRootLayout'", LKUIRoundLinearLayout.class);
        r100.mHeaderContainer = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r101, R.id.header_container, "field 'mHeaderContainer'", LKUIRoundableLayout.class);
        r100.mCardContentLayout = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r101, R.id.card_content_layout, "field 'mCardContentLayout'", LKUIRoundableLayout.class);
        r100.mTranslateStub = (ViewStub) Utils.findRequiredViewAsType(r101, R.id.vt_card_translate, "field 'mTranslateStub'", ViewStub.class);
    }
}
