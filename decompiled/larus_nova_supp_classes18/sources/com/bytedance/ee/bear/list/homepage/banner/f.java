package com.bytedance.ee.bear.list.homepage.banner;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface f extends IModel {
    void C4(List<? extends Document> r1);

    LiveData<ArrayList<Document>> X();

    void d7();

    ArrayList<Document> getList();

    boolean hasMore();

    void m5();
}
