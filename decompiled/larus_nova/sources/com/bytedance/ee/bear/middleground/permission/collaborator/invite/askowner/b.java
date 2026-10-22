package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void Y(int r100, UserInfo r101);

        void a0();

        void onBack();
    }

    void F(ArrayList<UserInfo> r100);

    String getNotes();

    void showLoading(boolean r100);
}
