package com.ss.android.ugc.aweme.search.dynamic.core.monitor;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\bR\b\u0016\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\b\u0086\u0001\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R*\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b.\u0010/\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0014\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010<\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b<\u0010=\u0012\u0004\bB\u0010/\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\"\u0010F\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010=\u001a\u0004\bG\u0010?\"\u0004\bH\u0010AR\"\u0010I\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010=\u001a\u0004\bJ\u0010?\"\u0004\bK\u0010AR\"\u0010L\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010=\u001a\u0004\bM\u0010?\"\u0004\bN\u0010AR(\u0010O\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bO\u0010=\u0012\u0004\bR\u0010/\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010AR\"\u0010S\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010=\u001a\u0004\bT\u0010?\"\u0004\bU\u0010AR\"\u0010V\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010=\u001a\u0004\bW\u0010?\"\u0004\bX\u0010AR\"\u0010Y\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010=\u001a\u0004\bZ\u0010?\"\u0004\b[\u0010AR\"\u0010\\\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010=\u001a\u0004\b]\u0010?\"\u0004\b^\u0010AR$\u0010_\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010)\u001a\u0004\b`\u0010+\"\u0004\ba\u0010-R$\u0010b\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010)\u001a\u0004\bc\u0010+\"\u0004\bd\u0010-R$\u0010e\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010)\u001a\u0004\bf\u0010+\"\u0004\bg\u0010-R$\u0010h\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010)\u001a\u0004\bi\u0010+\"\u0004\bj\u0010-R$\u0010k\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010)\u001a\u0004\bl\u0010+\"\u0004\bm\u0010-R$\u0010n\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010)\u001a\u0004\bo\u0010+\"\u0004\bp\u0010-R$\u0010q\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010)\u001a\u0004\br\u0010+\"\u0004\bs\u0010-R$\u0010t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0014\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010\u0017R*\u0010w\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bw\u0010)\u0012\u0004\bz\u0010/\u001a\u0004\bx\u0010+\"\u0004\by\u0010-R$\u0010{\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010)\u001a\u0004\b|\u0010+\"\u0004\b}\u0010-R\"\u0010~\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b~\u0010\u0004\u001a\u0004\b~\u0010\u0006\"\u0004\b\u007f\u0010\bR(\u0010\u0080\u0001\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u00107\u001a\u0005\b\u0081\u0001\u00109\"\u0005\b\u0082\u0001\u0010;R(\u0010\u0083\u0001\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u00107\u001a\u0005\b\u0084\u0001\u00109\"\u0005\b\u0085\u0001\u0010;¨\u0006\u0087\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/monitor/DefaultCardPerformanceModel;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/monitor/DefaultCardMonitorModel;", "", "firstLoad", "I", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "isReuse", "setReuse", "isAsyncBind", "setAsyncBind", "drawFromCache", "getDrawFromCache", "setDrawFromCache", "realShowTimes", "getRealShowTimes", "setRealShowTimes", "isHydrated", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setHydrated", "(Ljava/lang/Integer;)V", "fromCache", "getFromCache", "setFromCache", "fromAsync", "getFromAsync", "setFromAsync", "loadTimes", "getLoadTimes", "setLoadTimes", "sizeRawData", "getSizeRawData", "setSizeRawData", "sizeTemplateData", "getSizeTemplateData", "setSizeTemplateData", "", "durationParseRawData", "Ljava/lang/Long;", "getDurationParseRawData", "()Ljava/lang/Long;", "setDurationParseRawData", "(Ljava/lang/Long;)V", "getDurationParseRawData$annotations", "()V", "isHydrateFromGecko", "setHydrateFromGecko", "success", "getSuccess", "setSuccess", "", "errorDesc", "Ljava/lang/String;", "getErrorDesc", "()Ljava/lang/String;", "setErrorDesc", "(Ljava/lang/String;)V", "durationBind", "J", "getDurationBind", "()J", "setDurationBind", "(J)V", "getDurationBind$annotations", "durationCard", "getDurationCard", "setDurationCard", "durationCardMain", "getDurationCardMain", "setDurationCardMain", "durationCardAsync", "getDurationCardAsync", "setDurationCardAsync", "durationBusiness", "getDurationBusiness", "setDurationBusiness", "durationBullet", "getDurationBullet", "setDurationBullet", "getDurationBullet$annotations", "durationContainer", "getDurationContainer", "setDurationContainer", "durationLynx", "getDurationLynx", "setDurationLynx", "durationLynxMain", "getDurationLynxMain", "setDurationLynxMain", "durationLynxAsync", "getDurationLynxAsync", "setDurationLynxAsync", "durationLynxSSRDecodeTemplate", "getDurationLynxSSRDecodeTemplate", "setDurationLynxSSRDecodeTemplate", "durationLynxHydrateDecodeTemplate", "getDurationLynxHydrateDecodeTemplate", "setDurationLynxHydrateDecodeTemplate", "durationLynxSSRRender", "getDurationLynxSSRRender", "setDurationLynxSSRRender", "durationLynxSSRRenderToHydrate", "getDurationLynxSSRRenderToHydrate", "setDurationLynxSSRRenderToHydrate", "durationLynxSSRHydrate", "getDurationLynxSSRHydrate", "setDurationLynxSSRHydrate", "durationOnHydrate", "getDurationOnHydrate", "setDurationOnHydrate", "durationFlush", "getDurationFlush", "setDurationFlush", "threadStrategy", "getThreadStrategy", "setThreadStrategy", "durationFirstScreen", "getDurationFirstScreen", "setDurationFirstScreen", "getDurationFirstScreen$annotations", "durationLynxSSRHydrateOnMainThread", "getDurationLynxSSRHydrateOnMainThread", "setDurationLynxSSRHydrateOnMainThread", "isPreload", "setPreload", "templateResFrom", "getTemplateResFrom", "setTemplateResFrom", "searchId", "getSearchId", "setSearchId", "<init>", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class DefaultCardPerformanceModel extends DefaultCardMonitorModel {

    @SerializedName("draw_from_cache")
    private int drawFromCache;

    @SerializedName("duration_bind")
    private long durationBind;

    @SerializedName("duration_bullet")
    private long durationBullet;

    @SerializedName("duration_business")
    private long durationBusiness;

    @SerializedName("duration_card")
    private long durationCard;

    @SerializedName("duration_card_async")
    private long durationCardAsync;

    @SerializedName("duration_card_main")
    private long durationCardMain;

    @SerializedName("duration_container")
    private long durationContainer;

    @SerializedName("duration_first_screen")
    private Long durationFirstScreen;

    @SerializedName("duration_flush")
    private Long durationFlush;

    @SerializedName("duration_lynx")
    private long durationLynx;

    @SerializedName("duration_lynx_async")
    private long durationLynxAsync;

    @SerializedName("duration_lynx_ssr_hydrate_decode_template")
    private Long durationLynxHydrateDecodeTemplate;

    @SerializedName("duration_lynx_main")
    private long durationLynxMain;

    @SerializedName("duration_lynx_ssr_render_decode_template")
    private Long durationLynxSSRDecodeTemplate;

    @SerializedName("duration_lynx_ssr_hydrate")
    private Long durationLynxSSRHydrate;

    @SerializedName("duration_hydrate_on_mainloop")
    private Long durationLynxSSRHydrateOnMainThread;

    @SerializedName("duration_lynx_ssr_render")
    private Long durationLynxSSRRender;

    @SerializedName("duration_lynx_ssr_render_to_hydrate")
    private Long durationLynxSSRRenderToHydrate;

    @SerializedName("duration_on_hydrate")
    private Long durationOnHydrate;

    @SerializedName("duration_parse_raw_data")
    private Long durationParseRawData;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC)
    private String errorDesc;

    @SerializedName("is_first_load")
    private int firstLoad;

    @SerializedName("from_async")
    private int fromAsync;

    @SerializedName(MobConstants.FORM_CACHE)
    private int fromCache;

    @SerializedName("is_async_bind")
    private int isAsyncBind;

    @SerializedName("is_hydrate_from_gecko")
    private Integer isHydrateFromGecko;

    @SerializedName("is_hydrated")
    private Integer isHydrated;

    @SerializedName("is_preload")
    private int isPreload;

    @SerializedName(BdpAppEventConstant.PARAMS_PKG_IS_REUSE)
    private int isReuse;

    @SerializedName("load_times")
    private int loadTimes;

    @SerializedName("real_show_times")
    private int realShowTimes;

    @SerializedName("search_id")
    private String searchId;

    @SerializedName("size_raw_data")
    private int sizeRawData;

    @SerializedName("size_template_data")
    private Integer sizeTemplateData;

    @SerializedName("is_success")
    private int success;

    @SerializedName("template_source")
    private String templateResFrom;

    @SerializedName("thread_strategy")
    private Integer threadStrategy;

    public DefaultCardPerformanceModel() {
        this.firstLoad = 1;
        this.durationFirstScreen = 0L;
    }
}
