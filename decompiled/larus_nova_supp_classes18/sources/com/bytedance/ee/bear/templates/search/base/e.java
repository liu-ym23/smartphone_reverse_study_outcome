package com.bytedance.ee.bear.templates.search.base;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e extends IModel {
    Flowable<TemplateGroupTab> D7(int r1, String r2, String r3);

    Flowable<TemplateGroupTab> H5(String r1);

    NetService.f S5(int r1, String r2, String r3);

    String getTemplateType();
}
