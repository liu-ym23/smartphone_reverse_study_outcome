package com.ss.android.lark.forwardv2.impl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardSendDialogAdapter extends LarkRecyclerViewBaseAdapter<PickedChatViewHolder, SearchBaseInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f424964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f424965b;

    public static class PickedChatViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f424966a = 0;

        @BindView(9504)
        public ImageView mAvatar;

        @BindView(9086)
        public LKUIRoundedImageView mThreadIcon;

        public PickedChatViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class PickedChatViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PickedChatViewHolder f424967a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            PickedChatViewHolder r100 = this.f424967a;
            if (r100 == null) goto L7;
            this.f424967a = null;
            r100.mAvatar = null;
            r100.mThreadIcon = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public PickedChatViewHolder_ViewBinding(PickedChatViewHolder r100, View r101) {
            this.f424967a = r100;
            r100.mAvatar = (ImageView) Utils.findRequiredViewAsType(r101, R.id.preview_avatar, "field 'mAvatar'", ImageView.class);
            r100.mThreadIcon = (LKUIRoundedImageView) Utils.findRequiredViewAsType(r101, R.id.feed_thread_icon, "field 'mThreadIcon'", LKUIRoundedImageView.class);
        }
    }

    public interface a {
    }

    public ForwardSendDialogAdapter() {
        this.f424965b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PickedChatViewHolder r102 = (PickedChatViewHolder) r100;
        final SearchBaseInfo r103 = getItem(r101);
        boolean r104 = r103 instanceof SearchReplyInThreadInfo;
        LKUIRoundedImageView r105 = r102.mThreadIcon;
        int r106 = 0;
        if (r104 == false) goto L5;
        int r107 = 0;
    L6:
        r105.setBorderColor(r107);
        LKUIRoundedImageView r108 = r102.mThreadIcon;
        if (r104 == false) goto L9;
        float r109 = 0.0f;
    L10:
        r108.setBorderWidthDP(r109);
        LKUIRoundedImageView r110 = r102.mThreadIcon;
        if (r104 == false) goto L13;
    L16:
        r110.setVisibility(r106);
        if (r104 == false) goto L20;
        String r111 = ((SearchReplyInThreadInfo) r103).getEntityId();
        r102.mAvatar.setImageResource(R.drawable.ic_svg_feed_avatar_msg_thread);
        Context r112 = this.f424964a;
        LKUIRoundedImageView r113 = r102.mThreadIcon;
        String r114 = r103.getAvatarKey();
        int r115 = UIHelper.dp2px(40.0f);
        int r116 = UIHelper.dp2px(40.0f);
        LoadParams r117 = new LoadParams();
        r117.f426328a = r115;
        r117.f426329b = r116;
        ImageModule.a(r112, r113, r114, r111, r117);
    L24:
        final a r118 = this.f424965b;
        r102.itemView.setOnClickListener(new mib.a(r118, r103));
        return;
    L20:
        if ((r103 instanceof SearchThreadInfo) == false) goto L22;
        String r119 = ((SearchThreadInfo) r103).getChannel().getId();
    L23:
        Context r120 = this.f424964a;
        ImageView r121 = r102.mAvatar;
        String r122 = r103.getAvatarKey();
        int r123 = UIHelper.dp2px(40.0f);
        int r124 = UIHelper.dp2px(40.0f);
        LoadParams r125 = new LoadParams();
        r125.f426328a = r123;
        r125.f426329b = r124;
        ImageModule.a(r120, r121, r122, r119, r125);
        r102.mThreadIcon.setImageResource(R.drawable.feed_thread_icon);
        goto L24
    L22:
        r119 = r103.getId();
        goto L23
    L13:
        if ((r103 instanceof SearchThreadInfo) == true) goto L16;
        r106 = 8;
        goto L16
    L9:
        r109 = 1.5f;
        goto L10
    L5:
        r107 = UIUtils.getColor(this.f424964a, R.color.static_white);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f424964a = r100.getContext();
        return new PickedChatViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.common_avatar_40, r100, false));
    }
}
