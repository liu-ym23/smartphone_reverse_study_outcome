package kv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/settings/provider/music/MusicCreateMicroAppConfig;", "", "enableMusicCreateMicroAppInter", "", "enableMusicLyricsExpandInput", "<init>", "(ZZ)V", "getEnableMusicCreateMicroAppInter", "()Z", "getEnableMusicLyricsExpandInput", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("enable_music_create_micro_app_inter")
    private final boolean enableMusicCreateMicroAppInter;

    @SerializedName("enable_music_lyrics_expand_input")
    private final boolean enableMusicLyricsExpandInput;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.enableMusicCreateMicroAppInter == r101.enableMusicCreateMicroAppInter) goto L12;
        return false;
    L12:
        if (this.enableMusicLyricsExpandInput == r101.enableMusicLyricsExpandInput) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableMusicCreateMicroAppInter == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMusicLyricsExpandInput == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MusicCreateMicroAppConfig(enableMusicCreateMicroAppInter=" + this.enableMusicCreateMicroAppInter + ", enableMusicLyricsExpandInput=" + this.enableMusicLyricsExpandInput + ')';
    }

    public final boolean a() {
        return this.enableMusicCreateMicroAppInter;
    }

    public final boolean b() {
        return this.enableMusicLyricsExpandInput;
    }

    public c(int r100) {
        this.enableMusicCreateMicroAppInter = false;
        this.enableMusicLyricsExpandInput = false;
    }
}
