package com.bytedance.locallife.poi.media.photo;

import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/SlidesPhotosViewConfig;", "", "()V", "autoPlayEnabled", "", "getAutoPlayEnabled", "()Z", "setAutoPlayEnabled", "(Z)V", "dragEnabled", "getDragEnabled", "setDragEnabled", "enableLoop", "getEnableLoop", "setEnableLoop", "orientation", "", "getOrientation", "()I", "setOrientation", "(I)V", "photoPlayDuration", "", "getPhotoPlayDuration", "()J", "setPhotoPlayDuration", "(J)V", "progressInterval", "getProgressInterval", "setProgressInterval", "scrollAnimationDuration", "getScrollAnimationDuration", "setScrollAnimationDuration", "showProgressBar", "getShowProgressBar", "setShowProgressBar", "stopByDrag", "getStopByDrag", "setStopByDrag", "Builder", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SlidesPhotosViewConfig {
    private boolean autoPlayEnabled;
    private boolean dragEnabled;
    private boolean enableLoop;
    private int orientation;
    private long photoPlayDuration;
    private long progressInterval;
    private long scrollAnimationDuration;
    private boolean showProgressBar;
    private boolean stopByDrag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/SlidesPhotosViewConfig$Builder;", "", "()V", "config", "Lcom/bytedance/locallife/poi/media/photo/SlidesPhotosViewConfig;", "build", "enableAutoPlay", "autoPlay", "", "enableDrag", "enable", "enableLoop", "orientation", "", "photoPlayDuration", "duration", "", "progressInterval", VideoThumbInfo.KEY_INTERVAL, "scrollAnimDuration", "showProgressBar", "stopByDrag", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Builder {
        private final SlidesPhotosViewConfig config;

        public Builder() {
            this.config = new SlidesPhotosViewConfig();
        }

        public final SlidesPhotosViewConfig build() {
            return this.config;
        }

        public final Builder enableAutoPlay(boolean r100) {
            this.config.setAutoPlayEnabled(r100);
            return this;
        }

        public final Builder enableDrag(boolean r100) {
            this.config.setDragEnabled(r100);
            return this;
        }

        public final Builder enableLoop(boolean r100) {
            this.config.setEnableLoop(r100);
            return this;
        }

        public final Builder orientation(int r100) {
            this.config.setOrientation(r100);
            return this;
        }

        public final Builder photoPlayDuration(long r100) {
            this.config.setPhotoPlayDuration(r100);
            return this;
        }

        public final Builder progressInterval(long r100) {
            this.config.setProgressInterval(r100);
            return this;
        }

        public final Builder scrollAnimDuration(long r100) {
            this.config.setScrollAnimationDuration(r100);
            return this;
        }

        public final Builder showProgressBar(boolean r100) {
            this.config.setShowProgressBar(r100);
            return this;
        }

        public final Builder stopByDrag(boolean r100) {
            this.config.setStopByDrag(r100);
            return this;
        }
    }

    public SlidesPhotosViewConfig() {
        this.autoPlayEnabled = true;
        this.showProgressBar = true;
        this.photoPlayDuration = 2300;
        this.scrollAnimationDuration = 700;
        this.progressInterval = 300;
        this.stopByDrag = true;
    }

    public final boolean getAutoPlayEnabled() {
        return this.autoPlayEnabled;
    }

    public final boolean getDragEnabled() {
        return this.dragEnabled;
    }

    public final boolean getEnableLoop() {
        return this.enableLoop;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final long getPhotoPlayDuration() {
        return this.photoPlayDuration;
    }

    public final long getProgressInterval() {
        return this.progressInterval;
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

    public final void setAutoPlayEnabled(boolean r100) {
        this.autoPlayEnabled = r100;
    }

    public final void setDragEnabled(boolean r100) {
        this.dragEnabled = r100;
    }

    public final void setEnableLoop(boolean r100) {
        this.enableLoop = r100;
    }

    public final void setOrientation(int r100) {
        this.orientation = r100;
    }

    public final void setPhotoPlayDuration(long r100) {
        this.photoPlayDuration = r100;
    }

    public final void setProgressInterval(long r100) {
        this.progressInterval = r100;
    }

    public final void setScrollAnimationDuration(long r100) {
        this.scrollAnimationDuration = r100;
    }

    public final void setShowProgressBar(boolean r100) {
        this.showProgressBar = r100;
    }

    public final void setStopByDrag(boolean r100) {
        this.stopByDrag = r100;
    }
}
