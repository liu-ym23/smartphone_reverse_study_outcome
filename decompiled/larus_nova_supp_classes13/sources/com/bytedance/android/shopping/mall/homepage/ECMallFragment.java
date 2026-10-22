package com.bytedance.android.shopping.mall.homepage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.ECMallConfigs;
import com.bytedance.android.ec.hybrid.api.card.mita.ECMallMitaCardConvertConfig;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridApiConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ListEngineOptConfig;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.ability.c0;
import com.bytedance.android.ec.hybrid.list.ability.f0;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECListItemConfigDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ScrollImageByRV;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.popup.ECPopupManager;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.ECImageCustomDiskCacheHelper;
import com.bytedance.android.ec.hybrid.ui.ECMediaWrapperForLynx;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.api.mall.IECMallHomepageService;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.api.mall.IECMallTabOptService;
import com.bytedance.android.shopping.api.mall.IECNativeContainerLoadState$MallState;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.bytedance.android.shopping.api.mall.ILegouMallService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.MallPreloadName;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallCommonImpressionReportHelper;
import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.homepage.ECMallBackgroundGradientConfig;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.bytedance.android.shopping.api.mall.model.BackgroundInfo;
import com.bytedance.android.shopping.api.mall.model.BackgroundWrapper;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.ChunkedSectionData;
import com.bytedance.android.shopping.api.mall.model.ChunkedTrackAndRec;
import com.bytedance.android.shopping.api.mall.model.DouyinSkin;
import com.bytedance.android.shopping.api.mall.model.DouyinSkinConfig;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.HomepageExtra;
import com.bytedance.android.shopping.api.mall.model.PendantData;
import com.bytedance.android.shopping.api.mall.model.PendantWrapper;
import com.bytedance.android.shopping.api.mall.model.PreloadGeckoConfig;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.api.mall.opt.ECDeepFeedDomainPreConnectUtil;
import com.bytedance.android.shopping.api.mall.opt.ECMallPopupRenderOptConfig;
import com.bytedance.android.shopping.api.mall.opt.ECMallTabTouchAreaConfig;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.feed.ECMallFeedDataReuseHelper;
import com.bytedance.android.shopping.mall.feed.help.ECMallGulRefresh;
import com.bytedance.android.shopping.mall.feed.help.MallShelterHelp;
import com.bytedance.android.shopping.mall.feed.j0;
import com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder;
import com.bytedance.android.shopping.mall.homepage.chunked.HomepageChunkedCallback;
import com.bytedance.android.shopping.mall.homepage.component.ECFMiddleware;
import com.bytedance.android.shopping.mall.homepage.component.ECMBackTopComponent;
import com.bytedance.android.shopping.mall.homepage.component.ECMFPageCardComponent;
import com.bytedance.android.shopping.mall.homepage.component.ECMFTopBarComponent;
import com.bytedance.android.shopping.mall.homepage.component.ECMPinTopComponent;
import com.bytedance.android.shopping.mall.homepage.init.MallInitTaskManager;
import com.bytedance.android.shopping.mall.homepage.model.NativeMallApiException;
import com.bytedance.android.shopping.mall.homepage.opt.MallCrashListener;
import com.bytedance.android.shopping.mall.homepage.opt.MallDrainageOpt;
import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendant;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.android.shopping.mall.homepage.preload.MallLynxCardUtil;
import com.bytedance.android.shopping.mall.homepage.preload.StraightOutPrefetchTask;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineExtKt;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineMap;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.android.shopping.mall.homepage.tools.ECMarketingHelper;
import com.bytedance.android.shopping.mall.homepage.tools.ECMarketingHelper$scrollerListener$1;
import com.bytedance.android.shopping.mall.homepage.tools.MallGrayUtil;
import com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier;
import com.bytedance.android.shopping.mall.opt.MallGulRequestUtil;
import com.bytedance.android.shopping.mall.opt.MallOptUtil;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.bytedance.android.shopping.mall.utils.ECMallSkinManager;
import com.bytedance.android.shopping.mall.utils.ECMallSkinManager$init$2;
import com.bytedance.android.shopping.mall.widget.ECDetectableFrameLayout;
import com.bytedance.android.shopping.mall.widget.NoSlipFrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.pitaya.api.mutilinstance.HostSetupWatcher;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00022\u00020\u00042\u00020\u00052\u00020\u00022\u00020\u00062\b\u0012\u0004\u0012\u00020\u00020\u00022\u00020\u0007:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/ECMallFragment;", "Landroidx/fragment/app/Fragment;", "", "Lcom/bytedance/android/shopping/mall/feed/ECMallFeed$f;", "Lcom/bytedance/android/shopping/api/mall/g;", "Lcom/bytedance/android/ec/hybrid/card/api/f;", "Lcom/bytedance/android/ec/hybrid/list/ability/c0;", "Lcom/bytedance/android/ec/hybrid/popup/i;", "<init>", "()V", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFragment extends Fragment implements ECMallFeed.f, com.bytedance.android.shopping.api.mall.g, com.bytedance.android.ec.hybrid.card.api.f, c0, com.bytedance.android.ec.hybrid.popup.i {
    public static final /* synthetic */ int h4 = 0;
    public final ECMallFragment$channelItemShowEventSubscriber$1 A;
    public final com.bytedance.android.ec.hybrid.popup.e A3;
    public final ECMallFragment$tabItemShowEventSubscriber$1 B;
    public final Lazy B3;
    public int C;
    public final Lazy C3;
    public int D;
    public final Lazy D3;
    public final ECMallFragment$pageStateHelper$1 E;
    public boolean E2;
    public final Lazy E3;
    public final Lazy F;
    public boolean F2;
    public final Lazy F3;
    public final Lazy G;
    public y93.g G1;
    public boolean G2;
    public final Lazy G3;
    public final Lazy H;
    public ECHybridListEngine H0;
    public y93.f H1;
    public volatile boolean H2;
    public int H3;
    public final Lazy I;
    public boolean I2;
    public boolean I3;
    public final Lazy J;
    public boolean J2;
    public boolean J3;
    public volatile Boolean K;
    public boolean K2;
    public final Lazy K3;
    public volatile Boolean L;
    public DataEngineWrapper L0;
    public final Lazy L1;
    public boolean L2;
    public boolean L3;
    public volatile Runnable M;
    public int M1;
    public final Lazy M2;
    public String M3;
    public volatile Runnable N;
    public AnchorPendantManager N2;
    public String N3;
    public volatile boolean O;
    public final HashMap<String, String> O2;
    public String O3;
    public volatile boolean P;
    public ECHybridDataEngine P0;
    public final Handler P1;
    public FrameLayout P2;
    public boolean P3;
    public volatile String Q;
    public final Handler Q1;
    public FrameLayout Q2;
    public final Lazy Q3;
    public String R;
    public final g93.a R2;
    public boolean R3;
    public final Lazy S;
    public boolean S1;
    public final ik.a S2;
    public boolean S3;
    public final Lazy T;
    public int T1;
    public final jf3.e T2;
    public boolean T3;
    public final com.bytedance.android.shopping.mall.homepage.card.e U;
    public boolean U2;
    public final Lazy U3;
    public final MallCrashListener V;
    public SmartRefreshLayout V0;
    public volatile boolean V1;
    public HomePageDTO V2;
    public final Lazy V3;
    public boolean W;
    public volatile boolean W2;
    public final Lazy W3;
    public Function0<Unit> X;
    public volatile HomePageDTO X2;
    public final k X3;
    public final Lazy Y;
    public HomepageChunkedCallback Y2;
    public int Y3;
    public final List<com.bytedance.android.shopping.mall.feed.help.g> Z;
    public com.bytedance.android.shopping.mall.homepage.tools.l Z2;
    public Pair<? extends Function0<Unit>, ? extends Function0<Unit>> Z3;
    public final Lazy a3;
    public final g a4;
    public Pair<String, String> b1;
    public boolean b2;
    public final Lazy b3;
    public final Lazy b4;
    public boolean c3;
    public final a c4;
    public final ECFMiddleware d;
    public long d3;
    public boolean d4;
    public final com.bytedance.android.shopping.mall.homepage.component.c e;
    public long e3;
    public boolean e4;
    public ECMallFeed f;
    public long f3;
    public boolean f4;
    public int g;
    public String g1;
    public boolean g2;
    public IECMallTabOptService g3;
    public boolean g4;
    public final Lazy h;
    public final List<String> h1;
    public final List<com.bytedance.android.shopping.api.mall.common.tools.n> h2;
    public com.bytedance.android.shopping.mall.homepage.i h3;
    public yj.g i;
    public final Lazy i3;
    public final com.bytedance.android.shopping.mall.homepage.opt.b j;
    public final s j3;
    public final String k;
    public final Lazy k0;
    public ECLynxCard k1;
    public boolean k3;
    public final ECMarketingHelper l;
    public boolean l3;
    public MallNetApplier m;
    public Pair<? extends MutableLiveData<Boolean>, ? extends Object> m3;
    public volatile boolean n;
    public View n3;
    public boolean o;
    public final boolean o3;
    public Boolean p;
    public final jf3.c p0;
    public ECLynxCard p1;
    public final Map<String, String> p2;
    public final j p3;
    public final com.bytedance.android.shopping.mall.c q;
    public final Lazy q3;
    public final d r;
    public long r3;
    public final com.bytedance.android.shopping.mall.f s;
    public com.bytedance.android.shopping.mall.widget.a s3;
    public final o t;
    public final Function1<Boolean, Unit> t3;
    public final df3.a u;
    public final Lazy u3;
    public final Lazy v;
    public boolean v1;
    public final CopyOnWriteArrayList<Map<String, Object>> v2;
    public final boolean v3;
    public final ECMallFragment$hostSetupListener$1 w;
    public boolean w3;
    public final e x;
    public boolean x1;
    public boolean x2;
    public boolean x3;
    public final f y;
    public y93.d y1;
    public long y2;
    public boolean y3;
    public final v z;
    public boolean z3;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFragment a;

        public a(ECMallFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.H2 = true;     // Catch: Throwable -> L4
            this.a.Qa0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ ECMallFragment a;
        public final /* synthetic */ HomePageDTO b;
        public final /* synthetic */ String c;

        public c(ECMallFragment r1, HomePageDTO r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            Context r0 = this.a.getContext();
            Object r1 = null;
            if (r0 == null) goto L45;
            ECMallFragment r2 = this.a;
            int r3 = ECMallFragment.h4;
            String r4 = r2.ga0();
            int r5 = com.bytedance.android.shopping.mall.homepage.tools.p.a;
            if (com.bytedance.android.shopping.mall.homepage.tools.p.a(this.b) == false) goto L38;
            this.a.getClass();
            HomePageBffDTO r6 = this.b.getBff();
            if (r6 == null) goto L20;
            ECHybridListDTO r7 = r6.getFeed();
            if (r7 == null) goto L20;
            List r8 = r7.getSections();
            if (r8 == null) goto L20;
            Iterator r9 = r8.iterator();
        L14:
            if (r9.hasNext() == false) goto L18;
            Object r10 = r9.next();
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r10).getSectionId(), "favorite_section") == false) goto L14;
        L19:
            ECHybridListSectionDTO r11 = (ECHybridListSectionDTO) r10;
        L21:
            IntRange r12 = com.bytedance.android.ec.hybrid.list.d.a;
            if (r11 == null) goto L34;
            ArrayList r13 = r11.getItems();
            if (r13 == null) goto L34;
            Iterator r14 = r13.iterator();
        L27:
            if (r14.hasNext() == false) goto L32;
            Object r15 = r14.next();
            ECHybridListItemType.a r16 = ECHybridListItemType.Companion;
            Integer r17 = ((ECHybridListItemDTO) r15).getItemType();
            r16.getClass();
            if (ECHybridListItemType.a.b(r17) == false) goto L27;
            r1 = r15;
        L32:
            if (((ECHybridListItemDTO) r1) == null) goto L34;
            boolean r18 = true;
        L35:
            if (r18 == true) goto L38;
            com.bytedance.android.shopping.mall.homepage.tools.q.e(r0, TuplesKt.to(b0.k(this.c), this.b), r4, false);
        L34:
            r18 = false;
            goto L35
        L18:
            r10 = null;
        L20:
            r11 = null;
        L38:
            return Unit.INSTANCE;
        L45:
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements JsEventSubscriber {
        public final /* synthetic */ ECMallFragment a;

        public e(ECMallFragment r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "jsEvent");
            XReadableMap r3 = r2.getParams();
            if (r3 == null) goto L5;
            String r4 = r3.getString(PdpOpenThirdParam.KEY_PAGE_NAME);
        L7:
            if (Intrinsics.areEqual(r4, MallPageName.X_TAB_MALL) == false) goto L10;
            ECMallFragment r5 = this.a;
            int r0 = ECMallFragment.h4;
            r5.getClass();
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    public static final class f implements JsEventSubscriber {
        public final /* synthetic */ ECMallFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ View a;
            public final /* synthetic */ f b;

            public a(View r1, f r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Object r0 = CollectionsKt.firstOrNull(b0.b(this.a));
                if ((r0 instanceof LynxView) == true) goto L5;
                r0 = null;
            L5:
                LynxView r1 = (LynxView) r0;
                if (r1 == null) goto L11;
                View r2 = r1.findViewByIdSelector("coin-real-container");
                if (r2 == null) goto L12;
                JSONObject r3 = new JSONObject();
                int[] r4 = new int[2];
                r2.getLocationOnScreen(r4);
                r3.put("x", r4[0]);
                r3.put("y", r4[1]);
                r3.put("width", r2.getMeasuredWidth());
                r3.put("height", r2.getMeasuredHeight());
                ECMallFragment r5 = this.b.a;
                int r6 = ECMallFragment.h4;
                r5.getClass();
                return;
            L12:
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

        public f(ECMallFragment r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "jsEvent");
            XReadableMap r0 = r5.getParams();
            View r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.getString(PdpOpenThirdParam.KEY_PAGE_NAME);
        L7:
            if (Intrinsics.areEqual(r2, MallPageName.X_TAB_MALL) == false) goto L38;
            XReadableMap r6 = r5.getParams();
            if (r6 == null) goto L11;
            String r7 = r6.getString("layoutType");
        L13:
            if (Intrinsics.areEqual(r7, "left") == false) goto L39;
            ECMallFragment r8 = this.a;
            int r3 = ECMallFragment.h4;
            r8.getClass();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L28
            Class r9 = ECMallFragment.S90("com.bytedance.android.annie.card.AnnieCard");     // Catch: Throwable -> L28
            FrameLayout r10 = r8.P2;     // Catch: Throwable -> L28
            if (r10 == null) goto L30;
            List<View> r11 = b0.b(r10);     // Catch: Throwable -> L28
            if (r11 == null) goto L30;
            Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L28
        L21:
            if (r12.hasNext() == false) goto L25;
            Object r13 = r12.next();     // Catch: Throwable -> L28
            if (r9.isInstance((View) r13) == false) goto L21;
        L26:
            r1 = (View) r13;     // Catch: Throwable -> L28
            goto L30
        L25:
            r13 = null;
        L30:
            if (r1 == null) goto L40;
            r1.postDelayed(new a(r1, this), 1000);
            return;
        L40:
            return;
        L28:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L30
        L39:
            return;
        L11:
            r7 = null;
            goto L13
        L38:
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class g implements com.bytedance.android.ec.hybrid.data.gecko.c {
        public final /* synthetic */ ECMallFragment a;

        public g(ECMallFragment r1) {
            this.a = r1;
        }

        public final void b(Long r1, Map<String, ECHybridNetworkDTO> r2) {
            Intrinsics.checkNotNullParameter(r2, "apiConfigDTOMap");
            Intrinsics.checkNotNullParameter(r2, "apiConfigDTOMap");
        }

        public final void a(Throwable r4, String r5, Long r6) {
            Lazy r7 = ECMallLogUtil.a;
            com.bytedance.android.ec.hybrid.log.mall.m.b r8 = com.bytedance.android.ec.hybrid.log.mall.m.b.b;
            ECMallLogUtil.b(r8, "init data in na mall page failed, from: " + r5 + ", version: " + r6);
            ECMallFragment r9 = this.a;
            int r10 = ECMallFragment.h4;
            r9.getClass();
            DataEngineWrapper r11 = this.a.L0;
            if (r11 == null) goto L5;
            r11.i(System.currentTimeMillis());
        L5:
            ECMallFragment r12 = this.a;
            if (r12.Z3 == null) goto L17;
            DataEngineWrapper r13 = r12.L0;
            if (r13 == null) goto L10;
            r13.h(System.currentTimeMillis(), 100);
        L10:
            Pair<? extends Function0<Unit>, ? extends Function0<Unit>> r14 = r12.Z3;
            if (r14 == null) goto L15;
            Function0 r15 = (Function0) r14.getSecond();
            if (r15 == null) goto L15;
            Unit r16 = (Unit) r15.invoke();
        L15:
            r12.Z3 = null;
            r12.La0(2, null);
            ECMallLogUtil.b(r8, "check gecko version failed");
            return;
        }

        public final void c(String r6, Long r7, ECHybridConfigDTO r8, Map<String, ? extends Object> r9) {
            Lazy r10 = ECMallLogUtil.a;
            com.bytedance.android.ec.hybrid.log.mall.m.b r11 = com.bytedance.android.ec.hybrid.log.mall.m.b.b;
            ECMallLogUtil.b(r11, "init data in na mall page success, from: " + r6 + ", version: " + r7);
            ECMallFragment r12 = this.a;
            int r1 = ECMallFragment.h4;
            r12.getClass();
            DataEngineWrapper r13 = this.a.L0;
            if (r13 == null) goto L5;
            r13.i(System.currentTimeMillis());
        L5:
            ECMallFragment r14 = this.a;
            r14.Z90(r6, r7);
            if (r14.Z3 == null) goto L23;
            r14.d.e = r7;
            ECMallFeed r2 = r14.f;
            if (r2 == null) goto L13;
            ECMallFeed.e r3 = r2.B1;
            if (r3 == null) goto L13;
            if (r7 == null) goto L13;
            r7.longValue();
            r3.t = r7;
            Map<String, String> r4 = MapsKt.toMutableMap(r3.e);
            r4.put("na_offline_version", String.valueOf(r7.longValue()));
            Unit r5 = Unit.INSTANCE;
            r3.e = r4;
        L13:
            DataEngineWrapper r15 = r14.L0;
            if (r15 == null) goto L16;
            r15.g(System.currentTimeMillis(), r6);
        L16:
            Pair<? extends Function0<Unit>, ? extends Function0<Unit>> r16 = r14.Z3;
            if (r16 == null) goto L21;
            Function0 r17 = (Function0) r16.getFirst();
            if (r17 == null) goto L21;
            Unit r18 = (Unit) r17.invoke();
        L21:
            r14.Z3 = null;
            ECMallLogUtil.c(r11, "check gecko version success, from: " + r6 + ", version: " + r7);
            return;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ ECMallFragment a;

        public h(ECMallFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p0.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ ECMallFragment a;
        public final /* synthetic */ HomePageDTO b;

        public i(ECMallFragment r1, HomePageDTO r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ECMallFragment r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
            if (((Boolean) r0.I.getValue()).booleanValue() == false) goto L9;
            DataEngineWrapper r2 = r0.L0;     // Catch: Throwable -> L19
            if (r2 == null) goto L9;
            if (r2.s != true) goto L9;
        L17:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
            return;
        L9:
            DataEngineWrapper r3 = r0.L0;     // Catch: Throwable -> L19
            if (r3 == null) goto L13;
            DataEngineWrapper.C(r3, this.b, false, 6);     // Catch: Throwable -> L19
        L13:
            if (r0.e4 == false) goto L17;
            ECHybridDataEngine r4 = r0.P0;     // Catch: Throwable -> L19
            if (r4 == null) goto L17;
            r4.u();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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

    public static final class j {
        public final /* synthetic */ ECMallFragment a;

        public final void a() {
            ECMallFragment r0 = this.a;
            ECMallFragment r5 = this.a;
            int r6 = ECMallFragment.h4;
            r5.getClass();
            this.a.getClass();
            Map<String, ? extends Object> r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "login_button_click"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("previous_page", ""), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, ""), TuplesKt.to("button_type", "loginguide_button")}))});
            ECMallFeed r2 = r0.f;
            if (r2 == null) goto L8;
            ECMallFeed.ReportAbility r3 = r2.j0;
            if (r3 == null) goto L9;
            r3.d(r1);
            return;
        L9:
            return;
        }

        public j(ECMallFragment r1) {
            this.a = r1;
        }
    }

    public static final class k implements f0 {
        public final /* synthetic */ ECMallFragment a;

        public final void a() {
            this.a.getClass();
        }

        public k(ECMallFragment r1) {
            this.a = r1;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ ECMallFragment a;

        public l(ECMallFragment r1) {
            this.a = r1;
        }

        public final void a() {
            ECMallFragment r0 = this.a;
            int r1 = ECMallFragment.h4;
            r0.getClass();
            long r2 = System.currentTimeMillis();
            if (r2 <= 0) goto L7;
            DataEngineWrapper r3 = r0.L0;
            if (r3 == null) goto L7;
            r3.u(r2);
        L7:
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("eventName", "page_view");
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("EVENT_ORIGIN_FEATURE", "TEMAI");
            r5.put("enter_type", "normal");
            if (r0.isDarkMode() == false) goto L10;
            String r6 = "dark";
        L11:
            r5.put("theme_style", r6);
            r5.put("page_version", 1);
            r4.put("params", r5);
            r4.put("btm", "c0.d0");
            Unit r7 = Unit.INSTANCE;
            r0.Ka0(r4);
            return;
        L10:
            r6 = "light";
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

    public static final class m implements Runnable {
        public final /* synthetic */ NoSlipFrameLayout a;
        public final /* synthetic */ Context b;

        public m(NoSlipFrameLayout r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setEnableControlSlip(false);     // Catch: Throwable -> L4
            Context r0 = this.b;     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L4
            r0.getApplicationContext().getSharedPreferences("mall_control_slip_sp", 0).edit().putLong("control_slip_time", System.currentTimeMillis()).apply();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L6
            r0.put("main_view_create", "1");     // Catch: Throwable -> L6
            IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.reportThreadPoolInfo(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class o {
        public o() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.ECMallFragment$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/shopping/mall/homepage/ECMallFragment$onCreate$3", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass3 implements Observer<Boolean> {
        public final void onChanged(Object r4) {
            boolean r5 = ((Boolean) r4).booleanValue();
            Lazy r0 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.a.b, "login state changed, isLogin = " + r5);
            throw null;
        }
    }

    public static final class p<T, R> implements Function {
        public final /* synthetic */ ECMallFragment a;
        public final /* synthetic */ ECHybridListDTO b;
        public final /* synthetic */ HomePageDTO c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Ref.BooleanRef f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ boolean h;

        public p(ECMallFragment r1, ECHybridListDTO r2, HomePageDTO r3, boolean r4, boolean r5, Ref.BooleanRef r6, boolean r7, boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final Object apply(Object r13) {
            Intrinsics.checkNotNullParameter((HomePageDTO) r13, "it");
            ECHybridListDTO.a r14 = ECHybridListDTO.Companion;
            ECHybridListDTO r0 = this.b;
            HomePageBffDTO r2 = this.c.getBff();
            if (r2 == null) goto L7;
            BffBizInfo r3 = r2.getBizInfo();
            if (r3 == null) goto L7;
            String r4 = r3.getEcSceneId();
        L8:
            com.bytedance.android.ec.hybrid.list.entity.dto.a r1 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r4, 190);
            r14.getClass();
            com.bytedance.android.ec.hybrid.list.entity.k r15 = ECHybridListDTO.a.d(r0, true, r1);
            ECHybridListDTO.a.c(r15, this.d, this.e, this.f.element, this.g, this.h, new ECMallFragment$refreshCacheHomepage$6$$special$$inlined$also$lambda$1(this));
            return r15;
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ ECMallFragment a;
        public final /* synthetic */ ECHybridListDTO b;

        public q(ECMallFragment r1, ECHybridListDTO r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.ec.hybrid.list.entity.k r5 = (com.bytedance.android.ec.hybrid.list.entity.k) r4;
            ECMallFragment r0 = this.a;
            if (r0.x2 == true) goto L20;
            DataEngineWrapper r1 = r0.L0;
            if (r1 == null) goto L8;
            r1.z();
        L8:
            this.a.K = Boolean.FALSE;
            DataEngineWrapper r2 = this.a.L0;
            if (r2 == null) goto L11;
            r2.L(ECMallFragment$refreshCacheHomepage$7$1.INSTANCE);
        L11:
            ECMallFragment r3 = this.a;
            com.bytedance.android.shopping.api.mall.m r6 = (com.bytedance.android.shopping.api.mall.m) r3.T.getValue();
            if (r6 == null) goto L14;
            Boolean r7 = r6.c();
        L15:
            r3.p = r7;
            ECMallFeed r8 = this.a.f;
            if (r8 == null) goto L18;
            r8.j0(r5, this.b.getCursor(), this.b.getHasMore());
        L18:
            this.a.xa0();
            this.a.getClass();
            Lazy r9 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "ECMallFragment#refreshCacheHomepage()@" + this.a.hashCode() + ", async end");
            return;
        L14:
            r7 = null;
            goto L15
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final void accept(Object r4) {
            Lazy r0 = ECMallLogUtil.a;
            ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "handle cache data error, msg : " + ((Throwable) r4).getMessage());
        }
    }

    public static final class s implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ ECMallFragment a;

        public s(ECMallFragment r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.hybrid.card.event.d r11) {
            Intrinsics.checkNotNullParameter(r11, "jsEvent");
            Map r0 = r11.b;
            if (r0 == null) goto L6;
            Object r1 = r0.get("neednot_refresh");
            if (r1 == null) goto L6;
        L7:
            boolean r2 = Intrinsics.areEqual(r1, Boolean.TRUE);
            Map r12 = r11.b;
            if (r12 == null) goto L17;
            Iterator r13 = r12.entrySet().iterator();
        L11:
            if (r13.hasNext() == false) goto L17;
            Map.Entry r3 = (Map.Entry) r13.next();
            Object r4 = r3.getValue();
            if (r4 == null) goto L11;
            String r5 = r4.toString();
            if (r5 == null) goto L11;
            this.a.O2.put((String) r3.getKey(), r5);
        L17:
            if (r2 == true) goto L27;
            com.bytedance.android.shopping.api.mall.g.a.a(this.a, null, false, false, null, 63);
            return;
        L27:
            return;
        L6:
            r1 = Boolean.FALSE;
            goto L7
        }
    }

    public static final class t implements ECHybridNetworkTask.a {
        public final /* synthetic */ ECMallFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1 d;

        public t(ECMallFragment r1, boolean r2, boolean r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
        }

        public final void d(String r3, String r4, ECHybridNetworkVO r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            Intrinsics.checkNotNullParameter(r4, "result");
            Intrinsics.checkNotNullParameter(r5, "requestVO");
            if (this.a.isAdded() == true) goto L32;
            return;
        L32:
            ECMallFragment r7 = this.a;     // Catch: Throwable -> L29
            int r0 = ECMallFragment.h4;     // Catch: Throwable -> L29
            r7.Aa0(r3, r5, r4, true);     // Catch: Throwable -> L29
            if (this.b == false) goto L10;
            ECMallFragment.wa0(this.a);
        L10:
            if (this.c == false) goto L16;
            ECHybridListEngine r8 = this.a.H0;
            if (r8 == null) goto L16;
            ECHybridRecyclerView r9 = r8.b;
            if (r9 == null) goto L16;
            r9.m0();
        L16:
            AnchorPendantManager r10 = this.a.N2;
            if (r10 == null) goto L26;
            int r11 = AnchorPendantManager.l;
            LinkedHashSet r12 = new LinkedHashSet();
            Iterator<T> r13 = r10.d.iterator();
        L20:
            if (r13.hasNext() == false) goto L24;
            AnchorPendant r1 = (AnchorPendant) r13.next();
            if (r1.r.e == true) goto L20;
            r10.e(r1);
            Unit r2 = Unit.INSTANCE;
            r12.add(r1);
            goto L20
        L24:
            r10.d.removeAll(r12);
            r10.i();
        L26:
            if (Intrinsics.areEqual(r3, this.a.k) == false) goto L39;
            this.d.invoke(Boolean.TRUE);
            this.a.Qa0();
            return;
        L39:
            return;
        L29:
            th = move-exception;
            e(r3, th, r5, false);
        }

        public final void e(String r2, Throwable r3, ECHybridNetworkVO r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            Intrinsics.checkNotNullParameter(r3, "t");
            ECMallFragment r6 = this.a;
            int r7 = ECMallFragment.h4;
            r6.ia0().B.l = 3;
            if (this.a.isAdded() == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r2, this.a.k) == false) goto L8;
            this.a.getClass();
            this.a.Oa0();
            this.d.invoke(Boolean.FALSE);
            this.a.Qa0();
        L8:
            Lazy r8 = ECMallLogUtil.a;
            ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "refresh api " + r2 + " , message is " + r3.getMessage());
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public static final class u implements Runnable {
        public final /* synthetic */ Function0 a;

        public u(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class v implements com.bytedance.android.ec.hybrid.card.event.e {
        public final /* synthetic */ ECMallFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ v a;
            public final /* synthetic */ com.bytedance.android.ec.hybrid.card.event.d b;

            public a(v r1, com.bytedance.android.ec.hybrid.card.event.d r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Map r0 = this.b.b;     // Catch: Throwable -> L11
                if (r0 == null) goto L6;
                Object r1 = r0.get("component_id");     // Catch: Throwable -> L11
                if (r1 == null) goto L6;
            L7:
                String r2 = r1.toString();     // Catch: Throwable -> L11
                ECMallFeed r3 = this.a.a.f;     // Catch: Throwable -> L11
                if (r3 == null) goto L14;
                r3.V(r2);     // Catch: Throwable -> L11
                return;
            L14:
                return;
            L6:
                r1 = "";
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }
        }

        public v(ECMallFragment r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.hybrid.card.event.d r3) {
            Intrinsics.checkNotNullParameter(r3, "jsEvent");
            this.a.Q1.post(new a(this, r3));
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final com.bytedance.android.shopping.api.mall.idl.a Bi() {
        return null;
    }

    public final void CH() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Hv() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Jb() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void MT() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void P60(int r1) {
    }

    public final void PY(List<? extends com.bytedance.android.ec.hybrid.popup.j> r2) {
        Intrinsics.checkNotNullParameter(r2, "removeTasks");
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final yj.e Pn() {
        return null;
    }

    public final void Qa0() {
        this.S1 = false;
        this.P1.removeCallbacks(this.c4);
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Wr() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void YA() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void adReport(String r1, String r2, String r3, String r4, String r5, Map<String, ? extends Object> r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "label");
        Intrinsics.checkNotNullParameter(r4, "creativeId");
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void adThirdTrackReport(String r1, List<String> r2, Long r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "trackLabel");
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void ap() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final c0 bX() {
        return this;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void bp() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void fI() {
    }

    public final int ha0() {
        return ((Number) this.Q3.getValue()).intValue();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean hu() {
        return false;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean isAttached() {
        return true;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void jO() {
    }

    public final com.bytedance.android.shopping.mall.homepage.opt.e ja0() {
        return (com.bytedance.android.shopping.mall.homepage.opt.e) this.V3.getValue();
    }

    public final ECMallTabTouchAreaConfig la0() {
        return (ECMallTabTouchAreaConfig) this.F.getValue();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void lx() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean n10() {
        return false;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void rL(String r2, String r3, String r4, Function0 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "bubbleComponentID");
        Intrinsics.checkNotNullParameter(r3, "bubbleIcon");
        Intrinsics.checkNotNullParameter(r4, "bubbleText");
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        Intrinsics.checkNotNullParameter(r6, "onFail");
    }

    public final void release() {
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final void sj() {
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void u90(String r2) {
        Intrinsics.checkNotNullParameter(r2, "apiKey");
    }

    public final boolean Ca0() {
        ECMallPopupRenderOptConfig.a r0 = ECMallPopupRenderOptConfig.Companion;
        String r1 = this.d.e();
        r0.getClass();
        if (ECMallPopupRenderOptConfig.a.b(r1) <= 0) goto L6;
        return true;
    L6:
        Boolean r2 = null;
        if (this.i != null) goto L13;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L11;
        yj.g r4 = r3.getHostAB();
    L12:
        this.i = r4;
        goto L13
    L11:
        r4 = null;
    L13:
        yj.g r5 = this.i;
        if (r5 == null) goto L17;
        r2 = (Boolean) r5.a("mall_api_pre_main_process_enabled", Boolean.FALSE);
    L17:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final mf3.a DE() {
        return this.d.u.a();
    }

    public final void Ea0() {
        MallCrashListener r0 = this.V;
        r0.getClass();
        if (HybridAppInfoService.m() == false) goto L18;
        aa3.f r1 = (aa3.f) r0.b.getValue();
        Long r3 = null;
        if (r1 == null) goto L8;
        Integer r2 = r1.b();
    L9:
        if (r2 == null) goto L18;
        aa3.f r4 = (aa3.f) r0.b.getValue();
        if (r4 == null) goto L13;
        r3 = r4.c();
    L13:
        if (r3 == null) goto L18;
        if (r0.a == true) goto L18;
        r0.a = true;
        Npth.registerCrashCallback(r0.c, CrashType.ALL);
        goto L18
    L8:
        r2 = null;
    L18:
        ECMallFragment$pageStateHelper$1 r5 = this.E;
        Iterator r6 = ((ArrayList) r5.a).iterator();
    L20:
        if (r6.hasNext() == false) goto L23;
        ((com.bytedance.android.shopping.api.mall.b.a) r6.next()).b(r5.a());
        goto L20
    L23:
        if (this.H2 == false) goto L94;
        ECMallFeed r7 = this.f;
        if (r7 != null) goto L27;
    L61:
        Iterator r8 = ((ArrayList) this.Z).iterator();
    L63:
        if (r8.hasNext() == false) goto L65;
        ((com.bytedance.android.shopping.mall.feed.help.g) r8.next()).j(true);
        goto L63
    L65:
        ECDeepFeedDomainPreConnectUtil r9 = (ECDeepFeedDomainPreConnectUtil) this.L1.getValue();
        if (r9 == null) goto L95;
        ECDeepFeedDomainPreConnectUtil.g.getClass();
        com.bytedance.android.shopping.api.mall.opt.a r10 = ECDeepFeedDomainPreConnectUtil.a.b();
        if (r10.b() == true) goto L70;
        r9.e();
        return;
    L70:
        Set<String> r11 = ECDeepFeedDomainPreConnectUtil.h(r10.a());
        if (r11.isEmpty() == false) goto L73;
        r9.e();
        return;
    L73:
        Long r12 = r10.c();
        if (r12 != null) goto L76;
    L85:
        r9.e();
        return;
    L76:
        if (r12.longValue() <= 0) goto L85;
        Long r13 = r9.e;
        if (r13 != null) goto L81;
        r9.i(r11);
        r9.d(r12.longValue());
        return;
    L81:
        long r14 = System.currentTimeMillis() - r13.longValue();
        if (r14 < r12.longValue()) goto L84;
        r9.i(r11);
        r9.d(r12.longValue());
        return;
    L84:
        r9.d(RangesKt.coerceAtLeast(r12.longValue() - r14, 1));
        return;
    L95:
        return;
    L27:
        if (r7.v() == null) goto L53;
        ECHybridListEngine r15 = r7.J;
        if (r15 == null) goto L61;
        DataResolver r16 = r15.c;
        r16.getClass();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        ArrayList r19 = r16.i;
        if (r19 == null) goto L49;
        int r20 = r19.size() - 1;
    L33:
        if (r20 < 0) goto L49;
        ECHybridListItemVO r21 = (ECHybridListItemVO) CollectionsKt.getOrNull(r19, r20);
        if (r21 != null) goto L37;
    L39:
        if (r21 == null) goto L48;
        Integer r22 = r21.c;
        if (r22 == null) goto L43;
        int r23 = r22.intValue();
    L44:
        ListProtector.add(r17, 0, String.valueOf(r23));
        Object r24 = r21.d;
        if (r24 != null) goto L47;
        r24 = -1;
    L47:
        ListProtector.add(r18, 0, r24.toString());
        goto L48
    L43:
        r23 = -1;
    L48:
        r20 = r20 - 1;
        goto L33
    L37:
        if (r21.H != true) goto L39;
        Pair r25 = TuplesKt.to(r17, r18);
    L50:
        if (r25 == null) goto L61;
        MallGulRequestUtil.INSTANCE.exposureEvent(new com.bytedance.android.shopping.mall.opt.c(Long.valueOf(r7.a1), (List) r25.getFirst(), (List) r25.getSecond(), r7.B1.c));
    L49:
        r25 = TuplesKt.to(r17, r18);
    L53:
        r7.a1 = System.currentTimeMillis();
        ECMallGulRefresh r26 = r7.w();
        if (r26 == null) goto L56;
        r26.b = r7.Q;
    L56:
        Iterator r27 = ((ArrayList) r7.k1).iterator();
    L58:
        if (r27.hasNext() == false) goto L60;
        ((e93.e) r27.next()).onBackMall();
        goto L58
    L60:
        r7.c0("back", 5);
        goto L61
    }

    public final void Oa0() {
        ECHybridListEngine r0 = this.H0;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.hybrid.list.entity.k r1 = r0.c.g;
        return;
    }

    public final void Ra0() {
        Lazy r0 = MallOptUtil.a;
        String r1 = this.d.e();
        if (r1 == null) goto L10;
        List<String> r3 = MallOptUtil.d().b();
        if (r3 == null) goto L10;
        if (r3.contains(r1) != true) goto L10;
        List<String> r2 = MallOptUtil.d().e();
    L11:
        if (r2 != null) goto L13;
        ECEventCenter.d().d(false, null);
        return;
    L13:
        ECEventCenter.d().d(true, r2);
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final com.bytedance.android.shopping.mall.feed.help.q TN() {
        return (MallShelterHelp) this.v.getValue();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void VI() {
        ECMFTopBarComponent r0 = this.e.d;
    }

    public final void ea0() {
        if (this.f != null) goto L5;
        return;
    L5:
        if ((!this.v2.isEmpty()) == false) goto L24;
        Iterator<Map<String, Object>> r0 = this.v2.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Map<String, Object> r1 = r0.next();
        ECMallFeed r2 = this.f;
        if (r2 == null) goto L8;
        ECMallFeed.ReportAbility r3 = r2.j0;
        if (r3 == null) goto L8;
        k93.g.a.a(r3, r1, null, null, 14);
        goto L8
    L14:
        this.v2.clear();
        return;
    }

    public final String ga0() {
        ECFMiddleware r0 = this.d;
        if (Intrinsics.areEqual(r0.e(), MallPageName.X_TAB_MALL) == true) goto L8;
        IECNativeHomeArgument r1 = r0.f();
        if (r1 == null) goto L8;
        return r1.getDataEngineTag();
    L8:
        return null;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Map<String, Object> getPageInfo() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void h10() {
        if (this.o == false) goto L5;
        return;
    L5:
        this.o = true;
    }

    public final ECMallFavoriteSectionHelper ia0() {
        return (ECMallFavoriteSectionHelper) this.d.s.getValue();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean isDarkMode() {
        return Intrinsics.areEqual(this.d.a(), "dark");
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean kn() {
        if (com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin() == false) goto L5;
        boolean r0 = true;
    L22:
        boolean r3 = true;
    L24:
        if (this.H2 == true) goto L28;
        if (this.I2 == true) goto L28;
    L32:
        boolean r4 = false;
    L33:
        if (r4 == false) goto L37;
        if (r0 == false) goto L37;
        if (r3 == false) goto L37;
        return true;
    L37:
        return false;
    L28:
        if (this.J2 == true) goto L32;
        if (this.S1 == true) goto L32;
        r4 = true;
        goto L33
    L5:
        if (((Number) this.C3.getValue()).intValue() <= 0) goto L14;
        ECMallFeed r1 = this.f;
        if (r1 == null) goto L9;
        int r2 = r1.M;
    L11:
        if (r2 < ((Number) this.C3.getValue()).intValue()) goto L14;
        r0 = false;
    L16:
        if (((Number) this.D3.getValue()).intValue() <= 0) goto L22;
        if (this.H3 < ((Number) this.D3.getValue()).intValue()) goto L22;
        r3 = false;
        goto L24
    L9:
        r2 = 0;
    L14:
        r0 = true;
        goto L16
    }

    public final IECNativeHomeArgument ma0() {
        return this.d.f();
    }

    public final ck.a na0() {
        return this.d.g();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Map<String, Object> oU() {
        LinkedHashMap r0 = new LinkedHashMap();
        ECMFTopBarComponent r1 = this.e.d;
        if (r1 == null) goto L5;
        r0.put("t_top_bar_load", Long.valueOf(r1.m));
        r0.put("t_top_bar_create_view", Long.valueOf(r1.l));
    L5:
        return r0;
    }

    public final String oa0() {
        return (String) this.d.k.getValue();
    }

    public final void ta0() {
        if (this.b2 == false) goto L5;
        return;
    L5:
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko finish");
        this.b2 = true;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.g.a.b, "bindFirstScreenData: needBind:true");
        Iterator r1 = ((ArrayList) this.h2).iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        com.bytedance.android.shopping.api.mall.common.tools.n r2 = (com.bytedance.android.shopping.api.mall.common.tools.n) r1.next();
        if (r2.b != null) goto L10;
        String r3 = r2.a;
        Intrinsics.checkNotNull(r3);
        Throwable r4 = r2.c;
        Intrinsics.checkNotNull(r4);
        Function1<Boolean, Unit> r5 = r2.d;
        Intrinsics.checkNotNull(r5);
        ba0(r3, r4, r5);
        goto L7
    L10:
        String r6 = r2.a;
        Intrinsics.checkNotNull(r6);
        String r7 = r2.b;
        Intrinsics.checkNotNull(r7);
        Function1<Boolean, Unit> r8 = r2.d;
        Intrinsics.checkNotNull(r8);
        ca0(r6, r7, null, r8);
        goto L7
    L12:
        ((ArrayList) this.h2).clear();
    }

    public final void xa0() {
        boolean r0 = this.U2;
        Iterator<T> r1 = this.Z.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.help.g) r1.next()).k(false);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [com.bytedance.android.shopping.mall.homepage.ECMallFragment$hostSetupListener$1] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.bytedance.android.shopping.mall.homepage.ECMallFragment$channelItemShowEventSubscriber$1] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.bytedance.android.shopping.mall.homepage.ECMallFragment$tabItemShowEventSubscriber$1] */
    public ECMallFragment() {
        ECFMiddleware r0 = new ECFMiddleware(this);
        this.d = r0;
        this.e = new com.bytedance.android.shopping.mall.homepage.component.c(this, r0);
        IECNativeContainerLoadState$MallState r1 = IECNativeContainerLoadState$MallState.INIT;
        this.g = -1;
        this.h = LazyKt.lazy(ECMallFragment$preloadPendingRunnableList$2.INSTANCE);
        this.j = new com.bytedance.android.shopping.mall.homepage.opt.b();
        this.k = "homepage";
        this.l = new ECMarketingHelper();
        this.q = new com.bytedance.android.shopping.mall.c();
        this.r = new d();
        this.s = new com.bytedance.android.shopping.mall.f();
        this.t = new o();
        this.u = new df3.a();
        this.v = LazyKt.lazy(new ECMallFragment$mallShelterHelp$2(this));
        this.w = new ECMallFragment$hostSetupListener$1(this);
        UUID.randomUUID().toString();
        this.x = new e(this);
        this.y = new f(this);
        this.z = new v(this);
        this.A = new ECMallFragment$channelItemShowEventSubscriber$1(this);
        this.B = new ECMallFragment$tabItemShowEventSubscriber$1(this);
        this.E = new ECMallFragment$pageStateHelper$1(this);
        this.F = LazyKt.lazy(ECMallFragment$mallTabTouchAreaConfig$2.INSTANCE);
        this.G = LazyKt.lazy(ECMallFragment$ioDispatchOptEnable$2.INSTANCE);
        this.H = LazyKt.lazy(ECMallFragment$jsonParseOptEnable$2.INSTANCE);
        this.I = LazyKt.lazy(ECMallFragment$firstScreenImageOptEnable$2.INSTANCE);
        this.J = LazyKt.lazy(ECMallFragment$aiPrefetchCallbackAppend$2.INSTANCE);
        this.S = LazyKt.lazy(new ECMallFragment$drainageOpt$2(this));
        this.T = LazyKt.lazy(new ECMallFragment$preloadTaskManager$2(this));
        this.U = new com.bytedance.android.shopping.mall.homepage.card.e();
        this.V = new MallCrashListener();
        this.Y = LazyKt.lazy(ECMallFragment$sevenSplitScreenCheck$2.INSTANCE);
        this.Z = new ArrayList();
        this.k0 = LazyKt.lazy(new ECMallFragment$rebuildMonitor$2(this));
        this.p0 = r0.g;
        this.h1 = new ArrayList();
        this.x1 = true;
        this.y1 = new y93.d(50001, "popup", 8388349);
        this.G1 = new y93.g(0);
        this.H1 = new y93.f(null, null, null);
        this.L1 = LazyKt.lazy(new ECMallFragment$deepFeedDomainPreConnectUtil$2(this));
        this.P1 = r0.i;
        this.Q1 = new Handler(Looper.getMainLooper());
        this.h2 = new ArrayList();
        this.p2 = new LinkedHashMap();
        this.v2 = new CopyOnWriteArrayList();
        this.y2 = -1;
        System.currentTimeMillis();
        this.L2 = true;
        this.M2 = LazyKt.lazy(ECMallFragment$grayUtil$2.INSTANCE);
        this.O2 = new HashMap();
        this.R2 = new g93.a();
        this.S2 = r0.h;
        this.T2 = new jf3.e();
        this.a3 = LazyKt.lazy(ECMallFragment$enableCDNLoadOpt$2.INSTANCE);
        this.b3 = LazyKt.lazy(ECMallFragment$splitFrame$2.INSTANCE);
        this.d3 = -1;
        this.e3 = -1;
        this.f3 = -1;
        this.i3 = LazyKt.lazy(ECMallFragment$memTriggeredCacheClean$2.INSTANCE);
        this.j3 = new s(this);
        this.o3 = com.bytedance.android.shopping.api.mall.common.tools.h.b.needCheckLoginState();
        this.p3 = new j(this);
        this.q3 = LazyKt.lazy(new ECMallFragment$mallInitTaskManager$2(this));
        this.r3 = -1;
        this.t3 = new ECMallFragment$onThemeChangeListener$1(this);
        this.u3 = LazyKt.lazy(new ECMallFragment$deliverOpt$2(this));
        this.v3 = true;
        this.z3 = true;
        this.A3 = new com.bytedance.android.ec.hybrid.popup.e();
        this.B3 = LazyKt.lazy(ECMallFragment$gotoLoginPageNum$2.INSTANCE);
        this.C3 = LazyKt.lazy(ECMallFragment$notLoginMaxPageNum$2.INSTANCE);
        this.D3 = LazyKt.lazy(ECMallFragment$notLoginMaxLoadMoreContinuationFailCount$2.INSTANCE);
        this.E3 = LazyKt.lazy(ECMallFragment$mallCardWindowOpt$2.INSTANCE);
        this.F3 = LazyKt.lazy(ECMallFragment$getCardPositonOpt$2.INSTANCE);
        this.G3 = LazyKt.lazy(ECMallFragment$prefetchFlowOptEnable$2.INSTANCE);
        this.K3 = LazyKt.lazy(new ECMallFragment$loginController$2(this));
        this.Q3 = LazyKt.lazy(new ECMallFragment$deliveryReduceStrategy$2(this));
        this.T3 = true;
        this.U3 = LazyKt.lazy(ECMallFragment$coroutineScope$2.INSTANCE);
        this.V3 = LazyKt.lazy(new ECMallFragment$firstScreenHelp$2(this));
        this.W3 = LazyKt.lazy(new ECMallFragment$marketingResourceEventSubscriber$2(this));
        this.X3 = new k(this);
        this.a4 = new g(this);
        this.b4 = LazyKt.lazy(ECMallFragment$lockRefreshTimeOut$2.INSTANCE);
        this.c4 = new a(this);
        this.e4 = true;
    }

    public final void Fa0() {
        if (getContext() != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L25;
        FragmentActivity r0 = getActivity();
        boolean r1 = true;
        if (r0 != null) goto L9;
    L11:
        this.W = true;
        jf3.c r2 = this.p0;
        IECNativeHomeArgument r3 = ma0();
        if (r3 != null) goto L14;
    L21:
        r1 = false;
    L22:
        r2.b(r1);
        return;
    L14:
        if (r3.getEnableFirstScreenStraightOut() != true) goto L21;
        if (com.bytedance.android.shopping.mall.homepage.tools.q.a(requireContext(), ga0()).length() <= 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
    L18:
        r4 = false;
        goto L19
    L9:
        if (r0.isFinishing() != true) goto L11;
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Fragment M() {
        return getParentFragment();
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void closePage() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> getGlobalProps() {
        return MapsKt.emptyMap();
    }

    public final void onDestroy() {
        super.onDestroy();
        Lazy r0 = ECMallFeedDataReuseHelper.a;
        ECMallFeedDataReuseHelper.b(this.d.e(), ga0());
        CoroutineScopeKt.cancel$default((CoroutineScope) this.U3.getValue(), null, 1, null);
        MallShelterHelp r1 = (MallShelterHelp) this.v.getValue();
        if (r1 == null) goto L10;
        ECEventCenter.f("ec.on_popup_show", (com.bytedance.android.ec.hybrid.card.event.e) r1.h.getValue());
        ECEventCenter.f("ec.on_popup_dismiss", (com.bytedance.android.ec.hybrid.card.event.e) r1.i.getValue());
        if (MallSettings.a() == false) goto L8;
        r1.k.getActivity().getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(r1.j);
    L8:
        if (MallShelterHelp.l != 1) goto L10;
        Map r3 = ECMediaWrapperForLynx.f;
        String r2 = r1.k.c;
        Intrinsics.checkNotNullParameter(r2, "containerId");
        ECMediaWrapperForLynx.f.remove(r2);
    L10:
        ECMallFeed r4 = this.f;
        if (r4 == null) goto L16;
        ECMarketingHelper$scrollerListener$1 r5 = this.l.c;
        Intrinsics.checkNotNullParameter(r5, "scrollListener");
        ECHybridListEngine r6 = r4.J;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "listener");
        r6.b.removeOnScrollListener(r5);
    L16:
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.mall.settings.b) this.i3.getValue()).a(), Boolean.TRUE) == false) goto L22;
        com.bytedance.android.shopping.mall.homepage.i r7 = this.h3;
        if (r7 == null) goto L22;
        IECMallTabOptService r8 = this.g3;
        if (r8 == null) goto L22;
        r8.a(r7);
    L22:
        ECDeepFeedDomainPreConnectUtil r9 = (ECDeepFeedDomainPreConnectUtil) this.L1.getValue();
        if (r9 == null) goto L31;
        monitor-enter(r9);
        r9.g();     // Catch: Throwable -> L28
        r9.e = null;     // Catch: Throwable -> L28
        monitor-exit(r9);
        ECDeepFeedDomainPreConnectUtil.a.a(ECDeepFeedDomainPreConnectUtil.g, r9);
    L28:
        th = move-exception;
        throw th;
    L31:
        Lazy r10 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.o.b r11 = com.bytedance.android.ec.hybrid.log.mall.o.b.b;
        ECMallLogUtil.c(r11, "ECMallFragment#onDestroy()@" + hashCode());
        IECMallHomepageService r12 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r12 == null) goto L34;
        r12.releaseInstance(this);
    L34:
        int r13 = com.bytedance.android.shopping.api.mall.common.tools.u.a;
        Intrinsics.checkNotNullParameter("native_mall_scene", "key");
        Npth.addTags(MapsKt.mapOf(TuplesKt.to("native_mall_scene", null)));
        this.P1.removeCallbacksAndMessages(null);
        this.Q1.removeCallbacksAndMessages(null);
        ECMallFavoriteSectionHelper r14 = ia0();
        Lazy r15 = ECMallFavoriteSectionHelper.I;
        boolean r16 = false;
        r14.g(false);
        TransitionAnimationHelper.c = null;
        FragmentActivity r17 = getActivity();
        if (r17 != null) goto L37;
    L38:
        FragmentActivity r18 = getActivity();
        if (r18 != null) goto L41;
    L68:
        if (MallSettings.a() == false) goto L83;
        MallNetApplier r19 = this.m;
        if (r19 == null) goto L77;
        ECHybridDataEngine r20 = this.P0;
        if (r20 == null) goto L77;
        Intrinsics.checkNotNullParameter(r19, "applier");
        if (Intrinsics.areEqual(r19, r20.n) == false) goto L77;
        r20.n = null;
        r20.p.l(null);
    L77:
        if (((Boolean) MallSettings.b.getValue()).booleanValue() == false) goto L83;
        HomepageChunkedCallback r21 = this.Y2;
        if (r21 == null) goto L83;
        com.bytedance.android.shopping.mall.homepage.tools.l r22 = this.Z2;
        if (r22 == null) goto L83;
        r22.a(r21);
    L83:
        this.R2.getClass();
        g93.a.a.clear();
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();
        if (r23 == null) goto L88;
        yj.g r24 = r23.getHostAB();
        if (r24 == null) goto L88;
        r24.p();
    L88:
        this.p0.d();
        ECEventCenter.f("mallRefreshHomepageEvent", this.j3);
        pf3.a r25 = (pf3.a) this.W3.getValue();
        if (r25 == null) goto L91;
        ECEventCenter.f("ec.mall.marketingResource", r25);
    L91:
        ECEventCenter.f("ecom.mall.tool_show", this.z);
        ECEventCenter.f("ecom.mall.channel_show", this.A);
        ECEventCenter.f("ecom.mall.tab_show", this.B);
        EventCenter.unregisterJsEventSubscriber("ecom.mall.coin_pendant_show", this.y);
        EventCenter.unregisterJsEventSubscriber("ecom.mall.coin_pendant_dismissed", this.x);
        Lazy r26 = ECImageCustomDiskCacheHelper.a;
        ECImageCustomDiskCacheHelper.c(hashCode(), null, null);
        yj.s r27 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService();
        Pair<? extends MutableLiveData<Boolean>, ? extends Object> r28 = this.m3;
        if (r28 == null) goto L94;
        r28.getSecond();
    L94:
        r27.a();
        int r29 = lk.b.a;
        Intrinsics.checkNotNullParameter(oa0(), "sceneID");
        AnchorPendantManager r30 = this.N2;
        if (r30 != null) goto L121;
    L103:
        ck.a r31 = na0();
        if (r31 == null) goto L106;
        r31.release();
    L106:
        this.S2.a.clear();
        ((ArrayList) this.E.a).clear();
        this.A3.a.clear();
        this.T2.a.clear();
        if (com.bytedance.android.shopping.mall.opt.j.b() == true) goto L109;
    L111:
        this.e.onDestroy();
        ECFMiddleware r32 = this.d;
        r32.n = null;
        r32.o = null;
        this.u.getClass();
        if (((Number) this.F3.getValue()).intValue() != 0) goto L116;
        ECMarketingHelper r33 = this.l;
        ECMallFragment$releaseGetPositionEvent$1 r34 = ECMallFragment$releaseGetPositionEvent$1.INSTANCE;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "callBack");
        IMarketingServiceV2 r35 = ECMarketingHelper.a();
        if (r35 == null) goto L116;
        r35.h(r34);
    L116:
        this.s.getClass();
        ECBridgeMethodFinder.a r36 = ECBridgeMethodFinder.h;
        String r37 = oa0();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "sceneID");
        HashMap r38 = (HashMap) ((HashMap) ECBridgeMethodFinder.g.getValue()).remove(r37);
        if (r38 == null) goto L119;
        r38.clear();
    L119:
        ECEventCenter.b(oa0());
        return;
    L109:
        if (com.bytedance.android.shopping.mall.opt.j.a().contains(this.d.e()) == false) goto L111;
        this.q.getClass();
        HostSetupWatcher.INSTANCE.unregisterHostSetupListener(this.w);
        goto L111
    L121:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L98
        r30.a(true);     // Catch: Throwable -> L98
        r30.c.a();     // Catch: Throwable -> L98
        ik.a r40 = r30.j;     // Catch: Throwable -> L98
        r40.getClass();     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r30, "listener");     // Catch: Throwable -> L98
        r40.a.remove(r30);     // Catch: Throwable -> L98
        Object r41 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L98
    L100:
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L103;
        EnsureManager.ensureNotReachHere(r42);
    L98:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L100
    L41:
        if (r18.isDestroyed() != true) goto L68;
    L42:
        ECHybridDataEngine r44 = this.P0;
        if (r44 == null) goto L50;
        Intrinsics.checkNotNullParameter(this, "target");
        Lazy r45 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L50;
        if (r44.h.contains(this) == false) goto L50;
        r44.h.remove(this);
        ECMallLogUtil.c(r11, "DataEngine#unbind(), target = " + hashCode() + ", times = " + r44.i.decrementAndGet() + '}');
    L50:
        Map<String, DataEngineWrapper> r46 = DataEngineMap.a;
        IECNativeHomeArgument r47 = ma0();
        if (r47 == null) goto L54;
        String r48 = r47.getDataEngineTag();
        if (r48 == null) goto L54;
    L55:
        Intrinsics.checkNotNullParameter(r48, "key");
        ECMallLogUtil.c(r11, "DataEngineMap#releaseDataEngine(), key = ".concat(r48));
        Map<String, DataEngineWrapper> r49 = DataEngineMap.a;
        DataEngineWrapper r50 = (DataEngineWrapper) ((LinkedHashMap) r49).get(r48);
        if (r50 == null) goto L68;
        ECHybridDataEngine r51 = r50.a;
        if (r51 == null) goto L66;
        Lazy r52 = ECHybridDataEngine.q;
        Lazy r53 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L62;
    L64:
        r51.f();
        ((CompositeDisposable) r51.b.getValue()).dispose();
        ECHybridDataEngine.w.release();
        r16 = true;
    L65:
        if (r16 == false) goto L68;
    L62:
        if (r51.i.get() == 0) goto L64;
        ECMallLogUtil.c(r11, "DataEngine won't release, because boundTimes = " + r51.i.get());
    L66:
        r49.remove(r48);
    L54:
        r48 = "default";
        goto L55
    L37:
        if (r17.isFinishing() == true) goto L42;
        goto L38
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.onDestroyView();
        if (Intrinsics.areEqual(ECLynxBuildUtilKt.c, oa0()) == false) goto L6;
        ECLynxBuildUtilKt.c = null;
        return;
    }

    public final void onPause() {
        super.onPause();
        ECEventCenter.d().d(false, null);
        com.bytedance.android.shopping.api.mall.m r0 = (com.bytedance.android.shopping.api.mall.m) this.T.getValue();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "ECMallFragment#onPause()@" + hashCode());
        ECMallFragment$pageStateHelper$1 r2 = this.E;
        Iterator r3 = ((ArrayList) r2.a).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((com.bytedance.android.shopping.api.mall.b.a) r3.next()).b(r2.a());
        goto L7
    L9:
        MallCrashListener r4 = this.V;
        r4.getClass();
        if (HybridAppInfoService.m() == true) goto L13;
    L15:
        Iterator r5 = ((ArrayList) this.Z).iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        ((com.bytedance.android.shopping.mall.feed.help.g) r5.next()).j(false);
        goto L17
    L19:
        ECMallFeed r6 = this.f;
        if (r6 == null) goto L38;
        r6.j0.j(false);
        ECMallCommonImpressionReportHelper.b r7 = r6.t();
        if (r7 != null) goto L24;
    L33:
        Iterator r8 = ((ArrayList) r6.k1).iterator();
    L35:
        if (r8.hasNext() == false) goto L37;
        ((e93.e) r8.next()).onLeaveMall();
        goto L35
    L37:
        r6.c0("leave", null);
        goto L38
    L24:
        if (r7.a != true) goto L33;
        ECMallCommonImpressionReportHelper r9 = r6.u();
        if (r9 == null) goto L33;
        if (r9.g == true) goto L33;
        if (r9.i.d == false) goto L33;
        r9.a.post(new com.bytedance.android.shopping.api.mall.common.feed.help.b(r9));
    L38:
        ECDeepFeedDomainPreConnectUtil r10 = (ECDeepFeedDomainPreConnectUtil) this.L1.getValue();
        if (r10 == null) goto L41;
        r10.e();
    L41:
        Lazy r11 = ECMallFeedDataReuseHelper.a;
        ECMallFeedDataReuseHelper.b(this.d.e(), ga0());
        MallShelterHelp r12 = (MallShelterHelp) this.v.getValue();
        if (r12 != null) goto L44;
    L46:
        Da0(false);
    L47:
        com.bytedance.android.shopping.mall.homepage.tools.c0.a = null;
        if (this.R3 == false) goto L54;
        this.S3 = true;
        return;
    L54:
        return;
    L44:
        if (r12.d != true) goto L46;
        this.c3 = true;
        goto L47
    L13:
        if (r4.a == false) goto L15;
        Npth.unregisterCrashCallback(r4.c, CrashType.ALL);
        r4.a = true;
        goto L15
    }

    public final void onResume() {
        super.onResume();
        if (ha0() != 2) goto L5;
    L11:
        this.S3 = false;
        MallShelterHelp r0 = (MallShelterHelp) this.v.getValue();
        if (r0 == null) goto L14;
        r0.d = false;
    L14:
        Lazy r1 = ECImageCustomDiskCacheHelper.a;
        ECImageCustomDiskCacheHelper.c(hashCode(), this.d.e(), this.d.c());
        DataEngineWrapper r2 = this.L0;
        if (r2 == null) goto L21;
        y93.a r3 = r2.b;
        if (r3 == null) goto L21;
        if (r3.c != true) goto L21;
        Ra0();
    L21:
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "ECMallFragment#onResume()@" + hashCode());
        Ea0();
        Da0(true);
        ECMallFeed r5 = this.f;
        if (r5 == null) goto L24;
        r5.U(r5.v0);
    L24:
        Lazy r6 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.c = new AnonymousClass2(this);
        com.bytedance.android.shopping.mall.homepage.tools.c0.a = null;
        com.bytedance.android.shopping.api.mall.m r7 = (com.bytedance.android.shopping.api.mall.m) this.T.getValue();
        if (r7 == null) goto L28;
        r7.b();
        return;
    L28:
        return;
    L5:
        if (this.R3 == false) goto L11;
        if (this.S3 == false) goto L11;
        if (this.V1 == true) goto L11;
        this.R3 = false;
        ECMallDeliveryReduceConfig r8 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        Intrinsics.checkNotNullParameter(new C02731(this), "renderCacheDataAction");
        goto L11
    }

    public final void onStart() {
        super.onStart();
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "ECMallFragment#onStart()@" + hashCode());
        IECMallHomepageService r1 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r1 == null) goto L6;
        r1.setupInstance(this);
        return;
    }

    public final void onStop() {
        super.onStop();
        MallShelterHelp r0 = (MallShelterHelp) this.v.getValue();
        if (r0 == null) goto L5;
        r0.d = false;
    L5:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "ECMallFragment#onStop()@" + hashCode());
        this.e.onStop();
        Context r2 = getContext();
        if (r2 == null) goto L11;
        if (Intrinsics.areEqual(this.d.e(), MallPageName.X_TAB_MALL) == false) goto L11;
        boolean r3 = com.bytedance.android.ec.hybrid.list.util.o.a;
        com.bytedance.android.ec.hybrid.list.util.o.a(r2, hashCode());
    L11:
        if (this.c3 == false) goto L13;
        Da0(false);
        this.c3 = false;
    L13:
        Map<String, SoftReference<com.bytedance.android.shopping.api.mall.m>> r4 = com.bytedance.android.shopping.mall.homepage.preload.h.a;
        Context r5 = getContext();
        String r6 = this.d.e();
        Intrinsics.checkNotNullParameter(r6, "pageName");
        Object r7 = com.bytedance.android.shopping.mall.homepage.preload.h.b;
        monitor-enter(r7);
        SoftReference<com.bytedance.android.shopping.api.mall.m> r8 = com.bytedance.android.shopping.mall.homepage.preload.h.a.remove(r6);     // Catch: Throwable -> L27
        monitor-exit(r7);
        if (r5 == null) goto L20;
        com.bytedance.android.shopping.mall.homepage.preload.h.b(r5, r6);
    L20:
        if (aa3.e.a == false) goto L32;
        ECHybridListEngine r9 = this.H0;
        if (r9 == null) goto L33;
        ECHybridRecyclerView r10 = r9.b;
        if (r10 == null) goto L34;
        r10.K();
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final LifecycleOwner s4() {
        return getViewLifecycleOwner();
    }

    public final boolean s60() {
        long r0 = System.currentTimeMillis() - this.r3;
        int r2 = s93.c.a;
        Object r3 = 1000;
        IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
        if (r4 == null) goto L10;
        yj.g r5 = r4.getHostAB();
        if (r5 == null) goto L10;
        Object r6 = r5.a("na_mall_straight_dispatch_opt_least_duration", r3);
        if (r6 == null) goto L10;
        r3 = r6;
    L10:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : na_mall_straight_dispatch_opt_least_duration, Value: " + r3);
        if (r0 > ((Number) r3).longValue()) goto L13;
    L15:
        return false;
    L13:
        if (this.T3 == false) goto L15;
        return true;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Map<String, String> zH() {
        IECNativeHomeArgument r0 = ma0();
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.getGrassParams();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    public final void za0() {
        IECNativeHomeArgument r0 = ma0();
        if (r0 == null) goto L5;
        final Boolean r1 = Boolean.valueOf(r0.getEnableFirstScreenStraightOut());
    L7:
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L9;
        this.g = 1;
        Pa0(null);
    L9:
        IECMallHostService r2 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r2 == null) goto L12;
        r2.clearPendingPreloadTasks();
    L12:
        ya0(new ECMallFragment$initDataOnCreate$1(this, r1), new ECMallFragment$initDataOnCreate$2(this));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Map<String, Object> EA() {
        return this.O2;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean JQ() {
        return this.S1;
    }

    public final boolean KB() {
        return this.V1;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final AnchorPendantManager Pt() {
        return this.N2;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final boolean Q20() {
        return this.n;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final String ZJ() {
        return this.R;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final ViewGroup ex() {
        return this.P2;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final jf3.e jF() {
        return this.T2;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean oi() {
        return this.K2;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class S90(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static ECLynxLoadType ka0(ECMallFragment r2) {
        r2.getClass();
        Map r0 = com.bytedance.android.ec.hybrid.list.util.r.a;
        return com.bytedance.android.ec.hybrid.list.util.r.a(r2.oa0(), -1, 4);
    }

    public static void qa0(ECMallFragment r5) {
        r5.getClass();
        int r0 = s93.c.a;
        Object r1 = 0;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("ec_mall_waiting_handle_cache_data_timeout", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_waiting_handle_cache_data_timeout, Value: " + r1);
        if (((Number) r1).intValue() > 0) goto L13;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "invoke handleCacheData directly because disabled, timestamp = " + System.currentTimeMillis());
        r5.pa0(false, false);
        return;
    L13:
        r5.d.e();
        Map<String, SoftReference<com.bytedance.android.shopping.api.mall.m>> r7 = com.bytedance.android.shopping.mall.homepage.preload.h.a;
        com.bytedance.android.shopping.api.mall.m r8 = com.bytedance.android.shopping.mall.homepage.preload.h.a(r5.d.e());
        if (r8 != null) goto L16;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "invoke handleCacheData directly because preloadTaskManager is null, timestamp = " + System.currentTimeMillis());
        r5.pa0(false, false);
        return;
    L16:
        r8.a();
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "invoke handleCacheData directly because there is no PreloadLynxViewTask, timestamp = " + System.currentTimeMillis());
        r5.pa0(false, false);
    }

    public static void wa0(ECMallFragment r2) {
        ECMallFeed r0 = r2.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.f != null) goto L8;
        r0.f = new com.bytedance.android.shopping.mall.homepage.d(r2);
    L8:
        r0.i0(false);
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void BQ(Boolean r7) {
        if (r7 == null) goto L9;
        boolean r8 = r7.booleanValue();
        ECMallFeed r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.api.mall.common.feed.help.e r1 = r0.p1;
        if (r1 == null) goto L9;
        r1.b = r8;
    L9:
        com.bytedance.android.shopping.api.mall.g.a.a(this, null, false, true, null, 47);
    }

    public final List<Object> Ba0(String r3) {
        Lazy r0 = MallBehaviorUtil.a;
        return MallBehaviorUtil.a(new MallBehaviorUtil.a(this.d.e(), r3));
    }

    public final void Da0(final boolean r14) {
        com.bytedance.android.shopping.mall.homepage.opt.b r0 = this.j;
        monitor-enter(r0);
        monitor-exit(r0);
        this.w3 = r14;
        this.x3 = false;
        this.y3 = false;
        IECNativeHomeArgument r1 = ma0();
        if (r1 != null) goto L8;
    L16:
        ECLynxCard r4 = this.k1;
        if (r4 == null) goto L19;
        IVerseService r2 = ECLynxCard.f;
        ECLynxCard.m(r4, r14, "page", ECLynxCard.a.a(false, false), false, false, false, this.M1, 56);
    L19:
        this.e.g(r14);
        ECHybridListEngine r3 = this.H0;
        if (r3 == null) goto L22;
        Intrinsics.checkNotNullParameter("page", "source");
        r3.b.R(r14, false, false);
    L22:
        ECLynxCard r5 = this.p1;
        if (r5 == null) goto L25;
        IVerseService r6 = ECLynxCard.f;
        ECLynxCard.m(r5, r14, "page", ECLynxCard.a.a(false, false), false, false, false, 0, 248);
    L25:
        this.L2 = r14;
        Lazy r7 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L34;
        if (r14 == false) goto L29;
        this.y2 = SystemClock.uptimeMillis();
        goto L34
    L29:
        Pair[] r8 = new Pair[2];
        r8[0] = TuplesKt.to("eventName", "ecom_stay_time");
        if (this.y2 == (-1)) goto L32;
        long r9 = SystemClock.uptimeMillis() - this.y2;
    L33:
        r8[1] = TuplesKt.to("params", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r9))));
        Ka0(MapsKt.mapOf(r8));
        goto L34
    L32:
        r9 = 0;
    L34:
        ECMallFeed r10 = this.f;
        if (r10 == null) goto L39;
        com.bytedance.android.shopping.mall.homepage.card.live.n r11 = r10.h0;
        if (r11 == null) goto L39;
        r11.a(r14);
    L39:
        ECMallFeed r12 = this.f;
        if (r12 == null) goto L42;
        r12.O(r14);
    L42:
        AnchorPendantManager r13 = this.N2;
        if (r13 == null) goto L60;
        IVerseService r15 = ECLynxCard.f;
        String r16 = ECLynxCard.a.a(false, false);
        int r17 = AnchorPendantManager.l;
        Intrinsics.checkNotNullParameter("page", "source");
        Intrinsics.checkNotNullParameter(r16, "pageSource");
        Set<AnchorPendant> r18 = r13.d;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L46:
        if (r20.hasNext() == false) goto L50;
        Object r21 = r20.next();
        if (((AnchorPendant) r21).a == false) goto L46;
        r19.add(r21);
        goto L46
    L50:
        Iterator r22 = r19.iterator();
    L52:
        if (r22.hasNext() == false) goto L60;
        com.bytedance.android.ec.hybrid.card.api.e r23 = ((AnchorPendant) r22.next()).r.b.b;
        if ((r23 instanceof ECLynxCard) == true) goto L56;
        r23 = null;
    L56:
        ECLynxCard r24 = (ECLynxCard) r23;
        if (r24 == null) goto L52;
        ECLynxCard.m(r24, r14, "page", r16, false, false, false, 0, 240);
    L60:
        if (this.L2 == false) goto L62;
        boolean r25 = this.o;
    L62:
        ck.a r26 = na0();
        if (r26 == null) goto L65;
        r26.g(r14);
    L65:
        ECMarketingHelper r27 = this.l;
        if (r27.b == false) goto L71;
        IMarketingServiceV2 r28 = ECMarketingHelper.a();
        if (r28 == null) goto L71;
        String r29 = r27.a;
        JsonObject r30 = new JsonObject();
        r30.addProperty("visible", Integer.valueOf(r14 ? 1 : 0));
        r30.addProperty("source", "page");
        Unit r31 = Unit.INSTANCE;
        IMarketingServiceV2.a.b(r28, "ecom.marketing.event.pageVisibilityChange", r30, null, null, r29, 25);
    L71:
        Ma0(new ECMallFragment$setMallInVisible$1(this, r14));
        return;
    L8:
        if (r1.getEnableCorrectShowReport() != true) goto L16;
        ECMallFeed r32 = this.f;
        if (r32 == null) goto L16;
        ECHybridListEngine r33 = r32.J;
        if (r33 == null) goto L14;
        r33.b.setCurrentListOnScreen(r14);
    L14:
        if (r14 == false) goto L16;
        r32.w0();
        goto L16
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Hn(String r2) {
        if (Intrinsics.areEqual(r2, "smallWindow") == false) goto L5;
        return;
    L5:
        Intrinsics.areEqual(r2, "rollback");
    }

    public final void Ka0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        ECMallFeed r0 = this.f;
        if (r0 == null) goto L7;
        ECMallFeed.ReportAbility r1 = r0.j0;
        if (r1 == null) goto L7;
        k93.g.a.a(r1, r4, null, null, 14);
    L8:
        ea0();
        return;
    L7:
        this.v2.add(r4);
        EnsureManager.ensureNotReachHere("ECMallFragment, invoke report method before ECMallFeed created");
        goto L8
    }

    public final void Ma0(Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.P1.post(new u(r3));
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final PageFinder N90(ECHybridRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "listView");
        Intrinsics.checkNotNullParameter(r2, "listView");
        return PageFinder.via(r2);
    }

    public final void Na0(Boolean r6) {
        Pair[] r0 = new Pair[3];
        ECMallFeed r2 = this.f;
        if (r2 == null) goto L5;
        int r3 = r2.M;
    L6:
        r0[0] = new Pair("pageNum", Integer.valueOf(r3));
        r0[1] = new Pair("maxPageNum", Integer.valueOf(((Number) this.C3.getValue()).intValue()));
        r0[2] = new Pair("isLoggedIn", Integer.valueOf(Intrinsics.areEqual(r6, Boolean.TRUE) ? 1 : 0));
        Map r7 = MapsKt.mapOf(r0);
        ECLynxCard r1 = this.k1;
        if (r1 == null) goto L10;
        r1.p("GlobalLoginPanelVisibility", r7);
        return;
    L10:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void Pa0(Integer r3) {
        Iterator<T> r4 = this.Z.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.help.g) r4.next()).k(true);
        goto L4
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final String T80(Map<String, ? extends Object> r17) {
        Intrinsics.checkNotNullParameter(r17, "params");
        String r4 = "";
        if (this.P2 != null) goto L6;
        return "";
    L6:
        if (isAdded() == true) goto L8;
        return "";
    L8:
        ECMarketingHelper r3 = this.l;
        FrameLayout r5 = this.Q2;
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r17, "params");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L59
        com.bytedance.android.marketing.sdk.api.c r7 = new com.bytedance.android.marketing.sdk.api.c(null, this, 1);     // Catch: Throwable -> L59
        Object r6 = r17.get("pageData");     // Catch: Throwable -> L59
        if (r6 != null) goto L12;
    L18:
        Object r8 = r17.get("bizParams");     // Catch: Throwable -> L59
        if (r8 != null) goto L21;
    L33:
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L59
        Object r0 = r17.get("timestamp");     // Catch: Throwable -> L59
        if (r0 != null) goto L36;
    L41:
        r7.m = System.currentTimeMillis();     // Catch: Throwable -> L59
        if (r5 == null) goto L44;
        Intrinsics.checkNotNullParameter(r5, "container");     // Catch: Throwable -> L59
        r7.b = r5;     // Catch: Throwable -> L59
    L44:
        IMarketingServiceV2 r10 = ECMarketingHelper.a();     // Catch: Throwable -> L59
        if (r10 == null) goto L50;
        boolean r11 = true;
        String r1 = IMarketingServiceV2.a.a(r10, r7, r9, null, null, null, null, null, 124);     // Catch: Throwable -> L59
        if (r1 == null) goto L51;
        r4 = r1;
    L51:
        r3.a = r4;     // Catch: Throwable -> L59
        if (r4.length() <= 0) goto L54;
        boolean r15 = true;
    L55:
        if (r15 == false) goto L57;
        r3.b = r11;     // Catch: Throwable -> L59
    L57:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L59
    L62:
        return r3.a;
    L54:
        r15 = false;
        goto L55
    L50:
        r11 = true;
        goto L51
    L36:
        if ((r0 instanceof Long) == false) goto L39;
        r9 = ((Number) r0).longValue();     // Catch: Throwable -> L59
        goto L41
    L39:
        if ((r0 instanceof Integer) == false) goto L41;
        r9 = ((Number) r0).intValue();     // Catch: Throwable -> L59
        goto L41
    L21:
        if ((r8 instanceof Map) == false) goto L33;
        Iterator r12 = ((Map) r8).entrySet().iterator();     // Catch: Throwable -> L59
    L24:
        if (r12.hasNext() == false) goto L33;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L59
        Object r14 = r13.getKey();     // Catch: Throwable -> L59
        if (r14 == null) goto L29;
        String r16 = r14.toString();     // Catch: Throwable -> L59
        if (r16 == null) goto L29;
    L30:
        Object r18 = r13.getValue();     // Catch: Throwable -> L59
        if (r18 == null) goto L24;
        r7.l.put(r16, r18);     // Catch: Throwable -> L59
    L29:
        r16 = "";
        goto L30
    L12:
        if ((r6 instanceof Map) == false) goto L18;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L59
        Iterator r20 = ((Map) r6).entrySet().iterator();     // Catch: Throwable -> L59
    L15:
        if (r20.hasNext() == false) goto L17;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L59
        r19.putOpt(String.valueOf(r21.getKey()), new JSONObject(String.valueOf(r21.getValue())));     // Catch: Throwable -> L59
        goto L15
    L17:
        r7.a = r19.toString();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Vw(com.bytedance.android.shopping.mall.feed.help.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.Z).add(r2);
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super.onConfigurationChanged(r4);
        int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r1 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r4.screenWidthDp));
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r4.screenHeightDp));
        if (this.Y3 != r1) goto L5;
        r1 = r1 + 1;
    L5:
        this.Y3 = r1;
        this.e.m(r4, r1, r2);
        ECLynxCard r5 = this.k1;
        if (r5 == null) goto L8;
        r5.c(r1, r2);
    L8:
        ECMallFeed r6 = this.f;
        if (r6 == null) goto L11;
        r6.P(r1);
    L11:
        Iterator r7 = this.S2.a.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        ((ik.b) r7.next()).c(r1, r2);
        goto L13
    }

    public final void onCreate(Bundle r19) {
        super.onCreate(r19);
        IECNativeContainerLoadState$MallState r0 = IECNativeContainerLoadState$MallState.INIT;
        if (ja0() == null) goto L10;
        Integer r1 = com.bytedance.android.shopping.mall.homepage.opt.e.e.a();
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L10;
        int r2 = com.bytedance.android.shopping.mall.homepage.opt.h.a;
    L10:
        com.bytedance.android.shopping.mall.homepage.component.c r3 = this.e;
        r3.getClass();
        r3.h(new ECMFPageCardComponent());
        ECMFTopBarComponent r5 = new ECMFTopBarComponent();
        r3.d = r5;
        r3.h(r5);
        r3.h(new ECMPinTopComponent());
        r3.h(new ECMBackTopComponent());
        r3.h(new com.bytedance.android.shopping.mall.homepage.component.e());
        this.I2 = false;
        this.H2 = false;
        kjc.c r4 = new kjc.c();
        if (5 != kjc.a.a()) goto L19;
        kjc.b r6 = r4.a;
        IHybridHostService r7 = com.bytedance.android.ec.hybrid.a.h();
        if (r7 == null) goto L17;
        yj.l r8 = r7.getIHybridHostFrescoService();
        if (r8 == null) goto L17;
        r8.initFirstScreenImageRecord();
    L17:
        r6.a = Unit.INSTANCE;
        r4.b = true;
    L19:
        if (r4.b == true) goto L21;
        r4.a.a = Unit.INSTANCE;
    L21:
        Object r9 = r4.a.a;
        Integer r10 = null;
        ECEventCenter.d().d(false, null);
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "ECMallFragment#onCreate()@" + hashCode());
        int r12 = lk.b.a;
        Context r13 = requireContext();
        String r14 = oa0();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "sceneID");
        this.e.onCreate(r19);
        Ea0();
        com.bytedance.android.shopping.api.mall.common.tools.h r15 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        boolean r16 = r15.getIHybridHostUserService().isLogin();
        this.k3 = r16;
        this.l3 = r16;
        r15.getIHybridHostUserService().c();
        this.m3 = null;
        final LinkedHashMap r17 = new LinkedHashMap();
        r17.put("gecko_env_online", Integer.valueOf(((Boolean) NativeMallGeckoHelper.a.getValue()).booleanValue() ? 1 : 0));
        DataEngineWrapper r18 = this.L0;
        if (r18 == null) goto L28;
        y93.a r20 = r18.b;
        if (r20 == null) goto L28;
        Long r21 = r20.q();
        if (r21 == null) goto L28;
        long r22 = r21.longValue();
    L29:
        r17.put("real_open_time", Long.valueOf(r22));
        r17.put("theme", this.d.a());
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L36
        r17.put("statusBarHeight", Integer.valueOf(UIUtils.px2dip(getContext(), UIUtils.getStatusBarHeight(getContext()))));     // Catch: Throwable -> L36
        Context r24 = getContext();     // Catch: Throwable -> L36
        IECNativeHomeArgument r25 = ma0();     // Catch: Throwable -> L36
        if (r25 == null) goto L33;
        int r26 = r25.getPanelTopOffset();     // Catch: Throwable -> L36
    L34:
        r17.put("topOffset", Integer.valueOf(UIUtils.px2dip(r24, r26)));     // Catch: Throwable -> L36
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L44;
        Lazy r29 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "put statusBarHeight and topOffset to globalProps failed");
        if (HybridAppInfoService.p.isLocalTest() == true) goto L43;
        EnsureManager.ensureNotReachHere(r28);
        goto L44
    L43:
        throw r28;
    L44:
        uj.c r30 = ECLynxBuildUtilKt.b();
        if (r30 != null) goto L47;
    L49:
        boolean r31 = false;
    L50:
        if (r31 == false) goto L52;
        r17.put("sharedLynxGroupID", oa0());
    L52:
        Lazy r32 = BigFontAdapter.a;
        if (BigFontAdapter.b(this.d.e()) == false) goto L55;
        r17.put("big_font_enabled", 1);
        BigFontAdapter.FontType.Companion.getClass();
        r17.put("font_size_pref", Integer.valueOf(BigFontAdapter.FontType.a.a()));
    L55:
        Ma0(new ECMallFragment$updateHostQueryMap$3(this, r17));
        ILegouMallService r33 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
        DataEngineWrapper r34 = this.L0;
        if (r34 == null) goto L62;
        y93.a r35 = r34.b;
        if (r35 == null) goto L62;
        Long r36 = r35.q();
        if (r36 == null) goto L62;
        r36.longValue();
    L63:
        r33.b();
        Lazy r37 = ECImageCustomDiskCacheHelper.a;
        ECImageCustomDiskCacheHelper.c(hashCode(), this.d.e(), this.d.c());
        this.r3 = System.currentTimeMillis();
        MallInitTaskManager r38 = (MallInitTaskManager) this.q3.getValue();
        jf3.c r39 = this.p0;
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "containerManager");
        Logger.d("MallInitTaskManager", "bindNALifeCycle");
        WeakReference<jf3.c> r40 = r38.b;
        if (r40 == null) goto L68;
        jf3.c r41 = r40.get();
        if (r41 == null) goto L68;
        r41.h(r38);
    L68:
        r38.b = new WeakReference(r39);
        r39.getClass();
        Intrinsics.checkNotNullParameter(r38, "lifeCycle");
        r39.a.add(r38);
        Lazy r42 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.m.a r43 = com.bytedance.android.ec.hybrid.log.mall.m.a.b;
        StringBuilder r44 = new StringBuilder("start create na mall, is recreate : ");
        if (r19 != null) goto L71;
        boolean r45 = true;
    L72:
        r44.append(r45);
        ECMallLogUtil.c(r43, r44.toString());
        Map r46 = com.bytedance.android.ec.hybrid.list.util.r.a;
        String r47 = oa0();
        MallLynxCardUtil r48 = new MallLynxCardUtil(this.d.e());
        Intrinsics.checkNotNullParameter(r47, "sceneId");
        Intrinsics.checkNotNullParameter(r48, "util");
        com.bytedance.android.ec.hybrid.list.util.r.a.put(r47, r48);
        this.E2 = false;
        this.F2 = false;
        this.G2 = false;
        this.Z3 = null;
        this.W = false;
        Map<String, DataEngineWrapper> r49 = DataEngineMap.a;
        IECNativeHomeArgument r50 = ma0();
        if (r50 == null) goto L76;
        String r51 = r50.getDataEngineTag();
        if (r51 == null) goto L76;
    L77:
        DataEngineWrapper r52 = DataEngineMap.a(r51);
        this.L0 = r52;
        if (r52 == null) goto L84;
        IECNativeHomeArgument r53 = ma0();
        if (r53 == null) goto L82;
        String r54 = r53.getBundleConfigUrl();
    L83:
        r52.f(r54, null);
        goto L84
    L82:
        r54 = null;
    L84:
        MallNetApplier r55 = new MallNetApplier(new com.bytedance.android.shopping.mall.homepage.e(this));
        this.m = r55;
        DataEngineWrapper r56 = this.L0;
        if (r56 == null) goto L95;
        ECHybridDataEngine r57 = r56.a;
        if (r57 == null) goto L95;
        Intrinsics.checkNotNullParameter(this, "target");
        Lazy r58 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L92;
    L94:
        Intrinsics.checkNotNullParameter(r55, "applier");
        r57.n = r55;
        r57.p.l(r55);
        Unit r59 = Unit.INSTANCE;
    L96:
        this.P0 = r57;
        ia0().w = this.P0;
        ia0().x = this.d.u;
        ECMallLogUtil.c(r43, "data engine init end");
        Lazy r60 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L99;
        boolean r61 = ECMallConfigs.INSTANCE.getLegouPrefetchFlowOptEnable();
    L111:
        DataEngineWrapper r62 = this.L0;
        if (r62 == null) goto L116;
        y93.a r63 = r62.b;
        if (r63 == null) goto L116;
        String r64 = r63.l();
    L117:
        IECNativeHomeArgument r65 = ma0();
        if (r65 == null) goto L120;
        Long r66 = r65.getNaOfflineVersion();
    L121:
        Z90(r64, r66);
        DataEngineWrapper r67 = this.L0;
        if (r67 == null) goto L124;
        r67.m(System.currentTimeMillis());
    L124:
        String r68 = NativeMallGeckoHelper.a();
        Ref.ObjectRef r69 = new Ref.ObjectRef();
        r69.element = NativeMallGeckoHelper.b();
        IECNativeHomeArgument r70 = ma0();
        if (r70 == null) goto L129;
        String r71 = r70.getGeckoChannel();
        if (r71 == null) goto L129;
        r69.element = r71;
    L129:
        GeckoClient r72 = com.bytedance.geckox.a.a(r68);
        if (r72 != null) goto L141;
        IECNativeHomeArgument r110 = ma0();
        if (r110 == null) goto L134;
        Boolean r111 = r110.getGeckoExist();
    L136:
        if ((!Intrinsics.areEqual(r111, Boolean.TRUE)) == false) goto L141;
        DataEngineWrapper r73 = this.L0;
        if (r73 == null) goto L140;
        r73.l(System.currentTimeMillis(), -1);
    L140:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "local not found gecko channel");
        ta0();
    L153:
        IECNativeHomeArgument r74 = ma0();
        if (r74 == null) goto L156;
        Map<String, String> r75 = r74.getLandingInfo();
    L157:
        if (r75 == null) goto L191;
        LinkedHashMap r76 = new LinkedHashMap();
        if (r76.isEmpty() == true) goto L191;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r77 = this.d.m();
        String r78 = "";
        if (r77 == null) goto L168;
        String r79 = b0.m(r76);
        if (r79 != null) goto L167;
        r79 = "";
    L167:
        boolean r112 = this.k3;
        Intrinsics.checkNotNullParameter(r79, "routerParamsJson");
        r77.a.d("ec.mallLifeEnterBySchema", MapsKt.mapOf(new Pair[]{TuplesKt.to("routerParams", r79), TuplesKt.to("isLogin", Integer.valueOf(r112 ? 1 : 0))}), true);
    L168:
        IECNativeHomeArgument r80 = ma0();
        if (r80 == null) goto L173;
        Map<String, String> r81 = r80.getLandingInfo();
        if (r81 == null) goto L173;
        String r82 = r81.get("schema");
    L174:
        Uri r84 = UriProtector.parse(r82);
        String r85 = UriProtector.getQueryParameter(r84, "block_mall_popups");
        if (r85 == null) goto L177;
        r10 = ECHybridExtensionsKt.i(r85);
    L177:
        if (r10 != null) goto L180;
    L186:
        com.bytedance.android.ec.hybrid.a.d().submit(new com.bytedance.android.shopping.mall.homepage.q(this, r76, r84));
        ECMFTopBarComponent r86 = this.e.d;
        if (r86 == null) goto L189;
        r86.r(true);
    L189:
        ia0().B.getClass();
        goto L191
    L180:
        if (r10.intValue() != 1) goto L186;
        String r87 = UriProtector.getQueryParameter(r84, "scene");
        if (r87 == null) goto L185;
        r78 = r87;
    L185:
        Intrinsics.checkNotNullParameter(r78, "scene");
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.event.blockMallPopupEvent", System.currentTimeMillis(), oa0(), false, MapsKt.mapOf(new Pair[]{TuplesKt.to("status", 1), TuplesKt.to("scene", r78)}), true));
    L173:
        r82 = null;
    L191:
        if (this.o3 == true) goto L193;
    L194:
        za0();
    L195:
        this.d.j.observe(this, new com.bytedance.android.shopping.mall.homepage.o(this));
        if (HybridAppInfoService.l() == false) goto L200;
        com.bytedance.android.shopping.mall.f r88 = this.s;
        o r89 = this.t;
        r88.getClass();
        Intrinsics.checkNotNullParameter(r89, "callback");
    L200:
        if (Intrinsics.areEqual(this.d.e(), MallPageName.X_TAB_MALL) == false) goto L205;
        ECLynxBuildUtilKt.c = oa0();
        return;
    L205:
        return;
    L193:
        if (this.k3 == false) goto L195;
    L156:
        r75 = null;
        goto L157
    L134:
        r111 = null;
    L141:
        this.Q1.postDelayed(new com.bytedance.android.shopping.mall.homepage.f(this), 15000);
        if (r72 != null) goto L150;
        DataEngineWrapper r90 = this.L0;
        if (r90 == null) goto L146;
        r90.l(System.currentTimeMillis(), 1);
    L146:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko have cache, register not complete");
        if (r61 == false) goto L149;
        Ma0(new ECMallFragment$initGeckoData$3(this));
        goto L153
    L149:
        this.Q1.post(new com.bytedance.android.shopping.mall.homepage.g(this));
        goto L153
    L150:
        if (r61 == false) goto L152;
        Ma0(new ECMallFragment$initGeckoData$5(this));
    L152:
        r72.checkUpdateMulti("default", MapsKt.mapOf(TuplesKt.to(r68, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel((String) r69.element)))), new OptionCheckUpdateParams().setChannelUpdatePriority(3).setRequestWhenHasLocalVersion(false).setListener(new com.bytedance.android.shopping.mall.homepage.h(this, r68, (String) r69.element)));
        goto L153
    L120:
        r66 = null;
    L116:
        r64 = null;
        goto L117
    L99:
        int r91 = s93.c.a;
        Object r92 = 0;
        IHybridHostService r94 = com.bytedance.android.ec.hybrid.a.h();
        if (r94 == null) goto L107;
        yj.g r95 = r94.getHostAB();
        if (r95 == null) goto L107;
        Object r96 = r95.a("ec_mall_init_gecko_opt", r92);
        if (r96 == null) goto L107;
        r92 = r96;
    L107:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_init_gecko_opt, Value: " + r92);
        if (((Number) r92).intValue() != 1) goto L110;
        r61 = true;
        goto L111
    L110:
        r61 = false;
        goto L111
    L92:
        if (r57.h.contains(this) == true) goto L94;
        r57.h.add(this);
        int r97 = r57.i.incrementAndGet();
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.o.b.b, "DataEngine#bind(), target = " + hashCode() + "}, times = " + r97);
    L95:
        r57 = null;
    L76:
        r51 = "default";
        goto L77
    L71:
        r45 = false;
    L62:
        System.currentTimeMillis();
        goto L63
    L47:
        if (r30.a() != true) goto L49;
        r31 = true;
        goto L50
    L33:
        r26 = 0;
    L36:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r22 = System.currentTimeMillis();
        goto L29
    }

    public final void ra0(boolean r4) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.d.b, "handleDouyinSkinForLynx" + Log.getStackTraceString(new Throwable()) + ' ');
        if (r4 == false) goto L7;
        ECMFTopBarComponent r5 = this.e.d;
        if (r5 == null) goto L7;
        r5.w(this.d.q.b);
    L7:
        ECHybridListEngine r6 = this.H0;
        if (r6 == null) goto L10;
        com.bytedance.android.ec.hybrid.list.entity.k r7 = r6.c.g;
    L11:
        sa0(r7, new ECMallFragment$handleDouyinSkinForLynx$1(this));
        return;
    L10:
        r7 = null;
        goto L11
    }

    public final void ua0(String r8) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "start handle popup schema is " + r8);
        View r1 = getView();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        r8 = this.g1;
    L7:
        if (r8 != null) goto L9;
        return;
    L9:
        ViewGroup r2 = (ViewGroup) r1.findViewById(2131382099);
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "start init pendant view");
        if (this.M1 <= 0) goto L13;
    L29:
        this.g1 = null;
        return;
    L13:
        if (this.p1 != null) goto L20;
        this.p1 = new ECLynxCard();
        View r3 = getView();
        if (r3 == null) goto L20;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131382099);
        if (r4 == null) goto L20;
        r4.setVisibility(8);
    L20:
        if (this.v1 == false) goto L29;
        if (this.x1 == false) goto L25;
        String r5 = "1";
    L26:
        String r6 = UriProtector.parse(r8).buildUpon().appendQueryParameter("allow_popup", r5).build().toString();
        Map r7 = MapsKt.toMutableMap(MapsKt.emptyMap());
        r7.put("allow_popup", r5);
        jq(MapsKt.mapOf(TuplesKt.to("allow_popup", r5)), null);
        ECLynxLoadParam.a r9 = new ECLynxLoadParam.a(r2.getContext(), getLifecycle(), r2, ECMallGeckoResourceHelper.a(r6));
        r9.a(Ba0(r8));
        r9.g(this.d.e());
        Intrinsics.checkNotNullParameter(r7, "ecGlobalProps");
        r9.p = r7;
        r9.q = this.d.d();
        com.bytedance.android.shopping.mall.homepage.m r10 = new com.bytedance.android.shopping.mall.homepage.m(this.p1, this, r2);
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        r9.o = r10;
        r9.j(10000);
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r11, "ecLayoutParams");
        r9.u = r11;
        r9.t = b0.f();
        r9.b(this.d.l());
        r9.i(ka0(this));
        r9.h(oa0());
        ECLynxBuildUtilKt.a(r9, new uj.a(this.d.e(), oa0()));
        ECLynxCard r12 = this.p1;
        if (r12 == null) goto L29;
        r12.j(new ECLynxLoadParam(r9));
        goto L29
    L25:
        r5 = "0";
        goto L26
    }

    public final void va0(Pair<String, String> r27) {
        Lazy r1 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.a r2 = com.bytedance.android.ec.hybrid.log.mall.e.a.b;
        StringBuilder r3 = new StringBuilder("start handle popup schema is ");
        if (r27 == null) goto L5;
        String r4 = (String) r27.getFirst();
    L6:
        r3.append(r4);
        ECMallLogUtil.c(r2, r3.toString());
        if (r27 != null) goto L9;
        Pair<String, String> r5 = this.b1;
    L10:
        if (r5 != null) goto L12;
        return;
    L12:
        ViewGroup r6 = this.d.h();
        if (r6 != null) goto L15;
        return;
    L15:
        String r7 = (String) r5.getFirst();
        String r8 = (String) r5.getSecond();
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "start init popup, schema is " + r7);
        ECLynxCard r9 = this.k1;
        if (r9 != null) goto L20;
        this.y1 = y93.d.a(this.y1, r7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388606);
        this.k1 = new ECLynxCard();
        r6.setVisibility(8);
        ECLynxLoadParam.a r10 = new ECLynxLoadParam.a(r6.getContext(), getLifecycle(), r6, ECMallGeckoResourceHelper.a(r7));
        r10.j = r8;
        r10.g(this.d.e());
        r10.j(10000);
        r10.e(MapsKt.emptyMap());
        r10.a(Ba0(r7));
        r10.q = this.d.d();
        r10.i(ka0(this));
        r10.t = b0.f();
        r10.b(this.d.l());
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r11, "ecLayoutParams");
        r10.u = r11;
        com.bytedance.android.shopping.mall.homepage.n r12 = new com.bytedance.android.shopping.mall.homepage.n(this, r6, this.k1);
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        r10.o = r12;
        r10.D = this.S2;
        Lazy r13 = MallUtil.a;
        ECLynxCard r14 = this.k1;
        Intrinsics.checkNotNull(r14);
        Map r15 = MallUtil.a(r14, null);
        Intrinsics.checkNotNullParameter(r15, "ecBridgeMap");
        r10.r = r15;
        r10.h(oa0());
        ECLynxBuildUtilKt.a(r10, new uj.a(this.d.e(), oa0()));
        ECLynxCard r16 = this.k1;
        if (r16 == null) goto L21;
        r16.j(new ECLynxLoadParam(r10));
    L21:
        this.b1 = null;
        return;
    L20:
        int r17 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r9.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r8, new LinkedHashMap()), true);
        goto L21
    L9:
        r5 = r27;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final String AH(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "id");
        HomepageChunkedCallback r1 = this.Y2;
        if (r1 == null) goto L60;
        Intrinsics.checkNotNullParameter(r6, "id");
        if (r7 == true) goto L7;
        Map<String, String> r8 = r1.m;
        if (r8 == null) goto L62;
        String r9 = (String) ((LinkedHashMap) r8).get(r6);
    L49:
        return r9;
    L62:
        return null;
    L7:
        if (r1.l != null) goto L42;
        HomePageDTO r10 = (HomePageDTO) r1.n.a.invoke();
        if (r10 == null) goto L40;
        List<ChunkedSectionData> r11 = r10.getChunkDataList();
        if (r11 == null) goto L40;
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        Object r0 = r12.next();
        if (Intrinsics.areEqual(((ChunkedSectionData) r0).getChunkSectionId(), "multi_in_one_section") == false) goto L14;
    L19:
        ChunkedSectionData r2 = (ChunkedSectionData) r0;
        if (r2 == null) goto L40;
        List<ChunkedTrackAndRec> r13 = r2.getChunkInfo();
        if (r13 == null) goto L40;
        ArrayList r3 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L25:
        if (r14.hasNext() == false) goto L32;
        Object r4 = r14.next();
        if (((ChunkedTrackAndRec) r4).getId() == null) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L25;
        r3.add(r4);
        goto L25
    L29:
        r5 = false;
        goto L30
    L32:
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator r16 = r3.iterator();
    L34:
        if (r16.hasNext() == false) goto L36;
        Object r17 = r16.next();
        String r18 = ((ChunkedTrackAndRec) r17).getId();
        Intrinsics.checkNotNull(r18);
        r15.put(r18, r17);
        goto L34
    L36:
        LinkedHashMap r19 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));
        Iterator r20 = r15.entrySet().iterator();
    L38:
        if (r20.hasNext() == false) goto L41;
        Map.Entry r21 = (Map.Entry) r20.next();
        r19.put(r21.getKey(), ((ChunkedTrackAndRec) r21.getValue()).getRecommendInfo());
    L41:
        r1.l = r19;
        goto L42
    L18:
        r0 = null;
    L40:
        r19 = null;
    L42:
        Map<String, String> r22 = r1.l;
        if (r22 == null) goto L61;
        r9 = r22.get(r6);
        goto L49
    L61:
        return null;
    L60:
        return null;
    }

    public final void La0(int r92, final com.bytedance.android.ec.hybrid.list.util.d r94) {
        if (this.l3 == false) goto L5;
    L7:
        FragmentActivity r0 = getActivity();
        Long r4 = null;
        if (r0 == null) goto L32;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L32;
        Bundle r2 = r1.getExtras();
        if (r2 == null) goto L32;
        String r3 = r2.getString("schema", "");
        if (r3 == null) goto L32;
        if (r3.length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L32;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L30
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r3), "delivery_session_id");     // Catch: Throwable -> L30
        if (r5 == null) goto L27;
        IECNativeHomeService r9 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);     // Catch: Throwable -> L30
        if (r9 == null) goto L27;
        y93.b r10 = r9.a();     // Catch: Throwable -> L30
        if (r10 == null) goto L27;
        r10.d(r5, "force_refresh_end_time", null, null);     // Catch: Throwable -> L30
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.constructor-impl(r6);     // Catch: Throwable -> L30
    L27:
        r6 = null;
    L30:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L18:
        r7 = false;
    L32:
        DataEngineWrapper r12 = this.L0;
        if (r12 == null) goto L39;
        y93.a r13 = r12.b;
        if (r13 == null) goto L39;
        if (r13.c != true) goto L39;
        return;
    L39:
        IECNativeHomeArgument r14 = ma0();
        if (r14 == null) goto L50;
        Map<String, String> r15 = r14.getLandingInfo();
        if (r15 == null) goto L50;
        String r16 = r15.get("schema");
        if (r16 == null) goto L50;
        if (((cf3.a) this.Y.getValue()).a(r16) == false) goto L50;
        DataEngineWrapper r17 = this.L0;
        if (r17 == null) goto L50;
        r17.n();
    L50:
        DataEngineWrapper r18 = this.L0;
        if (r18 == null) goto L53;
        r18.v(r92);
        Unit r19 = Unit.INSTANCE;
    L53:
        DataEngineWrapper r20 = this.L0;
        if (r20 == null) goto L61;
        IECMallHostService r21 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r21 == null) goto L60;
        y93.a r22 = r21.updateFirstScreenAnalyseBeanWithHost(r20.b);
        if (r22 == null) goto L60;
        r20.b = r22;
    L60:
        Unit r23 = Unit.INSTANCE;
    L61:
        final JSONObject r24 = new JSONObject();
        kk.d.c(new ECMallFragment$reportFirstScreen$$inlined$apply$lambda$1(r24, this, r94));
        r24.put("type", "PERFORMANCE_LOG");
        r24.put("res_version", this.d.e);
        r24.put("no_cache_reason", this.g);
        int r25 = f93.a.a;
        f93.a.c(r24, fa0("c0.d0", false, null));
        r24.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r24.put("log_id", ia0().v);
        DataEngineWrapper r26 = this.L0;
        if (r26 == null) goto L66;
        y93.a r27 = r26.b;
        if (r27 == null) goto L66;
        String r28 = r27.c();
    L67:
        r24.put("error_msg", r28);
        DataEngineWrapper r29 = this.L0;
        if (r29 == null) goto L72;
        y93.a r30 = r29.b;
        if (r30 == null) goto L72;
        Integer r31 = r30.y();
    L73:
        r24.put("status", r31);
        IECNativeHomeArgument r32 = ma0();
        if (r32 == null) goto L76;
        int r33 = r32.getRenderThreadStrategy();
    L77:
        r24.put("render_thread_strategy", r33);
        IECNativeHomeArgument r34 = ma0();
        if (r34 == null) goto L80;
        Boolean r35 = r34.getBundlePreloaded();
    L82:
        if (Intrinsics.areEqual(r35, Boolean.TRUE) == false) goto L84;
        int r36 = 1;
    L85:
        r24.put("load_bundle_type", r36);
        DataEngineWrapper r37 = this.L0;
        if (r37 == null) goto L96;
        y93.a r38 = r37.b;
        if (r38 == null) goto L96;
        Map<String, Object> r39 = r38.a;
        if (r39 == null) goto L96;
        Iterator<T> r40 = r39.keySet().iterator();
    L93:
        if (r40.hasNext() == false) goto L95;
        String r41 = (String) r40.next();
        r24.putOpt(r41, r39.get(r41));
        goto L93
    L95:
        Unit r42 = Unit.INSTANCE;
    L96:
        DataEngineWrapper r43 = this.L0;
        if (r43 == null) goto L101;
        y93.a r44 = r43.b;
        if (r44 == null) goto L101;
        Long r45 = r44.q();
    L102:
        DataEngineWrapper r46 = this.L0;
        if (r46 == null) goto L107;
        y93.a r47 = r46.b;
        if (r47 == null) goto L107;
        Long r48 = r47.j();
    L108:
        if (r48 == null) goto L110;
        r48.longValue();
    L110:
        if (r45 == null) goto L112;
        r45.longValue();
    L112:
        long r49 = 0;
        if (r31 != null) goto L116;
    L124:
        DataEngineWrapper r50 = this.L0;
        if (r50 == null) goto L127;
        y93.a r51 = r50.b;
    L128:
        if (r51 == null) goto L255;
        Long r52 = r51.v();
        if (r52 == null) goto L132;
        long r110 = r52.longValue();
    L133:
        Long r53 = r51.u();
        if (r53 == null) goto L136;
        long r111 = r53.longValue();
    L137:
        Long r54 = Long.valueOf(r111 - r110);
        if (r54.longValue() <= 0) goto L140;
        boolean r112 = true;
    L141:
        if (r112 == true) goto L144;
        r54 = null;
    L144:
        if (r54 == null) goto L146;
        r24.put("preload_duration", r54.longValue());
    L146:
        Long r55 = r51.E();
        if (r55 == null) goto L149;
        long r113 = r55.longValue();
    L150:
        Long r56 = r51.D();
        if (r56 == null) goto L153;
        long r114 = r56.longValue();
    L154:
        Long r57 = Long.valueOf(r114 - r113);
        if (r57.longValue() <= 0) goto L157;
        boolean r115 = true;
    L158:
        if (r115 == true) goto L161;
        r57 = null;
    L161:
        if (r57 == null) goto L163;
        r24.put("prepare_cached_data_duration", r57.longValue());
    L163:
        Long r58 = r51.C();
        if (r58 == null) goto L166;
        long r116 = r58.longValue();
    L167:
        Long r59 = r51.B();
        if (r59 == null) goto L170;
        long r117 = r59.longValue();
    L171:
        Long r60 = Long.valueOf(r117 - r116);
        if (r60.longValue() <= 0) goto L174;
        boolean r118 = true;
    L175:
        if (r118 == true) goto L178;
        r60 = null;
    L178:
        if (r60 == null) goto L180;
        r24.put("straight_out_duration", r60.longValue());
    L180:
        Long r61 = r51.p();
        if (r61 == null) goto L183;
        long r119 = r61.longValue();
    L184:
        Long r62 = r51.o();
        if (r62 == null) goto L187;
        long r120 = r62.longValue();
    L188:
        Long r63 = r51.n();
        if (r63 == null) goto L191;
        long r121 = r63.longValue();
    L192:
        Long r64 = Long.valueOf(r120 - r119);
        if (r64.longValue() <= 0) goto L195;
        boolean r122 = true;
    L196:
        if (r122 == false) goto L198;
        r4 = r64;
    L198:
        if (r4 == null) goto L200;
        r24.put("network_io_duration", r4.longValue());
    L200:
        Long r65 = Long.valueOf(r121 - r120);
        r65.longValue();
        if (r121 > 0) goto L203;
    L205:
        boolean r66 = false;
    L206:
        if (r66 == true) goto L209;
        r65 = null;
    L209:
        if (r65 == null) goto L211;
        r24.put("network_dispatch_duration", r65.longValue());
    L211:
        Long r67 = Long.valueOf(r121 - r119);
        if (r67.longValue() <= 0) goto L214;
        boolean r68 = true;
    L215:
        if (r68 == true) goto L218;
        r67 = null;
    L218:
        if (r67 == null) goto L220;
        r24.put("network_duration", r67.longValue());
    L220:
        Long r69 = r51.G();
        if (r69 == null) goto L223;
        long r70 = r69.longValue();
    L224:
        Long r71 = r51.F();
        if (r71 == null) goto L227;
        long r123 = r71.longValue();
    L228:
        Long r72 = Long.valueOf(r123 - r70);
        if (r72.longValue() <= 0) goto L231;
        boolean r73 = true;
    L232:
        if (r73 == true) goto L235;
        r72 = null;
    L235:
        if (r72 == null) goto L237;
        r24.put("prepare_first_screen_data_duration", r72.longValue());
    L237:
        Long r74 = r51.k();
        if (r74 == null) goto L240;
        long r75 = r74.longValue();
    L241:
        Long r76 = r51.j();
        if (r76 == null) goto L244;
        long r124 = r76.longValue();
    L245:
        Long r77 = Long.valueOf(r124 - r75);
        if (r77.longValue() <= 0) goto L248;
        boolean r78 = true;
    L249:
        if (r78 == true) goto L252;
        r77 = null;
    L252:
        if (r77 == null) goto L254;
        r24.put("render_first_screen_duration", r77.longValue());
    L254:
        r24.put("straight_out_header_card_type", r51.z());
        r24.put("first_screen_header_card_type", r51.d());
        goto L255
    L248:
        r78 = false;
        goto L249
    L244:
        r124 = 0;
        goto L245
    L240:
        r75 = 0;
        goto L241
    L231:
        r73 = false;
        goto L232
    L227:
        r123 = 0;
        goto L228
    L223:
        r70 = 0;
        goto L224
    L214:
        r68 = false;
        goto L215
    L203:
        if (r120 <= 0) goto L205;
        r66 = true;
        goto L206
    L195:
        r122 = false;
        goto L196
    L191:
        r121 = 0;
        goto L192
    L187:
        r120 = 0;
        goto L188
    L183:
        r119 = 0;
        goto L184
    L174:
        r118 = false;
        goto L175
    L170:
        r117 = 0;
        goto L171
    L166:
        r116 = 0;
        goto L167
    L157:
        r115 = false;
        goto L158
    L153:
        r114 = 0;
        goto L154
    L149:
        r113 = 0;
        goto L150
    L140:
        r112 = false;
        goto L141
    L136:
        r111 = 0;
        goto L137
    L132:
        r110 = 0;
    L255:
        DataEngineWrapper r79 = this.L0;
        if (r79 == null) goto L262;
        y93.a r80 = r79.b;
        if (r80 == null) goto L262;
        Integer r81 = r80.g();
        if (r81 == null) goto L262;
        int r82 = r81.intValue();
        r24.putOpt("gyl_num_of_first_screen", Integer.valueOf(r82));
        r24.putOpt("gyl_num_of_homepage_response", Integer.valueOf(r82));
    L262:
        Boolean r84 = this.p;
        int r85 = -1;
        if (Intrinsics.areEqual(r84, Boolean.TRUE) == false) goto L266;
        int r86 = 1;
    L270:
        r24.putOpt("preload_lynx_view_task_status", Integer.valueOf(r86));
        DataEngineWrapper r87 = this.L0;
        if (r87 == null) goto L275;
        y93.a r88 = r87.b;
        if (r88 == null) goto L275;
        y93.a r89 = y93.a.a(r88, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 1610612735, -1, -129, -1, 111);
    L276:
        if (r89 == null) goto L278;
        JSONObject r90 = com.bytedance.android.ec.hybrid.list.util.k.b(r89);
        com.bytedance.android.ec.hybrid.list.util.k.a(r90, com.bytedance.android.ec.hybrid.list.util.k.d(this.G1));
        com.bytedance.android.ec.hybrid.list.util.k.a(r90, com.bytedance.android.ec.hybrid.list.util.k.d(this.H1));
    L279:
        if (r94 == null) goto L298;
        ECMFTopBarComponent r91 = this.e.d;
        if (r91 == null) goto L287;
        com.bytedance.android.ec.hybrid.list.util.d.a.a r95 = r91.n;
        Intrinsics.checkNotNullParameter(r95, "record");
        com.bytedance.android.ec.hybrid.list.util.d.a(r94.g, r95);
        if (r90 == null) goto L285;
        r90.put("t_top_bar_load", r91.m);
    L285:
        if (r90 == null) goto L287;
        r90.put("t_top_bar_create_view", r91.l);
    L287:
        if (r90 == null) goto L289;
        r90.put("count_total", r94.a);
    L289:
        if (r90 == null) goto L291;
        r90.put("count_succ", r94.b);
    L291:
        if (r90 == null) goto L293;
        r90.put("count_fail", r94.c);
    L293:
        if (r90 == null) goto L295;
        r90.put("t_all_lynx_card_load", r94.d);
    L295:
        if (r90 == null) goto L297;
        r90.put("t_all_lynx_card_create_view", r94.e);
    L297:
        com.bytedance.android.ec.hybrid.list.util.d.a.a r96 = r94.f;
        r24.putOpt("header_use_cache", Integer.valueOf(((((r96.c * 1) + 0) + (r96.d * 10)) + (r96.a * 100)) + (r96.b * 1000)));
        r24.putOpt("decode_use_cache", Integer.valueOf(r94.g.d));
        r24.putOpt("kit_view_use_cache", Integer.valueOf(r94.g.a));
        r24.putOpt("render_use_cache", Integer.valueOf(r94.g.b));
        r24.putOpt("gecko_ues_cache", Integer.valueOf(r94.g.c));
        r24.putOpt("straight_out_trans_data_time", Long.valueOf(this.d3));
        r24.putOpt("straight_out_native_alter_time", Long.valueOf(this.e3));
        r24.putOpt("data_from_net_trans_time", Long.valueOf(this.f3));
    L298:
        af3.e r97 = this.d.r;
        if (r97 == null) goto L313;
        r24.putOpt("native_open_dialog_result_code", Integer.valueOf(r97.d.a));
        r24.putOpt("native_open_dialog_result_message", r97.d.b);
        long r125 = r97.b.a;
        if (r125 <= 0) goto L304;
        if (r90 == null) goto L304;
        r90.putOpt("t_handle_dialog_start", Long.valueOf(r125));
    L304:
        r97.b.getClass();
        if (0 <= 0) goto L308;
        if (r90 == null) goto L308;
        r90.putOpt("t_before_load_dialog", 0L);
    L308:
        r97.b.getClass();
        if (0 <= 0) goto L312;
        if (r90 == null) goto L312;
        r90.putOpt("t_load_dialog_success", 0L);
    L312:
        Unit r98 = Unit.INSTANCE;
    L313:
        IECMallHostService r99 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r99 == null) goto L336;
        Map<String, Object> r100 = r99.getAppBootMetrics();
        if (r100 == null) goto L336;
        Iterator<T> r101 = r100.keySet().iterator();
    L319:
        if (r101.hasNext() == false) goto L321;
        String r102 = (String) r101.next();
        r24.putOpt(r102, r100.get(r102));
        goto L319
    L321:
        Object r103 = r100.get("t_app_attach_base_context_begin");
        if ((r103 instanceof Long) == true) goto L324;
        r103 = null;
    L324:
        Long r104 = (Long) r103;
        if (r104 == null) goto L335;
        if (r48 == null) goto L328;
        r49 = r48.longValue();
    L328:
        r24.putOpt("landing_first_screen_duration", Long.valueOf(r49 - r104.longValue()));
        DataEngineWrapper r105 = this.L0;
        if (r105 == null) goto L335;
        y93.a r106 = r105.b;
        if (r106 == null) goto L335;
        Long r107 = r106.B();
        if (r107 == null) goto L335;
        r24.putOpt("landing_straight_out_duration", Long.valueOf(r107.longValue() - r104.longValue()));
    L335:
        Unit r108 = Unit.INSTANCE;
    L336:
        r24.put("detail", r90);
        Integer r109 = null;
        if (Intrinsics.areEqual(null, 1) == false) goto L340;
        String r126 = "half_page_lazy";
    L343:
        r24.put("mall_load_type", r126);
        DataEngineWrapper r127 = this.L0;
        if (r127 == null) goto L348;
        ECHybridDataEngine r128 = r127.a;
        if (r128 == null) goto L348;
        Boolean r129 = Boolean.valueOf(r128.a);
    L349:
        r24.putOpt("is_config_load_from_keva", r129);
        ECMallFeed r130 = this.f;
        if (r130 == null) goto L354;
        Integer r131 = r130.R;
        if (r131 == null) goto L354;
        r85 = r131.intValue();
    L354:
        r24.putOpt("tab_id", Integer.valueOf(r85));
        Logger.d("peive", "reportFirstScreen " + r24);
        com.bytedance.android.shopping.api.mall.common.tools.l r132 = com.bytedance.android.shopping.api.mall.common.tools.l.a;
        IECNativeHomeArgument r133 = ma0();
        if (r133 == null) goto L357;
        r109 = r133.getReportSlardar();
    L357:
        com.bytedance.android.shopping.api.mall.common.tools.l.b(r132, r24, r109, true, 8);
        return;
    L348:
        r129 = null;
        goto L349
    L340:
        if (Intrinsics.areEqual(null, 1) == false) goto L342;
        r126 = "full_screen_lazy";
        goto L343
    L342:
        r126 = "normal";
        goto L343
    L278:
        r90 = null;
    L275:
        r89 = null;
        goto L276
    L266:
        if (Intrinsics.areEqual(r84, Boolean.FALSE) == false) goto L268;
        r86 = 0;
        goto L270
    L268:
        if (r84 != null) goto L360;
        r86 = -1;
        goto L270
    L360:
        throw new NoWhenBranchMatchedException();
    L127:
        r51 = null;
        goto L128
    L116:
        if (r31.intValue() != 1) goto L124;
        if (r48 == null) goto L119;
        long r134 = r48.longValue();
    L120:
        if (r45 == null) goto L122;
        long r135 = r45.longValue();
    L123:
        r24.put("first_screen_duration", r134 - r135);
        goto L124
    L122:
        r135 = 0;
        goto L123
    L119:
        r134 = 0;
    L107:
        r48 = null;
    L101:
        r45 = null;
        goto L102
    L84:
        r36 = 2;
        goto L85
    L80:
        r35 = null;
        goto L82
    L76:
        r33 = 0;
    L72:
        r31 = null;
    L66:
        r28 = null;
        goto L67
    L5:
        if (this.o3 == false) goto L7;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> PN(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void Q30(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = this.d.u.a();
        if (r1 == null) goto L10;
        PageCard r2 = r1.a;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "eventName");
        ECLynxCard r0 = r2.a;
        if (r0 == null) goto L12;
        r0.p(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void W90(String r2, HomePageDTO r3) {
        Single.fromCallable(new c(this, r3, r2)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, String> Xj(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        return null;
    }

    public final void Y90(HomePageDTO r6, boolean r7) {
        if (r6 == null) goto L32;
        HomePageBffDTO r8 = r6.getBff();
        if (r8 == null) goto L32;
        ECHybridListDTO r9 = r8.getFeed();
        if (r9 == null) goto L32;
        List r10 = r9.getSections();
        if (r10 == null) goto L32;
        Iterator r11 = r10.iterator();
    L11:
        Object r2 = null;
        if (r11.hasNext() == false) goto L16;
        Object r1 = r11.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r1).getSectionId(), "multi_in_one_section") == false) goto L11;
    L17:
        ECHybridListSectionDTO r3 = (ECHybridListSectionDTO) r1;
        if (r3 == null) goto L32;
        ArrayList r12 = r3.getItems();
        if (r12 == null) goto L32;
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L27;
        Object r4 = r13.next();
        if (Intrinsics.areEqual(((ECHybridListItemDTO) r4).getItemId(), "multi_in_one_item") == false) goto L23;
        r2 = r4;
    L27:
        ECHybridListItemDTO r5 = (ECHybridListItemDTO) r2;
        if (r5 == null) goto L32;
        Integer r14 = r5.getItemType();
        if (r14 == null) goto L32;
        int r15 = r14.intValue();
    L33:
        if (r15 > 0) goto L35;
        return;
    L35:
        if (r7 == false) goto L37;
        this.C = r15;
    L38:
        mf3.a r16 = DE();
        if (r16 == null) goto L52;
        PageCard r17 = ((com.bytedance.android.shopping.mall.homepage.pagecard.c) r16).a;
        if (r17 == null) goto L53;
        Map r18 = MapsKt.mapOf(new Pair[]{TuplesKt.to("header_card_type", Integer.valueOf(r15)), TuplesKt.to("isCacheData", Boolean.valueOf(r7))});
        Intrinsics.checkNotNullParameter("updateHeaderCardType", "eventName");
        ECLynxCard r19 = r17.a;
        if (r19 == null) goto L54;
        r19.p("updateHeaderCardType", r18);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L37:
        this.D = r15;
        goto L38
    L16:
        r1 = null;
    L32:
        r15 = 0;
        goto L33
    }

    public final void Z90(String r6, Long r7) {
        Logger.d("Javis", "checkResourceInfo  " + r7);
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L9;
        if (r7 != null) goto L6;
    L16:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L20;
        this.U2 = false;
        return;
    L20:
        if (((Boolean) this.a3.getValue()).booleanValue() == true) goto L22;
    L33:
        this.U2 = false;
        return;
    L22:
        if (this.d.l == true) goto L33;
        ECHybridListEngine r9 = this.H0;
        if (r9 == null) goto L26;
        com.bytedance.android.ec.hybrid.list.entity.k r10 = r9.c.g;
    L27:
        if (r10 != null) goto L33;
        if (this.k3 == false) goto L31;
    L32:
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "going to keep loading view until load finished");
        this.U2 = true;
        Pa0(null);
        return;
    L31:
        if (this.o3 == true) goto L33;
    L26:
        r10 = null;
        goto L27
    L6:
        if (r7.longValue() <= 0) goto L16;
    L17:
        r8 = false;
        goto L18
    L9:
        if (ECMallConfigs.INSTANCE.getLegouBuiltinResourceEnable() == false) goto L17;
        if (r6 != null) goto L12;
    L13:
        if (r6 == null) goto L17;
        if (StringsKt.contains(r6, "builtin", true) != true) goto L17;
    L12:
        if (StringsKt.contains(r6, "cdn", true) == true) goto L16;
        goto L13
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final Map<String, Object> bI(Map<String, ? extends Object> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        int r1 = f93.a.a;
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(this, "page");
        return f93.a.b(r3, PageFinder.via(this), r4);
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final void jq(final Map<String, ? extends Object> r2, final Set<String> r3) {
        Ma0(new ECMallFragment$updateGlobalProps$1(this, r2, r3));
    }

    public final void onViewCreated(View r50, Bundle r51) {
        Intrinsics.checkNotNullParameter(r50, FreqActions.ACTION_VIEW);
        super.onViewCreated(r50, r51);
        Context r0 = getContext();
        yj.g r1 = com.bytedance.android.ec.hybrid.a.b();
        if (r1 == null) goto L5;
        r1.j();
    L5:
        this.P2 = (FrameLayout) r50.findViewById(2131379494);
        this.Q2 = (FrameLayout) r50.findViewById(2131370787);
        if (Intrinsics.areEqual(this.d.e(), MallPageName.X_TAB_MALL) == false) goto L41;
        if (r0 == null) goto L41;
        int r2 = s93.c.a;
        Object r3 = 0;
        IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
        if (r4 == null) goto L16;
        yj.g r5 = r4.getHostAB();
        if (r5 == null) goto L16;
        Object r6 = r5.a("mall_launch_slip_enable", r3);
        if (r6 == null) goto L16;
        r3 = r6;
    L16:
        Lazy r7 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r8 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r8, "Key : mall_launch_slip_enable, Value: " + r3);
        if (((Number) r3).intValue() != 1) goto L41;
        long r9 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r0, "context");
        long r10 = r9 - r0.getApplicationContext().getSharedPreferences("mall_control_slip_sp", 0).getLong("control_slip_time", 0);
        Object r11 = 0;
        IHybridHostService r12 = com.bytedance.android.ec.hybrid.a.h();
        if (r12 == null) goto L26;
        yj.g r13 = r12.getHostAB();
        if (r13 == null) goto L26;
        Object r14 = r13.a("mall_launch_slip_control_interval", r11);
        if (r14 == null) goto L26;
        r11 = r14;
    L26:
        ECMallLogUtil.c(r8, "Key : mall_launch_slip_control_interval, Value: " + r11);
        if (r10 <= ((Number) r11).longValue()) goto L41;
        FrameLayout r15 = this.P2;
        if (r15 == null) goto L40;
        NoSlipFrameLayout r16 = (NoSlipFrameLayout) r15;
        r16.setEnableControlSlip(true);
        m r17 = new m(r16, r0);
        Object r18 = 0L;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();
        if (r19 == null) goto L38;
        yj.g r20 = r19.getHostAB();
        if (r20 == null) goto L38;
        Object r21 = r20.a("mall_launch_slip_duration", r18);
        if (r21 == null) goto L38;
        r18 = r21;
    L38:
        ECMallLogUtil.c(r8, "Key : mall_launch_slip_duration, Value: " + r18);
        r16.postDelayed(r17, ((Number) r18).longValue());
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.mall.widget.NoSlipFrameLayout");
    L41:
        ECDetectableFrameLayout r22 = (ECDetectableFrameLayout) r50.findViewById(2131370779);
        if (r22 == null) goto L44;
        r22.setTouchEventDetector(this.d.y);
        Unit r23 = Unit.INSTANCE;
    L44:
        this.e.b(r50, r51);
        IECNativeHomeArgument r24 = ma0();
        if (r24 == null) goto L47;
        int r25 = r24.getPanelTopOffset();
    L48:
        View r26 = getView();
        if (r26 == null) goto L53;
        View r27 = r26.findViewById(2131379454);
        if (r27 == null) goto L53;
        r27.setPadding(r27.getPaddingLeft(), r25, r27.getPaddingRight(), r27.getPaddingBottom());
    L53:
        IECNativeHomeArgument r28 = ma0();
        if (r28 != null) goto L56;
    L60:
        this.V0 = r50.findViewById(2131384142);
        Ref.ObjectRef r29 = new Ref.ObjectRef();
        r29.element = null;
        if (this.s3 != null) goto L63;
        com.bytedance.android.shopping.mall.widget.a r30 = new com.bytedance.android.shopping.mall.widget.a(r50.getContext());
        r30.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r31 = Unit.INSTANCE;
        this.s3 = r30;
    L63:
        com.bytedance.android.shopping.mall.widget.a r32 = this.s3;
        if (r32 == null) goto L73;
        ViewParent r33 = r32.getParent();
        if (r33 == null) goto L73;
        if ((r33 instanceof ViewGroup) == true) goto L70;
        r33 = null;
    L70:
        ViewGroup r34 = (ViewGroup) r33;
        if (r34 == null) goto L73;
        r34.removeView(this.s3);
    L73:
        com.bytedance.android.shopping.mall.widget.a r35 = this.s3;
        if (r35 != null) goto L76;
    L80:
        com.bytedance.android.shopping.mall.widget.a r36 = this.s3;
        r29.element = r36;
        SmartRefreshLayout r37 = this.V0;
        if (r37 == null) goto L93;
        Intrinsics.checkNotNull(r36);
        r37.G(r36, -2);
        r37.g(false);
        if (this.k3 == false) goto L85;
    L87:
        IECNativeHomeArgument r38 = ma0();
        if (r38 == null) goto L90;
        Boolean r39 = r38.getRefreshEnable();
    L91:
        boolean r40 = Intrinsics.areEqual(r39, Boolean.TRUE);
    L92:
        r37.A = r40;
        r37.W = new ECMallFragment$initRefresh$$inlined$apply$lambda$1(this);
        goto L93
    L90:
        r39 = null;
        goto L91
    L85:
        if (this.o3 == false) goto L87;
        r40 = false;
    L93:
        ECHybridListContainer r41 = r50.findViewById(2131378057);
        IECNativeHomeArgument r42 = this.d.f();
        if (r42 != null) goto L96;
        String r110 = "context";
    L250:
        Unit r43 = Unit.INSTANCE;
        if (this.k3 == false) goto L253;
    L277:
        final ECMallSkinManager r44 = this.d.q;
        String r45 = r44.b;
        if (r45 != null) goto L280;
    L283:
        boolean r46 = true;
    L284:
        if (r46 == false) goto L301;
        Context r47 = r44.e.z.getContext();
        if (r47 == null) goto L297;
        ECMallFragment r48 = r44.e.z;
        r48.getClass();
        Intrinsics.checkNotNullParameter(r47, r110);
        String r49 = r48.ga0();
        Intrinsics.checkNotNullParameter(r47, r110);
        StringBuilder r52 = new StringBuilder();
        if (r49 != null) goto L290;
    L293:
        boolean r53 = true;
    L294:
        if (r53 == false) goto L296;
        r49 = "default";
    L296:
        r52.append(r49);
        r52.append("_douyin_skin");
        r44.b = com.bytedance.android.shopping.mall.homepage.tools.q.d(r47, r52.toString());
        MutableLiveData<Boolean> r54 = r44.b();
        int r55 = com.bytedance.android.shopping.mall.background.a.a;
        ECHybridNetworkVO r56 = null;
        r54.setValue(Boolean.valueOf(Intrinsics.areEqual(com.bytedance.android.shopping.mall.background.a.a(r44.b, null).isDarkMode(), Boolean.TRUE)));
    L299:
        if (((Boolean) r44.d.getValue()).booleanValue() == false) goto L302;
        r44.b().observe(r44.e.z, new ECMallSkinManager$init$2(r44));
    L302:
        SimpleDraweeView r57 = r50.findViewById(2131379187);
        SimpleDraweeView r58 = r50.findViewById(2131386360);
        ScrollImageByRV r59 = r50.findViewById(2131385221);
        Lazy r60 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L310;
        IECNativeHomeArgument r61 = ma0();
        if (r61 != null) goto L307;
    L309:
        Lazy r62 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "disable saas background");
    L311:
        ECFMiddleware r63 = this.d;
        r63.o(r63.q.b, true);
        ECHybridListEngine r64 = this.H0;
        Intrinsics.checkNotNull(r64);
        IECNativeHomeArgument r65 = ma0();
        if (r65 == null) goto L314;
        int r66 = r65.getNaMallPreloadStrategy();
    L315:
        jf3.f r67 = new jf3.f(r64, r66);
        jf3.c r68 = this.p0;
        Intrinsics.checkNotNull(r67);
        r68.getClass();
        Intrinsics.checkNotNullParameter(r67, "lifeCycle");
        r68.a.add(r67);
        this.F2 = true;
        if (this.E2 == false) goto L321;
        if (this.W == true) goto L321;
        Fa0();
    L321:
        if (((Boolean) this.G3.getValue()).booleanValue() == false) goto L328;
        ECHybridNetworkVO r69 = this.Q;
        if (r69 != null) goto L327;
        ECHybridDataEngine r70 = this.P0;
        if (r70 == null) goto L328;
        r69 = r70.m(this.k);
    L327:
        ECHybridNetworkVO r71 = r69;
    L329:
        if (r71 != null) goto L331;
    L336:
        IECNativeHomeArgument r72 = ma0();
        if (r72 != null) goto L339;
    L345:
        DataEngineWrapper r73 = this.L0;
        if (r73 == null) goto L348;
        r73.q(System.currentTimeMillis());
    L348:
        jf3.c r74 = this.p0;
        IECNativeHomeArgument r75 = ma0();
        if (r75 != null) goto L351;
    L358:
        boolean r111 = false;
    L359:
        r74.a(r111);
        l r76 = new l(this);
        if (Intrinsics.areEqual(r56, Boolean.TRUE) == false) goto L362;
        ((CopyOnWriteArrayList) this.h.getValue()).add(r76);
    L363:
        com.bytedance.android.ec.hybrid.popup.e r77 = this.A3;
        r77.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r77.a.add(this);
        DataEngineWrapper r78 = this.L0;
        if (r78 == null) goto L366;
        r78.L(AnonymousClass7.INSTANCE);
    L366:
        this.e.i(r50, r51);
        kjc.c r79 = new kjc.c();
        if (5 != kjc.a.a()) goto L370;
        kjc.b r80 = r79.a;
        ThreadPoolHelper.c().submit(n.a);
        r80.a = Unit.INSTANCE;
        r79.b = true;
    L370:
        if (r79.b == true) goto L372;
        r79.a.a = Unit.INSTANCE;
    L372:
        Object r81 = r79.a.a;
        if (((Number) this.F3.getValue()).intValue() != 0) goto L383;
        ECMallFeed r82 = this.f;
        if (r82 == null) goto L385;
        final WeakReference r84 = new WeakReference(requireContext());
        final WeakReference r85 = new WeakReference(r82);
        ECMarketingHelper r86 = this.l;
        Function1<Map<String, ? extends Object>, Map<String, ? extends Object>> r87 = new ECMallFragment$registerCardPositionEvent$1(r84, r85);
        r86.getClass();
        Intrinsics.checkNotNullParameter(r87, "callBack");
        IMarketingServiceV2 r88 = ECMarketingHelper.a();
        if (r88 == null) goto L384;
        r88.h(r87);
        return;
    L384:
        return;
    L385:
        return;
    L383:
        return;
    L362:
        r76.run();
        goto L363
    L351:
        if (r75.getEnableFirstScreenStraightOut() != true) goto L358;
        if (com.bytedance.android.shopping.mall.homepage.tools.q.a(requireContext(), ga0()).length() <= 0) goto L355;
        boolean r89 = true;
    L356:
        if (r89 == false) goto L358;
        r111 = true;
        goto L359
    L355:
        r89 = false;
        goto L356
    L339:
        if (r72.getEnableFirstScreenStraightOut() != true) goto L345;
        if (this.E2 == false) goto L345;
        if (this.G2 == true) goto L345;
        qa0(this);
        this.G2 = true;
        goto L345
    L331:
        if (this.H2 == true) goto L336;
        this.O = true;
        if (this.P == false) goto L335;
        da0(this.k, r71, r56, new AnonymousClass6(this));
        this.Q = r56;
        goto L345
    L335:
        X90(this, false, true, 1);
    L328:
        r71 = r56;
        goto L329
    L314:
        r66 = 0;
        goto L315
    L307:
        if (r61.getEnableBackground() != true) goto L309;
    L310:
        this.d.getClass();
        goto L311
    L290:
        if (r49.length() == 0) goto L293;
        r53 = false;
        goto L294
    L297:
        r56 = null;
        goto L299
    L301:
        r56 = null;
        goto L302
    L280:
        if (r45.length() == 0) goto L283;
        r46 = false;
        goto L284
    L253:
        if (this.o3 == false) goto L277;
        if (this.n3 != null) goto L269;
        Context r90 = getContext();
        if (r90 == null) goto L264;
        View r91 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getLoginGuideView(r90, new ECMallFragment$initLoginGuideView$$inlined$let$lambda$1(this));
        this.n3 = r91;
        if (r91 != null) goto L264;
        com.bytedance.android.shopping.api.mall.common.widget.b r92 = new com.bytedance.android.shopping.api.mall.common.widget.b(r90, new ECMallFragment$initLoginGuideView$$inlined$let$lambda$2(this));
        this.n3 = r92;
        if (isDarkMode() == false) goto L263;
        r92.setBackgroundResource(2131248003);
        r92.c.setImageDrawable(ContextCompat.getDrawable(r92.getContext(), 2131248006));
        r92.a.setTextColor(ContextCompat.getColor(r92.getContext(), 2131106119));
        r92.b.setTextColor(ContextCompat.getColor(r92.getContext(), 2131106112));
        goto L264
    L263:
        r92.setBackgroundResource(2131248004);
        r92.c.setImageDrawable(ContextCompat.getDrawable(r92.getContext(), 2131248007));
        r92.a.setTextColor(ContextCompat.getColor(r92.getContext(), 2131106125));
        r92.b.setTextColor(ContextCompat.getColor(r92.getContext(), 2131106113));
    L264:
        View r94 = this.n3;
        if (r94 == null) goto L269;
        ViewGroup.LayoutParams r95 = new ViewGroup.LayoutParams(-1, -1);
        r94.setVisibility(8);
        FrameLayout r96 = this.P2;
        if (r96 == null) goto L269;
        r96.addView(r94, r95);
    L269:
        View r97 = this.n3;
        if (r97 == null) goto L272;
        r97.setVisibility(0);
    L272:
        j r98 = this.p3;
        ECMallFragment r99 = r98.a;
        r98.a.getClass();
        r98.a.getClass();
        Map<String, ? extends Object> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "loginguide_page_show"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("previous_page", ""), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "")}))});
        ECMallFeed r101 = r99.f;
        if (r101 == null) goto L277;
        ECMallFeed.ReportAbility r102 = r101.j0;
        if (r102 == null) goto L277;
        r102.d(r100);
        goto L277
    L96:
        int r103 = ECMallFeed.e.D;
        String r104 = oa0();
        String r105 = this.d.e();
        String r106 = b0.f();
        Map<String, String> r107 = this.d.l();
        Lazy r112 = MallOptUtil.a;
        String r108 = this.d.e();
        Intrinsics.checkNotNullParameter(r108, "pageName");
        Lazy r109 = MallOptUtil.a;
        Map<String, com.bytedance.android.shopping.api.mall.opt.f> r113 = ((com.bytedance.android.shopping.api.mall.opt.d) r109.getValue()).a();
        if (r113 == null) goto L99;
        com.bytedance.android.shopping.api.mall.opt.f r114 = r113.get(r108);
    L100:
        com.bytedance.android.shopping.api.mall.opt.d r115 = (com.bytedance.android.shopping.api.mall.opt.d) r109.getValue();
        LinkedHashSet r116 = new LinkedHashSet();
        ArrayList<String> r117 = r115.d();
        if (r117 == null) goto L112;
        String r410 = "context";
        if (r117.contains(r108) != true) goto L113;
        Map<String, Integer> r118 = r115.e();
        if (r118 == null) goto L113;
        Set<String> r119 = r118.keySet();
        if (r119 == null) goto L113;
        Iterator<T> r120 = r119.iterator();
    L110:
        if (r120.hasNext() == false) goto L113;
        r116.add((String) r120.next());
    L113:
        yj.g r121 = com.bytedance.android.ec.hybrid.a.b();
        if (r121 == null) goto L116;
        com.bytedance.android.ec.hybrid.data.i r122 = r121.k();
    L118:
        if (r114 == null) goto L120;
        Integer r123 = r114.c();
    L121:
        if (r114 == null) goto L123;
        Integer r124 = r114.b();
    L124:
        if (r114 == null) goto L126;
        Integer r125 = r114.a();
    L127:
        Lazy r126 = ECMallGulPrefetch.h;
        Integer r210 = ECMallGulPrefetch.Companion.a().g(r108);
        Integer r211 = ECMallGulPrefetch.Companion.a().h(r108);
        Integer r212 = ECMallGulPrefetch.Companion.a().c();
        Boolean r213 = Boolean.valueOf(ECMallGulPrefetch.Companion.a().a(r108));
        if (r122 == null) goto L130;
        Integer r214 = r122.g;
    L131:
        if (r122 == null) goto L133;
        Integer r215 = r122.h;
    L134:
        if (r122 == null) goto L136;
        Integer r310 = r122.i;
    L137:
        Boolean r216 = Boolean.valueOf(((Boolean) MallOptUtil.j.getValue()).booleanValue());
        ListEngineOptConfig.r.getClass();
        ListEngineOptConfig r411 = new ListEngineOptConfig(r123, r124, r125, r210, r211, r212, null, r213, r216, ListEngineOptConfig.a.a(r108), r116, r214, r215, r310, 64);
        com.bytedance.android.ec.hybrid.list.e r127 = new com.bytedance.android.ec.hybrid.list.e();
        Intrinsics.checkNotNullParameter(r42, "argument");
        Intrinsics.checkNotNullParameter(r104, "sceneId");
        Intrinsics.checkNotNullParameter(r105, "hostPageName");
        Intrinsics.checkNotNullParameter(r106, "lynxConsumerBid");
        Intrinsics.checkNotNullParameter(r107, "lynxConsumerMonitor");
        Intrinsics.checkNotNullParameter(r127, "engineEventConfig");
        String r128 = r42.getDataEngineTag();
        String r217 = r42.getBundleConfigUrl();
        Boolean r129 = r42.getGeckoExist();
        Boolean r130 = Boolean.TRUE;
        boolean r218 = Intrinsics.areEqual(r129, r130);
        boolean r219 = r42.getShouldCheckECPlugin();
        r42.getEnableEngineParentControl();
        Integer r220 = Integer.valueOf(r42.getRenderThreadStrategy());
        boolean r221 = Intrinsics.areEqual(r42.getVideoSmoothEnter(), r130);
        boolean r222 = Intrinsics.areEqual(r42.getLiveSmoothEnter(), r130);
        Integer r131 = r42.getBottomTabHeight();
        if (r131 == null) goto L140;
        int r223 = r131.intValue();
    L141:
        boolean r311 = r42.getMallFPSMonitorAfterFirstScreen();
        r42.getEnableMallFpsOpt();
        boolean r312 = r42.getExposureEventAsyncReport();
        boolean r313 = Intrinsics.areEqual(r42.getNeedReportLastAction(), r130);
        Integer r132 = r42.getLastActionLen();
        if (r132 == null) goto L144;
        int r314 = r132.intValue();
    L145:
        Integer r315 = r42.getReportSlardar();
        Long r316 = r42.getNaOfflineVersion();
        Integer r133 = r42.getLoadMoreRangeSize();
        if (r133 == null) goto L148;
        int r317 = r133.intValue();
    L149:
        r110 = r410;
        ECMallFeed r134 = new ECMallFeed(r41, this, new ECMallFeed.e(r104, r128, r105, r106, r107, r217, r218, r219, false, r220, r221, r222, r223, r311, r312, r313, r314, r315, r316, r317, r42.getMallScrollTimeInterval(), r42.getPageCardDynamicParamTimeout(), r42.getGeckoChannel(), r411, r127, null, null, null, false), this.L0, StringsKt.toIntOrNull(this.d.j()), ia0(), this, this.S2, this.d.u);
        this.f = r134;
        r134.a1 = System.currentTimeMillis();
        final ECMallFeed r135 = this.f;
        if (r135 == null) goto L250;
        ECHybridListEngine r136 = r135.J;
        this.H0 = r136;
        ECFMiddleware r137 = this.d;
        r137.c = r136;
        r137.b = r135;
        Lazy r138 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.c = new ECMallFragment$initListEngine$1(this);
        Context r139 = getContext();
        if (r139 == null) goto L161;
        ECHybridListEngine r140 = this.H0;
        if (r140 == null) goto L159;
        ECHybridListAdapter r141 = r140.a;
        if (r141 == null) goto L159;
        k r142 = this.X3;
        Intrinsics.checkNotNullParameter(r142, "sectionColumnProvider");
        r141.n = r142;
    L159:
        r135.P(ToolsKt.p(r139));
    L161:
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.mall.settings.b) this.i3.getValue()).a(), r130) == true) goto L163;
    L168:
        r135.c = new ECMallFragment$initListEngine$5(this);
        r135.d = new ECMallFragment$initListEngine$6(this, r42);
        r135.a = new com.bytedance.android.shopping.mall.homepage.j(this);
        r135.e = new com.bytedance.android.shopping.mall.homepage.k(this, r135);
        r135.b = new com.bytedance.android.shopping.mall.homepage.l(this, r135);
        IHybridHostService r143 = com.bytedance.android.ec.hybrid.a.h();
        if (r143 == null) goto L173;
        yj.g r144 = r143.getHostAB();
        if (r144 == null) goto L173;
        r144.r();
    L173:
        final boolean r145 = false;
        IHybridHostService r146 = com.bytedance.android.ec.hybrid.a.h();
        if (r146 == null) goto L178;
        yj.g r147 = r146.getHostAB();
        if (r147 == null) goto L178;
        r147.t();
    L178:
        final long r148 = 500;
        r135.Z(this.l.c);
        r135.Z(new ECMallFragment$initListEngine$11(this, r145, r135, r148));
        View r149 = getView();
        if (r149 == null) goto L181;
        ViewGroup r150 = (ViewGroup) r149.findViewById(2131379494);
    L182:
        View r151 = getView();
        if (r151 == null) goto L185;
        FrameLayout r152 = (FrameLayout) r151.findViewById(2131370776);
    L186:
        if (r150 == null) goto L189;
        if (r152 == null) goto L189;
        this.N2 = new AnchorPendantManager(r150, r152, this, this.S2, this.E);
    L189:
        this.d.getClass();
        this.d.getClass();
        View r153 = getView();
        if (r153 == null) goto L192;
        FrameLayout r154 = (FrameLayout) r153.findViewById(2131370788);
    L193:
        FragmentActivity r155 = getActivity();
        if (r155 == null) goto L202;
        Window r156 = r155.getWindow();
        if (r156 == null) goto L202;
        View r157 = r156.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L204;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r158 = ThreadMethodProxy.currentThread();
        if (r158 == com.larus.home.impl.utils.c.a) goto L204;
        com.larus.home.impl.utils.c.a(r158, "getDecorView");
    L204:
        if ((r157 instanceof FrameLayout) == true) goto L206;
        r157 = null;
    L206:
        FrameLayout r159 = (FrameLayout) r157;
        if (r154 == null) goto L233;
        if (r159 == null) goto L233;
        int r160 = s93.c.a;
        Object r161 = 0;
        IHybridHostService r162 = com.bytedance.android.ec.hybrid.a.h();
        if (r162 == null) goto L217;
        yj.g r163 = r162.getHostAB();
        if (r163 == null) goto L217;
        Object r164 = r163.a("fix_mall_popup_drifting", r161);
        if (r164 == null) goto L217;
        r161 = r164;
    L217:
        Lazy r165 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : fix_mall_popup_drifting, Value: " + r161);
        if (((Number) r161).intValue() != 1) goto L220;
        boolean r166 = true;
    L221:
        Function3<String, String, String, Unit> r167 = new ECMallFragment$initPopupManager$reportPopupHideByDrift$1(this);
        if (((Boolean) this.d.v.getValue()).booleanValue() == false) goto L229;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.b, "init popup manager with new component");
        bf3.a r168 = this.d.a;
        if (r168.a != null) goto L226;
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r169 = MallAbilityManager.a;
        r168.a = (e93.b) MallAbilityManager.b(e93.b.class, r168.b);
    L226:
        e93.b r170 = r168.a;
        if (r170 == null) goto L230;
        r170.h(this, r159, r154, this.S2, this.A3, oa0(), r166, r167);
    L230:
        Function0<Unit> r171 = this.X;
        if (r171 == null) goto L233;
        Unit r172 = (Unit) r171.invoke();
        goto L233
    L229:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.b, "init popup manager");
        this.d.x = new ECPopupManager(this, r159, r154, this.S2, this.A3, oa0(), r166, r167);
        goto L230
    L220:
        r166 = false;
    L233:
        com.bytedance.android.shopping.mall.homepage.s r173 = new com.bytedance.android.shopping.mall.homepage.s(requireContext(), getView(), r135, na0(), this.E);
        String r174 = r173.a.b.B();
        Iterator<T> r175 = r173.b.iterator();
    L235:
        if (r175.hasNext() == false) goto L238;
        IDLXBridgeMethod r176 = (IDLXBridgeMethod) r175.next();
        ECBridgeMethodFinder.a r177 = ECBridgeMethodFinder.h;
        String r178 = r176.getName();
        r177.getClass();
        ECBridgeMethodFinder.a.a(r174, r178, r176);
        goto L235
    L238:
        if (r42.getEnableCorrectShowReport() == false) goto L242;
        ECHybridListEngine r179 = r135.J;
        if (r179 == null) goto L242;
        r179.b.setCurrentListOnScreen(false);
    L242:
        ECEventCenter.e("mallRefreshHomepageEvent", this.j3, oa0());
        pf3.a r180 = (pf3.a) this.W3.getValue();
        if (r180 == null) goto L245;
        ECEventCenter.e("ec.mall.marketingResource", r180, oa0());
    L245:
        ECEventCenter.e("ecom.mall.tool_show", this.z, oa0());
        ECEventCenter.e("ecom.mall.channel_show", this.A, oa0());
        ECEventCenter.e("ecom.mall.tab_show", this.B, oa0());
        EventCenter.registerJsEventSubscriber("ecom.mall.coin_pendant_show", this.y);
        EventCenter.registerJsEventSubscriber("ecom.mall.coin_pendant_dismissed", this.x);
        Lazy r181 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "init data engie end");
        ea0();
        if (com.bytedance.android.shopping.mall.opt.j.b() == false) goto L250;
        if (com.bytedance.android.shopping.mall.opt.j.a().contains(this.d.e()) == false) goto L250;
        com.bytedance.android.shopping.mall.c r182 = this.q;
        d r183 = this.r;
        r182.getClass();
        Intrinsics.checkNotNullParameter(r183, "callback");
        HostSetupWatcher.INSTANCE.registerHostSetupListener(this.w);
    L202:
        r157 = null;
        goto L204
    L192:
        r154 = null;
        goto L193
    L185:
        r152 = null;
        goto L186
    L181:
        r150 = null;
        goto L182
    L163:
        if (this.g3 != null) goto L168;
        IECMallTabOptService r184 = (IECMallTabOptService) ServiceManager.get().getService(IECMallTabOptService.class);
        this.g3 = r184;
        com.bytedance.android.shopping.mall.homepage.i r185 = new com.bytedance.android.shopping.mall.homepage.i();
        if (r184 == null) goto L167;
        r184.b(r185);
    L167:
        Unit r186 = Unit.INSTANCE;
        this.h3 = r185;
        goto L168
    L148:
        r317 = 5;
        goto L149
    L144:
        r314 = 0;
        goto L145
    L140:
        r223 = 0;
        goto L141
    L136:
        r310 = null;
        goto L137
    L133:
        r215 = null;
        goto L134
    L130:
        r214 = null;
        goto L131
    L126:
        r125 = null;
        goto L127
    L123:
        r124 = null;
        goto L124
    L120:
        r123 = null;
        goto L121
    L116:
        r122 = null;
        goto L118
    L112:
        r410 = "context";
        goto L113
    L99:
        r114 = null;
        goto L100
    L76:
        if (this.d.k() != true) goto L78;
        boolean r187 = true;
    L79:
        r35.setNightMode(r187);
        goto L80
    L78:
        r187 = false;
        goto L79
    L56:
        if (r28.getShowHalfMallBar() != true) goto L60;
        View r188 = r50.findViewById(2131374180);
        if (r188 == null) goto L60;
        r188.setVisibility(0);
        goto L60
    L47:
        r25 = 0;
        goto L48
    }

    public final boolean pa0(boolean r12, boolean r13) {
        Object r2 = 0;
        if (getContext() != null) goto L5;
    L313:
        this.g = 2;
        Lazy r14 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "handle cache data failed context is null");
        return false;
    L5:
        if (getActivity() == null) goto L313;
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L9;
    L11:
        int r1 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L166
        Object r7 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_skip_cache_data_render");     // Catch: Throwable -> L62
        if (r7 != null) goto L17;
    L59:
        Object r8 = null;
    L60:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L62
    L64:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L166
        if (r10 == null) goto L68;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L166
    L68:
        if (Result.isFailure-impl(r9) == false) goto L71;
        r9 = null;
    L71:
        if ((r9 instanceof Integer) == true) goto L73;
        r9 = null;
    L73:
        Object r11 = (Integer) r9;     // Catch: Throwable -> L166
        if (r11 != null) goto L80;
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ec_mall_skip_cache_data_render");     // Catch: Throwable -> L166
        if ((r15 instanceof Integer) == true) goto L79;
        r15 = null;
    L79:
        r11 = (Integer) r15;     // Catch: Throwable -> L166
    L80:
        if (r11 != null) goto L173;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_skip_cache_data_render");     // Catch: Throwable -> L132
        if (r17 != null) goto L87;
    L129:
        Object r18 = null;
    L130:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L132
    L134:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L157
        if (r20 == null) goto L138;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L157
    L138:
        if (Result.isFailure-impl(r19) == false) goto L141;
        r19 = null;
    L141:
        if ((r19 instanceof Integer) == true) goto L143;
        r19 = null;
    L143:
        r11 = (Integer) r19;     // Catch: Throwable -> L157
        if (r11 != null) goto L164;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L157
        if (r21 == null) goto L149;
        Object r22 = r21.getHostABValue("ec_mall_skip_cache_data_render", r2);     // Catch: Throwable -> L157
    L150:
        if (r22 != null) goto L152;
    L163:
        r11 = r2;
        goto L164
    L152:
        if ((r22 instanceof Integer) == true) goto L154;
        r22 = null;
    L154:
        r11 = (Integer) r22;     // Catch: Throwable -> L157
        if (r11 != null) goto L164;
    L157:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L166
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r24 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L166
        if (r24 == null) goto L162;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L166
    L162:
        if (Result.isFailure-impl(r11) == false) goto L164;
    L149:
        r22 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_mall_skip_cache_data_render", r11);     // Catch: Throwable -> L166
        goto L173
    L87:
        if ((r17 instanceof Integer) == true) goto L89;
        Object r25 = null;
    L90:
        r18 = (Integer) r25;     // Catch: Throwable -> L132
        if (r18 != null) goto L130;
        if ((r17 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r26 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L132
        if ((r26 instanceof Integer) == true) goto L100;
        r26 = null;
    L100:
        r18 = (Integer) r26;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r27 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L132
        if ((r27 instanceof Integer) == true) goto L106;
        r27 = null;
    L106:
        r18 = (Integer) r27;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r28 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L132
        if ((r28 instanceof Integer) == true) goto L115;
        r28 = null;
    L115:
        r18 = (Integer) r28;     // Catch: Throwable -> L132
    L117:
        if ((r17 instanceof JSONObject) == false) goto L119;
    L321:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L125
        Object r29 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r29 instanceof Integer) == true) goto L123;
        r29 = null;
    L123:
        Object r30 = Result.constructor-impl((Integer) r29);     // Catch: Throwable -> L125
    L127:
        r18 = r30;
        if (Result.isFailure-impl(r18) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L132
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r17 instanceof JSONArray) == false) goto L129;
    L89:
        r25 = r17;
    L132:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L157
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L173:
        int r3 = ((Number) r11).intValue();
        if (r3 <= 0) goto L178;
        if (r3 != 2) goto L177;
        Pa0(null);
    L177:
        return false;
    L178:
        if (r12 == true) goto L191;
        ECHybridDataEngine r4 = this.P0;
        if (r4 == null) goto L182;
        String r5 = r4.m(this.k);
    L183:
        if (r5 == null) goto L191;
        IECNativeHomeArgument r33 = ma0();
        if (r33 != null) goto L187;
    L188:
        this.g = 3;
        return false;
    L187:
        if (r33.getNeedRefreshPage() == true) goto L191;
    L182:
        r5 = null;
    L191:
        if (((Number) kk.d.a(r2, new ECMallFragment$handleCacheData$popupPageDispatchStrategy$1(this))).intValue() != 1) goto L213;
        DataEngineWrapper r34 = this.L0;
        if (r34 == null) goto L197;
        y93.a r35 = r34.b;
        if (r35 == null) goto L197;
        Boolean r36 = r35.s();
    L199:
        if (Intrinsics.areEqual(r36, Boolean.TRUE) == false) goto L213;
        int r110 = s93.c.a;
        Object r111 = Boolean.FALSE;
        IHybridHostService r112 = com.bytedance.android.ec.hybrid.a.h();
        if (r112 == null) goto L208;
        yj.g r113 = r112.getHostAB();
        if (r113 == null) goto L208;
        Object r114 = r113.a("ec_mall_popup_page_dispatch_loading_enable", r111);
        if (r114 == null) goto L208;
        r111 = r114;
    L208:
        Lazy r115 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_popup_page_dispatch_loading_enable, Value: " + r111);
        if (((Boolean) r111).booleanValue() == false) goto L211;
        Pa0(null);
    L211:
        this.g = 4;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "skip render with cached data for popup page dispatch");
        return false;
    L197:
        r36 = null;
    L213:
        if (r12 == false) goto L215;
    L217:
        int r37 = s93.c.a;
        IHybridHostService r38 = com.bytedance.android.ec.hybrid.a.h();
        if (r38 == null) goto L223;
        yj.g r39 = r38.getHostAB();
        if (r39 == null) goto L223;
        Object r40 = r39.a("ec_mall_legou_disable_cache_stright_out_exp", r2);
        if (r40 == null) goto L223;
    L224:
        Lazy r41 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r42 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r42, "Key : ec_mall_legou_disable_cache_stright_out_exp, Value: " + r40);
        if (((Number) r40).intValue() <= 0) goto L235;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "skip handle cache data");
        if (this.J2 == true) goto L234;
        ECHybridListEngine r116 = this.H0;
        if (r116 == null) goto L231;
        com.bytedance.android.ec.hybrid.list.entity.k r117 = r116.c.g;
    L232:
        if (r117 != null) goto L234;
        Pa0(null);
        goto L234
    L231:
        r117 = null;
    L234:
        return false;
    L235:
        if (r12 == false) goto L237;
    L240:
        com.bytedance.android.ec.hybrid.log.mall.m.a r118 = com.bytedance.android.ec.hybrid.log.mall.m.a.b;
        ECMallLogUtil.c(r118, "ECMallFragment#handleCacheData()@" + hashCode() + ", going to render with cached data, duration = " + (System.currentTimeMillis() - this.r3));
        DataEngineWrapper r43 = this.L0;
        if (r43 == null) goto L243;
        r43.L(ECMallFragment$handleCacheData$2.INSTANCE);
        Unit r44 = Unit.INSTANCE;
    L243:
        IHybridHostService r45 = com.bytedance.android.ec.hybrid.a.h();
        if (r45 == null) goto L251;
        yj.g r46 = r45.getHostAB();
        if (r46 == null) goto L251;
        Object r47 = r46.a("ec_mall_ai_prefetch_expired_data_reuse", r2);
        if (r47 == null) goto L251;
        r2 = r47;
    L251:
        ECMallLogUtil.c(r42, "Key : ec_mall_ai_prefetch_expired_data_reuse, Value: " + r2);
        if (((Number) r2).intValue() <= 0) goto L270;
        DataEngineWrapper r48 = this.L0;
        if (r48 == null) goto L256;
        final HomePageDTO r49 = r48.u;
    L257:
        if (r49 == null) goto L270;
        DataEngineWrapper r50 = this.L0;
        if (r50 == null) goto L261;
        r50.u = null;
    L261:
        DataEngineWrapper r51 = this.L0;
        if (r51 == null) goto L264;
        r51.A(System.currentTimeMillis());
        Unit r52 = Unit.INSTANCE;
    L264:
        ECMallLogUtil.c(r118, "ECMallFragment#handleCacheData()@" + hashCode() + ", get cached homepage data from ai prefetch expired data");
        DataEngineWrapper r119 = this.L0;
        if (r119 == null) goto L267;
        r119.L(new ECMallFragment$handleCacheData$3(r49));
        Unit r120 = Unit.INSTANCE;
    L267:
        Ia0(r49, null, r13);
        return true;
    L256:
        r49 = null;
    L270:
        if (((Number) StraightOutPrefetchTask.d.getValue()).intValue() <= 0) goto L293;
        String r53 = ga0();
        if (r53 != null) goto L274;
    L277:
        boolean r54 = true;
    L278:
        if (r54 == false) goto L280;
        r53 = "homepage_cache";
    L280:
        com.bytedance.android.shopping.api.mall.m r55 = (com.bytedance.android.shopping.api.mall.m) this.T.getValue();
        if (r55 == null) goto L293;
        final Pair r56 = (Pair) r55.d(MallPreloadName.MALL_STRAIGHT_OUT, MapsKt.mapOf(TuplesKt.to("cache_key", r53)));
        if (r56 == null) goto L293;
        DataEngineWrapper r57 = this.L0;
        if (r57 == null) goto L287;
        r57.A(System.currentTimeMillis());
        Unit r58 = Unit.INSTANCE;
    L287:
        ECMallLogUtil.c(r118, "ECMallFragment#handleCacheData()@" + hashCode() + ", get cached homepage data from preload task");
        DataEngineWrapper r121 = this.L0;
        if (r121 == null) goto L290;
        r121.L(new ECMallFragment$handleCacheData$4$1$1(r56));
        Unit r122 = Unit.INSTANCE;
    L290:
        Ia0((HomePageDTO) r56.getFirst(), (com.bytedance.android.ec.hybrid.list.entity.k) r56.getSecond(), r13);
        return true;
    L274:
        if (r53.length() == 0) goto L277;
        r54 = false;
    L293:
        if (Intrinsics.areEqual(this.d.e(), MallPageName.X_TAB_MALL) == false) goto L295;
        int r59 = com.bytedance.android.shopping.mall.homepage.opt.c.a;
    L295:
        DataEngineWrapper r60 = this.L0;
        if (r60 == null) goto L298;
        r60.L(ECMallFragment$handleCacheData$6.INSTANCE);
        Unit r61 = Unit.INSTANCE;
    L298:
        String r62 = com.bytedance.android.shopping.mall.homepage.tools.q.a(requireContext(), ga0());
        if (com.bytedance.forest.utils.h.a(r62) == false) goto L308;
        ECMallLogUtil.c(r118, "ECMallFragment#handleCacheData()@" + hashCode() + ", get cached homepage data from disk");
        DataEngineWrapper r123 = this.L0;
        if (r123 == null) goto L323;
        r123.A(System.currentTimeMillis());
        Unit r124 = Unit.INSTANCE;
    L323:
        Ia0((HomePageDTO) new Gson().fromJson(r62, HomePageDTO.class), null, r13);     // Catch: Exception -> L305
        return true;
    L305:
        e = move-exception;
        Lazy r125 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "handle cache data gson error, " + e.getMessage());
        return false;
    L308:
        this.g = 8;
        if (this.J2 == true) goto L311;
        Pa0(null);
    L311:
        ECMallLogUtil.b(r118, "handle cache data failed, local data is null");
        return false;
    L237:
        if (this.O == false) goto L240;
        this.g = 7;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "skip render with cached data");
        return false;
    L223:
        r40 = r2;
        goto L224
    L215:
        if (ha0() >= 2) goto L217;
        ECMallDeliveryReduceConfig r63 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        LinkedHashMap r64 = new LinkedHashMap();
        ha0();
        Intrinsics.checkNotNullParameter(r64, "deliveryParams");
        goto L217
    L17:
        if ((r7 instanceof Integer) == true) goto L19;
        Object r65 = null;
    L20:
        r8 = (Integer) r65;     // Catch: Throwable -> L62
        if (r8 != null) goto L60;
        if ((r7 instanceof Number) == false) goto L47;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L32;
        Float r66 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L62
        if ((r66 instanceof Integer) == true) goto L30;
        r66 = null;
    L30:
        r8 = (Integer) r66;     // Catch: Throwable -> L62
        goto L60
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L38;
        Double r67 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L62
        if ((r67 instanceof Integer) == true) goto L36;
        r67 = null;
    L36:
        r8 = (Integer) r67;     // Catch: Throwable -> L62
        goto L60
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L41;
        r8 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Long r68 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L62
        if ((r68 instanceof Integer) == true) goto L45;
        r68 = null;
    L45:
        r8 = (Integer) r68;     // Catch: Throwable -> L62
    L47:
        if ((r7 instanceof JSONObject) == false) goto L49;
    L319:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L55
        Object r69 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L55
        if ((r69 instanceof Integer) == true) goto L53;
        r69 = null;
    L53:
        Object r70 = Result.constructor-impl((Integer) r69);     // Catch: Throwable -> L55
    L57:
        r8 = r70;
        if (Result.isFailure-impl(r8) == false) goto L60;
    L55:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L62
        r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
        goto L57
    L49:
        if ((r7 instanceof JSONArray) == false) goto L59;
    L19:
        r65 = r7;
    L62:
        th = move-exception;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L166
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r74 = Result.exceptionOrNull-impl(r11);
        if (r74 == null) goto L171;
        EnsureManager.ensureNotReachHere(r74);
    L171:
        if (Result.isFailure-impl(r11) == false) goto L173;
        r11 = r2;
        goto L173
    L9:
        if (r0.isFinishing() != true) goto L11;
        goto L11
    }

    public final void sa0(com.bytedance.android.ec.hybrid.list.entity.k r5, Function1<? super ECHybridListItemVO, Unit> r6) {
        Integer r0 = null;
        if (r5 == null) goto L14;
        ArrayList r7 = r5.c;
        if (r7 == null) goto L14;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r1).a, "multi_in_one_section") == false) goto L8;
    L13:
        com.bytedance.android.ec.hybrid.list.entity.i r2 = (com.bytedance.android.ec.hybrid.list.entity.i) r1;
    L15:
        if (r2 == null) goto L26;
        ArrayList r9 = r2.i;
        if (r9 == null) goto L26;
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r3 = r10.next();
        if (Intrinsics.areEqual(((ECHybridListItemVO) r3).d, "multi_in_one_item") == false) goto L20;
    L25:
        ECHybridListItemVO r4 = (ECHybridListItemVO) r3;
    L27:
        if (r4 != null) goto L59;
    L29:
        int r11 = ECHybridListItemType.NATIVE_HEADER_CHIP_AREA_CARD.getType();     // Catch: Exception -> L56
        if (r0 != null) goto L34;
    L39:
        String r12 = this.d.q.b;     // Catch: Exception -> L56
        if (r4 == null) goto L53;
        HashMap r13 = r4.E;     // Catch: Exception -> L56
        if (r13 == null) goto L53;
        if (r12 != null) goto L45;
    L48:
        boolean r14 = true;
    L49:
        if (r14 == false) goto L51;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L56
    L52:
        r13.put("skin", r15);     // Catch: Exception -> L56
        goto L53
    L51:
        r15 = new JSONObject(r12);     // Catch: Exception -> L56
        goto L52
    L45:
        if (r12.length() == 0) goto L48;
        r14 = false;
    L53:
        if (r6 == null) goto L67;
        Unit r16 = (Unit) r6.invoke(r4);     // Catch: Exception -> L56
        return;
    L56:
        e = move-exception;
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.d.b, "handleDouyinSkinForLynxHeaderSection failed, error = " + e);
        return;
    L67:
        return;
    L34:
        if (r0.intValue() != r11) goto L39;
        HashMap r18 = r4.E;     // Catch: Exception -> L56
        String r19 = this.d.q.b;     // Catch: Exception -> L56
        if (r19 != null) goto L38;
        r19 = "";
    L38:
        r18.put("skin", r19);     // Catch: Exception -> L56
        goto L53
    L59:
        r0 = r4.c;     // Catch: Exception -> L56
        goto L29
    L24:
        r3 = null;
    L26:
        r4 = null;
        goto L27
    L12:
        r1 = null;
    L14:
        r2 = null;
        goto L15
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final View yZ(String r7, String r8) {
        if (r7 == null) goto L101;
        int r1 = r7.hashCode();
        boolean r3 = false;
        if (r1 == (-1928986619)) goto L71;
        if (r1 == (-868071810)) goto L53;
        if (r1 == (-682595428)) goto L13;
        return null;
    L13:
        if (r7.equals("pendant") == false) goto L94;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L50
        if (r8.length() != 0) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == true) goto L49;
        AnchorPendantManager r11 = this.N2;     // Catch: Throwable -> L50
        if (r11 == null) goto L49;
        Intrinsics.checkNotNullParameter(r8, "uiName");     // Catch: Throwable -> L50
        Iterator<T> r12 = r11.d.iterator();     // Catch: Throwable -> L50
    L23:
        if (r12.hasNext() == false) goto L36;
        Object r2 = r12.next();     // Catch: Throwable -> L50
        View r4 = ((AnchorPendant) r2).r.c;     // Catch: Throwable -> L50
        if ((r4 instanceof LynxView) == true) goto L27;
        r4 = null;
    L27:
        LynxView r5 = (LynxView) r4;     // Catch: Throwable -> L50
        if (r5 == null) goto L30;
        View r6 = r5.findViewByName(r8);     // Catch: Throwable -> L50
    L31:
        if (r6 == null) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L23;
    L37:
        AnchorPendant r14 = (AnchorPendant) r2;     // Catch: Throwable -> L50
        if (r14 == null) goto L49;
        View r15 = r14.r.c;     // Catch: Throwable -> L50
        if (r15 == null) goto L49;
        if ((r15 instanceof LynxView) == true) goto L44;
        r15 = null;
    L44:
        LynxView r16 = (LynxView) r15;     // Catch: Throwable -> L50
        if (r16 == null) goto L49;
        View r17 = r16.findViewByName(r8);     // Catch: Throwable -> L50
        if (r17 == null) goto L49;
        return r17;
    L33:
        r13 = false;
        goto L34
    L30:
        r6 = null;
        goto L31
    L36:
        r2 = null;
    L49:
        return null;
    L17:
        r10 = false;
    L50:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L94:
        return null;
    L53:
        if (r7.equals("topBar") == false) goto L96;
        ECMFTopBarComponent r19 = this.e.d;
        if (r19 == null) goto L90;
        Intrinsics.checkNotNullParameter(r7, "targetName");
        if (Intrinsics.areEqual(r7, "topBar") == true) goto L59;
        return null;
    L59:
        if (r8.length() != 0) goto L61;
        r3 = true;
    L61:
        if (r3 == true) goto L65;
        ECLynxCard r20 = r19.b;
        if (r20 == null) goto L92;
        View r21 = r20.q(r8);
    L69:
        return r21;
    L92:
        return null;
    L65:
        ECLynxCard r22 = r19.b;
        if (r22 == null) goto L93;
        r21 = r22.i();
        goto L69
    L93:
        return null;
    L90:
        return null;
    L96:
        return null;
    L71:
        if (r7.equals("popupLayer") == true) goto L73;
        return null;
    L73:
        if (r8.length() != 0) goto L75;
        r3 = true;
    L75:
        if (r3 == true) goto L79;
        ECLynxCard r23 = this.k1;
        if (r23 != null) goto L99;
        return null;
    L99:
        return r23.q(r8);
    L79:
        ECLynxCard r24 = this.k1;
        if (r24 != null) goto L82;
        return null;
    L82:
        return r24.i();
    L101:
        return null;
    }

    public final void ya0(Function0<Unit> r6, Function0<Unit> r7) {
        IECNativeHomeArgument r0 = ma0();
        Long r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.getBundlePreloaded();
    L6:
        boolean r3 = true;
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L22;
        ECHybridDataEngine r4 = this.P0;
        if (r4 == null) goto L22;
        if (r4.c != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 != true) goto L22;
        ECFMiddleware r8 = this.d;
        IECNativeHomeArgument r9 = ma0();
        if (r9 == null) goto L20;
        r1 = r9.getNaOfflineVersion();
    L20:
        r8.e = r1;
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "bundle preload init data success, ");
        r6.invoke();
        return;
    L13:
        if (r4.p() == null) goto L15;
        r5 = true;
    L22:
        this.Z3 = new Pair(r6, r7);
        Lazy r11 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L25;
    L27:
        RequestParams r12 = new RequestParams(0);
        IECNativeHomeArgument r13 = ma0();
        if (r13 != null) goto L30;
    L32:
        boolean r14 = false;
    L33:
        r12.l = r14;
    L34:
        IECNativeHomeArgument r15 = ma0();
        if (r15 != null) goto L37;
    L40:
        ECHybridDataEngine r16 = this.P0;
        if (r16 == null) goto L44;
        r16.n(r12, r3, this.a4);
        return;
    L44:
        return;
    L37:
        if (r15.getEnableLoadGeckoInThread() != true) goto L40;
        r3 = false;
        goto L40
    L30:
        if (r13.getDisableBuiltin() != true) goto L32;
        r14 = true;
        goto L33
    L25:
        if (ECMallConfigs.INSTANCE.getLegouBuiltinResourceEnable() == false) goto L27;
        Lazy r17 = NativeMallGeckoHelper.a;
        Intrinsics.checkNotNullParameter("config.json", "bundle");
        r12 = new RequestParams(0);
        r12.b = NativeMallGeckoHelper.a();
        r12.c = NativeMallGeckoHelper.b();
        r12.d = "config.json";
        goto L34
    L5:
        r2 = null;
        goto L6
    }

    public static final void V90(ECMallFragment r10, boolean r11, String r12) {
        IECNativeHomeArgument r0 = r10.ma0();
        if (r0 == null) goto L32;
        Map<String, String> r1 = r0.getLandingInfo();
        if (r1 == null) goto L33;
        String r2 = r1.get("schema");
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        long r3 = -1;
        String r4 = r1.get("begin_time");     // Catch: Exception -> L14
        if (r4 == null) goto L15;
        long r5 = CastLongProtector.parseLong(r4);     // Catch: Exception -> L14
    L17:
        if (com.bytedance.forest.utils.h.a(r2) == false) goto L34;
        Uri r6 = UriProtector.parse(r2);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("eventName", "enter_ecom_intro_done");
        LinkedHashMap r8 = new LinkedHashMap();
        if (r11 == false) goto L21;
        String r9 = "success";
    L22:
        r8.put("result", r9);
        r8.put("step", "load_template");
        if (r11 == false) goto L25;
        r12 = "";
    L25:
        r8.put("error_msg", r12);
        r8.put("delivery_type", com.bytedance.android.shopping.api.mall.common.tools.v.g(r6, "delivery_type"));
        if (r5 == (-1)) goto L28;
        r3 = System.currentTimeMillis() - r5;
    L28:
        r8.put("duration", Long.valueOf(r3));
        r8.put(SimilarProductParam.ENTER_FROM, com.bytedance.android.shopping.api.mall.common.tools.v.g(r6, SimilarProductParam.ENTER_FROM));
        r8.put("enter_from_second", com.bytedance.android.shopping.api.mall.common.tools.v.g(r6, "enter_from_second"));
        r7.put("params", r8);
        Unit r13 = Unit.INSTANCE;
        r10.Ka0(r7);
        return;
    L21:
        r9 = DeepFeedCouponResult.FAIL;
        goto L22
    L34:
        return;
    L15:
        r5 = -1;
        goto L17
    L33:
        return;
    }

    public final void Ia0(HomePageDTO r32, final com.bytedance.android.ec.hybrid.list.entity.k r33, boolean r34) {
        HomePageDTO r0 = r32;
        if (this.e4 == true) goto L5;
        return;
    L5:
        int r2 = s93.c.a;
        boolean r3 = false;
        Object r4 = 0;
        IHybridHostService r5 = com.bytedance.android.ec.hybrid.a.h();
        if (r5 == null) goto L13;
        yj.g r6 = r5.getHostAB();
        if (r6 == null) goto L13;
        Object r7 = r6.a("ec_mall_cache_image_prefetch_opt", r4);
        if (r7 == null) goto L13;
        r4 = r7;
    L13:
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_cache_image_prefetch_opt, Value: " + r4);
        boolean r9 = true;
        if (((Number) r4).intValue() != 1) goto L18;
        DataEngineWrapper r10 = this.L0;
        if (r10 == null) goto L18;
        DataEngineWrapper.C(r10, r0, true, 4);
    L18:
        Y90(r0, true);
        final Ref.LongRef r11 = new Ref.LongRef();
        r11.element = -1;
        Integer r12 = null;
        if (ha0() != 2) goto L21;
        r11.element = System.currentTimeMillis();
        ECMallDeliveryReduceConfig r13 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        LinkedHashMap r14 = new LinkedHashMap();
        ha0();
        Intrinsics.checkNotNullParameter(r14, "deliveryParams");
    L25:
        final HomePageDTO r15 = r0;
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "ECMallFragment#refreshCacheHomepage()@" + hashCode());
        DataEngineWrapper r16 = this.L0;
        if (r16 == null) goto L195;
        Intrinsics.checkNotNullParameter(r15, "homepage");
        ECMallMitaCardConvertConfig r17 = (ECMallMitaCardConvertConfig) r16.p.getValue();     // Catch: Throwable -> L190
        String r18 = r17.getTemplateUrl();     // Catch: Throwable -> L190
        if (r18 != null) goto L49;
    L52:
        boolean r19 = true;
    L53:
        if (r19 == false) goto L55;
    L57:
        boolean r110 = false;
    L58:
        if (r110 == true) goto L61;
        r17 = null;
    L61:
        if (r17 == null) goto L193;
        ECHybridDataEngine r20 = r16.a;     // Catch: Throwable -> L190
        if (r20 == null) goto L66;
        String r21 = r20.q();     // Catch: Throwable -> L190
    L68:
        if (r17.isSupport(r21) == false) goto L193;
        HomePageBffDTO r22 = r15.getBff();     // Catch: Throwable -> L190
        if (r22 == null) goto L192;
        ECHybridListDTO r23 = r22.getFeed();     // Catch: Throwable -> L190
        if (r23 == null) goto L192;
        List r24 = r23.getSections();     // Catch: Throwable -> L190
        if (r24 == null) goto L192;
        Iterator r25 = r24.iterator();     // Catch: Throwable -> L190
    L79:
        if (r25.hasNext() == false) goto L83;
        Object r111 = r25.next();     // Catch: Throwable -> L190
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r111).getSectionId(), "category_tab_section") == false) goto L79;
    L84:
        ECHybridListSectionDTO r112 = (ECHybridListSectionDTO) r111;     // Catch: Throwable -> L190
        if (r112 == null) goto L192;
        ArrayList r26 = r112.getItems();     // Catch: Throwable -> L190
        if (r26 == null) goto L192;
        ECHybridListItemDTO r27 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(r26);     // Catch: Throwable -> L190
        if (r27 == null) goto L192;
        Integer r113 = r27.getItemType();     // Catch: Throwable -> L190
        if (r113 == null) goto L192;
        int r114 = r113.intValue();     // Catch: Throwable -> L190
        Integer r115 = r17.getCardType();     // Catch: Throwable -> L190
        if (r115 == null) goto L192;
        int r116 = r115.intValue();     // Catch: Throwable -> L190
        if (r114 == r116) goto L193;
        HomePageBffDTO r117 = r15.getBff();     // Catch: Throwable -> L190
        if (r117 == null) goto L192;
        ECHybridListDTO r118 = r117.getFeed();     // Catch: Throwable -> L190
        if (r118 == null) goto L192;
        Map r119 = r118.getItemConfigs();     // Catch: Throwable -> L190
        if (r119 == null) goto L192;
        ECListItemConfigDTO r28 = (ECListItemConfigDTO) r119.get(String.valueOf(r114));     // Catch: Throwable -> L190
        if (r28 == null) goto L192;
        r27.setItemType(Integer.valueOf(r116));     // Catch: Throwable -> L190
        r28.setMitaCardConfig(r17);     // Catch: Throwable -> L190
        HomePageBffDTO r29 = r15.getBff();     // Catch: Throwable -> L190
        if (r29 == null) goto L120;
        ECHybridListDTO r30 = r29.getFeed();     // Catch: Throwable -> L190
        if (r30 == null) goto L120;
        Map r31 = r30.getItemConfigs();     // Catch: Throwable -> L190
        if (r31 == null) goto L120;
        if (TypeIntrinsics.isMutableMap(r31) == true) goto L116;
        Map r120 = null;
    L117:
        if (r120 != null) goto L121;
        r120 = MapsKt.toMutableMap(r31);     // Catch: Throwable -> L190
        if (TypeIntrinsics.isMutableMap(r120) == false) goto L120;
    L121:
        if (r120 == null) goto L123;
        ECListItemConfigDTO r35 = (ECListItemConfigDTO) r120.put(String.valueOf(r116), r28);     // Catch: Throwable -> L190
    L123:
        HomePageBffDTO r36 = r15.getBff();     // Catch: Throwable -> L190
        if (r36 == null) goto L128;
        ECHybridListDTO r37 = r36.getFeed();     // Catch: Throwable -> L190
        if (r37 == null) goto L128;
        r37.setItemConfigs(r120);     // Catch: Throwable -> L190
    L128:
        Lazy r38 = ECMallLogUtil.a;     // Catch: Throwable -> L190
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.e.b, "ECMallDataEngineWrapper#convertCategoryTabType, convert dto");     // Catch: Throwable -> L190
        HomePageBffDTO r39 = r15.getBff();     // Catch: Throwable -> L190
        if (r39 == null) goto L189;
        com.bytedance.android.ec.hybrid.list.entity.k r40 = r39.getFeedVO();     // Catch: Throwable -> L190
        if (r40 == null) goto L189;
        ArrayList r41 = r40.c;     // Catch: Throwable -> L190
        if (r41 == null) goto L189;
        Iterator r42 = r41.iterator();     // Catch: Throwable -> L190
    L137:
        if (r42.hasNext() == false) goto L142;
        Object r121 = r42.next();     // Catch: Throwable -> L190
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r121).a, "category_tab_section") == false) goto L137;
    L143:
        com.bytedance.android.ec.hybrid.list.entity.i r122 = (com.bytedance.android.ec.hybrid.list.entity.i) r121;     // Catch: Throwable -> L190
        if (r122 == null) goto L189;
        ArrayList r43 = r122.i;     // Catch: Throwable -> L190
        if (r43 == null) goto L189;
        ECHybridListItemVO r44 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r43);     // Catch: Throwable -> L190
        if (r44 == null) goto L189;
        Object r45 = r44.d();     // Catch: Throwable -> L190
        if (r45 != null) goto L415;
    L185:
        HomePageBffDTO r46 = r15.getBff();     // Catch: Throwable -> L190
        if (r46 == null) goto L188;
        r46.setFeedVO(null);     // Catch: Throwable -> L190
    L188:
        Lazy r47 = ECMallLogUtil.a;     // Catch: Throwable -> L190
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.e.b, "ECMallDataEngineWrapper#convertCategoryTabType, convert vo failed");     // Catch: Throwable -> L190
        goto L189
    L415:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L168
        if ((r45 instanceof Map) == true) goto L155;
        Object r124 = null;
    L156:
        Map r125 = (Map) r124;     // Catch: Throwable -> L168
        if (r125 != null) goto L166;
        Gson r126 = com.bytedance.android.shopping.api.mall.common.tools.p.a;     // Catch: Throwable -> L168
        if ((r45 instanceof String) == true) goto L161;
        Object r127 = null;
    L162:
        String r128 = (String) r127;     // Catch: Throwable -> L168
        if (r128 != null) goto L165;
        r128 = com.bytedance.android.shopping.api.mall.common.tools.p.c(r45);     // Catch: Throwable -> L168
    L165:
        r125 = (Map) com.bytedance.android.shopping.api.mall.common.tools.p.a(r128, Map.class);     // Catch: Throwable -> L168
        goto L166
    L161:
        r127 = r45;
    L166:
        Object r48 = Result.constructor-impl(r125);     // Catch: Throwable -> L168
    L171:
        if (Result.isFailure-impl(r48) == false) goto L173;
        r48 = null;
    L173:
        Map r49 = (Map) r48;     // Catch: Throwable -> L190
        if (r49 == null) goto L185;
        r44.o(r49);     // Catch: Throwable -> L190
        HashMap r50 = r40.b;     // Catch: Throwable -> L190
        if (r50 == null) goto L189;
        com.bytedance.android.ec.hybrid.list.entity.k.a r51 = (com.bytedance.android.ec.hybrid.list.entity.k.a) r50.get(String.valueOf(r114));     // Catch: Throwable -> L190
        if (r51 == null) goto L189;
        r44.c = Integer.valueOf(r116);     // Catch: Throwable -> L190
        r51.b = r17;     // Catch: Throwable -> L190
        HashMap r52 = r40.b;     // Catch: Throwable -> L190
        if (r52 == null) goto L184;
        com.bytedance.android.ec.hybrid.list.entity.k.a r53 = (com.bytedance.android.ec.hybrid.list.entity.k.a) r52.put(String.valueOf(r116), r51);     // Catch: Throwable -> L190
    L184:
        Lazy r54 = ECMallLogUtil.a;     // Catch: Throwable -> L190
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.e.b, "ECMallDataEngineWrapper#convertCategoryTabType, convert vo");     // Catch: Throwable -> L190
        goto L189
    L155:
        r124 = r45;
    L168:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L190
        r48 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L190
        goto L171
    L142:
        r121 = null;
    L189:
        r3 = true;
        goto L193
    L116:
        r120 = r31;
    L120:
        r120 = null;
        goto L121
    L83:
        r111 = null;
    L192:
        r3 = false;
        goto L193
    L66:
        r21 = null;
    L193:
        if (r3 != true) goto L195;
        final boolean r55 = true;
    L196:
        this.V2 = r15;
        DataEngineWrapper r56 = this.L0;
        if (r56 == null) goto L199;
        r56.L(new ECMallFragment$refreshCacheHomepage$1(r15, r55));
    L199:
        int r57 = s93.c.a;
        Object r58 = 0;
        IHybridHostService r59 = com.bytedance.android.ec.hybrid.a.h();
        if (r59 == null) goto L207;
        yj.g r60 = r59.getHostAB();
        if (r60 == null) goto L207;
        Object r61 = r60.a("na_mall_straight_downgrade", r58);
        if (r61 == null) goto L207;
        r58 = r61;
    L207:
        Lazy r62 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r63 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r63, "Key : na_mall_straight_downgrade, Value: " + r58);
        if (((Number) r58).intValue() != 1) goto L210;
        boolean r130 = true;
    L211:
        Object r64 = 0;
        IHybridHostService r65 = com.bytedance.android.ec.hybrid.a.h();
        if (r65 == null) goto L219;
        yj.g r66 = r65.getHostAB();
        if (r66 == null) goto L219;
        Object r67 = r66.a("na_mall_straight_downgrade_category", r64);
        if (r67 == null) goto L219;
        r64 = r67;
    L219:
        ECMallLogUtil.c(r63, "Key : na_mall_straight_downgrade_category, Value: " + r64);
        if (((Number) r64).intValue() != 1) goto L222;
        boolean r210 = true;
    L223:
        Object r68 = 0;
        IHybridHostService r69 = com.bytedance.android.ec.hybrid.a.h();
        if (r69 == null) goto L231;
        yj.g r70 = r69.getHostAB();
        if (r70 == null) goto L231;
        Object r71 = r70.a("na_mall_straight_downgrade_nativecard", r68);
        if (r71 == null) goto L231;
        r68 = r71;
    L231:
        ECMallLogUtil.c(r63, "Key : na_mall_straight_downgrade_nativecard, Value: " + r68);
        int r72 = ((Number) r68).intValue();
        Ref.BooleanRef r73 = new Ref.BooleanRef();
        if (r72 != 1) goto L234;
        boolean r74 = true;
    L235:
        r73.element = r74;
        if (r72 != 2) goto L242;
        Map<String, SoftReference<com.bytedance.android.shopping.api.mall.m>> r75 = com.bytedance.android.shopping.mall.homepage.preload.h.a;
        com.bytedance.android.shopping.api.mall.m r76 = com.bytedance.android.shopping.mall.homepage.preload.h.a(this.d.e());
        if (r76 == null) goto L242;
        if ((!Intrinsics.areEqual(r76.c(), Boolean.TRUE)) == false) goto L242;
        r73.element = true;
    L242:
        Object r77 = 0;
        IHybridHostService r78 = com.bytedance.android.ec.hybrid.a.h();
        if (r78 == null) goto L250;
        yj.g r79 = r78.getHostAB();
        if (r79 == null) goto L250;
        Object r80 = r79.a("na_mall_straight_downgrade_last_nativecard", r77);
        if (r80 == null) goto L250;
        r77 = r80;
    L250:
        ECMallLogUtil.c(r63, "Key : na_mall_straight_downgrade_last_nativecard, Value: " + r77);
        if (((Number) r77).intValue() != 1) goto L253;
        boolean r211 = true;
    L254:
        Object r81 = 0;
        IHybridHostService r82 = com.bytedance.android.ec.hybrid.a.h();
        if (r82 == null) goto L262;
        yj.g r84 = r82.getHostAB();
        if (r84 == null) goto L262;
        Object r85 = r84.a("na_mall_straight_dispatch_opt", r81);
        if (r85 == null) goto L262;
        r81 = r85;
    L262:
        ECMallLogUtil.c(r63, "Key : na_mall_straight_dispatch_opt, Value: " + r81);
        if (((Number) r81).intValue() != 1) goto L265;
        boolean r212 = true;
    L266:
        com.bytedance.android.ec.hybrid.log.mall.m.a r86 = com.bytedance.android.ec.hybrid.log.mall.m.a.b;
        ECMallLogUtil.c(r86, "start refresh cache homepage");
        DataEngineWrapper r87 = this.L0;
        if (r87 == null) goto L269;
        r87.A(System.currentTimeMillis());
    L269:
        this.p0.e();
        MallGrayUtil r88 = (MallGrayUtil) this.M2.getValue();
        View r213 = getView();
        ViewGroup r214 = this.d.h();
        View r131 = getView();
        if (r131 == null) goto L272;
        View r215 = r131.findViewById(2131382099);
    L273:
        ViewGroup r216 = this.d.i();
        View r132 = getView();
        if (r132 == null) goto L276;
        View r310 = r132.findViewById(2131379187);
    L277:
        View r133 = getView();
        if (r133 == null) goto L280;
        View r217 = r133.findViewById(2131386360);
    L281:
        r88.c(r15, false, new MallGrayUtil.b(r213, r214, r216, r215, r217, r310));
        Integer r89 = r15.getStatusCode();
        if (r89 == null) goto L284;
        int r134 = r89.intValue();
    L285:
        if (r134 < 0) goto L412;
        xa0();
        this.e.k(r15, r33);
        int r90 = ((Number) kk.d.a(0, new ECMallFragment$refreshCacheHomepage$popupPageDispatchStrategy$1(this))).intValue();
        if (r90 != 2) goto L330;
        DataEngineWrapper r135 = this.L0;
        if (r135 == null) goto L293;
        y93.a r136 = r135.b;
        if (r136 == null) goto L293;
        Boolean r137 = r136.s();
    L295:
        if (Intrinsics.areEqual(r137, Boolean.TRUE) == false) goto L330;
        Object r91 = Boolean.FALSE;
        IHybridHostService r92 = com.bytedance.android.ec.hybrid.a.h();
        if (r92 == null) goto L304;
        yj.g r94 = r92.getHostAB();
        if (r94 == null) goto L304;
        Object r95 = r94.a("ec_mall_popup_page_dispatch_loading_enable", r91);
        if (r95 == null) goto L304;
        r91 = r95;
    L304:
        ECMallLogUtil.c(r63, "Key : ec_mall_popup_page_dispatch_loading_enable, Value: " + r91);
        if (((Boolean) r91).booleanValue() == false) goto L328;
        Integer r96 = (Integer) this.d.j.getValue();
        if (r96 != null) goto L314;
        ViewGroup r97 = this.d.i();
        if (r97 == null) goto L313;
        ViewGroup.LayoutParams r98 = r97.getLayoutParams();
        if (r98 == null) goto L313;
        r96 = Integer.valueOf(r98.height);
    L313:
        r96 = null;
    L314:
        if (r96 != null) goto L316;
    L322:
        r12 = Integer.valueOf((int) UIUtils.dip2Px(requireContext(), 48.0f));
    L323:
        int r99 = r12.intValue();
        IECNativeHomeArgument r100 = ma0();
        if (r100 == null) goto L326;
        int r101 = r100.getPanelTopOffset();
    L327:
        Pa0(Integer.valueOf(r101 + r99));
        goto L328
    L326:
        r101 = 0;
        goto L327
    L316:
        if (Intrinsics.compare(r96.intValue(), 0) > 0) goto L319;
        r9 = false;
    L319:
        if (r9 == false) goto L321;
        r12 = r96;
    L321:
        if (r12 != null) goto L323;
    L328:
        CommonUtilKt.g(new ECMallFragment$refreshCacheHomepage$2(this));
        ECMallLogUtil.c(r86, "ECMallFragment#refreshCacheHomepage()@" + hashCode() + ", render topBar only");
        return;
    L293:
        r137 = null;
    L330:
        HomePageBffDTO r138 = r15.getBff();
        if (r138 == null) goto L333;
        ECHybridListDTO r139 = r138.getFeed();
    L334:
        if (r139 != null) goto L336;
        return;
    L336:
        if (this.H0 == null) goto L431;
        IECNativeHomeArgument r140 = ma0();
        if (r140 != null) goto L340;
    L410:
        ECMallLogUtil.c(r86, "ECMallFragment#refreshCacheHomepage()@" + hashCode() + ", async start");
        Single.just(r15).map(new p(this, r139, r15, r130, r210, r73, r211, r212)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this, r139), r.a);
        return;
    L340:
        if (r140.getMallStraightOutSync() != 1) goto L410;
        if (this.x2 == false) goto L344;
        return;
    L344:
        ECMallLogUtil.c(r86, "ECMallFragment#refreshCacheHomepage()@" + hashCode() + ", sync start");
        DataEngineWrapper r102 = this.L0;
        if (r102 == null) goto L347;
        r102.z();
    L347:
        long r141 = System.currentTimeMillis();
        HomePageBffDTO r103 = r15.getBff();
        if (r103 == null) goto L351;
        com.bytedance.android.ec.hybrid.list.entity.k r104 = r103.getFeedVO();
        if (r104 == null) goto L351;
    L358:
        ECFMiddleware r105 = this.d;
        Object r106 = Boolean.FALSE;
        IHybridHostService r142 = com.bytedance.android.ec.hybrid.a.h();
        if (r142 == null) goto L366;
        yj.g r143 = r142.getHostAB();
        if (r143 == null) goto L366;
        Object r107 = r143.a("ec_mall_first_screen_render_optimize", r106);
        if (r107 == null) goto L366;
        r106 = r107;
    L366:
        ECMallLogUtil.c(r63, "Key : ec_mall_first_screen_render_optimize, Value: " + r106);
        if (((Boolean) r106).booleanValue() == true) goto L369;
        Boolean r108 = null;
    L373:
        this.d3 = System.currentTimeMillis() - r141;
        ECHybridListDTO.a r109 = ECHybridListDTO.Companion;
        boolean r144 = r73.element;
        Function1<com.bytedance.android.ec.hybrid.list.entity.k, Unit> r145 = new ECMallFragment$refreshCacheHomepage$3(this, r33);
        r109.getClass();
        ECHybridListDTO.a.c(r104, r130, r210, r144, r211, r212, r145);
        if (r90 != 3) goto L396;
        DataEngineWrapper r146 = this.L0;
        if (r146 == null) goto L380;
        y93.a r147 = r146.b;
        if (r147 == null) goto L380;
        Boolean r148 = r147.s();
    L382:
        if (Intrinsics.areEqual(r148, Boolean.TRUE) == false) goto L396;
        ArrayList r149 = r104.c;
        if (r149 == null) goto L393;
        Iterator r150 = r149.iterator();
    L387:
        if (r150.hasNext() == false) goto L391;
        Object r151 = r150.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r151).a, "multi_in_one_section") == false) goto L387;
    L392:
        Boolean r152 = (com.bytedance.android.ec.hybrid.list.entity.i) r151;
    L394:
        if (r152 == null) goto L396;
        r104.c = CollectionsKt.arrayListOf(new com.bytedance.android.ec.hybrid.list.entity.i[]{r152});
        Lazy r153 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "ECMallFragment#refreshCacheHomepage()@" + hashCode() + ", render without gul");
        goto L396
    L391:
        r151 = r108;
        goto L392
    L393:
        r152 = r108;
    L380:
        r148 = r108;
    L396:
        DataEngineWrapper r154 = this.L0;
        if (r154 == null) goto L399;
        r154.L(ECMallFragment$refreshCacheHomepage$4.INSTANCE);
    L399:
        this.e3 = System.currentTimeMillis() - r141;
        this.K = Boolean.FALSE;
        com.bytedance.android.shopping.api.mall.m r155 = (com.bytedance.android.shopping.api.mall.m) this.T.getValue();
        if (r155 == null) goto L402;
        Boolean r156 = r155.c();
    L403:
        this.p = r156;
        ECMallFeed r157 = this.f;
        if (r157 == null) goto L406;
        r157.j0(r104, r139.getCursor(), r139.getHasMore());
    L406:
        xa0();
        if (r11.element <= 0) goto L409;
        CommonUtilKt.g(new ECMallFragment$refreshCacheHomepage$5(this, r11));
    L409:
        Lazy r158 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "ECMallFragment#refreshCacheHomepage()@" + hashCode() + ", sync end");
        return;
    L402:
        r156 = r108;
        goto L403
    L369:
        ECMFTopBarComponent r159 = this.e.d;
        if (r159 == null) goto L372;
        r159.w(r105.q.b);
    L372:
        r108 = null;
        sa0(r104, null);
    L351:
        ECHybridListDTO.a r160 = ECHybridListDTO.Companion;
        HomePageBffDTO r161 = r15.getBff();
        if (r161 == null) goto L356;
        BffBizInfo r162 = r161.getBizInfo();
        if (r162 == null) goto L356;
        String r163 = r162.getEcSceneId();
    L357:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r164 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r163, 190);
        r160.getClass();
        r104 = ECHybridListDTO.a.d(r139, true, r164);
    L356:
        r163 = null;
        goto L357
    L431:
        return;
    L333:
        r139 = null;
        goto L334
    L412:
        Integer r165 = r15.getStatusCode();
        Intrinsics.checkNotNull(r165);
        throw new NativeMallApiException(r165.intValue(), r15.getStatusMessage());
    L284:
        r134 = 0;
        goto L285
    L280:
        r217 = null;
        goto L281
    L276:
        r310 = null;
        goto L277
    L272:
        r215 = null;
        goto L273
    L265:
        r212 = false;
        goto L266
    L253:
        r211 = false;
        goto L254
    L234:
        r74 = false;
        goto L235
    L222:
        r210 = false;
        goto L223
    L210:
        r130 = false;
        goto L211
    L55:
        if (r17.getCardType() == null) goto L57;
        r110 = true;
        goto L58
    L49:
        if (r18.length() == 0) goto L52;
        r19 = false;
    L190:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        Lazy r166 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.b.e.b, "ECMallDataEngineWrapper#convertCategoryTabType, convert failed, error = " + th);
    L195:
        r55 = false;
        goto L196
    L21:
        if (r34 == false) goto L24;
        ECMallDeliveryReduceConfig r167 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        Intrinsics.checkNotNullParameter(new LinkedHashMap(), "deliveryParams");
        goto L25
    L24:
        if (Intrinsics.areEqual(null, 1) == false) goto L25;
        HomePageBffDTO r168 = r32.getBff();
        if (r168 == null) goto L41;
        ECHybridListDTO r169 = r168.getFeed();
        ECHybridListDTO r170 = r168.getFeed();
        if (r170 == null) goto L40;
        List r171 = r170.getSections();
        if (r171 == null) goto L40;
        ArrayList r172 = new ArrayList();
        Iterator r173 = r171.iterator();
    L34:
        if (r173.hasNext() == false) goto L38;
        Object r174 = r173.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r174).getSectionId(), "multi_in_one_section") == false) goto L34;
        r172.add(r174);
        goto L34
    L38:
        if (r169 == null) goto L40;
        r169.setSections(r172);
    L40:
        HomePageBffDTO r175 = HomePageBffDTO.copy$default(r168, r169, null, r168.getPopup(), r168.getTopBar(), r168.getBizInfo(), r168.getDynamicParams(), r168.getBackground(), null, r168.getPendantWrapper(), r168.getExtra(), 130, null);
    L42:
        r0 = HomePageDTO.copy$default(r32, r175, r32.getHasMore(), r32.getCursor(), r32.getStatusCode(), r32.getStatusMessage(), null, null, null, null, 480, null);
        goto L25
    L41:
        r175 = null;
        goto L42
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final String ZK(String r2, boolean r3, BcmParams r4) {
        Intrinsics.checkNotNullParameter(r2, "btm");
        return fa0(r2, r3, r4);
    }

    public final void aa0(List<String> r21, boolean r22, final Function1<? super Boolean, Unit> r23) {
        Lazy r1 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.b r2 = com.bytedance.android.ec.hybrid.log.mall.e.b.b;
        ECMallLogUtil.c(r2, "ECMallFragment#firstScreenFetch()@" + hashCode());
        Lazy r3 = HybridAppInfoService.a;
        boolean r4 = HybridAppInfoService.l();
        int r5 = s93.c.a;
        Object r6 = Integer.valueOf(r4 ? 1 : 0);
        IHybridHostService r7 = com.bytedance.android.ec.hybrid.a.h();
        if (r7 == null) goto L10;
        yj.g r8 = r7.getHostAB();
        if (r8 == null) goto L10;
        Object r9 = r8.a("na_mall_api_dispatch_opt", r6);
        if (r9 == null) goto L10;
        r6 = r9;
    L10:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : na_mall_api_dispatch_opt, Value: " + r6);
        int r10 = ((Number) r6).intValue();
        if (r10 <= 0) goto L13;
        boolean r11 = true;
    L15:
        if (this.S1 == false) goto L18;
        r23.invoke(Boolean.TRUE);
        ECMallLogUtil.c(r2, "ECMallFragment#firstScreenFetch@" + hashCode() + ", return because is requesting");
        return;
    L18:
        this.S1 = true;
        if (((Number) this.b4.getValue()).longValue() <= 0) goto L21;
        this.P1.postDelayed(this.c4, ((Number) this.b4.getValue()).longValue());
    L21:
        DataEngineWrapper r12 = this.L0;
        if (r12 == null) goto L24;
        r12.t(System.currentTimeMillis());
    L24:
        DataEngineWrapper r13 = this.L0;
        if (r13 != null) goto L27;
    L28:
        DataEngineWrapper r14 = this.L0;
        if (r14 == null) goto L32;
        r14.J();
    L32:
        if (this.H2 == false) goto L36;
        DataEngineWrapper r15 = this.L0;
        if (r15 == null) goto L36;
        r15.I();
    L36:
        com.bytedance.android.shopping.mall.homepage.tools.l r16 = new com.bytedance.android.shopping.mall.homepage.tools.l();
        this.Z2 = r16;
        final boolean r17 = !Intrinsics.areEqual(r16, null);
        this.L = null;
        this.X2 = null;
        HomepageChunkedCallback r18 = new HomepageChunkedCallback(new HomepageChunkedCallback.b(new ECMallFragment$firstScreenFetch$1(this), new ECMallFragment$firstScreenFetch$2(this), r17, this.L0, new ECMallFragment$firstScreenFetch$3(this), new ECMallFragment$firstScreenFetch$4(this, r23), new ECMallFragment$firstScreenFetch$5(this, r17), new ECMallFragment$firstScreenFetch$6(this, r23), new ECMallFragment$firstScreenFetch$7(this)));
        Intrinsics.checkNotNullParameter(r18, "callback");
        ECMallLogUtil.c(r2, "ECHybridChunkedDataProcessor#addCallback()@" + r16.hashCode() + ", start");
        CopyOnWriteArrayList r19 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).a;
        monitor-enter(r19);
        ECMallLogUtil.c(r2, "ECHybridChunkedDataProcessor#addCallback()@" + r16.hashCode() + ", currentDataListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r16).a.size() + ", currentCallbackListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r16).b.size() + ", isFinished = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r16).c + ", isSuccess = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r16).d);     // Catch: Throwable -> L76
        Iterator r0 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).a.iterator();     // Catch: Throwable -> L76
    L40:
        if (r0.hasNext() == false) goto L46;
        Pair r20 = (Pair) r0.next();     // Catch: Throwable -> L76
        String r24 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).e;     // Catch: Throwable -> L76
        if (r24 != null) goto L44;
        r24 = "";
    L44:
        r18.c(r24, ((com.bytedance.android.ec.hybrid.data.utils.a) r16).f, (String) r20.getFirst(), r20.getSecond());     // Catch: Throwable -> L76
        goto L40
    L46:
        if (((com.bytedance.android.ec.hybrid.data.utils.a) r16).c == true) goto L48;
        ((com.bytedance.android.ec.hybrid.data.utils.a) r16).b.add(r18);     // Catch: Throwable -> L76
    L65:
        monitor-exit(r19);
        Lazy r25 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#addCallback()@" + r16.hashCode() + ", end");
        Unit r26 = Unit.INSTANCE;
        this.Y2 = r18;
        Lazy r27 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.b r28 = com.bytedance.android.ec.hybrid.log.mall.e.b.b;
        ECMallLogUtil.c(r28, "ECMallFragment#firstScreenFetch@" + hashCode() + ", start prefetch, shouldNotifyHomepageChunkedDataProcessor = " + r17);
        ECHybridDataEngine r110 = this.P0;
        if (r110 == null) goto L84;
        ECMallFragment$firstScreenFetch$9 r111 = new ECMallFragment$firstScreenFetch$9(this, r17, r16, r11, r23, r10, r22);
        Lazy r29 = ECHybridDataEngine.q;
        Intrinsics.checkNotNullParameter(r111, "callback");
        List r112 = r110.r();
        if (r112 != null) goto L72;
        ECMallLogUtil.b(r28, "ECHybridDataEngine#prefetch(), return because firstScreenKeyList is null, chunkedKeys = " + r21);
        return;
    L72:
        if (Intrinsics.areEqual(null, Boolean.TRUE) == true) goto L86;
        r110.p.e(r112, r21, r111, false, null);
        return;
    L86:
        return;
    L84:
        return;
    L48:
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.data.utils.a) r16).d, Boolean.TRUE) == false) goto L57;
        String r30 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).e;     // Catch: Throwable -> L76
        if (r30 != null) goto L52;
        r30 = "";
    L52:
        CopyOnWriteArrayList r31 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).a;     // Catch: Throwable -> L76
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));     // Catch: Throwable -> L76
        Iterator r33 = r31.iterator();     // Catch: Throwable -> L76
    L54:
        if (r33.hasNext() == false) goto L56;
        r32.add(((Pair) r33.next()).getSecond());     // Catch: Throwable -> L76
        goto L54
    L56:
        r18.a(r30, r16.c(r32));     // Catch: Throwable -> L76
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L76
        goto L65
    L57:
        String r35 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).e;     // Catch: Throwable -> L76
        if (r35 != null) goto L60;
        r35 = "";
    L60:
        ECHybridNetworkVO r36 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).f;     // Catch: Throwable -> L76
        Throwable r37 = ((com.bytedance.android.ec.hybrid.data.utils.a) r16).g;     // Catch: Throwable -> L76
        if (r37 != null) goto L63;
        r37 = new Throwable();     // Catch: Throwable -> L76
    L63:
        r18.b(r35, r36, r37);     // Catch: Throwable -> L76
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        throw th;
    L27:
        if (r13.s == true) goto L32;
    L13:
        r11 = false;
        goto L15
    }

    public final void ba0(String r9, Throwable r10, Function1<? super Boolean, Unit> r11) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "firstScreenFetchOnError " + r9 + " , message is " + r10.getMessage());
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r9, this.k) == false) goto L265;
        this.R3 = false;
        this.I2 = true;
        this.J2 = true;
        this.p0.getClass();
        ECHybridListEngine r1 = this.H0;
        if (r1 == null) goto L12;
        ECHybridListAdapter r2 = r1.a;
        if (r2 == null) goto L12;
        String r3 = r2.o;
    L13:
        boolean r4 = Intrinsics.areEqual(r3, "reduce");
        if (r4 == true) goto L29;
        ECHybridListEngine r5 = this.H0;
        if (r5 == null) goto L18;
        com.bytedance.android.ec.hybrid.list.entity.k r6 = r5.c.g;
    L19:
        if (r6 == null) goto L21;
    L23:
        ECHybridListEngine r7 = this.H0;
        if (r7 == null) goto L26;
        com.bytedance.android.ec.hybrid.list.entity.k r8 = r7.c.g;
    L27:
        if (r8 == null) goto L30;
        this.J2 = false;
    L30:
        Qa0();
        if (this.e4 == true) goto L33;
    L201:
        boolean r12 = false;
    L202:
        if (r12 == false) goto L207;
        this.g4 = true;
        DataEngineWrapper r13 = this.L0;
        if (r13 == null) goto L206;
        r13.L(ECMallFragment$firstScreenFetchOnError$1.INSTANCE);
    L206:
        com.bytedance.android.shopping.api.mall.g.a.a(this, null, false, false, new ECMallFragment$firstScreenFetchOnError$2(this), 31);
    L241:
        r11.invoke(Boolean.FALSE);
        ECMallFeed r14 = this.f;
        if (r14 == null) goto L244;
        ECMallFeed.m0(r14, false, null, null, false, 24);
    L244:
        DataEngineWrapper r15 = this.L0;
        if (r15 == null) goto L247;
        r15.I();
    L247:
        int r16 = sf3.a.a;
        return;
    L207:
        ECHybridListEngine r17 = this.H0;
        if (r17 == null) goto L210;
        com.bytedance.android.ec.hybrid.list.entity.k r18 = r17.c.g;
    L211:
        if (r18 == null) goto L215;
        if (this.e4 == false) goto L241;
    L215:
        if ((r10 instanceof NativeMallApiException) == false) goto L219;
        DataEngineWrapper r19 = this.L0;
        if (r19 == null) goto L238;
        r19.s(System.currentTimeMillis(), Integer.valueOf(((NativeMallApiException) r10).getStatusCode()), r10.getMessage());
    L238:
        La0(2, null);
        if (this.J2 == false) goto L241;
        Oa0();
        goto L241
    L219:
        DataEngineWrapper r20 = this.L0;
        if (r20 == null) goto L238;
        long r21 = System.currentTimeMillis();
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L234
        Class r23 = S90("com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException");     // Catch: Throwable -> L234
        if (Intrinsics.areEqual(r10.getClass(), r23) == false) goto L229;
        Method r24 = r23.getDeclaredMethod("getStatusCode", new Class[0]);     // Catch: Throwable -> L234
        r24.setAccessible(true);     // Catch: Throwable -> L234
        Object r25 = r24.invoke(r10, new Object[0]);     // Catch: Throwable -> L234
        if ((r25 instanceof Integer) == true) goto L227;
        r25 = null;
    L227:
        Integer r26 = (Integer) r25;     // Catch: Throwable -> L234
    L253:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L232
    L237:
        r20.s(r21, r26, r10.getMessage());
    L232:
        Throwable th = th;
    L236:
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L237
    L229:
        r26 = null;
    L234:
        th = move-exception;
        th = th;
        r26 = null;
        goto L236
    L210:
        r18 = null;
        goto L211
    L33:
        if (this.g4 == true) goto L201;
        int r28 = com.bytedance.android.ec.base.settings.a.a;
        Object r29 = 0;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L189
        Object r31 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_network_error_retry_opt");     // Catch: Throwable -> L85
        if (r31 != null) goto L40;
    L82:
        Object r32 = null;
    L83:
        Object r33 = Result.constructor-impl(r32);     // Catch: Throwable -> L85
    L87:
        Throwable r34 = Result.exceptionOrNull-impl(r33);     // Catch: Throwable -> L189
        if (r34 == null) goto L91;
        EnsureManager.ensureNotReachHere(r34);     // Catch: Throwable -> L189
    L91:
        if (Result.isFailure-impl(r33) == false) goto L94;
        r33 = null;
    L94:
        if ((r33 instanceof Integer) == true) goto L96;
        r33 = null;
    L96:
        Object r35 = (Integer) r33;     // Catch: Throwable -> L189
        if (r35 != null) goto L103;
        Object r36 = com.bytedance.android.ec.base.settings.d.a.get("ec_mall_network_error_retry_opt");     // Catch: Throwable -> L189
        if ((r36 instanceof Integer) == true) goto L102;
        r36 = null;
    L102:
        r35 = (Integer) r36;     // Catch: Throwable -> L189
    L103:
        if (r35 != null) goto L199;
        int r37 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L189
        Object r38 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_network_error_retry_opt");     // Catch: Throwable -> L155
        if (r38 != null) goto L110;
    L152:
        Object r39 = null;
    L153:
        Object r40 = Result.constructor-impl(r39);     // Catch: Throwable -> L155
    L157:
        Throwable r41 = Result.exceptionOrNull-impl(r40);     // Catch: Throwable -> L180
        if (r41 == null) goto L161;
        EnsureManager.ensureNotReachHere(r41);     // Catch: Throwable -> L180
    L161:
        if (Result.isFailure-impl(r40) == false) goto L164;
        r40 = null;
    L164:
        if ((r40 instanceof Integer) == true) goto L166;
        r40 = null;
    L166:
        r35 = (Integer) r40;     // Catch: Throwable -> L180
        if (r35 != null) goto L187;
        IHybridHostService r42 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L180
        if (r42 == null) goto L172;
        Object r43 = r42.getHostABValue("ec_mall_network_error_retry_opt", r29);     // Catch: Throwable -> L180
    L173:
        if (r43 != null) goto L175;
    L186:
        r35 = r29;
        goto L187
    L175:
        if ((r43 instanceof Integer) == true) goto L177;
        r43 = null;
    L177:
        r35 = (Integer) r43;     // Catch: Throwable -> L180
        if (r35 != null) goto L187;
    L180:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L189
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
        Throwable r45 = Result.exceptionOrNull-impl(r35);     // Catch: Throwable -> L189
        if (r45 == null) goto L185;
        EnsureManager.ensureNotReachHere(r45);     // Catch: Throwable -> L189
    L185:
        if (Result.isFailure-impl(r35) == false) goto L187;
    L172:
        r43 = null;
    L187:
        com.bytedance.android.ec.base.settings.d.d("ec_mall_network_error_retry_opt", r35);     // Catch: Throwable -> L189
        goto L199
    L110:
        if ((r38 instanceof Integer) == true) goto L112;
        Object r46 = null;
    L113:
        r39 = (Integer) r46;     // Catch: Throwable -> L155
        if (r39 != null) goto L153;
        if ((r38 instanceof Number) == false) goto L140;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L125;
        Float r47 = Float.valueOf(((Number) r38).floatValue());     // Catch: Throwable -> L155
        if ((r47 instanceof Integer) == true) goto L123;
        r47 = null;
    L123:
        r39 = (Integer) r47;     // Catch: Throwable -> L155
        goto L153
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L131;
        Double r48 = Double.valueOf(((Number) r38).doubleValue());     // Catch: Throwable -> L155
        if ((r48 instanceof Integer) == true) goto L129;
        r48 = null;
    L129:
        r39 = (Integer) r48;     // Catch: Throwable -> L155
        goto L153
    L131:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L134;
        r39 = Integer.valueOf(((Number) r38).intValue());     // Catch: Throwable -> L155
        goto L153
    L134:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L140;
        Long r49 = Long.valueOf(((Number) r38).longValue());     // Catch: Throwable -> L155
        if ((r49 instanceof Integer) == true) goto L138;
        r49 = null;
    L138:
        r39 = (Integer) r49;     // Catch: Throwable -> L155
    L140:
        if ((r38 instanceof JSONObject) == false) goto L142;
    L251:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L148
        Object r50 = SDKSettingsCacheManager.a().fromJson(r38.toString(), Integer.class);     // Catch: Throwable -> L148
        if ((r50 instanceof Integer) == true) goto L146;
        r50 = null;
    L146:
        Object r51 = Result.constructor-impl((Integer) r50);     // Catch: Throwable -> L148
    L150:
        r39 = r51;
        if (Result.isFailure-impl(r39) == false) goto L153;
    L148:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L155
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L155
        goto L150
    L142:
        if ((r38 instanceof JSONArray) == false) goto L152;
    L112:
        r46 = r38;
    L155:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L180
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L199:
        if (((Number) r35).intValue() <= 0) goto L201;
        r12 = true;
        goto L202
    L40:
        if ((r31 instanceof Integer) == true) goto L42;
        Object r54 = null;
    L43:
        r32 = (Integer) r54;     // Catch: Throwable -> L85
        if (r32 != null) goto L83;
        if ((r31 instanceof Number) == false) goto L70;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L55;
        Float r55 = Float.valueOf(((Number) r31).floatValue());     // Catch: Throwable -> L85
        if ((r55 instanceof Integer) == true) goto L53;
        r55 = null;
    L53:
        r32 = (Integer) r55;     // Catch: Throwable -> L85
        goto L83
    L55:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L61;
        Double r56 = Double.valueOf(((Number) r31).doubleValue());     // Catch: Throwable -> L85
        if ((r56 instanceof Integer) == true) goto L59;
        r56 = null;
    L59:
        r32 = (Integer) r56;     // Catch: Throwable -> L85
        goto L83
    L61:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L64;
        r32 = Integer.valueOf(((Number) r31).intValue());     // Catch: Throwable -> L85
        goto L83
    L64:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L70;
        Long r57 = Long.valueOf(((Number) r31).longValue());     // Catch: Throwable -> L85
        if ((r57 instanceof Integer) == true) goto L68;
        r57 = null;
    L68:
        r32 = (Integer) r57;     // Catch: Throwable -> L85
    L70:
        if ((r31 instanceof JSONObject) == false) goto L72;
    L249:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L78
        Object r58 = SDKSettingsCacheManager.a().fromJson(r31.toString(), Integer.class);     // Catch: Throwable -> L78
        if ((r58 instanceof Integer) == true) goto L76;
        r58 = null;
    L76:
        Object r59 = Result.constructor-impl((Integer) r58);     // Catch: Throwable -> L78
    L80:
        r32 = r59;
        if (Result.isFailure-impl(r32) == false) goto L83;
    L78:
        th = move-exception;
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L85
        r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L85
        goto L80
    L72:
        if ((r31 instanceof JSONArray) == false) goto L82;
    L42:
        r54 = r31;
    L85:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L189
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
    L189:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        Object r63 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r64 = Result.exceptionOrNull-impl(r63);
        if (r64 == null) goto L194;
        EnsureManager.ensureNotReachHere(r64);
    L194:
        if (Result.isFailure-impl(r63) == true) goto L197;
        r29 = r63;
    L197:
        r35 = r29;
        goto L199
    L26:
        r8 = null;
        goto L27
    L21:
        if ((!Intrinsics.areEqual(this.K, Boolean.TRUE)) == false) goto L23;
    L18:
        r6 = null;
    L29:
        this.T3 = false;
        this.J2 = !pa0(true, r4);
    L12:
        r3 = null;
        goto L13
    }

    public final String fa0(String r2, boolean r3, BcmParams r4) {
        Intrinsics.checkNotNullParameter(r2, "btm");
        String r0 = (String) ((LinkedHashMap) this.p2).get(r2);
        if (r3 == true) goto L6;
        if (r0 == null) goto L6;
        return r0;
    L6:
        int r5 = f93.a.a;
        String r1 = f93.a.a(r2, false, getView(), r4);
        this.p2.put(r2, r1);
        return r1;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        DataEngineWrapper r0 = this.L0;
        if (r0 == null) goto L5;
        r0.L(AnonymousClass1.INSTANCE);
    L5:
        this.e.d(r4, r5, r6);
        if (((Boolean) this.E3.getValue()).booleanValue() == false) goto L8;
        int r1 = 2131564679;
    L9:
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L12;
        yj.f r3 = r2.getHybridECSdkService();
    L13:
        if (r3 != null) goto L23;
    L17:
        if (r3 == null) goto L21;
        r3.c(requireContext());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    L21:
        View r7 = r4.inflate(r1, r5, false);
        this.e.n(r4, r5, r6, r7);
        return r7;
    L23:
        r3.e(requireActivity());     // Catch: Exception -> L15
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r1 = 2131564678;
        goto L9
    }

    public static final void U90(ECMallFragment r7, String r8, Throwable r9, Function1 r10) {
        if (r7.isAdded() == true) goto L6;
        return;
    L6:
        if (r7.b2 == true) goto L8;
        Logger.d("puffone-NativeMallHomePage.onError()", "puffone-Gecko接收onError1111:" + r8);
        ((ArrayList) r7.h2).add(new com.bytedance.android.shopping.api.mall.common.tools.n(r8, null, r9, r10, 2));
        return;
    L8:
        Logger.d("puffone-NativeMallHomePage.onError()", "puffone-Gecko接收onError2222:" + r8);
        r7.ba0(r8, r9, r10);
    }

    public static void X90(final ECMallFragment r6, boolean r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r7 = true;
    L6:
        if ((r9 & 2) == 0) goto L8;
        String r0 = "";
    L10:
        if ((r9 & 4) == 0) goto L12;
        r8 = false;
    L12:
        r6.getClass();
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.g.a.b, "bindMallRealData start, needbind:" + r7 + ", reason:" + r0 + ", isFirstBindMallData:" + r6.z3);
        boolean r11 = r6.Ca0();
        ECMallFragment$bindMallRealData$$inlined$Runnable$1 r12 = new ECMallFragment$bindMallRealData$$inlined$Runnable$1(r6, r0);
        if (r8 == true) goto L15;
        r6.Q1.post(r12);
    L16:
        ECHybridDataEngine r13 = r6.P0;
        if (r13 == null) goto L49;
        ECHybridApiConfigDTO r14 = r13.p();
        if (r14 == null) goto L21;
        List r15 = r14.getFirstScreenKeyList();
    L22:
        if (r15 == null) goto L64;
        Iterator r16 = r15.iterator();
    L25:
        if (r16.hasNext() == false) goto L65;
        final String r1 = (String) r16.next();
        if (r11 == false) goto L32;
        if (Intrinsics.areEqual(r1, "marketing_resource_get") == false) goto L32;
        Logger.d("preMainOpt", "already handle marketing resource skip");
    L32:
        if (Intrinsics.areEqual(r1, r6.k) == true) goto L25;
        ECHybridDataEngine r3 = r6.P0;
        if (r3 == null) goto L37;
        final String r4 = r3.m(r1);
    L38:
        if (r4 != null) goto L40;
    L43:
        boolean r5 = true;
    L44:
        if (r5 == true) goto L45;
        r6.Q1.post(new ECMallFragment$handlePendingApis$1(r6, r1, r4));
        goto L25
    L45:
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "start fetch api on create: " + r1);
        ECHybridDataEngine r18 = r6.P0;
        if (r18 == null) goto L25;
        r18.i(r1, null, null, new ECMallFragment$fetchApisOnCreate$1(r6));
        goto L25
    L40:
        if (r4.length() == 0) goto L43;
        r5 = false;
        goto L44
    L37:
        r4 = null;
        goto L38
    L65:
        return;
    L64:
        return;
    L21:
        r15 = null;
        goto L22
    L49:
        return;
    L15:
        r12.run();
        goto L16
    L8:
        r0 = "handle_init_data";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Aa0(String r26, ECHybridNetworkVO r27, String r28, boolean r29) {
        if (Intrinsics.areEqual(r26, this.k) == false) goto L7;
        this.H2 = true;
        if (ja0() == null) goto L7;
        Unit r0 = Unit.INSTANCE;
    L7:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECMallFragment#initOrRefreshSucc()@" + hashCode() + ", start, apiKey = " + r26 + ", isRefresh = " + r29);
        if (r29 == false) goto L16;
        ECMallFeed r2 = this.f;
        if (r2 == null) goto L16;
        Iterator<T> r3 = r2.k1.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((e93.e) r3.next()).initOrRefresh(true, r2.R);
        goto L13
    L15:
        Unit r4 = Unit.INSTANCE;
    L16:
        this.I3 = false;
        this.J3 = false;
        this.L3 = false;
        ECMallFeed r5 = this.f;
        if (r5 == null) goto L20;
        r5.e0 = false;
        Unit r6 = Unit.INSTANCE;
    L20:
        if (this.d4 == true) goto L24;
        this.d4 = true;
        new com.bytedance.android.shopping.mall.homepage.a(this).run();
    L24:
        if (Intrinsics.areEqual(r26, this.k) == false) goto L438;
        this.J2 = false;
        if (r29 == true) goto L28;
        h r7 = new h(this);
    L47:
        if (r7 == null) goto L53;
        Lazy r8 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L51;
    L52:
        r7.run();
        h r9 = null;
    L54:
        DataEngineWrapper r10 = this.L0;
        if (r10 == null) goto L563;
        r10.L(ECMallFragment$initOrRefreshSucc$2.INSTANCE);
        Unit r11 = Unit.INSTANCE;
    L563:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L69
        HomePageDTO r13 = this.X2;     // Catch: Throwable -> L69
        if (r13 == null) goto L61;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "ECMallFragment#initOrRefresh()@" + hashCode() + ", get homepageDTO from chunkedHomepageDTO");     // Catch: Throwable -> L69
    L67:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L69
    L72:
        if (Result.isFailure-impl(r14) == false) goto L74;
        r14 = null;
    L74:
        HomePageDTO r15 = (HomePageDTO) r14;
        String r16 = "";
        if (r15 == null) goto L435;
        boolean r17 = isDarkMode();
        HomePageBffDTO r18 = r15.getBff();
        if (r17 == false) goto L82;
        if (r18 == null) goto L86;
        BackgroundWrapper r19 = r18.getBackground();
        if (r19 == null) goto L86;
        BackgroundInfo r20 = r19.getDark();
    L87:
        if (r20 == null) goto L89;
        r20.getBaseBgColor();
    L89:
        if (r20 == null) goto L92;
        r20.getHeaderBgUrl();
    L92:
        int r21 = s93.c.a;
        Object r22 = Boolean.FALSE;
        IHybridHostService r110 = com.bytedance.android.ec.hybrid.a.h();
        if (r110 == null) goto L100;
        yj.g r111 = r110.getHostAB();
        if (r111 == null) goto L100;
        Object r112 = r111.a(ECMallBackgroundGradientConfig.ENABLE_KEY, r22);
        if (r112 == null) goto L100;
        r22 = r112;
    L100:
        Lazy r113 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_gradient_background_enable, Value: " + r22);
        if (((Boolean) r22).booleanValue() == false) goto L119;
        if (r20 == null) goto L119;
        String r23 = r20.getBgGradientConfig();
        if (r23 == null) goto L119;
        if ((!StringsKt.isBlank(r23)) == true) goto L109;
        r23 = null;
    L109:
        if (r23 == null) goto L119;
        Gson r24 = com.bytedance.android.shopping.api.mall.common.tools.p.a;     // Catch: Throwable -> L112
        Object r25 = Result.constructor-impl((ECMallBackgroundGradientConfig) com.bytedance.android.shopping.api.mall.common.tools.p.a(r23, ECMallBackgroundGradientConfig.class));     // Catch: Throwable -> L112
    L115:
        if (Result.isFailure-impl(r25) == false) goto L117;
        r25 = null;
    L117:
        ECMallBackgroundGradientConfig r30 = (ECMallBackgroundGradientConfig) r25;
    L112:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L119:
        this.X2 = null;
        HomePageBffDTO r32 = r15.getBff();
        if (r32 == null) goto L125;
        BffBizInfo r33 = r32.getBizInfo();
        if (r33 == null) goto L125;
        String r34 = r33.getRequestId();
        if (r34 == null) goto L125;
    L126:
        int r35 = s93.c.a;
        Object r36 = 0;
        IHybridHostService r37 = com.bytedance.android.ec.hybrid.a.h();
        if (r37 == null) goto L134;
        yj.g r38 = r37.getHostAB();
        if (r38 == null) goto L134;
        Object r39 = r38.a("ec_mall_dynamic_api_params_opt", r36);
        if (r39 == null) goto L134;
        r36 = r39;
    L134:
        Lazy r40 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_dynamic_api_params_opt, Value: " + r36);
        if (((Number) r36).intValue() != 1) goto L141;
        HomePageBffDTO r41 = r15.getBff();
        if (r41 == null) goto L139;
        Map<String, ? extends Object> r42 = r41.getDynamicParams();
    L140:
        Map<String, ? extends Object> r114 = r42;
        boolean r43 = false;
    L142:
        Y90(r15, r43);
        DataEngineWrapper r44 = this.L0;
        if (r44 == null) goto L151;
        HomePageBffDTO r45 = r15.getBff();
        if (r45 == null) goto L149;
        BffBizInfo r46 = r45.getBizInfo();
        if (r46 == null) goto L149;
        Integer r47 = r46.getLoginStatus();
    L150:
        r44.G(r47);
        Unit r48 = Unit.INSTANCE;
    L149:
        r47 = null;
    L151:
        i r49 = new i(this, r15);
        ECMallFeed r50 = this.f;
        if (r50 == null) goto L160;
        HomePageBffDTO r115 = r15.getBff();
        if (r115 == null) goto L158;
        HomepageExtra r116 = r115.getExtra();
        if (r116 == null) goto L158;
        List<PreloadGeckoConfig> r117 = r116.getPreloadGeckoConfigList();
    L159:
        r50.h1 = r117;
    L158:
        r117 = null;
    L160:
        ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3 r51 = new ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3(this, r15, r29);
        if (r29 == true) goto L177;
        Lazy r118 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L177;
        if (ECMallConfigs.INSTANCE.getLegouPrefetchFlowOptEnable() == false) goto L177;
        DataEngineWrapper r119 = this.L0;
        if (r119 == null) goto L169;
        HomePageDTO r120 = r119.t;
    L171:
        if ((!Intrinsics.areEqual(r15, r120)) == false) goto L173;
        r49.run();
        Unit r52 = Unit.INSTANCE;
        r49 = null;
    L173:
        r51.run();
        Unit r53 = Unit.INSTANCE;
        if (r9 == null) goto L176;
        r9.run();
    L176:
        r9 = null;
        r51 = null;
        goto L177
    L169:
        r120 = null;
    L177:
        if (r9 == null) goto L179;
        r9.run();
        Unit r54 = Unit.INSTANCE;
    L179:
        ECMallFeed r55 = this.f;
        if (r55 == null) goto L213;
        HomePageBffDTO r121 = r15.getBff();
        if (r121 == null) goto L186;
        Map<String, Object> r122 = r121.getDynamicParams();
        if (r122 == null) goto L186;
        Object r123 = r122.get("post_back");
    L188:
        if ((r123 instanceof String) == true) goto L190;
        r123 = null;
    L190:
        String r124 = (String) r123;
        if (r55.x() == false) goto L193;
    L196:
        r55.q0();
        ECMallFeed.i r125 = r55.Y;
        Map<String, ? extends Object> r126 = r114;
        if (r125 == null) goto L199;
        r125.a(false);
    L199:
        if (r124 == null) goto L201;
        r55.G0 = ECMallFeed.T(r124);
    L201:
        Iterator r127 = ((ArrayList) r55.k1).iterator();
    L203:
        if (r127.hasNext() == false) goto L205;
        ((e93.e) r127.next()).onGylRefreshStart();
        goto L203
    L205:
        ECHybridListEngine r128 = r55.J;
        if (r128 == null) goto L210;
        ECHybridRecyclerView r129 = r128.b;
        if (r129 == null) goto L210;
        r129.post(new j0(r55));
    L210:
        if (r29 == false) goto L212;
        r55.c0(ErrorPageButtonAction.REFRESH, 5);
    L212:
        Unit r56 = Unit.INSTANCE;
    L214:
        Map<String, ? extends Object> r57 = r15.getServerTiming();
        if (r57 == null) goto L219;
        DataEngineWrapper r130 = this.L0;
        if (r130 == null) goto L219;
        r130.K(r57);
        Unit r58 = Unit.INSTANCE;
    L219:
        HomePageBffDTO r59 = r15.getBff();
        if (r59 == null) goto L224;
        BffBizInfo r60 = r59.getBizInfo();
        if (r60 == null) goto L224;
        String r61 = r60.getEcSceneId();
    L225:
        this.R = r61;
        IHybridHostService r62 = com.bytedance.android.ec.hybrid.a.h();
        if (r62 == null) goto L235;
        yj.g r63 = r62.getHostAB();
        if (r63 == null) goto L235;
        com.bytedance.android.ec.hybrid.data.i r64 = r63.k();
        if (r64 == null) goto L235;
        if (r64.b != true) goto L235;
        if (r49 == null) goto L235;
        r49.run();
        Unit r65 = Unit.INSTANCE;
    L235:
        MallGrayUtil r66 = (MallGrayUtil) this.M2.getValue();
        View r131 = getView();
        ViewGroup r210 = this.d.h();
        View r132 = getView();
        if (r132 == null) goto L238;
        View r211 = r132.findViewById(2131382099);
    L239:
        ViewGroup r212 = this.d.i();
        View r133 = getView();
        if (r133 == null) goto L242;
        View r213 = r133.findViewById(2131379187);
    L243:
        View r134 = getView();
        if (r134 == null) goto L246;
        View r214 = r134.findViewById(2131386360);
    L247:
        r66.c(r15, r29, new MallGrayUtil.b(r131, r210, r212, r211, r214, r213));
        if (r29 == false) goto L268;
        MallGrayUtil r67 = (MallGrayUtil) this.M2.getValue();
        r67.getClass();
        Intrinsics.checkNotNullParameter(r15, "home");
        if (MallGrayUtil.d((Boolean) r67.b.getValue()) == false) goto L268;
        HomePageBffDTO r68 = r15.getBff();
        if (r68 == null) goto L268;
        ECHybridListDTO r69 = r68.getFeed();
        if (r69 == null) goto L268;
        List r70 = r69.getSections();
        if (r70 == null) goto L268;
        Iterator r71 = r70.iterator();
    L259:
        if (r71.hasNext() == false) goto L268;
        ArrayList r72 = ((ECHybridListSectionDTO) r71.next()).getItems();
        if (r72 == null) goto L259;
        Iterator r73 = r72.iterator();
    L264:
        if (r73.hasNext() == false) goto L259;
        ECNAMallCardExtra r135 = ((ECHybridListItemDTO) r73.next()).getExtra();
        if (r135 == null) goto L264;
        r135.setGrayEnable(Boolean.FALSE);
    L268:
        Integer r74 = r15.getStatusCode();
        if (r74 == null) goto L271;
        int r75 = r74.intValue();
    L272:
        if (r75 != 0) goto L427;
        HomePageBffDTO r76 = r15.getBff();
        if (r76 == null) goto L276;
        ECHybridListDTO r77 = r76.getFeed();
    L277:
        if (r77 == null) goto L427;
        HomePageBffDTO r78 = r15.getBff();
        if (r78 == null) goto L284;
        ECHybridListDTO r79 = r78.getFeed();
        if (r79 == null) goto L284;
        List r80 = r79.getSections();
    L285:
        List r81 = r80;
        if (r81 != null) goto L288;
    L291:
        boolean r82 = true;
    L292:
        if (r82 == false) goto L294;
        int r84 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a(r26, "homepage->feed->sections data is null", r34, this.d.e);
    L294:
        this.x2 = true;
        HomePageBffDTO r85 = r15.getBff();
        if (r85 == null) goto L297;
        SingleCardData r86 = r85.getPopup();
    L298:
        if (r86 == null) goto L300;
        String r87 = r86.getLynxSchema();
    L301:
        if (r87 != null) goto L303;
    L306:
        boolean r88 = true;
    L307:
        if (r88 == true) goto L322;
        Lazy r89 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "initOrRefreshSucc, start handle popup");
        String r90 = r86.getLynxData();
        if (r90 == null) goto L312;
        r16 = r90;
    L312:
        Pair<String, String> r91 = new Pair(r87, r16);
        ECHybridListEngine r92 = this.H0;
        if (r92 == null) goto L315;
        com.bytedance.android.ec.hybrid.list.entity.k r94 = r92.c.g;
    L316:
        if (r94 != null) goto L318;
    L321:
        this.b1 = r91;
        goto L322
    L318:
        if (this.e4 == true) goto L321;
        va0(r91);
        goto L322
    L315:
        r94 = null;
    L322:
        HomePageBffDTO r95 = r15.getBff();
        if (r95 == null) goto L331;
        PendantWrapper r96 = r95.getPendantWrapper();
        if (r96 == null) goto L331;
        List<PendantData> r97 = r96.getData();
        if (r97 == null) goto L331;
        PendantData r98 = (PendantData) CollectionsKt.firstOrNull(r97);
        if (r98 == null) goto L331;
        String r99 = r98.getSchema();
    L332:
        if (r99 != null) goto L334;
    L337:
        boolean r100 = true;
    L338:
        if (r100 == true) goto L349;
        Lazy r101 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "initOrRefreshSucc, start handle pendant");
        ECHybridListEngine r102 = this.H0;
        if (r102 == null) goto L342;
        com.bytedance.android.ec.hybrid.list.entity.k r103 = r102.c.g;
    L343:
        if (r103 != null) goto L345;
    L348:
        this.g1 = r99;
        goto L349
    L345:
        if (this.e4 == true) goto L348;
        ua0(r99);
        goto L349
    L342:
        r103 = null;
    L349:
        if (r51 == null) goto L351;
        r51.run();
        Unit r104 = Unit.INSTANCE;
    L351:
        DataEngineWrapper r105 = this.L0;
        if (r105 == null) goto L354;
        r105.I();
        Unit r106 = Unit.INSTANCE;
    L354:
        ECHybridDataEngine r107 = this.P0;
        if (r107 == null) goto L357;
        String r108 = r107.m("douyin_skin");
    L358:
        if (r29 == true) goto L382;
        if (r108 != null) goto L361;
    L364:
        boolean r109 = true;
    L365:
        if (r109 == true) goto L382;
        this.f4 = true;
        DouyinSkin r136 = (DouyinSkin) GsonProtectorUtils.fromJson(new Gson(), r108, DouyinSkin.class);
        Integer r137 = r136.getStatusCode();
        if (r137 == null) goto L382;
        if (r137.intValue() != 0) goto L382;
        List<DouyinSkinConfig> r138 = r136.getData();
        if (r138 == null) goto L374;
        DouyinSkinConfig r139 = (DouyinSkinConfig) CollectionsKt.firstOrNull(r138);
    L375:
        ECFMiddleware r140 = this.d;
        if (r139 == null) goto L378;
        String r141 = r139.getConfig();
    L379:
        if (r139 == null) goto L381;
        r139.getConfigHashVal();
    L381:
        r140.o(r141, false);
        ra0(false);
        goto L382
    L378:
        r141 = null;
        goto L379
    L374:
        r139 = null;
        goto L375
    L361:
        if (r108.length() == 0) goto L364;
        r109 = false;
    L382:
        this.e.e(r26, r27, r28, r29, r15);
        if (((Boolean) this.d.w.getValue()).booleanValue() == false) goto L385;
        if (r29 == false) goto L385;
    L391:
        HomePageBffDTO r142 = r15.getBff();
        if (r142 == null) goto L400;
        ECHybridListDTO r143 = r142.getFeed();
        if (r143 == null) goto L400;
        Map r144 = r143.getExtra();
        if (r144 == null) goto L400;
        String r145 = (String) r144.get("session_id");
        if (r145 == null) goto L400;
        ECMallFavoriteSectionHelper r146 = ia0();
        r146.getClass();
        Intrinsics.checkNotNullParameter(r145, "id");
        r146.A = r145;
        ((LinkedHashMap) r146.b).clear();
        Unit r147 = Unit.INSTANCE;
    L400:
        ia0().H(r15, 1);
        HomePageBffDTO r148 = r15.getBff();
        if (r148 == null) goto L414;
        ECHybridListDTO r149 = r148.getFeed();
        if (r149 == null) goto L414;
        List r150 = r149.getSections();
        if (r150 == null) goto L414;
        Iterator r151 = r150.iterator();
    L408:
        if (r151.hasNext() == false) goto L412;
        Object r152 = r151.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r152).getSectionId(), "category_tab_section") == false) goto L408;
        Object r153 = r152;
    L413:
        ECHybridListSectionDTO r154 = (ECHybridListSectionDTO) r153;
    L415:
        if (r154 != null) goto L423;
        ECMallFeed r155 = this.f;
        if (r155 == null) goto L423;
        if (0 == null) goto L421;
        r155.k0(0);
    L421:
        Unit r156 = Unit.INSTANCE;
    L423:
        if (this.W2 == false) goto L425;
        if (r29 == true) goto L425;
    L426:
        this.e4 = false;
        Na0(Boolean.valueOf(com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin()));
        Map<String, ? extends Object> r157 = r126;
    L552:
        ECMallFeed r158 = this.f;
        if (r158 == null) goto L555;
        r158.S(r26, r28, r157);
        Unit r159 = Unit.INSTANCE;
    L555:
        Lazy r160 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECMallFragment#initOrRefreshSucc()@" + hashCode() + ", end, apiKey = " + r26 + ", isRefresh = " + r29);
        return;
    L425:
        W90(r28, r15);
        goto L426
    L412:
        r153 = null;
    L414:
        r154 = null;
    L385:
        int r161 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(this.d.b()) == true) goto L391;
        HomePageBffDTO r162 = r15.getBff();
        if (r162 == null) goto L391;
        r162.getBackground();
        goto L391
    L357:
        r108 = null;
        goto L358
    L334:
        if (r99.length() == 0) goto L337;
        r100 = false;
    L331:
        r99 = null;
        goto L332
    L303:
        if (r87.length() == 0) goto L306;
        r88 = false;
        goto L307
    L300:
        r87 = null;
        goto L301
    L297:
        r86 = null;
        goto L298
    L288:
        if (r81.isEmpty() == true) goto L291;
        r82 = false;
    L284:
        r80 = null;
        goto L285
    L276:
        r77 = null;
    L427:
        HomePageBffDTO r163 = r15.getBff();
        if (r163 == null) goto L430;
        ECHybridListDTO r164 = r163.getFeed();
    L431:
        if (r164 != null) goto L433;
        int r165 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a(r26, "homepage->feed->data is null", r34, this.d.e);
    L433:
        Integer r166 = r15.getStatusCode();
        Intrinsics.checkNotNull(r166);
        throw new NativeMallApiException(r166.intValue(), r15.getStatusMessage());
    L430:
        r164 = null;
        goto L431
    L271:
        r75 = 0;
        goto L272
    L246:
        r214 = null;
        goto L247
    L242:
        r213 = null;
        goto L243
    L238:
        r211 = null;
    L224:
        r61 = null;
        goto L225
    L193:
        if (r55.z() == true) goto L196;
        r126 = r114;
    L186:
        r123 = null;
        goto L188
    L213:
        r126 = r114;
        goto L214
    L139:
        r42 = null;
        goto L140
    L141:
        r43 = false;
        r114 = null;
    L125:
        r34 = "";
    L86:
        r20 = null;
        goto L87
    L82:
        if (r18 == null) goto L86;
        BackgroundWrapper r167 = r18.getBackground();
        if (r167 == null) goto L86;
        r20 = r167.getLight();
        goto L87
    L435:
        ia0().B.l = 4;
        int r168 = com.bytedance.android.shopping.api.mall.common.tools.j.a;
        com.bytedance.android.shopping.api.mall.common.tools.j.a(r26, "homepage data is null or parse error", "", this.d.e);
        throw new NativeMallApiException(-1, "homepage data is null");
    L61:
        DataEngineWrapper r169 = this.L0;     // Catch: Throwable -> L69
        if (r169 == null) goto L66;
        r13 = r169.t;     // Catch: Throwable -> L69
        if (r13 == null) goto L66;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "ECMallFragment#initOrRefresh()@" + hashCode() + ", get homepageDTO from prefetchedHomepageDTO");     // Catch: Throwable -> L69
    L66:
        r13 = (HomePageDTO) new Gson().fromJson(r28, HomePageDTO.class);     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L51:
        if (ECMallConfigs.INSTANCE.getLegouPrefetchFlowOptEnable() == false) goto L52;
    L53:
        r9 = r7;
        goto L54
    L28:
        if (r27 == null) goto L32;
        Map r171 = r27.b();
        if (r171 == null) goto L32;
        Object r172 = r171.get("tab_id");
    L34:
        if ((r172 instanceof Integer) == true) goto L36;
        r172 = null;
    L36:
        Integer r173 = (Integer) r172;
        ECMallFeed r174 = this.f;
        if (r174 == null) goto L39;
        Integer r175 = r174.R;
    L40:
        if (r173 == null) goto L46;
        if (r175 == null) goto L46;
        if ((!Intrinsics.areEqual(r173, r175)) == false) goto L46;
        ia0().B.l = 1;
        return;
    L46:
        r7 = null;
        goto L47
    L39:
        r175 = null;
    L32:
        r172 = null;
        goto L34
    L438:
        if (Intrinsics.areEqual(r26, "suggest_words") == false) goto L443;
        ECMFTopBarComponent r176 = this.e.d;
        if (r176 == null) goto L467;
        r176.s(r28);
        Unit r177 = Unit.INSTANCE;
    L467:
        Map<String, ? extends Object> r178 = null;
    L551:
        r157 = r178;
        goto L552
    L443:
        if (Intrinsics.areEqual(r26, "douyin_skin") == false) goto L465;
        if (r29 == false) goto L446;
    L448:
        DouyinSkin r179 = (DouyinSkin) GsonProtectorUtils.fromJson(new Gson(), r28, DouyinSkin.class);
        Integer r180 = r179.getStatusCode();
        if (r180 == null) goto L467;
        if (r180.intValue() != 0) goto L467;
        List<DouyinSkinConfig> r181 = r179.getData();
        if (r181 == null) goto L456;
        DouyinSkinConfig r182 = (DouyinSkinConfig) CollectionsKt.firstOrNull(r181);
    L457:
        ECFMiddleware r183 = this.d;
        if (r182 == null) goto L460;
        String r184 = r182.getConfig();
    L461:
        if (r182 == null) goto L463;
        r182.getConfigHashVal();
    L463:
        r183.o(r184, false);
        ra0(true);
        goto L467
    L460:
        r184 = null;
        goto L461
    L456:
        r182 = null;
        goto L457
    L446:
        if (this.f4 == false) goto L448;
        return;
    L465:
        if (Intrinsics.areEqual(r26, "marketing_resource_get") == false) goto L468;
        this.e.l(r28);
        goto L467
    L468:
        HomePageDTO r185 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r28, HomePageDTO.class);
        if (r185 == null) goto L473;
        Integer r186 = r185.getStatusCode();
        if (r186 == null) goto L473;
        int r187 = r186.intValue();
    L474:
        if (r187 < 0) goto L557;
        HomePageBffDTO r188 = r185.getBff();
        if (r188 == null) goto L478;
        ECHybridListDTO r189 = r188.getFeed();
    L480:
        if (this.J2 == true) goto L491;
        if (r189 == null) goto L491;
        if (this.H0 == null) goto L491;
        long r190 = System.currentTimeMillis();
        ECHybridListDTO.a r191 = ECHybridListDTO.Companion;
        HomePageBffDTO r192 = r185.getBff();
        if (r192 == null) goto L489;
        BffBizInfo r193 = r192.getBizInfo();
        if (r193 == null) goto L489;
        String r194 = r193.getEcSceneId();
    L490:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r195 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(-1, r194, 190);
        r191.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r196 = ECHybridListDTO.a.d(r189, false, r195);
        this.f3 = System.currentTimeMillis() - r190;
        ECHybridListEngine r197 = this.H0;
        Intrinsics.checkNotNull(r197);
        r197.r(r196);
        xa0();
    L489:
        r194 = null;
    L491:
        HomePageBffDTO r198 = r185.getBff();
        if (r198 == null) goto L494;
        SingleCardData r199 = r198.getPopup();
    L495:
        if (r199 == null) goto L541;
        this.v1 = true;
        String r200 = r199.getLynxData();
        if (r200 != null) goto L499;
    L502:
        boolean r1100 = true;
    L503:
        if (r1100 == true) goto L541;
        ECLynxCard r201 = this.k1;
        if (r201 != null) goto L507;
        ((ArrayList) this.h1).add(r199.getLynxData());
    L508:
        Logger.e("xkf1024", "update pageCard " + System.currentTimeMillis());
        this.e.f(r185);
        Result.Companion r202 = Result.Companion;     // Catch: Throwable -> L511
        Object r203 = Result.constructor-impl((Map) com.bytedance.android.shopping.api.mall.common.tools.p.b().fromJson(r199.getLynxData(), Map.class));     // Catch: Throwable -> L511
    L513:
        Object r204 = r203;
        if (Result.isFailure-impl(r204) == false) goto L516;
        r204 = null;
    L516:
        Map r205 = (Map) r204;
        if (r205 == null) goto L519;
        Object r206 = r205.get("popup_get_popups");
    L521:
        if ((r206 instanceof List) == true) goto L523;
        r206 = null;
    L523:
        List r207 = (List) r206;
        if (r207 == null) goto L526;
        Integer r208 = Integer.valueOf(r207.size());
    L527:
        if (r208 == null) goto L539;
        Object r209 = r205.get("popup_get_popups");
        if ((r209 instanceof List) == true) goto L531;
        r209 = null;
    L531:
        List r215 = (List) r209;
        if (r215 == null) goto L534;
        Integer r216 = Integer.valueOf(r215.size());
    L535:
        Intrinsics.checkNotNull(r216);
        if (r216.intValue() <= 0) goto L539;
        this.x1 = false;
        goto L539
    L534:
        r216 = null;
    L539:
        if (this.p1 == null) goto L541;
        r178 = null;
        ua0(null);
    L542:
        ECMFTopBarComponent r217 = this.e.d;
        if (r217 == null) goto L551;
        HomePageBffDTO r218 = r185.getBff();
        if (r218 == null) goto L549;
        SingleCardData r219 = r218.getTopBar();
        if (r219 == null) goto L549;
        String r220 = r219.getLynxData();
    L550:
        r217.x(r220);
        Unit r221 = Unit.INSTANCE;
    L549:
        r220 = r178;
        goto L550
    L526:
        r208 = null;
        goto L527
    L519:
        r206 = null;
    L511:
        th = move-exception;
        Result.Companion r222 = Result.Companion;
        r203 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L513
    L507:
        int r223 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r201.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r200), true);
        goto L508
    L499:
        if (r200.length() == 0) goto L502;
        r1100 = false;
    L541:
        r178 = null;
        goto L542
    L494:
        r199 = null;
        goto L495
    L478:
        r189 = null;
        goto L480
    L557:
        Intrinsics.checkNotNull(r185);
        Integer r224 = r185.getStatusCode();
        Intrinsics.checkNotNull(r224);
        throw new NativeMallApiException(r224.intValue(), r185.getStatusMessage());
    L473:
        r187 = 0;
        goto L474
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
    public final void R60(final String r11, final String r12, final Function0<Unit> r13, final Function1<? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        com.bytedance.android.shopping.api.mall.common.tools.h r0 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        if (r0.getIHybridHostUserService().isLogin() == false) goto L6;
        if (r13 == null) goto L22;
        Unit r15 = (Unit) r13.invoke();
        return;
    L22:
        return;
    L6:
        Fragment r1 = getParentFragment();
        if (r1 == null) goto L24;
        FragmentActivity r3 = r1.requireActivity();
        if (r3 == null) goto L25;
        yj.s r2 = r0.getIHybridHostUserService();
        Bundle r4 = new Bundle();
        String r5 = this.N3;
        if (r5 == null) goto L15;
        String r6 = b0.k(r5);
        if (r6 == null) goto L15;
        r4.putString("themeId", r6);
    L15:
        String r7 = this.O3;
        if (r7 == null) goto L20;
        String r8 = b0.k(r7);
        if (r8 == null) goto L20;
        r4.putString("loginDesc", r8);
    L20:
        Unit r9 = Unit.INSTANCE;
        r2.e(r3, r11, r12, new ECMallFragment$confirmLogin$$inlined$let$lambda$1(this, r11, r12, r13, r14), new ECMallFragment$confirmLogin$$inlined$let$lambda$2(this, r11, r12, r13, r14));
        return;
    L25:
        return;
    }

    public final void ca0(String r6, String r7, ECHybridNetworkVO r8, Function1 r9) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "first screen fetch on success ");
        if (isAdded() == true) goto L5;
        return;
    L5:
        int r1 = s93.c.a;
        Object r2 = 0;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L13;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L13;
        Object r5 = r4.a("ec_mall_immerse_opt", r2);
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_immerse_opt, Value: " + r2);
        if (((Number) r2).intValue() == 1) goto L33;
        String r10 = com.bytedance.android.shopping.mall.homepage.tools.q.a(requireContext(), ga0());
        IHybridHostService r11 = com.bytedance.android.ec.hybrid.a.h();
        if (r11 == null) goto L33;
        if (r11.forbidMallLoadInAbSchema() != true) goto L33;
        TextUtils.isEmpty(r10);
    L33:
        Aa0(r6, r8, r7, false);     // Catch: Throwable -> L30
        ECMallFeed r12 = this.f;
        if (r12 == null) goto L26;
        r12.N();
    L26:
        if (Intrinsics.areEqual(r6, this.k) == false) goto L28;
        r9.invoke(Boolean.TRUE);
        Qa0();
    L28:
        Logger.d("puffone-NativeCommerceHomePage.onSuccess()", "firstScreenFetch");
        return;
    L30:
        th = move-exception;
        ba0(r6, th, r9);
    }

    public final void da0(String r82, String r84, ECHybridNetworkVO r85, Function1 r86) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        ECHybridListEngine r1 = this.H0;
        if (r1 == null) goto L13;
        MallDrainageOpt r3 = (MallDrainageOpt) this.S.getValue();
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r1, "listEngine");
        if (Intrinsics.areEqual(r3.a, "1") == false) goto L13;
        r3.a(r1);
    L13:
        if (Intrinsics.areEqual(r82, this.k) == false) goto L33;
        ECHybridListEngine r2 = this.H0;
        if (r2 == null) goto L17;
        com.bytedance.android.ec.hybrid.list.entity.k r4 = r2.c.g;
    L18:
        if (r4 == null) goto L22;
        if (this.e4 == false) goto L33;
    L22:
        if (Intrinsics.areEqual(r84, this.Q) == false) goto L28;
        DataEngineWrapper r5 = this.L0;
        if (r5 == null) goto L33;
        long r6 = System.currentTimeMillis();
        if (r5.b.i() != null) goto L33;
        r5.b = y93.a.a(r5.b, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r6), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -16777217, -1, -1, -1, 127);
        goto L33
    L28:
        DataEngineWrapper r7 = this.L0;
        if (r7 == null) goto L33;
        r7.r(System.currentTimeMillis());
        goto L33
    L17:
        r4 = null;
    L33:
        if (this.b2 == true) goto L35;
        Logger.d("puffone-NativeMallHomePage.onSuccess()", "puffone-Gecko接收onSuc1111:" + r82);
        ((ArrayList) this.h2).add(new com.bytedance.android.shopping.api.mall.common.tools.n(r82, r84, null, r86, 4));
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "init gecko not finish yet, holding first screen data");
        return;
    L35:
        Logger.d("puffone-NativeMallHomePage.onSuccess()", "puffone-Gecko接收onSuc2222:" + r82);
        ca0(r82, r84, r85, r86);
    }

    public static final View T90(ECMallFragment r4, String r5, Integer r6, String r7, String r8) {
        r4.getClass();
        if (r5 == null) goto L65;
        boolean r1 = true;
        if (r7 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L21;
        ECHybridListEngine r9 = r4.H0;
        if (r9 == null) goto L16;
        BaseViewHolder r10 = r9.e(r5, r7);
    L17:
        if (r10 == null) goto L19;
        View r11 = ((RecyclerView.ViewHolder) r10).itemView;
    L20:
        Pair r12 = TuplesKt.to(r10, r11);
    L33:
        BaseViewHolder r13 = (BaseViewHolder) r12.component1();
        View r14 = (View) r12.component2();
        if (r8 != null) goto L36;
    L47:
        if (r8 != null) goto L49;
    L56:
        if (r14 == null) goto L60;
        View r0 = t93.a.a(r14, ECMallFragment$findViewForTransitionAnimation$targetView$1.INSTANCE);
        if (r0 == null) goto L60;
        return r0;
    L60:
        return r14;
    L49:
        if (r8.length() > 0) goto L52;
        r1 = false;
    L52:
        if (r1 == false) goto L56;
        if ((r13 instanceof HeaderCardViewHolder) == false) goto L56;
        return r13.k4(r8);
    L36:
        if (r8.length() <= 0) goto L38;
        boolean r15 = true;
    L39:
        if (r15 == false) goto L47;
        boolean r16 = r13 instanceof ECLynxCardHolder;
        if (r16 == false) goto L47;
        if (r16 == true) goto L44;
        r13 = null;
    L44:
        ECLynxCardHolder r17 = (ECLynxCardHolder) r13;
        if (r17 != null) goto L62;
        return null;
    L62:
        return r17.k4(r8);
    L38:
        r15 = false;
        goto L39
    L19:
        r11 = null;
        goto L20
    L16:
        r10 = null;
        goto L17
    L21:
        if (r6 != null) goto L23;
    L32:
        r12 = TuplesKt.to(null, null);
        goto L33
    L23:
        if (r6.intValue() < 0) goto L32;
        ECHybridListEngine r18 = r4.H0;
        if (r18 == null) goto L27;
        BaseViewHolder r19 = r18.g(r5, r6.intValue());
    L28:
        if (r19 == null) goto L30;
        View r20 = ((RecyclerView.ViewHolder) r19).itemView;
    L31:
        r12 = TuplesKt.to(r19, r20);
        goto L33
    L30:
        r20 = null;
        goto L31
    L27:
        r19 = null;
        goto L28
    L8:
        if (r7.length() == 0) goto L11;
        r3 = false;
        goto L12
    L65:
        return null;
    }

    public final void Ja0(List<String> r10, boolean r11, boolean r12, Map<String, ? extends Object> r13, Function1<? super Boolean, Unit> r14) {
        ECMallFeed r0 = this.f;
        if (r0 == null) goto L5;
        Map r1 = ECMallFeed.o(r0);
    L6:
        Map r3 = r1;
        if (r13 == null) goto L16;
        Set<String> r2 = r13.keySet();
        if (r2 == null) goto L16;
        Iterator<T> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        String r5 = (String) r4.next();
        Object r6 = r13.get(r5);
        if (r6 == null) goto L12;
        r3.put(r5, r6);
    L16:
        ECHybridDataEngine r7 = this.P0;
        if (r7 == null) goto L29;
        com.bytedance.android.shopping.mall.homepage.pagecard.d r8 = this.d.u;
        IECNativeHomeArgument r15 = ma0();
        if (r15 == null) goto L21;
        long r9 = r15.getPageCardDynamicParamTimeout();
    L22:
        DataEngineExtKt.a(r7, r8, r3, r9, r10, null, new t(this, r11, r12, r14));
        return;
    L21:
        r9 = 200;
        goto L22
    L29:
        return;
    L5:
        r1 = new LinkedHashMap();
        goto L6
    }

    @Override // com.bytedance.android.shopping.api.mall.g
    public final void TK(Map<String, ? extends Object> r9, boolean r10, boolean r11, boolean r12, boolean r13, final Function1<? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r9, "reportExtraParams");
        if (r12 == false) goto L15;
        SmartRefreshLayout r15 = this.V0;
        if (r15 != null) goto L7;
    L14:
        Function1<? super Boolean, Unit> r7 = new ECMallFragment$pageRequestRefresh$1(this, r14);
    L16:
        Ga0(null, false, r10, r11, r9, r13, r7);
        return;
    L7:
        if (r15.E2 == false) goto L9;
        int r0 = 0;
    L10:
        int r1 = r15.f;
        float r2 = (r15.y1 / 2.0f) + 0.5f;
        int r3 = r15.g1;
        float r4 = (r2 * r3) * 1.0f;
        if (r3 != 0) goto L13;
        r3 = 1;
    L13:
        r15.r(r0, r1, r4 / r3, true);
        goto L14
    L9:
        r0 = 400;
        goto L10
    L15:
        r7 = r14;
        goto L16
    }

    public final void Ga0(final List<String> r22, final boolean r23, final boolean r24, final boolean r25, final Map<String, ? extends Object> r26, final boolean r27, final Function1<? super Boolean, Unit> r28) {
        IECMallHomepageService r2 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r2 == null) goto L6;
        r2.notifyRefreshStart(this, r23);
    L6:
        if (this.k3 == false) goto L8;
    L15:
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "pageRequestRefresh");
        this.K2 = r27;
        final Function1<Boolean, Unit> r7 = new ECMallFragment$pageRequestRefreshInternal$fetchResultCallback$1(this, r28, r23);
        Function0<Unit> r10 = new ECMallFragment$pageRequestRefreshInternal$initDataFailCallback$1(this, r28, r23);
        ECMallFeed r0 = this.f;
        if (r0 == null) goto L18;
        int r1 = r0.M;
    L19:
        if (r1 <= 0) goto L21;
        ya0(new ECMallFragment$pageRequestRefreshInternal$1(this, r22, r24, r25, r26, r27, r7), r10);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("negfeedback_hide_notification", System.currentTimeMillis(), oa0(), false, MapsKt.mapOf(TuplesKt.to("triggerBy", 1)), false, 32));
        return;
    L21:
        ya0(new ECMallFragment$pageRequestRefreshInternal$2(this, r7), r10);
        return;
    L18:
        r1 = 0;
        goto L19
    L8:
        if (this.o3 == false) goto L15;
        if (r28 == null) goto L11;
        Unit r4 = (Unit) r28.invoke(Boolean.TRUE);
    L11:
        IECMallHomepageService r5 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r5 == null) goto L23;
        r5.notifyRefreshEnd(this, r23, true);
        return;
    }

    public final ECLynxCard IW(ViewGroup r7, String r8, String r9, Map r10, ViewGroup.LayoutParams r11, IECLynxCardLifeCycle r12, Map r13) {
        Intrinsics.checkNotNullParameter(r7, "viewGroup");
        Intrinsics.checkNotNullParameter(r8, "schema");
        ECLynxCard r0 = new ECLynxCard();
        Map r1 = MapsKt.emptyMap();
        IECLynxCardLifeCycle r2 = null;
        if (r12 != null) goto L6;
        r12 = new rj.a(null, 3);
    L6:
        if ((r12 instanceof rj.a) == false) goto L9;
        r2 = r12;
    L9:
        rj.a r3 = (rj.a) r2;
        if (r3 == null) goto L12;
        r3.b = r0;
    L12:
        ECLynxLoadParam.a r4 = new ECLynxLoadParam.a(r7.getContext(), getLifecycle(), r7, ECMallGeckoResourceHelper.a(r8));
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        r4.j = r9;
        r4.g(this.d.e());
        r4.i = getLifecycle();
        r4.j(10000);
        r4.e(r1);
        r4.a(Ba0(r8));
        r4.q = this.d.d();
        r4.t = b0.f();
        r4.b(this.d.l());
        Intrinsics.checkNotNullParameter(r11, "ecLayoutParams");
        r4.u = r11;
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        r4.o = r12;
        r4.i(ka0(this));
        Map r14 = MallUtil.a(r0, r13);
        Intrinsics.checkNotNullParameter(r14, "ecBridgeMap");
        r4.r = r14;
        r4.h(oa0());
        ECLynxBuildUtilKt.a(r4, new uj.a(this.d.e(), oa0()));
        if (r10 == null) goto L18;
        Intrinsics.checkNotNullParameter(r10, "appendData");
        r4.m = r10;
    L18:
        r0.j(new ECLynxLoadParam(r4));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Ha0(ECMallFragment r8, List r9, boolean r10, boolean r11, Map r12, boolean r13, Function1 r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r15 & 16) == 0) goto L9;
        r12 = new LinkedHashMap();
    L9:
        Map r5 = r12;
        if ((r15 & 32) == 0) goto L12;
        boolean r6 = false;
    L14:
        if ((r15 & 64) == 0) goto L16;
        r14 = null;
    L16:
        r8.Ga0(r9, r10, r3, false, r5, r6, r14);
        return;
    L12:
        r6 = r13;
        goto L14
    L5:
        r3 = r11;
        goto L7
    }
}
