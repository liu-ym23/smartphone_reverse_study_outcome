package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.const.VolumeTypes;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w1 extends ECShopBasePresenter {
    public boolean u;
    public boolean v;
    public boolean w;

    public static final class a<T> implements Observer {
        public final /* synthetic */ w1 a;

        public a(w1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.shopping.store.home.entity.n r6 = (com.bytedance.android.shopping.store.home.entity.n) r5;
            String r0 = this.a.T().getStoreParam().getShopId();
            if (r0 == null) goto L5;
            w1 r2 = this.a;
            HashSet<String> r3 = com.bytedance.android.shopping.store.home.x.a;
            Intrinsics.checkNotNullParameter(r0, "shopId");
            r2.v = !com.bytedance.android.shopping.store.home.x.a.contains(r0);
        L5:
            com.bytedance.android.shopping.store.home.entity.i r7 = r6.g;
            if (r7 == null) goto L8;
            Integer r8 = r7.c;
        L9:
            if (r8 == null) goto L15;
            if (r8.intValue() != 2) goto L15;
            this.a.v = true;
        L15:
            if (this.a.T().getStoreParam().getShopId() != null) goto L18;
            this.a.v = false;
        L18:
            if (this.a.I() == true) goto L22;
            if (this.a.G() == true) goto L22;
        L23:
            this.a.T().getHeadAnimationEnd().setValue(Boolean.TRUE);
            return;
        L22:
            if (this.a.U() == true) goto L23;
            return;
        L8:
            r8 = null;
            goto L9
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ w1 a;

        public b(w1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            ECStoreTabAreaVO r8 = (ECStoreTabAreaVO) r7;
            com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
            Integer r1 = null;
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.store.home.entity.i r2 = r0.g;
            if (r2 == null) goto L7;
            Integer r3 = r2.c;
        L9:
            if (r3 == null) goto L63;
            boolean r4 = true;
            if (r3.intValue() != 1) goto L63;
            w1 r5 = this.a;
            if (r5.v == false) goto L63;
            Pair<Integer, Integer> r6 = r5.O();
            List<uj3.j> r9 = r8.b;
            if (r9 == null) goto L40;
            uj3.j r10 = (uj3.j) CollectionsKt.getOrNull(r9, ((Number) r6.getFirst()).intValue());
            if (r10 == null) goto L40;
            List<uj3.j> r11 = r10.b;
            if (r11 != null) goto L22;
        L25:
            boolean r12 = true;
        L27:
            if ((!r12) == true) goto L30;
            r10 = null;
        L30:
            if (r10 == null) goto L40;
            List<uj3.j> r13 = r10.b;
            if (r13 == null) goto L36;
            uj3.j r14 = (uj3.j) CollectionsKt.getOrNull(r13, ((Number) r6.getSecond()).intValue());
            if (r14 == null) goto L36;
            Integer r15 = Integer.valueOf(r14.d);
        L37:
            if (r15 == null) goto L40;
            r1 = r15;
        L45:
            this.a.getClass();
            if (r1 == null) goto L58;
            int r16 = r1.intValue();
            if (r16 != TabEnum.SELECTION_TAB.getType()) goto L50;
        L59:
            if (r4 == true) goto L61;
            this.a.v = false;
        L61:
            this.a.T().getVideoInfo().a(this.a.W(), new x1(this), false);
            goto L63
        L50:
            if (r16 == TabEnum.ISV_PLUS_TAB.getType()) goto L59;
            if (r16 == TabEnum.MIXED_SELECTION_TAB.getType()) goto L59;
            if (r16 == TabEnum.STRATEGY_SELECTION_TAB.getType()) goto L59;
            if (r16 == TabEnum.CONFIGURED_SELECTION_TAB.getType()) goto L59;
        L58:
            r4 = false;
        L36:
            r15 = null;
            goto L37
        L22:
            if (r11.isEmpty() == true) goto L25;
            r12 = false;
        L40:
            List<uj3.j> r17 = r8.b;
            if (r17 == null) goto L45;
            uj3.j r18 = (uj3.j) CollectionsKt.getOrNull(r17, ((Number) r6.getFirst()).intValue());
            if (r18 == null) goto L45;
            r1 = Integer.valueOf(r18.d);
        L63:
            if (this.a.I() == true) goto L65;
        L66:
            w1 r19 = this.a;
            r19.T().getFloatArea().a(r19.W(), new y1(r19), false);
            return;
        L65:
            if (this.a.G() == false) goto L66;
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ w1 a;

        public c(w1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ShopHeaderVideoVO r3 = (ShopHeaderVideoVO) r2;
            com.bytedance.android.shopping.store.home.entity.n r4 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
            if (r4 == null) goto L7;
            com.bytedance.android.shopping.store.home.entity.i r5 = r4.g;
            if (r5 == null) goto L7;
            Integer r6 = r5.c;
        L8:
            if (r6 != null) goto L11;
        L14:
            w1.q0(this.a);
            return;
        L11:
            if (r6.intValue() != 1) goto L14;
            if (this.a.v == false) goto L14;
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ w1 a;

        public d(w1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            StoreV3LiveRoomVO r10 = (StoreV3LiveRoomVO) r9;
            if (this.a.I() == true) goto L69;
            w1 r11 = this.a;
            if (r11.U() == true) goto L73;
            boolean r0 = r11.E();
            if (r11.G() == true) goto L10;
        L14:
            boolean r1 = false;
        L15:
            Boolean r5 = null;
            if (r11.U() == false) goto L18;
        L31:
            boolean r4 = false;
        L32:
            if (r4 == false) goto L40;
            int r6 = ECSdk.a;
            IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r7 == null) goto L40;
            com.bytedance.android.ec.adapter.api.j r8 = r7.getLiveWindowService();
            if (r8 == null) goto L40;
            Activity r12 = com.bytedance.android.ec.core.utils.l0.b(r11.u().c());
            if (r12 == null) goto L40;
            r8.c(r12, new com.bytedance.android.ec.adapter.api.a());
        L40:
            if (r1 == false) goto L50;
            im.b r13 = r11.T().getLiveManager();
            Integer r14 = r11.T().getStoreParam().getStoreUIParam().getVolume();
            int r15 = VolumeTypes.MUTE.getType();
            if (r14 != null) goto L45;
        L46:
            boolean r16 = true;
        L48:
            im.b.i(r13, false, r16, 1);
            goto L50
        L45:
            if (r14.intValue() != r15) goto L46;
            r16 = false;
        L50:
            if (r0 == false) goto L62;
            com.bytedance.android.shopping.store.home.entity.n r17 = (com.bytedance.android.shopping.store.home.entity.n) r11.T().getHeaderArea().getValue();
            if (r17 == null) goto L57;
            com.bytedance.android.shopping.store.home.entity.g r18 = r17.e;
            if (r18 == null) goto L57;
            r5 = r18.j;
        L57:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L59;
            r11.y().post(new v1(r11));
            r11.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L59:
            if (r1 == false) goto L61;
            r11.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
        L63:
            r11.T().getFloatArea().a(r11.W(), new y1(r11), false);
            if (r0 == true) goto L66;
            return;
        L66:
            if (r11.T().getFlagHasDisplayTopLive() == true) goto L72;
            r11.T().setFlagHasDisplayTopLive(true);
            return;
        L72:
            return;
        L61:
            r11.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
            goto L63
        L62:
            r11.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.NORMAL, 2));
            goto L63
        L18:
            if (com.bytedance.android.ec.core.utils.y0.a() == true) goto L20;
        L22:
            boolean r19 = false;
        L23:
            if (r19 == false) goto L31;
            int r20 = ECSdk.a;
            s83.g r21 = (s83.g) ECSdk.a(s83.g.class);
            if (r21 == null) goto L27;
            Boolean r22 = r21.hasLivePlayingMute();
        L29:
            if (Intrinsics.areEqual(r22, Boolean.FALSE) == false) goto L31;
            r4 = true;
            goto L32
        L27:
            r22 = null;
            goto L29
        L20:
            if (Intrinsics.areEqual((Boolean) r11.T().isLiveOn().getValue(), Boolean.FALSE) == false) goto L22;
            r19 = true;
            goto L23
        L10:
            if (r11.U() == true) goto L14;
            if (r11.T().canShowLiveFloatView() == false) goto L14;
            r1 = true;
            goto L15
        L73:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ w1 a;

        public e(w1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            Pair r10 = (Pair) r9;
            w1 r11 = this.a;
            Pair<Integer, Integer> r0 = r11.T().getLastSelectedTabLocation();
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            boolean r12 = false;
        L9:
            w1 r2 = this.a;
            Pair<Integer, Integer> r3 = r2.T().getLastSelectedTabLocation();
            if (r3 != null) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r12 == true) goto L18;
            if (r4 == true) goto L18;
            return;
        L18:
            w1 r13 = this.a;
            if (r13.U() == false) goto L22;
            return;
        L22:
            if (r13.I() == false) goto L24;
            r13.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L24:
            boolean r5 = r13.E();
            if (r13.Z() < 1.0f) goto L34;
            AbsECShopPresenter$currentIsProductTab$1 r6 = AbsECShopPresenter$currentIsProductTab$1.INSTANCE;
            ECStoreTabAreaVO r7 = (ECStoreTabAreaVO) r13.T().getTabArea().getValue();
            if (r7 == null) goto L32;
            List<uj3.j> r8 = r7.b;
            if (r8 == null) goto L32;
            int r14 = com.bytedance.android.shopping.store.home.t.a;
            boolean r15 = com.bytedance.android.shopping.store.home.t.c(r8, r13.N(), r6);
        L33:
            if (r15 == false) goto L34;
        L35:
            if (r1 == false) goto L41;
            if (r5 == false) goto L42;
            r13.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L42:
            return;
        L41:
            return;
        L32:
            r15 = false;
        L34:
            r1 = true;
            goto L35
        L13:
            if (((Number) r3.getSecond()).intValue() == ((Number) r2.N().getSecond()).intValue()) goto L15;
            r4 = true;
            goto L16
        L6:
            if (((Number) r0.getFirst()).intValue() == ((Number) r11.N().getFirst()).intValue()) goto L8;
            r12 = true;
            goto L9
        }
    }

    public w1(Fragment r1) {
        super(r1);
        this.u = true;
        this.v = true;
        this.w = true;
    }

    public static final void q0(w1 r6) {
        if (r6.U() == false) goto L5;
        return;
    L5:
        if (r6.I() == true) goto L8;
        return;
    L8:
        if (r6.I() == true) goto L10;
    L12:
        boolean r0 = false;
    L13:
        com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) r6.T().getHeaderArea().getValue();
        if (r2 == null) goto L18;
        com.bytedance.android.shopping.store.home.entity.g r3 = r2.e;
        if (r3 == null) goto L18;
        Boolean r4 = r3.j;
    L19:
        boolean r5 = Intrinsics.areEqual(r4, Boolean.TRUE);
        if (r6.u == false) goto L37;
        if (r0 == true) goto L23;
    L34:
        r6.u = false;
        return;
    L23:
        if (r5 == false) goto L25;
    L33:
        r6.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
        r6.u = false;
        return;
    L25:
        if (r6.v == false) goto L33;
        String r7 = r6.T().getStoreParam().getShopId();
        if (r7 == null) goto L32;
        HashSet<String> r8 = com.bytedance.android.shopping.store.home.x.a;
        Intrinsics.checkNotNullParameter(r7, "shopId");
        HashSet<String> r9 = com.bytedance.android.shopping.store.home.x.a;
        if (r9.contains(r7) == true) goto L32;
        Intrinsics.checkNotNullParameter(r7, "shopId");
        r9.add(r7);
    L32:
        r6.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
        goto L34
    L37:
        return;
    L18:
        r4 = null;
        goto L19
    L10:
        if (r6.U() == true) goto L12;
        r0 = true;
        goto L13
    }

    public final void A(QModel r4) {
        T().getHeaderArea().a(W(), new a(this), false);
        T().getTabArea().a(W(), new b(this), false);
        T().getVideoInfo().a(W(), new c(this), false);
        T().getLiveInfo().a(W(), new d(this), false);
        T().getSelectedTabLocation().a(W(), new e(this), false);
    }
}
