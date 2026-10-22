package com.bytedance.android.shopping.store.home.presenter.preview;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.event.StoreUserActionEvent;
import com.bytedance.android.shopping.store.live.SwitchLiveTabSource;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.utils.c0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/shopping/store/home/presenter/preview/ECShopHeaderPreviewGroupPresenter$behavior$2$a", "invoke", "()Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopHeaderPreviewGroupPresenter$behavior$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ECShopHeaderPreviewGroupPresenter$behavior$2 extends Lambda implements Function0<a> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ECShopHeaderPreviewGroupPresenter this$0;

    public static final class a implements o {
        public final /* synthetic */ ECShopHeaderPreviewGroupPresenter$behavior$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.store.home.presenter.preview.ECShopHeaderPreviewGroupPresenter$behavior$2$a$a, reason: collision with other inner class name */
        public static final class C0006a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function1 b;

            public C0006a(a r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r15) {
                ECCurrentPromotion r16 = (ECCurrentPromotion) r15;
                if (((com.bytedance.android.ec.model.g) r16).statusCode != 0) goto L27;
                Iterator<T> r0 = r16.promotions.iterator();
            L7:
                if (r0.hasNext() == false) goto L22;
                ECPromotion r1 = (ECPromotion) r0.next();
                c0 r2 = c0.a;
                String r3 = r1.detailUrl;
                ECShopHeaderPreviewGroupPresenter r4 = this.a.a.this$0;
                int r5 = ECShopHeaderPreviewGroupPresenter.n;
                String r6 = r4.l0("live_cell_card");
                String r7 = this.a.a.this$0.h0().getStoreParam().getSearchParams();
                String r8 = this.a.a.this$0.h0().getPassThroughLogData();
                String r9 = (String) this.a.a.this$0.h0().getStoreParam().getPassThroughParam("pass_through_api");
                QContext r10 = this.a.a.this$0.Y();
                FragmentActivity r11 = l0.c(r10.c());
                FragmentActivity r13 = null;
                if ((r11 instanceof FragmentActivity) == true) goto L11;
                r11 = null;
            L11:
                if (r11 != null) goto L13;
                FragmentActivity r12 = r10.a();
            L14:
                r2.getClass();
                r1.detailUrl = c0.a(r3, r6, r7, r8, r9, r12, true);
                String r14 = r1.directlyJumpUrl;
                String r17 = this.a.a.this$0.l0("live_cell_card");
                String r18 = this.a.a.this$0.h0().getStoreParam().getSearchParams();
                String r19 = this.a.a.this$0.h0().getPassThroughLogData();
                String r20 = (String) this.a.a.this$0.h0().getStoreParam().getPassThroughParam("pass_through_api");
                QContext r21 = this.a.a.this$0.Y();
                FragmentActivity r22 = l0.c(r21.c());
                if ((r22 instanceof FragmentActivity) == false) goto L18;
                r13 = r22;
            L18:
                if (r13 != null) goto L20;
                FragmentActivity r23 = r21.a();
            L21:
                r1.directlyJumpUrl = c0.a(r14, r17, r18, r19, r20, r23, true);
                goto L7
            L20:
                r23 = r13;
                goto L21
            L13:
                r12 = r11;
                goto L14
            L22:
                this.b.invoke(r16);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ Function1 a;

            public b(Function1 r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                this.a.invoke(null);
            }
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void e() {
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.this$0.h0().getStoreParam().getLifecycleMonitorId()));
            if (r1 == null) goto L6;
            r1.Q(this.a.this$0.h0().getStoreParam());
            return;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void i() {
            dm.a.a("点击进直播间").a("openLiveWithAnimation");
            if (this.a.this$0.h0().enableLiveTab() == false) goto L5;
            this.a.this$0.h0().setSwitchLiveTabSource(SwitchLiveTabSource.CLICK_LIVE_PREVIEW);
        L5:
            this.a.this$0.h0().getChangeStateEvent().setValue(new ui3.c(-1, ShopStatus.HIDE, 2));
        }

        public a(ECShopHeaderPreviewGroupPresenter$behavior$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void a(StoreV3LiveRoomVO r6) {
            Intrinsics.checkNotNullParameter(r6, "liveInfo");
            ECShopHeaderPreviewGroupPresenter r0 = this.a.this$0;
            int r1 = ECShopHeaderPreviewGroupPresenter.n;
            r0.getClass();
            Map r2 = BtmSDK.INSTANCE.createReportParams("c4706.d3124", PageFinder.via(this.a.this$0.a0()));
            ArrayList r3 = new ArrayList(r2.size());
            Iterator r4 = r2.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry r5 = (Map.Entry) r4.next();
            r3.add(TuplesKt.to(r5.getKey(), String.valueOf(r5.getValue())));
            goto L4
        L6:
            Map<String, String> r7 = MapsKt.toMap(r3);
            ECStoreViewModel r8 = this.a.this$0.h0();
            Pair<String, String>[] r9 = new Pair[5];
            r9[0] = TuplesKt.to("enter_from_merge", "store_page");
            r9[1] = TuplesKt.to("enter_method", this.a.this$0.l0("live_cell"));
            String r10 = r6.getRoomId();
            if (r10 != null) goto L9;
            r10 = "";
        L9:
            r9[2] = TuplesKt.to("room_id", r10);
            StoreV3LiveRoomVO r11 = (StoreV3LiveRoomVO) this.a.this$0.h0().getLiveInfo().getValue();
            if (r11 == null) goto L14;
            Integer r12 = r11.getLiveType();
            if (r12 == null) goto L14;
            String r13 = String.valueOf(r12.intValue());
        L15:
            r9[3] = TuplesKt.to("live_type", r13);
            r9[4] = TuplesKt.to("pass_through_log_data", this.a.this$0.h0().getPassThroughLogData());
            r8.doEventAction("livesdk_live_show", r7, r9);
            return;
        L14:
            r13 = null;
            goto L15
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void b(ShopStatus r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            this.a.this$0.h0().getChangeStateEvent().setValue(new ui3.c(-1, r5, 2));
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void d(boolean r3) {
            if ((!Intrinsics.areEqual((Boolean) this.a.this$0.h0().isLiveOn().getValue(), Boolean.valueOf(r3))) == false) goto L6;
            this.a.this$0.h0().isLiveOn().setValue(Boolean.valueOf(r3));
            return;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void f(StoreUserActionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            r4.with(new BaseEventContext[]{this.a.this$0.h0().getStoreEventContext()}).post(null, null);
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final boolean c(String r3, View r4) {
            Intrinsics.checkNotNullParameter(r3, "schema");
            Intrinsics.checkNotNullParameter(r4, "enterLiveWithAnimView");
            if ((!StringsKt.isBlank(r3)) == true) goto L5;
            return false;
        L5:
            if (this.a.this$0.h0().enableLiveTab() == false) goto L8;
            this.a.this$0.h0().setSwitchLiveTabSource(SwitchLiveTabSource.CLICK_LIVE_CARD);
            this.a.this$0.h0().setLiveSchema(r3);
            this.a.this$0.getClass();
            s0.a(new ah.d(TabEnum.LIVE_TAB.getType(), null));
            return true;
        L8:
            ECShopHeaderPreviewGroupPresenter.k0(this.a.this$0, r3);
            return false;
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void doEventAction(String r3, Pair<String, String>... r4) {
            Intrinsics.checkNotNullParameter("livesdk_open_audio", "eventName");
            Intrinsics.checkNotNullParameter(r4, "params");
            this.a.this$0.h0().doEventAction("livesdk_open_audio", (Pair[]) Arrays.copyOf(r4, r4.length));
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void g(String r10, Function1<? super ECCurrentPromotion, Unit> r11) {
            Intrinsics.checkNotNullParameter(r11, "callback");
            StoreV3LiveRoomVO r0 = (StoreV3LiveRoomVO) this.a.this$0.h0().getLiveInfo().getValue();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r10 != null) goto L7;
            r10 = r0.getPopUrl();
        L7:
            String r2 = r10;
            if (r2 != null) goto L10;
            return;
        L10:
            String r8 = r0.getRoomId();
            if (r8 != null) goto L13;
            return;
        L13:
            String r12 = r0.getAnchorId();
            if (r12 == null) goto L18;
            Long r13 = StringsKt.toLongOrNull(r12);
            if (r13 == null) goto L18;
            long r1 = r13.longValue();
        L19:
            long r3 = r1;
            String r14 = this.a.this$0.h0().getStoreParam().getStoreAccountParam().getSecUserId();
            if (r14 != null) goto L22;
            String r5 = "";
        L23:
            ECStoreApi.a.getClass();
            ECStoreApi r4 = ECStoreApi.a.a;
            if (r4 == null) goto L37;
            String r15 = (String) this.a.this$0.h0().getStoreParam().getPassThroughParam("pass_through_api");
            if (r15 != null) goto L28;
            String r7 = "";
        L29:
            Observable<ECCurrentPromotion> r16 = r4.getStorePopData(r2, r3, r5, 1, r7, r8);
            if (r16 == null) goto L38;
            Observable r17 = bg4.b.b(r16);
            if (r17 == null) goto L39;
            Disposable r18 = r17.subscribe(new C0006a(this, r11), new b(r11));
            if (r18 == null) goto L40;
            com.bytedance.android.ec.core.async.a.a(r18, this.a.this$0.h0());
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L28:
            r7 = r15;
            goto L29
        L37:
            return;
        L22:
            r5 = r14;
        L18:
            r1 = 0;
            goto L19
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.preview.o
        public final void h(View r13, String r14) {
            Intrinsics.checkNotNullParameter(r13, "enterLiveWithAnimView");
            Intrinsics.checkNotNullParameter(r14, "clickType");
            StoreV3LiveRoomVO r15 = (StoreV3LiveRoomVO) this.a.this$0.h0().getLiveInfo().getValue();
            if (r15 != null) goto L5;
            return;
        L5:
            int r0 = gj3.a.a;
            String r3 = gj3.a.b(this.a.this$0.h0());
            c0 r1 = c0.a;
            String r2 = r15.getEnterUrl();
            boolean r4 = this.a.this$0.h0().getStoreParam().isEcShare();
            String r5 = this.a.this$0.h0().getStoreParam().getShareContent();
            String r6 = this.a.this$0.h0().getStoreParam().getShareObject();
            String r7 = this.a.this$0.h0().getStoreParam().getSearchParams();
            String r8 = this.a.this$0.h0().getPassThroughLogData();
            String r9 = (String) this.a.this$0.h0().getStoreParam().getPassThroughParam("pass_through_api");
            QContext r16 = this.a.this$0.Y();
            FragmentActivity r10 = l0.c(r16.c());
            String r11 = null;
            if ((r10 instanceof FragmentActivity) == true) goto L8;
            r10 = null;
        L8:
            if (r10 != null) goto L10;
            FragmentActivity r12 = r16.a();
        L11:
            String r17 = c0.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r12);
            if (r17 != null) goto L14;
        L17:
            boolean r18 = true;
        L18:
            if (r18 == false) goto L20;
            return;
        L20:
            int r19 = com.bytedance.android.ec.store.utils.h.a;
            com.bytedance.android.ec.store.utils.h.d(this.a.this$0.h0().getEntranceInfoJsonObject(), "otherclick", "live_room", this.a.this$0.h0().getAdParams(), "shop_window_ad");
            if (this.a.this$0.h0().enableLiveTab() == false) goto L35;
            this.a.this$0.h0().setLiveSchema(r17);
            if (this.a.this$0.h0().getSwitchLiveTabSource() != SwitchLiveTabSource.CLICK_TAB) goto L32;
            ShopLiveState r110 = (ShopLiveState) this.a.this$0.h0().getLiveState().getValue();
            if (r110 == null) goto L27;
            ShopLiveState.PlayState r111 = r110.a;
        L29:
            if (r111 == ShopLiveState.PlayState.ERROR) goto L32;
            this.a.this$0.h0().getLiveState().setValue(new ShopLiveState(ShopLiveState.PlayState.ENTER_LIVE, ShopLiveState.LiveScene.LIVE_TAB));
        L34:
            dm.a.a("live_tab").i("openLiveRoom,handle enter live tab,source:" + this.a.this$0.h0().getSwitchLiveTabSource());
        L38:
            ECShopHeaderPreviewGroupPresenter r112 = this.a.this$0;
            r112.getClass();
            Map r20 = BtmSDK.INSTANCE.createReportParams("c4706.d3124", PageFinder.via(r112.a0()));
            ArrayList r21 = new ArrayList(r20.size());
            Iterator r22 = r20.entrySet().iterator();
        L40:
            if (r22.hasNext() == false) goto L42;
            Map.Entry r23 = (Map.Entry) r22.next();
            r21.add(TuplesKt.to(r23.getKey(), String.valueOf(r23.getValue())));
            goto L40
        L42:
            Map<String, String> r24 = MapsKt.toMap(r21);
            ECStoreViewModel r25 = r112.h0();
            Pair<String, String>[] r26 = new Pair[5];
            r26[0] = TuplesKt.to("enter_from_merge", "store_page");
            r26[1] = TuplesKt.to("enter_method", r112.l0("live_cell"));
            r26[2] = TuplesKt.to("click_type", r14);
            r26[3] = TuplesKt.to("pass_through_log_data", r112.h0().getPassThroughLogData());
            StoreV3LiveRoomVO r113 = (StoreV3LiveRoomVO) r112.h0().getLiveInfo().getValue();
            if (r113 == null) goto L47;
            Integer r114 = r113.getLiveType();
            if (r114 == null) goto L47;
            r11 = String.valueOf(r114.intValue());
        L47:
            r26[4] = TuplesKt.to("live_type", r11);
            r25.doEventAction("livesdk_livecell_click", r24, r26);
            return;
        L27:
            r111 = null;
        L32:
            if (this.a.this$0.h0().getSwitchLiveTabSource() != SwitchLiveTabSource.CLICK_LIVE_PREVIEW) goto L34;
            this.a.this$0.getClass();
            s0.a(new ah.d(TabEnum.LIVE_TAB.getType(), null));
            goto L34
        L35:
            ECShopHeaderPreviewGroupPresenter.k0(this.a.this$0, r17);
            Activity r27 = l0.b(this.a.this$0.Y().c());
            if (r27 == null) goto L38;
            com.bytedance.android.ec.sdk.helper.p r28 = com.bytedance.android.ec.sdk.helper.p.a;
            int r29 = com.bytedance.android.ec.store.utils.b.a;
            this.a.this$0.getClass();
            PageFinder r30 = PageFinder.via(this.a.$fragment);
            BcmParams r31 = new BcmParams();
            r31.put("bst_group_type", "live");
            Unit r32 = Unit.INSTANCE;
            r28.d(com.bytedance.android.ec.store.utils.b.b(r17, "c4706.d3124", r30, r31), r27);
            goto L38
        L14:
            if (StringsKt.isBlank(r17) == true) goto L17;
            r18 = false;
            goto L18
        L10:
            r12 = r10;
            goto L11
        }
    }

    public ECShopHeaderPreviewGroupPresenter$behavior$2(ECShopHeaderPreviewGroupPresenter r1, Fragment r2) {
        this.this$0 = r1;
        this.$fragment = r2;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m163invoke() {
        return invoke();
    }
}
