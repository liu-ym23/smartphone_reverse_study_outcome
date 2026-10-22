package com.bytedance.geckox.settings.model;

import com.bytedance.iesgurd.settings.c;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\t\u001d\u001e\u001f !\"#$%B;\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings;", "", "", "version", "Ljava/lang/String;", "getVersion$geckox_noasanRelease", "()Ljava/lang/String;", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$SettingsConfig;", "settingsConfig", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$SettingsConfig;", "getSettingsConfig$geckox_noasanRelease", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$SettingsConfig;", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", "resourceMeta", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", "getResourceMeta", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ReqMeta;", "reqMeta", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ReqMeta;", "getReqMeta$geckox_noasanRelease", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ReqMeta;", "Lcom/bytedance/iesgurd/settings/c;", "updateConfig", "Lcom/bytedance/iesgurd/settings/c;", "getUpdateConfig$geckox_noasanRelease", "()Lcom/bytedance/iesgurd/settings/c;", "<init>", "(Ljava/lang/String;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$SettingsConfig;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ReqMeta;Lcom/bytedance/iesgurd/settings/c;)V", "AccessKeyMetaInfo", "CDNFallBackConfig", "CDNMultiVersion", "ChannelMetaInfo", "CurrentLevelConfig", "PipelineStep", "ReqMeta", "ResourceMeta", "SettingsConfig", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class GlobalConfigSettings {

    @SerializedName("req_meta")
    private final ReqMeta reqMeta;

    @SerializedName("resource_meta")
    private final ResourceMeta resourceMeta;

    @SerializedName("settings_config")
    private final SettingsConfig settingsConfig;

    @SerializedName("update_config")
    private final c updateConfig;

    @SerializedName("version")
    private final String version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$AccessKeyMetaInfo;", "", "channels", "", "", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ChannelMetaInfo;", "config", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "(Ljava/util/Map;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;)V", "getChannels", "()Ljava/util/Map;", "getConfig", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class AccessKeyMetaInfo {

        @SerializedName("channels")
        private final Map<String, ChannelMetaInfo> channels;

        @SerializedName("config")
        private final CurrentLevelConfig config;

        /* JADX WARN: Multi-variable type inference failed */
        public AccessKeyMetaInfo() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final Map<String, ChannelMetaInfo> getChannels() {
            return this.channels;
        }

        public final CurrentLevelConfig getConfig() {
            return this.config;
        }

        public AccessKeyMetaInfo(Map<String, ChannelMetaInfo> r100, CurrentLevelConfig r101) {
            this.channels = r100;
            this.config = r101;
        }

        public /* synthetic */ AccessKeyMetaInfo(Map r100, CurrentLevelConfig r101, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            r100 = MapsKt.emptyMap();
        L6:
            if ((r110 & 2) == 0) goto L8;
            r101 = new CurrentLevelConfig(null, null, null, null, 15, null);
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNFallBackConfig;", "", "domains", "", "", "maxAttempts", "", "shuffle", "(Ljava/util/List;II)V", "getDomains", "()Ljava/util/List;", "getMaxAttempts", "()I", "getShuffle", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class CDNFallBackConfig {

        @SerializedName("domains")
        private final List<String> domains;

        @SerializedName("max_attempts")
        private final int maxAttempts;

        @SerializedName("shuffle")
        private final int shuffle;

        public CDNFallBackConfig() {
            this(null, 0, 0, 7, null);
        }

        public final List<String> getDomains() {
            return this.domains;
        }

        public final int getMaxAttempts() {
            return this.maxAttempts;
        }

        public final int getShuffle() {
            return this.shuffle;
        }

        public CDNFallBackConfig(List<String> r100, int r101, int r102) {
            this.domains = r100;
            this.maxAttempts = r101;
            this.shuffle = r102;
        }

        public /* synthetic */ CDNFallBackConfig(List r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = new ArrayList();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNMultiVersion;", "", "domains", "", "", "(Ljava/util/List;)V", "getDomains", "()Ljava/util/List;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class CDNMultiVersion {

        @SerializedName("domains")
        private final List<String> domains;

        /* JADX WARN: Multi-variable type inference failed */
        public CDNMultiVersion() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final List<String> getDomains() {
            return this.domains;
        }

        public CDNMultiVersion(List<String> r100) {
            this.domains = r100;
        }

        public /* synthetic */ CDNMultiVersion(List r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = CollectionsKt.emptyList();
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ChannelMetaInfo;", "", "config", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "(Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;)V", "getConfig", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ChannelMetaInfo {

        @SerializedName("config")
        private final CurrentLevelConfig config;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelMetaInfo() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final CurrentLevelConfig getConfig() {
            return this.config;
        }

        public ChannelMetaInfo(CurrentLevelConfig r100) {
            this.config = r100;
        }

        public /* synthetic */ ChannelMetaInfo(CurrentLevelConfig r100, int r101, DefaultConstructorMarker r110) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new CurrentLevelConfig(null, null, null, null, 15, null);
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "", "pipeline", "", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$PipelineStep;", "cdnFallback", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNFallBackConfig;", "prefix2AccessKey", "", "", "cdnMultiVersion", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNMultiVersion;", "(Ljava/util/List;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNFallBackConfig;Ljava/util/Map;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNMultiVersion;)V", "getCdnFallback", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNFallBackConfig;", "getCdnMultiVersion", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CDNMultiVersion;", "getPipeline", "()Ljava/util/List;", "getPrefix2AccessKey", "()Ljava/util/Map;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class CurrentLevelConfig {

        @SerializedName("cdn_fallback")
        private final CDNFallBackConfig cdnFallback;

        @SerializedName("cdn_multi_version")
        private final CDNMultiVersion cdnMultiVersion;

        @SerializedName("pipeline")
        private final List<PipelineStep> pipeline;

        @SerializedName("prefix_2_ak")
        private final Map<String, String> prefix2AccessKey;

        public CurrentLevelConfig() {
            this(null, null, null, null, 15, null);
        }

        public final CDNFallBackConfig getCdnFallback() {
            return this.cdnFallback;
        }

        public final CDNMultiVersion getCdnMultiVersion() {
            return this.cdnMultiVersion;
        }

        public final List<PipelineStep> getPipeline() {
            return this.pipeline;
        }

        public final Map<String, String> getPrefix2AccessKey() {
            return this.prefix2AccessKey;
        }

        public CurrentLevelConfig(List<PipelineStep> r100, CDNFallBackConfig r101, Map<String, String> r102, CDNMultiVersion r103) {
            this.pipeline = r100;
            this.cdnFallback = r101;
            this.prefix2AccessKey = r102;
            this.cdnMultiVersion = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ CurrentLevelConfig(List r100, CDNFallBackConfig r101, Map r110, CDNMultiVersion r111, int r112, DefaultConstructorMarker r113) {
            List r102 = null;
            Object[] r103 = 0;
            if ((r112 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r112 & 2) == 0) goto L9;
            r101 = new CDNFallBackConfig(null, 0, 0, 7, null);
        L9:
            if ((r112 & 4) == 0) goto L12;
            r110 = MapsKt.emptyMap();
        L12:
            if ((r112 & 8) == 0) goto L14;
            r111 = new CDNMultiVersion(r102, 1, r103 == true ? 1 : 0);
        L14:
            this(r100, r101, r110, r111);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$PipelineStep;", "", "type", "", "update", "noCache", "(III)V", "getNoCache", "()I", "getType", "getUpdate", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class PipelineStep {

        @SerializedName("no_cache")
        private final int noCache;

        @SerializedName("type")
        private final int type;

        @SerializedName("update")
        private final int update;

        public PipelineStep() {
            this(0, 0, 0, 7, null);
        }

        public final int getNoCache() {
            return this.noCache;
        }

        public final int getType() {
            return this.type;
        }

        public final int getUpdate() {
            return this.update;
        }

        public PipelineStep(int r100, int r101, int r102) {
            this.type = r100;
            this.update = r101;
            this.noCache = r102;
        }

        public /* synthetic */ PipelineStep(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ReqMeta;", "", "enable", "", "pollingInterval", "", "aks", "", "", "(ZILjava/util/List;)V", "getAks", "()Ljava/util/List;", "getEnable", "()Z", "getPollingInterval", "()I", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ReqMeta {

        @SerializedName("aks")
        private final List<String> aks;

        @SerializedName("enable")
        private final boolean enable;

        @SerializedName("polling_interval")
        private final int pollingInterval;

        public ReqMeta() {
            this(false, 0, null, 7, null);
        }

        public final List<String> getAks() {
            return this.aks;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final int getPollingInterval() {
            return this.pollingInterval;
        }

        public ReqMeta(boolean r100, int r101, List<String> r102) {
            this.enable = r100;
            this.pollingInterval = r101;
            this.aks = r102;
        }

        public /* synthetic */ ReqMeta(boolean r100, int r101, List r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = CollectionsKt.emptyList();
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", "", "accessKeys", "", "", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$AccessKeyMetaInfo;", "config", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "(Ljava/util/Map;Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;)V", "getAccessKeys", "()Ljava/util/Map;", "setAccessKeys", "(Ljava/util/Map;)V", "getConfig", "()Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$CurrentLevelConfig;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ResourceMeta {

        @SerializedName("access_keys")
        private Map<String, AccessKeyMetaInfo> accessKeys;

        @SerializedName("config")
        private final CurrentLevelConfig config;

        /* JADX WARN: Multi-variable type inference failed */
        public ResourceMeta() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final Map<String, AccessKeyMetaInfo> getAccessKeys() {
            return this.accessKeys;
        }

        public final CurrentLevelConfig getConfig() {
            return this.config;
        }

        public final void setAccessKeys(Map<String, AccessKeyMetaInfo> r100) {
            this.accessKeys = r100;
        }

        public ResourceMeta(Map<String, AccessKeyMetaInfo> r100, CurrentLevelConfig r101) {
            this.accessKeys = r100;
            this.config = r101;
        }

        public /* synthetic */ ResourceMeta(Map r100, CurrentLevelConfig r101, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            r100 = MapsKt.emptyMap();
        L6:
            if ((r110 & 2) == 0) goto L8;
            r101 = new CurrentLevelConfig(null, null, null, null, 15, null);
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$SettingsConfig;", "", "pollingInterval", "", "(J)V", "getPollingInterval", "()J", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class SettingsConfig {

        @SerializedName("polling_interval")
        private final long pollingInterval;

        public SettingsConfig() {
            long r100 = 0;
            this(r100, 1, null);
        }

        public final long getPollingInterval() {
            return this.pollingInterval;
        }

        public SettingsConfig(long r100) {
            this.pollingInterval = r100;
        }

        public /* synthetic */ SettingsConfig(long r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 0;
        L5:
            this(r100);
        }
    }

    public GlobalConfigSettings() {
        this(null, null, null, null, null, 31, null);
    }

    public final ReqMeta getReqMeta$geckox_noasanRelease() {
        return this.reqMeta;
    }

    public final ResourceMeta getResourceMeta() {
        return this.resourceMeta;
    }

    public final SettingsConfig getSettingsConfig$geckox_noasanRelease() {
        return this.settingsConfig;
    }

    public final c getUpdateConfig$geckox_noasanRelease() {
        return this.updateConfig;
    }

    public final String getVersion$geckox_noasanRelease() {
        return this.version;
    }

    public GlobalConfigSettings(String r100, SettingsConfig r101, ResourceMeta r102, ReqMeta r103, c r104) {
        this.version = r100;
        this.settingsConfig = r101;
        this.resourceMeta = r102;
        this.reqMeta = r103;
        this.updateConfig = r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ GlobalConfigSettings(String r100, SettingsConfig r110, ResourceMeta r111, ReqMeta r112, c r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = "0";
    L5:
        DefaultConstructorMarker r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        Object[] r104 = 0;
        if ((r114 & 2) == 0) goto L8;
        r110 = new SettingsConfig(0, 1, r101);
    L8:
        SettingsConfig r116 = r110;
        if ((r114 & 4) == 0) goto L11;
        Object[] r105 = r104 == true ? 1 : 0;
        Object[] r106 = r103 == true ? 1 : 0;
        r111 = new ResourceMeta(r105, r106, 3, r102 == true ? 1 : 0);
    L11:
        ResourceMeta r107 = r111;
        if ((r114 & 8) == 0) goto L14;
        ReqMeta r108 = new ReqMeta(false, 0, null, 7, null);
    L16:
        if ((r114 & 16) == 0) goto L18;
        r113 = new c(null);
    L18:
        String r117 = r100;
        ReqMeta r118 = r108;
        this(r117, r116, r107, r118, r113);
        return;
    L14:
        r108 = r112;
        goto L16
    }
}
