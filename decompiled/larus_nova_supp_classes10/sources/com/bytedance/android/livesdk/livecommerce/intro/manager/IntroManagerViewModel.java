package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.os.SystemClock;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.livesdk.livecommerce.event.o0;
import com.bytedance.android.livesdk.livecommerce.intro.card.base.AbsViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.q0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroUpdateType;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB)\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bD\u0010EJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J¦\u0001\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00042D\b\u0002\u0010\u001c\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014J\\\u0010!\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\b2$\u0010\u001c\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u00062\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\b\u0010$\u001a\u00020\u0006H\u0014R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R(\u00104\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u0004\u0018\u00010>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/manager/IntroManagerViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/base/AbsViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/opt/ECLivePerformanceMonitor;", "getEntryMonitor", "", "isShow", "", "onCardLoadFinish", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "cardScene", "Lkotlin/Pair;", "", "delayPair", "Lsh2/b;", "productInfo", "", "forcePath", "", "extraRequestParams", "shouldExtendSameCardDuration", "Lkotlin/Function2;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/LiveIntroResponse;", "Lkotlin/ParameterName;", "name", "introResp", "", "Luh2/a;", "introVOList", "callback", "queryIntro", "liveIntroResp", "isRetry", "isFromCache", "handleIntroResp", "introVOs", "updateIntroVOs", "onCleared", "Lbk2/e;", "Luh2/c;", "introVOLiveData", "Lbk2/e;", "getIntroVOLiveData", "()Lbk2/e;", "Lcom/bytedance/android/livesdk/livecommerce/intro/utils/IntroCardLoadOpt;", "cardLoadOpt", "Lcom/bytedance/android/livesdk/livecommerce/intro/utils/IntroCardLoadOpt;", "Lio/reactivex/disposables/Disposable;", "introRequestDispose", "Lio/reactivex/disposables/Disposable;", "introRetryDispose", "Ljava/lang/Runnable;", "value", "delayRunnable", "Ljava/lang/Runnable;", "setDelayRunnable", "(Ljava/lang/Runnable;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/manager/r;", "repo", "Lcom/bytedance/android/livesdk/livecommerce/intro/manager/r;", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "liveRoomInfo", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "liveRoomParams", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "roomContextController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/intro/manager/r;Lcom/bytedance/android/livesdk/livecommerce/room/model/e;Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroManagerViewModel extends AbsViewModel {
    public static final a Companion = null;
    private static final int LIMITED_CODE = 300010001;
    private final IntroCardLoadOpt cardLoadOpt;
    private Runnable delayRunnable;
    private Disposable introRequestDispose;
    private Disposable introRetryDispose;
    private final bk2.e<uh2.c> introVOLiveData;
    private final com.bytedance.android.livesdk.livecommerce.room.model.e liveRoomInfo;
    private final LiveRoomParams liveRoomParams;
    private final r repo;
    private final RoomContextController roomContextController;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IntroManagerViewModel a;

        public b(IntroManagerViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroManagerViewModel.access$onCardLoadFinish(this.a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ IntroManagerViewModel a;
        public final /* synthetic */ IntroCardScene b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Pair e;
        public final /* synthetic */ sh2.b f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Map h;

        public c(IntroManagerViewModel r1, IntroCardScene r2, Function2 r3, boolean r4, Pair r5, sh2.b r6, String r7, Map r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r12) {
            LiveIntroResponse r1 = (LiveIntroResponse) r12;
            int r13 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
            StringBuilder r14 = new StringBuilder("[query] query intro success, statusCode=");
            if (r1 == null) goto L5;
            Integer r2 = Integer.valueOf(((com.bytedance.android.ec.model.g) r1).statusCode);
        L6:
            r14.append(r2);
            com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(r14.toString());
            ECLivePerformanceMonitor r15 = IntroManagerViewModel.access$getEntryMonitor(this.a);
            if (r15 == null) goto L9;
            r15.l();
        L9:
            int r16 = ((com.bytedance.android.ec.model.g) r1).statusCode;
            if (r16 != 0) goto L13;
            IntroManagerViewModel.handleIntroResp$default(this.a, r1, this.b, this.c, false, false, this.d, 24, null);
            return;
        L13:
            if (r16 != IntroManagerViewModel.LIMITED_CODE) goto L18;
            Pair r17 = this.e;
            if (r17 != null) goto L17;
            IntroManagerViewModel.handleIntroResp$default(this.a, null, this.b, this.c, false, false, this.d, 24, null);
            return;
        L17:
            long r0 = ((Number) r17.getFirst()).longValue();
            long r3 = (long) (r0 + ((((Number) this.e.getSecond()).longValue() - r0) * new SecureRandom().nextFloat()));
            com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[query] query intro was limited, retry after " + r3 + " ms");
            new o0().k();
            IntroManagerViewModel r18 = this.a;
            s r4 = new s(this);
            UtilityKotlinExtentionsKt.b.postDelayed(r4, r3);
            Unit r5 = Unit.INSTANCE;
            IntroManagerViewModel.access$setDelayRunnable$p(r18, r4);
            return;
        L18:
            dm.a.a("IntroCard").w("[query] query intro errorCode, statusCode=" + ((com.bytedance.android.ec.model.g) r1).statusCode, null);
            IntroManagerViewModel.handleIntroResp$default(this.a, null, this.b, this.c, false, false, this.d, 24, null);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ IntroManagerViewModel a;
        public final /* synthetic */ IntroCardScene b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ boolean d;

        public d(IntroManagerViewModel r1, IntroCardScene r2, Function2 r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
            com.bytedance.android.livesdk.livecommerce.intro.utils.k.b("[query] query intro error, errorMsg=" + r11.getMessage());
            ECExceptionMonitor.e(r11);
            ECLivePerformanceMonitor r12 = IntroManagerViewModel.access$getEntryMonitor(this.a);
            if (r12 == null) goto L5;
            r12.l();
        L5:
            IntroManagerViewModel.handleIntroResp$default(this.a, null, this.b, this.c, false, false, this.d, 24, null);
        }
    }

    static {
        Companion = new a();
    }

    private final ECLivePerformanceMonitor getEntryMonitor() {
        ECContext r0 = this.roomContextController.r();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r1 = r0.getEcLivePerformanceMonitor();
        if (r1 == null) goto L7;
        return (ECLivePerformanceMonitor) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.base.AbsViewModel
    public void onCleared() {
        super.onCleared();
        Disposable r0 = this.introRequestDispose;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.introRequestDispose = null;
        Disposable r1 = this.introRetryDispose;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.introRetryDispose = null;
        setDelayRunnable(null);
    }

    public final bk2.e<uh2.c> getIntroVOLiveData() {
        return this.introVOLiveData;
    }

    public static final /* synthetic */ Runnable access$getDelayRunnable$p(IntroManagerViewModel r0) {
        return r0.delayRunnable;
    }

    public static final /* synthetic */ ECLivePerformanceMonitor access$getEntryMonitor(IntroManagerViewModel r0) {
        return r0.getEntryMonitor();
    }

    public static final /* synthetic */ Disposable access$getIntroRetryDispose$p(IntroManagerViewModel r0) {
        return r0.introRetryDispose;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.model.e access$getLiveRoomInfo$p(IntroManagerViewModel r0) {
        return r0.liveRoomInfo;
    }

    public static final /* synthetic */ r access$getRepo$p(IntroManagerViewModel r0) {
        return r0.repo;
    }

    private final void onCardLoadFinish(boolean r3) {
        OptCardUtil.b(null, "call onCardLoadFinish isShow=" + r3);
        this.roomContextController.A().t.Y();
    }

    private final void setDelayRunnable(Runnable r3) {
        Runnable r0 = this.delayRunnable;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
    L5:
        this.delayRunnable = r3;
    }

    public final void updateIntroVOs(List<? extends uh2.a> r4) {
        if (r4 == null) goto L16;
        uh2.c r1 = null;
        if ((!r4.isEmpty()) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L17;
        uh2.c r0 = this.introVOLiveData.a();
        if (r0 != null) goto L11;
        return;
    L11:
        if ((!r0.a.isEmpty()) == false) goto L13;
        r1 = r0;
    L13:
        if (r1 == null) goto L19;
        this.introVOLiveData.e(new uh2.c(r4, IntroUpdateType.UPDATE));
        return;
    L19:
        return;
    L17:
        return;
    }

    public static final /* synthetic */ void access$onCardLoadFinish(IntroManagerViewModel r0, boolean r1) {
        r0.onCardLoadFinish(r1);
    }

    public static final /* synthetic */ void access$setDelayRunnable$p(IntroManagerViewModel r0, Runnable r1) {
        r0.setDelayRunnable(r1);
    }

    public static final /* synthetic */ void access$setIntroRetryDispose$p(IntroManagerViewModel r0, Disposable r1) {
        r0.introRetryDispose = r1;
    }

    public IntroManagerViewModel(r r3, com.bytedance.android.livesdk.livecommerce.room.model.e r4, LiveRoomParams r5, RoomContextController r6) {
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r6, "roomContextController");
        super(null, 1, null);
        this.repo = r3;
        this.liveRoomInfo = r4;
        this.liveRoomParams = r5;
        this.roomContextController = r6;
        this.introVOLiveData = new bk2.e();
        this.cardLoadOpt = r6.A().t.A;
    }

    public final void handleIntroResp(LiveIntroResponse r20, IntroCardScene r21, Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r22, boolean r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r21, "cardScene");
        ECLivePerformanceMonitor r0 = getEntryMonitor();
        Object r5 = null;
        if (r0 == null) goto L8;
        r0.v("ec_perf_duration_intro_card", CollectionsKt.listOf("render_start"), Long.valueOf(SystemClock.elapsedRealtime()));
        String r1 = r0.p;
        if (r1 == null) goto L8;
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.POP_CARD_ANIM_DELAY_DURATION, null);
    L8:
        if (sh2.f.b(r21) == true) goto L12;
        if (r20 != null) goto L12;
        UtilityKotlinExtentionsKt.b.post(new b(this));
        return;
    L12:
        Boolean r2 = IntroCardLoadOpt.o;
        if (r2 != null) goto L16;
        IntroCardLoadOpt.o = Boolean.TRUE;
    L18:
        if (r20 == null) goto L139;
        List<LiveIntro> r3 = r20.getIntros();
        if (r3 == null) goto L139;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r3.iterator();
    L23:
        if (r8.hasNext() == false) goto L141;
        LiveIntro r4 = (LiveIntro) r8.next();
        int r9 = r4.c();
        String r11 = "1";
        if (r9 != 1) goto L27;
        r8 = r8;
        IntroPromotionVO r10 = uh2.d.a(r4.d(), r4.b(), r21, this.roomContextController, r20.getLogId());
        if (r10 == null) goto L135;
        Map r12 = r10.getEventParams();
        if (r12 == null) goto L134;
        if (r24 == true) goto L133;
        r11 = BDLocationException.ERROR_TIMEOUT;
    L133:
        String r13 = (String) r12.put("card_pop_with_cache", r11);
    L134:
        r10.setShouldExtendSameCardDuration(r25);
        Object r14 = r10;
    L136:
        if (r14 == null) goto L138;
        r7.add(r14);
    L138:
        r8 = r8;
        r5 = null;
        goto L23
    L135:
        r14 = null;
        goto L136
    L27:
        if (r9 == 2) goto L29;
        r14 = r5;
        r8 = r8;
        goto L136
    L29:
        Map<String, ? extends Object> r15 = z1.k(com.bytedance.android.shopping.extensions.k.v(r20));
        q0 r16 = r4.a();
        s0 r17 = r4.b();
        RoomContextController r18 = this.roomContextController;
        String r19 = r20.getLogId();
        int r110 = uh2.b.a;
        Intrinsics.checkNotNullParameter(r15, "rawData");
        Intrinsics.checkNotNullParameter(r18, "roomContextController");
        if (r16 != null) goto L32;
        IntroAuctionPromotionVO r26 = null;
    L117:
        if (r26 == null) goto L124;
        Map r27 = r26.getEventParams();
        IntroAuctionPromotionVO r28 = r26;
        if (r27 == null) goto L125;
        if (r24 == true) goto L123;
        r11 = BDLocationException.ERROR_TIMEOUT;
    L123:
        String r29 = (String) r27.put("card_pop_with_cache", r11);
        r28 = r26;
    L125:
        r14 = r28;
        goto L136
    L124:
        r28 = null;
        goto L125
    L32:
        long r111 = SystemClock.elapsedRealtime();
        IntroAuctionPromotionVO r30 = new IntroAuctionPromotionVO(r111);
        int r112 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.a("[progress] set currentTime " + r111);
        r30.setRawData(r15);
        r30.setUiFrame(r16.h());
        r30.setUiFrameV2(r16.i());
        r30.setCardType(r16.b());
        r30.setUiTemplate(r16.j());
        r30.setControl(r17);
        r30.setProduct(r16.e());
        r30.setDurations(r16.c());
        IntroProduct r31 = r16.e();
        if (r31 == null) goto L35;
        String r32 = r31.i();
    L36:
        String r33 = "";
        if (r32 != null) goto L39;
        r32 = "";
    L39:
        r30.setPromotionId(r32);
        IntroProduct r34 = r16.e();
        if (r34 == null) goto L42;
        String r35 = r34.g();
    L43:
        if (r35 != null) goto L45;
        r35 = "";
    L45:
        r30.setProductId(r35);
        Map<String, String> r36 = r16.d();
        if (r36 == null) goto L67;
        LinkedHashMap r37 = new LinkedHashMap();
        r37.putAll(r36);
        r37.put("auction_version", "2.0");
        Unit r113 = Unit.INSTANCE;
        r30.setEventParams(r37);
        r30.setHasDiscountPrice(r36.get("avl_discount"));
        if (r36.get("combination_id") == null) goto L50;
        boolean r38 = true;
    L51:
        r30.setShowCombination(r38);
        r30.setRealPrice(r36.get("real_price"));
        r30.setSingleSku(Intrinsics.areEqual(r36.get("with_sku"), BDLocationException.ERROR_TIMEOUT));
        String r39 = r36.get("live_product_type");
        if (r39 == null) goto L65;
        int r114 = r39.hashCode();
        if (r114 == (-538757262)) goto L63;
        if (r114 != 478830658) goto L65;
        if (r39.equals("buynow_part") == false) goto L65;
        int r40 = 2;
    L66:
        r30.setFlashType(r40);
        r30.setInsuranceProduct(Intrinsics.areEqual(r36.get("insurance_commodity_flag"), "1"));
        goto L67
    L63:
        if (r39.equals("buynow_all") == false) goto L65;
        r40 = 1;
    L65:
        r40 = 0;
        goto L66
    L50:
        r38 = false;
    L67:
        r30.processEventParams();
        r30.setStandardEventTrack(r16.f());
        r30.setTrack(r16.g());
        IntroProduct r41 = r16.e();
        if (r41 == null) goto L70;
        Long r42 = Long.valueOf(r41.b());
    L71:
        r30.setChannelId(String.valueOf(r42));
        IntroProduct r43 = r16.e();
        if (r43 == null) goto L74;
        Integer r44 = Integer.valueOf((int) r43.c());
    L75:
        r30.setChannelType(r44);
        IntroProduct r45 = r16.e();
        if (r45 == null) goto L78;
        String r46 = r45.d();
    L79:
        r30.setScheme(r46);
        IntroProduct r47 = r16.e();
        if (r47 == null) goto L82;
        Long r48 = Long.valueOf(r47.j());
    L83:
        r30.setShopId(String.valueOf(r48));
        IntroProduct r49 = r16.e();
        if (r49 == null) goto L86;
        String r50 = String.valueOf(r49.f());
    L87:
        r30.setEventItemType(r50);
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.h r51 = r16.a();
        if (r51 == null) goto L90;
        ECUrlModel r52 = r51.c();
    L91:
        r30.setDetailCover(r52);
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.h r53 = r16.a();
        if (r53 == null) goto L94;
        ECHotAtmosphere r54 = r53.b();
    L95:
        r30.setHotAtmosphere(r54);
        r30.setLogid(r19);
        JSONObject r55 = new JSONObject();     // Catch: Exception -> L98
        int r56 = w.h;     // Catch: Exception -> L98
        r55.put("ecom_scene_id", w.a.b());     // Catch: Exception -> L98
        r55.put("anchor_id", r18.y());     // Catch: Exception -> L98
        r55.put("room_id", r18.B());     // Catch: Exception -> L98
        r55.put("show_dou_campaign", 0);     // Catch: Exception -> L98
        r30.setExtraTransmissibleLogParams(r55);     // Catch: Exception -> L98
    L100:
        r30.setEventLabel("normal");
        r30.setCanAddShopCart(false);
        IntroProduct r57 = r16.e();
        if (r57 == null) goto L103;
        String r58 = r57.a();
    L104:
        r30.setBizIdentity(r58);
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.h r59 = r16.a();
        if (r59 == null) goto L107;
        String r60 = r59.a();
    L108:
        r30.setCheckCallback(r60);
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.h r61 = r16.a();
        if (r61 == null) goto L111;
        PrefetchOrder r62 = r61.d();
    L112:
        r30.setPrefetchOrder(r62);
        r30.setCardReqScene(r21);
        String r63 = r21.getValue();
        if (r63 == null) goto L116;
        r33 = r63;
    L116:
        r30.appendExtraEventParams("popup_scene", r33);
        r26 = r30;
        goto L117
    L111:
        r62 = null;
        goto L112
    L107:
        r60 = null;
        goto L108
    L103:
        r58 = null;
    L98:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L100
    L94:
        r54 = null;
        goto L95
    L90:
        r52 = null;
        goto L91
    L86:
        r50 = null;
        goto L87
    L82:
        r48 = null;
        goto L83
    L78:
        r46 = null;
        goto L79
    L74:
        r44 = null;
        goto L75
    L70:
        r42 = null;
        goto L71
    L42:
        r35 = null;
        goto L43
    L35:
        r32 = null;
    L141:
        if (r21 != IntroCardScene.REFRESH_MESSAGE) goto L144;
        IntroUpdateType r64 = IntroUpdateType.UPDATE;
    L147:
        bk2.e<uh2.c> r65 = this.introVOLiveData;
        if (r7 == null) goto L150;
        uh2.c r66 = new uh2.c(r7, r64);
    L151:
        r65.g(r66);
        if (r22 == null) goto L160;
        Unit r67 = (Unit) r22.invoke(r20, r7);
        return;
    L160:
        return;
    L150:
        r66 = null;
        goto L151
    L144:
        if (r21 != IntroCardScene.GET_CARD) goto L146;
        r64 = IntroUpdateType.MUST_SHOW_NEW_CARD;
        goto L147
    L146:
        r64 = IntroUpdateType.CREATE;
    L139:
        r7 = null;
        goto L141
    L16:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L18;
        IntroCardLoadOpt.o = Boolean.FALSE;
        goto L18
    }

    public final void queryIntro(final IntroCardScene r17, Pair<Long, Long> r18, sh2.b r19, String r20, Map<String, String> r21, final boolean r22, final Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r23) {
        Intrinsics.checkNotNullParameter(r17, "cardScene");
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(">>> [query] query intro, cardScene=" + r17 + ", forcePath=" + r20);
        setDelayRunnable(null);
        Disposable r1 = this.introRetryDispose;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.introRetryDispose = null;
        if (r17 != IntroCardScene.ENTER_ROOM) goto L14;
        IntroCardLoadOpt r2 = this.cardLoadOpt;
        if (r2 == null) goto L10;
        Boolean r3 = Boolean.valueOf(r2.a(this.liveRoomInfo.roomId(), new IntroManagerViewModel$queryIntro$isOptLoad$1(this, r17, r23, r22)));
    L12:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L14;
        return;
    L10:
        r3 = null;
    L14:
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(">>> [query] query intro network api, cardScene=" + r17);
        if (sh2.f.b(r17) == false) goto L19;
        ECLivePerformanceMonitor r4 = getEntryMonitor();
        if (r4 == null) goto L19;
        r4.s(true, this.liveRoomInfo.roomId(), this.roomContextController.A().t.U);
    L19:
        ECLivePerformanceMonitor r5 = getEntryMonitor();
        if (r5 == null) goto L24;
        r5.u("ec_perf_duration_intro_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r6 = r5.p;
        if (r6 == null) goto L24;
        Map r7 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.POP_API_DURATION, null);
    L24:
        Disposable r8 = this.introRequestDispose;
        if (r8 == null) goto L27;
        r8.dispose();
    L27:
        this.introRequestDispose = bk2.c.a(bg4.b.b(this.repo.a(this.liveRoomInfo, r17, false, false, r18, r19, r20, r21)).subscribe(new c(this, r17, r23, r22, r18, r19, r20, r21), new d(this, r17, r23, r22)), getDisposableContext());
    }

    public static /* synthetic */ void handleIntroResp$default(IntroManagerViewModel r9, LiveIntroResponse r10, IntroCardScene r11, Function2 r12, boolean r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r16 & 32) == 0) goto L13;
        boolean r8 = false;
    L14:
        r9.handleIntroResp(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryIntro$default(IntroManagerViewModel r7, IntroCardScene r8, Pair r9, sh2.b r10, String r11, Map r12, boolean r13, Function2 r14, int r15, Object r16) {
        Function2 r1 = null;
        if ((r15 & 2) == 0) goto L5;
        Pair r0 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        sh2.b r2 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        Map r4 = null;
    L19:
        if ((r15 & 32) == 0) goto L21;
        boolean r5 = false;
    L23:
        if ((r15 & 64) != 0) goto L26;
        r1 = r14;
    L26:
        r7.queryIntro(r8, r0, r2, r3, r4, r5, r1);
        return;
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L7
    }
}
