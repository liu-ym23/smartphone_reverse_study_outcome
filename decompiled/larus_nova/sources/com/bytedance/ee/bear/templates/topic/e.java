package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void P2(String r100, int r101);

        void h(int r100, TemplateV4 r101, String r102);

        void onLoadFailed();
    }

    void b();

    void d();

    List<TemplateV4> getCurrentList();

    void m(Throwable r100);

    void y3(TopicDataResult r100);
}
