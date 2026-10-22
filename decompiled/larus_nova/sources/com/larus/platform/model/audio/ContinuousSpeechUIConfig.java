package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/audio/ContinuousSpeechUIConfig;", "Ljava/io/Serializable;", "showSpeechOnLeft", "", "triggerSpeechDelayTime", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getShowSpeechOnLeft", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTriggerSpeechDelayTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/larus/platform/model/audio/ContinuousSpeechUIConfig;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContinuousSpeechUIConfig implements Serializable {
    public static final a Companion = null;
    private static final ContinuousSpeechUIConfig DEFAULT = null;

    @SerializedName("continuous_speak_button_left")
    private final Boolean showSpeechOnLeft;

    @SerializedName("click_continuous_speak_duration")
    private final Long triggerSpeechDelayTime;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuousSpeechUIConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContinuousSpeechUIConfig copy$default(ContinuousSpeechUIConfig r100, Boolean r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.showSpeechOnLeft;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.triggerSpeechDelayTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.showSpeechOnLeft;
    }

    public final Long component2() {
        return this.triggerSpeechDelayTime;
    }

    public final ContinuousSpeechUIConfig copy(Boolean r100, Long r101) {
        return new ContinuousSpeechUIConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContinuousSpeechUIConfig) == true) goto L8;
        return false;
    L8:
        ContinuousSpeechUIConfig r101 = (ContinuousSpeechUIConfig) r100;
        if (Intrinsics.areEqual(this.showSpeechOnLeft, r101.showSpeechOnLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.triggerSpeechDelayTime, r101.triggerSpeechDelayTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.showSpeechOnLeft;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.triggerSpeechDelayTime;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ContinuousSpeechUIConfig(showSpeechOnLeft=" + this.showSpeechOnLeft + ", triggerSpeechDelayTime=" + this.triggerSpeechDelayTime + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        Boolean r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        DEFAULT = new ContinuousSpeechUIConfig(r100, r101, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ ContinuousSpeechUIConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Boolean getShowSpeechOnLeft() {
        return this.showSpeechOnLeft;
    }

    public final Long getTriggerSpeechDelayTime() {
        return this.triggerSpeechDelayTime;
    }

    public ContinuousSpeechUIConfig(Boolean r100, Long r101) {
        this.showSpeechOnLeft = r100;
        this.triggerSpeechDelayTime = r101;
    }

    public /* synthetic */ ContinuousSpeechUIConfig(Boolean r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0L;
    L8:
        this(r100, r101);
    }
}
