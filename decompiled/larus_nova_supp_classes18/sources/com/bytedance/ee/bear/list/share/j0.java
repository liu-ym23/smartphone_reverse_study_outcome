package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface j0 extends com.bytedance.ee.bear.list.list.e {
    void c(String r1);

    Flowable<ArrayList<Document>> g();
}
