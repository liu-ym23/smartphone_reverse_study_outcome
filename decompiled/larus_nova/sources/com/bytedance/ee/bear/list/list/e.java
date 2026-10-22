package com.bytedance.ee.bear.list.list;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface e extends IModel {

    public interface a {
        void R6(Throwable r100);

        void a5();

        void h4(boolean r100);

        void p2(Throwable r100);

        void s8(int r100, boolean r101);
    }

    LiveData<ArrayList<Document>> X();

    Flowable b7(rf5.d r100);

    void e3();

    boolean hasMore();

    void r();

    void r2();

    void x8(a r100);
}
