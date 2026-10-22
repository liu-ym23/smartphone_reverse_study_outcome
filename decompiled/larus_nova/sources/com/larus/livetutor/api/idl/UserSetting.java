package com.larus.livetutor.api.idl;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/livetutor/api/idl/UserSetting;", "Ljava/io/Serializable;", "ttsSpeed", "", "ttsPitch", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getTtsSpeed", "()Ljava/lang/Double;", "setTtsSpeed", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getTtsPitch", "setTtsPitch", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/larus/livetutor/api/idl/UserSetting;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSetting implements Serializable {

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_TTS_PITCH_INT)
    private Double ttsPitch;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_TTS_SPEED_INT)
    private Double ttsSpeed;

    /* JADX WARN: Multi-variable type inference failed */
    public UserSetting() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UserSetting copy$default(UserSetting r100, Double r101, Double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.ttsSpeed;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.ttsPitch;
    L9:
        return r100.copy(r101, r102);
    }

    public final Double component1() {
        return this.ttsSpeed;
    }

    public final Double component2() {
        return this.ttsPitch;
    }

    public final UserSetting copy(Double r100, Double r101) {
        return new UserSetting(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserSetting) == true) goto L8;
        return false;
    L8:
        UserSetting r101 = (UserSetting) r100;
        if (Intrinsics.areEqual(this.ttsSpeed, r101.ttsSpeed) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ttsPitch, r101.ttsPitch) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Double r100 = this.ttsSpeed;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.ttsPitch;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserSetting(ttsSpeed=" + this.ttsSpeed + ", ttsPitch=" + this.ttsPitch + ')';
    }

    public final Double getTtsPitch() {
        return this.ttsPitch;
    }

    public final Double getTtsSpeed() {
        return this.ttsSpeed;
    }

    public final void setTtsPitch(Double r100) {
        this.ttsPitch = r100;
    }

    public final void setTtsSpeed(Double r100) {
        this.ttsSpeed = r100;
    }

    public UserSetting(Double r100, Double r101) {
        this.ttsSpeed = r100;
        this.ttsPitch = r101;
    }

    public /* synthetic */ UserSetting(Double r100, Double r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
