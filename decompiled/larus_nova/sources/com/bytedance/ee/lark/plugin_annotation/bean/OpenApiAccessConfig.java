package com.bytedance.ee.lark.plugin_annotation.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes19.dex */
public class OpenApiAccessConfig implements Serializable {
    private LKOpenApiBizType mBizType;
    private LKOpenApiBizDomain mDomain;
    private boolean mPublicToJS;
    private String mScene;

    public static /* synthetic */ class a {
    }

    public String toString() {
        return "LKOpenApiAccessConfig{mDomain=" + this.mDomain + ", mBizType=" + this.mBizType + ", mScene='" + this.mScene + "', mPublicToJS=" + this.mPublicToJS + '}';
    }

    private OpenApiAccessConfig() {
    }

    public LKOpenApiBizType getBizType() {
        return this.mBizType;
    }

    public LKOpenApiBizDomain getDomain() {
        return this.mDomain;
    }

    public String getScene() {
        return this.mScene;
    }

    public boolean isPublicToJS() {
        return this.mPublicToJS;
    }

    public /* synthetic */ OpenApiAccessConfig(a r100) {
        this();
    }

    public void updateDomain(LKOpenApiBizDomain r100) {
        this.mDomain = r100;
    }

    public static /* synthetic */ LKOpenApiBizDomain access$102(OpenApiAccessConfig r100, LKOpenApiBizDomain r101) {
        r100.mDomain = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(OpenApiAccessConfig r100, boolean r101) {
        r100.mPublicToJS = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(OpenApiAccessConfig r100, String r101) {
        r100.mScene = r101;
        return r101;
    }

    public static /* synthetic */ LKOpenApiBizType access$402(OpenApiAccessConfig r100, LKOpenApiBizType r101) {
        r100.mBizType = r101;
        return r101;
    }

    public static OpenApiAccessConfig createOpenApiConfig(LKOpenApiBizDomain r100, LKOpenApiBizType r101, String r102, boolean r103) {
        LKOpenApiBizDomain r104 = LKOpenApiBizDomain.ALL;
        OpenApiAccessConfig r105 = new OpenApiAccessConfig(null);
        access$102(r105, r100);
        access$202(r105, r103);
        access$302(r105, r102);
        access$402(r105, r101);
        return r105;
    }
}
