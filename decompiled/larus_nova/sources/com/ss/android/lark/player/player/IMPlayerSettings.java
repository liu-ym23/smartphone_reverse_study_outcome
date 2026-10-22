package com.ss.android.lark.player.player;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
public final class IMPlayerSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f438650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f438651b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Lcom/ss/android/lark/player/player/IMPlayerSettings$VideoLarkConfig;", "", "badAVDiff", "", "badAVWaitTime", "useCacheFromBiz", "preloadEnable", "preloadSize", "preloadFooterSize", "preloadDelay", "cellularPreloadEnable", "clickPreloadEnable", "cancelPreloadDelayEnable", "reuseSurfaceView", "<init>", "(IIIIIIIIIII)V", "getBadAVDiff", "()I", "setBadAVDiff", "(I)V", "getBadAVWaitTime", "setBadAVWaitTime", "getUseCacheFromBiz", "setUseCacheFromBiz", "getPreloadEnable", "setPreloadEnable", "getPreloadSize", "setPreloadSize", "getPreloadFooterSize", "setPreloadFooterSize", "getPreloadDelay", "setPreloadDelay", "getCellularPreloadEnable", "setCellularPreloadEnable", "getClickPreloadEnable", "setClickPreloadEnable", "getCancelPreloadDelayEnable", "setCancelPreloadDelayEnable", "getReuseSurfaceView", "setReuseSurfaceView", "videoview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoLarkConfig {

        @SerializedName("BAD_AV_DIFF")
        private int badAVDiff;

        @SerializedName("BAD_AV_WAIT_TIME")
        private int badAVWaitTime;

        @SerializedName("cancel_preload_delay_enable")
        private int cancelPreloadDelayEnable;

        @SerializedName("cellular_preload_enable")
        private int cellularPreloadEnable;

        @SerializedName("click_preload_enable")
        private int clickPreloadEnable;

        @SerializedName("preload_delay")
        private int preloadDelay;

        @SerializedName("preload_enable")
        private int preloadEnable;

        @SerializedName("preload_footer_size")
        private int preloadFooterSize;

        @SerializedName("preload_size")
        private int preloadSize;

        @SerializedName("reuse_surface_view_on_same_video")
        private int reuseSurfaceView;

        @SerializedName("USE_CACHE_FROM_BIZ")
        private int useCacheFromBiz;

        public VideoLarkConfig() {
            this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null);
        }

        public final int getBadAVDiff() {
            return this.badAVDiff;
        }

        public final int getBadAVWaitTime() {
            return this.badAVWaitTime;
        }

        public final int getCancelPreloadDelayEnable() {
            return this.cancelPreloadDelayEnable;
        }

        public final int getCellularPreloadEnable() {
            return this.cellularPreloadEnable;
        }

        public final int getClickPreloadEnable() {
            return this.clickPreloadEnable;
        }

        public final int getPreloadDelay() {
            return this.preloadDelay;
        }

        public final int getPreloadEnable() {
            return this.preloadEnable;
        }

        public final int getPreloadFooterSize() {
            return this.preloadFooterSize;
        }

        public final int getPreloadSize() {
            return this.preloadSize;
        }

        public final int getReuseSurfaceView() {
            return this.reuseSurfaceView;
        }

        public final int getUseCacheFromBiz() {
            return this.useCacheFromBiz;
        }

        public final void setBadAVDiff(int r100) {
            this.badAVDiff = r100;
        }

        public final void setBadAVWaitTime(int r100) {
            this.badAVWaitTime = r100;
        }

        public final void setCancelPreloadDelayEnable(int r100) {
            this.cancelPreloadDelayEnable = r100;
        }

        public final void setCellularPreloadEnable(int r100) {
            this.cellularPreloadEnable = r100;
        }

        public final void setClickPreloadEnable(int r100) {
            this.clickPreloadEnable = r100;
        }

        public final void setPreloadDelay(int r100) {
            this.preloadDelay = r100;
        }

        public final void setPreloadEnable(int r100) {
            this.preloadEnable = r100;
        }

        public final void setPreloadFooterSize(int r100) {
            this.preloadFooterSize = r100;
        }

        public final void setPreloadSize(int r100) {
            this.preloadSize = r100;
        }

        public final void setReuseSurfaceView(int r100) {
            this.reuseSurfaceView = r100;
        }

        public final void setUseCacheFromBiz(int r100) {
            this.useCacheFromBiz = r100;
        }

        public VideoLarkConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111) {
            this.badAVDiff = r100;
            this.badAVWaitTime = r101;
            this.useCacheFromBiz = r102;
            this.preloadEnable = r103;
            this.preloadSize = r104;
            this.preloadFooterSize = r105;
            this.preloadDelay = r106;
            this.cellularPreloadEnable = r107;
            this.clickPreloadEnable = r108;
            this.cancelPreloadDelayEnable = r110;
            this.reuseSurfaceView = r111;
        }

        public /* synthetic */ VideoLarkConfig(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, int r211, int r212, int r213, int r214, DefaultConstructorMarker r215) {
            if ((r214 & 1) == 0) goto L5;
            int r100 = 350000;
        L7:
            if ((r214 & 2) == 0) goto L9;
            int r101 = 5000;
        L10:
            int r102 = 1;
            if ((r214 & 4) == 0) goto L13;
            int r103 = 1;
        L15:
            if ((r214 & 8) == 0) goto L17;
            int r104 = 1;
        L19:
            if ((r214 & 16) == 0) goto L21;
            int r105 = 819200;
        L23:
            if ((r214 & 32) == 0) goto L25;
            int r106 = 307200;
        L27:
            if ((r214 & 64) == 0) goto L29;
            int r107 = 500;
        L31:
            if ((r214 & 128) == 0) goto L33;
            int r108 = 1;
        L35:
            if ((r214 & 256) == 0) goto L37;
            int r117 = 1;
        L39:
            if ((r214 & 512) == 0) goto L41;
            int r118 = 1;
        L43:
            if ((r214 & 1024) != 0) goto L46;
            r102 = r213;
        L46:
            this(r100, r101, r103, r104, r105, r106, r107, r108, r117, r118, r102);
            return;
        L41:
            r118 = r212;
            goto L43
        L37:
            r117 = r211;
            goto L39
        L33:
            r108 = r210;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L10
        L5:
            r100 = r110;
            goto L7
        }
    }

    @AppConfig(key = "im_video_player_config")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/player/player/IMPlayerSettings$VideoPlayerConfig;", "", "<init>", "()V", "videoview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoPlayerConfig {
        public VideoPlayerConfig() {
        }
    }

    static {
        f438650a = LazyKt.lazy(IMPlayerSettings$remoteSetting$2.INSTANCE);
        f438651b = LazyKt.lazy(IMPlayerSettings$larkConfig$2.INSTANCE);
    }

    public static final VideoLarkConfig a() {
        return (VideoLarkConfig) f438651b.getValue();
    }
}
