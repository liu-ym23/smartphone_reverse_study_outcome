package com.bytedance.ee.bear.list.list;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e extends IModel {

    public interface a {
        void R6(Throwable r1);

        void a5();

        void h4(boolean r1);

        void p2(Throwable r1);

        void s8(int r1, boolean r2);
    }

    LiveData<ArrayList<Document>> X();

    Flowable b7(rf5.d r1);

    void e3();

    boolean hasMore();

    void r();

    void r2();

    void x8(a r1);
}
