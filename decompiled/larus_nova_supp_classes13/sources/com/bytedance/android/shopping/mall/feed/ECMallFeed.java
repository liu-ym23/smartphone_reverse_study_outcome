package com.bytedance.android.shopping.mall.feed;

import android.animation.ValueAnimator;
import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.ECMallConfigs;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridApiConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.data.utils.ECHybridChunkedApiHelper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ListEngineOptConfig;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridHolderUpdateParams;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.prebind.ECHybridRecyclerViewPreBindHelper;
import com.bytedance.android.ec.hybrid.list.prebind.ECHybridViewCacheExtension;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.monitor.HybridRecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.opt.deepfeed.FoldFilterManager;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.api.mall.IECMallPerformanceService;
import com.bytedance.android.shopping.api.mall.ILegouMallService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallCommonImpressionReportHelper;
import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedFrameLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.loadview.LoadingStatusVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.StorageItemDataProvider;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedSplitRenderConfig;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedStickyConfig;
import com.bytedance.android.shopping.api.mall.feed.card.DeliveryCardData;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.DynamicApiDTO;
import com.bytedance.android.shopping.api.mall.model.DynamicApiParamDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.ImpressionItem;
import com.bytedance.android.shopping.api.mall.model.PreloadGeckoConfig;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.bytedance.android.shopping.mall.feed.help.ECMallFeedRepeatManagerFeed;
import com.bytedance.android.shopping.mall.feed.help.ECMallFeedRepeatManagerFeed$start$1;
import com.bytedance.android.shopping.mall.feed.help.ECMallGulRefresh;
import com.bytedance.android.shopping.mall.feed.help.EventExposureTime;
import com.bytedance.android.shopping.mall.feed.help.EventExposureTime$scrollListener$1;
import com.bytedance.android.shopping.mall.feed.help.EventExposureTime$start$1;
import com.bytedance.android.shopping.mall.feed.help.EventExposureTime$start$2;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.mall.feed.help.MallShelterHelp;
import com.bytedance.android.shopping.mall.feed.help.ShelterEventHelp;
import com.bytedance.android.shopping.mall.feed.holder.ECMallPlaceholderCardVO;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallOpenSchemaJsb;
import com.bytedance.android.shopping.mall.feed.opt.LoadMorePrefetchStrategy;
import com.bytedance.android.shopping.mall.feed.opt.MallFixSetting;
import com.bytedance.android.shopping.mall.feed.opt.MallRequestEndManager;
import com.bytedance.android.shopping.mall.homepage.card.common.ECLynxCardMonitorHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.DynamicParamsController;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.android.shopping.mall.homepage.tools.BstUtilsNewKt;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineExtKt;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineMap;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.android.shopping.mall.homepage.tools.FavRefreshParams;
import com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier;
import com.bytedance.android.shopping.mall.opt.MallGulRequestUtil;
import com.bytedance.android.shopping.mall.opt.MallOptUtil;
import com.bytedance.android.shopping.mall.settings.MallRefreshGuideConfigKt;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.bytedance.android.shopping.mall.utils.ECMallVideoPreLoader;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.loading.ECLoadMoreView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed {
    public static final /* synthetic */ int I1 = 0;
    public final Lazy A;
    public final Lazy A0;
    public final f A1;
    public final Lazy B;
    public com.bytedance.android.shopping.mall.feed.y B0;
    public final e B1;
    public final Lazy C;
    public final ECMallFeed$isSnapToSectionLiveData$1 C0;
    public DataEngineWrapper C1;
    public final Lazy D;
    public int D0;
    public final Integer D1;
    public final Lazy E;
    public String E0;
    public final com.bytedance.android.ec.hybrid.card.api.f E1;
    public final Lazy F;
    public String F0;
    public final ik.a F1;
    public boolean G;
    public String G0;
    public final com.bytedance.android.shopping.mall.homepage.pagecard.d G1;
    public boolean H;
    public String H0;
    public final long H1;
    public final List<String> I;
    public boolean I0;
    public ECHybridListEngine J;
    public final Function2<? super Integer, ? super Boolean, Unit> J0;
    public ECHybridDataEngine K;
    public ECHybridRecyclerViewPreBindHelper K0;
    public int L;
    public com.bytedance.android.ec.hybrid.list.prebind.a L0;
    public int M;
    public Function0<Unit> M0;
    public boolean N;
    public final Lazy N0;
    public int O;
    public final Lazy O0;
    public boolean P;
    public final int P0;
    public int Q;
    public int Q0;
    public Integer R;
    public boolean R0;
    public String S;
    public boolean S0;
    public final ConcurrentHashMap<Integer, Boolean> T;
    public boolean T0;
    public boolean U;
    public boolean U0;
    public final ECMallFavoriteSectionHelper V;
    public o V0;
    public final com.bytedance.android.shopping.api.mall.common.tools.t W;
    public final CompositeDisposable W0;
    public long X;
    public final MutableLiveData<Float> X0;
    public i Y;
    public final Lazy Y0;
    public final List<ImpressionItem> Z;
    public boolean Z0;
    public b a;
    public final List<ImpressionItem> a0;
    public long a1;
    public m b;
    public final Lazy b0;
    public Map<String, ? extends Object> b1;
    public g c;
    public final Lazy c0;
    public final Lazy c1;
    public yj.b d;
    public final Set<String> d0;
    public final Lazy d1;
    public com.bytedance.android.shopping.mall.feed.help.j e;
    public boolean e0;
    public final Lazy e1;
    public p f;
    public final List<Map<String, Object>> f0;
    public final Lazy f1;
    public String g;
    public int g0;
    public final Lazy g1;
    public final Lazy h;
    public final com.bytedance.android.shopping.mall.homepage.card.live.n h0;
    public List<PreloadGeckoConfig> h1;
    public final Handler i;
    public final g93.a i0;
    public Function0<Unit> i1;
    public final Handler j;
    public final ReportAbility j0;
    public JSONObject j1;
    public final Lazy k;
    public final i0 k0;
    public final List<e93.e> k1;
    public final Lazy l;
    public final Lazy l0;
    public final Lazy l1;
    public final Lazy m;
    public final Lazy m0;
    public volatile com.bytedance.android.ec.hybrid.list.entity.k m1;
    public final Lazy n;
    public com.bytedance.android.ec.hybrid.list.ability.a0 n0;
    public volatile com.bytedance.android.ec.hybrid.list.entity.k n1;
    public final Lazy o;
    public final l o0;
    public com.bytedance.android.shopping.mall.feed.help.r o1;
    public final Lazy p;
    public boolean p0;
    public final com.bytedance.android.shopping.api.mall.common.feed.help.e p1;
    public final Lazy q;
    public boolean q0;
    public final IECMallPerformanceService.SceneContext q1;
    public final Lazy r;
    public z r0;
    public final Lazy r1;
    public final Lazy s;
    public final List<c> s0;
    public final Lazy s1;
    public final Lazy t;
    public final Lazy t0;
    public final Lazy t1;
    public final Lazy u;
    public final LoadMorePrefetchStrategy u0;
    public final q0 u1;
    public final Lazy v;
    public final int v0;
    public final Lazy v1;
    public final Lazy w;
    public final int w0;
    public Runnable w1;
    public final boolean x;
    public final Lazy x0;
    public Runnable x1;
    public final Lazy y;
    public final Lazy y0;
    public final Lazy y1;
    public final Lazy z;
    public final Lazy z0;
    public final ECHybridListContainer z1;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ECMallFeed$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
        public AnonymousClass1(ECMallFavoriteSectionHelper r8) {
            super(1, r8, ECMallFavoriteSectionHelper.class, "getSecTabIdByTab", "getSecTabIdByTab(I)I", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return Integer.valueOf(invoke(((Number) r1).intValue()));
        }

        public final int invoke(int r3) {
            return ((ECMallFavoriteSectionHelper) ((CallableReference) this).receiver).j.get(r3, 0);
        }
    }

    public final class CardOnShowAbility implements com.bytedance.android.ec.hybrid.list.ability.d {
        public final /* synthetic */ ECMallFeed a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ CardOnShowAbility a;
            public final /* synthetic */ List b;
            public final /* synthetic */ int c;
            public final /* synthetic */ Map d;

            public a(CardOnShowAbility r1, List r2, int r3, Map r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r4) {
                Integer r5 = (Integer) r4;
                this.a.a.j0.f(this.b, this.c, this.d);
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r4) {
                Lazy r0 = ECMallLogUtil.a;
                ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "async report exposure event error, msg : " + ((Throwable) r4).getMessage());
            }
        }

        public final void release() {
        }

        public CardOnShowAbility(ECMallFeed r1) {
            this.a = r1;
        }

        public final void a(List<com.bytedance.android.ec.hybrid.list.entity.c> r3, int r4, Map<String, ? extends Object> r5) {
            ECMallFeed r0 = this.a;
            if (r0.B1.p == false) goto L5;
            Single.just(1).observeOn(Schedulers.computation()).subscribe(new a(this, r3, r4, r5), b.a);
            return;
        L5:
            r0.j0.f(r3, r4, r5);
        }

        public final void Fr(BaseViewHolder r5, int r6, List<String> r7, Map<String, ? extends Object> r8) {
            Intrinsics.checkNotNullParameter(r5, "card");
            ECHybridListItemVO r0 = r5.c;
            if (r0 == null) goto L51;
            com.bytedance.android.ec.hybrid.list.entity.n r1 = r0.o;
            if (r1 == null) goto L52;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r2 = r1.e;
            if (r2 == null) goto L53;
            if (r7 == null) goto L21;
            ArrayList r3 = new ArrayList();
            Iterator r4 = r2.iterator();
        L13:
            if (r4.hasNext() == false) goto L20;
            Object r9 = r4.next();
            String r10 = ((com.bytedance.android.ec.hybrid.list.entity.c) r9).a;
            if (r10 != null) goto L18;
            r10 = " ";
        L18:
            if (r7.contains(r10) == false) goto L13;
            r3.add(r9);
            goto L13
        L20:
            r2 = r3;
        L21:
            Iterator r11 = r2.iterator();
        L23:
            if (r11.hasNext() == false) goto L33;
            com.bytedance.android.ec.hybrid.list.entity.c r12 = (com.bytedance.android.ec.hybrid.list.entity.c) r11.next();
            ECHybridListItemVO r13 = r5.c;
            if (r13 == null) goto L23;
            com.bytedance.android.ec.hybrid.list.entity.n r14 = r13.o;
            if (r14 == null) goto L23;
            HashMap r15 = r14.b;
            if (r15 == null) goto L23;
            Map r16 = r12.b;
            if (r16 == null) goto L23;
            r16.putAll(r15);
            goto L23
        L33:
            a(r2, r6, r8);
            return;
        L53:
            return;
        L52:
            return;
        }

        public final void Xn(BaseViewHolder r15, ECHybridListItemVO r16, int r17, int r18, int r19, boolean r20, boolean r21) {
            Intrinsics.checkNotNullParameter(r15, "card");
            Intrinsics.checkNotNullParameter(r16, "itemDataVO");
            com.bytedance.android.shopping.api.mall.common.tools.t r2 = this.a.W;
            int r3 = r15.getAdapterPosition();
            r2.getClass();
            if (r3 < 0) goto L14;
            if (r16 == null) goto L14;
            Integer r4 = r16.W;
            if (r4 == null) goto L14;
            int r5 = r4.intValue();
            if (r5 != 1) goto L11;
        L13:
            r2.b.put(Integer.valueOf(r5), Integer.valueOf(r3));
            goto L14
        L11:
            if (r5 == 2) goto L13;
        L14:
            com.bytedance.android.ec.hybrid.list.entity.n r6 = r16.o;
            if (r6 == null) goto L28;
            HashMap r7 = r6.b;
            if (r7 == null) goto L28;
            if (r7.get("guess_favorite_impression_flag") == null) goto L28;
            if (r16.w == true) goto L28;
            ECHybridListEngine r8 = this.a.J;
            if (r8 == null) goto L28;
            com.bytedance.android.ec.hybrid.list.ability.v r9 = (com.bytedance.android.ec.hybrid.list.ability.v) r8.getAbility(com.bytedance.android.ec.hybrid.list.ability.v.class);
            if (r9 == null) goto L28;
            r9.Qc(r19);
        L28:
            r16.I = true;
            if (r20 == false) goto L31;
        L33:
            Logger.d("peive", "onCardShow itemIndex = " + r17 + " hasCacheFlag = " + r16.w);
            if (r16.w == false) goto L36;
            return;
        L36:
            com.bytedance.android.ec.hybrid.list.entity.n r10 = r16.o;
            if (r10 == null) goto L174;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r11 = r10.c;
            if (r11 == null) goto L177;
            HashMap r12 = r10.a;
            if (r12 == null) goto L44;
            Object r13 = r12.get("ecom_type");
        L46:
            if ((r13 instanceof String) == true) goto L48;
            r13 = null;
        L48:
            String r14 = (String) r13;
            if (r16.I == true) goto L51;
        L53:
            com.bytedance.android.ec.hybrid.list.entity.n r22 = r16.o;
            if (r22 == null) goto L80;
            List r23 = r22.c;
            if (r23 == null) goto L80;
            Iterator r24 = r23.iterator();
        L59:
            if (r24.hasNext() == false) goto L80;
            com.bytedance.android.ec.hybrid.list.entity.c r110 = (com.bytedance.android.ec.hybrid.list.entity.c) r24.next();
            if (Intrinsics.areEqual(r110.a, "show_ecom_card") == false) goto L77;
            if (r14 != null) goto L64;
        L67:
            boolean r111 = true;
        L68:
            if (r111 == false) goto L77;
            Map r25 = r110.b;
            if (r25 == null) goto L72;
            Object r26 = r25.get("ecom_type");
        L74:
            if ((r26 instanceof String) == true) goto L76;
            r26 = null;
        L76:
            r14 = (String) r26;
            goto L77
        L72:
            r26 = null;
            goto L74
        L64:
            if (r14.length() == 0) goto L67;
            r111 = false;
        L77:
            r110.h = Integer.valueOf(r16.hashCode());
            Map r112 = r110.b;
            if (r112 == null) goto L59;
            r112.put("event_reuse_id", r16.Q);
        L80:
            Lazy r27 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.f.b, "report show item type is " + r16.c + ", ecom type is " + r14);
            com.bytedance.android.ec.hybrid.list.entity.n r28 = r16.o;
            if (r28 == null) goto L87;
            HashMap r29 = r28.b;
            if (r29 == null) goto L87;
            if (r29.get("guess_favorite_impression_flag") == null) goto L87;
            ECMallFeed.b(this.a);
        L87:
            Logger.d("puffone-NativeCommerceHomePage.onCardShow()", "onCardShow: " + r16.c + ' ' + this.a.g0);
            com.bytedance.android.ec.hybrid.list.entity.n r1 = r16.o;
            if (r1 == null) goto L103;
            List r30 = r1.c;
            if (r30 == null) goto L103;
            List r31 = r30;
            LinkedHashMap r32 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r31, 10)), 16));
            Iterator r33 = r31.iterator();
        L93:
            if (r33.hasNext() == false) goto L95;
            com.bytedance.android.ec.hybrid.list.entity.c r34 = (com.bytedance.android.ec.hybrid.list.entity.c) r33.next();
            r32.put(r34.a, r34);
            goto L93
        L95:
            Iterator r35 = r31.iterator();
        L97:
            if (r35.hasNext() == false) goto L103;
            com.bytedance.android.ec.hybrid.list.entity.c r36 = (com.bytedance.android.ec.hybrid.list.entity.c) r35.next();
            String r37 = r36.g;
            if (r37 == null) goto L97;
            com.bytedance.android.ec.hybrid.list.entity.c r38 = (com.bytedance.android.ec.hybrid.list.entity.c) r32.get(r37);
            if (r38 == null) goto L97;
            r36.b = r38.b;
            r36.c = r38.c;
            r36.d = r38.d;
        L103:
            if (r21 == false) goto L105;
        L131:
            a(r11, r18, null);
        L132:
            Iterator r39 = ((ArrayList) this.a.s0).iterator();
        L134:
            if (r39.hasNext() == false) goto L136;
            ((c) r39.next()).a();
            goto L134
        L136:
            com.bytedance.android.shopping.mall.feed.help.r r40 = this.a.o1;
            if (r40 != null) goto L139;
            return;
        L139:
            if (r18 != ((r40.f + 20) + 1)) goto L176;
            r40.a("no_click");
            return;
        L176:
            return;
        L105:
            if (BstUtilsNewKt.c(((RecyclerView.ViewHolder) r15).itemView) == false) goto L131;
            ArrayList r41 = new ArrayList();
            r41.addAll(r11);
            CollectionsKt.removeAll(r41, ECMallFeed$CardOnShowAbility$onCardShow$cleanData$1$1.INSTANCE);
            a(r41, r18, null);
            List<com.bytedance.android.ec.hybrid.list.entity.c> r113 = r11;
            ArrayList r114 = new ArrayList();
            Iterator r42 = r113.iterator();
        L109:
            if (r42.hasNext() == false) goto L114;
            Object r43 = r42.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.c) r43).a, "show_product") == false) goto L109;
            r114.add(r43);
            goto L109
        L114:
            if (BstUtilsNewKt.b(r15, r114, this.a, r18, "like_shopping", "show_product") == true) goto L116;
            a(r114, r18, null);
        L116:
            Iterator r115 = r113.iterator();
        L118:
            if (r115.hasNext() == false) goto L132;
            com.bytedance.android.ec.hybrid.list.entity.c r44 = (com.bytedance.android.ec.hybrid.list.entity.c) r115.next();
            if ((!Intrinsics.areEqual(r44.a, "show_product")) == false) goto L118;
            int r45 = com.bytedance.forest.utils.h.a;
            if (com.bytedance.forest.utils.h.a(r44.f) == false) goto L118;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r116 = CollectionsKt.listOf(r44);
            String r46 = r44.a;
            String r47 = r44.f;
            if (r46 == null) goto L118;
            if (r47 == null) goto L118;
            if (BstUtilsNewKt.b(r15, r116, this.a, r18, r47, r46) == true) goto L118;
            a(r116, r18, null);
            goto L118
        L51:
            if (((Boolean) MallFixSetting.c.getValue()).booleanValue() == false) goto L53;
            return;
        L44:
            r13 = null;
            goto L46
        L177:
            return;
        L174:
            return;
        L31:
            if (r16.K == true) goto L33;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/ECMallFeed$FeedLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onResume", "onPause", "onStop", "onDestroy", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class FeedLifecycleObserver implements LifecycleObserver {
        public com.bytedance.android.shopping.mall.feed.m a;
        public final /* synthetic */ ECMallFeed b;

        public static final class a implements com.bytedance.android.shopping.mall.homepage.card.live.b {
            public final /* synthetic */ FeedLifecycleObserver a;

            public a(FeedLifecycleObserver r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.mall.homepage.card.live.b
            public final void j(boolean r2) {
                ECMallFeed r0 = this.a.b;
                r0.S0 = r2;
                r0.getClass();
            }
        }

        public final void a() {
            int r1 = 0;
            this.b.h0.a(false);
            this.b.O(false);
            int r3 = 1;
            this.b.j0.j(true);
            ECMallFeed r0 = this.b;
            com.bytedance.android.shopping.api.mall.common.tools.t r4 = r0.W;
            Integer r2 = r0.R;
            int r5 = -1;
            if (r2 == null) goto L5;
            int r6 = r2.intValue();
        L7:
            if (r6 == 308) goto L9;
            r4.getClass();
        L58:
            ECMallCommonImpressionReportHelper.b r7 = this.b.t();
            if (r7 != null) goto L61;
        L70:
            Iterator r8 = ((ArrayList) this.b.k1).iterator();
        L72:
            if (r8.hasNext() == false) goto L74;
            ((e93.e) r8.next()).onPause();
            goto L72
        L74:
            return;
        L61:
            if (r7.a != true) goto L70;
            ECMallCommonImpressionReportHelper r9 = this.b.u();
            if (r9 == null) goto L70;
            if (r9.g == true) goto L70;
            if (r9.i.d == false) goto L70;
            r9.a.post(new com.bytedance.android.shopping.api.mall.common.feed.help.b(r9));
            goto L70
        L9:
            Integer r10 = r4.c;
            com.bytedance.android.ec.hybrid.list.entity.k r11 = null;
            if (r10 != null) goto L25;
            int r12 = ((Number) r4.e.invoke(Integer.valueOf(r6))).intValue();
            if (r12 != 0) goto L14;
        L24:
            r10 = r3;
            goto L25
        L14:
            if (r12 == 1) goto L23;
            if (r12 == 2) goto L23;
            if (r4.b.containsKey(2) == false) goto L20;
            r3 = 2;
            goto L24
        L20:
            if (r4.b.containsKey(1) == true) goto L24;
            r10 = null;
        L23:
            r3 = 2;
        L25:
            if (r10 == null) goto L58;
            int r13 = r10.intValue();
            Integer r14 = (Integer) ((LinkedHashMap) r4.b).get(Integer.valueOf(r13));
            if (r14 == null) goto L29;
            int r15 = r14.intValue();
        L30:
            Integer r16 = (Integer) ((LinkedHashMap) r4.b).get(Integer.valueOf(r13));
            if (r16 == null) goto L33;
            r5 = r16.intValue();
        L33:
            ECHybridListEngine r17 = r4.a;
            if (r17 == null) goto L36;
            r11 = r17.c.g;
        L36:
            ArrayList r18 = (ArrayList) com.bytedance.android.shopping.api.mall.common.tools.t.a(r11);
            if (r18.isEmpty() == true) goto L53;
            Iterator r19 = r18.iterator();
        L41:
            if (r19.hasNext() == false) goto L53;
            ECHybridListItemVO r20 = (ECHybridListItemVO) r19.next();
            Integer r21 = r20.W;
            if (r21 != null) goto L46;
        L50:
            boolean r22 = false;
        L51:
            if (r22 == false) goto L41;
            r1 = 1;
            goto L53
        L46:
            if (r21.intValue() != r13) goto L50;
            if (r4.b(r20) <= r5) goto L50;
            r22 = true;
        L53:
            int r23 = r1 ^ 1;
            Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L56
            JSONObject r25 = new JSONObject();     // Catch: Throwable -> L56
            r25.put("type", r13);     // Catch: Throwable -> L56
            r25.put("last_exposure_index", r15);     // Catch: Throwable -> L56
            r25.put("is_real_last", r23);     // Catch: Throwable -> L56
            r25.putOpt("address", r4.d);     // Catch: Throwable -> L56
            Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L56
            AppLogNewUtils.onEventV3("gyl_next_day_arrive_show", r25);     // Catch: Throwable -> L56
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L58
        L29:
            r15 = -1;
            goto L30
        L5:
            r6 = -1;
            goto L7
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onCreate() {
            com.bytedance.android.shopping.mall.homepage.card.live.n r0 = this.b.h0;
            a r1 = new a(this);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "listener");
            r0.a.add(r1);
            this.b.getClass();
            this.b.getClass();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ECMallFeed r0 = this.b;
            int r1 = ECMallFeed.I1;
            com.bytedance.android.shopping.mall.feed.help.a r2 = (com.bytedance.android.shopping.mall.feed.help.a) r0.l1.getValue();
            if (r2 == null) goto L5;
            r2.a();
        L5:
            this.b.getClass();
            CoroutineScopeKt.cancel$default((CoroutineScope) this.b.y0.getValue(), null, 1, null);
            com.bytedance.android.shopping.mall.feed.help.d r3 = (com.bytedance.android.shopping.mall.feed.help.d) this.b.t0.getValue();
            if (r3 == null) goto L8;
            ECEventCenter.f("mallRefreshFeedData", r3.f);
            ECEventCenter.f("mallRequestFeedData", r3.g);
        L8:
            Iterator r4 = ((ArrayList) this.b.k1).iterator();
        L10:
            if (r4.hasNext() == false) goto L12;
            ((e93.e) r4.next()).onDestroy();
            goto L10
        L12:
            this.b.getClass();
            this.b.getClass();
            com.bytedance.android.shopping.mall.homepage.card.live.n r5 = this.b.h0;
            r5.a.clear();
            r5.b.clear();
            l r6 = this.b.o0;
            Iterator r7 = ((ArrayList) r6.a).iterator();
        L14:
            if (r7.hasNext() == false) goto L16;
            Pair r8 = (Pair) r7.next();
            ECEventCenter.f((String) r8.getFirst(), (com.bytedance.android.ec.hybrid.card.event.e) r8.getSecond());
            goto L14
        L16:
            WeakReference<Context> r9 = r6.b;
            if (r9 == null) goto L19;
            r9.clear();
        L19:
            r6.b = null;
            if (MallSettings.a() == false) goto L28;
            this.b.i.removeCallbacksAndMessages(null);
            ECMallFeed r10 = this.b;
            o r11 = r10.V0;
            if (r11 == null) goto L28;
            ECHybridDataEngine r12 = r10.K;
            if (r12 == null) goto L28;
            Intrinsics.checkNotNullParameter(r11, "applier");
            if (Intrinsics.areEqual(r11, r12.n) == false) goto L28;
            r12.n = null;
            r12.p.l(null);
        L28:
            this.b.j.removeCallbacksAndMessages(null);
            ECMallCommonImpressionReportHelper.b r13 = this.b.t();
            if (r13 != null) goto L31;
        L35:
            this.b.A1.s4().getLifecycle().removeObserver(this);
            ECEventCenter.f("ec.mita.reportClickData", this.b.k0);
            MallGulRequestUtil.INSTANCE.unRegisterListener(this.b.B1.a);
            this.b.W0.dispose();
            this.b.getClass();
            this.b.c0("destroy", null);
            return;
        L31:
            if (r13.a != true) goto L35;
            ECMallCommonImpressionReportHelper r14 = this.b.u();
            if (r14 == null) goto L35;
            r14.g = true;
            r14.a.removeCallbacks(r14.h);
            r14.b.clear();
            r14.c = CollectionsKt.emptyList();
            r14.d = false;
            r14.e = false;
            r14.f = false;
            goto L35
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            this.b.E().a();
            if (MallShelterHelp.l != 1) goto L10;
            com.bytedance.android.shopping.mall.feed.help.q r0 = this.b.A1.TN();
            if (r0 != null) goto L7;
        L9:
            a();
            return;
        L7:
            if (r0.f() != true) goto L9;
            this.a = new com.bytedance.android.shopping.mall.feed.m(this);
            return;
        L10:
            a();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            ECMallFeed r0 = this.b;
            int r1 = ECMallFeed.I1;
            r0.getClass();
            boolean r2 = true;
            this.b.h0.a(true);
            this.b.O(true);
            ECMallFeed r3 = this.b;
            if (r3.p0 == false) goto L31;
            DataEngineWrapper r4 = r3.C1;
            String r5 = null;
            if (r4 == null) goto L7;
            String r6 = r4.d();
        L9:
            if (r6 != null) goto L11;
        L14:
            boolean r7 = true;
        L15:
            if (r7 == true) goto L32;
            IECMallAddressService r8 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
            if (r8 == null) goto L33;
            String r9 = r8.getAddress(this.b.z1, null);
            if (r9 != null) goto L21;
            return;
        L21:
            if (r9.length() > 0) goto L24;
            r2 = false;
        L24:
            if (r2 == false) goto L26;
            r5 = r9;
        L26:
            if (r5 == null) goto L35;
            DataEngineWrapper r10 = this.b.C1;
            if (r10 == null) goto L36;
            r10.r = r5;
            return;
        L36:
            return;
        L35:
            return;
        L33:
            return;
        L32:
            return;
        L11:
            if (r6.length() == 0) goto L14;
            r7 = false;
            goto L15
        L7:
            r6 = null;
            goto L9
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onStop() {
            if (MallShelterHelp.l != 1) goto L7;
            com.bytedance.android.shopping.mall.feed.m r0 = this.a;
            if (r0 == null) goto L7;
            r0.run();
            this.a = null;
        L7:
            Runnable r1 = this.b.w1;
            if (r1 == null) goto L10;
            r1.run();
        L10:
            this.b.w1 = null;
        }

        public FeedLifecycleObserver(ECMallFeed r1) {
            this.b = r1;
        }
    }

    public final class LoadMoreCallBack extends k {
        public final int c;
        public boolean d;
        public HomePageDTO e;
        public final long f;
        public final /* synthetic */ ECMallFeed g;

        public static final class a implements Runnable {
            public final /* synthetic */ LoadMoreCallBack a;
            public final /* synthetic */ long b;
            public final /* synthetic */ Ref.ObjectRef c;
            public final /* synthetic */ String d;
            public final /* synthetic */ int e;
            public final /* synthetic */ long f;

            public a(LoadMoreCallBack r1, long r2, Ref.ObjectRef r4, String r5, int r6, long r7) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LoadMoreCallBack r0 = this.a;     // Catch: Throwable -> L4
                ECMallFeed r1 = r0.g;     // Catch: Throwable -> L4
                long r3 = r0.f;     // Catch: Throwable -> L4
                Long r5 = Long.valueOf(this.b);     // Catch: Throwable -> L4
                Integer r6 = (Integer) this.c.element;     // Catch: Throwable -> L4
                String r7 = this.d;     // Catch: Throwable -> L4
                int r8 = this.e;     // Catch: Throwable -> L4
                Long r9 = Long.valueOf(this.f);     // Catch: Throwable -> L4
                int r2 = ECMallFeed.I1;     // Catch: Throwable -> L4
                r1.b0(1, r3, r5, r6, r7, r8, r9);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ LoadMoreCallBack a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ ECHybridNetworkVO d;
            public final /* synthetic */ boolean e;

            public b(LoadMoreCallBack r1, String r2, String r3, ECHybridNetworkVO r4, boolean r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public LoadMoreCallBack(ECMallFeed r2, long r3) {
            this.g = r2;
            super(r2, GYLFetchType.LOAD_MORE);
            this.f = r3;
            Lazy r4 = MallOptUtil.a;
            this.c = MallOptUtil.g(r2.B1.c, 0);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void a(String r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, "apiKey");
            Intrinsics.checkNotNullParameter(r11, "t");
            if (Intrinsics.areEqual(r10, "favorite_feed") == false) goto L11;
            this.g.A1.MT();
            ECMallFeed r0 = this.g;
            long r2 = this.f;
            int[] r12 = new int[2];
            i r13 = r0.Y;
            if (r13 == null) goto L9;
            View r14 = r13.a;
            if (r14 == null) goto L9;
            r14.getLocationOnScreen(r12);
        L9:
            r0.b0(2, r2, null, null, null, r12[1], null);
            return;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void b(String r22, String r23, ECHybridNetworkVO r24) {
            Intrinsics.checkNotNullParameter(r22, "apiKey");
            Intrinsics.checkNotNullParameter(r23, "result");
            Intrinsics.checkNotNullParameter(r24, "requestVO");
            if (Intrinsics.areEqual(r22, "favorite_feed") == false) goto L59;
            long r3 = System.currentTimeMillis();
            Ref.ObjectRef r5 = new Ref.ObjectRef();
            final com.bytedance.android.shopping.mall.opt.b r11 = null;
            r5.element = null;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            r5.element = this.g.I(r23, this.e, r24, GYLFetchType.LOAD_MORE);     // Catch: Throwable -> L7
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r2 = Result.exceptionOrNull-impl(r1);
            if (r2 == null) goto L12;
            Lazy r4 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.r.b.b, "handle load success on normal fetch");
            EnsureManager.ensureNotReachHere(r2);
        L12:
            Integer r6 = (Integer) r5.element;
            if (r6 != null) goto L16;
        L18:
            String r18 = null;
        L19:
            int[] r7 = new int[2];
            i r8 = this.g.Y;
            if (r8 == null) goto L24;
            View r9 = r8.a;
            if (r9 == null) goto L24;
            r9.getLocationOnScreen(r7);
        L24:
            int r10 = r7[1];
            if (((Boolean) this.g.u.getValue()).booleanValue() == false) goto L27;
            ECMallFeed r12 = this.g;
            r12.i.post(new a(this, r3, r5, r18, r10, r12.X));
            boolean r13 = true;
        L28:
            this.g.U(this.c);
            if (r10 <= 0) goto L55;
            Lazy r14 = MallOptUtil.a;
            String r15 = this.g.B1.c;
            com.bytedance.android.shopping.mall.opt.a r16 = MallOptUtil.d().d();
            if (r16 == null) goto L53;
            com.bytedance.android.shopping.mall.opt.a r17 = MallOptUtil.d().d();
            if (r17 == null) goto L53;
            Map<String, com.bytedance.android.shopping.mall.opt.b> r19 = r17.e();
            if (r19 == null) goto L53;
            com.bytedance.android.shopping.mall.opt.b r20 = r19.get(r15);
            if (r20 == null) goto L53;
            Integer r21 = r20.a();
            if (r21 != null) goto L43;
            r21 = r16.a();
        L43:
            Boolean r25 = r20.b();
            if (r25 != null) goto L46;
            r25 = r16.b();
        L46:
            Long r26 = r20.c();
            if (r26 != null) goto L49;
            r26 = r16.c();
        L49:
            Integer r27 = r20.d();
            if (r27 != null) goto L52;
            r27 = r16.d();
        L52:
            r11 = new com.bytedance.android.shopping.mall.opt.b(r21, r25, r26, r27);
        L53:
            if (r11 == null) goto L55;
            CommonUtilKt.g(new ECMallFeed$LoadMoreCallBack$handleSuccess$4(this, r11));
        L55:
            ECMallFeed r28 = this.g;
            r28.Z0 = r13;
            r28.c0("loadmore", 5);
            return;
        L27:
            r13 = true;
            this.g.b0(1, this.f, Long.valueOf(r3), (Integer) r5.element, r18, r10, null);
            goto L28
        L16:
            if (r6.intValue() != (-1011)) goto L18;
            r18 = "sid_not_match";
        L7:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void c(String r9, String r10, ECHybridNetworkVO r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r9, "apiKey");
            Intrinsics.checkNotNullParameter(r10, "result");
            Intrinsics.checkNotNullParameter(r11, "requestVO");
            super.c(r9, r10, r11, r12);
            if (((Boolean) this.g.v.getValue()).booleanValue() == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r9, "favorite_feed") == false) goto L15;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            this.e = (HomePageDTO) new Gson().fromJson(r10, HomePageDTO.class);     // Catch: Throwable -> L8
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            this.g.i.postAtFrontOfQueue(new b(this, r9, r10, r11, r12));
            return;
        L8:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void d(String r3, String r4, ECHybridNetworkVO r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            Intrinsics.checkNotNullParameter(r4, "result");
            Intrinsics.checkNotNullParameter(r5, "requestVO");
            if (((Boolean) this.g.v.getValue()).booleanValue() == true) goto L5;
            super.d(r3, r4, r5, r6);
            return;
        L5:
            if (Intrinsics.areEqual(r3, "favorite_feed") == false) goto L10;
            if (this.d == false) goto L10;
            return;
        L10:
            if (Intrinsics.areEqual(r3, "favorite_feed") == false) goto L12;
            this.d = true;
        L12:
            super.d(r3, r4, r5, r6);
        }
    }

    public final class LoadMoreViewHolderCreator extends com.bytedance.android.ec.hybrid.list.ability.l0 {
        public final /* synthetic */ ECMallFeed a;

        public LoadMoreViewHolderCreator(ECMallFeed r1) {
            this.a = r1;
        }

        public final ECLoadMoreViewHolder a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            ECMallFeed r0 = this.a;
            if (r0.Y != null) goto L5;
            r0.Y = new i(r0, r3.getContext());
        L5:
            i r1 = this.a.Y;
            Intrinsics.checkNotNull(r1);
            final View r2 = r1.a;
            Intrinsics.checkNotNull(r2);
            return new ECMallFeed$LoadMoreViewHolderCreator$createLoadMoreHolder$1(r2);
        }
    }

    public final class LynxViewHolderCreator extends com.bytedance.android.ec.hybrid.list.ability.m0 {
        public final /* synthetic */ ECMallFeed a;

        public LynxViewHolderCreator(ECMallFeed r1) {
            this.a = r1;
        }

        public final ECLynxCardHolder a(Context r23) {
            Intrinsics.checkNotNullParameter(r23, "context");
            h r4 = new h(r23);
            r4.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ECMallFeed r2 = this.a;
            int r3 = ECMallFeed.I1;
            String r5 = r2.B();
            ECMallFeed r6 = this.a;
            e r7 = r6.B1;
            Long r8 = r7.t;
            Integer r9 = r7.s;
            Integer r10 = r7.k;
            com.bytedance.android.ec.hybrid.list.entity.l.b r11 = com.bytedance.android.ec.hybrid.list.entity.l.b.a;
            String r12 = r7.c;
            Lifecycle r13 = r6.A1.s4().getLifecycle();
            if (ECMallConfigs.INSTANCE.getLegouBuiltinResourceEnable() == true) goto L5;
            ECLynxCardHolder.a r14 = null;
        L6:
            ECMallFeed r15 = this.a;
            e r16 = r15.B1;
            Map<String, String> r17 = r16.e;
            String r18 = r16.d;
            ik.a r19 = r15.F1;
            MutableLiveData<Float> r20 = r15.X0;
            Function2<View, ECHybridListItemVO, Unit> r21 = new ECMallFeed$LynxViewHolderCreator$createLynxHolder$lynxCardHolder$1(this);
            LifecycleOwner r110 = this.a.A1.s4();
            ECMallFeed r22 = this.a;
            ECLynxCardMonitorHolder r1 = new ECLynxCardMonitorHolder(r4, r5, r8, r9, r10, r11, r12, r13, r14, r17, r18, r19, r20, r21, r110, r22.A1, r22.B1.C);
            ((ECLynxCardHolder) r1).q = this.a.A1.getGlobalProps();
            if (this.a.A1.isDarkMode() == false) goto L9;
            String r24 = "dark";
        L10:
            Lazy r25 = HybridAppInfoService.a;
            if (HybridAppInfoService.h() == false) goto L59;
            Map r26 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appTheme", r24)});
            com.bytedance.android.shopping.api.mall.idl.a r27 = this.a.A1.Bi();
            if (r27 == null) goto L60;
            com.bytedance.android.shopping.api.mall.idl.c r28 = r27.a;
            if (r28 == null) goto L60;
            LinkedHashMap r29 = new LinkedHashMap();
            Integer r30 = r28.b;
            if (r30 == null) goto L19;
            r29.put("mallContainerRealWidth", Integer.valueOf(r30.intValue()));
        L19:
            Float r31 = r28.e;
            if (r31 == null) goto L22;
            r29.put("mallContainerMarginLeft", Float.valueOf(r31.floatValue()));
        L22:
            Float r32 = r28.f;
            if (r32 == null) goto L25;
            r29.put("mallContainerMarginRight", Float.valueOf(r32.floatValue()));
        L25:
            LinkedHashMap r33 = new LinkedHashMap();
            Integer r34 = r28.g;
            if (r34 == null) goto L28;
            r33.put("mallLayoutBreakpoint", Integer.valueOf(r34.intValue()));
        L28:
            String r35 = r28.h;
            if (r35 == null) goto L31;
            r33.put("deviceOrientation", r35);
        L31:
            Integer r36 = r28.i;
            if (r36 == null) goto L34;
            r33.put("feedLayoutColumn", Integer.valueOf(r36.intValue()));
        L34:
            List<Integer> r37 = r28.j;
            if (r37 == null) goto L37;
            r33.put("tileLayoutInfo", r37);
        L37:
            Integer r38 = r28.k;
            if (r38 == null) goto L40;
            r33.put("deviceScreenType", Integer.valueOf(r38.intValue()));
        L40:
            Integer r39 = r28.d;
            if (r39 == null) goto L43;
            r33.put("mallPageWidth", Integer.valueOf(r39.intValue()));
        L43:
            Integer r40 = r28.b;
            if (r40 == null) goto L46;
            r33.put("mallMetricsWidth", Integer.valueOf(r40.intValue()));
        L46:
            Float r41 = r28.e;
            if (r41 == null) goto L49;
            r33.put("mallContainerMarginLeft", Float.valueOf(r41.floatValue()));
        L49:
            r33.put("enableWidescreenStyle", Boolean.valueOf(r28.n));
            Float r42 = r28.f;
            if (r42 == null) goto L52;
            r33.put("mallContainerMarginRight", Float.valueOf(r42.floatValue()));
        L52:
            Integer r43 = r28.c;
            if (r43 == null) goto L55;
            r33.put("mallFeedMetricsWidth", Integer.valueOf(r43.intValue()));
        L55:
            r33.put("inSplitScreen", Boolean.valueOf(r28.m));
            if ((true ^ r33.isEmpty()) == false) goto L58;
            r29.put("mallDeviceAdapterInfo", r33);
        L58:
            r26.putAll(r29);
        L60:
            ((ECLynxCardHolder) r1).r = r26;
            return r1;
        L59:
            r26 = null;
            goto L60
        L9:
            r24 = "light";
            goto L10
        L5:
            r14 = new ECLynxCardHolder.a(NativeMallGeckoHelper.a(), NativeMallGeckoHelper.b());
            goto L6
        }
    }

    public final class ReportAbility implements k93.g {
        public final List<com.bytedance.android.shopping.mall.feed.help.o> a;
        public final Lazy b;
        public final Lazy c;
        public final com.bytedance.android.shopping.mall.feed.help.s d;
        public final /* synthetic */ ECMallFeed e;

        public static final class a<V> implements Callable {
            public final /* synthetic */ ReportAbility a;
            public final /* synthetic */ List b;

            public a(ReportAbility r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                ReportAbility r0 = this.a;
                List r1 = this.b;
                r0.getClass();
                ReportAbility.g(r1);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public final Map<String, Object> c() {
            return this.e.A1.getGlobalProps();
        }

        public static void g(List r2) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            Iterator r3 = r2.iterator();     // Catch: Throwable -> L8
        L4:
            if (r3.hasNext() == false) goto L6;
            com.bytedance.android.shopping.mall.feed.help.o r1 = (com.bytedance.android.shopping.mall.feed.help.o) r3.next();     // Catch: Throwable -> L8
            AppLogNewUtils.onEventV3(r1.a, com.bytedance.android.ec.hybrid.list.util.k.b(r1.b));     // Catch: Throwable -> L8
            goto L4
        L6:
            Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L17;
            EnsureManager.ensureNotReachHere(r5);
            return;
        L17:
            return;
        L8:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // k93.g
        public final void a(com.bytedance.android.shopping.api.mall.common.feed.help.f r8) {
            Intrinsics.checkNotNullParameter(r8, "params");
            Map<String, Object> r0 = r8.c;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r8.b != null) goto L8;
            return;
        L8:
            Map<String, Object> r1 = r8.e;
            if (r1 != null) goto L11;
            r1 = this.e.A1.getGlobalProps();
        L11:
            List<com.bytedance.android.ec.hybrid.list.entity.m> r2 = r8.b;
            if (r2 == null) goto L60;
            Iterator<T> r3 = r2.iterator();
        L15:
            if (r3.hasNext() == false) goto L108;
            com.bytedance.android.ec.hybrid.list.entity.m r4 = (com.bytedance.android.ec.hybrid.list.entity.m) r3.next();
            String r5 = r4.a;
            if (r5 == null) goto L15;
            String r6 = r4.b;
            if (r6 == null) goto L15;
            if (r1.containsKey(r5) == true) goto L24;
            switch(r5.hashCode()) {
                case -1318876424: goto L54;
                case -1119704095: goto L49;
                case -1030806959: goto L46;
                case -777455388: goto L43;
                case 39426542: goto L40;
                case 100346066: goto L37;
                case 1644800532: goto L32;
                case 1970241253: goto L29;
                default: goto L15;
            };
        L29:
            if (r5.equals("section") == false) goto L15;
        L55:
            Map<String, Object> r7 = r8.f;
            if (r7 == null) goto L15;
            Object r9 = r7.get(r5);
            if (r9 == null) goto L15;
            r0.put(r6, r9);
            goto L15
        L32:
            if (r5.equals("last_request_id") == false) goto L15;
            if (Intrinsics.areEqual(r8.a, "show_ecom_card_list") == false) goto L15;
            r0.put(r6, this.e.E0);
            goto L15
        L37:
            if (r5.equals("index") == false) goto L15;
            r0.put(r6, String.valueOf(r8.d));
            goto L15
        L40:
            if (r5.equals("btm_index") == false) goto L15;
            r0.put(r6, String.valueOf(r8.d + 1));
            goto L15
        L43:
            if (r5.equals("click_area") == false) goto L15;
        L46:
            if (r5.equals("recommend_info") == false) goto L15;
        L49:
            if (r5.equals("last_item_list") == false) goto L15;
            if (Intrinsics.areEqual(r8.a, "show_ecom_card_list") == false) goto L15;
            r0.put(r6, this.e.F0);
            goto L15
        L54:
            if (r5.equals("section_index") == false) goto L15;
        L24:
            r0.put(r6, r1.get(r5));
            goto L15
        L108:
            return;
        }

        public final void d(Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "map");
            i(r3, null, null, false);
        }

        public final void j(boolean r3) {
            ArrayList r0 = new ArrayList();
            r0.addAll(this.a);
            ((ArrayList) this.a).clear();
            if (r3 == false) goto L5;
            g(r0);
            return;
        L5:
            Single.fromCallable(new a(this, r0)).subscribeOn(Schedulers.single()).subscribe();
        }

        public ReportAbility(ECMallFeed r1, ShelterEventHelp r2) {
            this.e = r1;
            this.d = r2;
            this.a = new ArrayList();
            this.b = LazyKt.lazy(new ECMallFeed$ReportAbility$cacheBtmInfo$2(this));
            this.c = LazyKt.lazy(new ECMallFeed$ReportAbility$cacheGlobalPropsWhenExposure$2(this));
        }

        public final void e(String r2, JSONObject r3) {
            if (((ArrayList) this.e.D.getValue()).contains(r2) == false) goto L9;
            com.bytedance.android.shopping.mall.feed.help.s r0 = this.d;
            if (r0 == null) goto L9;
            if (r0.a(r2, r3) == true) goto L11;
            AppLogNewUtils.onEventV3(r2, r3);
            return;
        L11:
            return;
        L9:
            AppLogNewUtils.onEventV3(r2, r3);
        }

        public final void f(List<com.bytedance.android.ec.hybrid.list.entity.c> r18, int r19, Map<String, ? extends Object> r20) {
            Intrinsics.checkNotNullParameter(r18, "data");
            if (r18.isEmpty() == true) goto L113;
            Object r4 = null;
            if (((Boolean) this.c.getValue()).booleanValue() == false) goto L7;
            Map<String, Object> r3 = this.e.j0.c();
        L8:
            j93.c r12 = new j93.c(null);
            boolean r14 = true;
            if (((Boolean) this.b.getValue()).booleanValue() == false) goto L36;
            Iterator<T> r5 = r18.iterator();
        L12:
            if (r5.hasNext() == false) goto L36;
            Map r6 = ((com.bytedance.android.ec.hybrid.list.entity.c) r5.next()).d;
            if (r6 == null) goto L12;
            Object r7 = r6.get("btm");
            if ((r7 instanceof String) == true) goto L19;
            r7 = null;
        L19:
            String r8 = (String) r7;
            Object r9 = r6.get("bcm");
            if ((r9 instanceof String) == true) goto L22;
            r9 = null;
        L22:
            String r10 = (String) r9;
            if (r8 != null) goto L25;
        L28:
            boolean r11 = true;
        L29:
            if (r11 == true) goto L12;
            if (r8 != null) goto L33;
            r8 = "";
        L33:
            if (r10 != null) goto L35;
            r10 = "";
        L35:
            String r13 = r8 + "-----" + r10;
            ECMallFeed r15 = this.e;
            r12.a.put(r13, r15.A1.bI(MapsKt.toMap(r6), false));
            goto L36
        L25:
            if (r8.length() == 0) goto L28;
            r11 = false;
        L36:
            Iterator<T> r1 = r18.iterator();
        L38:
            if (r1.hasNext() == false) goto L123;
            com.bytedance.android.ec.hybrid.list.entity.c r16 = (com.bytedance.android.ec.hybrid.list.entity.c) r1.next();
            if (Intrinsics.areEqual(r16.a, "common_impression") == false) goto L50;
            Map r17 = r16.b;
            if (r17 != null) goto L44;
        L47:
            boolean r21 = true;
        L48:
            if (r21 == true) goto L50;
            this.e.i(r16.b);
        L112:
            r4 = null;
            r14 = true;
            goto L38
        L44:
            if (r17.isEmpty() == true) goto L47;
            r21 = false;
        L50:
            LinkedHashMap r110 = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(r16, "data");
            Intrinsics.checkNotNullParameter(r110, "reportItem");
            LinkedHashMap r22 = new LinkedHashMap();
            r22.put("item_data_flag", r16.h);
            Unit r23 = Unit.INSTANCE;
            r110.put("params", r22);
            r110.put("eventName", r16.a);
            Map r24 = r16.d;
            if (r24 == null) goto L53;
            Object r25 = r24.get("btm");
        L55:
            if ((r25 instanceof String) == true) goto L57;
            r25 = r4;
        L57:
            String r26 = (String) r25;
            if (r26 != null) goto L60;
        L65:
            Map r27 = r16.b;
            if (r27 != null) goto L68;
        L75:
            if (r3 != null) goto L77;
            Map<String, Object> r28 = this.e.A1.getGlobalProps();
        L78:
            List r29 = r16.c;
            if (r29 == null) goto L90;
            if ((r29.isEmpty() ^ r14) != r14) goto L90;
            if ((r28.isEmpty() ^ r14) == false) goto L90;
            String r30 = r16.a;
            List r31 = r16.c;
            Object r32 = r110.get("params");
            if (TypeIntrinsics.isMutableMap(r32) == true) goto L87;
            r32 = r4;
        L87:
            a(new com.bytedance.android.shopping.api.mall.common.feed.help.f(r30, r31, (Map) r32, r19, r3, r20));
        L90:
            if (Intrinsics.areEqual(r16.a, "show_ecom_card_list") == false) goto L111;
            Map r33 = r16.b;
            if (r33 == null) goto L111;
            if ((!r33.isEmpty()) != true) goto L111;
            ECMallFeed r34 = this.e;
            Map r35 = r16.b;
            if (r35 == null) goto L98;
            Object r36 = r35.get("request_id");
        L100:
            if ((r36 instanceof String) == true) goto L102;
            r36 = null;
        L102:
            r34.E0 = (String) r36;
            ECMallFeed r37 = this.e;
            Map r38 = r16.b;
            if (r38 == null) goto L105;
            Object r39 = r38.get("item_list");
        L107:
            if ((r39 instanceof String) == true) goto L109;
            r39 = null;
        L109:
            r37.F0 = (String) r39;
            goto L111
        L105:
            r39 = null;
            goto L107
        L98:
            r36 = null;
        L111:
            k93.g.a.a(this, r110, r3, r12, 8);
            goto L112
        L77:
            r28 = r3;
            goto L78
        L68:
            if ((r27.isEmpty() ^ r14) != r14) goto L75;
            Object r40 = r110.get("params");
            if (TypeIntrinsics.isMutableMap(r40) == true) goto L72;
            r40 = r4;
        L72:
            Map r41 = (Map) r40;
            if (r41 == null) goto L75;
            Map r42 = r16.b();
            Intrinsics.checkNotNull(r42);
            r41.putAll(r42);
            goto L75
        L60:
            if (r26.length() <= 0) goto L62;
            boolean r43 = true;
        L63:
            if (r43 == false) goto L65;
            r110.put("btm", r26);
            goto L65
        L62:
            r43 = false;
            goto L63
        L53:
            r25 = r4;
            goto L55
        L123:
            return;
        L7:
            r3 = null;
            goto L8
        }

        public final void h(Map<String, ? extends Object> r2, Map<String, ? extends Object> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "params");
            i(r2, r3, null, r4);
        }

        @Override // k93.g
        public final void b(Map<String, ? extends Object> r3, Map<String, ? extends Object> r4, j93.c r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "map");
            DataEngineWrapper r0 = this.e.C1;
            if (r0 == null) goto L7;
            y93.a r1 = r0.b;
            if (r1 == null) goto L7;
            Long r2 = r1.j();
        L8:
            if (r2 != null) goto L13;
            ECMallFeed r7 = this.e;
            if (r7.q0 == true) goto L13;
            ((CopyOnWriteArrayList) r7.f0).add(r3);
            return;
        L13:
            i(r3, r4, r5, r6);
            return;
        L7:
            r2 = null;
            goto L8
        }

        public final void i(Map<String, ? extends Object> r17, final Map<String, ? extends Object> r18, final j93.c r19, final boolean r20) {
            Intrinsics.checkNotNullParameter(r17, "params");
            ArrayList<String> r3 = com.bytedance.android.shopping.mall.feed.help.i.a;
            ECMallFeed r4 = this.e;
            ECHybridListEngine r5 = r4.J;
            ECMallFavoriteSectionHelper r6 = r4.V;
            Intrinsics.checkNotNullParameter(r17, "params");
            Object r7 = r17.get("eventName");
            boolean r9 = false;
            Object r10 = null;
            if (r7 != null) goto L6;
        L49:
            int r8 = com.bytedance.android.shopping.api.mall.common.feed.help.d.a;
            Intrinsics.checkNotNullParameter(r17, "params");
            Object r11 = r17.get("eventName");
            if (r11 != null) goto L53;
        L68:
            com.bytedance.android.shopping.mall.homepage.tools.f r12 = com.bytedance.android.shopping.mall.homepage.tools.f.a;
            f r13 = this.e.A1;
            Function1<Map<String, ? extends Object>, Unit> r14 = new ECMallFeed$ReportAbility$reportInnerInterceptor$1(this, r18, r19, r20);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r17, "originParams");
            Intrinsics.checkNotNullParameter(r13, "feedContainerAbility");
            Intrinsics.checkNotNullParameter(r14, "ensuredParamsCallback");
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L123
            Lazy r16 = ECHybridChunkedApiHelper.a;     // Catch: Throwable -> L123
            if (((Boolean) ECHybridChunkedApiHelper.a.getValue()).booleanValue() == true) goto L72;
            r14.invoke(r17);     // Catch: Throwable -> L123
            return;
        L72:
            Object r21 = r17.get("params");     // Catch: Throwable -> L123
            if ((r21 instanceof Map) == true) goto L75;
            r21 = null;
        L75:
            Map r22 = (Map) r21;     // Catch: Throwable -> L123
            if (r22 == null) goto L79;
            Object r23 = r22.get("recommend_info");     // Catch: Throwable -> L123
        L81:
            if ((r23 instanceof String) == true) goto L83;
            r23 = null;
        L83:
            String r24 = (String) r23;     // Catch: Throwable -> L123
            if (r24 != null) goto L88;
        L90:
            boolean r110 = false;
        L91:
            if (r22 == null) goto L121;
            if (r24 == null) goto L121;
            if (r110 == false) goto L121;
            if (TypeIntrinsics.isMutableMap(r17) == false) goto L98;
            Map<String, ? extends Object> r111 = r17;
        L99:
            String r25 = new JSONObject(r24).optString("chunked_info_key");     // Catch: Throwable -> L123
            Object r26 = r22.get("is_cache_data");     // Catch: Throwable -> L123
            if ((r26 instanceof Number) == false) goto L103;
            r10 = r26;
        L103:
            Number r112 = (Number) r10;     // Catch: Throwable -> L123
            if (r112 != null) goto L106;
        L108:
            String r27 = r13.AH(r25, r9);     // Catch: Throwable -> L123
        L115:
            th = move-exception;
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L123
            Object r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L123
        L118:
            if (Result.exceptionOrNull-impl(r0) == null) goto L120;
            r14.invoke(r17);     // Catch: Throwable -> L123
        L120:
            Object r1 = Result.constructor-impl(Result.box-impl(r0));     // Catch: Throwable -> L123
        L126:
            if (Result.exceptionOrNull-impl(r1) == null) goto L133;
            r14.invoke(r17);
            return;
        L133:
            return;
        L110:
            if (TypeIntrinsics.isMutableMap(r22) == true) goto L113;
            LinkedHashMap r29 = new LinkedHashMap();     // Catch: Throwable -> L115
            r29.putAll(r22);     // Catch: Throwable -> L115
            r22 = r29;
        L113:
            r22.put("recommend_info", r27);     // Catch: Throwable -> L115
            r111.put("params", r22);     // Catch: Throwable -> L115
            r14.invoke(r111);     // Catch: Throwable -> L115
            r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L115
        L106:
            if (r112.intValue() != 1) goto L108;
            r9 = true;
            goto L108
        L98:
            r111 = new LinkedHashMap();     // Catch: Throwable -> L123
            r111.putAll(r17);     // Catch: Throwable -> L123
        L121:
            r14.invoke(r17);     // Catch: Throwable -> L123
            return;
        L88:
            if (StringsKt.contains$default(r24, "chunked_info_key", false, 2, null) != true) goto L90;
            r110 = true;
            goto L91
        L79:
            r23 = null;
        L123:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L126
        L53:
            if ((!Intrinsics.areEqual(r11, "show_ecom_card")) == true) goto L55;
        L61:
            Object r31 = r17.get("params");
            if (TypeIntrinsics.isMutableMap(r31) == true) goto L64;
            r31 = null;
        L64:
            Map r32 = (Map) r31;
            if (r32 == null) goto L68;
            r32.put("track_unique_id", String.valueOf(Random.Default.nextLong(1000000000000000L, 10000000000000000L)));
            goto L68
        L55:
            if ((!Intrinsics.areEqual(r11, "click_ecom_card")) == false) goto L61;
            if ((!Intrinsics.areEqual(r11, "show_product")) == false) goto L61;
            if ((!Intrinsics.areEqual(r11, "click_product")) == false) goto L61;
        L6:
            if ((!Intrinsics.areEqual(r7, "click_ecom_card")) == true) goto L8;
        L10:
            Object r33 = r17.get("params");
            if (TypeIntrinsics.isMutableMap(r33) == true) goto L13;
            r33 = null;
        L13:
            Map r34 = (Map) r33;
            if (r34 == null) goto L49;
            Object r113 = r34.get("outflow_order");
            if ((r113 instanceof String) == true) goto L19;
            r113 = null;
        L19:
            String r114 = (String) r113;
            Object r115 = r34.get("session_id");
            if ((r115 instanceof String) == true) goto L22;
            r115 = null;
        L22:
            String r116 = (String) r115;
            if (com.bytedance.forest.utils.h.a(r116) == true) goto L49;
            if (r114 == null) goto L36;
            Integer r117 = StringsKt.toIntOrNull(r114);
            if (r117 == null) goto L36;
            int r118 = r117.intValue();
            if (r5 == null) goto L36;
            ECHybridListItemVO r35 = r5.h(r118 + 1);
            if (r35 == null) goto L36;
            com.bytedance.android.ec.hybrid.list.entity.dto.a r36 = r35.D;
            if (r36 == null) goto L35;
            r116 = r36.d;
            goto L36
        L35:
            r116 = null;
        L36:
            if (r116 != null) goto L38;
        L41:
            boolean r37 = true;
        L42:
            if (r37 == false) goto L47;
            if (r6 == null) goto L47;
            String r38 = r6.A;
            if (r38 == null) goto L47;
            r116 = r38;
        L47:
            if (r116 == null) goto L49;
            r34.put("session_id", r116);
            goto L49
        L38:
            if (r116.length() == 0) goto L41;
            r37 = false;
            goto L42
        L8:
            if ((!Intrinsics.areEqual(r7, "show_ecom_card")) == false) goto L10;
            goto L10
        }

        @Override // k93.g
        public final void adThirdTrackReport(String r8, List<String> r9, Long r10, String r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r8, "trackLabel");
            this.e.A1.adThirdTrackReport(r8, r9, r10, r11, r12);
        }

        @Override // k93.g
        public final void adReport(String r11, String r12, String r13, String r14, String r15, Map<String, ? extends Object> r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "label");
            Intrinsics.checkNotNullParameter(r14, "creativeId");
            this.e.A1.adReport(r11, r12, r13, r14, r15, r16, r17, r18);
        }
    }

    public final class ScrollListener extends RecyclerView.OnScrollListener {
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ ECMallFeed d;

        public static final class a implements Runnable {
            public final /* synthetic */ Runnable a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ ScrollListener a;

            public b(ScrollListener r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r2 = true;
                if (ECHybridSettings.a() == false) goto L12;
                ScrollListener r0 = this.a;     // Catch: Throwable -> L16
                int r4 = r0.a;     // Catch: Throwable -> L16
                if (r4 == 0) goto L21;
                if (r4 > 0) goto L9;
                r2 = false;
            L9:
                ECHybridRecyclerViewPreBindHelper r1 = r0.d.K0;     // Catch: Throwable -> L16
                if (r1 == null) goto L21;
                ECHybridRecyclerViewPreBindHelper.d(r1, r2, null, null, 30);     // Catch: Throwable -> L16
            L21:
                return;
            L12:
                ECHybridRecyclerViewPreBindHelper r3 = this.a.d.K0;     // Catch: Throwable -> L16
                if (r3 == null) goto L21;
                ECHybridRecyclerViewPreBindHelper.d(r3, true, null, null, 30);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L24;
                throw th;
            }
        }

        public ScrollListener(ECMallFeed r1) {
            this.d = r1;
        }

        public final void onScrollStateChanged(RecyclerView r27, int r28) {
            Intrinsics.checkNotNullParameter(r27, "recyclerView");
            super.onScrollStateChanged(r27, r28);
            if (this.d.C() == false) goto L5;
            this.d.p0(r27, 0);
        L5:
            ECMallFeed r3 = this.d;
            r3.x1 = null;
            ShelterEventHelp r4 = (ShelterEventHelp) r3.k.getValue();
            if (r4 == null) goto L8;
            r4.h = false;
        L8:
            ECMallFeed r5 = this.d;
            com.bytedance.android.ec.hybrid.list.prebind.a r6 = r5.L0;
            if (r6 == null) goto L11;
            r6.f = true;
        L11:
            if (r28 == 0) goto L22;
            ECHybridListEngine r7 = r5.J;
            if (r7 == null) goto L18;
            ECHybridListAdapter r8 = r7.a;
            if (r8 == null) goto L18;
            if (r8.b == true) goto L22;
        L18:
            if (r7 == null) goto L22;
            ECHybridListAdapter r9 = r7.a;
            if (r9 == null) goto L22;
            r9.b = true;
        L22:
            ECHybridListEngine r10 = r5.J;
            if (r10 == null) goto L27;
            DataResolver r11 = r10.c;
            if (r11 == null) goto L27;
            r11.j();
        L27:
            this.d.A1.MT();
            if (r28 != 0) goto L31;
            this.d.C0.setValue(Boolean.FALSE);
        L31:
            if (r28 != 0) goto L41;
            ECMallFeed r12 = this.d;
            ECHybridRecyclerViewPreBindHelper r13 = r12.K0;
            if (r13 == null) goto L36;
            r13.k = false;
        L36:
            if (r12.A() != 2) goto L44;
            b r14 = new b(this);
            if (((Boolean) this.d.O0.getValue()).booleanValue() == false) goto L40;
            this.d.i.post(new a(r14));
            goto L44
        L40:
            r14.run();
        L44:
            if (r28 == 2) goto L50;
            if (r28 == 1) goto L50;
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("scroll:stop", System.currentTimeMillis(), this.d.B(), false, null, false, 56));
            Function2<? super Integer, ? super Boolean, Unit> r15 = this.d.J0;
            if (r15 == null) goto L51;
            Unit r1 = (Unit) r15.invoke(Integer.valueOf(UIUtils.px2dip(r27.getContext(), this.d.Q)), Boolean.TRUE);
        L51:
            if (r28 != 0) goto L92;
            ECMallFeed.c(this.d);
            ECMallFavoriteSectionHelper r2 = this.d.V;
            if (r2.B != null) goto L55;
            return;
        L55:
            if (r2.s() == null) goto L109;
            ECMallFeed r16 = this.d;
            h93.a r17 = r16.V.B;
            if (r17 != null) goto L60;
        L87:
            this.d.j0.j(false);
            com.bytedance.android.ec.hybrid.list.ability.a0 r18 = this.d.n0;
            if (r18 == null) goto L90;
            r18.a();
        L90:
            kk.d.c(new ECMallFeed$ScrollListener$onScrollStateChanged$3(this));
            goto L92
        L60:
            if (r17.a != true) goto L87;
            int r19 = r16.D0;
            int r20 = ((Number) r16.A.getValue()).intValue();
            if (1 > r20) goto L87;
            if (r19 <= r20) goto L87;
            ECMallFeed r21 = this.d;
            h93.a r22 = r21.V.B;
            if (r22 == null) goto L68;
            r22.a = false;
        L68:
            ReportAbility r23 = r21.j0;
            LinkedHashMap r24 = new LinkedHashMap();
            r24.put("eventName", "ecommerce_mall_tab_channel_did_scroll");
            LinkedHashMap r25 = new LinkedHashMap();
            List<com.bytedance.android.shopping.api.mall.common.tools.d> r26 = this.d.V.s();
            if (r26 == null) goto L86;
            Iterator<T> r29 = r26.iterator();
        L72:
            if (r29.hasNext() == false) goto L82;
            Object r30 = r29.next();
            int r110 = ((com.bytedance.android.shopping.api.mall.common.tools.d) r30).a;
            Integer r111 = this.d.R;
            if (r111 != null) goto L77;
        L79:
            boolean r112 = false;
        L80:
            if (r112 == false) goto L72;
        L83:
            com.bytedance.android.shopping.api.mall.common.tools.d r31 = (com.bytedance.android.shopping.api.mall.common.tools.d) r30;
            if (r31 == null) goto L86;
            r25.put("tab_id", String.valueOf(r31.a));
            r25.put("tab_name", r31.b);
            r25.put("tab_order", Integer.valueOf(r31.c));
            r25.put("tab_title", r31.g);
            r25.put("tab_type", String.valueOf(r31.d));
            goto L86
        L77:
            if (r110 != r111.intValue()) goto L79;
            r112 = true;
            goto L80
        L82:
            r30 = null;
        L86:
            r24.put("params", r25);
            r24.put("btm", "c0.d0");
            Unit r32 = Unit.INSTANCE;
            k93.g.a.a(r23, r24, null, null, 14);
            goto L87
        L109:
            return;
        L92:
            com.bytedance.android.shopping.mall.feed.help.r r33 = this.d.o1;
            if (r33 == null) goto L110;
            if (r28 != 1) goto L96;
            r33.a = true;
        L96:
            if (r28 == 0) goto L98;
            return;
        L98:
            if (r33.d > com.bytedance.android.shopping.api.mall.common.tools.b0.c(500)) goto L100;
        L102:
            r33.a = false;
            r33.b = 0;
            r33.d = 0;
            r33.e = 0;
            r33.c = null;
            return;
        L100:
            if (r33.e <= 3000) goto L102;
            r33.a("quick_slide");
            goto L102
        L110:
            return;
        L50:
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("scroll:start", System.currentTimeMillis(), this.d.B(), false, null, false, 56));
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("negfeedback_hide_notification", System.currentTimeMillis(), this.d.B(), false, MapsKt.mapOf(TuplesKt.to("triggerBy", 1)), false, 32));
            goto L51
        L41:
            ECHybridRecyclerViewPreBindHelper r34 = this.d.K0;
            if (r34 == null) goto L44;
            r34.k = true;
            goto L44
        }

        public final void onScrolled(RecyclerView r19, int r20, int r21) {
            Intrinsics.checkNotNullParameter(r19, "recyclerView");
            super.onScrolled(r19, r20, r21);
            ECMallFeed r3 = this.d;
            r3.getClass();
            this.a = r21;
            if (r3.C() == false) goto L5;
            this.d.p0(r19, r21);
        L6:
            Function2<? super Integer, ? super Boolean, Unit> r4 = this.d.J0;
            if (r4 == null) goto L9;
            Unit r0 = (Unit) r4.invoke(Integer.valueOf(UIUtils.px2dip(r19.getContext(), this.d.Q)), Boolean.FALSE);
        L9:
            ECMallFeed r1 = this.d;
            if (r1.P == true) goto L12;
            r1.X = -1;
        L59:
            if ((!Intrinsics.areEqual((Boolean) this.d.C0.getValue(), Boolean.TRUE)) == false) goto L134;
            ECMallFeed r2 = this.d;
            int r5 = r2.D0 + r21;
            r2.D0 = r5;
            String r12 = "";
            if (Math.abs(r5) <= 130) goto L113;
            if (this.b == true) goto L113;
            this.b = true;
            ReportAbility r6 = this.d.j0;
            LinkedHashMap r7 = new LinkedHashMap();
            r7.put("eventName", "ecom_page_slide");
            LinkedHashMap r13 = new LinkedHashMap();
            long r14 = System.currentTimeMillis();
            DataEngineWrapper r8 = this.d.C1;
            if (r8 == null) goto L71;
            y93.a r9 = r8.b;
            if (r9 == null) goto L71;
            Long r10 = r9.q();
            if (r10 == null) goto L71;
            long r16 = r10.longValue();
        L72:
            r13.put("timestamp", Long.valueOf(r14 - r16));
            r13.put("sliding_distance", Integer.valueOf(Math.abs(this.d.D0)));
            r13.put("request_id", this.d.V.v);
            r13.put("user_id", com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().getCurrentUserId());
            if (r21 <= 0) goto L75;
            String r11 = "down";
        L76:
            r13.put("slide_direction", r11);
            Lazy r15 = HybridAppInfoService.a;
            if (HybridAppInfoService.n() == false) goto L79;
        L80:
            ECMallFeed r17 = this.d;
            ECMallFavoriteSectionHelper r18 = r17.V;
            ECHybridListEngine r22 = r17.J;
            r18.getClass();
            if (r22 == null) goto L108;
            DataResolver r23 = (DataResolver) r22.getAbility(DataResolver.class);
            if (r23 == null) goto L108;
            List r24 = r23.j();
            if (r24 == null) goto L108;
            ArrayList r25 = (ArrayList) r24;
            Iterator r110 = r25.subList(0, Math.min(4, r25.size())).iterator();
        L89:
            if (r110.hasNext() == false) goto L108;
            String r26 = ((ECHybridListItemVO) r110.next()).g();     // Catch: JSONException -> L106
            if (r26 != null) goto L94;
            r26 = "";
        L94:
            JSONObject r27 = new JSONObject(r26).optJSONObject("product");     // Catch: JSONException -> L106
            if (r27 == null) goto L97;
            String r28 = r27.optString("recommend_info");     // Catch: JSONException -> L106
        L98:
            if (r28 != null) goto L100;
        L103:
            boolean r111 = true;
        L104:
            if (r111 == true) goto L89;
        L109:
            if (r28 == null) goto L111;
            r13.put("recommend_info", r28);
        L111:
            r7.put("params", r13);
            r7.put("btm", "c0.d0");
            Unit r29 = Unit.INSTANCE;
            k93.g.a.a(r6, r7, null, null, 14);
            goto L113
        L100:
            if (StringsKt.isBlank(r28) == true) goto L103;
            r111 = false;
            goto L104
        L97:
            r28 = null;
        L106:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
        L108:
            r28 = null;
            goto L109
        L79:
            if (((Boolean) HybridAppInfoService.j.getValue()).booleanValue() == false) goto L111;
        L75:
            r11 = "up";
        L71:
            r16 = 0;
        L113:
            if (((Boolean) this.d.B.getValue()).booleanValue() == false) goto L134;
            if (this.c == true) goto L134;
            ECMallFeed r30 = this.d;
            int r31 = r30.D0;
            int r32 = ((Number) r30.A.getValue()).intValue();
            if (1 > r32) goto L134;
            if (r31 <= r32) goto L134;
            this.c = true;
            ReportAbility r33 = this.d.j0;
            LinkedHashMap r34 = new LinkedHashMap();
            r34.put("eventName", "ecom_mall_gyl_slide");
            LinkedHashMap r35 = new LinkedHashMap();
            Object r36 = this.d.A1.getGlobalProps().get("traffic_from");
            if ((r36 instanceof String) == true) goto L123;
            r36 = null;
        L123:
            String r37 = (String) r36;
            if (r37 != null) goto L126;
            r37 = "";
        L126:
            r35.put("traffic_from", r37);
            Object r38 = this.d.A1.getGlobalProps().get("traffic_from_second");
            if ((r38 instanceof String) == true) goto L129;
            r38 = null;
        L129:
            String r39 = (String) r38;
            if (r39 == null) goto L133;
            r12 = r39;
        L133:
            r35.put("traffic_from_second", r12);
            r34.put("params", r35);
            r34.put("btm", "c0.d0");
            Unit r40 = Unit.INSTANCE;
            k93.g.a.a(r33, r34, null, null, 14);
        L134:
            ECMallFeed r41 = this.d;
            com.bytedance.android.shopping.mall.feed.help.r r42 = r41.o1;
            if (r42 == null) goto L156;
            int r43 = r41.Q;
            r42.e = r43;
            if (r42.a == false) goto L139;
            r42.a = false;
            r42.c = Long.valueOf(System.currentTimeMillis());
            r42.b = r43;
        L139:
            Long r44 = r42.c;
            if (r44 != null) goto L142;
            return;
        L142:
            if ((System.currentTimeMillis() - r44.longValue()) <= 250) goto L158;
            r42.c = null;
            r42.d = r43 - r42.b;
            return;
        L158:
            return;
        L156:
            return;
        L12:
            if (r1.x == true) goto L20;
            ECHybridListEngine r45 = r1.J;
            if (r45 == null) goto L52;
            ECHybridRecyclerView r46 = r45.b;
            if (r46 == null) goto L52;
            if (r46.canScrollVertically(1) == true) goto L52;
        L47:
            boolean r47 = true;
        L53:
            if (r47 == false) goto L59;
            ECMallFeed r48 = this.d;
            if (r48.X >= 0) goto L59;
            r48.X = System.currentTimeMillis();
        L52:
            r47 = false;
            goto L53
        L20:
            ECHybridListEngine r49 = r1.J;
            if (r49 == null) goto L27;
            ECHybridRecyclerView r50 = r49.b;
            if (r50 == null) goto L27;
            if (r50.canScrollVertically(1) == false) goto L47;
        L27:
            ECHybridListEngine r51 = r1.J;
            if (r51 == null) goto L52;
            ECHybridRecyclerView r52 = r51.b;
            if (r52 == null) goto L52;
            int r53 = r52.getChildCount() - 1;
            int r54 = 0;
        L32:
            if (r53 < 0) goto L52;
            View r112 = r52.getChildAt(r53);
            RecyclerView.ViewHolder r113 = r52.getChildViewHolder(r112);
            if ((r113 instanceof BaseViewHolder) == true) goto L36;
            r113 = null;
        L36:
            BaseViewHolder r114 = (BaseViewHolder) r113;
            if (r54 > 1) goto L49;
            if (r114 == null) goto L42;
            ECHybridListItemVO r115 = r114.c;
            if (r115 == null) goto L42;
            String r116 = r115.r;
        L44:
            if (Intrinsics.areEqual(r116, "favorite_section") == false) goto L49;
            r54 = r54 + 1;
            if (r112.getBottom() >= r52.getBottom()) goto L49;
        L42:
            r116 = null;
        L49:
            if (r54 == 2) goto L52;
            r53 = r53 - 1;
            goto L32
        L5:
            this.d.Q += r21;
            goto L6
        }
    }

    public final class a {
        public final ECHybridListEngine.a a;
        public final /* synthetic */ ECMallFeed b;

        public a(ECMallFeed r2, ECHybridListEngine.a r3) {
            Intrinsics.checkNotNullParameter(r3, "listEngineBuilder");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class a0 implements View.OnTouchListener {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    public interface b {
        void a(String r1, boolean r2, boolean r3);

        void b(String r1, boolean r2);
    }

    public interface c {
        void a();
    }

    public static final class d {
    }

    public static final class e {
        public static final /* synthetic */ int D = 0;
        public final com.bytedance.android.shopping.api.mall.feed.i A;
        public final Map<String, Object> B;
        public final boolean C;
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public Map<String, String> e;
        public final String f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final Integer k;
        public final boolean l;
        public final boolean m;
        public final int n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final int r;
        public final Integer s;
        public Long t;
        public final int u;
        public final long v;
        public final long w;
        public final String x;
        public final ListEngineOptConfig y;
        public final com.bytedance.android.ec.hybrid.list.e z;

        public static final class a {
        }

        static {
        }

        public e(String r7, String r8, String r9, String r10, Map r11, String r12, boolean r13, boolean r14, boolean r15, Integer r16, boolean r17, boolean r18, int r19, boolean r20, boolean r21, boolean r22, int r23, Integer r24, Long r25, int r26, long r27, long r29, String r31, ListEngineOptConfig r32, com.bytedance.android.ec.hybrid.list.e r33, com.bytedance.android.shopping.api.mall.feed.i r34, ECMallFeedStickyConfig r35, Map r36, boolean r37) {
            Intrinsics.checkNotNullParameter(r7, "sceneId");
            Intrinsics.checkNotNullParameter(r9, "hostPageName");
            Intrinsics.checkNotNullParameter(r10, "lynxConsumerBid");
            Intrinsics.checkNotNullParameter(r11, "lynxConsumerMonitor");
            this.a = r7;
            this.b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.g = false;
            this.h = r13;
            this.i = r14;
            this.j = r15;
            this.k = r16;
            this.l = r17;
            this.m = r18;
            this.n = r19;
            this.o = r20;
            this.p = r21;
            this.q = r22;
            this.r = r23;
            this.s = r24;
            this.t = r25;
            this.u = r26;
            this.v = r27;
            this.w = r29;
            this.x = r31;
            this.y = r32;
            this.z = r33;
            this.A = r34;
            this.B = r36;
            this.C = r37;
        }
    }

    public interface f extends com.bytedance.android.shopping.api.mall.feed.e {
        String AH(String r1, boolean r2);

        void BQ(Boolean r1);

        com.bytedance.android.shopping.api.mall.idl.a Bi();

        mf3.a DE();

        Map<String, Object> EA();

        void Hn(String r1);

        void Hv();

        boolean JQ();

        void Jb();

        Fragment M();

        void MT();

        PageFinder N90(ECHybridRecyclerView r1);

        void P60(int r1);

        AnchorPendantManager Pt();

        boolean Q20();

        void Q30(String r1, Map<String, ? extends Object> r2);

        void R60(String r1, String r2, Function0<Unit> r3, Function1<? super String, Unit> r4);

        String T80(Map<String, ? extends Object> r1);

        com.bytedance.android.shopping.mall.feed.help.q TN();

        void VI();

        void Vw(com.bytedance.android.shopping.mall.feed.help.g r1);

        void Wr();

        void YA();

        String ZJ();

        String ZK(String r1, boolean r2, BcmParams r3);

        void adReport(String r1, String r2, String r3, String r4, String r5, Map<String, ? extends Object> r6, String r7, String r8);

        void adThirdTrackReport(String r1, List<String> r2, Long r3, String r4, JSONObject r5);

        void ap();

        Map<String, Object> bI(Map<String, ? extends Object> r1, boolean r2);

        com.bytedance.android.ec.hybrid.list.ability.c0 bX();

        void bp();

        void closePage();

        ViewGroup ex();

        void fI();

        Map<String, Object> getPageInfo();

        void h10();

        boolean hu();

        boolean isAttached();

        jf3.e jF();

        void jO();

        boolean kn();

        void lx();

        boolean n10();

        Map<String, Object> oU();

        void rL(String r1, String r2, String r3, Function0 r4, Function1 r5);

        void u90(String r1);

        View yZ(String r1, String r2);

        Map<String, String> zH();
    }

    public interface g {
        void a(String r1);
    }

    public final class h extends ECRoundedFrameLayout implements com.bytedance.android.ec.hybrid.ui.i {
        public h(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4, null, 6, 0);
        }
    }

    public final class i {
        public View a;
        public View b;
        public View c;
        public final /* synthetic */ ECMallFeed d;

        public final void a(boolean r4) {
            View r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            Lazy r1 = HybridAppInfoService.a;
            boolean r2 = HybridAppInfoService.l();
            if (r4 == true) goto L14;
            r0.setVisibility(8);
            if (r2 == false) goto L52;
            ViewGroup.LayoutParams r5 = r0.getLayoutParams();
            if (r5 == null) goto L12;
            int r3 = com.bytedance.android.ec.hybrid.list.util.c.a;
            r5.height = com.bytedance.android.ec.hybrid.list.util.c.d(10);
        L12:
            r0.requestLayout();
            return;
        L52:
            return;
        L14:
            if (r2 == false) goto L20;
            ViewGroup.LayoutParams r6 = r0.getLayoutParams();
            if (r6 == null) goto L18;
            r6.height = -2;
        L18:
            r0.requestLayout();
        L20:
            if (this.d.N == false) goto L35;
            r0.setVisibility(0);
            View r7 = this.b;
            if (r7 == null) goto L24;
            r7.setVisibility(0);
        L24:
            View r8 = this.b;
            if (r8 == null) goto L32;
            List<View> r9 = com.bytedance.android.shopping.api.mall.common.tools.b0.b(r8);
            if (r9 == null) goto L32;
            Iterator<T> r10 = r9.iterator();
        L30:
            if (r10.hasNext() == false) goto L32;
            ((View) r10.next()).setVisibility(0);
        L32:
            View r11 = this.c;
            if (r11 == null) goto L49;
            r11.setVisibility(8);
            return;
        L49:
            return;
        L35:
            r0.setVisibility(0);
            View r12 = this.b;
            if (r12 == null) goto L38;
            r12.setVisibility(8);
        L38:
            View r13 = this.c;
            if (r13 == null) goto L41;
            r13.setVisibility(0);
        L41:
            View r14 = this.c;
            if (r14 == null) goto L54;
            List<View> r15 = com.bytedance.android.shopping.api.mall.common.tools.b0.b(r14);
            if (r15 == null) goto L55;
            Iterator<T> r16 = r15.iterator();
        L47:
            if (r16.hasNext() == false) goto L56;
            ((View) r16.next()).setVisibility(0);
            goto L47
        L56:
            return;
        L55:
            return;
        }

        public i(ECMallFeed r10, Context r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            this.d = r10;
            yj.e r0 = r10.A1.Pn();
            View r5 = null;
            if (r0 == null) goto L6;
            ECLoadMoreView r6 = r0.b();
            if (r6 == null) goto L6;
        L9:
            this.b = r6;
            if (r0 == null) goto L12;
            r0.a();
        L12:
            View r1 = LayoutInflater.from(r11).inflate(2131564671, null, false);
            int r7 = com.bytedance.android.ec.hybrid.list.util.c.a;
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(56)));
            if (r10.A1.isDarkMode() == false) goto L15;
            ((TextView) r1.findViewById(2131368759)).setTextColor(r11.getResources().getColor(2131106120));
        L15:
            this.c = r1;
            View r12 = LayoutInflater.from(r11).inflate(2131564669, null, false);
            this.a = r12;
            if ((r12 instanceof FrameLayout) == true) goto L18;
            r12 = null;
        L18:
            FrameLayout r13 = (FrameLayout) r12;
            if (r13 == null) goto L21;
            r13.addView(this.b);
        L21:
            View r14 = this.a;
            if ((r14 instanceof FrameLayout) == false) goto L25;
            r5 = r14;
        L25:
            FrameLayout r8 = (FrameLayout) r5;
            if (r8 == null) goto L28;
            r8.addView(this.c);
        L28:
            View r15 = this.a;
            if (r15 == null) goto L31;
            r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        L31:
            View r16 = this.a;
            if (r16 == null) goto L35;
            r16.setVisibility(8);
            return;
        L35:
            return;
        L6:
            r6 = LayoutInflater.from(r11).inflate(2131564670, null, false);
            int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(56)));
            if (r10.A1.isDarkMode() == false) goto L9;
            ((TextView) r6.findViewById(2131368754)).setTextColor(r11.getResources().getColor(2131106120));
            goto L9
        }
    }

    public final class j extends k {
        public final String c;
        public final int d;
        public final String e;
        public final boolean f;
        public final Function0<Unit> g;
        public final /* synthetic */ ECMallFeed h;

        public final void g(boolean r13) {
            if (this.f == true) goto L6;
            return;
        L6:
            if (this.h.A1.n10() == false) goto L15;
            com.bytedance.android.shopping.api.mall.idl.a r0 = this.h.A1.Bi();
            if (r0 == null) goto L13;
            com.bytedance.android.shopping.api.mall.idl.c r1 = r0.a;
            if (r1 == null) goto L13;
            if (r1.m == true) goto L15;
        L13:
            int r2 = com.bytedance.android.shopping.mall.feed.help.e.a;
            com.bytedance.android.shopping.mall.feed.help.e.a(r13, "block_instant", this.e, this.h.B1.c);
            return;
        L15:
            int r3 = com.bytedance.android.shopping.mall.feed.help.e.a;
            if (r13 == true) goto L18;
            String r4 = "net_error";
        L19:
            com.bytedance.android.shopping.mall.feed.help.e.a(r13, r4, this.e, this.h.B1.c);
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b(this.c, System.currentTimeMillis(), this.h.B(), false, MapsKt.mapOf(TuplesKt.to("action", this.e)), false, 32));
            return;
        L18:
            r4 = null;
            goto L19
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void a(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            Intrinsics.checkNotNullParameter(r3, "t");
            g(false);
            Function0<Unit> r4 = this.g;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }

        public j(ECMallFeed r2, String r3, Function0 r4) {
            Intrinsics.checkNotNullParameter(r3, "lastActionInfo");
            this.h = r2;
            super(r2, GYLFetchType.FETCH_BY_USER_BEHAVIOR);
            this.e = r3;
            this.f = true;
            this.g = r4;
            this.c = "ec.allowInstantFetch";
            Lazy r5 = MallOptUtil.a;
            this.d = MallOptUtil.g(r2.B1.c, 1);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.k
        public final void b(String r3, String r4, ECHybridNetworkVO r5) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            Intrinsics.checkNotNullParameter(r4, "result");
            Intrinsics.checkNotNullParameter(r5, "requestVO");
            if (Intrinsics.areEqual(r3, "favorite_feed") == false) goto L9;
            this.h.I(r4, null, r5, GYLFetchType.FETCH_BY_USER_BEHAVIOR);
            g(true);
            Function0<Unit> r6 = this.g;
            if (r6 == null) goto L7;
            Unit r7 = (Unit) r6.invoke();
        L7:
            this.h.U(this.d);
            return;
        }
    }

    public abstract class k implements ECHybridNetworkTask.a {
        public final String a;
        public final /* synthetic */ ECMallFeed b;

        public abstract void a(String r1, Throwable r2);

        public abstract void b(String r1, String r2, ECHybridNetworkVO r3);

        public k(ECMallFeed r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "fetchType");
            this.b = r2;
            this.a = r3;
        }

        public void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
        }

        public void d(String r2, String r3, ECHybridNetworkVO r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            Intrinsics.checkNotNullParameter(r3, "result");
            Intrinsics.checkNotNullParameter(r4, "requestVO");
            if (this.b.A1.isAttached() == true) goto L5;
            return;
        L5:
            b(r2, r3, r4);
            if (Intrinsics.areEqual(r2, "favorite_feed") == true) goto L8;
            com.bytedance.android.shopping.mall.feed.help.j r6 = this.b.e;
            if (r6 == null) goto L21;
            r6.d(this.a, true, r2, r3);
        L21:
            this.b.S(r2, r3, null);
            Lazy r7 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "guess you like success api key: ".concat(r2));
            return;
        L8:
            if (this.b.x() == false) goto L10;
        L13:
            ECMallFeed r8 = this.b;
            r8.i.removeCallbacks(r8.u1);
        L14:
            ECMallFeed r9 = this.b;
            i r0 = r9.Y;
            if (r0 == null) goto L17;
            r0.a(!r9.N);
        L17:
            this.b.q0();
            goto L21
        L10:
            if (this.b.v() != null) goto L13;
            if (this.b.z() == false) goto L14;
            goto L13
        }

        public final void e(String r5, Throwable r6, ECHybridNetworkVO r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r5, "apiKey");
            Intrinsics.checkNotNullParameter(r6, "t");
            ECMallFeed r0 = this.b;
            int r1 = ECMallFeed.I1;
            if (r0.x() == false) goto L5;
        L8:
            ECMallFeed r2 = this.b;
            r2.i.removeCallbacks(r2.u1);
        L10:
            if (this.b.A1.isAttached() == true) goto L12;
            return;
        L12:
            Map r3 = null;
            if (Intrinsics.areEqual(r5, "favorite_feed") == false) goto L20;
            this.b.q0();
            i r4 = this.b.Y;
            if (r4 == null) goto L17;
            r4.a(false);
        L17:
            com.bytedance.android.shopping.mall.feed.help.j r9 = this.b.e;
            if (r9 == null) goto L23;
            r9.f(this.a, false, null, null);
        L23:
            a(r5, r6);
            Lazy r10 = ECMallLogUtil.a;
            ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "loadMoreFetch error api key: " + r5 + ", error: " + r6.getMessage());
            if (r7 == null) goto L26;
            Map r11 = r7.b();
        L27:
            if (r7 == null) goto L29;
            r3 = r7.a();
        L29:
            Intrinsics.checkNotNullParameter(r5, "apiKey");
            Intrinsics.checkNotNullParameter("fetch guess you like failed", "prefix");
            com.bytedance.android.ec.hybrid.a.i(new com.bytedance.android.ec.hybrid.log.mall.i(r11, r3, "fetch guess you like failed", r5));
            return;
        L26:
            r11 = null;
            goto L27
        L20:
            com.bytedance.android.shopping.mall.feed.help.j r12 = this.b.e;
            if (r12 == null) goto L23;
            r12.d(this.a, false, r5, null);
            goto L23
        L5:
            if (this.b.v() != null) goto L8;
            if (this.b.z() == false) goto L10;
            goto L8
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public final class l {
        public final List<Pair<String, com.bytedance.android.ec.hybrid.card.event.e>> a;
        public WeakReference<Context> b;
        public final /* synthetic */ ECMallFeed c;

        public l(ECMallFeed r1) {
            this.c = r1;
            this.a = new ArrayList();
        }
    }

    public interface m {
        void a(com.bytedance.android.ec.hybrid.list.util.d r1);
    }

    public final class n {
        public final /* synthetic */ ECMallFeed a;

        public n(ECMallFeed r1) {
            this.a = r1;
        }

        public static final Pair a(n r5, int r6, ViewGroup r7, String r8) {
            ListEngineOptConfig r0 = r5.a.B1.y;
            if (r0 == null) goto L25;
            Set r1 = r0.k;
            if (r1 == null) goto L25;
            if (r1.contains(r8) != true) goto L25;
            Object r9 = com.bytedance.android.shopping.mall.homepage.opt.i.b;
            monitor-enter(r9);
            Map<Integer, List<View>> r2 = com.bytedance.android.shopping.mall.homepage.opt.i.a;     // Catch: Throwable -> L21
            LinkedHashMap r3 = (LinkedHashMap) r2;     // Catch: Throwable -> L21
            List r4 = (List) r3.get(Integer.valueOf(r6));     // Catch: Throwable -> L21
            Object r10 = null;
            if (r4 != null) goto L13;
        L17:
            monitor-exit(r9);
            if (r10 == null) goto L20;
            com.bytedance.android.shopping.mall.homepage.opt.a.C0105a r11 = com.bytedance.android.shopping.mall.homepage.opt.a.d;
            String r12 = r5.a.B();
            r11.getClass();
            com.bytedance.android.shopping.mall.homepage.opt.a r13 = com.bytedance.android.shopping.mall.homepage.opt.a.C0105a.a(r12);
            r13.a(r13.a, 1);
            return TuplesKt.to(r10, Boolean.TRUE);
        L20:
            com.bytedance.android.shopping.mall.homepage.opt.a.C0105a r14 = com.bytedance.android.shopping.mall.homepage.opt.a.d;
            String r15 = r5.a.B();
            r14.getClass();
            com.bytedance.android.shopping.mall.homepage.opt.a r16 = com.bytedance.android.shopping.mall.homepage.opt.a.C0105a.a(r15);
            r16.a(r16.a, 0);
            goto L25
        L13:
            if (r4.isEmpty() == true) goto L16;
            r10 = ListProtector.remove(r4, 0);     // Catch: Throwable -> L21
        L16:
            r10 = (View) r10;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            throw th;
        L25:
            return TuplesKt.to(LayoutInflater.from(r7.getContext()).inflate(r6, r7, false), Boolean.FALSE);
        }
    }

    public final class o implements com.bytedance.android.ec.hybrid.data.g {
        public final /* synthetic */ ECMallFeed a;

        public final /* synthetic */ void g(Map r1, String r2) {
        }

        public o(ECMallFeed r1) {
            this.a = r1;
        }

        public final Map<String, Object> a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            HashMap r0 = new HashMap();
            r0.putAll(ECMallFeed.o(this.a));
            i(r0, r3);
            return r0;
        }

        public final Map<String, Object> c(List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "keys");
            return new StorageItemDataProvider(this.a.e0()).a(r3);
        }

        public final Map<String, String> d(String r4) {
            Intrinsics.checkNotNullParameter(r4, "apiKey");
            LinkedHashMap r0 = new LinkedHashMap();
            ECMallFeed r1 = this.a;
            Map<String, String> r5 = r1.A1.Xj(r4, r1.M);
            if (r5 == null) goto L5;
            r0.putAll(r5);
        L5:
            return r0;
        }

        public final Map<String, Object> e(String r13, String r14) {
            Intrinsics.checkNotNullParameter(r13, "tabId");
            Intrinsics.checkNotNullParameter(r14, "apiKey");
            int r8 = this.a.V.q(CastIntegerProtector.parseInt(r13));
            int r7 = this.a.V.m(CastIntegerProtector.parseInt(r13));
            List<com.bytedance.android.shopping.api.mall.common.tools.d> r2 = this.a.V.s();
            if (r2 == null) goto L17;
            Iterator<T> r3 = r2.iterator();
        L6:
            if (r3.hasNext() == false) goto L13;
            Object r5 = r3.next();
            if (((com.bytedance.android.shopping.api.mall.common.tools.d) r5).a != CastIntegerProtector.parseInt(r13)) goto L10;
            boolean r6 = true;
        L11:
            if (r6 == false) goto L6;
        L14:
            com.bytedance.android.shopping.api.mall.common.tools.d r9 = (com.bytedance.android.shopping.api.mall.common.tools.d) r5;
            if (r9 == null) goto L17;
            String r10 = r9.b;
        L18:
            List<com.bytedance.android.shopping.api.mall.common.tools.d> r4 = this.a.V.s();
            if (r4 == null) goto L32;
            Iterator<com.bytedance.android.shopping.api.mall.common.tools.d> r11 = r4.iterator();
            int r12 = 0;
        L22:
            if (r11.hasNext() == false) goto L30;
            if (r11.next().a != CastIntegerProtector.parseInt(r13)) goto L26;
            boolean r15 = true;
        L27:
            if (r15 == true) goto L31;
            r12 = r12 + 1;
        L31:
            Integer r16 = Integer.valueOf(r12);
        L33:
            com.bytedance.android.shopping.mall.homepage.pagecard.d r17 = this.a.G1;
            if (r17 == null) goto L47;
            com.bytedance.android.shopping.mall.homepage.pagecard.c r18 = r17.a();
            if (r18 == null) goto L47;
            ECMallFeed r19 = this.a;
            Integer r20 = Integer.valueOf(CastIntegerProtector.parseInt(r13));
            if (r16 != null) goto L40;
        L42:
            r16 = null;
        L43:
            Map<String, ? extends Object> r21 = r19.n(r20, r10, r7, r8, r16);
            Intrinsics.checkNotNullParameter(r13, "tabId");
            Intrinsics.checkNotNullParameter(r14, "apiKey");
            Intrinsics.checkNotNullParameter(r21, "paramsContext");
            PageCard r22 = r18.a;
            r22.getClass();
            Intrinsics.checkNotNullParameter(r13, "tabID");
            Intrinsics.checkNotNullParameter(r14, "apiKey");
            Intrinsics.checkNotNullParameter(r21, "paramsContext");
            if (r22.a() == false) goto L46;
            r22.m.b.setTPullDynamicParamsStart(Long.valueOf(System.currentTimeMillis()));
            Map<String, Object> r0 = ((com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r22.f.getValue()).a(r13, r14, r21);
            r22.m.a(true, true);
        L48:
            Map<String, Object> r1 = MapsKt.toMutableMap(r0);
            h(r14, r1, StringsKt.toIntOrNull(r13));
            return r1;
        L46:
            r0 = ((DynamicParamsController) r22.d.getValue()).a(r13, r14, r21);
            goto L48
        L40:
            if (r16.intValue() < 0) goto L42;
        L47:
            r0 = new HashMap();
            goto L48
        L26:
            r15 = false;
            goto L27
        L30:
            r12 = -1;
            goto L31
        L32:
            r16 = null;
            goto L33
        L10:
            r6 = false;
            goto L11
        L13:
            r5 = null;
        L17:
            r10 = null;
            goto L18
        }

        public final Map<String, Object> f(String r5, Map<String, Object> r6) {
            Intrinsics.checkNotNullParameter(r5, "apiKey");
            Intrinsics.checkNotNullParameter(r6, "extraParams");
            com.bytedance.android.shopping.mall.homepage.pagecard.d r0 = this.a.G1;
            if (r0 == null) goto L8;
            com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = r0.a();
            if (r1 == null) goto L8;
            Map<String, Object> r2 = r1.d(r5, r6);
            if (r2 == null) goto L8;
        L9:
            Map<String, Object> r3 = MapsKt.toMutableMap(r2);
            Object r4 = r6.get("tab_id");
            if ((r4 instanceof Integer) == true) goto L12;
            r4 = null;
        L12:
            Integer r7 = (Integer) r4;
            if (r7 != null) goto L15;
        L20:
            String r8 = this.a.V.u;
            if (r8 == null) goto L23;
            r3.put("post_back", r8);
        L23:
            h(r5, r3, r7);
            if (r6.containsKey("is_load_more") == true) goto L32;
            Integer r9 = StringsKt.toIntOrNull(String.valueOf(r6.get("page_num")));
            if (r9 == null) goto L28;
            int r10 = r9.intValue();
        L30:
            if (r10 > 1) goto L32;
        L49:
            return r3;
        L28:
            r10 = 0;
        L32:
            if (r6.containsKey("wysiwyg_items") == false) goto L35;
            r3.put("wysiwyg_items", "");
        L35:
            if (r6.containsKey("wysiwyg_position") == false) goto L38;
            r3.put("wysiwyg_position", 0);
        L38:
            if (r6.containsKey("wysiwyg_scene_id") == false) goto L41;
            r3.put("wysiwyg_scene_id", "");
        L41:
            if (r6.containsKey("wysiwyg_block_name") == false) goto L44;
            r3.put("wysiwyg_block_name", "");
        L44:
            if (r6.containsKey("multi_wysiwyg") == false) goto L47;
            r3.put("multi_wysiwyg", "");
        L47:
            if (r6.containsKey("landing_tab_redirect") == false) goto L49;
            r3.put("landing_tab_redirect", Boolean.FALSE);
            goto L49
        L15:
            if (r7.intValue() != 0) goto L23;
            if (Intrinsics.areEqual(r5, "favorite_feed") == false) goto L23;
            int r11 = com.bytedance.forest.utils.h.a;
            if (com.bytedance.forest.utils.h.a(this.a.V.u) == false) goto L23;
        L8:
            r2 = new HashMap();
            goto L9
        }

        public final void i(Map<String, Object> r7, String r8) {
            if (Intrinsics.areEqual(r8, "homepage") == false) goto L10;
            HashMap r1 = (HashMap) r7;
            if (r1.containsKey("cursor") == false) goto L10;
            if (((Boolean) MallNetApplier.b.getValue()).booleanValue() == false) goto L9;
            r1.put("page_num", "1");
        L9:
            r1.put("cursor", "0");
        L10:
            Lazy r2 = HybridAppInfoService.a;
            if (HybridAppInfoService.i() == false) goto L18;
            if (Intrinsics.areEqual(r8, "homepage") == false) goto L18;
            Object r3 = this.a.A1.getGlobalProps().get("ecom_scene_id");
            if (r3 == null) goto L18;
            ((HashMap) r7).put("ecom_scene_id", r3);
        L18:
            if (Intrinsics.areEqual(r8, "homepage") == false) goto L20;
        L25:
            DataEngineWrapper r0 = this.a.C1;
            Object r4 = null;
            if (r0 == null) goto L28;
            String r5 = r0.d();
        L29:
            boolean r6 = false;
            if (r5 != null) goto L32;
        L35:
            boolean r9 = true;
        L37:
            if (r9 == false) goto L52;
            IECMallAddressService r10 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
            if (r10 == null) goto L53;
            String r11 = r10.getAddress(this.a.z1, null);
            if (r11 == null) goto L53;
            if (r11.length() <= 0) goto L45;
            r6 = true;
        L45:
            if (r6 == true) goto L48;
            r11 = null;
        L48:
            if (r11 == null) goto L53;
            ((HashMap) r7).put("ec_address_data", r11);
            DataEngineWrapper r12 = this.a.C1;
            if (r12 == null) goto L53;
            r12.r = r11;
        L53:
            Integer r13 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getLocationPermissionParam();
            if (r13 != null) goto L80;
        L68:
            ECMallFeed.g(this.a, r7);
            if (Intrinsics.areEqual(r8, "common_impression") == false) goto L73;
            Map<String, ? extends Object> r14 = this.a.b1;
            if (r14 == null) goto L73;
            ((HashMap) r7).put("biz_identity", r14);
        L73:
            ECMallFavoriteSectionHelper.K.getClass();
            if (Intrinsics.areEqual(ECMallFavoriteSectionHelper.a.a().a(), Boolean.TRUE) == false) goto L76;
            ((HashMap) r7).put("is_active_refresh", Boolean.valueOf(this.a.A1.oi()));
        L76:
            Integer r15 = this.a.p1.a;
            if (r15 == null) goto L82;
            ((HashMap) r7).put("ecom_refresh_type", Integer.valueOf(r15.intValue()));
            return;
        L82:
            return;
        L80:
            int r16 = r13.intValue();     // Catch: Throwable -> L67
            Object r17 = this.a.e0().getSystemService("location");     // Catch: Throwable -> L67
            if ((r17 instanceof LocationManager) == false) goto L59;
            r4 = r17;
        L59:
            LocationManager r18 = (LocationManager) r4;     // Catch: Throwable -> L67
            if (r18 != null) goto L62;
        L64:
            String r19 = "2";
        L65:
            ((HashMap) r7).put("webcast_gps_access", r19);     // Catch: Throwable -> L67
            goto L68
        L62:
            if (r18.isProviderEnabled("gps") != true) goto L64;
            r19 = String.valueOf(r16);     // Catch: Throwable -> L67
            goto L65
        L52:
            ((HashMap) r7).put("ec_address_data", r5);
            goto L53
        L32:
            if (r5.length() == 0) goto L35;
            r9 = false;
            goto L37
        L28:
            r5 = null;
            goto L29
        L20:
            if (Intrinsics.areEqual(r8, "favorite_feed") == true) goto L25;
            if (Intrinsics.areEqual(r8, "popup_get") == true) goto L25;
            if (Intrinsics.areEqual(r8, "homepage_refresh") == false) goto L68;
            goto L25
        }

        public final Map<String, Object> b(String r13, String r14, Map<String, Object> r15) {
            Intrinsics.checkNotNullParameter(r13, "tabId");
            Intrinsics.checkNotNullParameter(r14, "apiKey");
            if (r15 != null) goto L5;
        L11:
            int r3 = this.a.V.q(CastIntegerProtector.parseInt(r13));
        L12:
            int r8 = r3;
            if (r15 != null) goto L15;
        L21:
            int r0 = this.a.V.m(CastIntegerProtector.parseInt(r13));
        L22:
            int r7 = r0;
            List<com.bytedance.android.shopping.api.mall.common.tools.d> r1 = this.a.V.s();
            if (r1 == null) goto L37;
            Iterator<T> r2 = r1.iterator();
        L26:
            if (r2.hasNext() == false) goto L33;
            Object r6 = r2.next();
            if (((com.bytedance.android.shopping.api.mall.common.tools.d) r6).a != CastIntegerProtector.parseInt(r13)) goto L30;
            boolean r9 = true;
        L31:
            if (r9 == false) goto L26;
        L34:
            com.bytedance.android.shopping.api.mall.common.tools.d r10 = (com.bytedance.android.shopping.api.mall.common.tools.d) r6;
            if (r10 == null) goto L37;
            String r11 = r10.b;
        L38:
            List<com.bytedance.android.shopping.api.mall.common.tools.d> r4 = this.a.V.s();
            if (r4 == null) goto L52;
            Iterator<com.bytedance.android.shopping.api.mall.common.tools.d> r5 = r4.iterator();
            int r12 = 0;
        L42:
            if (r5.hasNext() == false) goto L50;
            if (r5.next().a != CastIntegerProtector.parseInt(r13)) goto L46;
            boolean r16 = true;
        L47:
            if (r16 == true) goto L51;
            r12 = r12 + 1;
        L51:
            Integer r17 = Integer.valueOf(r12);
        L53:
            HashMap r18 = new HashMap();
            if (r15 == null) goto L65;
            Set<String> r19 = r15.keySet();
            if (r19 == null) goto L65;
            Iterator<T> r20 = r19.iterator();
        L59:
            if (r20.hasNext() == false) goto L65;
            String r21 = (String) r20.next();
            if ((!Intrinsics.areEqual(r21, "cursor")) == false) goto L59;
            if ((!Intrinsics.areEqual(r21, "page_num")) == false) goto L59;
            r18.put(r21, r15.get(r21));
        L65:
            ECMallFeed r22 = this.a;
            Integer r110 = Integer.valueOf(CastIntegerProtector.parseInt(r13));
            if (r17 != null) goto L68;
        L70:
            Integer r23 = null;
        L71:
            r18.putAll(r22.n(r110, r11, r7, r8, r23));
            i(r18, r14);
            return r18;
        L68:
            if (r17.intValue() < 0) goto L70;
            r23 = r17;
            goto L71
        L46:
            r16 = false;
            goto L47
        L50:
            r12 = -1;
            goto L51
        L52:
            r17 = null;
            goto L53
        L30:
            r9 = false;
            goto L31
        L33:
            r6 = null;
        L37:
            r11 = null;
            goto L38
        L15:
            if (r15.containsKey("cursor") != true) goto L21;
            Object r24 = r15.get("cursor");
            if (r24 == null) goto L20;
            r0 = ((Integer) r24).intValue();
            goto L22
        L20:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L5:
            if (r15.containsKey("page_num") != true) goto L11;
            Object r25 = r15.get("page_num");
            if (r25 == null) goto L10;
            r3 = ((Integer) r25).intValue();
            goto L12
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public final void h(String r4, Map<String, Object> r5, Integer r6) {
            boolean r1 = false;
            if (Intrinsics.areEqual(r4, "favorite_feed") == true) goto L5;
        L61:
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L38
            IECMallHostService r8 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);     // Catch: Throwable -> L38
            if (r8 == null) goto L32;
            Map<String, Object> r9 = r8.getExtraRequestParams(r4);     // Catch: Throwable -> L38
            if (r9 == null) goto L32;
            Iterator<Map.Entry<String, Object>> r10 = r9.entrySet().iterator();     // Catch: Throwable -> L38
        L26:
            if (r10.hasNext() == false) goto L32;
            Map.Entry<String, Object> r0 = r10.next();     // Catch: Throwable -> L38
            String r2 = r0.getKey();     // Catch: Throwable -> L38
            Object r3 = r0.getValue();     // Catch: Throwable -> L38
            if (r3 != null) goto L30;
            r3 = "";
        L30:
            r5.put(r2, r3);     // Catch: Throwable -> L38
        L32:
            if (TextUtils.equals(this.a.B1.c, "order_homepage") == true) goto L34;
        L36:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
        L40:
            ECMallFeed r11 = this.a;
            Map<? extends String, ? extends Object> r12 = r11.A1.PN(r4, r11.M);
            if (r12 == null) goto L43;
            r5.putAll(r12);
        L43:
            ECMallFeed.g(this.a, r5);
            ECMallGulPrefetch r13 = this.a.v();
            if (r13 == null) goto L68;
            r93.b r14 = r13.f;
            if (r14 != null) goto L49;
            r14 = r13.b();
        L49:
            if (r14 == null) goto L69;
            v93.a.c.getClass();     // Catch: Throwable -> L57
            if (v93.a.b.length() != 0) goto L53;
            r1 = true;
        L53:
            if (r1 == false) goto L55;
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L57
            r15.putOpt("mall_recommend_common", tv5.a.a(new Gson(), r14));     // Catch: Throwable -> L57
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L57
            r5.put("pitaya_info", r15);     // Catch: Throwable -> L57
        L55:
            Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
        L59:
            Result.box-impl(r17);
            return;
        L57:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L59
        L69:
            return;
        L68:
            return;
        L34:
            if (Intrinsics.areEqual(r4, "homepage") == false) goto L36;
            this.a.A1.u90(r4);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L40
        L5:
            if (r6 != null) goto L7;
        L17:
            int r20 = this.a.u0.curNextPageCount();
            if (r20 <= 0) goto L61;
            r5.put("count", Integer.valueOf(r20));
            goto L61
        L7:
            if (r6.intValue() == 0) goto L17;
            Object r21 = ((HashMap) this.a.y.getValue()).get(String.valueOf(r6.intValue()));
            if ((r21 instanceof Number) == true) goto L11;
            r21 = null;
        L11:
            Number r22 = (Number) r21;
            if (r22 == null) goto L14;
            int r23 = r22.intValue();
        L15:
            if (r23 <= 0) goto L61;
            r5.put("count", Integer.valueOf(r23));
            goto L61
        L14:
            r23 = 0;
            goto L15
        }
    }

    public interface p {
        void a();
    }

    public final class q implements ECHybridListEngine.b {
        public final /* synthetic */ ECMallFeed a;

        public q(ECMallFeed r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "filter");
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            this.a.V.c(r3);
            Integer r1 = this.a.R;
            if (r1 == null) goto L12;
            r1.intValue();
            ECMallFeed r2 = this.a;
            r2.V.d(String.valueOf(r2.R), r3);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public final class r implements ECHybridListEngine.c {
        public final /* synthetic */ ECMallFeed a;

        public r(ECMallFeed r1) {
            this.a = r1;
        }

        public final void a(int r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "sectionId");
            if (r4 >= 0) goto L5;
            return;
        L5:
            ECMallFeed r0 = this.a;
            if (r6 == false) goto L8;
            String r1 = r5;
        L9:
            r0.H0 = r1;
            ECHybridListEngine r2 = r0.J;
            if (r2 == null) goto L16;
            com.bytedance.android.ec.hybrid.list.ability.n r3 = (com.bytedance.android.ec.hybrid.list.ability.n) r2.getAbility(com.bytedance.android.ec.hybrid.list.ability.n.class);
            if (r3 == null) goto L17;
            r3.kr("ec.headerStackChange", MapsKt.mapOf(new Pair[]{TuplesKt.to("sectionIndex", Integer.valueOf(r4)), TuplesKt.to("sectionID", r5), TuplesKt.to("isStickNow", Boolean.valueOf(r6))}));
            return;
        L17:
            return;
        L16:
            return;
        L8:
            r1 = null;
            goto L9
        }
    }

    public static final class s implements Runnable {
        public final /* synthetic */ ECMallFeed a;

        public s(ECMallFeed r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.L(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class t implements Runnable {
        public final /* synthetic */ ECMallFeed a;
        public final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.k b;
        public final /* synthetic */ ECHybridNetworkVO c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ ECHybridListDTO e;

        public t(ECMallFeed r1, com.bytedance.android.ec.hybrid.list.entity.k r2, ECHybridNetworkVO r3, Integer r4, ECHybridListDTO r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
            ECMallFeed r1 = this.a;     // Catch: Throwable -> L9
            if (r1.e0 == true) goto L7;
            ECHybridListEngine r2 = r1.J;     // Catch: Throwable -> L9
            if (r2 == null) goto L7;
            r2.c(this.b);     // Catch: Throwable -> L9
        L7:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            ECMallFeed r3 = this.a;
            ECHybridNetworkVO r4 = this.c;
            Integer r5 = this.d;
            com.bytedance.android.ec.hybrid.list.entity.k r6 = this.b;
            Map r7 = this.e.getExtra();
            if (r7 == null) goto L14;
            String r8 = (String) r7.get("address_info");
        L15:
            r3.d0(r4, r5, r6, r8);
            return;
        L14:
            r8 = null;
        L9:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
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

    public static final class u implements Runnable {
        public final /* synthetic */ ECMallFeed a;
        public final /* synthetic */ HomePageDTO b;

        public u(ECMallFeed r1, HomePageDTO r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ((MallRequestEndManager) this.a.x0.getValue()).a(this.a.e0(), this.b);
            com.bytedance.android.shopping.mall.feed.help.a r0 = (com.bytedance.android.shopping.mall.feed.help.a) this.a.l1.getValue();
            if (r0 == null) goto L11;
            ECHybridListEngine r1 = r0.c;
            if (r1 == null) goto L7;
            int r2 = r1.i();
        L9:
            if (r2 <= (r0.b + com.bytedance.android.shopping.mall.feed.help.a.e)) goto L11;
            r0.a();
            r0.b = r2;
            goto L11
        L7:
            r2 = 0;
        L11:
            Runnable r3 = this.a.x1;
            if (r3 == null) goto L14;
            r3.run();
        L14:
            ECMallFeed r4 = this.a;
            r4.x1 = null;
            ECMallFeed.e(r4);
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

    public static final class v implements Runnable {
        public final /* synthetic */ ECMallFeed a;

        public v(ECMallFeed r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECMallFeed.d(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class w extends com.bytedance.android.shopping.api.mall.common.tools.o {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ OptionCheckUpdateParams e;
        public final /* synthetic */ GeckoClient f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ ECMallFeed h;

        public static final class a implements Runnable {
            public final /* synthetic */ w a;

            public a(w r1) {
                this.a = r1;
            }

            public final void a() {
                Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
                JSONObject r1 = new JSONObject();     // Catch: Throwable -> L18
                r1.put("channel_name", this.a.c);     // Catch: Throwable -> L18
                r1.put("access_key", this.a.d);     // Catch: Throwable -> L18
                r1.put("preload_status", "success");     // Catch: Throwable -> L18
                r1.put("preload_type", "1");     // Catch: Throwable -> L18
                OptionCheckUpdateParams r2 = this.a.e;     // Catch: Throwable -> L18
                String r3 = null;
                if (r2 == null) goto L12;
                Map r4 = r2.getCustomParam();     // Catch: Throwable -> L18
                if (r4 == null) goto L12;
                String r5 = this.a.d;     // Catch: Throwable -> L18
                if (r5 != null) goto L9;
                r5 = "";
            L9:
                Map r6 = (Map) r4.get(r5);     // Catch: Throwable -> L18
                if (r6 == null) goto L12;
                Object r7 = r6.get("load_tag");     // Catch: Throwable -> L18
            L13:
                r1.put("tag", r7);     // Catch: Throwable -> L18
                int r8 = f93.a.a;     // Catch: Throwable -> L18
                f93.a.c(r1, ECMallFeed.s(this.a.h, "c0.d0"));     // Catch: Throwable -> L18
                r1.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.a.h.B1.c);     // Catch: Throwable -> L18
                com.bytedance.android.ec.hybrid.list.e r9 = this.a.h.B1.z;     // Catch: Throwable -> L18
                if (r9 == null) goto L16;
                r3 = r9.a;     // Catch: Throwable -> L18
            L16:
                r1.putOpt(SimilarProductParam.ENTER_FROM, r3);     // Catch: Throwable -> L18
                com.bytedance.android.shopping.api.mall.common.tools.l.a.getClass();     // Catch: Throwable -> L18
                com.bytedance.android.shopping.api.mall.common.tools.l.a(r1);     // Catch: Throwable -> L18
                Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
            L20:
                Lazy r10 = ECMallLogUtil.a;
                ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update success, channel:" + this.a.c + ",ak:" + this.a.d);
                return;
            L12:
                r7 = null;
            L18:
                th = move-exception;
                Result.Companion r11 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L20
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

        public static final class b implements Runnable {
            public final /* synthetic */ w a;

            public static final class a implements Runnable {
                public final /* synthetic */ b a;

                public a(b r1) {
                    this.a = r1;
                }

                public final void a() {
                    com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_mall_gecko_fail_retry_preload");
                    OptionCheckUpdateParams r0 = this.a.a.e;
                    if (r0 == null) goto L12;
                    Map r1 = r0.getCustomParam();
                    if (r1 == null) goto L12;
                    String r2 = this.a.a.d;
                    if (r2 != null) goto L9;
                    r2 = "";
                L9:
                    Map r3 = (Map) r1.get(r2);
                    if (r3 == null) goto L12;
                    r3.put("load_tag", "repeat");
                L12:
                    w r4 = this.a.a;
                    GeckoClient r5 = r4.f;
                    if (r5 == null) goto L16;
                    r5.checkUpdateMulti(null, r4.g, r4.e);
                    return;
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

            public b(w r1) {
                this.a = r1;
            }

            public final void a() {
                Lazy r0 = ECMallLogUtil.a;
                ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update failed, channel:" + this.a.c + ",ak:" + this.a.d);
                Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
                JSONObject r2 = new JSONObject();     // Catch: Throwable -> L19
                r2.put("channel_name", this.a.c);     // Catch: Throwable -> L19
                r2.put("access_key", this.a.d);     // Catch: Throwable -> L19
                r2.put("preload_status", DeepFeedCouponResult.FAIL);     // Catch: Throwable -> L19
                r2.put("preload_type", "1");     // Catch: Throwable -> L19
                OptionCheckUpdateParams r3 = this.a.e;     // Catch: Throwable -> L19
                String r4 = null;
                if (r3 == null) goto L13;
                Map r5 = r3.getCustomParam();     // Catch: Throwable -> L19
                if (r5 == null) goto L13;
                String r6 = this.a.d;     // Catch: Throwable -> L19
                if (r6 != null) goto L10;
                r6 = "";
            L10:
                Map r7 = (Map) r5.get(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L13;
                Object r8 = r7.get("load_tag");     // Catch: Throwable -> L19
            L14:
                r2.put("tag", r8);     // Catch: Throwable -> L19
                int r9 = f93.a.a;     // Catch: Throwable -> L19
                f93.a.c(r2, ECMallFeed.s(this.a.h, "c0.d0"));     // Catch: Throwable -> L19
                r2.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.a.h.B1.c);     // Catch: Throwable -> L19
                com.bytedance.android.ec.hybrid.list.e r10 = this.a.h.B1.z;     // Catch: Throwable -> L19
                if (r10 == null) goto L17;
                r4 = r10.a;     // Catch: Throwable -> L19
            L17:
                r2.putOpt(SimilarProductParam.ENTER_FROM, r4);     // Catch: Throwable -> L19
                com.bytedance.android.shopping.api.mall.common.tools.l.a.getClass();     // Catch: Throwable -> L19
                com.bytedance.android.shopping.api.mall.common.tools.l.a(r2);     // Catch: Throwable -> L19
                Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
            L21:
                com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_mall_gecko_fail_retry_preload");
                this.a.h.i.postDelayed(new a(this), 60000);
                return;
            L13:
                r8 = null;
            L19:
                th = move-exception;
                Result.Companion r11 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L21
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

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void a() {
            this.h.i.post(new b(this));
        }

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void b() {
            this.h.i.post(new a(this));
        }

        public w(String r1, String r2, OptionCheckUpdateParams r3, GeckoClient r4, Map r5, String r6, String r7, ECMallFeed r8) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r8;
            super(r6, r7);
        }
    }

    public static final class x implements Runnable {
        public final /* synthetic */ ECMallFeed a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public x(ECMallFeed r1, String r2, boolean r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.l(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class y implements Runnable {
        public final /* synthetic */ ECMallFeed a;

        public y(ECMallFeed r1) {
            this.a = r1;
        }

        public final void a() {
            if (((Boolean) this.a.m.getValue()).booleanValue() == false) goto L9;
            ECHybridListEngine r0 = this.a.J;
            if (r0 == null) goto L15;
            com.bytedance.android.ec.hybrid.list.entity.k r1 = r0.c.g;
            if (r1 == null) goto L16;
            r0.o(r1, false, "refreshLayout");
            return;
        L16:
            return;
        L15:
            return;
        L9:
            ECHybridListEngine r2 = this.a.J;
            if (r2 == null) goto L18;
            ECHybridRecyclerView r3 = r2.b;
            if (r3 == null) goto L19;
            r3.requestLayout();
            return;
        L19:
            return;
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

    public static final class z implements Runnable {
        public final /* synthetic */ ECMallFeed a;
        public final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.k b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ String h;

        public z(ECMallFeed r1, com.bytedance.android.ec.hybrid.list.entity.k r2, int r3, boolean r4, boolean r5, String r6, boolean r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECMallFeed r0 = this.a;     // Catch: Throwable -> L6
            if (r0.G == false) goto L9;
            r0.n0(this.b, this.c, this.d, this.e, this.f, this.g, this.h);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final int A() {
        return ((Number) this.N0.getValue()).intValue();
    }

    public final String B() {
        return (String) this.E.getValue();
    }

    public final boolean C() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final com.bytedance.android.shopping.api.mall.opt.e D() {
        return (com.bytedance.android.shopping.api.mall.opt.e) this.c1.getValue();
    }

    public final ECMallVideoPreLoader E() {
        return (ECMallVideoPreLoader) this.Y0.getValue();
    }

    public final void M() {
        this.P = true;
        if (x() == false) goto L5;
    L8:
        this.i.postDelayed(this.u1, ((long) ((Number) this.t.getValue()).intValue()) * 1000);
        return;
    L5:
        if (v() != null) goto L8;
        if (z() == true) goto L8;
    }

    public final void f0() {
        int r0 = 0;
        this.L = 0;
        this.M = 0;
        this.N = true;
        this.V.g(this.U);
        if (this.U == true) goto L8;
        Integer r1 = this.D1;
        if (r1 == null) goto L7;
        r0 = r1.intValue();
    L7:
        k0(Integer.valueOf(r0));
    L8:
        E().a();
    }

    public final void q0() {
        this.P = false;
        com.bytedance.android.shopping.mall.feed.help.d r1 = (com.bytedance.android.shopping.mall.feed.help.d) this.t0.getValue();
        if (r1 == null) goto L6;
        int r2 = com.bytedance.android.shopping.mall.feed.help.d.i;
        r1.b(false);
        return;
    }

    public final ECMallCommonImpressionReportHelper.b t() {
        return (ECMallCommonImpressionReportHelper.b) this.b0.getValue();
    }

    public final ECMallCommonImpressionReportHelper u() {
        return (ECMallCommonImpressionReportHelper) this.c0.getValue();
    }

    public final ECMallGulPrefetch v() {
        return (ECMallGulPrefetch) this.z0.getValue();
    }

    public final ECMallGulRefresh w() {
        return (ECMallGulRefresh) this.A0.getValue();
    }

    public final boolean x() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final boolean y() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public final boolean z() {
        return ((Boolean) this.p.getValue()).booleanValue();
    }

    public final List<String> F() {
        ArrayList r0 = new ArrayList();
        ECHybridDataEngine r1 = this.K;
        if (r1 == null) goto L12;
        ECHybridConfigDTO r2 = r1.c;
        if (r2 == null) goto L9;
        ECHybridApiConfigDTO r3 = r2.getApiConfig();
        if (r3 == null) goto L9;
        List r4 = r3.getLoadMoreKeyList();
    L10:
        if (r4 == null) goto L12;
        r0.addAll(r4);
    L9:
        r4 = null;
    L12:
        return r0;
    }

    public final void G() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko finish");
        this.G = true;
        z r1 = this.r0;
        if (r1 == null) goto L5;
        r1.run();
    L5:
        this.r0 = null;
        com.bytedance.android.shopping.mall.feed.y r2 = this.B0;
        if (r2 == null) goto L9;
        this.i.removeCallbacks(r2);
        this.B0 = null;
        return;
    }

    public final void J() {
        ECHybridRecyclerView r1 = null;
        c0("initialize", null);
        LinkedHashMap r0 = new LinkedHashMap();
        yj.g r2 = com.bytedance.android.ec.hybrid.a.b();
        if (r2 == null) goto L5;
        r2.j();
    L5:
        Lazy r3 = BigFontAdapter.a;
        if (BigFontAdapter.b(this.B1.c) == false) goto L9;
        r0.put("big_font_enabled", 1);
        BigFontAdapter.FontType.Companion.getClass();
        r0.put("font_size_pref", Integer.valueOf(BigFontAdapter.FontType.a.a()));
    L9:
        if ((!r0.isEmpty()) == false) goto L12;
        this.A1.jq(r0, null);
    L12:
        if (this.C1 != null) goto L27;
        String r4 = this.B1.b;
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L25;
        Map<String, DataEngineWrapper> r6 = DataEngineMap.a;
        String r7 = this.B1.b;
        if (r7 != null) goto L24;
        r7 = "default";
    L24:
        DataEngineWrapper r8 = DataEngineMap.a(r7);
    L26:
        this.C1 = r8;
        goto L27
    L25:
        r8 = new DataEngineWrapper();
        goto L26
    L16:
        if (StringsKt.isBlank(r4) == true) goto L19;
        r5 = false;
    L27:
        DataEngineWrapper r9 = this.C1;
        if (r9 == null) goto L30;
        r9.f(com.bytedance.android.shopping.api.mall.common.tools.b0.k(this.B1.f), this.A1.getGlobalProps());
    L30:
        DataEngineWrapper r10 = this.C1;
        if (r10 == null) goto L35;
        ECHybridDataEngine r11 = r10.a;
        if (r11 == null) goto L35;
        o r12 = new o(this);
        this.V0 = r12;
        Intrinsics.checkNotNullParameter(r12, "applier");
        r11.n = r12;
        r11.p.l(r12);
        Unit r13 = Unit.INSTANCE;
    L36:
        this.K = r11;
        ECMallFavoriteSectionHelper r14 = this.V;
        r14.w = r11;
        r14.x = this.G1;
        Lazy r15 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "data engine init end");
        if (this.B1.g == true) goto L39;
        this.G = true;
    L76:
        n r16 = new n(this);
        com.bytedance.android.shopping.api.mall.idl.a r17 = this.A1.Bi();
        if (r17 == null) goto L79;
        com.bytedance.android.shopping.api.mall.idl.c r18 = r17.a;
    L80:
        ECHybridListEngine.Companion r19 = ECHybridListEngine.x;
        String r20 = B();
        int r21 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD.getType();
        LifecycleOwner r22 = this.A1.s4();
        ECMallFeed$NativeCardInjector$inject$1 r110 = new ECMallFeed$NativeCardInjector$inject$1(r16, r18, VideoCardData.class);
        r19.getClass();
        ECHybridListEngine.Companion.c(r20, r21, r22, r110);
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD.getType(), this.A1.s4(), new ECMallFeed$NativeCardInjector$inject$2(r16, r18, LiveCardData.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.NATIVE_HEADER_CHIP_AREA_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.p(r16, HeaderCardData.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.NATIVE_LIVE_BIG_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.q(r16, LiveCardData.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.NATIVE_VIDEO_BIG_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.r(r16, VideoCardData.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.LOGIN_GUIDE_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.s(r16));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.HYBRID_LIST_TITLE.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.t(r16, i93.a.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.HYBRID_LIST_SINGLE_PLACEHOLDER_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.u(ECMallPlaceholderCardVO.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.HYBRID_LIST_DOUBLE_PLACEHOLDER_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.v(ECMallPlaceholderCardVO.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.HYBRID_TYPE_FAV_LOADING_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.n(r16, LoadingStatusVO.class));
        ECHybridListEngine.Companion.c(B(), ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType(), this.A1.s4(), new com.bytedance.android.shopping.mall.feed.o(DeliveryCardData.class));
        ECHybridListEngine.a r23 = new ECHybridListEngine.a(e0(), B());
        ECHybridListContainer r24 = this.z1;
        Intrinsics.checkNotNullParameter(r24, FreqActions.ACTION_VIEW);
        r23.b = r24;
        r23.b(this.A1.s4());
        Function2<String, Boolean, Unit> r25 = new ECMallFeed$initListEngine$1(this);
        Intrinsics.checkNotNullParameter(r25, "listener");
        r23.k = r25;
        Function3<String, Boolean, Boolean, Unit> r26 = new ECMallFeed$initListEngine$2(this);
        Intrinsics.checkNotNullParameter(r26, "listener");
        r23.l = r26;
        Function1<ECHybridHolderUpdateParams, Unit> r27 = new ECMallFeed$initListEngine$3(this);
        Intrinsics.checkNotNullParameter(r27, "listener");
        r23.m = r27;
        Function2<Long, com.bytedance.android.ec.hybrid.list.util.d, Unit> r28 = new ECMallFeed$initListEngine$4(this);
        Intrinsics.checkNotNullParameter(r28, "callback");
        ((ArrayList) r23.i).add(r28);
        Function1<String, Unit> r29 = new ECMallFeed$initListEngine$5(this);
        Intrinsics.checkNotNullParameter(r29, "callback");
        ((ArrayList) r23.q).add(r29);
        e0 r30 = new e0(this);
        Intrinsics.checkNotNullParameter(r30, "lifecycle");
        ((ArrayList) r23.h).add(r30);
        Function2<RecyclerView, Integer, Unit> r31 = new ECMallFeed$initListEngine$7(this);
        Intrinsics.checkNotNullParameter(r31, "callback");
        ((ArrayList) r23.j).add(r31);
        e r32 = this.B1;
        r23.n = r32.j;
        r23.d = r32.u;
        r23.o = r32.y;
        r23.p = this.u0;
        final a r33 = new a(this, r23);
        Map r34 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.m0.class, new LynxViewHolderCreator(r33.b)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.y.class, new com.bytedance.android.ec.hybrid.list.ability.impl.a()), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.t.class, new com.bytedance.android.shopping.mall.feed.ability.b(r33.b.K)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.i0.class, new com.bytedance.android.shopping.mall.feed.ability.g(r33.b.K)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.k0.class, new com.bytedance.android.shopping.mall.feed.d(r33)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.o.class, new com.bytedance.android.shopping.mall.feed.e(r33)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.l0.class, new LoadMoreViewHolderCreator(r33.b)), TuplesKt.to(k93.b.class, new com.bytedance.android.shopping.mall.feed.f(r33)), TuplesKt.to(k93.g.class, r33.b.j0), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.d.class, new CardOnShowAbility(r33.b)), TuplesKt.to(k93.d.class, new com.bytedance.android.shopping.mall.feed.g()), TuplesKt.to(k93.e.class, new com.bytedance.android.shopping.mall.feed.h(r33)), TuplesKt.to(k93.h.class, new com.bytedance.android.shopping.mall.feed.i(r33)), TuplesKt.to(k93.c.class, new com.bytedance.android.shopping.mall.feed.j(r33)), TuplesKt.to(k93.f.class, new com.bytedance.android.shopping.mall.feed.k(r33)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.d0.class, new com.bytedance.android.shopping.mall.feed.l(r33)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.e0.class, new com.bytedance.android.shopping.mall.feed.b(r33)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.h0.class, new com.bytedance.android.shopping.mall.feed.c(r33))});
        com.bytedance.android.ec.hybrid.list.ability.c0 r35 = r33.b.A1.bX();
        if (r35 == null) goto L83;
        r34.put(com.bytedance.android.ec.hybrid.list.ability.c0.class, r35);
    L83:
        int r36 = sf3.a.a;
        Context r37 = r33.b.e0();
        com.bytedance.android.shopping.mall.feed.a r38 = new com.bytedance.android.shopping.mall.feed.a();
        Function0<com.bytedance.android.shopping.api.mall.idl.c> r39 = new ECMallFeed$AbilityInjector$getAbilities$$inlined$apply$lambda$2(r33);
        Intrinsics.checkNotNullParameter(r37, "context");
        Intrinsics.checkNotNullParameter(r38, "containerAbility");
        Intrinsics.checkNotNullParameter(r39, "mallScreenModelProvider");
        Iterator r40 = r34.entrySet().iterator();
    L85:
        if (r40.hasNext() == false) goto L87;
        Map.Entry r41 = (Map.Entry) r40.next();
        r33.a.d((Class) r41.getKey(), r41.getValue());
        goto L85
    L87:
        Unit r42 = Unit.INSTANCE;
        ECHybridListEngine r43 = r23.c();
        this.J = r43;
        RecyclerView r44 = r43.b;
        if (r44 == null) goto L93;
        LoadMorePrefetchStrategy r45 = this.u0;
        Integer r46 = this.R;
        if (r46 == null) goto L92;
        r45.onTabChange(r46);
    L92:
        ((ArrayList) this.k1).add(r45);
        this.u0.injectRecyclerView(r44);
    L93:
        ECHybridListEngine r47 = this.J;
        if (r47 == null) goto L98;
        ECHybridRecyclerView r48 = r47.b;
        if (r48 == null) goto L98;
        r48.setItemAnimator(null);
    L98:
        ECHybridListEngine r49 = this.J;
        if (r49 == null) goto L103;
        ECHybridRecyclerView r50 = r49.b;
        if (r50 == null) goto L103;
        r50.setHasFixedSize(true);
    L103:
        ECHybridListEngine r51 = this.J;
        if (r51 == null) goto L113;
        ECHybridRecyclerView r52 = r51.b;
        if (r52 == null) goto L113;
        if (((Number) this.g1.getValue()).intValue() != 1) goto L110;
        boolean r53 = true;
    L111:
        r52.setEnableAsNestedParent(r53);
        goto L113
    L110:
        r53 = false;
    L113:
        if (A() < 1) goto L124;
        ECHybridListEngine r54 = this.J;
        if (r54 == null) goto L117;
        ECHybridRecyclerView r55 = r54.b;
    L118:
        ECHybridRecyclerViewPreBindHelper r56 = new ECHybridRecyclerViewPreBindHelper(r55);
        r56.o = this.P0;
        ECHybridListEngine r57 = this.J;
        if (r57 == null) goto L123;
        ECHybridRecyclerView r58 = r57.b;
        if (r58 == null) goto L123;
        r58.setViewCacheExtension(new ECHybridViewCacheExtension(r56));
    L123:
        this.K0 = r56;
        goto L124
    L117:
        r55 = null;
    L124:
        w0();
        ECHybridListEngine r59 = this.J;
        if (r59 == null) goto L129;
        ECHybridRecyclerView r60 = r59.b;
        if (r60 == null) goto L129;
        r60.setClipChildren(false);
        r60.setClipToPadding(false);
    L129:
        ECHybridListEngine r61 = this.J;
        if (r61 == null) goto L132;
        r61.q(new r(this));
    L132:
        ECHybridListEngine r62 = this.J;
        if (r62 == null) goto L136;
        r62.c.m = new q(this);
    L136:
        if (this.B1.o == true) goto L138;
        j();
    L138:
        ECHybridListEngine r63 = this.J;
        if (r63 == null) goto L141;
        r63.b(com.bytedance.android.ec.hybrid.list.ability.x.class, new com.bytedance.android.shopping.mall.feed.ability.d(new com.bytedance.android.shopping.mall.feed.ability.d.a.C0081a(this.B1.c)));
    L141:
        ECHybridListEngine r64 = this.J;
        if (r64 == null) goto L144;
        r64.b(com.bytedance.android.ec.hybrid.list.ability.b0.class, new d0(this));
    L144:
        ECHybridListEngine r65 = this.J;
        if (r65 == null) goto L149;
        ECHybridRecyclerView r66 = r65.b;
        if (r66 == null) goto L149;
        r66.setPageName(this.B1.c);
    L149:
        List r67 = ((com.bytedance.android.ec.hybrid.list.g) this.l0.getValue()).a();
        if (r67 != null) goto L152;
    L153:
        List r68 = ((com.bytedance.android.ec.hybrid.list.g) this.l0.getValue()).c();
        if (r68 != null) goto L156;
    L171:
        Z(new ScrollListener(this));
        ECHybridListEngine r69 = this.J;
        if (r69 == null) goto L179;
        ECHybridRecyclerView r70 = r69.b;
        if (r70 == null) goto L179;
        com.bytedance.android.shopping.api.mall.opt.c r71 = new com.bytedance.android.shopping.api.mall.opt.c(r70, this.A1.ZK("c9582.d0", false, null));
        Integer r72 = this.R;
        if (r72 == null) goto L178;
        r71.onTabChange(r72);
    L178:
        ((ArrayList) this.k1).add(r71);
    L179:
        Map<String, Object> r73 = this.A1.getGlobalProps();
        ECHybridListEngine r74 = this.J;
        if (r74 == null) goto L190;
        ECHybridRecyclerView r75 = r74.b;
        if (r75 == null) goto L190;
        Object r76 = r73.get("delivery_position_id");
        if ((r76 instanceof String) == true) goto L186;
        r76 = null;
    L186:
        String r77 = (String) r76;
        if (r77 != null) goto L189;
        r77 = "";
    L189:
        r75.setCardFrom(r77);
    L190:
        this.W.a = this.J;
        final a1 r78 = new a1(e0(), this);
        String r79 = r78.a.b.B();
        Iterator<T> r80 = r78.d.iterator();
    L192:
        if (r80.hasNext() == false) goto L194;
        IDLXBridgeMethod r81 = (IDLXBridgeMethod) r80.next();
        ECBridgeMethodFinder.a r82 = ECBridgeMethodFinder.h;
        String r84 = r81.getName();
        r82.getClass();
        ECBridgeMethodFinder.a.a(r79, r84, r81);
        goto L192
    L194:
        com.bytedance.android.shopping.mall.feed.help.q r85 = this.A1.TN();
        if (r85 == null) goto L198;
        Intrinsics.checkNotNullParameter(r85, "listener");
        ECMallOpenSchemaJsb r86 = r78.b;
        r86.getClass();
        Intrinsics.checkNotNullParameter(r85, "listener");
        ((ArrayList) r86.l).add(r85);
    L198:
        if (((Number) this.C.getValue()).intValue() != 1) goto L200;
        ((IMarketingServiceV2) ServiceManager.get().getService(IMarketingServiceV2.class)).h(new ECMallFeedJsbInjector$getCardPositionMarketing$1(r78));
    L200:
        ECMallOpenSchemaJsb r87 = r78.b;
        LinkedHashMap r88 = new LinkedHashMap();
        Lazy r89 = MallOptUtil.e;
        if (((com.bytedance.android.shopping.mall.settings.a) r89.getValue()).c(this.B1.c) == false) goto L208;
        Fragment r90 = this.A1.M();
        if (r90 == null) goto L208;
        FragmentActivity r91 = r90.requireActivity();
        if (r91 == null) goto L208;
        com.bytedance.android.shopping.mall.feed.ability.a r92 = new com.bytedance.android.shopping.mall.feed.ability.a(B(), r91, r87);
        int r94 = lk.b.a;
        Context r95 = r92.b;
        String r96 = r92.a;
        Intrinsics.checkNotNullParameter(r95, "context");
        Intrinsics.checkNotNullParameter(r96, "sceneID");
    L208:
        if (((com.bytedance.android.shopping.mall.settings.a) r89.getValue()).b(this.B1.c) == false) goto L211;
        r88.put("pauseToStop", Boolean.TRUE);
    L211:
        if ((!r88.isEmpty()) == false) goto L213;
        this.A1.jq(r88, null);
    L213:
        l r97 = this.o0;
        r97.getClass();
        r97.b = new WeakReference(r97.c.e0());
        ECMallFeed$JsEventSubscriberInjector$inject$1 r98 = new ECMallFeed$JsEventSubscriberInjector$inject$1(r97);
        ((ArrayList) r97.a).add(new Pair("mallTabSelectedEvent", r98));
        Unit r99 = Unit.INSTANCE;
        ECEventCenter.e("mallTabSelectedEvent", r98, r97.c.B());
        String r100 = r97.c.B();
        pf3.b r101 = new pf3.b(r97.b);
        ((ArrayList) r97.a).add(new Pair("opensku", r101));
        ECEventCenter.e("opensku", r101, r100);
        if (v() != null) goto L220;
        ECMallGulRefresh r102 = w();
        if (r102 != null) goto L218;
    L221:
        final ECMallFeedRepeatManagerFeed r103 = (ECMallFeedRepeatManagerFeed) this.F.getValue();
        if (r103 == null) goto L242;
        this.A1.Vw(r103);
        final EventExposureTime r104 = (EventExposureTime) r103.f.getValue();
        if (r104 == null) goto L241;
        EventExposureTime.a.C0083a r105 = r104.o;
        if (r105.f == true) goto L230;
        ECHybridRecyclerView r106 = r105.e;
        if (r106 == null) goto L230;
        r106.addOnScrollListener(new EventExposureTime$start$1(r104));
    L230:
        ECHybridRecyclerView r107 = r104.o.e;
        if (r107 == null) goto L233;
        r107.addOnChildAttachStateChangeListener(new EventExposureTime$start$2(r104));
    L233:
        EventExposureTime.a.C0083a r108 = r104.o;
        if (r108.f == false) goto L241;
        ECHybridRecyclerView r109 = r108.e;
        if (r109 == null) goto L238;
        r109.addOnScrollListener(new EventExposureTime$scrollListener$1(r104));
    L238:
        ECHybridRecyclerView r111 = r104.o.e;
        if (r111 == null) goto L241;
        r111.addOnAttachStateChangeListener(new com.bytedance.android.shopping.mall.feed.help.c(r104));
    L241:
        r103.c.addOnScrollListener(new ECMallFeedRepeatManagerFeed$start$1(r103));
    L242:
        ShelterEventHelp r112 = (ShelterEventHelp) this.k.getValue();
        if (r112 == null) goto L252;
        ECHybridListEngine r113 = this.J;
        if (r113 == null) goto L247;
        r1 = r113.b;
    L247:
        r112.e = r1;
        if (r112.k == null) goto L251;
        if (r1 == null) goto L251;
        r1.addOnChildAttachStateChangeListener(r112.g);
    L251:
        this.A1.Vw(r112);
    L252:
        String r114 = this.B1.c;
        ILegouMallService r115 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
        if (r115 == null) goto L255;
        r115.g(this.B1.c);
    L255:
        com.bytedance.android.shopping.mall.feed.help.a r116 = (com.bytedance.android.shopping.mall.feed.help.a) this.l1.getValue();
        if (r116 != null) goto L258;
    L260:
        List<String> r117 = ((aa3.d) MallRefreshGuideConfigKt.a.getValue()).c();
        if (r117 == null) goto L274;
        Integer r118 = this.R;
        if (r118 == null) goto L267;
        if (r118.intValue() == 0) goto L267;
        return;
    L267:
        if ((!r117.isEmpty()) == true) goto L269;
        return;
    L269:
        if (r117.contains(this.B1.c) == false) goto L277;
        this.o1 = new com.bytedance.android.shopping.mall.feed.help.r(B());
        return;
    L277:
        return;
    L274:
        return;
    L258:
        if (Build.VERSION.SDK_INT <= 23) goto L260;
        Single.fromCallable(new com.bytedance.android.shopping.mall.feed.help.b(r116)).subscribeOn(Schedulers.single()).subscribe();
        goto L260
    L218:
        if (r102.f != true) goto L221;
    L220:
        this.T0 = true;
        MallGulRequestUtil r119 = MallGulRequestUtil.INSTANCE;
        e r120 = this.B1;
        r119.registerListener(r120.c, r120.a, new ECMallFeed$registerRequestListener$1(this));
        goto L221
    L156:
        if (r68.contains(this.B1.c) == true) goto L171;
    L157:
        IECMallHostService r121 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r121 == null) goto L160;
        com.bytedance.android.ec.hybrid.list.ability.a0 r122 = r121.getLiveStatusAbility(B(), this.J, this.A1.s4().getLifecycle());
    L161:
        this.n0 = r122;
        if (r122 == null) goto L171;
        ECHybridListEngine r123 = this.J;
        if (r123 == null) goto L166;
        r123.b(com.bytedance.android.ec.hybrid.list.ability.a0.class, r122);
    L166:
        ECHybridListEngine r124 = this.J;
        if (r124 == null) goto L171;
        ECHybridRecyclerView r125 = r124.b;
        if (r125 == null) goto L171;
        r125.b0();
        goto L171
    L160:
        r122 = null;
        goto L161
    L152:
        if (r67.contains(this.B1.c) == true) goto L157;
    L79:
        r18 = null;
        goto L80
    L39:
        DataEngineWrapper r126 = this.C1;
        if (r126 == null) goto L44;
        y93.a r127 = r126.b;
        if (r127 == null) goto L44;
        Long r128 = r127.f();
    L45:
        if (r128 != null) goto L49;
        DataEngineWrapper r129 = this.C1;
        if (r129 == null) goto L49;
        r129.m(System.currentTimeMillis());
    L49:
        String r130 = NativeMallGeckoHelper.a();
        Ref.ObjectRef r131 = new Ref.ObjectRef();
        r131.element = NativeMallGeckoHelper.b();
        String r132 = this.B1.x;
        if (r132 == null) goto L52;
        r131.element = r132;
    L52:
        GeckoClient r133 = com.bytedance.geckox.a.a(r130);
        if (r133 == null) goto L55;
    L60:
        com.bytedance.android.shopping.mall.feed.y r134 = this.B0;
        if (r134 == null) goto L63;
        this.i.postDelayed(r134, 15000);
    L63:
        if (r133 != null) goto L75;
        DataEngineWrapper r135 = this.C1;
        if (r135 == null) goto L69;
        y93.a r136 = r135.b;
        if (r136 == null) goto L69;
        Long r137 = r136.e();
    L70:
        if (r137 != null) goto L74;
        DataEngineWrapper r138 = this.C1;
        if (r138 == null) goto L74;
        r138.l(System.currentTimeMillis(), 1);
    L74:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko have cache, register not  complete");
        this.i.post(new b0(this));
    L69:
        r137 = null;
        goto L70
    L75:
        r133.checkUpdateMulti("default", MapsKt.mapOf(TuplesKt.to(r130, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel((String) r131.element)))), new OptionCheckUpdateParams().setChannelUpdatePriority(3).setRequestWhenHasLocalVersion(false).setListener(new c0(this, r130, (String) r131.element)));
        goto L76
    L55:
        if (this.B1.h == true) goto L60;
        DataEngineWrapper r139 = this.C1;
        if (r139 == null) goto L59;
        r139.l(System.currentTimeMillis(), -1);
    L59:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "local not found gecko channel");
        G();
    L44:
        r128 = null;
    L35:
        r11 = null;
        goto L36
    }

    public final boolean K() {
        if (((Number) this.s1.getValue()).intValue() > 0) goto L5;
    L7:
        return false;
    L5:
        if (((List) this.t1.getValue()).contains(this.B1.c) == false) goto L7;
        return true;
    }

    public final void Y() {
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L15;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L17;
        y r2 = new y(this);
        if (r1.isComputingLayout() == false) goto L10;
    L13:
        this.i.post(r2);
        return;
    L10:
        if (r1.getScrollState() != 0) goto L13;
        r2.run();
        return;
    L17:
        return;
    }

    public final Context e0() {
        return this.z1.getContext();
    }

    public final void j() {
        Long r1 = this.B1.t;
        if (r1 == null) goto L5;
        String r2 = String.valueOf(r1);
    L6:
        JSONObject r3 = new JSONObject();
        r3.putOpt("res_version", r2);
        r3.putOpt("na_page_name", this.B1.c);
        com.bytedance.android.ec.hybrid.list.e r4 = this.B1.z;
        if (r4 == null) goto L11;
        String r5 = r4.a;
        if (r5 == null) goto L11;
        r3.putOpt(SimilarProductParam.ENTER_FROM, r5);
    L11:
        Function0<Map<String, ? extends String>> r6 = new ECMallFeed$attachFpsMonitor$1(this);
        Intrinsics.checkNotNullParameter("homepage_mall_native", "sceneName");
        Intrinsics.checkNotNullParameter(r3, "additionParams");
        Z(new HybridRecyclerViewPerformanceMonitor(new com.bytedance.android.ec.hybrid.monitor.h("homepage_mall_native", r3, r6)));
        g0(this, new ECMallFeed$updateFpsMonitor$1(this, this.R));
        return;
    L5:
        r2 = "-1";
        goto L6
    }

    public final int k() {
        ECHybridListEngine r0 = this.J;
        int r1 = 0;
        if (r0 == null) goto L15;
        ArrayList r3 = new ArrayList();
        int r4 = r0.b.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L16;
        View r6 = r0.b.getChildAt(r5);
        if (r6 == null) goto L14;
        RecyclerView.ViewHolder r7 = r0.b.getChildViewHolder(r6);
        if ((r7 instanceof BaseViewHolder) == true) goto L11;
        r7 = null;
    L11:
        BaseViewHolder r8 = (BaseViewHolder) r7;
        if (r8 == null) goto L14;
        r3.add(r8);
    L14:
        r5 = r5 + 1;
    L16:
        ArrayList r2 = new ArrayList();
        if (r3 == null) goto L32;
        Iterator r9 = r3.iterator();
    L20:
        if (r9.hasNext() == false) goto L32;
        BaseViewHolder r10 = (BaseViewHolder) r9.next();
        ECHybridListItemVO r11 = r10.c;
        if (r11 == null) goto L24;
        String r12 = r11.r;
    L25:
        if (r12 == null) goto L20;
        if (r11 == null) goto L28;
        String r13 = r11.r;
    L30:
        if ((!Intrinsics.areEqual(r13, "favorite_section")) == false) goto L20;
        r2.add(r10);
        goto L20
    L28:
        r13 = null;
        goto L30
    L24:
        r12 = null;
    L32:
        Iterator r14 = r2.iterator();
    L34:
        if (r14.hasNext() == false) goto L40;
        BaseViewHolder r15 = (BaseViewHolder) r14.next();
        if (((RecyclerView.ViewHolder) r15).itemView.getTop() > 0) goto L34;
        if (((RecyclerView.ViewHolder) r15).itemView.getBottom() <= 0) goto L34;
        r1 = Math.max(r1, ((RecyclerView.ViewHolder) r15).itemView.getBottom());
        goto L34
    L40:
        return r1;
    L15:
        r3 = null;
        goto L16
    }

    public final void w0() {
        Lazy r0 = MallOptUtil.a;
        com.bytedance.android.ec.hybrid.list.entity.o r1 = (com.bytedance.android.ec.hybrid.list.entity.o) MallOptUtil.i.getValue();
        Integer r2 = r1.a();
        if (r2 == null) goto L24;
        int r3 = r2.intValue();
        String r4 = this.B1.c;
        int r5 = r4.hashCode();
        if (r5 == (-1773284929)) goto L13;
        if (r5 == 556139984) goto L10;
    L15:
        r3 = r3 >> 2;
    L17:
        if ((r3 & 1) != 1) goto L25;
        ECHybridListEngine r6 = this.J;
        if (r6 == null) goto L26;
        ECHybridRecyclerView r7 = r6.b;
        if (r7 == null) goto L27;
        Intrinsics.checkNotNullParameter(r1, "params");
        r7.H = r1;
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L10:
        if (r4.equals(MallPageName.X_TAB_MALL) == false) goto L15;
    L13:
        if (r4.equals("order_homepage") == false) goto L15;
        r3 = r3 >> 1;
        goto L17
    }

    public final void x0() {
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L141;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L142;
        VirtualLayoutManager r2 = r1.getLayoutManager();
        if (r2 == null) goto L143;
        Integer r3 = Integer.valueOf(r2.findFirstVisibleItemPosition());
        boolean r4 = false;
        if (r3.intValue() < 0) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L144;
        int r6 = r3.intValue();
        ECHybridListEngine r7 = this.J;
        if (r7 == null) goto L145;
        ECHybridRecyclerView r8 = r7.b;
        if (r8 == null) goto L146;
        VirtualLayoutManager r9 = r8.getLayoutManager();
        if (r9 == null) goto L147;
        Integer r10 = Integer.valueOf(r9.findLastVisibleItemPosition());
        if (r10.intValue() < 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == true) goto L30;
        r10 = null;
    L30:
        if (r10 == null) goto L148;
        int r12 = r10.intValue();
        ECHybridListEngine r13 = this.J;
        if (r13 == null) goto L149;
        DataResolver r14 = r13.c;
        if (r14 == null) goto L150;
        List r15 = r14.j();
        if (r15 != null) goto L38;
        return;
    L38:
        if ((!((ArrayList) r15).isEmpty()) == true) goto L41;
        r15 = null;
    L41:
        if (r15 == null) goto L155;
        int r16 = RangesKt.coerceAtMost(r12 + 20, r15.size() - 1);
        if (r6 >= r16) goto L152;
        List r17 = r15.subList(r6, r16);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L47:
        if (r19.hasNext() == false) goto L54;
        Object r20 = ((ECHybridListItemVO) r19.next()).d();
        if ((r20 instanceof VideoCardData) == true) goto L51;
        r20 = null;
    L51:
        VideoCardData r21 = (VideoCardData) r20;
        if (r21 == null) goto L47;
        r18.add(r21);
        goto L47
    L54:
        List r22 = CollectionsKt.toMutableList(r18);
        ArrayList<Integer> r23 = D().a();
        if (r23 != null) goto L57;
    L60:
        boolean r24 = true;
    L61:
        if (r24 == true) goto L95;
        List r25 = r15.subList(r6, r16);
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L64:
        if (r27.hasNext() == false) goto L75;
        Object r28 = r27.next();
        ECHybridListItemVO r29 = (ECHybridListItemVO) r28;
        if (r29.c == null) goto L72;
        ArrayList<Integer> r30 = D().a();
        if (r30 == null) goto L72;
        if (CollectionsKt.contains(r30, r29.c) != true) goto L72;
        boolean r31 = true;
    L73:
        if (r31 == false) goto L64;
        r26.add(r28);
    L72:
        r31 = false;
        goto L73
    L75:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r26.iterator();
    L77:
        if (r33.hasNext() == false) goto L94;
        ECHybridListItemVO r34 = (ECHybridListItemVO) r33.next();
        r34.getClass();
        Intrinsics.checkNotNullParameter(VideoCardData.class, "model");
        Object r35 = r34.Y;
        if (r35 != null) goto L89;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L86
        String r37 = r34.g();     // Catch: Throwable -> L86
        if (r37 == null) goto L84;
        r34.Y = hb.a.a(r37, VideoCardData.class);     // Catch: Throwable -> L86
    L84:
        r35 = r34.Y;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r35 = null;
    L89:
        if ((r35 instanceof VideoCardData) == true) goto L91;
        r35 = null;
    L91:
        VideoCardData r39 = (VideoCardData) r35;
        if (r39 == null) goto L77;
        r32.add(r39);
        goto L77
    L94:
        r22.addAll(r32);
    L95:
        ECMallVideoPreLoader r40 = E();
        List r41 = CollectionsKt.take(r22, D().b());
        if (((com.bytedance.android.shopping.api.mall.opt.e) r40.c.getValue()).c() == false) goto L153;
        List r42 = r41;
        if (r42 != null) goto L100;
    L101:
        r4 = true;
    L102:
        if (r4 == true) goto L156;
        ArrayList r43 = new ArrayList();
        Iterator r44 = r41.iterator();
    L106:
        if (r44.hasNext() == false) goto L110;
        Object r45 = r44.next();
        if ((!r40.a.contains((VideoCardData) r45)) == false) goto L106;
        r43.add(r45);
        goto L106
    L110:
        r40.a.addAll(r43);
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r47 = r43.iterator();
    L112:
        if (r47.hasNext() == false) goto L114;
        r46.add(r40.b((VideoCardData) r47.next()));
        goto L112
    L114:
        yj.d r48 = (yj.d) r40.b.getValue();
        if (r48 == null) goto L154;
        ((com.bytedance.android.shopping.api.mall.opt.e) r40.c.getValue()).getClass();
        r48.preload();
        return;
    L154:
        return;
    L156:
        return;
    L100:
        if (r42.isEmpty() == false) goto L102;
    L153:
        return;
    L57:
        if (r23.isEmpty() == true) goto L60;
        r24 = false;
        goto L61
    L152:
        return;
    L155:
        return;
    L150:
        return;
    L149:
        return;
    L148:
        return;
    L26:
        r11 = false;
        goto L27
    L147:
        return;
    L146:
        return;
    L145:
        return;
    L144:
        return;
    L11:
        r5 = false;
        goto L13
    L143:
        return;
    L142:
        return;
    }

    public final void y0() {
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L9;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.Z(Reflection.getOrCreateKotlinClass(NativeVideoCard.class)) != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        E().a();
        return;
    L12:
        x0();
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void N() {
        ECMallCommonImpressionReportHelper.b r0 = t();
        if (r0 != null) goto L5;
    L17:
        this.j.postDelayed(new v(this), 5000);
        return;
    L5:
        if (r0.a != true) goto L17;
        ECMallCommonImpressionReportHelper r1 = u();
        if (r1 == null) goto L19;
        boolean r2 = r1.g;
        if (r2 == false) goto L11;
        return;
    L11:
        if (r1.d == true) goto L22;
        r1.d = true;
        if (r2 == true) goto L23;
        r1.a.removeCallbacks(r1.h);
        r1.a.postDelayed(r1.h, r1.i.b);
        return;
    L23:
        return;
    L22:
        return;
    }

    public static String T(String r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r5 = new JSONObject(new String(Base64.decode(r4, 0), Charsets.UTF_8)).optJSONObject("0");     // Catch: Throwable -> L7
        if (r5 == null) goto L12;
        return r5.optString("sid");
    L12:
        return null;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static final String a(ECMallFeed r6) {
        if (r6.H0 == null) goto L215;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L212
        int r1 = com.bytedance.android.ec.base.settings.a.a;     // Catch: Throwable -> L212
        Object r2 = "";
        Object r3 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_sticky_section_check_target");     // Catch: Throwable -> L58
        if (r3 != null) goto L10;
    L55:
        Object r4 = null;
    L56:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L58
    L60:
        Throwable r7 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L165
        if (r7 == null) goto L64;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L165
    L64:
        if (Result.isFailure-impl(r5) == false) goto L67;
        r5 = null;
    L67:
        if ((r5 instanceof String) == true) goto L69;
        r5 = null;
    L69:
        Object r8 = (String) r5;     // Catch: Throwable -> L165
        if (r8 != null) goto L76;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("ec_mall_sticky_section_check_target");     // Catch: Throwable -> L165
        if ((r9 instanceof String) == true) goto L75;
        r9 = null;
    L75:
        r8 = (String) r9;     // Catch: Throwable -> L165
    L76:
        if (r8 != null) goto L174;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_sticky_section_check_target");     // Catch: Throwable -> L131
        if (r11 != null) goto L83;
    L128:
        Object r12 = null;
    L129:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L131
    L133:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L156
        if (r14 == null) goto L137;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L156
    L137:
        if (Result.isFailure-impl(r13) == false) goto L140;
        r13 = null;
    L140:
        if ((r13 instanceof String) == true) goto L142;
        r13 = null;
    L142:
        r8 = (String) r13;     // Catch: Throwable -> L156
        if (r8 != null) goto L163;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r15 == null) goto L148;
        Object r16 = r15.getHostABValue("ec_mall_sticky_section_check_target", "");     // Catch: Throwable -> L156
    L149:
        if (r16 != null) goto L151;
    L162:
        r8 = "";
        goto L163
    L151:
        if ((r16 instanceof String) == true) goto L153;
        r16 = null;
    L153:
        r8 = (String) r16;     // Catch: Throwable -> L156
        if (r8 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L165
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r18 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L165
        if (r18 == null) goto L161;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r8) == false) goto L163;
    L148:
        r16 = null;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_mall_sticky_section_check_target", r8);     // Catch: Throwable -> L165
    L83:
        if ((r11 instanceof String) == true) goto L85;
        Object r19 = null;
    L86:
        r12 = (String) r19;     // Catch: Throwable -> L131
        if (r12 != null) goto L129;
        if ((r11 instanceof Number) == false) goto L116;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L98;
        Float r20 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L131
        if ((r20 instanceof String) == true) goto L96;
        r20 = null;
    L96:
        r12 = (String) r20;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L104;
        Double r21 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L131
        if ((r21 instanceof String) == true) goto L102;
        r21 = null;
    L102:
        r12 = (String) r21;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L110;
        Integer r22 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L131
        if ((r22 instanceof String) == true) goto L108;
        r22 = null;
    L108:
        r12 = (String) r22;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L116;
        Long r23 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L131
        if ((r23 instanceof String) == true) goto L114;
        r23 = null;
    L114:
        r12 = (String) r23;     // Catch: Throwable -> L131
    L116:
        if ((r11 instanceof JSONObject) == false) goto L118;
    L226:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L124
        Object r24 = SDKSettingsCacheManager.a().fromJson(r11.toString(), String.class);     // Catch: Throwable -> L124
        if ((r24 instanceof String) == true) goto L122;
        r24 = null;
    L122:
        Object r25 = Result.constructor-impl((String) r24);     // Catch: Throwable -> L124
    L126:
        r12 = r25;
        if (Result.isFailure-impl(r12) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L131
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r11 instanceof JSONArray) == false) goto L128;
    L85:
        r19 = r11;
    L131:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L156
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L165:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L212
        Object r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L212
        if (r30 == null) goto L170;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L212
    L170:
        if (Result.isFailure-impl(r29) == true) goto L173;
        r2 = r29;
    L173:
        r8 = r2;
    L174:
        String r31 = (String) r8;     // Catch: Throwable -> L212
        boolean r32 = false;
        if (r31.length() <= 0) goto L177;
        boolean r33 = true;
    L178:
        if (r33 == true) goto L180;
    L210:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L212
        goto L215
    L180:
        if (Intrinsics.areEqual(r6.H0, r31) == false) goto L210;
        ECHybridListEngine r34 = r6.J;     // Catch: Throwable -> L212
        if (r34 == null) goto L197;
        ECHybridRecyclerView r35 = r34.b;     // Catch: Throwable -> L212
        if (r35 == null) goto L197;
        VirtualLayoutManager r36 = r35.getLayoutManager();     // Catch: Throwable -> L212
        if (r36 == null) goto L197;
        List r37 = r36.R();     // Catch: Throwable -> L212
        if (r37 == null) goto L197;
        Iterator r38 = r37.iterator();     // Catch: Throwable -> L212
    L191:
        if (r38.hasNext() == false) goto L195;
        Object r39 = r38.next();     // Catch: Throwable -> L212
        if ((((com.bytedance.android.ec.vlayout.a) r39) instanceof vn.m) == false) goto L191;
    L196:
        com.bytedance.android.ec.vlayout.a r40 = (com.bytedance.android.ec.vlayout.a) r39;     // Catch: Throwable -> L212
    L199:
        if ((r40 instanceof vn.m) == true) goto L201;
        r40 = null;
    L201:
        vn.m r41 = (vn.m) r40;     // Catch: Throwable -> L212
        if (r41 != null) goto L204;
    L209:
        r6.H0 = null;     // Catch: Throwable -> L212
        goto L210
    L204:
        if (r41.r == false) goto L206;
    L208:
        if (r32 == true) goto L210;
    L206:
        if (r41.q == null) goto L208;
        r32 = true;
        goto L208
    L195:
        r39 = null;
    L197:
        r40 = null;
        goto L199
    L177:
        r33 = false;
        goto L178
    L10:
        if ((r3 instanceof String) == true) goto L12;
        Object r42 = null;
    L13:
        r4 = (String) r42;     // Catch: Throwable -> L58
        if (r4 != null) goto L56;
        if ((r3 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r43 = Float.valueOf(((Number) r3).floatValue());     // Catch: Throwable -> L58
        if ((r43 instanceof String) == true) goto L23;
        r43 = null;
    L23:
        r4 = (String) r43;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r44 = Double.valueOf(((Number) r3).doubleValue());     // Catch: Throwable -> L58
        if ((r44 instanceof String) == true) goto L29;
        r44 = null;
    L29:
        r4 = (String) r44;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r45 = Integer.valueOf(((Number) r3).intValue());     // Catch: Throwable -> L58
        if ((r45 instanceof String) == true) goto L35;
        r45 = null;
    L35:
        r4 = (String) r45;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r46 = Long.valueOf(((Number) r3).longValue());     // Catch: Throwable -> L58
        if ((r46 instanceof String) == true) goto L41;
        r46 = null;
    L41:
        r4 = (String) r46;     // Catch: Throwable -> L58
    L43:
        if ((r3 instanceof JSONObject) == false) goto L45;
    L222:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L51
        Object r47 = SDKSettingsCacheManager.a().fromJson(r3.toString(), String.class);     // Catch: Throwable -> L51
        if ((r47 instanceof String) == true) goto L49;
        r47 = null;
    L49:
        Object r48 = Result.constructor-impl((String) r47);     // Catch: Throwable -> L51
    L53:
        r4 = r48;
        if (Result.isFailure-impl(r4) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L58
        r48 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r3 instanceof JSONArray) == false) goto L55;
    L12:
        r42 = r3;
    L58:
        th = move-exception;
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L165
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L212:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L215:
        return r6.H0;
    }

    public static final void b(ECMallFeed r12) {
        r12.g0++;
        ECHybridListEngine r0 = r12.J;
        if (r0 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.ability.z r1 = (com.bytedance.android.ec.hybrid.list.ability.z) r0.getAbility(com.bytedance.android.ec.hybrid.list.ability.z.class);
        if (r1 == null) goto L7;
        r1.Lm("favoriteShowCount", Integer.valueOf(r12.g0));
    L7:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mallGetFavoriteShowCount", System.currentTimeMillis(), r12.B(), false, MapsKt.mapOf(TuplesKt.to("count", Integer.valueOf(r12.g0))), false, 40));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static final void c(ECMallFeed r6) {
        ECHybridListEngine r0 = r6.J;
        List r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        if (r0 == null) goto L23;
        VirtualLayoutManager r2 = r0.b.getLayoutManager();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.findFirstVisibleItemPosition());
    L8:
        VirtualLayoutManager r4 = r0.b.getLayoutManager();
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.findLastVisibleItemPosition());
    L12:
        if (r3 == null) goto L23;
        if (r5 == null) goto L23;
        if (r5.intValue() < r3.intValue()) goto L23;
        r1 = new ArrayList();
        int r7 = r3.intValue();
        int r8 = r5.intValue();
        if (r7 > r8) goto L23;
    L18:
        ECHybridListItemVO r9 = r0.c.h(r7);
        if (r9 == null) goto L21;
        r1.add(r9);
    L21:
        if (r7 == r8) goto L23;
        r7 = r7 + 1;
        goto L18
    L11:
        r5 = null;
        goto L12
    L7:
        r3 = null;
    L23:
        if (r1 != 0) goto L26;
        r1 = CollectionsKt.emptyList();
    L26:
        if (r1.isEmpty() == true) goto L34;
        Iterator r10 = SequencesKt.filter(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r1), ECMallFeed$handleIdleImagePreload$1.INSTANCE), ECMallFeed$handleIdleImagePreload$2.INSTANCE), ECMallFeed$handleIdleImagePreload$3.INSTANCE).iterator();
    L30:
        if (r10.hasNext() == false) goto L41;
        ECNAMallCardExtra r11 = (ECNAMallCardExtra) r10.next();
        DataEngineWrapper r12 = r6.C1;
        if (r12 == null) goto L30;
        r12.D(r11);
        goto L30
    L41:
        return;
    }

    public static final void d(ECMallFeed r5) {
        r5.j.removeCallbacksAndMessages(null);
        r5.j.postDelayed(new com.bytedance.android.shopping.mall.feed.z(r5), 5000);
        if (((CopyOnWriteArrayList) r5.Z).isEmpty() == true) goto L15;
        ((ArrayList) r5.a0).clear();
        Iterator r0 = ((CopyOnWriteArrayList) r5.Z).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ImpressionItem r1 = (ImpressionItem) r0.next();
        List<ImpressionItem> r2 = r5.a0;
        ArrayList r3 = (ArrayList) r2;
        r3.add(new ImpressionItem(r1.getType(), r1.getId()));
        goto L7
    L9:
        ECHybridDataEngine r4 = r5.K;
        if (r4 == null) goto L14;
        r4.a(CollectionsKt.listOf("common_impression"), new com.bytedance.android.shopping.mall.feed.a0(r5));
        return;
    L14:
        return;
    }

    public static final void e(ECMallFeed r5) {
        r5.getClass();
        ListEngineOptConfig.a r0 = ListEngineOptConfig.r;
        String r1 = r5.B1.c;
        r0.getClass();
        Integer r2 = ListEngineOptConfig.a.a(r1);
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        if (r3 != 0) goto L9;
        return;
    L9:
        if (r5.R != null) goto L11;
    L13:
        ECHybridListEngine r4 = r5.J;
        if (r4 == null) goto L23;
        int r6 = r4.n("favorite_section");
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.d.b, "favorite feed card is " + r6 + ", curTabId = " + r5.R);
        if (r6 < 0) goto L28;
        if (r3 < r6) goto L24;
        ECHybridListEngine r8 = r5.J;
        if (r8 == null) goto L25;
        r8.b.O();
        return;
    L25:
        return;
    L24:
        return;
    L28:
        return;
    L23:
        return;
    L11:
        if (CollectionsKt.contains((ArrayList) ListEngineOptConfig.q.getValue(), r5.R) == false) goto L13;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static final void f(ECMallFeed r9) {
        if (r9.Z0 == false) goto L30;
        ECMallGulPrefetch r0 = r9.v();
        if (r0 == null) goto L30;
        Object r1 = r0.a;
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L9:
        if ((!Intrinsics.areEqual(r0.g, "init")) == false) goto L15;
        if ((!Intrinsics.areEqual(r0.g, "finish")) == false) goto L15;
        boolean r2 = false;
    L16:
        monitor-exit(r1);
        if (r2 != true) goto L30;
        if (r9.P == true) goto L30;
        ECMallGulPrefetch r3 = r9.v();
        if (r3 == null) goto L34;
        List<String> r6 = r9.F();
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.r.b.b, "start prefetch gul ,page num is " + r9.M);
        ECHybridDataEngine r5 = r9.K;
        if (r5 == null) goto L26;
        DataEngineExtKt.a(r5, r9.G1, o(r9), r9.B1.w, r6, new com.bytedance.android.ec.hybrid.data.entity.a(Boolean.TRUE, 3), r3);
    L26:
        r3.g();
        return;
    L34:
        return;
    L15:
        r2 = true;
    L30:
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.r.b.b, "not all prefetch");
    }

    public static /* synthetic */ Map o(ECMallFeed r6) {
        return r6.n(r6.R, r6.S, r6.L, r6.M, null);
    }

    public final void L(boolean r8) {
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.r.b r1 = com.bytedance.android.ec.hybrid.log.mall.r.b.b;
        ECMallLogUtil.c(r1, "load more lock is " + this.P);
        if (this.A1.kn() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L86:
        com.bytedance.android.shopping.mall.feed.help.j r9 = this.e;
        if (r9 == null) goto L95;
        r9.e(this.A1.kn());
        return;
    L95:
        return;
    L10:
        if (this.P == true) goto L86;
        if (this.N == false) goto L86;
        ECMallFavoriteSectionHelper r3 = this.V;
        Integer r4 = this.R;
        if (r4 != null) goto L16;
        r3.getClass();
        boolean r5 = false;
    L17:
        if (r5 == true) goto L86;
        this.Z0 = false;
        ECMallGulRefresh r6 = w();
        if (r6 == null) goto L22;
        r6.a();
    L22:
        this.T0 = true;
        com.bytedance.android.shopping.mall.feed.help.j r7 = this.e;
        if (r7 == null) goto L25;
        r7.e(true);
    L25:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.d.b, "onLoadMore isManual = " + r8 + " , pageNum =" + this.M + " ,cursor =" + this.L + ", curTabId = " + this.R);
        E().a();
        com.bytedance.android.shopping.mall.homepage.pagecard.d r10 = this.G1;
        if (r10 == null) goto L31;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r11 = r10.a();
        if (r11 == null) goto L31;
        PageCard.e(r11.a, "ec.mallActionLoadMore", MapsKt.mapOf(new Pair("is_manual", Boolean.valueOf(r8))), 4);
    L31:
        if (this.Y != null) goto L33;
        this.Y = new i(this, e0());
    L33:
        i r12 = this.Y;
        if (r12 == null) goto L36;
        r12.a(true);
    L36:
        Logger.d("puffone-ECMallFeed#loadMoreFetch()", "猜喜loadMore");
        M();
        this.O++;
        final long r13 = System.currentTimeMillis();
        final List<String> r14 = F();
        com.bytedance.android.shopping.mall.feed.help.j r15 = this.e;
        if (r15 == null) goto L40;
        r15.c(r14, this.O);
    L40:
        if (v() == null) goto L84;
        ECMallGulPrefetch r16 = v();
        if (r16 == null) goto L91;
        Function2<HomePageDTO, ECHybridNetworkVO, Unit> r17 = new ECMallFeed$loadMoreFetch$1(this, r13);
        Function0<Unit> r18 = new ECMallFeed$loadMoreFetch$2(this, r14, r13);
        Intrinsics.checkNotNullParameter(r17, "success");
        Intrinsics.checkNotNullParameter(r18, CheckLoginParam.KEY_FAILED);
        ECMallLogUtil.c(r1, "load cache state is " + r16.g);
        Object r19 = r16.a;
        monitor-enter(r19);
        String r20 = r16.g;     // Catch: Throwable -> L81
        switch(r20.hashCode()) {
            case -1274442605: goto L70;
            case -180585540: goto L67;
            case 3237136: goto L64;
            case 1550783935: goto L49;
            default: goto L78;
        };     // Catch: Throwable -> L81
    L78:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(r19);
        return;
    L49:
        if (r20.equals("running") == false) goto L78;
        Lazy r22 = ECMallGulPrefetch.h;     // Catch: Throwable -> L81
        Integer r23 = ECMallGulPrefetch.Companion.a().f();     // Catch: Throwable -> L81
        if (r23 != null) goto L54;
    L62:
        ECMallLogUtil.c(r1, "wait reqeust invoke when strategy != 2");     // Catch: Throwable -> L81
        r16.g = "wait_result";     // Catch: Throwable -> L81
        r16.d = r17;     // Catch: Throwable -> L81
        r16.e = r18;     // Catch: Throwable -> L81
        goto L78
    L54:
        if (r23.intValue() != 2) goto L62;
        HomePageDTO r24 = r16.b;     // Catch: Throwable -> L81
        ECHybridNetworkVO r25 = r16.c;     // Catch: Throwable -> L81
        if (r24 == null) goto L61;
        if (r25 == null) goto L61;
        ECMallLogUtil.c(r1, "success invoke when strategy == 2");     // Catch: Throwable -> L81
        r17.invoke(r24, r25);     // Catch: Throwable -> L81
        r16.b = null;     // Catch: Throwable -> L81
        r16.g = "invalid_second";     // Catch: Throwable -> L81
        monitor-exit(r19);
        return;
    L61:
        r16.g = "init";     // Catch: Throwable -> L81
        r16.b = null;     // Catch: Throwable -> L81
        r16.e = null;     // Catch: Throwable -> L81
        r16.d = null;     // Catch: Throwable -> L81
        r18.invoke();     // Catch: Throwable -> L81
        goto L78
    L64:
        if (r20.equals("init") == false) goto L78;
        ECMallLogUtil.c(r1, "failed invoke");     // Catch: Throwable -> L81
        r18.invoke();     // Catch: Throwable -> L81
        goto L78
    L67:
        if (r20.equals("invalid_second") == false) goto L78;
        r16.e = r18;     // Catch: Throwable -> L81
        goto L78
    L70:
        if (r20.equals("finish") == false) goto L78;
        HomePageDTO r26 = r16.b;     // Catch: Throwable -> L81
        ECHybridNetworkVO r27 = r16.c;     // Catch: Throwable -> L81
        if (r26 == null) goto L77;
        if (r27 == null) goto L77;
        ECMallLogUtil.c(r1, "state finish wait reqeust invoke when strategy != 2");     // Catch: Throwable -> L81
        r17.invoke(r26, r27);     // Catch: Throwable -> L81
        r16.b = null;     // Catch: Throwable -> L81
        r16.g = "init";     // Catch: Throwable -> L81
        monitor-exit(r19);
        return;
    L77:
        ECMallLogUtil.c(r1, "state finish data is null failed invoke");     // Catch: Throwable -> L81
        r18.invoke();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    L91:
        return;
    L84:
        W(r14, r13);
        return;
    L16:
        r5 = r3.k.get(r4.intValue());
        goto L17
    L5:
        if (this.n1 != null) goto L7;
        r2 = true;
        goto L8
    }

    public final void O(boolean r6) {
        ILegouMallService r0 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
        if (r0 == null) goto L5;
        r0.c(B());
    L5:
        this.S0 = r6;
        if (r6 == true) goto L8;
    L10:
        this.j1 = null;
    L11:
        if (r6 == true) goto L14;
        this.T0 = false;
        this.U0 = false;
        return;
    L14:
        return;
    L8:
        if (this.U0 == false) goto L10;
        Lazy r2 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "need refresh gul by pitaya when visible");
        this.U0 = false;
        com.bytedance.android.shopping.mall.opt.g r3 = new com.bytedance.android.shopping.mall.opt.g("visibleRefresh", this.B1.c);
        JSONObject r4 = this.j1;
        Lazy r5 = ECMallGulRefresh.g;
        m(r4, r(ECMallGulRefresh.Companion.a().c()), false, r3);
        this.j1 = null;
        goto L11
    }

    public final void P(int r4) {
        if (((Boolean) this.e1.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        boolean r1 = true;
        if (r0 != null) goto L8;
    L9:
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 != null) goto L12;
    L31:
        this.X0.setValue(Float.valueOf(1.0f));
    L32:
        ECHybridListEngine r5 = this.J;
        if (r5 == null) goto L38;
        ECHybridRecyclerView r6 = r5.b;
        if (r6 == null) goto L39;
        r6.m0();
        return;
    L39:
        return;
    L38:
        return;
    L12:
        if (r2.isFoldDevice() != true) goto L31;
        int r3 = com.bytedance.android.ec.hybrid.list.util.c.a;
        if (r4 <= com.bytedance.android.ec.hybrid.list.util.c.d(600)) goto L31;
    L15:
        com.bytedance.android.shopping.api.mall.idl.a r7 = this.A1.Bi();
        if (r7 == null) goto L30;
        com.bytedance.android.shopping.api.mall.idl.c r8 = r7.a;
        if (r8 == null) goto L30;
        Integer r9 = r8.b;
        if (r9 == null) goto L30;
        if (r9.intValue() > 0) goto L25;
        r1 = false;
    L25:
        if (r1 == true) goto L28;
        r9 = null;
    L28:
        if (r9 == null) goto L30;
        int r10 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r4 = com.bytedance.android.ec.hybrid.list.util.c.d(r9);
    L30:
        MutableLiveData<Float> r11 = this.X0;
        int r12 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r11.setValue(Float.valueOf(r4 / com.bytedance.android.ec.hybrid.list.util.c.d(375)));
        goto L32
    L8:
        if (r0.isPadDevice() == true) goto L15;
        goto L9
    }

    public final void U(final int r2) {
        if (r2 <= 0) goto L5;
        CommonUtilKt.g(new ECMallFeed$preBindHolder$1(this, r2));
        return;
    }

    public final void V(final String r14) {
        Intrinsics.checkNotNullParameter(r14, "componentId");
        Lazy r0 = ECMallGeckoResourceHelper.a;
        if (ECMallGeckoResourceHelper.e(new ECMallFeed$preloadGeckoWhenShow$1(r14)) == false) goto L5;
        return;
    L5:
        List<PreloadGeckoConfig> r1 = this.h1;
        if (r1 == null) goto L42;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((PreloadGeckoConfig) r3).getComponentId(), r14) == false) goto L9;
    L14:
        PreloadGeckoConfig r4 = (PreloadGeckoConfig) r3;
        if (r4 == null) goto L43;
        com.bytedance.geckox.b r15 = com.bytedance.geckox.b.a.a;
        GeckoGlobalConfig r16 = com.bytedance.geckox.b.a();
        if (r16 == null) goto L19;
        GeckoGlobalConfig.ENVType r17 = r16.getEnv();
    L21:
        if (r17 == GeckoGlobalConfig.ENVType.PROD) goto L23;
        String r18 = r4.getAccessKeyDebug();
    L24:
        String r5 = r18;
        String r6 = r4.getChannelName();
        GeckoClient r19 = com.bytedance.geckox.a.a(r5);
        Map r7 = MapsKt.mapOf(TuplesKt.to(r5, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r4.getChannelName()))));
        OptionCheckUpdateParams r8 = new OptionCheckUpdateParams().setLazyUpdate(false).setEnableDownloadAutoRetry(true).setChannelUpdatePriority(3);
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("load_tag", "first")});
        Pair[] r10 = new Pair[1];
        if (r5 != null) goto L27;
        String r11 = "";
    L28:
        r10[0] = TuplesKt.to(r11, r9);
        r8.setCustomParam(MapsKt.mutableMapOf(r10));
        if (r5 != null) goto L31;
        String r12 = "";
    L32:
        if (r6 != null) goto L34;
        String r13 = "";
    L35:
        r8.setListener(new w(r6, r5, r8, r19, r7, r12, r13, this));
        if (r19 == null) goto L44;
        r19.checkUpdateMulti(null, r7, r8);
        return;
    L44:
        return;
    L34:
        r13 = r6;
        goto L35
    L31:
        r12 = r5;
        goto L32
    L27:
        r11 = r5;
        goto L28
    L23:
        r18 = r4.getAccessKeyOnline();
        goto L24
    L19:
        r17 = null;
        goto L21
    L43:
        return;
    L13:
        r3 = null;
        goto L14
    }

    public final void Z(RecyclerView.OnScrollListener r3) {
        Intrinsics.checkNotNullParameter(r3, "scrollListener");
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r0.b.addOnScrollListener(r3);
        return;
    }

    public final boolean a0(String r20) {
        if (this.P == false) goto L6;
        int r1 = com.bytedance.android.shopping.mall.feed.help.e.a;
        com.bytedance.android.shopping.mall.feed.help.e.a(false, "load_more_block", r20, this.B1.c);
        return false;
    L6:
        Integer r2 = ((com.bytedance.android.shopping.mall.feed.help.f) this.h.getValue()).b();
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        ECHybridListEngine r4 = this.J;
        if (r4 == null) goto L185;
        Integer r5 = r4.j();
        if (r5 == null) goto L204;
        int r6 = r5.intValue();
        ECHybridListEngine r7 = this.J;
        boolean r8 = true;
        if (r7 == null) goto L153;
        int r9 = (r6 + r3) + 1;
        DataResolver r10 = r7.c;
        r10.getClass();
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L19;
        EnsureManager.ensureNotReachHere("DataResolver#rmStartPosIfNotInWindow(), it's risky to invoke on non-ui thread");
    L19:
        if (r9 < 0) goto L27;
        ArrayList r11 = r10.i;
        if (r11 == null) goto L24;
        int r12 = r11.size();
    L25:
        if (r9 >= r12) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L153;
        if (r9 <= r10.a.findLastVisibleItemPosition()) goto L153;
        ArrayList r14 = r10.i;
        if (r14 == null) goto L43;
        ECHybridListItemVO r15 = (ECHybridListItemVO) CollectionsKt.getOrNull(r14, r9);
        if (r15 == null) goto L43;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r16 = r15.D;
        if (r16 == null) goto L40;
        int r17 = r16.a;
    L41:
        if (r17 > 1) goto L43;
    L40:
        r17 = 1;
    L43:
        ArrayList r18 = r10.i;
        if (r18 == null) goto L153;
        int r19 = r18.size() - r9;
        ArrayList r110 = new ArrayList();
        int r111 = r18.size();
        int r112 = r9;
    L46:
        if (r112 >= r111) goto L48;
        r110.addAll(((ECHybridListItemVO) ListProtector.get(r18, r112)).s);
        r112 = r112 + 1;
        goto L46
    L48:
        int r113 = r18.size() - r9;
        if (r9 < 0) goto L57;
        ArrayList r114 = r10.i;
        if (r114 == null) goto L54;
        int r115 = r114.size();
    L55:
        if (r9 >= r115) goto L57;
        boolean r116 = true;
    L58:
        if (r116 == false) goto L139;
        int r117 = r113 + r9;
        int r118 = r9;
        ECHybridListItemVO r119 = null;
    L61:
        if (r118 >= r117) goto L118;
        ArrayList r120 = r10.i;
        if (r120 == null) goto L65;
        ECHybridListItemVO r121 = (ECHybridListItemVO) ListProtector.get(r120, r9);
    L66:
        ArrayList r122 = r10.c;
        if (r121 == null) goto L116;
        if (r122 == null) goto L116;
        Iterator r123 = r122.iterator();
    L71:
        if (r123.hasNext() == false) goto L115;
        com.bytedance.android.ec.hybrid.list.entity.i r124 = (com.bytedance.android.ec.hybrid.list.entity.i) r123.next();
        ArrayList r21 = r124.i;
        if (r21 == null) goto L114;
        if (r21.contains(r121) != r8) goto L114;
        com.bytedance.android.ec.hybrid.list.ability.k r22 = (com.bytedance.android.ec.hybrid.list.ability.k) ((HashMap) r10.j).get(r124);
        if (r22 == null) goto L114;
        Intrinsics.checkNotNullParameter(r121, "item");
        ArrayList r125 = r22.h.i;
        if (r125 == null) goto L114;
        int r126 = r125.indexOf(r121);
        if (r126 < 0) goto L114;
        Iterator r23 = ((ArrayList) r22.e).iterator();
        int r24 = -1;
        int r127 = 0;
    L85:
        if (r23.hasNext() == false) goto L95;
        Object r128 = r23.next();
        int r129 = r127 + 1;
        if (r127 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        com.bytedance.android.ec.hybrid.list.ability.k.b r25 = (com.bytedance.android.ec.hybrid.list.ability.k.b) r128;
        Iterator r130 = r23;
        int r26 = r25.a;
        int r27 = r25.b;
        if (r26 > r126) goto L94;
        if (r27 < r126) goto L94;
        r24 = r127;
    L94:
        r23 = r130;
        r127 = r129;
        goto L85
    L95:
        int r28 = ((ArrayList) r22.f).size();
        if (r24 < 0) goto L99;
        if (r28 <= r24) goto L99;
    L100:
        com.bytedance.android.ec.hybrid.list.ability.k.b r29 = (com.bytedance.android.ec.hybrid.list.ability.k.b) ListProtector.get(r22.e, r24);
        vn.l r30 = (com.bytedance.android.ec.vlayout.a) ListProtector.get(r22.f, r24);
        ArrayList r131 = r22.h.i;
        if (r131 == null) goto L107;
        Iterator r132 = r131.subList(r126, r131.size()).iterator();
    L104:
        if (r132.hasNext() == false) goto L107;
        r29.a((ECHybridListItemVO) r132.next());
        com.bytedance.android.ec.hybrid.list.ability.m.b(r30);
    L107:
        if ((r30 instanceof vn.l) == false) goto L109;
        com.bytedance.android.ec.hybrid.list.ability.m.a(r30, r9 - 1);
    L109:
        int r31 = r24 + 1;
        if (r31 >= ((ArrayList) r22.e).size()) goto L112;
        ArrayList r32 = (ArrayList) r22.e;
        r32.subList(r31, r32.size()).clear();
        ArrayList r33 = (ArrayList) r22.f;
        r33.subList(r31, r33.size()).clear();
    L112:
        r22.i();
    L99:
        if (((ArrayList) r22.e).size() != ((ArrayList) r22.f).size()) goto L100;
    L114:
        r117 = r117;
        r123 = r123;
        r8 = true;
        goto L71
    L115:
        int r133 = r117;
        r119 = r121;
    L117:
        r118 = r118 + 1;
        r117 = r133;
        r8 = true;
    L116:
        r133 = r117;
        goto L117
    L65:
        r121 = null;
        goto L66
    L118:
        if (r119 == null) goto L139;
        ArrayList r34 = r10.c;
        if (r34 == null) goto L139;
        int r35 = r34.size();
        int r36 = 0;
        int r37 = -1;
    L122:
        if (r36 >= r35) goto L132;
        ArrayList r134 = ((com.bytedance.android.ec.hybrid.list.entity.i) ListProtector.get(r34, r36)).i;
        if (r134 != null) goto L126;
    L128:
        int r135 = -1;
        if (r37 != (-1)) goto L134;
        r36 = r36 + 1;
    L134:
        if (r37 >= (r34.size() + r135)) goto L139;
        List r38 = r34.subList(r37 + 1, r34.size());
        Iterator r39 = r38.iterator();
    L137:
        if (r39.hasNext() == false) goto L139;
        ((HashMap) r10.j).remove((com.bytedance.android.ec.hybrid.list.entity.i) r39.next());
        r38.clear();
        goto L137
    L126:
        if (r134.contains(r119) == false) goto L128;
        r134.subList(r134.indexOf(r119), r134.size()).clear();
        r37 = r36;
        goto L128
    L132:
        r135 = -1;
    L139:
        r18.subList(r9, r18.size()).clear();
        r10.p.notifyItemRangeRemoved(r9, r18.size() - r9);
        ECHybridListItemVO r40 = (ECHybridListItemVO) CollectionsKt.lastOrNull(r18);
        if (r40 == null) goto L151;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r41 = r40.D;
        if (r41 == null) goto L151;
        Integer r42 = r41.h;
        if (r42 == null) goto L151;
        int r43 = r42.intValue();
        int r44 = r41.b;
        if (r44 < 0) goto L151;
        int r45 = r41.c;
        if (r45 < 0) goto L151;
        int r46 = (r43 - (r45 - r44)) + 1;
    L152:
        com.bytedance.android.ec.hybrid.data.j r47 = new com.bytedance.android.ec.hybrid.data.j(r19, r110, Integer.valueOf(r46));
    L154:
        if (r47 != null) goto L158;
        return false;
    L158:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L167;
        Integer r48 = r47.c;
        if (r48 == null) goto L162;
        int r49 = r48.intValue();
    L163:
        if (r49 >= 0) goto L167;
        return false;
    L162:
        r49 = -1;
    L167:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L173;
        Integer r50 = r47.c;
        if (r50 == null) goto L171;
        int r51 = r50.intValue();
    L172:
        int r52 = Math.max(r51, this.g0 + r3);
    L174:
        this.L = r52;
        Integer r53 = this.R;
        if (r53 == null) goto L177;
        this.V.E(r53.intValue(), this.M, this.L, this.N);
    L177:
        List r54 = r47.b;
        if (r54 == null) goto L183;
        Iterator r55 = r54.iterator();
    L181:
        if (r55.hasNext() == false) goto L203;
        this.V.z((String) r55.next());
        goto L181
    L203:
        return true;
    L183:
        return true;
    L171:
        r51 = -1;
        goto L172
    L173:
        r52 = r3 + this.g0;
    L151:
        r46 = -1;
        goto L152
    L54:
        r115 = 0;
    L57:
        r116 = false;
        goto L58
    L24:
        r12 = 0;
    L27:
        r13 = false;
    L153:
        r47 = null;
        goto L154
    L204:
        return false;
    L185:
        return false;
    L9:
        r3 = 2;
        goto L10
    }

    public final void h(ImpressionItem r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r0 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r10.getId()) == false) goto L46;
        String r1 = r10.getType() + '_' + r10.getId();
        boolean r2 = false;
        if (((Boolean) this.y1.getValue()).booleanValue() == false) goto L20;
        ECMallFavoriteSectionHelper r3 = this.V;
        r3.getClass();
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r1, "filter");
        r3.j("filters");
        if (r1.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L21;
        com.bytedance.android.shopping.mall.homepage.tools.s r8 = (com.bytedance.android.shopping.mall.homepage.tools.s) ((LinkedHashMap) r3.a).get("filters");
        if (r8 == null) goto L19;
        Map<K, Object> r9 = r8.snapshot();
        if (r9 == 0) goto L19;
        if (r9.containsKey(r1) == true) goto L21;
    L19:
        r3.c(r1);
    L21:
        Integer r4 = this.R;
        if (r4 == null) goto L36;
        r4.intValue();
        if (((Boolean) this.y1.getValue()).booleanValue() == false) goto L34;
        ECMallFavoriteSectionHelper r5 = this.V;
        String r11 = String.valueOf(this.R);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "tabId");
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r1, "filter");
        com.bytedance.android.shopping.mall.homepage.tools.s<String> r6 = r5.o(r11, "filters");
        if (r1.length() <= 0) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L36;
        Map<String, Object> r12 = r6.snapshot();
        if (r12 != null) goto L32;
    L33:
        r6.a(r1);
        goto L36
    L32:
        if (r12.containsKey(r1) == true) goto L36;
    L34:
        this.V.d(String.valueOf(this.R), r1);
    L36:
        if (r10.getType() != 1) goto L41;
        ECMallFavoriteSectionHelper.K.getClass();
        if (ECMallFavoriteSectionHelper.a.a().c() == null) goto L41;
        this.V.b("live_filters", String.valueOf(r10.getId()));
        return;
    L41:
        if (r10.getType() != 2) goto L48;
        ECMallFavoriteSectionHelper.K.getClass();
        if (ECMallFavoriteSectionHelper.a.a().e() == null) goto L49;
        this.V.b("product_filters", String.valueOf(r10.getId()));
        return;
    L49:
        return;
    L48:
        return;
    L11:
        r7 = false;
        goto L12
    L20:
        this.V.c(r1);
        goto L21
    }

    public final void i(Map<String, ? extends Object> r4) {
        ImpressionItem r5 = (ImpressionItem) com.bytedance.android.shopping.api.mall.common.tools.p.a(com.bytedance.android.shopping.api.mall.common.tools.p.c(r4), ImpressionItem.class);     // Catch: Exception -> L23
        ECMallCommonImpressionReportHelper.b r0 = t();     // Catch: Exception -> L23
        if (r0 == null) goto L19;
        if (r0.a != true) goto L19;
        ECMallCommonImpressionReportHelper r1 = u();     // Catch: Exception -> L23
        if (r1 == null) goto L21;
        Intrinsics.checkNotNullParameter(r5, "item");     // Catch: Exception -> L23
        if (r1.g == true) goto L21;
        if (r1.b.add(r5) == false) goto L21;
        int r2 = r1.i.c;     // Catch: Exception -> L23
        if (r2 <= 0) goto L21;
        if (r1.b.size() < r2) goto L21;
        r1.a.post(new com.bytedance.android.shopping.api.mall.common.feed.help.a(r1));     // Catch: Exception -> L23
    L21:
        h(r5);     // Catch: Exception -> L23
        return;
    L19:
        if (((CopyOnWriteArrayList) this.Z).contains(r5) == true) goto L21;
        ((CopyOnWriteArrayList) this.Z).add(r5);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public final void i0(boolean r3) {
        Iterator<com.bytedance.android.shopping.mall.homepage.card.live.c> r0 = this.h0.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().Y1();
        goto L4
    L7:
        if (r3 == false) goto L13;
        ECHybridListEngine r4 = this.J;
        if (r4 == null) goto L21;
        ECHybridRecyclerView r5 = r4.b;
        if (r5 == null) goto L21;
        r5.smoothScrollToPosition(0);
    L21:
        p r6 = this.f;
        if (r6 == null) goto L24;
        r6.a();
    L24:
        ECHybridListEngine r7 = this.J;
        if (r7 == null) goto L29;
        r7.e = null;
        r7.f = null;
        return;
    L29:
        return;
    L13:
        ECHybridListEngine r8 = this.J;
        if (r8 == null) goto L18;
        ECHybridRecyclerView r9 = r8.b;
        if (r9 == null) goto L18;
        r9.scrollToPosition(0);
    L18:
        this.Q = 0;
        Function2<? super Integer, ? super Boolean, Unit> r10 = this.J0;
        if (r10 == null) goto L21;
        Unit r11 = (Unit) r10.invoke(0, Boolean.TRUE);
        goto L21
    }

    public final void k0(Integer r3) {
        this.R = r3;
        Iterator<T> r0 = this.k1.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e93.e) r0.next()).onTabChange(r3);
        goto L4
    }

    public final String r(Integer r7) {
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L44;
        ECHybridRecyclerView r2 = r0.b;
        View r4 = r2.getChildAt(0);
        if (r4 == null) goto L12;
        RecyclerView.ViewHolder r3 = r2.getChildViewHolder(r4);
        if (r3 == null) goto L9;
        Integer r5 = Integer.valueOf(r3.getAdapterPosition());
    L10:
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
    L14:
        if (r6 < 0) goto L31;
        ArrayList r1 = r0.c.i;
        if (r1 == null) goto L30;
        int r8 = r1.size();
        if (r6 < 0) goto L22;
        if (r8 <= r6) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L25;
        ArrayList r10 = r1;
    L26:
        if (r10 == null) goto L29;
        List r11 = r10.subList(r6, r1.size());
        if (r11 == null) goto L29;
    L32:
        if (r11 == null) goto L44;
        if (r7 != null) goto L35;
    L42:
        this.V.getClass();
        return ECMallFavoriteSectionHelper.l(r11);
    L35:
        if ((!r11.isEmpty()) == false) goto L42;
        int r12 = r11.size();
        int r13 = r7.intValue();
        if (r13 < 0) goto L42;
        if (r12 < r13) goto L42;
        ECMallFavoriteSectionHelper r14 = this.V;
        List r15 = r11.subList(0, r7.intValue());
        r14.getClass();
        return ECMallFavoriteSectionHelper.l(r15);
    L29:
        r11 = CollectionsKt.emptyList();
        goto L32
    L25:
        r10 = null;
    L22:
        r9 = false;
        goto L23
    L30:
        r11 = CollectionsKt.emptyList();
        goto L32
    L31:
        r11 = null;
        goto L32
    L9:
        r5 = null;
    L12:
        r6 = -1;
    L44:
        return null;
    }

    public final void u0(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.b.b, "updateFeedbackInfo params: " + r5 + ' ');
        Set<String> r1 = this.d0;
        StringBuilder r2 = new StringBuilder();
        r2.append(r5.get("type"));
        r2.append('_');
        r2.append(r5.get("itemType"));
        r2.append('_');
        r2.append(r5.get("itemId"));
        r1.add(r2.toString());
    }

    public static final void g(ECMallFeed r8, Map r9) {
        com.bytedance.android.ec.hybrid.list.e r0 = r8.B1.z;
        if (r0 == null) goto L32;
        String r1 = r0.a;
        if (r1 == null) goto L36;
        Object r2 = r8.A1.getPageInfo().get("enterMethod");
        if ((r2 instanceof String) == true) goto L10;
        r2 = null;
    L10:
        String r3 = (String) r2;
        if (r3 == null) goto L37;
        List<String> r7 = ((aa3.h) r8.f1.getValue()).b();
        if (r7 == null) goto L38;
        List<String> r4 = ((aa3.h) r8.f1.getValue()).a();
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4.contains(r3) == true) goto L24;
        int r5 = StringsKt.split$default(r1, new String[]{"."}, false, 0, 6, null).size();
        boolean r6 = true;
        if (r5 <= 1) goto L24;
    L25:
        if (r6 == true) goto L27;
        return;
    L27:
        if (r8.R0 == false) goto L35;
        Iterator<T> r10 = r7.iterator();
    L30:
        if (r10.hasNext() == false) goto L40;
        r9.remove((String) r10.next());
        goto L30
    L40:
        return;
    L35:
        return;
    L24:
        r6 = false;
        goto L25
    L38:
        return;
    L37:
        return;
    L36:
        return;
    }

    public static void g0(ECMallFeed r3, Function0 r4) {
        r3.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r4.invoke();
        return;
    L5:
        r3.i.postDelayed(new m0(r4), 0);
    }

    public static String s(ECMallFeed r2, String r3) {
        return r2.A1.ZK(r3, false, null);
    }

    public final void R(com.bytedance.android.shopping.api.mall.common.tools.d r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("previous_page", this.A1.getGlobalProps().get("previous_page"));
        r0.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.A1.getGlobalProps().get(PdpOpenThirdParam.KEY_PAGE_NAME));
        r0.put("click_type", "draw");
        r0.put("action", r5);
        String r6 = null;
        if (r4 == null) goto L5;
        String r1 = r4.b;
    L6:
        r0.put("tab_name", r1);
        if (r4 == null) goto L11;
        Integer r2 = r4.d;
        if (r2 == null) goto L11;
        String r3 = String.valueOf(r2.intValue());
    L12:
        r0.put("tab_type", r3);
        if (r4 == null) goto L15;
        Integer r7 = Integer.valueOf(r4.c);
    L16:
        r0.put("order", r7);
        if (r4 == null) goto L19;
        r6 = String.valueOf(r4.a);
    L19:
        r0.put("tab_id", r6);
        Unit r8 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("click_ecommerce_module_entrance", r0);
        return;
    L15:
        r7 = null;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void W(List<String> r11, long r12) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "real start to load more fetch, apikey is " + com.bytedance.android.shopping.api.mall.common.tools.b0.i(r11));
        ECHybridDataEngine r2 = this.K;
        if (r2 == null) goto L6;
        DataEngineExtKt.a(r2, this.G1, o(this), this.B1.w, r11, new com.bytedance.android.ec.hybrid.data.entity.a(Boolean.TRUE, 3), new LoadMoreCallBack(this, r12));
        return;
    }

    public final void c0(final String r6, final Integer r7) {
        if (r7 != null) goto L7;
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "ECMallFeed#reportMemoryStatus, " + r6 + ", timestamp = " + System.currentTimeMillis());
        IECMallPerformanceService r9 = (IECMallPerformanceService) this.r1.getValue();
        if (r9 == null) goto L9;
        r9.a(this.q1, r6, null);
        return;
    L9:
        return;
    L7:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "ECMallFeed#reportMemoryStatus, " + r6 + ", invokeTimestamp = " + System.currentTimeMillis() + ", delayFrameCount = " + r7);
        ECHybridExtensionsKt.e(r7.intValue(), new ECMallFeed$reportMemoryStatus$1(this, r6, r7));
    }

    public final void l(String r5, Function0 r6) {
        boolean r1 = true;
        if (((com.bytedance.android.shopping.mall.feed.help.f) this.h.getValue()).a(this.B1.c) != 1) goto L35;
        Integer r0 = this.D1;
        if (r0 != null) goto L7;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L35;
        ECMallFavoriteSectionHelper r3 = this.V;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "lastAction");
        if (r3.s.get(r5) == null) goto L17;
        r1 = false;
    L17:
        r3.s.put(r5, com.bytedance.android.shopping.mall.homepage.tools.o.a);
        if (r1 == true) goto L38;
        if (r6 == null) goto L43;
        Unit r7 = (Unit) r6.invoke();
        return;
    L43:
        return;
    L38:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
        if (a0(r5) == false) goto L22;
        q(r5, r6);     // Catch: Throwable -> L27
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L27
    L30:
        if (Result.exceptionOrNull-impl(r9) == null) goto L40;
        if (r6 == null) goto L41;
        Unit r10 = (Unit) r6.invoke();
        return;
    L41:
        return;
    L40:
        return;
    L22:
        if (r6 == null) goto L24;
        r8 = (Unit) r6.invoke();     // Catch: Throwable -> L27
        goto L25
    L24:
        r8 = null;
    L27:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L7:
        if (r0.intValue() == 0) goto L11;
        if (((Boolean) MallFixSetting.b.getValue()).booleanValue() == false) goto L11;
        r2 = false;
    L35:
        if (r6 == null) goto L45;
        Unit r12 = (Unit) r6.invoke();
        return;
    }

    public final void p0(RecyclerView r3, int r4) {
        RecyclerView.LayoutManager r5 = r3.getLayoutManager();
        if ((r5 instanceof VirtualLayoutManager) == true) goto L5;
        r5 = null;
    L5:
        final VirtualLayoutManager r6 = (VirtualLayoutManager) r5;
        Integer r7 = (Integer) kk.d.a(null, new ECMallFeed$syncScrollY$scrollDy$1(r6));
        if (r7 == null) goto L8;
        int r8 = -r7.intValue();
    L9:
        this.Q = r8;
        return;
    L8:
        r8 = this.Q + r4;
        goto L9
    }

    public final void q(String r11, Function0 r12) {
        boolean r2 = false;
        if (this.A1.kn() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (this.N == false) goto L28;
        ECMallFavoriteSectionHelper r1 = this.V;
        Integer r3 = this.R;
        if (r3 != null) goto L14;
        r1.getClass();
    L15:
        if (r2 == true) goto L30;
        M();
        if (this.Y != null) goto L20;
        this.Y = new i(this, e0());
    L20:
        i r4 = this.Y;
        if (r4 == null) goto L23;
        r4.a(true);
    L23:
        List<String> r7 = F();
        ECHybridDataEngine r5 = this.K;
        if (r5 == null) goto L29;
        DataEngineExtKt.a(r5, this.G1, o(this), this.B1.w, r7, null, new j(this, r11, r12));
        return;
    L29:
        return;
    L30:
        return;
    L14:
        r2 = r1.k.get(r3.intValue());
        goto L15
    L28:
        return;
    L5:
        if (this.n1 != null) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(String r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r4 != null) goto L10;
        DynamicApiDTO r5 = (DynamicApiDTO) GsonProtectorUtils.fromJson(new Gson(), r3, DynamicApiDTO.class);
        if (r5 == null) goto L9;
        DynamicApiParamDTO r6 = r5.getBffDynamicStruct();
        if (r6 == 0) goto L9;
        r4 = r6.getDynamicParams();
    L9:
        r4 = null;
    L10:
        if (r4 == null) goto L13;
        String r7 = com.bytedance.android.shopping.api.mall.common.tools.b0.m(r4);
        if (r7 == null) goto L13;
    L14:
        com.bytedance.android.shopping.mall.homepage.pagecard.d r8 = this.G1;
        if (r8 == null) goto L20;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r9 = r8.a();
        if (r9 == null) goto L21;
        r9.e(r2, r7);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r7 = "";
        goto L14
    }

    public final void X(String r3, boolean r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "lastActionInfo");
    L4:
        if (((ArrayList) this.I).size() < this.B1.r) goto L8;
        if ((!((ArrayList) this.I).isEmpty()) == false) goto L8;
        ListProtector.remove(this.I, 0);
    L8:
        ((ArrayList) this.I).add(r3);
        if (((com.bytedance.android.shopping.mall.settings.a) MallOptUtil.e.getValue()).a(this.B1.c) == false) goto L11;
        this.w1 = new x(this, r3, r4, r5);
        return;
    L11:
        l(r3, r5);
    }

    public final void j0(com.bytedance.android.ec.hybrid.list.entity.k r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "listVO");
        if (K() == false) goto L9;
        ECHybridListEngine r0 = this.J;
        if (r0 == null) goto L9;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L9;
        Lazy r2 = ECHybridRecyclerView.S;
        r1.d0(true, false);
    L9:
        n0(r9, r10, r11, true, "cache", false, null);
    }

    public final void o0(String r18, com.bytedance.android.shopping.api.mall.common.tools.d r19, boolean r20) {
        long r4 = System.currentTimeMillis();
        if (this.J != null) goto L5;
        return;
    L5:
        ECMallFavoriteSectionHelper r0 = this.V;
        int r1 = r19.a;
        Map.Entry r2 = (Map.Entry) CollectionsKt.firstOrNull(((LinkedHashMap) r0.f).entrySet());
        if (r2 == null) goto L8;
        com.bytedance.android.ec.hybrid.list.entity.i r3 = (com.bytedance.android.ec.hybrid.list.entity.i) r2.getValue();
    L9:
        if (r3 == null) goto L15;
        ArrayList r5 = r3.i;
        if (r5 == null) goto L15;
        ECHybridListItemVO r6 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L15;
        Object r7 = r6.T;
    L17:
        if ((r7 instanceof BaseViewHolder) == true) goto L19;
        r7 = null;
    L19:
        BaseViewHolder r8 = (BaseViewHolder) r7;
        if (r8 == null) goto L22;
        r8.i4(MapsKt.mapOf(TuplesKt.to("tab_id", Integer.valueOf(r1))));
    L22:
        ECMallFeed$switchTab$scrollToCategory$1 r9 = new ECMallFeed$switchTab$scrollToCategory$1(this, r20);
        ArrayList r11 = new ArrayList();
        ECHybridListEngine r10 = this.J;
        if (r10 == null) goto L63;
        List<View> r12 = com.bytedance.android.shopping.api.mall.common.tools.b0.b(r10.b);
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
        int r15 = 0;
    L26:
        if (r14.hasNext() == false) goto L51;
        Object r16 = r14.next();
        View r17 = (View) r16;
        ECHybridListEngine r110 = this.J;
        if (r110 == null) goto L50;
        RecyclerView.ViewHolder r111 = r110.b.findContainingViewHolder(r17);
        if (r111 == null) goto L48;
        int r112 = r111.getAdapterPosition();
        r15 = Math.max(r112, r15);
        if (r17.getTranslationX() != 0.0f) goto L44;
        ECHybridListEngine r113 = this.J;
        if (r113 == null) goto L43;
        com.bytedance.android.ec.hybrid.list.ability.v r21 = (com.bytedance.android.ec.hybrid.list.ability.v) r113.getAbility(com.bytedance.android.ec.hybrid.list.ability.v.class);
        if (r21 == null) goto L38;
        String r22 = r21.Ag(r112);
    L40:
        if (Intrinsics.areEqual(r22, "favorite_section") == false) goto L44;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L26;
        r13.add(r16);
        goto L26
    L38:
        r22 = null;
        goto L40
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());
    L44:
        r23 = false;
        goto L45
    L48:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
    L50:
        throw new IllegalArgumentException("Required value was null.".toString());
    L51:
        r11.addAll(r13);
        Integer r24 = this.R;
        k0(Integer.valueOf(r19.a));
        ECHybridListEngine r25 = this.J;
        if (r25 == null) goto L61;
        r25.b.setOnTouchListener(a0.a);
        ECMallFavoriteSectionHelper r114 = this.V;
        Context r115 = e0();
        ECMallFeed$switchTab$3 r116 = new ECMallFeed$switchTab$3(this, r24, r9, r4, r11, r19, r18);
        r114.getClass();
        Intrinsics.checkNotNullParameter(r115, "context");
        Intrinsics.checkNotNullParameter(r18, "action");
        Intrinsics.checkNotNullParameter(r11, "gylViews");
        Intrinsics.checkNotNullParameter(r116, "animateEndCallback");
        ValueAnimator r26 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        int r27 = UIUtils.getScreenWidth(r115);
        if (Intrinsics.areEqual(r18, "next") == false) goto L56;
    L57:
        r27 = -r27;
    L58:
        r26.addUpdateListener(new com.bytedance.android.shopping.mall.homepage.tools.j(r11, r27));
        r26.addListener(new com.bytedance.android.shopping.mall.homepage.tools.k(r116));
        r26.setDuration(200);
        r26.start();
        return;
    L56:
        if (Intrinsics.areEqual(r18, "landing") == false) goto L58;
    L61:
        throw new IllegalArgumentException("Required value was null.".toString());
    L63:
        throw new IllegalArgumentException("Required value was null.".toString());
    L15:
        r7 = null;
        goto L17
    L8:
        r3 = null;
        goto L9
    }

    public final boolean p(final FavRefreshParams r22, final Function0<Unit> r23, final Function0<Integer> r24) {
        if (r24 == null) goto L7;
        Integer r1 = (Integer) r24.invoke();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        boolean r3 = false;
        if (r2 == 1) goto L16;
        if (r22 == null) goto L14;
        com.bytedance.android.shopping.mall.opt.g r0 = r22.d;
        if (r0 == null) goto L14;
        r0.a(false, 1, r2);
    L14:
        return false;
    L16:
        if (this.P == false) goto L18;
    L21:
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "has refresh or loadMore, can not refresh");
        boolean r5 = false;
    L22:
        if (r5 == true) goto L26;
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "request check error ");
        return false;
    L26:
        if (w() == null) goto L50;
        ECMallGulRefresh r7 = w();
        if (r7 == null) goto L44;
        Object r8 = r7.a;
        monitor-enter(r8);
    L41:
        th = move-exception;
        throw th;
    L32:
        if (Intrinsics.areEqual(r7.d, "init") == true) goto L37;
        if (Intrinsics.areEqual(r7.d, "finish") == true) goto L37;
        boolean r9 = false;
    L38:
        monitor-exit(r8);
        if (r9 == true) goto L50;
    L37:
        r9 = true;
    L44:
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "request check error by gul refresh handle ");
        if (r22 == null) goto L49;
        com.bytedance.android.shopping.mall.opt.g r11 = r22.d;
        if (r11 == null) goto L49;
        r11.a(false, 1, 1008);
    L49:
        return false;
    L50:
        final Ref.IntRef r12 = new Ref.IntRef();
        r12.element = 0;
        if (r22 != null) goto L53;
    L59:
        Integer r13 = this.R;
        if (r13 == null) goto L65;
        if (r13.intValue() != 0) goto L65;
    L66:
        Iterator<T> r14 = this.k1.iterator();
    L68:
        if (r14.hasNext() == false) goto L70;
        ((e93.e) r14.next()).initOrRefresh(true, this.R);
    L70:
        ECMallGulRefresh r15 = w();
        if (r15 == null) goto L73;
        r15.c();
    L73:
        Lazy r16 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "start refresh gul, request data");
        this.A1.h10();
        com.bytedance.android.shopping.mall.homepage.pagecard.d r17 = this.G1;
        Map<String, ? extends Object> r18 = null;
        if (r17 == null) goto L76;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r19 = r17.a();
    L77:
        if (r19 == null) goto L85;
        PageCard r20 = r19.a;
        if (r20 == null) goto L85;
        if (r20.c() == true) goto L85;
        if (y() == false) goto L85;
        r3 = true;
    L85:
        if (r22 == null) goto L89;
        Map<String, Object> r21 = r22.b;
        if (r21 == null) goto L89;
        Object r25 = r21.get("skip_reset_params");
    L91:
        if ((r25 instanceof Boolean) == true) goto L93;
        r25 = null;
    L93:
        Boolean r26 = (Boolean) r25;
        if (r19 != null) goto L96;
    L106:
        ECMallFavoriteSectionHelper r110 = this.V;
        Context r111 = e0();
        int r27 = r12.element;
        if (r22 == null) goto L109;
        r18 = r22.b;
    L109:
        r110.B(r111, r27, true, r18, new ECMallFeed$commonGulRefresh$4(this, r22, r12, r24, r23));
    L110:
        return true;
    L96:
        if (Intrinsics.areEqual(r26, Boolean.TRUE) == true) goto L100;
        if (r3 == true) goto L106;
        if (r19.a.a() == true) goto L106;
    L100:
        List<String> r112 = CollectionsKt.listOf("favorite_feed");
        Map<String, ? extends Object> r113 = o(this);
        if (r22 == null) goto L105;
        Map<String, Object> r28 = r22.b;
        if (r28 == null) goto L105;
        r113.putAll(r28);
    L105:
        Unit r29 = Unit.INSTANCE;
        r19.g(r112, r113, this.B1.w, new ECMallFeed$commonGulRefresh$3(this, r12, r22, r24, r23));
    L89:
        r25 = null;
        goto L91
    L76:
        r19 = null;
    L65:
        if (this.R != null) goto L70;
    L53:
        if (r22.c != true) goto L59;
        Integer r30 = this.R;
        if (r30 == null) goto L57;
        int r31 = r30.intValue();
    L58:
        r12.element = r31;
        goto L59
    L57:
        r31 = 0;
        goto L58
    L18:
        if (this.A1.JQ() == true) goto L21;
        r5 = true;
    L7:
        r2 = 1;
        goto L8
    }

    public final void v0(Integer r2, boolean r3, String r4) {
        if (r2 != null) goto L5;
    L11:
        boolean r5 = false;
    L12:
        if (r4 == null) goto L14;
        if (r5 == false) goto L14;
        return;
    L14:
        this.N = r3;
        return;
    L5:
        if (r2.intValue() != 308) goto L11;
        if (Intrinsics.areEqual(r4, "tomorrow_delivery_tab_tomorrow") == false) goto L9;
    L10:
        r5 = true;
        goto L12
    L9:
        if (Intrinsics.areEqual(r4, "tomorrow_delivery_tab_next_day") == false) goto L11;
        goto L10
    }

    public final Integer I(String r18, HomePageDTO r19, ECHybridNetworkVO r20, String r21) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "handleLoadMoreSucc");
        if (r19 != null) goto L5;
        final HomePageDTO r7 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r18, HomePageDTO.class);
    L6:
        int r1 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(this.G0) == true) goto L9;
    L28:
        if (r7 == null) goto L35;
        HomePageBffDTO r2 = r7.getBff();
        if (r2 == null) goto L35;
        BffBizInfo r3 = r2.getBizInfo();
        if (r3 == null) goto L35;
        String r4 = r3.getRequestId();
        if (r4 == null) goto L35;
    L36:
        if (r7 == null) goto L40;
        HomePageBffDTO r5 = r7.getBff();
        if (r5 == null) goto L40;
        ECHybridListDTO r6 = r5.getFeed();
    L42:
        if (r6 != null) goto L44;
        int r8 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a("favorite_feed", "favorite_feed->feed data is null", r4, this.B1.t);
    L44:
        if (r7 == null) goto L50;
        HomePageBffDTO r9 = r7.getBff();
        if (r9 == null) goto L50;
        ECHybridListDTO r10 = r9.getFeed();
        if (r10 == null) goto L50;
        List r11 = r10.getSections();
    L51:
        if (r11 == null) goto L61;
        if (r7 == null) goto L63;
        HomePageBffDTO r12 = r7.getBff();
        if (r12 == null) goto L63;
        ECHybridListDTO r13 = r12.getFeed();
        if (r13 == null) goto L63;
        List r14 = r13.getSections();
        if (r14 == null) goto L63;
        if (r14.isEmpty() == true) goto L61;
    L63:
        if (r7 == null) goto L106;
        final Ref.IntRef r15 = new Ref.IntRef();
        ListEngineOptConfig r16 = this.B1.y;
        if (r16 == null) goto L106;
        int r17 = this.M;
        Integer r22 = r16.n;
        if (r22 == null) goto L69;
        int r23 = r22.intValue();
    L70:
        if (r17 > r23) goto L72;
        Integer r24 = r16.m;
    L73:
        if (r24 == null) goto L106;
        int r25 = r24.intValue();
        r15.element = r25;
        if (r25 == 0) goto L106;
        final ArrayList r26 = new ArrayList();
        HomePageBffDTO r27 = r7.getBff();
        if (r27 == null) goto L106;
        ECHybridListDTO r28 = r27.getFeed();
        if (r28 == null) goto L106;
        List r29 = r28.getSections();
        if (r29 == null) goto L106;
        Iterator r30 = r29.iterator();
    L85:
        if (r30.hasNext() == false) goto L106;
        ArrayList r31 = ((ECHybridListSectionDTO) r30.next()).getItems();
        if (r31 == null) goto L85;
        Iterator r32 = r31.iterator();
    L90:
        if (r32.hasNext() == false) goto L85;
        ECNAMallCardExtra r33 = ((ECHybridListItemDTO) r32.next()).getExtra();
        if (r33 == null) goto L99;
        r26.add(r33);
        DataEngineWrapper r34 = this.C1;
        if (r34 == null) goto L96;
        Integer r35 = Integer.valueOf(r34.E(r33));
    L97:
        if (r35 == null) goto L99;
        int r36 = r35.intValue();
    L100:
        int r37 = r15.element - r36;
        r15.element = r37;
        if (r37 > 0) goto L90;
        Function0<Unit> r38 = new ECMallFeed$preloadImageOnLoadMoreSuccess$$inlined$run$lambda$1(r26, this, r7, r15);
        if (((Boolean) MallOptUtil.m.getValue()).booleanValue() == false) goto L105;
        BuildersKt.launch$default((CoroutineScope) this.y0.getValue(), null, null, new ECMallFeed$preloadImageOnLoadMoreSuccess$1$1$1$1(r38, null), 3, null);
        goto L106
    L105:
        r38.invoke();
        goto L106
    L96:
        r35 = null;
    L99:
        r36 = 0;
        goto L100
    L72:
        r24 = r16.l;
        goto L73
    L69:
        r23 = 0;
    L106:
        this.A1.MT();
        if (r7 == null) goto L111;
        HomePageBffDTO r39 = r7.getBff();
        if (r39 == null) goto L111;
        final ECHybridListDTO r110 = r39.getFeed();
    L112:
        if (r110 != null) goto L114;
    L446:
        r7 = r7;
    L447:
        HomePageDTO r40 = r7;
        this.V.H(r40, this.M);
        com.bytedance.android.shopping.mall.feed.help.j r41 = this.e;
        if (r41 == null) goto L450;
        r41.f(r21, true, r40, Boolean.valueOf(this.N));
    L450:
        this.i.post(new u(this, r40));
        return null;
    L114:
        if (this.J == null) goto L446;
        this.M++;
        this.L = r110.getCursor();
        Object r42 = r20.b().get("tab_id");
        if ((r42 instanceof Integer) == true) goto L118;
        r42 = null;
    L118:
        Integer r111 = (Integer) r42;
        boolean r43 = r110.getHasMore();
        Map r44 = r110.getExtra();
        if (r44 == null) goto L121;
        String r45 = (String) r44.get("scene_code");
    L122:
        v0(r111, r43, r45);
        this.u0.updatePreRequestCount(r110.getPreRequestCount(), r110.getNextPageCount());
        ECHybridListDTO.a r46 = ECHybridListDTO.Companion;
        int r47 = this.M;
        HomePageBffDTO r48 = r7.getBff();
        if (r48 == null) goto L127;
        BffBizInfo r49 = r48.getBizInfo();
        if (r49 == null) goto L127;
        String r50 = r49.getEcSceneId();
    L128:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r51 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(r47, r50, 190);
        r46.getClass();
        final com.bytedance.android.ec.hybrid.list.entity.k r52 = ECHybridListDTO.a.d(r110, false, r51);
        ArrayList r53 = r52.c;
        if (r53 == null) goto L138;
        Iterator r54 = r53.iterator();
    L132:
        if (r54.hasNext() == false) goto L136;
        Object r55 = r54.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r55).a, "favorite_section") == false) goto L132;
    L137:
        com.bytedance.android.ec.hybrid.list.entity.i r112 = (com.bytedance.android.ec.hybrid.list.entity.i) r55;
    L139:
        ArrayList r56 = r52.c;
        if (r56 == null) goto L148;
        Iterator r57 = r56.iterator();
        int r58 = 0;
    L143:
        if (r57.hasNext() == false) goto L148;
        ArrayList r59 = ((com.bytedance.android.ec.hybrid.list.entity.i) r57.next()).i;
        if (r59 == null) goto L147;
        r58 = r58 + r59.size();
    L147:
        this.Q0 = r58;
    L148:
        if (r111 != null) goto L150;
    L155:
        boolean r60 = true;
    L157:
        if (r60 == false) goto L331;
        if (r111 != null) goto L160;
        EnsureManager.ensureNotReachHere("ECMallFeed, loadMore reqTabId is null");
    L160:
        Lazy r61 = ECMallFeedDataReuseHelper.a;
        final String r62 = this.B1.c;
        if (r62 != null) goto L163;
    L195:
        ECHybridListEngine r63 = this.J;
        if (r63 == null) goto L202;
        com.bytedance.android.ec.hybrid.list.entity.k r64 = r63.c.g;
        if (r64 == null) goto L202;
        ArrayList r65 = r64.c;
        if (r65 == null) goto L202;
        com.bytedance.android.ec.hybrid.list.entity.i r66 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.lastOrNull(r65);
    L203:
        if (r66 == null) goto L247;
        ArrayList r67 = r66.i;
        if (r67 == null) goto L247;
        if (r67.size() != 1) goto L247;
        ArrayList r68 = r66.i;
        if (r68 == null) goto L213;
        ECHybridListItemVO r69 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r68);
        if (r69 == null) goto L213;
        Integer r70 = r69.c;
    L214:
        int r71 = ECHybridListItemType.HYBRID_TYPE_FAV_LOADING_CARD.getType();
        if (r70 == null) goto L247;
        if (r70.intValue() != r71) goto L247;
        ArrayList r72 = r52.c;
        if (r72 == null) goto L247;
        com.bytedance.android.ec.hybrid.list.entity.i r73 = (com.bytedance.android.ec.hybrid.list.entity.i) CollectionsKt.firstOrNull(r72);
        if (r73 == null) goto L247;
        ArrayList r74 = r73.i;
        if (r74 == null) goto L247;
        if ((!r74.isEmpty()) != true) goto L247;
        ECHybridListEngine r75 = this.J;
        if (r75 == null) goto L230;
        r66.c(ECSectionOperationType.DELETE_SECTION);
        Unit r76 = Unit.INSTANCE;
        ECHybridListEngine.s(r75, r66, null, 6);
    L230:
        ArrayList r77 = r52.c;
        if (r77 != null) goto L233;
    L235:
        r77 = null;
    L236:
        if (r111 == null) goto L247;
        if (r77 == null) goto L247;
        Iterator r78 = r77.iterator();
    L240:
        if (r78.hasNext() == false) goto L244;
        Object r79 = r78.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r79).a, "favorite_section") == false) goto L240;
    L245:
        if (r79 == null) goto L247;
        this.V.v(this.J, r111.intValue(), r77);
        goto L247
    L244:
        r79 = null;
        goto L245
    L233:
        if ((!r77.isEmpty()) == false) goto L235;
    L213:
        r70 = null;
    L247:
        ECHybridListEngine r80 = this.J;
        if (r80 == null) goto L285;
        com.bytedance.android.ec.hybrid.list.entity.k r81 = r80.c.g;
        if (r81 == null) goto L285;
        ArrayList r82 = r81.c;
        if (r82 == null) goto L285;
        if (r82.isEmpty() == true) goto L282;
        Iterator r84 = r82.iterator();
    L258:
        if (r84.hasNext() == false) goto L282;
        ArrayList r85 = ((com.bytedance.android.ec.hybrid.list.entity.i) r84.next()).i;
        if (r85 != null) goto L262;
    L279:
        boolean r86 = false;
    L280:
        if (r86 == false) goto L258;
        boolean r87 = true;
    L283:
        if (r87 != true) goto L285;
        boolean r88 = true;
    L286:
        if (r88 == false) goto L311;
        ArrayList r89 = r52.c;
        if (r89 == null) goto L311;
        Iterator r90 = r89.iterator();
    L292:
        if (r90.hasNext() == false) goto L311;
        com.bytedance.android.ec.hybrid.list.entity.i r91 = (com.bytedance.android.ec.hybrid.list.entity.i) r90.next();
        ArrayList r92 = r91.i;
        if (r92 == null) goto L309;
        ArrayList r94 = new ArrayList();
        Iterator r95 = r92.iterator();
    L297:
        if (r95.hasNext() == false) goto L308;
        Object r96 = r95.next();
        Integer r113 = ((ECHybridListItemVO) r96).c;
        int r97 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r113 != null) goto L302;
    L304:
        boolean r98 = false;
    L305:
        if (r98 == true) goto L297;
        r94.add(r96);
        goto L297
    L302:
        if (r113.intValue() != r97) goto L304;
        r98 = true;
        goto L305
    L308:
        ArrayList r99 = new ArrayList(r94);
    L310:
        r91.i = r99;
        goto L292
    L309:
        r99 = null;
    L311:
        ECHybridListEngine r100 = this.J;
        if (r100 == null) goto L330;
        ECHybridRecyclerView r101 = r100.b;
        if (r101 == null) goto L330;
        if (r101.getScrollState() != 0) goto L330;
        ECHybridListEngine r102 = this.J;
        if (r102 == null) goto L330;
        ECHybridRecyclerView r103 = r102.b;
        if (r103 == null) goto L330;
        if (r103.isComputingLayout() == true) goto L330;
        Map r104 = r110.getExtra();
        if (r104 == null) goto L326;
        String r105 = (String) r104.get("address_info");
    L327:
        d0(r20, r111, r52, r105);
        ECHybridListEngine r106 = this.J;
        if (r106 == null) goto L331;
        r106.c(r52);
        goto L331
    L326:
        r105 = null;
    L330:
        int r107 = 6;
        this.i.post(new t(this, r52, r20, r111, r110));
    L332:
        if (r111 == null) goto L444;
        r111.intValue();
        this.V.I(r111.intValue(), r112);
        this.V.E(r111.intValue(), this.M, this.L, this.N);
        Map r108 = r110.getExtra();
        if (r108 == null) goto L336;
        String r109 = (String) r108.get("scene_code");
    L337:
        Map r114 = r110.getExtra();
        if (r114 == null) goto L340;
        String r115 = (String) r114.get("address");
    L342:
        if (r111.intValue() != 308) goto L444;
        if (r112 == null) goto L345;
        ArrayList r116 = r112.i;
    L346:
        if (r116 != null) goto L348;
    L351:
        boolean r117 = true;
    L352:
        if (r117 == false) goto L444;
        if (r109 == null) goto L367;
        int r118 = r109.hashCode();
        if (r118 == (-443281813)) goto L364;
        if (r118 != 1389789472) goto L367;
        if (r109.equals("tomorrow_delivery_tab_tomorrow") == false) goto L367;
    L365:
        this.i.post(new s(this));
        goto L444
    L364:
        if (r109.equals("tomorrow_delivery_tab_next_day") == true) goto L365;
    L367:
        if (this.N == true) goto L444;
        ECMallFavoriteSectionHelper r119 = this.V;
        ECHybridListEngine r120 = this.J;
        r119.getClass();
        if (r120 == null) goto L408;
        com.bytedance.android.ec.hybrid.list.entity.k r121 = r120.c.g;
        if (r121 == null) goto L385;
        ArrayList r122 = r121.c;
        if (r122 == null) goto L385;
        Iterator r123 = r122.iterator();
    L377:
        if (r123.hasNext() == false) goto L381;
        Object r124 = r123.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r124).a, "favorite_section") == false) goto L377;
    L382:
        com.bytedance.android.ec.hybrid.list.entity.i r125 = (com.bytedance.android.ec.hybrid.list.entity.i) r124;
        if (r125 == null) goto L385;
        ArrayList r126 = r125.i;
    L386:
        if (r126 != null) goto L388;
    L409:
        boolean r127 = true;
    L410:
        if (r127 == false) goto L444;
        ECMallFavoriteSectionHelper.A(r119.y, r115);
        if (r120 == null) goto L426;
        com.bytedance.android.ec.hybrid.list.entity.k r128 = r120.c.g;
        if (r128 == null) goto L426;
        ArrayList r129 = r128.c;
        if (r129 == null) goto L426;
        Iterator r130 = r129.iterator();
    L420:
        if (r130.hasNext() == false) goto L424;
        Object r131 = r130.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r131).a, "favorite_section") == false) goto L420;
    L425:
        com.bytedance.android.ec.hybrid.list.entity.i r132 = (com.bytedance.android.ec.hybrid.list.entity.i) r131;
    L428:
        if (r132 == null) goto L438;
        Integer r133 = Integer.valueOf(r132.f);
        if (r133.intValue() <= 0) goto L432;
        boolean r134 = true;
    L433:
        if (r134 == true) goto L436;
        r133 = null;
    L436:
        if (r133 == null) goto L438;
        int r135 = r133.intValue();
    L439:
        if (r132 == null) goto L441;
        r132.c(ECSectionOperationType.DELETE_SECTION);
        ECHybridListEngine.s(r120, r132, null, r107);
    L441:
        if (r120 == null) goto L444;
        com.bytedance.android.ec.hybrid.list.entity.i r136 = new com.bytedance.android.ec.hybrid.list.entity.i();
        r136.a = "favorite_section";
        r136.f = r135;
        r136.c(ECSectionOperationType.INSERT_SECTION);
        ArrayList r137 = new ArrayList();
        ECHybridListItemVO r138 = new ECHybridListItemVO();
        r138.d = "next_day_delivery_loading_item";
        r138.c = Integer.valueOf(ECHybridListItemType.HYBRID_TYPE_FAV_LOADING_CARD.getType());
        r138.a = Integer.valueOf(r135);
        JSONObject r139 = new JSONObject();
        r139.put("loading_status", 2);
        r139.put("loading_view_type", 1);
        Unit r140 = Unit.INSTANCE;
        r138.o(r139);
        r137.add(r138);
        r136.i = r137;
        ECHybridListEngine.s(r120, r136, null, r107);
        goto L444
    L432:
        r134 = false;
    L438:
        r135 = 2;
        goto L439
    L424:
        r131 = null;
    L426:
        r132 = null;
        goto L428
    L388:
        if (r126.isEmpty() == true) goto L405;
        Iterator r141 = r126.iterator();
    L392:
        if (r141.hasNext() == false) goto L405;
        ECHybridListItemVO r142 = (ECHybridListItemVO) r141.next();
        Integer r143 = r142.c;
        int r144 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r143 == null) goto L399;
        if (r143.intValue() != r144) goto L399;
    L402:
        boolean r145 = true;
    L403:
        if (r145 == true) goto L392;
        boolean r146 = false;
    L406:
        if (r146 == false) goto L408;
    L399:
        if (Intrinsics.areEqual(r142.d, "next_day_delivery_loading_item") == true) goto L402;
        r145 = false;
    L405:
        r146 = true;
        goto L406
    L381:
        r124 = null;
    L385:
        r126 = null;
    L408:
        r127 = false;
        goto L410
    L348:
        if (r116.isEmpty() == true) goto L351;
        r117 = false;
        goto L352
    L345:
        r116 = null;
        goto L346
    L340:
        r115 = null;
        goto L342
    L336:
        r109 = null;
    L444:
        if (D().c() == false) goto L447;
        y0();
        goto L447
    L262:
        if (r85.isEmpty() == true) goto L276;
        Iterator r147 = r85.iterator();
    L266:
        if (r147.hasNext() == false) goto L276;
        Integer r148 = ((ECHybridListItemVO) r147.next()).c;
        int r149 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r148 != null) goto L271;
    L273:
        boolean r150 = false;
    L274:
        if (r150 == false) goto L266;
        boolean r151 = true;
    L277:
        if (r151 != true) goto L279;
        r86 = true;
        goto L280
    L271:
        if (r148.intValue() != r149) goto L273;
        r150 = true;
    L276:
        r151 = false;
    L282:
        r87 = false;
    L285:
        r88 = false;
    L202:
        r66 = null;
        goto L203
    L163:
        if (r62.length() <= 0) goto L165;
        boolean r152 = true;
    L166:
        if (r152 == false) goto L168;
        String r153 = r62;
    L169:
        if (r153 == null) goto L195;
        if (r111 != null) goto L173;
    L175:
        Integer r154 = ECMallFeedDataReuseHelper.a().getMaxSize();
        if (r154 == null) goto L195;
        if (r154.intValue() <= 0) goto L180;
        boolean r155 = true;
    L181:
        if (r155 == true) goto L184;
        r154 = null;
    L184:
        if (r154 == null) goto L195;
        r154.intValue();
        List<String> r156 = ECMallFeedDataReuseHelper.a().getEnabledPages();
        if (r156 != null) goto L188;
    L194:
        kk.d.c(new ECMallFeedDataReuseHelper$onLoadMoreSuccess$3(r62, r110, r52));
        goto L195
    L188:
        if ((!r156.isEmpty()) != true) goto L194;
        List<String> r157 = ECMallFeedDataReuseHelper.a().getEnabledPages();
        if (r157 == null) goto L195;
        if (r157.contains(r62) == true) goto L194;
    L180:
        r155 = false;
        goto L181
    L173:
        if (r111.intValue() == ECMallFeedDataReuseHelper.a().getTabId()) goto L175;
    L168:
        r153 = null;
        goto L169
    L165:
        r152 = false;
    L331:
        r107 = 6;
        goto L332
    L150:
        if (Intrinsics.areEqual(r111, this.R) == true) goto L152;
    L154:
        r60 = false;
        goto L157
    L152:
        if ((!Intrinsics.areEqual(this.T.get(r111), Boolean.TRUE)) == false) goto L154;
    L136:
        r55 = null;
        goto L137
    L138:
        r112 = null;
    L127:
        r50 = null;
        goto L128
    L121:
        r45 = null;
    L111:
        r110 = null;
    L61:
        int r158 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a("favorite_feed", "favorite_feed->feed->sections data is null", r4, this.B1.t);
    L50:
        r11 = null;
    L40:
        r6 = null;
    L35:
        r4 = "";
        goto L36
    L9:
        if (x() == false) goto L28;
        if (r7 == null) goto L16;
        HomePageBffDTO r159 = r7.getBff();
        if (r159 == null) goto L16;
        Map<String, Object> r160 = r159.getDynamicParams();
        if (r160 == null) goto L16;
        Object r161 = r160.get("post_back");
    L18:
        if ((r161 instanceof String) == true) goto L20;
        r161 = null;
    L20:
        String r162 = (String) r161;
        if (r162 == null) goto L28;
        String r163 = T(r162);
        if (r163 == null) goto L28;
        if ((!Intrinsics.areEqual(r163, this.G0)) == false) goto L28;
        return -1011;
    L16:
        r161 = null;
        goto L18
    L5:
        r7 = r19;
        goto L6
    }

    public final void Q(int r7, int r8, int r9, int r10) {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L55;
        boolean r1 = true;
        if ((!this.V.f.isEmpty()) == false) goto L56;
        ECMallFavoriteSectionHelper r2 = this.V;
        ECHybridListEngine r3 = this.J;
        Map.Entry r4 = (Map.Entry) CollectionsKt.firstOrNull(((LinkedHashMap) r2.f).entrySet());
        if (r4 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.entity.i r5 = (com.bytedance.android.ec.hybrid.list.entity.i) r4.getValue();
    L11:
        if (r5 != null) goto L18;
        if (r3 == null) goto L45;
        BaseViewHolder r6 = r3.g("multi_in_one_section", 0);
        if (r6 == null) goto L45;
        View r11 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r11 == null) goto L45;
    L41:
        int[] r12 = new int[2];
        r11.getLocationOnScreen(r12);
        int r13 = r12[1] + r11.getHeight();
        if (r8 <= r13) goto L45;
        if (r10 <= r13) goto L45;
    L46:
        if (r1 == false) goto L57;
        if (r7 <= r9) goto L49;
        final String r14 = "next";
    L51:
        if (this.V.k() == false) goto L53;
        this.A1.R60("guess_you_like_change_tab", "guess_you_like_change_tab", new ECMallFeed$onSlide$1(this, r14), ECMallFeed$onSlide$2.INSTANCE);
        return;
    L53:
        R(null, r14);
        return;
    L49:
        r14 = "pre";
        goto L51
    L57:
        return;
    L45:
        r1 = false;
        goto L46
    L18:
        View r15 = r2.g;
        if (r15 != null) goto L21;
    L27:
        r2.g = null;
        ArrayList r16 = r5.i;
        if (r16 == null) goto L32;
        ECHybridListItemVO r17 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L32;
        Object r18 = r17.T;
    L34:
        if ((r18 instanceof BaseViewHolder) == true) goto L36;
        r18 = null;
    L36:
        BaseViewHolder r19 = (BaseViewHolder) r18;
        if (r19 == null) goto L45;
        r11 = ((RecyclerView.ViewHolder) r19).itemView;
        if (r11 != null) goto L41;
    L32:
        r18 = null;
        goto L34
    L21:
        if (r15.isAttachedToWindow() != true) goto L27;
        r11 = r2.g;
        if (r11 != null) goto L41;
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        r5 = null;
        goto L11
    L56:
        return;
    }

    public final void d0(ECHybridNetworkVO r10, Integer r11, com.bytedance.android.ec.hybrid.list.entity.k r12, String r13) {
        com.bytedance.android.shopping.api.mall.common.tools.t r0 = this.W;
        Object r14 = r10.b().get("sec_tab_id");
        Object r2 = null;
        if ((r14 instanceof Integer) == true) goto L5;
        r14 = null;
    L5:
        Integer r15 = (Integer) r14;
        int r1 = 0;
        if (r15 == null) goto L8;
        int r16 = r15.intValue();
    L9:
        int r3 = this.L;
        boolean r4 = this.N;
        r0.getClass();
        if (r11 != null) goto L13;
        return;
    L13:
        if (r11.intValue() != 308) goto L66;
        if (r12 != null) goto L17;
        return;
    L17:
        if (r16 != 0) goto L19;
        Integer r17 = 1;
    L24:
        if (r17 == null) goto L67;
        int r18 = r17.intValue();
        ArrayList r5 = r12.c;
        if (r5 == null) goto L39;
        Iterator r6 = r5.iterator();
    L29:
        if (r6.hasNext() == false) goto L33;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r7).a, "favorite_section") == false) goto L29;
    L34:
        com.bytedance.android.ec.hybrid.list.entity.i r8 = (com.bytedance.android.ec.hybrid.list.entity.i) r7;
        if (r8 == null) goto L39;
        ArrayList r9 = r8.i;
        if (r9 == null) goto L39;
        r1 = r9.size();
        goto L39
    L33:
        r7 = null;
    L39:
        if (r1 == 0) goto L70;
        r0.c = Integer.valueOf(r18);
        r0.d = r13;
        ArrayList r19 = r12.c;
        if (r19 == null) goto L57;
        Iterator r110 = r19.iterator();
    L45:
        if (r110.hasNext() == false) goto L49;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r111).a, "favorite_section") == false) goto L45;
        r2 = r111;
    L49:
        com.bytedance.android.ec.hybrid.list.entity.i r20 = (com.bytedance.android.ec.hybrid.list.entity.i) r2;
        if (r20 == null) goto L57;
        ArrayList r112 = r20.i;
        if (r112 == null) goto L57;
        Iterator r113 = r112.iterator();
    L55:
        if (r113.hasNext() == false) goto L57;
        ((ECHybridListItemVO) r113.next()).W = Integer.valueOf(r18);
    L57:
        r0.c(r18, r3 + r1, 1 ^ (r4 ? 1 : 0));
        return;
    L70:
        return;
    L67:
        return;
    L19:
        if (r16 == 1) goto L22;
        if (r16 == 2) goto L22;
        r17 = null;
    L22:
        r17 = 2;
        goto L24
    L66:
        return;
    L8:
        r16 = 0;
        goto L9
    }

    public final void m(JSONObject r9, String r10, boolean r11, final com.bytedance.android.shopping.mall.opt.g r12) {
        final Function0<Unit> r6 = new ECMallFeed$checkPitayaInfoAndRefresh$refreshBack$1(r12);
        Integer r0 = this.D1;
        if (r0 == null) goto L7;
        if (r0.intValue() == 0) goto L7;
    L12:
        int r1 = FavRefreshParams.f;
        FavRefreshParams r13 = FavRefreshParams.Companion.a(false, r9, r10, r11, r12);
        p(r13, new ECMallFeed$checkPitayaInfoAndRefresh$2(r6), new ECMallFeed$gulRefresh$1(this, r13));
        return;
    L7:
        if (((Boolean) this.v1.getValue()).booleanValue() == false) goto L12;
        ECMallFeed$checkPitayaInfoAndRefresh$1 r7 = new ECMallFeed$checkPitayaInfoAndRefresh$1(this, r9, r10, r11, r12, r6);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        ThreadPoolHelper.c().submit(r7);
        return;
    L11:
        r7.run();
    }

    public final void l0(boolean r13, final HomePageDTO r14, com.bytedance.android.ec.hybrid.list.entity.k r15, boolean r16, boolean r17) {
        boolean r0 = false;
        if (r13 == false) goto L5;
        ListEngineOptConfig r2 = this.B1.y;
        Integer r10 = null;
        if (r2 == null) goto L16;
        Boolean r3 = r2.i;
    L18:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L31;
        com.bytedance.android.shopping.mall.homepage.pagecard.d r4 = this.G1;
        if (r4 == null) goto L24;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r5 = r4.a();
        if (r5 == null) goto L24;
        PageCard r6 = r5.a;
    L25:
        if (r6 == null) goto L31;
        if (r6.c == false) goto L29;
        this.i.post(new g0(this));
        goto L31
    L29:
        h0 r7 = new h0(this);
        Intrinsics.checkNotNullParameter(r7, "lifecycle");
        ((ArrayList) r6.l).add(r7);
    L24:
        r6 = null;
    L31:
        if (((Number) this.z.getValue()).intValue() != 1) goto L33;
        f r8 = this.A1;
        SetsKt.setOf(new String[]{"wysiwyg_items", "wysiwyg_position", "wysiwyg_scene_id", "wysiwyg_block_name"});
        r8.Hv();
    L33:
        if (r14 == null) goto L100;
        HomePageBffDTO r9 = r14.getBff();
        if (r9 == null) goto L101;
        ECHybridListDTO r11 = r9.getFeed();
        if (r11 == null) goto L102;
        if (r15 != null) goto L47;
        ECHybridListDTO.a r12 = ECHybridListDTO.Companion;
        HomePageBffDTO r18 = r14.getBff();
        if (r18 == null) goto L45;
        BffBizInfo r19 = r18.getBizInfo();
        if (r19 == null) goto L45;
        String r20 = r19.getEcSceneId();
    L46:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r21 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r20, 190);
        r12.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r22 = ECHybridListDTO.a.d(r11, false, r21);
    L48:
        ArrayList r23 = r22.c;
        if (r23 != null) goto L51;
    L54:
        boolean r24 = true;
    L55:
        if (r24 == false) goto L57;
        return;
    L57:
        HomePageBffDTO r25 = r14.getBff();
        if (r25 == null) goto L69;
        ECHybridListDTO r26 = r25.getFeed();
        if (r26 == null) goto L69;
        List r27 = r26.getSections();
        if (r27 == null) goto L69;
        Iterator r28 = r27.iterator();
    L65:
        if (r28.hasNext() == false) goto L69;
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r28.next()).getSectionId(), "category_tab_section") == false) goto L65;
        r0 = true;
    L69:
        if (r0 == true) goto L78;
        HomePageBffDTO r1 = r14.getBff();
        if (r1 == null) goto L78;
        BffBizInfo r29 = r1.getBizInfo();
        if (r29 == null) goto L78;
        Map<String, ? extends Object> r30 = r29.getBizIdentity();
        if (r30 == null) goto L78;
        this.b1 = r30;
    L78:
        if (this.b1 != null) goto L83;
        ECMallCommonImpressionReportHelper.b r31 = t();
        if (r31 != null) goto L82;
    L84:
        this.U = r11.getKeepSelectedTabOnRefresh();
        int r32 = r11.getCursor();
        boolean r33 = r11.getHasMore();
        Map r34 = r11.getExtra();
        if (r34 == null) goto L87;
        String r35 = (String) r34.get("scene_code");
    L88:
        n0(r22, r32, r33, r16, "real", r17, r35);
        LoadMorePrefetchStrategy r36 = this.u0;
        Integer r37 = r11.getPreRequestCount();
        HomePageBffDTO r38 = r14.getBff();
        if (r38 == null) goto L93;
        ECHybridListDTO r39 = r38.getFeed();
        if (r39 == null) goto L93;
        r10 = r39.getNextPageCount();
    L93:
        r36.updatePreRequestCount(r37, r10);
        this.i1 = new ECMallFeed$setFirstScreenData$3(this, r14);
        return;
    L87:
        r35 = null;
        goto L88
    L82:
        if (r31.a != true) goto L84;
    L83:
        N();
        goto L84
    L51:
        if (r23.isEmpty() == true) goto L54;
        r24 = false;
    L45:
        r20 = null;
        goto L46
    L47:
        r22 = r15;
        goto L48
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L16:
        r3 = null;
        goto L18
    L5:
        if (K() == false) goto L11;
        ECHybridListEngine r40 = this.J;
        if (r40 == null) goto L11;
        ECHybridRecyclerView r41 = r40.b;
        if (r41 == null) goto L11;
        r41.d0(false, true);
    L11:
        this.q0 = true;
        g0(this, new ECMallFeed$reportPendingEvent$1(this, false));
    }

    public final Map<String, Object> n(Integer r19, String r20, int r21, int r22, Integer r23) {
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("page_num", String.valueOf(r22 + 1));
        r2.put("cursor", String.valueOf(r21));
        r2.put("recommend_back_up_offset", String.valueOf(this.V.t));
        ECMallCommonImpressionReportHelper.b r4 = t();
        if (r4 != null) goto L5;
    L11:
        List<ImpressionItem> r5 = this.a0;
    L12:
        r2.put("feed", r5);
        r2.put("feedbacks", CollectionsKt.joinToString$default(this.d0, ",", null, null, 0, null, null, 62, null));
        r2.put("can_client_nest_channel", Integer.valueOf(((Number) this.g1.getValue()).intValue()));
        ((ILegouMallService) ServiceManager.get().getService(ILegouMallService.class)).j();
        String r6 = this.V.u;
        if (r6 == null) goto L16;
        r2.put("post_back", r6);
    L16:
        if ((!this.V.f.isEmpty()) == false) goto L34;
        ECMallFavoriteSectionHelper r7 = this.V;
        if (r19 == null) goto L20;
        int r8 = r19.intValue();
    L21:
        if (r8 > 0) goto L23;
        Map<String, String> r9 = r7.i();
    L30:
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L32:
        if (r10.hasNext() == false) goto L42;
        Map.Entry<String, String> r11 = r10.next();
        r2.put(r11.getKey(), r11.getValue());
    L42:
        Iterator<Map.Entry<String, Object>> r12 = this.A1.getGlobalProps().entrySet().iterator();
    L44:
        if (r12.hasNext() == false) goto L48;
        Map.Entry<String, Object> r13 = r12.next();
        String r14 = r13.getKey();
        Object r15 = r13.getValue();
        if (r2.containsKey(r14) == true) goto L44;
        r2.put(r14, r15);
        goto L44
    L48:
        if (r19 == null) goto L50;
        int r16 = r19.intValue();
    L51:
        r2.put("tab_id", Integer.valueOf(r16));
        if (r19 != null) goto L55;
    L57:
        JSONObject r17 = new JSONObject();
        if (r19 == null) goto L60;
        int r18 = r19.intValue();
    L61:
        r2.put("tab_id", Integer.valueOf(r18));
        if (r19 == null) goto L64;
        r17.put("tab_id", String.valueOf(r19.intValue()));
    L64:
        if (r20 == null) goto L66;
        r17.put("tab_name", r20);
    L66:
        if (r23 == null) goto L68;
        r17.put("tab_order", String.valueOf(r23.intValue()));
    L68:
        Map<String, String> r1 = this.A1.zH();
        Integer r24 = null;
        if ((!r1.isEmpty()) == true) goto L72;
        r1 = null;
    L72:
        if (r1 == null) goto L74;
        r17.put("video_guide_mall", r1.get("video_guide_mall"));
        r17.put("xtab_toast_info", r1.get("xtab_toast_info"));
    L74:
        Unit r3 = Unit.INSTANCE;
        r2.put("log_extra", r17.toString());
        if (this.B1.q == true) goto L77;
    L81:
        Iterator<Map.Entry<String, Object>> r25 = this.A1.EA().entrySet().iterator();
    L83:
        if (r25.hasNext() == false) goto L86;
        Map.Entry<String, Object> r26 = r25.next();
        r2.put(r26.getKey(), r26.getValue());
        goto L83
    L86:
        if (TextUtils.equals(this.B1.c, MallPageName.X_TAB_MALL) == false) goto L88;
    L89:
        v93.a.c.getClass();
        String r27 = v93.a.b;
        if (r27.length() <= 0) goto L92;
        boolean r28 = true;
    L93:
        if (r28 == false) goto L95;
        r2.put("pitaya_info", r27);
    L95:
        IHybridHostService r29 = com.bytedance.android.ec.hybrid.a.h();
        if (r29 == null) goto L101;
        yj.f r30 = r29.getHybridECSdkService();
        if (r30 == null) goto L101;
        r30.getHomePageMallSource();
        r24 = 0;
    L101:
        if (r24 != null) goto L104;
    L106:
        if (r24 != null) goto L109;
    L111:
        if (r24 != null) goto L114;
    L116:
        Lazy r31 = ECMallLogUtil.a;
        ECMallLogUtil.h(com.bytedance.android.ec.hybrid.log.mall.e.b.b, r2, "request extra params is : ");
        return r2;
    L114:
        if (r24.intValue() != 3) goto L116;
    L115:
        r2.put("business_id", "90247");
        goto L116
    L109:
        if (r24.intValue() != 2) goto L111;
    L104:
        if (r24.intValue() != 1) goto L106;
        r2.put("business_id", "30103");
        goto L116
    L92:
        r28 = false;
        goto L93
    L88:
        if (TextUtils.equals(this.B1.c, "order_homepage") == false) goto L95;
    L77:
        if (((ArrayList) this.I).isEmpty() == false) goto L79;
        String r32 = "";
    L80:
        r2.put("last_actions", r32);
        goto L81
    L79:
        r32 = CollectionsKt.joinToString$default(this.I, ",", null, null, 0, null, null, 62, null);
        goto L80
    L60:
        r18 = 0;
        goto L61
    L55:
        if (r19.intValue() != 308) goto L57;
        ECMallFavoriteSectionHelper r33 = this.V;
        r2.put("sec_tab_id", Integer.valueOf(r33.j.get(r19.intValue(), 0)));
        goto L57
    L50:
        r16 = 0;
        goto L51
    L23:
        r7.getClass();
        LinkedHashMap r34 = new LinkedHashMap();
        Map r35 = (Map) ((LinkedHashMap) r7.d).get(String.valueOf(r8));
        if (r35 == null) goto L29;
        Iterator r36 = r35.entrySet().iterator();
    L27:
        if (r36.hasNext() == false) goto L29;
        Map.Entry r37 = (Map.Entry) r36.next();
        r34.put((String) r37.getKey(), CollectionsKt.joinToString$default(((com.bytedance.android.shopping.mall.homepage.tools.s) r37.getValue()).snapshot().keySet(), ",", null, null, 0, null, null, 62, null));
    L29:
        r9 = r34;
        goto L30
    L20:
        r8 = 0;
        goto L21
    L34:
        Iterator r38 = ((LinkedHashMap) this.V.i()).entrySet().iterator();
    L36:
        if (r38.hasNext() == false) goto L38;
        Map.Entry r39 = (Map.Entry) r38.next();
        r2.put(r39.getKey(), r39.getValue());
        goto L36
    L38:
        Iterator r40 = ((LinkedHashMap) this.V.h()).entrySet().iterator();
    L40:
        if (r40.hasNext() == false) goto L42;
        Map.Entry r41 = (Map.Entry) r40.next();
        r2.put(r41.getKey(), r41.getValue());
        goto L40
    L5:
        if (r4.a != true) goto L11;
        ECMallCommonImpressionReportHelper r42 = u();
        if (r42 == null) goto L10;
        r5 = r42.c;
        if (r5 != null) goto L12;
    L10:
        r5 = CollectionsKt.emptyList();
        goto L12
    }

    public static /* synthetic */ void m0(ECMallFeed r6, boolean r7, HomePageDTO r8, com.bytedance.android.ec.hybrid.list.entity.k r9, boolean r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        boolean r4 = true;
    L6:
        r6.l0(r7, r8, r9, r4, false);
        return;
    L5:
        r4 = r10;
        goto L6
    }

    public final void H(final int r10, final com.bytedance.android.shopping.api.mall.c r11, final boolean r12, final com.bytedance.android.shopping.mall.opt.g r13, final Function0<Integer> r14, final Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r11, "jobResult");
        g0(this, new ECMallFeed$handleGulRefreshJobResult$1(this, r14, r13, r12, r10, r11, r15));
    }

    public final void s0(final Integer r17, final Long r18, final boolean r19, final String r20, final com.bytedance.android.shopping.api.mall.common.tools.c r21, final Function0<Unit> r22) {
        Integer r0 = this.R;
        if (r0 == null) goto L27;
        final int r1 = r0.intValue();
        com.bytedance.android.shopping.mall.homepage.pagecard.d r2 = this.G1;
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r3 = r2.a();
    L8:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r10 = r3;
        if (r10 == null) goto L17;
        PageCard r4 = r10.a;
        if (r4 == null) goto L17;
        if (r4.c() == true) goto L17;
        if (y() == false) goto L17;
        boolean r6 = true;
    L18:
        if (r10 == null) goto L25;
        if (r6 == true) goto L25;
        PageCard r5 = r10.a;
        if (r5 == null) goto L25;
        if (r5.a() == true) goto L25;
        r10.g(CollectionsKt.listOf("favorite_feed"), o(this), this.B1.w, new ECMallFeed$updateFavoriteSection$$inlined$let$lambda$1(r1, this, r17, r18, r19, r20, r21, r22));
        return;
    L25:
        r0(r1, r17, r18, r19, r20, r6, r21, r22);
        return;
    L17:
        r6 = false;
        goto L18
    L7:
        r3 = null;
        goto L8
    }

    public static boolean h0(final ECMallFeed r16, final String r17, final int r18, boolean r19, float r20, zj.b r21, int r22) {
        if ((r22 & 8) == 0) goto L5;
        final float r4 = ((Number) r16.d1.getValue()).floatValue();
    L6:
        Integer r2 = null;
        if ((r22 & 16) == 0) goto L9;
        final zj.b r7 = null;
    L10:
        ECHybridListEngine r10 = r16.J;
        if (r10 == null) goto L107;
        VirtualLayoutManager r12 = r10.b.getLayoutManager();
        if (r12 == null) goto L107;
        com.bytedance.android.ec.hybrid.list.entity.k r1 = r10.c.g;
        if (r1 == null) goto L107;
        ArrayList r3 = r1.c;
        if (r3 == null) goto L107;
        Iterator r5 = r3.iterator();
    L22:
        if (r5.hasNext() == false) goto L26;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r6).a, r17) == false) goto L22;
    L27:
        com.bytedance.android.ec.hybrid.list.entity.i r8 = (com.bytedance.android.ec.hybrid.list.entity.i) r6;
        if (r8 == null) goto L107;
        ArrayList r9 = r8.i;
        if (r9 == null) goto L107;
        Iterator r11 = r9.iterator();
    L34:
        if (r11.hasNext() == false) goto L38;
        Object r13 = r11.next();
        if ((!((ECHybridListItemVO) r13).l()) == false) goto L34;
    L39:
        ECHybridListItemVO r14 = (ECHybridListItemVO) r13;
        if (r14 == null) goto L107;
        String r15 = r14.d;
        if (r15 != null) goto L45;
        r15 = "";
    L45:
        BaseViewHolder r23 = r10.e(r17, r15);
        if (r23 == null) goto L48;
        int r24 = r23.getLayoutPosition();
    L59:
        int r25 = r10.i();
        if (r24 < 0) goto L107;
        if (r25 <= r24) goto L107;
        if (r23 == null) goto L65;
        Integer r26 = Integer.valueOf(r23.getLayoutPosition());
    L66:
        if (r26 == null) goto L107;
        int r110 = r26.intValue();
        if (r110 == r12.findFirstVisibleItemPosition()) goto L70;
    L72:
        View r27 = r12.findViewByPosition(r110);
        if (r27 == null) goto L75;
        int r111 = r27.getTop();
    L76:
        r16.C0.setValue(Boolean.TRUE);
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L80
        if (r19 == false) goto L82;
        final Context r29 = r16.e0();     // Catch: Throwable -> L80
        LinearSmoothScroller r30 = new ECMallFeed$scrollToSection$$inlined$runCatching$lambda$1(r29, r16, r4, r18, r17, r7);     // Catch: Throwable -> L80
        r30.setTargetPosition(r110);     // Catch: Throwable -> L80
        r12.startSmoothScroll(r30);     // Catch: Throwable -> L80
    L87:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L91:
        if (Result.isSuccess-impl(r0) == false) goto L100;
        Unit r31 = (Unit) r0;
        if (r16.C() == false) goto L95;
        r10.b.post(new p0(r16, r10));
        goto L100
    L95:
        if (r111 <= 0) goto L97;
        r111 = r111 - r18;
    L97:
        r16.Q = r111;
        Function2<? super Integer, ? super Boolean, Unit> r32 = r16.J0;
        if (r32 == null) goto L100;
        Unit r33 = (Unit) r32.invoke(Integer.valueOf(UIUtils.px2dip(r10.b.getContext(), r16.Q)), Boolean.TRUE);
    L100:
        Throwable r34 = Result.exceptionOrNull-impl(r0);
        if (r34 != null) goto L103;
    L106:
        return true;
    L103:
        if (HybridAppInfoService.p.isLocalTest() == true) goto L105;
        EnsureManager.ensureNotReachHere(r34);
        goto L107
    L105:
        throw r34;
    L82:
        r12.scrollToPositionWithOffset(r110, -r18);     // Catch: Throwable -> L80
        if (Intrinsics.areEqual(r17, "category_tab_section") == false) goto L87;
        if (r111 <= 0) goto L86;
        r16.A1.P60(r111 - r18);     // Catch: Throwable -> L80
        goto L87
    L86:
        r16.A1.P60(r111);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L75:
        r111 = 0;
        goto L76
    L70:
        if (Intrinsics.areEqual(r17, "category_tab_section") == false) goto L72;
        r16.C0.setValue(Boolean.FALSE);
        goto L106
    L65:
        r26 = r10.d(r17, r15);
        goto L66
    L48:
        Intrinsics.checkNotNullParameter(r14, "item");
        ECHybridListAdapter r112 = r10.a;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r14, "item");
        DataResolver r36 = r112.a;
        if (r36 == null) goto L58;
        Integer r37 = Integer.valueOf(r36.k40(r14));
        if (r37.intValue() < 0) goto L53;
        boolean r38 = true;
    L54:
        if (r38 == false) goto L56;
        r2 = r37;
    L56:
        if (r2 == null) goto L58;
        r24 = r2.intValue();
        goto L59
    L53:
        r38 = false;
    L58:
        r24 = -1;
        goto L59
    L38:
        r13 = null;
        goto L39
    L26:
        r6 = null;
    L107:
        return false;
    L9:
        r7 = r21;
        goto L10
    L5:
        r4 = r20;
        goto L6
    }

    public final void b0(int r17, long r18, Long r20, Integer r21, String r22, int r23, Long r24) {
        if (r24 == null) goto L5;
        long r2 = r24.longValue();
    L6:
        JSONObject r4 = new JSONObject();
        r4.put("type", "LOADMORE_PERFORMANCE_LOG");     // Catch: Exception -> L72
        r4.put("res_version", this.B1.t);     // Catch: Exception -> L72
        int r0 = f93.a.a;     // Catch: Exception -> L72
        Integer r8 = null;
        f93.a.c(r4, this.A1.ZK("c0.d0", false, null));     // Catch: Exception -> L72
        Long r10 = Long.valueOf(r18);     // Catch: Exception -> L72
        Long r11 = Long.valueOf(System.currentTimeMillis());     // Catch: Exception -> L72
        if (r23 <= 0) goto L10;
    L13:
        int r1 = 1;
    L14:
        Integer r12 = Integer.valueOf(r1);     // Catch: Exception -> L72
        Integer r14 = Integer.valueOf(r17);     // Catch: Exception -> L72
        if (r2 <= r18) goto L17;
        Long r13 = Long.valueOf(r2);     // Catch: Exception -> L72
    L18:
        y93.c r6 = new y93.c(r10, r11, r12, r13, r14, r21);     // Catch: Exception -> L72
        DataEngineWrapper r3 = this.C1;     // Catch: Exception -> L72
        if (r3 == null) goto L25;
        y93.a r5 = r3.b;     // Catch: Exception -> L72
        if (r5 == null) goto L25;
        Long r7 = r5.q();     // Catch: Exception -> L72
        if (r7 == null) goto L25;
        r4.putOpt("t_open_time", Long.valueOf(r7.longValue()));     // Catch: Exception -> L72
    L25:
        DataEngineWrapper r9 = this.C1;     // Catch: Exception -> L72
        if (r9 == null) goto L32;
        y93.a r15 = r9.b;     // Catch: Exception -> L72
        if (r15 == null) goto L32;
        Long r16 = r15.j();     // Catch: Exception -> L72
        if (r16 == null) goto L32;
        r4.putOpt("t_list_first_screen", Long.valueOf(r16.longValue()));     // Catch: Exception -> L72
    L32:
        DataEngineWrapper r19 = this.C1;     // Catch: Exception -> L72
        if (r19 == null) goto L77;
        y93.a r25 = r19.b;     // Catch: Exception -> L72
        if (r25 == null) goto L77;
        Integer r26 = r25.g();     // Catch: Exception -> L72
        if (r26 == null) goto L77;
        r4.putOpt("gyl_num_of_first_screen", Integer.valueOf(r26.intValue()));     // Catch: Exception -> L72
    L77:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L57
        v93.a.c.getClass();     // Catch: Throwable -> L57
        Pair r28 = v93.a.a();     // Catch: Throwable -> L57
        if (r28 == null) goto L54;
        Long r29 = (Long) r28.getSecond();     // Catch: Throwable -> L57
        JSONObject r30 = (JSONObject) r28.getFirst();     // Catch: Throwable -> L57
        if (r30 != null) goto L45;
        Integer r31 = null;
    L47:
        r4.putOpt("mall_scroll_mode", r31);     // Catch: Throwable -> L57
        if (r30 != null) goto L51;
        Double r32 = null;
    L53:
        r4.putOpt("mall_scroll_proba", r32);     // Catch: Throwable -> L57
        JSONObject r33 = r4.putOpt("feat_read_ts", r29);     // Catch: Throwable -> L57
    L55:
        Result.constructor-impl(r33);     // Catch: Throwable -> L57
    L59:
        r4.putOpt("t_load_more_draw_start", r20);     // Catch: Exception -> L72
        com.bytedance.android.ec.hybrid.list.e r34 = this.B1.z;     // Catch: Exception -> L72
        if (r34 == null) goto L62;
        String r35 = r34.a;     // Catch: Exception -> L72
    L63:
        r4.putOpt(SimilarProductParam.ENTER_FROM, r35);     // Catch: Exception -> L72
        r4.putOpt("request_count", Integer.valueOf(this.Q0));     // Catch: Exception -> L72
        ListEngineOptConfig r36 = this.B1.y;     // Catch: Exception -> L72
        if (r36 == null) goto L66;
        Integer r37 = r36.a;     // Catch: Exception -> L72
    L67:
        r4.putOpt("first_screen_preload_count", r37);     // Catch: Exception -> L72
        ListEngineOptConfig r38 = this.B1.y;     // Catch: Exception -> L72
        if (r38 == null) goto L70;
        r8 = r38.b;     // Catch: Exception -> L72
    L70:
        r4.putOpt("common_preload_count", r8);     // Catch: Exception -> L72
        r4.put("detail", tv5.a.a(new Gson(), r6));     // Catch: Exception -> L72
        r4.put("error_msg", r22);     // Catch: Exception -> L72
        r4.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.B1.c);     // Catch: Exception -> L72
        r4.putOpt("load_more_num", Integer.valueOf(this.O));     // Catch: Exception -> L72
        r4.putOpt("pre_request_count", this.u0.curPreRequestCount());     // Catch: Exception -> L72
    L73:
        com.bytedance.android.shopping.api.mall.common.tools.l.b(com.bytedance.android.shopping.api.mall.common.tools.l.a, r4, this.B1.s, true, 8);
        return;
    L66:
        r37 = null;
        goto L67
    L62:
        r35 = null;
        goto L63
    L51:
        r32 = Double.valueOf(r30.optDouble("mall_scroll_proba", -1.0d));     // Catch: Throwable -> L57
        goto L53
    L45:
        r31 = Integer.valueOf(r30.optInt("mall_scroll_mode", -1));     // Catch: Throwable -> L57
        goto L47
    L54:
        r33 = null;
    L57:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Exception -> L72
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L72
        goto L59
    L17:
        r13 = null;
        goto L18
    L10:
        if (r2 > r18) goto L13;
        r1 = 2;
    L72:
        EnsureManager.ensureNotReachHere("ECMallFeed#reportLoadMore");
        goto L73
    L5:
        r2 = this.X;
        goto L6
    }

    public final void n0(com.bytedance.android.ec.hybrid.list.entity.k r25, int r26, boolean r27, boolean r28, String r29, boolean r30, String r31) {
        if (this.G == true) goto L6;
        this.r0 = new z(this, r25, r26, r27, r28, r29, r30, r31);
        return;
    L6:
        this.r0 = null;
        ECHybridListEngine r2 = this.J;
        if (r2 != null) goto L9;
        return;
    L9:
        String r8 = "real";
        boolean r0 = Intrinsics.areEqual(r29, "real");
        boolean r11 = Intrinsics.areEqual(r29, "cache");
        if (r30 == true) goto L109;
        if (r0 == false) goto L19;
        if (r28 == false) goto L19;
        h93.a r12 = this.V.B;
        if (r12 == null) goto L16;
        r12.l = 5;
    L16:
        ECMallFeedSplitRenderConfig r13 = d1.a;
        Pair r14 = d1.a(this.B1.c, r25, false);
        if (r14 == null) goto L27;
        com.bytedance.android.ec.hybrid.list.entity.k r15 = (com.bytedance.android.ec.hybrid.list.entity.k) r14.getFirst();
        this.n1 = (com.bytedance.android.ec.hybrid.list.entity.k) r14.getSecond();
    L28:
        if (r0 == false) goto L108;
        if (Intrinsics.areEqual(r2.c.n, "cache") == false) goto L108;
        int r1 = j93.a.a;
        com.bytedance.android.ec.hybrid.list.entity.k r3 = r2.c.g;
        ECMallFeed$setFirstScreenDataInternal$2 r9 = ECMallFeed$setFirstScreenDataInternal$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "realList");
        Intrinsics.checkNotNullParameter(r9, "canReuseCachedLynxCard");
        if (r3 == null) goto L108;
        List r16 = j93.a.a(r3);
        List r17 = j93.a.a(r15);
        ArrayList r18 = (ArrayList) r16;
        if (r18.isEmpty() == true) goto L108;
        ArrayList r19 = (ArrayList) r17;
        if (r19.isEmpty() == true) goto L108;
        HashMap r4 = r3.b;
        if (r4 == null) goto L108;
        HashMap r110 = r15.b;
        if (r110 == null) goto L108;
        int r111 = Math.min(r18.size(), r19.size());
        int r10 = 0;
    L46:
        if (r10 >= r111) goto L108;
        List r32 = r16;
        ECHybridListItemVO r112 = (ECHybridListItemVO) ListProtector.get(r16, r10);
        int r113 = r111;
        ECHybridListItemVO r114 = (ECHybridListItemVO) ListProtector.get(r17, r10);
        Integer r5 = r112.c;
        if (r5 == null) goto L105;
        List r20 = r17;
        int r115 = r5.intValue();
        Integer r6 = r114.c;
        if (r6 == null) goto L104;
        int r7 = r6.intValue();
        if (r115 == r7) goto L104;
        HashMap r21 = r4;
        com.bytedance.android.ec.hybrid.list.entity.k.a r22 = (com.bytedance.android.ec.hybrid.list.entity.k.a) r4.get(String.valueOf(r115));
        if (r22 == null) goto L106;
        com.bytedance.android.ec.hybrid.list.entity.k.a r23 = (com.bytedance.android.ec.hybrid.list.entity.k.a) r110.get(String.valueOf(r7));
        if (r23 == null) goto L106;
        com.bytedance.android.ec.hybrid.list.entity.f r24 = r22.a;
        if (r24 == null) goto L63;
        String r33 = r24.a;
    L64:
        if (r33 != null) goto L66;
    L69:
        boolean r34 = true;
    L70:
        if (r34 == true) goto L106;
        com.bytedance.android.ec.hybrid.list.entity.f r35 = r23.a;
        if (r35 == null) goto L93;
        String r36 = r35.a;
        if (r36 == null) goto L93;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L87
        Uri r38 = UriProtector.parse(r36);     // Catch: Throwable -> L87
        if (j93.a.b(r38) == true) goto L84;
        String r39 = UriProtector.getQueryParameter(r38, "surl");     // Catch: Throwable -> L87
        if (r39 != null) goto L81;
    L83:
        boolean r40 = false;
    L85:
        Object r41 = Result.constructor-impl(Boolean.valueOf(r40));     // Catch: Throwable -> L87
    L89:
        Boolean r42 = Boolean.FALSE;
        if (Result.isFailure-impl(r41) == false) goto L92;
        r41 = r42;
    L92:
        boolean r43 = ((Boolean) r41).booleanValue();
    L94:
        if (r43 == false) goto L106;
        if (((Boolean) r9.invoke(r112)).booleanValue() == false) goto L106;
        r110.put(String.valueOf(r115), r22.a());
        Integer r44 = r114.b;
        if (r44 == null) goto L102;
        int r45 = r44.intValue();
    L103:
        r114.b = Integer.valueOf(r45);
        r114.c = Integer.valueOf(r115);
        goto L106
    L102:
        r45 = r7;
        goto L103
    L81:
        if (j93.a.b(UriProtector.parse(r39)) != true) goto L83;
    L84:
        r40 = true;
    L87:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
    L93:
        r43 = false;
        goto L94
    L66:
        if (r33.length() == 0) goto L69;
        r34 = false;
        goto L70
    L63:
        r33 = null;
    L106:
        r10 = r10 + 1;
        r16 = r32;
        r111 = r113;
        r17 = r20;
        r4 = r21;
    L104:
        r21 = r4;
        goto L106
    L105:
        r21 = r4;
        r20 = r17;
    L108:
        r2.o(r15, r28, r29);
    L110:
        this.M = 1;
        this.L = r26;
        v0(this.R, r27, r31);
        ECMallFavoriteSectionHelper r47 = this.V;
        Integer r48 = this.R;
        if (r48 == null) goto L113;
        int r49 = r48.intValue();
    L114:
        ArrayList r50 = r25.c;
        if (r50 == null) goto L124;
        Iterator r51 = r50.iterator();
    L118:
        if (r51.hasNext() == false) goto L122;
        Object r52 = r51.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r52).a, "favorite_section") == false) goto L118;
    L123:
        com.bytedance.android.ec.hybrid.list.entity.i r53 = (com.bytedance.android.ec.hybrid.list.entity.i) r52;
    L125:
        r47.I(r49, r53);
        ECMallFavoriteSectionHelper r54 = this.V;
        Integer r55 = this.R;
        if (r55 == null) goto L128;
        int r56 = r55.intValue();
    L129:
        r54.E(r56, this.M, r26, r27);
        this.g0 = 0;
        if (Intrinsics.areEqual(r29, r8) == false) goto L206;
        Iterator<T> r57 = this.k1.iterator();
    L133:
        if (r57.hasNext() == false) goto L135;
        ((e93.e) r57.next()).onStartLoadFeed();
        goto L133
    L135:
        ArrayList r58 = r25.c;
        if (r58 != null) goto L138;
    L180:
        Lazy r59 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L183;
        return;
    L183:
        if (this.I0 == false) goto L208;
        this.I0 = false;
        ECHybridDataEngine r60 = this.K;
        if (r60 == null) goto L209;
        r60.b(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("traffic_extra", null)}));
        return;
    L209:
        return;
    L208:
        return;
    L138:
        if ((!r58.isEmpty()) == true) goto L141;
        r58 = null;
    L141:
        if (r58 == null) goto L180;
        Integer r61 = this.R;
        if (r61 == null) goto L145;
        int r62 = r61.intValue();
    L146:
        if (r62 != 0) goto L148;
    L150:
        ArrayList r63 = r25.c;
        if (r63 == null) goto L160;
        Iterator r64 = r63.iterator();
    L154:
        if (r64.hasNext() == false) goto L158;
        Object r65 = r64.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r65).a, "favorite_section") == false) goto L154;
    L159:
        com.bytedance.android.ec.hybrid.list.entity.i r66 = (com.bytedance.android.ec.hybrid.list.entity.i) r65;
    L161:
        if (r27 == false) goto L163;
    L179:
        this.V.v(r2, r62, r58);
        goto L180
    L163:
        if (r62 != 308) goto L179;
        if (r66 == null) goto L166;
        ArrayList r67 = r66.i;
    L167:
        if (r67 != null) goto L169;
    L172:
        boolean r68 = true;
    L173:
        if (r68 == false) goto L179;
        ECMallFavoriteSectionHelper r69 = this.V;
        Map r70 = r25.d;
        if (r70 == null) goto L177;
        String r71 = (String) r70.get("address_info");
    L178:
        r69.getClass();
        ECMallFavoriteSectionHelper.A(r62, r71);
        goto L179
    L177:
        r71 = null;
        goto L178
    L169:
        if (r67.isEmpty() == true) goto L172;
        r68 = false;
        goto L173
    L166:
        r67 = null;
        goto L167
    L158:
        r65 = null;
        goto L159
    L160:
        r66 = null;
        goto L161
    L148:
        if (((Boolean) MallFixSetting.a.getValue()).booleanValue() == false) goto L150;
        this.V.y = r62;
        goto L150
    L145:
        r62 = 0;
        goto L146
    L206:
        return;
    L128:
        r56 = 0;
        goto L129
    L122:
        r52 = null;
        goto L123
    L124:
        r53 = null;
        goto L125
    L113:
        r49 = 0;
    L27:
        r15 = r25;
    L19:
        if (r11 == false) goto L27;
        if (r28 == false) goto L27;
        h93.a r116 = this.V.B;
        if (r116 == null) goto L24;
        r116.l = 2;
    L24:
        ECMallFeedSplitRenderConfig r117 = d1.a;
        Pair r118 = d1.a(this.B1.c, r25, true);
        if (r118 == null) goto L27;
        r15 = (com.bytedance.android.ec.hybrid.list.entity.k) r118.getFirst();
        this.m1 = (com.bytedance.android.ec.hybrid.list.entity.k) r118.getSecond();
        goto L28
    L109:
        r8 = "real";
        goto L110
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r0(final int r17, final Integer r18, final Long r19, final boolean r20, final String r21, boolean r22, com.bytedance.android.shopping.api.mall.common.tools.c r23, final Function0<Unit> r24) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.d.b, "start update feed tab: " + r17);
        final int r3 = this.V.j.get(r17, 0);
        this.T.put(Integer.valueOf(r17), Boolean.TRUE);
        boolean r11 = this.V.k();
        this.V.G(r17, this.A1.isAttached(), r11 ? 1 : 0, this.J, r22, r23, new ECMallFeed$updateFavoriteSection$1(this, r17, r3, r24, r18, r20, r19, r21));
        ECHybridListEngine r1 = this.J;
        if (r1 == null) goto L5;
        r1.e = null;
        r1.f = null;
    L5:
        g0(this, new ECMallFeed$updateFpsMonitor$1(this, Integer.valueOf(r17)));
    }

    public ECMallFeed(ECHybridListContainer r5, f r6, e r7, DataEngineWrapper r8, Integer r9, ECMallFavoriteSectionHelper r10, com.bytedance.android.ec.hybrid.card.api.f r11, ik.a r12, com.bytedance.android.shopping.mall.homepage.pagecard.d r13) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r6, "containerAbility");
        Intrinsics.checkNotNullParameter(r7, "config");
        this.z1 = r5;
        this.A1 = r6;
        this.B1 = r7;
        this.C1 = r8;
        this.D1 = r9;
        this.E1 = r11;
        this.F1 = r12;
        this.G1 = r13;
        this.H1 = r0;
        this.h = LazyKt.lazy(ECMallFeed$fetchGYLSetting$2.INSTANCE);
        this.i = new Handler(Looper.getMainLooper());
        this.j = new Handler(Looper.getMainLooper());
        Lazy r14 = LazyKt.lazy(new ECMallFeed$shelterEventHelp$2(this));
        this.k = r14;
        this.l = LazyKt.lazy(ECMallFeed$optFpsSetting$2.INSTANCE);
        this.m = LazyKt.lazy(ECMallFeed$refreshLayoutOptEnable$2.INSTANCE);
        this.n = LazyKt.lazy(ECMallFeed$scrollYCalcOptEnable$2.INSTANCE);
        this.o = LazyKt.lazy(ECMallFeed$loadMoreAndHomepageUnify$2.INSTANCE);
        this.p = LazyKt.lazy(ECMallFeed$mallLoadMoreDismissOpt$2.INSTANCE);
        this.q = LazyKt.lazy(ECMallFeed$mallPrefetchNextTabFeed$2.INSTANCE);
        this.r = LazyKt.lazy(ECMallFeed$mallDynamicParamsSyncToNative$2.INSTANCE);
        this.s = LazyKt.lazy(ECMallFeed$mallPrefetchCurrentTabBeforeScroll$2.INSTANCE);
        this.t = LazyKt.lazy(ECMallFeed$loadMoreReleaseTimeOut$2.INSTANCE);
        this.u = LazyKt.lazy(ECMallFeed$loadMoreReportSwitch$2.INSTANCE);
        this.v = LazyKt.lazy(new ECMallFeed$loadMorePostFront$2(this));
        this.w = LazyKt.lazy(ECMallFeed$updateCursorType$2.INSTANCE);
        int r15 = s93.c.a;
        Boolean r16 = Boolean.FALSE;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();
        if (r17 == null) goto L8;
        yj.g r18 = r17.getHostAB();
        if (r18 == null) goto L8;
        Object r19 = r18.a("mall_gyl_load_more_calc_type", r16);
        if (r19 == null) goto L8;
    L9:
        Lazy r110 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_gyl_load_more_calc_type, Value: " + r19);
        this.x = ((Boolean) r19).booleanValue();
        this.y = LazyKt.lazy(ECMallFeed$nonTab0FavFeedCountMap$2.INSTANCE);
        this.z = LazyKt.lazy(ECMallFeed$removeDeliveryDataSetting$2.INSTANCE);
        this.A = LazyKt.lazy(new ECMallFeed$distanceSlideToReport$2(this));
        this.B = LazyKt.lazy(new ECMallFeed$slideReportEnable$2(this));
        this.C = LazyKt.lazy(ECMallFeed$getCardPositonOpt$2.INSTANCE);
        this.D = LazyKt.lazy(ECMallFeed$shelterReportEvent$2.INSTANCE);
        this.E = LazyKt.lazy(new ECMallFeed$sceneID$2(this));
        this.F = LazyKt.lazy(new ECMallFeed$feedRepeatManager$2(this));
        this.I = new ArrayList();
        this.N = true;
        this.T = new ConcurrentHashMap();
        this.X = -1;
        this.Z = new CopyOnWriteArrayList();
        this.a0 = new ArrayList();
        this.b0 = LazyKt.lazy(new ECMallFeed$commonImpressionReportConfig$2(this));
        this.c0 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECMallFeed$commonImpressionReportHelper$2(this));
        this.d0 = new LinkedHashSet();
        this.f0 = new CopyOnWriteArrayList();
        this.h0 = new com.bytedance.android.shopping.mall.homepage.card.live.n();
        this.i0 = new g93.a();
        this.j0 = new ReportAbility(this, (ShelterEventHelp) r14.getValue());
        i0 r20 = new i0(this);
        this.k0 = r20;
        this.l0 = LazyKt.lazy(ECMallFeed$liveStatusConfig$2.INSTANCE);
        this.m0 = LazyKt.lazy(ECMallFeed$allowTabNot0Refresh$2.INSTANCE);
        this.o0 = new l(this);
        this.s0 = new ArrayList();
        this.t0 = LazyKt.lazy(new ECMallFeed$favFeedUpdateHelp$2(this));
        LoadMorePrefetchStrategy.a r1 = LoadMorePrefetchStrategy.Companion;
        ListEngineOptConfig r2 = r7.y;
        String r3 = r7.c;
        Lifecycle r4 = r6.s4().getLifecycle();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "pageName");
        Intrinsics.checkNotNullParameter(r4, "lifecycle");
        this.u0 = new LoadMorePrefetchStrategy(r2, r3, r4);
        Lazy r21 = MallOptUtil.a;
        this.v0 = MallOptUtil.g(r7.c, 2);
        this.w0 = MallOptUtil.g(r7.c, 3);
        this.x0 = LazyKt.lazy(new ECMallFeed$requestEndManger$2(this));
        this.y0 = LazyKt.lazy(ECMallFeed$coroutineScope$2.INSTANCE);
        this.z0 = LazyKt.lazy(new ECMallFeed$gulPrefetchHandler$2(this));
        this.A0 = LazyKt.lazy(new ECMallFeed$gulRefreshHandler$2(this));
        this.B0 = new com.bytedance.android.shopping.mall.feed.y(this);
        this.C0 = new ECMallFeed$isSnapToSectionLiveData$1(r16);
        this.I0 = true;
        final Ref.LongRef r22 = new Ref.LongRef();
        r22.element = 0;
        this.J0 = new ECMallFeed$scrollEventHandler$funcHandler$1(this, r22);
        this.N0 = LazyKt.lazy(new ECMallFeed$rvPreBindOptStrategy$2(this));
        this.O0 = LazyKt.lazy(ECMallFeed$scrollPreBindTimingOpt$2.INSTANCE);
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();
        if (r23 == null) goto L14;
        yj.g r24 = r23.getHostAB();
        if (r24 == null) goto L14;
        r24.e();
    L14:
        boolean r25 = false;
        this.P0 = 0;
        this.Q0 = -1;
        this.W0 = new CompositeDisposable();
        this.X0 = new MutableLiveData(Float.valueOf(1.0f));
        this.Y0 = LazyKt.lazy(ECMallFeed$videoPreloader$2.INSTANCE);
        this.Z0 = true;
        this.a1 = -1;
        this.c1 = LazyKt.lazy(ECMallFeed$videoPreloadConfig$2.INSTANCE);
        this.d1 = LazyKt.lazy(ECMallFeed$mallScrollToFavoriteCellSpeedOpt$2.INSTANCE);
        this.e1 = LazyKt.lazy(ECMallFeed$disablePadFoldConfig$2.INSTANCE);
        this.f1 = LazyKt.lazy(ECMallFeed$filterTrafficParams$2.INSTANCE);
        this.g1 = LazyKt.lazy(ECMallFeed$supportNestedScrollChannel$2.INSTANCE);
        this.k1 = new ArrayList();
        this.l1 = LazyKt.lazy(new ECMallFeed$memoryMonitor$2(this));
        this.p1 = new com.bytedance.android.shopping.api.mall.common.feed.help.e();
        int r111 = IECMallPerformanceService.SceneContext.f;
        String r112 = r7.c;
        Map r113 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene_id", r7.a)});
        Function0<Map<String, ? extends Object>> r114 = new ECMallFeed$performanceSceneContext$1(this);
        Intrinsics.checkNotNullParameter(r112, "sceneName");
        Intrinsics.checkNotNullParameter(r113, "params");
        this.q1 = new IECMallPerformanceService.SceneContext(r112, r113, r114);
        this.r1 = LazyKt.lazy(ECMallFeed$mallPerformanceService$2.INSTANCE);
        if (r9 == null) goto L17;
        int r26 = r9.intValue();
    L18:
        k0(Integer.valueOf(r26));
        if (r10 != null) goto L21;
        ECMallFavoriteSectionHelper.a r27 = ECMallFavoriteSectionHelper.K;
        String r115 = r7.c;
        Long r28 = r7.t;
        r27.getClass();
        r10 = ECMallFavoriteSectionHelper.a.b(r115, r28);
    L21:
        this.V = r10;
        this.W = new com.bytedance.android.shopping.api.mall.common.tools.t(new AnonymousClass1(r10), new AnonymousClass2(this));
        r6.s4().getLifecycle().addObserver(new FeedLifecycleObserver(this));
        ECEventCenter.e("ec.mita.reportClickData", r20, B());
        J();
        ServiceManager r29 = ServiceManager.get();
        if (r29 == null) goto L26;
        IECMallHostService r30 = (IECMallHostService) r29.getService(IECMallHostService.class);
        if (r30 == null) goto L26;
        r25 = r30.hitSplitScreenAndFoldOpen();
    L26:
        if (r25 == false) goto L36;
        ReentrantLock r31 = zl.a.a;
        Fragment r32 = r6.M();
        if (r32 == null) goto L36;
        int r33 = r32.hashCode();
        ConcurrentHashMap r34 = zl.a.c;
        if (r34.containsKey(Integer.valueOf(r33)) == false) goto L35;
        ConcurrentLinkedDeque r35 = zl.a.b;
        if (r35.contains(Integer.valueOf(r33)) == true) goto L36;
        r35.push(Integer.valueOf(r33));
        goto L36
    L35:
        ConcurrentLinkedDeque r36 = zl.a.b;
        r36.push(Integer.valueOf(r33));
        r34.put(Integer.valueOf(r33), r10);
        r32.getLifecycle().addObserver(new FoldFilterManager.observeFragmentLifecycle.1(r36, r33, r34));
    L36:
        this.s1 = LazyKt.lazy(ECMallFeed$liveViewCacheStop$2.INSTANCE);
        this.t1 = LazyKt.lazy(ECMallFeed$liveViewCacheStopPages$2.INSTANCE);
        this.u1 = new q0(this);
        this.v1 = LazyKt.lazy(ECMallFeed$pitayaCheckAndRefresh$2.INSTANCE);
        this.y1 = LazyKt.lazy(ECMallFeed$impressionFiltersNoReset$2.INSTANCE);
        System.currentTimeMillis();
        return;
    L17:
        r26 = 0;
    L8:
        r19 = r16;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t0(ECMallFeed r12, int r13, Integer r14, Long r15, boolean r16, String r17, com.bytedance.android.shopping.api.mall.common.tools.c r18, Function0 r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Long r6 = null;
    L11:
        if ((r20 & 8) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r20 & 16) == 0) goto L17;
        String r8 = "click";
    L19:
        if ((r20 & 64) == 0) goto L21;
        com.bytedance.android.shopping.api.mall.common.tools.c r10 = null;
    L23:
        if ((r20 & 128) == 0) goto L25;
        Function0 r11 = null;
    L26:
        r12.r0(r13, r5, r6, r7, r8, false, r10, r11);
        return;
    L25:
        r11 = r19;
        goto L26
    L21:
        r10 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
