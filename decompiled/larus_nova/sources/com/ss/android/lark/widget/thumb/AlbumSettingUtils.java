package com.ss.android.lark.widget.thumb;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AlbumSettingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f448944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f448945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f448946c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f448947d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f448948e = null;

    @AppConfig(key = "album_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$AlbumSetting;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AlbumSetting {
        public AlbumSetting() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$Enable;", "", "total", "", "serialLoadEnable", "uriLoadEnable", "badCaseDiskCacheEnable", "customSourceExecutorEnable", "firstOpenImproveEnable", "<init>", "(IIIIII)V", "getTotal", "()I", "setTotal", "(I)V", "getSerialLoadEnable", "setSerialLoadEnable", "getUriLoadEnable", "setUriLoadEnable", "getBadCaseDiskCacheEnable", "setBadCaseDiskCacheEnable", "getCustomSourceExecutorEnable", "setCustomSourceExecutorEnable", "getFirstOpenImproveEnable", "setFirstOpenImproveEnable", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Enable {

        @SerializedName("bad_case_disk_cache_enable")
        private int badCaseDiskCacheEnable;

        @SerializedName("custom_source_executor_enable")
        private int customSourceExecutorEnable;

        @SerializedName("first_open_improve_enable")
        private int firstOpenImproveEnable;

        @SerializedName("serial_load_enable")
        private int serialLoadEnable;

        @SerializedName("total")
        private int total;

        @SerializedName("uri_load_enable")
        private int uriLoadEnable;

        public Enable() {
            this(0, 0, 0, 0, 0, 0, 63, null);
        }

        public final int getBadCaseDiskCacheEnable() {
            return this.badCaseDiskCacheEnable;
        }

        public final int getCustomSourceExecutorEnable() {
            return this.customSourceExecutorEnable;
        }

        public final int getFirstOpenImproveEnable() {
            return this.firstOpenImproveEnable;
        }

        public final int getSerialLoadEnable() {
            return this.serialLoadEnable;
        }

        public final int getTotal() {
            return this.total;
        }

        public final int getUriLoadEnable() {
            return this.uriLoadEnable;
        }

        public final void setBadCaseDiskCacheEnable(int r100) {
            this.badCaseDiskCacheEnable = r100;
        }

        public final void setCustomSourceExecutorEnable(int r100) {
            this.customSourceExecutorEnable = r100;
        }

        public final void setFirstOpenImproveEnable(int r100) {
            this.firstOpenImproveEnable = r100;
        }

        public final void setSerialLoadEnable(int r100) {
            this.serialLoadEnable = r100;
        }

        public final void setTotal(int r100) {
            this.total = r100;
        }

        public final void setUriLoadEnable(int r100) {
            this.uriLoadEnable = r100;
        }

        public Enable(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.total = r100;
            this.serialLoadEnable = r101;
            this.uriLoadEnable = r102;
            this.badCaseDiskCacheEnable = r103;
            this.customSourceExecutorEnable = r104;
            this.firstOpenImproveEnable = r105;
        }

        public /* synthetic */ Enable(int r100, int r101, int r102, int r103, int r110, int r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            int r114 = 1;
        L7:
            if ((r112 & 2) == 0) goto L9;
            int r104 = 1;
        L11:
            if ((r112 & 4) == 0) goto L13;
            int r105 = 1;
        L15:
            if ((r112 & 8) == 0) goto L17;
            int r106 = 1;
        L19:
            if ((r112 & 16) == 0) goto L21;
            int r107 = 1;
        L23:
            if ((r112 & 32) == 0) goto L25;
            int r115 = 1;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$LevelItem;", "", "deviceScore", "", "", "conLoadThreads", "rejectLoadLimit", "resolutionRatio", "<init>", "(Ljava/util/List;III)V", "getDeviceScore", "()Ljava/util/List;", "setDeviceScore", "(Ljava/util/List;)V", "getConLoadThreads", "()I", "setConLoadThreads", "(I)V", "getRejectLoadLimit", "setRejectLoadLimit", "getResolutionRatio", "setResolutionRatio", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LevelItem {

        @SerializedName("con_load_threads")
        private int conLoadThreads;

        @SerializedName("device_score")
        private List<Integer> deviceScore;

        @SerializedName("reject_load_limit")
        private int rejectLoadLimit;

        @SerializedName("resolution_ratio")
        private int resolutionRatio;

        public LevelItem() {
            this(null, 0, 0, 0, 15, null);
        }

        public final int getConLoadThreads() {
            return this.conLoadThreads;
        }

        public final List<Integer> getDeviceScore() {
            return this.deviceScore;
        }

        public final int getRejectLoadLimit() {
            return this.rejectLoadLimit;
        }

        public final int getResolutionRatio() {
            return this.resolutionRatio;
        }

        public final void setConLoadThreads(int r100) {
            this.conLoadThreads = r100;
        }

        public final void setDeviceScore(List<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.deviceScore = r100;
        }

        public final void setRejectLoadLimit(int r100) {
            this.rejectLoadLimit = r100;
        }

        public final void setResolutionRatio(int r100) {
            this.resolutionRatio = r100;
        }

        public LevelItem(List<Integer> r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "deviceScore");
            this.deviceScore = r100;
            this.conLoadThreads = r101;
            this.rejectLoadLimit = r102;
            this.resolutionRatio = r103;
        }

        public /* synthetic */ LevelItem(List r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = CollectionsKt.mutableListOf(new Integer[]{1, 2});
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 2;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 100;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 6;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$PerfImproveConfig;", "", "enable", "Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$Enable;", "largeImageLimit", "", "deviceLevel", "", "Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$LevelItem;", "<init>", "(Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$Enable;ILjava/util/List;)V", "getEnable", "()Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$Enable;", "setEnable", "(Lcom/ss/android/lark/widget/thumb/AlbumSettingUtils$Enable;)V", "getLargeImageLimit", "()I", "setLargeImageLimit", "(I)V", "getDeviceLevel", "()Ljava/util/List;", "setDeviceLevel", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PerfImproveConfig {

        @SerializedName(IPerformanceStrategyManager.KEY_INT_DEVICE_LEVEL)
        private List<LevelItem> deviceLevel;

        @SerializedName("enable")
        private Enable enable;

        @SerializedName("large_image_limit")
        private int largeImageLimit;

        public PerfImproveConfig() {
            this(null, 0, null, 7, null);
        }

        public final List<LevelItem> getDeviceLevel() {
            return this.deviceLevel;
        }

        public final Enable getEnable() {
            return this.enable;
        }

        public final int getLargeImageLimit() {
            return this.largeImageLimit;
        }

        public final void setDeviceLevel(List<LevelItem> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.deviceLevel = r100;
        }

        public final void setEnable(Enable r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.enable = r100;
        }

        public final void setLargeImageLimit(int r100) {
            this.largeImageLimit = r100;
        }

        public PerfImproveConfig(Enable r100, int r101, List<LevelItem> r102) {
            Intrinsics.checkNotNullParameter(r100, "enable");
            Intrinsics.checkNotNullParameter(r102, "deviceLevel");
            this.enable = r100;
            this.largeImageLimit = r101;
            this.deviceLevel = r102;
        }

        public /* synthetic */ PerfImproveConfig(Enable r110, int r111, List r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 1) == 0) goto L6;
            r110 = new Enable(0, 0, 0, 0, 0, 0, 63, null);
        L6:
            if ((r113 & 2) == 0) goto L9;
            r111 = 10;
        L9:
            if ((r113 & 4) == 0) goto L11;
            r112 = CollectionsKt.mutableListOf(new LevelItem[]{new LevelItem(CollectionsKt.mutableListOf(new Integer[]{0}), 4, 200, 4), new LevelItem(CollectionsKt.mutableListOf(new Integer[]{1, 2}), 2, 100, 6), new LevelItem(CollectionsKt.mutableListOf(new Integer[]{3}), 1, 50, 8)});
        L11:
            this(r110, r111, r112);
        }
    }

    public AlbumSettingUtils() {
    }

    static {
        f448944a = LazyKt.lazy(AlbumSettingUtils$albumRemoteSetting$2.INSTANCE);
        f448945b = LazyKt.lazy(AlbumSettingUtils$perfImproveConfig$2.INSTANCE);
        f448946c = LazyKt.lazy(AlbumSettingUtils$enable$2.INSTANCE);
        f448947d = LazyKt.lazy(AlbumSettingUtils$largeImageLimit$2.INSTANCE);
        f448948e = LazyKt.lazy(AlbumSettingUtils$deviceLevel$2.INSTANCE);
    }

    public static final Enable a() {
        return (Enable) f448946c.getValue();
    }
}
