package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    Flowable<RecommendTemplates> K();

    void n7(TemplateV4 r1, boolean r2);

    Flowable<DocumentCreateInfo> x6(TemplateV4 r1, String r2, String r3, String r4, CreateSelectResult r5);
}
