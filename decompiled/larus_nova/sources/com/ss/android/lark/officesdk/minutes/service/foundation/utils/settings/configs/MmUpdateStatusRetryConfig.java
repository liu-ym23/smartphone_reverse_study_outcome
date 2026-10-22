package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_minutes_update_status_retry_config")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmUpdateStatusRetryConfig;", "Ljava/io/Serializable;", "intervalInSecs", "", "maxRetryCount", "<init>", "(II)V", "getIntervalInSecs", "()I", "getMaxRetryCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmUpdateStatusRetryConfig implements Serializable {
    public static final a Companion = null;
    public static final long MAX_RANDOM_MS = 2000;

    @SerializedName("intervalInSecs")
    private final int intervalInSecs;

    @SerializedName("maxRetryCount")
    private final int maxRetryCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmUpdateStatusRetryConfig() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public MmUpdateStatusRetryConfig(int r100) {
        int r101 = 0;
        this(r100, r101, 2, null);
    }

    public static /* synthetic */ MmUpdateStatusRetryConfig copy$default(MmUpdateStatusRetryConfig r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.intervalInSecs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.maxRetryCount;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.intervalInSecs;
    }

    public final int component2() {
        return this.maxRetryCount;
    }

    public final MmUpdateStatusRetryConfig copy(int r100, int r101) {
        return new MmUpdateStatusRetryConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmUpdateStatusRetryConfig) == true) goto L8;
        return false;
    L8:
        MmUpdateStatusRetryConfig r101 = (MmUpdateStatusRetryConfig) r100;
        if (this.intervalInSecs == r101.intervalInSecs) goto L12;
        return false;
    L12:
        if (this.maxRetryCount == r101.maxRetryCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.intervalInSecs * 31) + this.maxRetryCount;
    }

    public String toString() {
        return "MmUpdateStatusRetryConfig(intervalInSecs=" + this.intervalInSecs + ", maxRetryCount=" + this.maxRetryCount + ')';
    }

    public final int getIntervalInSecs() {
        return this.intervalInSecs;
    }

    public final int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public MmUpdateStatusRetryConfig(int r100, int r101) {
        this.intervalInSecs = r100;
        this.maxRetryCount = r101;
    }

    public /* synthetic */ MmUpdateStatusRetryConfig(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 5;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 10;
    L8:
        this(r100, r101);
    }
}
