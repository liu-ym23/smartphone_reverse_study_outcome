package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.InteractInfo;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B§\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\n\u0010S\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010T\u001a\u0004\u0018\u00010\u0003J\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0VJ\u0006\u0010W\u001a\u00020\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010i\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010p\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J®\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00182\b\u0010w\u001a\u0004\u0018\u00010xHÖ\u0003J\t\u0010y\u001a\u00020\rHÖ\u0001J\t\u0010z\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b1\u0010,R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b3\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b4\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR2\u0010K\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\f\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u0001`NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010X\u001a\u00020YX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[¨\u0006{"}, d2 = {"Lcom/larus/bmhome/chat/search/VideoInfo;", "Lcom/larus/im/bean/message/ItemData;", "cardId", "", "itemId", "description", "imageUrl", "hostPageUrl", "hostVideoSchema", "sourceApp", "iconUrl", "iconUrlV2", "sourceFrom", "", "imageUri", "sceneId", "width", "height", "videoFirstFrameImage", "videoFirstFrameImageWidth", "videoFirstFrameImageHeight", "videoFirstFrameImageUri", "interactiveRecInfo", "needFillEdge", "", "authorInfo", "Lcom/larus/bmhome/video/AuthorInfo;", "interactionInfo", "Lcom/larus/bmhome/video/InteractInfo;", "appJumpUrl", "searchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/InteractInfo;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getItemId", "getDescription", "getImageUrl", "getHostPageUrl", "getHostVideoSchema", "getSourceApp", "getIconUrl", "getIconUrlV2", "getSourceFrom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUri", "getSceneId", "getWidth", "getHeight", "getVideoFirstFrameImage", "getVideoFirstFrameImageWidth", "getVideoFirstFrameImageHeight", "getVideoFirstFrameImageUri", "getInteractiveRecInfo", "getNeedFillEdge", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAuthorInfo", "()Lcom/larus/bmhome/video/AuthorInfo;", "getInteractionInfo", "()Lcom/larus/bmhome/video/InteractInfo;", "getAppJumpUrl", "getSearchId", "videoInfoList", "", "getVideoInfoList", "()Ljava/util/List;", "setVideoInfoList", "(Ljava/util/List;)V", "videoIndex", "getVideoIndex", "()I", "setVideoIndex", "(I)V", "preloadMediaEntityList", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "getPreloadMediaEntityList", "()Ljava/util/ArrayList;", "setPreloadMediaEntityList", "(Ljava/util/ArrayList;)V", "getId", "getIconUrlCompat", "getFirstFrameSize", "Lkotlin/Pair;", "getFirstFrameImage", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/InteractInfo;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/search/VideoInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoInfo extends ItemData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<VideoInfo> f308605a;

    @SerializedName("app_jump_url")
    private final String appJumpUrl;

    @SerializedName("author_info")
    private final AuthorInfo authorInfo;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f308606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ArrayList<MediaEntity> f308607c;

    @SerializedName("id")
    private final String cardId;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient ItemType f308608d;

    @SerializedName("video_captions")
    private final String description;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("host_page_url")
    private final String hostPageUrl;

    @SerializedName("host_video_schema")
    private final String hostVideoSchema;

    @SerializedName("source_app_icon")
    private final String iconUrl;

    @SerializedName("source_app_icon_v2")
    private final String iconUrlV2;

    @SerializedName("image_uri")
    private final String imageUri;

    @SerializedName("album_image")
    private final String imageUrl;

    @SerializedName("interaction_info")
    private final InteractInfo interactionInfo;

    @SerializedName("interactive_rec_info")
    private final String interactiveRecInfo;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("need_fill_edge")
    private final Boolean needFillEdge;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("source_app_name")
    private final String sourceApp;

    @SerializedName("source_from")
    private final Integer sourceFrom;

    @SerializedName("video_first_frame_image")
    private final String videoFirstFrameImage;

    @SerializedName("video_first_frame_image_height")
    private final Integer videoFirstFrameImageHeight;

    @SerializedName("video_first_frame_image_uri")
    private final String videoFirstFrameImageUri;

    @SerializedName("video_first_frame_image_width")
    private final Integer videoFirstFrameImageWidth;

    @SerializedName("width")
    private final Integer width;

    public VideoInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ VideoInfo copy$default(VideoInfo r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, Integer r217, String r218, String r219, Integer r310, Integer r311, String r312, Integer r313, Integer r314, String r315, String r316, Boolean r317, AuthorInfo r318, InteractInfo r319, String r410, String r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = r110.cardId;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = r110.itemId;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.description;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = r110.imageUrl;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = r110.hostPageUrl;
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r105 = r110.hostVideoSchema;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = r110.sourceApp;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = r110.iconUrl;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r113 = r110.iconUrlV2;
    L39:
        if ((r412 & 512) == 0) goto L41;
        Integer r114 = r110.sourceFrom;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r115 = r110.imageUri;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r116 = r110.sceneId;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Integer r117 = r110.width;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        Integer r118 = r110.height;
    L58:
        Integer r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        String r119 = r110.videoFirstFrameImage;
    L62:
        String r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        Integer r120 = r110.videoFirstFrameImageWidth;
    L66:
        Integer r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        Integer r121 = r110.videoFirstFrameImageHeight;
    L70:
        Integer r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        String r122 = r110.videoFirstFrameImageUri;
    L74:
        String r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        String r123 = r110.interactiveRecInfo;
    L78:
        String r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        Boolean r124 = r110.needFillEdge;
    L82:
        Boolean r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        AuthorInfo r125 = r110.authorInfo;
    L86:
        AuthorInfo r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        InteractInfo r126 = r110.interactionInfo;
    L90:
        InteractInfo r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        String r127 = r110.appJumpUrl;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        String r108 = r110.searchId;
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
        return this.cardId;
    }

    public final Integer component10() {
        return this.sourceFrom;
    }

    public final String component11() {
        return this.imageUri;
    }

    public final String component12() {
        return this.sceneId;
    }

    public final Integer component13() {
        return this.width;
    }

    public final Integer component14() {
        return this.height;
    }

    public final String component15() {
        return this.videoFirstFrameImage;
    }

    public final Integer component16() {
        return this.videoFirstFrameImageWidth;
    }

    public final Integer component17() {
        return this.videoFirstFrameImageHeight;
    }

    public final String component18() {
        return this.videoFirstFrameImageUri;
    }

    public final String component19() {
        return this.interactiveRecInfo;
    }

    public final String component2() {
        return this.itemId;
    }

    public final Boolean component20() {
        return this.needFillEdge;
    }

    public final AuthorInfo component21() {
        return this.authorInfo;
    }

    public final InteractInfo component22() {
        return this.interactionInfo;
    }

    public final String component23() {
        return this.appJumpUrl;
    }

    public final String component24() {
        return this.searchId;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.hostPageUrl;
    }

    public final String component6() {
        return this.hostVideoSchema;
    }

    public final String component7() {
        return this.sourceApp;
    }

    public final String component8() {
        return this.iconUrl;
    }

    public final String component9() {
        return this.iconUrlV2;
    }

    public final VideoInfo copy(String r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, String r315, Integer r316, String r317, String r318, Integer r319, Integer r410, String r411, Integer r412, Integer r413, String r414, String r415, Boolean r416, AuthorInfo r417, InteractInfo r418, String r419, String r510) {
        return new VideoInfo(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoInfo) == true) goto L8;
        return false;
    L8:
        VideoInfo r101 = (VideoInfo) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hostPageUrl, r101.hostPageUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hostVideoSchema, r101.hostVideoSchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sourceApp, r101.sourceApp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconUrlV2, r101.iconUrlV2) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.imageUri, r101.imageUri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.videoFirstFrameImage, r101.videoFirstFrameImage) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.videoFirstFrameImageWidth, r101.videoFirstFrameImageWidth) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.videoFirstFrameImageHeight, r101.videoFirstFrameImageHeight) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.videoFirstFrameImageUri, r101.videoFirstFrameImageUri) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.interactiveRecInfo, r101.interactiveRecInfo) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.needFillEdge, r101.needFillEdge) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.authorInfo, r101.authorInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.interactionInfo, r101.interactionInfo) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.appJumpUrl, r101.appJumpUrl) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r100 = this.cardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.itemId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.hostPageUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.hostVideoSchema;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.sourceApp;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.iconUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.iconUrlV2;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.sourceFrom;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.imageUri;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.sceneId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.width;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.height;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.videoFirstFrameImage;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.videoFirstFrameImageWidth;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.videoFirstFrameImageHeight;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.videoFirstFrameImageUri;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.interactiveRecInfo;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.needFillEdge;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        AuthorInfo r161 = this.authorInfo;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        InteractInfo r164 = this.interactionInfo;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.appJumpUrl;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.searchId;
        if (r170 == null) goto L99;
        r101 = r170.hashCode();
    L99:
        return r169 + r101;
    L93:
        r168 = r167.hashCode();
        goto L94
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
        return "VideoInfo(cardId=" + this.cardId + ", itemId=" + this.itemId + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ", hostPageUrl=" + this.hostPageUrl + ", hostVideoSchema=" + this.hostVideoSchema + ", sourceApp=" + this.sourceApp + ", iconUrl=" + this.iconUrl + ", iconUrlV2=" + this.iconUrlV2 + ", sourceFrom=" + this.sourceFrom + ", imageUri=" + this.imageUri + ", sceneId=" + this.sceneId + ", width=" + this.width + ", height=" + this.height + ", videoFirstFrameImage=" + this.videoFirstFrameImage + ", videoFirstFrameImageWidth=" + this.videoFirstFrameImageWidth + ", videoFirstFrameImageHeight=" + this.videoFirstFrameImageHeight + ", videoFirstFrameImageUri=" + this.videoFirstFrameImageUri + ", interactiveRecInfo=" + this.interactiveRecInfo + ", needFillEdge=" + this.needFillEdge + ", authorInfo=" + this.authorInfo + ", interactionInfo=" + this.interactionInfo + ", appJumpUrl=" + this.appJumpUrl + ", searchId=" + this.searchId + ')';
    }

    public final String getFirstFrameImage() {
        if (o0.d(this.videoFirstFrameImage) == false) goto L7;
        String r100 = this.videoFirstFrameImage;
        if (r100 != null) goto L11;
        return "";
    L11:
        return r100;
    L7:
        r100 = this.imageUrl;
        if (r100 != null) goto L11;
        return "";
    }

    public final Pair<Integer, Integer> getFirstFrameSize() {
        Integer r100 = this.videoFirstFrameImageWidth;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        Integer r103 = this.videoFirstFrameImageHeight;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        if (r102 <= 0) goto L14;
        if (r104 <= 0) goto L14;
        return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r104));
    L14:
        Integer r105 = this.width;
        if (r105 == null) goto L17;
        int r106 = r105.intValue();
    L18:
        Integer r107 = this.height;
        if (r107 == null) goto L21;
        r101 = r107.intValue();
    L21:
        if (r106 <= 0) goto L26;
        if (r101 <= 0) goto L26;
        return TuplesKt.to(Integer.valueOf(r106), Integer.valueOf(r101));
    L26:
        return TuplesKt.to(10, 10);
    L17:
        r106 = 0;
        goto L18
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String getIconUrlCompat() {
        String r100 = this.iconUrlV2;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return this.iconUrl;
    L12:
        return this.iconUrlV2;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String getAppJumpUrl() {
        return this.appJumpUrl;
    }

    public final AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getHostPageUrl() {
        return this.hostPageUrl;
    }

    public final String getHostVideoSchema() {
        return this.hostVideoSchema;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconUrlV2() {
        return this.iconUrlV2;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.itemId;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final InteractInfo getInteractionInfo() {
        return this.interactionInfo;
    }

    public final String getInteractiveRecInfo() {
        return this.interactiveRecInfo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Boolean getNeedFillEdge() {
        return this.needFillEdge;
    }

    public final ArrayList<MediaEntity> getPreloadMediaEntityList() {
        return this.f308607c;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getSearchId() {
        return this.searchId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public ItemType getSearchItemType() {
        return this.f308608d;
    }

    public final String getSourceApp() {
        return this.sourceApp;
    }

    public final Integer getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getVideoFirstFrameImage() {
        return this.videoFirstFrameImage;
    }

    public final Integer getVideoFirstFrameImageHeight() {
        return this.videoFirstFrameImageHeight;
    }

    public final String getVideoFirstFrameImageUri() {
        return this.videoFirstFrameImageUri;
    }

    public final Integer getVideoFirstFrameImageWidth() {
        return this.videoFirstFrameImageWidth;
    }

    public final int getVideoIndex() {
        return this.f308606b;
    }

    public final List<VideoInfo> getVideoInfoList() {
        return this.f308605a;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setPreloadMediaEntityList(ArrayList<MediaEntity> r100) {
        this.f308607c = r100;
    }

    public final void setVideoIndex(int r100) {
        this.f308606b = r100;
    }

    public final void setVideoInfoList(List<VideoInfo> r100) {
        this.f308605a = r100;
    }

    public VideoInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, Integer r112, String r113, String r114, Integer r115, Integer r116, String r117, Integer r118, Integer r119, String r210, String r211, Boolean r212, AuthorInfo r213, InteractInfo r214, String r215, String r216) {
        this.cardId = r100;
        this.itemId = r101;
        this.description = r102;
        this.imageUrl = r103;
        this.hostPageUrl = r104;
        this.hostVideoSchema = r105;
        this.sourceApp = r106;
        this.iconUrl = r110;
        this.iconUrlV2 = r111;
        this.sourceFrom = r112;
        this.imageUri = r113;
        this.sceneId = r114;
        this.width = r115;
        this.height = r116;
        this.videoFirstFrameImage = r117;
        this.videoFirstFrameImageWidth = r118;
        this.videoFirstFrameImageHeight = r119;
        this.videoFirstFrameImageUri = r210;
        this.interactiveRecInfo = r211;
        this.needFillEdge = r212;
        this.authorInfo = r213;
        this.interactionInfo = r214;
        this.appJumpUrl = r215;
        this.searchId = r216;
        this.f308608d = ItemType.TYPE_CARD_VIDEO;
    }

    public /* synthetic */ VideoInfo(String r210, String r211, String r212, String r213, String r310, String r311, String r312, String r313, String r314, Integer r315, String r316, String r317, Integer r318, Integer r319, String r410, Integer r411, Integer r412, String r413, String r414, Boolean r415, AuthorInfo r416, InteractInfo r417, String r418, String r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = null;
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
        String r107 = null;
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r510 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r510 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r510 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r510 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r510 & 524288) == 0) goto L81;
        Boolean r214 = Boolean.FALSE;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        AuthorInfo r215 = null;
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        InteractInfo r216 = null;
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        String r217 = null;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        String r109 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r214, r215, r216, r217, r109);
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
        r115 = r319;
        goto L59
    L53:
        r114 = r318;
        goto L55
    L49:
        r113 = r317;
        goto L51
    L45:
        r112 = r316;
        goto L47
    L41:
        r111 = r315;
        goto L43
    L37:
        r110 = r314;
        goto L39
    L33:
        r107 = r313;
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
