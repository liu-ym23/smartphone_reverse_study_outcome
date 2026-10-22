package com.bytedance.ee.bear.templates.search.base;

import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface f extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void Z1(String r1);

        void a();

        void h(int r1, TemplateV4 r2, String r3);

        void l4();

        void onLoadFailed();

        void w(TemplateV4 r1);
    }

    void Q(boolean r1);

    void Z(TemplateGroupTab r1);

    void b();

    void b0();

    void d();

    void d3(boolean r1);

    void m(Throwable r1);

    CategoryTab s0();
}
