package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001a\u0010<\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017¨\u0006H"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/SlidesPhotosConfig;", "", "()V", "adapterSkinMode", "", "getAdapterSkinMode", "()Z", "setAdapterSkinMode", "(Z)V", "autoPlayEnabled", "getAutoPlayEnabled", "setAutoPlayEnabled", "dragEnabled", "getDragEnabled", "setDragEnabled", "enableProgressBarSwitch", "getEnableProgressBarSwitch", "setEnableProgressBarSwitch", "height", "", "getHeight", "()I", "setHeight", "(I)V", "hostPlaceHolderUrl", "", "getHostPlaceHolderUrl", "()Ljava/lang/String;", "setHostPlaceHolderUrl", "(Ljava/lang/String;)V", "initPlayPosition", "getInitPlayPosition", "setInitPlayPosition", "optVisibilityAggregated", "getOptVisibilityAggregated", "()Ljava/lang/Boolean;", "setOptVisibilityAggregated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "outDragEnabled", "getOutDragEnabled", "setOutDragEnabled", "photoPlayDuration", "", "getPhotoPlayDuration", "()J", "setPhotoPlayDuration", "(J)V", "progressInterval", "getProgressInterval", "setProgressInterval", "scaleType", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/ScaleType;", "getScaleType", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/ScaleType;", "setScaleType", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/ScaleType;)V", "scrollAnimationDuration", "getScrollAnimationDuration", "setScrollAnimationDuration", "showProgressBar", "getShowProgressBar", "setShowProgressBar", "stopByDrag", "getStopByDrag", "setStopByDrag", "width", "getWidth", "setWidth", "reset", "", "singlePhotoConfig", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlidesPhotosConfig {
    private boolean adapterSkinMode;
    private boolean autoPlayEnabled;
    private boolean dragEnabled;
    private boolean enableProgressBarSwitch;
    private int height;
    private String hostPlaceHolderUrl;
    private int initPlayPosition;
    private Boolean optVisibilityAggregated;
    private boolean outDragEnabled;
    private long photoPlayDuration;
    private long progressInterval;
    private ScaleType scaleType;
    private long scrollAnimationDuration;
    private boolean showProgressBar;
    private boolean stopByDrag;
    private int width;

    public final void reset() {
        this.height = 0;
        this.width = 0;
        this.autoPlayEnabled = true;
        this.dragEnabled = true;
        this.outDragEnabled = true;
        this.photoPlayDuration = 1800;
        this.scrollAnimationDuration = 700;
        this.showProgressBar = true;
        this.scaleType = ScaleType.AUTO_MODE;
        this.initPlayPosition = 0;
        this.enableProgressBarSwitch = true;
        this.progressInterval = 300;
        this.stopByDrag = true;
        this.adapterSkinMode = false;
        this.hostPlaceHolderUrl = null;
    }

    public final void singlePhotoConfig() {
        this.autoPlayEnabled = false;
        this.dragEnabled = false;
        this.outDragEnabled = true;
        this.showProgressBar = false;
        this.enableProgressBarSwitch = false;
    }

    public SlidesPhotosConfig() {
        this.autoPlayEnabled = true;
        this.dragEnabled = true;
        this.outDragEnabled = true;
        this.photoPlayDuration = 1800;
        this.scrollAnimationDuration = 700;
        this.showProgressBar = true;
        this.scaleType = ScaleType.AUTO_MODE;
        this.enableProgressBarSwitch = true;
        this.progressInterval = 300;
        this.stopByDrag = true;
        this.optVisibilityAggregated = Boolean.FALSE;
    }

    public final boolean getAdapterSkinMode() {
        return this.adapterSkinMode;
    }

    public final boolean getAutoPlayEnabled() {
        return this.autoPlayEnabled;
    }

    public final boolean getDragEnabled() {
        return this.dragEnabled;
    }

    public final boolean getEnableProgressBarSwitch() {
        return this.enableProgressBarSwitch;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getHostPlaceHolderUrl() {
        return this.hostPlaceHolderUrl;
    }

    public final int getInitPlayPosition() {
        return this.initPlayPosition;
    }

    public final Boolean getOptVisibilityAggregated() {
        return this.optVisibilityAggregated;
    }

    public final boolean getOutDragEnabled() {
        return this.outDragEnabled;
    }

    public final long getPhotoPlayDuration() {
        return this.photoPlayDuration;
    }

    public final long getProgressInterval() {
        return this.progressInterval;
    }

    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public final long getScrollAnimationDuration() {
        return this.scrollAnimationDuration;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    public final boolean getStopByDrag() {
        return this.stopByDrag;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setAdapterSkinMode(boolean r1) {
        this.adapterSkinMode = r1;
    }

    public final void setAutoPlayEnabled(boolean r1) {
        this.autoPlayEnabled = r1;
    }

    public final void setDragEnabled(boolean r1) {
        this.dragEnabled = r1;
    }

    public final void setEnableProgressBarSwitch(boolean r1) {
        this.enableProgressBarSwitch = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setHostPlaceHolderUrl(String r1) {
        this.hostPlaceHolderUrl = r1;
    }

    public final void setInitPlayPosition(int r1) {
        this.initPlayPosition = r1;
    }

    public final void setOptVisibilityAggregated(Boolean r1) {
        this.optVisibilityAggregated = r1;
    }

    public final void setOutDragEnabled(boolean r1) {
        this.outDragEnabled = r1;
    }

    public final void setPhotoPlayDuration(long r1) {
        this.photoPlayDuration = r1;
    }

    public final void setProgressInterval(long r1) {
        this.progressInterval = r1;
    }

    public final void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaleType = r2;
    }

    public final void setScrollAnimationDuration(long r1) {
        this.scrollAnimationDuration = r1;
    }

    public final void setShowProgressBar(boolean r1) {
        this.showProgressBar = r1;
    }

    public final void setStopByDrag(boolean r1) {
        this.stopByDrag = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
