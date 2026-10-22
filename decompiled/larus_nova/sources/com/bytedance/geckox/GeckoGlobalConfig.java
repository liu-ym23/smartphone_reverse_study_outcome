package com.bytedance.geckox;

import android.content.Context;
import android.util.Pair;
import com.bytedance.geckox.net.INetWork;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes19.dex */
public class GeckoGlobalConfig extends BaseGeckoConfig {
    private final String mAppChannel;
    private final long mAppColdStartTime;
    private final ENVType mEnv;
    private final IMonitorConfig mMonitorConfig;
    private final IRequestTagHeaderProvider mRequestTagHeaderProvider;
    private final String mRootDir;

    public static class Builder extends BaseGeckoConfig.BaseGeckoConfigBuilder<Builder> {
        private String appChannel;
        private long appColdStartTime;
        private ENVType env;
        private IMonitorConfig monitorConfig;
        private IRequestTagHeaderProvider requestTagHeaderProvider;
        private String rootDir;

        public GeckoGlobalConfig build() {
            return new GeckoGlobalConfig(this, null);
        }

        public Builder(Context r100) {
            super(r100.getApplicationContext());
        }

        public static /* synthetic */ ENVType access$000(Builder r100) {
            return r100.env;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.rootDir;
        }

        public static /* synthetic */ IRequestTagHeaderProvider access$200(Builder r100) {
            return r100.requestTagHeaderProvider;
        }

        public static /* synthetic */ IMonitorConfig access$300(Builder r100) {
            return r100.monitorConfig;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.appChannel;
        }

        public static /* synthetic */ long access$500(Builder r100) {
            return r100.appColdStartTime;
        }

        public Builder appChannel(String r100) {
            this.appChannel = r100;
            return this;
        }

        public Builder appColdStartTime(long r100) {
            this.appColdStartTime = r100;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appId(long r100) {
            return (Builder) super.appId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appVersion(String r100) {
            return (Builder) super.appVersion(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder checkUpdateExecutor(Executor r100) {
            return (Builder) super.checkUpdateExecutor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder deviceId(String r100) {
            return (Builder) super.deviceId(r100);
        }

        public Builder env(ENVType r100) {
            this.env = r100;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder host(String r100) {
            return (Builder) super.host(r100);
        }

        public Builder monitorConfig(IMonitorConfig r100) {
            this.monitorConfig = r100;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder netStack(INetWork r100) {
            return (Builder) super.netStack(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder region(String r100) {
            return (Builder) super.region(r100);
        }

        public Builder requestTagHeaderProvider(IRequestTagHeaderProvider r100) {
            this.requestTagHeaderProvider = r100;
            return this;
        }

        public Builder rootDir(String r100) {
            this.rootDir = r100;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder statisticMonitor(az5.a r100) {
            return (Builder) super.statisticMonitor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder updateExecutor(Executor r100) {
            return (Builder) super.updateExecutor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder useMMap(boolean r100) {
            return (Builder) super.useMMap(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appId(long r100) {
            return appId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appVersion(String r100) {
            return appVersion(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder checkUpdateExecutor(Executor r100) {
            return checkUpdateExecutor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder deviceId(String r100) {
            return deviceId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder host(String r100) {
            return host(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder netStack(INetWork r100) {
            return netStack(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder region(String r100) {
            return region(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder statisticMonitor(az5.a r100) {
            return statisticMonitor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder updateExecutor(Executor r100) {
            return updateExecutor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder useMMap(boolean r100) {
            return useMMap(r100);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum ENVType extends Enum<ENVType> {
        private static final /* synthetic */ ENVType[] $VALUES = null;
        public static final ENVType BOE = null;
        public static final ENVType DEV = null;
        public static final ENVType PROD = null;
        private int val;

        static {
            ENVType r100 = new ENVType("BOE", 0, 1);
            BOE = r100;
            ENVType r101 = new ENVType("DEV", 1, 1);
            DEV = r101;
            ENVType r102 = new ENVType("PROD", 2, 2);
            PROD = r102;
            $VALUES = new ENVType[]{r100, r101, r102};
        }

        public static ENVType[] values() {
            return (ENVType[]) $VALUES.clone();
        }

        public int getVal() {
            return this.val;
        }

        public static ENVType valueOf(String r100) {
            return (ENVType) r27.a.a(ENVType.class, r100);
        }

        private ENVType(String r100, int r101, int r102) {
            super(r100, r101);
            this.val = r102;
        }
    }

    public interface IMonitorConfig {
        String getChannel();

        Map<String, String> getCommonParams();

        String getMonitorHost();

        String getPackageId();

        String getUpdateVersionCode();

        boolean isOversea();
    }

    public interface IRequestTagHeaderProvider {
        Pair<String, String> getRequestTagHeader(boolean r100);
    }

    public static /* synthetic */ class a {
    }

    public String getAppChannel() {
        return this.mAppChannel;
    }

    public long getAppColdStartTime() {
        return this.mAppColdStartTime;
    }

    public ENVType getEnv() {
        return this.mEnv;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.mMonitorConfig;
    }

    public IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return this.mRequestTagHeaderProvider;
    }

    public String getRootDir() {
        return this.mRootDir;
    }

    private GeckoGlobalConfig(Builder r100) {
        super(r100);
        ENVType r101 = Builder.access$000(r100);
        this.mEnv = r101;
        if (r101 == null) goto L17;
        if (AppSettingsManager.b.f245071a.a() == true) goto L7;
    L11:
        this.mRequestTagHeaderProvider = Builder.access$200(r100);
        this.mMonitorConfig = Builder.access$300(r100);
        this.mAppChannel = Builder.access$400(r100);
        this.mRootDir = Builder.access$100(r100);
        if (Builder.access$500(r100) != 0) goto L14;
        this.mAppColdStartTime = System.currentTimeMillis();
        return;
    L14:
        this.mAppColdStartTime = Builder.access$500(r100);
        return;
    L7:
        if (Builder.access$100(r100) != null) goto L11;
        throw new IllegalArgumentException("rootDir is required");
    L17:
        throw new IllegalArgumentException("env is required");
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setDeviceId(String r100) {
        this.mDeviceId = r100;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setHost(String r100) {
        this.mHost = r100;
    }

    public /* synthetic */ GeckoGlobalConfig(Builder r100, a r101) {
        this(r100);
    }
}
