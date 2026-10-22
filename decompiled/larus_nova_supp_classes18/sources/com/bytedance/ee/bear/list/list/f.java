package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.f.a;
import com.larksuite.framework.mvp.IView;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface f<VD extends a> extends IView<VD>, pc5.i.c {

    public interface a extends IView.IViewDelegate {
        void C(RecyclerView r1, int r2);

        void h3(Document r1, int r2, boolean r3);

        void onLoadMore();

        void onRefresh();

        void u8(Document r1);

        void y7(Document r1);
    }

    void A6(boolean r1);

    Flowable<List<Document>> A7(int r1);

    void E3(Throwable r1);

    List<Document> G();

    boolean G1();

    void T1(Throwable r1);

    void W3(int r1);

    void h5(int r1, Document r2);

    void j3(Throwable r1);

    void j8();

    void k1(int r1, boolean r2);

    void k3();

    void l0(ArrayList<Document> r1);

    void onResume();

    void r();

    void s6(boolean r1);

    void setUserVisibleHint(boolean r1);
}
