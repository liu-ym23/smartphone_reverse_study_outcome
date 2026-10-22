package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.event.f2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.r1;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility;
import com.bytedance.android.livesdk.livecommerce.iron.helper.ECLiveLoginHelper;
import com.bytedance.android.livesdk.livecommerce.kmp.ECLiveKmpABUtils;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.livesdk.livecommerce.room.hover.ECLiveDialogHoverManager;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponInfo;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponMsgEvent;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveListSkinUIHelper;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.p0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionListController extends c0 {
    public static final a T = null;
    public boolean A;
    public Pair<Integer, Integer> B;
    public Pair<Integer, Integer> C;
    public ql.a D;
    public boolean E;
    public LivePromotionListCacheCenter F;
    public ECLiveListSkinUIHelper G;
    public com.bytedance.android.livesdk.livecommerce.skin.a H;
    public Boolean I;
    public com.bytedance.android.shopping.ligo.context.b<?> J;
    public final Map<String, Object> K;
    public JSONArray L;
    public volatile boolean M;
    public final Object N;
    public Function1<? super vj2.b, Unit> O;
    public Function0<Unit> P;
    public String Q;
    public ECLiveDialogHoverManager R;
    public final mj2.b S;
    public LivePromotionListFragment c;
    public final List<b> d;
    public boolean e;
    public String f;
    public String g;
    public long h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public d r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PromotionListController a() {
            PromotionListController r0 = ControllerCenter.c(null, null).r;
            Objects.toString(r0);
            return r0;
        }

        @JvmStatic
        public static fh2.a b(String r0, String r1) {
            PromotionListController r2 = c(r0, r1);
            if (r2.x() == true) goto L7;
            return null;
        L7:
            return r2.c;
        }

        @JvmStatic
        public static PromotionListController c(String r0, String r1) {
            PromotionListController r2 = ControllerCenter.c(r0, r1).r;
            Objects.toString(r2);
            return r2;
        }
    }

    public static final class b {
        public final lj2.a a;
        public final oj2.a b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            lj2.a r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            oj2.a r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            int r8 = (r6 + r1) * 31;
            boolean r9 = this.d;
            ?? r10 = r9;
            if (r9 == false) goto L17;
            r10 = 1;
        L17:
            return r8 + r10;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveListUpdateMessageInterceptorInfo(msgInterceptor=" + this.a + ", optMsgInterceptor=" + this.b + ", targetRoomId=" + this.c + ", isContainerRoom=" + this.d + ")";
        }

        public b(lj2.a r2, oj2.a r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "msgInterceptor");
            Intrinsics.checkNotNullParameter(r3, "optMsgInterceptor");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c {
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;
        public final String e;
        public final ml.b f;
        public final JSONObject g;
        public final String h;

        public c() {
            this(null, false, null, null, null, null, null, null, 255);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L22;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L12;
            int r8 = r7.hashCode();
        L13:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L16;
            int r11 = r10.hashCode();
        L17:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 == null) goto L20;
            int r14 = r13.hashCode();
        L21:
            int r15 = (r12 + r14) * 31;
            ml.b r16 = this.f;
            if (r16 == null) goto L24;
            int r17 = r16.hashCode();
        L25:
            int r18 = (r15 + r17) * 31;
            JSONObject r19 = this.g;
            if (r19 == null) goto L28;
            int r20 = r19.hashCode();
        L29:
            int r21 = (r18 + r20) * 31;
            String r22 = this.h;
            if (r22 == null) goto L33;
            r1 = r22.hashCode();
        L33:
            return r21 + r1;
        L28:
            r20 = 0;
            goto L29
        L24:
            r17 = 0;
            goto L25
        L20:
            r14 = 0;
            goto L21
        L16:
            r11 = 0;
            goto L17
        L12:
            r8 = 0;
            goto L13
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SchemaParams(promotionId=" + this.a + ", isPromotionId=" + this.b + ", passthroughParams=" + this.c + ", relatedInfo=" + this.d + ", sourceBtmToken=" + this.e + ", liveRoomInfo=" + this.f + ", eventParams=" + this.g + ", cartIconRelatedInfo=" + this.h + ")";
        }

        public c(String r3, boolean r4, String r5, String r6, String r7, ml.b r8, JSONObject r9, String r10, int r11) {
            if ((r11 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r4 = true;
        L9:
            if ((r11 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r11 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r11 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r11 & 32) == 0) goto L21;
            r8 = null;
        L21:
            if ((r11 & 64) == 0) goto L24;
            r9 = null;
        L24:
            if ((r11 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L26;
            r10 = null;
        L26:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PromotionListController a;

        public d(PromotionListController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.O("first_comment_show_delay");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends p0<ge.a> {
        public final /* synthetic */ PromotionListController a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zk.b e;
        public final /* synthetic */ c f;
        public final /* synthetic */ wj2.g g;
        public final /* synthetic */ Function1 h;

        @Override // com.bytedance.android.livesdk.livecommerce.utils.p0
        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onNext(Object r7) {
            Intrinsics.checkNotNullParameter((ge.a) r7, "iUser");
            Function0 r8 = this.b;
            if (r8 == null) goto L5;
            Unit r9 = (Unit) r8.invoke();
        L5:
            LivePromotionListFragment r10 = this.a.L(this.c, this.d, this.e, this.f, this.g);
            Function1 r0 = this.h;
            if (r0 == null) goto L9;
            Unit r11 = (Unit) r0.invoke(r10);
            return;
        }

        public e(PromotionListController r1, Function0 r2, Context r3, String r4, zk.b r5, boolean r6, c r7, wj2.g r8, Function1 r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void n() {
        this.J = null;
        this.L = null;
        this.v = false;
        LivePromotionListFragment r1 = this.c;
        if (r1 == null) goto L6;
        r1.dismissAllowingStateLoss();
    L20:
        this.c = null;
        int r0 = ECSdk.a;
        ah2.a r2 = (ah2.a) ECSdk.a(ah2.a.class);
        if (r2 == null) goto L26;
        r2.onExitRoom();
        return;
    L26:
        return;
    L6:
        if (u() == false) goto L20;
        Context r3 = m();     // Catch: Exception -> L18
        if ((r3 instanceof FragmentActivity) == true) goto L10;
        r3 = null;
    L10:
        FragmentActivity r4 = (FragmentActivity) r3;     // Catch: Exception -> L18
        if (r4 == null) goto L20;
        FragmentManager r5 = r4.getSupportFragmentManager();     // Catch: Exception -> L18
        if (r5 == null) goto L20;
        Fragment r6 = r5.findFragmentByTag("live_promotion_fragment");     // Catch: Exception -> L18
        if (r6 == null) goto L20;
        r5.beginTransaction().remove(r6).commitNow();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L20
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
    }

    static {
        T = new a();
    }

    @JvmStatic
    public static final fh2.a H() {
        T.getClass();
        PromotionListController r0 = a.a();
        if (r0.x() == true) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final boolean J() {
        if (this.s != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void K() {
        if (((Boolean) ECLiveKmpABUtils.a.getValue()).booleanValue() == false) goto L6;
        com.bytedance.android.livesdk.livecommerce.kmp.b r0 = A().w;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        this.J = null;
        d r2 = this.r;
        if (r2 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.utils.k.a.removeCallbacks(r2);
    L5:
        this.r = null;
        if (this.h <= 0) goto L12;
        String r10 = B();
        String r11 = y();
        int r12 = this.i;
        long r13 = this.k;
        long r15 = SystemClock.elapsedRealtime() - this.h;
        boolean r3 = this.l;
        boolean r4 = this.m;
        boolean r5 = this.n;
        boolean r6 = this.o;
        String r8 = this.q;
        Long r9 = ((ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue()).c;
        if (r9 == null) goto L10;
        long r22 = SystemClock.elapsedRealtime() - r9.longValue();
    L11:
        new r1(r10, r11, r12, r13, r15, r3, r4, r5, r6, r8, r22).k();
        goto L12
    L10:
        r22 = -1;
    L12:
        this.h = -1;
        this.i = 0;
        this.j = 0;
        this.k = -1;
        this.l = false;
        this.m = false;
        this.p = false;
        this.n = false;
        this.o = false;
        this.D = null;
        this.q = "";
        LivePromotionListCacheCenter r7 = this.F;
        if (r7 == null) goto L15;
        r7.e();
    L15:
        this.F = null;
        this.e = false;
        this.Q = null;
        ((LinkedHashMap) this.K).clear();
        ECLiveDialogHoverManager r14 = this.R;
        if (r14 == null) goto L21;
        int r16 = ECLiveDialogHoverManager.j;
        dm.a.a("LiveHover").i("Clear fragmentLifecycleCallback");
        FragmentManager r17 = r14.e;
        if (r17 == null) goto L20;
        r17.unregisterFragmentLifecycleCallbacks(r14.d);
    L20:
        ((ArrayList) r14.b).clear();
        ((ArrayList) r14.a).clear();
        ((ArrayList) r14.c).clear();
    L21:
        this.R = null;
        mj2.b r18 = this.S;
        r18.a = null;
        r18.b = null;
        r18.c = true;
        r18.d = true;
        super.onExitRoom();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onRoomVisible() {
        int r0 = ECLiveDialogHoverManager.j;
        boolean r1 = ECLiveDialogHoverManager.a.a(A().t.U);
        if (w() == true) goto L5;
        return;
    L5:
        if (u() == true) goto L7;
        return;
    L7:
        if (this.R != null) goto L15;
        if (r1 == false) goto L10;
    L11:
        this.R = new ECLiveDialogHoverManager(m(), B(), D(), r1);
        return;
    L10:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() == 1) goto L11;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        int r0 = xh2.a.a();
        if (r0 != 1) goto L5;
        O("widget_load_finished");
        return;
    L5:
        if (r0 != 2) goto L11;
        d r1 = new d(this);
        this.r = r1;
        com.bytedance.android.livesdk.livecommerce.utils.k.a.postDelayed(r1, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
    }

    public PromotionListController(RealRoomController$roomResources$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "roomResources");
        super(r3);
        this.d = new ArrayList();
        this.h = -1;
        this.k = -1;
        this.q = "";
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.y = "";
        this.z = "";
        this.K = new LinkedHashMap();
        this.N = new Object();
        this.O = PromotionListController$pageRequestOnNext$1.INSTANCE;
        this.P = PromotionListController$pageRequestOnError$1.INSTANCE;
        this.S = new mj2.b(0);
        hh2.a.a().g.getClass();
        Lazy r4 = ECAppInfoService.a;
        ECAppInfoService.k();
    }

    public final void I(com.bytedance.android.ec.adapter.api.state.a r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (s() == true) goto L44;
        boolean r0 = true;
        if (((Boolean) ECLiveKmpABUtils.a.getValue()).booleanValue() == true) goto L9;
    L39:
        if (r0 == true) goto L41;
        return;
    L41:
        if (this.F != null) goto L46;
        this.F = new LivePromotionListCacheCenter(y(), z(), B(), new PromotionListController$initCacheCenter$1(this), new PromotionListController$initCacheCenter$2(this), A().m);
        return;
    L46:
        return;
    L9:
        if (w() == false) goto L35;
        nj.d r9 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (C().c == true) goto L35;
        int r2 = com.bytedance.android.livesdk.livecommerce.largemode.a.c;
        if (com.bytedance.android.livesdk.livecommerce.largemode.a.C0076a.a() > 1.0d) goto L16;
    L17:
        if (r9 == null) goto L19;
        r9.isFold();
    L19:
        if (r9 == null) goto L22;
        r9.isPad();
    L22:
        if (C().v >= 1) goto L24;
    L25:
        n1 r10 = A().m.f;
        if (r10 == null) goto L34;
        List r11 = r10.a();
        if (r11 == null) goto L34;
        if ((!r11.isEmpty()) != true) goto L34;
        if (((Boolean) ECLiveKmpABUtils.h.getValue()).booleanValue() == false) goto L35;
    L34:
        boolean r12 = false;
    L36:
        if (r12 == true) goto L39;
        r0 = false;
        goto L39
    L24:
        if (((Boolean) ECLiveKmpABUtils.i.getValue()).booleanValue() == false) goto L35;
    L16:
        if (((Boolean) ECLiveKmpABUtils.d.getValue()).booleanValue() == true) goto L17;
    L35:
        r12 = true;
        goto L36
    }

    public final void O(String r5) {
        Intrinsics.checkNotNullParameter(r5, "timing");
        if (this.p == false) goto L5;
        return;
    L5:
        if (A().t.V() == true) goto L7;
        return;
    L7:
        if (s() == false) goto L9;
        return;
    L9:
        if (this.b.o() == false) goto L11;
        return;
    L11:
        if (A().m.M() == false) goto L50;
        this.q = r5;
        boolean r6 = true;
        this.p = true;
        boolean r0 = xh2.a.b();
        Integer r2 = (Integer) EComABUtils.getLiveSettingValue(EComABUtils.AB_LIVE_LIST_CACHE_OPT_CLIENT_AI, 0);
        if (r2 != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L30;
        int r4 = ECSdk.a;
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r7 == null) goto L24;
        r7.getStrategyService();
    L24:
        Integer r8 = 1;
        int r9 = r8.intValue();
        if (r0 == false) goto L28;
        if (r9 != 1) goto L28;
    L29:
        r0 = r6;
    L28:
        r6 = false;
    L30:
        if (r0 == true) goto L32;
        return;
    L32:
        if (this.c == null) goto L34;
        return;
    L34:
        if (this.l == false) goto L36;
        return;
    L36:
        if (this.m == true) goto L48;
        int r10 = ECSdk.a;
        ah2.a r11 = (ah2.a) ECSdk.a(ah2.a.class);
        if (r11 == null) goto L49;
        Map r1 = C().m;
        new PromotionListController$tryPreloadPromotionList$1(this);
        r11.a();
        return;
    L49:
        return;
    L48:
        return;
    L17:
        if (r2.intValue() != 2) goto L19;
        r3 = true;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r6) {
        Intrinsics.checkNotNullParameter(r6, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r6, BaseCoreViewModel.CORE_TAG_STATE);
        if (w() == true) goto L5;
    L17:
        I(r6);
        return;
    L5:
        if (u() == false) goto L17;
        y r0 = A().m.c;
        if (r0 == null) goto L9;
        r0.setRoomId(B());
    L9:
        int r1 = ECLiveDialogHoverManager.j;
        boolean r2 = ECLiveDialogHoverManager.a.a(A().t.U);
        if (this.R != null) goto L17;
        if (com.bytedance.android.livesdk.livecommerce.room.controller.b.a(C()) == false) goto L17;
        if (r2 == false) goto L15;
    L16:
        this.R = new ECLiveDialogHoverManager(m(), B(), D(), r2);
        goto L17
    L15:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() != 1) goto L17;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificViewAttached(String r4) {
        Intrinsics.checkNotNullParameter(r4, "viewClassName");
        Intrinsics.checkNotNullParameter(r4, "viewClassName");
        if (Intrinsics.areEqual(r4, "cmd_first_chat_view_loaded") == true) goto L5;
        return;
    L5:
        if (xh2.a.a() != 2) goto L16;
        O("first_comment_show");
        if (com.bytedance.android.livesdk.livecommerce.room.controller.related.c.a() > 0) goto L9;
        this.L = null;
        return;
    L9:
        if (A().t.M().f(IRelatedInfoManager$Scene.PROMOTION_LIST) != null) goto L17;
        int r5 = ECSdk.a;
        pg.c r6 = (pg.c) ECSdk.a(pg.c.class);
        if (r6 == null) goto L18;
        new JSONObject().put("author_id", y()).put("room_id", B());
        r6.a(new PromotionListController$getClientAIProductListInfo$1(this));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        super.c(r1, r2);
        this.D = null;
    }

    public final LivePromotionListFragment L(Context r58, String r59, zk.b r60, c r61, wj2.g r62) {
        this.M = false;
        this.S.d = true;
        ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue();
        String r6 = B();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "roomId");
        r4.b("ec_perf_duration_promotion_list", "room_id", r6);
        r4.b("ec_perf_duration_promotion_list", "enter_from_merge", l0.d());
        r4.b("ec_perf_duration_promotion_list", "enter_method", l0.e());
        r4.t = Long.valueOf(System.currentTimeMillis());
        zk.b r13 = null;
        r4.v("ec_perf_duration_promotion_list", CollectionsKt.listOf(new String[]{"initial", "create_fragment_start"}), null);
        Map r10 = com.bytedance.android.ec.core.monitor.c.a;
        String r11 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.DURATION_LIVE_EC_PROMOTION_LIST, null);
        r4.r = r11;
        com.bytedance.android.ec.core.monitor.c.e(r11, "room_id", r6);
        com.bytedance.android.ec.core.monitor.c.e(r11, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r11, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.h(r11, MetricNames.DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r11, MetricNames.METRIC_CREATE_FRAGMENT_DURATION, null);
        r4.p(1, true);
        if ((r60 instanceof si2.b) == false) goto L6;
        r13 = r60;
    L6:
        si2.b r14 = (si2.b) r13;
        if (r14 == null) goto L9;
        boolean r7 = r14.b;
    L10:
        Intrinsics.checkNotNullParameter(r59, "openMethod");
        r4.f = r59;
        int r12 = r59.hashCode();
        if (r12 == (-907987551)) goto L24;
        if (r12 == (-552969852)) goto L21;
        if (r12 != 105529) goto L28;
        String r8 = "jsb";
        if (r59.equals("jsb") == false) goto L28;
    L29:
        r4.e = r8;
        if (Intrinsics.areEqual(r59, "schema") == false) goto L32;
        r4.d = true;
    L32:
        this.K.put("call_list_show", Long.valueOf(System.currentTimeMillis()));
        if (s() == false) goto L35;
        new com.bytedance.android.livesdk.livecommerce.event.f(B()).k();
    L35:
        String r5 = y();
        String r9 = z();
        String r15 = B();
        int r16 = ECSdk.a;
        if (ECSdk.a(IECCommonService.class) != null) goto L40;
        return null;
    L40:
        if ((r58 instanceof FragmentActivity) == false) goto L487;
        f2 r17 = f2.b;
        ((ConcurrentHashMap) r17.a).put("live_list_channel", r60.entryName());
        String r18 = r60.getCouponId();
        FragmentManager r19 = ((FragmentActivity) r58).getSupportFragmentManager();
        if (s() == true) goto L458;
        Lazy r0 = LiveDynamicContext.c;
        LiveListTabResortAbility r1 = (LiveListTabResortAbility) LiveDynamicContext.a.a().a().get("tab_resort");
        if (r1 == null) goto L46;
        r1.g();
        Unit r2 = Unit.INSTANCE;
    L46:
        LiveRoomParams r20 = l();
        RoomContextController r3 = ControllerExtensionsKt.c(A().m, r15);
        if (EComABUtils.isArsEnable() == true) goto L49;
        r9 = r9;
        String r510 = "tab_resort";
        r19 = r19;
    L73:
        oh.a.c("livesdk_live_list_should_open", new v(r59, r3));
        if (Intrinsics.areEqual(r59, "live_shopping_cart") == false) goto L86;
        if (r18 != null) goto L77;
    L80:
        boolean r21 = true;
    L81:
        if (r21 == false) goto L86;
        if (this.i != 0) goto L85;
        this.k = SystemClock.elapsedRealtime() - this.h;
    L85:
        int r22 = 1;
        this.i++;
    L87:
        this.j += r22;
        ECLivePerformanceMonitor r23 = (ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue();
        if (cg4.a.a(r18) == true) goto L90;
        r23.g += r22;
    L90:
        r23.b("ec_perf_duration_promotion_list", "pop_times", String.valueOf(r23.g));
        String r24 = r23.r;
        if (r24 == null) goto L94;
        com.bytedance.android.ec.core.monitor.c.e(r24, "pop_times", String.valueOf(r23.g));
    L94:
        if ((r60 instanceof si2.b) == true) goto L96;
        zk.b r25 = null;
    L97:
        si2.b r26 = (si2.b) r25;
        if (r26 != null) goto L100;
    L122:
        String r27 = null;
    L123:
        boolean r28 = true;
    L124:
        boolean r29 = r60 instanceof com.bytedance.android.livesdk.livecommerce.router.c;
        if (r29 == false) goto L127;
        com.bytedance.android.livesdk.livecommerce.router.c r30 = (com.bytedance.android.livesdk.livecommerce.router.c) r60;
        String r31 = r30.b();
        String r43 = r30.a();
    L128:
        boolean r32 = EntryController.M1;
        if (TextUtils.isEmpty(EntryController.a.a().Q) == true) goto L131;
        r31 = EntryController.a.a().Q;
    L131:
        if (r61 == null) goto L142;
        String r33 = r61.a;
        if (r33 == null) goto L137;
        String r34 = a2.d(r33);
        if (r34 == null) goto L137;
        Unit r35 = Unit.INSTANCE;
        r27 = r34;
    L137:
        r28 = r61.b;
        String r36 = r61.c;
        if (r36 == null) goto L142;
        String r37 = a2.d(r36);
        if (r37 == null) goto L142;
        Unit r38 = Unit.INSTANCE;
        String r110 = r27;
        boolean r111 = r28;
        String r39 = r37;
    L143:
        boolean r40 = ((Boolean) o().getHasCouponEntryShown().getValue()).booleanValue();
        if (EComABUtils.useNewLiveListAutoApplyCoupon(0) != 1) goto L160;
        ShortTouchCouponMsgEvent r41 = (ShortTouchCouponMsgEvent) o().getShortTouchCouponInfo().getValue();
        if (r41 == null) goto L148;
        boolean r42 = r41.getHasCoupon();
    L150:
        if (EComABUtils.useNewLiveListAutoApplyCouponOpt() != 1) goto L159;
        if (r41 == null) goto L157;
        List<ShortTouchCouponInfo> r44 = r41.getInfos();
        if (r44 == null) goto L157;
        ShortTouchCouponInfo r45 = (ShortTouchCouponInfo) CollectionsKt.firstOrNull(r44);
        if (r45 == null) goto L157;
        int r46 = r45.getApplyType();
    L158:
        int r47 = r46;
        boolean r48 = r42;
    L161:
        com.bytedance.android.ec.adapter.api.state.a r49 = C();
        if (((Boolean) o().isCartShow().getValue()).booleanValue() == true) goto L173;
        if (r61 == null) goto L167;
        ml.b r50 = r61.f;
        if (r50 == null) goto L167;
        String r51 = r50.roomId();
    L169:
        if (cg4.a.a(r51) == false) goto L173;
        if (EComABUtils.enablePromotionListUseSchemaRoomId() == false) goto L173;
        boolean r52 = true;
    L174:
        RelatedInfoManager r53 = A().t.M();
        JSONArray r112 = this.L;
        r53.getClass();
        if (r112 != null) goto L177;
    L200:
        String r410 = r39;
    L201:
        boolean r411 = r48;
        String r412 = r110;
        boolean r413 = r111;
    L202:
        if (r52 == false) goto L289;
        if (r18 != null) goto L205;
    L208:
        boolean r54 = true;
    L209:
        if (r54 == false) goto L289;
        xh2.b r55 = new xh2.b(r15, A().m);
        if (r61 == null) goto L215;
        ml.b r56 = r61.f;
        if (r56 == null) goto L215;
        String r57 = r56.c();
    L216:
        if (r61 == null) goto L220;
        ml.b r63 = r61.f;
        if (r63 == null) goto L220;
        String r64 = r63.d();
    L221:
        if (r61 == null) goto L225;
        ml.b r65 = r61.f;
        if (r65 == null) goto L225;
        String r66 = r65.roomId();
    L226:
        String r113 = r60.entryName();
        r49.getClass();
        if (r61 == null) goto L229;
        String r511 = r61.e;
    L230:
        if (r20 == null) goto L272;
        if (r61 == null) goto L235;
        ml.b r67 = r61.f;
        if (r67 == null) goto L235;
        String r68 = r67.roomId();
    L236:
        if (r68 != null) goto L238;
        String r114 = "";
    L240:
        if (r61 == null) goto L244;
        ml.b r69 = r61.f;
        if (r69 == null) goto L244;
        String r70 = r69.c();
    L245:
        if (r70 != null) goto L247;
        r70 = "";
    L247:
        if (r61 == null) goto L251;
        ml.b r71 = r61.f;
        if (r71 == null) goto L251;
        String r72 = r71.d();
    L252:
        if (r72 != null) goto L254;
        String r210 = "";
    L255:
        Map r73 = MapsKt.toMutableMap(r20.getReportParams());
        r73.remove("creative_id");
        r73.remove("is_other_channel");
        r73.remove("log_extra");
        r73.remove("search_params");
        r73.remove("live_tracker_params");
        r73.put("follow_status", "");
        if (r61 == null) goto L260;
        ml.b r74 = r61.f;
        if (r74 == null) goto L260;
        String r75 = r74.roomId();
    L261:
        if (r75 != null) goto L263;
        r75 = "";
    L263:
        r73.put("room_id", r75);
        if (r61 == null) goto L268;
        ml.b r76 = r61.f;
        if (r76 == null) goto L268;
        String r77 = r76.c();
    L269:
        if (r77 != null) goto L271;
        r77 = "";
    L271:
        r73.put("anchor_id", r77);
        Unit r78 = Unit.INSTANCE;
        LiveRoomParams r211 = LiveRoomParams.copy$default(r20, r114, null, r70, r210, null, null, r73, MapsKt.emptyMap(), null, PromotionListController$showLivePromotionListFragment$argument$2.INSTANCE, PromotionListController$showLivePromotionListFragment$argument$3.INSTANCE, PromotionListController$showLivePromotionListFragment$argument$4.INSTANCE, PromotionListController$showLivePromotionListFragment$argument$5.INSTANCE, PromotionListController$showLivePromotionListFragment$argument$6.INSTANCE, null, null, null, null, null, null, null, 0, 3653682, null);
    L274:
        if (r61 == null) goto L276;
        JSONObject r212 = r61.g;
    L277:
        boolean r115 = this.e;
        RoomContextController r79 = A().m;
        if (r61 == null) goto L280;
        String r213 = r61.h;
    L281:
        if (r29 == true) goto L283;
        zk.b r80 = null;
    L284:
        com.bytedance.android.livesdk.livecommerce.router.c r81 = (com.bytedance.android.livesdk.livecommerce.router.c) r80;
        if (r81 == null) goto L287;
        String r214 = r81.c();
    L288:
        String r512 = r510;
        com.bytedance.android.livesdk.livecommerce.iron.ui.k r310 = new com.bytedance.android.livesdk.livecommerce.iron.ui.k(r55, r57, r64, r66, r18, r411, r47, r113, r412, r413, false, r410, r59, null, null, 0, r511, r211, null, r15, r212, r115, r43, r62, r79, r213, r214, 2105346);
    L314:
        com.bytedance.android.livesdk.livecommerce.iron.ui.k r82 = r310;
        nj.d r83 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r83 == null) goto L317;
        r83.l();
    L317:
        K();
        if (EComABUtils.listRequestTimeOpt() == false) goto L408;
        ECLiveABUtils r85 = ECLiveABUtils.INSTANCE;
        r85.getEC_LIVE_SPLIT_PROMOTION_LIST_REQUEST().booleanValue();
        boolean r215 = false;
        Lazy r86 = LiveDynamicContext.c;
        LiveListTabResortAbility r87 = (LiveListTabResortAbility) LiveDynamicContext.a.a().a().get(r512);
        if (r87 != null) goto L322;
    L327:
        String r88 = null;
    L328:
        RealRoomController r89 = A();
        String r90 = B();
        if (r85.getENABLE_CONTROLLER_OPT() == true) goto L331;
        r89 = ControllerCenter.c(r90, null);
    L334:
        JSONObject r91 = r89.t.M().d(IRelatedInfoManager$Scene.PROMOTION_LIST);
        String r116 = r82.c;
        if (r116 != null) goto L337;
        String r92 = "";
    L338:
        String r117 = r82.d;
        if (r117 != null) goto L341;
        String r93 = r14;
    L342:
        String r118 = r82.e;
        if (r118 != null) goto L345;
        String r94 = r14;
    L346:
        RoomContextController r95 = r82.B;
        if (r95 == null) goto L352;
        String r119 = r95.D();
        if (r119 == null) goto L352;
        String r96 = r119;
    L353:
        String r120 = r82.w;
        if (r120 != null) goto L356;
        String r97 = r14;
    L357:
        boolean r121 = r82.a.isLinkmic();
        String r122 = r82.i;
        boolean r123 = r82.g;
        int r124 = r82.h;
        String r98 = r82.o;
        com.bytedance.android.livesdk.livecommerce.opt.f r125 = new com.bytedance.android.livesdk.livecommerce.opt.f();
        Application.ActivityLifecycleCallbacks r126 = ControllerCenter.a;
        String r127 = r125.toString();
        ((HashMap) com.bytedance.android.livesdk.livecommerce.opt.f.b).put(r127, r125);
        boolean r99 = this.v;
        String r128 = r82.j;
        boolean r100 = r82.k;
        if (cg4.a.a(r88) == false) goto L360;
    L366:
        JSONObject r129 = new JSONObject();
        if (r128 == null) goto L373;
        if (r100 == false) goto L370;
        String r101 = "anchor_promotion_id";
    L372:
        if (r129.put(r101, r128) == null) goto L373;
    L375:
        if (r88 == null) goto L377;
        r129.put("resort_promotion_category", r88);
    L377:
        String r102 = r129.toString();
    L378:
        final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r130 = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c(r92, r93, r94, r97, r96, r121, true, r122, r123, r124, r98, r127, r99, r102, this.e, null, r215, r82.C, r82.D, 229376);
        this.O = new PromotionListController$queryPromotionListOnShowFragment$1(this, r130);
        this.P = PromotionListController$queryPromotionListOnShowFragment$2.INSTANCE;
        Function1<vj2.b, Unit> r103 = new PromotionListController$queryPromotionListOnShowFragment$onNext$1(this);
        Function0<Unit> r131 = new PromotionListController$queryPromotionListOnShowFragment$onError$1(this);
        LivePromotionListCacheCenter r132 = this.F;
        if (r132 == null) goto L408;
        Intrinsics.checkNotNullParameter(r130, "requestParam");
        Intrinsics.checkNotNullParameter(r103, "onNext");
        Intrinsics.checkNotNullParameter(r131, "onError");
        mj2.e r104 = r132.j(r130);
        if (r104 == null) goto L388;
        List<? extends ql.a> r105 = r104.a;
        if (r105 == null) goto L388;
        if ((!r105.isEmpty()) == true) goto L408;
    L388:
        ControllerExtensionsKt.c(r132.m, r130.h).A().r.M = true;
        ECContext r106 = ControllerExtensionsKt.c(r132.m, r130.h).r();
        if (r106 == null) goto L395;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r107 = r106.getEcLivePerformanceMonitor();
        if (r107 == null) goto L395;
        ECLivePerformanceMonitor r108 = (ECLivePerformanceMonitor) r107.getValue();
        if (r108 == null) goto L395;
        r108.n(true);
    L395:
        Disposable r109 = r132.f.a(r130, 0, EComABUtils.liveListLoadPageSize(), 1, false, true).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.a(r103), new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.b(r131));
        if (EComABUtils.isLiveListMemoryLeakSwitchForDisposable() == false) goto L406;
        Disposable r133 = r132.h;
        if (r133 != null) goto L400;
    L405:
        r132.h = r109;
        goto L408
    L400:
        if ((!r133.isDisposed()) == true) goto L403;
        r133 = null;
    L403:
        if (r133 == null) goto L405;
        r133.dispose();
        goto L405
    L406:
        com.bytedance.android.ec.core.async.a.a(r109, r132.g);
        goto L408
    L370:
        r101 = "anchor_product_id";
    L373:
        if (r91 == null) goto L375;
        z1.b(r129, r91);
        goto L375
    L360:
        if (cg4.a.a(r128) == true) goto L366;
        if (r91 == null) goto L364;
        r102 = r91.toString();
        goto L378
    L364:
        r102 = null;
        goto L378
    L356:
        r97 = r120;
    L352:
        r96 = r14;
        goto L353
    L345:
        r94 = r118;
        goto L346
    L341:
        r93 = r117;
        goto L342
    L337:
        r92 = r116;
        goto L338
    L331:
        if (r89 != null) goto L334;
        r89 = ControllerCenter.c(null, null);
        goto L334
    L322:
        if (r87.d().e() != 2) goto L324;
        boolean r134 = true;
    L325:
        if (r134 == false) goto L327;
        r88 = r87.c;
        goto L328
    L324:
        r134 = false;
    L408:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L412;
        LivePromotionListCacheCenter r135 = this.F;
        if (r135 == null) goto L412;
        LivePromotionListCacheCenter.b(r135);
        Unit r136 = Unit.INSTANCE;
    L412:
        int r137 = LivePromotionListFragment.F;
        Intrinsics.checkNotNullParameter(r82, "argument");
        com.bytedance.android.livesdk.livecommerce.opt.f r138 = new com.bytedance.android.livesdk.livecommerce.opt.f();
        Application.ActivityLifecycleCallbacks r139 = ControllerCenter.a;
        String r140 = r138.toString();
        HashMap r141 = (HashMap) com.bytedance.android.livesdk.livecommerce.opt.f.b;
        r141.put(r140, r138);
        com.bytedance.android.livesdk.livecommerce.opt.f r142 = (com.bytedance.android.livesdk.livecommerce.opt.f) r141.get(r140);
        if (r142 != null) goto L418;
        com.bytedance.android.livesdk.livecommerce.opt.f r143 = (com.bytedance.android.livesdk.livecommerce.opt.f) r141.get("fake");
        if (r143 != null) goto L419;
        com.bytedance.android.livesdk.livecommerce.opt.f r144 = new com.bytedance.android.livesdk.livecommerce.opt.f();
        r141.put("fake", r144);
        r142 = r144;
    L419:
        ((HashMap) r143.a).put("duration", Long.valueOf(SystemClock.elapsedRealtime()));
        SystemClock.elapsedRealtime();
        Bundle r145 = new Bundle();
        String r146 = r82.e;
        if (r146 != null) goto L422;
        String r147 = r14;
    L423:
        String r148 = r82.w;
        if (r148 != null) goto L426;
        String r149 = r14;
    L427:
        String r150 = r82.c;
        if (r150 != null) goto L430;
        String r151 = r14;
    L431:
        String r152 = r82.d;
        if (r152 != null) goto L434;
        String r153 = r14;
    L435:
        boolean r154 = r82.g;
        int r155 = r82.h;
        String r156 = r82.p;
        String r157 = r82.f;
        String r158 = r82.i;
        String r159 = a2.d(r82.j);
        boolean r160 = r82.k;
        String r161 = r82.o;
        boolean r162 = r82.n;
        boolean r163 = r82.y;
        String r164 = r82.z;
        String r165 = r82.q;
        String r166 = r82.r;
        int r167 = r82.s;
        JSONObject r168 = r82.x;
        if (r168 == null) goto L438;
        Map r169 = z1.j(r168);
    L439:
        r145.putSerializable("initial_params", new LivePromotionListParams(r147, r149, r151, r153, r154, r155, r156, r140, r157, r158, r159, r160, r161, r162, false, r163, r164, r165, r166, r167, r169, r82.C, r82.D, 16384, null));
        r145.putString("source_btm_token", r82.t);
        final LivePromotionListFragment r170 = new LivePromotionListFragment();
        r170.setArguments(r145);
        r170.p = r82.a;
        r170.r = r82.b;
        r170.s = r82.u;
        r170.w = r82.A;
        r170.t = r82.v;
        r170.u = r82.B;
        if (this.b.l() == false) goto L442;
        q().e();
    L442:
        final FragmentManager r171 = r19;
        Function0<Unit> r172 = new PromotionListController$showLivePromotionListFragment$5(r170, r171);
        int r173 = com.bytedance.android.livesdk.livecommerce.iron.ui.a.a;
        Intrinsics.checkNotNullParameter("live_promotion_fragment", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r172, "init");
        if (r171 != null) goto L489;
    L452:
        this.c = r170;
        int r174 = RoomContextController.h;
        ECContext r175 = RoomContextController.a.a().r();
        if (r175 == null) goto L457;
        com.bytedance.live.datacontext.m<Boolean> r176 = r175.isPromotionListShow();
        if (r176 == null) goto L457;
        r176.setValue(Boolean.TRUE);
    L457:
        return r170;
    L489:
        Fragment r177 = r171.findFragmentByTag("live_promotion_fragment");     // Catch: Throwable -> L450
        if (r177 == null) goto L448;
        r171.beginTransaction().remove(r177).commitNow();     // Catch: Throwable -> L450
    L448:
        r172.invoke();     // Catch: Throwable -> L450
    L450:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L452
    L438:
        r169 = null;
        goto L439
    L434:
        r153 = r152;
        goto L435
    L430:
        r151 = r150;
        goto L431
    L426:
        r149 = r148;
        goto L427
    L422:
        r147 = r146;
    L418:
        r143 = r142;
        goto L419
    L287:
        r214 = null;
        goto L288
    L283:
        r80 = r60;
        goto L284
    L280:
        r213 = null;
        goto L281
    L276:
        r212 = null;
    L268:
        r77 = null;
    L260:
        r75 = null;
        goto L261
    L254:
        r210 = r72;
    L251:
        r72 = null;
    L244:
        r70 = null;
        goto L245
    L238:
        r114 = r68;
    L235:
        r68 = null;
        goto L236
    L272:
        r211 = null;
        goto L274
    L229:
        r511 = null;
    L225:
        r66 = null;
    L220:
        r64 = null;
    L215:
        r57 = null;
        goto L216
    L205:
        if (r18.length() == 0) goto L208;
        r54 = false;
    L289:
        r512 = r510;
        xh2.b r178 = new xh2.b(r15, A().m);
        String r179 = r60.entryName();
        boolean r180 = r49.i;
        boolean r181 = EntryController.M1;
        String r182 = EntryController.a.a().N;
        String r183 = EntryController.a.a().O;
        int r184 = EntryController.a.a().P;
        if (r61 == null) goto L292;
        String r185 = r61.e;
    L293:
        String r186 = r185;
        if (r61 == null) goto L296;
        ml.b r187 = r61.f;
    L297:
        ml.b r216 = r187;
        if (r61 == null) goto L300;
        JSONObject r188 = r61.g;
    L301:
        JSONObject r217 = r188;
        boolean r189 = this.e;
        RoomContextController r190 = A().m;
        if (r61 == null) goto L304;
        String r191 = r61.h;
    L305:
        String r218 = r191;
        if (r29 != 0) goto L308;
        zk.b r192 = null;
    L309:
        com.bytedance.android.livesdk.livecommerce.router.c r193 = (com.bytedance.android.livesdk.livecommerce.router.c) r192;
        if (r193 == null) goto L312;
        String r194 = r193.c();
    L313:
        r310 = new com.bytedance.android.livesdk.livecommerce.iron.ui.k(r178, r5, r9, r15, r18, r411, r47, r179, r412, r413, r180, r410, r59, r182, r183, r184, r186, r20, r216, r15, r217, r189, r43, r62, r190, r218, r194, 8194);
        goto L314
    L312:
        r194 = null;
        goto L313
    L308:
        r192 = r60;
        goto L309
    L304:
        r191 = null;
        goto L305
    L300:
        r188 = null;
        goto L301
    L296:
        r187 = null;
        goto L297
    L292:
        r185 = null;
        goto L293
    L177:
        if (r112.length() <= 0) goto L179;
        boolean r195 = true;
    L180:
        if (r195 == false) goto L182;
        JSONArray r196 = r112;
    L183:
        if (r196 == null) goto L200;
        r410 = r39;
        if (r53.a(IRelatedInfoManager$FromSource.CLIENT_AI_PRODUCT_INFO) == false) goto L201;
        ArrayList r197 = new ArrayList();
        r413 = r111;
        int r198 = r112.length();
        int r199 = com.bytedance.android.livesdk.livecommerce.room.controller.related.c.a;
        r412 = r110;
        r411 = r48;
        int r200 = Math.min(r198, ((Number) EComABUtils.getLiveSettingValue("ec_live_smart_product_limit", 3)).intValue());
        int r1100 = 0;
    L189:
        if (r1100 >= r200) goto L197;
        JSONObject r1101 = JSONArrayProtectorUtils.getJSONObject(r112, r1100);
        if (r1101 == null) goto L195;
        String r1102 = r1101.optString("product_id");
        if (r1102 == null) goto L195;
        r197.add(r1102);
    L195:
        r1100 = r1100 + 1;
        goto L189
    L197:
        if ((!r197.isEmpty()) == false) goto L202;
        JSONObject r201 = new JSONObject();
        r201.put("smart_product_id", CollectionsKt.joinToString$default(r197, ",", null, null, 0, null, null, 62, null));
        JSONArray r202 = new JSONArray();
        JSONObject r1103 = new JSONObject();
        JSONObject r1104 = new JSONObject();
        int r1105 = com.bytedance.android.livesdk.livecommerce.room.controller.related.c.a;
        r1104.put("list_show_count", ((Number) EComABUtils.getLiveSettingValue("ec_live_smart_product_show_count", 1)).intValue());
        r1104.put(LocationMonitorConst.TYPE, new JSONArray().put("promotion_list_top"));
        Unit r203 = Unit.INSTANCE;
        r1103.put("client_config", r1104);
        r1103.put("id", "smart_product_id");
        JSONObject r204 = new JSONObject();
        r204.put("list_show_duration", ((Number) EComABUtils.getLiveSettingValue("ec_live_smart_product_duration", -1)).intValue());
        r204.put("list_show_index", ((Boolean) EComABUtils.getLiveSettingValue("ec_live_smart_product_show_index", Boolean.FALSE)).booleanValue());
        r204.put("related_message", false);
        r1103.put("server_config", r204);
        r201.put("related_config", r202.put(r1103));
        r53.i(r201.toString(), IRelatedInfoManager$FromSource.CLIENT_AI_PRODUCT_INFO);
        goto L202
    L182:
        r196 = null;
        goto L183
    L179:
        r195 = false;
    L167:
        r51 = null;
    L173:
        r52 = false;
    L157:
        r46 = 1;
        goto L158
    L159:
        r40 = r42;
        goto L160
    L148:
        r42 = false;
    L160:
        r48 = r40;
        r47 = -1;
    L142:
        r110 = r27;
        r111 = r28;
        r39 = r31;
        goto L143
    L127:
        r31 = null;
        r43 = null;
        goto L128
    L100:
        if (r26.a != true) goto L122;
        String r205 = p().get("jump_schema");     // Catch: Throwable -> L118
        if (r205 == null) goto L111;
        Uri r206 = UriProtector.parse(r205);     // Catch: Throwable -> L118
        if (r206 == null) goto L111;
        String r207 = UriProtector.getQueryParameter(r206, "extra");     // Catch: Throwable -> L118
        if (r207 == null) goto L111;
        HashMap r208 = com.bytedance.android.ec.core.hybrid.utils.j.a;     // Catch: Throwable -> L118
        JSONObject r209 = com.bytedance.android.ec.core.hybrid.utils.j.i(r207);     // Catch: Throwable -> L118
        if (r209 == null) goto L111;
        String r219 = r209.optString("promotion_id");     // Catch: Throwable -> L118
    L112:
        if (r219 == null) goto L491;
    L121:
        r27 = r219;
        goto L123
    L491:
        r27 = p().get("product_id");     // Catch: Throwable -> L116
        r28 = false;
    L116:
        th = th;
    L120:
        ECExceptionMonitor.e(th);
    L111:
        r219 = null;
    L118:
        th = th;
        r219 = null;
        goto L120
    L96:
        r25 = r60;
        goto L97
    L77:
        if (StringsKt.isBlank(r18) == true) goto L80;
        r21 = false;
    L86:
        r22 = 1;
        goto L87
    L49:
        ECContext r220 = ControllerExtensionsKt.c(A().m, r15).r();
        if (r220 == null) goto L57;
        com.bytedance.live.datacontext.i<yg2.a> r1106 = r220.getEcLiveActionRecordService();
        if (r1106 == null) goto L57;
        r510 = "tab_resort";
        yg2.a r221 = (yg2.a) r1106.getValue();
        if (r221 == null) goto L59;
        r9 = r9;
        r221.d(new xg2.e(Action.SHOP_LIST_OPEN));
    L59:
        if (r220 == null) goto L65;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r222 = r220.getEcLivePerformanceMonitor();
        if (r222 == null) goto L65;
        ECLivePerformanceMonitor r223 = (ECLivePerformanceMonitor) r222.getValue();
        if (r223 == null) goto L65;
        String r224 = r223.e;
    L66:
        if (r220 == null) goto L73;
        com.bytedance.live.datacontext.i<yg2.a> r225 = r220.getEcLiveActionRecordService();
        if (r225 == null) goto L73;
        yg2.a r226 = (yg2.a) r225.getValue();
        if (r226 == null) goto L73;
        r226.d(new xg2.b(Action.SHOP_LIST_OPEN, MapsKt.mapOf(TuplesKt.to("action_from", r224))));
    L65:
        r224 = null;
    L57:
        r510 = "tab_resort";
        goto L59
    L458:
        boolean r227 = true;
        RealRoomController r228 = A();
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L463;
        if (r228 != null) goto L462;
        r228 = ControllerCenter.c(null, null);
    L462:
        String r229 = r15;
    L464:
        FlashController r230 = r228.p;
        boolean r231 = LynxAnchorPromotionListUtils.a;
        int r232 = ch2.b.a;
        Bundle r233 = C().n;
        if (r233 == null) goto L467;
        boolean r234 = false;
        boolean r235 = r233.getBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", false);
    L468:
        Bundle r236 = C().n;
        if (r236 == null) goto L471;
        boolean r237 = r236.getBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN", r234);
    L472:
        FlashController.b r238 = r230.e;
        if (r238 != null) goto L475;
    L477:
        r227 = false;
    L478:
        boolean r239 = r230.c;
        if (r238 == null) goto L481;
        String r240 = r238.c;
    L482:
        String r1107 = r240;
        if (r1107 != null) goto L485;
        r1107 = "";
    L485:
        Intrinsics.checkNotNullParameter(r229, "roomId");
        Intrinsics.checkNotNullParameter(r1107, "shopId");
        String r241 = ECSettingKeys.j().b() + "&ecom_sdk_version=44700&room_id=" + r229 + "&commodity_no_filter=" + com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r235)) + "&no_commodity_filter_default=" + com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r237)) + "&flash_sale_switch_on=" + com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r239)) + "&is_auth_flash_sale=" + com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r227)) + "&shop_id=" + r1107;
        dm.a.a("enable_ecom_anchor_new_infra").i(r241);
        com.bytedance.android.livesdk.livecommerce.utils.k.i(r58, r241);
        int r242 = lh.b.a;
        lh.b.c(ProcessDomain.LIVE, "主播半屏商列", "打开半屏商列");
        return null;
    L481:
        r240 = null;
        goto L482
    L475:
        if (r238.f != true) goto L477;
    L471:
        r237 = false;
        goto L472
    L467:
        r234 = false;
        r235 = false;
        goto L468
    L463:
        r229 = r15;
        r228 = ControllerCenter.c(r229, null);
        goto L464
    L487:
        return null;
    L28:
        r8 = "";
        goto L29
    L21:
        if (r59.equals("live_shopping_cart") == false) goto L28;
        r8 = "click_shopping_cart";
        goto L29
    L24:
        if (r59.equals("schema") == false) goto L28;
        if (r7 == false) goto L27;
        r8 = "schema_enter_room";
        goto L29
    L27:
        r8 = "schema_in_room";
        goto L29
    L9:
        r7 = false;
        goto L10
    }

    public final void M(Context r14, String r15, zk.b r16, c r17, boolean r18, wj2.g r19, Function0<Unit> r20, Function1<? super Fragment, Unit> r21) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "openMethod");
        Intrinsics.checkNotNullParameter(r16, "livePromotionListParams");
        boolean r0 = A().m.M();
        ECLiveEntranceMonitor.trace$default("showLivePromotionListFragment hasLogin=" + r0, "PromotionListController", false, 4, null);
        if (r0 == true) goto L10;
        int r1 = ECLiveLoginHelper.a;
        int r2 = C().v;
        ECLiveABUtils r3 = ECLiveABUtils.INSTANCE;
        if (ECLiveLoginHelper.c(r2, r3.getECOM_LIVE_LIST_NO_LOGIN().booleanValue()) == true) goto L10;
        int r4 = ge.b.h;
        ge.b.a r5 = new ge.b.a();
        r5.c = -1;
        Intrinsics.checkNotNullParameter("live_detail", "enterFrom");
        r5.e = "live_detail";
        Intrinsics.checkNotNullParameter("livesdk_click_product", "actionType");
        r5.f = "livesdk_click_product";
        Intrinsics.checkNotNullParameter("live_list_card", "source");
        r5.d = "live_list_card";
        if (r3.getECOM_LIVE_LOGIN_HALF_SCREEN().booleanValue() == false) goto L9;
        Bundle r6 = new Bundle();
        r6.putBoolean("show_half_page", true);
        Unit r7 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "bundle");
        r5.g = r6;
    L9:
        yj2.b.a(r14, new ge.b(r5), new e(this, r20, r14, r15, r16, r18, r17, r19, r21));
        return;
    L10:
        if (r20 == null) goto L12;
        Unit r8 = (Unit) r20.invoke();
    L12:
        LivePromotionListFragment r9 = L(r14, r15, r16, r17, r19);
        if (r21 == null) goto L17;
        Unit r10 = (Unit) r21.invoke(r9);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N(PromotionListController r11, Context r12, String r13, zk.b r14, c r15, boolean r16, wj2.g r17, Function0 r18, Function1 r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        Context r3 = r11.m();
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = "live_shopping_cart";
    L11:
        if ((r20 & 8) == 0) goto L13;
        c r6 = null;
    L15:
        if ((r20 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r20 & 32) == 0) goto L21;
        wj2.g r8 = null;
    L23:
        if ((r20 & 64) == 0) goto L25;
        Function0 r9 = null;
    L27:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L29;
        Function1 r10 = null;
    L30:
        r11.M(r3, r4, r14, r6, r7, r8, r9, r10);
        return;
    L29:
        r10 = r19;
        goto L30
    L25:
        r9 = r18;
        goto L27
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }
}
