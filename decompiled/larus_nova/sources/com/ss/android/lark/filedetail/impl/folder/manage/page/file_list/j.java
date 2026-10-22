package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface j extends IView<a> {

    public interface a extends IView.IViewDelegate {
        int M();

        void U(int r100);

        boolean o0();

        void onLoadMore();
    }

    void J0(List<nfb.a> r100);

    void Q5(boolean r100);

    void T3(boolean r100, boolean r101, boolean r102);

    void h6(int r100, String r101);

    void n();
}
