package com.bytedance.sdk.open.aweme.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenHostTicketService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;

/* JADX INFO: loaded from: classes22.dex */
public class DouYinOpenSDKConfig {
    private String clientKey;
    private Context context;
    private Boolean enableDefaultTicketGuard;
    private OpenEventService eventService;
    private OpenHostInfoService hostInfoService;
    private OpenHostSettingService hostSettingService;
    private OpenHostTicketService hostTicketService;
    private OpenImageService imageService;
    private OpenLogService logService;
    private OpenNetworkService networkService;
    private OpenOptionService openOptionService;
    private boolean useClientTicket;

    public static class Builder {
        private String clientKey;
        private Context context;
        private Boolean enableDefaultTicketGuard;
        private OpenEventService eventService;
        private OpenHostInfoService hostInfoService;
        private OpenHostSettingService hostSettingService;
        private OpenHostTicketService hostTicketService;
        private OpenImageService imageService;
        private OpenLogService logService;
        private OpenNetworkService networkService;
        private OpenOptionService openOptionService;
        public boolean useClientTicket;

        public Builder() {
            this.useClientTicket = false;
        }

        public DouYinOpenSDKConfig build() {
            if (this.context == null) goto L15;
            if (TextUtils.isEmpty(this.clientKey) == true) goto L13;
            DouYinOpenSDKConfig r100 = new DouYinOpenSDKConfig(null);
            Context r101 = this.context;
            if ((r101 instanceof Application) == true) goto L10;
            r101 = r101.getApplicationContext();
        L10:
            DouYinOpenSDKConfig.access$102(r100, r101);
            DouYinOpenSDKConfig.access$202(r100, this.clientKey);
            DouYinOpenSDKConfig.access$302(r100, this.hostInfoService);
            DouYinOpenSDKConfig.access$402(r100, this.networkService);
            DouYinOpenSDKConfig.access$502(r100, this.imageService);
            DouYinOpenSDKConfig.access$602(r100, this.logService);
            DouYinOpenSDKConfig.access$702(r100, this.eventService);
            DouYinOpenSDKConfig.access$802(r100, this.enableDefaultTicketGuard);
            DouYinOpenSDKConfig.access$902(r100, this.hostSettingService);
            DouYinOpenSDKConfig.access$1002(r100, this.hostTicketService);
            DouYinOpenSDKConfig.access$1102(r100, this.useClientTicket);
            DouYinOpenSDKConfig.access$1202(r100, this.openOptionService);
            return r100;
        L13:
            throw new IllegalArgumentException("clientKey不能为空");
        L15:
            throw new IllegalArgumentException("context不能为空");
        }

        public Builder clientKey(String r100) {
            this.clientKey = r100;
            return this;
        }

        public Builder context(Context r100) {
            this.context = r100;
            return this;
        }

        public Builder enableDefaultTicketGuard(Boolean r100) {
            this.enableDefaultTicketGuard = r100;
            return this;
        }

        public Builder eventService(OpenEventService r100) {
            this.eventService = r100;
            return this;
        }

        public Builder hostInfoService(OpenHostInfoService r100) {
            this.hostInfoService = r100;
            return this;
        }

        public Builder hostSettingService(OpenHostSettingService r100) {
            this.hostSettingService = r100;
            return this;
        }

        public Builder hostTicketService(OpenHostTicketService r100) {
            this.hostTicketService = r100;
            return this;
        }

        public Builder imageService(OpenImageService r100) {
            this.imageService = r100;
            return this;
        }

        public Builder logService(OpenLogService r100) {
            this.logService = r100;
            return this;
        }

        public Builder networkService(OpenNetworkService r100) {
            this.networkService = r100;
            return this;
        }

        public Builder openOptionService(OpenOptionService r100) {
            this.openOptionService = r100;
            return this;
        }

        public Builder useClientTicket(boolean r100) {
            this.useClientTicket = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private DouYinOpenSDKConfig() {
        this.enableDefaultTicketGuard = Boolean.FALSE;
        this.useClientTicket = false;
    }

    public /* synthetic */ DouYinOpenSDKConfig(a r100) {
        this();
    }

    public static /* synthetic */ OpenHostTicketService access$1002(DouYinOpenSDKConfig r100, OpenHostTicketService r101) {
        r100.hostTicketService = r101;
        return r101;
    }

    public static /* synthetic */ Context access$102(DouYinOpenSDKConfig r100, Context r101) {
        r100.context = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1102(DouYinOpenSDKConfig r100, boolean r101) {
        r100.useClientTicket = r101;
        return r101;
    }

    public static /* synthetic */ OpenOptionService access$1202(DouYinOpenSDKConfig r100, OpenOptionService r101) {
        r100.openOptionService = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(DouYinOpenSDKConfig r100, String r101) {
        r100.clientKey = r101;
        return r101;
    }

    public static /* synthetic */ OpenHostInfoService access$302(DouYinOpenSDKConfig r100, OpenHostInfoService r101) {
        r100.hostInfoService = r101;
        return r101;
    }

    public static /* synthetic */ OpenNetworkService access$402(DouYinOpenSDKConfig r100, OpenNetworkService r101) {
        r100.networkService = r101;
        return r101;
    }

    public static /* synthetic */ OpenImageService access$502(DouYinOpenSDKConfig r100, OpenImageService r101) {
        r100.imageService = r101;
        return r101;
    }

    public static /* synthetic */ OpenLogService access$602(DouYinOpenSDKConfig r100, OpenLogService r101) {
        r100.logService = r101;
        return r101;
    }

    public static /* synthetic */ OpenEventService access$702(DouYinOpenSDKConfig r100, OpenEventService r101) {
        r100.eventService = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$802(DouYinOpenSDKConfig r100, Boolean r101) {
        r100.enableDefaultTicketGuard = r101;
        return r101;
    }

    public static /* synthetic */ OpenHostSettingService access$902(DouYinOpenSDKConfig r100, OpenHostSettingService r101) {
        r100.hostSettingService = r101;
        return r101;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public Context getContext() {
        return this.context;
    }

    public Boolean getEnableDefaultTicketGuard() {
        return this.enableDefaultTicketGuard;
    }

    public OpenEventService getEventService() {
        return this.eventService;
    }

    public OpenHostInfoService getHostInfoService() {
        return this.hostInfoService;
    }

    public OpenHostSettingService getHostSettingService() {
        return this.hostSettingService;
    }

    public OpenHostTicketService getHostTicketService() {
        return this.hostTicketService;
    }

    public OpenImageService getImageService() {
        return this.imageService;
    }

    public OpenLogService getLogService() {
        return this.logService;
    }

    public OpenNetworkService getNetworkService() {
        return this.networkService;
    }

    public OpenOptionService getOpenOptionService() {
        return this.openOptionService;
    }

    public boolean isUseClientTicket() {
        return this.useClientTicket;
    }
}
