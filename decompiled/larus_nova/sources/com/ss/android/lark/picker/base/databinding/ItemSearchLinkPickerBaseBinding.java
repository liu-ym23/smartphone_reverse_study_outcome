package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemSearchLinkPickerBaseBinding implements ViewBinding {
    public final AppCompatImageView messageUrlOpenChatIv;
    public final RelativeLayout messageUrlOpenChatRl;
    public final TextView messageUrlSenderInfoTv;
    private final ConstraintLayout rootView;
    public final LKUIRoundedImageView urlAvatarIv;
    public final LinearLayout urlContentLayoutLl;
    public final TextView urlContentTv;
    public final TextView urlDetailTv;
    public final TextView urlNameTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkPickerBaseBinding bind(View r110) {
        int r100 = R.id.message_url_open_chat_iv;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.message_url_open_chat_iv);
        if (r101 == null) goto L21;
        r100 = R.id.message_url_open_chat_rl;
        RelativeLayout r102 = (RelativeLayout) ViewBindings.findChildViewById(r110, R.id.message_url_open_chat_rl);
        if (r102 == null) goto L21;
        r100 = R.id.message_url_sender_info_tv;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r110, R.id.message_url_sender_info_tv);
        if (r103 == null) goto L21;
        r100 = R.id.url_avatar_iv;
        LKUIRoundedImageView r104 = (LKUIRoundedImageView) ViewBindings.findChildViewById(r110, R.id.url_avatar_iv);
        if (r104 == null) goto L21;
        r100 = R.id.url_content_layout_ll;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.url_content_layout_ll);
        if (r105 == null) goto L21;
        r100 = R.id.url_content_tv;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r110, R.id.url_content_tv);
        if (r106 == null) goto L21;
        r100 = R.id.url_detail_tv;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r110, R.id.url_detail_tv);
        if (r111 == null) goto L21;
        r100 = R.id.url_name_tv;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r110, R.id.url_name_tv);
        if (r112 == null) goto L21;
        return new ItemSearchLinkPickerBaseBinding((ConstraintLayout) r110, r101, r102, r103, r104, r105, r106, r111, r112);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public static ItemSearchLinkPickerBaseBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ItemSearchLinkPickerBaseBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_search_link_picker_base, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ItemSearchLinkPickerBaseBinding(ConstraintLayout r100, AppCompatImageView r101, RelativeLayout r102, TextView r103, LKUIRoundedImageView r104, LinearLayout r105, TextView r106, TextView r107, TextView r108) {
        this.rootView = r100;
        this.messageUrlOpenChatIv = r101;
        this.messageUrlOpenChatRl = r102;
        this.messageUrlSenderInfoTv = r103;
        this.urlAvatarIv = r104;
        this.urlContentLayoutLl = r105;
        this.urlContentTv = r106;
        this.urlDetailTv = r107;
        this.urlNameTv = r108;
    }
}
