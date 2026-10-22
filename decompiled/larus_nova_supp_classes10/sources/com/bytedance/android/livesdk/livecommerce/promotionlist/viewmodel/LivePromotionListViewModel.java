package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import cf.j;
import cf.l;
import cf.s;
import cf.u;
import cf.x;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.b1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionSingleEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListScene;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionListABConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHeaderData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHintData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageListTop;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.ToggleElement;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.LivePromotionListRepositoryMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListRepository;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveListSkinUIHelper;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sg2.v;
import si2.m;
import vi2.v0;
import xi2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ä\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\u0099\u0003\u0018\u0000 ¢\u00032\u00020\u00012\u00020\u0002:\n£\u0003¤\u0003¥\u0003¦\u0003§\u0003B\t¢\u0006\u0006\b \u0003\u0010¡\u0003J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002JN\u0010.\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\u00142\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u001dJ\u001e\u00102\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0014J(\u00103\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u00104\u001a\u00020\u0003J\u000e\u00105\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0007J#\u00108\u001a\u00020\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00107\u001a\u00020\u0014¢\u0006\u0004\b8\u00109J\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010=\u001a\u00020\u0003Jk\u0010C\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010>\u001a\u00020\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010?\u001a\u00020\u00142\b\b\u0002\u0010@\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010B\u001a\u00020\u0014¢\u0006\u0004\bC\u0010DJ\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\fJ\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0\fJ\b\u0010H\u001a\u0004\u0018\u00010EJ\b\u0010I\u001a\u0004\u0018\u00010\rJ\b\u0010K\u001a\u0004\u0018\u00010JJ\u0006\u0010L\u001a\u00020\u0005J\u0018\u0010O\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\r2\b\b\u0002\u0010N\u001a\u00020\u0014J\u000e\u0010P\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\rJ\u000e\u0010R\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u0014J\u000e\u0010T\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\u0014J\u000e\u0010W\u001a\u00020\u00032\u0006\u0010V\u001a\u00020UJ\u0012\u0010Z\u001a\u00020\u00032\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010XJ\u0006\u0010[\u001a\u00020\u0003J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010b\u001a\u00020\u00032\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\f2\u0006\u0010_\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u00142\u0006\u0010a\u001a\u00020\u0014H\u0016J\u0006\u0010c\u001a\u00020\u0003J#\u0010e\u001a\u00020\u00032\b\u0010d\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\be\u0010fJ\u0010\u0010h\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u000fH\u0016J\"\u0010k\u001a\u00020\u00032\b\u0010i\u001a\u0004\u0018\u00010\u00052\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J\u0016\u0010o\u001a\u00020\u00032\f\u0010n\u001a\b\u0012\u0004\u0012\u00020m0lH\u0016J\u0018\u0010q\u001a\u00020\u00032\u0006\u0010p\u001a\u00020m2\u0006\u0010S\u001a\u00020\u0014H\u0016J(\u0010v\u001a\u00020\u00032\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010s\u001a\u00020\u00142\u0006\u0010u\u001a\u00020tH\u0016J\u0018\u0010x\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010{\u001a\u00020\u00032\u0006\u0010z\u001a\u00020yH\u0016J\u001a\u0010}\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010|\u001a\u00020\u000fH\u0016J\u0006\u0010~\u001a\u00020\u0003J\b\u0010\u007f\u001a\u00020\u0003H\u0014J\u0007\u0010\u0080\u0001\u001a\u00020\u0014J\u0012\u0010\u0082\u0001\u001a\u00020\u00032\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\rJ\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010#J\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001J\u001c\u0010\u008b\u0001\u001a\u00030\u008a\u00012\b\u0010\u0087\u0001\u001a\u00030\u0086\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J0\u0010\u0091\u0001\u001a\u00020\u00142\b\u0010\u008d\u0001\u001a\u00030\u008c\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010E2\u0012\b\u0002\u0010\u0090\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u008f\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\u00032\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001J\u0007\u0010\u0095\u0001\u001a\u00020\u000fJ\u0007\u0010\u0096\u0001\u001a\u00020\u0014J\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001J\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001J\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001J\u0019\u0010¡\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0007\u0012\u0005\u0018\u00010 \u0001\u0018\u00010\u009f\u0001J\u0019\u0010¢\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0007\u0012\u0005\u0018\u00010 \u0001\u0018\u00010\u009f\u0001J\"\u0010¤\u0001\u001a\u00020\u00032\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010A\u001a\u0004\u0018\u00010\u0005H\u0016J\u0013\u0010¥\u0001\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010\u0005H\u0016R'\u0010$\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0017\n\u0005\b$\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R*\u0010«\u0001\u001a\u00030\u0084\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R*\u0010²\u0001\u001a\u00030±\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¹\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R'\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0017\n\u0005\b&\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R)\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b,\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R'\u0010-\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b-\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R,\u0010Ê\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R,\u0010Ð\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010×\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R0\u0010Û\u0001\u001a\u0005\u0018\u00010Ù\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001R#\u0010á\u0001\u001a\f\u0012\u0005\u0012\u00030à\u0001\u0018\u00010ß\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R,\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R!\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030ë\u00010ê\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R:\u0010ð\u0001\u001a\u0013\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u00010ë\u00010ï\u00010î\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R\u001d\u0010÷\u0001\u001a\u00030ö\u00018\u0006¢\u0006\u0010\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001R\u001d\u0010ü\u0001\u001a\u00030û\u00018\u0006¢\u0006\u0010\n\u0006\bü\u0001\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001R0\u0010\u0081\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0080\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R,\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0087\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0002\u0010\u0089\u0002\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R'\u0010g\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bg\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R)\u0010\u0093\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R+\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010\u009a\u0002\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002\"\u0006\b\u009d\u0002\u0010\u009e\u0002R+\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0002\u0010\u009a\u0002\u001a\u0006\b \u0002\u0010\u009c\u0002\"\u0006\b¡\u0002\u0010\u009e\u0002R)\u0010¢\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0002\u0010\u008e\u0002\u001a\u0006\b£\u0002\u0010\u0090\u0002\"\u0006\b¤\u0002\u0010\u0092\u0002R+\u0010¥\u0002\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¥\u0002\u0010¦\u0002\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0006\b©\u0002\u0010ª\u0002R+\u0010«\u0002\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b«\u0002\u0010¦\u0002\u001a\u0006\b¬\u0002\u0010¨\u0002\"\u0006\b\u00ad\u0002\u0010ª\u0002R+\u0010®\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0002\u0010\u009a\u0002\u001a\u0006\b¯\u0002\u0010\u009c\u0002\"\u0006\b°\u0002\u0010\u009e\u0002R)\u0010±\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b±\u0002\u0010\u008e\u0002\u001a\u0006\b²\u0002\u0010\u0090\u0002\"\u0006\b³\u0002\u0010\u0092\u0002R)\u0010´\u0002\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b´\u0002\u0010µ\u0002\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R)\u0010º\u0002\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0002\u0010µ\u0002\u001a\u0006\bº\u0002\u0010·\u0002\"\u0006\b»\u0002\u0010¹\u0002R)\u0010¼\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0002\u0010\u008e\u0002\u001a\u0006\b½\u0002\u0010\u0090\u0002\"\u0006\b¾\u0002\u0010\u0092\u0002R,\u0010À\u0002\u001a\u0005\u0018\u00010¿\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0002\u0010Á\u0002\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002R,\u0010Ç\u0002\u001a\u0005\u0018\u00010Æ\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0002\u0010È\u0002\u001a\u0006\bÉ\u0002\u0010Ê\u0002\"\u0006\bË\u0002\u0010Ì\u0002R%\u0010Ò\u0002\u001a\u00070Í\u0002R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÎ\u0002\u0010Ï\u0002\u001a\u0006\bÐ\u0002\u0010Ñ\u0002R*\u0010Ô\u0002\u001a\u00030Ó\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0002\u0010Õ\u0002\u001a\u0006\bÖ\u0002\u0010×\u0002\"\u0006\bØ\u0002\u0010Ù\u0002R)\u0010Ú\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÚ\u0002\u0010\u008e\u0002\u001a\u0006\bÛ\u0002\u0010\u0090\u0002\"\u0006\bÜ\u0002\u0010\u0092\u0002R\u001d\u0010Þ\u0002\u001a\u00030Ý\u00028\u0006¢\u0006\u0010\n\u0006\bÞ\u0002\u0010ß\u0002\u001a\u0006\bà\u0002\u0010á\u0002R2\u0010ã\u0002\u001a\u00020\u00142\u0007\u0010â\u0002\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0002\u0010µ\u0002\u001a\u0006\bã\u0002\u0010·\u0002\"\u0006\bä\u0002\u0010¹\u0002R)\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b)\u0010\u009a\u0002\u001a\u0006\bå\u0002\u0010\u009c\u0002\"\u0006\bæ\u0002\u0010\u009e\u0002R\u001d\u0010è\u0002\u001a\u00030ç\u00028\u0006¢\u0006\u0010\n\u0006\bè\u0002\u0010é\u0002\u001a\u0006\bê\u0002\u0010ë\u0002R\u001d\u0010í\u0002\u001a\u00030ì\u00028\u0006¢\u0006\u0010\n\u0006\bí\u0002\u0010î\u0002\u001a\u0006\bï\u0002\u0010ð\u0002R\u001d\u0010ò\u0002\u001a\u00030ñ\u00028\u0006¢\u0006\u0010\n\u0006\bò\u0002\u0010ó\u0002\u001a\u0006\bô\u0002\u0010õ\u0002R+\u0010ö\u0002\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bö\u0002\u0010÷\u0002\u001a\u0006\bø\u0002\u0010ù\u0002\"\u0006\bú\u0002\u0010û\u0002R2\u0010ü\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bü\u0002\u0010ý\u0002\u001a\u0006\bþ\u0002\u0010ÿ\u0002\"\u0006\b\u0080\u0003\u0010\u0081\u0003RI\u0010\u0085\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0084\u0003\u0012\u0005\u0012\u00030\u0084\u0003\u0018\u00010\u0083\u0003\u0018\u00010\u0082\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0003\u0010\u0086\u0003\u001a\u0006\b\u0087\u0003\u0010\u0088\u0003\"\u0006\b\u0089\u0003\u0010\u008a\u0003R4\u0010\u008b\u0003\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0003\u0010ý\u0002\u001a\u0006\b\u008c\u0003\u0010ÿ\u0002\"\u0006\b\u008d\u0003\u0010\u0081\u0003R+\u0010\u008e\u0003\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0003\u0010\u008f\u0003\u001a\u0006\b\u0090\u0003\u0010\u0091\u0003\"\u0006\b\u0092\u0003\u0010\u0093\u0003R\u001d\u0010\u0095\u0003\u001a\u00030\u0094\u00038\u0006¢\u0006\u0010\n\u0006\b\u0095\u0003\u0010\u0096\u0003\u001a\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0018\u0010\u009a\u0003\u001a\u00030\u0099\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0003\u0010\u009b\u0003R\u001e\u0010\u009f\u0003\u001a\t\u0012\u0005\u0012\u00030\u009c\u00030\f8TX\u0094\u0004¢\u0006\b\u001a\u0006\b\u009d\u0003\u0010\u009e\u0003¨\u0006¨\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListBaseViewModel;", "Ltj2/a;", "", "onInitExtraRequest", "", "requestPageCategoryName", "Lorg/json/JSONObject;", "enterRoomRelatedInfo", "generateRelatedInfo", "Lmj2/e;", "response", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "categories", "", "requestType", "onSuccessCallback", "reportSuccessInfoActionEvent", "updateUserChooseStoreEntryData", "", "shouldShowUserChooseStoreEntry", "userChooseStore", "setShouldShowUserChooseStoreEntry", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;", "headerData", "getListBackgroundColor", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/PromotionListController;", "ofPromotionListController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "ofRoomContextController", "updateListScene", "getListHeaderMarginBottom", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", "params", "Lfi2/a;", "liveRoomService", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "liveRoomParams", "btmPageId", "hitLayoutCache", "Lwj2/g;", "initialAction", "roomContextController", "init", "promotionId", "requestScene", "isScatter", "getPromotionById", "updatePageResponse", "retry", "updatePromotionsFromSettlement", "startPosition", "needScrollToStartPosition", "updateWhenBackFromOtherPage", "(Ljava/lang/Integer;Z)V", "updateWhenUseCache", "resetToDefault", "refreshPromotionListForStoreChange", "refreshPromotionListWithLoading", "uniqueIndex", "needClearTotalTabData", "needUpdateCompleteData", "toast", "needAllPanelData", "refreshProductList", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZLjava/lang/String;Z)V", "Lql/a;", "getTotalPromotions", "getCurrentTabPromotions", "getCurrentTopPromotion", "getCurrentCategory", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotionLiveListConfig;", "getLiveListConfig", "getEntranceInfoWithoutOpt", "category", "skipCheckIsSelected", "updateCategoryPromotions", "forceRefreshCategoryPromotions", "visible", "updateAllViewsVisible", "isLoadAfter", "retryLoadMore", "Lrj2/b;", "refreshHandler", "registerDataRefreshHandler", "Lcom/bytedance/android/ec/monitor/duration/h;", "listener", "reportFirstBindPromotionMonitorIfNeed", "updateECShoppingCartTask", "updatePromotionListTopData", "Lcom/bytedance/android/ec/model/live/ECPromotionInterationData;", "data", "isFullUpdate", "needCheckParam", "isFromPageApi", "updateInteractionData", "updateHintBannerInfo", "updateToast", "updateProductList", "(Ljava/lang/String;Ljava/lang/Integer;)V", LBSLightLocationTraceLogger.TOTAL, "notifyTotalChanged", "explainPromotionId", "topUniqueIndexList", "updateExplainPromotion", "Lmj2/h;", "Lcom/bytedance/android/livesdk/livecommerce/base/paging/PageListLoadStatus;", "wrapper", "updateLoadInitialStatus", "status", "updateLoadMoreStatus", "ids", "isProductId", "Lcom/bytedance/android/ec/common/api/UpdateLocalViewType;", "updateType", "updateDataChangeByIds", "connect", "notifyAuthorDisconnect", "Lwe3/d;", "message", "onProductRefreshMsgReceived", "promotionCount", "reportTabFirstPageLoadResult", "closePromotionListFragmentNow", "onCleared", "disableUpdateInteractionData", "currentCategory", "scrollToTop", "getListParams", "Lgi2/a;", "safeGetPromotionListParams", "Lcf/s;", "btmHandler", "Lcf/j;", "itemListHandler", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/g;", "createLivePromotionCardArgument", "Landroid/view/View;", "cartView", "promotion", "Lkotlin/Function0;", "callback", "addCartSuccessForAnim", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/utils/instant/a;", "cardRegionData", "notifyPromotionCardShowBottomAddOnFloor", "getCurrentTabIndex", "isPromotionListParamsInitialized", "Lcom/bytedance/android/livesdk/livecommerce/skin/f;", "getSkinHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/i;", "getListItemSkinHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/e;", "getLayoutHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/h;", "getListItemLayoutHelper", "", "", "getLigoInitialData", "getAddressInfoMap", "newCategories", "optUpdateCategories", "notifyListUpdateToast", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", "getParams", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", "setParams", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;)V", "promotionListParams", "Lgi2/a;", "getPromotionListParams", "()Lgi2/a;", "setPromotionListParams", "(Lgi2/a;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/c;", "requestParam", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/c;", "getRequestParam", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/c;", "setRequestParam", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/c;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/opt/repo/monitor/b;", "repoMonitor", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/opt/repo/monitor/b;", "Lfi2/a;", "getLiveRoomService", "()Lfi2/a;", "setLiveRoomService", "(Lfi2/a;)V", "Lwj2/g;", "getInitialAction", "()Lwj2/g;", "setInitialAction", "(Lwj2/g;)V", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "getRoomContextController", "()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "setRoomContextController", "(Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "listSkinHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/f;", "getListSkinHelper", "()Lcom/bytedance/android/livesdk/livecommerce/skin/f;", "setListSkinHelper", "(Lcom/bytedance/android/livesdk/livecommerce/skin/f;)V", "listLayoutHelper", "Lcom/bytedance/android/livesdk/livecommerce/skin/e;", "getListLayoutHelper", "()Lcom/bytedance/android/livesdk/livecommerce/skin/e;", "setListLayoutHelper", "(Lcom/bytedance/android/livesdk/livecommerce/skin/e;)V", "Ltj2/f;", "listRepository", "Ltj2/f;", "Ljf/d;", "<set-?>", "newJumpHelper", "Ljf/d;", "getNewJumpHelper", "()Ljf/d;", "Ljava/lang/ref/WeakReference;", "Lcf/u;", "newSkuPanelService", "Ljava/lang/ref/WeakReference;", "Ldi2/b;", "promotionListEventActionImpl", "Ldi2/b;", "getPromotionListEventActionImpl", "()Ldi2/b;", "setPromotionListEventActionImpl", "(Ldi2/b;)V", "Lmj2/i;", "Lmj2/c;", "listing", "Lmj2/i;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "pageListLiveData", "Landroidx/lifecycle/LiveData;", "getPageListLiveData", "()Landroidx/lifecycle/LiveData;", "setPageListLiveData", "(Landroidx/lifecycle/LiveData;)V", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/i;", "listHeaderViewModel", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/i;", "getListHeaderViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/i;", "Lyh2/a;", "interactionData", "Lyh2/a;", "getInteractionData", "()Lyh2/a;", "Lcom/bytedance/android/shopping/ligo/context/b;", "ligoContext", "Lcom/bytedance/android/shopping/ligo/context/b;", "getLigoContext", "()Lcom/bytedance/android/shopping/ligo/context/b;", "setLigoContext", "(Lcom/bytedance/android/shopping/ligo/context/b;)V", "Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;", "ligoViewManager", "Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;", "getLigoViewManager", "()Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;", "setLigoViewManager", "(Lcom/bytedance/android/shopping/ligo/context/LigoViewManager;)V", "I", "getTotal", "()I", "setTotal", "(I)V", "entranceInfo", "Lorg/json/JSONObject;", "getEntranceInfo", "()Lorg/json/JSONObject;", "setEntranceInfo", "(Lorg/json/JSONObject;)V", "authorSellScore", "Ljava/lang/String;", "getAuthorSellScore", "()Ljava/lang/String;", "setAuthorSellScore", "(Ljava/lang/String;)V", "searchSchema", "getSearchSchema", "setSearchSchema", "latestRequestType", "getLatestRequestType", "setLatestRequestType", "addCartOpt", "Ljava/lang/Integer;", "getAddCartOpt", "()Ljava/lang/Integer;", "setAddCartOpt", "(Ljava/lang/Integer;)V", "addCartToastOrder", "getAddCartToastOrder", "setAddCartToastOrder", "storeSchema", "getStoreSchema", "setStoreSchema", "showAuthorConnect", "getShowAuthorConnect", "setShowAuthorConnect", "forceHideTopModule", "Z", "getForceHideTopModule", "()Z", "setForceHideTopModule", "(Z)V", "isDefaultTab", "setDefaultTab", "currentSelectedTabPosition", "getCurrentSelectedTabPosition", "setCurrentSelectedTabPosition", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "dynamicOpenRegion", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "getDynamicOpenRegion", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "setDynamicOpenRegion", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "roomInfo", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "getRoomInfo", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "setRoomInfo", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;)V", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel$d;", "skuAbility$delegate", "Lkotlin/Lazy;", "getSkuAbility", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel$d;", "skuAbility", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListScene;", "listScene", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListScene;", "getListScene", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListScene;", "setListScene", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListScene;)V", "buyButtonStyle", "getBuyButtonStyle", "setBuyButtonStyle", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/utils/instant/b;", "timestampTracker", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/utils/instant/b;", "getTimestampTracker", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/utils/instant/b;", "value", "isInSplitScreen", "setInSplitScreen", "getBtmPageId", "setBtmPageId", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/b;", "listingViewModel", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/b;", "getListingViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/b;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/c;", "monitorViewModel", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/c;", "getMonitorViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/c;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/a;", "footerViewModel", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/a;", "getFooterViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/subviewmodel/a;", "recentExplainPromotion", "Lql/a;", "getRecentExplainPromotion", "()Lql/a;", "setRecentExplainPromotion", "(Lql/a;)V", "getCurrentPosition", "Lkotlin/jvm/functions/Function0;", "getGetCurrentPosition", "()Lkotlin/jvm/functions/Function0;", "setGetCurrentPosition", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "getCardLoc", "Lkotlin/jvm/functions/Function1;", "getGetCardLoc", "()Lkotlin/jvm/functions/Function1;", "setGetCardLoc", "(Lkotlin/jvm/functions/Function1;)V", "getCurrentTab", "getGetCurrentTab", "setGetCurrentTab", "secondViewModel", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel;", "getSecondViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel;", "setSecondViewModel", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel;)V", "Lx83/a;", "viewCacheCenter", "Lx83/a;", "getViewCacheCenter", "()Lx83/a;", "com/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel$f", "listStateProvider", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListViewModel$f;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/b;", "getSubViewModels", "()Ljava/util/List;", "subViewModels", "<init>", "()V", "Companion", "a", "b", "c", "d", "e", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListViewModel extends LivePromotionListBaseViewModel implements tj2.a {
    private static final int BUY_BTN_STYLE_INSTANT_FUSION_SHORT = 1;
    public static final a Companion = null;
    private Integer addCartOpt;
    private Integer addCartToastOrder;
    private String authorSellScore;
    private String btmPageId;
    private int buyButtonStyle;
    private int currentSelectedTabPosition;
    private LivePromotionPageDynamicOpenRegion dynamicOpenRegion;
    private JSONObject entranceInfo;
    private final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a footerViewModel;
    private boolean forceHideTopModule;
    private Function1<? super String, Pair<float[], float[]>> getCardLoc;
    private Function0<Integer> getCurrentPosition;
    private Function0<Integer> getCurrentTab;
    private wj2.g initialAction;
    private final yh2.a interactionData;
    private boolean isDefaultTab;
    private boolean isInSplitScreen;
    private int latestRequestType;
    private com.bytedance.android.shopping.ligo.context.b<?> ligoContext;
    private LigoViewManager ligoViewManager;
    private final com.bytedance.android.livesdk.livecommerce.iron.listheader.i listHeaderViewModel;
    private com.bytedance.android.livesdk.livecommerce.skin.e listLayoutHelper;
    private final tj2.f listRepository;
    private LivePromotionListScene listScene;
    private com.bytedance.android.livesdk.livecommerce.skin.f listSkinHelper;
    private final f listStateProvider;
    private mj2.i<mj2.c> listing;
    private final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b listingViewModel;
    public fi2.a liveRoomService;
    private final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.c monitorViewModel;
    private jf.d newJumpHelper;
    private WeakReference<u> newSkuPanelService;
    public LiveData<PagedList<mj2.c>> pageListLiveData;
    public LivePromotionListParams params;
    private di2.b promotionListEventActionImpl;
    public gi2.a promotionListParams;
    private volatile ql.a recentExplainPromotion;
    private final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b repoMonitor;
    public com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c requestParam;
    private RoomContextController roomContextController;
    private LivePromotionPageRoomInfo roomInfo;
    private String searchSchema;
    private LivePromotionListViewModel secondViewModel;
    private int showAuthorConnect;
    private final Lazy skuAbility$delegate;
    private String storeSchema;
    private final com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b timestampTracker;
    private int total;
    private final x83.a viewCacheCenter;

    public static final class a {
        public a() {
        }
    }

    public final class b implements ILivePromotionCardContainerHandler {
        public final l a;
        public final j b;
        public final /* synthetic */ LivePromotionListViewModel c;

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void d() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void m() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final com.bytedance.android.livesdk.livecommerce.promotion.card.d g() {
            return LivePromotionListViewModel.access$getSkuAbility$p(this.c);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final Object l() {
            return this.c.getViewCacheCenter();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final com.bytedance.android.livesdk.livecommerce.largemode.b o() {
            return this.c.getRoomContextController().A().t.L();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final il2.a b(com.bytedance.android.btm.api.model.d r3) {
            return this.c.getRoomContextController().A().t.K().a("livesdk_live_room", r3);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final Map<String, Object> e(ILivePromotionCardContainerHandler.ContainerPriority r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            int r3 = com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.d.b[r2.ordinal()];
            if (r3 == 1) goto L9;
            if (r3 == 2) goto L11;
            return null;
        L11:
            return this.c.getAddressInfoMap();
        L9:
            return this.c.getLigoInitialData();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void f(ECUIPromotion r2) {
            Intrinsics.checkNotNullParameter(r2, "promotion");
            this.b.j(r2.getPromotionId());
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final boolean h(Decision r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            switch(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.d.a[r3.ordinal()]) {
                case 1: goto L28;
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L31;
                case 5: goto L14;
                case 6: goto L11;
                case 7: goto L8;
                case 8: goto L33;
                default: goto L5;
            };
        L18:
            ECLiveDegradeHelper.c.getClass();
            if (ECLiveDegradeHelper.a("promotion_list_card_sale_point_degrade", ECLiveDegradeHelper.b().getEnablePromotionListCardSalePointDegrade()) != 1) goto L31;
            return true;
        L21:
            l r4 = this.a;
            if (r4 != null) goto L24;
        L25:
            ECLiveDegradeHelper.c.getClass();
            if (ECLiveDegradeHelper.a("promotion_list_card_explaining_anim_degrade", ECLiveDegradeHelper.b().getEnablePromotionListCardExplainingAnimDegrade()) != 1) goto L31;
            return true;
        L24:
            if (r4.Ea() != true) goto L25;
            return true;
        L28:
            ECLiveDegradeHelper.c.getClass();
            if (ECLiveDegradeHelper.a("hot_atmosphere_degrade", ECLiveDegradeHelper.b().getEnableHotAtmosphereDegrade()) < 2) goto L31;
            return true;
        L31:
            return false;
        L5:
            throw new NoWhenBranchMatchedException();
        L33:
            return this.c.isInSplitScreen();
        L8:
            if (this.c.getBuyButtonStyle() != 1) goto L31;
            return true;
        L11:
            if (this.c.getListScene() != LivePromotionListScene.INSTANT_RETAIL_FUSION) goto L31;
            return true;
        L14:
            if (this.c.getListScene() == LivePromotionListScene.INSTANT_RETAIL_FUSION) goto L31;
            if (EComABUtils.getLiveListCardTitleStyle() != 1) goto L31;
            return true;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void j(String r5) {
            Intrinsics.checkNotNullParameter(r5, "productId");
            Intrinsics.checkNotNullParameter("operation_start_time", "event");
            com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b r3 = this.c.getTimestampTracker();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r5, "productId");
            Intrinsics.checkNotNullParameter("operation_start_time", "event");
            if (r3.a.get(r5) != null) goto L5;
            Map<String, Long> r0 = r3.a.put(r5, new LinkedHashMap());
        L5:
            Map<String, Long> r6 = r3.a.get(r5);
            if (r6 == null) goto L9;
            r6.put("operation_start_time", Long.valueOf(System.currentTimeMillis()));
            return;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void k(ql.a r2) {
            Intrinsics.checkNotNullParameter(r2, "promotion");
            this.b.e(r2);
        }

        public b(LivePromotionListViewModel r2, j r3) {
            Intrinsics.checkNotNullParameter(r3, "itemListHandler");
            this.c = r2;
            this.b = r3;
            int r4 = ECSdk.a;
            this.a = (l) ECSdk.a(l.class);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final boolean p(View r8, ql.a r9) {
            Intrinsics.checkNotNullParameter(r8, "cartView");
            Intrinsics.checkNotNullParameter(r9, "promotion");
            return LivePromotionListViewModel.addCartSuccessForAnim$default(this.c, r8, r9, null, 4, null);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final void c(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "promotionId");
            this.b.c(r2, r3, r4);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        public final boolean i(ql.a r7, int r8, boolean r9) {
            mj2.b r0 = LivePromotionListViewModel.access$ofPromotionListController(this.c).S;
            ql.a r1 = LivePromotionListViewModel.access$getListRepository$p(this.c).B();
            if (r8 != 3) goto L10;
            if (r0.d == false) goto L10;
            if (r9 == false) goto L8;
            r0.d = false;
        L8:
            return true;
        L10:
            if (r8 == 2) goto L12;
        L16:
            if (r8 != 1) goto L57;
            ECLiveABUtils r10 = ECLiveABUtils.INSTANCE;
            if (r10.getEC_LIVE_PROMOTION_ENHANCE_RELATED_EFFECT_TYPE().intValue() <= 0) goto L48;
            if (r7 == null) goto L48;
            if (r1 == null) goto L48;
            Integer r2 = r10.getEC_LIVE_PROMOTION_ENHANCE_RELATED_EFFECT_TYPE();
            if (r2 != null) goto L25;
        L35:
            Integer r3 = r10.getEC_LIVE_PROMOTION_ENHANCE_RELATED_EFFECT_TYPE();
            if (r3 == null) goto L48;
            if (r3.intValue() != 2) goto L48;
            if (r7.isRelatedInfo() == false) goto L48;
            if ((!Intrinsics.areEqual(r0.b, r7.getPromotionId())) == false) goto L48;
            if (r9 == false) goto L46;
            r0.b = r7.getPromotionId();
        L46:
            return true;
        L25:
            if (r2.intValue() != 1) goto L35;
            if (r0.b == null) goto L30;
            return false;
        L30:
            if (r7.isRelatedInfo() == false) goto L34;
            if (r9 == false) goto L33;
            r0.b = r7.getPromotionId();
        L33:
            return true;
        L34:
            return false;
        L48:
            if (r10.getEC_LIVE_PROMOTION_ENHANCE_EXPLAIN_EFFECT() == false) goto L57;
            if (r7 == null) goto L57;
            if (r7.isOnTopExplaining() == false) goto L57;
            if ((!Intrinsics.areEqual(r7.getPromotionId(), r0.a)) == false) goto L57;
            if (r9 == false) goto L56;
            r0.a = r7.getPromotionId();
        L56:
            return true;
        L57:
            return false;
        L12:
            if (r0.c == false) goto L16;
            if (r9 == false) goto L15;
            r0.c = false;
        L15:
            return true;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
        @Deprecated(message = "临时兼容，二期改为动态可配")
        public final <T> T n(ILivePromotionCardContainerHandler.Scene r6, KClass<T> r7, Context r8) {
            Intrinsics.checkNotNullParameter(r6, "scene");
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TYPE);
            T r2 = null;
            if (r6 != ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackground) goto L15;
            if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Drawable.class)) == false) goto L15;
            com.bytedance.android.livesdk.livecommerce.skin.i r9 = this.c.getListItemSkinHelper();
            if (r9 == null) goto L9;
            Object r10 = r9.l();
        L11:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L182:
            return (T) r10;
        L9:
            r10 = null;
        L15:
            if (r6 != ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackgroundRadius) goto L28;
            if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(List.class)) == false) goto L28;
            com.bytedance.android.livesdk.livecommerce.skin.i r11 = this.c.getListItemSkinHelper();
            if (r11 == null) goto L21;
            List<Integer> r12 = r11.v();
        L23:
            if ((r12 instanceof Object) == false) goto L26;
            r2 = (T) r12;
        L26:
            T r3 = r2;
            return r2;
        L21:
            r12 = null;
        L28:
            if (r6 != ILivePromotionCardContainerHandler.Scene.ExplainBarWaveIcon) goto L37;
            com.bytedance.android.livesdk.livecommerce.skin.i r13 = this.c.getListItemSkinHelper();
            if (r13 == null) goto L32;
            r10 = r13.s();
        L34:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L32:
            r10 = null;
            goto L34
        L37:
            if (r6 != ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextColor) goto L46;
            com.bytedance.android.livesdk.livecommerce.skin.i r14 = this.c.getListItemSkinHelper();
            if (r14 == null) goto L41;
            r10 = r14.y();
        L43:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L41:
            r10 = null;
            goto L43
        L46:
            if (r6 != ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextSize) goto L55;
            com.bytedance.android.livesdk.livecommerce.skin.i r15 = this.c.getListItemSkinHelper();
            if (r15 == null) goto L50;
            r10 = r15.u();
        L52:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L50:
            r10 = null;
            goto L52
        L55:
            if (r6 != ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddEnabledImageUrl) goto L64;
            com.bytedance.android.livesdk.livecommerce.skin.i r16 = this.c.getListItemSkinHelper();
            if (r16 == null) goto L59;
            r10 = r16.d(true);
        L61:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L59:
            r10 = null;
            goto L61
        L64:
            if (r6 != ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddDisabledImageUrl) goto L73;
            com.bytedance.android.livesdk.livecommerce.skin.i r17 = this.c.getListItemSkinHelper();
            if (r17 == null) goto L68;
            r10 = r17.d(false);
        L70:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L68:
            r10 = null;
            goto L70
        L73:
            if (r6 != ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperSubImageUrl) goto L82;
            com.bytedance.android.livesdk.livecommerce.skin.i r18 = this.c.getListItemSkinHelper();
            if (r18 == null) goto L77;
            r10 = r18.t();
        L79:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L77:
            r10 = null;
            goto L79
        L82:
            if (r6 != ILivePromotionCardContainerHandler.Scene.AddCartIconEnabled) goto L91;
            com.bytedance.android.livesdk.livecommerce.skin.i r19 = this.c.getListItemSkinHelper();
            if (r19 == null) goto L86;
            r10 = r19.F(true);
        L88:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L86:
            r10 = null;
            goto L88
        L91:
            if (r6 != ILivePromotionCardContainerHandler.Scene.AddCartIconDisabled) goto L100;
            com.bytedance.android.livesdk.livecommerce.skin.i r20 = this.c.getListItemSkinHelper();
            if (r20 == null) goto L95;
            r10 = r20.F(false);
        L97:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L95:
            r10 = null;
            goto L97
        L100:
            if (r6 != ILivePromotionCardContainerHandler.Scene.AddCartBtnBgEnabled) goto L109;
            com.bytedance.android.livesdk.livecommerce.skin.i r21 = this.c.getListItemSkinHelper();
            if (r21 == null) goto L104;
            r10 = r21.o(true);
        L106:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L104:
            r10 = null;
            goto L106
        L109:
            if (r6 != ILivePromotionCardContainerHandler.Scene.AddCartBtnBgDisabled) goto L118;
            com.bytedance.android.livesdk.livecommerce.skin.i r22 = this.c.getListItemSkinHelper();
            if (r22 == null) goto L113;
            r10 = r22.o(false);
        L115:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L113:
            r10 = null;
            goto L115
        L118:
            if (r6 != ILivePromotionCardContainerHandler.Scene.AddCartBtnLargeSize) goto L127;
            com.bytedance.android.livesdk.livecommerce.skin.i r23 = this.c.getListItemSkinHelper();
            if (r23 == null) goto L122;
            r10 = r23.p();
        L124:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L122:
            r10 = null;
            goto L124
        L127:
            if (r6 != ILivePromotionCardContainerHandler.Scene.BuyBtnWidthSelfAdapt) goto L136;
            com.bytedance.android.livesdk.livecommerce.skin.h r24 = this.c.getListItemLayoutHelper();
            if (r24 == null) goto L131;
            r10 = r24.a();
        L133:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L131:
            r10 = null;
            goto L133
        L136:
            if (r6 != ILivePromotionCardContainerHandler.Scene.BuyBtnBgEnabled) goto L145;
            com.bytedance.android.livesdk.livecommerce.skin.i r25 = this.c.getListItemSkinHelper();
            if (r25 == null) goto L140;
            r10 = r25.n(true);
        L142:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L140:
            r10 = null;
            goto L142
        L145:
            if (r6 != ILivePromotionCardContainerHandler.Scene.BuyBtnBgDisabled) goto L154;
            com.bytedance.android.livesdk.livecommerce.skin.i r26 = this.c.getListItemSkinHelper();
            if (r26 == null) goto L149;
            r10 = r26.n(false);
        L151:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L149:
            r10 = null;
            goto L151
        L154:
            if (r6 != ILivePromotionCardContainerHandler.Scene.SimilarBtnBgEnabled) goto L163;
            com.bytedance.android.livesdk.livecommerce.skin.i r27 = this.c.getListItemSkinHelper();
            if (r27 == null) goto L158;
            r10 = r27.k();
        L160:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L158:
            r10 = null;
            goto L160
        L163:
            if (r6 != ILivePromotionCardContainerHandler.Scene.SimilarBtnTextColorEnabled) goto L172;
            com.bytedance.android.livesdk.livecommerce.skin.i r28 = this.c.getListItemSkinHelper();
            if (r28 == null) goto L167;
            r10 = r28.a();
        L169:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L167:
            r10 = null;
            goto L169
        L172:
            if (r6 != ILivePromotionCardContainerHandler.Scene.BuyBtnTextColor) goto L180;
            com.bytedance.android.livesdk.livecommerce.skin.i r29 = this.c.getListItemSkinHelper();
            if (r29 == null) goto L176;
            r10 = r29.f();
        L178:
            if ((r10 instanceof Object) == true) goto L182;
            return null;
        L176:
            r10 = null;
            goto L178
        L180:
            Intrinsics.checkNotNullParameter(r6, "scene");
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TYPE);
            return null;
        }
    }

    public final class c implements jf.c {
        public final /* synthetic */ LivePromotionListViewModel a;

        public final void h() {
        }

        public final void l() {
        }

        public final void m() {
        }

        public final void b() {
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g(false));
        }

        public final void a() {
            if (EComABUtils.getHuaweiFoldableDevice() != 1) goto L6;
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g(false));
            return;
        }

        public c(LivePromotionListViewModel r1) {
            this.a = r1;
        }

        public final boolean k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            Intrinsics.checkNotNullParameter(r2, "schema");
            return false;
        }

        public final void d(Context r1, com.bytedance.android.btm.api.model.d r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
        }

        public final void e(Context r1, com.bytedance.android.btm.api.model.d r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
        }

        public final void f(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotionParams");
            if (Intrinsics.areEqual(r2, "button") == false) goto L6;
            com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b r4 = this.a.getListingViewModel();
            ql.a r5 = r3.a;
            BuyNowPrefetchType r0 = BuyNowPrefetchType.CLICK;
            r4.getClass();
            com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b.k(r5, r0);
            return;
        }

        public final boolean i(String r1, com.bytedance.android.btm.api.model.d r2) {
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            return false;
        }

        public final Map<String, String> j(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            return jf.c.a.a(r2, r3);
        }

        public final void n(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotionParams");
            jf.c.a.b(r2, r3);
        }

        public final boolean c(Context r1, com.bytedance.android.btm.api.model.d r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
            return false;
        }

        public final void g(String r2, ql.a r3, BtmItemBuilder r4) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotion");
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotion");
        }
    }

    public final class d implements com.bytedance.android.livesdk.livecommerce.promotion.card.d {
        public final HashMap<String, ECUISkuInfo.a> a;

        public d() {
            this.a = new HashMap();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
        public final Pair<String[], Long> a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "promotionId");
            ECUISkuInfo.a r5 = this.a.get(r4);
            if (r5 != null) goto L7;
            return null;
        L7:
            return TuplesKt.to(r5.a, Long.valueOf(r5.b));
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
        public final void b(String r3, String[] r4, long r5) {
            Intrinsics.checkNotNullParameter(r3, "promotionId");
            Intrinsics.checkNotNullParameter(r4, "selectedSkuIdList");
            this.a.put(r3, new ECUISkuInfo.a(r4, r5));
        }
    }

    public final class e implements com.bytedance.android.livesdk.livecommerce.promotion.card.e {
        public final Set<String> a;
        public final /* synthetic */ LivePromotionListViewModel b;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;
            public final /* synthetic */ Function3 b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Map d;
            public final /* synthetic */ String e;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$e$a$a, reason: collision with other inner class name */
            public static final class RunnableC0096a implements Runnable {
                public final /* synthetic */ a a;

                public RunnableC0096a(a r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a r0 = this.a;     // Catch: Throwable -> L4
                    r0.b.invoke(r0.c, r0.d, r0.e);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(e r1, Function3 r2, String r3, Map r4, String r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.postRunnable(new RunnableC0096a(this));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(LivePromotionListViewModel r12) {
            this.b = r12;
            this.a = SetsKt.setOf(new String[]{"livesdk_explain_replay_entrance_show", "livesdk_explain_apply_entrance_show", "livesdk_show_add_to_cart", "livesdk_unrec_show_product", "livesdk_sku_button_show", "livesdk_show_store_entrance", "livesdk_show_store_info", "livesdk_show_have_seen_label", "livesdk_show_hot_sale", "livesdk_show_invalid_product", "livesdk_product_apply_explain_show"});
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.e
        public final boolean a(String r10, Map<String, String> r11, String r12, ql.a r13, Function3<? super String, ? super Map<String, String>, ? super String, Unit> r14) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            Intrinsics.checkNotNullParameter(r11, "eventParams");
            Intrinsics.checkNotNullParameter(r14, "save");
            boolean r2 = false;
            if (this.a.contains(r10) == false) goto L5;
        L18:
            a r15 = new a(this, r14, r10, r11, r12);
            Handler r16 = k.a;
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L21;
            r2 = true;
        L21:
            if (r2 == false) goto L23;
            r15.run();
        L24:
            return true;
        L23:
            k.a.post(r15);
            goto L24
        L5:
            if (StringsKt.endsWith$default(r10, "_show", false, 2, null) == true) goto L18;
            if (Intrinsics.areEqual(r10, "livesdk_show_product") == false) goto L17;
            if (r13 == null) goto L15;
            ql.b r17 = r13.getClientData();
            if (r17 == null) goto L15;
            if (r17.b == true) goto L15;
            return true;
        L15:
            return false;
        L17:
            return false;
        }
    }

    public static final class f implements qj2.a {
        public final /* synthetic */ LivePromotionListViewModel a;

        @Override // qj2.a
        public final int a() {
            Function0<Integer> r0 = this.a.getGetCurrentPosition();
            if (r0 == null) goto L7;
            Integer r1 = (Integer) r0.invoke();
            if (r1 == null) goto L7;
            return r1.intValue();
        L7:
            return 0;
        }

        public f(LivePromotionListViewModel r1) {
            this.a = r1;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ LivePromotionListViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public g(LivePromotionListViewModel r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            int r0 = this.b;
            String r1 = BDLocationException.ERROR_TIMEOUT;
            if (r0 != 0) goto L5;
            String r2 = BDLocationException.ERROR_TIMEOUT;
        L6:
            v r3 = new v("livesdk_list_load_result", this.a.getPromotionListParams());
            r3.c(LocationMonitorConst.IS_SUCCESS, r2);
            String r4 = this.c;
            if (r4 != null) goto L9;
        L18:
            r3.c("tab_unique_index", r1);
            r3.i(null);
            return;
        L9:
            if (r4.length() <= 0) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == true) goto L15;
            r4 = null;
        L15:
            if (r4 == null) goto L18;
            r1 = r4;
            goto L18
        L11:
            r5 = false;
            goto L12
        L5:
            r2 = "1";
            goto L6
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

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$getAddressInfoMap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02951 extends MutablePropertyReference0Impl {
        public C02951(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "promotionListParams", "getPromotionListParams()Lcom/bytedance/android/livesdk/livecommerce/jump/model/PromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getPromotionListParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setPromotionListParams((gi2.a) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$getLigoInitialData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02961 extends MutablePropertyReference0Impl {
        public C02961(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "promotionListParams", "getPromotionListParams()Lcom/bytedance/android/livesdk/livecommerce/jump/model/PromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getPromotionListParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setPromotionListParams((gi2.a) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$getListParams$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02971 extends MutablePropertyReference0Impl {
        public C02971(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "params", "getParams()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setParams((LivePromotionListParams) r2);
        }
    }

    public static final class h implements v0<e0> {
        public final /* synthetic */ LivePromotionListViewModel a;

        @Override // vi2.v0
        public final void onError(Throwable r1) {
        }

        public h(LivePromotionListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onSuccess(e0 r9) {
            e0 r10 = r9;
            if (r10 != null) goto L5;
        L9:
            s0.a(new wk.c("", "", 1, 1, 48));
            return;
        L5:
            if (TextUtils.equals(r10.b(), "ok") == false) goto L9;
            if (r10.a() != 0) goto L9;
            com.bytedance.android.ec.core.arch.event.c.d(this.a, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g0(r10));
            goto L9
        }
    }

    public static final class i implements v0<ECPromotionList.o> {
        public final /* synthetic */ LivePromotionListViewModel a;

        @Override // vi2.v0
        public final void onError(Throwable r1) {
        }

        public i(LivePromotionListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onSuccess(ECPromotionList.o r3) {
            final ECPromotionList.o r4 = r3;
            LivePromotionListViewModel.access$setState(this.a, new LivePromotionListViewModel$updateHintBannerInfo$1$onSuccess$1(r4));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$isPromotionListParamsInitialized$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02991 extends MutablePropertyReference0Impl {
        public C02991(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "promotionListParams", "getPromotionListParams()Lcom/bytedance/android/livesdk/livecommerce/jump/model/PromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getPromotionListParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setPromotionListParams((gi2.a) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C03011 extends MutablePropertyReference0Impl {
        public C03011(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "params", "getParams()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setParams((LivePromotionListParams) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel$safeGetPromotionListParams$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C03071 extends MutablePropertyReference0Impl {
        public C03071(LivePromotionListViewModel r7) {
            super(r7, LivePromotionListViewModel.class, "promotionListParams", "getPromotionListParams()Lcom/bytedance/android/livesdk/livecommerce/jump/model/PromotionListParams;", 0);
        }

        public Object get() {
            return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getPromotionListParams();
        }

        public void set(Object r2) {
            ((LivePromotionListViewModel) ((CallableReference) this).receiver).setPromotionListParams((gi2.a) r2);
        }
    }

    static {
        Companion = new a();
    }

    public LivePromotionListViewModel() {
        com.bytedance.android.ec.core.async.b r0 = null;
        super(r0, 1, r0);
        if (ECLiveABUtils.INSTANCE.getENABLE_LIST_STREAM_MONITOR() == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b r1 = new LivePromotionListRepositoryMonitor();
    L6:
        this.repoMonitor = r1;
        int r2 = RoomContextController.h;
        this.roomContextController = RoomContextController.a.a();
        this.listRepository = new LivePromotionListRepository(new LivePromotionListViewModel$listRepository$1(this), getDisposableScope(), r1);
        com.bytedance.android.livesdk.livecommerce.iron.listheader.i r3 = new com.bytedance.android.livesdk.livecommerce.iron.listheader.i();
        r3.d = this.roomContextController.A().t.L();
        Unit r4 = Unit.INSTANCE;
        this.listHeaderViewModel = r3;
        this.interactionData = new yh2.a();
        this.entranceInfo = new JSONObject();
        this.isDefaultTab = true;
        this.skuAbility$delegate = LazyKt.lazy(new LivePromotionListViewModel$skuAbility$2(this));
        this.listScene = LivePromotionListScene.NORMAL;
        this.timestampTracker = new com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b();
        this.listingViewModel = new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b(new LivePromotionListViewModel$listingViewModel$1(this), new LivePromotionListViewModel$listingViewModel$2(this));
        this.monitorViewModel = new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.c(new LivePromotionListViewModel$monitorViewModel$1(this));
        Function0<LivePromotionListParams> r5 = new LivePromotionListViewModel$footerViewModel$1(this);
        Function0<List<? extends ql.a>> r6 = new LivePromotionListViewModel$footerViewModel$2(this);
        Function0<gi2.a> r7 = new LivePromotionListViewModel$footerViewModel$3(this);
        this.footerViewModel = new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a(r5, r6, new LivePromotionListViewModel$footerViewModel$4(this), new LivePromotionListViewModel$footerViewModel$5(this), r7, new LivePromotionListViewModel$footerViewModel$6(this));
        this.viewCacheCenter = new com.bytedance.android.livesdk.livecommerce.promotionlist.base.d();
        this.listStateProvider = new f(this);
        return;
    L5:
        r1 = new com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.a();
        goto L6
    }

    private final d getSkuAbility() {
        return (d) this.skuAbility$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListBaseViewModel
    public List<com.bytedance.android.livesdk.livecommerce.promotionlist.base.b> getSubViewModels() {
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.livecommerce.promotionlist.base.b[]{this.listingViewModel, this.monitorViewModel, this.footerViewModel});
    }

    private final PromotionListController ofPromotionListController() {
        RoomContextController r0 = this.roomContextController;
        LivePromotionListParams r1 = getListParams();
        if (r1 == null) goto L5;
        String r2 = r1.getRoomId();
    L7:
        return ControllerExtensionsKt.c(r0, r2).A().r;
    L5:
        r2 = null;
        goto L7
    }

    private final RoomContextController ofRoomContextController() {
        RoomContextController r0 = this.roomContextController;
        LivePromotionListParams r1 = getListParams();
        if (r1 == null) goto L5;
        String r2 = r1.getRoomId();
    L7:
        return ControllerExtensionsKt.c(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    private final void onInitExtraRequest() {
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == false) goto L14;
        tj2.f r1 = this.listRepository;
        LivePromotionListParams r0 = this.params;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L7:
        String r2 = r0.getRoomId();
        LivePromotionListParams r3 = this.params;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L10:
        String r4 = r3.getAnchorId();
        LivePromotionListParams r5 = this.params;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L13:
        r1.p(r2, r4, r5.getAnchorSecId(), true, new C03021(this));
    L14:
        Lazy r6 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("live_list_init", null);
    }

    public final void closePromotionListFragmentNow() {
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g(false));
    }

    public final Map<String, Object> getAddressInfoMap() {
        if (this.promotionListParams == null) goto L19;
        LinkedHashMap r0 = new LinkedHashMap();
        gi2.a r1 = this.promotionListParams;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("promotionListParams");
    L7:
        LivePromotionPageRoomInfo r2 = (LivePromotionPageRoomInfo) r1.e.invoke();
        if (r2 == null) goto L18;
        String r3 = r2.getReceiveAddressId();
        if (r3 == null) goto L12;
        r0.put("receive_address_id", r3);
    L12:
        String r4 = r2.getAddressType();
        if (r4 == null) goto L15;
        r0.put("address_type", r4);
    L15:
        String r5 = r2.getAddressStrategy();
        if (r5 == null) goto L18;
        r0.put("address_strategy_type", r5);
    L18:
        return r0;
    L19:
        return null;
    }

    public final PromotionCategory getCurrentCategory() {
        return this.listRepository.b();
    }

    public final int getCurrentTabIndex() {
        return this.listRepository.l();
    }

    public final List<ql.a> getCurrentTabPromotions() {
        return this.listRepository.F();
    }

    public final ql.a getCurrentTopPromotion() {
        return this.listRepository.g();
    }

    public final String getEntranceInfoWithoutOpt() {
        LivePromotionListParams r0 = this.params;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L5:
        String r1 = r0.getLiveListChannel();
        LivePromotionListParams r2 = this.params;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L9:
        return l0.k(r1, "live_list_card", r2.getExtraEntranceInfo());
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.e getLayoutHelper() {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L7;
        return this.listLayoutHelper;
    L7:
        return ofPromotionListController().H;
    }

    public final Map<String, Object> getLigoInitialData() {
        LinkedHashMap r0 = new LinkedHashMap();
        gi2.a r1 = this.promotionListParams;
        if (r1 == null) goto L27;
        LiveRoomParams r2 = r1.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r2 == null) goto L21;
        Map r3 = r2.generaInitialData();
        if (r3 == null) goto L21;
        Map r4 = MapsKt.toMutableMap(r3);
        if (r4 == null) goto L21;
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L18
        JSONObject r6 = r2.addToCartEntranceInfo();     // Catch: Exception -> L18
        Iterator<String> r7 = r6.keys();     // Catch: Exception -> L18
    L12:
        if (r7.hasNext() == false) goto L16;
        String r8 = r7.next();     // Catch: Exception -> L18
        if (r4.containsKey(r8) == true) goto L12;
        r5.put(r8, r6.opt(r8));     // Catch: Exception -> L18
        goto L12
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L18
        r4.put("cart_track_params", r5);     // Catch: Exception -> L18
    L20:
        r0.putAll(r4);
    L18:
        e = move-exception;
        ye.a.b(e);
    L21:
        r0.put("ecom_scene_id", ControllerCenter.b(null).a());
        LivePromotionListParams r10 = this.params;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L24:
        String r11 = r10.getLiveListChannel();
        if (r11 == null) goto L27;
        r0.put("live_list_channel", r11);
    L27:
        return r0;
    }

    public final LivePromotionListParams getListParams() {
        LivePromotionListParams r0 = this.params;
        if (r0 == null) goto L6;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return r0;
    L8:
        return r0;
    L6:
        return null;
    }

    public final ECUIPromotionLiveListConfig getLiveListConfig() {
        return this.listRepository.r();
    }

    public final fi2.a getLiveRoomService() {
        fi2.a r0 = this.liveRoomService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
    L5:
        return r0;
    }

    public final LiveData<PagedList<mj2.c>> getPageListLiveData() {
        LiveData<PagedList<mj2.c>> r0 = this.pageListLiveData;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pageListLiveData");
    L5:
        return r0;
    }

    public final LivePromotionListParams getParams() {
        LivePromotionListParams r0 = this.params;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L5:
        return r0;
    }

    public final gi2.a getPromotionListParams() {
        gi2.a r0 = this.promotionListParams;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionListParams");
    L5:
        return r0;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c getRequestParam() {
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r0 = this.requestParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L5:
        return r0;
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.f getSkinHelper() {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L7;
        return this.listSkinHelper;
    L7:
        return ofPromotionListController().G;
    }

    public final List<ql.a> getTotalPromotions() {
        return this.listRepository.f();
    }

    public final boolean isPromotionListParamsInitialized() {
        if (this.promotionListParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void refreshPromotionListWithLoading() {
        this.listRepository.o();
    }

    public final void retry() {
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r0 = this.requestParam;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L6:
        if (r0.a != 0) goto L8;
        int r1 = 4;
    L12:
        mj2.i<mj2.c> r2 = this.listing;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("listing");
    L15:
        r2.b.invoke(Integer.valueOf(r1));
        return;
    L8:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r3 = this.requestParam;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L11:
        r1 = r3.a;
        goto L12
    }

    public final gi2.a safeGetPromotionListParams() {
        gi2.a r0 = this.promotionListParams;
        if (r0 == null) goto L6;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotionListParams");
        return r0;
    L8:
        return r0;
    L6:
        return null;
    }

    public final void updateECShoppingCartTask() {
        LivePromotionListParams r0 = this.params;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L5:
        String r1 = r0.getOpenMethod();
        LivePromotionListParams r2 = this.params;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L8:
        String r3 = r2.getShoppingCartTaskItemId();
        LivePromotionListParams r4 = this.params;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L11:
        String r5 = r4.getShoppingCartTaskMetaID();
        LivePromotionListParams r6 = this.params;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L14:
        int r7 = r6.getShoppingCartTaskScene();
        if (TextUtils.equals(r1, "live_shopping_cart") == true) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r3) == false) goto L19;
        return;
    L19:
        if (TextUtils.isEmpty(r5) == false) goto L21;
        return;
    L21:
        if (r7 != 2) goto L24;
        String r8 = "live_room_click_cart_by_task_list";
    L28:
        if (TextUtils.isEmpty(r8) == false) goto L30;
        return;
    L30:
        if (TextUtils.isEmpty(r5) == false) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(r3) == true) goto L40;
        this.listRepository.n(r5, r3, r8, new h(this));
        return;
    L40:
        return;
    L24:
        if (r7 != 1) goto L26;
        r8 = "live_room_click_cart_by_accident";
        goto L28
    L26:
        r8 = null;
        goto L28
    }

    public final void updateHintBannerInfo() {
        tj2.f r0 = this.listRepository;
        LivePromotionListParams r1 = this.params;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L5:
        String r2 = r1.getAnchorId();
        LivePromotionListParams r3 = this.params;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L8:
        String r4 = r3.getAnchorSecId();
        LivePromotionListParams r5 = this.params;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L11:
        r0.v(r2, r4, r5.getRoomId(), ofRoomContextController().D(), ofPromotionListController().v, getEntranceInfoWithoutOpt(), new i(this));
    }

    public final void updateWhenUseCache() {
        this.listRepository.k();
    }

    private final void reportSuccessInfoActionEvent() {
        if (EComABUtils.isArsEnable() == true) goto L5;
        return;
    L5:
        ECContext r0 = ofRoomContextController().r();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.i<yg2.a> r1 = r0.getEcLiveActionRecordService();
        if (r1 == null) goto L12;
        yg2.a r2 = (yg2.a) r1.getValue();
        if (r2 == null) goto L12;
        r2.d(new xg2.b(Action.SHOP_LIST_OPEN, MapsKt.mapOf(TuplesKt.to("use_cache", BDLocationException.ERROR_TIMEOUT))));
    L12:
        ECContext r3 = ofRoomContextController().r();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.i<yg2.a> r4 = r3.getEcLiveActionRecordService();
        if (r4 == null) goto L21;
        yg2.a r5 = (yg2.a) r4.getValue();
        if (r5 == null) goto L22;
        r5.d(new xg2.f(Action.SHOP_LIST_OPEN));
        return;
    L22:
        return;
    L21:
        return;
    }

    private final boolean shouldShowUserChooseStoreEntry() {
        return ofPromotionListController().A;
    }

    private final void updateUserChooseStoreEntryData() {
        if (shouldShowUserChooseStoreEntry() == false) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(this, com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.x.a);
        return;
    }

    public final boolean disableUpdateInteractionData() {
        if (shouldShowUserChooseStoreEntry() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.forceHideTopModule == true) goto L8;
        return false;
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.h getListItemLayoutHelper() {
        com.bytedance.android.livesdk.livecommerce.skin.e r0 = getLayoutHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.i getListItemSkinHelper() {
        com.bytedance.android.livesdk.livecommerce.skin.f r0 = getSkinHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListBaseViewModel
    public void onCleared() {
        super.onCleared();
        WeakReference<u> r0 = this.newSkuPanelService;
        if (r0 != null) goto L5;
    L9:
        this.listRepository.G();
        if (this.params == null) goto L32;
        PromotionListController r1 = ofPromotionListController();
        if (this.isDefaultTab == false) goto L19;
        ((ArrayList) r1.d).clear();
        LivePromotionListCacheCenter r2 = r1.F;
        if (r2 == null) goto L32;
        LivePromotionListParams r5 = this.params;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L18:
        ((ArrayList) r1.d).add(new PromotionListController.b(r2, r2, r5.getRoomId(), this.isDefaultTab));
        goto L32
    L19:
        Iterator r3 = ((ArrayList) r1.d).iterator();
    L21:
        if (r3.hasNext() == false) goto L28;
        Object r4 = r3.next();
        String r6 = ((PromotionListController.b) r4).c;
        LivePromotionListParams r7 = this.params;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L26:
        if (Intrinsics.areEqual(r6, r7.getRoomId()) == false) goto L21;
    L29:
        PromotionListController.b r8 = (PromotionListController.b) r4;
        if (r8 == null) goto L32;
        ((ArrayList) r1.d).remove(r8);
        goto L32
    L28:
        r4 = null;
    L32:
        this.repoMonitor.clear();
        this.viewCacheCenter.clear();
        this.timestampTracker.a.evictAll();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_JUMPDISPATCHER_OOM_FIX() == false) goto L39;
        ECLiveEventHelper.a = null;
        ECLiveEventHelper.b = null;
        return;
    L39:
        return;
    L5:
        if (r0.get() == null) goto L9;
        WeakReference<u> r9 = this.newSkuPanelService;
        if (r9 == null) goto L9;
        r9.clear();
        goto L9
    }

    public final Integer getAddCartOpt() {
        return this.addCartOpt;
    }

    public final Integer getAddCartToastOrder() {
        return this.addCartToastOrder;
    }

    public final String getAuthorSellScore() {
        return this.authorSellScore;
    }

    public final String getBtmPageId() {
        return this.btmPageId;
    }

    public final int getBuyButtonStyle() {
        return this.buyButtonStyle;
    }

    public final int getCurrentSelectedTabPosition() {
        return this.currentSelectedTabPosition;
    }

    public final LivePromotionPageDynamicOpenRegion getDynamicOpenRegion() {
        return this.dynamicOpenRegion;
    }

    public final JSONObject getEntranceInfo() {
        return this.entranceInfo;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a getFooterViewModel() {
        return this.footerViewModel;
    }

    public final boolean getForceHideTopModule() {
        return this.forceHideTopModule;
    }

    public final Function1<String, Pair<float[], float[]>> getGetCardLoc() {
        return this.getCardLoc;
    }

    public final Function0<Integer> getGetCurrentPosition() {
        return this.getCurrentPosition;
    }

    public final Function0<Integer> getGetCurrentTab() {
        return this.getCurrentTab;
    }

    public final wj2.g getInitialAction() {
        return this.initialAction;
    }

    public final yh2.a getInteractionData() {
        return this.interactionData;
    }

    public final int getLatestRequestType() {
        return this.latestRequestType;
    }

    public final com.bytedance.android.shopping.ligo.context.b<?> getLigoContext() {
        return this.ligoContext;
    }

    public final LigoViewManager getLigoViewManager() {
        return this.ligoViewManager;
    }

    public final com.bytedance.android.livesdk.livecommerce.iron.listheader.i getListHeaderViewModel() {
        return this.listHeaderViewModel;
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.e getListLayoutHelper() {
        return this.listLayoutHelper;
    }

    public final LivePromotionListScene getListScene() {
        return this.listScene;
    }

    public final com.bytedance.android.livesdk.livecommerce.skin.f getListSkinHelper() {
        return this.listSkinHelper;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b getListingViewModel() {
        return this.listingViewModel;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.c getMonitorViewModel() {
        return this.monitorViewModel;
    }

    public final jf.d getNewJumpHelper() {
        return this.newJumpHelper;
    }

    public final di2.b getPromotionListEventActionImpl() {
        return this.promotionListEventActionImpl;
    }

    public final ql.a getRecentExplainPromotion() {
        return this.recentExplainPromotion;
    }

    public final RoomContextController getRoomContextController() {
        return this.roomContextController;
    }

    public final LivePromotionPageRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public final String getSearchSchema() {
        return this.searchSchema;
    }

    public final LivePromotionListViewModel getSecondViewModel() {
        return this.secondViewModel;
    }

    public final int getShowAuthorConnect() {
        return this.showAuthorConnect;
    }

    public final String getStoreSchema() {
        return this.storeSchema;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b getTimestampTracker() {
        return this.timestampTracker;
    }

    public final int getTotal() {
        return this.total;
    }

    public final x83.a getViewCacheCenter() {
        return this.viewCacheCenter;
    }

    public final boolean isDefaultTab() {
        return this.isDefaultTab;
    }

    public final boolean isInSplitScreen() {
        return this.isInSplitScreen;
    }

    public static final /* synthetic */ tj2.f access$getListRepository$p(LivePromotionListViewModel r0) {
        return r0.listRepository;
    }

    public static final /* synthetic */ jf.d access$getNewJumpHelper$p(LivePromotionListViewModel r0) {
        return r0.newJumpHelper;
    }

    public static final /* synthetic */ WeakReference access$getNewSkuPanelService$p(LivePromotionListViewModel r0) {
        return r0.newSkuPanelService;
    }

    public static final /* synthetic */ d access$getSkuAbility$p(LivePromotionListViewModel r0) {
        return r0.getSkuAbility();
    }

    public static final /* synthetic */ PromotionListController access$ofPromotionListController(LivePromotionListViewModel r0) {
        return r0.ofPromotionListController();
    }

    private final String getListBackgroundColor(LivePromotionPageHeaderData r2) {
        if (r2 == null) goto L13;
        String r3 = r2.getBackgroundColor();
        if (r3 == null) goto L13;
        if (r3.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L13;
        return r3;
    L8:
        r0 = false;
    L13:
        return "#FFFFFF";
    }

    private final int getListHeaderMarginBottom(mj2.e r5) {
        LivePromotionPageCategoryData r0 = r5.p;
        if (r0 == null) goto L9;
        List<PromotionCategory> r1 = r0.getCategories();
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        boolean r2 = true;
    L10:
        LivePromotionPageHeaderData r6 = r5.m;
        if (r6 == null) goto L15;
        ECPromotionHeaderLayoutControl r7 = r6.getLayoutControl();
        if (r7 == null) goto L15;
        Integer r8 = Integer.valueOf(r7.getHeaderStyle());
    L16:
        if (r2 == false) goto L19;
        return 0;
    L19:
        if (r8 != null) goto L22;
    L23:
        if (r8 != null) goto L26;
    L28:
        if (r8 != null) goto L31;
        return 0;
    L31:
        if (r8.intValue() == 0) goto L33;
        return 0;
    L33:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_LIST_HEADER_EXTRA_PADDING_ENABLE() == false) goto L37;
    L34:
        return 8;
    L37:
        return 0;
    L26:
        if (r8.intValue() != 6) goto L28;
    L22:
        if (r8.intValue() == 5) goto L34;
    L15:
        r8 = null;
    L9:
        r2 = false;
        goto L10
    }

    private final void setShouldShowUserChooseStoreEntry(boolean r2) {
        ofPromotionListController().A = r2;
    }

    private final void updateListScene(mj2.e r2) {
        LivePromotionPageDynamicOpenRegion r3 = r2.w;
        if (r3 == null) goto L9;
        ll.a r4 = r3.getListOpenSidebar();
        if (r4 == null) goto L9;
        if (r4.d() != 7) goto L9;
        this.listScene = LivePromotionListScene.INSTANT_RETAIL_FUSION;
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i(UtilityKotlinExtentionsKt.d(4)));
        return;
    L9:
        this.listScene = LivePromotionListScene.NORMAL;
    }

    public final void forceRefreshCategoryPromotions(PromotionCategory r3) {
        Intrinsics.checkNotNullParameter(r3, "category");
        this.listRepository.i();
        this.listRepository.e(r3.getUniqueIndex());
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e(r3));
        this.listRepository.j(r3);
    }

    @Override // tj2.a
    public void notifyListUpdateToast(String r3) {
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k(new m(r3)));
    }

    public final void notifyPromotionCardShowBottomAddOnFloor(com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cardRegionData");
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0(r2));
    }

    @Override // tj2.a
    public void notifyTotalChanged(int r2) {
        Handler r0 = k.a;
        int r1 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L5;
        r3.notifyMiniApp(r2);
    L5:
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r4 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.listHeaderViewModel.a.getValue();
        if (r4 == null) goto L9;
        r4.h = r2;
        return;
    }

    @Override // tj2.a
    public void onProductRefreshMsgReceived(we3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.v(r2));
    }

    public final void refreshPromotionListForStoreChange(boolean r2) {
        if (r2 == false) goto L7;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r3 = this.requestParam;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L6:
        r3.e = true;
    L7:
        refreshPromotionListWithLoading();
    }

    public final void registerDataRefreshHandler(rj2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "refreshHandler");
        this.listRepository.u(r2);
    }

    public final void reportFirstBindPromotionMonitorIfNeed(com.bytedance.android.ec.monitor.duration.h r4) {
        if (this.isDefaultTab == false) goto L9;
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.c r0 = this.monitorViewModel;
        LivePromotionListParams r1 = this.params;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L7:
        r0.k(r1.getRoomId(), r4);
        return;
    }

    public final void retryLoadMore(boolean r3) {
        mj2.i<mj2.c> r0 = this.listing;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listing");
    L5:
        r0.c.invoke(Boolean.valueOf(r3));
    }

    public final void scrollToTop(PromotionCategory r2) {
        if (r2 != null) goto L5;
        r2 = this.listRepository.b();
    L5:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d0(r2));
    }

    public final void setAddCartOpt(Integer r1) {
        this.addCartOpt = r1;
    }

    public final void setAddCartToastOrder(Integer r1) {
        this.addCartToastOrder = r1;
    }

    public final void setAuthorSellScore(String r1) {
        this.authorSellScore = r1;
    }

    public final void setBtmPageId(String r1) {
        this.btmPageId = r1;
    }

    public final void setBuyButtonStyle(int r1) {
        this.buyButtonStyle = r1;
    }

    public final void setCurrentSelectedTabPosition(int r1) {
        this.currentSelectedTabPosition = r1;
    }

    public final void setDefaultTab(boolean r1) {
        this.isDefaultTab = r1;
    }

    public final void setDynamicOpenRegion(LivePromotionPageDynamicOpenRegion r1) {
        this.dynamicOpenRegion = r1;
    }

    public final void setEntranceInfo(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceInfo = r2;
    }

    public final void setForceHideTopModule(boolean r1) {
        this.forceHideTopModule = r1;
    }

    public final void setGetCardLoc(Function1<? super String, Pair<float[], float[]>> r1) {
        this.getCardLoc = r1;
    }

    public final void setGetCurrentPosition(Function0<Integer> r1) {
        this.getCurrentPosition = r1;
    }

    public final void setGetCurrentTab(Function0<Integer> r1) {
        this.getCurrentTab = r1;
    }

    public final void setInSplitScreen(boolean r2) {
        this.isInSplitScreen = r2;
        this.listHeaderViewModel.e = r2;
    }

    public final void setInitialAction(wj2.g r1) {
        this.initialAction = r1;
    }

    public final void setLatestRequestType(int r1) {
        this.latestRequestType = r1;
    }

    public final void setLigoContext(com.bytedance.android.shopping.ligo.context.b<?> r1) {
        this.ligoContext = r1;
    }

    public final void setLigoViewManager(LigoViewManager r1) {
        this.ligoViewManager = r1;
    }

    public final void setListLayoutHelper(com.bytedance.android.livesdk.livecommerce.skin.e r1) {
        this.listLayoutHelper = r1;
    }

    public final void setListScene(LivePromotionListScene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.listScene = r2;
    }

    public final void setListSkinHelper(com.bytedance.android.livesdk.livecommerce.skin.f r1) {
        this.listSkinHelper = r1;
    }

    public final void setLiveRoomService(fi2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveRoomService = r2;
    }

    public final void setPageListLiveData(LiveData<PagedList<mj2.c>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageListLiveData = r2;
    }

    public final void setParams(LivePromotionListParams r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.params = r2;
    }

    public final void setPromotionListEventActionImpl(di2.b r1) {
        this.promotionListEventActionImpl = r1;
    }

    public final void setPromotionListParams(gi2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.promotionListParams = r2;
    }

    public final void setRecentExplainPromotion(ql.a r1) {
        this.recentExplainPromotion = r1;
    }

    public final void setRequestParam(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.requestParam = r2;
    }

    public final void setRoomContextController(RoomContextController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomContextController = r2;
    }

    public final void setRoomInfo(LivePromotionPageRoomInfo r1) {
        this.roomInfo = r1;
    }

    public final void setSearchSchema(String r1) {
        this.searchSchema = r1;
    }

    public final void setSecondViewModel(LivePromotionListViewModel r1) {
        this.secondViewModel = r1;
    }

    public final void setShowAuthorConnect(int r1) {
        this.showAuthorConnect = r1;
    }

    public final void setStoreSchema(String r1) {
        this.storeSchema = r1;
    }

    public final void setTotal(int r1) {
        this.total = r1;
    }

    public final void updateAllViewsVisible(boolean r2) {
        this.listRepository.D(r2);
    }

    @Override // tj2.a
    public void updateLoadInitialStatus(final mj2.h<PageListLoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "wrapper");
        setState(new C03081(r2));
    }

    @Override // tj2.a
    public void updatePromotionListTopData(mj2.e r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        LivePromotionPageRoomInfo r0 = r4.j;
        if (r0 == null) goto L5;
        boolean r1 = r0.getUserChooseStore();
    L6:
        setShouldShowUserChooseStoreEntry(r1);
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == true) goto L13;
        ECPromotionListTopData r5 = r4.l;
        if (r5 == null) goto L11;
        List r6 = r5.getInteractionData();
    L12:
        tj2.a.C0175a.a(this, r6, true, false, 12);
        goto L13
    L11:
        r6 = null;
    L13:
        updateUserChooseStoreEntryData();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void updatePromotionsFromSettlement(JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        if (Intrinsics.areEqual(r14.optString("action_type"), "clear_cart") == false) goto L5;
        refreshProductList$default(this, 1, 6, null, null, true, true, false, null, false, 460, null);
    L5:
        JSONArray r15 = r14.optJSONArray("cart_list");
        if (r15 != null) goto L8;
        return;
    L8:
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        int r2 = r15.length();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L15;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r15, r4);
        String r6 = r5.optString("product_id");
        if (r6 == null) goto L14;
        r0.put(r6, Integer.valueOf(r5.optInt("combo_num")));
    L14:
        r4 = r4 + 1;
        goto L9
    L15:
        Iterator<T> r16 = this.listRepository.f().iterator();
        int r3 = 0;
    L17:
        if (r16.hasNext() == false) goto L45;
        Object r7 = r16.next();
        int r8 = r3 + 1;
        if (r3 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        ql.a r9 = (ql.a) r7;
        com.bytedance.android.ec.model.response.v r10 = r9.getStepperInfo();
        if (r0.containsKey(r9.getProductId()) == false) goto L36;
        if (r10 == null) goto L25;
        Integer r11 = Integer.valueOf(r10.b());
    L27:
        if ((!Intrinsics.areEqual(r11, (Integer) r0.get(r9.getProductId()))) == false) goto L43;
        if (r10 == null) goto L34;
        Integer r12 = (Integer) r0.get(r9.getProductId());
        if (r12 == null) goto L32;
        int r13 = r12.intValue();
    L33:
        r10.d(r13);
        goto L34
    L32:
        r13 = 0;
    L34:
        r1.add(Integer.valueOf(r3));
    L43:
        r3 = r8;
        goto L17
    L25:
        r11 = null;
        goto L27
    L36:
        if (r9.shouldShowStepper() == false) goto L43;
        if (r10 != null) goto L39;
    L40:
        if (r10 == null) goto L42;
        r10.d(0);
    L42:
        r1.add(Integer.valueOf(r3));
        goto L43
    L39:
        if (r10.b() == 0) goto L43;
    L45:
        if ((!r1.isEmpty()) == false) goto L47;
    L48:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r18 = r1.iterator();
    L50:
        if (r18.hasNext() == false) goto L52;
        r17.add(new x(((Number) r18.next()).intValue(), UpdateLocalViewType.UPDATE_BUTTON_INFO));
        goto L50
    L52:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.t(r17));
        return;
    L47:
        if ((!r0.isEmpty()) == true) goto L48;
    }

    public static final /* synthetic */ String access$getListBackgroundColor(LivePromotionListViewModel r0, LivePromotionPageHeaderData r1) {
        return r0.getListBackgroundColor(r1);
    }

    public static final /* synthetic */ int access$getListHeaderMarginBottom(LivePromotionListViewModel r0, mj2.e r1) {
        return r0.getListHeaderMarginBottom(r1);
    }

    public static final /* synthetic */ void access$setNewJumpHelper$p(LivePromotionListViewModel r0, jf.d r1) {
        r0.newJumpHelper = r1;
    }

    public static final /* synthetic */ void access$setNewSkuPanelService$p(LivePromotionListViewModel r0, WeakReference r1) {
        r0.newSkuPanelService = r1;
    }

    public static final /* synthetic */ void access$setState(LivePromotionListViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private final String generateRelatedInfo(String r5, JSONObject r6) {
        if (cg4.a.a(r5) == true) goto L13;
        LivePromotionListParams r0 = this.params;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L8:
        if (cg4.a.a(r0.getScrollPromotionId()) == true) goto L13;
        if (r6 != null) goto L33;
        return null;
    L33:
        return r6.toString();
    L13:
        JSONObject r1 = new JSONObject();
        LivePromotionListParams r2 = this.params;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L16:
        String r3 = r2.getScrollPromotionId();
        if (r3 == null) goto L27;
        LivePromotionListParams r4 = this.params;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L22:
        if (r4.isPromotionId() == false) goto L24;
        String r7 = "anchor_promotion_id";
    L26:
        if (r1.put(r7, r3) == null) goto L27;
    L29:
        if (r5 == null) goto L32;
        r1.put("resort_promotion_category", r5);
    L32:
        return r1.toString();
    L24:
        r7 = "anchor_product_id";
    L27:
        if (r6 == null) goto L29;
        z1.b(r1, r6);
        goto L29
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.card.g createLivePromotionCardArgument(s r20, j r21) {
        Intrinsics.checkNotNullParameter(r20, "btmHandler");
        Intrinsics.checkNotNullParameter(r21, "itemListHandler");
        Intrinsics.checkNotNullParameter(r20, "$this$toBtmInfo");
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.g(new com.bytedance.android.livesdk.livecommerce.promotion.card.g.a(r20.f(null), r20.d(null), r20.h(null), r20.e(null), r20.i(null), r20.j(null), r20.k(null), r20.g(null), r20.a(null), r20.b(null), null, true, 7168), new b(this, r21), new c(this), new e(this), getEventMap());
    }

    @Override // tj2.a
    public void notifyAuthorDisconnect(boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "toast");
        if (r14 == true) goto L5;
        setState(C03001.INSTANCE);
    L5:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r16 = this.requestParam;
        if (r16 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L9:
        if (this.isDefaultTab == false) goto L17;
        fi2.a r0 = this.liveRoomService;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
    L14:
        if (r0.isLinkmic() == true) goto L17;
        boolean r1 = false;
    L18:
        r16.k = r1;
        refreshProductList$default(this, 10, 3, null, null, true, true, false, r15, true, 76, null);
        return;
    L17:
        r1 = true;
        goto L18
    }

    @Override // tj2.a
    public void optUpdateCategories(final List<PromotionCategory> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "newCategories");
        setState(new C03051(r2));
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k(new m(r3)));
    }

    @Override // tj2.a
    public void reportTabFirstPageLoadResult(String r2, int r3) {
        oh.a.b("livesdk_list_load_result", new g(this, r3, r2));
    }

    public final void updateCategoryPromotions(PromotionCategory r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "category");
        PromotionCategory r0 = this.listRepository.b();
        if (r0 == null) goto L5;
        String r1 = r0.getUniqueIndex();
    L7:
        if ((!Intrinsics.areEqual(r1, r3.getUniqueIndex())) == true) goto L9;
        if (r4 == true) goto L9;
        return;
    L9:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e(r3));
        this.listRepository.j(r3);
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // tj2.a
    public void updateExplainPromotion(String r5, List<String> r6) {
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i0(r5, r6));
        if (r5 == null) goto L10;
        ql.a r1 = this.recentExplainPromotion;
        if (r1 == null) goto L7;
        String r2 = r1.getPromotionId();
    L8:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k(new m("讲解商品已更新", Intrinsics.areEqual(r5, r2), 2)));
        this.recentExplainPromotion = this.listRepository.g();
        getEventMap().e("livesdk_ecom_gift_bar_show", r5);
        getEventMap().e("livesdk_show_product_explaining", r5);
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // tj2.a
    public void updateLoadMoreStatus(PageListLoadStatus r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "status");
        if (r3 == false) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l(r2));
        return;
    L5:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m(r2));
    }

    public void updateProductList(String r13, Integer r14) {
        if (r14 == null) goto L4;
        int r1 = r14.intValue();
    L5:
        refreshProductList$default(this, r1, null, "", null, false, false, false, r13, false, 378, null);
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == false) goto L18;
        tj2.f r0 = this.listRepository;
        LivePromotionListParams r15 = this.params;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L10:
        String r2 = r15.getRoomId();
        LivePromotionListParams r16 = this.params;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L13:
        String r3 = r16.getAnchorId();
        LivePromotionListParams r17 = this.params;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L16:
        r0.p(r2, r3, r17.getAnchorSecId(), false, new C03091(this));
        return;
    L18:
        return;
    L4:
        r1 = 1;
        goto L5
    }

    public final void updateWhenBackFromOtherPage(Integer r13, boolean r14) {
        refreshProductList$default(this, 3, null, null, r13, true, true, r14, null, true, 134, null);
        int r15 = ECSdk.a;
        b93.c r16 = (b93.c) ECSdk.a(b93.c.class);
        if (r16 == null) goto L7;
        b93.b r17 = r16.b();
        if (r17 == null) goto L7;
        r17.sendEvent("list_back_from_other_page", new JSONObject());
    L7:
        LigoViewManager r18 = this.ligoViewManager;
        if (r18 == null) goto L37;
        Iterator r19 = r18.a.keySet().iterator();
    L11:
        if (r19.hasNext() == false) goto L49;
        ViewGroup r0 = (ViewGroup) r19.next();
        HashMap r1 = (HashMap) r18.a.get(r0);
        if (r1 == null) goto L11;
        Collection r2 = r1.values();
        if (r2 == null) goto L11;
        Iterator r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L11;
        ll.c r4 = (ll.c) r3.next();
        Integer r5 = r4.getIdentifier().a;
        Object r6 = null;
        if (r5 == null) goto L23;
        View r7 = r0.findViewById(r5.intValue());
        if (r7 == null) goto L23;
    L27:
        if (r7 == null) goto L29;
        Object r8 = r7.getTag(2131370717);
    L31:
        if ((r8 instanceof ti.l) == false) goto L34;
        r6 = r8;
    L34:
        ti.l r9 = (ti.l) r6;
        if (r9 == null) goto L18;
        dm.a.a("LigoViewManager").i("id: " + r7.getId() + " send pageVisibilityChange=true");
        JSONObject r10 = new JSONObject();
        r10.put("visible", true);
        r10.put("source", "page");
        Unit r11 = Unit.INSTANCE;
        r9.sendJsEvent("pageVisibilityChange", r10);
        goto L18
    L29:
        r8 = null;
    L23:
        String r12 = r4.getIdentifier().b;
        if (r12 == null) goto L26;
        r7 = r0.findViewWithTag(r12);
        goto L27
    L26:
        r7 = null;
        goto L27
    L49:
        return;
    }

    private final void onSuccessCallback(final mj2.e r24, final List<PromotionCategory> r25, int r26) {
        PromotionCategory.a r3 = PromotionCategory.Companion;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r4 = this.requestParam;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L5:
        String r5 = r4.b;
        r3.getClass();
        if (PromotionCategory.a.b(r5) == false) goto L8;
        this.total = r24.h;
    L8:
        LivePromotionListABConfig r6 = r24.k;
        ECPromotionSingleEntry r7 = null;
        if (r6 == null) goto L11;
        Integer r8 = r6.getAddCartOpt();
    L12:
        this.addCartOpt = r8;
        LivePromotionListABConfig r9 = r24.k;
        if (r9 == null) goto L15;
        Integer r10 = Integer.valueOf(r9.getAddCartToastOrder());
    L16:
        this.addCartToastOrder = r10;
        LivePromotionPageDynamicOpenRegion r11 = r24.w;
        this.dynamicOpenRegion = r11;
        if (r11 == null) goto L19;
        ll.a r12 = r11.getListOpenTop();
    L21:
        if (r12 == null) goto L23;
        this.forceHideTopModule = true;
    L23:
        PromotionListController r13 = ofPromotionListController();
        LivePromotionPageRoomInfo r14 = r24.j;
        this.roomInfo = r14;
        if (r14 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        r13.w = r15;
        LivePromotionPageRoomInfo r16 = r24.j;
        if (r16 == null) goto L32;
        String r17 = r16.getHourlyPurchaseShopId();
    L33:
        String r18 = "";
        if (r17 != null) goto L36;
        r17 = "";
    L36:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r13.y = r17;
        LivePromotionPageRoomInfo r19 = r24.j;
        if (r19 == null) goto L39;
        String r20 = r19.getStoreId();
    L40:
        if (r20 != null) goto L42;
        r20 = "";
    L42:
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r13.z = r20;
        LivePromotionPageRoomInfo r21 = r24.j;
        if (r21 == null) goto L45;
        r21.getReceiveAddressId();
    L45:
        LivePromotionPageRoomInfo r22 = r24.j;
        if (r22 == null) goto L48;
        r22.getAddressType();
    L48:
        LivePromotionPageRoomInfo r23 = r24.j;
        if (r23 == null) goto L51;
        r23.getAddressStrategy();
    L51:
        LivePromotionPageRoomInfo r27 = r24.j;
        if (r27 == null) goto L54;
        int r28 = r27.getRoomType();
    L55:
        r13.s = r28;
        LivePromotionPageHeaderData r29 = r24.m;
        if (r29 == null) goto L58;
        String r30 = r29.getCallback();
    L59:
        r13.Q = r30;
        mj2.f r31 = r24.r;
        if (r31 == null) goto L62;
        List<String> r32 = r31.b();
    L63:
        ECLiveListSkinUIHelper r110 = r13.G;
        if (r110 == null) goto L69;
        if (r32 != null) goto L67;
        r32 = CollectionsKt.emptyList();
    L67:
        r110.h(r32);
    L72:
        ECLiveABUtils r33 = ECLiveABUtils.INSTANCE;
        if (r33.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L75;
        this.listSkinHelper = r13.G;
    L75:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r111 = this.requestParam;
        if (r111 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L79:
        if (PromotionCategory.a.b(r111.b) == false) goto L99;
        b1 r112 = r24.s;
        if (r112 == null) goto L83;
        List<String> r113 = r112.a();
    L84:
        boolean r114 = this.isInSplitScreen;
        com.bytedance.android.livesdk.livecommerce.skin.a r115 = r13.H;
        if (r115 == null) goto L90;
        if (r113 != null) goto L88;
        r113 = CollectionsKt.emptyList();
    L88:
        r115.b(r113);
    L93:
        com.bytedance.android.livesdk.livecommerce.skin.a r116 = r13.H;
        if (r116 == null) goto L97;
        r116.c(r114);
    L97:
        if (r33.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L99;
        this.listLayoutHelper = r13.H;
        goto L99
    L90:
        if (r113 != null) goto L92;
        r113 = CollectionsKt.emptyList();
    L92:
        r13.H = new com.bytedance.android.livesdk.livecommerce.skin.a(r113);
        Unit r117 = Unit.INSTANCE;
        goto L93
    L83:
        r113 = null;
    L99:
        if (r26 != 0) goto L105;
        List<? extends ql.a> r34 = r24.a;
        if (r34 == null) goto L103;
        int r35 = r34.size();
    L104:
        r13.t = r35;
        goto L105
    L103:
        r35 = -1;
    L105:
        r13.u = r24.h;
        if (xh2.c.a(r26) == false) goto L108;
    L111:
        boolean r36 = true;
    L112:
        if (r36 == false) goto L134;
        LivePromotionListABConfig r37 = r24.k;
        if (r37 == null) goto L116;
        int r38 = r37.getShowAuthorConnect();
    L117:
        this.showAuthorConnect = r38;
        setState(new C03031(r24));
        LivePromotionPageListTop r39 = r24.n;
        if (r39 == null) goto L129;
        Toggle r40 = r39.getToggle();
        if (r40 == null) goto L129;
        List<ToggleElement> r41 = r40.getElements();
        if (r41 == null) goto L129;
        if (r41.size() <= 1) goto L126;
        boolean r118 = true;
    L127:
        if (r118 == false) goto L129;
    L130:
        if (r41 == null) goto L132;
        boolean r42 = true;
    L133:
        r13.I = Boolean.valueOf(r42);
        goto L134
    L132:
        r42 = false;
        goto L133
    L126:
        r118 = false;
    L129:
        r41 = null;
        goto L130
    L116:
        r38 = 0;
    L134:
        setState(new C03043(this, r24, r25));
        LivePromotionPageHeaderData r43 = r24.m;
        if (r43 == null) goto L143;
        ECPromotionList.o r44 = r43.getListBanner();
        if (r44 == null) goto L143;
        ECPromotionList.p r45 = r44.listBannerInfo;
        if (r45 == null) goto L143;
        if (r45.bannerType != 14) goto L143;
        updateHintBannerInfo();
    L143:
        notifyTotalChanged(r24.h);
        this.latestRequestType = r26;
        if (xh2.c.a(r26) == true) goto L146;
    L169:
        com.bytedance.android.livesdk.livecommerce.iron.listheader.i r2 = this.listHeaderViewModel;
        LinkedHashMap r46 = new LinkedHashMap();
        LivePromotionListParams r47 = this.params;
        if (r47 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L172:
        r46.put("anchor_id", r47.getAnchorId());
        LivePromotionListParams r48 = this.params;
        if (r48 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L175:
        r46.put("anchor_sec_id", r48.getAnchorSecId());
        LivePromotionListParams r49 = this.params;
        if (r49 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L178:
        r46.put("room_id", r49.getRoomId());
        r46.put("room_unique_key", this.roomContextController.D());
        r46.put("entrance_info", getEntranceInfoWithoutOpt());
        LivePromotionPageHeaderData r50 = r24.m;
        if (r50 == null) goto L186;
        ECPromotionList.f r51 = r50.getAuthorShopInfo();
        if (r51 == null) goto L186;
        ECPromotionList.d r52 = r51.authorReputationInside;
        if (r52 == null) goto L186;
        String r53 = String.valueOf(r52.score);
        if (r53 == null) goto L186;
    L194:
        r46.put("author_sell_score", r53);
        LivePromotionListParams r54 = this.params;
        if (r54 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L197:
        String r55 = r54.getLiveListChannel();
        if (r55 != null) goto L200;
        r55 = "";
    L200:
        r46.put("live_list_channel", r55);
        ECUIPromotionLiveListConfig r119 = getLiveListConfig();
        if (r119 == null) goto L203;
        Lazy r56 = Json.a;
        String r57 = Json.d(ECUIPromotionLiveListConfig.copy$default(r119, r119.getShouldShowFindSimilar(), null, false, null, 14, null));
    L204:
        if (r57 != null) goto L206;
        r57 = "";
    L206:
        r46.put("promotion_live_list_config", r57);
        String r58 = this.btmPageId;
        if (r58 == null) goto L210;
        r18 = r58;
    L210:
        r46.put("btm_page_id", r18);
        gi2.a r59 = this.promotionListParams;
        if (r59 == null) goto L213;
        r2.g = r59;
    L213:
        MutableLiveData<com.bytedance.android.livesdk.livecommerce.iron.listheader.b> r60 = r2.a;
        int r61 = com.bytedance.android.livesdk.livecommerce.iron.listheader.b.m;
        LivePromotionListParams r62 = this.params;
        if (r62 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L216:
        String r63 = r62.getCouponId();
        LivePromotionPageRoomInfo r64 = r24.j;
        if (r64 != null) goto L219;
    L221:
        boolean r120 = false;
    L222:
        Intrinsics.checkNotNullParameter(r24, "response");
        Intrinsics.checkNotNullParameter(r46, "extraParams");
        LivePromotionPageHeaderData r65 = r24.m;
        if (r65 == null) goto L225;
        Map<String, List<ECRitTag>> r121 = r65.getAnchorTags();
    L226:
        LivePromotionPageHeaderData r66 = r24.m;
        if (r66 == null) goto L229;
        ECPromotionList.d r122 = r66.getAuthorReputation();
    L230:
        LivePromotionPageHeaderData r67 = r24.m;
        if (r67 == null) goto L233;
        ECPromotionList.v r123 = r67.getStoreEntranceInfo();
    L234:
        LivePromotionPageHeaderData r68 = r24.m;
        if (r68 == null) goto L237;
        ECPromotionList.f r124 = r68.getAuthorShopInfo();
    L238:
        LivePromotionPageHeaderData r69 = r24.m;
        if (r69 == null) goto L241;
        List<ECPromotionEntry> r125 = r69.getEntries();
    L242:
        boolean r126 = cg4.a.a(r63);
        int r70 = r24.h;
        LivePromotionPageHeaderData r71 = r24.m;
        if (r71 == null) goto L245;
        ECPromotionHeaderLayoutControl r210 = r71.getLayoutControl();
    L246:
        LivePromotionPageHeaderData r72 = r24.m;
        if (r72 == null) goto L249;
        ECPromotionEnhancedSearchEntry r211 = r72.getEnhanceSearchEntry();
    L250:
        LivePromotionPageHeaderData r73 = r24.m;
        if (r73 == null) goto L253;
        r7 = r73.getSingleEntry();
    L253:
        r60.postValue(new com.bytedance.android.livesdk.livecommerce.iron.listheader.b(r121, r122, r123, r124, r125, r46, r126, r70, r120, r210, r211, r7));
        updatePromotionListTopData(r24);
        return;
    L249:
        r211 = null;
        goto L250
    L245:
        r210 = null;
        goto L246
    L241:
        r125 = null;
        goto L242
    L237:
        r124 = null;
        goto L238
    L233:
        r123 = null;
        goto L234
    L229:
        r122 = null;
        goto L230
    L225:
        r121 = null;
        goto L226
    L219:
        if (r64.getRoomType() != 1) goto L221;
        r120 = true;
        goto L222
    L203:
        r57 = null;
    L186:
        LivePromotionPageHeaderData r74 = r24.m;
        if (r74 == null) goto L191;
        ECPromotionList.d r75 = r74.getAuthorReputation();
        if (r75 == null) goto L191;
        r53 = String.valueOf(r75.score);
    L192:
        if (r53 != null) goto L194;
        r53 = "";
    L191:
        r53 = null;
        goto L192
    L146:
        if (r24.v == false) goto L149;
        reportSuccessInfoActionEvent();
        com.bytedance.android.ec.core.arch.event.c.d(this, com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.n.a);
    L149:
        if (r24.u == true) goto L168;
        LivePromotionPageHintData r76 = r24.o;
        if (r76 == null) goto L153;
        JsonObject r77 = r76.getApplyResp();
    L154:
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.C0097a(r77));
        if (EComABUtils.useNewLiveListAutoApplyCouponOpt() != 1) goto L169;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r78 = this.requestParam;
        if (r78 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L159:
        r78.n = false;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r79 = this.requestParam;
        if (r79 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L163:
        if (r79.o <= 0) goto L169;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r80 = this.requestParam;
        if (r80 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L167:
        r80.o = 1;
        goto L169
    L153:
        r77 = null;
        goto L154
    L168:
        updateWhenUseCache();
        goto L169
    L108:
        if (r26 == 10) goto L111;
        r36 = false;
        goto L112
    L69:
        if (r32 != null) goto L71;
        r32 = CollectionsKt.emptyList();
    L71:
        r13.G = new ECLiveListSkinUIHelper(r32, r13.A().t.L());
        Unit r81 = Unit.INSTANCE;
        goto L72
    L62:
        r32 = null;
        goto L63
    L58:
        r30 = null;
        goto L59
    L54:
        r28 = 0;
        goto L55
    L39:
        r20 = null;
        goto L40
    L32:
        r17 = null;
        goto L33
    L26:
        if (r14.getMinimumGuaranteeAddress() != 1) goto L28;
        r15 = true;
        goto L29
    L19:
        r12 = null;
        goto L21
    L15:
        r10 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    }

    public final boolean addCartSuccessForAnim(View r16, ql.a r17, final Function0<Unit> r18) {
        Intrinsics.checkNotNullParameter(r16, "cartView");
        gi2.a r1 = this.promotionListParams;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionListParams");
    L5:
        com.bytedance.android.ec.common.api.jump.model.f r2 = r1.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        Float r3 = null;
        if (r2 == null) goto L8;
        jf.e r4 = r2.d;
    L10:
        if (Intrinsics.areEqual(r4, jf.e.f.b) == false) goto L13;
        dm.a.a("LiveAddCart").i("addCartSuccessForAnim -> play add cart anim for search page promotion card.");
        return true;
    L13:
        boolean r5 = false;
        if (r17 == null) goto L22;
        ql.b r6 = r17.getClientData();
        if (r6 == null) goto L22;
        ECUIPromotionLiveListConfig r7 = r6.g;
        if (r7 == null) goto L22;
        Integer r8 = r7.getAddCartOpt();
        if (r8 == null) goto L22;
        int r9 = r8.intValue();
    L23:
        if (r9 != 0) goto L30;
        int r10 = wj2.f.a;
        LivePromotionListParams r11 = this.params;
        if (r11 == null) goto L27;
        String r12 = r11.getContainerRoomId();
    L29:
        if (wj2.f.a(r12, this.roomContextController.D()) == true) goto L30;
    L31:
        dm.a.a("LiveAddCart").i("addCartSuccessForAnim -> addCartOpt = " + r5);
        if (r5 == true) goto L49;
        int r13 = ECSdk.a;
        final l r14 = (l) ECSdk.a(l.class);
        if (r14 == null) goto L36;
        final float[] r15 = r14.Pa();
    L37:
        int r19 = wj2.c.a;
        Context r20 = r16.getContext();
        float[] r21 = wj2.d.a(r16);
        if (r14 == null) goto L40;
        View r22 = r14.Ia();
    L42:
        if (r15 == null) goto L44;
        Float r110 = Float.valueOf(10.0f);
    L45:
        if (r15 == null) goto L48;
        r3 = Float.valueOf(10.0f);
    L48:
        return wj2.c.a(r20, r21, r15, r16, r22, 0, null, r110, r3, false, null, new AnonymousClass1(r15, r14, r18));
    L44:
        r110 = null;
        goto L45
    L40:
        r22 = null;
        goto L42
    L36:
        r15 = null;
        goto L37
    L49:
        return true;
    L27:
        r12 = null;
    L30:
        r5 = true;
    L22:
        r9 = 0;
        goto L23
    L8:
        r4 = null;
        goto L10
    }

    public final void getPromotionById(String r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        this.listRepository.c(r2, r3, r4);
    }

    @Override // tj2.a
    public void updateDataChangeByIds(List<String> r2, boolean r3, UpdateLocalViewType r4) {
        Intrinsics.checkNotNullParameter(r4, "updateType");
        this.listingViewModel.m(r2, r3, r4);
    }

    @Override // tj2.a
    public void updatePageResponse(mj2.e r7, List<PromotionCategory> r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "response");
        LivePromotionListABConfig r0 = r7.k;
        String r1 = null;
        if (r0 == null) goto L20;
        String r2 = r0.getStoreSchema();
        if (r2 == null) goto L20;
        if (cg4.a.a(r2) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L20;
        UrlBuilderV2 r3 = new UrlBuilderV2(r2);
        JSONObject r4 = new JSONObject();
        ECEventUtilsV2 r5 = ECEventUtilsV2.b;
        gi2.a r6 = this.promotionListParams;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("promotionListParams");
    L14:
        LiveRoomParams r10 = r6.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r10 == null) goto L18;
        Map r11 = r10.getReportParams();
        if (r11 == null) goto L18;
    L19:
        r5.getClass();
        r4.put("live_guide_store", ECEventUtilsV2.d(r11));
        Unit r12 = Unit.INSTANCE;
        r3.addOrReplaceParam("entrance_info", r4);
        String r13 = r3.build();
    L21:
        this.storeSchema = r13;
        LivePromotionPageHeaderData r14 = r7.m;
        if (r14 == null) goto L24;
        String r15 = r14.getSearchSchema();
    L25:
        this.searchSchema = r15;
        LivePromotionPageHeaderData r16 = r7.m;
        if (r16 == null) goto L35;
        ECPromotionList.f r17 = r16.getAuthorShopInfo();
        if (r17 == null) goto L35;
        ECPromotionList.d r18 = r17.authorReputationInside;
        if (r18 == null) goto L35;
        String r19 = String.valueOf(r18.score);
        if (r19 == null) goto L35;
        r1 = r19;
    L40:
        this.authorSellScore = r1;
        updateListScene(r7);
        LivePromotionListABConfig r20 = r7.k;
        if (r20 != null) goto L43;
    L45:
        int r21 = 0;
    L46:
        this.buyButtonStyle = r21;
        this.monitorViewModel.e = r7.u;
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a r22 = this.footerViewModel;
        LivePromotionPageBottomData r23 = r7.q;
        if (r22.c == true) goto L49;
        r22.c = true;
        ECLiveABUtils.INSTANCE.getEnableLiveFixBottomSelect();
    L49:
        r22.d.postValue(r23);
        onSuccessCallback(r7, r8, r9);
        return;
    L43:
        if (r20.getShortenedBuyNowButton() != 1) goto L45;
        r21 = 1;
    L35:
        LivePromotionPageHeaderData r24 = r7.m;
        if (r24 == null) goto L40;
        ECPromotionList.d r25 = r24.getAuthorReputation();
        if (r25 == null) goto L40;
        r1 = String.valueOf(r25.score);
        goto L40
    L24:
        r15 = null;
    L18:
        r11 = MapsKt.emptyMap();
    L20:
        r13 = null;
        goto L21
    }

    public static /* synthetic */ void reportFirstBindPromotionMonitorIfNeed$default(LivePromotionListViewModel r0, com.bytedance.android.ec.monitor.duration.h r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.reportFirstBindPromotionMonitorIfNeed(r1);
    }

    @Override // tj2.a
    public void updateInteractionData(List<ECPromotionInterationData> r8, boolean r9, boolean r10, boolean r11) {
        if (disableUpdateInteractionData() == false) goto L5;
        return;
    L5:
        yh2.a r12 = this.interactionData;
        List<ql.a> r0 = this.listRepository.A();
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter(r0, "totalPromotions");     // Catch: Throwable -> L47
        ArrayList r3 = null;
        if (r9 == false) goto L25;
        ((ArrayList) r12.b).clear();     // Catch: Throwable -> L47
        if (r8 == null) goto L24;
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L47
        Iterator<T> r13 = r8.iterator();     // Catch: Throwable -> L47
    L13:
        if (r13.hasNext() == false) goto L23;
        Object r5 = r13.next();     // Catch: Throwable -> L47
        ECPromotionInterationData r6 = (ECPromotionInterationData) r5;     // Catch: Throwable -> L47
        if (r10 == true) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L13;
        r4.add(r5);     // Catch: Throwable -> L47
        goto L13
    L17:
        if (yh2.a.a(r0, r6.getCheckParam()) == true) goto L20;
        r7 = false;
        goto L21
    L23:
        ((ArrayList) r12.b).addAll(r4);     // Catch: Throwable -> L47
    L24:
        r12.c = null;     // Catch: Throwable -> L47
    L42:
        if (r12.a == true) goto L44;
        r12.a = r9;     // Catch: Throwable -> L47
    L44:
        monitor-exit(r12);
        com.bytedance.android.ec.core.arch.event.c.d(this, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.a0());
        return;
    L25:
        if (r8 == null) goto L38;
        r3 = new ArrayList();     // Catch: Throwable -> L47
        Iterator<T> r14 = r8.iterator();     // Catch: Throwable -> L47
    L28:
        if (r14.hasNext() == false) goto L38;
        Object r15 = r14.next();     // Catch: Throwable -> L47
        ECPromotionInterationData r16 = (ECPromotionInterationData) r15;     // Catch: Throwable -> L47
        if (r10 == true) goto L32;
    L35:
        boolean r17 = true;
    L36:
        if (r17 == false) goto L28;
        r3.add(r15);     // Catch: Throwable -> L47
        goto L28
    L32:
        if (yh2.a.a(r0, r16.getCheckParam()) == true) goto L35;
        r17 = false;
    L38:
        r12.c = r3;     // Catch: Throwable -> L47
        if (r3 == null) goto L42;
        ((ArrayList) r12.b).addAll(0, r3);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void updateCategoryPromotions$default(LivePromotionListViewModel r0, PromotionCategory r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.updateCategoryPromotions(r1, r2);
    }

    public static /* synthetic */ void updateWhenBackFromOtherPage$default(LivePromotionListViewModel r0, Integer r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        r0.updateWhenBackFromOtherPage(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean addCartSuccessForAnim$default(LivePromotionListViewModel r0, View r1, ql.a r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.addCartSuccessForAnim(r1, r2, r3);
    }

    public final void init(final Context r34, LivePromotionListParams r35, fi2.a r36, LiveRoomParams r37, String r38, boolean r39, wj2.g r40, RoomContextController r41) {
        Intrinsics.checkNotNullParameter(r34, "context");
        Intrinsics.checkNotNullParameter(r35, "params");
        Intrinsics.checkNotNullParameter(r36, "liveRoomService");
        Intrinsics.checkNotNullParameter(r41, "roomContextController");
        this.params = r35;
        this.roomContextController = r41;
        if (r37 == null) goto L5;
        LiveRoomParams r5 = r37;
    L6:
        this.promotionListParams = (gi2.a) r5.buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class), new com.bytedance.android.ec.common.api.jump.model.f.a("a1.b0715.c0.d0", r38, jf.b.f.b, jf.e.c.b, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(gi2.a.class), new gi2.a.C0140a(r35.getLiveListChannel(), r35.getExtraEntranceInfo(), new C02981(this), new AnonymousClass2(this), r35.getSchemaEventParams(), new AnonymousClass3(this), new AnonymousClass4(this)));
        this.liveRoomService = r36;
        this.initialAction = r40;
        this.btmPageId = r38;
        this.promotionListEventActionImpl = new di2.b(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.b(this), this, r41);
        PromotionListController.a r1 = PromotionListController.T;
        String r6 = r35.getContainerRoomId();
        String r7 = r41.D();
        r1.getClass();
        List<PromotionListController.b> r2 = PromotionListController.a.c(r6, r7).d;
        if (this.isDefaultTab == false) goto L9;
        ((ArrayList) r2).clear();
    L9:
        LivePromotionListRepository r8 = this.listRepository.q();
        LivePromotionListRepository r9 = this.listRepository.s();
        String r10 = r35.getRoomId();
        if (this.isDefaultTab == true) goto L12;
    L14:
        boolean r11 = false;
    L15:
        ((ArrayList) r2).add(new PromotionListController.b(r8, r9, r10, r11));
        Lazy r3 = LiveDynamicContext.c;
        LiveListTabResortAbility r4 = (LiveListTabResortAbility) LiveDynamicContext.a.a().a().get("tab_resort");
        if (r4 != null) goto L18;
    L23:
        String r12 = null;
    L24:
        JSONObject r13 = ofRoomContextController().A().t.M().d(IRelatedInfoManager$Scene.PROMOTION_LIST);
        String r14 = r35.getAnchorId();
        String r15 = r35.getAnchorSecId();
        String r16 = r35.getRoomId();
        String r17 = r41.D();
        String r18 = r35.getContainerRoomId();
        if (this.isDefaultTab == true) goto L27;
    L30:
        boolean r19 = true;
    L31:
        this.requestParam = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c(r14, r15, r16, r18, r17, r19, this.isDefaultTab, r35.getLiveListChannel(), r35.getAutoApplyCoupon(), r35.getListApplyCoupon(), r35.getExtraEntranceInfo(), r35.getMonitorName(), ofPromotionListController().v, generateRelatedInfo(r12, r13), r35.getRecommendProductDisplayed(), r35.getTabUniqueIndex(), this.isInSplitScreen, r35.getCartAnimRelatedInfo(), r35.getPreferredCoupon(), 98304);
        r35.setTabUniqueIndex(null);
        tj2.f r20 = this.listRepository;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r21 = this.requestParam;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("requestParam");
    L34:
        mj2.i<mj2.c> r22 = r20.E(r21, this, this.listStateProvider);
        this.listing = r22;
        if (r22 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("listing");
    L37:
        this.pageListLiveData = r22.a;
        ECEventUtilsV2 r23 = ECEventUtilsV2.b;
        String r24 = r35.getLiveListChannel();
        String r25 = r35.getExtraEntranceInfo();
        r23.getClass();
        this.entranceInfo = ECEventUtilsV2.f("live_list_card", r24, r25);
        String r26 = r35.getRoomId();
        String r27 = r35.getAnchorId();
        String r28 = r35.getAnchorSecId();
        String r29 = r35.getLiveListChannel();
        if (r29 != null) goto L40;
        r29 = "";
    L40:
        Intrinsics.checkNotNullParameter(r26, "roomId");
        Intrinsics.checkNotNullParameter(r27, "anchorId");
        Intrinsics.checkNotNullParameter(r28, "anchorSecId");
        Intrinsics.checkNotNullParameter(r29, "liveChannel");
        Intrinsics.checkNotNullParameter("", "authorReputationScore");
        fi2.c.a r30 = fi2.c.a;
        com.bytedance.android.ec.core.async.b r31 = getDisposableScope();
        Intrinsics.checkNotNullParameter(r31, "$this$convert");
        this.newJumpHelper = fi2.c.b(new wj2.a(r31), new c(this), 4);
        this.listHeaderViewModel.f = new AnonymousClass6(this, r34);
        this.monitorViewModel.d = r39;
        onInitExtraRequest();
        return;
    L27:
        if (r36.isLinkmic() == true) goto L30;
        r19 = false;
        goto L31
    L18:
        if (r4.d().e() != 2) goto L20;
        boolean r32 = true;
    L21:
        if (r32 == false) goto L23;
        r12 = r4.c;
        goto L24
    L20:
        r32 = false;
        goto L21
    L12:
        if (Intrinsics.areEqual(r35.getRoomId(), r35.getContainerRoomId()) == false) goto L14;
        r11 = true;
        goto L15
    L5:
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
        goto L6
    }

    public final void refreshProductList(int r12, Integer r13, String r14, Integer r15, boolean r16, boolean r17, boolean r18, final String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r14, "uniqueIndex");
        tj2.f r2 = this.listRepository;
        if (r15 != null) goto L8;
        Function0<Integer> r1 = this.getCurrentPosition;
        if (r1 == null) goto L7;
        Integer r3 = (Integer) r1.invoke();
    L9:
        if (r3 == null) goto L11;
        int r6 = r3.intValue();
    L12:
        r2.y(r12, r13, r14, r6, r18, r16, r20, new C03061(this, r19));
        return;
    L11:
        r6 = 0;
        goto L12
    L7:
        r3 = null;
        goto L9
    L8:
        r3 = r15;
        goto L9
    }

    public static /* synthetic */ void init$default(LivePromotionListViewModel r10, Context r11, LivePromotionListParams r12, fi2.a r13, LiveRoomParams r14, String r15, boolean r16, wj2.g r17, RoomContextController r18, int r19, Object r20) {
        if ((r19 & 64) == 0) goto L5;
        wj2.g r8 = null;
    L6:
        r10.init(r11, r12, r13, r14, r15, r16, r8, r18);
        return;
    L5:
        r8 = r17;
        goto L6
    }

    public static /* synthetic */ void refreshProductList$default(LivePromotionListViewModel r11, int r12, Integer r13, String r14, Integer r15, boolean r16, boolean r17, boolean r18, String r19, boolean r20, int r21, Object r22) {
        String r2 = null;
        if ((r21 & 2) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r21 & 4) == 0) goto L14;
        PromotionCategory r4 = r11.listRepository.b();
        if (r4 == null) goto L11;
        String r5 = r4.getUniqueIndex();
    L12:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if ((r21 & 8) == 0) goto L18;
        Integer r6 = null;
    L19:
        boolean r7 = false;
        if ((r21 & 16) == 0) goto L22;
        boolean r8 = false;
    L24:
        if ((r21 & 32) == 0) goto L26;
        boolean r9 = false;
    L28:
        if ((r21 & 64) == 0) goto L30;
        boolean r10 = false;
    L32:
        if ((r21 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L36;
        r2 = r19;
    L36:
        if ((r21 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L39;
        r7 = r20;
    L39:
        r11.refreshProductList(r12, r1, r5, r6, r8, r9, r10, r2, r7);
        return;
    L30:
        r10 = r18;
        goto L32
    L26:
        r9 = r17;
        goto L28
    L22:
        r8 = r16;
        goto L24
    L18:
        r6 = r15;
        goto L19
    L11:
        r5 = null;
        goto L12
    L14:
        r5 = r14;
        goto L16
    L5:
        r1 = r13;
        goto L7
    }
}
