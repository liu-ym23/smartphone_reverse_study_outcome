package kr8;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003Jê\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u000fHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u000e\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0016\u0010\u0016\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*¨\u0006J"}, d2 = {"Lcom/larus/bmhome/music/mob/CreateMusicResult;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "secScene", "chatType", "botId", "createWay", "videoId", "errorInfo", "title", "messageId", "enterMethod", "lyricCreateType", "isLyric", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "generationType", "duration", "messageType", "success", "successCount", "requestCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;III)V", "getMobKey", "()Ljava/lang/String;", "getSecScene", "getChatType", "getBotId", "getCreateWay", "getVideoId", "getErrorInfo", "getTitle", "getMessageId", "getEnterMethod", "getLyricCreateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModel", "getGenerationType", "getDuration", "()I", "getMessageType", "getSuccess", "getSuccessCount", "getRequestCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;III)Lcom/larus/bmhome/music/mob/CreateMusicResult;", "equals", "", "other", "", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505860a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("create_source")
    private final String createWay;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(MapMonitorConst.ERROR_INFO)
    private final String errorInfo;

    @SerializedName("generation_type")
    private final String generationType;

    @SerializedName("is_lyric")
    private final Integer isLyric;

    @SerializedName("lyric_create_type")
    private final String lyricCreateType;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("message_type")
    private final String messageType;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("request_cnt")
    private final int requestCount;

    @SerializedName("sec_scene")
    private final String secScene;

    @SerializedName("success")
    private final int success;

    @SerializedName("success_cnt")
    private final int successCount;

    @SerializedName("title")
    private final String title;

    @SerializedName("video_id")
    private final String videoId;

    public h() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f505860a, r101.f505860a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secScene, r101.secScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createWay, r101.createWay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.errorInfo, r101.errorInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.lyricCreateType, r101.lyricCreateType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isLyric, r101.isLyric) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.generationType, r101.generationType) == true) goto L51;
        return false;
    L51:
        if (this.duration == r101.duration) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L57;
        return false;
    L57:
        if (this.success == r101.success) goto L60;
        return false;
    L60:
        if (this.successCount == r101.successCount) goto L63;
        return false;
    L63:
        if (this.requestCount == r101.requestCount) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505860a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secScene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.chatType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.botId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.createWay;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.videoId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.errorInfo;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.title;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.messageId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.enterMethod;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.lyricCreateType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.isLyric;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.model;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.generationType;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (((r139 + r141) * 31) + this.duration) * 31;
        String r143 = this.messageType;
        if (r143 == null) goto L63;
        r101 = r143.hashCode();
    L63:
        return ((((((r142 + r101) * 31) + this.success) * 31) + this.successCount) * 31) + this.requestCount;
    L57:
        r141 = r140.hashCode();
        goto L58
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
        return "CreateMusicResult(mobKey=" + this.f505860a + ", secScene=" + this.secScene + ", chatType=" + this.chatType + ", botId=" + this.botId + ", createWay=" + this.createWay + ", videoId=" + this.videoId + ", errorInfo=" + this.errorInfo + ", title=" + this.title + ", messageId=" + this.messageId + ", enterMethod=" + this.enterMethod + ", lyricCreateType=" + this.lyricCreateType + ", isLyric=" + this.isLyric + ", model=" + this.model + ", generationType=" + this.generationType + ", duration=" + this.duration + ", messageType=" + this.messageType + ", success=" + this.success + ", successCount=" + this.successCount + ", requestCount=" + this.requestCount + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505860a;
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public h(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, Integer r310, String r311, String r312, int r313, String r314, int r315, int r316, int r317, int r318) {
        String r100 = null;
        if ((r318 & 1) == 0) goto L5;
        String r101 = "create_music_result";
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r318 & 8) != 0) goto L19;
        r100 = r212;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r318 & 2048) == 0) goto L49;
        Integer r114 = 1;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r107 = "";
    L58:
        String r220 = r107;
        if ((r318 & 16384) == 0) goto L61;
        int r108 = e.f505856c;
        int r116 = (int) e.a.a();
    L63:
        if ((32768 & r318) == 0) goto L65;
        String r117 = "";
    L66:
        Integer r221 = r114;
        if ((r318 & 65536) == 0) goto L69;
        int r109 = 0;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r318 & 262144) == 0) goto L77;
        int r119 = 0;
    L78:
        this.f505860a = r101;
        this.secScene = r102;
        this.chatType = r103;
        this.botId = r100;
        this.createWay = r104;
        this.videoId = r105;
        this.errorInfo = r106;
        this.title = r110;
        this.messageId = r111;
        this.enterMethod = r112;
        this.lyricCreateType = r113;
        this.isLyric = r221;
        this.model = r115;
        this.generationType = r220;
        this.duration = r116;
        this.messageType = r117;
        this.success = r109;
        this.successCount = r118;
        this.requestCount = r119;
        return;
    L77:
        r119 = r317;
        goto L78
    L73:
        r118 = r316;
        goto L75
    L69:
        r109 = r315;
        goto L71
    L65:
        r117 = r314;
        goto L66
    L61:
        r116 = r313;
        goto L63
    L57:
        r107 = r312;
        goto L58
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r110 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = null;
        goto L7
    }
}
