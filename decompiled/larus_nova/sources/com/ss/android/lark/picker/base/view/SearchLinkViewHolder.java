package com.ss.android.lark.picker.base.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "mUrlAvatarIV", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getMUrlAvatarIV", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "setMUrlAvatarIV", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;)V", "mUrlNameTV", "Landroid/widget/TextView;", "getMUrlNameTV", "()Landroid/widget/TextView;", "setMUrlNameTV", "(Landroid/widget/TextView;)V", "mUrlContentLayoutLL", "Landroid/widget/LinearLayout;", "getMUrlContentLayoutLL", "()Landroid/widget/LinearLayout;", "setMUrlContentLayoutLL", "(Landroid/widget/LinearLayout;)V", "mUrlContentTV", "getMUrlContentTV", "setMUrlContentTV", "mUrlDetailTV", "getMUrlDetailTV", "setMUrlDetailTV", "mMsgUrlSenderInfoTV", "getMMsgUrlSenderInfoTV", "setMMsgUrlSenderInfoTV", "mMsgUrlOpenChatRL", "Landroid/widget/RelativeLayout;", "getMMsgUrlOpenChatRL", "()Landroid/widget/RelativeLayout;", "setMMsgUrlOpenChatRL", "(Landroid/widget/RelativeLayout;)V", "mMsgUrlOpenChatIv", "Landroid/widget/ImageView;", "getMMsgUrlOpenChatIv", "()Landroid/widget/ImageView;", "setMMsgUrlOpenChatIv", "(Landroid/widget/ImageView;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchLinkViewHolder extends RecyclerView.ViewHolder {
    private ImageView mMsgUrlOpenChatIv;
    private RelativeLayout mMsgUrlOpenChatRL;
    private TextView mMsgUrlSenderInfoTV;
    private LKUIRoundedImageView mUrlAvatarIV;
    private LinearLayout mUrlContentLayoutLL;
    private TextView mUrlContentTV;
    private TextView mUrlDetailTV;
    private TextView mUrlNameTV;
    private final View view;

    public final ImageView getMMsgUrlOpenChatIv() {
        return this.mMsgUrlOpenChatIv;
    }

    public final RelativeLayout getMMsgUrlOpenChatRL() {
        return this.mMsgUrlOpenChatRL;
    }

    public final TextView getMMsgUrlSenderInfoTV() {
        return this.mMsgUrlSenderInfoTV;
    }

    public final LKUIRoundedImageView getMUrlAvatarIV() {
        return this.mUrlAvatarIV;
    }

    public final LinearLayout getMUrlContentLayoutLL() {
        return this.mUrlContentLayoutLL;
    }

    public final TextView getMUrlContentTV() {
        return this.mUrlContentTV;
    }

    public final TextView getMUrlDetailTV() {
        return this.mUrlDetailTV;
    }

    public final TextView getMUrlNameTV() {
        return this.mUrlNameTV;
    }

    public final View getView() {
        return this.view;
    }

    public SearchLinkViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.view = r100;
        this.mUrlAvatarIV = (LKUIRoundedImageView) r100.findViewById(R.id.url_avatar_iv);
        this.mUrlNameTV = (TextView) r100.findViewById(R.id.url_name_tv);
        this.mUrlContentLayoutLL = (LinearLayout) r100.findViewById(R.id.url_content_layout_ll);
        this.mUrlContentTV = (TextView) r100.findViewById(R.id.url_content_tv);
        this.mUrlDetailTV = (TextView) r100.findViewById(R.id.url_detail_tv);
        this.mMsgUrlSenderInfoTV = (TextView) r100.findViewById(R.id.message_url_sender_info_tv);
        this.mMsgUrlOpenChatRL = (RelativeLayout) r100.findViewById(R.id.message_url_open_chat_rl);
        this.mMsgUrlOpenChatIv = (ImageView) r100.findViewById(R.id.message_url_open_chat_iv);
    }

    public final void setMMsgUrlOpenChatIv(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mMsgUrlOpenChatIv = r100;
    }

    public final void setMMsgUrlOpenChatRL(RelativeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mMsgUrlOpenChatRL = r100;
    }

    public final void setMMsgUrlSenderInfoTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mMsgUrlSenderInfoTV = r100;
    }

    public final void setMUrlAvatarIV(LKUIRoundedImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mUrlAvatarIV = r100;
    }

    public final void setMUrlContentLayoutLL(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mUrlContentLayoutLL = r100;
    }

    public final void setMUrlContentTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mUrlContentTV = r100;
    }

    public final void setMUrlDetailTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mUrlDetailTV = r100;
    }

    public final void setMUrlNameTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mUrlNameTV = r100;
    }
}
