package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016¨\u0006+"}, d2 = {"Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;", "Ljava/io/Serializable;", "firstWaitTimeMs", "", "secondWaitTimeMs", MmEndWindowAvatar.TYPE_SPEAKER, "", TextureRenderKeys.KEY_IS_PITCH, "", "text", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getFirstWaitTimeMs", "()Ljava/lang/Integer;", "setFirstWaitTimeMs", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSecondWaitTimeMs", "setSecondWaitTimeMs", "getSpeaker", "()Ljava/lang/String;", "setSpeaker", "(Ljava/lang/String;)V", "getPitch", "()Ljava/lang/Double;", "setPitch", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeoutStrategyV2 implements Serializable {

    @SerializedName("first_wait_time_ms")
    private Integer firstWaitTimeMs;

    @SerializedName(TextureRenderKeys.KEY_IS_PITCH)
    private Double pitch;

    @SerializedName("second_wait_time_ms")
    private Integer secondWaitTimeMs;

    @SerializedName(MmEndWindowAvatar.TYPE_SPEAKER)
    private String speaker;

    @SerializedName("text")
    private String text;

    public TimeoutStrategyV2() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TimeoutStrategyV2 copy$default(TimeoutStrategyV2 r100, Integer r101, Integer r102, String r103, Double r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.firstWaitTimeMs;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.secondWaitTimeMs;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.speaker;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.pitch;
    L14:
        Double r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.text;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.firstWaitTimeMs;
    }

    public final Integer component2() {
        return this.secondWaitTimeMs;
    }

    public final String component3() {
        return this.speaker;
    }

    public final Double component4() {
        return this.pitch;
    }

    public final String component5() {
        return this.text;
    }

    public final TimeoutStrategyV2 copy(Integer r100, Integer r101, String r110, Double r111, String r112) {
        return new TimeoutStrategyV2(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeoutStrategyV2) == true) goto L8;
        return false;
    L8:
        TimeoutStrategyV2 r101 = (TimeoutStrategyV2) r100;
        if (Intrinsics.areEqual(this.firstWaitTimeMs, r101.firstWaitTimeMs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondWaitTimeMs, r101.secondWaitTimeMs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.speaker, r101.speaker) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pitch, r101.pitch) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.firstWaitTimeMs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.secondWaitTimeMs;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.speaker;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.pitch;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.text;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "TimeoutStrategyV2(firstWaitTimeMs=" + this.firstWaitTimeMs + ", secondWaitTimeMs=" + this.secondWaitTimeMs + ", speaker=" + this.speaker + ", pitch=" + this.pitch + ", text=" + this.text + ')';
    }

    public final Integer getFirstWaitTimeMs() {
        return this.firstWaitTimeMs;
    }

    public final Double getPitch() {
        return this.pitch;
    }

    public final Integer getSecondWaitTimeMs() {
        return this.secondWaitTimeMs;
    }

    public final String getSpeaker() {
        return this.speaker;
    }

    public final String getText() {
        return this.text;
    }

    public final void setFirstWaitTimeMs(Integer r100) {
        this.firstWaitTimeMs = r100;
    }

    public final void setPitch(Double r100) {
        this.pitch = r100;
    }

    public final void setSecondWaitTimeMs(Integer r100) {
        this.secondWaitTimeMs = r100;
    }

    public final void setSpeaker(String r100) {
        this.speaker = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public TimeoutStrategyV2(Integer r100, Integer r101, String r102, Double r103, String r104) {
        this.firstWaitTimeMs = r100;
        this.secondWaitTimeMs = r101;
        this.speaker = r102;
        this.pitch = r103;
        this.text = r104;
    }

    public /* synthetic */ TimeoutStrategyV2(Integer r100, Integer r101, String r102, Double r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Double r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
