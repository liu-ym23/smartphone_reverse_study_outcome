package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.audio.call.dora.DoraSpecialMode;
import com.larus.audio.call.dora.VisionModeEventType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/api/bean/VisionModeIntention;", "", "<init>", "()V", "doraSpecialMode", "", "getDoraSpecialMode$annotations", "getDoraSpecialMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "visionEventType", "getVisionEventType$annotations", "getVisionEventType", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisionModeIntention {

    @SerializedName("mode")
    private final Integer doraSpecialMode;

    @SerializedName("event_type")
    private final Integer visionEventType;

    public VisionModeIntention() {
    }

    @DoraSpecialMode
    public static /* synthetic */ void getDoraSpecialMode$annotations() {
    }

    @VisionModeEventType
    public static /* synthetic */ void getVisionEventType$annotations() {
    }

    public final Integer getDoraSpecialMode() {
        return this.doraSpecialMode;
    }

    public final Integer getVisionEventType() {
        return this.visionEventType;
    }
}
