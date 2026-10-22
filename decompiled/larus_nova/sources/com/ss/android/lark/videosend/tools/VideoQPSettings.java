package com.ss.android.lark.videosend.tools;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoQPSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f444978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444979b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f444980c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f444981d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoQPSettings$VideoQPConfig;", "", "qpRangeParam", "", "chipBrand", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQpRangeParam", "()Ljava/lang/String;", "setQpRangeParam", "(Ljava/lang/String;)V", "getChipBrand", "setChipBrand", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoQPConfig {

        @SerializedName("chip_brand")
        private String chipBrand;

        @SerializedName("qp_range_param")
        private String qpRangeParam;

        /* JADX WARN: Multi-variable type inference failed */
        public VideoQPConfig() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final String getChipBrand() {
            return this.chipBrand;
        }

        public final String getQpRangeParam() {
            return this.qpRangeParam;
        }

        public final void setChipBrand(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.chipBrand = r100;
        }

        public final void setQpRangeParam(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.qpRangeParam = r100;
        }

        public VideoQPConfig(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "qpRangeParam");
            Intrinsics.checkNotNullParameter(r101, "chipBrand");
            this.qpRangeParam = r100;
            this.chipBrand = r101;
        }

        public /* synthetic */ VideoQPConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    @AppConfig(key = "android_video_qp_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoQPSettings$VideoQPSetting;", "", "<init>", "()V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoQPSetting {
        public VideoQPSetting() {
        }
    }

    static {
        f444978a = Build.MODEL.toLowerCase(Locale.ROOT);
        f444979b = LazyKt.lazy(VideoQPSettings$remoteSetting$2.INSTANCE);
        f444980c = LazyKt.lazy(VideoQPSettings$qpConfig$2.INSTANCE);
        f444981d = LazyKt.lazy(VideoQPSettings$isUseDynamicQP$2.INSTANCE);
    }
}
