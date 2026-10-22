package com.bytedance.android.livesdk.livecommerce.intro.auction;

import android.content.Context;
import android.view.View;
import cf.n;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.intro.card.base.AbsViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.manager.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 m2\u00020\u0001:\u0004nopqB9\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010g\u001a\u00020f¢\u0006\u0004\bk\u0010lJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00150\u00108\u0006¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b4\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u00060KR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010:\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R\u0017\u0010R\u001a\u00020Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0017\u0010Z\u001a\u00020Y8\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0017\u0010b\u001a\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010g\u001a\u00020f8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j¨\u0006r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/auction/IntroAuctionViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/base/AbsViewModel;", "", "btmPageId", "", "buildIntroParams", "Ljf/d;", "getPromotionJumpDispatcher", "Loh2/e;", "getCardArgument", "Loh2/c;", "getContainerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroAuctionPromotionVO;", "introPromotionVO", "Lcom/bytedance/android/ec/common/api/jump/model/g;", "buildPromotionParams", "Lbk2/e;", "cardState", "Lbk2/e;", "getCardState", "()Lbk2/e;", "Lbk2/a;", "showBeforeAnimAction", "getShowBeforeAnimAction", "showAfterAnimAction", "getShowAfterAnimAction", "clickCloseAction", "getClickCloseAction", "showCardAction", "getShowCardAction", "", "secondFrameHasTitleAction", "getSecondFrameHasTitleAction", "showImageTagAction", "getShowImageTagAction", "Lio/reactivex/disposables/Disposable;", "getPromotionDispose", "Lio/reactivex/disposables/Disposable;", "Lcf/n;", "openSchemaProxy", "Lcf/n;", "getOpenSchemaProxy", "()Lcf/n;", "setOpenSchemaProxy", "(Lcf/n;)V", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "cardCallback", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "getCardCallback", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;", "setCardCallback", "(Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/r;)V", "isEnterRoom", "Z", "()Z", "setEnterRoom", "(Z)V", "lastShowedPromotionId", "Ljava/lang/String;", "getLastShowedPromotionId", "()Ljava/lang/String;", "setLastShowedPromotionId", "(Ljava/lang/String;)V", "Lrh2/b;", "introCardParams", "Lrh2/b;", "argument", "Loh2/e;", "containerAbility", "Loh2/c;", "jumpDispatcher", "Ljf/d;", "Loh2/d;", "containerHandler", "Loh2/d;", "Lcom/bytedance/android/livesdk/livecommerce/intro/auction/IntroAuctionViewModel$e;", "reportIntercept", "Lcom/bytedance/android/livesdk/livecommerce/intro/auction/IntroAuctionViewModel$e;", "eventBtmPageId", "getEventBtmPageId", "setEventBtmPageId", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "liveRoomInfo", "Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "getLiveRoomInfo", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/e;", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "liveRoomParams", "Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "btmInfo", "Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "getBtmInfo", "()Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;", "Ljf/b;", "ecomEntranceForm", "Ljf/b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "roomContextController", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "getRoomContextController", "()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;", "Lcom/bytedance/android/livesdk/livecommerce/intro/manager/u;", "animDelegate", "Lcom/bytedance/android/livesdk/livecommerce/intro/manager/u;", "getAnimDelegate", "()Lcom/bytedance/android/livesdk/livecommerce/intro/manager/u;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/room/model/e;Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;Lcom/bytedance/android/livesdk/livecommerce/intro/event/a;Ljf/b;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/RoomContextController;Lcom/bytedance/android/livesdk/livecommerce/intro/manager/u;)V", "Companion", "b", "c", "d", "e", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroAuctionViewModel extends AbsViewModel {
    public static final b Companion = null;
    private static final int LIMITED_CODE = 300010001;
    private static final String TAG = "IntroCardVM";
    private final u animDelegate;
    private oh2.e argument;
    private final com.bytedance.android.livesdk.livecommerce.intro.event.a btmInfo;
    private r cardCallback;
    private final bk2.e<IntroAuctionPromotionVO> cardState;
    private final bk2.e<bk2.a<Unit>> clickCloseAction;
    private oh2.c containerAbility;
    private final oh2.d containerHandler;
    private final jf.b ecomEntranceForm;
    private String eventBtmPageId;
    private Disposable getPromotionDispose;
    private rh2.b introCardParams;
    private boolean isEnterRoom;
    private jf.d jumpDispatcher;
    private String lastShowedPromotionId;
    private final com.bytedance.android.livesdk.livecommerce.room.model.e liveRoomInfo;
    private final LiveRoomParams liveRoomParams;
    private n openSchemaProxy;
    private final e reportIntercept;
    private final RoomContextController roomContextController;
    private final bk2.e<bk2.a<Boolean>> secondFrameHasTitleAction;
    private final bk2.e<bk2.a<Unit>> showAfterAnimAction;
    private final bk2.e<bk2.a<Unit>> showBeforeAnimAction;
    private final bk2.e<bk2.a<Unit>> showCardAction;
    private final bk2.e<bk2.a<Boolean>> showImageTagAction;

    public static final class a implements oh2.c {
        public final /* synthetic */ IntroAuctionViewModel a;

        public a(IntroAuctionViewModel r1) {
            this.a = r1;
        }

        @Override // oh2.c
        public final Long b(long r14, long r16) {
            IntroAuctionPromotionVO r1 = this.a.getCardState().a();
            Long r2 = null;
            if (r1 == null) goto L39;
            IntroProduct r3 = r1.getProduct();
            if (r3 == null) goto L7;
            Integer r4 = Integer.valueOf(r3.e());
        L8:
            boolean r5 = false;
            if (r4 != null) goto L12;
        L23:
            if (r4 != null) goto L26;
        L37:
            long r6 = 1000;
            return Long.valueOf((r1.getCurrentTime() + (r16 * r6)) - (r6 * r14));
        L26:
            if (r4.intValue() != 2) goto L37;
            ECPromotionAuctionInfo r7 = r1.getAuctionInfo();
            if (r7 == null) goto L37;
            Long r8 = Long.valueOf(r7.getEndTime());
            if (r8.longValue() <= 0) goto L32;
            r5 = true;
        L32:
            if (r5 == false) goto L34;
            r2 = r8;
        L34:
            if (r2 == null) goto L37;
            return Long.valueOf((r1.getCurrentTime() + r2.longValue()) - (((long) 1000) * r14));
        L12:
            if (r4.intValue() != 1) goto L23;
            Long r9 = Long.valueOf(r1.getAuctionEndTime());
            if (r9.longValue() <= 0) goto L16;
            boolean r10 = true;
        L17:
            if (r10 == true) goto L20;
            r9 = null;
        L20:
            if (r9 == null) goto L23;
            return Long.valueOf((r1.getCurrentTime() + r9.longValue()) - (((long) 1000) * r14));
        L16:
            r10 = false;
            goto L17
        L7:
            r4 = null;
            goto L8
        L39:
            return null;
        }

        @Override // oh2.c
        public final void a(String r1, boolean r2, String r3, BtmItemBuilder r4, View r5) {
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            Intrinsics.checkNotNullParameter(r5, "view");
            IntroAuctionPromotionVO r6 = this.a.getCardState().a();
            int r7 = r1.hashCode();
            if (r7 != (-1377687758)) goto L5;
            String r8 = "button";
            if (r1.equals("button") == true) goto L15;
        L13:
            String r9 = "";
        L14:
            r8 = r9;
        L15:
            com.bytedance.android.livesdk.livecommerce.room.controller.business.n.H(this.a.getRoomContextController().A().q, r6, r8, "shop_ad");
            return;
        L5:
            if (r7 != 93819220) goto L13;
            if (r1.equals("blank") == false) goto L13;
            r9 = "name";
            goto L14
        }

        @Override // oh2.c
        public final void c(Context r23, String r24, Integer r25, com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r26, int r27, int r28, cf.a r29, com.bytedance.android.btm.api.model.d r30, String r31, il2.a r32) {
            Intrinsics.checkNotNullParameter(r23, "context");
            Intrinsics.checkNotNullParameter(r24, "clickArea");
            Intrinsics.checkNotNullParameter(r26, "action");
            IntroAuctionPromotionVO r4 = this.a.getCardState().a();
            if (r4 == null) goto L12;
            jf.d r5 = IntroAuctionViewModel.access$getPromotionJumpDispatcher(this.a, r31);
            if (r5 == null) goto L12;
            g r7 = this.a.buildPromotionParams(r4, r31);
            if (r32 == null) goto L9;
            r32.a(r7);
        L9:
            if (r32 == null) goto L11;
            il2.a.C0145a.a(r32, "check_buy_btn", MapsKt.mapOf(TuplesKt.to("action", r26)), false, null, null, null, 60);
        L11:
            int r1 = k.a;
            k.c("handleClick clickArea=" + r24 + ", action=" + r26);
            jf.d.b.b(r5, r23, r24, r25, r7, r26, r27, r28, r29, r30, r32, DeviceStatus$DiffDimension.DIFF_LOCATION_MODE);
        L12:
            xh.a r2 = xh.c.a("Live");
            String r3 = "explain_card_".concat(r24);
            LinkedHashMap r6 = new LinkedHashMap();
            IntroAuctionPromotionVO r8 = this.a.getCardState().a();
            if (r8 == null) goto L15;
            String r9 = r8.getPromotionId();
        L16:
            if (r9 != null) goto L18;
            r9 = "";
        L18:
            r6.put("promotion_id", r9);
            Unit r10 = Unit.INSTANCE;
            r2.d("explain_card", r3, r6);
            return;
        L15:
            r9 = null;
            goto L16
        }
    }

    public static final class b {
        public b() {
        }
    }

    public final class c implements oh2.d {
        public final /* synthetic */ IntroAuctionViewModel a;

        @Override // oh2.d
        public final void a() {
        }

        public c(IntroAuctionViewModel r1) {
            this.a = r1;
        }

        @Override // oh2.d
        public final LiveActionTracker b(com.bytedance.android.btm.api.model.d r3) {
            return this.a.getRoomContextController().A().t.K().a("livesdk_intro_card", r3);
        }
    }

    public final class d implements jf.c {
        public final /* synthetic */ IntroAuctionViewModel a;

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

        public d(IntroAuctionViewModel r1) {
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

        public final void g(String r1, ql.a r2, BtmItemBuilder r3) {
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            Intrinsics.checkNotNullParameter(r2, "promotion");
            if (this.a.getCardState().a() != null) goto L5;
            return;
        L5:
            if (r1.hashCode() == (-1377687758)) goto L8;
        L10:
            this.a.getBtmInfo().a();
            return;
        L8:
            if (r1.equals("button") == false) goto L10;
            this.a.getBtmInfo().b();
        }
    }

    public final class e implements com.bytedance.android.livesdk.livecommerce.promotion.card.e {
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

        public e() {
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
        Companion = new b();
    }

    public final u getAnimDelegate() {
        return this.animDelegate;
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.event.a getBtmInfo() {
        return this.btmInfo;
    }

    public final oh2.e getCardArgument() {
        return this.argument;
    }

    public final r getCardCallback() {
        return this.cardCallback;
    }

    public final bk2.e<IntroAuctionPromotionVO> getCardState() {
        return this.cardState;
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

    private final void buildIntroParams(String r13) {
        if (this.introCardParams != null) goto L9;
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.liveRoomParams;
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        this.introCardParams = (rh2.b) r0.buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class), new com.bytedance.android.ec.common.api.jump.model.f.a("c0.d0", r13, this.ecomEntranceForm, jf.e.d.b, "live_button", null, null, 96)).buildParams(Reflection.getOrCreateKotlinClass(rh2.b.class), new rh2.b.a(C02661.INSTANCE));
        return;
    }

    private final jf.d getPromotionJumpDispatcher(String r2) {
        if (this.jumpDispatcher != null) goto L6;
        buildIntroParams(r2);
        this.jumpDispatcher = fi2.c.b(this, new d(this), 4);
    L6:
        return this.jumpDispatcher;
    }

    public final g buildPromotionParams(IntroAuctionPromotionVO r4) {
        Intrinsics.checkNotNullParameter(r4, "introPromotionVO");
        com.bytedance.android.ec.common.api.jump.model.b r0 = this.introCardParams;
        if (r0 != null) goto L6;
        r0 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        return r0.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r4));
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

    public final void setLastShowedPromotionId(String r1) {
        this.lastShowedPromotionId = r1;
    }

    public final void setOpenSchemaProxy(n r1) {
        this.openSchemaProxy = r1;
    }

    public static final /* synthetic */ jf.d access$getPromotionJumpDispatcher(IntroAuctionViewModel r0, String r1) {
        return r0.getPromotionJumpDispatcher(r1);
    }

    public final g buildPromotionParams(IntroAuctionPromotionVO r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "introPromotionVO");
        buildIntroParams(r4);
        com.bytedance.android.ec.common.api.jump.model.b r5 = this.introCardParams;
        if (r5 != null) goto L6;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        return r5.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r3));
    }

    public IntroAuctionViewModel(com.bytedance.android.livesdk.livecommerce.room.model.e r8, LiveRoomParams r9, com.bytedance.android.livesdk.livecommerce.intro.event.a r10, jf.b r11, RoomContextController r12, u r13) {
        Intrinsics.checkNotNullParameter(r8, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r10, "btmInfo");
        Intrinsics.checkNotNullParameter(r11, "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r12, "roomContextController");
        Intrinsics.checkNotNullParameter(r13, "animDelegate");
        super(null, 1, null);
        this.liveRoomInfo = r8;
        this.liveRoomParams = r9;
        this.btmInfo = r10;
        this.ecomEntranceForm = r11;
        this.roomContextController = r12;
        this.animDelegate = r13;
        this.cardState = new bk2.e();
        this.showBeforeAnimAction = new bk2.e();
        this.showAfterAnimAction = new bk2.e();
        this.clickCloseAction = new bk2.e();
        this.showCardAction = new bk2.e();
        this.secondFrameHasTitleAction = new bk2.e();
        this.showImageTagAction = new bk2.e();
        c r3 = new c(this);
        this.containerHandler = r3;
        e r4 = new e();
        this.reportIntercept = r4;
        this.argument = new oh2.e(r10, r8, r3, r4, new il.a(), new AnonymousClass1(this));
        this.containerAbility = new a(this);
    }
}
