package vt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;", "", "enableRenderOpt", "", "audioAnimFps", "", "enableVideoPreviewOpt", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getEnableRenderOpt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAudioAnimFps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableVideoPreviewOpt", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("audio_anim_fps")
    private final Integer audioAnimFps;

    @SerializedName("enable_render_opt")
    private final Boolean enableRenderOpt;

    @SerializedName("enable_video_preview_opt")
    private final Boolean enableVideoPreviewOpt;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.enableRenderOpt, r101.enableRenderOpt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.audioAnimFps, r101.audioAnimFps) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableVideoPreviewOpt, r101.enableVideoPreviewOpt) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enableRenderOpt;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.audioAnimFps;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enableVideoPreviewOpt;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioAnimRenderOpt(enableRenderOpt=" + this.enableRenderOpt + ", audioAnimFps=" + this.audioAnimFps + ", enableVideoPreviewOpt=" + this.enableVideoPreviewOpt + ')';
    }

    public final Integer a() {
        return this.audioAnimFps;
    }

    public final Boolean b() {
        return this.enableRenderOpt;
    }

    public final Boolean c() {
        return this.enableVideoPreviewOpt;
    }

    public f(int r100) {
        Boolean r101 = Boolean.TRUE;
        this.enableRenderOpt = r101;
        this.audioAnimFps = 30;
        this.enableVideoPreviewOpt = r101;
    }
}
