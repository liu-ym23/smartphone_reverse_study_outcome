package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void P2(String r1, int r2);

        void h(int r1, TemplateV4 r2, String r3);

        void onLoadFailed();
    }

    void b();

    void d();

    List<TemplateV4> getCurrentList();

    void m(Throwable r1);

    void y3(TopicDataResult r1);
}
