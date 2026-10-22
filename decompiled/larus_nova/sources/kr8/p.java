package kr8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/music/mob/MusicCardShow;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "messageId", "position", "videoId", "showFrom", "musicSource", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getMessageId", "getPosition", "getVideoId", "getShowFrom", "getMusicSource", "getBotId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505882a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("music_source")
    private final String musicSource;

    @SerializedName("position")
    private final String position;

    @SerializedName("show_from")
    private final String showFrom;

    @SerializedName("video_id")
    private final String videoId;

    public p() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f505882a, r101.f505882a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showFrom, r101.showFrom) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.musicSource, r101.musicSource) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505882a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.position;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.videoId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.showFrom;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.musicSource;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.botId;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicCardShow(mobKey=" + this.f505882a + ", messageId=" + this.messageId + ", position=" + this.position + ", videoId=" + this.videoId + ", showFrom=" + this.showFrom + ", musicSource=" + this.musicSource + ", botId=" + this.botId + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505882a;
    }

    public final String d() {
        return this.messageId;
    }

    public final String e() {
        return this.position;
    }

    public static p c(p r100, String r101) {
        return new p(r100.f505882a, r100.messageId, r100.position, r101, r100.showFrom, r100.musicSource, r100.botId);
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public /* synthetic */ p(String r110, String r111, String r112, String r113, String r114, String r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = "music_card_show";
    L6:
        String r101 = r100;
        if ((r116 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r116 & 64) == 0) goto L29;
        String r107 = "";
    L30:
        this(r101, r102, r103, r104, r105, r106, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    public p(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f505882a = r100;
        this.messageId = r101;
        this.position = r102;
        this.videoId = r103;
        this.showFrom = r104;
        this.musicSource = r105;
        this.botId = r106;
    }
}
