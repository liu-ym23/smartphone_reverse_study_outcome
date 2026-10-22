package com.bytedance.locallife.model.album;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010U\u001a\u00020\u001cHÆ\u0003J\t\u0010V\u001a\u00020\u001cHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J¤\u0002\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020\u001c2\b\u0010b\u001a\u0004\u0018\u00010cHÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b5\u0010'R\u001a\u0010\u001d\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u0010:R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bB\u00102R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,¨\u0006f"}, d2 = {"Lcom/bytedance/locallife/model/album/PhotoData;", "Ljava/io/Serializable;", "mediaType", "", "url", "", "uri", "picId", "urlJEPG", "tabId", "tabName", "nameForShow", "picScore", "", "picSourceInt", "picSource", "upLoaderId", "upLoaderName", "picLogParams", "videoId", "videoUrl", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "videoWidth", "videoHeight", "videoCoverUrl", "highlight", "Lcom/bytedance/locallife/model/album/HighLightStruct;", "hasMob", "", "selected", "index", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;IILjava/lang/String;Lcom/bytedance/locallife/model/album/HighLightStruct;ZZLjava/lang/Integer;)V", "getHasMob", "()Z", "setHasMob", "(Z)V", "getHighlight", "()Lcom/bytedance/locallife/model/album/HighLightStruct;", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMediaType", "()I", "getNameForShow", "()Ljava/lang/String;", "getPicId", "getPicLogParams", "getPicScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPicSource", "getPicSourceInt", "getSelected", "setSelected", "getTabId", "setTabId", "(Ljava/lang/String;)V", "getTabName", "getUpLoaderId", "getUpLoaderName", "getUri", "getUrl", "getUrlJEPG", "getVideoCoverUrl", "getVideoDuration", "getVideoHeight", "getVideoId", "getVideoUrl", "getVideoWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;IILjava/lang/String;Lcom/bytedance/locallife/model/album/HighLightStruct;ZZLjava/lang/Integer;)Lcom/bytedance/locallife/model/album/PhotoData;", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PhotoData implements Serializable {
    private boolean hasMob;

    @SerializedName("highlight")
    private final HighLightStruct highlight;
    private Integer index;

    @SerializedName(a.KEY_MEDIA_TYPE)
    private final int mediaType;

    @SerializedName("name_for_show")
    private final String nameForShow;

    @SerializedName("pic_id")
    private final String picId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS)
    private final String picLogParams;

    @SerializedName("pic_score")
    private final Float picScore;

    @SerializedName("pic_source")
    private final String picSource;

    @SerializedName("source")
    private final Integer picSourceInt;
    private boolean selected;

    @SerializedName("tab_id")
    private String tabId;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("uploader_id")
    private final String upLoaderId;

    @SerializedName("uploader_nick_name")
    private final String upLoaderName;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("url")
    private final String url;

    @SerializedName("optimized_url")
    private final String urlJEPG;

    @SerializedName("video_cover_url")
    private final String videoCoverUrl;

    @SerializedName("video_duration")
    private final Float videoDuration;

    @SerializedName("video_height")
    private final int videoHeight;

    @SerializedName("video_id")
    private final String videoId;

    @SerializedName("video_url")
    private final String videoUrl;

    @SerializedName("video_width")
    private final int videoWidth;

    public PhotoData() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, false, false, null, 16777215, null);
    }

    public static /* synthetic */ PhotoData copy$default(PhotoData r110, int r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, Float r216, Integer r217, String r218, String r219, String r310, String r311, String r312, String r313, Float r314, int r315, int r316, String r317, HighLightStruct r318, boolean r319, boolean r410, Integer r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        int r100 = r110.mediaType;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = r110.url;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.uri;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = r110.picId;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = r110.urlJEPG;
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r105 = r110.tabId;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = r110.tabName;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = r110.nameForShow;
    L35:
        if ((r412 & 256) == 0) goto L37;
        Float r113 = r110.picScore;
    L39:
        if ((r412 & 512) == 0) goto L41;
        Integer r114 = r110.picSourceInt;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r115 = r110.picSource;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r116 = r110.upLoaderId;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r117 = r110.upLoaderName;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r118 = r110.picLogParams;
    L58:
        String r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        String r119 = r110.videoId;
    L62:
        String r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        String r120 = r110.videoUrl;
    L66:
        String r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        Float r121 = r110.videoDuration;
    L70:
        Float r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        int r122 = r110.videoWidth;
    L74:
        int r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        int r123 = r110.videoHeight;
    L78:
        int r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        String r124 = r110.videoCoverUrl;
    L82:
        String r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        HighLightStruct r125 = r110.highlight;
    L86:
        HighLightStruct r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        boolean r126 = r110.hasMob;
    L90:
        boolean r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        boolean r127 = r110.selected;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        Integer r108 = r110.index;
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

    public final int component1() {
        return this.mediaType;
    }

    public final Integer component10() {
        return this.picSourceInt;
    }

    public final String component11() {
        return this.picSource;
    }

    public final String component12() {
        return this.upLoaderId;
    }

    public final String component13() {
        return this.upLoaderName;
    }

    public final String component14() {
        return this.picLogParams;
    }

    public final String component15() {
        return this.videoId;
    }

    public final String component16() {
        return this.videoUrl;
    }

    public final Float component17() {
        return this.videoDuration;
    }

    public final int component18() {
        return this.videoWidth;
    }

    public final int component19() {
        return this.videoHeight;
    }

    public final String component2() {
        return this.url;
    }

    public final String component20() {
        return this.videoCoverUrl;
    }

    public final HighLightStruct component21() {
        return this.highlight;
    }

    public final boolean component22() {
        return this.hasMob;
    }

    public final boolean component23() {
        return this.selected;
    }

    public final Integer component24() {
        return this.index;
    }

    public final String component3() {
        return this.uri;
    }

    public final String component4() {
        return this.picId;
    }

    public final String component5() {
        return this.urlJEPG;
    }

    public final String component6() {
        return this.tabId;
    }

    public final String component7() {
        return this.tabName;
    }

    public final String component8() {
        return this.nameForShow;
    }

    public final Float component9() {
        return this.picScore;
    }

    public final PhotoData copy(int r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, Float r315, Integer r316, String r317, String r318, String r319, String r410, String r411, String r412, Float r413, int r414, int r415, String r416, HighLightStruct r417, boolean r418, boolean r419, Integer r510) {
        return new PhotoData(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoData) == true) goto L8;
        return false;
    L8:
        PhotoData r101 = (PhotoData) r100;
        if (this.mediaType == r101.mediaType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.picId, r101.picId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.urlJEPG, r101.urlJEPG) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.nameForShow, r101.nameForShow) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.picScore, r101.picScore) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.picSourceInt, r101.picSourceInt) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.picSource, r101.picSource) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.upLoaderId, r101.upLoaderId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.upLoaderName, r101.upLoaderName) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.picLogParams, r101.picLogParams) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.videoUrl, r101.videoUrl) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.videoDuration, r101.videoDuration) == true) goto L60;
        return false;
    L60:
        if (this.videoWidth == r101.videoWidth) goto L63;
        return false;
    L63:
        if (this.videoHeight == r101.videoHeight) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.videoCoverUrl, r101.videoCoverUrl) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.highlight, r101.highlight) == true) goto L72;
        return false;
    L72:
        if (this.hasMob == r101.hasMob) goto L75;
        return false;
    L75:
        if (this.selected == r101.selected) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r100 = this.mediaType * 31;
        String r101 = this.url;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.uri;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.picId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.urlJEPG;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.tabId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.tabName;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.nameForShow;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Float r123 = this.picScore;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.picSourceInt;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.picSource;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.upLoaderId;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.upLoaderName;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        String r138 = this.picLogParams;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        String r141 = this.videoId;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        String r144 = this.videoUrl;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        Float r147 = this.videoDuration;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (((((r146 + r148) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31;
        String r150 = this.videoCoverUrl;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        HighLightStruct r153 = this.highlight;
        if (r153 != null) goto L73;
        int r154 = 0;
    L74:
        int r155 = (r152 + r154) * 31;
        int r156 = 1231;
        if (this.hasMob == false) goto L77;
        int r157 = 1231;
    L78:
        int r158 = (r155 + r157) * 31;
        if (this.selected == true) goto L82;
        r156 = 1237;
    L82:
        int r159 = (r158 + r156) * 31;
        Integer r160 = this.index;
        if (r160 == null) goto L87;
        r102 = r160.hashCode();
    L87:
        return r159 + r102;
    L77:
        r157 = 1237;
        goto L78
    L73:
        r154 = r153.hashCode();
        goto L74
    L69:
        r151 = r150.hashCode();
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoData(mediaType=" + this.mediaType + ", url=" + this.url + ", uri=" + this.uri + ", picId=" + this.picId + ", urlJEPG=" + this.urlJEPG + ", tabId=" + this.tabId + ", tabName=" + this.tabName + ", nameForShow=" + this.nameForShow + ", picScore=" + this.picScore + ", picSourceInt=" + this.picSourceInt + ", picSource=" + this.picSource + ", upLoaderId=" + this.upLoaderId + ", upLoaderName=" + this.upLoaderName + ", picLogParams=" + this.picLogParams + ", videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", videoDuration=" + this.videoDuration + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoCoverUrl=" + this.videoCoverUrl + ", highlight=" + this.highlight + ", hasMob=" + this.hasMob + ", selected=" + this.selected + ", index=" + this.index + ')';
    }

    public final boolean getHasMob() {
        return this.hasMob;
    }

    public final HighLightStruct getHighlight() {
        return this.highlight;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final String getNameForShow() {
        return this.nameForShow;
    }

    public final String getPicId() {
        return this.picId;
    }

    public final String getPicLogParams() {
        return this.picLogParams;
    }

    public final Float getPicScore() {
        return this.picScore;
    }

    public final String getPicSource() {
        return this.picSource;
    }

    public final Integer getPicSourceInt() {
        return this.picSourceInt;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getUpLoaderId() {
        return this.upLoaderId;
    }

    public final String getUpLoaderName() {
        return this.upLoaderName;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlJEPG() {
        return this.urlJEPG;
    }

    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public final Float getVideoDuration() {
        return this.videoDuration;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setHasMob(boolean r100) {
        this.hasMob = r100;
    }

    public final void setIndex(Integer r100) {
        this.index = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setTabId(String r100) {
        this.tabId = r100;
    }

    public PhotoData(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, Float r111, Integer r112, String r113, String r114, String r115, String r116, String r117, String r118, Float r119, int r210, int r211, String r212, HighLightStruct r213, boolean r214, boolean r215, Integer r216) {
        this.mediaType = r100;
        this.url = r101;
        this.uri = r102;
        this.picId = r103;
        this.urlJEPG = r104;
        this.tabId = r105;
        this.tabName = r106;
        this.nameForShow = r110;
        this.picScore = r111;
        this.picSourceInt = r112;
        this.picSource = r113;
        this.upLoaderId = r114;
        this.upLoaderName = r115;
        this.picLogParams = r116;
        this.videoId = r117;
        this.videoUrl = r118;
        this.videoDuration = r119;
        this.videoWidth = r210;
        this.videoHeight = r211;
        this.videoCoverUrl = r212;
        this.highlight = r213;
        this.hasMob = r214;
        this.selected = r215;
        this.index = r216;
    }

    public /* synthetic */ PhotoData(int r210, String r211, String r212, String r213, String r310, String r311, String r312, String r313, Float r314, Integer r315, String r316, String r317, String r318, String r319, String r410, String r411, Float r412, int r413, int r414, String r415, HighLightStruct r416, boolean r417, boolean r418, Integer r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r510 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r510 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r510 & 256) == 0) goto L37;
        Float r111 = null;
    L39:
        if ((r510 & 512) == 0) goto L41;
        Integer r112 = 0;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r510 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r510 & 65536) == 0) goto L69;
        Float r117 = null;
    L71:
        if ((r510 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        int r119 = 0;
    L79:
        if ((r510 & 524288) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        HighLightStruct r215 = null;
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        boolean r216 = false;
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        boolean r217 = false;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        Integer r109 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r214, r215, r216, r217, r109);
        return;
    L97:
        r109 = r419;
        goto L98
    L93:
        r217 = r418;
        goto L95
    L89:
        r216 = r417;
        goto L91
    L85:
        r215 = r416;
        goto L87
    L81:
        r214 = r415;
        goto L83
    L77:
        r119 = r414;
        goto L79
    L73:
        r118 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L71
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r107 = r319;
        goto L59
    L53:
        r115 = r318;
        goto L55
    L49:
        r114 = r317;
        goto L51
    L45:
        r113 = r316;
        goto L47
    L41:
        r112 = r315;
        goto L43
    L37:
        r111 = r314;
        goto L39
    L33:
        r110 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
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
