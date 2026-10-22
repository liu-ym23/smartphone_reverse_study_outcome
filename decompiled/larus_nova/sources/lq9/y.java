package lq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallTranslatorConfig;", "", "enabledVoiceRecordStatus", "", "enabledShowTranslatorToast", "enabledTranslatorPhase2", "enabledTtsInitialStatus", "enabledInterpretationMic", "<init>", "(ZZZZZ)V", "getEnabledVoiceRecordStatus", "()Z", "getEnabledShowTranslatorToast", "getEnabledTranslatorPhase2", "getEnabledTtsInitialStatus", "getEnabledInterpretationMic", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class y {

    @SerializedName("enabled_interpretation_mic")
    private final boolean enabledInterpretationMic;

    @SerializedName("enabled_show_translator_toast")
    private final boolean enabledShowTranslatorToast;

    @SerializedName("enabled_translator_phase2")
    private final boolean enabledTranslatorPhase2;

    @SerializedName("enabled_tts_initial_status")
    private final boolean enabledTtsInitialStatus;

    @SerializedName("enabled_voice_record_status")
    private final boolean enabledVoiceRecordStatus;

    public y() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.enabledVoiceRecordStatus == r101.enabledVoiceRecordStatus) goto L12;
        return false;
    L12:
        if (this.enabledShowTranslatorToast == r101.enabledShowTranslatorToast) goto L15;
        return false;
    L15:
        if (this.enabledTranslatorPhase2 == r101.enabledTranslatorPhase2) goto L18;
        return false;
    L18:
        if (this.enabledTtsInitialStatus == r101.enabledTtsInitialStatus) goto L21;
        return false;
    L21:
        if (this.enabledInterpretationMic == r101.enabledInterpretationMic) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enabledVoiceRecordStatus == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enabledShowTranslatorToast == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enabledTranslatorPhase2 == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enabledTtsInitialStatus == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enabledInterpretationMic == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RealtimeCallTranslatorConfig(enabledVoiceRecordStatus=" + this.enabledVoiceRecordStatus + ", enabledShowTranslatorToast=" + this.enabledShowTranslatorToast + ", enabledTranslatorPhase2=" + this.enabledTranslatorPhase2 + ", enabledTtsInitialStatus=" + this.enabledTtsInitialStatus + ", enabledInterpretationMic=" + this.enabledInterpretationMic + ')';
    }

    public final boolean a() {
        return this.enabledInterpretationMic;
    }

    public final boolean b() {
        return this.enabledShowTranslatorToast;
    }

    public final boolean c() {
        return this.enabledTranslatorPhase2;
    }

    public final boolean d() {
        return this.enabledTtsInitialStatus;
    }

    public final boolean e() {
        return this.enabledVoiceRecordStatus;
    }

    public y(int r100) {
        this.enabledVoiceRecordStatus = true;
        this.enabledShowTranslatorToast = false;
        this.enabledTranslatorPhase2 = false;
        this.enabledTtsInitialStatus = false;
        this.enabledInterpretationMic = false;
    }
}
