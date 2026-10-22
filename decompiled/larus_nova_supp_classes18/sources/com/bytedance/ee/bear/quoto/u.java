package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface u extends IModel {
    Flowable<QuotaInfoResult> e2(String r1, String r2);
}
