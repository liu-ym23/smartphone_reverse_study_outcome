package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface p extends IModel {
    NetService.c<TemplateGroupTab> G5(int r1, r r2, boolean r3);

    boolean L5(int r1);

    Flowable<TemplateGroupTab> N7(String r1, int r2, long r3, int r5);

    NetService.f R3(r r1);

    TemplateGroupTab S7(int r1, int r2, Throwable r3);

    String getCacheKey();

    Flowable t1(int r1);

    LiveData<sbb.e> u7();
}
