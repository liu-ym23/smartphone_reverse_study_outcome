package fb1;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lfb1/b;", "", "", "songId", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "", "duration", FaceService.girlLabel, "getDuration", "()F", "", "anchor", "Ljava/lang/String;", "getAnchor", "()Ljava/lang/String;", "title", "f", "Lfb1/c;", PlayerResolution.SDKKEY.ORIGIN, "Lfb1/c;", "d", "()Lfb1/c;", "accompany", "b", "Lfb1/a;", KtvSubElement.LYRIC, "Lfb1/a;", "c", "()Lfb1/a;", "midiFilePath", "getMidiFilePath", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("accompany_model")
    private final c accompany;

    @SerializedName("anchor")
    private final String anchor;

    @SerializedName("duration")
    private final float duration;

    @SerializedName("lyric_model")
    private final a lyric;

    @SerializedName("midi_path")
    private final String midiFilePath;

    @SerializedName("original_model")
    private final c origin;

    @SerializedName("song_id")
    private final Long songId;

    @SerializedName("song_title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.songId, r101.songId) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.duration, r101.duration) == 0) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchor, r101.anchor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.origin, r101.origin) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.accompany, r101.accompany) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lyric, r101.lyric) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.midiFilePath, r101.midiFilePath) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.songId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + Float.floatToIntBits(this.duration)) * 31;
        String r104 = this.anchor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.origin;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        c r113 = this.accompany;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        a r116 = this.lyric;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.midiFilePath;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SongSourceModel(songId=" + this.songId + ", duration=" + this.duration + ", anchor=" + this.anchor + ", title=" + this.title + ", origin=" + this.origin + ", accompany=" + this.accompany + ", lyric=" + this.lyric + ", midiFilePath=" + this.midiFilePath + ")";
    }

    public final c b() {
        return this.accompany;
    }

    public final a c() {
        return this.lyric;
    }

    public final c d() {
        return this.origin;
    }

    public final Long e() {
        return this.songId;
    }

    public final String f() {
        return this.title;
    }

    public static b a(b r100) {
        Long r101 = r100.songId;
        float r102 = r100.duration;
        String r103 = r100.anchor;
        String r104 = r100.title;
        c r105 = r100.origin;
        c r106 = r100.accompany;
        a r107 = r100.lyric;
        String r108 = r100.midiFilePath;
        r100.getClass();
        return new b(r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public b(Long r100, float r101, String r102, String r103, c r104, c r105, a r106, String r107) {
        this.songId = r100;
        this.duration = r101;
        this.anchor = r102;
        this.title = r103;
        this.origin = r104;
        this.accompany = r105;
        this.lyric = r106;
        this.midiFilePath = r107;
    }
}
