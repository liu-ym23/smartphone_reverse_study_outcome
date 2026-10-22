package com.bytedance.ee.bear.list.homepage.banner;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g<VD extends a> extends IView<VD> {

    public interface a extends IView.IViewDelegate {
        void t6();

        void y1(Document r1, int r2);
    }

    void j4(boolean r1);

    void l0(ArrayList<Document> r1);

    void l6(boolean r1);
}
