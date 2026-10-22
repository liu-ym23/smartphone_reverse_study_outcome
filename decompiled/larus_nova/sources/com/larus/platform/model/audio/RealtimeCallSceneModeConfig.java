package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallSceneModeConfig;", "", "enableNoInputHangUp", "", "noInputHangUpTimeSecond", "", "enableSceneMode", "enableSceneModeGuide", "<init>", "(ZIZZ)V", "getEnableNoInputHangUp", "()Z", "getNoInputHangUpTimeSecond", "()I", "getEnableSceneMode", "getEnableSceneModeGuide", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneModeConfig {

    @SerializedName("enable_no_input_hang_up")
    private final boolean enableNoInputHangUp;

    @SerializedName("enable_scene_mode")
    private final boolean enableSceneMode;

    @SerializedName("enable_scene_mode_guide")
    private final boolean enableSceneModeGuide;

    @SerializedName("no_input_hang_up_time_second")
    private final int noInputHangUpTimeSecond;

    public RealtimeCallSceneModeConfig() {
        this(false, 0, false, false, 15, null);
    }

    public static /* synthetic */ RealtimeCallSceneModeConfig copy$default(RealtimeCallSceneModeConfig r100, boolean r101, int r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enableNoInputHangUp;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.noInputHangUpTimeSecond;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enableSceneMode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.enableSceneModeGuide;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enableNoInputHangUp;
    }

    public final int component2() {
        return this.noInputHangUpTimeSecond;
    }

    public final boolean component3() {
        return this.enableSceneMode;
    }

    public final boolean component4() {
        return this.enableSceneModeGuide;
    }

    public final RealtimeCallSceneModeConfig copy(boolean r100, int r101, boolean r102, boolean r103) {
        return new RealtimeCallSceneModeConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallSceneModeConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallSceneModeConfig r101 = (RealtimeCallSceneModeConfig) r100;
        if (this.enableNoInputHangUp == r101.enableNoInputHangUp) goto L12;
        return false;
    L12:
        if (this.noInputHangUpTimeSecond == r101.noInputHangUpTimeSecond) goto L15;
        return false;
    L15:
        if (this.enableSceneMode == r101.enableSceneMode) goto L18;
        return false;
    L18:
        if (this.enableSceneModeGuide == r101.enableSceneModeGuide) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableNoInputHangUp == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.noInputHangUpTimeSecond) * 31;
        if (this.enableSceneMode == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableSceneModeGuide == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "RealtimeCallSceneModeConfig(enableNoInputHangUp=" + this.enableNoInputHangUp + ", noInputHangUpTimeSecond=" + this.noInputHangUpTimeSecond + ", enableSceneMode=" + this.enableSceneMode + ", enableSceneModeGuide=" + this.enableSceneModeGuide + ')';
    }

    public final boolean getEnableNoInputHangUp() {
        return this.enableNoInputHangUp;
    }

    public final boolean getEnableSceneMode() {
        return this.enableSceneMode;
    }

    public final boolean getEnableSceneModeGuide() {
        return this.enableSceneModeGuide;
    }

    public final int getNoInputHangUpTimeSecond() {
        return this.noInputHangUpTimeSecond;
    }

    public RealtimeCallSceneModeConfig(boolean r100, int r101, boolean r102, boolean r103) {
        this.enableNoInputHangUp = r100;
        this.noInputHangUpTimeSecond = r101;
        this.enableSceneMode = r102;
        this.enableSceneModeGuide = r103;
    }

    public /* synthetic */ RealtimeCallSceneModeConfig(boolean r100, int r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
