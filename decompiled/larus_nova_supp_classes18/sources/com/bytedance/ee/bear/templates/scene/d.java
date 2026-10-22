package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface d extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void h(int r1, TemplateV4 r2, String r3);

        void onLoadFailed();

        void v0(String r1);
    }

    void a7(TopicDataResult r1);

    void b();

    void d();

    void m(Throwable r1);
}
