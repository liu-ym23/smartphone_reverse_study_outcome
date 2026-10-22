package com.ss.android.lark.widget.photo.preview.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
public final class LargeImageSettingsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f447132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f447133b = null;

    @AppConfig(key = "large_image_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/utils/LargeImageSettingsUtil$LargeImageSettings;", "", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeImageSettings {
        public LargeImageSettings() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/utils/LargeImageSettingsUtil$QRCodeSettings;", "", "enableOnDemand", "", "delayTime", "", "<init>", "(ZJ)V", "getEnableOnDemand", "()Z", "setEnableOnDemand", "(Z)V", "getDelayTime", "()J", "setDelayTime", "(J)V", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QRCodeSettings {

        @SerializedName("delay_time")
        private long delayTime;

        @SerializedName("enable_decode_on_demand")
        private boolean enableOnDemand;

        public QRCodeSettings() {
            this(false, 0, 3, null);
        }

        public final long getDelayTime() {
            return this.delayTime;
        }

        public final boolean getEnableOnDemand() {
            return this.enableOnDemand;
        }

        public final void setDelayTime(long r100) {
            this.delayTime = r100;
        }

        public final void setEnableOnDemand(boolean r100) {
            this.enableOnDemand = r100;
        }

        public QRCodeSettings(boolean r100, long r101) {
            this.enableOnDemand = r100;
            this.delayTime = r101;
        }

        public /* synthetic */ QRCodeSettings(boolean r100, long r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = true;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 500;
        L8:
            this(r100, r101);
        }
    }

    static {
        f447132a = LazyKt.lazy(LargeImageSettingsUtil$remoteSetting$2.INSTANCE);
        f447133b = LazyKt.lazy(LargeImageSettingsUtil$qrSettings$2.INSTANCE);
    }
}
