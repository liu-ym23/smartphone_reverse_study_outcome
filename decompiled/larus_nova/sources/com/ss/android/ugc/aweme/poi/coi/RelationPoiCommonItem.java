package com.ss.android.ugc.aweme.poi.coi;

import android.os.SystemClock;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.locallife.model.poi.resp.SimpleAwemeInfo;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.ugc.aweme.poi.utils.Md5Utils;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b8\b\u0086\b\u0018\u0000 l2\u00020\u0001:\u0002mlBÏ\u0001\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0016\u0012\b\b\u0002\u00101\u001a\u00020\u0016¢\u0006\u0004\bj\u0010kJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000fHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0016HÆ\u0003J\t\u0010 \u001a\u00020\u0016HÆ\u0003JØ\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00162\b\b\u0002\u00101\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b2\u00103J\t\u00104\u001a\u00020\u0002HÖ\u0001J\t\u00105\u001a\u00020\u000fHÖ\u0001J\u0013\u00108\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003R\u001c\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010;R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010>R$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010%\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010J\u001a\u0004\bK\u0010\u0011R\u001a\u0010'\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010OR$\u0010)\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010O\u001a\u0004\bU\u0010VR\u001c\u0010+\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010W\u001a\u0004\b+\u0010\u0018R\u001c\u0010,\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010X\u001a\u0004\bY\u0010ZR\u001f\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b-\u0010[\u001a\u0004\b\\\u0010]R\"\u0010.\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010L\u001a\u0004\b^\u0010N\"\u0004\b_\u0010`R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010O\u001a\u0004\ba\u0010V\"\u0004\bb\u0010cR\"\u00100\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010d\u001a\u0004\b0\u0010e\"\u0004\bf\u0010gR\"\u00101\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010d\u001a\u0004\bh\u0010e\"\u0004\bi\u0010g¨\u0006n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;", "Ljava/io/Serializable;", "", "extraString", "getSortId", "Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "component1", "Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;", "component2", "Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "component3", "Lcom/ss/android/ugc/aweme/poi/coi/RecommendInformation;", "component4", "Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;", "component5", "", "component6", "()Ljava/lang/Integer;", "component7", "Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;", "component9", "component10", "", "component11", "()Ljava/lang/Boolean;", "Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;", "component12", "", "component13", "component14", "component15", "component16", "component17", "poiInfo", "productInfo", ShareChannel.DOUYIN, "recInfo", "relationInfo", "displayMode", "cardType", "sortId", "displayInfo", "coiReqId", "isAd", "adInfo", "barrages", "itemType", "dividerDesc", "isRecommendCard", "needGradientBg", "copy", "(Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;Lcom/ss/android/ugc/aweme/poi/coi/RecommendInformation;Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;Ljava/lang/Integer;ILjava/lang/String;Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;Ljava/util/List;ILjava/lang/String;ZZ)Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "getPoiInfo", "()Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;", "getProductInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;", "Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "getAweme", "()Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "setAweme", "(Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;)V", "Lcom/ss/android/ugc/aweme/poi/coi/RecommendInformation;", "getRecInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/RecommendInformation;", "Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;", "getRelationInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;", "Ljava/lang/Integer;", "getDisplayMode", "I", "getCardType", "()I", "Ljava/lang/String;", "Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;", "getDisplayInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;", "setDisplayInfo", "(Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;)V", "getCoiReqId", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;", "getAdInfo", "()Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;", "Ljava/util/List;", "getBarrages", "()Ljava/util/List;", "getItemType", "setItemType", "(I)V", "getDividerDesc", "setDividerDesc", "(Ljava/lang/String;)V", "Z", "()Z", "setRecommendCard", "(Z)V", "getNeedGradientBg", "setNeedGradientBg", "<init>", "(Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;Lcom/ss/android/ugc/aweme/poi/coi/RecommendInformation;Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;Ljava/lang/Integer;ILjava/lang/String;Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;Ljava/util/List;ILjava/lang/String;ZZ)V", "Companion", "CardType", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class RelationPoiCommonItem implements Serializable {
    public static final Companion Companion = null;
    public static final int ITEM_TYPE_COMMON_POI_LARGE_CARD = 0;
    public static final int ITEM_TYPE_COMMON_POI_SMALL_CARD = 1;
    public static final int ITEM_TYPE_DIVIDER = 2;

    @SerializedName("ad_info")
    private final ADInfoData adInfo;

    @SerializedName("aweme_info")
    private SimpleAwemeInfo aweme;
    private final List<String> barrages;

    @SerializedName(a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("coi_req_id")
    private final String coiReqId;

    @SerializedName("coi_display_info")
    private CoiDisplayInfo displayInfo;

    @SerializedName("display_mode")
    private final Integer displayMode;
    private String dividerDesc;

    @SerializedName("is_ad")
    private final Boolean isAd;
    private boolean isRecommendCard;
    private int itemType;
    private boolean needGradientBg;

    @SerializedName("poi_info")
    private final SimplePoiInfoStruct poiInfo;

    @SerializedName("product_info")
    private final PoiSpuListModuleStruct productInfo;

    @SerializedName("rec_info")
    private final RecommendInformation recInfo;

    @SerializedName("relation_info")
    private final RelationInfo relationInfo;

    @SerializedName("sort_id")
    private String sortId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem$CardType;", "", "", "type", "I", "getType", "()I", "CARD_TYPE_VIDEO", "CARD_TYPE_IMG", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CardType extends Enum<CardType> {
        public static final CardType CARD_TYPE_IMG = null;
        public static final CardType CARD_TYPE_VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardType[] f451318a = null;
        private final int type;

        public static CardType valueOf(String r100) {
            return (CardType) r27.a.a(CardType.class, r100);
        }

        public static CardType[] values() {
            return (CardType[]) f451318a.clone();
        }

        static {
            CardType r100 = new CardType("CARD_TYPE_VIDEO", 0, 0);
            CARD_TYPE_VIDEO = r100;
            CardType r101 = new CardType("CARD_TYPE_IMG", 1, 1);
            CARD_TYPE_IMG = r101;
            f451318a = new CardType[]{r100, r101};
        }

        public final int getType() {
            return this.type;
        }

        public CardType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem$Companion;", "", "()V", "ITEM_TYPE_COMMON_POI_LARGE_CARD", "", "ITEM_TYPE_COMMON_POI_SMALL_CARD", "ITEM_TYPE_DIVIDER", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public RelationPoiCommonItem() {
        this(null, null, null, null, null, null, 0, null, null, null, null, null, null, 0, null, false, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RelationPoiCommonItem copy$default(RelationPoiCommonItem r110, SimplePoiInfoStruct r111, PoiSpuListModuleStruct r112, SimpleAwemeInfo r210, RecommendInformation r211, RelationInfo r212, Integer r213, int r214, String r215, CoiDisplayInfo r216, String r217, Boolean r218, ADInfoData r219, List r310, int r311, String r312, boolean r313, boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        SimplePoiInfoStruct r100 = r110.poiInfo;
    L7:
        if ((r315 & 2) == 0) goto L9;
        PoiSpuListModuleStruct r101 = r110.productInfo;
    L11:
        if ((r315 & 4) == 0) goto L13;
        SimpleAwemeInfo r102 = r110.aweme;
    L15:
        if ((r315 & 8) == 0) goto L17;
        RecommendInformation r103 = r110.recInfo;
    L19:
        if ((r315 & 16) == 0) goto L21;
        RelationInfo r104 = r110.relationInfo;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Integer r105 = r110.displayMode;
    L27:
        if ((r315 & 64) == 0) goto L29;
        int r106 = r110.cardType;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r107 = r110.sortId;
    L35:
        if ((r315 & 256) == 0) goto L37;
        CoiDisplayInfo r113 = r110.displayInfo;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.coiReqId;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Boolean r115 = r110.isAd;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        ADInfoData r116 = r110.adInfo;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        List r117 = r110.barrages;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        int r118 = r110.itemType;
    L58:
        int r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.dividerDesc;
    L62:
        String r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        boolean r120 = r110.isRecommendCard;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        boolean r108 = r110.needGradientBg;
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

    public final SimplePoiInfoStruct component1() {
        return this.poiInfo;
    }

    public final String component10() {
        return this.coiReqId;
    }

    public final Boolean component11() {
        return this.isAd;
    }

    public final ADInfoData component12() {
        return this.adInfo;
    }

    public final List<String> component13() {
        return this.barrages;
    }

    public final int component14() {
        return this.itemType;
    }

    public final String component15() {
        return this.dividerDesc;
    }

    public final boolean component16() {
        return this.isRecommendCard;
    }

    public final boolean component17() {
        return this.needGradientBg;
    }

    public final PoiSpuListModuleStruct component2() {
        return this.productInfo;
    }

    public final SimpleAwemeInfo component3() {
        return this.aweme;
    }

    public final RecommendInformation component4() {
        return this.recInfo;
    }

    public final RelationInfo component5() {
        return this.relationInfo;
    }

    public final Integer component6() {
        return this.displayMode;
    }

    public final int component7() {
        return this.cardType;
    }

    public final CoiDisplayInfo component9() {
        return this.displayInfo;
    }

    public final RelationPoiCommonItem copy(SimplePoiInfoStruct r210, PoiSpuListModuleStruct r211, SimpleAwemeInfo r212, RecommendInformation r213, RelationInfo r214, Integer r215, int r216, String r217, CoiDisplayInfo r218, String r219, Boolean r310, ADInfoData r311, List<String> r312, int r313, String r314, boolean r315, boolean r316) {
        Intrinsics.checkNotNullParameter(r314, "dividerDesc");
        return new RelationPoiCommonItem(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RelationPoiCommonItem) == true) goto L8;
        return false;
    L8:
        RelationPoiCommonItem r101 = (RelationPoiCommonItem) r100;
        if (Intrinsics.areEqual(this.poiInfo, r101.poiInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.aweme, r101.aweme) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recInfo, r101.recInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.relationInfo, r101.relationInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.displayMode, r101.displayMode) == true) goto L27;
        return false;
    L27:
        if (this.cardType == r101.cardType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sortId, r101.sortId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.displayInfo, r101.displayInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.coiReqId, r101.coiReqId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isAd, r101.isAd) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.adInfo, r101.adInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.barrages, r101.barrages) == true) goto L48;
        return false;
    L48:
        if (this.itemType == r101.itemType) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.dividerDesc, r101.dividerDesc) == true) goto L54;
        return false;
    L54:
        if (this.isRecommendCard == r101.isRecommendCard) goto L57;
        return false;
    L57:
        if (this.needGradientBg == r101.needGradientBg) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        SimplePoiInfoStruct r100 = this.poiInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiSpuListModuleStruct r104 = this.productInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SimpleAwemeInfo r107 = this.aweme;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        RecommendInformation r110 = this.recInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        RelationInfo r113 = this.relationInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.displayMode;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.cardType) * 31;
        String r119 = this.sortId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        CoiDisplayInfo r122 = this.displayInfo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.coiReqId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isAd;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        ADInfoData r131 = this.adInfo;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        List<String> r134 = this.barrages;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        int r135 = (((((r133 + r101) * 31) + this.itemType) * 31) + this.dividerDesc.hashCode()) * 31;
        int r136 = 1231;
        if (this.isRecommendCard == false) goto L53;
        int r137 = 1231;
    L54:
        int r138 = (r135 + r137) * 31;
        if (this.needGradientBg == true) goto L59;
        r136 = 1237;
    L59:
        return r138 + r136;
    L53:
        r137 = 1237;
        goto L54
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
        return "RelationPoiCommonItem(poiInfo=" + this.poiInfo + ", productInfo=" + this.productInfo + ", aweme=" + this.aweme + ", recInfo=" + this.recInfo + ", relationInfo=" + this.relationInfo + ", displayMode=" + this.displayMode + ", cardType=" + this.cardType + ", sortId=" + this.sortId + ", displayInfo=" + this.displayInfo + ", coiReqId=" + this.coiReqId + ", isAd=" + this.isAd + ", adInfo=" + this.adInfo + ", barrages=" + this.barrages + ", itemType=" + this.itemType + ", dividerDesc=" + this.dividerDesc + ", isRecommendCard=" + this.isRecommendCard + ", needGradientBg=" + this.needGradientBg + ')';
    }

    public final ADInfoData getAdInfo() {
        return this.adInfo;
    }

    public final SimpleAwemeInfo getAweme() {
        return this.aweme;
    }

    public final List<String> getBarrages() {
        return this.barrages;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final String getCoiReqId() {
        return this.coiReqId;
    }

    public final CoiDisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    public final Integer getDisplayMode() {
        return this.displayMode;
    }

    public final String getDividerDesc() {
        return this.dividerDesc;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final boolean getNeedGradientBg() {
        return this.needGradientBg;
    }

    public final SimplePoiInfoStruct getPoiInfo() {
        return this.poiInfo;
    }

    public final PoiSpuListModuleStruct getProductInfo() {
        return this.productInfo;
    }

    public final RecommendInformation getRecInfo() {
        return this.recInfo;
    }

    public final RelationInfo getRelationInfo() {
        return this.relationInfo;
    }

    public final Boolean isAd() {
        return this.isAd;
    }

    public final boolean isRecommendCard() {
        return this.isRecommendCard;
    }

    public final String getSortId(String r100) {
        String r101 = this.sortId;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L19;
        StringBuilder r103 = new StringBuilder();
        SimplePoiInfoStruct r104 = this.poiInfo;
        String r105 = null;
        if (r104 == null) goto L13;
        String r106 = r104.getPoiId();
    L14:
        r103.append(r106);
        SimplePoiInfoStruct r107 = this.poiInfo;
        if (r107 == null) goto L17;
        r105 = r107.getPoiName();
    L17:
        r103.append(r105);
        r103.append(this.cardType);
        r103.append(r100);
        r103.append(SystemClock.elapsedRealtimeNanos());
        r103.append(UUID.randomUUID());
        this.sortId = Md5Utils.a(r103.toString());
        return "";
    L13:
        r106 = null;
        goto L14
    L19:
        return this.sortId;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void setAweme(SimpleAwemeInfo r100) {
        this.aweme = r100;
    }

    public final void setDisplayInfo(CoiDisplayInfo r100) {
        this.displayInfo = r100;
    }

    public final void setDividerDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dividerDesc = r100;
    }

    public final void setItemType(int r100) {
        this.itemType = r100;
    }

    public final void setNeedGradientBg(boolean r100) {
        this.needGradientBg = r100;
    }

    public final void setRecommendCard(boolean r100) {
        this.isRecommendCard = r100;
    }

    public RelationPoiCommonItem(SimplePoiInfoStruct r100, PoiSpuListModuleStruct r101, SimpleAwemeInfo r102, RecommendInformation r103, RelationInfo r104, Integer r105, int r110, String r111, CoiDisplayInfo r112, String r113, Boolean r114, ADInfoData r115, List<String> r116, int r117, String r118, boolean r119, boolean r210) {
        Intrinsics.checkNotNullParameter(r118, "dividerDesc");
        this.poiInfo = r100;
        this.productInfo = r101;
        this.aweme = r102;
        this.recInfo = r103;
        this.relationInfo = r104;
        this.displayMode = r105;
        this.cardType = r110;
        this.sortId = r111;
        this.displayInfo = r112;
        this.coiReqId = r113;
        this.isAd = r114;
        this.adInfo = r115;
        this.barrages = r116;
        this.itemType = r117;
        this.dividerDesc = r118;
        this.isRecommendCard = r119;
        this.needGradientBg = r210;
    }

    public /* synthetic */ RelationPoiCommonItem(SimplePoiInfoStruct r110, PoiSpuListModuleStruct r210, SimpleAwemeInfo r211, RecommendInformation r212, RelationInfo r213, Integer r214, int r215, String r216, CoiDisplayInfo r217, String r218, Boolean r219, ADInfoData r310, List r311, int r312, String r313, boolean r314, boolean r315, int r316, DefaultConstructorMarker r317) {
        List r100 = null;
        if ((r316 & 1) == 0) goto L5;
        SimplePoiInfoStruct r101 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        PoiSpuListModuleStruct r102 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        SimpleAwemeInfo r103 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        RecommendInformation r104 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        RelationInfo r105 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        int r107 = CardType.CARD_TYPE_VIDEO.getType();
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        CoiDisplayInfo r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Boolean r113 = Boolean.FALSE;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        ADInfoData r114 = null;
    L51:
        if ((r316 & 4096) != 0) goto L55;
        r100 = r311;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        int r115 = 0;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r116 = "";
    L63:
        if ((r316 & 32768) == 0) goto L65;
        boolean r117 = false;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        boolean r109 = false;
    L70:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r111, r112, r113, r114, r100, r115, r116, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r116 = r313;
        goto L63
    L57:
        r115 = r312;
        goto L59
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
        r108 = r216;
        goto L35
    L29:
        r107 = r215;
        goto L31
    L25:
        r106 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
