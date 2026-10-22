package com.bytedance.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.INetWork;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class BaseGeckoConfig {
    protected Long mAppId;
    protected String mAppVersion;
    private final Context mContext;
    protected String mDeviceId;
    protected String mHost;
    protected INetWork mNetWork;
    private final az5.a mStatisticMonitor;
    private final boolean mUseMMap;

    public static class BaseGeckoConfigBuilder<T extends BaseGeckoConfigBuilder> {
        private Long appId;
        private String appVersion;
        private Context context;
        private String deviceId;
        private String host;
        private INetWork netWork;
        private az5.a statisticMonitor;
        private boolean useMMap;

        public T checkUpdateExecutor(Executor r100) {
            return this;
        }

        public T region(String r100) {
            return this;
        }

        public T updateExecutor(Executor r100) {
            return this;
        }

        public BaseGeckoConfigBuilder(Context r100) {
            this.useMMap = true;
            this.context = r100;
        }

        public static /* synthetic */ Context access$000(BaseGeckoConfigBuilder r100) {
            return r100.context;
        }

        public static /* synthetic */ Long access$100(BaseGeckoConfigBuilder r100) {
            return r100.appId;
        }

        public static /* synthetic */ String access$200(BaseGeckoConfigBuilder r100) {
            return r100.appVersion;
        }

        public static /* synthetic */ String access$300(BaseGeckoConfigBuilder r100) {
            return r100.deviceId;
        }

        public static /* synthetic */ String access$400(BaseGeckoConfigBuilder r100) {
            return r100.host;
        }

        public static /* synthetic */ INetWork access$500(BaseGeckoConfigBuilder r100) {
            return r100.netWork;
        }

        public static /* synthetic */ boolean access$600(BaseGeckoConfigBuilder r100) {
            return r100.useMMap;
        }

        public static /* synthetic */ az5.a access$700(BaseGeckoConfigBuilder r100) {
            return r100.statisticMonitor;
        }

        public T appId(long r100) {
            this.appId = Long.valueOf(r100);
            return this;
        }

        public T appVersion(String r100) {
            this.appVersion = r100;
            return this;
        }

        public T deviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public T host(String r100) {
            this.host = r100;
            return this;
        }

        public T netStack(INetWork r100) {
            this.netWork = r100;
            return this;
        }

        public T statisticMonitor(az5.a r100) {
            this.statisticMonitor = r100;
            return this;
        }

        public T useMMap(boolean r100) {
            this.useMMap = r100;
            return this;
        }
    }

    public String getRegion() {
        return "";
    }

    public long getAppId() {
        return this.mAppId.longValue();
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getHost() {
        return this.mHost;
    }

    public INetWork getNetWork() {
        return this.mNetWork;
    }

    public az5.a getStatisticMonitor() {
        return this.mStatisticMonitor;
    }

    public boolean isUseMMap() {
        return this.mUseMMap;
    }

    public BaseGeckoConfig(BaseGeckoConfigBuilder r100) {
        Context r101 = BaseGeckoConfigBuilder.access$000(r100);
        this.mContext = r101;
        if (r101 == null) goto L31;
        this.mAppId = BaseGeckoConfigBuilder.access$100(r100);
        if (TextUtils.isEmpty(BaseGeckoConfigBuilder.access$200(r100)) == false) goto L12;
        int r102 = ez5.a.f474883a;
        String r103 = r101.getPackageManager().getPackageInfo(r101.getPackageName(), 0).versionName;     // Catch: Exception -> L9
    L11:
        this.mAppVersion = r103;
    L13:
        this.mDeviceId = BaseGeckoConfigBuilder.access$300(r100);
        String r104 = BaseGeckoConfigBuilder.access$400(r100);
        this.mHost = r104;
        if (r104 == null) goto L29;
        if (this.mAppId == null) goto L27;
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L21;
        this.mDeviceId = "empty_device_id";
    L21:
        if (BaseGeckoConfigBuilder.access$500(r100) != null) goto L23;
        this.mNetWork = new wy5.a();
    L24:
        this.mUseMMap = BaseGeckoConfigBuilder.access$600(r100);
        this.mStatisticMonitor = BaseGeckoConfigBuilder.access$700(r100);
        return;
    L23:
        this.mNetWork = BaseGeckoConfigBuilder.access$500(r100);
        goto L24
    L27:
        throw new IllegalArgumentException("appId is null");
    L29:
        throw new IllegalArgumentException("host is null");
    L9:
        e = move-exception;
        GeckoLogger.w("getVersion:", e);
        r103 = "null";
        goto L11
    L12:
        this.mAppVersion = BaseGeckoConfigBuilder.access$200(r100);
        goto L13
    L31:
        throw new IllegalArgumentException("context == null");
    }

    public void setAppId(long r100) {
        this.mAppId = Long.valueOf(r100);
    }

    public void setDeviceId(String r100) {
        this.mDeviceId = r100;
    }

    public void setHost(String r100) {
        this.mHost = r100;
    }

    public void setNetWork(INetWork r100) {
        this.mNetWork = r100;
    }
}
