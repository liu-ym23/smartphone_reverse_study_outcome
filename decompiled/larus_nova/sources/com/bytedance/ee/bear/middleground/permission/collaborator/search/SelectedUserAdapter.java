package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import pg5.a;

/* JADX INFO: loaded from: classes18.dex */
public class SelectedUserAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {
    public SelectedUserAdapter() {
        super(R.layout.share_list_user_ico_item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, UserInfo r101) {
        UDAvatar r102 = (UDAvatar) r100.getView(R.id.user_icon);
        a.b(r102, r101);
    }
}
