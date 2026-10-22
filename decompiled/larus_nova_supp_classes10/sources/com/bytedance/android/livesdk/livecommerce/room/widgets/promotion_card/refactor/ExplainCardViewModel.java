package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.model.response.PromotionPriceInfo;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.BaseViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.ECLiveCardPanelType;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.bytedance.android.livesdk.livecommerce.skin.ECLivePopCardSkinUIHelper;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 È\u00012\u00020\u0001:\u0002É\u0001BU\u0012\b\u0010¨\u0001\u001a\u00030§\u0001\u0012\b\u0010«\u0001\u001a\u00030ª\u0001\u0012\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010¯\u0001\u0012\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001\u0012\b\u0010¸\u0001\u001a\u00030·\u0001\u0012\b\u0010½\u0001\u001a\u00030¼\u0001\u0012\b\u0010Â\u0001\u001a\u00030Á\u0001¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002Jr\u0010\u001e\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJh\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJz\u0010-\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010!\u001a\u00020\n2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010(2\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\u00060*J$\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\b2\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00060*J,\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u00060*J$\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ$\u00106\u001a\u0004\u0018\u0001042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u00109\u001a\u0002082\u0006\u00107\u001a\u00020+J\u000e\u0010:\u001a\u0002082\u0006\u00107\u001a\u00020+J\"\u00109\u001a\u0002082\u0006\u00107\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0006\u0010;\u001a\u00020\nJ\u0006\u0010<\u001a\u00020\nJ\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\bJ\u0016\u0010A\u001a\u00020\u00062\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010?J\u001a\u0010D\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010C\u001a\u0004\u0018\u00010BJ\b\u0010E\u001a\u00020\u0006H\u0014R.\u0010H\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MRD\u0010N\u001a$\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0(\u0018\u00010(\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001f\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0T8\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR#\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Y0T8\u0006¢\u0006\f\n\u0004\bZ\u0010V\u001a\u0004\b[\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0018\u0010b\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010]R\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0017\u0010f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\"\u0010j\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010g\u001a\u0004\bk\u0010i\"\u0004\bl\u0010mR#\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Y0T8\u0006¢\u0006\f\n\u0004\bn\u0010V\u001a\u0004\bo\u0010XR$\u0010p\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR#\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Y0T8\u0006¢\u0006\f\n\u0004\bx\u0010V\u001a\u0004\by\u0010XR(\u0010{\u001a\b\u0012\u0004\u0012\u00020z0T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010V\u001a\u0004\b|\u0010X\"\u0004\b}\u0010~R0\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Y0T8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010V\u001a\u0005\b\u0080\u0001\u0010X\"\u0005\b\u0081\u0001\u0010~R2\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0Y0T8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010V\u001a\u0005\b\u0083\u0001\u0010X\"\u0005\b\u0084\u0001\u0010~R,\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\b0T8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010V\u001a\u0005\b\u0086\u0001\u0010X\"\u0005\b\u0087\u0001\u0010~R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R&\u0010\u008f\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010g\u001a\u0005\b\u008f\u0001\u0010i\"\u0005\b\u0090\u0001\u0010mR,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R!\u0010\u009d\u0001\u001a\u00030\u0098\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R,\u0010¥\u0001\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\n0¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010¨\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001d\u0010«\u0001\u001a\u00030ª\u00018\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001f\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0006¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001R\u001a\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001d\u0010¸\u0001\u001a\u00030·\u00018\u0006¢\u0006\u0010\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001R\u001d\u0010½\u0001\u001a\u00030¼\u00018\u0006¢\u0006\u0010\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001R\u001d\u0010Â\u0001\u001a\u00030Á\u00018\u0006¢\u0006\u0010\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001¨\u0006Ê\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/ExplainCardViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/room/quick/BaseViewModel;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/btm/api/model/d;", "btmModel", "", "showLivePromotionListOnClickCard", "", "btmPageId", "", "isPreviewCard", "buildExplainParams", "buildAuctionV2ExplainParams", "Ljf/c;", "getDispatcherListener", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/a;", "getCardShowStrategy", "vm", "clickArea", "skipCheck", "btm", "Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "btmItemBuilder", "Landroid/view/View;", "view", "Lil2/a;", "actionTracker", "Lkotlin/Function0;", "reserveListener", "clickCard", "clickAuctionV2Card", "action", "isFirstEnterRoom", "Lkotlin/Pair;", "", "delayPair", "Lcom/bytedance/android/ec/model/response/s;", "productInfo", "forcePath", "", "extraRequestParams", "Lkotlin/Function1;", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "receiver", "queryPopPromotion", "promotionId", "Lcom/bytedance/android/ec/model/promotion/ECUICampaign;", "queryPromotionCampaign", "productId", "Lcom/bytedance/android/ec/model/response/PromotionPriceInfo;", "queryPromotionByGetApi", "Ljf/d;", "getNewJumpDispatcher", "getAuctionV2NewJumpDispatcher", "promotion", "Lcom/bytedance/android/ec/common/api/jump/model/g;", "buildPromotionParams", "buildAuctionV2PromotionParams", "isFromLive", "isFromStore", "noticeText", "postNoFilterNoticeEvent", "", "cardThemes", "initCardSkin", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "data", "onHotSaleChanged", "onCleared", "Lcf/n;", "value", "openSchemaProxy", "Lcf/n;", "getOpenSchemaProxy", "()Lcf/n;", "setOpenSchemaProxy", "(Lcf/n;)V", "eventPassthroughParams", "Lkotlin/jvm/functions/Function0;", "getEventPassthroughParams", "()Lkotlin/jvm/functions/Function0;", "setEventPassthroughParams", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "promotionState", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getPromotionState", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lbk2/a;", "clickCloseAction", "getClickCloseAction", "newJumpHelper", "Ljf/d;", "Lpk2/b;", "explainParams", "Lpk2/b;", "auctionV2ExplainParams", "newAuctionV2JumpHelper", "Lpk2/c;", "repository", "Lpk2/c;", "needShowBtnAnimation", "Z", "getNeedShowBtnAnimation", "()Z", "hasShowBtnAnimation", "getHasShowBtnAnimation", "setHasShowBtnAnimation", "(Z)V", "showCardAction", "getShowCardAction", "lastShowedPromotionId", "Ljava/lang/String;", "getLastShowedPromotionId", "()Ljava/lang/String;", "setLastShowedPromotionId", "(Ljava/lang/String;)V", "lastClickTime", "J", "showBeforeAnimAction", "getShowBeforeAnimAction", "Lpk2/d;", "cardExtendInfoState", "getCardExtendInfoState", "setCardExtendInfoState", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "showAfterAnimAction", "getShowAfterAnimAction", "setShowAfterAnimAction", "hotAtmosphereUpdateAction", "getHotAtmosphereUpdateAction", "setHotAtmosphereUpdateAction", "noFilterNoticeLiveData", "getNoFilterNoticeLiveData", "setNoFilterNoticeLiveData", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "cardCallback", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "getCardCallback", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "setCardCallback", "(Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;)V", "isEnterRoom", "setEnterRoom", "Lcom/bytedance/android/livesdk/livecommerce/skin/g;", "cardSkinHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/g;", "getCardSkinHelper", "()Lcom/bytedance/android/livesdk/livecommerce/skin/g;", "setCardSkinHelper", "(Lcom/bytedance/android/livesdk/livecommerce/skin/g;)V", "Lcom/bytedance/android/livesdk/livecommerce/largemode/b;", "largeModeAdapter$delegate", "Lkotlin/Lazy;", "getLargeModeAdapter", "()Lcom/bytedance/android/livesdk/livecommerce/largemode/b;", "largeModeAdapter", "", "openListFrequency", "I", "Ljava/lang/Runnable;", "openListRunnable", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "clickExplainCardEnterRoom", "Lkotlin/jvm/functions/Function2;", "Lcf/i;", "getExplainPromotion", "Lcf/i;", "Lgf/a;", "from", "Lgf/a;", "getFrom", "()Lgf/a;", "Lml/b;", "liveRoomInfo", "Lml/b;", "getLiveRoomInfo", "()Lml/b;", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "liveRoomParams", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcf/c;", "btmInfo", "Lcf/c;", "getBtmInfo", "()Lcf/c;", "Ljf/b;", "ecomEntranceForm", "Ljf/b;", "getEcomEntranceForm", "()Ljf/b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "roomContextController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "getRoomContextController", "()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "<init>", "(Lcf/i;Lgf/a;Lml/b;Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;Lcf/c;Ljf/b;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardViewModel extends BaseViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_CLICK_DURATION = 1500;
    private pk2.b auctionV2ExplainParams;
    private final cf.c btmInfo;
    private r cardCallback;
    private QLiveData<pk2.d> cardExtendInfoState;
    private com.bytedance.android.livesdk.livecommerce.skin.g cardSkinHelper;
    private final QLiveData<bk2.a<Unit>> clickCloseAction;
    private final Function2<String, com.bytedance.android.btm.api.model.d, Boolean> clickExplainCardEnterRoom;
    private final jf.b ecomEntranceForm;
    private Function0<? extends Map<String, ? extends Map<String, String>>> eventPassthroughParams;
    private pk2.b explainParams;
    private final gf.a from;
    private final cf.i getExplainPromotion;
    private boolean hasShowBtnAnimation;
    private QLiveData<bk2.a<ECHotAtmosphere>> hotAtmosphereUpdateAction;
    private boolean isEnterRoom;
    private final Lazy largeModeAdapter$delegate;
    private long lastClickTime;
    private String lastShowedPromotionId;
    private final ml.b liveRoomInfo;
    private final LiveRoomParams liveRoomParams;
    private final boolean needShowBtnAnimation;
    private jf.d newAuctionV2JumpHelper;
    private jf.d newJumpHelper;
    private QLiveData<String> noFilterNoticeLiveData;
    private int openListFrequency;
    private Runnable openListRunnable;
    private cf.n openSchemaProxy;
    private final QLiveData<ECUIPromotion> promotionState;
    private final pk2.c repository;
    private final RoomContextController roomContextController;
    private QLiveData<bk2.a<Unit>> showAfterAnimAction;
    private final QLiveData<bk2.a<Unit>> showBeforeAnimAction;
    private final QLiveData<bk2.a<Unit>> showCardAction;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(((pk2.e) r2).a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.invoke(null);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            xi2.k r5 = (xi2.k) r4;
            if (r5 == null) goto L11;
            List<ECPromotionCampaign> r0 = r5.campaignList;
            if (r0 == null) goto L11;
            ECPromotionCampaign r1 = (ECPromotionCampaign) CollectionsKt.firstOrNull(r0);
            if (r1 == null) goto L11;
            if (com.bytedance.android.livesdk.livecommerce.utils.k.a(r1, r5.serverTime) == false) goto L11;
            ECUICampaign r6 = ECUICampaign.convertCampaign(r1, r5.serverTime);
        L12:
            this.a.invoke(r6);
            return;
        L11:
            r6 = null;
            goto L12
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.invoke(null);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ com.bytedance.android.btm.api.model.d c;

        public f(ExplainCardViewModel r1, Context r2, com.bytedance.android.btm.api.model.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            PromotionListController.N(this.a.getRoomContextController().A().r, this.b, "live_pop_card_explore", new si2.b("live_pop_card_explore", false, false), new PromotionListController.c(null, false, null, null, BtmSDK.INSTANCE.createJumpSourceBtmToken(this.c), null, null, null, 239), false, new wj2.g.c(true), null, null, 208);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel$getDispatcherListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03261 implements jf.c {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ String b;

        public final void b() {
        }

        public final void a() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r0 = ExplainCardViewModel.access$getCardShowStrategy(this.a);
            if (r0 == null) goto L6;
            r0.m(ECLiveCardPanelType.GOODS_DETAIL);
            return;
        }

        public final void h() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r0 = ExplainCardViewModel.access$getCardShowStrategy(this.a);
            if (r0 == null) goto L6;
            r0.m(ECLiveCardPanelType.ORDER);
            return;
        }

        public final void l() {
            int r0 = ECSdk.a;
            cf.l r1 = (cf.l) ECSdk.a(cf.l.class);
            if (r1 == null) goto L6;
            r1.showInteractionAndEnterRoom(this.a.getRoomContextController().B());
            return;
        }

        public final void m() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r0 = ExplainCardViewModel.access$getCardShowStrategy(this.a);
            if (r0 == null) goto L6;
            r0.m(ECLiveCardPanelType.SKU);
            return;
        }

        public final boolean k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            cf.n r0 = this.a.getOpenSchemaProxy();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.open(r2) != true) goto L7;
            return true;
        }

        public C03261(ExplainCardViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void d(Context r2, com.bytedance.android.btm.api.model.d r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            ExplainCardViewModel.access$showLivePromotionListOnClickCard(this.a, r2, r3);
        }

        public final void e(Context r2, com.bytedance.android.btm.api.model.d r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            ExplainCardViewModel.access$showLivePromotionListOnClickCard(this.a, r2, r3);
        }

        public final void f(String r3, com.bytedance.android.ec.common.api.jump.model.g r4) {
            Intrinsics.checkNotNullParameter(r3, "clickArea");
            Intrinsics.checkNotNullParameter(r4, "promotionParams");
            if (Intrinsics.areEqual(r3, "button") == false) goto L14;
            PrefetchOrder r5 = r4.a.getPrefetchOrder();
            if (r5 != null) goto L7;
        L8:
            int r6 = ECSdk.a;
            IEShoppingService r7 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
            if (r7 == null) goto L16;
            sc3.c r8 = r7.getBuyNowService();
            if (r8 == null) goto L17;
            r8.l(r4.a, new tf3.l(null), BuyNowPrefetchType.CLICK);
            return;
        L17:
            return;
        L16:
            return;
        L7:
            if (r5.isFetchModel() != true) goto L8;
            return;
        }

        public final boolean i(String r2, com.bytedance.android.btm.api.model.d r3) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            return ((Boolean) ExplainCardViewModel.access$getClickExplainCardEnterRoom$p(this.a).invoke(r2, r3)).booleanValue();
        }

        public final Map<String, String> j(String r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r5, "eventName");
            Intrinsics.checkNotNullParameter(r6, "eventParams");
            HashMap r7 = new HashMap();
            Function0<Map<String, Map<String, String>>> r0 = this.a.getEventPassthroughParams();
            if (r0 == null) goto L5;
            Map r1 = (Map) r0.invoke();
        L6:
            if (r1 == null) goto L19;
            Map r2 = (Map) r1.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
            if (r2 == null) goto L13;
            Iterator r3 = r2.entrySet().iterator();
        L11:
            if (r3.hasNext() == false) goto L13;
            Map.Entry r4 = (Map.Entry) r3.next();
            r7.put((String) r4.getKey(), (String) r4.getValue());
        L13:
            Map r8 = (Map) r1.get(r5);
            if (r8 == null) goto L19;
            Iterator r9 = r8.entrySet().iterator();
        L17:
            if (r9.hasNext() == false) goto L19;
            Map.Entry r10 = (Map.Entry) r9.next();
            r7.put((String) r10.getKey(), (String) r10.getValue());
        L19:
            return r7;
        L5:
            r1 = null;
            goto L6
        }

        public final void n(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotionParams");
            jf.c.a.b(r2, r3);
        }

        public final boolean c(Context r2, com.bytedance.android.btm.api.model.d r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r4 == true) goto L7;
            ExplainCardViewModel.access$showLivePromotionListOnClickCard(this.a, r2, r3);
            return false;
        L7:
            return false;
        }

        public final void g(final String r3, ql.a r4, final BtmItemBuilder r5) {
            Intrinsics.checkNotNullParameter(r3, "clickArea");
            Intrinsics.checkNotNullParameter(r4, "promotion");
            UtilityKotlinExtentionsKt.f(this.a.getPromotionState().a(), this.a.getLiveRoomInfo(), new ExplainCardViewModel$getDispatcherListener$1$afterReportProductEvent$1(this, r3, r5));
        }
    }

    static {
        Companion = new a();
    }

    public final com.bytedance.android.livesdk.livecommerce.largemode.b getLargeModeAdapter() {
        return (com.bytedance.android.livesdk.livecommerce.largemode.b) this.largeModeAdapter$delegate.getValue();
    }

    private final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a getCardShowStrategy() {
        return this.roomContextController.A().q.j;
    }

    public final boolean isFromLive() {
        return this.from.a();
    }

    public final boolean isFromStore() {
        if (this.from.a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.quick.BaseViewModel
    public void onCleared() {
        super.onCleared();
        Runnable r0 = this.openListRunnable;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
        this.openListRunnable = null;
        return;
    }

    public final cf.c getBtmInfo() {
        return this.btmInfo;
    }

    public final r getCardCallback() {
        return this.cardCallback;
    }

    public final QLiveData<pk2.d> getCardExtendInfoState() {
        return this.cardExtendInfoState;
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.g getCardSkinHelper() {
        return this.cardSkinHelper;
    }

    public final QLiveData<bk2.a<Unit>> getClickCloseAction() {
        return this.clickCloseAction;
    }

    public final jf.b getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final Function0<Map<String, Map<String, String>>> getEventPassthroughParams() {
        return this.eventPassthroughParams;
    }

    public final gf.a getFrom() {
        return this.from;
    }

    public final boolean getHasShowBtnAnimation() {
        return this.hasShowBtnAnimation;
    }

    public final QLiveData<bk2.a<ECHotAtmosphere>> getHotAtmosphereUpdateAction() {
        return this.hotAtmosphereUpdateAction;
    }

    public final String getLastShowedPromotionId() {
        return this.lastShowedPromotionId;
    }

    public final ml.b getLiveRoomInfo() {
        return this.liveRoomInfo;
    }

    public final boolean getNeedShowBtnAnimation() {
        return this.needShowBtnAnimation;
    }

    public final QLiveData<String> getNoFilterNoticeLiveData() {
        return this.noFilterNoticeLiveData;
    }

    public final cf.n getOpenSchemaProxy() {
        return this.openSchemaProxy;
    }

    public final QLiveData<ECUIPromotion> getPromotionState() {
        return this.promotionState;
    }

    public final RoomContextController getRoomContextController() {
        return this.roomContextController;
    }

    public final QLiveData<bk2.a<Unit>> getShowAfterAnimAction() {
        return this.showAfterAnimAction;
    }

    public final QLiveData<bk2.a<Unit>> getShowBeforeAnimAction() {
        return this.showBeforeAnimAction;
    }

    public final QLiveData<bk2.a<Unit>> getShowCardAction() {
        return this.showCardAction;
    }

    public final boolean isEnterRoom() {
        return this.isEnterRoom;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a access$getCardShowStrategy(ExplainCardViewModel r0) {
        return r0.getCardShowStrategy();
    }

    public static final /* synthetic */ Function2 access$getClickExplainCardEnterRoom$p(ExplainCardViewModel r0) {
        return r0.clickExplainCardEnterRoom;
    }

    private final jf.c getDispatcherListener(String r2) {
        return new C03261(this, r2);
    }

    public final com.bytedance.android.ec.common.api.jump.model.g buildAuctionV2PromotionParams(ECUIPromotion r4) {
        Intrinsics.checkNotNullParameter(r4, "promotion");
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.auctionV2ExplainParams;
        if (r0 != null) goto L6;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        return r0.buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class), new com.bytedance.android.ec.common.api.jump.model.g.a(r4));
    }

    public final com.bytedance.android.ec.common.api.jump.model.g buildPromotionParams(ECUIPromotion r4) {
        Intrinsics.checkNotNullParameter(r4, "promotion");
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.explainParams;
        if (r0 != null) goto L6;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        return r0.buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class), new com.bytedance.android.ec.common.api.jump.model.g.a(r4));
    }

    public final void initCardSkin(List<String> r3) {
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.skin.g r0 = this.cardSkinHelper;
        if (r0 == null) goto L6;
        List<String> r1 = r0.b();
    L8:
        if ((!Intrinsics.areEqual(r3, r1)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        this.cardSkinHelper = new ECLivePopCardSkinUIHelper(r3);
        return;
    L15:
        return;
    L6:
        r1 = null;
        goto L8
    }

    public final void postNoFilterNoticeEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "noticeText");
        this.noFilterNoticeLiveData.e(r2);
    }

    public final void setCardCallback(r r1) {
        this.cardCallback = r1;
    }

    public final void setCardExtendInfoState(QLiveData<pk2.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardExtendInfoState = r2;
    }

    public final void setCardSkinHelper(com.bytedance.android.livesdk.livecommerce.skin.g r1) {
        this.cardSkinHelper = r1;
    }

    public final void setEnterRoom(boolean r1) {
        this.isEnterRoom = r1;
    }

    public final void setEventPassthroughParams(Function0<? extends Map<String, ? extends Map<String, String>>> r1) {
        this.eventPassthroughParams = r1;
    }

    public final void setHasShowBtnAnimation(boolean r1) {
        this.hasShowBtnAnimation = r1;
    }

    public final void setHotAtmosphereUpdateAction(QLiveData<bk2.a<ECHotAtmosphere>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hotAtmosphereUpdateAction = r2;
    }

    public final void setLastShowedPromotionId(String r1) {
        this.lastShowedPromotionId = r1;
    }

    public final void setNoFilterNoticeLiveData(QLiveData<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.noFilterNoticeLiveData = r2;
    }

    public final void setOpenSchemaProxy(cf.n r1) {
        this.openSchemaProxy = r1;
    }

    public final void setShowAfterAnimAction(QLiveData<bk2.a<Unit>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showAfterAnimAction = r2;
    }

    private final void buildAuctionV2ExplainParams(String r13, boolean r14) {
        if (this.auctionV2ExplainParams != null) goto L13;
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.liveRoomParams;
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        KClass r1 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class);
        jf.b.e r5 = jf.b.e.b;
        if (r14 == false) goto L10;
        jf.e.e r15 = jf.e.e.b;
    L11:
        this.auctionV2ExplainParams = (pk2.b) r0.buildParams(r1, new com.bytedance.android.ec.common.api.jump.model.f.a("c0.d0", r13, r5, r15, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(pk2.b.class), new pk2.b.a(this.from, null, new AnonymousClass1(this)));
        return;
    L10:
        r15 = jf.e.d.b;
        goto L11
    }

    private final void buildExplainParams(String r13, boolean r14) {
        if (this.explainParams != null) goto L13;
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.liveRoomParams;
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        KClass r1 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class);
        jf.b r5 = this.ecomEntranceForm;
        if (r14 == false) goto L10;
        jf.e.e r15 = jf.e.e.b;
    L11:
        this.explainParams = (pk2.b) r0.buildParams(r1, new com.bytedance.android.ec.common.api.jump.model.f.a("c0.d0", r13, r5, r15, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(pk2.b.class), new pk2.b.a(this.from, new C03251(this), new AnonymousClass2(this)));
        return;
    L10:
        r15 = jf.e.d.b;
        goto L11
    }

    private final void showLivePromotionListOnClickCard(Context r20, com.bytedance.android.btm.api.model.d r21) {
        if (r21 != null) goto L6;
        return;
    L6:
        if (this.roomContextController.A().t.U < 1) goto L9;
        return;
    L9:
        if (EComABUtils.enableLivePopCardOpenList() != 1) goto L15;
        int r2 = this.openListFrequency;
        if (r2 < 0) goto L13;
        if (r2 > 0) goto L13;
        return;
    L13:
        this.openListFrequency = r2 - 1;
        PromotionListController.N(this.roomContextController.A().r, r20, "live_pop_card_explore", new si2.b("live_pop_card_explore", false, false), new PromotionListController.c(null, false, null, null, BtmSDK.INSTANCE.createJumpSourceBtmToken(r21), null, null, null, 239), false, new wj2.g.c(false), null, null, 208);
        return;
    L15:
        if (EComABUtils.enableLivePopCardOpenList() != 2) goto L26;
        int r3 = this.openListFrequency;
        if (r3 < 0) goto L19;
        if (r3 > 0) goto L19;
        return;
    L19:
        this.openListFrequency = r3 - 1;
        Runnable r4 = this.openListRunnable;
        if (r4 == null) goto L22;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r4);
    L22:
        f r5 = new f(this, r20, r21);
        UtilityKotlinExtentionsKt.b.postDelayed(r5, EComABUtils.enableLivePopCardOpenListDelayTime());
        Unit r1 = Unit.INSTANCE;
        this.openListRunnable = r5;
        return;
    }

    public final void onHotSaleChanged(String r2, ECHotAtmosphere r3) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r0 = getCardShowStrategy();
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    public final void queryPromotionCampaign(String r3, Function1<? super ECUICampaign, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        Intrinsics.checkNotNullParameter(r4, "receiver");
        pk2.c r0 = this.repository;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "promotionIds");
        r0.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "promotionIds");
        bk2.c.a(bg4.b.c(Single.create(new qk2.c(r3))).subscribe(new d(r4), new e(r4)), this);
    }

    public static final /* synthetic */ void access$showLivePromotionListOnClickCard(ExplainCardViewModel r0, Context r1, com.bytedance.android.btm.api.model.d r2) {
        r0.showLivePromotionListOnClickCard(r1, r2);
    }

    public final com.bytedance.android.ec.common.api.jump.model.g buildPromotionParams(ECUIPromotion r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        buildExplainParams(r3, r4);
        com.bytedance.android.ec.common.api.jump.model.b r5 = this.explainParams;
        if (r5 != null) goto L6;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        return r5.buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class), new com.bytedance.android.ec.common.api.jump.model.g.a(r2));
    }

    public final jf.d getAuctionV2NewJumpDispatcher(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.newAuctionV2JumpHelper != null) goto L6;
        buildAuctionV2ExplainParams(r3, r4);
        fi2.c.a r5 = fi2.c.a;
        this.newAuctionV2JumpHelper = fi2.c.b(this, getDispatcherListener(r3), 4);
    L6:
        return this.newAuctionV2JumpHelper;
    }

    public final jf.d getNewJumpDispatcher(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.newJumpHelper != null) goto L6;
        buildExplainParams(r3, r4);
        fi2.c.a r5 = fi2.c.a;
        this.newJumpHelper = fi2.c.b(this, getDispatcherListener(r3), 4);
    L6:
        return this.newJumpHelper;
    }

    public final void queryPromotionByGetApi(String r11, String r12, Function1<? super PromotionPriceInfo, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "productId");
        Intrinsics.checkNotNullParameter(r12, "promotionId");
        Intrinsics.checkNotNullParameter(r13, "receiver");
        ml.b r2 = this.liveRoomInfo;
        if ((r2 instanceof com.bytedance.android.livesdk.livecommerce.room.model.e) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.room.model.e r7 = (com.bytedance.android.livesdk.livecommerce.room.model.e) r2;
        if (r7 == null) goto L9;
        pk2.c r3 = this.repository;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "roomInfo");
        Intrinsics.checkNotNullParameter(r11, "productId");
        Intrinsics.checkNotNullParameter(r12, "promotionId");
        r3.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "roomInfo");
        Intrinsics.checkNotNullParameter(r11, "productId");
        Intrinsics.checkNotNullParameter(r12, "promotionId");
        String r6 = r7.roomId();
        bk2.c.a(bg4.b.c(Single.create(new qk2.b(r7.c(), r7.d(), r6, r7, r11, r12))).subscribe(new b(r13), new c(r13)), this);
        return;
    }

    public static /* synthetic */ void buildAuctionV2ExplainParams$default(ExplainCardViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.buildAuctionV2ExplainParams(r1, r2);
    }

    public static /* synthetic */ void buildExplainParams$default(ExplainCardViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.buildExplainParams(r1, r2);
    }

    public static /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g buildPromotionParams$default(ExplainCardViewModel r0, ECUIPromotion r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.buildPromotionParams(r1, r2, r3);
    }

    public static /* synthetic */ jf.d getAuctionV2NewJumpDispatcher$default(ExplainCardViewModel r0, Context r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.getAuctionV2NewJumpDispatcher(r1, r2, r3);
    }

    public static /* synthetic */ jf.d getNewJumpDispatcher$default(ExplainCardViewModel r0, Context r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.getNewJumpDispatcher(r1, r2, r3);
    }

    public ExplainCardViewModel(cf.i r3, gf.a r4, ml.b r5, LiveRoomParams r6, cf.c r7, jf.b r8, RoomContextController r9) {
        Intrinsics.checkNotNullParameter(r3, "getExplainPromotion");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r7, "btmInfo");
        Intrinsics.checkNotNullParameter(r8, "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r9, "roomContextController");
        super(null, 1, null);
        this.getExplainPromotion = r3;
        this.from = r4;
        this.liveRoomInfo = r5;
        this.liveRoomParams = r6;
        this.btmInfo = r7;
        this.ecomEntranceForm = r8;
        this.roomContextController = r9;
        boolean r10 = t.i;
        if (r10 == false) goto L5;
        QLiveData<ECUIPromotion> r11 = new bk2.e();
    L6:
        this.promotionState = r11;
        this.clickCloseAction = new QLiveData();
        this.repository = new pk2.c();
        this.needShowBtnAnimation = q.a;
        this.showCardAction = new QLiveData();
        if (r10 == false) goto L9;
        QLiveData<bk2.a<Unit>> r12 = new bk2.e();
    L10:
        this.showBeforeAnimAction = r12;
        this.cardExtendInfoState = new QLiveData();
        if (r10 == false) goto L13;
        QLiveData<bk2.a<Unit>> r13 = new bk2.e();
    L14:
        this.showAfterAnimAction = r13;
        this.hotAtmosphereUpdateAction = new QLiveData();
        this.noFilterNoticeLiveData = new QLiveData();
        this.isEnterRoom = true;
        this.largeModeAdapter$delegate = LazyKt.lazy(new ExplainCardViewModel$largeModeAdapter$2(this));
        this.openListFrequency = EComABUtils.enableLivePopCardOpenListFrequency();
        this.clickExplainCardEnterRoom = new ExplainCardViewModel$clickExplainCardEnterRoom$1(this);
        return;
    L13:
        r13 = new QLiveData();
        goto L14
    L9:
        r12 = new QLiveData();
        goto L10
    L5:
        r11 = new QLiveData();
        goto L6
    }

    public final void queryPopPromotion(String r12, boolean r13, Pair<Long, Long> r14, s r15, String r16, Map<String, String> r17, final Function1<? super ECUIPromotion, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "receiver");
        this.getExplainPromotion.a(r12, r13, r14, r15, r16, r17, new C03271(this, r18));
    }

    public /* synthetic */ ExplainCardViewModel(cf.i r10, gf.a r11, ml.b r12, LiveRoomParams r13, cf.c r14, jf.b r15, RoomContextController r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 4) == 0) goto L5;
        ml.b r4 = null;
    L6:
        this(r10, r11, r4, r13, r14, r15, r16);
        return;
    L5:
        r4 = r12;
        goto L6
    }

    public final void clickAuctionV2Card(final Context r16, final String r17, boolean r18, final String r19, final BtmItemBuilder r20, final String r21, final View r22, final il2.a r23, final Function0<Unit> r24) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "clickArea");
        if (r23 == null) goto L5;
        il2.a.C0145a.a(r23, "click_auction_v2", MapsKt.mapOf(TuplesKt.to("click_area", r17)), false, null, null, null, 60);
    L5:
        if (r18 == false) goto L7;
    L13:
        this.lastClickTime = SystemClock.uptimeMillis();
        ECUIPromotion r12 = (ECUIPromotion) this.promotionState.a();
        if (r12 == null) goto L19;
        UtilityKotlinExtentionsKt.f(getAuctionV2NewJumpDispatcher$default(this, r16, r21, false, 4, null), r12, new ExplainCardViewModel$clickAuctionV2Card$$inlined$let$lambda$1(this, r16, r21, r23, r17, r19, r20, r22, r24));
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("promotion_id", r12.getPromotionId());
        Unit r3 = Unit.INSTANCE;
        xh.c.a("Live").d("explain_card", "explain_card_" + r17, r2);
        return;
    L19:
        return;
    L7:
        if ((SystemClock.uptimeMillis() - this.lastClickTime) >= DEFAULT_CLICK_DURATION) goto L13;
        if (r23 == null) goto L17;
        il2.a r0 = il2.a.C0145a.a(r23, "click_auction_v2", null, false, "click_frequency_limit", null, null, 48);
        if (r0 == null) goto L18;
        ((LiveActionTracker) r0).e(false);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryPopPromotion$default(ExplainCardViewModel r10, String r11, boolean r12, Pair r13, s r14, String r15, Map r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Pair r5 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        s r6 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Map r8 = null;
    L26:
        r10.queryPopPromotion(r3, r4, r5, r6, r7, r8, r17);
        return;
    L25:
        r8 = r16;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final void clickCard(final ExplainCardViewModel r16, final Context r17, final String r18, boolean r19, final String r20, final BtmItemBuilder r21, final String r22, final View r23, final il2.a r24, final Function0<Unit> r25) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "clickArea");
        if (r19 == false) goto L5;
    L7:
        this.lastClickTime = SystemClock.uptimeMillis();
        if (r16 == null) goto L15;
        QLiveData<ECUIPromotion> r1 = r16.promotionState;
        if (r1 == null) goto L16;
        ECUIPromotion r12 = (ECUIPromotion) r1.a();
        if (r12 == null) goto L17;
        UtilityKotlinExtentionsKt.f(getNewJumpDispatcher$default(r16, r17, r22, false, 4, null), r12, new ExplainCardViewModel$clickCard$$inlined$let$lambda$1(r16, r17, r22, r24, r18, r20, r21, r23, r25));
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("promotion_id", r12.getPromotionId());
        Unit r4 = Unit.INSTANCE;
        xh.c.a("Live").d("explain_card", "explain_card_" + r18, r3);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((SystemClock.uptimeMillis() - this.lastClickTime) >= DEFAULT_CLICK_DURATION) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clickAuctionV2Card$default(ExplainCardViewModel r12, Context r13, String r14, boolean r15, String r16, BtmItemBuilder r17, String r18, View r19, il2.a r20, Function0 r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r22 & 16) == 0) goto L9;
        BtmItemBuilder r7 = null;
    L11:
        if ((r22 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L17;
        Function0 r11 = null;
    L18:
        r12.clickAuctionV2Card(r13, r14, r5, r16, r7, r8, r19, r20, r11);
        return;
    L17:
        r11 = r21;
        goto L18
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clickCard$default(ExplainCardViewModel r13, ExplainCardViewModel r14, Context r15, String r16, boolean r17, String r18, BtmItemBuilder r19, String r20, View r21, il2.a r22, Function0 r23, int r24, Object r25) {
        if ((r24 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r24 & 32) == 0) goto L9;
        BtmItemBuilder r8 = null;
    L11:
        if ((r24 & 64) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L17;
        Function0 r12 = null;
    L18:
        r13.clickCard(r14, r15, r16, r6, r18, r8, r9, r21, r22, r12);
        return;
    L17:
        r12 = r23;
        goto L18
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }
}
