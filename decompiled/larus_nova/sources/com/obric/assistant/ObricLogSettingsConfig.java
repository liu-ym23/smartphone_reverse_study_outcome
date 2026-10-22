package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ObricLogSettingsConfig;", "", "forbitHighFreqLogs", "", "<init>", "(Z)V", "getForbitHighFreqLogs", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLogSettingsConfig {

    @SerializedName("forbit_high_freq_logs")
    private final boolean forbitHighFreqLogs;

    public ObricLogSettingsConfig() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ ObricLogSettingsConfig copy$default(ObricLogSettingsConfig r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.forbitHighFreqLogs;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.forbitHighFreqLogs;
    }

    public final ObricLogSettingsConfig copy(boolean r100) {
        return new ObricLogSettingsConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricLogSettingsConfig) == true) goto L9;
        return false;
    L9:
        if (this.forbitHighFreqLogs == ((ObricLogSettingsConfig) r100).forbitHighFreqLogs) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.forbitHighFreqLogs == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "ObricLogSettingsConfig(forbitHighFreqLogs=" + this.forbitHighFreqLogs + ')';
    }

    public final boolean getForbitHighFreqLogs() {
        return this.forbitHighFreqLogs;
    }

    public ObricLogSettingsConfig(boolean r100) {
        this.forbitHighFreqLogs = r100;
    }

    public /* synthetic */ ObricLogSettingsConfig(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
