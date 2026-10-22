package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = BitablePreloadConfig.APP_CONFIG_KEY)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR:\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010&\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001e\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001e\u0010,\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001e\u0010/\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001e\u00102\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/BitablePreloadConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "baseProductTypePattern", "", "getBaseProductTypePattern", "()Ljava/lang/String;", "setBaseProductTypePattern", "(Ljava/lang/String;)V", "baseRenderKeyToBridgeName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBaseRenderKeyToBridgeName", "()Ljava/util/HashMap;", "setBaseRenderKeyToBridgeName", "(Ljava/util/HashMap;)V", "updateClientVarFrequency", "", "getUpdateClientVarFrequency", "()J", "setUpdateClientVarFrequency", "(J)V", "enableRenderLinkedDocxFirst", "", "getEnableRenderLinkedDocxFirst", "()Z", "setEnableRenderLinkedDocxFirst", "(Z)V", "bitableRecordNumWhenPageLoad", "", "getBitableRecordNumWhenPageLoad", "()I", "setBitableRecordNumWhenPageLoad", "(I)V", "resourceMaxMemoryCacheSize", "getResourceMaxMemoryCacheSize", "setResourceMaxMemoryCacheSize", "resourcePutInCacheLimitLength", "getResourcePutInCacheLimitLength", "setResourcePutInCacheLimitLength", "blockDataMaxCacheCount", "getBlockDataMaxCacheCount", "setBlockDataMaxCacheCount", "firstBlockMaxCacheCount", "getFirstBlockMaxCacheCount", "setFirstBlockMaxCacheCount", "preloadDataMaxCacheCount", "getPreloadDataMaxCacheCount", "setPreloadDataMaxCacheCount", "bitableMaxRevGap", "getBitableMaxRevGap", "setBitableMaxRevGap", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitablePreloadConfig implements NonProguard {
    public static final String APP_CONFIG_KEY = "bitable_offline_cache_config";
    public static final a Companion = null;

    @SerializedName("base_product_type_pattern")
    private String baseProductTypePattern;

    @SerializedName("base_key_to_bridge")
    private HashMap<String, String> baseRenderKeyToBridgeName;

    @SerializedName("bitable_max_rev_gap")
    private int bitableMaxRevGap;

    @SerializedName("bitable_record_num_when_page_load")
    private int bitableRecordNumWhenPageLoad;

    @SerializedName("block_cache_limit_count")
    private int blockDataMaxCacheCount;

    @SerializedName("enable_render_linked_docx_first")
    private boolean enableRenderLinkedDocxFirst;

    @SerializedName("fristblock_cache_limit_count")
    private int firstBlockMaxCacheCount;

    @SerializedName("preload_cache_limit_count")
    private int preloadDataMaxCacheCount;

    @SerializedName("resource_max_memory_cache_size")
    private int resourceMaxMemoryCacheSize;

    @SerializedName("resource_cache_limit_length")
    private int resourcePutInCacheLimitLength;

    @SerializedName("update_clientvar_frequency")
    private long updateClientVarFrequency;

    public static final class a {
        @JvmStatic
        public static BitablePreloadConfig a() {
            return (BitablePreloadConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(BitablePreloadConfig.APP_CONFIG_KEY, BitablePreloadConfig.class, new BitablePreloadConfig());
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final BitablePreloadConfig get() {
        Companion.getClass();
        return a.a();
    }

    public BitablePreloadConfig() {
        this.baseProductTypePattern = "/(bitable|base)/";
        this.baseRenderKeyToBridgeName = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("header", "biz.bitable.setHeaderContainer"), TuplesKt.to("viewList", "biz.bitable.setViewContainer"), TuplesKt.to(NewBroadcastMonitor.STAGE.TOOLBAR, "biz.bitable.setToolbarContainer"), TuplesKt.to("viewData", "biz.bitable.setNativeViewData"), TuplesKt.to("sceneData", "biz.bitable.updateScene")});
        this.updateClientVarFrequency = 300000;
        this.bitableRecordNumWhenPageLoad = 500;
        this.resourceMaxMemoryCacheSize = 5242880;
        this.resourcePutInCacheLimitLength = 2097152;
        this.blockDataMaxCacheCount = 20;
        this.firstBlockMaxCacheCount = 20;
        this.preloadDataMaxCacheCount = 100;
        this.bitableMaxRevGap = 200;
    }

    public final String getBaseProductTypePattern() {
        return this.baseProductTypePattern;
    }

    public final HashMap<String, String> getBaseRenderKeyToBridgeName() {
        return this.baseRenderKeyToBridgeName;
    }

    public final int getBitableMaxRevGap() {
        return this.bitableMaxRevGap;
    }

    public final int getBitableRecordNumWhenPageLoad() {
        return this.bitableRecordNumWhenPageLoad;
    }

    public final int getBlockDataMaxCacheCount() {
        return this.blockDataMaxCacheCount;
    }

    public final boolean getEnableRenderLinkedDocxFirst() {
        return this.enableRenderLinkedDocxFirst;
    }

    public final int getFirstBlockMaxCacheCount() {
        return this.firstBlockMaxCacheCount;
    }

    public final int getPreloadDataMaxCacheCount() {
        return this.preloadDataMaxCacheCount;
    }

    public final int getResourceMaxMemoryCacheSize() {
        return this.resourceMaxMemoryCacheSize;
    }

    public final int getResourcePutInCacheLimitLength() {
        return this.resourcePutInCacheLimitLength;
    }

    public final long getUpdateClientVarFrequency() {
        return this.updateClientVarFrequency;
    }

    public final void setBaseProductTypePattern(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseProductTypePattern = r100;
    }

    public final void setBaseRenderKeyToBridgeName(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseRenderKeyToBridgeName = r100;
    }

    public final void setBitableMaxRevGap(int r100) {
        this.bitableMaxRevGap = r100;
    }

    public final void setBitableRecordNumWhenPageLoad(int r100) {
        this.bitableRecordNumWhenPageLoad = r100;
    }

    public final void setBlockDataMaxCacheCount(int r100) {
        this.blockDataMaxCacheCount = r100;
    }

    public final void setEnableRenderLinkedDocxFirst(boolean r100) {
        this.enableRenderLinkedDocxFirst = r100;
    }

    public final void setFirstBlockMaxCacheCount(int r100) {
        this.firstBlockMaxCacheCount = r100;
    }

    public final void setPreloadDataMaxCacheCount(int r100) {
        this.preloadDataMaxCacheCount = r100;
    }

    public final void setResourceMaxMemoryCacheSize(int r100) {
        this.resourceMaxMemoryCacheSize = r100;
    }

    public final void setResourcePutInCacheLimitLength(int r100) {
        this.resourcePutInCacheLimitLength = r100;
    }

    public final void setUpdateClientVarFrequency(long r100) {
        this.updateClientVarFrequency = r100;
    }
}
