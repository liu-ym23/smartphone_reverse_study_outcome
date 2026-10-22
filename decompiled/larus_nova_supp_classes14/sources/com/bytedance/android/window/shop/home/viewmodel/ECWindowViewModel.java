package com.bytedance.android.window.shop.home.viewmodel;

import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.common.const.WindowLiveStyles;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.common.param.ECWindowShareParam;
import com.bytedance.android.ec.window.base.common.taskgraph.PipelinePool;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.setting.WindowSettingKeys;
import com.bytedance.android.ec.window.base.shop.PrefetchScene;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.android.ec.window.base.shop.WindowPrefetchJobKey;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.utils.window.ECWindowShopLiveData;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.ecom.bcm.track.api.const.AppendScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.window.shop.CategoryTabStruct;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.home.ECWindowJobKeys;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.WindowEventContext;
import com.bytedance.android.window.shop.home.WindowMonitor;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.lifecycle.WindowBusinessMonitor;
import com.bytedance.android.window.shop.prefetch.HeaderPrefetchJobKey;
import com.bytedance.android.window.shop.prefetch.WindowComponentPrefetchJobKey;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.WindowPreSceneType;
import com.bytedance.android.window.shop.repository.api.ShopHeaderRequestParam;
import com.bytedance.android.window.shop.repository.api.WindowComponentRequestParam;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParamDeprecated;
import com.bytedance.android.window.shop.repository.api.WindowSceneType;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.dto.a1;
import com.bytedance.android.window.shop.repository.dto.d0;
import com.bytedance.android.window.shop.repository.dto.e0;
import com.bytedance.android.window.shop.repository.dto.g0;
import com.bytedance.android.window.shop.repository.dto.k0;
import com.bytedance.android.window.shop.repository.dto.r0;
import com.bytedance.android.window.shop.repository.dto.x;
import com.bytedance.android.window.shop.repository.dto.y;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import uq3.m;
import uq3.n;
import uq3.o;
import uq3.p;
import yn.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0085\u00022\u00020\u0001:\u0004\u0086\u0002\u0087\u0002B\t¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020#J$\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u0006\u0010+\u001a\u00020\u0002J\u0010\u0010-\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020#J\u0006\u0010.\u001a\u00020\u0002J\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020#J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020\u0002J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020706J\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020709J\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004062\u0006\u0010;\u001a\u00020\tJ\u0014\u0010?\u001a\u00020\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020=J\u0014\u0010B\u001a\u00020\u00022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u000bJ\b\u0010C\u001a\u00020\u0002H\u0014J\f\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010DR$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0017\u0010N\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020#0W8\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0_8\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00040_8\u0006¢\u0006\f\n\u0004\bd\u0010a\u001a\u0004\be\u0010cR\u0017\u0010g\u001a\u00020f8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010lR\u0017\u0010o\u001a\u00020n8\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020z0y8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u001e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00160y8\u0006¢\u0006\r\n\u0004\b\u007f\u0010|\u001a\u0005\b\u0080\u0001\u0010~R+\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010y8\u0006¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010|\u001a\u0005\b\u0089\u0001\u0010~R#\u0010\u008b\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008a\u00010y8\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010|\u001a\u0005\b\u008c\u0001\u0010~R#\u0010\u008e\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010y8\u0006¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010|\u001a\u0005\b\u008f\u0001\u0010~R \u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020#0y8\u0006¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010|\u001a\u0005\b\u0091\u0001\u0010~R0\u0010\u0094\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0\u0093\u00010\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u0098\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001d\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0006¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R \u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020#0y8\u0006¢\u0006\u000e\n\u0005\b£\u0001\u0010|\u001a\u0005\b£\u0001\u0010~R\"\u0010¤\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0y8\u0006¢\u0006\u000e\n\u0005\b¤\u0001\u0010|\u001a\u0005\b¤\u0001\u0010~R \u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0006¢\u0006\u000e\n\u0005\b¥\u0001\u0010|\u001a\u0005\b¦\u0001\u0010~R-\u0010§\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0093\u00010y8\u0006¢\u0006\u000e\n\u0005\b§\u0001\u0010|\u001a\u0005\b¨\u0001\u0010~R$\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010\u0092\u00018\u0006¢\u0006\u0010\n\u0006\bª\u0001\u0010\u0095\u0001\u001a\u0006\b«\u0001\u0010\u0097\u0001R$\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b¬\u0001\u0010\u0095\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0097\u0001R#\u0010®\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010\u0095\u0001\u001a\u0006\b¯\u0001\u0010\u0097\u0001R-\u0010°\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0093\u00010y8\u0006¢\u0006\u000e\n\u0005\b°\u0001\u0010|\u001a\u0005\b±\u0001\u0010~R\u001d\u0010³\u0001\u001a\u00030²\u00018\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R \u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0006¢\u0006\u000e\n\u0005\b·\u0001\u0010|\u001a\u0005\b¸\u0001\u0010~R \u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0006¢\u0006\u000e\n\u0005\b¹\u0001\u0010|\u001a\u0005\bº\u0001\u0010~R+\u0010»\u0001\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R*\u0010Ã\u0001\u001a\u0012\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u00010Â\u00010Á\u00010y8\u0006¢\u0006\u000e\n\u0005\bÃ\u0001\u0010|\u001a\u0005\bÄ\u0001\u0010~R#\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u0002070\u0092\u00018\u0006¢\u0006\u0010\n\u0006\bÅ\u0001\u0010\u0095\u0001\u001a\u0006\bÆ\u0001\u0010\u0097\u0001R \u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020#0y8\u0006¢\u0006\u000e\n\u0005\bÇ\u0001\u0010|\u001a\u0005\bÈ\u0001\u0010~R \u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0006¢\u0006\u000e\n\u0005\bÉ\u0001\u0010|\u001a\u0005\bÊ\u0001\u0010~R\u001d\u0010Ì\u0001\u001a\u00030Ë\u00018\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001R)\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0005\u0010\u0082\u0001\u001a\u0006\bÐ\u0001\u0010\u0084\u0001\"\u0006\bÑ\u0001\u0010\u0086\u0001R+\u0010Ò\u0001\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R!\u0010Ý\u0001\u001a\u00030Ø\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u001d\u0010ß\u0001\u001a\u00030Þ\u00018\u0006¢\u0006\u0010\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001R\u001d\u0010ä\u0001\u001a\u00030ã\u00018\u0006¢\u0006\u0010\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R~\u0010î\u0001\u001aW\u0012\u0018\u0012\u0016\u0018\u00010\u0004¢\u0006\u000f\bé\u0001\u0012\n\bê\u0001\u0012\u0005\b\b(ë\u0001\u0012\u0016\u0012\u00140#¢\u0006\u000f\bé\u0001\u0012\n\bê\u0001\u0012\u0005\b\b(ì\u0001\u0012\u0018\u0012\u0016\u0018\u00010\u0004¢\u0006\u000f\bé\u0001\u0012\n\bê\u0001\u0012\u0005\b\b(í\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010è\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001\"\u0006\bò\u0001\u0010ó\u0001RK\u0010÷\u0001\u001a$\u0012\u0017\u0012\u00150õ\u0001¢\u0006\u000f\bé\u0001\u0012\n\bê\u0001\u0012\u0005\b\b(ö\u0001\u0012\u0004\u0012\u00020#\u0018\u00010ô\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001R$\u0010ÿ\u0001\u001a\n\u0012\u0005\u0012\u00030þ\u00010ý\u00018\u0006¢\u0006\u0010\n\u0006\bÿ\u0001\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002¨\u0006\u0088\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "resolveLayoutType", "", "entranceInfo", "initEventParams", "initDynamicParam", "loadComponentInfo", "", "getTabType", "", "Lio/d;", "layoutList", "handleLayoutInSql", "Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "tabDTO", "handleShopTabDataListResponse", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO;", "actionName", "doShopWindowEventReport", "getLoadingTabId", "Luq3/a;", "responseVO", "", "startTime", "initShopParam", "Lorg/json/JSONObject;", "getLogExtraJsonObject", "Lcom/bytedance/android/window/shop/repository/compat/WindowTabInfoProvider;", "doTabMonitor", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "type", "setServerLayoutType", "updateUserLayoutType", "", "isVideoTrailerOrSplitOpt", "Lcom/bytedance/android/window/shop/home/ECWindowParam;", "shopParam", "Landroid/net/Uri;", "uri", "entranceInfoParam", "init", "loadHeaderInfo", "forceUseOld", "loadTabInfo", "doDragToFullEventReport", "doEnterShopWindowEventReport", "getPassThroughLogData", "couldLive", "isCroppedStyle", "isCroppedStyleOpt", "isSplitStyle", "mayEmitHeaderResponse", "", "", "getMetaInfoWithoutKolId", "", "getMetaInfo", "selectedTabType", "getWindowMonitorCategories", "Lkotlin/Function0;", "runnable", "runLowPriorityTask", "Lio/reactivex/disposables/Disposable;", "list", "addAllDisposable", "onCleared", "Lcom/bytedance/android/ec/window/base/common/taskgraph/b;", "getPipeline", "Lto/d;", "renderDataVo", "Lto/d;", "getRenderDataVo", "()Lto/d;", "setRenderDataVo", "(Lto/d;)V", "Lcom/bytedance/android/window/shop/home/k;", "pendingTaskViewModel", "Lcom/bytedance/android/window/shop/home/k;", "getPendingTaskViewModel", "()Lcom/bytedance/android/window/shop/home/k;", "Lep3/a;", "paramProvider", "Lep3/a;", "getParamProvider", "()Lep3/a;", "Lzn/a;", "showPopupWindowLiveData", "Lzn/a;", "getShowPopupWindowLiveData", "()Lzn/a;", "Lcom/bytedance/android/window/shop/home/tab/a;", "taskMgr", "Lcom/bytedance/android/window/shop/home/tab/a;", "Lcom/bytedance/android/ec/window/base/utils/window/ECWindowShopLiveData;", "croppedState", "Lcom/bytedance/android/ec/window/base/utils/window/ECWindowShopLiveData;", "getCroppedState", "()Lcom/bytedance/android/ec/window/base/utils/window/ECWindowShopLiveData;", "floatLayerShowDenied", "getFloatLayerShowDenied", "Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel$b;", "headerSubTabsParam", "Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel$b;", "getHeaderSubTabsParam", "()Lcom/bytedance/android/window/shop/home/viewmodel/ECWindowViewModel$b;", "storedLayoutType", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "serverLayoutType", "Lcom/bytedance/android/window/shop/home/c;", "secondaryPageParams", "Lcom/bytedance/android/window/shop/home/c;", "getSecondaryPageParams", "()Lcom/bytedance/android/window/shop/home/c;", "fakeShopParam", "Lcom/bytedance/android/window/shop/home/ECWindowParam;", "getShopParam", "()Lcom/bytedance/android/window/shop/home/ECWindowParam;", "setShopParam", "(Lcom/bytedance/android/window/shop/home/ECWindowParam;)V", "Lzn/b;", "Lcom/bytedance/android/ec/window/base/shopping/paging/WindowLoadStatus;", "loadStatus", "Lzn/b;", "getLoadStatus", "()Lzn/b;", "headerResponse", "getHeaderResponse", "headerCards", "Ljava/lang/String;", "getHeaderCards", "()Ljava/lang/String;", "setHeaderCards", "(Ljava/lang/String;)V", "Lcom/bytedance/android/window/shop/repository/vo/ShopComponentResponseVO;", "componentResponse", "getComponentResponse", "Lcom/bytedance/android/ec/window/base/common/headlive/WindowV3LiveRoomVO;", "liveInfo", "getLiveInfo", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "cartEntryConfig", "getCartEntryConfig", "openLiveByHeadClick", "getOpenLiveByHeadClick", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "layoutStatus", "Landroidx/lifecycle/MutableLiveData;", "getLayoutStatus", "()Landroidx/lifecycle/MutableLiveData;", "tabDuration", "J", "getTabDuration", "()J", "setTabDuration", "(J)V", "Lap/c;", "tagPools", "Lap/c;", "getTagPools", "()Lap/c;", "isFollowed", "isLiveOn", "topBarHeight", "getTopBarHeight", "offsetState", "getOffsetState", "", "collapseProgress", "getCollapseProgress", "subCollapseProgress", "getSubCollapseProgress", "pullOffset", "getPullOffset", "selectedTabLocation", "getSelectedTabLocation", "Lcom/bytedance/android/window/shop/home/f;", "topBarInfoParam", "Lcom/bytedance/android/window/shop/home/f;", "getTopBarInfoParam", "()Lcom/bytedance/android/window/shop/home/f;", "extraSchemaClosed", "getExtraSchemaClosed", "scrollState", "getScrollState", "schema", "Landroid/net/Uri;", "getSchema", "()Landroid/net/Uri;", "setSchema", "(Landroid/net/Uri;)V", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "destView", "getDestView", "goTopEventReceiver", "getGoTopEventReceiver", "scrollPositionFarEnough", "getScrollPositionFarEnough", "tabBarHeight", "getTabBarHeight", "Lfo/b;", "overallData", "Lfo/b;", "getOverallData", "()Lfo/b;", "getEntranceInfo", "setEntranceInfo", "entranceInfoJsonObject", "Lorg/json/JSONObject;", "getEntranceInfoJsonObject", "()Lorg/json/JSONObject;", "setEntranceInfoJsonObject", "(Lorg/json/JSONObject;)V", "Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext$delegate", "Lkotlin/Lazy;", "getImageCallerContext", "()Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext", "Lyn/d;", "liveManager", "Lyn/d;", "getLiveManager", "()Lyn/d;", "Lcom/bytedance/android/window/shop/home/WindowEventContext;", "windowEventContext", "Lcom/bytedance/android/window/shop/home/WindowEventContext;", "getWindowEventContext", "()Lcom/bytedance/android/window/shop/home/WindowEventContext;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "enterMethod", "openLiveList", "btm", "jump2Live", "Lkotlin/jvm/functions/Function3;", "getJump2Live", "()Lkotlin/jvm/functions/Function3;", "setJump2Live", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function1;", "Lhp3/b;", "params", "eventDeliverer", "Lkotlin/jvm/functions/Function1;", "getEventDeliverer", "()Lkotlin/jvm/functions/Function1;", "setEventDeliverer", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/window/base/utils/window/c;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "playerPool", "Lcom/bytedance/android/ec/window/base/utils/window/c;", "getPlayerPool", "()Lcom/bytedance/android/ec/window/base/utils/window/c;", "<init>", "()V", "Companion", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowViewModel extends BaseViewModel {
    public static final int CROPPED_STATE_FINAL = 2;
    public static final int CROPPED_STATE_INITIAL = 1;
    public static final a Companion = null;
    private final zn.b<WindowCartEntryConfig> cartEntryConfig;
    private final MutableLiveData<Float> collapseProgress;
    private final zn.b<ShopComponentResponseVO> componentResponse;
    private final ECWindowShopLiveData<Integer> croppedState;
    private final zn.b<WeakReference<View>> destView;
    private String entranceInfo;
    private JSONObject entranceInfoJsonObject;
    private Function1<? super hp3.b, Boolean> eventDeliverer;
    private final zn.b<Integer> extraSchemaClosed;
    private final ECWindowParam fakeShopParam;
    private final ECWindowShopLiveData<String> floatLayerShowDenied;
    private final MutableLiveData<Object> goTopEventReceiver;
    private String headerCards;
    private final zn.b<uq3.a> headerResponse;
    private final b headerSubTabsParam;
    private final Lazy imageCallerContext$delegate;
    private final zn.b<Boolean> isFollowed;
    private final zn.b<Boolean> isLiveOn;
    private Function3<? super String, ? super Boolean, ? super String, Unit> jump2Live;
    private final MutableLiveData<Pair<String, WindowLayoutType>> layoutStatus;
    private final zn.b<WindowV3LiveRoomVO> liveInfo;
    private final yn.d liveManager;
    private final zn.b<WindowLoadStatus> loadStatus;
    private final zn.b<Pair<Integer, Integer>> offsetState;
    private final zn.b<Boolean> openLiveByHeadClick;
    private final fo.b overallData;
    private final ep3.a paramProvider;
    private final com.bytedance.android.window.shop.home.k pendingTaskViewModel;
    private final com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> playerPool;
    private final MutableLiveData<Integer> pullOffset;
    private to.d renderDataVo;
    private Uri schema;
    private final zn.b<Boolean> scrollPositionFarEnough;
    private final zn.b<Integer> scrollState;
    private final com.bytedance.android.window.shop.home.c secondaryPageParams;
    private final zn.b<Pair<Integer, Integer>> selectedTabLocation;
    private WindowLayoutType serverLayoutType;
    private ECWindowParam shopParam;
    private final zn.a<Boolean> showPopupWindowLiveData;
    private WindowLayoutType storedLayoutType;
    private final MutableLiveData<Float> subCollapseProgress;
    private final zn.b<Integer> tabBarHeight;
    private long tabDuration;
    private final ap.c tagPools;
    private final com.bytedance.android.window.shop.home.tab.a taskMgr;
    private final zn.b<Integer> topBarHeight;
    private final com.bytedance.android.window.shop.home.f topBarInfoParam;
    private final WindowEventContext windowEventContext;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final ReentrantReadWriteLock a;
        public WindowLayoutType b;
        public final zn.b<WindowTabDataListResponseDTODeprecated> c;
        public final zn.b<WindowHybridTabDataListResponseDTO> d;
        public final zn.b<Unit> e;

        public b() {
            this.a = new ReentrantReadWriteLock();
            this.c = new zn.b();
            this.d = new zn.b();
            this.e = new zn.b();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public c(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            WindowComponentResponseDTO r4 = (WindowComponentResponseDTO) r3;
            if (r4.getStatusCode() != 0) goto L20;
            ShopComponentResponseVO r0 = new ShopComponentResponseVO();
            uq3.h.a(r0, r4);
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r5 = this.a.getPipeline();
            if (r5 == null) goto L9;
            r5.b(WindowLaunchTask.f, r0);
        L9:
            if (this.a.getHeaderResponse().getValue() == null) goto L17;
            this.a.getComponentResponse().c(r0);
            return;
        L17:
            this.a.getHeaderSubTabsParam().a.readLock().lock();     // Catch: Throwable -> L14
            this.a.getComponentResponse().c(r0);     // Catch: Throwable -> L14
            this.a.getHeaderSubTabsParam().a.readLock().unlock();
            return;
        L14:
            th = move-exception;
            this.a.getHeaderSubTabsParam().a.readLock().unlock();
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;
        public final /* synthetic */ long b;

        public e(ECWindowViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r19) {
            WindowHeaderResponseDTO r1 = (WindowHeaderResponseDTO) r19;
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r2 = com.bytedance.android.window.shop.lifecycle.c.a;
            com.bytedance.android.window.shop.lifecycle.f r3 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.getShopParam().getLifecycleMonitorId());
            if (r3 == null) goto L5;
            r3.p(this.a.getShopParam(), r1);
        L5:
            dm.a.a("WINDOW").i("[loadHeaderInfo]secAuthorId:" + this.a.getShopParam().getSecAuthorId());
            dm.a.a("WINDOW").i("[loadHeaderInfo]statusCode:" + r1.getStatusCode());
            boolean r4 = true;
            if (r1.getStatusCode() == 0) goto L8;
            new bp3.a(this.a.getShopParam(), r1, this.a.getSchema()).post(null, null);
            int r5 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, r1, 1);
            this.a.getLoadStatus().setValue(WindowLoadStatus.InitializeError);
            int r6 = com.bytedance.android.ec.window.base.utils.i.a;
            com.bytedance.android.ec.window.base.utils.i.d(this.a.getEntranceInfoJsonObject(), "load_fail", null, 12);
            return;
        L8:
            uq3.a r7 = new uq3.a();
            Intrinsics.checkNotNullParameter(r7, "$this$transform");
            Intrinsics.checkNotNullParameter(r1, "responseDTO");
            int r8 = n.c;
            e0 r9 = r1.getWindowHeaderBffDataData();
            if (r9 == null) goto L12;
            List<a1> r10 = r9.c();
            if (r10 == null) goto L12;
        L14:
            if (r9 == null) goto L18;
            ECHybridListDTO r11 = r9.b();
            if (r11 == null) goto L18;
            ECHybridListDTO.Companion.getClass();
            com.bytedance.android.ec.hybrid.list.entity.k r12 = ECHybridListDTO.a.d(r11, false, null);
        L19:
            n r13 = new n(r10, r12);
            r7.a = r13.a;
            r7.b = r13.b;
            o.x.getClass();
            Intrinsics.checkNotNullParameter(r1, "dto");
            e0 r14 = r1.getWindowHeaderBffDataData();
            if (r14 == null) goto L22;
            k0 r15 = r14.a();
        L23:
            if (r15 == null) goto L44;
            k0 r16 = r1.getWindowHeaderBffDataData().a();
            o r17 = new o();
            r16.getClass();
            r17.a = r16.o();
            WindowAuthorReputationVO.a r18 = WindowAuthorReputationVO.Companion;
            AuthorReputationDTO r20 = r16.m();
            r18.getClass();
            r17.e = WindowAuthorReputationVO.a.a(r20);
            r17.b = r16.c();
            r17.c = r16.l();
            r17.d = r16.n();
            u r21 = r16.i();
            if (r21 == null) goto L27;
            WindowV3LiveRoomVO.Companion.getClass();
            WindowV3LiveRoomVO r22 = WindowV3LiveRoomVO.a.a(r21);
        L28:
            r17.f = r22;
            r17.g = r16.b();
            r17.h = Integer.valueOf(uq3.g.c(r16.d()));
            r17.i = r16.q();
            r17.j = r16.g();
            r17.k = r16.j();
            r17.m = r16.a();
            r17.n = r16.f();
            r17.o = r16.r();
            r17.p = r16.p();
            r17.q = r16.e();
            int r23 = m.d;
            y r24 = r16.h();
            Intrinsics.checkNotNullParameter("window_private_message", "name");
            if (r24 == null) goto L37;
            ECUrlModel r25 = r24.a();
            if (r25 == null) goto L37;
            String r26 = r24.b();
            if (r26 == null) goto L37;
            m r110 = new m(r25, r26);
        L38:
            r17.v = r110;
            Map<String, List<String>> r27 = r16.s();
            if (r27 != null) goto L41;
            r27 = MapsKt.emptyMap();
        L41:
            Intrinsics.checkNotNullParameter(r27, "<set-?>");
            r17.w = r27;
            String r28 = r16.k();
            if (r28 == null) goto L135;
            String r29 = StringsKt.trim(r28).toString();
            Intrinsics.checkNotNullParameter(r29, "<set-?>");
            r17.l = r29;
        L135:
            r7.c = r17;
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r30 = this.a.getPipeline();
            if (r30 == null) goto L138;
            r30.b(WindowLaunchTask.e, r7);
        L138:
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r31 = this.a.getPipeline();
            if (r31 == null) goto L141;
            r31.c(WindowLaunchTask.h);
        L141:
            Integer r32 = this.a.getShopParam().getLiveStyle();
            int r33 = WindowLiveStyles.NOLIVE.getType();
            if (r32 != null) goto L145;
        L149:
            ECWindowViewModel r34 = this.a;
            List<a1> r35 = r7.a;
            if (r35 == null) goto L179;
            ArrayList r36 = new ArrayList();
            Iterator<T> r37 = r35.iterator();
        L153:
            if (r37.hasNext() == false) goto L158;
            List<com.bytedance.android.window.shop.repository.dto.c> r38 = ((a1) r37.next()).a();
            if (r38 == null) goto L153;
            r36.add(r38);
            goto L153
        L158:
            if ((!r36.isEmpty()) == true) goto L161;
            r36 = null;
        L161:
            if (r36 == null) goto L179;
            Iterator<T> r39 = r36.iterator();
            if (r39.hasNext() == false) goto L178;
            T r40 = r39.next();
        L166:
            if (r39.hasNext() == false) goto L168;
            r40 = (T) CollectionsKt.plus(r40, (List) r39.next());
            goto L166
        L168:
            List r41 = r40;
            if (r41 == null) goto L179;
            ArrayList r42 = new ArrayList();
            Iterator<T> r43 = r41.iterator();
        L172:
            if (r43.hasNext() == false) goto L176;
            Integer r44 = ((com.bytedance.android.window.shop.repository.dto.c) r43.next()).c();
            if (r44 == null) goto L172;
            r42.add(r44);
            goto L172
        L176:
            String r45 = CollectionsKt.joinToString$default(r42, ",", null, null, 0, null, null, 62, null);
        L180:
            r34.setHeaderCards(r45);
            zn.b<Boolean> r46 = this.a.isLiveOn();
            o r47 = r7.c;
            if (r47 == null) goto L183;
            WindowV3LiveRoomVO r48 = r47.f;
        L184:
            if (r48 == null) goto L186;
            boolean r49 = true;
        L187:
            r46.c(Boolean.valueOf(r49));
            int r50 = com.bytedance.android.window.shop.lifecycle.b.a;
            Intrinsics.checkNotNullParameter(r7, "response");
            if (r7.c != null) goto L190;
            com.bytedance.android.ec.core.monitor.d.a("/window/header/", "null", "shopHeaderBaseInfo");
        L190:
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r51 = com.bytedance.android.window.shop.lifecycle.c.a;
            com.bytedance.android.window.shop.lifecycle.f r52 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.getShopParam().getLifecycleMonitorId());
            if (r52 == null) goto L193;
            r52.n(r7);
        L193:
            WindowMonitor r53 = this.a.getShopParam().getMonitor();
            if (r53 == null) goto L196;
            r53.stopHeaderDurationMonitor();
        L196:
            this.a.getLoadStatus().setValue(WindowLoadStatus.InitializeSuccess);
            ECWindowViewModel.access$initShopParam(this.a, r7, this.b);
            ECWindowViewModel.access$initDynamicParam(this.a);
            this.a.getHeaderResponse().setValue(r7);
            zn.b<WindowV3LiveRoomVO> r54 = this.a.getLiveInfo();
            o r55 = r7.c;
            if (r55 == null) goto L199;
            WindowV3LiveRoomVO r56 = r55.f;
        L200:
            r54.setValue(r56);
            zn.b<WindowCartEntryConfig> r57 = this.a.getCartEntryConfig();
            o r58 = r7.c;
            if (r58 == null) goto L203;
            WindowCartEntryConfig r59 = r58.b;
        L204:
            r57.setValue(r59);
            zn.b<Boolean> r60 = this.a.isFollowed();
            o r61 = r7.c;
            if (r61 == null) goto L207;
            Integer r62 = r61.j;
        L208:
            if (r62 != null) goto L211;
        L213:
            r4 = false;
        L214:
            r60.setValue(Boolean.valueOf(r4));
            this.a.getHeaderSubTabsParam().a.writeLock().unlock();
            int r63 = com.bytedance.android.ec.window.base.utils.i.a;
            com.bytedance.android.ec.window.base.utils.i.d(this.a.getEntranceInfoJsonObject(), "load_finish", null, 12);
            return;
        L211:
            if (r62.intValue() != 1) goto L213;
        L207:
            r62 = null;
            goto L208
        L203:
            r59 = null;
            goto L204
        L199:
            r56 = null;
            goto L200
        L186:
            r49 = false;
            goto L187
        L183:
            r48 = null;
            goto L184
        L178:
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        L179:
            r45 = null;
            goto L180
        L145:
            if (r32.intValue() != r33) goto L149;
            o r64 = r7.c;
            if (r64 == null) goto L149;
            r64.f = null;
        L37:
            r110 = null;
            goto L38
        L27:
            r22 = null;
            goto L28
        L44:
            o r65 = new o();
            WindowAuthorReputationVO.a r66 = WindowAuthorReputationVO.Companion;
            d0 r111 = r1.getShopHeaderBaseInfo();
            if (r111 == null) goto L47;
            AuthorReputationDTO r112 = r111.k();
        L48:
            r66.getClass();
            r65.e = WindowAuthorReputationVO.a.a(r112);
            d0 r67 = r1.getShopHeaderBaseInfo();
            if (r67 == null) goto L51;
            String r68 = r67.l();
        L52:
            r65.a = r68;
            d0 r69 = r1.getShopHeaderBaseInfo();
            if (r69 == null) goto L55;
            WindowCartEntryConfig r70 = r69.d();
        L56:
            r65.b = r70;
            d0 r71 = r1.getShopHeaderBaseInfo();
            if (r71 == null) goto L59;
            String r72 = r71.j();
        L60:
            r65.c = r72;
            g0 r73 = r1.getShopHeaderControl();
            if (r73 == null) goto L63;
            Boolean r74 = r73.e();
        L64:
            r65.d = r74;
            d0 r75 = r1.getShopHeaderBaseInfo();
            if (r75 == null) goto L69;
            u r76 = r75.h();
            if (r76 == null) goto L69;
            WindowV3LiveRoomVO.Companion.getClass();
            WindowV3LiveRoomVO r77 = WindowV3LiveRoomVO.a.a(r76);
        L70:
            r65.f = r77;
            d0 r78 = r1.getShopHeaderBaseInfo();
            if (r78 == null) goto L73;
            ECUrlModel r79 = r78.b();
        L74:
            r65.g = r79;
            d0 r80 = r1.getShopHeaderBaseInfo();
            if (r80 == null) goto L77;
            String r81 = r80.e();
        L78:
            r65.h = Integer.valueOf(uq3.g.c(r81));
            d0 r82 = r1.getShopHeaderBaseInfo();
            if (r82 == null) goto L81;
            String r83 = r82.m();
        L82:
            r65.i = r83;
            g0 r84 = r1.getShopHeaderControl();
            if (r84 == null) goto L85;
            Integer r85 = r84.b();
        L86:
            r65.j = r85;
            d0 r86 = r1.getShopHeaderBaseInfo();
            if (r86 == null) goto L89;
            String r87 = r86.i();
        L90:
            r65.k = r87;
            d0 r88 = r1.getShopHeaderBaseInfo();
            if (r88 == null) goto L93;
            ECUrlModel r89 = r88.a();
        L94:
            r65.m = r89;
            g0 r90 = r1.getShopHeaderControl();
            if (r90 == null) goto L97;
            WindowFansClubInfo r91 = r90.a();
        L98:
            r65.n = r91;
            d0 r92 = r1.getShopHeaderBaseInfo();
            if (r92 == null) goto L101;
            String r93 = r92.n();
        L102:
            r65.o = r93;
            g0 r94 = r1.getShopHeaderControl();
            if (r94 == null) goto L105;
            Boolean r95 = r94.d();
        L106:
            r65.p = r95;
            r1.getShopHeaderControl();
            d0 r96 = r1.getShopHeaderBaseInfo();
            if (r96 == null) goto L114;
            List<r0> r97 = r96.g();
            if (r97 == null) goto L114;
            List<r0> r98 = r97;
            ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r98, 10));
            Iterator<T> r99 = r98.iterator();
        L112:
            if (r99.hasNext() == false) goto L115;
            r0 r114 = (r0) r99.next();
            int r115 = p.c;
            Intrinsics.checkNotNullParameter(r114, "dto");
            p r116 = new p();
            r116.a = r114.b();
            r116.b = r114.a();
            r113.add(r116);
        L115:
            r65.r = r113;
            d0 r100 = r1.getShopHeaderBaseInfo();
            if (r100 == null) goto L123;
            List<com.bytedance.android.window.shop.repository.dto.n> r101 = r100.c();
            if (r101 == null) goto L123;
            List<com.bytedance.android.window.shop.repository.dto.n> r102 = r101;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L121:
            if (r104.hasNext() == false) goto L124;
            com.bytedance.android.window.shop.repository.dto.n r117 = (com.bytedance.android.window.shop.repository.dto.n) r104.next();
            int r118 = uq3.e.h;
            r103.add(uq3.e.a.a(r117));
        L124:
            r65.t = r103;
            r1.getShopHeaderBaseInfo();
            d0 r105 = r1.getShopHeaderBaseInfo();
            if (r105 == null) goto L129;
            x r106 = r105.f();
            if (r106 == null) goto L129;
            int r107 = uq3.k.b;
            uq3.k r108 = uq3.k.a.a(r106);
        L130:
            r65.s = r108;
            r1.getShopHeaderControl();
            g0 r109 = r1.getShopHeaderControl();
            if (r109 == null) goto L133;
            Boolean r119 = r109.c();
        L134:
            r65.u = Intrinsics.areEqual(r119, Boolean.TRUE);
            r17 = r65;
            goto L135
        L133:
            r119 = null;
        L129:
            r108 = null;
        L123:
            r103 = null;
        L114:
            r113 = null;
            goto L115
        L105:
            r95 = null;
            goto L106
        L101:
            r93 = null;
            goto L102
        L97:
            r91 = null;
            goto L98
        L93:
            r89 = null;
            goto L94
        L89:
            r87 = null;
            goto L90
        L85:
            r85 = null;
            goto L86
        L81:
            r83 = null;
            goto L82
        L77:
            r81 = null;
            goto L78
        L73:
            r79 = null;
        L69:
            r77 = null;
            goto L70
        L63:
            r74 = null;
            goto L64
        L59:
            r72 = null;
            goto L60
        L55:
            r70 = null;
            goto L56
        L51:
            r68 = null;
            goto L52
        L47:
            r112 = null;
            goto L48
        L22:
            r15 = null;
        L18:
            r12 = null;
        L12:
            r10 = CollectionsKt.emptyList();
            goto L14
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public f(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            int r0 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, null, 1);
            ECExceptionMonitor.e(r7);
            this.a.getLoadStatus().setValue(WindowLoadStatus.InitializeError);
            int r1 = com.bytedance.android.ec.window.base.utils.i.a;
            com.bytedance.android.ec.window.base.utils.i.d(this.a.getEntranceInfoJsonObject(), "load_fail", null, 12);
            this.a.getHeaderSubTabsParam().a.writeLock().unlock();
            dm.a.a("WINDOW").b("[loadHeaderInfo]error secAuthorId:" + this.a.getShopParam().getSecAuthorId(), null);
            dm.a.a("WINDOW").b("[loadHeaderInfo]error message:" + r7.getMessage(), null);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public g(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ECWindowViewModel r0 = this.a;
            ECWindowViewModel.access$handleLayoutInSql(r0, (List) r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public h(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            WindowHybridTabDataListResponseDTO r7 = (WindowHybridTabDataListResponseDTO) r6;
            if (r7.getStatusCode() == 0) goto L5;
            int r0 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, r7, 2);
            return;
        L5:
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r1 = com.bytedance.android.window.shop.lifecycle.c.a;
            com.bytedance.android.window.shop.lifecycle.f r2 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.getShopParam().getLifecycleMonitorId());
            if (r2 == null) goto L12;
            ECWindowParam r3 = this.a.getShopParam();
            Pair[] r4 = new Pair[1];
            WindowLayoutType r5 = this.a.getHeaderSubTabsParam().b;
            if (r5 == null) goto L10;
            String r8 = String.valueOf(r5.getType());
        L11:
            r4[0] = TuplesKt.to("layout", r8);
            r2.i(r3, r7, MapsKt.mutableMapOf(r4));
            goto L12
        L10:
            r8 = null;
        L12:
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r9 = this.a.getPipeline();
            if (r9 == null) goto L15;
            r9.b(WindowLaunchTask.d, r7);
        L15:
            ECWindowViewModel.access$handleShopTabDataListResponse(this.a, r7);
            ECWindowViewModel.access$loadComponentInfo(this.a);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public i(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            int r0 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, null, 2);
            dm.a.a("WINDOW").b("[loadTabInfo]error secAuthorId:" + this.a.getShopParam().getSecAuthorId(), null);
            dm.a.a("WINDOW").b("[loadTabInfo]error message:" + ((Throwable) r6).getMessage(), null);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public j(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            WindowTabDataListResponseDTODeprecated r7 = (WindowTabDataListResponseDTODeprecated) r6;
            if (r7.getStatusCode() == 0) goto L5;
            int r0 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, r7, 2);
            return;
        L5:
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r1 = com.bytedance.android.window.shop.lifecycle.c.a;
            com.bytedance.android.window.shop.lifecycle.f r2 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.getShopParam().getLifecycleMonitorId());
            if (r2 == null) goto L12;
            ECWindowParam r3 = this.a.getShopParam();
            Pair[] r4 = new Pair[1];
            WindowLayoutType r5 = this.a.getHeaderSubTabsParam().b;
            if (r5 == null) goto L10;
            String r8 = String.valueOf(r5.getType());
        L11:
            r4[0] = TuplesKt.to("layout", r8);
            r2.i(r3, r7, MapsKt.mutableMapOf(r4));
            goto L12
        L10:
            r8 = null;
        L12:
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r9 = this.a.getPipeline();
            if (r9 == null) goto L15;
            r9.b(WindowLaunchTask.d, r7);
        L15:
            ECWindowViewModel.access$handleShopTabDataListResponse(this.a, r7);
            ECWindowViewModel.access$loadComponentInfo(this.a);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public k(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            int r0 = WindowBusinessMonitor.a;
            WindowBusinessMonitor.c(this.a, null, 2);
            dm.a.a("WINDOW").b("[loadTabInfo]error secAuthorId:" + this.a.getShopParam().getSecAuthorId(), null);
            dm.a.a("WINDOW").b("[loadTabInfo]error message:" + ((Throwable) r6).getMessage(), null);
        }
    }

    public static final class l extends com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> {
        public l() {
            super(3);
        }
    }

    static {
        Companion = new a();
    }

    public ECWindowViewModel() {
        super(null, null, 3, null);
        this.pendingTaskViewModel = new com.bytedance.android.window.shop.home.k();
        this.paramProvider = new ep3.a();
        this.showPopupWindowLiveData = new zn.a(false, 7);
        this.taskMgr = new com.bytedance.android.window.shop.home.tab.a();
        ECWindowShopLiveData<Integer> r0 = new ECWindowShopLiveData();
        r0.setValue(1);
        Unit r1 = Unit.INSTANCE;
        this.croppedState = r0;
        this.floatLayerShowDenied = new ECWindowShopLiveData();
        this.headerSubTabsParam = new b();
        this.secondaryPageParams = new com.bytedance.android.window.shop.home.c(this);
        ECWindowParam r2 = new ECWindowParam("", "");
        this.fakeShopParam = r2;
        this.shopParam = r2;
        this.loadStatus = new zn.b();
        this.headerResponse = new zn.b();
        this.componentResponse = new zn.b();
        this.liveInfo = new zn.b();
        this.cartEntryConfig = new zn.b();
        this.openLiveByHeadClick = new zn.b();
        this.layoutStatus = new MutableLiveData();
        this.tagPools = new ap.c();
        this.isFollowed = new zn.b();
        this.isLiveOn = new zn.b();
        this.topBarHeight = new zn.b();
        this.offsetState = new zn.b();
        this.collapseProgress = new MutableLiveData();
        this.subCollapseProgress = new MutableLiveData();
        this.pullOffset = new MutableLiveData();
        this.selectedTabLocation = new zn.b();
        this.topBarInfoParam = new com.bytedance.android.window.shop.home.f();
        this.extraSchemaClosed = new zn.b();
        this.scrollState = new zn.b();
        this.destView = new zn.b();
        this.goTopEventReceiver = new MutableLiveData();
        this.scrollPositionFarEnough = new zn.b();
        this.tabBarHeight = new zn.b();
        this.overallData = new fo.b();
        this.imageCallerContext$delegate = LazyKt.lazy(ECWindowViewModel$imageCallerContext$2.INSTANCE);
        this.liveManager = new yn.d(new ECWindowViewModel$liveManager$1(this));
        this.windowEventContext = new WindowEventContext(this);
        this.playerPool = new l();
    }

    private final void initDynamicParam() {
        Pair[] r0 = new Pair[1];
        Integer r1 = this.shopParam.getFollowStatus();
        if (r1 == null) goto L7;
        String r2 = String.valueOf(r1.intValue());
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter("0", CommentConstants$CmtLongPanelStrategy.DEFAULT);
    L8:
        r0[0] = TuplesKt.to("follow_status", r2);
        initEventContext(r0);
        return;
    L7:
        r2 = null;
        goto L8
    }

    private final synchronized void resolveLayoutType() {
        monitor-enter(this);
        WindowLayoutType.a r0 = WindowLayoutType.Companion;     // Catch: Throwable -> L21
        WindowLayoutType r1 = this.storedLayoutType;     // Catch: Throwable -> L21
        WindowLayoutType r2 = this.serverLayoutType;     // Catch: Throwable -> L21
        r0.getClass();     // Catch: Throwable -> L21
        if (r1 != null) goto L6;
    L8:
        if (r2 != null) goto L10;
    L12:
        if (r1 != null) goto L17;
        if (r2 == null) goto L16;
    L15:
        r1 = r2;
        goto L17
    L16:
        r1 = null;
    L17:
        if (r1 == null) goto L19;
        this.headerSubTabsParam.b = r1;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L10:
        if (r2.isNewLayout() != true) goto L12;
    L6:
        if (r1.isNewLayout() != true) goto L8;
    L21:
        th = move-exception;
        throw th;
    }

    public final r getImageCallerContext() {
        return (r) this.imageCallerContext$delegate.getValue();
    }

    public final String getPassThroughLogData() {
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[7];
        r0[0] = JsonDslUtilKt.d("store_type", "window");
        r0[1] = JsonDslUtilKt.d("product_source_page", this.shopParam.getEntranceLocation());
        String r1 = this.shopParam.getStoreSourcePage();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[2] = JsonDslUtilKt.d("store_source_page", r1);
        String r3 = this.shopParam.getStoreSourceMethod();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[3] = JsonDslUtilKt.d("store_source_method", r3);
        String r4 = this.shopParam.getStoreGroupType();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0[4] = JsonDslUtilKt.d("store_group_type", r4);
        WindowV3LiveRoomVO r5 = (WindowV3LiveRoomVO) this.liveInfo.getValue();
        if (r5 == null) goto L14;
        String r6 = r5.getAnchorId();
    L15:
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        r0[5] = JsonDslUtilKt.d("from_anchor_id", r2);
        if (yn.c.a() == false) goto L21;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L22:
        r0[6] = JsonDslUtilKt.d("pre_contains_live", r7);
        return JsonDslUtilKt.a(r0).toString();
    L21:
        r7 = "0";
        goto L22
    L14:
        r6 = null;
        goto L15
    }

    private final String getLoadingTabId() {
        WindowTabDataListResponseDTODeprecated r0 = (WindowTabDataListResponseDTODeprecated) this.headerSubTabsParam.c.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.getSelectCategoryId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "-1";
    }

    private final JSONObject getLogExtraJsonObject() {
        JSONObject r0 = new JSONObject();
        if (this.shopParam.isEcShare() == false) goto L6;
        r0.put("is_ec_shopping", 1);
        r0.put("share_content", this.shopParam.getShareContent());
        r0.put("share_object", this.shopParam.getShareObject());
    L6:
        if (Intrinsics.areEqual(this.shopParam.getShareContent(), "shop") == false) goto L8;
        r0.put("entrance_location", this.shopParam.getEntranceLocation());
    L8:
        r0.put("pre_product_id", this.shopParam.getPreProductId());
        r0.put("pre_group_id", this.shopParam.getPreGroupId());
        r0.put("pre_room_id", this.shopParam.getPreRoomId());
        return r0;
    }

    private final int getTabType() {
        Integer r0 = this.shopParam.getTargetTabType();
        if (r0 != null) goto L7;
        return 100;
    L7:
        return r0.intValue();
    }

    public final boolean couldLive() {
        if (Intrinsics.areEqual((Boolean) this.isLiveOn.getValue(), Boolean.TRUE) == false) goto L7;
        if (y0.a() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.shopParam.isCroppedStyle() == true) goto L8;
        return false;
    }

    public final void doDragToFullEventReport() {
        doShopWindowEventReport("enter_store_page_half_click");
    }

    public final void doEnterShopWindowEventReport() {
        doShopWindowEventReport("enter_store_page");
    }

    public final Map<String, Object> getMetaInfoWithoutKolId() {
        Pair[] r0 = new Pair[16];
        int r2 = 0;
        r0[0] = TuplesKt.to("sec_author_id", this.shopParam.getSecAuthorId());
        r0[1] = TuplesKt.to("entrance_location", this.shopParam.getEntranceLocation());
        r0[2] = TuplesKt.to("enter_from", this.shopParam.getEntranceLocation());
        String r1 = this.shopParam.getShareInfo().getShopName();
        String r4 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[3] = TuplesKt.to("shop_name", r1);
        if (this.shopParam.getBrandTag() == null) goto L8;
        r2 = 1;
    L8:
        r0[4] = TuplesKt.to("brand_verified", Integer.valueOf(r2));
        Integer r3 = this.shopParam.getFollowStatus();
        if (r3 == null) goto L11;
        String r5 = String.valueOf(r3.intValue());
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r0[5] = TuplesKt.to("follow_status", r5);
        String r6 = this.shopParam.getTempId();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0[6] = TuplesKt.to("temp_id", r6);
        String r7 = this.shopParam.getSearchParams();
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r0[7] = TuplesKt.to("search_params", r7);
        String r8 = this.shopParam.getStoreSourcePage();
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r0[8] = TuplesKt.to("store_source_page", r8);
        String r9 = this.shopParam.getStoreSourceMethod();
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r0[9] = TuplesKt.to("store_source_method", r9);
        String r10 = this.shopParam.getStoreGroupType();
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r0[10] = TuplesKt.to("store_group_type", r10);
        String r11 = (String) this.shopParam.getPassThroughParam("pass_through_api");
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        r0[11] = TuplesKt.to("pass_through_api", r11);
        r0[12] = TuplesKt.to("store_type", "window");
        r0[13] = TuplesKt.to("log_extra", getLogExtraJsonObject().toString());
        r0[14] = TuplesKt.to("source_page", "store_page");
        String r12 = this.entranceInfo;
        if (r12 == null) goto L36;
        r4 = r12;
    L36:
        r0[15] = TuplesKt.to("entrance_info", r4);
        return MapsKt.mutableMapOf(r0);
    L11:
        r5 = null;
        goto L12
    }

    public final com.bytedance.android.ec.window.base.common.taskgraph.b<?> getPipeline() {
        PipelinePool.PipelineId r0 = this.shopParam.getPipelineId();
        if (r0 != null) goto L6;
        return null;
    L6:
        AtomicLong r1 = PipelinePool.a;
        Intrinsics.checkNotNullParameter(r0, "id");
        return (com.bytedance.android.ec.window.base.common.taskgraph.b) PipelinePool.b.get(r0);
    }

    public final boolean isCroppedStyle() {
        return this.shopParam.isCroppedStyle();
    }

    public final boolean isCroppedStyleOpt() {
        return this.shopParam.isCroppedStyle();
    }

    public final boolean isSplitStyle() {
        return this.shopParam.isSplitStyle();
    }

    public final void loadHeaderInfo() {
        int r0 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.c(this.entranceInfoJsonObject, "detail_show", null, null);
        com.bytedance.android.ec.window.base.utils.i.d(this.entranceInfoJsonObject, "load", null, 12);
        this.loadStatus.setValue(WindowLoadStatus.Initialize);
        long r1 = SystemClock.elapsedRealtime();
        this.headerSubTabsParam.a.writeLock().lock();
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r3 = getPipeline();
        if (r3 == null) goto L5;
        r3.c(WindowLaunchTask.e);
    L5:
        ShopRepository r4 = ShopRepository.a;
        ShopHeaderRequestParam r5 = new ShopHeaderRequestParam();
        r5.setSecAuthorId(this.shopParam.getSecAuthorId());
        r5.setSourceType(this.shopParam.getSourceType());
        r5.setPassThroughApi(String.valueOf(this.shopParam.getPassThroughParams().get("pass_through_api")));
        r5.setUpgradeVersion(1);
        String r6 = this.shopParam.getPreSceneType();
        if (r6 == null) goto L11;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L11;
        int r8 = r7.intValue();
    L14:
        r5.setSceneType(Integer.valueOf(r8));
        if (yq3.a.g() != 1) goto L17;
        int r9 = zq3.d.a;
        r5.setEcExtra(zq3.d.a(this.shopParam, z1.f(this.entranceInfo)));
    L17:
        Unit r10 = Unit.INSTANCE;
        ECWindowJobKeys r11 = this.shopParam.getWindowJobKeys();
        if (r11 == null) goto L20;
        HeaderPrefetchJobKey r12 = r11.getHeadJobKey();
    L21:
        WindowMonitor r13 = this.shopParam.getMonitor();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "reqParam");
        ConcurrentHashMap r14 = com.bytedance.android.ec.window.base.shop.l.a;
        Observable r15 = com.bytedance.android.ec.window.base.shop.l.b(PrefetchScene.WINDOW, r12);
        if (r15 != null) goto L27;
        if (r13 == null) goto L26;
        r13.startHeaderDurationMonitor();
    L26:
        r15 = kq3.a.a(r5);
    L27:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r15).subscribe(new e(this, r1), new f(this)), this);
        loadTabInfo$default(this, false, 1, null);
        return;
    L20:
        r12 = null;
    L11:
        if (this.shopParam.isCroppedStyle() == false) goto L13;
        r8 = WindowSceneType.CROPPED_OPT_STYLE.getType();
        goto L14
    L13:
        r8 = com.bytedance.android.shopping.extensions.k.r(this.shopParam.getPreSceneType(), 0);
        goto L14
    }

    public final void mayEmitHeaderResponse() {
        uq3.a r0 = (uq3.a) this.headerResponse.getValue();
        if (r0 == null) goto L9;
        WindowLoadStatus r1 = (WindowLoadStatus) this.loadStatus.getValue();
        if (r1 == null) goto L7;
        this.loadStatus.c(r1);
    L7:
        this.headerResponse.c(r0);
        return;
    }

    private final void loadComponentInfo() {
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r0 = getPipeline();
        if (r0 == null) goto L5;
        r0.c(WindowLaunchTask.f);
    L5:
        ShopRepository r1 = ShopRepository.a;
        WindowComponentRequestParam r2 = new WindowComponentRequestParam();
        r2.setSecAuthorId(this.shopParam.getSecAuthorId());
        r2.setSourceType(this.shopParam.getSourceType());
        r2.setPassThroughApi(String.valueOf(this.shopParam.getPassThroughParams().get("pass_through_api")));
        r2.setExtraSchema(this.shopParam.getExtraSchema());
        Integer r3 = this.shopParam.getExtraSchemaType();
        WindowComponentPrefetchJobKey r4 = null;
        if (r3 != null) goto L9;
    L17:
        Unit r5 = Unit.INSTANCE;
        ECWindowJobKeys r6 = this.shopParam.getWindowJobKeys();
        if (r6 == null) goto L20;
        r4 = r6.getComponentJobKey();
    L20:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        ConcurrentHashMap r7 = com.bytedance.android.ec.window.base.shop.l.a;
        ReplaySubject r8 = com.bytedance.android.ec.window.base.shop.l.b(PrefetchScene.WINDOW, r4);
        if (r8 != null) goto L23;
        r8 = ShopRepository.a(r2);
    L23:
        com.bytedance.android.ec.core.async.a.a(r8.subscribeOn(Schedulers.io()).subscribe(new c(this), d.a), this);
        return;
    L9:
        if (r3.intValue() != 1) goto L17;
        lq3.a<Map<?, ?>> r9 = lq3.c.b;
        String r10 = this.entranceInfo;
        if (r10 == null) goto L13;
        Map r11 = com.bytedance.android.shopping.extensions.k.z(r10);
    L14:
        if (r11 != null) goto L16;
        r11 = MapsKt.emptyMap();
    L16:
        r2.setSceneParams(new lq3.b(r9, r11));
        goto L17
    L13:
        r11 = null;
        goto L14
    }

    public final Map<String, Object> getMetaInfo() {
        Map<String, Object> r0 = getMetaInfoWithoutKolId();
        r0.put("kol_id", this.shopParam.getAuthorId());
        r0.put("author_id", this.shopParam.getAuthorId());
        r0.put("sec_kol_id", this.shopParam.getSecAuthorId());
        return r0;
    }

    public final boolean isVideoTrailerOrSplitOpt() {
        if (isCroppedStyle() == true) goto L5;
    L20:
        return false;
    L5:
        if (Intrinsics.areEqual(this.shopParam.getPreSceneType(), WindowPreSceneType.VIDEO_TRAILER.getType()) == true) goto L19;
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r3 = 0;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L11
        Object r2 = jj4.a.a("window_split_opt", Integer.class, r3, false);     // Catch: Throwable -> L11
        if (r2 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L11
    L18:
        if (((Number) r2).intValue() != 1) goto L20;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L16;
        r3 = r7;
    L16:
        r2 = r3;
    L19:
        return true;
    }

    public void onCleared() {
        super.onCleared();
        ((LinkedHashMap) this.paramProvider.a).clear();
        this.eventDeliverer = null;
        ((LinkedHashMap) this.tagPools.a).clear();
        if (ECSettingKeys.d0() == false) goto L10;
        AVScene.a r0 = AVScene.Companion;
        AVScene r1 = AVScene.WINDOW_INNER_FLOW;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "avScene");
        r1.getTag();
        r1.getSubTag();
        int r2 = ECSdk.a;
        s83.g r3 = (s83.g) ECSdk.a(s83.g.class);
        if (r3 == null) goto L11;
        s83.f r4 = r3.p();
        if (r4 == null) goto L12;
        r4.j();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final zn.b<WindowCartEntryConfig> getCartEntryConfig() {
        return this.cartEntryConfig;
    }

    public final MutableLiveData<Float> getCollapseProgress() {
        return this.collapseProgress;
    }

    public final zn.b<ShopComponentResponseVO> getComponentResponse() {
        return this.componentResponse;
    }

    public final ECWindowShopLiveData<Integer> getCroppedState() {
        return this.croppedState;
    }

    public final zn.b<WeakReference<View>> getDestView() {
        return this.destView;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final JSONObject getEntranceInfoJsonObject() {
        return this.entranceInfoJsonObject;
    }

    public final Function1<hp3.b, Boolean> getEventDeliverer() {
        return this.eventDeliverer;
    }

    public final zn.b<Integer> getExtraSchemaClosed() {
        return this.extraSchemaClosed;
    }

    public final ECWindowShopLiveData<String> getFloatLayerShowDenied() {
        return this.floatLayerShowDenied;
    }

    public final MutableLiveData<Object> getGoTopEventReceiver() {
        return this.goTopEventReceiver;
    }

    public final String getHeaderCards() {
        return this.headerCards;
    }

    public final zn.b<uq3.a> getHeaderResponse() {
        return this.headerResponse;
    }

    public final b getHeaderSubTabsParam() {
        return this.headerSubTabsParam;
    }

    public final Function3<String, Boolean, String, Unit> getJump2Live() {
        return this.jump2Live;
    }

    public final MutableLiveData<Pair<String, WindowLayoutType>> getLayoutStatus() {
        return this.layoutStatus;
    }

    public final zn.b<WindowV3LiveRoomVO> getLiveInfo() {
        return this.liveInfo;
    }

    public final yn.d getLiveManager() {
        return this.liveManager;
    }

    public final zn.b<WindowLoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final zn.b<Pair<Integer, Integer>> getOffsetState() {
        return this.offsetState;
    }

    public final zn.b<Boolean> getOpenLiveByHeadClick() {
        return this.openLiveByHeadClick;
    }

    public final fo.b getOverallData() {
        return this.overallData;
    }

    public final ep3.a getParamProvider() {
        return this.paramProvider;
    }

    public final com.bytedance.android.window.shop.home.k getPendingTaskViewModel() {
        return this.pendingTaskViewModel;
    }

    public final com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> getPlayerPool() {
        return this.playerPool;
    }

    public final MutableLiveData<Integer> getPullOffset() {
        return this.pullOffset;
    }

    public final to.d getRenderDataVo() {
        return this.renderDataVo;
    }

    public final Uri getSchema() {
        return this.schema;
    }

    public final zn.b<Boolean> getScrollPositionFarEnough() {
        return this.scrollPositionFarEnough;
    }

    public final zn.b<Integer> getScrollState() {
        return this.scrollState;
    }

    public final com.bytedance.android.window.shop.home.c getSecondaryPageParams() {
        return this.secondaryPageParams;
    }

    public final zn.b<Pair<Integer, Integer>> getSelectedTabLocation() {
        return this.selectedTabLocation;
    }

    public final ECWindowParam getShopParam() {
        return this.shopParam;
    }

    public final zn.a<Boolean> getShowPopupWindowLiveData() {
        return this.showPopupWindowLiveData;
    }

    public final MutableLiveData<Float> getSubCollapseProgress() {
        return this.subCollapseProgress;
    }

    public final zn.b<Integer> getTabBarHeight() {
        return this.tabBarHeight;
    }

    public final long getTabDuration() {
        return this.tabDuration;
    }

    public final ap.c getTagPools() {
        return this.tagPools;
    }

    public final zn.b<Integer> getTopBarHeight() {
        return this.topBarHeight;
    }

    public final com.bytedance.android.window.shop.home.f getTopBarInfoParam() {
        return this.topBarInfoParam;
    }

    public final WindowEventContext getWindowEventContext() {
        return this.windowEventContext;
    }

    public final zn.b<Boolean> isFollowed() {
        return this.isFollowed;
    }

    public final zn.b<Boolean> isLiveOn() {
        return this.isLiveOn;
    }

    public static final /* synthetic */ void access$initDynamicParam(ECWindowViewModel r0) {
        r0.initDynamicParam();
    }

    public static final /* synthetic */ void access$loadComponentInfo(ECWindowViewModel r0) {
        r0.loadComponentInfo();
    }

    private final void doShopWindowEventReport(String r8) {
        String r0 = new BtmItemBuilder("", Boolean.FALSE).withPageFinder(PageFinder.via(this.shopParam.getBtmPageId())).createBtmId();
        String r1 = this.shopParam.getEnterStoreEvent();
        String r3 = null;
        if (r1 == null) goto L7;
        JSONObject r2 = z1.g(r1);
        if (r2 == null) goto L7;
        HashMap r4 = xn.c.e(r2);
    L8:
        Pair[] r5 = new Pair[18];
        r5[0] = TuplesKt.to("which_account", this.shopParam.getWhichAccount());
        r5[1] = TuplesKt.to("page_type", this.shopParam.getPageType());
        r5[2] = TuplesKt.to("search_params", this.shopParam.getSearchParams());
        r5[3] = TuplesKt.to("pre_product_id", this.shopParam.getPreProductId());
        r5[4] = TuplesKt.to("pre_room_id", this.shopParam.getPreRoomId());
        r5[5] = TuplesKt.to("ecom_json_str", this.shopParam.getEcomJsonStr());
        r5[6] = TuplesKt.to("ecom_pitaya_json_str", this.shopParam.getEcomPitayaJsonStr());
        r5[7] = TuplesKt.to("pre_group_id", this.shopParam.getPreGroupId());
        r5[8] = TuplesKt.to("loading_tab_id", getLoadingTabId());
        r5[9] = TuplesKt.to("follow_status", String.valueOf(this.shopParam.getFollowStatus()));
        r5[10] = TuplesKt.to("entrance_class_name", this.shopParam.getEntranceClassName());
        if (this.shopParam.isEcShare() == false) goto L11;
        Pair r6 = TuplesKt.to("share_content", this.shopParam.getShareContent());
    L12:
        r5[11] = r6;
        if (this.shopParam.isEcShare() == false) goto L15;
        Pair r7 = TuplesKt.to("share_object", this.shopParam.getShareObject());
    L16:
        r5[12] = r7;
        if (this.shopParam.isLuban() == false) goto L19;
        Pair r9 = TuplesKt.to("tag", "views_product_item");
    L20:
        r5[13] = r9;
        if (this.shopParam.isLuban() == false) goto L27;
        ECAdLogExtra r10 = this.shopParam.getAdLogExtra();
        if (r10 == null) goto L25;
        String r11 = r10.getCreativeId();
    L26:
        Pair r12 = TuplesKt.to("value", String.valueOf(r11));
    L28:
        r5[14] = r12;
        if (this.shopParam.isLuban() == false) goto L31;
        Pair r13 = TuplesKt.to("category", "umeng");
    L32:
        r5[15] = r13;
        if (this.shopParam.isLuban() == false) goto L38;
        ECAdLogExtra r14 = this.shopParam.getAdLogExtra();
        if (r14 == null) goto L37;
        r3 = r14.getLogExtra();
    L37:
        Pair r15 = TuplesKt.to("log_extra", r3);
    L39:
        r5[16] = r15;
        r5[17] = TuplesKt.to("btm_id", r0);
        doEventAction(r8, r4, r5);
        return;
    L38:
        r15 = TuplesKt.to("", "");
        goto L39
    L31:
        r13 = TuplesKt.to("", "");
        goto L32
    L25:
        r11 = null;
        goto L26
    L27:
        r12 = TuplesKt.to("", "");
        goto L28
    L19:
        r9 = TuplesKt.to("", "");
        goto L20
    L15:
        r7 = TuplesKt.to("", "");
        goto L16
    L11:
        r6 = TuplesKt.to("", "");
    L7:
        r4 = null;
        goto L8
    }

    private final void doTabMonitor(WindowTabInfoProvider r3) {
        WindowMonitor r0 = this.shopParam.getMonitor();
        if (r0 == null) goto L5;
        r0.stopTabDurationMonitor();
    L5:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r1 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r2 = com.bytedance.android.window.shop.lifecycle.c.a(this.shopParam.getLifecycleMonitorId());
        if (r2 == null) goto L8;
        r2.j(r3);
    L8:
        WindowBusinessMonitor.a(this, r3);
    }

    private final synchronized void handleLayoutInSql(List<io.d> r3) {
        monitor-enter(this);
        io.d r4 = (io.d) CollectionsKt.getOrNull(r3, 0);     // Catch: Throwable -> L28
        if (r4 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        Integer r5 = r4.c;     // Catch: Throwable -> L28
        if (r5 == null) goto L26;
        int r6 = r5.intValue();     // Catch: Throwable -> L28
        WindowLayoutType r0 = WindowLayoutType.SINGLECOLUMN;     // Catch: Throwable -> L28
        if (r6 == r0.getType()) goto L23;
        r0 = WindowLayoutType.DOUBLECOLUMN;     // Catch: Throwable -> L28
        if (r6 == r0.getType()) goto L23;
        r0 = WindowLayoutType.SINGLECOLUMN_V2;     // Catch: Throwable -> L28
        if (r6 == r0.getType()) goto L23;
        r0 = WindowLayoutType.DOUBLECOLUMN_V2;     // Catch: Throwable -> L28
        if (r6 == r0.getType()) goto L23;
        r0 = null;
    L23:
        this.storedLayoutType = r0;     // Catch: Throwable -> L28
        resolveLayoutType();     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    private final void handleShopTabDataListResponse(WindowHybridTabDataListResponseDTO r7) {
        dm.a.a("WINDOW").i("[loadTabInfo]secAuthorId:" + this.shopParam.getSecAuthorId());
        dm.a.a("WINDOW").i("[loadTabInfo]statusCode:" + r7.getStatusCode());
        if (r7.getStatusCode() != 302) goto L7;
        this.secondaryPageParams.e.setValue(Boolean.TRUE);
        return;
    L7:
        if (r7.getStatusCode() == 0) goto L9;
        return;
    L9:
        doTabMonitor(r7);
        if (this.headerResponse.getValue() == null) goto L62;
        this.headerSubTabsParam.d.c(r7);
    L14:
        Iterator<T> r0 = r7.categories().iterator();
    L16:
        if (r0.hasNext() == false) goto L21;
        com.bytedance.android.window.shop.repository.dto.p r1 = (com.bytedance.android.window.shop.repository.dto.p) r0.next();
        if (r1.b() == null) goto L19;
        com.bytedance.android.window.shop.e.a.put(r1.b(), new CategoryTabStruct(r1.b(), r1.c(), r1.getType()));
        goto L16
    L19:
        return;
    L21:
        ECWindowParam r2 = this.shopParam;
        ECHybridListDTO r8 = r7.getFeed();
        if (r8 == null) goto L24;
        List r9 = r8.getSections();
    L25:
        if (r9 != null) goto L27;
        r9 = CollectionsKt.emptyList();
    L27:
        List r10 = r9;
        boolean r3 = false;
        if ((r10 instanceof Collection) == true) goto L30;
    L32:
        Iterator r11 = r10.iterator();
    L34:
        if (r11.hasNext() == false) goto L57;
        Iterable r4 = ((ECHybridListSectionDTO) r11.next()).getItems();
        if (r4 != null) goto L38;
        r4 = CollectionsKt.emptyList();
    L38:
        Iterable r5 = r4;
        if ((r5 instanceof Collection) == true) goto L41;
    L43:
        Iterator r6 = r5.iterator();
    L45:
        if (r6.hasNext() == false) goto L54;
        Integer r12 = ((ECHybridListItemDTO) r6.next()).getItemType();
        if (r12 == null) goto L51;
        int r13 = r12.intValue();
        IntRange r14 = com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a;
        ECHybridListItemType.Companion.getClass();
        if (ECHybridListItemType.a.a(r13) != true) goto L51;
        boolean r15 = true;
    L52:
        if (r15 == false) goto L45;
        boolean r16 = true;
    L55:
        if (r16 == false) goto L34;
        r3 = true;
    L51:
        r15 = false;
    L54:
        r16 = false;
        goto L55
    L41:
        if (((Collection) r5).isEmpty() == false) goto L43;
    L57:
        r2.setUseLynxCard(r3);
        return;
    L30:
        if (r10.isEmpty() == false) goto L32;
    L24:
        r9 = null;
        goto L25
    L62:
        this.headerSubTabsParam.a.readLock().lock();     // Catch: Throwable -> L59
        this.headerSubTabsParam.d.c(r7);     // Catch: Throwable -> L59
        this.headerSubTabsParam.a.readLock().unlock();
    L59:
        th = move-exception;
        this.headerSubTabsParam.a.readLock().unlock();
        throw th;
    }

    private final void initEventParams(String r7) {
        Pair[] r0 = new Pair[17];
        r0[0] = TuplesKt.to("author_id", this.shopParam.getAuthorId());
        r0[1] = TuplesKt.to("window_bhv_session_id", this.shopParam.getWindowSessionId());
        r0[2] = TuplesKt.to("sec_author_id", this.shopParam.getSecAuthorId());
        r0[3] = TuplesKt.to("enter_from", this.shopParam.getEnterFrom());
        r0[4] = TuplesKt.to("entrance_location", this.shopParam.getEntranceLocation());
        r0[5] = TuplesKt.to("store_source_page", this.shopParam.getStoreSourcePage());
        r0[6] = TuplesKt.to("store_source_method", this.shopParam.getStoreSourceMethod());
        r0[7] = TuplesKt.to("store_group_type", this.shopParam.getStoreGroupType());
        r0[8] = TuplesKt.to("live_anchor_id", this.shopParam.getLiveAnchorId());
        r0[9] = TuplesKt.to("page_name", this.shopParam.getPageName());
        r0[10] = TuplesKt.to("source_page", this.shopParam.getPageName());
        r0[11] = TuplesKt.to("page_type", this.shopParam.getPageType());
        r0[12] = TuplesKt.to(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1004");
        r0[13] = TuplesKt.to("store_type", "window");
        Integer r1 = this.shopParam.getFollowStatus();
        ArrayList r3 = null;
        if (r1 == null) goto L7;
        String r2 = String.valueOf(r1.intValue());
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter("0", CommentConstants$CmtLongPanelStrategy.DEFAULT);
    L8:
        r0[14] = TuplesKt.to("follow_status", r2);
        kc.a r4 = com.bytedance.android.bcm.api.b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));
        if (r4 == null) goto L16;
        List r5 = r4.a;
        if (r5 == null) goto L16;
        List r6 = r5;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r3.add(((kc.a.a) r8.next()).c);
    L16:
        r0[15] = TuplesKt.to("btm_list", com.bytedance.android.ec.hybrid.list.util.k.d(r3));
        r0[16] = TuplesKt.to("entrance_info", r7);
        initEventContext(r0);
        this.windowEventContext.init(getBaseParams());
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void addAllDisposable(List<? extends Disposable> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add((Disposable) r3.next());
        goto L4
    }

    public final Map<String, String> getWindowMonitorCategories(int r8) {
        Pair[] r0 = new Pair[12];
        boolean r1 = this.shopParam.getHasHeaderLive();
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r1 == false) goto L5;
        Object r3 = CommentScene.COMMENTSCENE_NO_AWEME;
    L6:
        r0[0] = TuplesKt.to("flag_has_header_live", r3);
        fo.a<WindowLayoutType> r4 = WindowConstDef.a;
        if (WindowConstDef.b(Integer.valueOf(r8), 2) == false) goto L9;
        Object r5 = CommentScene.COMMENTSCENE_NO_AWEME;
    L10:
        r0[1] = TuplesKt.to("flag_hybrid_feed", r5);
        String r6 = this.headerCards;
        String r7 = "";
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0[2] = TuplesKt.to("flag_header_cards", r6);
        if (this.shopParam.getUseLynxCard() == true) goto L17;
        r2 = "0";
    L17:
        r0[3] = TuplesKt.to("flag_use_lynx_card", r2);
        r0[4] = TuplesKt.to("flex_use_preload", "true");
        WindowLayoutType r9 = this.headerSubTabsParam.b;
        if (r9 == null) goto L20;
        String r10 = String.valueOf(r9.getType());
    L21:
        if (r10 == null) goto L24;
        r7 = r10;
    L24:
        r0[5] = TuplesKt.to("goods_tab_layout", r7);
        r0[6] = TuplesKt.to("select_tab_type", String.valueOf(r8));
        r0[7] = TuplesKt.to("flag_live_optimize", String.valueOf(yq3.a.c()));
        r0[8] = TuplesKt.to("sec_author_id", this.shopParam.getSecAuthorId());
        r0[9] = TuplesKt.to("entrance_location", this.shopParam.getEntranceLocation());
        r0[10] = TuplesKt.to("window_bhv_session_id", this.shopParam.getWindowSessionId());
        if (isCroppedStyle() == false) goto L27;
        String r11 = "split";
    L28:
        r0[11] = TuplesKt.to("modal", r11);
        return MapsKt.mutableMapOf(r0);
    L27:
        r11 = "full";
        goto L28
    L20:
        r10 = null;
        goto L21
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = "0";
        goto L6
    }

    public final void loadTabInfo(boolean r9) {
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r0 = getPipeline();
        if (r0 == null) goto L6;
        r0.c(WindowLaunchTask.d);
    L6:
        if (this.shopParam.getTargetLayoutType() == null) goto L8;
        this.storedLayoutType = this.shopParam.getTargetLayoutType();
        b r1 = this.headerSubTabsParam;
        r1.b = this.shopParam.getTargetLayoutType();
    L13:
        String r2 = "-1";
        WindowPrefetchJobKey r5 = null;
        if (r9 == true) goto L35;
        fo.a<WindowLayoutType> r10 = WindowConstDef.a;
        if (WindowConstDef.b(this.shopParam.getTargetTabType(), 2) == false) goto L35;
        ShopRepository r11 = ShopRepository.a;
        WindowProductTabRequestParamDeprecated r6 = new WindowProductTabRequestParamDeprecated();
        r6.setPassThroughApi((String) this.shopParam.getPassThroughParam("pass_through_api"));
        r6.setSecAuthorId(this.shopParam.getSecAuthorId());
        int r4 = zq3.d.a;
        r6.setEcExtra(zq3.d.a(this.shopParam, this.entranceInfoJsonObject));
        Integer r7 = this.shopParam.getTargetTabType();
        if (r7 == null) goto L20;
        int r8 = r7.intValue();
    L21:
        r6.setTabType(r8);
        r6.setSortType(this.shopParam.getTargetSortType());
        r6.setSort(this.shopParam.getTargetSort());
        r6.setFirstEnter(true);
        r6.setPageSize(10);
        String r3 = this.shopParam.getTargetCategory();
        if (r3 == null) goto L25;
        r2 = r3;
    L25:
        r6.setTargetCategory(r2);
        r6.setForceInsertInfo(this.shopParam.getForceInsertInfo());
        Unit r12 = Unit.INSTANCE;
        ECWindowJobKeys r13 = this.shopParam.getWindowJobKeys();
        if (r13 == null) goto L28;
        r5 = r13.getTabBffJobKey();
    L28:
        WindowMonitor r14 = this.shopParam.getMonitor();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r6, "reqParam");
        ConcurrentHashMap r15 = com.bytedance.android.ec.window.base.shop.l.a;
        Observable r16 = com.bytedance.android.ec.window.base.shop.l.b(PrefetchScene.WINDOW, r5);
        if (r16 != null) goto L34;
        if (r14 == null) goto L33;
        r14.startTabDurationMonitor();
    L33:
        Intrinsics.checkNotNullParameter(r6, "reqParam");
        r16 = kq3.a.b(r6);
    L34:
        com.bytedance.android.ec.core.async.a.a(r16.subscribeOn(Schedulers.io()).subscribe(new h(this), new i(this)), this);
        return;
    L20:
        r8 = 100;
    L35:
        ShopRepository r17 = ShopRepository.a;
        WindowProductTabRequestParamDeprecated r18 = new WindowProductTabRequestParamDeprecated();
        r18.setPassThroughApi((String) this.shopParam.getPassThroughParam("pass_through_api"));
        r18.setSecAuthorId(this.shopParam.getSecAuthorId());
        r18.setTabType(getTabType());
        r18.setSortType(this.shopParam.getTargetSortType());
        r18.setSort(this.shopParam.getTargetSort());
        r18.setFirstEnter(true);
        r18.setPageSize(10);
        String r19 = this.shopParam.getTargetCategory();
        if (r19 == null) goto L39;
        r2 = r19;
    L39:
        r18.setTargetCategory(r2);
        r18.setForceInsertInfo(this.shopParam.getForceInsertInfo());
        Unit r20 = Unit.INSTANCE;
        ECWindowJobKeys r21 = this.shopParam.getWindowJobKeys();
        if (r21 == null) goto L42;
        r5 = r21.getTabJobKey();
    L42:
        WindowMonitor r22 = this.shopParam.getMonitor();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "reqParam");
        ConcurrentHashMap r23 = com.bytedance.android.ec.window.base.shop.l.a;
        Observable r24 = com.bytedance.android.ec.window.base.shop.l.b(PrefetchScene.WINDOW, r5);
        if (r24 != null) goto L48;
        if (r22 == null) goto L47;
        r22.startTabDurationMonitor();
    L47:
        Intrinsics.checkNotNullParameter(r18, "reqParam");
        r24 = kq3.a.c(r18);
    L48:
        com.bytedance.android.ec.core.async.a.a(r24.subscribeOn(Schedulers.io()).subscribe(new j(this), new k(this)), this);
        return;
    L8:
        ap3.i r25 = ap3.i.a;
        String r26 = com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId();
        String r27 = this.shopParam.getSecAuthorId();
        Intrinsics.checkNotNullParameter(r26, "userId");
        Intrinsics.checkNotNullParameter(r27, "secAuthorId");
        WindowDatabase r28 = go.a.b.a();
        if (r28 == null) goto L11;
        Observable r29 = Observable.create(new ap3.h(r28, r26, r27));
    L12:
        com.bytedance.android.ec.core.async.a.a(r29.subscribeOn(Schedulers.io()).subscribe(new g(this)), this);
        goto L13
    L11:
        r29 = Observable.just(CollectionsKt.emptyList());
        goto L12
    }

    public final void runLowPriorityTask(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.taskMgr.a(r2);
    }

    public final void setEntranceInfo(String r1) {
        this.entranceInfo = r1;
    }

    public final void setEntranceInfoJsonObject(JSONObject r1) {
        this.entranceInfoJsonObject = r1;
    }

    public final void setEventDeliverer(Function1<? super hp3.b, Boolean> r1) {
        this.eventDeliverer = r1;
    }

    public final void setHeaderCards(String r1) {
        this.headerCards = r1;
    }

    public final void setJump2Live(Function3<? super String, ? super Boolean, ? super String, Unit> r1) {
        this.jump2Live = r1;
    }

    public final void setRenderDataVo(to.d r1) {
        this.renderDataVo = r1;
    }

    public final void setSchema(Uri r1) {
        this.schema = r1;
    }

    public final void setServerLayoutType(WindowLayoutType r1) {
        this.serverLayoutType = r1;
        resolveLayoutType();
    }

    public final void setShopParam(ECWindowParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.shopParam = r2;
    }

    public final void setTabDuration(long r1) {
        this.tabDuration = r1;
    }

    public final void updateUserLayoutType(WindowLayoutType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.storedLayoutType = r2;
        this.headerSubTabsParam.b = r2;
    }

    private final void handleShopTabDataListResponse(WindowTabDataListResponseDTODeprecated r7) {
        dm.a.a("WINDOW").i("[loadTabInfo]secAuthorId:" + this.shopParam.getSecAuthorId());
        dm.a.a("WINDOW").i("[loadTabInfo]statusCode:" + r7.getStatusCode());
        if (r7.getStatusCode() != 302) goto L7;
        this.secondaryPageParams.e.setValue(Boolean.TRUE);
        return;
    L7:
        if (r7.getStatusCode() == 0) goto L9;
        return;
    L9:
        doTabMonitor(r7);
        if (this.headerResponse.getValue() == null) goto L35;
        this.headerSubTabsParam.c.c(r7);
    L14:
        Iterator<T> r0 = r7.categories().iterator();
    L16:
        if (r0.hasNext() == false) goto L21;
        com.bytedance.android.window.shop.repository.dto.p r1 = (com.bytedance.android.window.shop.repository.dto.p) r0.next();
        if (r1.b() == null) goto L19;
        com.bytedance.android.window.shop.e.a.put(r1.b(), new CategoryTabStruct(r1.b(), r1.c(), r1.getType()));
        goto L16
    L19:
        return;
    L21:
        List<com.bytedance.android.window.shop.repository.dto.c> r8 = r7.getMixFullCards();
        if (r8 == null) goto L31;
        Iterator<T> r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L46;
        com.bytedance.android.window.shop.repository.dto.c r2 = (com.bytedance.android.window.shop.repository.dto.c) r9.next();
        if (r2.c() == null) goto L25;
        if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r2.c().intValue()) == false) goto L25;
        this.shopParam.setUseLynxCard(true);
        goto L25
    L46:
        return;
    L31:
        return;
    L35:
        this.headerSubTabsParam.a.readLock().lock();     // Catch: Throwable -> L32
        this.headerSubTabsParam.c.c(r7);     // Catch: Throwable -> L32
        this.headerSubTabsParam.a.readLock().unlock();
    L32:
        th = move-exception;
        this.headerSubTabsParam.a.readLock().unlock();
        throw th;
    }

    public static final /* synthetic */ void access$handleLayoutInSql(ECWindowViewModel r0, List r1) {
        r0.handleLayoutInSql(r1);
    }

    public static final /* synthetic */ void access$handleShopTabDataListResponse(ECWindowViewModel r0, WindowHybridTabDataListResponseDTO r1) {
        r0.handleShopTabDataListResponse(r1);
    }

    private final void initShopParam(uq3.a r6, long r7) {
        ECWindowShareParam r0 = this.shopParam.getShareInfo();
        o r1 = r6.c;
        WindowFansClubInfo r2 = null;
        if (r1 == null) goto L5;
        ECUrlModel r3 = r1.m;
    L6:
        r0.setAvatarMedium(r3);
        o r4 = r6.c;
        if (r4 == null) goto L9;
        String r5 = r4.k;
    L10:
        r0.setNickName(r5);
        this.shopParam.setHeaderInterfaceTime(SystemClock.elapsedRealtime() - r7);
        ECWindowParam r8 = this.shopParam;
        o r9 = r6.c;
        if (r9 == null) goto L13;
        Integer r10 = r9.j;
    L14:
        r8.setFollowStatus(r10);
        ECWindowParam r11 = this.shopParam;
        o r12 = r6.c;
        if (r12 == null) goto L17;
        r2 = r12.n;
    L17:
        r11.setFansClubInfo(r2);
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ void access$handleShopTabDataListResponse(ECWindowViewModel r0, WindowTabDataListResponseDTODeprecated r1) {
        r0.handleShopTabDataListResponse(r1);
    }

    public static final /* synthetic */ void access$initShopParam(ECWindowViewModel r0, uq3.a r1, long r2) {
        r0.initShopParam(r1, r2);
    }

    public final void init(ECWindowParam r10, Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "shopParam");
        this.shopParam = r10;
        this.schema = r11;
        AppendScene r13 = AppendScene.EnterStorePage;
        this.entranceInfo = EcomBcmTracker.i().appendEntranceInfo(null, r12, r13);
        this.shopParam.setSourceType(null);
        this.entranceInfoJsonObject = z1.g(this.entranceInfo);
        initEventParams(this.entranceInfo);
        if (r10.isCroppedStyle() == true) goto L26;
        com.bytedance.android.window.shop.home.k r14 = this.pendingTaskViewModel;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "shopParam");
        wn.b.b r15 = wn.b.c;
        String r0 = WindowSettingKeys.getEC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST();
        monitor-enter(r15);
        Intrinsics.checkNotNullParameter(r0, "json");     // Catch: Throwable -> L23
        Map r1 = (Map) wn.b.b.fromJson(r0, wn.b.a);     // Catch: Exception -> L9 Throwable -> L23
    L11:
        monitor-exit(r15);
        String r4 = r10.getEntranceLocation();
        wn.b r16 = (wn.b) r1.get(r4);
        if (r16 == null) goto L32;
        String r7 = r16.a();
        if (r7 == null) goto L33;
        String r3 = r10.getSecAuthorId();
        long r5 = r16.b();
        String r2 = com.bytedance.android.ec.sdk.helper.r.a.f();
        ap3.g r17 = ap3.g.a;
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        Intrinsics.checkNotNullParameter(r4, "componentName");
        WindowDatabase r18 = go.a.b.a();
        if (r18 != null) goto L21;
        Observable r19 = Observable.just(CollectionsKt.emptyList());
    L22:
        bg4.b.b(r19.subscribeOn(Schedulers.io()).map(new com.bytedance.android.window.shop.home.j(r14, r2, r3, r4, r5))).subscribe(new com.bytedance.android.window.shop.home.h(r14, r7, r10), com.bytedance.android.window.shop.home.i.a);
        return;
    L21:
        r19 = Observable.create(new ap3.d(r18, r2, r3, r4));
        goto L22
    L33:
        return;
    L32:
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L23
        r1 = MapsKt.emptyMap();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void loadTabInfo$default(ECWindowViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.loadTabInfo(r1);
    }

    public static /* synthetic */ void init$default(ECWindowViewModel r0, ECWindowParam r1, Uri r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.init(r1, r2, r3);
    }
}
