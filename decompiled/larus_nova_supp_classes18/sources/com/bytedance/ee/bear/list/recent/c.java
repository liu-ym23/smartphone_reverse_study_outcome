package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c extends com.bytedance.ee.bear.list.list.e {
    void c(String r1);

    void c4(ArrayList<Document> r1);

    Flowable<ArrayList<Document>> g();

    void onResume();

    void onStop();

    void setUserVisibleHint(boolean r1);
}
