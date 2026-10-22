package com.larus.platform.uimodel;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0001_B¥\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010I\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010L\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010O\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\t\u0010P\u001a\u00020\fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¬\u0002\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u00102\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\fHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b6\u00104R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b=\u0010*R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010!¨\u0006`"}, d2 = {"Lcom/larus/platform/uimodel/MediaEntity;", "Ljava/io/Serializable;", AppConstants.BUNDLE_MEDIA_ID, "", "item_id", "media_url", "media_from", "media_account_name", "media_des", "media_source_icon", "media_cover_image", "media_width", "", "media_height", "video_model", "video_auto_play", "", "source_from", "sourceId", "start", "", "duration", "media_status", "interactive_rec_info", "author_id", "author_name", "author_avatar", "aweme_type", "scene", "hostVideoSchema", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMedia_id", "()Ljava/lang/String;", "getItem_id", "getMedia_url", "getMedia_from", "getMedia_account_name", "getMedia_des", "getMedia_source_icon", "getMedia_cover_image", "getMedia_width", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMedia_height", "getVideo_model", "getVideo_auto_play", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSource_from", "getSourceId", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getMedia_status", "()I", "getInteractive_rec_info", "getAuthor_id", "getAuthor_name", "getAuthor_avatar", "getAweme_type", "getScene", "getHostVideoSchema", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/uimodel/MediaEntity;", "equals", "other", "", "hashCode", "toString", "MediaStatus", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaEntity implements Serializable {

    @SerializedName("author_avatar")
    private final String author_avatar;

    @SerializedName("author_id")
    private final String author_id;

    @SerializedName("author_name")
    private final String author_name;

    @SerializedName("aweme_type")
    private final Integer aweme_type;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("host_video_schema")
    private final String hostVideoSchema;

    @SerializedName("interactive_rec_info")
    private final String interactive_rec_info;

    @SerializedName("item_id")
    private final String item_id;

    @SerializedName("artist_name")
    private final String media_account_name;

    @SerializedName("album_image")
    private final String media_cover_image;

    @SerializedName("song_name")
    private final String media_des;

    @SerializedName("source_app_name")
    private final String media_from;

    @SerializedName("media_height")
    private final Integer media_height;

    @SerializedName("vid")
    private final String media_id;

    @SerializedName("source_app_icon")
    private final String media_source_icon;

    @SerializedName("media_status")
    private final int media_status;

    @SerializedName("media_url")
    private final String media_url;

    @SerializedName("media_width")
    private final Integer media_width;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("source_from")
    private final Integer source_from;

    @SerializedName("start")
    private final Long start;

    @SerializedName("video_auto_play")
    private final Boolean video_auto_play;

    @SerializedName("video_model")
    private final String video_model;

    public MediaEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ MediaEntity copy$default(MediaEntity r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, Integer r216, Integer r217, String r218, Boolean r219, Integer r310, String r311, Long r312, Long r313, int r314, String r315, String r316, String r317, String r318, Integer r319, String r410, String r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = r110.media_id;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = r110.item_id;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.media_url;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = r110.media_from;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = r110.media_account_name;
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r105 = r110.media_des;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = r110.media_source_icon;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = r110.media_cover_image;
    L35:
        if ((r412 & 256) == 0) goto L37;
        Integer r113 = r110.media_width;
    L39:
        if ((r412 & 512) == 0) goto L41;
        Integer r114 = r110.media_height;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r115 = r110.video_model;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        Boolean r116 = r110.video_auto_play;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Integer r117 = r110.source_from;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r118 = r110.sourceId;
    L58:
        String r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        Long r119 = r110.start;
    L62:
        Long r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        Long r120 = r110.duration;
    L66:
        Long r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        int r121 = r110.media_status;
    L70:
        int r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        String r122 = r110.interactive_rec_info;
    L74:
        String r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        String r123 = r110.author_id;
    L78:
        String r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        String r124 = r110.author_name;
    L82:
        String r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        String r125 = r110.author_avatar;
    L86:
        String r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        Integer r126 = r110.aweme_type;
    L90:
        Integer r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        String r127 = r110.scene;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        String r108 = r110.hostVideoSchema;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.media_id;
    }

    public final Integer component10() {
        return this.media_height;
    }

    public final String component11() {
        return this.video_model;
    }

    public final Boolean component12() {
        return this.video_auto_play;
    }

    public final Integer component13() {
        return this.source_from;
    }

    public final String component14() {
        return this.sourceId;
    }

    public final Long component15() {
        return this.start;
    }

    public final Long component16() {
        return this.duration;
    }

    public final int component17() {
        return this.media_status;
    }

    public final String component18() {
        return this.interactive_rec_info;
    }

    public final String component19() {
        return this.author_id;
    }

    public final String component2() {
        return this.item_id;
    }

    public final String component20() {
        return this.author_name;
    }

    public final String component21() {
        return this.author_avatar;
    }

    public final Integer component22() {
        return this.aweme_type;
    }

    public final String component23() {
        return this.scene;
    }

    public final String component24() {
        return this.hostVideoSchema;
    }

    public final String component3() {
        return this.media_url;
    }

    public final String component4() {
        return this.media_from;
    }

    public final String component5() {
        return this.media_account_name;
    }

    public final String component6() {
        return this.media_des;
    }

    public final String component7() {
        return this.media_source_icon;
    }

    public final String component8() {
        return this.media_cover_image;
    }

    public final Integer component9() {
        return this.media_width;
    }

    public final MediaEntity copy(String r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, Integer r315, Integer r316, String r317, Boolean r318, Integer r319, String r410, Long r411, Long r412, int r413, String r414, String r415, String r416, String r417, Integer r418, String r419, String r510) {
        return new MediaEntity(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaEntity) == true) goto L8;
        return false;
    L8:
        MediaEntity r101 = (MediaEntity) r100;
        if (Intrinsics.areEqual(this.media_id, r101.media_id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.item_id, r101.item_id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.media_url, r101.media_url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.media_from, r101.media_from) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.media_account_name, r101.media_account_name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.media_des, r101.media_des) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.media_source_icon, r101.media_source_icon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.media_cover_image, r101.media_cover_image) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.media_width, r101.media_width) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.media_height, r101.media_height) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.video_model, r101.video_model) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.video_auto_play, r101.video_auto_play) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.source_from, r101.source_from) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sourceId, r101.sourceId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L57;
        return false;
    L57:
        if (this.media_status == r101.media_status) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.interactive_rec_info, r101.interactive_rec_info) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.author_id, r101.author_id) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.author_name, r101.author_name) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.author_avatar, r101.author_avatar) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.aweme_type, r101.aweme_type) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.hostVideoSchema, r101.hostVideoSchema) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r100 = this.media_id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.item_id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.media_url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.media_from;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.media_account_name;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.media_des;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.media_source_icon;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.media_cover_image;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.media_width;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.media_height;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.video_model;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.video_auto_play;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.source_from;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.sourceId;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.start;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.duration;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (((r145 + r147) * 31) + this.media_status) * 31;
        String r149 = this.interactive_rec_info;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.author_id;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.author_name;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.author_avatar;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.aweme_type;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.scene;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.hostVideoSchema;
        if (r167 == null) goto L95;
        r101 = r167.hashCode();
    L95:
        return r166 + r101;
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
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

    public String toString() {
        return "MediaEntity(media_id=" + this.media_id + ", item_id=" + this.item_id + ", media_url=" + this.media_url + ", media_from=" + this.media_from + ", media_account_name=" + this.media_account_name + ", media_des=" + this.media_des + ", media_source_icon=" + this.media_source_icon + ", media_cover_image=" + this.media_cover_image + ", media_width=" + this.media_width + ", media_height=" + this.media_height + ", video_model=" + this.video_model + ", video_auto_play=" + this.video_auto_play + ", source_from=" + this.source_from + ", sourceId=" + this.sourceId + ", start=" + this.start + ", duration=" + this.duration + ", media_status=" + this.media_status + ", interactive_rec_info=" + this.interactive_rec_info + ", author_id=" + this.author_id + ", author_name=" + this.author_name + ", author_avatar=" + this.author_avatar + ", aweme_type=" + this.aweme_type + ", scene=" + this.scene + ", hostVideoSchema=" + this.hostVideoSchema + ')';
    }

    public final String getAuthor_avatar() {
        return this.author_avatar;
    }

    public final String getAuthor_id() {
        return this.author_id;
    }

    public final String getAuthor_name() {
        return this.author_name;
    }

    public final Integer getAweme_type() {
        return this.aweme_type;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getHostVideoSchema() {
        return this.hostVideoSchema;
    }

    public final String getInteractive_rec_info() {
        return this.interactive_rec_info;
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final String getMedia_account_name() {
        return this.media_account_name;
    }

    public final String getMedia_cover_image() {
        return this.media_cover_image;
    }

    public final String getMedia_des() {
        return this.media_des;
    }

    public final String getMedia_from() {
        return this.media_from;
    }

    public final Integer getMedia_height() {
        return this.media_height;
    }

    public final String getMedia_id() {
        return this.media_id;
    }

    public final String getMedia_source_icon() {
        return this.media_source_icon;
    }

    public final int getMedia_status() {
        return this.media_status;
    }

    public final String getMedia_url() {
        return this.media_url;
    }

    public final Integer getMedia_width() {
        return this.media_width;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final Integer getSource_from() {
        return this.source_from;
    }

    public final Long getStart() {
        return this.start;
    }

    public final Boolean getVideo_auto_play() {
        return this.video_auto_play;
    }

    public final String getVideo_model() {
        return this.video_model;
    }

    public MediaEntity(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, Integer r111, Integer r112, String r113, Boolean r114, Integer r115, String r116, Long r117, Long r118, int r119, String r210, String r211, String r212, String r213, Integer r214, String r215, String r216) {
        this.media_id = r100;
        this.item_id = r101;
        this.media_url = r102;
        this.media_from = r103;
        this.media_account_name = r104;
        this.media_des = r105;
        this.media_source_icon = r106;
        this.media_cover_image = r110;
        this.media_width = r111;
        this.media_height = r112;
        this.video_model = r113;
        this.video_auto_play = r114;
        this.source_from = r115;
        this.sourceId = r116;
        this.start = r117;
        this.duration = r118;
        this.media_status = r119;
        this.interactive_rec_info = r210;
        this.author_id = r211;
        this.author_name = r212;
        this.author_avatar = r213;
        this.aweme_type = r214;
        this.scene = r215;
        this.hostVideoSchema = r216;
    }

    public /* synthetic */ MediaEntity(String r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, Integer r315, Integer r316, String r317, Boolean r318, Integer r319, String r410, Long r411, Long r412, int r413, String r414, String r415, String r416, String r417, Integer r418, String r419, String r510, int r511, DefaultConstructorMarker r512) {
        if ((r511 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r511 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r511 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r511 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r511 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r511 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r511 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r511 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r511 & 256) == 0) goto L37;
        Integer r110 = 0;
    L39:
        if ((r511 & 512) == 0) goto L41;
        Integer r111 = 0;
    L43:
        if ((r511 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r511 & 2048) == 0) goto L49;
        Boolean r113 = Boolean.FALSE;
    L51:
        if ((r511 & 4096) == 0) goto L53;
        Integer r114 = -1;
    L55:
        if ((r511 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r511 & 16384) == 0) goto L61;
        Long r108 = 0L;
    L63:
        if ((r511 & 32768) == 0) goto L65;
        Long r116 = -1L;
    L67:
        if ((r511 & 65536) == 0) goto L69;
        int r117 = 0;
    L70:
        String r118 = null;
        if ((r511 & 131072) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r511 & 262144) == 0) goto L77;
        String r213 = "";
    L79:
        if ((r511 & 524288) == 0) goto L81;
        String r214 = "";
    L83:
        if ((r511 & 1048576) == 0) goto L85;
        String r215 = "";
    L87:
        if ((r511 & 2097152) == 0) goto L89;
        Integer r216 = 0;
    L91:
        if ((r511 & 4194304) == 0) goto L93;
        String r217 = "";
    L95:
        if ((r511 & 8388608) != 0) goto L98;
        r118 = r510;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r119, r213, r214, r215, r216, r217, r118);
        return;
    L93:
        r217 = r419;
        goto L95
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r213 = r415;
        goto L79
    L73:
        r119 = r414;
        goto L75
    L69:
        r117 = r413;
        goto L70
    L65:
        r116 = r412;
        goto L67
    L61:
        r108 = r411;
        goto L63
    L57:
        r115 = r410;
        goto L59
    L53:
        r114 = r319;
        goto L55
    L49:
        r113 = r318;
        goto L51
    L45:
        r112 = r317;
        goto L47
    L41:
        r111 = r316;
        goto L43
    L37:
        r110 = r315;
        goto L39
    L33:
        r107 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
