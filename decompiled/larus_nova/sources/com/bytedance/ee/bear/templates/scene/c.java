package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes18.dex */
public interface c extends IModel {
    void b4(TemplateV4 r100);

    Flowable<TopicDataResult> v0(String r100);
}
