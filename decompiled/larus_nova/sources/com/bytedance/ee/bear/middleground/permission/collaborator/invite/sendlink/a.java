package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface a extends IView<InterfaceC3341a> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a$a, reason: collision with other inner class name */
    public interface InterfaceC3341a extends IView.IViewDelegate {
        void Y(int r100, UserInfo r101);

        void a0();

        void onBack();

        void q2();
    }

    void F(ArrayList<UserInfo> r100);

    String getNotes();

    void showLoading(boolean r100);
}
