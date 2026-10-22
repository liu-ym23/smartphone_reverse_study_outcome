package com.larus.uaigc.lynx;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012¨\u0006+"}, d2 = {"Lcom/larus/uaigc/lynx/Segment;", "", "id", "", "minMs", "", "maxMs", "presenceRate", "", "priority", "weight", "validDuration", "times", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getMinMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxMs", "getPresenceRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPriority", "getWeight", "getValidDuration", "getTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/uaigc/lynx/Segment;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Segment {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f373504id;

    @SerializedName("maxMs")
    private final Integer maxMs;

    @SerializedName("minMs")
    private final Integer minMs;

    @SerializedName("presenceRate")
    private final Double presenceRate;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("times")
    private final Integer times;

    @SerializedName("validDuration")
    private final Integer validDuration;

    @SerializedName("weight")
    private final Double weight;

    public Segment() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ Segment copy$default(Segment r100, String r110, Integer r111, Integer r112, Double r113, Integer r114, Double r115, Integer r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.f373504id;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = r100.minMs;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = r100.maxMs;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Double r104 = r100.presenceRate;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.priority;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Double r106 = r100.weight;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = r100.validDuration;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.times;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
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
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.f373504id;
    }

    public final Integer component2() {
        return this.minMs;
    }

    public final Integer component3() {
        return this.maxMs;
    }

    public final Double component4() {
        return this.presenceRate;
    }

    public final Integer component5() {
        return this.priority;
    }

    public final Double component6() {
        return this.weight;
    }

    public final Integer component7() {
        return this.validDuration;
    }

    public final Integer component8() {
        return this.times;
    }

    public final Segment copy(String r110, Integer r111, Integer r112, Double r113, Integer r114, Double r115, Integer r116, Integer r117) {
        return new Segment(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Segment) == true) goto L8;
        return false;
    L8:
        Segment r101 = (Segment) r100;
        if (Intrinsics.areEqual(this.f373504id, r101.f373504id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minMs, r101.minMs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxMs, r101.maxMs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.presenceRate, r101.presenceRate) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.weight, r101.weight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.validDuration, r101.validDuration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.times, r101.times) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.f373504id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.minMs;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.maxMs;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.presenceRate;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.priority;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.weight;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.validDuration;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.times;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Segment(id=" + this.f373504id + ", minMs=" + this.minMs + ", maxMs=" + this.maxMs + ", presenceRate=" + this.presenceRate + ", priority=" + this.priority + ", weight=" + this.weight + ", validDuration=" + this.validDuration + ", times=" + this.times + ')';
    }

    public final String getId() {
        return this.f373504id;
    }

    public final Integer getMaxMs() {
        return this.maxMs;
    }

    public final Integer getMinMs() {
        return this.minMs;
    }

    public final Double getPresenceRate() {
        return this.presenceRate;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getTimes() {
        return this.times;
    }

    public final Integer getValidDuration() {
        return this.validDuration;
    }

    public final Double getWeight() {
        return this.weight;
    }

    public Segment(String r100, Integer r101, Integer r102, Double r103, Integer r104, Double r105, Integer r106, Integer r107) {
        this.f373504id = r100;
        this.minMs = r101;
        this.maxMs = r102;
        this.presenceRate = r103;
        this.priority = r104;
        this.weight = r105;
        this.validDuration = r106;
        this.times = r107;
    }

    public /* synthetic */ Segment(String r110, Integer r111, Integer r112, Double r113, Integer r114, Double r115, Integer r116, Integer r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r101 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r102 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Double r103 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r104 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Double r105 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r106 = 0;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r107 = 1;
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
