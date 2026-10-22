package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void S1(UserGroup r1);

        void z8(UserGroup r1);
    }

    void E0(UserGroup r1);

    void Y2(GetUserGroupResult r1);

    void a1(UserGroup r1);

    void hideLoading();

    void n3(ArrayList<UserInfo> r1, ArrayList<UserGroup> r2);

    void showLoading();
}
