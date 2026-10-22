package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_minutes_record_upload_config")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadRetryConfigSetting;", "Ljava/io/Serializable;", "linearRetryConfig", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;", "exponentialRetryConfig", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;)V", "getLinearRetryConfig", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;", "setLinearRetryConfig", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUploadTaskRetryConfig;)V", "getExponentialRetryConfig", "setExponentialRetryConfig", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmUploadRetryConfigSetting implements Serializable {
    public static final a Companion = null;
    public static final long MAX_INTERVAL_MS = 30000;
    public static final long MAX_RANDOM_MS = 2000;

    @SerializedName("exponential")
    private MmUploadTaskRetryConfig exponentialRetryConfig;

    @SerializedName("linear")
    private MmUploadTaskRetryConfig linearRetryConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmUploadRetryConfigSetting() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ MmUploadRetryConfigSetting copy$default(MmUploadRetryConfigSetting r100, MmUploadTaskRetryConfig r101, MmUploadTaskRetryConfig r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.linearRetryConfig;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exponentialRetryConfig;
    L9:
        return r100.copy(r101, r102);
    }

    public final MmUploadTaskRetryConfig component1() {
        return this.linearRetryConfig;
    }

    public final MmUploadTaskRetryConfig component2() {
        return this.exponentialRetryConfig;
    }

    public final MmUploadRetryConfigSetting copy(MmUploadTaskRetryConfig r100, MmUploadTaskRetryConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "linearRetryConfig");
        Intrinsics.checkNotNullParameter(r101, "exponentialRetryConfig");
        return new MmUploadRetryConfigSetting(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmUploadRetryConfigSetting) == true) goto L8;
        return false;
    L8:
        MmUploadRetryConfigSetting r101 = (MmUploadRetryConfigSetting) r100;
        if (Intrinsics.areEqual(this.linearRetryConfig, r101.linearRetryConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exponentialRetryConfig, r101.exponentialRetryConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.linearRetryConfig.hashCode() * 31) + this.exponentialRetryConfig.hashCode();
    }

    public String toString() {
        return "MmUploadRetryConfigSetting(linearRetryConfig=" + this.linearRetryConfig + ", exponentialRetryConfig=" + this.exponentialRetryConfig + ')';
    }

    public final MmUploadTaskRetryConfig getExponentialRetryConfig() {
        return this.exponentialRetryConfig;
    }

    public final MmUploadTaskRetryConfig getLinearRetryConfig() {
        return this.linearRetryConfig;
    }

    public final void setExponentialRetryConfig(MmUploadTaskRetryConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exponentialRetryConfig = r100;
    }

    public final void setLinearRetryConfig(MmUploadTaskRetryConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linearRetryConfig = r100;
    }

    public MmUploadRetryConfigSetting(MmUploadTaskRetryConfig r100, MmUploadTaskRetryConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "linearRetryConfig");
        Intrinsics.checkNotNullParameter(r101, "exponentialRetryConfig");
        this.linearRetryConfig = r100;
        this.exponentialRetryConfig = r101;
    }

    public MmUploadRetryConfigSetting(MmUploadTaskRetryConfig r100, MmUploadTaskRetryConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        MmUploadTaskRetryConfig.Companion.getClass();
        r100 = new MmUploadTaskRetryConfig();
        r100.setInterval(5);
        MmUploadTaskRetryConfig.access$setMaxCount$p(r100, -1);
    L6:
        if ((r102 & 2) == 0) goto L8;
        MmUploadTaskRetryConfig.Companion.getClass();
        r101 = new MmUploadTaskRetryConfig();
        r101.setInterval(-1);
        MmUploadTaskRetryConfig.access$setMaxCount$p(r101, 3);
    L8:
        this(r100, r101);
    }
}
