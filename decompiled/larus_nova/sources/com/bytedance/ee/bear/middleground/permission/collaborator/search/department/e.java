package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void A5(VisibleTopUserInDep r100);

        void B8(VisibleDepartment r100);

        void C7(VisibleDepartment r100);

        void Q1(VisibleDepartment r100);

        void back();

        void c6(VisibleDepartment r100);

        void onLoadMore();

        void p5(VisibleTopUserInDep r100);
    }

    void I0(Department r100);

    void J1(boolean r100);

    void Q7(VisibleTopUserInDep r100);

    void R7(VisibleDepartment r100);

    void X0(Department r100);

    void Z6(VisibleDepartment r100);

    void d0(boolean r100);

    void d4(VisibleTopUserInDep r100);

    void g1();

    void g3(ArrayList<UserInfo> r100, ArrayList<VisibleDepartment> r101, ArrayList<VisibleTopUserInDep> r102);

    void hideLoading();

    void showLoading();

    void t7();
}
