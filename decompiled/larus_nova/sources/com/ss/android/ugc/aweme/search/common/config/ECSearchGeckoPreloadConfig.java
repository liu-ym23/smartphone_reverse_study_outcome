package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchGeckoPreloadConfig;", "Ljava/io/Serializable;", "()V", "channelConfigMap", "", "", "Lcom/ss/android/ugc/aweme/search/common/config/ECSearchGeckoPreloadConfig$ItemConfig;", "getChannelConfigMap", "()Ljava/util/Map;", "ItemConfig", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchGeckoPreloadConfig implements Serializable {

    @SerializedName("channel_config_map")
    private final Map<String, ItemConfig> channelConfigMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchGeckoPreloadConfig$ItemConfig;", "", "accessKeyOnline", "", "accessKeyDebug", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyDebug", "()Ljava/lang/String;", "getAccessKeyOnline", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemConfig {

        @SerializedName("access_key_debug")
        private final String accessKeyDebug;

        @SerializedName("access_key_online")
        private final String accessKeyOnline;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemConfig() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ItemConfig copy$default(ItemConfig r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.accessKeyOnline;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.accessKeyDebug;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.accessKeyOnline;
        }

        public final String component2() {
            return this.accessKeyDebug;
        }

        public final ItemConfig copy(String r100, String r101) {
            return new ItemConfig(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ItemConfig) == false) goto L10;
            ItemConfig r101 = (ItemConfig) r100;
            if (Intrinsics.areEqual(this.accessKeyOnline, r101.accessKeyOnline) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.accessKeyDebug, r101.accessKeyDebug) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.accessKeyOnline;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.accessKeyDebug;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ItemConfig(accessKeyOnline=" + this.accessKeyOnline + ", accessKeyDebug=" + this.accessKeyDebug + ")";
        }

        public final String getAccessKeyDebug() {
            return this.accessKeyDebug;
        }

        public final String getAccessKeyOnline() {
            return this.accessKeyOnline;
        }

        public ItemConfig(String r100, String r101) {
            this.accessKeyOnline = r100;
            this.accessKeyDebug = r101;
        }

        public /* synthetic */ ItemConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public ECSearchGeckoPreloadConfig() {
    }

    public final Map<String, ItemConfig> getChannelConfigMap() {
        return this.channelConfigMap;
    }
}
