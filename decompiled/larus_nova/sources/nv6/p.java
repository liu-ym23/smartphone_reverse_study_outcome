package nv6;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.locallife.host.model.UrlModel;
import com.bytedance.locallife.live.goodsshelves.bean.DisplayControl;
import com.bytedance.locallife.live.goodsshelves.bean.DrawTicketParamsInfo;
import com.bytedance.locallife.live.goodsshelves.bean.MemberInfo;
import com.bytedance.locallife.live.goodsshelves.bean.TicketInfo;
import com.bytedance.locallife.live.model.CardAtmosphere;
import com.bytedance.locallife.live.model.GroupPurchaseCardNearStoreInfo;
import com.bytedance.locallife.live.model.GroupPurchaseChannelSale;
import com.bytedance.locallife.live.model.GroupPurchaseFlashSale;
import com.bytedance.locallife.live.model.GroupPurchaseMinusSale;
import com.bytedance.locallife.live.model.Lottery;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010$\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001a\u00105\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010&R\u001a\u00107\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u0010&R\"\u00109\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\"\u0010B\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010:\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010HR$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\b:\u0010T\"\u0004\bU\u0010VR$\u0010W\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010HR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010+\u001a\u0004\bb\u0010-\"\u0004\bc\u0010dR$\u0010e\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010+\u001a\u0004\bf\u0010-\"\u0004\bg\u0010dR$\u0010h\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010v\u001a\u0004\u0018\u00010u8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R5\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010|8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R6\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010|8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0080\u0001\"\u0006\b\u0085\u0001\u0010\u0082\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R(\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\u0004\u001a\u0005\b\u0093\u0001\u0010\u0006\"\u0005\b\u0094\u0001\u0010HR\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0096\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R(\u0010¨\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010§\u0001\u0018\u00010P8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010S\u001a\u0005\b©\u0001\u0010TR\"\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\"\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001¨\u0006´\u0001"}, d2 = {"Lnv6/p;", "", "", "buttonImageUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "cardId", ce.f26391f, "grouponId", "q", "Lcom/bytedance/locallife/host/model/UrlModel;", "imageUrl", "Lcom/bytedance/locallife/host/model/UrlModel;", "s", "()Lcom/bytedance/locallife/host/model/UrlModel;", "title", "getTitle", "topText", "K", "source", "G", "price", "B", NativeDownloadModel.JsonKey.WEB_URL, "M", "lynxUrl", BaseSwitches.V, "Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "flashSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "p", "()Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "tipsImageUrl", "J", "", "stock", FaceService.neutralLabel, "()J", "buttonText", "e", "", "liveCardType", "Ljava/lang/Integer;", "t", "()Ljava/lang/Integer;", "Lcom/bytedance/locallife/live/model/GroupPurchaseCardNearStoreInfo;", "nearStore", "Lcom/bytedance/locallife/live/model/GroupPurchaseCardNearStoreInfo;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "()Lcom/bytedance/locallife/live/model/GroupPurchaseCardNearStoreInfo;", "placeOrderUrl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "soldStartTime", FaceService.girlLabel, "soldEndTime", ExifInterface.LONGITUDE_EAST, "productType", "I", "D", "()I", "setProductType", "(I)V", "productBizline", "C", "setProductBizline", "consumptionTimes", "l", "setConsumptionTimes", "cardTypeName", "getCardTypeName", "setCardTypeName", "(Ljava/lang/String;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "displayControl", "Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "m", "()Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "setDisplayControl", "(Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;)V", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/TicketInfo;", "tickets", "Ljava/util/List;", "()Ljava/util/List;", "setTickets", "(Ljava/util/List;)V", "cecPoiInfo", "h", "setCecPoiInfo", "Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "minusSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "y", "()Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "setMinusSale", "(Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;)V", "enterType", "o", "setEnterType", "(Ljava/lang/Integer;)V", "authType", "b", "setAuthType", "merchantAccountId", "Ljava/lang/Long;", "x", "()Ljava/lang/Long;", "setMerchantAccountId", "(Ljava/lang/Long;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "memberInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "w", "()Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "setMemberInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;)V", "Lcom/bytedance/locallife/live/model/CardAtmosphere;", "cardAtmosphere", "Lcom/bytedance/locallife/live/model/CardAtmosphere;", "f", "()Lcom/bytedance/locallife/live/model/CardAtmosphere;", "N", "(Lcom/bytedance/locallife/live/model/CardAtmosphere;)V", "", "trackParams", "Ljava/util/Map;", "L", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "commonSession", ce.f26396k, "setCommonSession", "Lcom/bytedance/locallife/live/model/Lottery;", "lottery", "Lcom/bytedance/locallife/live/model/Lottery;", "u", "()Lcom/bytedance/locallife/live/model/Lottery;", "setLottery", "(Lcom/bytedance/locallife/live/model/Lottery;)V", "Lnv6/a;", "activityConfig", "Lnv6/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/a;", "imageTagUrl", "r", "setImageTagUrl", "", "isMultidayTour", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "channelSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "setChannelSale", "(Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "drawTicketParams", "Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "setDrawTicketParams", "(Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;)V", "Lnv6/g;", "attrInfoList", "getAttrInfoList", "", "bottomPriceBtnMaxWidth", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "Lnv6/i;", "coinInfo", "Lnv6/i;", ce.f26395j, "()Lnv6/i;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("activity_config")
    private final a activityConfig;

    @SerializedName("biz_attrs")
    private final List<g> attrInfoList;

    @SerializedName(BdpAppEventConstant.PARAMS_AUTH_TYPE)
    private Integer authType;

    @SerializedName("bottom_price_btn_max_width")
    private final Double bottomPriceBtnMaxWidth;

    @SerializedName("button_image_url")
    private final String buttonImageUrl;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("card_atmosphere")
    private CardAtmosphere cardAtmosphere;

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("card_type_name")
    private String cardTypeName;

    @SerializedName("cec_poi_info")
    private String cecPoiInfo;

    @SerializedName("channel_sale")
    private GroupPurchaseChannelSale channelSale;

    @SerializedName("product_reward_task_info")
    private final i coinInfo;

    @SerializedName("common_session")
    private Map<String, ? extends Object> commonSession;

    @SerializedName("consumption_times")
    private int consumptionTimes;

    @SerializedName("display_control")
    private DisplayControl displayControl;

    @SerializedName("draw_ticket_params")
    private DrawTicketParamsInfo drawTicketParams;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE)
    private Integer enterType;

    @SerializedName("flash_sale")
    private final GroupPurchaseFlashSale flashSale;

    @SerializedName("groupon_id")
    private final String grouponId;

    @SerializedName("image_tag_url")
    private String imageTagUrl;

    @SerializedName("image_url")
    private final UrlModel imageUrl;

    @SerializedName("is_multiday_tour")
    private final Boolean isMultidayTour;

    @SerializedName("live_card_type")
    private final Integer liveCardType;

    @SerializedName("lottery")
    private Lottery lottery;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("member_info")
    private MemberInfo memberInfo;

    @SerializedName("account_id")
    private Long merchantAccountId;

    @SerializedName("minus_sale")
    private GroupPurchaseMinusSale minusSale;

    @SerializedName("near_store")
    private final GroupPurchaseCardNearStoreInfo nearStore;

    @SerializedName("place_order_url")
    private final String placeOrderUrl;

    @SerializedName("price")
    private final String price;

    @SerializedName("product_bizline")
    private int productBizline;

    @SerializedName("product_type")
    private int productType;

    @SerializedName("sold_end_time")
    private final long soldEndTime;

    @SerializedName("sold_start_time")
    private final long soldStartTime;

    @SerializedName("source")
    private final String source;

    @SerializedName("stock")
    private final long stock;

    @SerializedName("ticket")
    private List<TicketInfo> tickets;

    @SerializedName("tips_image_url")
    private final String tipsImageUrl;

    @SerializedName("title")
    private final String title;

    @SerializedName("top_text")
    private final String topText;

    @SerializedName("track_params")
    private Map<String, ? extends Object> trackParams;

    @SerializedName("web_url")
    private final String webUrl;

    public p() {
        this.buttonImageUrl = null;
        this.cardId = null;
        this.grouponId = null;
        this.imageUrl = null;
        this.title = null;
        this.topText = null;
        this.source = null;
        this.price = null;
        this.webUrl = null;
        this.lynxUrl = null;
        this.flashSale = null;
        this.tipsImageUrl = null;
        this.stock = 0;
        this.buttonText = null;
        this.liveCardType = 0;
        this.nearStore = null;
        this.placeOrderUrl = null;
        this.soldStartTime = 0;
        this.soldEndTime = 0;
        this.productType = 0;
        this.productBizline = 0;
        this.consumptionTimes = 0;
        this.cardTypeName = null;
        this.displayControl = null;
        this.tickets = null;
        this.cecPoiInfo = null;
        this.minusSale = null;
        this.enterType = 1;
        this.authType = 0;
        this.merchantAccountId = null;
        this.memberInfo = null;
        this.cardAtmosphere = null;
        this.trackParams = null;
        this.commonSession = null;
        this.lottery = null;
        this.activityConfig = null;
        this.imageTagUrl = null;
        this.isMultidayTour = null;
        this.channelSale = null;
        this.drawTicketParams = null;
        this.attrInfoList = null;
        this.bottomPriceBtnMaxWidth = null;
        this.coinInfo = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.buttonImageUrl, r101.buttonImageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.grouponId, r101.grouponId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.topText, r101.topText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.flashSale, r101.flashSale) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tipsImageUrl, r101.tipsImageUrl) == true) goto L45;
        return false;
    L45:
        if (this.stock == r101.stock) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.liveCardType, r101.liveCardType) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.nearStore, r101.nearStore) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.placeOrderUrl, r101.placeOrderUrl) == true) goto L60;
        return false;
    L60:
        if (this.soldStartTime == r101.soldStartTime) goto L63;
        return false;
    L63:
        if (this.soldEndTime == r101.soldEndTime) goto L66;
        return false;
    L66:
        if (this.productType == r101.productType) goto L69;
        return false;
    L69:
        if (this.productBizline == r101.productBizline) goto L72;
        return false;
    L72:
        if (this.consumptionTimes == r101.consumptionTimes) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.cardTypeName, r101.cardTypeName) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.displayControl, r101.displayControl) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.tickets, r101.tickets) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.cecPoiInfo, r101.cecPoiInfo) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.minusSale, r101.minusSale) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.enterType, r101.enterType) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.authType, r101.authType) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.merchantAccountId, r101.merchantAccountId) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.memberInfo, r101.memberInfo) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.cardAtmosphere, r101.cardAtmosphere) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.commonSession, r101.commonSession) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.lottery, r101.lottery) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.activityConfig, r101.activityConfig) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.imageTagUrl, r101.imageTagUrl) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.isMultidayTour, r101.isMultidayTour) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.channelSale, r101.channelSale) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.drawTicketParams, r101.drawTicketParams) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.attrInfoList, r101.attrInfoList) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.bottomPriceBtnMaxWidth, r101.bottomPriceBtnMaxWidth) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.coinInfo, r101.coinInfo) == true) goto L137;
        return false;
    L137:
        return true;
    }

    public final int hashCode() {
        String r100 = this.buttonImageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.cardId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.grouponId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UrlModel r110 = this.imageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.topText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.source;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.price;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.webUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.lynxUrl;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        GroupPurchaseFlashSale r131 = this.flashSale;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.tipsImageUrl;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        long r137 = this.stock;
        int r138 = (r136 + ((int) (r137 ^ (r137 >>> 32)))) * 31;
        String r139 = this.buttonText;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.liveCardType;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        GroupPurchaseCardNearStoreInfo r145 = this.nearStore;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        String r148 = this.placeOrderUrl;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        long r151 = this.soldStartTime;
        int r152 = (r150 + ((int) (r151 ^ (r151 >>> 32)))) * 31;
        long r153 = this.soldEndTime;
        int r154 = (((((((r152 + ((int) (r153 ^ (r153 >>> 32)))) * 31) + this.productType) * 31) + this.productBizline) * 31) + this.consumptionTimes) * 31;
        String r155 = this.cardTypeName;
        if (r155 != null) goto L69;
        int r156 = 0;
    L70:
        int r157 = (r154 + r156) * 31;
        DisplayControl r158 = this.displayControl;
        if (r158 != null) goto L73;
        int r159 = 0;
    L74:
        int r160 = (r157 + r159) * 31;
        List<TicketInfo> r161 = this.tickets;
        if (r161 != null) goto L77;
        int r162 = 0;
    L78:
        int r163 = (r160 + r162) * 31;
        String r164 = this.cecPoiInfo;
        if (r164 != null) goto L81;
        int r165 = 0;
    L82:
        int r166 = (r163 + r165) * 31;
        GroupPurchaseMinusSale r167 = this.minusSale;
        if (r167 != null) goto L85;
        int r168 = 0;
    L86:
        int r169 = (r166 + r168) * 31;
        Integer r170 = this.enterType;
        if (r170 != null) goto L89;
        int r171 = 0;
    L90:
        int r172 = (r169 + r171) * 31;
        Integer r173 = this.authType;
        if (r173 != null) goto L93;
        int r174 = 0;
    L94:
        int r175 = (r172 + r174) * 31;
        Long r176 = this.merchantAccountId;
        if (r176 != null) goto L97;
        int r177 = 0;
    L98:
        int r178 = (r175 + r177) * 31;
        MemberInfo r179 = this.memberInfo;
        if (r179 != null) goto L101;
        int r180 = 0;
    L102:
        int r181 = (r178 + r180) * 31;
        CardAtmosphere r182 = this.cardAtmosphere;
        if (r182 != null) goto L105;
        int r183 = 0;
    L106:
        int r184 = (r181 + r183) * 31;
        Map<String, ? extends Object> r185 = this.trackParams;
        if (r185 != null) goto L109;
        int r186 = 0;
    L110:
        int r187 = (r184 + r186) * 31;
        Map<String, ? extends Object> r188 = this.commonSession;
        if (r188 != null) goto L113;
        int r189 = 0;
    L114:
        int r190 = (r187 + r189) * 31;
        Lottery r191 = this.lottery;
        if (r191 != null) goto L117;
        int r192 = 0;
    L118:
        int r193 = (r190 + r192) * 31;
        a r194 = this.activityConfig;
        if (r194 != null) goto L121;
        int r195 = 0;
    L122:
        int r196 = (r193 + r195) * 31;
        String r197 = this.imageTagUrl;
        if (r197 != null) goto L125;
        int r198 = 0;
    L126:
        int r199 = (r196 + r198) * 31;
        Boolean r200 = this.isMultidayTour;
        if (r200 != null) goto L129;
        int r201 = 0;
    L130:
        int r202 = (r199 + r201) * 31;
        GroupPurchaseChannelSale r203 = this.channelSale;
        if (r203 != null) goto L133;
        int r204 = 0;
    L134:
        int r205 = (r202 + r204) * 31;
        DrawTicketParamsInfo r206 = this.drawTicketParams;
        if (r206 != null) goto L137;
        int r207 = 0;
    L138:
        int r208 = (r205 + r207) * 31;
        List<g> r209 = this.attrInfoList;
        if (r209 != null) goto L141;
        int r210 = 0;
    L142:
        int r211 = (r208 + r210) * 31;
        Double r212 = this.bottomPriceBtnMaxWidth;
        if (r212 != null) goto L145;
        int r213 = 0;
    L146:
        int r214 = (r211 + r213) * 31;
        i r215 = this.coinInfo;
        if (r215 == null) goto L151;
        r101 = r215.hashCode();
    L151:
        return r214 + r101;
    L145:
        r213 = r212.hashCode();
        goto L146
    L141:
        r210 = r209.hashCode();
        goto L142
    L137:
        r207 = r206.hashCode();
        goto L138
    L133:
        r204 = r203.hashCode();
        goto L134
    L129:
        r201 = r200.hashCode();
        goto L130
    L125:
        r198 = r197.hashCode();
        goto L126
    L121:
        r195 = r194.hashCode();
        goto L122
    L117:
        r192 = r191.hashCode();
        goto L118
    L113:
        r189 = r188.hashCode();
        goto L114
    L109:
        r186 = r185.hashCode();
        goto L110
    L105:
        r183 = r182.hashCode();
        goto L106
    L101:
        r180 = r179.hashCode();
        goto L102
    L97:
        r177 = r176.hashCode();
        goto L98
    L93:
        r174 = r173.hashCode();
        goto L94
    L89:
        r171 = r170.hashCode();
        goto L90
    L85:
        r168 = r167.hashCode();
        goto L86
    L81:
        r165 = r164.hashCode();
        goto L82
    L77:
        r162 = r161.hashCode();
        goto L78
    L73:
        r159 = r158.hashCode();
        goto L74
    L69:
        r156 = r155.hashCode();
        goto L70
    L65:
        r149 = r148.hashCode();
        goto L66
    L61:
        r146 = r145.hashCode();
        goto L62
    L57:
        r143 = r142.hashCode();
        goto L58
    L53:
        r140 = r139.hashCode();
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
        return "GroupPurchaseCardRawData(buttonImageUrl=" + this.buttonImageUrl + ", cardId=" + this.cardId + ", grouponId=" + this.grouponId + ", imageUrl=" + this.imageUrl + ", title=" + this.title + ", topText=" + this.topText + ", source=" + this.source + ", price=" + this.price + ", webUrl=" + this.webUrl + ", lynxUrl=" + this.lynxUrl + ", flashSale=" + this.flashSale + ", tipsImageUrl=" + this.tipsImageUrl + ", stock=" + this.stock + ", buttonText=" + this.buttonText + ", liveCardType=" + this.liveCardType + ", nearStore=" + this.nearStore + ", placeOrderUrl=" + this.placeOrderUrl + ", soldStartTime=" + this.soldStartTime + ", soldEndTime=" + this.soldEndTime + ", productType=" + this.productType + ", productBizline=" + this.productBizline + ", consumptionTimes=" + this.consumptionTimes + ", cardTypeName=" + this.cardTypeName + ", displayControl=" + this.displayControl + ", tickets=" + this.tickets + ", cecPoiInfo=" + this.cecPoiInfo + ", minusSale=" + this.minusSale + ", enterType=" + this.enterType + ", authType=" + this.authType + ", merchantAccountId=" + this.merchantAccountId + ", memberInfo=" + this.memberInfo + ", cardAtmosphere=" + this.cardAtmosphere + ", trackParams=" + this.trackParams + ", commonSession=" + this.commonSession + ", lottery=" + this.lottery + ", activityConfig=" + this.activityConfig + ", imageTagUrl=" + this.imageTagUrl + ", isMultidayTour=" + this.isMultidayTour + ", channelSale=" + this.channelSale + ", drawTicketParams=" + this.drawTicketParams + ", attrInfoList=" + this.attrInfoList + ", bottomPriceBtnMaxWidth=" + this.bottomPriceBtnMaxWidth + ", coinInfo=" + this.coinInfo + ')';
    }

    public final String A() {
        return this.placeOrderUrl;
    }

    public final String B() {
        return this.price;
    }

    public final int C() {
        return this.productBizline;
    }

    public final int D() {
        return this.productType;
    }

    public final long E() {
        return this.soldEndTime;
    }

    public final long F() {
        return this.soldStartTime;
    }

    public final String G() {
        return this.source;
    }

    public final long H() {
        return this.stock;
    }

    public final List<TicketInfo> I() {
        return this.tickets;
    }

    public final String J() {
        return this.tipsImageUrl;
    }

    public final String K() {
        return this.topText;
    }

    public final Map<String, Object> L() {
        return this.trackParams;
    }

    public final String M() {
        return this.webUrl;
    }

    public final a a() {
        return this.activityConfig;
    }

    public final Integer b() {
        return this.authType;
    }

    public final Double c() {
        return this.bottomPriceBtnMaxWidth;
    }

    public final String d() {
        return this.buttonImageUrl;
    }

    public final String e() {
        return this.buttonText;
    }

    public final CardAtmosphere f() {
        return this.cardAtmosphere;
    }

    public final String g() {
        return this.cardId;
    }

    public final String h() {
        return this.cecPoiInfo;
    }

    public final GroupPurchaseChannelSale i() {
        return this.channelSale;
    }

    public final i j() {
        return this.coinInfo;
    }

    public final Map<String, Object> k() {
        return this.commonSession;
    }

    public final int l() {
        return this.consumptionTimes;
    }

    public final DisplayControl m() {
        return this.displayControl;
    }

    public final DrawTicketParamsInfo n() {
        return this.drawTicketParams;
    }

    public final Integer o() {
        return this.enterType;
    }

    public final GroupPurchaseFlashSale p() {
        return this.flashSale;
    }

    public final String q() {
        return this.grouponId;
    }

    public final String r() {
        return this.imageTagUrl;
    }

    public final UrlModel s() {
        return this.imageUrl;
    }

    public final Integer t() {
        return this.liveCardType;
    }

    public final Lottery u() {
        return this.lottery;
    }

    public final String v() {
        return this.lynxUrl;
    }

    public final MemberInfo w() {
        return this.memberInfo;
    }

    public final Long x() {
        return this.merchantAccountId;
    }

    public final GroupPurchaseMinusSale y() {
        return this.minusSale;
    }

    public final GroupPurchaseCardNearStoreInfo z() {
        return this.nearStore;
    }

    public final void N(CardAtmosphere r100) {
        this.cardAtmosphere = r100;
    }
}
