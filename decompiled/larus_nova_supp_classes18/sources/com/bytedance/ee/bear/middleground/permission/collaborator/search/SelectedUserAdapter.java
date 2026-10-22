package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import pg5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SelectedUserAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {
    public SelectedUserAdapter() {
        super(2131564514);
    }

    public final void convert(BaseViewHolder r2, Object r3) {
        UDAvatar r4 = r2.getView(2131392028);
        a.b(r4, (UserInfo) r3);
    }
}
