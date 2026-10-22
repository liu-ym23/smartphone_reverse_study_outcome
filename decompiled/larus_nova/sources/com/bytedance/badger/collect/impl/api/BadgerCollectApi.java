package com.bytedance.badger.collect.impl.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ICommonConfig;
import com.bytedance.badger.collect.impl.interfaces.ILogger;
import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi;
import com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance;
import com.bytedance.badger.collect.impl.model.DefaultSimCardComplianceImpl;
import com.bytedance.badger.collect.impl.network.DefaultNetworkImpl;
import com.bytedance.badger.collect.impl.network.impl.DefaultOperatorNetworkImpl;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: classes3.dex */
public class BadgerCollectApi {
    private static volatile Context appContext;
    private static volatile Integer appId;
    public static volatile ICommonConfig commonConfig;
    private static volatile boolean initialized;
    private static volatile String mobileChannelId;
    private static volatile INetworkApi networkApi;
    private static volatile IOperatorNetworkApi operatorNetworkApi;
    public static volatile ISimCardCompliance simCardCompliance;

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.api.BadgerCollectApi$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes47.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Integer appId;
        private ICommonConfig commonConfig;
        private final Context context;
        private ILogger logger;
        private final String mobileChannelId;
        private final INetworkApi networkApi;
        private IOperatorNetworkApi operatorNetworkApi;
        private ISimCardCompliance simCardCompliance;

        public InitConfig build() {
            return new InitConfig(this, null);
        }

        public static /* synthetic */ String access$1000(Builder r100) {
            return r100.mobileChannelId;
        }

        public static /* synthetic */ INetworkApi access$1100(Builder r100) {
            return r100.networkApi;
        }

        public static /* synthetic */ ILogger access$1200(Builder r100) {
            return r100.logger;
        }

        public static /* synthetic */ ISimCardCompliance access$1300(Builder r100) {
            return r100.simCardCompliance;
        }

        public static /* synthetic */ IOperatorNetworkApi access$1400(Builder r100) {
            return r100.operatorNetworkApi;
        }

        public static /* synthetic */ Context access$700(Builder r100) {
            return r100.context;
        }

        public static /* synthetic */ Integer access$800(Builder r100) {
            return r100.appId;
        }

        public static /* synthetic */ ICommonConfig access$900(Builder r100) {
            return r100.commonConfig;
        }

        public Builder commonConfig(ICommonConfig r100) {
            this.commonConfig = r100;
            return this;
        }

        public Builder setLogger(ILogger r100) {
            this.logger = r100;
            return this;
        }

        public Builder setOperatorNetworkApi(IOperatorNetworkApi r100) {
            this.operatorNetworkApi = r100;
            return this;
        }

        public Builder setSimCardCompliance(ISimCardCompliance r100) {
            this.simCardCompliance = r100;
            return this;
        }

        public Builder(Context r100, Integer r101, String r102, INetworkApi r103) {
            this.context = r100;
            this.appId = r101;
            this.networkApi = r103;
            this.mobileChannelId = r102;
        }
    }

    public static final class InitConfig {
        private final Integer appId;
        private final ICommonConfig commonConfig;
        private final Context context;
        private final String mobileChannelId;
        private final INetworkApi networkApi;
        private final IOperatorNetworkApi operatorNetworkApi;
        private final ISimCardCompliance simCardCompliance;

        private InitConfig(Builder r100) {
            this.context = Builder.access$700(r100);
            this.appId = Builder.access$800(r100);
            this.commonConfig = Builder.access$900(r100);
            this.mobileChannelId = Builder.access$1000(r100);
            if (Builder.access$1100(r100) == null) goto L5;
            INetworkApi r101 = Builder.access$1100(r100);
        L6:
            this.networkApi = r101;
            if (Builder.access$1200(r100) == null) goto L10;
            KLog.setLogger(Builder.access$1200(r100));
        L10:
            if (Builder.access$1300(r100) == null) goto L12;
            ISimCardCompliance r102 = Builder.access$1300(r100);
        L13:
            this.simCardCompliance = r102;
            if (Builder.access$1400(r100) == null) goto L16;
            IOperatorNetworkApi r103 = Builder.access$1400(r100);
        L17:
            this.operatorNetworkApi = r103;
            return;
        L16:
            r103 = new DefaultOperatorNetworkImpl();
            goto L17
        L12:
            r102 = new DefaultSimCardComplianceImpl();
            goto L13
        L5:
            r101 = new DefaultNetworkImpl();
            goto L6
        }

        public static /* synthetic */ Context access$000(InitConfig r100) {
            return r100.context;
        }

        public static /* synthetic */ ICommonConfig access$100(InitConfig r100) {
            return r100.commonConfig;
        }

        public static /* synthetic */ Integer access$200(InitConfig r100) {
            return r100.appId;
        }

        public static /* synthetic */ String access$300(InitConfig r100) {
            return r100.mobileChannelId;
        }

        public static /* synthetic */ ISimCardCompliance access$400(InitConfig r100) {
            return r100.simCardCompliance;
        }

        public static /* synthetic */ INetworkApi access$500(InitConfig r100) {
            return r100.networkApi;
        }

        public static /* synthetic */ IOperatorNetworkApi access$600(InitConfig r100) {
            return r100.operatorNetworkApi;
        }

        public /* synthetic */ InitConfig(Builder r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    static {
        appId = 0;
        mobileChannelId = null;
        networkApi = null;
        operatorNetworkApi = null;
        commonConfig = null;
        simCardCompliance = null;
    }

    public BadgerCollectApi() {
    }

    public static int getAppId() {
        return appId.intValue();
    }

    public static SharedPreferences getSp() {
        Context r100 = appContext;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSharedPreferences(Constants.Keys.SP_NAME, 0);
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static String getMobileChannelId() {
        return mobileChannelId;
    }

    public static INetworkApi getNetworkApi() {
        return networkApi;
    }

    public static IOperatorNetworkApi getOperatorNetworkApi() {
        return operatorNetworkApi;
    }

    public static ISimCardCompliance getSimCardCompliance() {
        return simCardCompliance;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static void init(InitConfig r100) {
        if (r100 == null) goto L17;
        if (InitConfig.access$000(r100) == null) goto L7;
        appContext = InitConfig.access$000(r100).getApplicationContext();
    L7:
        if (InitConfig.access$100(r100) == null) goto L9;
        commonConfig = InitConfig.access$100(r100);
    L9:
        Integer r101 = InitConfig.access$200(r100);
        if (r101 != null) goto L12;
    L14:
        mobileChannelId = InitConfig.access$300(r100);
        simCardCompliance = InitConfig.access$400(r100);
        networkApi = InitConfig.access$500(r100);
        operatorNetworkApi = InitConfig.access$600(r100);
        initialized = true;
        return;
    L12:
        if (r101.intValue() == 0) goto L14;
        appId = r101;
        goto L14
    L17:
        throw new IllegalArgumentException("config must not be null");
    }
}
