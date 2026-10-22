package com.bytedance.android.shopping.store.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECFansClubResponse;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeInfoResponse;
import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import com.bytedance.android.shopping.store.home.entity.FansClubScene;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.bytedance.android.shopping.store.repository.dto.StoreV3DeleteCommitDTO;
import com.bytedance.android.shopping.store.repository.dto.StoreV3FollowCommitDTO;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopFollowBasePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFollowBasePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int J = 0;
    public boolean A;
    public final a0 B;
    public final g C;
    public final f D;
    public final b E;
    public final e F;
    public final d G;
    public final c H;
    public final l I;
    public StoreFollowGiftConfig u;
    public StoreFollowGiftConfig v;
    public Boolean w;
    public boolean x;
    public boolean y;
    public String z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public b(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            if ((!Intrinsics.areEqual(r4.optString("author_id"), this.a.T().getStoreParam().getStoreAccountParam().getUserId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L8;
            ECShopFollowBasePresenter r5 = this.a;
            r5.y = false;
            r5.A = true;
            r5.v0(true, false, null);
            return;
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public c(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            if ((!Intrinsics.areEqual(r3.optString("author_id"), this.a.T().getStoreParam().getStoreAccountParam().getUserId())) == false) goto L5;
            return;
        L5:
            ECShopFollowBasePresenter r4 = this.a;
            r4.A = false;
            r4.v0(true, true, r4.z);
        }
    }

    public static final class d implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public d(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            String r0 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r0, this.a.T().getStoreParam().getStoreAccountParam().getUserId())) == false) goto L6;
            return;
        L6:
            if ((!Intrinsics.areEqual(String.valueOf(r5), this.a.z)) == false) goto L9;
            ECShopFollowBasePresenter r1 = this.a;
            r1.A = true;
            r1.v0(true, true, String.valueOf(r5));
            return;
        }
    }

    public static final class e implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public e(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            boolean r0 = r3.optBoolean("follow_status");
            if ((!Intrinsics.areEqual(r3.optString("sec_shop_id"), this.a.T().getStoreParam().getSecShopId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L11;
            StoreFollowGiftConfig r4 = this.a.u;
            if (r4 == null) goto L11;
            if (a2.b(r4.getText()) == false) goto L11;
            this.a.A = false;
        L11:
            this.a.t0(r0, null);
        }
    }

    public static final class f implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public f(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            boolean r0 = r4.optBoolean("success");
            String r1 = r4.optString("author_id");
            int r5 = r4.optInt("level");
            if ((!Intrinsics.areEqual(r1, this.a.T().getStoreParam().getStoreAccountParam().getUserId())) == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L8;
            ECShopFollowBasePresenter r2 = this.a;
            r2.y = true;
            r2.z = String.valueOf(r5);
            ECShopFollowBasePresenter r6 = this.a;
            r6.A = true;
            r6.t0(true, null);
            return;
        }
    }

    public static final class g implements ti.j {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public g(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            int r0 = r5.optInt("follow_status");
            int r1 = r5.optInt("update_from_remote");
            String r2 = r5.optString("sec_shop_id");
            String r6 = r5.optString("gift_data");
            if ((!Intrinsics.areEqual(r2, this.a.T().getStoreParam().getSecShopId())) == false) goto L5;
            return;
        L5:
            if (r1 != 1) goto L8;
            this.a.T().fetchAll(this.a.u().c());
            return;
        L8:
            boolean r3 = false;
            if (r0 == 0) goto L18;
            if (r0 != 1) goto L21;
            this.a.T().setFollowGiftData(r6);
            ECShopFollowBasePresenter r7 = this.a;
            StoreFollowGiftConfig r4 = r7.u;
            if (r4 != null) goto L15;
        L16:
            r3 = true;
        L17:
            r7.A = r3;
            this.a.t0(true, null);
            return;
        L15:
            if (a2.b(r4.getText()) == true) goto L17;
        L21:
            return;
        L18:
            this.a.t0(false, null);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public h(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            com.bytedance.android.shopping.store.home.entity.n r11 = (com.bytedance.android.shopping.store.home.entity.n) r10;
            if (r11 == null) goto L81;
            ECShopFollowBasePresenter r0 = this.a;
            com.bytedance.android.shopping.store.home.entity.d r1 = r11.c;
            boolean r2 = true;
            if (r1 == null) goto L12;
            FansClubInfo r3 = r1.h;
            if (r3 == null) goto L12;
            if (r3.getJoinStatus() != true) goto L12;
            boolean r4 = true;
        L13:
            r0.y = r4;
            ECShopFollowBasePresenter r5 = this.a;
            com.bytedance.android.shopping.store.home.entity.d r12 = r11.c;
            Integer r6 = null;
            if (r12 == null) goto L18;
            FansClubInfo r13 = r12.h;
            if (r13 == null) goto L18;
            Integer r14 = r13.getFansClubLevel();
        L19:
            r5.z = String.valueOf(r14);
            final ECShopFollowBasePresenter r15 = this.a;
            com.bytedance.android.shopping.store.home.entity.n r7 = (com.bytedance.android.shopping.store.home.entity.n) r15.T().getHeaderArea().getValue();
            if (r7 == null) goto L76;
            com.bytedance.android.shopping.store.home.entity.d r8 = r7.c;
            if (r8 == null) goto L76;
            a0 r9 = r15.B;
            boolean r16 = r8.d;
            r9.a = !r16;
            if (r16 == false) goto L26;
            r15.T().getFollowConfigLiveData().setValue(r15.B);
            goto L76
        L26:
            r15.u = r8.f;
            FansClubInfo r17 = r8.h;
            if (r17 == null) goto L29;
            boolean r18 = r17.getOpenFansClub();
        L30:
            r15.x = r18;
            FansClubInfo r19 = r8.h;
            if (r19 == null) goto L33;
            boolean r20 = r19.getJoinStatus();
        L34:
            FansClubInfo r21 = r8.h;
            if (r21 == null) goto L37;
            StoreFollowGiftConfig r22 = r21.getFansClubCouponConfig();
        L38:
            r15.v = r22;
            r15.A = true;
            jm.a<Boolean> r23 = r15.T().isFollowed();
            Integer r24 = r8.c;
            if (r24 != null) goto L42;
        L44:
            boolean r25 = false;
        L45:
            r23.setValue(Boolean.valueOf(r25));
            Integer r26 = r8.c;
            if (r26 != null) goto L49;
        L51:
            boolean r27 = false;
        L52:
            FansClubInfo r28 = r8.h;
            if (r28 == null) goto L55;
            r6 = r28.getFansClubLevel();
        L55:
            r15.v0(r27, r20, String.valueOf(r6));
            Integer r29 = r8.c;
            if (r29 != null) goto L59;
        L61:
            boolean r30 = false;
        L63:
            if (Intrinsics.areEqual(r15.T().getStoreParam().getSchemaQueryMap().get("auto_follow"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L66;
            if (r30 == true) goto L66;
            boolean r31 = true;
        L67:
            if (r31 == false) goto L70;
            Lazy r32 = ECTaskManager.b;
            ECTaskManager.a.a().a(r15.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopFollowBasePresenter$checkAutoFollow$1(r15));
            goto L76
        L70:
            if (Intrinsics.areEqual(r15.T().getStoreParam().getSchemaQueryMap().get("auto_follow"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L73;
            if (r30 == false) goto L73;
        L74:
            if (r2 == false) goto L76;
            ECToast.showToast$default(ECToast.INSTANCE, r15.u().c(), 2131896840, null, 4, null);
        L73:
            r2 = false;
        L66:
            r31 = false;
            goto L67
        L59:
            if (r29.intValue() != 1) goto L61;
            r30 = true;
            goto L63
        L49:
            if (r26.intValue() != 1) goto L51;
            r27 = true;
            goto L52
        L42:
            if (r24.intValue() != 1) goto L44;
            r25 = true;
            goto L45
        L37:
            r22 = null;
            goto L38
        L33:
            r20 = false;
            goto L34
        L29:
            r18 = false;
        L76:
            a0 r33 = r15.B;
            r33.getClass();
            r33.h = r33.h;
            r33.f = r15.u;
            r15.T().getFollowConfigLiveData().setValue(r15.B);
            Boolean r110 = this.a.w;
            if (r110 == null) goto L80;
            r110.booleanValue();
            ECShopFollowBasePresenter r111 = this.a;
            boolean r34 = Intrinsics.areEqual((Boolean) r111.T().isFollowed().getValue(), Boolean.TRUE);
            ECShopFollowBasePresenter r35 = this.a;
            r111.v0(r34, r35.y, r35.z);
            return;
        L80:
            return;
        L18:
            r14 = null;
        L12:
            r4 = false;
            goto L13
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public i(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            this.a.t0(((Boolean) r3).booleanValue(), this.a.u);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public j(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Pair r7 = (Pair) r6;
            ECShopFollowBasePresenter r8 = this.a;
            int r0 = ECShopFollowBasePresenter.J;
            boolean r9 = r8.i0();
            boolean r1 = true;
            if ((!Intrinsics.areEqual(Boolean.valueOf(r9), this.a.w)) == false) goto L12;
            this.a.w = Boolean.valueOf(r9);
            ECShopFollowBasePresenter r10 = this.a;
            Boolean r2 = (Boolean) r10.T().isFollowed().getValue();
            Boolean r3 = Boolean.TRUE;
            boolean r4 = Intrinsics.areEqual(r2, r3);
            ECShopFollowBasePresenter r5 = this.a;
            r10.v0(r4, r5.y, r5.z);
            if (Intrinsics.areEqual((Boolean) this.a.T().isFollowed().getValue(), r3) == false) goto L13;
            jm.a<Boolean> r11 = this.a.T().getUpdateFollowAreaEvent();
            if (this.a.Z() == 0.0f) goto L10;
            r1 = false;
        L10:
            r11.setValue(Boolean.valueOf(r1));
            return;
        L13:
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        public k(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Float r4 = (Float) r3;
            ECShopFollowBasePresenter r5 = this.a;
            int r0 = ECShopFollowBasePresenter.J;
            float r6 = r5.b0();
            if (Intrinsics.areEqual((Boolean) this.a.T().isFollowed().getValue(), Boolean.TRUE) == false) goto L10;
            jm.a<Boolean> r1 = this.a.T().getUpdateFollowAreaEvent();
            if (r6 != 0.0f) goto L7;
            boolean r7 = true;
        L8:
            r1.setValue(Boolean.valueOf(r7));
            return;
        L7:
            r7 = false;
            goto L8
        }
    }

    public static final class l implements y {
        public final /* synthetic */ ECShopFollowBasePresenter a;

        @Override // com.bytedance.android.shopping.store.home.y
        public final void a() {
            Intrinsics.checkNotNullParameter("fold", "position");
            ECShopFollowBasePresenter r0 = this.a;
            int r2 = ECShopFollowBasePresenter.J;
            r0.s0("", "fold");
        }

        public l(ECShopFollowBasePresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.y
        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "position");
            ECShopFollowBasePresenter r0 = this.a;
            int r1 = ECShopFollowBasePresenter.J;
            r0.r0("", r3);
        }
    }

    static {
    }

    public ECShopFollowBasePresenter() {
        this(null);
    }

    public final void C() {
        ECLiveHybridUtil.p("ecom.store.follow_status_update", this.C);
        ECLiveHybridUtil.p("ecom.fans_club.join_result", this.D);
        ECLiveHybridUtil.p("ecom.fans_club.exit_result", this.E);
        ECLiveHybridUtil.p("ecom.store.follow_status_change", this.F);
        ECLiveHybridUtil.p("ecom.fans_club.update_info", this.G);
        ECLiveHybridUtil.p("ecom.fans_club.get_all_coupon", this.H);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.y == false) goto L12;
        ECStoreApi.a.getClass();
        ECStoreApi r0 = ECStoreApi.a.a;
        if (r0 == null) goto L13;
        Observable<ECFansClubResponse> r1 = r0.getFansClubInfo(T().getStoreParam().getStoreAccountParam().getUserId(), Integer.valueOf(FansClubScene.Shop.ordinal()), Boolean.TRUE);
        if (r1 == null) goto L14;
        Observable r2 = bg4.b.b(r1);
        if (r2 == null) goto L15;
        r2.subscribe(new com.bytedance.android.shopping.store.home.k(this), com.bytedance.android.shopping.store.home.l.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    public ECShopFollowBasePresenter(Fragment r1) {
        super(r1);
        this.A = true;
        this.B = new a0();
        this.C = new g(this);
        this.D = new f(this);
        this.E = new b(this);
        this.F = new e(this);
        this.G = new d(this);
        this.H = new c(this);
        this.I = new l(this);
    }

    public static final void q0(ECShopFollowBasePresenter r9) {
        r9.getClass();
        ECStoreApi.a.getClass();
        ECStoreApi r1 = ECStoreApi.a.a;
        if (r1 == null) goto L14;
        String r3 = r9.T().getStoreParam().getSecShopId();
        int r0 = w0.a;
        ECStoreHomeConfig.a r2 = ECStoreHomeConfig.Companion;
        ECStoreParam r4 = r9.T().getStoreParam();
        r2.getClass();
        String r5 = u0.d(ECStoreHomeConfig.a.a(r4));
        if ((!Intrinsics.areEqual(r5, "{}")) == true) goto L8;
        r5 = null;
    L8:
        Observable<ECStoreHomeInfoResponse> r6 = r1.getHomeInfo("/shop/home/info/", r3, w0.a(r5), (String) r9.T().getStoreParam().getPassThroughParam("pass_through_api"), r9.T().getStoreParam().getApiExtParam(), 0, com.bytedance.android.ec.hybrid.list.util.k.d(ECShopABSettings.k.b()));
        if (r6 == null) goto L15;
        Observable r7 = bg4.b.b(r6);
        if (r7 == null) goto L16;
        r7.subscribe(new com.bytedance.android.shopping.store.home.i(r9), new com.bytedance.android.shopping.store.home.j(r9));
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void A(QModel r4) {
        W().getLifecycle().addObserver(this);
        T().setIShopInfoAreaAbility(this.I);
        T().getHeaderArea().a(W(), new h(this), false);
        T().getFollowStatusChanged().a(W(), new i(this), false);
        Intrinsics.checkNotNullParameter(this, "$this$registerJsEventSubscriber");
        ECLiveHybridUtil.m("ecom.store.follow_status_update", this.C);
        ECLiveHybridUtil.m("ecom.fans_club.join_result", this.D);
        ECLiveHybridUtil.m("ecom.fans_club.exit_result", this.E);
        ECLiveHybridUtil.m("ecom.store.follow_status_change", this.F);
        ECLiveHybridUtil.m("ecom.fans_club.update_info", this.G);
        ECLiveHybridUtil.m("ecom.fans_club.get_all_coupon", this.H);
        T().getSelectedTabLocation().d(W(), new j(this));
        T().getCollapseFactor().a(W(), new k(this), false);
    }

    public final void u0(int r22) {
        JSONObject r0 = new JSONObject(T().getFollowGiftData());     // Catch: Exception -> L4
    L5:
        String r1 = r0.optString("coupon_id");
        boolean r2 = r0.optBoolean("continue_apply");
        Object r3 = r0.opt("status_code");
        int r4 = ECSdk.a;
        IECHostService r5 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r5 == null) goto L11;
        vi.a r6 = r5.getIECHostAppInfo();
        if (r6 == null) goto L11;
        JSONObject r8 = new JSONObject();
        r8.put("eventName", "UPDATE_FOLLOW_STATUS");
        JSONObject r9 = new JSONObject();
        r9.put("couponId", r1);
        r9.put("continueApply", r2);
        r9.put("statusCode", r3);
        r9.put("followStatus", r22);
        Unit r11 = Unit.INSTANCE;
        r8.put("data", r9);
        r6.d(r8);
    L11:
        long r14 = System.currentTimeMillis();
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("couponId", r1);
        r7.put("continueApply", Boolean.valueOf(r2));
        r7.put("statusCode", r3);
        r7.put("followStatus", Integer.valueOf(r22));
        Unit r10 = Unit.INSTANCE;
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("KEY_EVENT_FOLLOW_STATE", r14, "1003", true, r7, false, 32));
        return;
    L4:
        r0 = new JSONObject();
        goto L5
    }

    public final void r0(String r9, String r10) {
        Integer r0 = T().getStoreParam().getFollowStatus();
        if (r0 == null) goto L40;
        int r1 = r0.intValue();
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L22;
        ECStoreApi.a.getClass();
        ECStoreApi r2 = ECStoreApi.a.a;
        if (r2 == null) goto L22;
        String r3 = T().getStoreParam().getStoreAccountParam().getSecUserId();
        Intrinsics.checkNotNull(r3);
        Observable<StoreV3DeleteCommitDTO> r4 = r2.deleteFollowCommit(r3);
        if (r4 == null) goto L22;
        Observable r5 = bg4.b.b(r4);
        if (r5 == null) goto L22;
        r5.subscribe(new com.bytedance.android.shopping.store.home.e(this), new com.bytedance.android.shopping.store.home.f(this));
    L22:
        if (r1 != 0) goto L24;
        int r6 = 2131896874;
    L25:
        String r7 = ag4.a.d(r6);
        ECStoreViewModel r8 = T();
        BtmSDK r11 = BtmSDK.INSTANCE;
        uj3.j r12 = T().getCurrentTab();
        if (r12 != null) goto L28;
    L30:
        String r13 = "a1.b6269.c5887.d3100";
    L31:
        Map r14 = r11.createReportParams(r13, PageFinder.via(y()));
        ArrayList r15 = new ArrayList(r14.size());
        Iterator r16 = r14.entrySet().iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        Map.Entry r17 = (Map.Entry) r16.next();
        r15.add(TuplesKt.to(r17.getKey(), String.valueOf(r17.getValue())));
        goto L33
    L35:
        r8.doEventAction("click_store_follow", MapsKt.toMap(r15), new Pair[]{TuplesKt.to("position", r10), TuplesKt.to("author_id", T().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("entrance_location", "others_homepage"), TuplesKt.to("enter_from", "others_homepage"), TuplesKt.to("store_type", "shop"), TuplesKt.to("button_status", r7), TuplesKt.to("icon_name", r9)});
        if (r1 != 0) goto L41;
        boolean r18 = gm.a.a;
        gm.a.b("shop_follow_shop", PostActionType.DO);
        return;
    L41:
        return;
    L28:
        if (r12.j() != true) goto L30;
        r13 = "a1.b0715.c722556.d29819";
        goto L31
    L24:
        r6 = 2131896852;
        goto L25
    L15:
        ECStoreApi.a.getClass();
        ECStoreApi r19 = ECStoreApi.a.a;
        if (r19 == null) goto L22;
        String r20 = T().getStoreParam().getStoreAccountParam().getSecUserId();
        Intrinsics.checkNotNull(r20);
        Observable<StoreV3FollowCommitDTO> r21 = r19.doFollowCommit(r20, null, null, (String) T().getStoreParam().getPassThroughParam("pass_through_api"));
        if (r21 == null) goto L22;
        Observable r22 = bg4.b.b(r21);
        if (r22 == null) goto L22;
        r22.subscribe(new com.bytedance.android.shopping.store.home.g(this), new com.bytedance.android.shopping.store.home.h(this));
        goto L22
    }

    public final void s0(String r7, String r8) {
        if (this.x == true) goto L5;
    L36:
        r0(r7, r8);
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) T().isFollowed().getValue(), Boolean.TRUE) == false) goto L36;
        FansClubInfo r9 = T().getStoreParam().getFansInfo();
        if (r9 == null) goto L23;
        String r10 = r9.getFansClubUrl();
        if (r10 == null) goto L23;
        m0 r1 = new m0(r10);
        r1.b("author_id", T().getStoreParam().getStoreAccountParam().getUserId());
        r1.b("sec_shop_id", T().getStoreParam().getSecShopId());
        r1.b("shop_id", T().getStoreParam().getShopId());
        String r11 = r1.c();
        com.bytedance.android.ec.sdk.helper.p r2 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r3 = u();
        FragmentActivity r4 = l0.c(r3.c());
        FragmentActivity r5 = null;
        if ((r4 instanceof FragmentActivity) == true) goto L13;
        r4 = null;
    L13:
        if (r4 != null) goto L19;
        FragmentActivity r6 = r3.c();
        if ((r6 instanceof FragmentActivity) == false) goto L18;
        r5 = r6;
    L18:
        r4 = r5;
    L19:
        if (r4 != null) goto L22;
        r4 = ECAppInfoService.e.getApplicationContext();
    L22:
        r2.openSchema(r4, r11);
    L23:
        ECStoreViewModel r12 = T();
        Pair<String, String>[] r13 = new Pair[8];
        r13[0] = TuplesKt.to("fans_club_type", "ecom_fans_club");
        r13[1] = TuplesKt.to("position", r8);
        r13[2] = TuplesKt.to("fans_club_channel", "shop");
        r13[3] = TuplesKt.to("entrance_location", T().getStoreParam().getEntranceLocation());
        if (com.bytedance.android.shopping.extensions.k.c(this.z) == false) goto L26;
        String r14 = "level_" + this.z;
    L27:
        r13[4] = TuplesKt.to("ecom_fans_status", r14);
        r13[5] = TuplesKt.to("anchor_id", T().getStoreParam().getStoreAccountParam().getUserId());
        r13[6] = TuplesKt.to("shop_id", T().getStoreParam().getShopId());
        if (this.A == false) goto L34;
        StoreFollowGiftConfig r15 = this.v;
        if (r15 == null) goto L34;
        if (a2.b(r15.getText()) == false) goto L34;
        String r16 = CommentScene.COMMENTSCENE_NO_AWEME;
    L35:
        r13[7] = TuplesKt.to("is_with_coupon", r16);
        r12.doEventAction("livesdk_ecom_fans_club_entrance_click", r13);
        return;
    L34:
        r16 = "0";
        goto L35
    L26:
        r14 = "not_in";
        goto L27
    }

    public final void t0(boolean r6, StoreFollowGiftConfig r7) {
        int r0 = com.bytedance.android.ec.store.utils.h.a;
        JSONObject r1 = T().getEntranceInfoJsonObject();
        if (r6 == false) goto L5;
        String r2 = "follow";
    L6:
        com.bytedance.android.ec.store.utils.h.d(r1, r2, "button", T().getAdParams(), "shop_window_ad");
        this.u = r7;
        T().isFollowed().setValue(Boolean.valueOf(r6));
        T().changeFollowStatus(r6);
        ECStoreParam r8 = T().getStoreParam();
        if (r6 == false) goto L9;
        int r3 = 1;
    L10:
        r8.setFollowStatus(r3);
        v0(r6, this.y, this.z);
        if (r6 != true) goto L13;
        u0(1);
        return;
    L13:
        if (r6 == true) goto L17;
        u0(0);
        return;
    L17:
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = "follow_cancel";
        goto L6
    }

    public final void v0(boolean r4, boolean r5, String r6) {
        if (this.x == false) goto L6;
        if (r4 == false) goto L6;
        a0 r7 = this.B;
        r7.c = true;
        r7.b = false;
        r7.e = true;
        r7.i = r5;
        r7.h = r6;
        r7.g = this.v;
        r7.d = this.A;
    L7:
        T().getFollowConfigLiveData().setValue(this.B);
        return;
    L6:
        a0 r0 = this.B;
        r0.c = false;
        r0.b = true;
        r0.e = r4;
        r0.i = r5;
        r0.h = r6;
        r0.f = this.u;
        goto L7
    }
}
