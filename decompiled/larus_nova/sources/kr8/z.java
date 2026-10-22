package kr8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J±\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00064"}, d2 = {"Lcom/larus/bmhome/music/mob/ShareMusic;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "currentPage", "previousPage", "botId", "title", "isDefaultCover", "isDefaultTitle", "isLyric", "videoId", DBDefinition.TASK_ID, "isTemplate", "clickFrom", "messageId", "createWay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getCurrentPage", "getPreviousPage", "getBotId", "getTitle", "getVideoId", "getTaskId", "getClickFrom", "getMessageId", "getCreateWay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505898a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("click_from")
    private final String clickFrom;

    @SerializedName("create_source")
    private final String createWay;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("is_default_cover")
    private final String isDefaultCover;

    @SerializedName("is_default_title")
    private final String isDefaultTitle;

    @SerializedName("is_lyric")
    private final String isLyric;

    @SerializedName("is_template")
    private final String isTemplate;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("title")
    private final String title;

    @SerializedName("video_id")
    private final String videoId;

    public z() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f505898a, r101.f505898a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isDefaultCover, r101.isDefaultCover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isDefaultTitle, r101.isDefaultTitle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isLyric, r101.isLyric) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isTemplate, r101.isTemplate) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.clickFrom, r101.clickFrom) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createWay, r101.createWay) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505898a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.currentPage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.previousPage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.botId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.isDefaultCover;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.isDefaultTitle;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.isLyric;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.videoId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.taskId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.isTemplate;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.clickFrom;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.messageId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.createWay;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "ShareMusic(mobKey=" + this.f505898a + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", botId=" + this.botId + ", title=" + this.title + ", isDefaultCover=" + this.isDefaultCover + ", isDefaultTitle=" + this.isDefaultTitle + ", isLyric=" + this.isLyric + ", videoId=" + this.videoId + ", taskId=" + this.taskId + ", isTemplate=" + this.isTemplate + ", clickFrom=" + this.clickFrom + ", messageId=" + this.messageId + ", createWay=" + this.createWay + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505898a;
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public z(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        String r100 = "share_music";
    L6:
        String r101 = "";
        if ((r219 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r219 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r219 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r219 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r219 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r219 & 64) == 0) goto L29;
        String r113 = "";
    L31:
        if ((r219 & 128) == 0) goto L33;
        String r114 = "1";
    L35:
        if ((r219 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r219 & 512) == 0) goto L41;
        String r116 = "";
    L43:
        if ((r219 & 1024) == 0) goto L45;
        String r117 = "";
    L47:
        if ((r219 & 2048) == 0) goto L49;
        String r118 = "";
    L51:
        if ((r219 & 4096) != 0) goto L55;
        r101 = r217;
    L55:
        if ((r219 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        this.f505898a = r100;
        this.currentPage = r102;
        this.previousPage = r103;
        this.botId = r104;
        this.title = r105;
        this.isDefaultCover = r106;
        this.isDefaultTitle = r113;
        this.isLyric = r114;
        this.videoId = r115;
        this.taskId = r116;
        this.isTemplate = r117;
        this.clickFrom = r118;
        this.messageId = r101;
        this.createWay = r107;
        return;
    L57:
        r107 = r218;
        goto L58
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}
