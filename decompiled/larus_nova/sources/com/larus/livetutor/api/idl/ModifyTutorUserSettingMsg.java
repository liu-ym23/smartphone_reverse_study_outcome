package com.larus.livetutor.api.idl;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;", "Ljava/io/Serializable;", "ttsSpeed", "", "pauseLocation", "Lcom/larus/livetutor/api/idl/PauseLocation;", "memoryStatus", "", "ttsPitch", "<init>", "(Ljava/lang/Double;Lcom/larus/livetutor/api/idl/PauseLocation;Ljava/lang/Integer;Ljava/lang/Double;)V", "getTtsSpeed", "()Ljava/lang/Double;", "setTtsSpeed", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPauseLocation", "()Lcom/larus/livetutor/api/idl/PauseLocation;", "setPauseLocation", "(Lcom/larus/livetutor/api/idl/PauseLocation;)V", "getMemoryStatus", "()Ljava/lang/Integer;", "setMemoryStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTtsPitch", "setTtsPitch", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Lcom/larus/livetutor/api/idl/PauseLocation;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;", "equals", "", "other", "", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifyTutorUserSettingMsg implements Serializable {

    @SerializedName("memory_status")
    private Integer memoryStatus;

    @SerializedName("pause_location")
    private PauseLocation pauseLocation;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_TTS_PITCH_INT)
    private Double ttsPitch;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_TTS_SPEED_INT)
    private Double ttsSpeed;

    public ModifyTutorUserSettingMsg() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ModifyTutorUserSettingMsg copy$default(ModifyTutorUserSettingMsg r100, Double r101, PauseLocation r102, Integer r103, Double r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.ttsSpeed;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.pauseLocation;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.memoryStatus;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ttsPitch;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Double component1() {
        return this.ttsSpeed;
    }

    public final PauseLocation component2() {
        return this.pauseLocation;
    }

    public final Integer component3() {
        return this.memoryStatus;
    }

    public final Double component4() {
        return this.ttsPitch;
    }

    public final ModifyTutorUserSettingMsg copy(Double r100, PauseLocation r101, Integer r102, Double r103) {
        return new ModifyTutorUserSettingMsg(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModifyTutorUserSettingMsg) == true) goto L8;
        return false;
    L8:
        ModifyTutorUserSettingMsg r101 = (ModifyTutorUserSettingMsg) r100;
        if (Intrinsics.areEqual(this.ttsSpeed, r101.ttsSpeed) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pauseLocation, r101.pauseLocation) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memoryStatus, r101.memoryStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ttsPitch, r101.ttsPitch) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Double r100 = this.ttsSpeed;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PauseLocation r104 = this.pauseLocation;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.memoryStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.ttsPitch;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ModifyTutorUserSettingMsg(ttsSpeed=" + this.ttsSpeed + ", pauseLocation=" + this.pauseLocation + ", memoryStatus=" + this.memoryStatus + ", ttsPitch=" + this.ttsPitch + ')';
    }

    public final Integer getMemoryStatus() {
        return this.memoryStatus;
    }

    public final PauseLocation getPauseLocation() {
        return this.pauseLocation;
    }

    public final Double getTtsPitch() {
        return this.ttsPitch;
    }

    public final Double getTtsSpeed() {
        return this.ttsSpeed;
    }

    public final void setMemoryStatus(Integer r100) {
        this.memoryStatus = r100;
    }

    public final void setPauseLocation(PauseLocation r100) {
        this.pauseLocation = r100;
    }

    public final void setTtsPitch(Double r100) {
        this.ttsPitch = r100;
    }

    public final void setTtsSpeed(Double r100) {
        this.ttsSpeed = r100;
    }

    public ModifyTutorUserSettingMsg(Double r100, PauseLocation r101, Integer r102, Double r103) {
        this.ttsSpeed = r100;
        this.pauseLocation = r101;
        this.memoryStatus = r102;
        this.ttsPitch = r103;
    }

    public /* synthetic */ ModifyTutorUserSettingMsg(Double r100, PauseLocation r101, Integer r102, Double r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
