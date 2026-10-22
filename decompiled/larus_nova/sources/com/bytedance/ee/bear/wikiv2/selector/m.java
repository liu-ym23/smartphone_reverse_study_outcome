package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface m extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void M7();

        void Z3();

        void d2();

        void f3(int r100, Document r101);

        void onRefresh();

        void p();
    }

    void E(Throwable r100);

    void I(List<? extends Document> r100);

    void showLoading();

    void u(Document r100);
}
