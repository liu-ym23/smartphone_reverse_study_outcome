package com.ss.android.lark.image.impl.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;", "", "scene", "", "preloadEnable", "", "maxCount", "<init>", "(Ljava/lang/String;II)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getPreloadEnable", "()I", "setPreloadEnable", "(I)V", "getMaxCount", "setMaxCount", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreloadStrategy {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int DEFAULT_PRELOAD_MAX_COUNT = 20;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private int maxCount;

    @SerializedName("preload_enable")
    private int preloadEnable;

    @SerializedName("scene")
    private String scene;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/PreloadStrategy$Companion;", "", "<init>", "()V", "DEFAULT_PRELOAD_MAX_COUNT", "", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public PreloadStrategy() {
        this(null, 0, 0, 7, null);
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getPreloadEnable() {
        return this.preloadEnable;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setMaxCount(int r100) {
        this.maxCount = r100;
    }

    public final void setPreloadEnable(int r100) {
        this.preloadEnable = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public PreloadStrategy(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.scene = r100;
        this.preloadEnable = r101;
        this.maxCount = r102;
    }

    public /* synthetic */ PreloadStrategy(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "default";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 20;
    L11:
        this(r100, r101, r102);
    }
}
