package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: classes35.dex */
public class LarkWebViewConfig {
    private static final String TAG = "LarkWebViewConfig";
    private DebuggableConfig mDebuggableConfig;
    private PerformanceConfig mPerformanceConfig;
    private WebSettingConfig mWebSettingConfig;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.basewebview.config.LarkWebViewConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        DebuggableConfig.Builder mDebuggableConfigBuilder;
        PerformanceConfig.Builder mPerformanceBuilder;
        WebSettingConfig.Builder mWebSettingConfigBuilder;

        public LarkWebViewConfig build() {
            LarkWebViewConfig r100 = new LarkWebViewConfig(null);
            LarkWebViewConfig.access$102(r100, this.mDebuggableConfigBuilder.build());
            LarkWebViewConfig.access$202(r100, this.mWebSettingConfigBuilder.build());
            LarkWebViewConfig.access$302(r100, this.mPerformanceBuilder.build());
            return r100;
        }

        public DebuggableConfig.Builder debuggableBuilder() {
            return this.mDebuggableConfigBuilder;
        }

        public PerformanceConfig.Builder performanceBuilder() {
            return this.mPerformanceBuilder;
        }

        public WebSettingConfig.Builder webSettingBuilder() {
            return this.mWebSettingConfigBuilder;
        }

        public Builder(Context r100) {
            this.mDebuggableConfigBuilder = new DebuggableConfig.Builder(this);
            this.mWebSettingConfigBuilder = new WebSettingConfig.Builder(this);
            this.mPerformanceBuilder = new PerformanceConfig.Builder(this);
            this.mDebuggableConfigBuilder.initDefaultConfig(r100);
            this.mWebSettingConfigBuilder.initDefaultConfig(r100);
            this.mPerformanceBuilder.initDefaultConfig(r100);
        }

        public LarkWebViewConfig apply(LarkWebViewConfig r100) {
            LarkWebViewConfig r101 = new LarkWebViewConfig(null);
            if (LarkWebViewConfig.access$100(r100) == null) goto L5;
            DebuggableConfig r102 = LarkWebViewConfig.access$100(r100);
        L6:
            LarkWebViewConfig.access$102(r101, r102);
            if (LarkWebViewConfig.access$200(r100) == null) goto L9;
            WebSettingConfig r103 = LarkWebViewConfig.access$200(r100);
        L10:
            LarkWebViewConfig.access$202(r101, r103);
            if (LarkWebViewConfig.access$300(r100) == null) goto L13;
            PerformanceConfig r104 = LarkWebViewConfig.access$300(r100);
        L14:
            LarkWebViewConfig.access$302(r101, r104);
            return r101;
        L13:
            r104 = this.mPerformanceBuilder.build();
            goto L14
        L9:
            r103 = this.mWebSettingConfigBuilder.build();
            goto L10
        L5:
            r102 = this.mDebuggableConfigBuilder.build();
            goto L6
        }
    }

    private LarkWebViewConfig() {
    }

    public DebuggableConfig getDebuggableConfig() {
        return this.mDebuggableConfig;
    }

    public PerformanceConfig getPerformanceConfig() {
        return this.mPerformanceConfig;
    }

    public WebSettingConfig getWebSettingConfig() {
        return this.mWebSettingConfig;
    }

    public /* synthetic */ LarkWebViewConfig(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ DebuggableConfig access$100(LarkWebViewConfig r100) {
        return r100.mDebuggableConfig;
    }

    public static /* synthetic */ WebSettingConfig access$200(LarkWebViewConfig r100) {
        return r100.mWebSettingConfig;
    }

    public static /* synthetic */ PerformanceConfig access$300(LarkWebViewConfig r100) {
        return r100.mPerformanceConfig;
    }

    public static LarkWebViewConfig createDefault(Context r100) {
        return new Builder(r100).build();
    }

    public void setDebuggableConfig(DebuggableConfig r100) {
        this.mDebuggableConfig = r100;
    }

    public void setPerformanceConfig(PerformanceConfig r100) {
        this.mPerformanceConfig = r100;
    }

    public void setWebSettingConfig(WebSettingConfig r100) {
        this.mWebSettingConfig = r100;
    }

    public static /* synthetic */ DebuggableConfig access$102(LarkWebViewConfig r100, DebuggableConfig r101) {
        r100.mDebuggableConfig = r101;
        return r101;
    }

    public static /* synthetic */ WebSettingConfig access$202(LarkWebViewConfig r100, WebSettingConfig r101) {
        r100.mWebSettingConfig = r101;
        return r101;
    }

    public static /* synthetic */ PerformanceConfig access$302(LarkWebViewConfig r100, PerformanceConfig r101) {
        r100.mPerformanceConfig = r101;
        return r101;
    }
}
