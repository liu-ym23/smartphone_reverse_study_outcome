package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void A5(VisibleTopUserInDep r1);

        void B8(VisibleDepartment r1);

        void C7(VisibleDepartment r1);

        void Q1(VisibleDepartment r1);

        void back();

        void c6(VisibleDepartment r1);

        void onLoadMore();

        void p5(VisibleTopUserInDep r1);
    }

    void I0(Department r1);

    void J1(boolean r1);

    void Q7(VisibleTopUserInDep r1);

    void R7(VisibleDepartment r1);

    void X0(Department r1);

    void Z6(VisibleDepartment r1);

    void d0(boolean r1);

    void d4(VisibleTopUserInDep r1);

    void g1();

    void g3(ArrayList<UserInfo> r1, ArrayList<VisibleDepartment> r2, ArrayList<VisibleTopUserInDep> r3);

    void hideLoading();

    void showLoading();

    void t7();
}
