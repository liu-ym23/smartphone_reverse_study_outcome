package com.bytedance.ies.abmock.datacenter.plugin;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BasePluginMockModelJson {
    protected StringBuilder mockModelJsonBuilder;

    public BasePluginMockModelJson() {
    }

    public String getMockModelJson() {
        StringBuilder r100 = this.mockModelJsonBuilder;
        if (r100 != null) goto L6;
        return "[]";
    L6:
        return r100.toString();
    }
}
