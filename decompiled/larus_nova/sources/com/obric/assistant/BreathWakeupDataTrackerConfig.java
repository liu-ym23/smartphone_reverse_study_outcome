package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/BreathWakeupDataTrackerConfig;", "", "enable", "", SocialConstants.PARAM_APP_DESC, "", "time", "maxCacheSize", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V", "getEnable", "()Z", "getDesc", "()Ljava/lang/String;", "getTime", "getMaxCacheSize", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BreathWakeupDataTrackerConfig {

    @SerializedName("breath-tracker-desc")
    private final String desc;

    @SerializedName("breath-tracker-enable")
    private final boolean enable;

    @SerializedName("max-cache-size")
    private final int maxCacheSize;

    @SerializedName("breath-tracker-time")
    private final String time;

    public BreathWakeupDataTrackerConfig() {
        this(false, null, null, 0, 15, null);
    }

    public static /* synthetic */ BreathWakeupDataTrackerConfig copy$default(BreathWakeupDataTrackerConfig r100, boolean r101, String r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.desc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.time;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxCacheSize;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.time;
    }

    public final int component4() {
        return this.maxCacheSize;
    }

    public final BreathWakeupDataTrackerConfig copy(boolean r100, String r101, String r102, int r103) {
        return new BreathWakeupDataTrackerConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BreathWakeupDataTrackerConfig) == true) goto L8;
        return false;
    L8:
        BreathWakeupDataTrackerConfig r101 = (BreathWakeupDataTrackerConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L18;
        return false;
    L18:
        if (this.maxCacheSize == r101.maxCacheSize) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.desc;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.time;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return ((r105 + r103) * 31) + this.maxCacheSize;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "BreathWakeupDataTrackerConfig(enable=" + this.enable + ", desc=" + this.desc + ", time=" + this.time + ", maxCacheSize=" + this.maxCacheSize + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public final String getTime() {
        return this.time;
    }

    public BreathWakeupDataTrackerConfig(boolean r100, String r101, String r102, int r103) {
        this.enable = r100;
        this.desc = r101;
        this.time = r102;
        this.maxCacheSize = r103;
    }

    public /* synthetic */ BreathWakeupDataTrackerConfig(boolean r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 10;
    L14:
        this(r100, r101, r102, r103);
    }
}
