package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00062"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/d;", "", "", "enableOpenAhead", "Z", "getEnableOpenAhead", "()Z", "setEnableOpenAhead", "(Z)V", "disableDiamondCache", "getDisableDiamondCache", "setDisableDiamondCache", "disableFeedCache", "getDisableFeedCache", "setDisableFeedCache", "disableLynxPreload", "getDisableLynxPreload", "setDisableLynxPreload", "enableFeedRenderDelay", "getEnableFeedRenderDelay", "setEnableFeedRenderDelay", "enableFeedRenderTriggerFromEvent", "getEnableFeedRenderTriggerFromEvent", "setEnableFeedRenderTriggerFromEvent", "", "feedRenderDelayTimeOut", "J", "getFeedRenderDelayTimeOut", "()J", "setFeedRenderDelayTimeOut", "(J)V", "", "enableDiamondRenderDelay", "I", "getEnableDiamondRenderDelay", "()I", "setEnableDiamondRenderDelay", "(I)V", "diamondRenderDelayTimeOut", "getDiamondRenderDelayTimeOut", "setDiamondRenderDelayTimeOut", "enablePrefetch", "getEnablePrefetch", "setEnablePrefetch", "removeDelay", "getRemoveDelay", "setRemoveDelay", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("diamond_render_delay_timeout")
    private long diamondRenderDelayTimeOut;

    @SerializedName("disable_diamond_cache")
    private boolean disableDiamondCache;

    @SerializedName("disable_feed_cache")
    private boolean disableFeedCache;

    @SerializedName("disable_lynx_preload")
    private boolean disableLynxPreload;

    @SerializedName("enable_diamond_render_delay")
    private int enableDiamondRenderDelay;

    @SerializedName("enable_feed_render_delay")
    private boolean enableFeedRenderDelay;

    @SerializedName("enable_feed_render_trigger_from_event")
    private boolean enableFeedRenderTriggerFromEvent;

    @SerializedName("enable_open_ahead")
    private boolean enableOpenAhead;

    @SerializedName("enable_prefetch")
    private boolean enablePrefetch;

    @SerializedName("feed_render_delay_timeout")
    private long feedRenderDelayTimeOut;

    @SerializedName("remove_delay")
    private boolean removeDelay;

    public static final class a {
    }

    static {
    }

    public d() {
        this.enableOpenAhead = true;
        this.disableDiamondCache = true;
        this.disableFeedCache = true;
        this.disableLynxPreload = true;
        this.enableFeedRenderDelay = true;
        this.enableFeedRenderTriggerFromEvent = true;
        this.feedRenderDelayTimeOut = 2000;
        this.diamondRenderDelayTimeOut = 2000;
    }
}
