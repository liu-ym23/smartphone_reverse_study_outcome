package com.facebook.cache.disk;

import android.content.Context;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheConfig {
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private String mConfigBaseDirectoryName;
    private Supplier<File> mConfigBaseDirectoryPathSupplier;
    private final Context mContext;
    private final long mDefaultSizeLimit;
    private final DiskTrimmableRegistry mDiskTrimmableRegistry;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final float mEvictRatio;
    private final boolean mIndexPopulateAtStartupEnabled;
    private final long mLowDiskSpaceSizeLimit;
    private final long mMinimumSizeLimit;
    private final boolean mNeedEncrypt;
    private final boolean mNeedMD5;
    private final int mVersion;

    /* JADX INFO: renamed from: com.facebook.cache.disk.DiskCacheConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mBaseDirectoryName;
        private Supplier<File> mBaseDirectoryPathSupplier;
        private CacheErrorLogger mCacheErrorLogger;
        private CacheEventListener mCacheEventListener;
        private String mConfigBaseDirectoryName;
        private Supplier<File> mConfigBaseDirectoryPathSupplier;

        @Nullable
        private final Context mContext;
        private DiskTrimmableRegistry mDiskTrimmableRegistry;
        private EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
        private float mEvictRatio;
        private boolean mIndexPopulateAtStartupEnabled;
        private long mMaxCacheSize;
        private long mMaxCacheSizeOnLowDiskSpace;
        private long mMaxCacheSizeOnVeryLowDiskSpace;
        private boolean mNeedEncrypt;
        private boolean mNeedMD5;
        private int mVersion;

        public DiskCacheConfig build() {
            if (this.mBaseDirectoryPathSupplier == null) goto L5;
        L8:
            boolean r100 = true;
        L9:
            Preconditions.checkState(r100, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mBaseDirectoryPathSupplier != null) goto L15;
            if (this.mContext == null) goto L15;
            this.mBaseDirectoryPathSupplier = new AnonymousClass1(this);
        L15:
            if (this.mConfigBaseDirectoryPathSupplier != null) goto L20;
            if (this.mContext == null) goto L20;
            this.mConfigBaseDirectoryPathSupplier = this.mBaseDirectoryPathSupplier;
        L20:
            return new DiskCacheConfig(this, null);
        L5:
            if (this.mContext != null) goto L8;
            r100 = false;
            goto L9
        }

        private Builder(@Nullable Context r100) {
            this.mVersion = 1;
            this.mBaseDirectoryName = "image_cache";
            this.mMaxCacheSize = 41943040;
            this.mEvictRatio = 0.1f;
            this.mMaxCacheSizeOnLowDiskSpace = BdpOkClient.CACHE_MAX_SIZE;
            this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152;
            this.mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
            this.mConfigBaseDirectoryName = "image_config";
            this.mContext = r100;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.mVersion;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mBaseDirectoryName;
        }

        public static /* synthetic */ DiskTrimmableRegistry access$1000(Builder r100) {
            return r100.mDiskTrimmableRegistry;
        }

        public static /* synthetic */ Context access$1100(Builder r100) {
            return r100.mContext;
        }

        public static /* synthetic */ boolean access$1200(Builder r100) {
            return r100.mIndexPopulateAtStartupEnabled;
        }

        public static /* synthetic */ boolean access$1300(Builder r100) {
            return r100.mNeedMD5;
        }

        public static /* synthetic */ boolean access$1400(Builder r100) {
            return r100.mNeedEncrypt;
        }

        public static /* synthetic */ String access$1500(Builder r100) {
            return r100.mConfigBaseDirectoryName;
        }

        public static /* synthetic */ Supplier access$1600(Builder r100) {
            return r100.mConfigBaseDirectoryPathSupplier;
        }

        public static /* synthetic */ Supplier access$200(Builder r100) {
            return r100.mBaseDirectoryPathSupplier;
        }

        public static /* synthetic */ long access$300(Builder r100) {
            return r100.mMaxCacheSize;
        }

        public static /* synthetic */ long access$400(Builder r100) {
            return r100.mMaxCacheSizeOnLowDiskSpace;
        }

        public static /* synthetic */ long access$500(Builder r100) {
            return r100.mMaxCacheSizeOnVeryLowDiskSpace;
        }

        public static /* synthetic */ float access$600(Builder r100) {
            return r100.mEvictRatio;
        }

        public static /* synthetic */ EntryEvictionComparatorSupplier access$700(Builder r100) {
            return r100.mEntryEvictionComparatorSupplier;
        }

        public static /* synthetic */ CacheErrorLogger access$800(Builder r100) {
            return r100.mCacheErrorLogger;
        }

        public static /* synthetic */ CacheEventListener access$900(Builder r100) {
            return r100.mCacheEventListener;
        }

        public Builder setBaseDirectoryName(String r100) {
            this.mBaseDirectoryName = r100;
            return this;
        }

        public Builder setBaseDirectoryPath(File r100) {
            this.mBaseDirectoryPathSupplier = Suppliers.of(r100);
            return this;
        }

        public Builder setBaseDirectoryPathSupplier(Supplier<File> r100) {
            this.mBaseDirectoryPathSupplier = r100;
            return this;
        }

        public Builder setCacheErrorLogger(CacheErrorLogger r100) {
            this.mCacheErrorLogger = r100;
            return this;
        }

        public Builder setCacheEventListener(CacheEventListener r100) {
            this.mCacheEventListener = r100;
            return this;
        }

        public Builder setConfigBaseDirectoryName(String r100) {
            this.mConfigBaseDirectoryName = r100;
            return this;
        }

        public Builder setConfigBaseDirectoryPath(File r100) {
            this.mConfigBaseDirectoryPathSupplier = Suppliers.of(r100);
            return this;
        }

        public Builder setConfigBaseDirectoryPathSupplier(Supplier<File> r100) {
            this.mConfigBaseDirectoryPathSupplier = r100;
            return this;
        }

        public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry r100) {
            this.mDiskTrimmableRegistry = r100;
            return this;
        }

        public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier r100) {
            this.mEntryEvictionComparatorSupplier = r100;
            return this;
        }

        public Builder setEvictRatio(float r100) {
            if (r100 <= 1.0f) goto L6;
            this.mEvictRatio = 1.0f;
        L9:
            return this;
        L6:
            if (r100 >= 0.0f) goto L8;
            this.mEvictRatio = 0.0f;
            goto L9
        L8:
            this.mEvictRatio = r100;
            goto L9
        }

        public Builder setIndexPopulateAtStartupEnabled(boolean r100) {
            this.mIndexPopulateAtStartupEnabled = r100;
            return this;
        }

        public Builder setMaxCacheSize(long r100) {
            this.mMaxCacheSize = r100;
            return this;
        }

        public Builder setMaxCacheSizeOnLowDiskSpace(long r100) {
            this.mMaxCacheSizeOnLowDiskSpace = r100;
            return this;
        }

        public Builder setMaxCacheSizeOnVeryLowDiskSpace(long r100) {
            this.mMaxCacheSizeOnVeryLowDiskSpace = r100;
            return this;
        }

        public Builder setNeedEncrypt(boolean r100) {
            this.mNeedEncrypt = r100;
            return this;
        }

        public Builder setNeedMD5(boolean r100) {
            this.mNeedMD5 = r100;
            return this;
        }

        public Builder setVersion(int r100) {
            this.mVersion = r100;
            return this;
        }

        public /* synthetic */ Builder(Context r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public String getBaseDirectoryName() {
        return this.mBaseDirectoryName;
    }

    public Supplier<File> getBaseDirectoryPathSupplier() {
        return this.mBaseDirectoryPathSupplier;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        return this.mCacheErrorLogger;
    }

    public CacheEventListener getCacheEventListener() {
        return this.mCacheEventListener;
    }

    public String getConfigBaseDirectoryName() {
        return this.mConfigBaseDirectoryName;
    }

    public Supplier<File> getConfigBaseDirectoryPathSupplier() {
        return this.mConfigBaseDirectoryPathSupplier;
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getDefaultSizeLimit() {
        return this.mDefaultSizeLimit;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.mDiskTrimmableRegistry;
    }

    public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        return this.mEntryEvictionComparatorSupplier;
    }

    public float getEvictRatio() {
        return this.mEvictRatio;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        return this.mIndexPopulateAtStartupEnabled;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.mLowDiskSpaceSizeLimit;
    }

    public long getMinimumSizeLimit() {
        return this.mMinimumSizeLimit;
    }

    public boolean getNeedEncrypt() {
        return this.mNeedEncrypt;
    }

    public boolean getNeedMD5() {
        return this.mNeedMD5;
    }

    public int getVersion() {
        return this.mVersion;
    }

    private DiskCacheConfig(Builder r100) {
        this.mVersion = Builder.access$000(r100);
        this.mBaseDirectoryName = (String) Preconditions.checkNotNull(Builder.access$100(r100));
        this.mBaseDirectoryPathSupplier = (Supplier) Preconditions.checkNotNull(Builder.access$200(r100));
        this.mDefaultSizeLimit = Builder.access$300(r100);
        this.mLowDiskSpaceSizeLimit = Builder.access$400(r100);
        this.mMinimumSizeLimit = Builder.access$500(r100);
        this.mEvictRatio = Builder.access$600(r100);
        this.mEntryEvictionComparatorSupplier = (EntryEvictionComparatorSupplier) Preconditions.checkNotNull(Builder.access$700(r100));
        if (Builder.access$800(r100) != null) goto L5;
        CacheErrorLogger r101 = NoOpCacheErrorLogger.getInstance();
    L6:
        this.mCacheErrorLogger = r101;
        if (Builder.access$900(r100) != null) goto L9;
        CacheEventListener r102 = NoOpCacheEventListener.getInstance();
    L10:
        this.mCacheEventListener = r102;
        if (Builder.access$1000(r100) != null) goto L13;
        DiskTrimmableRegistry r103 = NoOpDiskTrimmableRegistry.getInstance();
    L14:
        this.mDiskTrimmableRegistry = r103;
        this.mContext = Builder.access$1100(r100);
        this.mIndexPopulateAtStartupEnabled = Builder.access$1200(r100);
        this.mNeedMD5 = Builder.access$1300(r100);
        this.mNeedEncrypt = Builder.access$1400(r100);
        this.mConfigBaseDirectoryName = Builder.access$1500(r100);
        this.mConfigBaseDirectoryPathSupplier = Builder.access$1600(r100);
        return;
    L13:
        r103 = Builder.access$1000(r100);
        goto L14
    L9:
        r102 = Builder.access$900(r100);
        goto L10
    L5:
        r101 = Builder.access$800(r100);
        goto L6
    }

    public static Builder newBuilder(@Nullable Context r100) {
        return new Builder(r100, null);
    }

    public /* synthetic */ DiskCacheConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
