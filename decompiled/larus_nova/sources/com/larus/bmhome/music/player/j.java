package com.larus.bmhome.music.player;

import androidx.compose.ui.spatial.RectListKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bH\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001iB«\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0003\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010]\u001a\u00020\rHÆ\u0003J\t\u0010^\u001a\u00020\rHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010`\u001a\u00020\rHÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u00ad\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0003\u0010#\u001a\u00020\u0003HÆ\u0001J\u0013\u0010e\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010g\u001a\u00020\tHÖ\u0001J\t\u0010h\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0016\u0010\u0017\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00101R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010\u001f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u0010DR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u0010DR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010'¨\u0006j"}, d2 = {"Lcom/larus/bmhome/music/player/MusicPlayerData;", "", "messageId", "", "conversationId", "botId", "showFrom", "sourceId", "sourceFrom", "", "videoModel", "vid", "autoPlay", "", "autoPlayMulti", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateSyncTime", "", "playerEngineKey", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "currentPage", "detailPage", "chatType", "title", "chunkUrl", "isTemplate", "compatMusicCardMob", "playList", "Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "clickFromNext", "clickFromPrevious", "message", "Lcom/larus/im/bean/message/Message;", "mediaScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLkotlinx/coroutines/CoroutineScope;JLjava/lang/String;Lcom/larus/bmhome/music/mob/MusicAppletMobContext;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/larus/im/bean/message/block/player/ICreationPlayList;ZZLcom/larus/im/bean/message/Message;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getConversationId", "getBotId", "getShowFrom", "getSourceId", "getSourceFrom", "()I", "getVideoModel", "getVid", "getAutoPlay", "()Z", "getAutoPlayMulti", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getUpdateSyncTime", "()J", "getPlayerEngineKey", "getMusicAppletMobContext", "()Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "getCurrentPage", "getDetailPage", "getChatType", "getTitle", "getChunkUrl", "getCompatMusicCardMob", "getPlayList", "()Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "getClickFromNext", "setClickFromNext", "(Z)V", "getClickFromPrevious", "setClickFromPrevious", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getMediaScene", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", "hashCode", "toString", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient CoroutineScope f312972a;

    @SerializedName("auto_play")
    private final boolean autoPlay;

    @SerializedName("auto_play_multi")
    private final boolean autoPlayMulti;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient long f312973b;

    @SerializedName("bot_id")
    private final String botId;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient String f312974c;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("chunk_uri")
    private final String chunkUrl;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("current_page")
    private final String currentPage;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient kr8.o f312975d;

    @SerializedName("detail_page")
    private final boolean detailPage;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient boolean f312976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient boolean f312977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient ad9.b f312978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient boolean f312979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient boolean f312980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final transient Message f312981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final transient String f312982k;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("show_from")
    private final String showFrom;

    @SerializedName("source_from")
    private final int sourceFrom;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("title")
    private final String title;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("video_model")
    private final String videoModel;

    public static final class a {
    }

    public j() {
        this(null, null, null, null, null, 0, null, null, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, RectListKt.Lower26Bits);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showFrom, r101.showFrom) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceId, r101.sourceId) == true) goto L24;
        return false;
    L24:
        if (this.sourceFrom == r101.sourceFrom) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.videoModel, r101.videoModel) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L33;
        return false;
    L33:
        if (this.autoPlay == r101.autoPlay) goto L36;
        return false;
    L36:
        if (this.autoPlayMulti == r101.autoPlayMulti) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f312972a, r101.f312972a) == true) goto L42;
        return false;
    L42:
        if (this.f312973b == r101.f312973b) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f312974c, r101.f312974c) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f312975d, r101.f312975d) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L54;
        return false;
    L54:
        if (this.detailPage == r101.detailPage) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.chunkUrl, r101.chunkUrl) == true) goto L66;
        return false;
    L66:
        if (this.f312976e == r101.f312976e) goto L69;
        return false;
    L69:
        if (this.f312977f == r101.f312977f) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f312978g, r101.f312978g) == true) goto L75;
        return false;
    L75:
        if (this.f312979h == r101.f312979h) goto L78;
        return false;
    L78:
        if (this.f312980i == r101.f312980i) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f312981j, r101.f312981j) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f312982k, r101.f312982k) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public final int hashCode() {
        String r100 = this.messageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.botId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.showFrom;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sourceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.sourceFrom) * 31;
        String r116 = this.videoModel;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.vid;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        int r122 = 1231;
        if (this.autoPlay == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r121 + r123) * 31;
        if (this.autoPlayMulti == false) goto L37;
        int r125 = 1231;
    L38:
        int r126 = (r124 + r125) * 31;
        CoroutineScope r127 = this.f312972a;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        long r129 = this.f312973b;
        int r130 = (((r126 + r128) * 31) + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        String r131 = this.f312974c;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        kr8.o r134 = this.f312975d;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.currentPage;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        if (this.detailPage == false) goto L57;
        int r140 = 1231;
    L58:
        int r141 = (r139 + r140) * 31;
        String r142 = this.chatType;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        String r145 = this.title;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        String r148 = this.chunkUrl;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        if (this.f312976e == false) goto L73;
        int r151 = 1231;
    L74:
        int r152 = (r150 + r151) * 31;
        if (this.f312977f == false) goto L77;
        int r153 = 1231;
    L78:
        int r154 = (r152 + r153) * 31;
        ad9.b r155 = this.f312978g;
        if (r155 != null) goto L81;
        int r156 = 0;
    L82:
        int r157 = (r154 + r156) * 31;
        if (this.f312979h == false) goto L85;
        int r158 = 1231;
    L86:
        int r159 = (r157 + r158) * 31;
        if (this.f312980i == true) goto L90;
        r122 = 1237;
    L90:
        int r160 = (r159 + r122) * 31;
        Message r161 = this.f312981j;
        if (r161 == null) goto L95;
        r101 = r161.hashCode();
    L95:
        return ((r160 + r101) * 31) + this.f312982k.hashCode();
    L85:
        r158 = 1237;
        goto L86
    L81:
        r156 = r155.hashCode();
        goto L82
    L77:
        r153 = 1237;
        goto L78
    L73:
        r151 = 1237;
        goto L74
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = 1237;
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
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = 1237;
        goto L38
    L33:
        r123 = 1237;
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
        return "MusicPlayerData(messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", showFrom=" + this.showFrom + ", sourceId=" + this.sourceId + ", sourceFrom=" + this.sourceFrom + ", videoModel=" + this.videoModel + ", vid=" + this.vid + ", autoPlay=" + this.autoPlay + ", autoPlayMulti=" + this.autoPlayMulti + ", scope=" + this.f312972a + ", updateSyncTime=" + this.f312973b + ", playerEngineKey=" + this.f312974c + ", musicAppletMobContext=" + this.f312975d + ", currentPage=" + this.currentPage + ", detailPage=" + this.detailPage + ", chatType=" + this.chatType + ", title=" + this.title + ", chunkUrl=" + this.chunkUrl + ", isTemplate=" + this.f312976e + ", compatMusicCardMob=" + this.f312977f + ", playList=" + this.f312978g + ", clickFromNext=" + this.f312979h + ", clickFromPrevious=" + this.f312980i + ", message=" + this.f312981j + ", mediaScene=" + this.f312982k + ')';
    }

    static {
        new Gson();
    }

    public final boolean b() {
        return this.autoPlay;
    }

    public final boolean c() {
        return this.autoPlayMulti;
    }

    public final String d() {
        return this.botId;
    }

    public final String e() {
        return this.chatType;
    }

    public final String f() {
        return this.chunkUrl;
    }

    public final String g() {
        return this.conversationId;
    }

    public final String h() {
        return this.currentPage;
    }

    public final boolean i() {
        return this.detailPage;
    }

    public final String j() {
        return this.messageId;
    }

    public final String k() {
        return this.showFrom;
    }

    public final int l() {
        return this.sourceFrom;
    }

    public final String m() {
        return this.sourceId;
    }

    public final String n() {
        return this.title;
    }

    public final String o() {
        return this.vid;
    }

    public final String p() {
        return this.videoModel;
    }

    public static j a(j r310, String r311, String r312, boolean r313, boolean r314, LifecycleCoroutineScope r315, long r316, kr8.o r410, String r411, boolean r412, String r413, String r414, ad9.b r415, boolean r416, boolean r417, Message r418, int r419) {
        if ((r419 & 1) == 0) goto L5;
        String r100 = r310.messageId;
    L7:
        if ((r419 & 2) == 0) goto L9;
        String r101 = r310.conversationId;
    L11:
        if ((r419 & 4) == 0) goto L13;
        String r102 = r310.botId;
    L15:
        if ((r419 & 8) == 0) goto L17;
        String r103 = r310.showFrom;
    L19:
        if ((r419 & 16) == 0) goto L21;
        String r104 = r310.sourceId;
    L23:
        if ((r419 & 32) == 0) goto L25;
        int r110 = r310.sourceFrom;
    L27:
        if ((r419 & 64) == 0) goto L29;
        String r111 = r310.videoModel;
    L31:
        if ((r419 & 128) == 0) goto L33;
        String r112 = r310.vid;
    L35:
        if ((r419 & 256) == 0) goto L37;
        boolean r113 = r310.autoPlay;
    L39:
        if ((r419 & 512) == 0) goto L41;
        boolean r114 = r310.autoPlayMulti;
    L43:
        if ((r419 & 1024) == 0) goto L45;
        CoroutineScope r115 = r310.f312972a;
    L47:
        if ((r419 & 2048) == 0) goto L49;
        long r116 = r310.f312973b;
    L51:
        if ((r419 & 4096) == 0) goto L53;
        String r105 = r310.f312974c;
    L55:
        if ((r419 & 8192) == 0) goto L57;
        kr8.o r117 = r310.f312975d;
    L59:
        if ((r419 & 16384) == 0) goto L61;
        String r210 = r310.currentPage;
    L63:
        if ((32768 & r419) == 0) goto L65;
        boolean r211 = r310.detailPage;
    L67:
        if ((65536 & r419) == 0) goto L69;
        String r212 = r310.chatType;
    L71:
        if ((131072 & r419) == 0) goto L73;
        String r213 = r310.title;
    L75:
        if ((262144 & r419) == 0) goto L77;
        String r214 = r310.chunkUrl;
    L79:
        if ((524288 & r419) == 0) goto L81;
        boolean r215 = r310.f312976e;
    L83:
        if ((1048576 & r419) == 0) goto L85;
        boolean r216 = r310.f312977f;
    L87:
        if ((2097152 & r419) == 0) goto L89;
        ad9.b r217 = r310.f312978g;
    L91:
        if ((4194304 & r419) == 0) goto L93;
        boolean r218 = r310.f312979h;
    L95:
        if ((8388608 & r419) == 0) goto L97;
        boolean r219 = r310.f312980i;
    L99:
        if ((16777216 & r419) == 0) goto L101;
        Message r317 = r310.f312981j;
    L103:
        if ((r419 & 33554432) == 0) goto L105;
        String r106 = r310.f312982k;
    L106:
        r310.getClass();
        Intrinsics.checkNotNullParameter(r106, "mediaScene");
        return new j(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r105, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r317, r106);
    L105:
        r106 = null;
        goto L106
    L101:
        r317 = r418;
        goto L103
    L97:
        r219 = r417;
        goto L99
    L93:
        r218 = r416;
        goto L95
    L89:
        r217 = r415;
        goto L91
    L85:
        r216 = false;
        goto L87
    L81:
        r215 = false;
        goto L83
    L77:
        r214 = r414;
        goto L79
    L73:
        r213 = r413;
        goto L75
    L69:
        r212 = null;
        goto L71
    L65:
        r211 = r412;
        goto L67
    L61:
        r210 = r411;
        goto L63
    L57:
        r117 = r410;
        goto L59
    L53:
        r105 = null;
        goto L55
    L49:
        r116 = r316;
        goto L51
    L45:
        r115 = r315;
        goto L47
    L41:
        r114 = r314;
        goto L43
    L37:
        r113 = r313;
        goto L39
    L33:
        r112 = r312;
        goto L35
    L29:
        r111 = r311;
        goto L31
    L25:
        r110 = 0;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public j(String r100, String r101, String r102, String r103, String r104, int r110, String r111, String r112, boolean r113, boolean r114, CoroutineScope r115, long r116, String r117, kr8.o r118, String r210, boolean r211, String r212, String r213, String r214, boolean r215, boolean r216, ad9.b r217, boolean r218, boolean r219, Message r310, @MediaScene String r311) {
        Intrinsics.checkNotNullParameter(r311, "mediaScene");
        this.messageId = r100;
        this.conversationId = r101;
        this.botId = r102;
        this.showFrom = r103;
        this.sourceId = r104;
        this.sourceFrom = r110;
        this.videoModel = r111;
        this.vid = r112;
        this.autoPlay = r113;
        this.autoPlayMulti = r114;
        this.f312972a = r115;
        this.f312973b = r116;
        this.f312974c = r117;
        this.f312975d = r118;
        this.currentPage = r210;
        this.detailPage = r211;
        this.chatType = r212;
        this.title = r213;
        this.chunkUrl = r214;
        this.f312976e = r215;
        this.f312977f = r216;
        this.f312978g = r217;
        this.f312979h = r218;
        this.f312980i = r219;
        this.f312981j = r310;
        this.f312982k = r311;
    }

    public /* synthetic */ j(String r210, String r310, String r311, String r312, String r313, int r314, String r315, String r316, boolean r317, boolean r318, CoroutineScope r319, long r410, String r411, kr8.o r412, String r413, boolean r414, String r415, String r416, String r417, boolean r418, boolean r510, ad9.b r511, boolean r512, boolean r513, Message r514, String r515, int r516) {
        if ((r516 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r516 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r516 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r516 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r516 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r516 & 512) == 0) goto L41;
        boolean r112 = false;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        CoroutineScope r113 = null;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        long r114 = 500;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        String r107 = null;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        kr8.o r115 = null;
    L58:
        String r116 = "";
        if ((r516 & 16384) == 0) goto L61;
        String r108 = r116;
    L63:
        if ((r516 & 32768) == 0) goto L65;
        boolean r117 = false;
    L67:
        if ((r516 & 65536) == 0) goto L69;
        String r118 = r116;
    L71:
        if ((r516 & 131072) == 0) goto L73;
        String r211 = r116;
    L75:
        if ((r516 & 262144) != 0) goto L79;
        r116 = r417;
    L79:
        if ((r516 & 524288) == 0) goto L81;
        boolean r212 = false;
    L83:
        if ((r516 & 1048576) == 0) goto L85;
        boolean r213 = false;
    L87:
        if ((r516 & 2097152) == 0) goto L89;
        ad9.b r214 = null;
    L91:
        if ((r516 & 4194304) == 0) goto L93;
        boolean r215 = false;
    L95:
        if ((r516 & 8388608) == 0) goto L97;
        boolean r216 = false;
    L99:
        if ((r516 & 16777216) == 0) goto L101;
        Message r217 = null;
    L103:
        if ((r516 & 33554432) == 0) goto L105;
        String r109 = "music";
    L106:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r115, r108, r117, r118, r211, r116, r212, r213, r214, r215, r216, r217, r109);
        return;
    L105:
        r109 = r515;
        goto L106
    L101:
        r217 = r514;
        goto L103
    L97:
        r216 = r513;
        goto L99
    L93:
        r215 = r512;
        goto L95
    L89:
        r214 = r511;
        goto L91
    L85:
        r213 = r510;
        goto L87
    L81:
        r212 = r418;
        goto L83
    L73:
        r211 = r416;
        goto L75
    L69:
        r118 = r415;
        goto L71
    L65:
        r117 = r414;
        goto L67
    L61:
        r108 = r413;
        goto L63
    L57:
        r115 = r412;
        goto L58
    L53:
        r107 = r411;
        goto L55
    L49:
        r114 = r410;
        goto L51
    L45:
        r113 = r319;
        goto L47
    L41:
        r112 = r318;
        goto L43
    L37:
        r111 = r317;
        goto L39
    L33:
        r110 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
