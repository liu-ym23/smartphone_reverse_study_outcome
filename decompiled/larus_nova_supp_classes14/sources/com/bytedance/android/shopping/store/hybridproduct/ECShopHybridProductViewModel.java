package com.bytedance.android.shopping.store.hybridproduct;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.i1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt;
import com.bytedance.android.shopping.store.slicecard.dto.SliceConfig;
import com.bytedance.android.shopping.store.viewmodel.ECStoreBaseViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002µ\u0002B\t¢\u0006\u0006\b³\u0002\u0010´\u0002JN\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002JC\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J \u0010%\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020!H\u0002J\u001c\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u0013H\u0002J\u0012\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u000eH\u0002J\u001c\u00101\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00103\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u0010J\u0006\u00104\u001a\u00020\u000eJ\u0006\u00106\u001a\u000205J\u000e\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u000205J@\u0010=\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010;J\u0006\u0010>\u001a\u00020\u0013J\u0006\u0010?\u001a\u00020\u000eJ\u0006\u0010@\u001a\u00020\u000eJ\u0006\u0010A\u001a\u00020\u000eJ\u0006\u0010B\u001a\u00020\u000eJ\u000e\u0010C\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0013J\u0010\u0010E\u001a\u00020\u000e2\b\u0010D\u001a\u0004\u0018\u00010\u0007J6\u0010I\u001a\u00020\u000e2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u00152\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0015J!\u0010M\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bM\u0010NJ\u001e\u0010P\u001a\u00020\u000e2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0007J\u0010\u0010Q\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u0010J\u0016\u0010T\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007J\u001a\u0010W\u001a\u00020\u000e2\b\u0010U\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010V\u001a\u00020\u0013J\u0006\u0010X\u001a\u00020\u000eJ\u0006\u0010Y\u001a\u00020\u000eJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00070ZJ\u000e\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0007R\u0014\u0010^\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR(\u0010r\u001a\b\u0012\u0004\u0012\u00020q0p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001d\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00130x8\u0006¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\by\u0010{R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0x8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010z\u001a\u0004\b|\u0010{\"\u0004\b}\u0010~R'\u0010\u007f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R.\u0010\u0087\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00070\u0085\u0001j\t\u0012\u0004\u0012\u00020\u0007`\u0086\u00018\u0006¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R)\u0010\u008b\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130x8\u0006¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010z\u001a\u0005\b\u0092\u0001\u0010{R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R!\u0010\u009a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0099\u00010x8\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010z\u001a\u0005\b\u009b\u0001\u0010{R.\u0010\u009c\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00070\u0085\u0001j\t\u0012\u0004\u0012\u00020\u0007`\u0086\u00018\u0006¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u0088\u0001\u001a\u0006\b\u009d\u0001\u0010\u008a\u0001R'\u0010\\\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\\\u0010\u0080\u0001\u001a\u0006\b\u009e\u0001\u0010\u0082\u0001\"\u0006\b\u009f\u0001\u0010\u0084\u0001R.\u0010 \u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00070\u0085\u0001j\t\u0012\u0004\u0012\u00020\u0007`\u0086\u00018\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010\u0088\u0001\u001a\u0006\b¡\u0001\u0010\u008a\u0001R)\u0010¢\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010\u0080\u0001\u001a\u0006\b£\u0001\u0010\u0082\u0001\"\u0006\b¤\u0001\u0010\u0084\u0001R5\u0010§\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010¦\u0001\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R5\u0010®\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u00ad\u0001\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010¨\u0001\u001a\u0006\b¯\u0001\u0010ª\u0001\"\u0006\b°\u0001\u0010¬\u0001R!\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030±\u00010x8\u0006¢\u0006\u000e\n\u0005\b²\u0001\u0010z\u001a\u0005\b³\u0001\u0010{R\u001d\u0010µ\u0001\u001a\u00030´\u00018\u0006¢\u0006\u0010\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R\u001f\u0010¹\u0001\u001a\u00020\u00108\u0006X\u0086D¢\u0006\u0010\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R/\u0010¾\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010½\u00010x8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¾\u0001\u0010z\u001a\u0005\b¿\u0001\u0010{\"\u0005\bÀ\u0001\u0010~R%\u0010\n\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Á\u00010\u00040x8\u0006¢\u0006\r\n\u0004\b\n\u0010z\u001a\u0005\bÂ\u0001\u0010{R\"\u0010Ã\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130x8\u0006¢\u0006\u000e\n\u0005\bÃ\u0001\u0010z\u001a\u0005\bÄ\u0001\u0010{R#\u0010Æ\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010Å\u00010x8\u0006¢\u0006\u000e\n\u0005\bÆ\u0001\u0010z\u001a\u0005\bÇ\u0001\u0010{R.\u0010\u0006\u001a\t\u0012\u0004\u0012\u00020\u00050È\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0006\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R0\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050È\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÎ\u0001\u0010É\u0001\u001a\u0006\bÏ\u0001\u0010Ë\u0001\"\u0006\bÐ\u0001\u0010Í\u0001R,\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R,\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R8\u0010ß\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R2\u0010æ\u0001\u001a\u000b\u0012\u0005\u0012\u00030å\u0001\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bæ\u0001\u0010É\u0001\u001a\u0006\bç\u0001\u0010Ë\u0001\"\u0006\bè\u0001\u0010Í\u0001R)\u0010é\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010\u008c\u0001\u001a\u0006\bê\u0001\u0010\u008e\u0001\"\u0006\bë\u0001\u0010\u0090\u0001R$\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030ì\u00010È\u00018\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010É\u0001\u001a\u0006\bî\u0001\u0010Ë\u0001R \u0010ï\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100x8\u0006¢\u0006\u000e\n\u0005\bï\u0001\u0010z\u001a\u0005\bð\u0001\u0010{R \u0010ñ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100x8\u0006¢\u0006\u000e\n\u0005\bñ\u0001\u0010z\u001a\u0005\bò\u0001\u0010{R \u0010ó\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100x8\u0006¢\u0006\u000e\n\u0005\bó\u0001\u0010z\u001a\u0005\bô\u0001\u0010{R)\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\f\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R\u0019\u0010ú\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010\u008c\u0001R\u001d\u0010ü\u0001\u001a\u00030û\u00018\u0006¢\u0006\u0010\n\u0006\bü\u0001\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001R\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020!0x8\u0006¢\u0006\r\n\u0004\b'\u0010z\u001a\u0005\b\u0080\u0002\u0010{R,\u0010\u0081\u0002\u001a\b\u0012\u0004\u0012\u00020\u00130x8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0002\u0010z\u001a\u0005\b\u0082\u0002\u0010{\"\u0005\b\u0083\u0002\u0010~R-\u0010\u0085\u0002\u001a\t\u0012\u0005\u0012\u00030\u0084\u00020x8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0002\u0010z\u001a\u0005\b\u0086\u0002\u0010{\"\u0005\b\u0087\u0002\u0010~R'\u0010X\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bX\u0010\u008c\u0001\u001a\u0006\b\u0088\u0002\u0010\u008e\u0001\"\u0006\b\u0089\u0002\u0010\u0090\u0001R)\u0010\u008a\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0002\u0010\u008c\u0001\u001a\u0006\b\u008b\u0002\u0010\u008e\u0001\"\u0006\b\u008c\u0002\u0010\u0090\u0001R,\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R,\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0002\u0010\u0096\u0002\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002\"\u0006\b\u0099\u0002\u0010\u009a\u0002R)\u0010\u009b\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0002\u0010\u008c\u0001\u001a\u0006\b\u009b\u0002\u0010\u008e\u0001\"\u0006\b\u009c\u0002\u0010\u0090\u0001R)\u0010\u009d\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0002\u0010\u008c\u0001\u001a\u0006\b\u009e\u0002\u0010\u008e\u0001\"\u0006\b\u009f\u0002\u0010\u0090\u0001R)\u0010 \u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b \u0002\u0010\u008c\u0001\u001a\u0006\b¡\u0002\u0010\u008e\u0001\"\u0006\b¢\u0002\u0010\u0090\u0001R)\u0010£\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010\u0080\u0001\u001a\u0006\b¤\u0002\u0010\u0082\u0001\"\u0006\b¥\u0002\u0010\u0084\u0001R\u001f\u0010¦\u0002\u001a\u00020\u00078\u0006X\u0086D¢\u0006\u0010\n\u0006\b¦\u0002\u0010\u0080\u0001\u001a\u0006\b§\u0002\u0010\u0082\u0001R\"\u0010¨\u0002\u001a\u000b\u0012\u0004\u0012\u00020;\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010¨\u0001R,\u0010ª\u0002\u001a\u0005\u0018\u00010©\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010¯\u0002R,\u0010°\u0002\u001a\u0005\u0018\u00010©\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0002\u0010«\u0002\u001a\u0006\b±\u0002\u0010\u00ad\u0002\"\u0006\b²\u0002\u0010¯\u0002¨\u0006¶\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreBaseViewModel;", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "storeParam", "", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButtons", "", "paginationParams", "Lcom/bytedance/android/ec/store/repository/dto/m;", "sortTypes", "Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "tabConfig", "hybridParams", "", "initRequestParams", "", "typeFromServer", "forceFromServer", "", "fallbackLocal", "", "Ldj3/k;", "switchButtonConfigs", "setLayoutTypeIfNeed", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/util/Map;)V", "fetchFirst", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "layoutType", "preloadRemainXML", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel$RequestType;", "requestType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopProductListBffResponseDTO;", "getProductListObservable", "readSuccess", "params", "doProductListOptMonitor", "fetchNext", "response", "updateRequestParamFromResponse", "isRemove", "needUpdate", "updateRequestParamForDiscount", "pickId", "updatePickTypes", "resetInsertParam", "entranceInfo", "shopVersion", "initEventParams", "index", "refreshSelectStatus", "resetUniqueKey", "Lcom/bytedance/android/shopping/store/restore/i;", "exportRequestState", "state", "importRequestState", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "initialData", "Landroid/content/Context;", "context", "init", "hasDiscountSelected", "fetchProductBffApi", "refreshPassthroughApiForSql", "resetDisposable", "updateLoadMoreVisibleTime", "updateMiddleCouponFilterClientState", "selectParams", "upDateSelectParams", "", "filterParams", "clientStateParams", "refreshByLynx", "", "sortType", "sort", "refreshBySortAndSortType", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "filterEventParams", "refreshByDiscountSelect", "refreshByLiveSameTab", "customIdType", "customIds", "refreshByCustomId", "productTabParams", "isFromCouponPanel", "setButtonSelected", "refreshAll", "clearSkuIdRecords", "", "getUnExposedProducts", "currentProductId", "prefetchInsertData", "fakeStoreParam", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "getStoreParam", "()Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "setStoreParam", "(Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;)V", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductReqParams;", "requestParam", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductReqParams;", "getRequestParam", "()Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductReqParams;", "setRequestParam", "(Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductReqParams;)V", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "getInitialData", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "setInitialData", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setLoadStatus", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "Ljm/a;", "isClothesSelected", "Ljm/a;", "()Ljm/a;", "getLayoutType", "setLayoutType", "(Ljm/a;)V", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "showSelectPanelEntry", "Z", "getShowSelectPanelEntry", "()Z", "setShowSelectPanelEntry", "(Z)V", "removeVipCard", "getRemoveVipCard", "titleMaxLines", "Ljava/lang/Integer;", "getTitleMaxLines", "()Ljava/lang/Integer;", "setTitleMaxLines", "(Ljava/lang/Integer;)V", "Lej3/a;", "updateProduct", "getUpdateProduct", "allIdRecords", "getAllIdRecords", "getCurrentProductId", "setCurrentProductId", "skuProductIdRecords", "getSkuProductIdRecords", "ecomEntranceFrom", "getEcomEntranceFrom", "setEcomEntranceFrom", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "cartView", "Ljava/lang/ref/WeakReference;", "getCartView", "()Ljava/lang/ref/WeakReference;", "setCartView", "(Ljava/lang/ref/WeakReference;)V", "Lcom/bytedance/android/shopping/store/home/view/LottieAnimationViewWithPlayCount;", "cartAnimationView", "getCartAnimationView", "setCartAnimationView", "Lcom/bytedance/android/ec/store/utils/playable/controller/playcontrol/PlayControlStrategy;", "currentPlayStrategy", "getCurrentPlayStrategy", "Lxm/c;", "tagPools", "Lxm/c;", "getTagPools", "()Lxm/c;", "maxDepth", "I", "getMaxDepth", "()I", "Lej3/f;", "sortsVO", "getSortsVO", "setSortsVO", "Lcom/bytedance/android/ec/store/repository/vo/r;", "getSortTypes", "bigSaleMoveToTop", "getBigSaleMoveToTop", "Lcom/bytedance/android/ec/store/repository/vo/n;", "discountButton", "getDiscountButton", "", "Ljava/util/List;", "getSelectButtons", "()Ljava/util/List;", "setSelectButtons", "(Ljava/util/List;)V", "filterSelectButtons", "getFilterSelectButtons", "setFilterSelectButtons", "Lcom/bytedance/android/ec/store/repository/vo/h;", "middleCouponFilterVO", "Lcom/bytedance/android/ec/store/repository/vo/h;", "getMiddleCouponFilterVO", "()Lcom/bytedance/android/ec/store/repository/vo/h;", "setMiddleCouponFilterVO", "(Lcom/bytedance/android/ec/store/repository/vo/h;)V", "Lcom/bytedance/android/ec/store/repository/vo/g;", "cachedCouponPanelInfo", "Lcom/bytedance/android/ec/store/repository/vo/g;", "getCachedCouponPanelInfo", "()Lcom/bytedance/android/ec/store/repository/vo/g;", "setCachedCouponPanelInfo", "(Lcom/bytedance/android/ec/store/repository/vo/g;)V", "cachedCouponMapData", "Ljava/util/Map;", "getCachedCouponMapData", "()Ljava/util/Map;", "setCachedCouponMapData", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/store/repository/dto/g;", "pickTypes", "getPickTypes", "setPickTypes", "hasBind", "getHasBind", "setHasBind", "Ljava/lang/Runnable;", "pendingAction", "getPendingAction", "productViewsNum", "getProductViewsNum", "totalProductNum", "getTotalProductNum", "truelyTotalProductNum", "getTruelyTotalProductNum", "Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "getTabConfig", "()Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "setTabConfig", "(Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;)V", "flagEndApiDuration", "Lti3/a;", "dataSource", "Lti3/a;", "getDataSource", "()Lti3/a;", "getResponse", "refresh", "getRefresh", "setRefresh", "Lcom/bytedance/android/shopping/store/slicecard/dto/SliceConfig;", "apiSliceConfig", "getApiSliceConfig", "setApiSliceConfig", "getRefreshAll", "setRefreshAll", "fetchLock", "getFetchLock", "setFetchLock", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "hybridList", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridList", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridList", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "hybridListVO", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getHybridListVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setHybridListVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "isRestoredData", "setRestoredData", "hasNextPage", "getHasNextPage", "setHasNextPage", "hasSelectButton", "getHasSelectButton", "setHasSelectButton", "uniqueKeyForProductEvent", "getUniqueKeyForProductEvent", "setUniqueKeyForProductEvent", "PITAYA_PRODUCT_BUSINESS_ID", "getPITAYA_PRODUCT_BUSINESS_ID", "contextReference", "Lio/reactivex/disposables/Disposable;", "firstReqDis", "Lio/reactivex/disposables/Disposable;", "getFirstReqDis", "()Lio/reactivex/disposables/Disposable;", "setFirstReqDis", "(Lio/reactivex/disposables/Disposable;)V", "nextReqDis", "getNextReqDis", "setNextReqDis", "<init>", "()V", "RequestType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridProductViewModel extends ECStoreBaseViewModel {
    private final String PITAYA_PRODUCT_BUSINESS_ID;
    private final HashSet<String> allIdRecords;
    private jm.a<SliceConfig> apiSliceConfig;
    private final jm.a<Boolean> bigSaleMoveToTop;
    private Map<String, com.bytedance.android.ec.store.repository.vo.h> cachedCouponMapData;
    private com.bytedance.android.ec.store.repository.vo.g cachedCouponPanelInfo;
    private WeakReference<LottieAnimationViewWithPlayCount> cartAnimationView;
    private WeakReference<View> cartView;
    private WeakReference<Context> contextReference;
    private final jm.a<PlayControlStrategy> currentPlayStrategy;
    private String currentProductId;
    private final ti3.a dataSource;
    private final jm.a<com.bytedance.android.ec.store.repository.vo.n> discountButton;
    private String ecomEntranceFrom;
    private final ECStoreParam fakeStoreParam;
    private boolean fetchLock;
    private List<com.bytedance.android.ec.store.repository.dto.c> filterSelectButtons;
    private Disposable firstReqDis;
    private boolean flagEndApiDuration;
    private boolean hasBind;
    private boolean hasNextPage;
    private boolean hasSelectButton;
    private ECHybridListDTO hybridList;
    private com.bytedance.android.ec.hybrid.list.entity.k hybridListVO;
    private final HashSet<String> idRecords;
    private StoreV2ProductListResponseVO initialData;
    private final jm.a<Boolean> isClothesSelected;
    private boolean isRestoredData;
    private jm.a<LayoutTypes> layoutType;
    private QLiveData<LoadStatus> loadStatus;
    private final int maxDepth;
    private com.bytedance.android.ec.store.repository.vo.h middleCouponFilterVO;
    private Disposable nextReqDis;
    private final List<Runnable> pendingAction;
    private List<com.bytedance.android.ec.store.repository.dto.g> pickTypes;
    private final jm.a<Integer> productViewsNum;
    private jm.a<Boolean> refresh;
    private boolean refreshAll;
    private final jm.a<Boolean> removeVipCard;
    private ECShopHybridProductReqParams requestParam;
    private final jm.a<ECShopProductListBffResponseDTO> response;
    private List<com.bytedance.android.ec.store.repository.dto.c> selectButtons;
    private String sessionId;
    private boolean showSelectPanelEntry;
    private final HashSet<String> skuProductIdRecords;
    private final jm.a<List<com.bytedance.android.ec.store.repository.vo.r>> sortTypes;
    private jm.a<ej3.f> sortsVO;
    private ECStoreParam storeParam;
    private StoreTabConfig tabConfig;
    private final xm.c tagPools;
    private Integer titleMaxLines;
    private final jm.a<Integer> totalProductNum;
    private final jm.a<Integer> truelyTotalProductNum;
    private String uniqueKeyForProductEvent;
    private final jm.a<ej3.a> updateProduct;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel$RequestType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "FIRST_LOAD", "LOAD_MORE", "INSERT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestType extends Enum<RequestType> {
        public static final RequestType FIRST_LOAD = null;
        public static final RequestType INSERT = null;
        public static final RequestType LOAD_MORE = null;
        public static final /* synthetic */ RequestType[] a = null;
        private final String type;

        static {
            RequestType r1 = new RequestType("FIRST_LOAD", 0, "refresh");
            FIRST_LOAD = r1;
            RequestType r2 = new RequestType("LOAD_MORE", 1, "loadmore");
            LOAD_MORE = r2;
            RequestType r3 = new RequestType("INSERT", 2, "insert");
            INSERT = r3;
            a = new RequestType[]{r1, r2, r3};
        }

        public static RequestType valueOf(String r1) {
            return (RequestType) r27.a.a(RequestType.class, r1);
        }

        public static RequestType[] values() {
            return (RequestType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public RequestType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public a(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r20) {
            ECShopProductListBffResponseDTO r2 = (ECShopProductListBffResponseDTO) r20;
            String r13 = "";
            if (r2.getStatusCode() == 0) goto L10;
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            int r0 = o0.a;
            JSONObject r1 = new JSONObject();
            r1.put("status", CommentScene.COMMENTSCENE_NO_AWEME);
            r1.put("net_name", "product/bff");
            r1.put("status_code", String.valueOf(r2.getStatusCode()));
            r1.put("error_code", String.valueOf(r2.getStatusCode()));
            String r3 = r2.getMessage();
            if (r3 == null) goto L8;
            r13 = r3;
        L8:
            r1.put("error_msg", r13);
            Unit r4 = Unit.INSTANCE;
            int r5 = ECMonitorService.b;
            ECMonitorService.a.a("shop_perf_tab_fetch", r1, null, null);
            this.a.setFetchLock(false);
            return;
        L10:
            if (this.a.getInitialData() != null) goto L17;
            if (ECShopHybridProductViewModel.access$getFlagEndApiDuration$p(this.a) == true) goto L17;
            ECShopHybridProductViewModel.access$setFlagEndApiDuration$p(this.a, true);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r6 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r7 == null) goto L17;
            r7.s(this.a.getTabConfig());
        L17:
            if (this.a.getRequestParam().isFilterRequest() == false) goto L22;
            this.a.getRequestParam().setFilterRequest(false);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r8 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r9 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r9 == null) goto L21;
            r9.R(this.a.getTabConfig());
        L21:
            new Handler(Looper.getMainLooper()).post(new g0(this));
        L22:
            jm.a<Integer> r10 = this.a.getTotalProductNum();
            Map<String, String> r15 = r2.getBizExtra();
            if (r15 == null) goto L29;
            String r11 = r15.get("product_total_count");
            if (r11 == null) goto L29;
            Integer r12 = StringsKt.toIntOrNull(r11);
            if (r12 == null) goto L29;
            int r14 = r12.intValue();
        L30:
            r10.setValue(Integer.valueOf(r14));
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r16 = com.bytedance.android.shopping.store.lifecycle.a.a;
            if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId())) == null) goto L196;
            this.a.getTabConfig();
        L196:
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L41
            Map<String, String> r18 = r2.getBizExtra();     // Catch: Throwable -> L41
            if (r18 == null) goto L38;
            String r19 = r18.get("__PRODUCTS_SECTION__");     // Catch: Throwable -> L41
            if (r19 == null) goto L38;
            JSONObject r21 = com.bytedance.commerce.base.json.b.a(r19);     // Catch: Throwable -> L41
        L39:
            Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L41
        L44:
            if (Result.isFailure-impl(r22) == false) goto L46;
            r22 = null;
        L46:
            JSONObject r23 = (JSONObject) r22;
            if (r23 == null) goto L49;
            Integer r110 = Integer.valueOf(r23.optInt("force_product_layout", -1));
        L50:
            if (r23 == null) goto L52;
            Integer r24 = Integer.valueOf(r23.optInt("product_layout", -1));
        L53:
            ECShopHybridProductViewModel r25 = this.a;
            Map<String, String> r26 = r2.getBizExtra();
            if (r26 == null) goto L58;
            String r27 = r26.get("title_lines");
            if (r27 == null) goto L58;
            Integer r28 = StringsKt.toIntOrNull(r27);
        L59:
            r25.setTitleMaxLines(r28);
            ECHybridListDTO r29 = r2.getHybridList();
            if (r29 == null) goto L92;
            List r30 = r29.getSections();
            if (r30 == null) goto L92;
            Iterator<T> r31 = r30.iterator();
        L65:
            if (r31.hasNext() == false) goto L70;
            T r32 = r31.next();
            Iterator<T> r111 = r31;
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r32).getSectionId(), "__FILTER_SECTION__") == true) goto L71;
            r31 = r111;
        L71:
            ECHybridListSectionDTO r33 = (ECHybridListSectionDTO) r32;
            if (r33 == null) goto L92;
            ArrayList r34 = r33.getItems();
            if (r34 == null) goto L92;
            Iterator<T> r35 = r34.iterator();
        L77:
            if (r35.hasNext() == false) goto L88;
            T r36 = r35.next();
            Integer r112 = ((ECHybridListItemDTO) r36).getItemType();
            Iterator<T> r113 = r35;
            int r37 = ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType();
            if (r112 != null) goto L82;
        L84:
            boolean r38 = false;
        L85:
            if (r38 == true) goto L89;
            r35 = r113;
        L89:
            ECHybridListItemDTO r39 = (ECHybridListItemDTO) r36;
            if (r39 == null) goto L92;
            Object r40 = r39.getItemData();
        L94:
            if ((r40 instanceof dj3.g) == true) goto L96;
            r40 = null;
        L96:
            ej3.f.g.getClass();
            ECShopHybridProductViewModel.access$setLayoutTypeIfNeed(this.a, r24, r110, true, ej3.f.a.a((dj3.g) r40).f);
            ECHybridListDTO r41 = r2.getHybridList();
            if (r41 == null) goto L101;
            Map r42 = r41.getExtra();
            if (r42 == null) goto L101;
            String r43 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r42, "coupon_plan_id", null);
        L102:
            ECHybridListDTO r44 = r2.getHybridList();
            if (r44 == null) goto L107;
            Map r45 = r44.getExtra();
            if (r45 == null) goto L107;
            String r46 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r45, "coupon_panel_data", null);
        L108:
            JSONObject r47 = com.bytedance.android.shopping.extensions.k.w(r46);
            if (r43 == null) goto L115;
            if ((!Intrinsics.areEqual(r43, "")) == false) goto L115;
            if (r47 == null) goto L115;
            HashMap r48 = com.bytedance.android.ec.core.hybrid.utils.j.a;
            com.bytedance.android.ec.core.hybrid.utils.j.h(r43, r47);
        L115:
            ECHybridListDTO r49 = r2.getHybridList();
            if (r49 == null) goto L153;
            List r50 = r49.getSections();
            if (r50 == null) goto L153;
            Iterator<T> r51 = r50.iterator();
        L121:
            if (r51.hasNext() == false) goto L153;
            ECHybridListSectionDTO r52 = (ECHybridListSectionDTO) r51.next();
            LayoutTypes r53 = (LayoutTypes) this.a.getLayoutType().getValue();
            if (r53 == null) goto L125;
            int r54 = r53.getType();
        L126:
            l0.b(r52, r54);
            l0.d(r52, r54);
            if (Intrinsics.areEqual(r52.getSectionId(), "__PRODUCTS_SECTION__") == false) goto L121;
            r52.setOperationType(ECSectionOperationType.INSERT_SECTION);
            ArrayList r55 = r52.getItems();
            if (r55 == null) goto L137;
            Iterator<T> r56 = r55.iterator();
        L132:
            if (r56.hasNext() == false) goto L137;
            String r114 = ((ECHybridListItemDTO) r56.next()).getItemId();
            if (r114 == null) goto L132;
            this.a.getAllIdRecords().add(r114);
        L137:
            ArrayList r57 = r52.getItems();
            if (r57 == null) goto L146;
            ArrayList r58 = new ArrayList();
            Iterator<T> r59 = r57.iterator();
        L141:
            if (r59.hasNext() == false) goto L145;
            T r115 = r59.next();
            if (ShopHybridTabExtKt.e((ECHybridListItemDTO) r115) == false) goto L141;
            r58.add(r115);
            goto L141
        L145:
            int r60 = r58.size();
        L147:
            jm.a<Integer> r61 = this.a.getTruelyTotalProductNum();
            Integer r116 = (Integer) this.a.getTruelyTotalProductNum().getValue();
            if (r116 == null) goto L150;
            int r117 = r116.intValue();
        L151:
            r61.setValue(Integer.valueOf(r117 + r60));
            goto L121
        L150:
            r117 = 0;
            goto L151
        L146:
            r60 = 0;
            goto L147
        L125:
            r54 = 1;
        L153:
            SliceConfig.a r62 = SliceConfig.Companion;
            ECHybridListDTO r63 = r2.getHybridList();
            if (r63 == null) goto L156;
            Map r64 = r63.getExtra();
        L157:
            r62.getClass();
            SliceConfig r65 = SliceConfig.a.a(r64);
            if (r65 == null) goto L160;
            this.a.getApiSliceConfig().setValue(r65);
        L160:
            ECShopHybridProductViewModel.access$updateRequestParamFromResponse(this.a, r2);
            this.a.setHasNextPage(r2.getHasMore());
            ECHybridListDTO r66 = r2.getHybridList();
            if (r66 == null) goto L186;
            List r67 = r66.getSections();
            if (r67 == null) goto L186;
            Iterator<T> r68 = r67.iterator();
        L166:
            if (r68.hasNext() == false) goto L170;
            T r69 = r68.next();
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r69).getSectionId(), "__PRODUCTS_SECTION__") == false) goto L166;
        L171:
            ECHybridListSectionDTO r70 = (ECHybridListSectionDTO) r69;
            if (r70 == null) goto L186;
            ArrayList r71 = r70.getItems();
            if (r71 == null) goto L186;
            if (r71.isEmpty() == true) goto L186;
            Iterator<T> r72 = r71.iterator();
            int r73 = 0;
        L180:
            if (r72.hasNext() == false) goto L187;
            if (ShopHybridTabExtKt.e((ECHybridListItemDTO) r72.next()) == false) goto L180;
            r73 = r73 + 1;
            if (r73 >= 0) goto L180;
            CollectionsKt.throwCountOverflow();
        L187:
            dm.a.a("ec_shop_restore").a("product_fetch_first end tabId=" + this.a.getRequestParam().getRequestTabType() + " hasMore=" + r2.getHasMore() + " productCount=" + r73);
            if (r2.getHasMore() == true) goto L190;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
        L190:
            this.a.setFetchLock(false);
            int r74 = o0.a;
            JSONObject r75 = new JSONObject();
            r75.put("status", "0");
            r75.put("net_name", "product/bff");
            r75.put("status_code", String.valueOf(r2.getStatusCode()));
            r75.put("error_code", "");
            String r76 = r2.getMessage();
            if (r76 == null) goto L194;
            r13 = r76;
        L194:
            r75.put("error_msg", r13);
            Unit r77 = Unit.INSTANCE;
            int r78 = ECMonitorService.b;
            ECMonitorService.a.a("shop_perf_tab_fetch", r75, null, null);
            this.a.getResponse().setValue(r2);
            return;
        L170:
            r69 = null;
        L186:
            r73 = 0;
            goto L187
        L156:
            r64 = null;
        L107:
            r46 = null;
        L101:
            r43 = null;
            goto L102
        L82:
            if (r112.intValue() != r37) goto L84;
            r38 = true;
            goto L85
        L88:
            r36 = null;
            goto L89
        L70:
            r32 = null;
        L92:
            r40 = null;
        L58:
            r28 = null;
            goto L59
        L52:
            r24 = null;
            goto L53
        L49:
            r110 = null;
        L38:
            r21 = null;
        L41:
            th = move-exception;
            Result.Companion r79 = Result.Companion;
            r22 = Result.constructor-impl(ResultKt.createFailure(th));
        L29:
            r14 = 0;
            goto L30
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public b(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            this.a.setFetchLock(false);
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            ECExceptionMonitor.e(r7);
            int r0 = o0.a;
            JSONObject r1 = new JSONObject();
            r1.put("status", CommentScene.COMMENTSCENE_NO_AWEME);
            r1.put("net_name", "product/bff");
            String r2 = "";
            r1.put("status_code", "");
            ErrorDomain r3 = ErrorDomain.NATIVE;
            r1.put("error_code", r3.getCode());
            String r4 = r7.getMessage();
            if (r4 == null) goto L6;
            r2 = r4;
        L6:
            r1.put("error_msg", r2);
            Unit r5 = Unit.INSTANCE;
            int r8 = ECMonitorService.b;
            ECMonitorService.a.a("shop_perf_tab_fetch", r1, null, null);
            ECShopHybridProductViewModel.access$setLayoutTypeIfNeed(this.a, null, null, true, null);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r9 = com.bytedance.android.shopping.store.lifecycle.a.a;
            if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId())) == null) goto L10;
            this.a.getTabConfig();
            r3.getCode();
            ErrorCode.NATIVE_COMMON.getCode();
            r7.getMessage();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public c(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            ECShopProductListBffResponseDTO r14 = (ECShopProductListBffResponseDTO) r13;
            boolean r1 = false;
            if (r14.getStatusCode() == 0) goto L8;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreError);
            this.a.setFetchLock(false);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r2 == null) goto L126;
            r2.D(this.a.getTabConfig(), ((com.bytedance.android.ec.store.setting.h) ECStoreSettings.d.getValue()).a(), 1, Integer.valueOf(ErrorDomain.NET.getCode()), Integer.valueOf(r14.getStatusCode()), r14.getStatusMsg(), this.a.getRequestParam().getFilterParams(), this.a.getRequestParam().getFilterEventParams());
            return;
        L126:
            return;
        L8:
            if (this.a.getRequestParam().isFilterRequest() == false) goto L12;
            this.a.getRequestParam().setFilterRequest(false);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r3 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r4 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r4 == null) goto L12;
            r4.R(this.a.getTabConfig());
        L12:
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r5 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r6 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r6 == null) goto L15;
            com.bytedance.android.shopping.store.lifecycle.c.a.d(r6, this.a.getTabConfig(), ((com.bytedance.android.ec.store.setting.h) ECStoreSettings.d.getValue()).a(), 0, null, null, null, this.a.getRequestParam().getFilterParams(), this.a.getRequestParam().getFilterEventParams(), 56);
        L15:
            ECHybridListDTO r7 = r14.getHybridList();
            if (r7 == null) goto L51;
            List r8 = r7.getSections();
            if (r8 == null) goto L51;
            Iterator<T> r9 = r8.iterator();
        L21:
            if (r9.hasNext() == false) goto L51;
            ECHybridListSectionDTO r10 = (ECHybridListSectionDTO) r9.next();
            LayoutTypes r11 = (LayoutTypes) this.a.getLayoutType().getValue();
            if (r11 == null) goto L25;
            int r12 = r11.getType();
        L26:
            l0.b(r10, r12);
            l0.d(r10, r12);
            if (Intrinsics.areEqual(r10.getSectionId(), "__PRODUCTS_SECTION__") == false) goto L21;
            r10.setOperationType(ECSectionOperationType.INSERT_SECTION);
            ArrayList r15 = r10.getItems();
            if (r15 == null) goto L36;
            Iterator r16 = r15.iterator();
        L32:
            if (r16.hasNext() == false) goto L36;
            String r17 = ((ECHybridListItemDTO) r16.next()).getItemId();
            if (r17 == null) goto L32;
            this.a.getAllIdRecords().add(r17);
        L36:
            ArrayList r18 = r10.getItems();
            if (r18 == null) goto L45;
            ArrayList r19 = new ArrayList();
            Iterator<T> r20 = r18.iterator();
        L40:
            if (r20.hasNext() == false) goto L44;
            T r21 = r20.next();
            if (ShopHybridTabExtKt.e((ECHybridListItemDTO) r21) == false) goto L40;
            r19.add(r21);
            goto L40
        L44:
            int r22 = r19.size();
        L46:
            jm.a<Integer> r23 = this.a.getTruelyTotalProductNum();
            Integer r24 = (Integer) this.a.getTruelyTotalProductNum().getValue();
            if (r24 == null) goto L49;
            int r25 = r24.intValue();
        L50:
            r23.setValue(Integer.valueOf(r25 + r22));
            goto L21
        L49:
            r25 = 0;
            goto L50
        L45:
            r22 = 0;
            goto L46
        L25:
            r12 = 1;
        L51:
            this.a.getResponse().setValue(r14);
            SliceConfig.a r26 = SliceConfig.Companion;
            ECHybridListDTO r27 = r14.getHybridList();
            List r28 = null;
            if (r27 == null) goto L54;
            Map r29 = r27.getExtra();
        L55:
            r26.getClass();
            SliceConfig r30 = SliceConfig.a.a(r29);
            if (r30 == null) goto L58;
            this.a.getApiSliceConfig().setValue(r30);
        L58:
            this.a.getLoadStatus().g(LoadStatus.LoadMoreSuccess);
            ECShopHybridProductViewModel.access$updateRequestParamFromResponse(this.a, r14);
            ECHybridListDTO r31 = r14.getHybridList();
            if (r31 == null) goto L84;
            List r32 = r31.getSections();
            if (r32 == null) goto L84;
            Iterator<T> r33 = r32.iterator();
        L64:
            if (r33.hasNext() == false) goto L68;
            T r34 = r33.next();
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r34).getSectionId(), "__PRODUCTS_SECTION__") == false) goto L64;
        L69:
            ECHybridListSectionDTO r35 = (ECHybridListSectionDTO) r34;
            if (r35 == null) goto L84;
            ArrayList r36 = r35.getItems();
            if (r36 == null) goto L84;
            if (r36.isEmpty() == true) goto L84;
            Iterator<T> r37 = r36.iterator();
            int r38 = 0;
        L78:
            if (r37.hasNext() == false) goto L85;
            if (ShopHybridTabExtKt.e((ECHybridListItemDTO) r37.next()) == false) goto L78;
            r38 = r38 + 1;
            if (r38 >= 0) goto L78;
            CollectionsKt.throwCountOverflow();
        L85:
            dm.a.a("ec_shop_restore").a("product_fetch_next end tabId=" + this.a.getRequestParam().getRequestTabType() + " hasMore=" + r14.getHasMore() + " productCount=" + r38);
            if (r14.getHasMore() == true) goto L88;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
        L88:
            this.a.setFetchLock(false);
            this.a.setHasNextPage(r14.getHasMore());
            if (r14.getHasMore() == false) goto L128;
            ECHybridListDTO r110 = r14.getHybridList();
            if (r110 == null) goto L93;
            r28 = r110.getSections();
        L93:
            List r39 = r28;
            if (r39 != null) goto L96;
        L97:
            r1 = true;
        L98:
            if (r1 == false) goto L129;
            this.a.fetchProductBffApi();
            return;
        L129:
            return;
        L96:
            if (r39.isEmpty() == false) goto L98;
        L128:
            return;
        L68:
            r34 = null;
        L84:
            r38 = 0;
            goto L85
        L54:
            r29 = null;
            goto L55
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public d(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            this.a.setFetchLock(false);
            this.a.getLoadStatus().g(LoadStatus.LoadMoreError);
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getStoreParam().getLifecycleMonitorId()));
            if (r1 == null) goto L6;
            com.bytedance.android.shopping.store.lifecycle.c.a.d(r1, this.a.getTabConfig(), ((com.bytedance.android.ec.store.setting.h) ECStoreSettings.d.getValue()).a(), 1, Integer.valueOf(ErrorDomain.NATIVE.getCode()), Integer.valueOf(ErrorCode.NATIVE_COMMON.getCode()), r13.getMessage(), null, null, 192);
            return;
        }
    }

    public static final class e<T> implements ObservableOnSubscribe {
        public final /* synthetic */ ECShopHybridProductViewModel a;
        public final /* synthetic */ RequestType b;

        public e(ECShopHybridProductViewModel r1, RequestType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<String> r8) {
            Intrinsics.checkNotNullParameter(r8, "emit");
            String r1 = ECAppInfoService.e.getAppId();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            IFeatureCore r3 = FeatureCoreFactory.INSTANCE.getFeatureCore(r1);
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
            if (r3 == null) goto L16;
            IKVStore r5 = r3.createInMemoryKVStore(this.a.getPITAYA_PRODUCT_BUSINESS_ID());     // Catch: Throwable -> L19
            if (r5 == null) goto L16;
            JSONObject r6 = r5.getValueForKeys(CollectionsKt.listOf("kv_store_realtime_feat"));     // Catch: Throwable -> L19
            if (r6 == null) goto L16;
            JSONObject r0 = r6.optJSONObject("kv_store_realtime_feat");     // Catch: Throwable -> L19
            if (r0 == null) goto L16;
            String r7 = r0.toString();     // Catch: Throwable -> L19
            if (r7 == null) goto L16;
        L17:
            Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L19
        L21:
            JSONObject r10 = null;
            if (Result.isFailure-impl(r9) == false) goto L24;
            r9 = null;
        L24:
            String r11 = (String) r9;
            if (r11 == null) goto L28;
            r2 = r11;
        L28:
            boolean r12 = false;
            if (r2.length() <= 0) goto L31;
            boolean r13 = true;
        L32:
            if (r13 == false) goto L41;
            com.bytedance.android.ec.store.setting.d r14 = (com.bytedance.android.ec.store.setting.d) ECStoreSettings.a.getValue();
            if (r14 == null) goto L41;
            if (r14.a() != true) goto L41;
            String r15 = this.a.getRequestParam().getPassThroughApi();
            ECShopHybridProductReqParams r16 = this.a.getRequestParam();
            if (r15 == null) goto L40;
            r10 = com.bytedance.commerce.base.json.b.a(r15);
            r10.put("user_behavior", r2);
            Unit r17 = Unit.INSTANCE;
        L40:
            r16.setPassThroughApi(String.valueOf(r10));
        L41:
            ECShopHybridProductViewModel r18 = this.a;
            if (r3 == null) goto L44;
            r12 = true;
        L44:
            ECShopHybridProductViewModel.access$doProductListOptMonitor(r18, r12, r2, this.b.getType());
            r8.onNext(r2);
            return;
        L31:
            r13 = false;
        L16:
            r7 = "";
        L19:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public f(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ECShopProductListBffResponseDTO r7 = (ECShopProductListBffResponseDTO) r6;
            if (r7.getStatusCode() == 0) goto L5;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreError);
            this.a.setFetchLock(false);
            return;
        L5:
            ECHybridListDTO r0 = r7.getHybridList();
            if (r0 == null) goto L17;
            List r1 = r0.getSections();
            if (r1 == null) goto L17;
            Iterator<T> r2 = r1.iterator();
        L11:
            if (r2.hasNext() == false) goto L17;
            ECHybridListSectionDTO r3 = (ECHybridListSectionDTO) r2.next();
            LayoutTypes r4 = (LayoutTypes) this.a.getLayoutType().getValue();
            if (r4 == null) goto L15;
            int r5 = r4.getType();
        L16:
            l0.b(r3, r5);
            l0.d(r3, r5);
            goto L11
        L15:
            r5 = 1;
        L17:
            ECHybridListDTO r8 = r7.getHybridList();
            if (r8 == null) goto L20;
            List r9 = r8.getSections();
        L21:
            List r10 = r9;
            if (r10 != null) goto L24;
        L27:
            boolean r11 = true;
        L28:
            if (r11 == true) goto L30;
            r7.setDynamicInsert(true);
            this.a.getResponse().setValue(r7);
        L30:
            this.a.setFetchLock(false);
            ECShopHybridProductViewModel.access$resetInsertParam(this.a);
            return;
        L24:
            if (r10.isEmpty() == true) goto L27;
            r11 = false;
            goto L28
        L20:
            r9 = null;
            goto L21
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ECShopHybridProductViewModel a;

        public g(ECShopHybridProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.setFetchLock(false);
            ECShopHybridProductViewModel.access$resetInsertParam(this.a);
        }
    }

    public ECShopHybridProductViewModel() {
        DisposableScope r0 = null;
        super(r0, r0, 3, r0);
        ECStoreParam r1 = new ECStoreParam("");
        this.fakeStoreParam = r1;
        this.storeParam = r1;
        this.requestParam = new ECShopHybridProductReqParams();
        this.loadStatus = new QLiveData();
        this.isClothesSelected = new jm.a(6);
        this.layoutType = new jm.a(7);
        this.sessionId = UUID.randomUUID().toString();
        this.idRecords = new HashSet();
        this.removeVipCard = new jm.a(7);
        this.updateProduct = new jm.a(7);
        this.allIdRecords = new HashSet();
        this.currentProductId = "";
        this.skuProductIdRecords = new HashSet();
        this.ecomEntranceFrom = "";
        this.currentPlayStrategy = new jm.a(7);
        this.tagPools = new xm.c();
        jm.a<ej3.f> r2 = new jm.a(7);
        r2.setValue(null);
        Unit r3 = Unit.INSTANCE;
        this.sortsVO = r2;
        this.sortTypes = new jm.a(7);
        this.bigSaleMoveToTop = new jm.a(7);
        jm.a<com.bytedance.android.ec.store.repository.vo.n> r4 = new jm.a(7);
        r4.setValue(null);
        this.discountButton = r4;
        this.selectButtons = new ArrayList();
        this.filterSelectButtons = new ArrayList();
        this.pendingAction = new ArrayList();
        this.productViewsNum = new jm.a(7);
        this.totalProductNum = new jm.a(7);
        this.truelyTotalProductNum = new jm.a(7);
        this.dataSource = new ti3.a();
        this.response = new jm.a(7);
        this.refresh = new jm.a(6);
        this.apiSliceConfig = new jm.a(7);
        this.hasNextPage = true;
        byte[] r5 = new byte[16];
        new SecureRandom().nextBytes(r5);
        this.uniqueKeyForProductEvent = new BigInteger(1, r5).toString(16);
        this.PITAYA_PRODUCT_BUSINESS_ID = "ecom_store_rerank";
    }

    private final void fetchFirst() {
        this.loadStatus.g(LoadStatus.Initialize);
        this.requestParam.setLocalTemplateVersions(this.storeParam.getLocalVersionWithoutContent());
        dm.a.a("ec_shop_restore").a("product_fetch_first start tabId=" + this.requestParam.getRequestTabType() + " pagination=null");
        this.firstReqDis = com.bytedance.android.ec.core.async.a.a(bg4.b.b(getProductListObservable(RequestType.FIRST_LOAD)).subscribe(new a(this), new b(this)), this);
    }

    private final void fetchNext() {
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.storeParam.getLifecycleMonitorId()));
        if (r1 == null) goto L5;
        r1.i(this.tabConfig);
    L5:
        this.loadStatus.g(LoadStatus.LoadMoreIn);
        dm.a.b r2 = dm.a.a("ec_shop_restore");
        StringBuilder r3 = new StringBuilder("product_fetch_next start tabId=");
        r3.append(this.requestParam.getRequestTabType());
        r3.append(" paginationLen=");
        String r4 = this.requestParam.getPaginationParams();
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.length());
    L9:
        r3.append(r5);
        r2.a(r3.toString());
        this.nextReqDis = com.bytedance.android.ec.core.async.a.a(bg4.b.b(getProductListObservable(RequestType.LOAD_MORE)).subscribe(new c(this), new d(this)), this);
        return;
    L8:
        r5 = null;
        goto L9
    }

    private final void resetInsertParam() {
        JSONObject r1 = null;
        this.requestParam.setUnexposedIds(null);
        ECShopHybridProductReqParams r0 = this.requestParam;
        String r2 = r0.getClientState();
        if (r2 == null) goto L7;
        JSONObject r3 = com.bytedance.android.shopping.extensions.k.w(r2);
        if (r3 == null) goto L7;
        r3.remove("interactive_product_id");
        Unit r4 = Unit.INSTANCE;
        r1 = r3;
    L7:
        r0.setClientState(String.valueOf(r1));
    }

    public final void clearSkuIdRecords() {
        this.skuProductIdRecords.clear();
        this.productViewsNum.setValue(0);
        this.totalProductNum.setValue(0);
        this.truelyTotalProductNum.setValue(0);
    }

    public final com.bytedance.android.shopping.store.restore.i exportRequestState() {
        LayoutTypes r0 = (LayoutTypes) this.layoutType.getValue();
        List r1 = null;
        if (r0 == null) goto L5;
        Integer r3 = Integer.valueOf(r0.getType());
    L6:
        ECShopHybridProductReqParams r4 = this.requestParam;
        ej3.a r5 = (ej3.a) this.updateProduct.getValue();
        HashSet<String> r2 = this.allIdRecords;
        if ((!r2.isEmpty()) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        List r6 = CollectionsKt.toList(r2);
    L13:
        String r7 = this.currentProductId;
        if (r7.length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        String r9 = r7;
    L20:
        HashSet<String> r10 = this.skuProductIdRecords;
        if ((true ^ r10.isEmpty()) == true) goto L24;
        r10 = null;
    L24:
        if (r10 == null) goto L27;
        r1 = CollectionsKt.toList(r10);
    L27:
        return new com.bytedance.android.shopping.store.restore.i(r3, r4, r5, r6, r9, r1, (Integer) this.productViewsNum.getValue(), (Integer) this.totalProductNum.getValue(), Boolean.valueOf(this.hasNextPage));
    L19:
        r9 = null;
        goto L20
    L16:
        r8 = false;
        goto L17
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void fetchProductBffApi() {
        if (this.fetchLock == false) goto L5;
        return;
    L5:
        this.fetchLock = true;
        if (this.requestParam.getPaginationParams() != null) goto L8;
        clearSkuIdRecords();
        fetchFirst();
        return;
    L8:
        fetchNext();
    }

    public final Set<String> getUnExposedProducts() {
        HashSet<String> r0 = this.allIdRecords;
        r0.removeAll(this.idRecords);
        return r0;
    }

    public final boolean hasDiscountSelected() {
        if ((!this.selectButtons.isEmpty()) == false) goto L17;
        List<com.bytedance.android.ec.store.repository.dto.c> r0 = this.selectButtons;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r1.next()).e(), Boolean.TRUE) == false) goto L11;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        return true;
    L8:
        r2 = false;
        goto L15
    L7:
        if (r0.isEmpty() == false) goto L9;
    L17:
        return false;
    }

    public final void refreshAll() {
        this.requestParam.setFilterParams(JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]).toString());
        updateRequestParamForDiscount$default(this, true, false, 2, null);
        this.requestParam.setPaginationParams(null);
        this.refreshAll = true;
        this.isClothesSelected.setValue(Boolean.FALSE);
        this.refresh.setValue(Boolean.TRUE);
        this.discountButton.setValue(null);
        fetchProductBffApi();
    }

    public final void refreshPassthroughApiForSql() {
        ECShopHybridProductReqParams r0 = this.requestParam;
        JSONObject r1 = z1.f(r0.getPassThroughApi());
        Keva r2 = ECShopDataStorageForRemote.a;
        r1.put("sql_data_from_client", ECShopDataStorageForRemote.b(this.storeParam.getSecShopId(), com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId()));
        Unit r3 = Unit.INSTANCE;
        r0.setPassThroughApi(r1.toString());
    }

    public final void resetDisposable() {
        Disposable r0 = this.firstReqDis;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.nextReqDis;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.fetchLock = false;
    }

    public final void resetUniqueKey() {
        byte[] r2 = new byte[16];
        new SecureRandom().nextBytes(r2);
        this.uniqueKeyForProductEvent = new BigInteger(1, r2).toString(16);
    }

    public final void updateLoadMoreVisibleTime() {
        if (((LoadStatus) this.loadStatus.a()) == LoadStatus.LoadMoreIn) goto L5;
        return;
    L5:
        if (this.fetchLock == false) goto L11;
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.storeParam.getLifecycleMonitorId()));
        if (r1 == null) goto L12;
        r1.x(this.tabConfig);
        return;
    L12:
        return;
    }

    public final HashSet<String> getAllIdRecords() {
        return this.allIdRecords;
    }

    public final jm.a<SliceConfig> getApiSliceConfig() {
        return this.apiSliceConfig;
    }

    public final jm.a<Boolean> getBigSaleMoveToTop() {
        return this.bigSaleMoveToTop;
    }

    public final Map<String, com.bytedance.android.ec.store.repository.vo.h> getCachedCouponMapData() {
        return this.cachedCouponMapData;
    }

    public final com.bytedance.android.ec.store.repository.vo.g getCachedCouponPanelInfo() {
        return this.cachedCouponPanelInfo;
    }

    public final WeakReference<LottieAnimationViewWithPlayCount> getCartAnimationView() {
        return this.cartAnimationView;
    }

    public final WeakReference<View> getCartView() {
        return this.cartView;
    }

    public final jm.a<PlayControlStrategy> getCurrentPlayStrategy() {
        return this.currentPlayStrategy;
    }

    public final String getCurrentProductId() {
        return this.currentProductId;
    }

    public final ti3.a getDataSource() {
        return this.dataSource;
    }

    public final jm.a<com.bytedance.android.ec.store.repository.vo.n> getDiscountButton() {
        return this.discountButton;
    }

    public final String getEcomEntranceFrom() {
        return this.ecomEntranceFrom;
    }

    public final boolean getFetchLock() {
        return this.fetchLock;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> getFilterSelectButtons() {
        return this.filterSelectButtons;
    }

    public final Disposable getFirstReqDis() {
        return this.firstReqDis;
    }

    public final boolean getHasBind() {
        return this.hasBind;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public final boolean getHasSelectButton() {
        return this.hasSelectButton;
    }

    public final ECHybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final com.bytedance.android.ec.hybrid.list.entity.k getHybridListVO() {
        return this.hybridListVO;
    }

    public final HashSet<String> getIdRecords() {
        return this.idRecords;
    }

    public final StoreV2ProductListResponseVO getInitialData() {
        return this.initialData;
    }

    public final jm.a<LayoutTypes> getLayoutType() {
        return this.layoutType;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final int getMaxDepth() {
        return this.maxDepth;
    }

    public final com.bytedance.android.ec.store.repository.vo.h getMiddleCouponFilterVO() {
        return this.middleCouponFilterVO;
    }

    public final Disposable getNextReqDis() {
        return this.nextReqDis;
    }

    public final String getPITAYA_PRODUCT_BUSINESS_ID() {
        return this.PITAYA_PRODUCT_BUSINESS_ID;
    }

    public final List<Runnable> getPendingAction() {
        return this.pendingAction;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.g> getPickTypes() {
        return this.pickTypes;
    }

    public final jm.a<Integer> getProductViewsNum() {
        return this.productViewsNum;
    }

    public final jm.a<Boolean> getRefresh() {
        return this.refresh;
    }

    public final boolean getRefreshAll() {
        return this.refreshAll;
    }

    public final jm.a<Boolean> getRemoveVipCard() {
        return this.removeVipCard;
    }

    public final ECShopHybridProductReqParams getRequestParam() {
        return this.requestParam;
    }

    public final jm.a<ECShopProductListBffResponseDTO> getResponse() {
        return this.response;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> getSelectButtons() {
        return this.selectButtons;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getShowSelectPanelEntry() {
        return this.showSelectPanelEntry;
    }

    public final HashSet<String> getSkuProductIdRecords() {
        return this.skuProductIdRecords;
    }

    public final jm.a<List<com.bytedance.android.ec.store.repository.vo.r>> getSortTypes() {
        return this.sortTypes;
    }

    public final jm.a<ej3.f> getSortsVO() {
        return this.sortsVO;
    }

    public final ECStoreParam getStoreParam() {
        return this.storeParam;
    }

    public final StoreTabConfig getTabConfig() {
        return this.tabConfig;
    }

    public final xm.c getTagPools() {
        return this.tagPools;
    }

    public final Integer getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final jm.a<Integer> getTotalProductNum() {
        return this.totalProductNum;
    }

    public final jm.a<Integer> getTruelyTotalProductNum() {
        return this.truelyTotalProductNum;
    }

    public final String getUniqueKeyForProductEvent() {
        return this.uniqueKeyForProductEvent;
    }

    public final jm.a<ej3.a> getUpdateProduct() {
        return this.updateProduct;
    }

    public final jm.a<Boolean> isClothesSelected() {
        return this.isClothesSelected;
    }

    public final boolean isRestoredData() {
        return this.isRestoredData;
    }

    public static final /* synthetic */ boolean access$getFlagEndApiDuration$p(ECShopHybridProductViewModel r0) {
        return r0.flagEndApiDuration;
    }

    public static final /* synthetic */ void access$resetInsertParam(ECShopHybridProductViewModel r0) {
        r0.resetInsertParam();
    }

    private final Observable<ECShopProductListBffResponseDTO> getProductListObservable(RequestType r2) {
        return i1.a(Observable.create(new e(this, r2)), new AnonymousClass1(this));
    }

    private final void preloadRemainXML(LayoutTypes r4) {
        WeakReference<Context> r5 = this.contextReference;
        if (r5 == null) goto L9;
        Context r6 = r5.get();
        if (r6 == null) goto L10;
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r7 = th.a.e(r6, true);
        r0.getClass();
        com.bytedance.android.ec.opt.asyncInflate.d r8 = ShoppingAsyncInflater.a.a(r7).a();
        r8.c(2131564716, 1, "shopping_layout_ec_store_tab_footer");
        r8.commit();
        return;
    L10:
        return;
    }

    private final void updatePickTypes(int r4) {
        List<com.bytedance.android.ec.store.repository.dto.g> r0 = this.pickTypes;
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        com.bytedance.android.ec.store.repository.dto.g r2 = (com.bytedance.android.ec.store.repository.dto.g) r1.next();
        if (r2.a() != r4) goto L10;
        boolean r3 = true;
    L11:
        r2.c(r3);
        goto L6
    L10:
        r3 = false;
        goto L11
    L16:
        return;
    }

    private final void updateRequestParamFromResponse(ECShopProductListBffResponseDTO r2) {
        this.requestParam.setPaginationParams(r2.getPaginationParams());
        this.refresh.setValue(Boolean.FALSE);
        JSONObject r3 = com.bytedance.android.shopping.extensions.k.w(this.requestParam.getFilterParams());
        if (r3 == null) goto L6;
        r3.remove("custom_ids");
        r3.remove("custom_id_type");
        return;
    }

    public final void importRequestState(com.bytedance.android.shopping.store.restore.i r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        ECShopHybridProductReqParams r0 = r9.b;
        LayoutTypes r1 = null;
        if (r0 == null) goto L5;
        this.requestParam = r0;
        r0.setFilterRequest(false);
        this.requestParam.setUnexposedIds(null);
        resetInsertParam();
    L5:
        Integer r2 = r9.a;
        if (r2 == null) goto L16;
        int r3 = r2.intValue();
        LayoutTypes[] r4 = LayoutTypes.values();
        int r5 = r4.length;
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L16;
        LayoutTypes r7 = r4[r6];
        if (r7.getType() != r3) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == true) goto L14;
        r6 = r6 + 1;
        goto L8
    L14:
        r1 = r7;
        goto L16
    L12:
        r8 = false;
    L16:
        if (r1 == null) goto L18;
        this.layoutType.setValue(r1);
    L18:
        ej3.a r10 = r9.c;
        if (r10 == null) goto L21;
        this.updateProduct.setValue(r10);
    L21:
        this.allIdRecords.clear();
        List<String> r11 = r9.d;
        if (r11 == null) goto L24;
        this.allIdRecords.addAll(r11);
    L24:
        String r12 = r9.e;
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        this.currentProductId = r12;
        this.skuProductIdRecords.clear();
        List<String> r13 = r9.f;
        if (r13 == null) goto L30;
        this.skuProductIdRecords.addAll(r13);
    L30:
        Integer r14 = r9.g;
        if (r14 == null) goto L33;
        int r15 = r14.intValue();
        this.productViewsNum.setValue(Integer.valueOf(r15));
    L33:
        Integer r16 = r9.h;
        if (r16 == null) goto L36;
        int r17 = r16.intValue();
        this.totalProductNum.setValue(Integer.valueOf(r17));
    L36:
        Boolean r18 = r9.i;
        if (r18 == null) goto L42;
        this.hasNextPage = r18.booleanValue();
        return;
    }

    public final void prefetchInsertData(String r11) {
        Intrinsics.checkNotNullParameter(r11, "currentProductId");
        this.currentProductId = r11;
        ECShopHybridProductReqParams r0 = this.requestParam;
        String r1 = r0.getClientState();
        if (r1 == null) goto L7;
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(r1);
        if (r2 == null) goto L7;
        r2.put("interactive_product_id", r11);
        Unit r12 = Unit.INSTANCE;
    L8:
        r0.setClientState(String.valueOf(r2));
        this.requestParam.setUnexposedIds(CollectionsKt.joinToString$default(getUnExposedProducts(), ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(getProductListObservable(RequestType.INSERT)).subscribe(new f(this), new g(this)), this);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void refreshByLiveSameTab(int r5) {
        if (com.bytedance.android.shopping.extensions.k.c(this.requestParam.getFilterParams()) == false) goto L5;
        JSONObject r0 = com.bytedance.commerce.base.json.b.a(this.requestParam.getFilterParams());
    L6:
        r0.put("pick_type", r5);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.storeParam.getLifecycleMonitorId()));
        if (r2 == null) goto L9;
        r2.p(this.tabConfig, r0, this.requestParam.getFilterEventParams());
    L9:
        this.requestParam.setFilterRequest(true);
        this.requestParam.setFilterParams(r0.toString());
        this.requestParam.setPaginationParams(null);
        updatePickTypes(r5);
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
        return;
    L5:
        r0 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        goto L6
    }

    public final void refreshSelectStatus(int r6) {
        Iterator<T> r0 = this.selectButtons.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.android.ec.store.repository.dto.c r5 = (com.bytedance.android.ec.store.repository.dto.c) r3;
        if (r2 != r6) goto L11;
        boolean r7 = true;
    L12:
        r5.f(Boolean.valueOf(r7));
        r2 = r4;
        goto L4
    L11:
        r7 = false;
        goto L12
    }

    public final void setApiSliceConfig(jm.a<SliceConfig> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.apiSliceConfig = r2;
    }

    public final void setCachedCouponMapData(Map<String, com.bytedance.android.ec.store.repository.vo.h> r1) {
        this.cachedCouponMapData = r1;
    }

    public final void setCachedCouponPanelInfo(com.bytedance.android.ec.store.repository.vo.g r1) {
        this.cachedCouponPanelInfo = r1;
    }

    public final void setCartAnimationView(WeakReference<LottieAnimationViewWithPlayCount> r1) {
        this.cartAnimationView = r1;
    }

    public final void setCartView(WeakReference<View> r1) {
        this.cartView = r1;
    }

    public final void setCurrentProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentProductId = r2;
    }

    public final void setEcomEntranceFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ecomEntranceFrom = r2;
    }

    public final void setFetchLock(boolean r1) {
        this.fetchLock = r1;
    }

    public final void setFilterSelectButtons(List<com.bytedance.android.ec.store.repository.dto.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.filterSelectButtons = r2;
    }

    public final void setFirstReqDis(Disposable r1) {
        this.firstReqDis = r1;
    }

    public final void setHasBind(boolean r1) {
        this.hasBind = r1;
    }

    public final void setHasNextPage(boolean r1) {
        this.hasNextPage = r1;
    }

    public final void setHasSelectButton(boolean r1) {
        this.hasSelectButton = r1;
    }

    public final void setHybridList(ECHybridListDTO r1) {
        this.hybridList = r1;
    }

    public final void setHybridListVO(com.bytedance.android.ec.hybrid.list.entity.k r1) {
        this.hybridListVO = r1;
    }

    public final void setInitialData(StoreV2ProductListResponseVO r1) {
        this.initialData = r1;
    }

    public final void setLayoutType(jm.a<LayoutTypes> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.layoutType = r2;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadStatus = r2;
    }

    public final void setMiddleCouponFilterVO(com.bytedance.android.ec.store.repository.vo.h r1) {
        this.middleCouponFilterVO = r1;
    }

    public final void setNextReqDis(Disposable r1) {
        this.nextReqDis = r1;
    }

    public final void setPickTypes(List<com.bytedance.android.ec.store.repository.dto.g> r1) {
        this.pickTypes = r1;
    }

    public final void setRefresh(jm.a<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.refresh = r2;
    }

    public final void setRefreshAll(boolean r1) {
        this.refreshAll = r1;
    }

    public final void setRequestParam(ECShopHybridProductReqParams r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.requestParam = r2;
    }

    public final void setRestoredData(boolean r1) {
        this.isRestoredData = r1;
    }

    public final void setSelectButtons(List<com.bytedance.android.ec.store.repository.dto.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectButtons = r2;
    }

    public final void setSessionId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sessionId = r2;
    }

    public final void setShowSelectPanelEntry(boolean r1) {
        this.showSelectPanelEntry = r1;
    }

    public final void setSortsVO(jm.a<ej3.f> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sortsVO = r2;
    }

    public final void setStoreParam(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.storeParam = r2;
    }

    public final void setTabConfig(StoreTabConfig r1) {
        this.tabConfig = r1;
    }

    public final void setTitleMaxLines(Integer r1) {
        this.titleMaxLines = r1;
    }

    public final void setUniqueKeyForProductEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uniqueKeyForProductEvent = r2;
    }

    public final void upDateSelectParams(String r3) {
        if (com.bytedance.android.shopping.extensions.k.c(this.requestParam.getFilterParams()) == false) goto L5;
        JSONObject r0 = com.bytedance.commerce.base.json.b.a(this.requestParam.getFilterParams());
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r3) == false) goto L9;
        r0.putOpt("select_params", r3);
    L9:
        this.requestParam.setFilterParams(r0.toString());
        return;
    L5:
        r0 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        goto L7
    }

    public final void updateMiddleCouponFilterClientState(boolean r4) {
        JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(this.requestParam.getClientState());
        if (r0 != null) goto L5;
        r0 = new JSONObject();
    L5:
        r0.remove("middle_coupon_filter");
        com.bytedance.android.ec.store.repository.vo.h r2 = this.middleCouponFilterVO;
        if (r4 == true) goto L12;
        if (r2 == null) goto L12;
        JSONObject r5 = com.bytedance.android.ec.hybrid.list.util.k.b(r2);     // Catch: Throwable -> L10
        r5.remove("panel_info");     // Catch: Throwable -> L10
        r5.remove("coupon_map_data");     // Catch: Throwable -> L10
        String r6 = r5.toString();     // Catch: Throwable -> L10
    L15:
        r0.put("middle_coupon_filter", r6);     // Catch: Throwable -> L14
    L10:
        r6 = "{}";
    L12:
        String r7 = r0.toString();
        this.requestParam.setClientState(r7);
    }

    public static final /* synthetic */ void access$setFlagEndApiDuration$p(ECShopHybridProductViewModel r0, boolean r1) {
        r0.flagEndApiDuration = r1;
    }

    public static final /* synthetic */ void access$updateRequestParamFromResponse(ECShopHybridProductViewModel r0, ECShopProductListBffResponseDTO r1) {
        r0.updateRequestParamFromResponse(r1);
    }

    private final void initEventParams(String r17, String r18) {
        Pair<String, String>[] r2 = com.bytedance.android.shopping.store.utils.z.a(this.storeParam.getStoreAccountParam().getUserId(), this.storeParam.getEnterFrom(), this.storeParam.getStoreSourcePage(), this.storeParam.getStoreSourceMethod(), this.storeParam.getStoreGroupType(), this.storeParam.getEntranceLocation(), this.storeParam.getPageName(), this.storeParam.getFollowStatus(), this.storeParam.isPreview(), this.storeParam.getTempId(), r17, new Pair[]{TuplesKt.to("shop_version", r18), TuplesKt.to("tab_id", String.valueOf(this.requestParam.getRequestTabType()))});
        initEventContext((Pair[]) Arrays.copyOf(r2, r2.length));
        if (Intrinsics.areEqual(this.storeParam.getPageName(), "classification_secondary_page") == false) goto L5;
        appendEventParams(new Pair[]{TuplesKt.to("source_page", "store_page")});
    L5:
        appendEventParams((Pair[]) Arrays.copyOf(com.bytedance.android.shopping.store.utils.z.b(this.storeParam.getShopId(), this.storeParam.getSecShopId()), 2));
    }

    private final void updateRequestParamForDiscount(boolean r7, boolean r8) {
        JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(this.requestParam.getClientState());
        if (r0 != null) goto L5;
        r0 = new JSONObject();
    L5:
        r0.remove("select_buttons");
        r0.remove("filter_select_buttons");
        if (r7 == true) goto L28;
        List<com.bytedance.android.ec.store.repository.dto.c> r4 = this.selectButtons;
        boolean r5 = false;
        if (r4 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L44;
        List<com.bytedance.android.ec.store.repository.dto.c> r9 = this.filterSelectButtons;
        if (r9 != null) goto L18;
    L19:
        r5 = true;
    L20:
        if (r5 == true) goto L28;
    L18:
        if (r9.isEmpty() == false) goto L20;
    L44:
        if (this.middleCouponFilterVO != null) goto L24;
        r0.put("select_buttons", com.bytedance.android.ec.hybrid.list.util.k.d(this.selectButtons));     // Catch: Throwable -> L26
    L24:
        r0.put("filter_select_buttons", com.bytedance.android.ec.hybrid.list.util.k.d(this.filterSelectButtons));     // Catch: Throwable -> L26
        goto L28
    L10:
        if (r4.isEmpty() == true) goto L13;
        r6 = false;
    L28:
        if (r8 == false) goto L30;
        r0.put("update_buttons", 1);
    L31:
        this.requestParam.setClientState(r0.toString());
        updateMiddleCouponFilterClientState(r7);
        if (r7 == false) goto L51;
        ECShopHybridProductReqParams r10 = this.requestParam;
        Map<String, Object> r11 = r10.getClientStateFromLynx();
        if (r11 == null) goto L41;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r12 = r11.entrySet().iterator();
    L37:
        if (r12.hasNext() == false) goto L42;
        Map.Entry<String, Object> r13 = r12.next();
        if ((!Intrinsics.areEqual(r13.getKey(), "select_buttons")) == false) goto L37;
        r2.put(r13.getKey(), r13.getValue());
    L42:
        r10.setClientStateFromLynx(r2);
        this.requestParam.setFilterParamsFromLynx(null);
        return;
    L41:
        r2 = null;
        goto L42
    L51:
        return;
    L30:
        r0.remove("update_buttons");
        goto L31
    }

    public final void refreshByCustomId(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "customIdType");
        Intrinsics.checkNotNullParameter(r5, "customIds");
        JSONObject r1 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        r1.put("custom_id_type", r4);
        r1.put("custom_ids", r5);
        updateRequestParamForDiscount$default(this, true, false, 2, null);
        this.refreshAll = true;
        this.isClothesSelected.setValue(Boolean.FALSE);
        this.discountButton.setValue(null);
        this.requestParam.setPaginationParams(null);
        this.requestParam.setFilterParams(r1.toString());
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
    }

    public final void refreshByDiscountSelect(String r6, String r7) {
        updateRequestParamForDiscount$default(this, false, false, 3, null);
        if (com.bytedance.android.shopping.extensions.k.c(this.requestParam.getFilterParams()) == false) goto L5;
        JSONObject r0 = com.bytedance.commerce.base.json.b.a(this.requestParam.getFilterParams());
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r6) == false) goto L9;
        r0.putOpt("select_params", r6);
    L11:
        if (this.showSelectPanelEntry == false) goto L13;
        r0.putOpt("show_select_panel_button", 1);
    L14:
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r8 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r9 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.storeParam.getLifecycleMonitorId()));
        if (r9 == null) goto L17;
        r9.p(this.tabConfig, r0, r7);
    L17:
        this.requestParam.setFilterRequest(true);
        this.requestParam.setFilterParams(r0.toString());
        this.requestParam.setFilterEventParams(r7);
        this.requestParam.setPaginationParams(null);
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
        return;
    L13:
        r0.remove("show_select_panel_button");
        goto L14
    L9:
        r0.remove("select_params");
        goto L11
    L5:
        r0 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        goto L7
    }

    public final void refreshByLynx(Map<String, ? extends Object> r2, Map<String, ? extends Object> r3) {
        this.requestParam.setClientStateFromLynx(r3);
        this.requestParam.setFilterParamsFromLynx(r2);
        this.requestParam.setPaginationParams(null);
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
    }

    public final void refreshBySortAndSortType(Long r3, Integer r4) {
        int r1 = 0;
        if (com.bytedance.android.shopping.extensions.k.c(this.requestParam.getFilterParams()) == false) goto L5;
        JSONObject r0 = com.bytedance.commerce.base.json.b.a(this.requestParam.getFilterParams());
    L6:
        if (r4 == null) goto L8;
        r1 = r4.intValue();
    L8:
        r0.putOpt("order", Integer.valueOf(r1));
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        r0.putOpt("sort_type", Long.valueOf(r5));
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r6 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.storeParam.getLifecycleMonitorId()));
        if (r7 == null) goto L15;
        r7.p(this.tabConfig, r0, this.requestParam.getFilterEventParams());
    L15:
        this.requestParam.setFilterRequest(true);
        this.requestParam.setFilterParams(r0.toString());
        this.requestParam.setPaginationParams(null);
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
        return;
    L11:
        r5 = 0;
        goto L12
    L5:
        r0 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        goto L6
    }

    public final void setButtonSelected(String r4, boolean r5) {
        JSONObject r0 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[0]);
        if (com.bytedance.android.shopping.extensions.k.c(r4) == false) goto L6;
        r0.putOpt("select_params", r4);
    L6:
        if (this.showSelectPanelEntry == false) goto L8;
        r0.putOpt("show_select_panel_button", 1);
    L8:
        updateRequestParamForDiscount(!r5, r5);
        this.refreshAll = true;
        this.isClothesSelected.setValue(Boolean.FALSE);
        this.discountButton.setValue(null);
        this.requestParam.setPaginationParams(null);
        this.requestParam.setFilterParams(r0.toString());
        this.refresh.setValue(Boolean.TRUE);
        fetchProductBffApi();
    }

    private final void doProductListOptMonitor(boolean r9, String r10, String r11) {
        int r0 = com.bytedance.android.shopping.store.utils.j.a;
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "requestType");
        long r1 = com.bytedance.commerce.base.json.b.a(r10).optLong("update_time");
        long r2 = System.currentTimeMillis();
        Pair[] r4 = new Pair[9];
        String r5 = ECAppInfoService.e.getAppId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4[0] = TuplesKt.to("pty_ready", Integer.valueOf(PitayaCoreFactory.getCore(r5).isReady() ? 1 : 0));
        if (r10.length() <= 0) goto L8;
        int r12 = 1;
    L9:
        r4[1] = TuplesKt.to("has_pty_data", Integer.valueOf(r12));
        r4[2] = TuplesKt.to("read_success", Integer.valueOf(r9 ? 1 : 0));
        r4[3] = TuplesKt.to("gen_time", Long.valueOf(r1));
        r4[4] = TuplesKt.to("upload_time", Long.valueOf(r2));
        r4[5] = TuplesKt.to("gen_upload_diff", Long.valueOf(r2 - r1));
        r4[6] = TuplesKt.to("request_type", r11);
        r4[7] = TuplesKt.to("biz", "ecom_store_rerank");
        r4[8] = TuplesKt.to("scene", "shop");
        doAnyEventAction("store_req_rt_feat_monitor", MapsKt.mapOf(r4), new Pair[0]);
        return;
    L8:
        r12 = 0;
        goto L9
    }

    public static final /* synthetic */ void access$doProductListOptMonitor(ECShopHybridProductViewModel r0, boolean r1, String r2, String r3) {
        r0.doProductListOptMonitor(r1, r2, r3);
    }

    public static /* synthetic */ void refreshByLiveSameTab$default(ECShopHybridProductViewModel r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.refreshByLiveSameTab(r1);
    }

    public static /* synthetic */ void refreshSelectStatus$default(ECShopHybridProductViewModel r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = -1;
    L5:
        r0.refreshSelectStatus(r1);
    }

    private final void setLayoutTypeIfNeed(Integer r5, Integer r6, boolean r7, Map<String, dj3.k> r8) {
        LayoutTypes r0 = (LayoutTypes) this.layoutType.getValue();
        LayoutTypes r1 = LayoutTypes.RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW;
        if (r0 != r1) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
    L15:
        if (r5 != null) goto L18;
        if (r6 != null) goto L18;
        if (r7 == true) goto L18;
        return;
    L18:
        int r9 = com.bytedance.android.ec.store.utils.h.a;
        LayoutTypes r10 = com.bytedance.android.ec.store.utils.h.b(r5, r6);
        this.layoutType.setValue(r10);
        preloadRemainXML(r10);
        return;
    L7:
        if (r8.containsKey("clothes_preview_button") != true) goto L15;
        dj3.k r11 = r8.get("clothes_preview_button");
        if (r11 != null) goto L11;
    L13:
        this.layoutType.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
        return;
    L11:
        if (r11.b() != true) goto L13;
        this.layoutType.setValue(r1);
    }

    public static /* synthetic */ void updatePickTypes$default(ECShopHybridProductViewModel r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.updatePickTypes(r1);
    }

    public static final /* synthetic */ void access$setLayoutTypeIfNeed(ECShopHybridProductViewModel r0, Integer r1, Integer r2, boolean r3, Map r4) {
        r0.setLayoutTypeIfNeed(r1, r2, r3, r4);
    }

    public static /* synthetic */ void refreshByDiscountSelect$default(ECShopHybridProductViewModel r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.refreshByDiscountSelect(r2, r3);
    }

    public static /* synthetic */ void setButtonSelected$default(ECShopHybridProductViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setButtonSelected(r1, r2);
    }

    public static /* synthetic */ void updateRequestParamForDiscount$default(ECShopHybridProductViewModel r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        r1.updateRequestParamForDiscount(r2, r3);
    }

    private final void initRequestParams(ECStoreParam r6, List<com.bytedance.android.ec.store.repository.dto.c> r7, String r8, List<com.bytedance.android.ec.store.repository.dto.m> r9, StoreTabConfig r10, String r11) {
        this.requestParam.setSecShopId(r6.getSecShopId());
        this.requestParam.setPassThroughApi((String) r6.getPassThroughParam("pass_through_api"));
        if (r7 == null) goto L14;
        Iterator<T> r1 = r7.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r2).e(), Boolean.TRUE) == false) goto L6;
    L11:
        com.bytedance.android.ec.store.repository.dto.c r3 = (com.bytedance.android.ec.store.repository.dto.c) r2;
        if (r3 == null) goto L14;
        this.requestParam.setSelectParams(r3.c());
        goto L14
    L10:
        r2 = null;
    L14:
        ECShopHybridProductReqParams r4 = this.requestParam;
        if (r10 == null) goto L17;
        Integer r12 = Integer.valueOf(r10.getTabType());
    L18:
        r4.setRequestTabType(r12);
        this.requestParam.setHybridParams(r11);
        if (r9 == null) goto L26;
        Iterator<T> r13 = r9.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        com.bytedance.android.ec.store.repository.dto.m r14 = (com.bytedance.android.ec.store.repository.dto.m) r13.next();
        if (r14.n() == false) goto L22;
        this.requestParam.setSortType(r14.e());
        this.requestParam.setOrder(r14.c());
    L26:
        this.requestParam.setPickType(r6.getPickType());
        com.bytedance.commerce.base.json.a[] r15 = new com.bytedance.commerce.base.json.a[3];
        boolean r16 = false;
        r15[0] = JsonDslUtilKt.c("order", this.requestParam.getOrder());
        r15[1] = JsonDslUtilKt.b(this.requestParam.getSortType());
        Integer r17 = this.requestParam.getPickType();
        if (r17 == null) goto L29;
        int r18 = r17.intValue();
    L30:
        r15[2] = JsonDslUtilKt.c("pick_type", r18);
        JSONObject r19 = JsonDslUtilKt.a(r15);
        String r110 = this.requestParam.getSelectParams();
        if (r110 == null) goto L33;
        r19.putOpt("select_params", r110);
    L33:
        String r111 = r6.getProductBasicRequestParam().getCustomIds();
        if (r111 == null) goto L36;
        r19.putOpt("custom_ids", r111);
    L36:
        Integer r20 = r6.getProductBasicRequestParam().getCustomIdType();
        if (r20 == null) goto L39;
        r19.putOpt("custom_id_type", Integer.valueOf(r20.intValue()));
    L39:
        this.requestParam.setFilterParams(r19.toString());
        com.bytedance.commerce.base.json.a[] r21 = new com.bytedance.commerce.base.json.a[1];
        LayoutTypes r22 = (LayoutTypes) this.layoutType.getValue();
        if (r22 == null) goto L42;
        int r23 = r22.getType();
    L43:
        r21[0] = JsonDslUtilKt.c("list_style", 2 - r23);
        JSONObject r24 = JsonDslUtilKt.a(r21);
        List<com.bytedance.android.ec.store.repository.dto.c> r25 = r7;
        if (r25 != null) goto L46;
    L47:
        r16 = true;
    L49:
        if ((!r16) == true) goto L52;
        r7 = null;
    L52:
        if (r7 == null) goto L54;
        r24.putOpt("select_buttons", GsonProtectorUtils.toJson(new Gson(), r7));
    L54:
        this.requestParam.setClientState(r24.toString());
        if (r8 == null) goto L66;
        this.requestParam.setPaginationParams(r8);
        return;
    L66:
        return;
    L46:
        if (r25.isEmpty() == false) goto L49;
    L42:
        r23 = 1;
        goto L43
    L29:
        r18 = 0;
        goto L30
    L17:
        r12 = null;
        goto L18
    }

    public final void init(ECStoreParam r13, StoreV2ProductListResponseVO r14, StoreTabConfig r15, String r16, String r17, Context r18) {
        Intrinsics.checkNotNullParameter(r13, "storeParam");
        this.contextReference = new WeakReference(r18);
        this.storeParam = r13;
        this.tabConfig = r15;
        this.initialData = r14;
        bindMonitorId(Long.valueOf(r13.getLifecycleMonitorId()));
        String r9 = null;
        if (r14 == null) goto L9;
        Map r1 = r14.getBizExtra();
        if (r1 == null) goto L9;
        String r2 = (String) r1.get("title_lines");
        if (r2 == null) goto L9;
        Integer r3 = StringsKt.toIntOrNull(r2);
    L10:
        this.titleMaxLines = r3;
        jm.a<Integer> r4 = this.totalProductNum;
        boolean r5 = false;
        if (r14 == null) goto L19;
        Map r6 = r14.getBizExtra();
        if (r6 == null) goto L19;
        String r7 = (String) r6.get("product_total_count");
        if (r7 == null) goto L19;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L19;
        int r10 = r8.intValue();
    L20:
        r4.setValue(Integer.valueOf(r10));
        if (r14 == null) goto L23;
        com.bytedance.android.ec.hybrid.list.entity.k r11 = r14.getHybridListVO();
    L24:
        this.hybridListVO = r11;
        if (r11 == null) goto L44;
        ArrayList r12 = r11.c;
        if (r12 == null) goto L44;
        Iterator r19 = r12.iterator();
    L29:
        List<com.bytedance.android.ec.store.repository.dto.m> r20 = null;
    L31:
        if (r19.hasNext() == false) goto L46;
        com.bytedance.android.ec.hybrid.list.entity.i r21 = (com.bytedance.android.ec.hybrid.list.entity.i) r19.next();
        if (Intrinsics.areEqual(r21.a, "__FILTER_SECTION__") == false) goto L31;
        ArrayList r22 = r21.i;
        if (r22 == null) goto L31;
        ECHybridListItemVO r23 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L31;
        Object r24 = r23.d();
        if ((r24 instanceof dj3.g) == true) goto L41;
        r24 = null;
    L41:
        dj3.g r25 = (dj3.g) r24;
        if (r25 == null) goto L29;
        r20 = r25.f();
    L46:
        if (r14 == null) goto L78;
        com.bytedance.android.ec.hybrid.list.entity.k r26 = r14.getHybridListVO();
        if (r26 == null) goto L78;
        ArrayList r27 = r26.c;
        if (r27 == null) goto L78;
        Iterator r28 = r27.iterator();
    L53:
        if (r28.hasNext() == false) goto L57;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r29).a, "__FILTER_SECTION__") == false) goto L53;
    L58:
        com.bytedance.android.ec.hybrid.list.entity.i r30 = (com.bytedance.android.ec.hybrid.list.entity.i) r29;
        if (r30 == null) goto L78;
        ArrayList r31 = r30.i;
        if (r31 == null) goto L78;
        Iterator r32 = r31.iterator();
    L64:
        if (r32.hasNext() == false) goto L74;
        Object r33 = r32.next();
        Integer r34 = ((ECHybridListItemVO) r33).c;
        int r110 = ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType();
        if (r34 != null) goto L69;
    L71:
        boolean r35 = false;
    L72:
        if (r35 == false) goto L64;
    L75:
        ECHybridListItemVO r36 = (ECHybridListItemVO) r33;
        if (r36 == null) goto L78;
        Object r37 = r36.d();
    L80:
        if ((r37 instanceof dj3.g) == true) goto L82;
        r37 = null;
    L82:
        ej3.f.g.getClass();
        ej3.f r38 = ej3.f.a.a((dj3.g) r37);
        List<com.bytedance.android.ec.store.repository.dto.c> r39 = r38.d;
        if (r14 == null) goto L85;
        Integer r40 = r14.getLayoutType();
    L86:
        if (r14 == null) goto L88;
        Integer r111 = r14.getForceProductLayout();
    L89:
        setLayoutTypeIfNeed(r40, r111, false, r38.f);
        SliceConfig.a r41 = SliceConfig.Companion;
        if (r14 == null) goto L94;
        com.bytedance.android.ec.hybrid.list.entity.k r42 = r14.getHybridListVO();
        if (r42 == null) goto L94;
        Map r43 = r42.d;
    L95:
        r41.getClass();
        SliceConfig r44 = SliceConfig.a.a(r43);
        if (r44 == null) goto L98;
        this.apiSliceConfig.setValue(r44);
    L98:
        if (r14 == null) goto L100;
        boolean r45 = r14.getHasMore();
    L101:
        this.hasNextPage = r45;
        if (r39 == null) goto L104;
        r5 = true;
    L104:
        this.hasSelectButton = r5;
        if (r14 == null) goto L107;
        String r46 = r14.getPaginationParams();
    L108:
        if (r14 == null) goto L110;
        String r112 = r14.getHybridParams();
    L111:
        initRequestParams(r13, r39, r46, r20, r15, r112);
        initEventParams(r16, r17);
        com.bytedance.android.ec.hybrid.list.entity.k r0 = this.hybridListVO;
        if (r0 == null) goto L116;
        Map r47 = r0.d;
        if (r47 == null) goto L116;
        String r48 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r47, "coupon_plan_id", null);
    L117:
        com.bytedance.android.ec.hybrid.list.entity.k r49 = this.hybridListVO;
        if (r49 == null) goto L122;
        Map r50 = r49.d;
        if (r50 == null) goto L122;
        r9 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r50, "coupon_panel_data", null);
    L122:
        JSONObject r51 = com.bytedance.android.shopping.extensions.k.w(r9);
        if (r48 != null) goto L125;
        return;
    L125:
        if ((!Intrinsics.areEqual(r48, "")) == false) goto L153;
        if (r51 == null) goto L154;
        HashMap r52 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r53 = new JSONObject();
        r53.putOpt("pass_through_api", r13.getPassThroughParam("pass_through_api"));
        r53.putOpt("sec_shop_id", r13.getSecShopId());
        r53.putOpt("shop_version", "brand");
        Iterator<Map.Entry<String, String>> r54 = getBaseParams().entrySet().iterator();
    L129:
        if (r54.hasNext() == false) goto L131;
        Map.Entry<String, String> r55 = r54.next();
        r53.putOpt(r55.getKey(), r55.getValue());
        goto L129
    L131:
        Unit r56 = Unit.INSTANCE;
        r51.putOpt("meta", r53);
        com.bytedance.android.ec.core.hybrid.utils.j.h(r48, r51);
        return;
    L154:
        return;
    L153:
        return;
    L116:
        r48 = null;
        goto L117
    L110:
        r112 = null;
        goto L111
    L107:
        r46 = null;
        goto L108
    L100:
        r45 = true;
    L94:
        r43 = null;
        goto L95
    L88:
        r111 = null;
        goto L89
    L85:
        r40 = null;
        goto L86
    L69:
        if (r34.intValue() != r110) goto L71;
        r35 = true;
        goto L72
    L74:
        r33 = null;
        goto L75
    L57:
        r29 = null;
    L78:
        r37 = null;
    L44:
        r20 = null;
        goto L46
    L23:
        r11 = null;
    L19:
        r10 = 0;
    L9:
        r3 = null;
        goto L10
    }

    public static /* synthetic */ void setLayoutTypeIfNeed$default(ECShopHybridProductViewModel r0, Integer r1, Integer r2, boolean r3, Map r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.setLayoutTypeIfNeed(r1, r2, r3, r4);
    }
}
