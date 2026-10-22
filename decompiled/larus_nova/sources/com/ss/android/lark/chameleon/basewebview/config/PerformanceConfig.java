package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: classes35.dex */
public class PerformanceConfig {
    private volatile boolean mPerformanceEnable;

    public static class Builder extends BaseConfigBuilder {
        private PerformanceConfig mPerformanceConfig;

        public PerformanceConfig build() {
            return this.mPerformanceConfig;
        }

        public Builder(LarkWebViewConfig.Builder r100) {
            super(r100);
            this.mPerformanceConfig = new PerformanceConfig();
        }

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r100) {
            PerformanceConfig.access$002(this.mPerformanceConfig, true);
        }

        public void setPerformanceState(boolean r100) {
            PerformanceConfig.access$002(this.mPerformanceConfig, r100);
        }
    }

    public PerformanceConfig() {
        this.mPerformanceEnable = true;
    }

    public boolean isPerformanceEnable() {
        return this.mPerformanceEnable;
    }

    public static /* synthetic */ boolean access$002(PerformanceConfig r100, boolean r101) {
        r100.mPerformanceEnable = r101;
        return r101;
    }
}
