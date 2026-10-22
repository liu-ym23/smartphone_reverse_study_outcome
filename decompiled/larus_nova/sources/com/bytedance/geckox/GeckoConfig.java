package com.bytedance.geckox;

import android.content.Context;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class GeckoConfig extends BaseGeckoConfig {
    private final List<String> mAccessKeys;
    private final qy5.a mCacheConfig;
    private final File resRootDir;

    public static class Builder extends BaseGeckoConfig.BaseGeckoConfigBuilder<Builder> {
        private List<String> mAccessKeys;
        private qy5.a mCacheConfig;
        private File resRootDir;

        public Builder allLocalAccessKeys(String... r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appVersion(String r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder checkUpdateExecutor(Executor r100) {
            return this;
        }

        public Builder isLoopCheck(boolean r100) {
            return this;
        }

        public Builder needServerMonitor(boolean r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder netStack(INetWork r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder region(String r100) {
            return this;
        }

        public Builder setEnableSync(boolean r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder statisticMonitor(az5.a r100) {
            return this;
        }

        public Builder uid(String r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder updateExecutor(Executor r100) {
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder useMMap(boolean r100) {
            return this;
        }

        public GeckoConfig build() {
            return new GeckoConfig(this, null);
        }

        public Builder(Context r100) {
            super(r100.getApplicationContext());
        }

        public static /* synthetic */ List access$000(Builder r100) {
            return r100.mAccessKeys;
        }

        public static /* synthetic */ qy5.a access$100(Builder r100) {
            return r100.mCacheConfig;
        }

        public static /* synthetic */ File access$200(Builder r100) {
            return r100.resRootDir;
        }

        public Builder accessKey(String... r100) {
            if (r100 != null) goto L4;
        L6:
            return this;
        L4:
            if (r100.length < 1) goto L6;
            this.mAccessKeys = Arrays.asList(r100);
            goto L6
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appId(long r100) {
            return (Builder) super.appId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appVersion(String r100) {
            return appVersion(r100);
        }

        public Builder cacheConfig(qy5.a r100) {
            this.mCacheConfig = r100;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder checkUpdateExecutor(Executor r100) {
            return checkUpdateExecutor(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder deviceId(String r100) {
            return (Builder) super.deviceId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder host(String r100) {
            return (Builder) super.host(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder netStack(INetWork r100) {
            return netStack(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder region(String r100) {
            return region(r100);
        }

        public Builder resRootDir(File r100) {
            this.resRootDir = r100;
            return this;
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

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appId(long r100) {
            return appId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder deviceId(String r100) {
            return deviceId(r100);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder host(String r100) {
            return host(r100);
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static /* synthetic */ class a {
    }

    public String getAccessKey() {
        return (String) ListProtector.get(this.mAccessKeys, 0);
    }

    public List<String> getAccessKeys() {
        return this.mAccessKeys;
    }

    public qy5.a getCacheConfig() {
        return this.mCacheConfig;
    }

    public File getResRootDir() {
        return this.resRootDir;
    }

    private GeckoConfig(Builder r100) {
        super(r100);
        List<String> r101 = Builder.access$000(r100);
        this.mAccessKeys = r101;
        this.mCacheConfig = Builder.access$100(r100);
        if (Builder.access$200(r100) != null) goto L5;
        this.resRootDir = new PolarisFileWrapper(getContext().getFilesDir(), GeckoClient.GECKO_ROOT_DIR);
    L6:
        if (r101 == null) goto L11;
        if (r101.isEmpty() == true) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("accessKey is empty");
    L5:
        this.resRootDir = Builder.access$200(r100);
        goto L6
    }

    public /* synthetic */ GeckoConfig(Builder r100, a r101) {
        this(r100);
    }
}
