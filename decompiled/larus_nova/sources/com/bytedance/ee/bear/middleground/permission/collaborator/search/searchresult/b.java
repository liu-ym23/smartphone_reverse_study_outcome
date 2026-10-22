package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void F8(UserInfo r100);

        void P(UserInfo r100);

        void onLoadMore();

        void w8(UserInfo r100);
    }

    void F4(SearchUserResult r100);

    void d0(boolean r100);

    void d6();

    void hideLoading();

    void i(UserInfo r100);

    void l(UserInfo r100);

    void showLoading();

    void v4(ArrayList<UserInfo> r100);

    void y6(SearchUserResult r100);
}
