package com.larus.settings.provider.music;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/music/MusicSaveConfig;", "Ljava/io/Serializable;", "minVersionUseCanvasDraw", "", "framesPerSecond", "drainTimeoutMs", "", "fixSaveMusicError", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getMinVersionUseCanvasDraw", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFramesPerSecond", "getDrainTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFixSaveMusicError", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicSaveConfig implements Serializable {

    @SerializedName("drain_timeout_ms")
    private final Long drainTimeoutMs;

    @SerializedName("fix_save_music_error")
    private final Boolean fixSaveMusicError;

    @SerializedName("frames_per_second")
    private final Integer framesPerSecond;

    @SerializedName("min_version_use_canvas_draw")
    private final Integer minVersionUseCanvasDraw;

    public MusicSaveConfig() {
        this(null, null, null, null, 15, null);
    }

    public final Long getDrainTimeoutMs() {
        return this.drainTimeoutMs;
    }

    public final Boolean getFixSaveMusicError() {
        return this.fixSaveMusicError;
    }

    public final Integer getFramesPerSecond() {
        return this.framesPerSecond;
    }

    public final Integer getMinVersionUseCanvasDraw() {
        return this.minVersionUseCanvasDraw;
    }

    public MusicSaveConfig(Integer r100, Integer r101, Long r102, Boolean r103) {
        this.minVersionUseCanvasDraw = r100;
        this.framesPerSecond = r101;
        this.drainTimeoutMs = r102;
        this.fixSaveMusicError = r103;
    }

    public /* synthetic */ MusicSaveConfig(Integer r100, Integer r101, Long r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 5;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1000L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        this(r100, r101, r102, r103);
    }
}
