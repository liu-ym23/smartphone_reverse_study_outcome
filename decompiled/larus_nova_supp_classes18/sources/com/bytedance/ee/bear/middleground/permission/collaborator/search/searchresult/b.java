package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void F8(UserInfo r1);

        void P(UserInfo r1);

        void onLoadMore();

        void w8(UserInfo r1);
    }

    void F4(SearchUserResult r1);

    void d0(boolean r1);

    void d6();

    void hideLoading();

    void i(UserInfo r1);

    void l(UserInfo r1);

    void showLoading();

    void v4(ArrayList<UserInfo> r1);

    void y6(SearchUserResult r1);
}
