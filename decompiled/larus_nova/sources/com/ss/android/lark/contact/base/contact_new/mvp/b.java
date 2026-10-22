package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void T();

        boolean canLoadMore();

        void j0(NewContactView.a r100);

        void t0(String r100, String r101);
    }

    void B1(List<NewContactView.a> r100);

    void E6();

    void G3(List<NewContactView.a> r100);

    void J(String r100, String r101);

    void e7(NewContactView.a r100);

    void hideLoading();

    void n();

    void showLoading();

    void z(int r100);
}
