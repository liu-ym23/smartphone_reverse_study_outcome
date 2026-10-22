package com.bytedance.android.shopping.store.home.api;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.model.entity.ShopAPIPreloadType;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.home.preload.data.AIPreloadType;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.ShopSlcTemplateManager;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b$\u0018\u0000 Ç\u00012\u00020\u0001:\u0002È\u0001B\u0011\u0012\u0007\u0010Â\u0001\u001a\u00020\u0006¢\u0006\u0005\bÆ\u0001\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J;\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR$\u00102\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR$\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R$\u0010;\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R$\u0010>\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0014\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R$\u0010A\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R0\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010 \u001a\u0004\bE\u0010\"\"\u0004\bF\u0010$R0\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\"\u0010J\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010*\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R\"\u0010L\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010*\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R$\u0010O\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0014\u001a\u0004\bP\u0010\u0016\"\u0004\bQ\u0010\u0018R\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR#\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020W0\u000e8\u0006¢\u0006\f\n\u0004\bX\u0010 \u001a\u0004\bY\u0010\"R$\u0010Z\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0014\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R\"\u0010]\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010*\u001a\u0004\b^\u0010,\"\u0004\b_\u0010.R\"\u0010a\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0014\u001a\u0004\bh\u0010\u0016\"\u0004\bi\u0010\u0018R\u001a\u0010j\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\"\u0010n\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010k\u001a\u0004\bo\u0010m\"\u0004\bp\u0010qR\"\u0010r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010k\u001a\u0004\br\u0010m\"\u0004\bs\u0010qR$\u0010t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0014\u001a\u0004\bu\u0010\u0016\"\u0004\bv\u0010\u0018R\"\u0010x\u001a\u00020w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u007f\u001a\u00020~8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R)\u0010\u0085\u0001\u001a\u00020~8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0014\u001a\u0005\b\u0089\u0001\u0010\u0016\"\u0005\b\u008a\u0001\u0010\u0018R(\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010\u0014\u001a\u0005\b\u008c\u0001\u0010\u0016\"\u0005\b\u008d\u0001\u0010\u0018R&\u0010\u008e\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010*\u001a\u0005\b\u008e\u0001\u0010,\"\u0005\b\u008f\u0001\u0010.R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u0014\u001a\u0005\b\u0098\u0001\u0010\u0016\"\u0005\b\u0099\u0001\u0010\u0018R&\u0010\u009a\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010*\u001a\u0005\b\u009a\u0001\u0010,\"\u0005\b\u009b\u0001\u0010.R(\u0010\u009c\u0001\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u001a\u001a\u0005\b\u009d\u0001\u0010\u001c\"\u0005\b\u009e\u0001\u0010\u001eR(\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0014\u001a\u0005\b \u0001\u0010\u0016\"\u0005\b¡\u0001\u0010\u0018R(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u0014\u001a\u0005\b£\u0001\u0010\u0016\"\u0005\b¤\u0001\u0010\u0018R,\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R+\u0010¬\u0001\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R(\u0010²\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010\u0014\u001a\u0005\b³\u0001\u0010\u0016\"\u0005\b´\u0001\u0010\u0018R&\u0010µ\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010*\u001a\u0005\b¶\u0001\u0010,\"\u0005\b·\u0001\u0010.R!\u0010»\u0001\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0005\bº\u0001\u0010\u0016R\u001f\u0010¾\u0001\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¼\u0001\u0010¹\u0001\u001a\u0005\b½\u0001\u0010\u0016R\u001f\u0010Á\u0001\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¿\u0001\u0010¹\u0001\u001a\u0005\bÀ\u0001\u0010\u0016R\u001a\u0010Â\u0001\u001a\u00020\u00068\u0006¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u0014\u001a\u0005\bÃ\u0001\u0010\u0016R\u0013\u0010Ä\u0001\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010,R\u0013\u0010Å\u0001\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010,¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "Landroid/net/Uri;", "schema", "", "prepare", "", "getMarketInfo", "getLocalVersionWithoutContent", "getClientParams", "", "tabType", "", "extraLogExtra", "", "", "getTabMetaInfo", "(Ljava/lang/Integer;Ljava/util/Map;)Ljava/util/Map;", "updateSqlClientData", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "shopType", "Ljava/lang/Integer;", "getShopType", "()Ljava/lang/Integer;", "setShopType", "(Ljava/lang/Integer;)V", "schemaQueryMap", "Ljava/util/Map;", "getSchemaQueryMap", "()Ljava/util/Map;", "setSchemaQueryMap", "(Ljava/util/Map;)V", "apiExtParam", "getApiExtParam", "setApiExtParam", "", "viewProductTab", "Z", "getViewProductTab", "()Z", "setViewProductTab", "(Z)V", "sortType", "getSortType", "setSortType", "pickType", "getPickType", "setPickType", "passthroughHybrid", "getPassthroughHybrid", "setPassthroughHybrid", "taskRequestParams", "getTaskRequestParams", "setTaskRequestParams", "memberTrackParams", "getMemberTrackParams", "setMemberTrackParams", "frame", "getFrame", "setFrame", "extra", "getExtra", "setExtra", "logExtra", "getLogExtra", "setLogExtra", "tabPerfLogExtra", "getTabPerfLogExtra", "setTabPerfLogExtra", "isCroppedStyle", "setCroppedStyle", "statusBarDarkFont", "getStatusBarDarkFont", "setStatusBarDarkFont", "shuffleProductIds", "getShuffleProductIds", "setShuffleProductIds", "Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "storeV3UIParam", "Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "getStoreV3UIParam", "()Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "Lcom/bytedance/android/shopping/store/home/api/TabStyle;", "tabStyles", "getTabStyles", "inflowProductCardMode", "getInflowProductCardMode", "setInflowProductCardMode", "openByFragment", "getOpenByFragment", "setOpenByFragment", "", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "shopVersion", "getShopVersion", "setShopVersion", "flagSupportNestedTab", "I", "getFlagSupportNestedTab", "()I", "enableCommonAdTrack", "getEnableCommonAdTrack", "setEnableCommonAdTrack", "(I)V", "isFromAd", "setFromAd", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "apiPreloadType", "Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "getApiPreloadType", "()Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "setApiPreloadType", "(Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;)V", "Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "infoAIPreloadType", "Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "getInfoAIPreloadType", "()Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "setInfoAIPreloadType", "(Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;)V", "tabAIPreloadType", "getTabAIPreloadType", "setTabAIPreloadType", "interceptBackProcessType", "getInterceptBackProcessType", "setInterceptBackProcessType", "btmPageId", "getBtmPageId", "setBtmPageId", "isSplitMode", "setSplitMode", "Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "splitParent", "Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "getSplitParent", "()Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "setSplitParent", "(Lcom/bytedance/android/ec/host/api/split/ECFoldScene;)V", "splitPageType", "getSplitPageType", "setSplitPageType", "isTopSplit", "setTopSplit", "storeUITheme", "getStoreUITheme", "setStoreUITheme", "primaryColor", "getPrimaryColor", "setPrimaryColor", "secondaryColor", "getSecondaryColor", "setSecondaryColor", "", "transparency", "Ljava/lang/Double;", "getTransparency", "()Ljava/lang/Double;", "setTransparency", "(Ljava/lang/Double;)V", "flagHasActivityFloat", "Ljava/lang/Boolean;", "getFlagHasActivityFloat", "()Ljava/lang/Boolean;", "setFlagHasActivityFloat", "(Ljava/lang/Boolean;)V", "productTabPassThroughApi", "getProductTabPassThroughApi", "setProductTabPassThroughApi", "needShowMallBackView", "getNeedShowMallBackView", "setNeedShowMallBackView", "clientParam$delegate", "Lkotlin/Lazy;", "getClientParam", "clientParam", "localVersion$delegate", "getLocalVersion", "localVersion", "abParams$delegate", "getAbParams", "abParams", "secShopId", "getSecShopId", "isWhiteBrand", "isRedMan", "<init>", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreParam extends StoreBaseParam {
    public static final a Companion = null;
    public static final String KEY_MODAL = "modal";
    private final Lazy abParams$delegate;
    private String apiExtParam;
    private ShopAPIPreloadType apiPreloadType;
    private String btmPageId;
    private final Lazy clientParam$delegate;
    private int enableCommonAdTrack;
    private String entranceInfo;
    private String extra;
    private Boolean flagHasActivityFloat;
    private final int flagSupportNestedTab;
    private String frame;
    private String inflowProductCardMode;
    private AIPreloadType infoAIPreloadType;
    private String interceptBackProcessType;
    private boolean isCroppedStyle;
    private int isFromAd;
    private boolean isSplitMode;
    private boolean isTopSplit;
    private long lifecycleMonitorId;
    private final Lazy localVersion$delegate;
    private Map<String, String> logExtra;
    private String memberTrackParams;
    private boolean needShowMallBackView;
    private boolean openByFragment;
    private String passthroughHybrid;
    private Integer pickType;
    private String primaryColor;
    private String productTabPassThroughApi;
    private Map<String, String> schemaQueryMap;
    private final String secShopId;
    private String secondaryColor;
    private String shopId;
    private Integer shopType;
    private String shopVersion;
    private String shuffleProductIds;
    private Integer sortType;
    private String splitPageType;
    private ECFoldScene splitParent;
    private boolean statusBarDarkFont;
    private Integer storeUITheme;
    private final StoreV3UIParam storeV3UIParam;
    private AIPreloadType tabAIPreloadType;
    private Map<String, String> tabPerfLogExtra;
    private final Map<Integer, TabStyle> tabStyles;
    private String taskRequestParams;
    private Double transparency;
    private boolean viewProductTab;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAbParams() {
        return (String) this.abParams$delegate.getValue();
    }

    public final String getClientParam() {
        return (String) this.clientParam$delegate.getValue();
    }

    public final String getClientParams() {
        return null;
    }

    public final String getLocalVersion() {
        return (String) this.localVersion$delegate.getValue();
    }

    public final String getLocalVersionWithoutContent() {
        ConcurrentHashMap<String, ShopSliceItemConfig> r0 = ShopSlcTemplateManager.i;
        if (r0.isEmpty() == false) goto L30;
        long r1 = wh.a.a("ecom_shop_slice_template");
        List r3 = (List) ShopSlcTemplateManager.h.getValue();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        k r6 = (k) r5.next();
        SliceTemplate r7 = new SliceTemplate();
        r7.setName(r6.a());
        r7.setUrl(r6.c());
        r7.setVersion(String.valueOf(r1));
        r7.setType(SliceTemplateType.GECKO.getType());
        r4.add(r7);
        goto L6
    L8:
        ArrayList r2 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r4.iterator();
    L10:
        if (r13.hasNext() == false) goto L29;
        SliceTemplate r14 = (SliceTemplate) r13.next();
        if (CollectionsKt.contains(ShopSlcTemplateManager.b, r14.getName()) == false) goto L15;
        r10.add(r14);
    L15:
        if (CollectionsKt.contains(ShopSlcTemplateManager.e, r14.getName()) == false) goto L18;
        r8.add(r14);
    L18:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f, r14.getName()) == false) goto L21;
        r9.add(r14);
    L21:
        if (CollectionsKt.contains(ShopSlcTemplateManager.d, r14.getName()) == false) goto L24;
        r12.add(r14);
    L24:
        if (CollectionsKt.contains(ShopSlcTemplateManager.c, r14.getName()) == false) goto L27;
        r11.add(r14);
    L27:
        if (CollectionsKt.contains(ShopSlcTemplateManager.g, r14.getName()) == false) goto L10;
        r2.add(r14);
        goto L10
    L29:
        ConcurrentHashMap<String, ShopSliceItemConfig> r15 = ShopSlcTemplateManager.i;
        String r16 = SliceItemType.SHOP_PROFILE_CONCISE.getType();
        ShopSliceItemConfig r17 = new ShopSliceItemConfig();
        r17.setTemplates(r2);
        Unit r18 = Unit.INSTANCE;
        r15.put(r16, r17);
        String r19 = SliceItemType.SHOP_PROFILE.getType();
        ShopSliceItemConfig r20 = new ShopSliceItemConfig();
        r20.setTemplates(r8);
        r15.put(r19, r20);
        String r21 = SliceItemType.SHOP_TOP_BAR.getType();
        ShopSliceItemConfig r22 = new ShopSliceItemConfig();
        r22.setTemplates(r9);
        r15.put(r21, r22);
        String r23 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType();
        ShopSliceItemConfig r24 = new ShopSliceItemConfig();
        r24.setTemplates(r10);
        r15.put(r23, r24);
        String r25 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK.getType();
        ShopSliceItemConfig r26 = new ShopSliceItemConfig();
        r26.setTemplates(r11);
        r15.put(r25, r26);
        String r27 = SliceItemType.SHOP_FILTER.getType();
        ShopSliceItemConfig r28 = new ShopSliceItemConfig();
        r28.setTemplates(r12);
        r15.put(r27, r28);
    L34:
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r30 = r4.iterator();
    L36:
        if (r30.hasNext() == false) goto L39;
        SliceTemplate r31 = (SliceTemplate) r30.next();
        SliceTemplate r32 = new SliceTemplate();
        r32.setContent(null);
        r32.setName(r31.getName());
        r32.setUrl(r31.getUrl());
        r32.setVersion(r31.getVersion());
        r32.setType(r31.getType());
        r32.setSpanSize(r31.getSpanSize());
        r32.setPredictHeight(r31.getPredictHeight());
        r29.add(r32);
        goto L36
    L39:
        return com.bytedance.android.ec.hybrid.list.util.k.d(CollectionsKt.toMutableList(r29));
    L30:
        Collection<ShopSliceItemConfig> r33 = r0.values();
        r4 = new ArrayList();
        Iterator<T> r34 = r33.iterator();
    L32:
        if (r34.hasNext() == false) goto L34;
        CollectionsKt.addAll(r4, ((ShopSliceItemConfig) r34.next()).getTemplates());
        goto L32
    }

    public final String getMarketInfo() {
        return this.schemaQueryMap.get("pass_through_marketing_info");
    }

    public final boolean isRedMan() {
        Integer r0 = this.shopType;
        int r1 = ShopType.RED_MAN.getType();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != r1) goto L8;
        return true;
    }

    public final boolean isWhiteBrand() {
        Integer r0 = this.shopType;
        int r1 = ShopType.WHITE_BRAND.getType();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != r1) goto L8;
        return true;
    }

    public final void updateSqlClientData() {
        String r1 = (String) getPassThroughParam("pass_through_api");
        if (r1 == null) goto L5;
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(r1);
    L6:
        if (r2 == null) goto L8;
        Keva r3 = ECShopDataStorageForRemote.a;
        r2.put("sql_data_from_client", ECShopDataStorageForRemote.b(this.secShopId, r.a.getCurrentUserId()));
    L8:
        putPassThroughParam("pass_through_api", String.valueOf(r2));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final String getApiExtParam() {
        return this.apiExtParam;
    }

    public final ShopAPIPreloadType getApiPreloadType() {
        return this.apiPreloadType;
    }

    public final String getBtmPageId() {
        return this.btmPageId;
    }

    public final int getEnableCommonAdTrack() {
        return this.enableCommonAdTrack;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Boolean getFlagHasActivityFloat() {
        return this.flagHasActivityFloat;
    }

    public final int getFlagSupportNestedTab() {
        return this.flagSupportNestedTab;
    }

    public final String getFrame() {
        return this.frame;
    }

    public final String getInflowProductCardMode() {
        return this.inflowProductCardMode;
    }

    public final AIPreloadType getInfoAIPreloadType() {
        return this.infoAIPreloadType;
    }

    public final String getInterceptBackProcessType() {
        return this.interceptBackProcessType;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getMemberTrackParams() {
        return this.memberTrackParams;
    }

    public final boolean getNeedShowMallBackView() {
        return this.needShowMallBackView;
    }

    public final boolean getOpenByFragment() {
        return this.openByFragment;
    }

    public final String getPassthroughHybrid() {
        return this.passthroughHybrid;
    }

    public final Integer getPickType() {
        return this.pickType;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getProductTabPassThroughApi() {
        return this.productTabPassThroughApi;
    }

    public final Map<String, String> getSchemaQueryMap() {
        return this.schemaQueryMap;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final Integer getShopType() {
        return this.shopType;
    }

    public final String getShopVersion() {
        return this.shopVersion;
    }

    public final String getShuffleProductIds() {
        return this.shuffleProductIds;
    }

    public final Integer getSortType() {
        return this.sortType;
    }

    public final String getSplitPageType() {
        return this.splitPageType;
    }

    public final ECFoldScene getSplitParent() {
        return this.splitParent;
    }

    public final boolean getStatusBarDarkFont() {
        return this.statusBarDarkFont;
    }

    public final Integer getStoreUITheme() {
        return this.storeUITheme;
    }

    public final StoreV3UIParam getStoreV3UIParam() {
        return this.storeV3UIParam;
    }

    public final AIPreloadType getTabAIPreloadType() {
        return this.tabAIPreloadType;
    }

    public final Map<String, String> getTabPerfLogExtra() {
        return this.tabPerfLogExtra;
    }

    public final Map<Integer, TabStyle> getTabStyles() {
        return this.tabStyles;
    }

    public final String getTaskRequestParams() {
        return this.taskRequestParams;
    }

    public final Double getTransparency() {
        return this.transparency;
    }

    public final boolean getViewProductTab() {
        return this.viewProductTab;
    }

    public final boolean isCroppedStyle() {
        return this.isCroppedStyle;
    }

    public final int isFromAd() {
        return this.isFromAd;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public final boolean isTopSplit() {
        return this.isTopSplit;
    }

    public ECStoreParam(String r3) {
        Intrinsics.checkNotNullParameter(r3, "secShopId");
        this.secShopId = r3;
        this.schemaQueryMap = new HashMap();
        this.storeV3UIParam = new StoreV3UIParam();
        this.tabStyles = new LinkedHashMap();
        this.lifecycleMonitorId = -1;
        this.flagSupportNestedTab = 1;
        this.apiPreloadType = ShopAPIPreloadType.NO_PRELOAD;
        AIPreloadType r4 = AIPreloadType.NO_PRELOAD;
        this.infoAIPreloadType = r4;
        this.tabAIPreloadType = r4;
        this.splitPageType = "";
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.clientParam$delegate = LazyKt.lazy(r5, new ECStoreParam$clientParam$2(this));
        this.localVersion$delegate = LazyKt.lazy(r5, new ECStoreParam$localVersion$2(this));
        this.abParams$delegate = LazyKt.lazy(new ECStoreParam$abParams$2(this));
    }

    public final JSONObject a(Map<String, String> r5) {
        JSONObject r0 = new JSONObject();
        if (isEcShare() == false) goto L6;
        r0.put("is_ec_shopping", 1);
        r0.put("share_content", getShareContent());
        r0.put("share_object", getShareObject());
    L6:
        if (Intrinsics.areEqual(getShareContent(), "shop") == false) goto L8;
        r0.put("entrance_location", getEntranceLocation());
    L8:
        Map<String, String> r1 = this.logExtra;
        if (r1 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r2.next();
        r0.put(r3.getKey(), r3.getValue());
    L14:
        Map<String, String> r4 = this.tabPerfLogExtra;
        if (r4 == null) goto L20;
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, String> r7 = r6.next();
        r0.put(r7.getKey(), r7.getValue());
    L20:
        if (r5 == null) goto L25;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();
    L23:
        if (r8.hasNext() == false) goto L25;
        Map.Entry<String, String> r9 = r8.next();
        r0.put(r9.getKey(), r9.getValue());
    L25:
        return r0;
    }

    public final void prepare(Uri r7) {
        Intrinsics.checkNotNullParameter(r7, "schema");
        this.schemaQueryMap = j1.a(r7);
        int r0 = com.bytedance.android.shopping.store.home.api.a.a;
        Lazy r1 = ECStoreSettings.a;
        int r2 = p.a;
        String r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        b r5 = b.b;     // Catch: Throwable -> L5
        Object r6 = jj4.a.a("ec_store_api_ext_param_config", JsonElement.class, null, false);     // Catch: Throwable -> L5
    L9:
        JsonObject r8 = (JsonElement) r6;
        if ((r8 instanceof JsonObject) == false) goto L13;
        com.bytedance.android.shopping.store.home.api.a.a(r8, r7);
        r3 = r8.toString();
    L13:
        this.apiExtParam = r3;
        boolean r9 = Intrinsics.areEqual(this.schemaQueryMap.get("modal"), "seven_split");
        boolean r10 = true;
        if (Intrinsics.areEqual(getEntranceLocation(), "video_bind_store") == false) goto L30;
        Lazy r11 = ECStoreSettings.a;
        int r12 = p.a;
        Object r13 = Boolean.TRUE;
        b r14 = b.b;     // Catch: Throwable -> L20
        Object r15 = jj4.a.a("ec_store_enable_video_anchor_with_cropped_style", Boolean.class, r13, false);     // Catch: Throwable -> L20
        if (r15 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Throwable -> L20
    L27:
        if (((Boolean) r15).booleanValue() == true) goto L30;
        boolean r16 = false;
    L31:
        if (r9 == false) goto L34;
        if (r16 == false) goto L34;
    L35:
        this.isCroppedStyle = r10;
        this.enableCommonAdTrack = com.bytedance.android.shopping.extensions.k.r(UriProtector.getQueryParameter(r7, "enable_common_ad_track"), 0);
        this.isFromAd = com.bytedance.android.shopping.extensions.k.r(UriProtector.getQueryParameter(r7, "is_from_ad"), 0);
        return;
    L34:
        r10 = false;
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Object r18 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r18) == true) goto L25;
        r13 = r18;
    L25:
        r15 = r13;
    L30:
        r16 = true;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == false) goto L9;
        r6 = null;
        goto L9
    }

    public final void setApiExtParam(String r1) {
        this.apiExtParam = r1;
    }

    public final void setApiPreloadType(ShopAPIPreloadType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.apiPreloadType = r2;
    }

    public final void setBtmPageId(String r1) {
        this.btmPageId = r1;
    }

    public final void setCroppedStyle(boolean r1) {
        this.isCroppedStyle = r1;
    }

    public final void setEnableCommonAdTrack(int r1) {
        this.enableCommonAdTrack = r1;
    }

    public final void setEntranceInfo(String r1) {
        this.entranceInfo = r1;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public final void setFlagHasActivityFloat(Boolean r1) {
        this.flagHasActivityFloat = r1;
    }

    public final void setFrame(String r1) {
        this.frame = r1;
    }

    public final void setFromAd(int r1) {
        this.isFromAd = r1;
    }

    public final void setInflowProductCardMode(String r1) {
        this.inflowProductCardMode = r1;
    }

    public final void setInfoAIPreloadType(AIPreloadType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.infoAIPreloadType = r2;
    }

    public final void setInterceptBackProcessType(String r1) {
        this.interceptBackProcessType = r1;
    }

    public final void setLifecycleMonitorId(long r1) {
        this.lifecycleMonitorId = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setMemberTrackParams(String r1) {
        this.memberTrackParams = r1;
    }

    public final void setNeedShowMallBackView(boolean r1) {
        this.needShowMallBackView = r1;
    }

    public final void setOpenByFragment(boolean r1) {
        this.openByFragment = r1;
    }

    public final void setPassthroughHybrid(String r1) {
        this.passthroughHybrid = r1;
    }

    public final void setPickType(Integer r1) {
        this.pickType = r1;
    }

    public final void setPrimaryColor(String r1) {
        this.primaryColor = r1;
    }

    public final void setProductTabPassThroughApi(String r1) {
        this.productTabPassThroughApi = r1;
    }

    public final void setSchemaQueryMap(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.schemaQueryMap = r2;
    }

    public final void setSecondaryColor(String r1) {
        this.secondaryColor = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public final void setShopType(Integer r1) {
        this.shopType = r1;
    }

    public final void setShopVersion(String r1) {
        this.shopVersion = r1;
    }

    public final void setShuffleProductIds(String r1) {
        this.shuffleProductIds = r1;
    }

    public final void setSortType(Integer r1) {
        this.sortType = r1;
    }

    public final void setSplitMode(boolean r1) {
        this.isSplitMode = r1;
    }

    public final void setSplitPageType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.splitPageType = r2;
    }

    public final void setSplitParent(ECFoldScene r1) {
        this.splitParent = r1;
    }

    public final void setStatusBarDarkFont(boolean r1) {
        this.statusBarDarkFont = r1;
    }

    public final void setStoreUITheme(Integer r1) {
        this.storeUITheme = r1;
    }

    public final void setTabAIPreloadType(AIPreloadType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabAIPreloadType = r2;
    }

    public final void setTabPerfLogExtra(Map<String, String> r1) {
        this.tabPerfLogExtra = r1;
    }

    public final void setTaskRequestParams(String r1) {
        this.taskRequestParams = r1;
    }

    public final void setTopSplit(boolean r1) {
        this.isTopSplit = r1;
    }

    public final void setTransparency(Double r1) {
        this.transparency = r1;
    }

    public final void setViewProductTab(boolean r1) {
        this.viewProductTab = r1;
    }

    public final Map<String, Object> getTabMetaInfo(Integer r7, Map<String, String> r8) {
        Pair[] r0 = new Pair[33];
        String r1 = getStoreAccountParam().getUserId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[0] = TuplesKt.to("kol_id", r1);
        String r3 = getStoreAccountParam().getSecUserId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[1] = TuplesKt.to("sec_kol_id", r3);
        r0[2] = TuplesKt.to("entrance_location", getEntranceLocation());
        r0[3] = TuplesKt.to("enter_from", getEntranceLocation());
        String r4 = getShareInfo().getShopName();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0[4] = TuplesKt.to("shop_name", r4);
        r0[5] = TuplesKt.to("is_preview", Boolean.valueOf(isPreview()));
        r0[6] = TuplesKt.to("brand_verified", 0);
        r0[7] = TuplesKt.to("source_page", "store_page");
        Integer r5 = getFollowStatus();
        String r6 = null;
        if (r5 == null) goto L14;
        String r9 = String.valueOf(r5.intValue());
    L15:
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        r0[8] = TuplesKt.to("follow_status", r9);
        if (isPreview() == false) goto L20;
        String r10 = CommentScene.COMMENTSCENE_NO_AWEME;
    L21:
        r0[9] = TuplesKt.to("is_enter_preview", r10);
        String r11 = getTempId();
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        r0[10] = TuplesKt.to("temp_id", r11);
        String r12 = getSearchParams();
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        r0[11] = TuplesKt.to("search_params", r12);
        String r13 = getStoreSourcePage();
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r0[12] = TuplesKt.to("store_source_page", r13);
        String r14 = getStoreSourceMethod();
        if (r14 != null) goto L33;
        r14 = "";
    L33:
        r0[13] = TuplesKt.to("store_source_method", r14);
        String r15 = getStoreGroupType();
        if (r15 != null) goto L36;
        r15 = "";
    L36:
        r0[14] = TuplesKt.to("store_group_type", r15);
        r0[15] = TuplesKt.to("pre_product_id", getPreProductId());
        r0[16] = TuplesKt.to("pre_room_id", getPreRoomId());
        r0[17] = TuplesKt.to("pre_group_id", getPreGroupId());
        String r16 = (String) getPassThroughParam("pass_through_api");
        if (r16 != null) goto L39;
        r16 = "";
    L39:
        r0[18] = TuplesKt.to("pass_through_api", r16);
        String r17 = this.shopId;
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        r0[19] = TuplesKt.to("shop_id", r17);
        r0[20] = TuplesKt.to("sec_shop_id", this.secShopId);
        String r18 = getStoreAccountParam().getUserId();
        if (r18 != null) goto L45;
        r18 = "";
    L45:
        r0[21] = TuplesKt.to("author_id", r18);
        r0[22] = TuplesKt.to("is_from_ad", Integer.valueOf(this.isFromAd));
        String r19 = this.schemaQueryMap.get("modal");
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        r0[23] = TuplesKt.to("modal", r19);
        String r20 = getStoreAccountParam().getSecUserId();
        if (r20 != null) goto L51;
        r20 = "";
    L51:
        r0[24] = TuplesKt.to("sec_author_id", r20);
        String r21 = this.primaryColor;
        if (r21 != null) goto L54;
        r21 = "";
    L54:
        r0[25] = TuplesKt.to("primary_color", r21);
        String r22 = this.secondaryColor;
        if (r22 != null) goto L57;
        r22 = "";
    L57:
        r0[26] = TuplesKt.to("secondary_color", r22);
        Double r23 = this.transparency;
        if (r23 == null) goto L60;
        double r24 = r23.doubleValue();
    L61:
        r0[27] = TuplesKt.to("transparency", Double.valueOf(r24));
        String r25 = getProductBasicRequestParam().getToken();
        if (r25 != null) goto L64;
        r25 = "";
    L64:
        r0[28] = TuplesKt.to("token", r25);
        JSONObject r26 = com.bytedance.android.shopping.extensions.k.w(this.passthroughHybrid);
        if (r26 != null) goto L67;
        r26 = new JSONObject();
    L67:
        r0[29] = TuplesKt.to("pass_through_hybrid", r26);
        r0[30] = TuplesKt.to("store_type", "shop");
        String r27 = this.shopVersion;
        if (r27 != null) goto L70;
        r27 = "";
    L70:
        r0[31] = TuplesKt.to("shop_version", r27);
        r0[32] = TuplesKt.to("log_extra", a(r8).toString());
        Map<String, Object> r28 = MapsKt.mutableMapOf(r0);
        if (r7 == null) goto L87;
        r7.intValue();
        if (r7.intValue() != TabEnum.CATEGORY_TAB.getType()) goto L79;
        String r29 = getProductBasicRequestParam().getTmpId();
        if (r29 == null) goto L78;
        r2 = r29;
    L78:
        r28.put("tmp_id", r2);
    L86:
        r28.put("tab_type", r7);
        goto L87
    L79:
        TabStyle r30 = this.tabStyles.get(r7);
        if (r30 == null) goto L82;
        r6 = r30.getTemplateId();
    L82:
        if (r6 == null) goto L85;
        r2 = r6;
    L85:
        r28.put("tmp_id", r2);
    L87:
        String r31 = (String) getPassThroughParam("pass_through_api");
        if (r31 == null) goto L97;
        JSONObject r32 = com.bytedance.android.shopping.extensions.k.w(r31);
        if (r32 == null) goto L97;
        r28.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r32.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L97:
        r28.put("client_experiment_list", new JSONObject(new HashMap(ECShopABSettings.k.b())).toString());     // Catch: Throwable -> L94
    L96:
        return r28;
    L94:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L96
    L60:
        r24 = 1.0d;
        goto L61
    L20:
        r10 = "0";
        goto L21
    L14:
        r9 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject getLogExtraJsonObject$default(ECStoreParam r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map getTabMetaInfo$default(ECStoreParam r0, Integer r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getTabMetaInfo(r1, r2);
    }
}
