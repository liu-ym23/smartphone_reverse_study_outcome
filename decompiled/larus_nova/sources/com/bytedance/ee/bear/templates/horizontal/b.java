package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void L(int r100, TemplateV4 r101);

        void o();
    }

    void E(Throwable r100);

    void F5(List<TemplateV4> r100, boolean r101);

    void d();
}
