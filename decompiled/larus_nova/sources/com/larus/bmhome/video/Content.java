package com.larus.bmhome.video;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ItemData;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010B\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010U\u001a\u00020\u001aHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jð\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u001a2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b1\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010>R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006_"}, d2 = {"Lcom/larus/bmhome/video/Content;", "Lcom/larus/im/bean/message/ItemData;", "itemId", "", "itemType", "", "source", "status", "authorInfo", "Lcom/larus/bmhome/video/AuthorInfo;", "cover", "Lcom/larus/bmhome/video/ContentCover;", "contentDescription", "Lcom/larus/bmhome/video/ContentDescription;", "interactInfo", "Lcom/larus/bmhome/video/InteractInfo;", "extra", "", "requestId", "recChannelId", "searchId", "clientExt", "", "ratioStrategy", "Lcom/larus/bmhome/video/CardRatioStrategy;", "hasExposed", "", "imprIndex", "bizTag", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/ContentCover;Lcom/larus/bmhome/video/ContentDescription;Lcom/larus/bmhome/video/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Lcom/larus/bmhome/video/CardRatioStrategy;ZLjava/lang/Integer;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getItemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "getStatus", "getAuthorInfo", "()Lcom/larus/bmhome/video/AuthorInfo;", "getCover", "()Lcom/larus/bmhome/video/ContentCover;", "getContentDescription", "()Lcom/larus/bmhome/video/ContentDescription;", "getInteractInfo", "()Lcom/larus/bmhome/video/InteractInfo;", "getExtra", "()Ljava/util/Map;", "getRequestId", "getRecChannelId", "getSearchId", "getClientExt", "getRatioStrategy", "()Lcom/larus/bmhome/video/CardRatioStrategy;", "setRatioStrategy", "(Lcom/larus/bmhome/video/CardRatioStrategy;)V", "getHasExposed", "()Z", "setHasExposed", "(Z)V", "getImprIndex", "setImprIndex", "(Ljava/lang/Integer;)V", "getBizTag", "setBizTag", "(Ljava/lang/String;)V", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/ContentCover;Lcom/larus/bmhome/video/ContentDescription;Lcom/larus/bmhome/video/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Lcom/larus/bmhome/video/CardRatioStrategy;ZLjava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/video/Content;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Content extends ItemData {

    @SerializedName("author_info")
    private final AuthorInfo authorInfo;
    private transient String bizTag;
    private final transient Map<String, String> clientExt;

    @SerializedName("content_description")
    private final ContentDescription contentDescription;

    @SerializedName("cover")
    private final ContentCover cover;

    @SerializedName("extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> extra;
    private transient boolean hasExposed;
    private transient Integer imprIndex;

    @SerializedName("interaction_info")
    private final InteractInfo interactInfo;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Integer itemType;
    private transient CardRatioStrategy ratioStrategy;

    @SerializedName("rec_channel_id")
    private final Integer recChannelId;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("search_id")
    private final String searchId;
    private final transient com.larus.im.bean.message.ItemType searchItemType;

    @SerializedName("source")
    private final Integer source;

    @SerializedName("status")
    private final Integer status;

    public Content() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Content copy$default(Content r110, String r111, Integer r112, Integer r210, Integer r211, AuthorInfo r212, ContentCover r213, ContentDescription r214, InteractInfo r215, Map r216, String r217, Integer r218, String r219, Map r310, CardRatioStrategy r311, boolean r312, Integer r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.itemId;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Integer r101 = r110.itemType;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Integer r102 = r110.source;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Integer r103 = r110.status;
    L19:
        if ((r315 & 16) == 0) goto L21;
        AuthorInfo r104 = r110.authorInfo;
    L23:
        if ((r315 & 32) == 0) goto L25;
        ContentCover r105 = r110.cover;
    L27:
        if ((r315 & 64) == 0) goto L29;
        ContentDescription r106 = r110.contentDescription;
    L31:
        if ((r315 & 128) == 0) goto L33;
        InteractInfo r107 = r110.interactInfo;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Map r113 = r110.extra;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.requestId;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Integer r115 = r110.recChannelId;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.searchId;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Map r117 = r110.clientExt;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        CardRatioStrategy r118 = r110.ratioStrategy;
    L58:
        CardRatioStrategy r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        boolean r119 = r110.hasExposed;
    L62:
        boolean r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        Integer r120 = r110.imprIndex;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        String r108 = r110.bizTag;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
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
        return this.itemId;
    }

    public final String component10() {
        return this.requestId;
    }

    public final Integer component11() {
        return this.recChannelId;
    }

    public final String component12() {
        return this.searchId;
    }

    public final Map<String, String> component13() {
        return this.clientExt;
    }

    public final CardRatioStrategy component14() {
        return this.ratioStrategy;
    }

    public final boolean component15() {
        return this.hasExposed;
    }

    public final Integer component16() {
        return this.imprIndex;
    }

    public final String component17() {
        return this.bizTag;
    }

    public final Integer component2() {
        return this.itemType;
    }

    public final Integer component3() {
        return this.source;
    }

    public final Integer component4() {
        return this.status;
    }

    public final AuthorInfo component5() {
        return this.authorInfo;
    }

    public final ContentCover component6() {
        return this.cover;
    }

    public final ContentDescription component7() {
        return this.contentDescription;
    }

    public final InteractInfo component8() {
        return this.interactInfo;
    }

    public final Map<String, String> component9() {
        return this.extra;
    }

    public final Content copy(String r210, Integer r211, Integer r212, Integer r213, AuthorInfo r214, ContentCover r215, ContentDescription r216, InteractInfo r217, Map<String, String> r218, String r219, Integer r310, String r311, Map<String, String> r312, CardRatioStrategy r313, boolean r314, Integer r315, String r316) {
        return new Content(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Content) == true) goto L8;
        return false;
    L8:
        Content r101 = (Content) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authorInfo, r101.authorInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentDescription, r101.contentDescription) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.interactInfo, r101.interactInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.recChannelId, r101.recChannelId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.clientExt, r101.clientExt) == true) goto L48;
        return false;
    L48:
        if (this.ratioStrategy == r101.ratioStrategy) goto L51;
        return false;
    L51:
        if (this.hasExposed == r101.hasExposed) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.imprIndex, r101.imprIndex) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r100 = this.itemId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.itemType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.source;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        AuthorInfo r113 = this.authorInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ContentCover r116 = this.cover;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ContentDescription r119 = this.contentDescription;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        InteractInfo r122 = this.interactInfo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.requestId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.recChannelId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.searchId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Map<String, String> r137 = this.clientExt;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        CardRatioStrategy r140 = this.ratioStrategy;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        if (this.hasExposed == false) goto L61;
        int r143 = 1231;
    L62:
        int r144 = (r142 + r143) * 31;
        Integer r145 = this.imprIndex;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        String r148 = this.bizTag;
        if (r148 == null) goto L71;
        r101 = r148.hashCode();
    L71:
        return r147 + r101;
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = 1237;
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
        return "Content(itemId=" + this.itemId + ", itemType=" + this.itemType + ", source=" + this.source + ", status=" + this.status + ", authorInfo=" + this.authorInfo + ", cover=" + this.cover + ", contentDescription=" + this.contentDescription + ", interactInfo=" + this.interactInfo + ", extra=" + this.extra + ", requestId=" + this.requestId + ", recChannelId=" + this.recChannelId + ", searchId=" + this.searchId + ", clientExt=" + this.clientExt + ", ratioStrategy=" + this.ratioStrategy + ", hasExposed=" + this.hasExposed + ", imprIndex=" + this.imprIndex + ", bizTag=" + this.bizTag + ')';
    }

    public final AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final Map<String, String> getClientExt() {
        return this.clientExt;
    }

    public final ContentDescription getContentDescription() {
        return this.contentDescription;
    }

    public final ContentCover getCover() {
        return this.cover;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final boolean getHasExposed() {
        return this.hasExposed;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.itemId;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final InteractInfo getInteractInfo() {
        return this.interactInfo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final CardRatioStrategy getRatioStrategy() {
        return this.ratioStrategy;
    }

    public final Integer getRecChannelId() {
        return this.recChannelId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getSearchId() {
        return this.searchId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public com.larus.im.bean.message.ItemType getSearchItemType() {
        return this.searchItemType;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setBizTag(String r100) {
        this.bizTag = r100;
    }

    public final void setHasExposed(boolean r100) {
        this.hasExposed = r100;
    }

    public final void setImprIndex(Integer r100) {
        this.imprIndex = r100;
    }

    public final void setRatioStrategy(CardRatioStrategy r100) {
        this.ratioStrategy = r100;
    }

    public Content(String r100, Integer r101, Integer r102, Integer r103, AuthorInfo r104, ContentCover r105, ContentDescription r106, InteractInfo r110, Map<String, String> r111, String r112, Integer r113, String r114, Map<String, String> r115, CardRatioStrategy r116, boolean r117, Integer r118, String r119) {
        this.itemId = r100;
        this.itemType = r101;
        this.source = r102;
        this.status = r103;
        this.authorInfo = r104;
        this.cover = r105;
        this.contentDescription = r106;
        this.interactInfo = r110;
        this.extra = r111;
        this.requestId = r112;
        this.recChannelId = r113;
        this.searchId = r114;
        this.clientExt = r115;
        this.ratioStrategy = r116;
        this.hasExposed = r117;
        this.imprIndex = r118;
        this.bizTag = r119;
        this.searchItemType = com.larus.im.bean.message.ItemType.TYPE_CARD_MIXED_MEDIA;
    }

    public /* synthetic */ Content(String r110, Integer r210, Integer r211, Integer r212, AuthorInfo r213, ContentCover r214, ContentDescription r215, InteractInfo r216, Map r217, String r218, Integer r219, String r310, Map r311, CardRatioStrategy r312, boolean r313, Integer r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        AuthorInfo r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        ContentCover r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        ContentDescription r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        InteractInfo r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Map r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        Map r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        CardRatioStrategy r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        Integer r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
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
        r107 = r216;
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
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
