package com.bytedance.locallife.groupon.fence;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b&\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006?"}, d2 = {"Lcom/bytedance/locallife/groupon/fence/NearbyDualAbParam;", "", "()V", "cellGapConf", "", "getCellGapConf", "()Ljava/lang/String;", "setCellGapConf", "(Ljava/lang/String;)V", "coverLoadNumToPlay", "", "getCoverLoadNumToPlay", "()I", "setCoverLoadNumToPlay", "(I)V", "coverUpdate", "getCoverUpdate", "setCoverUpdate", "disableVideoAutoPlay", "getDisableVideoAutoPlay", "setDisableVideoAutoPlay", "dualCardStyle", "getDualCardStyle", "setDualCardStyle", "dualDislikeSwitch", "", "getDualDislikeSwitch", "()Z", "setDualDislikeSwitch", "(Z)V", "feedCache", "getFeedCache", "setFeedCache", "feedCacheConf", "getFeedCacheConf", "setFeedCacheConf", "feedInnerCache", "getFeedInnerCache", "setFeedInnerCache", "feedInnerCacheConf", "getFeedInnerCacheConf", "setFeedInnerCacheConf", "feedPreload", "getFeedPreload", "setFeedPreload", "feedPreloadConf", "getFeedPreloadConf", "setFeedPreloadConf", "nearbyFeedDualSwitch", "getNearbyFeedDualSwitch", "setNearbyFeedDualSwitch", "refreshPlayConf", "getRefreshPlayConf", "setRefreshPlayConf", "remoteStrategyDual", "getRemoteStrategyDual", "setRemoteStrategyDual", "searchGapConf", "getSearchGapConf", "setSearchGapConf", "tabIconStyle", "getTabIconStyle", "setTabIconStyle", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyDualAbParam {

    @SerializedName("cell_gap_conf")
    private String cellGapConf;

    @SerializedName("cover_load_num_to_play")
    private int coverLoadNumToPlay;

    @SerializedName("cover_update")
    private int coverUpdate;

    @SerializedName("disable_video_auto_play")
    private int disableVideoAutoPlay;

    @SerializedName("dual_card_style")
    private int dualCardStyle;

    @SerializedName("nearby_dual_dislike_switch")
    private boolean dualDislikeSwitch;

    @SerializedName("feed_cache")
    private int feedCache;

    @SerializedName("feed_cache_conf")
    private String feedCacheConf;

    @SerializedName("feed_inner_cache")
    private int feedInnerCache;

    @SerializedName("feed_inner_cache_conf")
    private String feedInnerCacheConf;

    @SerializedName("feed_preload")
    private int feedPreload;

    @SerializedName("feed_preload_conf")
    private String feedPreloadConf;

    @SerializedName("nearby_feed_dual_switch")
    private int nearbyFeedDualSwitch;

    @SerializedName("refresh_play_conf")
    private String refreshPlayConf;

    @SerializedName("remote_strategy_dual")
    private boolean remoteStrategyDual;

    @SerializedName("search_gap_conf")
    private String searchGapConf;

    @SerializedName("tab_icon_style")
    private int tabIconStyle;

    public NearbyDualAbParam() {
        this.feedPreloadConf = "";
        this.feedInnerCacheConf = "";
        this.feedCacheConf = "";
        this.refreshPlayConf = "";
        this.cellGapConf = "";
        this.searchGapConf = "";
    }

    public final String getCellGapConf() {
        return this.cellGapConf;
    }

    public final int getCoverLoadNumToPlay() {
        return this.coverLoadNumToPlay;
    }

    public final int getCoverUpdate() {
        return this.coverUpdate;
    }

    public final int getDisableVideoAutoPlay() {
        return this.disableVideoAutoPlay;
    }

    public final int getDualCardStyle() {
        return this.dualCardStyle;
    }

    public final boolean getDualDislikeSwitch() {
        return this.dualDislikeSwitch;
    }

    public final int getFeedCache() {
        return this.feedCache;
    }

    public final String getFeedCacheConf() {
        return this.feedCacheConf;
    }

    public final int getFeedInnerCache() {
        return this.feedInnerCache;
    }

    public final String getFeedInnerCacheConf() {
        return this.feedInnerCacheConf;
    }

    public final int getFeedPreload() {
        return this.feedPreload;
    }

    public final String getFeedPreloadConf() {
        return this.feedPreloadConf;
    }

    public final int getNearbyFeedDualSwitch() {
        return this.nearbyFeedDualSwitch;
    }

    public final String getRefreshPlayConf() {
        return this.refreshPlayConf;
    }

    public final boolean getRemoteStrategyDual() {
        return this.remoteStrategyDual;
    }

    public final String getSearchGapConf() {
        return this.searchGapConf;
    }

    public final int getTabIconStyle() {
        return this.tabIconStyle;
    }

    public final void setCellGapConf(String r100) {
        this.cellGapConf = r100;
    }

    public final void setCoverLoadNumToPlay(int r100) {
        this.coverLoadNumToPlay = r100;
    }

    public final void setCoverUpdate(int r100) {
        this.coverUpdate = r100;
    }

    public final void setDisableVideoAutoPlay(int r100) {
        this.disableVideoAutoPlay = r100;
    }

    public final void setDualCardStyle(int r100) {
        this.dualCardStyle = r100;
    }

    public final void setDualDislikeSwitch(boolean r100) {
        this.dualDislikeSwitch = r100;
    }

    public final void setFeedCache(int r100) {
        this.feedCache = r100;
    }

    public final void setFeedCacheConf(String r100) {
        this.feedCacheConf = r100;
    }

    public final void setFeedInnerCache(int r100) {
        this.feedInnerCache = r100;
    }

    public final void setFeedInnerCacheConf(String r100) {
        this.feedInnerCacheConf = r100;
    }

    public final void setFeedPreload(int r100) {
        this.feedPreload = r100;
    }

    public final void setFeedPreloadConf(String r100) {
        this.feedPreloadConf = r100;
    }

    public final void setNearbyFeedDualSwitch(int r100) {
        this.nearbyFeedDualSwitch = r100;
    }

    public final void setRefreshPlayConf(String r100) {
        this.refreshPlayConf = r100;
    }

    public final void setRemoteStrategyDual(boolean r100) {
        this.remoteStrategyDual = r100;
    }

    public final void setSearchGapConf(String r100) {
        this.searchGapConf = r100;
    }

    public final void setTabIconStyle(int r100) {
        this.tabIconStyle = r100;
    }
}
