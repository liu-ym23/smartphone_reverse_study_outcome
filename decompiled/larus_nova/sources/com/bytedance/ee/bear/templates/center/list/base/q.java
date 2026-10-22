package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: classes18.dex */
public interface q extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void N3();

        void V6(CategoryTab r100);

        void a();

        void h(int r100, TemplateV4 r101, String r102);

        void onLoadFailed();

        void w(TemplateV4 r100);
    }

    void H0(int r100);

    boolean H3();

    EmptyCategory I7();

    sbb.e M4();

    void Q(boolean r100);

    void Y1(TemplateGroupTab r100);

    void Z(TemplateGroupTab r100);

    void b();

    void b0();

    void c0();

    void d();

    Tab2 getTab();

    int getType();

    void k0();

    void m(Throwable r100);

    CategoryTab s0();

    void w3(CategoryTab r100);
}
