package com.bytedance.common.wschannel;

import android.app.Application;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;

/* JADX INFO: loaded from: classes15.dex */
public class WschannelSdkInitParam {
    private Application application;
    private boolean calculateAppState;
    private boolean delayStartPushProcess;
    private boolean isEnableOfflineDetect;
    private OnMessageReceiveListener listener;
    private ConfigProvider<Boolean> optLogic;

    public static class Builder {
        private Application application;
        private boolean calculateAppState;
        private boolean delayStartPushProcess;
        private boolean isEnableOfflineDetect;
        private OnMessageReceiveListener messageReceiveListener;

        public Builder bindWsChannelServiceListener(OnBindWsChannelServiceListener r100) {
            return this;
        }

        public WschannelSdkInitParam build() {
            return new WschannelSdkInitParam(this.application, this.messageReceiveListener, this.delayStartPushProcess, this.calculateAppState, this.isEnableOfflineDetect, null);
        }

        public Builder() {
            this.delayStartPushProcess = false;
            this.calculateAppState = true;
            this.isEnableOfflineDetect = false;
        }

        public Builder application(Application r100) {
            this.application = r100;
            return this;
        }

        public Builder calculateAppState(boolean r100) {
            this.calculateAppState = r100;
            return this;
        }

        public Builder delayStartPushProcess(boolean r100) {
            this.delayStartPushProcess = r100;
            return this;
        }

        public Builder enableOfflineDetect(boolean r100) {
            this.isEnableOfflineDetect = r100;
            return this;
        }

        public Builder messageReceiveListener(OnMessageReceiveListener r100) {
            this.messageReceiveListener = r100;
            return this;
        }
    }

    public Application getApplication() {
        return this.application;
    }

    public OnMessageReceiveListener getListener() {
        return this.listener;
    }

    public ConfigProvider<Boolean> getOptLogic() {
        return this.optLogic;
    }

    public boolean isCalculateAppState() {
        return this.calculateAppState;
    }

    public boolean isDelayStartPushProcess() {
        return this.delayStartPushProcess;
    }

    public boolean isEnableOfflineDetect() {
        return this.isEnableOfflineDetect;
    }

    public WschannelSdkInitParam(Application r100, OnMessageReceiveListener r101, boolean r102, boolean r103, boolean r104, OnBindWsChannelServiceListener r105) {
        this.application = r100;
        this.listener = r101;
        this.delayStartPushProcess = r102;
        this.calculateAppState = r103;
        this.isEnableOfflineDetect = r104;
    }
}
