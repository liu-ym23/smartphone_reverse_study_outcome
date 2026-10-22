package com.bytedance.ee.bear.templates.search.base;

import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: classes18.dex */
public interface f extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void Z1(String r100);

        void a();

        void h(int r100, TemplateV4 r101, String r102);

        void l4();

        void onLoadFailed();

        void w(TemplateV4 r100);
    }

    void Q(boolean r100);

    void Z(TemplateGroupTab r100);

    void b();

    void b0();

    void d();

    void d3(boolean r100);

    void m(Throwable r100);

    CategoryTab s0();
}
