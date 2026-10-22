package com.bytedance.android.shopping.mall.feed;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridApiConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ListEngineOptConfig;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.util.LynxCardUtil;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallAdService;
import com.bytedance.android.shopping.api.mall.IECMallGeckoService;
import com.bytedance.android.shopping.api.mall.ILegouMallService;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.mall.homepage.model.NativeMallApiException;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.android.ui.ec.widget.loading.ECLoadMoreView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedComponent implements com.bytedance.android.shopping.api.mall.feed.d {
    public static final boolean H0 = false;
    public static final Lazy p0 = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public String D;
    public final Lazy E;
    public int F;
    public final List<String> G;
    public final List<String> H;
    public final Lazy I;
    public boolean J;
    public com.bytedance.android.shopping.api.mall.idl.b K;
    public volatile com.bytedance.android.shopping.mall.feed.help.p L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public long T;
    public boolean U;
    public boolean V;
    public Runnable W;
    public volatile List<Integer> X;
    public final Context Y;
    public final com.bytedance.android.shopping.api.mall.feed.b Z;
    public Integer a;
    public final Lazy b;
    public final Lazy c;
    public final com.bytedance.android.shopping.mall.homepage.pagecard.d d;
    public final Lazy e;
    public final ECMallFeed.e f;
    public final FeedContainerAbility g;
    public final ik.a h;
    public String i;
    public final List<com.bytedance.android.shopping.mall.feed.help.g> j;
    public final ECMallFeed k;
    public final com.bytedance.android.shopping.api.mall.feed.e k0;
    public final Lazy l;
    public final e m;
    public final h n;
    public DataEngineWrapper o;
    public final Lazy p;
    public boolean q;
    public Boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public long w;
    public Function0<Unit> x;
    public boolean y;
    public boolean z;

    public final class FeedContainerAbility implements ECMallFeed.f {
        public final Map<String, String> a;
        public final Lazy b;
        public final /* synthetic */ ECMallFeedComponent c;

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void BQ(Boolean r1) {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final mf3.a DE() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Hn(String r1) {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Hv() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean JQ() {
            return false;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Jb() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Fragment M() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void MT() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void P60(int r1) {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final AnchorPendantManager Pt() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean Q20() {
            return false;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void R60(String r1, String r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r1, "enterFrom");
            Intrinsics.checkNotNullParameter(r2, "enterMethod");
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final com.bytedance.android.shopping.mall.feed.help.q TN() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void VI() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Wr() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void YA() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void ap() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final com.bytedance.android.ec.hybrid.list.ability.c0 bX() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void bp() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void closePage() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final ViewGroup ex() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void fI() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void h10() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean hu() {
            return true;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean isAttached() {
            return true;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final jf3.e jF() {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void jO() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void lx() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Map<String, Object> oU() {
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final void sj() {
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final View yZ(String r1, String r2) {
            return null;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final com.bytedance.android.shopping.api.mall.idl.a Bi() {
            Integer r1 = null;
            if (((Boolean) MallSettings.c.getValue()).booleanValue() == false) goto L26;
            com.bytedance.android.shopping.api.mall.feed.b r0 = this.c.Z;
            if (r0.m == false) goto L26;
            com.bytedance.android.shopping.api.mall.idl.c r2 = r0.n;
            if (r2 != null) goto L9;
        L14:
            com.bytedance.android.shopping.api.mall.idl.a r3 = new com.bytedance.android.shopping.api.mall.idl.a(new com.bytedance.android.shopping.api.mall.idl.c(null));
            IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
            if (r4 == null) goto L21;
            yj.t r5 = r4.getHybridLynxHostService();
            if (r5 == null) goto L21;
            Integer r6 = r5.getSplitWidth();
            if (r6 == null) goto L21;
            float r7 = r6.intValue();
            Resources r8 = Resources.getSystem();
            r1 = Integer.valueOf((int) (r7 / WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density));
        L21:
            if (r1 != null) goto L23;
        L25:
            return r3;
        L23:
            if (r1.intValue() <= 0) goto L25;
            com.bytedance.android.shopping.api.mall.idl.c r9 = r3.a;
            r9.d = r1;
            r9.b = r1;
            goto L25
        L9:
            if (r2.d == null) goto L14;
            if (r2.b == null) goto L14;
            return new com.bytedance.android.shopping.api.mall.idl.a(r2);
        L26:
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final yj.e Pn() {
            yj.e r0 = this.c.k0.Pn();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return (c) this.b.getValue();
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final String ZJ() {
            return this.c.D;
        }

        public final View a() {
            if (ECMallFeedComponent.H0 == true) goto L7;
            return this.c.j();
        L7:
            if (this.c.j().isAttachedToWindow() == false) goto L10;
            return this.c.j();
        L10:
            return this.c.j().getRecyclerView();
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, Object> getGlobalProps() {
            return this.c.k0.getGlobalProps();
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Map<String, Object> getPageInfo() {
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final boolean isDarkMode() {
            return this.c.k0.isDarkMode();
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean kn() {
            return this.c.B;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final boolean n10() {
            return this.c.J;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final boolean oi() {
            return this.c.k0.oi();
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final LifecycleOwner s4() {
            return this.c.k0.s4();
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Map<String, Object> EA() {
            return MapsKt.emptyMap();
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Map<String, String> zH() {
            return MapsKt.emptyMap();
        }

        public FeedContainerAbility(ECMallFeedComponent r1) {
            this.c = r1;
            this.a = new LinkedHashMap();
            this.b = LazyKt.lazy(new ECMallFeedComponent$FeedContainerAbility$defaultLoadMoreContainer$2(this));
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final PageFinder N90(ECHybridRecyclerView r2) {
            Intrinsics.checkNotNullParameter(r2, "listView");
            Intrinsics.checkNotNullParameter(r2, "listView");
            return PageFinder.via(r2);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final String T80(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            return "";
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Vw(com.bytedance.android.shopping.mall.feed.help.g r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ((ArrayList) this.c.j).add(r2);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void u90(String r2) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "apiKey");
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final String AH(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "id");
            Intrinsics.checkNotNullParameter(r1, "id");
            return null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, Object> PN(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            return this.c.k0.PN(r2, r3);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void Q30(String r1, Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r1, "eventName");
            Intrinsics.checkNotNullParameter(r1, "eventName");
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final Map<String, String> Xj(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            return this.c.k0.Xj(r2, r3);
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final Map<String, Object> bI(Map<String, ? extends Object> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            int r1 = f93.a.a;
            View r2 = a();
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            return f93.a.b(r3, PageFinder.via(r2), r4);
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.e
        public final void jq(final Map<String, ? extends Object> r2, final Set<String> r3) {
            t93.a.c(new ECMallFeedComponent$FeedContainerAbility$updateGlobalProps$1(this, r2, r3));
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final String ZK(String r2, boolean r3, BcmParams r4) {
            Intrinsics.checkNotNullParameter(r2, "btm");
            if (r3 == false) goto L5;
        L9:
            int r5 = f93.a.a;
            String r6 = f93.a.a(r2, false, a(), r4);
            this.a.put(r2, r6);
            return r6;
        L5:
            if (this.a.containsKey(r2) == false) goto L9;
            String r7 = (String) ((LinkedHashMap) this.a).get(r2);
            if (r7 != null) goto L11;
            return "";
        L11:
            return r7;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void adThirdTrackReport(String r8, List<String> r9, Long r10, String r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r8, "trackLabel");
            Intrinsics.checkNotNullParameter(r8, "trackLabel");
            IECMallAdService r1 = (IECMallAdService) ServiceManager.get().getService(IECMallAdService.class);
            if (r1 == null) goto L6;
            r1.adThirdTrackReport(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void rL(String r6, String r7, String r8, Function0 r9, Function1 r10) {
            Intrinsics.checkNotNullParameter(r6, "bubbleComponentID");
            Intrinsics.checkNotNullParameter(r7, "bubbleIcon");
            Intrinsics.checkNotNullParameter(r8, "bubbleText");
            Intrinsics.checkNotNullParameter(r9, "onSuccess");
            Intrinsics.checkNotNullParameter(r10, "onFail");
            Intrinsics.checkNotNullParameter(r6, "bubbleComponentID");
            Intrinsics.checkNotNullParameter(r7, "bubbleIcon");
            Intrinsics.checkNotNullParameter(r8, "bubbleText");
            Intrinsics.checkNotNullParameter(r9, "onSuccess");
            Intrinsics.checkNotNullParameter(r10, "onFail");
        }

        @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.f
        public final void adReport(String r10, String r11, String r12, String r13, String r14, Map<String, ? extends Object> r15, String r16, String r17) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, "label");
            Intrinsics.checkNotNullParameter(r13, "creativeId");
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, "label");
            Intrinsics.checkNotNullParameter(r13, "creativeId");
            IECMallAdService r0 = (IECMallAdService) ServiceManager.get().getService(IECMallAdService.class);
            if (r0 == null) goto L6;
            r0.adReport(r10, r11, r12, r13, r14, r15, r16, r17);
            return;
        }
    }

    public final class a implements Consumer<Boolean> {
        public final /* synthetic */ ECMallFeedComponent a;

        public a(ECMallFeedComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            if (r6 == null) goto L31;
            r6.booleanValue();
            if (r6.booleanValue() == false) goto L12;
            ECMallFeedComponent r0 = this.a;
            Lazy r1 = ECMallFeedComponent.p0;
            mf3.a r2 = r0.m();
            if (r2 == null) goto L9;
            r2.onAppBackground();
        L9:
            Set r3 = kk.c.a;
            String r4 = this.a.Z.a;
            Function0<Unit> r7 = new ECMallFeedComponent$AppBackgroundStateConsumer$accept$1(this);
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r7, "action");
            Set r8 = kk.c.a;
            if (r8.contains(r4) == true) goto L15;
            r8.add(r4);
            r7.invoke();
        L15:
            ik.a r9 = this.a.h;
            boolean r10 = !r6.booleanValue();
            Iterator r11 = r9.a.iterator();
        L17:
            if (r11.hasNext() == false) goto L19;
            ((ik.b) r11.next()).d(r10);
            goto L17
        L19:
            IHybridHostService r12 = com.bytedance.android.ec.hybrid.a.h();
            if (r12 == null) goto L24;
            yj.i r13 = r12.getIHybridHostAppInfo();
            if (r13 == null) goto L24;
            Activity r14 = r13.a();
        L25:
            boolean r15 = Intrinsics.areEqual(r14, ECHybridExtensionsKt.a(this.a.Y));
            ECMallFeed r16 = this.a.k;
            boolean r17 = r6.booleanValue();
            r16.getClass();
            ILegouMallService r18 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
            String r19 = r16.B1.c;
            r18.d();
            if (r15 == false) goto L34;
            Iterator r20 = ((ArrayList) r16.k1).iterator();
        L29:
            if (r20.hasNext() == false) goto L35;
            ((e93.e) r20.next()).onEnterBackGround(r17);
            goto L29
        L35:
            return;
        L34:
            return;
        L24:
            r14 = null;
            goto L25
        L12:
            ECMallFeedComponent r21 = this.a;
            Lazy r22 = ECMallFeedComponent.p0;
            mf3.a r23 = r21.m();
            if (r23 == null) goto L15;
            r23.onAppForeground();
            goto L15
        }
    }

    public static final class b {
    }

    public final class c implements com.bytedance.android.shopping.api.mall.j {
        public final /* synthetic */ ECMallFeedComponent a;

        public final void a() {
        }

        public final ECLoadMoreView b() {
            ECLoadMoreView r6 = new ECLoadMoreView(this.a.Y, null, 0, 6, null);
            r6.setLayoutParams(new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.api.mall.common.tools.b0.c(56)));
            return r6;
        }

        public c(ECMallFeedComponent r1) {
            this.a = r1;
        }
    }

    public final class d implements ECHybridNetworkTask.a, yj.b {
        public final /* synthetic */ ECMallFeedComponent a;

        public final void b() {
        }

        public d(ECMallFeedComponent r1) {
            this.a = r1;
        }

        public final void h(String r3) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            if ((!Intrinsics.areEqual(r3, "homepage")) == true) goto L5;
        L7:
            DataEngineWrapper r4 = this.a.o;
            if (r4 == null) goto L11;
            r4.t(System.currentTimeMillis());
            return;
        L11:
            return;
        L5:
            if ((!Intrinsics.areEqual(r3, "favorite_feed")) == false) goto L7;
        }

        public static boolean g(HomePageDTO r6, com.bytedance.android.ec.hybrid.list.entity.k r7) {
            HomePageBffDTO r8 = r6.getBff();
            Object r1 = null;
            if (r8 == null) goto L16;
            ECHybridListDTO r9 = r8.getFeed();
            if (r9 == null) goto L16;
            List r10 = r9.getSections();
            if (r10 == null) goto L16;
            Iterator r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L14;
            Object r2 = r11.next();
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r2).getSectionId(), "title") == false) goto L10;
        L15:
            ECHybridListSectionDTO r3 = (ECHybridListSectionDTO) r2;
        L18:
            if (r3 == null) goto L20;
            boolean r4 = true;
        L21:
            ArrayList r12 = r7.c;
            if (r12 == null) goto L30;
            Iterator r13 = r12.iterator();
        L25:
            if (r13.hasNext() == false) goto L29;
            Object r5 = r13.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r5).a, "title") == false) goto L25;
            r1 = r5;
        L29:
            r1 = (com.bytedance.android.ec.hybrid.list.entity.i) r1;
        L30:
            if (r1 == null) goto L32;
            boolean r14 = true;
        L33:
            if (r4 != r14) goto L42;
            return true;
        L42:
            return false;
        L32:
            r14 = false;
            goto L33
        L20:
            r4 = false;
            goto L21
        L14:
            r2 = null;
        L16:
            r3 = null;
            goto L18
        }

        public static void i(d r10, String r11, com.bytedance.android.shopping.mall.feed.help.p r12) {
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "apiKey");
            Intrinsics.checkNotNullParameter(r12, "result");
            if ((!Intrinsics.areEqual(r11, "homepage")) == true) goto L5;
        L85:
            ECMallFeedComponent r2 = r10.a;     // Catch: Exception -> L78
            Lazy r4 = ECMallFeedComponent.p0;     // Catch: Exception -> L78
            r2.p();     // Catch: Exception -> L78
            ECMallFeedComponent r3 = r10.a;     // Catch: Exception -> L78
            String r5 = "initOrRefresh " + r11 + " network success at " + System.currentTimeMillis();     // Catch: Exception -> L78
            r3.getClass();     // Catch: Exception -> L78
            ECMallFeedComponent.o(r5);     // Catch: Exception -> L78
            ECMallFeedComponent r6 = r10.a;     // Catch: Exception -> L78
            h r7 = r6.n;     // Catch: Exception -> L78
            if (r6.A == false) goto L10;
            ECMallFeedState r8 = ECMallFeedState.REFRESH_DATA_PREPARED;     // Catch: Exception -> L78
        L11:
            r7.a(r8);     // Catch: Exception -> L78
            DataEngineWrapper r9 = r10.a.o;     // Catch: Exception -> L78
            if (r9 == null) goto L16;
            y93.a r13 = r9.b;     // Catch: Exception -> L78
            if (r13 == null) goto L16;
            Long r14 = r13.p();     // Catch: Exception -> L78
        L17:
            if (r14 == null) goto L21;
            DataEngineWrapper r15 = r10.a.o;     // Catch: Exception -> L78
            if (r15 == null) goto L21;
            r15.r(System.currentTimeMillis());     // Catch: Exception -> L78
        L21:
            HomePageDTO r16 = r12.b;     // Catch: Exception -> L78
            if (r16 != null) goto L24;
            r16 = (HomePageDTO) new Gson().fromJson(r12.a, HomePageDTO.class);     // Catch: Exception -> L78
        L24:
            HomePageDTO r17 = r16;
            String r18 = r10.a.Z.b;     // Catch: Exception -> L78
            if (r18 != null) goto L27;
        L30:
            boolean r19 = true;
        L31:
            if (r19 == true) goto L35;
            com.bytedance.android.shopping.mall.feed.help.h.a(r17, r18);     // Catch: Exception -> L78
        L35:
            if (r10.a.A == false) goto L37;
        L39:
            ECMallFeed r20 = r10.a.k;     // Catch: Exception -> L78
            String r21 = r12.a;     // Catch: Exception -> L78
            int r22 = ECMallFeed.I1;     // Catch: Exception -> L78
            r20.S(r11, r21, null);     // Catch: Exception -> L78
            r10.a.k.V.H(r17, 1);     // Catch: Exception -> L78
            HomePageBffDTO r23 = r17.getBff();     // Catch: Exception -> L78
            if (r23 == null) goto L44;
            BffBizInfo r24 = r23.getBizInfo();     // Catch: Exception -> L78
            if (r24 == null) goto L44;
            r10.a.D = r24.getEcSceneId();     // Catch: Exception -> L78
        L44:
            ECMallFeedComponent.i(r10.a, r17);     // Catch: Exception -> L78
            DataEngineWrapper r25 = r10.a.o;     // Catch: Exception -> L78
            if (r25 == null) goto L47;
            r25.p(System.currentTimeMillis());     // Catch: Exception -> L78
        L47:
            HomePageBffDTO r26 = r17.getBff();     // Catch: Exception -> L78
            if (r26 == null) goto L65;
            ECHybridListDTO r27 = r26.getFeed();     // Catch: Exception -> L78
            if (r27 == null) goto L65;
            List r28 = r27.getSections();     // Catch: Exception -> L78
            if (r28 == null) goto L65;
            Iterator r29 = r28.iterator();     // Catch: Exception -> L78
        L55:
            if (r29.hasNext() == false) goto L65;
            ECHybridListSectionDTO r30 = (ECHybridListSectionDTO) r29.next();     // Catch: Exception -> L78
            if (Intrinsics.areEqual(r30.getSectionId(), "favorite_section") == false) goto L55;
            DataEngineWrapper r31 = r10.a.o;     // Catch: Exception -> L78
            if (r31 == null) goto L55;
            ArrayList r32 = r30.getItems();     // Catch: Exception -> L78
            if (r32 == null) goto L63;
            int r33 = r32.size();     // Catch: Exception -> L78
        L64:
            r31.c(r33);     // Catch: Exception -> L78
            goto L55
        L63:
            r33 = 0;
        L65:
            com.bytedance.android.ec.hybrid.list.entity.k r34 = r12.d;     // Catch: Exception -> L78
            if (r34 != null) goto L68;
        L70:
            ECMallFeed.m0(r10.a.k, true, r17, null, true, 16);     // Catch: Exception -> L78
        L72:
            if (Intrinsics.areEqual(r11, "homepage") == false) goto L74;
            int r110 = sf3.a.a;     // Catch: Exception -> L78
            ECHybridListEngine r111 = r10.a.k.J;     // Catch: Exception -> L78
        L74:
            ECMallFeedComponent r112 = r10.a;     // Catch: Exception -> L78
            if (r112.C == false) goto L94;
            r112.B = true;     // Catch: Exception -> L78
            return;
        L94:
            return;
        L68:
            if (g(r17, r34) == false) goto L70;
            ECMallFeed.m0(r10.a.k, true, r17, r12.d, true, 16);     // Catch: Exception -> L78
            goto L72
        L37:
            if (Intrinsics.areEqual(r11, "homepage") == false) goto L39;
            String r35 = r10.a.n(r11);     // Catch: Exception -> L78
            Single.fromCallable(new r0(r10, r35, r17)).subscribeOn(Schedulers.io()).subscribe(new s0(r10, r11, r35), new t0(r10, r11, r35));     // Catch: Exception -> L78
            goto L39
        L27:
            if (StringsKt.isBlank(r18) == true) goto L30;
            r19 = false;
        L16:
            r14 = null;
            goto L17
        L10:
            r8 = ECMallFeedState.INIT_DATA_PREPARED;     // Catch: Exception -> L78
        L78:
            e = move-exception;
            ECMallFeedComponent r1 = r10.a;
            String r113 = "initOrRefresh " + r11 + " network failed at " + System.currentTimeMillis();
            Lazy r0 = ECMallFeedComponent.p0;
            r1.getClass();
            ECMallFeedComponent.o(r113);
            ECMallFeedComponent r114 = r10.a;
            h r115 = r114.n;
            if (r114.A == false) goto L82;
            ECMallFeedState r116 = ECMallFeedState.REFRESH_FAILED;
        L83:
            r115.a(r116);
            EnsureManager.ensureNotReachHere(e);
            return;
        L82:
            r116 = ECMallFeedState.INIT_FAILED;
            goto L83
        L5:
            if ((!Intrinsics.areEqual(r11, "favorite_feed")) == false) goto L85;
        }

        public final void a(long r3, long r5, com.bytedance.android.ec.hybrid.list.util.d r7) {
            Intrinsics.checkNotNullParameter(r7, "lynxLoadResult");
            if (Intrinsics.areEqual(r7.k, "cache") == false) goto L15;
            DataEngineWrapper r6 = this.a.o;
            if (r6 == null) goto L7;
            r6.w(r3);
        L7:
            DataEngineWrapper r4 = this.a.o;
            if (r4 == null) goto L10;
            r4.y(r7.d);
        L10:
            DataEngineWrapper r8 = this.a.o;
            if (r8 == null) goto L13;
            r8.x(r7.e);
        L13:
            this.a.p();
            return;
        L15:
            DataEngineWrapper r0 = this.a.o;
            if (r0 == null) goto L20;
            y93.a r1 = r0.b;
            if (r1 == null) goto L20;
            Long r2 = r1.j();
        L21:
            if (r2 != null) goto L28;
            DataEngineWrapper r9 = this.a.o;
            if (r9 == null) goto L25;
            r9.k(r3);
        L25:
            DataEngineWrapper r10 = this.a.o;
            if (r10 == null) goto L28;
            r10.o(r5);
        L28:
            DataEngineWrapper r11 = this.a.o;
            if (r11 == null) goto L31;
            Intrinsics.checkNotNullParameter(r7, "res");
            r11.f = r7;
        L31:
            this.a.getClass();
            ECMallFeedComponent.o("firstScreenRendered at " + r3);
            ECMallFeedComponent r12 = this.a;
            h r13 = r12.n;
            if (r12.A == false) goto L34;
            ECMallFeedState r14 = ECMallFeedState.REFRESH_SUCCESS;
        L35:
            r13.a(r14);
            ECMallFeedComponent r15 = this.a;
            if (r15.A == true) goto L38;
            r15.A = true;
        L38:
            r15.B = true;
            i r16 = (i) r15.E.getValue();
            ECHybridListEngine r17 = r16.b.k.J;
            if (r17 == null) goto L42;
            r17.b.T(new ECMallFeedComponent$LynxCardLoadStatusChecker$check$1(r16));
        L42:
            ECMallFeedComponent r18 = this.a;
            if (r18.R == true) goto L59;
            r18.R = true;
            com.bytedance.android.shopping.api.mall.feed.c r19 = r18.Z.f;
            if (r19 != null) goto L49;
            return;
        L49:
            if (r19.c == false) goto L61;
            ECMallFeedComponent.o("loadMore image prefetch triggered");
            ECHybridListEngine r20 = r18.k.J;
            if (r20 == null) goto L57;
            ECHybridListAdapter r21 = r20.a;
            if (r21 == null) goto L58;
            z0 r22 = new z0(r18, r19);
            Intrinsics.checkNotNullParameter(r22, "listener");
            ((ArrayList) r21.h).add(r22);
            return;
        L58:
            return;
        L57:
            return;
        L61:
            return;
        L59:
            return;
        L34:
            r14 = ECMallFeedState.INIT_SUCCESS;
        L20:
            r2 = null;
            goto L21
        }

        public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
            if (Intrinsics.areEqual(r1, "homepage") == false) goto L6;
            ((ArrayList) this.a.X).add(0);
            return;
        }

        public final void d(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            int r5 = com.bytedance.android.shopping.mall.feed.help.p.e;
            i(this, r1, com.bytedance.android.shopping.mall.feed.help.p.a.a(r2, this.a.Z.b));
        }

        public final void e(String r4, Throwable r5, ECHybridNetworkVO r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "apiKey");
            Intrinsics.checkNotNullParameter(r5, "t");
            String r8 = null;
            if ((r5 instanceof NativeMallApiException) == true) goto L5;
            r5 = null;
        L5:
            NativeMallApiException r9 = (NativeMallApiException) r5;
            DataEngineWrapper r10 = this.a.o;
            if (r10 == null) goto L14;
            long r0 = System.currentTimeMillis();
            if (r9 == null) goto L10;
            Integer r2 = Integer.valueOf(r9.getStatusCode());
        L11:
            if (r9 == null) goto L13;
            r8 = r9.getMessage();
        L13:
            r10.s(r0, r2, r8);
            goto L14
        L10:
            r2 = null;
        L14:
            ECMallFeedComponent r11 = this.a;
            String r12 = "initOrRefresh " + r4 + " network failed at " + System.currentTimeMillis();
            r11.getClass();
            ECMallFeedComponent.o(r12);
            ECMallFeedComponent r13 = this.a;
            h r14 = r13.n;
            if (r13.A == false) goto L17;
            ECMallFeedState r15 = ECMallFeedState.REFRESH_FAILED;
        L18:
            r14.a(r15);
            if (Intrinsics.areEqual(r4, "homepage") == false) goto L22;
            int r16 = sf3.a.a;
            ECHybridListEngine r17 = this.a.k.J;
            return;
        L22:
            return;
        L17:
            r15 = ECMallFeedState.INIT_FAILED;
            goto L18
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public final class e implements LifecycleObserver {
        public final Set<Disposable> a;
        public final /* synthetic */ ECMallFeedComponent b;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ECMallFeedComponent r0 = this.b;
            Lazy r1 = ECMallFeedComponent.p0;
            mf3.a r2 = r0.m();
            if (r2 == null) goto L5;
            r2.onDestroy();
        L5:
            int r3 = lk.b.a;
            Intrinsics.checkNotNullParameter(this.b.f.a, "sceneID");
            Iterator<T> r4 = this.a.iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            Disposable r5 = (Disposable) r4.next();
            if (r5.isDisposed() == true) goto L7;
            r5.dispose();
            goto L7
        L11:
            this.a.clear();
            ECBridgeMethodFinder.a r6 = ECBridgeMethodFinder.h;
            String r7 = this.b.f.a;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "sceneID");
            HashMap r8 = (HashMap) ((HashMap) ECBridgeMethodFinder.g.getValue()).remove(r7);
            if (r8 == null) goto L14;
            r8.clear();
        L14:
            ECEventCenter.b(this.b.f.a);
            this.b.k0.s4().getLifecycle().removeObserver(this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            ECMallFeedComponent r0 = this.b;
            if (r0.A == true) goto L5;
            return;
        L5:
            r0.J = false;
            mf3.a r1 = r0.m();
            if (r1 == null) goto L8;
            r1.a(false, false);
        L8:
            Iterator<T> r2 = this.b.j.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            ((com.bytedance.android.shopping.mall.feed.help.g) r2.next()).j(false);
            goto L10
        L12:
            ECMallFeedComponent r3 = this.b;
            if (r3.f.j == false) goto L17;
            ECHybridListEngine r4 = r3.k.J;
            if (r4 == null) goto L17;
            Intrinsics.checkNotNullParameter("page", "source");
            r4.b.R(false, false, false);
        L17:
            this.b.k.h0.a(false);
            this.b.k.O(false);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            ECMallFeedComponent r0 = this.b;
            if (r0.A == true) goto L5;
            return;
        L5:
            r0.J = true;
            mf3.a r1 = r0.m();
            if (r1 == null) goto L8;
            r1.a(true, false);
        L8:
            ECMallFeedComponent r2 = this.b;
            DataEngineWrapper r3 = r2.o;
            if (r3 == null) goto L18;
            y93.a r4 = r3.b;
            if (r4 == null) goto L18;
            if (r4.c != true) goto L18;
            Iterator<T> r5 = r2.j.iterator();
        L16:
            if (r5.hasNext() == false) goto L18;
            ((com.bytedance.android.shopping.mall.feed.help.g) r5.next()).j(true);
        L18:
            ECMallFeedComponent r6 = this.b;
            if (r6.f.j == false) goto L23;
            ECHybridListEngine r7 = r6.k.J;
            if (r7 == null) goto L23;
            Intrinsics.checkNotNullParameter("page", "source");
            r7.b.R(true, false, false);
        L23:
            this.b.k.h0.a(true);
            this.b.k.O(true);
        }

        public e(ECMallFeedComponent r1) {
            this.b = r1;
            this.a = new LinkedHashSet();
        }

        public final void a(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "disposable");
            if (r2.isDisposed() == false) goto L5;
            return;
        L5:
            this.a.add(r2);
        }
    }

    public final class f implements com.bytedance.android.shopping.mall.feed.help.j {
        public final /* synthetic */ ECMallFeedComponent a;

        @Override // com.bytedance.android.shopping.mall.feed.help.j
        public final void d(String r1, boolean r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r1, "fetchType");
            Intrinsics.checkNotNullParameter(r3, "apiKey");
        }

        @Override // com.bytedance.android.shopping.mall.feed.help.j
        public final void e(boolean r1) {
        }

        public f(ECMallFeedComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.mall.feed.help.j
        public final void c(List r2, int r3) {
            Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
            Intrinsics.checkNotNullParameter(r2, "apiKeyList");
            if (Intrinsics.areEqual(GYLFetchType.LOAD_MORE, GYLFetchType.LOAD_MORE) == false) goto L6;
            this.a.n.a(ECMallFeedState.LOADING_MORE);
            return;
        L6:
            if (Intrinsics.areEqual(GYLFetchType.LOAD_MORE, GYLFetchType.FETCH_BY_USER_BEHAVIOR) == false) goto L10;
            this.a.n.a(ECMallFeedState.LOAD_BY_USER_BEHAVIOR);
            return;
        }

        @Override // com.bytedance.android.shopping.mall.feed.help.j
        public final void f(String r1, boolean r2, HomePageDTO r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "fetchType");
            if (Intrinsics.areEqual(r1, GYLFetchType.LOAD_MORE) == false) goto L10;
            if (r2 == false) goto L8;
            this.a.n.a(ECMallFeedState.LOAD_MORE_SUCCESS);
            if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L16;
            this.a.n.a(ECMallFeedState.NO_MORE);
        L16:
            i r5 = (i) this.a.E.getValue();
            ECHybridListEngine r6 = r5.b.k.J;
            if (r6 == null) goto L21;
            r6.b.T(new ECMallFeedComponent$LynxCardLoadStatusChecker$check$1(r5));
            return;
        L21:
            return;
        L8:
            this.a.n.a(ECMallFeedState.LOAD_MORE_FAILED);
            goto L16
        L10:
            if (Intrinsics.areEqual(r1, GYLFetchType.FETCH_BY_USER_BEHAVIOR) == false) goto L16;
            if (r2 == false) goto L15;
            this.a.n.a(ECMallFeedState.LOAD_BY_USER_BEHAVIOR_SUCCESS);
            if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L16;
            this.a.n.a(ECMallFeedState.NO_MORE);
            goto L16
        L15:
            this.a.n.a(ECMallFeedState.LOAD_BY_USER_BEHAVIOR_FAILED);
            goto L16
        }
    }

    public final class g implements ECHybridNetworkTask.a {
        public final Long a;
        public final /* synthetic */ ECMallFeedComponent b;

        public static final class a<V> implements Callable {
            public final /* synthetic */ g a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ECMallFeedComponent$g$a$a, reason: collision with other inner class name */
            public static final class RunnableC0079a implements Runnable {
                public final /* synthetic */ a a;

                public RunnableC0079a(a r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a.b.L = null;     // Catch: Throwable -> L8
                    a r0 = this.a;     // Catch: Throwable -> L8
                    DataEngineWrapper r1 = r0.a.b.o;     // Catch: Throwable -> L8
                    if (r1 == null) goto L11;
                    ECHybridDataEngine r2 = r1.a;     // Catch: Throwable -> L8
                    if (r2 == null) goto L15;
                    r2.c(r0.c);     // Catch: Throwable -> L8
                    return;
                L15:
                    return;
                L11:
                    return;
                L8:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == true) goto L16;
                    throw th;
                }
            }

            public static final class b implements Runnable {
                public final /* synthetic */ a a;

                public b(a r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Runnable r0 = this.a.a.b.W;     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(g r1, String r2, String r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.util.concurrent.Callable
            public final Unit call() {
                HomePageDTO r0 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), this.b, HomePageDTO.class);
                if (r0 != null) goto L5;
                return null;
            L5:
                if (((Boolean) this.a.b.M.getValue()).booleanValue() == false) goto L7;
                ECMallFeedComponent r1 = this.a.b;
                int r2 = com.bytedance.android.shopping.mall.feed.help.p.e;
                r1.L = com.bytedance.android.shopping.mall.feed.help.p.a.a(this.b, r1.Z.b);
            L7:
                Long r3 = this.a.a;
                if (r3 == null) goto L10;
                r3.longValue();
                ECMallFeedComponent r4 = this.a.b;
                r4.W = new RunnableC0079a(this);
                t93.a.b().postDelayed(new b(this), this.a.a.longValue());
            L10:
                ECMallFeedComponent.i(this.a.b, r0);
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ g a;

            public b(g r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Unit r3 = (Unit) r2;
                ECMallFeedComponent r4 = this.a.b;
                Lazy r0 = ECMallFeedComponent.p0;
                r4.getClass();
                ECMallFeedComponent.o("trigger firstScreen image prefetch triggered");
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ g a;

            public c(g r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                ECMallFeedComponent r4 = this.a.b;
                Lazy r0 = ECMallFeedComponent.p0;
                r4.getClass();
                ECMallFeedComponent.o("trigger firstScreen image prefetch failed");
            }
        }

        public g(ECMallFeedComponent r1, Long r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
            if (Intrinsics.areEqual(r1, "homepage") == false) goto L6;
            ((ArrayList) this.b.X).add(0);
            return;
        }

        public final void d(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            Runnable r5 = this.b.W;
            if (r5 == null) goto L5;
            t93.a.b().removeCallbacks(r5);
        L5:
            ECMallFeedComponent r6 = this.b;
            r6.W = null;
            if (r6.v == true) goto L8;
        L10:
            Disposable r7 = Single.fromCallable(new a(this, r2, r1)).subscribeOn(Schedulers.io()).subscribe(new b(this), new c(this));
            this.b.m.a(r7);
            return;
        L8:
            if (((ArrayList) r6.G).contains(r1) == false) goto L10;
            int r8 = com.bytedance.android.shopping.mall.feed.help.p.e;
            com.bytedance.android.shopping.mall.feed.help.p r9 = com.bytedance.android.shopping.mall.feed.help.p.a.a(r2, this.b.Z.b);
            d.i(this.b.k(), r1, r9);
        }

        public final void e(String r3, Throwable r4, ECHybridNetworkVO r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "apiKey");
            Intrinsics.checkNotNullParameter(r4, "t");
            ECMallFeedComponent r0 = this.b;
            if (r0.v == true) goto L5;
        L7:
            this.b.H.add(r3);
            return;
        L5:
            if (r0.G.contains(r3) == false) goto L7;
            this.b.k().e(r3, r4, r5, r6);
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public final class h implements com.bytedance.android.shopping.api.mall.feed.f {
        public com.bytedance.android.shopping.api.mall.feed.f a;
        public final /* synthetic */ ECMallFeedComponent b;

        public h(ECMallFeedComponent r1) {
            this.b = r1;
            this.a = null;
        }

        @Override // com.bytedance.android.shopping.api.mall.feed.f
        public final void a(ECMallFeedState r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            this.b.getClass();
            ECMallFeedComponent.o("onFeedStateChanged, state = " + r5);
            switch(u0.a[r5.ordinal()]) {
                case 1: goto L22;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L8;
                case 6: goto L5;
                default: goto L25;
            };
        L5:
            ECMallFeedComponent r0 = this.b;
            r0.s = false;
            if (r0.V == false) goto L25;
            r0.s(1, null);
            goto L25
        L8:
            mf3.a r1 = this.b.m();
            if (r1 == null) goto L25;
            r1.onRefresh();
            goto L25
        L11:
            this.b.s(2, null);
            goto L25
        L12:
            this.b.s(1, null);
            mf3.a r2 = this.b.m();
            if (r2 == null) goto L15;
            r2.a(true, true);
        L15:
            ECHybridDataEngine.x.getClass();
            if (((Boolean) ECHybridDataEngine.r.getValue()).booleanValue() == false) goto L25;
            DataEngineWrapper r3 = this.b.o;
            if (r3 == null) goto L25;
            ECHybridDataEngine r4 = r3.a;
            if (r4 == null) goto L25;
            r4.v();
            goto L25
        L22:
            DataEngineWrapper r6 = this.b.o;
            if (r6 == null) goto L25;
            r6.u(System.currentTimeMillis());
        L25:
            com.bytedance.android.shopping.api.mall.feed.f r7 = this.a;
            if (r7 == null) goto L29;
            r7.a(r5);
            return;
        }
    }

    public final class i {
        public int a;
        public final /* synthetic */ ECMallFeedComponent b;

        public i(ECMallFeedComponent r1) {
            this.b = r1;
        }
    }

    public final class j implements com.bytedance.android.ec.hybrid.card.api.f {
        public final /* synthetic */ ECMallFeedComponent a;

        public j(ECMallFeedComponent r1) {
            this.a = r1;
        }

        public final ECLynxCard IW(ViewGroup r8, String r9, String r10, Map r11, ViewGroup.LayoutParams r12, IECLynxCardLifeCycle r13, Map r14) {
            Intrinsics.checkNotNullParameter(r8, "viewGroup");
            Intrinsics.checkNotNullParameter(r9, "schema");
            ECLynxCard r0 = new ECLynxCard();
            Map<String, Object> r1 = this.a.k0.getGlobalProps();
            Map r2 = null;
            if (r13 != null) goto L6;
            r13 = new rj.a(null, 3);
        L6:
            if ((r13 instanceof rj.a) == true) goto L8;
            IECLynxCardLifeCycle r3 = null;
        L9:
            rj.a r4 = (rj.a) r3;
            if (r4 == null) goto L12;
            r4.b = r0;
        L12:
            ECLynxLoadParam.a r5 = new ECLynxLoadParam.a(r8.getContext(), this.a.k0.s4().getLifecycle(), r8, ECMallGeckoResourceHelper.a(r9));
            if (r10 != null) goto L15;
            r10 = "";
        L15:
            r5.j = r10;
            r5.g(this.a.Z.a);
            r5.i = this.a.k0.s4().getLifecycle();
            r5.j(10000);
            r5.e(r1);
            Lazy r15 = MallBehaviorUtil.a;
            r5.a(MallBehaviorUtil.a(new MallBehaviorUtil.a(this.a.Z.a, r9)));
            Lazy r16 = HybridAppInfoService.a;
            if (HybridAppInfoService.h() == true) goto L18;
        L22:
            r5.q = r2;
            r5.t = this.a.l();
            r5.b(MapsKt.emptyMap());
            Intrinsics.checkNotNullParameter(r12, "ecLayoutParams");
            r5.u = r12;
            Intrinsics.checkNotNullParameter(r13, "lifecycle");
            r5.o = r13;
            ECMallFeedComponent r17 = this.a;
            ECLynxBuildUtilKt.a(r5, new uj.a(r17.Z.a, r17.f.a));
            b1 r18 = b1.a;
            r5.i(ECLynxLoadType.PRE_CREATE_VIEW);
            HashMap r19 = new HashMap();
            r19.put("ec.lynxCardSetData", new com.bytedance.android.ec.hybrid.card.bridge.a(r0));
            if (r14 != null) goto L25;
        L28:
            boolean r20 = true;
        L29:
            if (r20 == true) goto L31;
            r19.putAll(r14);
        L31:
            Intrinsics.checkNotNullParameter(r19, "ecBridgeMap");
            r5.r = r19;
            r5.h(this.a.f.a);
            if (r11 == null) goto L34;
            Intrinsics.checkNotNullParameter(r11, "appendData");
            r5.m = r11;
        L34:
            r0.j(new ECLynxLoadParam(r5));
            return r0;
        L25:
            if (r14.isEmpty() == true) goto L28;
            r20 = false;
            goto L29
        L18:
            if (this.a.k0.isDarkMode() == false) goto L20;
            String r21 = "dark";
        L21:
            r2 = MapsKt.mapOf(TuplesKt.to("appTheme", r21));
            goto L22
        L20:
            r21 = "light";
            goto L21
        L8:
            r3 = r13;
            goto L9
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ ECMallFeedComponent a;
        public final /* synthetic */ int b;
        public final /* synthetic */ com.bytedance.android.ec.hybrid.list.util.d c;

        public k(ECMallFeedComponent r1, int r2, com.bytedance.android.ec.hybrid.list.util.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
            DataEngineWrapper r2 = this.a.o;     // Catch: Throwable -> L10
            if (r2 == null) goto L5;
            r2.k(r0);     // Catch: Throwable -> L10
        L5:
            DataEngineWrapper r3 = this.a.o;     // Catch: Throwable -> L10
            if (r3 == null) goto L8;
            r3.o(r0);     // Catch: Throwable -> L10
        L8:
            this.a.s(this.b, this.c);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void d() {
        this.s = true;
        if (this.v == false) goto L6;
        o("invoke prefetch() after initOrRefresh()");
        return;
    L6:
        DataEngineWrapper r0 = this.o;
        if (r0 == null) goto L12;
        ECHybridDataEngine r1 = r0.a;
        if (r1 == null) goto L13;
        ECHybridDataEngine.t(r1, new g(this, null));
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void g() {
        this.C = true;
    }

    public final ECHybridListContainer j() {
        return (ECHybridListContainer) this.b.getValue();
    }

    public final d k() {
        return (d) this.p.getValue();
    }

    public final mf3.a m() {
        return (mf3.a) this.e.getValue();
    }

    static {
        p0 = LazyKt.lazy(ECMallFeedComponent$Companion$verseService$2.INSTANCE);
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L166
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("product_gyl_btm_fix");     // Catch: Throwable -> L57
        if (r4 != null) goto L9;
    L54:
        Object r5 = null;
    L55:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L57
    L59:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L166
        if (r7 == null) goto L63;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r6) == false) goto L66;
        r6 = null;
    L66:
        if ((r6 instanceof Boolean) == true) goto L68;
        r6 = null;
    L68:
        Object r8 = (Boolean) r6;     // Catch: Throwable -> L166
        if (r8 != null) goto L75;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("product_gyl_btm_fix");     // Catch: Throwable -> L166
        if ((r9 instanceof Boolean) == true) goto L74;
        r9 = null;
    L74:
        r8 = (Boolean) r9;     // Catch: Throwable -> L166
    L75:
        if (r8 != null) goto L175;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("product_gyl_btm_fix");     // Catch: Throwable -> L130
        if (r11 != null) goto L82;
    L127:
        Object r12 = null;
    L128:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L130
    L132:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L156
        if (r14 == null) goto L136;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r13) == false) goto L139;
        r13 = null;
    L139:
        if ((r13 instanceof Boolean) == true) goto L141;
        r13 = null;
    L141:
        r8 = (Boolean) r13;     // Catch: Throwable -> L156
        if (r8 != null) goto L164;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r15 == null) goto L147;
        Object r16 = r15.getHostABValue("product_gyl_btm_fix", r1);     // Catch: Throwable -> L156
    L148:
        if (r16 != null) goto L150;
    L155:
        r8 = r1;
        goto L164
    L150:
        if ((r16 instanceof Boolean) == false) goto L153;
        r3 = r16;
    L153:
        Object r17 = (Boolean) r3;     // Catch: Throwable -> L156
        if (r17 == null) goto L155;
    L163:
        r8 = r17;
        goto L164
    L147:
        r16 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("product_gyl_btm_fix", r8);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r11 instanceof Boolean) == true) goto L84;
        Object r18 = null;
    L85:
        r12 = (Boolean) r18;     // Catch: Throwable -> L130
        if (r12 != null) goto L128;
        if ((r11 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L130
        if ((r19 instanceof Boolean) == true) goto L95;
        r19 = null;
    L95:
        r12 = (Boolean) r19;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L101;
        r20 = null;
    L101:
        r12 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L107;
        r21 = null;
    L107:
        r12 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L113;
        r22 = null;
    L113:
        r12 = (Boolean) r22;     // Catch: Throwable -> L130
    L115:
        if ((r11 instanceof JSONObject) == false) goto L117;
    L177:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r23 instanceof Boolean) == true) goto L121;
        r23 = null;
    L121:
        Object r24 = Result.constructor-impl((Boolean) r23);     // Catch: Throwable -> L123
    L125:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L130
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r11 instanceof JSONArray) == false) goto L127;
    L84:
        r18 = r11;
    L156:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r27 == null) goto L161;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r17) == false) goto L163;
        r17 = r1;
    L130:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L156
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        H0 = ((Boolean) r8).booleanValue();
        return;
    L9:
        if ((r4 instanceof Boolean) == true) goto L11;
        Object r29 = null;
    L12:
        r5 = (Boolean) r29;     // Catch: Throwable -> L57
        if (r5 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Boolean) == true) goto L22;
        r30 = null;
    L22:
        r5 = (Boolean) r30;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L28;
        r31 = null;
    L28:
        r5 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L34;
        r32 = null;
    L34:
        r5 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L40;
        r33 = null;
    L40:
        r5 = (Boolean) r33;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r34 instanceof Boolean) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L50
    L52:
        r5 = r35;
        if (Result.isFailure-impl(r5) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L11:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L171;
        EnsureManager.ensureNotReachHere(r40);
    L171:
        if (Result.isFailure-impl(r39) == true) goto L174;
        r1 = r39;
    L174:
        r8 = r1;
        goto L175
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void b() {
        this.k.Y();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void c() {
        if (this.r != null) goto L6;
        this.x = new ECMallFeedComponent$initOrRefresh$1(this);
        return;
    L6:
        ECMallFeed r0 = this.k;
        Iterator<T> r1 = r0.k1.iterator();
    L7:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L11;
        ((e93.e) r1.next()).initOrRefresh(false, r0.R);
        goto L7
    L11:
        if (this.v == true) goto L16;
        this.w = System.currentTimeMillis();
        if (((Boolean) this.N.getValue()).booleanValue() == true) goto L15;
        p();
    L15:
        this.v = true;
    L16:
        DataEngineWrapper r2 = null;
        com.bytedance.android.shopping.mall.feed.help.p r4 = null;
        this.x = null;
        if (this.A == false) goto L21;
        DataEngineWrapper r5 = this.o;
        if (r5 == null) goto L21;
        r5.J();
    L21:
        o("initOrRefresh start at " + System.currentTimeMillis());
        this.k.b = new y0(this);
        h r6 = this.n;
        if (this.A == false) goto L24;
        ECMallFeedState r7 = ECMallFeedState.REFRESHING;
    L25:
        r6.a(r7);
        if (Intrinsics.areEqual(this.r, Boolean.FALSE) == false) goto L29;
        o("initOrRefresh failed at " + System.currentTimeMillis());
        this.n.a(ECMallFeedState.INIT_FAILED);
        return;
    L29:
        ArrayList r8 = new ArrayList();
        DataEngineWrapper r9 = this.o;
        if (r9 == null) goto L47;
        ECHybridDataEngine r10 = r9.a;
        if (r10 == null) goto L47;
        if (this.A == false) goto L41;
        ECHybridApiConfigDTO r11 = r10.p();
        if (r11 == null) goto L38;
        List r12 = r11.getRefreshKeyList();
    L39:
        if (r12 == null) goto L47;
        r8.addAll(r12);
        goto L47
    L38:
        r12 = null;
        goto L39
    L41:
        ECHybridApiConfigDTO r13 = r10.p();
        if (r13 == null) goto L44;
        List r14 = r13.getFirstScreenKeyList();
    L45:
        if (r14 == null) goto L47;
        r8.addAll(r14);
        goto L47
    L44:
        r14 = null;
    L47:
        DataEngineWrapper r15 = this.o;
        if (r15 == null) goto L50;
        final ECHybridDataEngine r16 = r15.a;
    L51:
        IECMallFeedService r17 = (IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class);
        if (r17 == null) goto L54;
        final com.bytedance.android.shopping.api.mall.feed.g r18 = r17.b(this.Z.a);
    L56:
        if (r18 == null) goto L63;
        com.bytedance.android.shopping.api.mall.feed.b r19 = this.Z;
        String r20 = r19.l;
        if (r20 != null) goto L61;
        r20 = r19.a;
    L61:
        if (r18.a(r20) != true) goto L63;
    L65:
        if (this.A == false) goto L69;
        if (this.u == true) goto L69;
    L132:
        if (r8.contains("homepage") == false) goto L136;
        t();
        if (this.z == true) goto L136;
        p();
    L136:
        DataEngineWrapper r21 = this.o;
        if (r21 != null) goto L139;
    L152:
        o("initOrRefresh failed at " + System.currentTimeMillis());
        h r22 = this.n;
        if (this.A == false) goto L155;
        ECMallFeedState r23 = ECMallFeedState.REFRESH_FAILED;
    L156:
        r22.a(r23);
        return;
    L155:
        r23 = ECMallFeedState.INIT_FAILED;
        goto L156
    L139:
        if ((true ^ r8.isEmpty()) == false) goto L141;
        r2 = r21;
    L141:
        if (r2 == null) goto L152;
        this.k.f0();
        this.B = false;
        r2.t(System.currentTimeMillis());
        ECHybridDataEngine r24 = r2.a;
        if (r24 == null) goto L146;
        r24.a(r8, k());
    L146:
        if (this.z == false) goto L148;
        return;
    L148:
        if (this.U == false) goto L170;
        this.U = false;
        List<com.bytedance.android.ec.hybrid.list.entity.p> r25 = ((IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class)).c().c(this.Z.a);
        ECHybridListEngine r26 = this.k.J;
        if (r26 == null) goto L171;
        r26.m(new com.bytedance.android.ec.hybrid.list.entity.g(this.X, r25));
        return;
    L171:
        return;
    L170:
        return;
    L69:
        if ((!r8.isEmpty()) == false) goto L132;
        if (r16 == null) goto L132;
        if (this.s == false) goto L109;
        Iterator r27 = r8.iterator();
        if (r27.hasNext() == false) goto L109;
        String r28 = (String) r27.next();
        DataEngineWrapper r29 = this.o;
        com.bytedance.android.shopping.mall.feed.help.p r30 = this.L;
        if (r30 != null) goto L94;
        if (r29 == null) goto L82;
        Intrinsics.checkNotNullParameter(r28, "apiKey");
        ECHybridDataEngine r31 = r29.a;
        if (r31 == null) goto L82;
        String r32 = r31.m(r28);
    L83:
        if (r32 != null) goto L85;
    L86:
        r3 = true;
    L88:
        if ((true ^ r3) == true) goto L91;
        r32 = null;
    L91:
        if (r32 == null) goto L93;
        int r33 = com.bytedance.android.shopping.mall.feed.help.p.e;
        r4 = com.bytedance.android.shopping.mall.feed.help.p.a.a(r32, this.Z.b);
    L93:
        r30 = r4;
        goto L94
    L85:
        if (StringsKt.isBlank(r32) == false) goto L88;
    L82:
        r32 = null;
    L94:
        if (r30 == null) goto L97;
        d.i(k(), r28, r30);
        return;
    L97:
        if (Intrinsics.areEqual(r28, "homepage") == false) goto L101;
        t();
        if (this.z == true) goto L101;
        p();
    L101:
        k().h(r28);
        if (this.s == true) goto L104;
    L107:
        r16.a(CollectionsKt.listOf(r28), k());
        return;
    L104:
        if (((ArrayList) this.H).contains(r28) == true) goto L107;
        ((ArrayList) this.G).add(r28);
        return;
    L109:
        if (r18 == null) goto L132;
        com.bytedance.android.shopping.api.mall.feed.b r34 = this.Z;
        String r35 = r34.l;
        if (r35 != null) goto L114;
        r35 = r34.a;
    L114:
        if (r18.a(r35) != true) goto L132;
        Iterator r36 = r8.iterator();
    L117:
        if (r36.hasNext() == false) goto L130;
        final String r37 = (String) r36.next();
        k().h(r37);
        final Function0<Unit> r38 = new ECMallFeedComponent$initOrRefresh$$inlined$forEach$lambda$1(r37, this, r16, r18);
        final Ref.BooleanRef r39 = new Ref.BooleanRef();
        r39.element = false;
        final Function0<Unit> r40 = new ECMallFeedComponent$initOrRefresh$$inlined$forEach$lambda$2(r39, this, r16, r18);
        if (Intrinsics.areEqual(r37, "homepage") == true) goto L121;
        r38.invoke();
        goto L117
    L121:
        if (((Boolean) this.P.getValue()).booleanValue() == false) goto L123;
        r40.invoke();
    L123:
        com.bytedance.android.shopping.api.mall.feed.b r41 = this.Z;
        String r42 = r41.l;
        if (r42 != null) goto L127;
        r42 = r41.a;
    L127:
        if (r18.c(r42, new ECMallFeedComponent$initOrRefresh$$inlined$forEach$lambda$3(r37, this, r16, r18), new ECMallFeedComponent$initOrRefresh$3$prefetchBack$2(r40, r38)) == true) goto L117;
        r40.invoke();
        goto L117
    L130:
        return;
    L63:
        if (this.s == false) goto L132;
    L54:
        r18 = null;
        goto L56
    L50:
        r16 = null;
        goto L51
    L24:
        r7 = ECMallFeedState.INITIALIZING;
        goto L25
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final RecyclerView getFeedView() {
        ECHybridListEngine r0 = this.k.J;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final String getSceneId() {
        return this.f.a;
    }

    public final String l() {
        return "ec_mall_feed_" + this.Z.a;
    }

    public final void p() {
        if (this.S == true) goto L8;
        mf3.a r1 = m();
        if (r1 == null) goto L9;
        mf3.b.a.a(r1, this.Y, this.k0.s4().getLifecycle(), (FrameLayout) this.c.getValue(), this.k0.getGlobalProps(), l(), MapsKt.emptyMap(), null, null, this.Z.m, 192);
        this.S = true;
        return;
    L9:
        return;
    }

    public final void t() {
        if (this.q == true) goto L9;
        if (this.Z.e == null) goto L9;
        o("can not render with cached api response, because do not hit offline gecko resources");
        return;
    L9:
        if (this.Z.e != null) goto L13;
        o("api cache is disabled");
        return;
    L13:
        if (this.u == false) goto L23;
        RecyclerView r0 = getFeedView();
        if (r0 == null) goto L23;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L19;
        int r2 = r1.getItemCount();
    L21:
        if (r2 <= 4) goto L23;
        return;
    L19:
        r2 = 0;
    L23:
        String r3 = n("homepage");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        q(r3);     // Catch: Throwable -> L26
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L34;
        o("read homepage cached api response failed at " + System.currentTimeMillis() + ", cacheKey = " + r3);
        EnsureManager.ensureNotReachHere(r6);
        return;
    L34:
        return;
    L26:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final View getView() {
        return j();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void h() {
        this.T = System.currentTimeMillis();
        DataEngineWrapper r0 = this.o;
        if (r0 == null) goto L5;
        r0.L(ECMallFeedComponent$onParentContainerBuild$1.INSTANCE);
    L5:
        this.V = true;
    }

    public static void o(String r1) {
        Logger.d("ECMallFeedComponent", r1);
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void a(Integer r1) {
        this.a = r1;
        c();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void e(Long r3) {
        if (this.s == false) goto L5;
        return;
    L5:
        if (this.v == false) goto L16;
        this.s = true;
        this.u = true;
        DataEngineWrapper r0 = this.o;
        if (r0 == null) goto L14;
        ECHybridDataEngine r1 = r0.a;
        if (r1 == null) goto L15;
        ECHybridDataEngine.t(r1, new g(this, r3));
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        this.i = r2;
        c();
    }

    public final String n(String r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append('_');
        com.bytedance.android.shopping.api.mall.feed.a r3 = this.Z.e;
        if (r3 == null) goto L6;
        String r4 = r3.a;
        if (r4 == null) goto L6;
    L7:
        r0.append(r4);
        return r0.toString();
    L6:
        r4 = "";
        goto L7
    }

    public final void q(String r8) {
        if (this.K != null) goto L5;
        this.K = ((IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class)).c().e(this.Z.a, r8);
    L5:
        com.bytedance.android.shopping.api.mall.idl.b r0 = this.K;
        boolean r2 = false;
        if (r0 == null) goto L13;
        ECMallFeedLocalStorage r3 = (ECMallFeedLocalStorage) this.I.getValue();
        if (r3 != null) goto L10;
    L11:
        r2 = true;
    L12:
        r2 = !r2;
        goto L13
    L10:
        if (r3.a(r0.d) == false) goto L12;
    L13:
        com.bytedance.android.shopping.api.mall.idl.b r1 = this.K;
        String r4 = null;
        if (r1 == null) goto L43;
        if (r2 == false) goto L43;
        this.y = true;
        r(r1.a, r1.b, r1.c);
        this.K = null;
        return;
    L43:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L40
        ECMallFeedLocalStorage r6 = (ECMallFeedLocalStorage) this.I.getValue();     // Catch: Throwable -> L40
        if (r6 == null) goto L23;
        String r7 = r6.c(r8);     // Catch: Throwable -> L40
        if (r7 == null) goto L23;
        String r9 = com.bytedance.android.shopping.api.mall.common.tools.b0.k(r7);     // Catch: Throwable -> L40
    L25:
        if (this.z == true) goto L38;
        if (r9 == null) goto L38;
        HomePageDTO r10 = (HomePageDTO) new Gson().fromJson(r9, HomePageDTO.class);     // Catch: Throwable -> L40
        o("read homepage cached api response success at " + System.currentTimeMillis() + ", cacheKey = " + r8);     // Catch: Throwable -> L40
        HomePageBffDTO r11 = r10.getBff();     // Catch: Throwable -> L40
        if (r11 == null) goto L37;
        ECHybridListDTO r12 = r11.getFeed();     // Catch: Throwable -> L40
        if (r12 == null) goto L37;
        ECHybridListDTO.a r13 = ECHybridListDTO.Companion;     // Catch: Throwable -> L40
        HomePageBffDTO r14 = r10.getBff();     // Catch: Throwable -> L40
        if (r14 == null) goto L36;
        BffBizInfo r15 = r14.getBizInfo();     // Catch: Throwable -> L40
        if (r15 == null) goto L36;
        r4 = r15.getEcSceneId();     // Catch: Throwable -> L40
    L36:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r16 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r4, 190);     // Catch: Throwable -> L40
        r13.getClass();     // Catch: Throwable -> L40
        r(ECHybridListDTO.a.d(r12, true, r16), r12.getCursor(), r12.getHasMore());     // Catch: Throwable -> L40
    L37:
        o("homepage cached api response is null");     // Catch: Throwable -> L40
    L38:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
        return;
    L23:
        r9 = null;
    L40:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.d
    public final void setFeedStateListener(com.bytedance.android.shopping.api.mall.feed.f r2) {
        this.n.a = r2;
    }

    public static final void i(final ECMallFeedComponent r3, final HomePageDTO r4) {
        if (r3.Q == true) goto L22;
        r3.Q = true;
        final com.bytedance.android.shopping.api.mall.feed.c r0 = r3.Z.f;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.a == false) goto L24;
        o("first screen image prefetch start");
        if (Intrinsics.areEqual(r3.Z.a, "personal_homepage_ecom") == true) goto L14;
    L16:
        DataEngineWrapper r5 = r3.o;
        if (r5 == null) goto L21;
        DataEngineWrapper.F(r5, r4, r0.b);
        return;
    L21:
        return;
    L14:
        if (((Boolean) r3.O.getValue()).booleanValue() == false) goto L16;
        Handler r1 = com.bytedance.android.shopping.api.mall.common.tools.a0.a;
        Function0<Unit> r2 = new ECMallFeedComponent$triggerFirstScreenImagePrefetchIfNeed$1(r3, r4, r0);
        Intrinsics.checkNotNullParameter(r2, "method");
        com.bytedance.android.shopping.api.mall.common.tools.a0.a.postDelayed(new com.bytedance.android.shopping.api.mall.common.tools.z(r2), 0);
        return;
    L24:
        return;
    }

    public final void s(int r87, com.bytedance.android.ec.hybrid.list.util.d r88) {
        ECHybridListEngine r4 = this.k.J;
        Boolean r5 = null;
        if (r4 == null) goto L5;
        ECHybridRecyclerView r6 = r4.b;
    L7:
        if (r6 != null) goto L9;
    L14:
        DataEngineWrapper r7 = this.o;
        if (r7 == null) goto L21;
        y93.a r8 = r7.b;
        if (r8 == null) goto L21;
        if (r8.c != true) goto L21;
        return;
    L21:
        if (r7 == null) goto L23;
        r7.v(r87);
        Unit r0 = Unit.INSTANCE;
    L23:
        JSONObject r9 = new JSONObject();
        r9.put("type", "PERFORMANCE_LOG");     // Catch: JSONException -> L156
        r9.put("res_version", this.f.t);     // Catch: JSONException -> L156
        r9.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.g.getGlobalProps().get(PdpOpenThirdParam.KEY_PAGE_NAME));     // Catch: JSONException -> L156
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: JSONException -> L156
        r9.put("log_id", this.k.V.v);     // Catch: JSONException -> L156
        DataEngineWrapper r3 = this.o;     // Catch: JSONException -> L156
        if (r3 == null) goto L29;
        y93.a r10 = r3.b;     // Catch: JSONException -> L156
        if (r10 == null) goto L29;
        String r11 = r10.c();     // Catch: JSONException -> L156
    L30:
        r9.put("error_msg", r11);     // Catch: JSONException -> L156
        DataEngineWrapper r1 = this.o;     // Catch: JSONException -> L156
        if (r1 == null) goto L35;
        y93.a r2 = r1.b;     // Catch: JSONException -> L156
        if (r2 == null) goto L35;
        Integer r12 = r2.y();     // Catch: JSONException -> L156
    L36:
        r9.put("status", r12);     // Catch: JSONException -> L156
        Integer r13 = this.f.k;     // Catch: JSONException -> L156
        if (r13 == null) goto L39;
        int r14 = r13.intValue();     // Catch: JSONException -> L156
    L40:
        r9.put("render_thread_strategy", r14);     // Catch: JSONException -> L156
        r9.putOpt("open_gyl_behavior", this.i);     // Catch: JSONException -> L156
        r9.putOpt("prefetch_for_gyl", Boolean.valueOf(this.s));     // Catch: JSONException -> L156
        r9.putOpt("prefetch_fot_gyl_v2", Boolean.valueOf(this.t));     // Catch: JSONException -> L156
        if (this.t == false) goto L43;
        int r15 = 1;
    L44:
        r9.putOpt("data_is_prefetch", Integer.valueOf(r15));     // Catch: JSONException -> L156
        r9.putOpt("tab_id", this.a);     // Catch: JSONException -> L156
        long r16 = this.w;     // Catch: JSONException -> L156
        long r17 = 0;
        if (r16 <= 0) goto L47;
        r9.put("t_invoke_init", r16);     // Catch: JSONException -> L156
    L47:
        if (r12 != null) goto L50;
    L100:
        DataEngineWrapper r18 = this.o;     // Catch: JSONException -> L156
        if (r18 == null) goto L111;
        com.bytedance.android.ec.hybrid.list.util.d r19 = r18.f;     // Catch: JSONException -> L156
        r18.f = null;     // Catch: JSONException -> L156
        if (r19 == null) goto L111;
        List r20 = r19.h;     // Catch: JSONException -> L156
        if (r20 == null) goto L111;
        if (r20.size() != 2) goto L109;
        r9.putOpt("first_item_load_start", ListProtector.get(r20, 0));     // Catch: JSONException -> L156
        r9.putOpt("first_item_load_end", ListProtector.get(r20, 1));     // Catch: JSONException -> L156
    L109:
        Unit r21 = Unit.INSTANCE;     // Catch: JSONException -> L156
    L111:
        if (this.z == false) goto L113;
        int r22 = 1;
    L114:
        r9.put("flag_render_with_cache", r22);     // Catch: JSONException -> L156
        DataEngineWrapper r23 = this.o;     // Catch: JSONException -> L156
        if (r23 == null) goto L119;
        y93.a r110 = r23.b;     // Catch: JSONException -> L156
        if (r110 == null) goto L119;
        y93.a r24 = y93.a.a(r110, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 1610612735, -1, -1, -1, 127);     // Catch: JSONException -> L156
    L120:
        if (r24 == null) goto L122;
        JSONObject r25 = com.bytedance.android.ec.hybrid.list.util.k.b(r24);     // Catch: JSONException -> L156
    L123:
        if (r88 == null) goto L134;
        if (r25 == null) goto L126;
        r25.put("count_total", r88.a);     // Catch: JSONException -> L156
    L126:
        if (r25 == null) goto L128;
        r25.put("count_succ", r88.b);     // Catch: JSONException -> L156
    L128:
        if (r25 == null) goto L130;
        r25.put("count_fail", r88.c);     // Catch: JSONException -> L156
    L130:
        if (r25 == null) goto L132;
        r25.put("t_all_lynx_card_load", r88.d);     // Catch: JSONException -> L156
    L132:
        if (r25 == null) goto L134;
        r25.put("t_all_lynx_card_create_view", r88.e);     // Catch: JSONException -> L156
    L134:
        DataEngineWrapper r26 = this.o;     // Catch: JSONException -> L156
        if (r26 == null) goto L139;
        y93.a r27 = r26.b;     // Catch: JSONException -> L156
        if (r27 == null) goto L139;
        Integer r28 = r27.g();     // Catch: JSONException -> L156
    L140:
        r9.putOpt("gyl_num_of_homepage_response", r28);     // Catch: JSONException -> L156
        r9.put("detail", r25);     // Catch: JSONException -> L156
        r9.putOpt("parent_create_time", Long.valueOf(this.T));     // Catch: JSONException -> L156
        DataEngineWrapper r29 = this.o;     // Catch: JSONException -> L156
        if (r29 == null) goto L145;
        y93.a r30 = r29.b;     // Catch: JSONException -> L156
        if (r30 == null) goto L145;
        Integer r31 = r30.w();     // Catch: JSONException -> L156
    L146:
        r9.putOpt("rebuild_scene", r31);     // Catch: JSONException -> L156
        Long r32 = j().getOpenTime();     // Catch: JSONException -> L156
        if (r32 == null) goto L149;
        r17 = r32.longValue();     // Catch: JSONException -> L156
    L149:
        r9.putOpt("t_recommend_open_time", Long.valueOf(r17));     // Catch: JSONException -> L156
        DataEngineWrapper r33 = this.o;     // Catch: JSONException -> L156
        if (r33 == null) goto L154;
        ECHybridDataEngine r34 = r33.a;     // Catch: JSONException -> L156
        if (r34 == null) goto L154;
        r5 = Boolean.valueOf(r34.a);     // Catch: JSONException -> L156
    L154:
        r9.putOpt("is_config_load_from_keva", r5);     // Catch: JSONException -> L156
    L158:
        Logger.d("peive", "reportFirstScreen " + r9);
        com.bytedance.android.shopping.api.mall.common.tools.l r35 = com.bytedance.android.shopping.api.mall.common.tools.l.a;
        Integer r36 = this.f.s;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r9, "params");
        com.bytedance.android.ec.hybrid.a.d().submit(new com.bytedance.android.shopping.api.mall.common.tools.m(r9, r36, true, false));
        this.V = false;
        return;
    L145:
        r31 = null;
    L139:
        r28 = null;
        goto L140
    L122:
        r25 = null;
    L119:
        r24 = null;
        goto L120
    L113:
        r22 = 0;
        goto L114
    L50:
        if (r12.intValue() != 1) goto L100;
        DataEngineWrapper r37 = this.o;     // Catch: JSONException -> L156
        if (r37 == null) goto L58;
        y93.a r38 = r37.b;     // Catch: JSONException -> L156
        if (r38 == null) goto L58;
        Long r39 = r38.q();     // Catch: JSONException -> L156
        if (r39 == null) goto L58;
        long r40 = r39.longValue();     // Catch: JSONException -> L156
    L59:
        DataEngineWrapper r41 = this.o;     // Catch: JSONException -> L156
        if (r41 == null) goto L66;
        y93.a r42 = r41.b;     // Catch: JSONException -> L156
        if (r42 == null) goto L66;
        Long r43 = r42.j();     // Catch: JSONException -> L156
        if (r43 == null) goto L66;
        long r111 = r43.longValue();     // Catch: JSONException -> L156
    L67:
        r9.put("first_screen_duration", r111 - r40);     // Catch: JSONException -> L156
        DataEngineWrapper r44 = this.o;     // Catch: JSONException -> L156
        if (r44 == null) goto L74;
        y93.a r45 = r44.b;     // Catch: JSONException -> L156
        if (r45 == null) goto L74;
        Long r46 = r45.p();     // Catch: JSONException -> L156
        if (r46 == null) goto L74;
        long r47 = r46.longValue();     // Catch: JSONException -> L156
    L75:
        DataEngineWrapper r48 = this.o;     // Catch: JSONException -> L156
        if (r48 == null) goto L82;
        y93.a r49 = r48.b;     // Catch: JSONException -> L156
        if (r49 == null) goto L82;
        Long r50 = r49.n();     // Catch: JSONException -> L156
        if (r50 == null) goto L82;
        long r112 = r50.longValue();     // Catch: JSONException -> L156
    L83:
        r9.put("first_screen_net_duration", r112 - r47);     // Catch: JSONException -> L156
        DataEngineWrapper r51 = this.o;     // Catch: JSONException -> L156
        if (r51 == null) goto L90;
        y93.a r52 = r51.b;     // Catch: JSONException -> L156
        if (r52 == null) goto L90;
        Long r53 = r52.k();     // Catch: JSONException -> L156
        if (r53 == null) goto L90;
        long r54 = r53.longValue();     // Catch: JSONException -> L156
    L91:
        DataEngineWrapper r55 = this.o;     // Catch: JSONException -> L156
        if (r55 == null) goto L98;
        y93.a r56 = r55.b;     // Catch: JSONException -> L156
        if (r56 == null) goto L98;
        Long r57 = r56.j();     // Catch: JSONException -> L156
        if (r57 == null) goto L98;
        long r113 = r57.longValue();     // Catch: JSONException -> L156
    L99:
        r9.put("first_screen_render_duration", r113 - r54);     // Catch: JSONException -> L156
    L98:
        r113 = 0;
    L90:
        r54 = 0;
    L82:
        r112 = 0;
    L74:
        r47 = 0;
    L66:
        r111 = 0;
    L58:
        r40 = 0;
        goto L59
    L43:
        r15 = 0;
        goto L44
    L39:
        r14 = 0;
    L35:
        r12 = null;
    L29:
        r11 = null;
    L156:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L158
    L9:
        if (r6.getChildCount() > 0) goto L14;
        if (this.F > 5) goto L14;
        r6.post(new k(this, r87, r88));
        this.F++;
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final void r(com.bytedance.android.ec.hybrid.list.entity.k r5, int r6, boolean r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        DataEngineWrapper r2 = this.o;     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.A(System.currentTimeMillis());     // Catch: Throwable -> L8
    L6:
        this.k.j0(r5, r6, r7);     // Catch: Throwable -> L8
        this.n.a(ECMallFeedState.INIT_WITH_CACHE_SUCCESS);     // Catch: Throwable -> L8
        this.z = true;     // Catch: Throwable -> L8
        o("render with cached api response at " + System.currentTimeMillis());     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        o("render with cached api response failed at " + System.currentTimeMillis());
        EnsureManager.ensureNotReachHere(r9);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public ECMallFeedComponent(Context r53, com.bytedance.android.shopping.api.mall.feed.b r54, com.bytedance.android.shopping.api.mall.feed.e r55, com.bytedance.android.shopping.api.mall.feed.f r56) {
        this.Y = r53;
        this.Z = r54;
        this.k0 = r55;
        this.b = LazyKt.lazy(new ECMallFeedComponent$feedContainer$2(this));
        this.c = LazyKt.lazy(new ECMallFeedComponent$pageCardContainer$2(this));
        com.bytedance.android.shopping.mall.homepage.pagecard.d r14 = new com.bytedance.android.shopping.mall.homepage.pagecard.d();
        this.d = r14;
        this.e = LazyKt.lazy(new ECMallFeedComponent$pageCardContext$2(this));
        new LinkedHashSet();
        String r4 = String.valueOf(hashCode());
        String r5 = r54.a;
        b1 r6 = b1.a;
        Activity r2 = ECHybridExtensionsKt.a(r53);
        if ((r2 instanceof LifecycleOwner) == true) goto L5;
        r2 = null;
    L5:
        LifecycleOwner r3 = (LifecycleOwner) r2;
        if (r3 == null) goto L8;
        Lifecycle r7 = r3.getLifecycle();
    L10:
        if (r7 == null) goto L12;
        Map r9 = com.bytedance.android.ec.hybrid.list.util.r.a;
        Intrinsics.checkNotNullParameter(r4, "sceneId");
        Intrinsics.checkNotNullParameter(r6, "util");
        Intrinsics.checkNotNullParameter(r7, "lifeCycle");
        com.bytedance.android.ec.hybrid.list.util.r.a.put(r4, r6);
        r7.addObserver(new LynxCardUtil.setUtilsByLife.1(r4));
    L13:
        int r8 = 0;
        if (s93.c.a("gyl_live_video_smooth_enter") != 1) goto L16;
        boolean r27 = true;
    L17:
        IECMallGeckoService r10 = (IECMallGeckoService) ServiceManager.get().getService(IECMallGeckoService.class);
        if (r10 != null) goto L20;
    L22:
        boolean r22 = false;
    L23:
        String r19 = l();
        Map r20 = MapsKt.emptyMap();
        String r11 = r54.h;
        if (r11 == null) goto L26;
    L33:
        String r21 = r11;
    L34:
        HybridAppInfoService r12 = HybridAppInfoService.p;
        if (HybridAppInfoService.j() == false) goto L37;
    L40:
        boolean r23 = true;
    L41:
        Integer r13 = r54.d;
        if (r13 == null) goto L44;
        int r35 = r13.intValue();
    L45:
        ListEngineOptConfig.a r15 = ListEngineOptConfig.r;
        com.bytedance.android.shopping.api.mall.feed.c r16 = r54.f;
        if (r16 == null) goto L48;
        Integer r48 = Integer.valueOf(r16.e);
    L49:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r5, "pageName");
        boolean r17 = ((ArrayList) ListEngineOptConfig.o.getValue()).contains(r5);
        Integer r18 = ListEngineOptConfig.a.a(r5);
        if (r18 == null) goto L52;
        r8 = r18.intValue();
    L52:
        if (r48 != null) goto L56;
        if (r17 == true) goto L56;
        if (r8 != 0) goto L56;
        ListEngineOptConfig r41 = null;
    L57:
        ECMallFeed.e r24 = new ECMallFeed.e(r4, null, r5, r19, r20, r21, r22, r23, false, 0, r27, r27, 0, false, false, true, 2, 1, null, r35, 150, 200, null, r41, null, r54.g, r54.j, r54.k, r54.m);
        this.f = r24;
        FeedContainerAbility r25 = new FeedContainerAbility(this);
        this.g = r25;
        j r1 = new j(this);
        ik.a r26 = new ik.a();
        this.h = r26;
        this.i = "";
        this.j = new ArrayList();
        ECMallFeed r28 = new ECMallFeed(j(), r25, r24, null, null, null, r1, r26, r14);
        this.k = r28;
        this.l = LazyKt.lazy(new ECMallFeedComponent$appBackgroundStateConsumer$2(this));
        e r29 = new e(this);
        this.m = r29;
        h r30 = new h(this);
        this.n = r30;
        this.p = LazyKt.lazy(new ECMallFeedComponent$feedController$2(this));
        this.E = LazyKt.lazy(new ECMallFeedComponent$lynxCardLoadStatusChecker$2(this));
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = LazyKt.lazy(new ECMallFeedComponent$apiCache$2(this));
        this.J = true;
        LazyThreadSafetyMode r31 = LazyThreadSafetyMode.NONE;
        this.M = LazyKt.lazy(r31, new ECMallFeedComponent$homepagePreTransVo$2(this));
        this.N = LazyKt.lazy(r31, new ECMallFeedComponent$pageCardInitDelay$2(this));
        this.O = LazyKt.lazy(r31, ECMallFeedComponent$optMainThreadLogic$2.INSTANCE);
        this.P = LazyKt.lazy(r31, ECMallFeedComponent$forceStraightOutByPrefetch$2.INSTANCE);
        this.T = -1;
        this.U = true;
        this.X = new ArrayList();
        o("prepare start at " + System.currentTimeMillis());
        j().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r55.s4().getLifecycle().addObserver(r29);
        r30.a = r56;
        ECMallFeedComponent$configDTOCallback$1 r32 = new ECMallFeedComponent$configDTOCallback$1(this);
        this.o = r28.C1;
        r30.a(ECMallFeedState.PREPARING);
        DataEngineWrapper r33 = this.o;
        if (r33 == null) goto L66;
        ECHybridDataEngine r34 = r33.a;
        if (r34 == null) goto L66;
        r33.i(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r32, "callback");
        ConcurrentHashMap r36 = ECHybridDataEngine.v;
        if (((com.bytedance.android.ec.hybrid.data.entity.b) r36.get(r34.l)) == null) goto L65;
        r34.s(null, null);
        r34.c = null;
        r32.c(null, null, null, null);
        r36.remove(r34.l);
        return;
    L65:
        Intrinsics.checkNotNullParameter(r32, "callback");
        r34.n(null, !((Boolean) r34.f.getValue()).booleanValue(), r32);
        return;
    L66:
        r32.a(null, null, null);
        return;
    L56:
        r41 = new ListEngineOptConfig(null, null, null, null, null, null, Boolean.valueOf(r17), null, null, Integer.valueOf(r8), null, r48, null, null, 13759);
        goto L57
    L48:
        r48 = null;
        goto L49
    L44:
        r35 = 2;
        goto L45
    L37:
        if (r12.b() == true) goto L40;
        r23 = false;
        goto L41
    L26:
        if (StringsKt.isBlank(r54.a) == false) goto L28;
        r21 = null;
        goto L34
    L28:
        Lazy r37 = NativeMallGeckoHelper.a;
        r11 = NativeMallGeckoHelper.d(r54.a);
        if (HybridAppInfoService.p.isLocalTest() == false) goto L33;
        IVerseService r38 = (IVerseService) p0.getValue();
        if (r38 == null) goto L33;
        r38.getMallDebugService();
        goto L33
    L20:
        if (r10.isGeckoExist() != true) goto L22;
        r22 = true;
        goto L23
    L16:
        r27 = false;
        goto L17
    L12:
        Map r39 = com.bytedance.android.ec.hybrid.list.util.r.a;
        Intrinsics.checkNotNullParameter(r4, "sceneId");
        Intrinsics.checkNotNullParameter(r6, "util");
        com.bytedance.android.ec.hybrid.list.util.r.a.put(r4, r6);
        goto L13
    L8:
        r7 = null;
        goto L10
    }
}
