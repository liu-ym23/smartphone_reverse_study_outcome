package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface q extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void N3();

        void V6(CategoryTab r1);

        void a();

        void h(int r1, TemplateV4 r2, String r3);

        void onLoadFailed();

        void w(TemplateV4 r1);
    }

    void H0(int r1);

    boolean H3();

    EmptyCategory I7();

    sbb.e M4();

    void Q(boolean r1);

    void Y1(TemplateGroupTab r1);

    void Z(TemplateGroupTab r1);

    void b();

    void b0();

    void c0();

    void d();

    Tab2 getTab();

    int getType();

    void k0();

    void m(Throwable r1);

    CategoryTab s0();

    void w3(CategoryTab r1);
}
