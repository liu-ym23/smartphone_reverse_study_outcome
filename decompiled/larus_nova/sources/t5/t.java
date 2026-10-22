package t5;

import com.bytedance.ai.settings.provider.LynxThreadStrategy;
import com.bytedance.ai.settings.provider.WidgetCacheLimit;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/ai/settings/provider/WidgetSettingsConfig;", "", "preloadCount", "", "chatCacheCount", "globalCachePoolSize", "chatCacheLimit", "", "Lcom/bytedance/ai/settings/provider/WidgetCacheLimit;", "lynxThreadStrategy", "Lcom/bytedance/ai/settings/provider/LynxThreadStrategy;", "<init>", "(IIILjava/util/List;Ljava/util/List;)V", "getPreloadCount", "()I", "getChatCacheCount", "getGlobalCachePoolSize", "getChatCacheLimit", "()Ljava/util/List;", "getLynxThreadStrategy", "getSafePreloadCount", "getSafeChatCacheCount", "getSafeGlobalCachePoolSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName("chat_cache_count")
    private final int chatCacheCount;

    @SerializedName("chat_widget_cache_limit")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetCacheLimit> chatCacheLimit;

    @SerializedName("global_cache_pool_size")
    private final int globalCachePoolSize;

    @SerializedName("lynx_thread_strategy")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<LynxThreadStrategy> lynxThreadStrategy;

    @SerializedName("preload_count")
    private final int preloadCount;

    public static final class a {
    }

    static {
    }

    public t() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.preloadCount == r101.preloadCount) goto L12;
        return false;
    L12:
        if (this.chatCacheCount == r101.chatCacheCount) goto L15;
        return false;
    L15:
        if (this.globalCachePoolSize == r101.globalCachePoolSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatCacheLimit, r101.chatCacheLimit) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxThreadStrategy, r101.lynxThreadStrategy) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.preloadCount * 31) + this.chatCacheCount) * 31) + this.globalCachePoolSize) * 31;
        List<WidgetCacheLimit> r101 = this.chatCacheLimit;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<LynxThreadStrategy> r105 = this.lynxThreadStrategy;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetSettingsConfig(preloadCount=" + this.preloadCount + ", chatCacheCount=" + this.chatCacheCount + ", globalCachePoolSize=" + this.globalCachePoolSize + ", chatCacheLimit=" + this.chatCacheLimit + ", lynxThreadStrategy=" + this.lynxThreadStrategy + ')';
    }

    public final List<WidgetCacheLimit> a() {
        return this.chatCacheLimit;
    }

    public final List<LynxThreadStrategy> b() {
        return this.lynxThreadStrategy;
    }

    public t(Object r210) {
        List<WidgetCacheLimit> r100 = CollectionsKt.listOf(new WidgetCacheLimit[]{new WidgetCacheLimit("route_card", "com.flow.locallife", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_m3", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_sd", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_stream", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_stream_v2", 8), new WidgetCacheLimit("route_card", "com.flow.locallife_douyin", 8), new WidgetCacheLimit("route_plan", "com.obric.map", 8)});
        List<LynxThreadStrategy> r101 = CollectionsKt.listOf(new LynxThreadStrategy(1, 1, CollectionsKt.listOf(new String[]{"com.flow.events@widget__main-place-entrance", "com.flow.events@widget__schedule-list", "com.flow.events@widget__medal-list", "com.flow.events@widget__key-score-against", "com.flow.events@widget__key-athletes-entrance", "com.flow.news@widget__hot-news", "com.flow.news@widget__news_preference_card", "com.flow.locallife@ll_poi_card_widget", "com.flow.locallife@ll_product_card_0624", "com.flow.music.auth@widget__playlist", "com.flow.music.auth@widget__single_music", "com.flow.music.auth@widget__artist_musics", "com.flow.music.auth@widget__album", "com.flow.music.auth@widget__collect_mix", "com.flow.music.auth@widget__collected_music"})));
        this.preloadCount = 0;
        this.chatCacheCount = 0;
        this.globalCachePoolSize = 5;
        this.chatCacheLimit = r100;
        this.lynxThreadStrategy = r101;
    }
}
