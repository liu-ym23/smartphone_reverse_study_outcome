package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/ObricThresholdItemConfig;", "", "enableHprof", "", "enableAlog", "pssLimit", "", "recentAlogMs", "", "<init>", "(ZZFJ)V", "getEnableHprof", "()Z", "getEnableAlog", "getPssLimit", "()F", "getRecentAlogMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricThresholdItemConfig {

    @SerializedName("enable_alog")
    private final boolean enableAlog;

    @SerializedName("enable_hprof")
    private final boolean enableHprof;

    @SerializedName("pss_limit")
    private final float pssLimit;

    @SerializedName("recent_alog_ms")
    private final long recentAlogMs;

    public ObricThresholdItemConfig() {
        this(false, false, 0.0f, 0, 15, null);
    }

    public static /* synthetic */ ObricThresholdItemConfig copy$default(ObricThresholdItemConfig r100, boolean r101, boolean r102, float r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enableHprof;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.enableAlog;
    L8:
        boolean r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.pssLimit;
    L11:
        float r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.recentAlogMs;
    L14:
        boolean r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final boolean component1() {
        return this.enableHprof;
    }

    public final boolean component2() {
        return this.enableAlog;
    }

    public final float component3() {
        return this.pssLimit;
    }

    public final long component4() {
        return this.recentAlogMs;
    }

    public final ObricThresholdItemConfig copy(boolean r100, boolean r101, float r110, long r111) {
        return new ObricThresholdItemConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricThresholdItemConfig) == true) goto L8;
        return false;
    L8:
        ObricThresholdItemConfig r101 = (ObricThresholdItemConfig) r100;
        if (this.enableHprof == r101.enableHprof) goto L12;
        return false;
    L12:
        if (this.enableAlog == r101.enableAlog) goto L15;
        return false;
    L15:
        if (Float.compare(this.pssLimit, r101.pssLimit) == 0) goto L18;
        return false;
    L18:
        if (this.recentAlogMs == r101.recentAlogMs) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableHprof == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableAlog == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + Float.floatToIntBits(this.pssLimit)) * 31;
        long r104 = this.recentAlogMs;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricThresholdItemConfig(enableHprof=" + this.enableHprof + ", enableAlog=" + this.enableAlog + ", pssLimit=" + this.pssLimit + ", recentAlogMs=" + this.recentAlogMs + ')';
    }

    public final boolean getEnableAlog() {
        return this.enableAlog;
    }

    public final boolean getEnableHprof() {
        return this.enableHprof;
    }

    public final float getPssLimit() {
        return this.pssLimit;
    }

    public final long getRecentAlogMs() {
        return this.recentAlogMs;
    }

    public ObricThresholdItemConfig(boolean r100, boolean r101, float r102, long r103) {
        this.enableHprof = r100;
        this.enableAlog = r101;
        this.pssLimit = r102;
        this.recentAlogMs = r103;
    }

    public /* synthetic */ ObricThresholdItemConfig(boolean r100, boolean r101, float r102, long r103, int r104, DefaultConstructorMarker r105) {
        boolean r106 = false;
        if ((r104 & 1) == 0) goto L5;
        boolean r107 = false;
    L7:
        if ((r104 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r104 & 4) == 0) goto L13;
        float r108 = 1258291.2f;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 120000;
    L17:
        long r109 = r103;
        this(r107, r106, r108, r109);
        return;
    L13:
        r108 = r102;
        goto L15
    L5:
        r107 = r100;
        goto L7
    }
}
