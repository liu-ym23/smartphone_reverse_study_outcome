package com.ss.android.lark.message.card.pin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class CardPinViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CardPinViewHolder f431909a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        CardPinViewHolder r100 = this.f431909a;
        if (r100 == null) goto L7;
        this.f431909a = null;
        r100.mNameTV = null;
        r100.mTimeTV = null;
        r100.mAvatarIV = null;
        r100.mNameAndTimeTV = null;
        r100.mRootView = null;
        r100.mNormalSenderLayout = null;
        r100.mItemMenuBtn = null;
        r100.mUnPinIV = null;
        r100.mJumpChatIV = null;
        r100.mForwardIV = null;
        r100.mFooterTV = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CardPinViewHolder_ViewBinding(CardPinViewHolder r100, View r101) {
        this.f431909a = r100;
        r100.mNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.tv_name, "field 'mNameTV'", TextView.class);
        r100.mTimeTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.tv_time, "field 'mTimeTV'", TextView.class);
        r100.mAvatarIV = (LKUIRoundedImageView) Utils.findRequiredViewAsType(r101, R.id.avatar, "field 'mAvatarIV'", LKUIRoundedImageView.class);
        r100.mNameAndTimeTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.tv_name_time, "field 'mNameAndTimeTV'", TextView.class);
        r100.mRootView = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.item_root_layout, "field 'mRootView'", ViewGroup.class);
        r100.mNormalSenderLayout = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.sender_layout, "field 'mNormalSenderLayout'", ViewGroup.class);
        r100.mItemMenuBtn = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_menu_btn, "field 'mItemMenuBtn'", ImageView.class);
        r100.mUnPinIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_unpin_btn, "field 'mUnPinIV'", ImageView.class);
        r100.mJumpChatIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_view_in_chat_btn, "field 'mJumpChatIV'", ImageView.class);
        r100.mForwardIV = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_forward_btn, "field 'mForwardIV'", ImageView.class);
        r100.mFooterTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.tv_footer, "field 'mFooterTV'", TextView.class);
    }
}
