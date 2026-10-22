package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface m extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void M7();

        void Z3();

        void d2();

        void f3(int r1, Document r2);

        void onRefresh();

        void p();
    }

    void E(Throwable r1);

    void I(List<? extends Document> r1);

    void showLoading();

    void u(Document r1);
}
