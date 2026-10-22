package com.bytedance.ee.bear.templates.bean;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SceneTemplateResult extends Result<SceneTemplateData> {
    public SceneTemplateData getSceneTemplateData() {
        return (SceneTemplateData) ((Result) this).data;
    }

    public SceneTemplateResult() {
    }
}
