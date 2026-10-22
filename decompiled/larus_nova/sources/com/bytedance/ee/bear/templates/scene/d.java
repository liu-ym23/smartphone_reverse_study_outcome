package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: classes18.dex */
public interface d extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void h(int r100, TemplateV4 r101, String r102);

        void onLoadFailed();

        void v0(String r100);
    }

    void a7(TopicDataResult r100);

    void b();

    void d();

    void m(Throwable r100);
}
