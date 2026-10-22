package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/ObricThresholdPssUploadFilesConfig;", "", "enableMemInfo", "", "checkIntervalMs", "", "processConfigs", "", "", "Lcom/obric/assistant/ObricThresholdItemConfig;", "<init>", "(ZJLjava/util/Map;)V", "getEnableMemInfo", "()Z", "getCheckIntervalMs", "()J", "getProcessConfigs", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricThresholdPssUploadFilesConfig {

    @SerializedName("check_interval_ms")
    private final long checkIntervalMs;

    @SerializedName("enable_meminfo")
    private final boolean enableMemInfo;

    @SerializedName("process_configs")
    private final Map<String, ObricThresholdItemConfig> processConfigs;

    public ObricThresholdPssUploadFilesConfig() {
        this(false, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricThresholdPssUploadFilesConfig copy$default(ObricThresholdPssUploadFilesConfig r100, boolean r101, long r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enableMemInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.checkIntervalMs;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.processConfigs;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enableMemInfo;
    }

    public final long component2() {
        return this.checkIntervalMs;
    }

    public final Map<String, ObricThresholdItemConfig> component3() {
        return this.processConfigs;
    }

    public final ObricThresholdPssUploadFilesConfig copy(boolean r100, long r101, Map<String, ObricThresholdItemConfig> r102) {
        return new ObricThresholdPssUploadFilesConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricThresholdPssUploadFilesConfig) == true) goto L8;
        return false;
    L8:
        ObricThresholdPssUploadFilesConfig r101 = (ObricThresholdPssUploadFilesConfig) r100;
        if (this.enableMemInfo == r101.enableMemInfo) goto L12;
        return false;
    L12:
        if (this.checkIntervalMs == r101.checkIntervalMs) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.processConfigs, r101.processConfigs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enableMemInfo == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.checkIntervalMs;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Map<String, ObricThresholdItemConfig> r103 = this.processConfigs;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricThresholdPssUploadFilesConfig(enableMemInfo=" + this.enableMemInfo + ", checkIntervalMs=" + this.checkIntervalMs + ", processConfigs=" + this.processConfigs + ')';
    }

    public final long getCheckIntervalMs() {
        return this.checkIntervalMs;
    }

    public final boolean getEnableMemInfo() {
        return this.enableMemInfo;
    }

    public final Map<String, ObricThresholdItemConfig> getProcessConfigs() {
        return this.processConfigs;
    }

    public ObricThresholdPssUploadFilesConfig(boolean r100, long r101, Map<String, ObricThresholdItemConfig> r102) {
        this.enableMemInfo = r100;
        this.checkIntervalMs = r101;
        this.processConfigs = r102;
    }

    public /* synthetic */ ObricThresholdPssUploadFilesConfig(boolean r100, long r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 5000;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new HashMap();
    L11:
        this(r100, r101, r102);
    }
}
