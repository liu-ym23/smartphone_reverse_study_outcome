package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void L(int r1, TemplateV4 r2);

        void o();
    }

    void E(Throwable r1);

    void F5(List<TemplateV4> r1, boolean r2);

    void d();
}
