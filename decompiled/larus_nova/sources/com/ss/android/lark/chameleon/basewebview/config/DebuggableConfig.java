package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: classes35.dex */
public class DebuggableConfig {
    private boolean mIsVConsoleEnable;
    private boolean mIsWebViewInspectEnable;

    public static class Builder extends BaseConfigBuilder {
        private DebuggableConfig mDebuggableConfig;

        public DebuggableConfig build() {
            return this.mDebuggableConfig;
        }

        public Builder(LarkWebViewConfig.Builder r100) {
            super(r100);
            this.mDebuggableConfig = new DebuggableConfig();
        }

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r100) {
            DebuggableConfig.access$102(this.mDebuggableConfig, false);
        }

        public Builder setVConsoleEnable(boolean r100) {
            DebuggableConfig.access$002(this.mDebuggableConfig, r100);
            return this;
        }
    }

    public DebuggableConfig() {
    }

    public boolean isVConsoleEnable() {
        return this.mIsVConsoleEnable;
    }

    public boolean isWebViewInspectEnable() {
        return this.mIsWebViewInspectEnable;
    }

    public static /* synthetic */ boolean access$002(DebuggableConfig r100, boolean r101) {
        r100.mIsVConsoleEnable = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(DebuggableConfig r100, boolean r101) {
        r100.mIsWebViewInspectEnable = r101;
        return r101;
    }
}
