package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.f.a;
import com.larksuite.framework.mvp.IView;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface f<VD extends a> extends IView<VD>, pc5.i.c {

    public interface a extends IView.IViewDelegate {
        void C(RecyclerView r100, int r101);

        void h3(Document r100, int r101, boolean r102);

        void onLoadMore();

        void onRefresh();

        void u8(Document r100);

        void y7(Document r100);
    }

    void A6(boolean r100);

    Flowable<List<Document>> A7(int r100);

    void E3(Throwable r100);

    List<Document> G();

    boolean G1();

    void T1(Throwable r100);

    void W3(int r100);

    void h5(int r100, Document r101);

    void j3(Throwable r100);

    void j8();

    void k1(int r100, boolean r101);

    void k3();

    void l0(ArrayList<Document> r100);

    void onResume();

    void r();

    void s6(boolean r100);

    void setUserVisibleHint(boolean r100);
}
