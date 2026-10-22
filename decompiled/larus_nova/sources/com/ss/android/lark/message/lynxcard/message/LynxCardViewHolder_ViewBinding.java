package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public class LynxCardViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxCardViewHolder f432180a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        LynxCardViewHolder r100 = this.f432180a;
        if (r100 == null) goto L7;
        this.f432180a = null;
        r100.mRootLayout = null;
        r100.contentLayout = null;
        r100.mFoldContainer = null;
        r100.mEllipsizeLayout = null;
        r100.mShowMoreView = null;
        r100.mShowMoreText = null;
        r100.mTranslateStub = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public LynxCardViewHolder_ViewBinding(LynxCardViewHolder r100, View r101) {
        this.f432180a = r100;
        r100.mRootLayout = (LynxCardRoundLinearLayout) Utils.findRequiredViewAsType(r101, R.id.root, "field 'mRootLayout'", LynxCardRoundLinearLayout.class);
        r100.contentLayout = (LynxCardMessageContentLayout) Utils.findRequiredViewAsType(r101, R.id.lynx_card_content_layout, "field 'contentLayout'", LynxCardMessageContentLayout.class);
        r100.mFoldContainer = (FrameLayout) Utils.findRequiredViewAsType(r101, R.id.lynx_card_fold_container, "field 'mFoldContainer'", FrameLayout.class);
        r100.mEllipsizeLayout = (EllipsizeFrameLayout) Utils.findRequiredViewAsType(r101, R.id.lynx_card_ellipsize_layout, "field 'mEllipsizeLayout'", EllipsizeFrameLayout.class);
        r100.mShowMoreView = Utils.findRequiredView(r101, R.id.lynx_card_show_more_mask, "field 'mShowMoreView'");
        r100.mShowMoreText = (TextView) Utils.findRequiredViewAsType(r101, R.id.lynx_card_show_more_text, "field 'mShowMoreText'", TextView.class);
        r100.mTranslateStub = (ViewStub) Utils.findRequiredViewAsType(r101, R.id.lynx_vt_card_translate, "field 'mTranslateStub'", ViewStub.class);
    }
}
