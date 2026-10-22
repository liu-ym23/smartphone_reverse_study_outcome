package com.bytedance.ee.bear.list.homepage.banner;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface g<VD extends a> extends IView<VD> {

    public interface a extends IView.IViewDelegate {
        void t6();

        void y1(Document r100, int r101);
    }

    void j4(boolean r100);

    void l0(ArrayList<Document> r100);

    void l6(boolean r100);
}
