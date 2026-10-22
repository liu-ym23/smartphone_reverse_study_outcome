package com.bytedance.android.livesdk.livecommerce.intro.card.vm;

import android.content.Context;
import cf.n;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.intro.card.base.AbsViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.k;
import com.bytedance.android.livesdk.livecommerce.intro.event.m;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import oh2.e;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 x2\u00020\u0001:\u0004yz{|B1\u0012\u0006\u0010b\u001a\u00020a\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010j\u001a\u00020i\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010r\u001a\u00020q¢\u0006\u0004\bv\u0010wJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R(\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R&\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00180\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R&\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00180\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015R&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015R&\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00180\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00180\u00118\u0006¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010\u0015R#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00180\u00118\u0006¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bA\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010B\u001a\u0004\bL\u0010C\"\u0004\bM\u0010ER\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u00060[R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010G\u001a\u0004\b_\u0010I\"\u0004\b`\u0010KR\u0017\u0010b\u001a\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010g\u001a\u0004\u0018\u00010f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0017\u0010j\u001a\u00020i8\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0017\u0010r\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010u¨\u0006}"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/IntroCardViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/base/AbsViewModel;", "", "btmPageId", "", "buildIntroParams", "buildRelatedCardParams", "Ljf/d;", "getPromotionJumpDispatcher", "Loh2/e;", "getCardArgument", "Loh2/c;", "getContainerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroPromotionVO;", "introPromotionVO", "Lcom/bytedance/android/ec/common/api/jump/model/g;", "buildPromotionParams", "Lbk2/e;", "cardState", "Lbk2/e;", "getCardState", "()Lbk2/e;", "getCardState$annotations", "()V", "Lbk2/a;", "showBeforeAnimAction", "getShowBeforeAnimAction", "showAfterAnimAction", "getShowAfterAnimAction", "clickCloseAction", "getClickCloseAction", "showCardAction", "getShowCardAction", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/a;", "cardHiddenAction", "getCardHiddenAction$livecommerce_saasRelease", "cardUnboundAction", "getCardUnboundAction$livecommerce_saasRelease", "openPriceAnimationFinishedAction", "getOpenPriceAnimationFinishedAction$livecommerce_saasRelease", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/b;", "openPriceAnimationStateAction", "getOpenPriceAnimationStateAction$livecommerce_saasRelease", "", "secondFrameHasTitleAction", "getSecondFrameHasTitleAction", "showImageTagAction", "getShowImageTagAction", "Lio/reactivex/disposables/Disposable;", "getPromotionDispose", "Lio/reactivex/disposables/Disposable;", "Lcf/n;", "openSchemaProxy", "Lcf/n;", "getOpenSchemaProxy", "()Lcf/n;", "setOpenSchemaProxy", "(Lcf/n;)V", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "cardCallback", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "getCardCallback", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "setCardCallback", "(Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;)V", "isEnterRoom", "Z", "()Z", "setEnterRoom", "(Z)V", "lastShowedPromotionId", "Ljava/lang/String;", "getLastShowedPromotionId", "()Ljava/lang/String;", "setLastShowedPromotionId", "(Ljava/lang/String;)V", "isKmpCardHostActive", "setKmpCardHostActive", "Lrh2/b;", "introCardParams", "Lrh2/b;", "relatedCardParams", "argument", "Loh2/e;", "containerAbility", "Loh2/c;", "jumpDispatcher", "Ljf/d;", "Loh2/d;", "containerHandler", "Loh2/d;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/IntroCardViewModel$d;", "reportIntercept", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/IntroCardViewModel$d;", "eventBtmPageId", "getEventBtmPageId", "setEventBtmPageId", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "liveRoomInfo", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "getLiveRoomInfo", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "liveRoomParams", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "btmInfo", "Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "getBtmInfo", "()Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "Ljf/b;", "ecomEntranceForm", "Ljf/b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "roomContextController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "getRoomContextController", "()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/room/model/e;Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;Ljf/b;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;)V", "Companion", "a", "b", "c", "d", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardViewModel extends AbsViewModel {
    public static final a Companion = null;
    private static final int LIMITED_CODE = 300010001;
    private static final String TAG = "IntroCardVM";
    private e argument;
    private final com.bytedance.android.livesdk.livecommerce.intro.event.a btmInfo;
    private r cardCallback;
    private final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a>> cardHiddenAction;
    private final bk2.e<IntroPromotionVO> cardState;
    private final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a>> cardUnboundAction;
    private final bk2.e<bk2.a<Unit>> clickCloseAction;
    private oh2.c containerAbility;
    private final oh2.d containerHandler;
    private final jf.b ecomEntranceForm;
    private String eventBtmPageId;
    private Disposable getPromotionDispose;
    private rh2.b introCardParams;
    private boolean isEnterRoom;
    private boolean isKmpCardHostActive;
    private jf.d jumpDispatcher;
    private String lastShowedPromotionId;
    private final com.bytedance.android.livesdk.livecommerce.room.model.e liveRoomInfo;
    private final LiveRoomParams liveRoomParams;
    private final bk2.e<bk2.a<Unit>> openPriceAnimationFinishedAction;
    private final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.b>> openPriceAnimationStateAction;
    private n openSchemaProxy;
    private rh2.b relatedCardParams;
    private final d reportIntercept;
    private final RoomContextController roomContextController;
    private final bk2.e<bk2.a<Boolean>> secondFrameHasTitleAction;
    private final bk2.e<bk2.a<Unit>> showAfterAnimAction;
    private final bk2.e<bk2.a<Unit>> showBeforeAnimAction;
    private final bk2.e<bk2.a<Unit>> showCardAction;
    private final bk2.e<bk2.a<Boolean>> showImageTagAction;

    public static final class a {
        public a() {
        }
    }

    public final class b implements oh2.d {
        public final /* synthetic */ IntroCardViewModel a;

        @Override // oh2.d
        public final void a() {
        }

        public b(IntroCardViewModel r1) {
            this.a = r1;
        }

        @Override // oh2.d
        public final LiveActionTracker b(com.bytedance.android.btm.api.model.d r3) {
            return this.a.getRoomContextController().A().t.K().a("livesdk_intro_card", r3);
        }
    }

    public final class c implements jf.c {
        public final String a;
        public final /* synthetic */ IntroCardViewModel b;

        public final void a() {
        }

        public final void b() {
        }

        public final void h() {
        }

        public final void l() {
        }

        public final void m() {
        }

        public final boolean k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            Intrinsics.checkNotNullParameter(r2, "schema");
            return false;
        }

        public c(IntroCardViewModel r1, String r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void d(Context r1, com.bytedance.android.btm.api.model.d r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
        }

        public final void e(Context r1, com.bytedance.android.btm.api.model.d r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
        }

        public final void f(String r3, g r4) {
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
            r8.l(r4.a, new l(null), BuyNowPrefetchType.CLICK);
            return;
        L17:
            return;
        L16:
            return;
        L7:
            if (r5.isFetchModel() != true) goto L8;
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

        public final void n(String r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "clickArea");
            Intrinsics.checkNotNullParameter(r3, "promotionParams");
            jf.c.a.b(r2, r3);
        }

        public final boolean c(Context r1, com.bytedance.android.btm.api.model.d r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "context");
            return false;
        }

        public final void g(String r13, ql.a r14, BtmItemBuilder r15) {
            Intrinsics.checkNotNullParameter(r13, "clickArea");
            Intrinsics.checkNotNullParameter(r14, "promotion");
            IntroPromotionVO r5 = this.b.getCardState().a();
            if (r5 != null) goto L5;
            return;
        L5:
            if (r13.hashCode() == (-1377687758)) goto L8;
        L10:
            this.b.getBtmInfo().a();
            String r16 = "a1128.b3295.c59667.d30609";
        L11:
            String r11 = r16;
            int r17 = com.bytedance.android.livesdk.livecommerce.intro.event.n.a;
            com.bytedance.android.livesdk.livecommerce.room.model.e r2 = this.b.getLiveRoomInfo();
            String r7 = this.a;
            RoomContextController r4 = this.b.getRoomContextController();
            Intrinsics.checkNotNullParameter(r5, "introPromotionVO");
            Intrinsics.checkNotNullParameter(r2, "liveRoomInfo");
            Intrinsics.checkNotNullParameter(r13, "clickArea");
            Intrinsics.checkNotNullParameter(r4, "roomContextController");
            r2.roomId();
            if (r4 == null) goto L14;
            r4.L();
        L14:
            Ref.ObjectRef r8 = new Ref.ObjectRef();
            r8.element = null;
            Ref.ObjectRef r9 = new Ref.ObjectRef();
            r9.element = null;
            boolean r18 = true;
            if (r4 != null) goto L17;
        L24:
            r8.element = Boolean.valueOf(r18);
            r9.element = com.bytedance.android.livesdk.livecommerce.intro.event.n.a(r4);
            int r19 = ECSdk.a;
            IAdapterService r110 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r110 == null) goto L28;
            String r111 = r110.getIfClearModeValueWithIntroCardShow();
            if (r111 == null) goto L28;
        L29:
            t.b(new k(new m(r2, r13, r4, r5, r15, r7, r8, r9, r111, r11), "ExplainProductEntranceClickEvent"));
            return;
        L28:
            r111 = BDLocationException.ERROR_TIMEOUT;
            goto L29
        L17:
            if (r4.x() != true) goto L24;
            com.bytedance.android.ec.adapter.api.state.a r0 = r4.L();
            if (r0 == null) goto L24;
            if (r0.d == true) goto L24;
            r18 = false;
            goto L24
        L8:
            if (r13.equals("button") == false) goto L10;
            this.b.getBtmInfo().b();
            r16 = "a1128.b3295.c59667.d30614";
            goto L11
        }
    }

    public final class d implements com.bytedance.android.livesdk.livecommerce.promotion.card.e {
        public final Set<String> a;

        public static final class a implements Runnable {
            public final /* synthetic */ Function3 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Map c;
            public final /* synthetic */ String d;

            public a(Function3 r1, String r2, Map r3, String r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke(this.b, this.c, this.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d() {
            this.a = SetsKt.setOf(new String[]{"livesdk_explain_replay_entrance_show", "livesdk_explain_apply_entrance_show", "livesdk_show_add_to_cart", "livesdk_unrec_show_product", "livesdk_sku_button_show", "livesdk_show_store_entrance", "livesdk_show_store_info", "livesdk_show_have_seen_label", "livesdk_show_hot_sale", "livesdk_show_invalid_product", "livesdk_product_apply_explain_show"});
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.e
        public final boolean a(String r6, Map<String, String> r7, String r8, ql.a r9, Function3<? super String, ? super Map<String, String>, ? super String, Unit> r10) {
            Intrinsics.checkNotNullParameter(r6, "eventName");
            Intrinsics.checkNotNullParameter(r7, "eventParams");
            Intrinsics.checkNotNullParameter(r10, "save");
            if (this.a.contains(r6) == false) goto L5;
        L18:
            UtilityKotlinExtentionsKt.b.post(new a(r10, r6, r7, r8));
            return true;
        L5:
            if (StringsKt.endsWith$default(r6, "_show", false, 2, null) == true) goto L18;
            if (Intrinsics.areEqual(r6, "livesdk_show_product") == false) goto L17;
            if (r9 == null) goto L15;
            ql.b r11 = r9.getClientData();
            if (r11 == null) goto L15;
            if (r11.b == true) goto L15;
            return true;
        L15:
            return false;
        L17:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "注意该变量在动画开始时赋值，动画结束时会清空，在动画过程中使用请注意时序")
    public static /* synthetic */ void getCardState$annotations() {
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.event.a getBtmInfo() {
        return this.btmInfo;
    }

    public final e getCardArgument() {
        return this.argument;
    }

    public final r getCardCallback() {
        return this.cardCallback;
    }

    public final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a>> getCardHiddenAction$livecommerce_saasRelease() {
        return this.cardHiddenAction;
    }

    public final bk2.e<IntroPromotionVO> getCardState() {
        return this.cardState;
    }

    public final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a>> getCardUnboundAction$livecommerce_saasRelease() {
        return this.cardUnboundAction;
    }

    public final bk2.e<bk2.a<Unit>> getClickCloseAction() {
        return this.clickCloseAction;
    }

    public final oh2.c getContainerAbility() {
        return this.containerAbility;
    }

    public final String getEventBtmPageId() {
        return this.eventBtmPageId;
    }

    public final String getLastShowedPromotionId() {
        return this.lastShowedPromotionId;
    }

    public final com.bytedance.android.livesdk.livecommerce.room.model.e getLiveRoomInfo() {
        return this.liveRoomInfo;
    }

    public final bk2.e<bk2.a<Unit>> getOpenPriceAnimationFinishedAction$livecommerce_saasRelease() {
        return this.openPriceAnimationFinishedAction;
    }

    public final bk2.e<bk2.a<com.bytedance.android.livesdk.livecommerce.intro.card.vm.b>> getOpenPriceAnimationStateAction$livecommerce_saasRelease() {
        return this.openPriceAnimationStateAction;
    }

    public final n getOpenSchemaProxy() {
        return this.openSchemaProxy;
    }

    public final RoomContextController getRoomContextController() {
        return this.roomContextController;
    }

    public final bk2.e<bk2.a<Boolean>> getSecondFrameHasTitleAction() {
        return this.secondFrameHasTitleAction;
    }

    public final bk2.e<bk2.a<Unit>> getShowAfterAnimAction() {
        return this.showAfterAnimAction;
    }

    public final bk2.e<bk2.a<Unit>> getShowBeforeAnimAction() {
        return this.showBeforeAnimAction;
    }

    public final bk2.e<bk2.a<Unit>> getShowCardAction() {
        return this.showCardAction;
    }

    public final bk2.e<bk2.a<Boolean>> getShowImageTagAction() {
        return this.showImageTagAction;
    }

    public final boolean isEnterRoom() {
        return this.isEnterRoom;
    }

    public final boolean isKmpCardHostActive() {
        return this.isKmpCardHostActive;
    }

    public static final /* synthetic */ d access$getReportIntercept$p(IntroCardViewModel r0) {
        return r0.reportIntercept;
    }

    private final void buildIntroParams(String r13) {
        if (this.introCardParams != null) goto L9;
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.liveRoomParams;
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        this.introCardParams = (rh2.b) r0.buildParams(Reflection.getOrCreateKotlinClass(f.class), new f.a("c0.d0", r13, jf.b.g.b, jf.e.d.b, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(rh2.b.class), new rh2.b.a(C02671.INSTANCE));
        return;
    }

    private final void buildRelatedCardParams(String r13) {
        if (this.relatedCardParams != null) goto L9;
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.liveRoomParams;
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        this.relatedCardParams = (rh2.b) r0.buildParams(Reflection.getOrCreateKotlinClass(f.class), new f.a("c0.d0", r13, jf.b.h.b, jf.e.d.b, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(rh2.b.class), new rh2.b.a(C02681.INSTANCE));
        return;
    }

    private final jf.d getPromotionJumpDispatcher(String r2) {
        if (this.jumpDispatcher != null) goto L6;
        buildIntroParams(r2);
        this.jumpDispatcher = fi2.c.b(this, new c(this, r2), 4);
    L6:
        return this.jumpDispatcher;
    }

    public final void setCardCallback(r r1) {
        this.cardCallback = r1;
    }

    public final void setEnterRoom(boolean r1) {
        this.isEnterRoom = r1;
    }

    public final void setEventBtmPageId(String r1) {
        this.eventBtmPageId = r1;
    }

    public final void setKmpCardHostActive(boolean r1) {
        this.isKmpCardHostActive = r1;
    }

    public final void setLastShowedPromotionId(String r1) {
        this.lastShowedPromotionId = r1;
    }

    public final void setOpenSchemaProxy(n r1) {
        this.openSchemaProxy = r1;
    }

    public static final /* synthetic */ jf.d access$getPromotionJumpDispatcher(IntroCardViewModel r0, String r1) {
        return r0.getPromotionJumpDispatcher(r1);
    }

    public final g buildPromotionParams(IntroPromotionVO r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "introPromotionVO");
        IntroProduct r0 = r3.getProduct();
        if (r0 != null) goto L5;
    L11:
        buildIntroParams(r4);
        com.bytedance.android.ec.common.api.jump.model.b r5 = this.introCardParams;
        if (r5 != null) goto L15;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L15:
        return r5.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r3));
    L5:
        if (r0.h() != 2) goto L11;
        buildRelatedCardParams(r4);
        com.bytedance.android.ec.common.api.jump.model.b r6 = this.relatedCardParams;
        if (r6 != null) goto L10;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L10:
        return r6.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r3));
    }

    public IntroCardViewModel(com.bytedance.android.livesdk.livecommerce.room.model.e r8, LiveRoomParams r9, com.bytedance.android.livesdk.livecommerce.intro.event.a r10, jf.b r11, RoomContextController r12) {
        Intrinsics.checkNotNullParameter(r8, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r10, "btmInfo");
        Intrinsics.checkNotNullParameter(r11, "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r12, "roomContextController");
        super(null, 1, null);
        this.liveRoomInfo = r8;
        this.liveRoomParams = r9;
        this.btmInfo = r10;
        this.ecomEntranceForm = r11;
        this.roomContextController = r12;
        this.cardState = new bk2.e();
        this.showBeforeAnimAction = new bk2.e();
        this.showAfterAnimAction = new bk2.e();
        this.clickCloseAction = new bk2.e();
        this.showCardAction = new bk2.e();
        this.cardHiddenAction = new bk2.e();
        this.cardUnboundAction = new bk2.e();
        this.openPriceAnimationFinishedAction = new bk2.e();
        this.openPriceAnimationStateAction = new bk2.e();
        this.secondFrameHasTitleAction = new bk2.e();
        this.showImageTagAction = new bk2.e();
        b r3 = new b(this);
        this.containerHandler = r3;
        d r4 = new d();
        this.reportIntercept = r4;
        this.argument = new e(r10, r8, r3, r4, new il.a(), new AnonymousClass1(this));
        this.containerAbility = new AnonymousClass2(this);
    }
}
