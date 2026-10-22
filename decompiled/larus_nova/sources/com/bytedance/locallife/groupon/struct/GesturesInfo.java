package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GesturesInfo;", "", "frequency_day", "", "frequency_times", "show_seconds", "type", "(IILjava/lang/Integer;I)V", "getFrequency_day", "()I", "getFrequency_times", "getShow_seconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;I)Lcom/bytedance/locallife/groupon/struct/GesturesInfo;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GesturesInfo {

    @SerializedName("frequency_day")
    private final int frequency_day;

    @SerializedName("frequency_times")
    private final int frequency_times;

    @SerializedName("show_seconds")
    private final Integer show_seconds;

    @SerializedName("scene_type")
    private final int type;

    public static /* synthetic */ GesturesInfo copy$default(GesturesInfo r100, int r101, int r102, Integer r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.frequency_day;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.frequency_times;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.show_seconds;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.type;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.frequency_day;
    }

    public final int component2() {
        return this.frequency_times;
    }

    public final Integer component3() {
        return this.show_seconds;
    }

    public final int component4() {
        return this.type;
    }

    public final GesturesInfo copy(int r100, int r101, Integer r102, int r103) {
        return new GesturesInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GesturesInfo) == true) goto L8;
        return false;
    L8:
        GesturesInfo r101 = (GesturesInfo) r100;
        if (this.frequency_day == r101.frequency_day) goto L12;
        return false;
    L12:
        if (this.frequency_times == r101.frequency_times) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.show_seconds, r101.show_seconds) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.frequency_day * 31) + this.frequency_times) * 31;
        Integer r101 = this.show_seconds;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.type;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "GesturesInfo(frequency_day=" + this.frequency_day + ", frequency_times=" + this.frequency_times + ", show_seconds=" + this.show_seconds + ", type=" + this.type + ')';
    }

    public final int getFrequency_day() {
        return this.frequency_day;
    }

    public final int getFrequency_times() {
        return this.frequency_times;
    }

    public final Integer getShow_seconds() {
        return this.show_seconds;
    }

    public final int getType() {
        return this.type;
    }

    public GesturesInfo(int r100, int r101, Integer r102, int r103) {
        this.frequency_day = r100;
        this.frequency_times = r101;
        this.show_seconds = r102;
        this.type = r103;
    }

    public /* synthetic */ GesturesInfo(int r100, int r101, Integer r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 0;
    L11:
        this(r100, r101, r102, r103);
    }
}
