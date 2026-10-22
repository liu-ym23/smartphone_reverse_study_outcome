package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility;
import com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionListABConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHeaderData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.LivePromotionListDataSourceFactory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.q;
import com.bytedance.android.livesdk.livecommerce.room.controller.r;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.x;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;
import si2.d0;
import si2.e0;
import si2.f0;
import si2.t;
import si2.z;
import vi2.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListRepository implements tj2.f, lj2.a, tj2.g, oj2.a {
    public c a;
    public i b;
    public d c;
    public LiveData<PagedList<mj2.c>> d;
    public MutableLiveData e;
    public boolean f;
    public boolean g;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a h;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b i;
    public Disposable j;
    public tj2.a k;
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g l;
    public qj2.a m;
    public final List<rj2.b> n;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a o;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.b p;
    public final Function0<RoomContextController> q;
    public final com.bytedance.android.ec.core.async.b r;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b s;

    @Override // tj2.f
    public final void G() {
        this.k = null;
        this.l.a();
        d r0 = this.c;
        if (r0 == null) goto L5;
        r0.a.a();
    L5:
        PromotionListController r1 = J();
        if (r1 == null) goto L13;
        LivePromotionListCacheCenter r2 = r1.F;
        if (r2 == null) goto L13;
        if (r2.f() == true) goto L12;
        r2.e();
        r2.g(false, 13);
    L12:
        LivePromotionListCacheCenter.b(r2);
    L13:
        ((ArrayList) this.n).clear();
    }

    @Override // tj2.f
    public final LivePromotionListRepository q() {
        return this;
    }

    @Override // tj2.f
    public final LivePromotionListRepository s() {
        return this;
    }

    @Override // tj2.f
    public final List<ql.a> A() {
        List<ql.a> r0 = this.h.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // tj2.f
    public final ql.a B() {
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r0 = this.h;
        r0.getClass();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L13;
        List<? extends ql.a> r1 = r0.g;
        if (r1 != null) goto L7;
    L11:
        return null;
    L7:
        if (r1.size() != 1) goto L11;
        List<? extends ql.a> r2 = r0.g;
        if (r2 == null) goto L11;
        return (ql.a) CollectionsKt.firstOrNull(r2);
    L13:
        return r0.f;
    }

    @Override // tj2.f
    public final List<ql.a> F() {
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r0 = this.h;
        PromotionCategory r1 = r0.j;
        if (r1 != null) goto L5;
    L10:
        List<ql.a> r2 = r0.a();
    L11:
        if (r2 == null) goto L13;
        return r2;
    L13:
        return CollectionsKt.emptyList();
    L5:
        if (r1.isAllTab() == true) goto L10;
        Function0<? extends List<? extends ql.a>> r3 = r0.b;
        if (r3 == null) goto L9;
        r2 = (List) r3.invoke();
        goto L11
    L9:
        r2 = null;
        goto L11
    }

    public final PromotionListController J() {
        RoomContextController r0 = (RoomContextController) this.q.invoke();
        c r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.h;
    L6:
        PromotionListController r3 = ControllerExtensionsKt.c(r0, r2).A().r;
        if (r3.x() == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    @Override // tj2.f
    public final PromotionCategory b() {
        return this.o.e();
    }

    @Override // tj2.f
    public final List<ql.a> f() {
        return this.h.f();
    }

    @Override // tj2.f
    public final ql.a g() {
        return this.h.e;
    }

    @Override // tj2.f
    public final void i() {
        this.o.g();
    }

    @Override // tj2.f
    public final void k() {
        c r0 = this.a;
        if (r0 == null) goto L6;
        c r2 = c.a(r0);
        r2.b = "";
        this.i.d(r2, r2.u, 1, true, this.r, new LivePromotionListRepository$updateWhenCache$1(this), new LivePromotionListRepository$updateWhenCache$2(this));
        return;
    }

    @Override // tj2.f
    public final int l() {
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r0 = this.h;
        PromotionCategory r1 = r0.j;
        if (r1 == null) goto L10;
        List<PromotionCategory> r2 = r0.k;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.indexOf(r1));
    L8:
        if (r3 == null) goto L10;
        return r3.intValue();
    L7:
        r3 = null;
    L10:
        return 0;
    }

    @Override // tj2.f
    public final void o() {
        this.h.m();
        PromotionListController r0 = J();
        if (r0 == null) goto L7;
        LivePromotionListCacheCenter r1 = r0.F;
        if (r1 == null) goto L7;
        r1.e();
    L7:
        c r2 = this.a;
        if (r2 == null) goto L10;
        r2.d = true;
    L10:
        if (r2 == null) goto L12;
        r2.b = "";
    L12:
        K(9, 0);
    }

    @Override // tj2.f
    public final ECUIPromotionLiveListConfig r() {
        return this.h.l.e;
    }

    @Override // tj2.f
    public final void D(boolean r1) {
        this.g = r1;
    }

    @Override // lj2.a
    public final void H(z r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (this.g == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = f().iterator();
    L6:
        Object r3 = null;
        if (r0.hasNext() == false) goto L23;
        Object r1 = r0.next();
        ql.a r4 = (ql.a) r1;
        boolean r6 = false;
        if (r4.getProductId().length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L21;
        String r7 = r4.getProductId();
        List<Long> r8 = r10.productIds;
        if (r8 == null) goto L19;
        Long r9 = (Long) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L19;
        r3 = String.valueOf(r9.longValue());
    L19:
        if (Intrinsics.areEqual(r7, r3) == false) goto L21;
        r6 = true;
    L21:
        if (r6 == false) goto L6;
        r3 = r1;
        goto L23
    L11:
        r5 = false;
    L23:
        ql.a r11 = (ql.a) r3;
        if (r11 == null) goto L33;
        c(r11.getPromotionId(), 45, true);
        return;
    }

    @Override // oj2.a
    public final void I(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.p.c(r2);
    }

    @Override // lj2.a
    public final void a(e0 r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if (this.g == true) goto L5;
        return;
    L5:
        d r1 = this.c;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r7, "message");
        String r0 = String.valueOf(r7.promotionId);
        List<ql.a> r2 = r1.e.f();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((ql.a) r5).getPromotionId(), r0) == false) goto L9;
        r3.add(r5);
        goto L9
    L14:
        if ((!r3.isEmpty()) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        r1.e(r7, r3, null, null);
    L19:
        tj2.a r6 = this.k;
        if (r6 == null) goto L28;
        r6.onProductRefreshMsgReceived(new we3.d(CollectionsKt.listOf(new we3.e(Long.valueOf(r7.promotionId)))));
        return;
    }

    @Override // lj2.a
    public final void d(f0 r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if (this.g == true) goto L5;
        return;
    L5:
        i r1 = this.b;
        if (r1 == null) goto L42;
        Intrinsics.checkNotNullParameter(r11, "message");
        Context r0 = com.bytedance.android.livesdk.livecommerce.room.f.a();
        int r2 = r11.updateType;
        ArrayList r5 = null;
        if (r2 == 4) goto L31;
        if (r2 == 9) goto L13;
        return;
    L13:
        if (r11.timeStamp < x.a(r0, "ec_update_hot_atmosphere_timestamp")) goto L43;
        List<Long> r3 = r11.productIds;
        if (r3 == null) goto L20;
        List<Long> r4 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r7 = r4.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        r6.add(String.valueOf(((Number) r7.next()).longValue()));
    L22:
        if (r1.a.c(r11.hotAtmosphere, r11.promotionHeaderInteraction, r11.productIds) == false) goto L29;
        v r8 = new v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        sg2.b r9 = r11.getCommon();
        if (r9 == null) goto L27;
        String r10 = r9.a;
        if (r10 == null) goto L27;
    L28:
        r8.c("message_id", r10);
        r8.c("product_id", String.valueOf(r11.productIds));
        r8.c("scene", "promotion_list");
        r8.c("use_new_message", BDLocationException.ERROR_TIMEOUT);
        r8.c("handled", "1");
        r8.i(null);
        r1.b.invoke(r6, Boolean.TRUE, UpdateLocalViewType.HOT_ATMOSPHERE);
    L27:
        r10 = "NoValue";
    L29:
        x.c(r0, "ec_update_hot_atmosphere_timestamp", r11.timeStamp);
        return;
    L20:
        r6 = null;
        goto L22
    L43:
        return;
    L31:
        if (r11.timeStamp < x.a(r0, "ec_update_commentary_video_timestamp")) goto L45;
        r1.a.b(r11.updatedCommentaryVideoInfo, r11.productIds);
        List<Long> r12 = r11.productIds;
        if (r12 == null) goto L38;
        List<Long> r13 = r12;
        r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L38;
        r5.add(String.valueOf(((Number) r14.next()).longValue()));
    L38:
        r1.b.invoke(r5, Boolean.TRUE, UpdateLocalViewType.UPDATE_ALL);
        x.c(r0, "ec_update_commentary_video_timestamp", r11.timeStamp);
        return;
    L45:
        return;
    }

    @Override // tj2.f
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueIndex");
        this.h.e(r2);
    }

    @Override // lj2.a
    public final void h(z r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (this.g == true) goto L5;
        return;
    L5:
        ArrayList r3 = null;
        Object r4 = null;
        if (r10.msgType == 4) goto L30;
        Iterator<T> r0 = f().iterator();
    L9:
        if (r0.hasNext() == false) goto L27;
        Object r1 = r0.next();
        ql.a r5 = (ql.a) r1;
        boolean r6 = true;
        if (r5.getProductId().length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L24;
        String r8 = r5.getProductId();
        List<Long> r9 = r10.productIds;
        if (r9 == null) goto L20;
        Long r11 = (Long) CollectionsKt.firstOrNull(r9);
        if (r11 == null) goto L20;
        String r12 = String.valueOf(r11.longValue());
    L22:
        if (Intrinsics.areEqual(r8, r12) == false) goto L24;
    L25:
        if (r6 == false) goto L9;
        r4 = r1;
    L20:
        r12 = null;
    L24:
        r6 = false;
        goto L25
    L13:
        r7 = false;
    L27:
        ql.a r13 = (ql.a) r4;
        if (r13 == null) goto L48;
        c(r13.getPromotionId(), 44, false);
        return;
    L48:
        return;
    L30:
        i r2 = this.b;
        if (r2 == null) goto L50;
        Intrinsics.checkNotNullParameter(r10, "message");
        ECV2AuctionInfo r14 = r10.auctionInfo;
        if (r14 == null) goto L51;
        r2.a.a(r14);
        List<Long> r15 = r10.productIds;
        if (r15 == null) goto L40;
        List<Long> r16 = r15;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L40;
        r3.add(String.valueOf(((Number) r17.next()).longValue()));
    L40:
        r2.b.invoke(r3, Boolean.TRUE, UpdateLocalViewType.UPDATE_ALL);
        return;
    L51:
        return;
    }

    @Override // tj2.f
    public final void j(PromotionCategory r4) {
        Intrinsics.checkNotNullParameter(r4, "newSelectedTab");
        ArrayList r0 = (ArrayList) this.n;
        List<? extends ql.a> r2 = null;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L16;
        Function0<? extends List<? extends ql.a>> r1 = this.h.b;
        if (r1 == null) goto L10;
        r2 = (List) r1.invoke();
    L10:
        if (r2 != null) goto L12;
        r2 = CollectionsKt.emptyList();
    L12:
        Iterator r3 = r0.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        ((rj2.b) r3.next()).e(r2);
    L16:
        this.o.a(r4);
    }

    @Override // lj2.a
    public final void m(t r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        int r0 = r5.msgType;
        boolean r1 = true;
        if (r0 != 1) goto L5;
    L7:
        PromotionListController r2 = J();
        if (r2 == null) goto L10;
        Boolean r3 = r2.I;
    L12:
        if (r5.msgType != 1) goto L14;
        boolean r4 = true;
    L16:
        if (Intrinsics.areEqual(r3, Boolean.valueOf(r4)) == false) goto L18;
        return;
    L18:
        PromotionListController r6 = J();
        if (r6 != null) goto L21;
    L25:
        tj2.a r7 = this.k;
        if (r7 != null) goto L28;
        return;
    L28:
        if (r5.msgType == 1) goto L31;
        r1 = false;
    L31:
        String r8 = r5.toast;
        if (r8 != null) goto L34;
        r8 = "";
    L34:
        r7.notifyAuthorDisconnect(r1, r8);
        return;
    L21:
        if (r5.msgType != 1) goto L23;
        boolean r9 = true;
    L24:
        r6.I = Boolean.valueOf(r9);
        goto L25
    L23:
        r9 = false;
        goto L24
    L14:
        r4 = false;
        goto L16
    L10:
        r3 = null;
        goto L12
    L5:
        if (r0 == 2) goto L7;
    }

    @Override // tj2.f
    public final void u(rj2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        ((ArrayList) this.n).add(r2);
    }

    @Override // tj2.g
    public final void updateLoadInitialStatus(mj2.h<PageListLoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "wrapper");
        tj2.a r0 = this.k;
        if (r0 == null) goto L6;
        r0.updateLoadInitialStatus(r2);
        return;
    }

    @Override // oj2.a
    public final void w(si2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.o.f(r2);
    }

    @Override // tj2.g
    public final void C(List<ECPromotionInterationData> r4, boolean r5) {
        tj2.a r0 = this.k;
        if (r0 == null) goto L6;
        tj2.a.C0175a.a(r0, r4, r5, false, 12);
        return;
    }

    public final void K(int r2, Integer r3) {
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.c = r4;
    L6:
        c r5 = this.a;
        if (r5 == null) goto L9;
        r5.a = r2;
    L9:
        MutableLiveData r6 = this.e;
        if (r6 == null) goto L15;
        tj2.d r7 = (tj2.d) r6.getValue();
        if (r7 == null) goto L16;
        r7.refresh();
        return;
    L16:
        return;
    }

    public final void L(int r7, List<String> r8) {
        d r0 = this.c;
        if (r0 == null) goto L6;
        Map<String, String> r2 = MapsKt.mapOf(TuplesKt.to("request_scene", String.valueOf(r7)));
        int r9 = ProductRefreshMessageHandler.b;
        r0.f("/live/promotions/page/get/", r2, r8, null, null);
        return;
    }

    public final void M(ECUIPromotionV2 r5, List r6) {
        this.o.d();
        this.h.d(r5, r6, true);
        tj2.a r0 = this.k;
        if (r0 == null) goto L14;
        MutableLiveData r1 = this.e;
        String r2 = null;
        if (r1 == null) goto L9;
        tj2.d r3 = (tj2.d) r1.getValue();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.getStartPosition());
    L10:
        K(2, r4);
        if (r5 == null) goto L13;
        r2 = r5.getPromotionId();
    L13:
        r0.updateExplainPromotion(r2, r6);
    L9:
        r4 = null;
    L14:
        PromotionListController r7 = J();
        if (r7 == null) goto L22;
        LivePromotionListCacheCenter r8 = r7.F;
        if (r8 == null) goto L23;
        mj2.e r9 = r8.b;
        if (r9 == null) goto L24;
        r9.c = r5;
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // tj2.g
    public final void reportTabFirstPageLoadResult(String r2, int r3) {
        tj2.a r0 = this.k;
        if (r0 == null) goto L6;
        r0.reportTabFirstPageLoadResult(r2, r3);
        return;
    }

    @Override // tj2.g
    public final void updateLoadMoreStatus(PageListLoadStatus r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "status");
        tj2.a r0 = this.k;
        if (r0 == null) goto L6;
        r0.updateLoadMoreStatus(r2, r3);
        return;
    }

    @Override // lj2.a
    public final void z(boolean r4, List<ECPromotionInterationData> r5) {
        if (this.g == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (r4 == true) goto L9;
    L11:
        tj2.a r0 = this.k;
        if (r0 == null) goto L15;
        tj2.a.C0175a.a(r0, r5, r4, true, 8);
        return;
    L15:
        return;
    L9:
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == false) goto L11;
    }

    public LivePromotionListRepository(Function0<RoomContextController> r10, com.bytedance.android.ec.core.async.b r11, com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b r12) {
        Intrinsics.checkNotNullParameter(r10, "roomContextController");
        Intrinsics.checkNotNullParameter(r11, "disposableScope");
        Intrinsics.checkNotNullParameter(r12, "repoMonitor");
        this.q = r10;
        this.r = r11;
        this.s = r12;
        RoomContextController r13 = (RoomContextController) r10.invoke();
        PromotionListController r14 = J();
        if (r14 == null) goto L5;
        LivePromotionListCacheCenter r15 = r14.F;
    L6:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r3 = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a(r13, r15);
        this.h = r3;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b r7 = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b();
        this.i = r7;
        com.bytedance.android.livesdk.livecommerce.room.utils.g r8 = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
        this.l = r8;
        this.n = new ArrayList();
        e r16 = new e(this, r3, new LivePromotionListRepository$repoContext$1(this), new LivePromotionListRepository$repoContext$2(this), r11, r7, r8);
        this.o = r16.a;
        this.p = r16.b;
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // tj2.f
    public final mj2.i E(c r13, tj2.a r14, LivePromotionListViewModel.f r15) {
        Intrinsics.checkNotNullParameter(r13, "requestParam");
        Intrinsics.checkNotNullParameter(r15, "listStateProvider");
        this.a = r13;
        this.k = r14;
        this.m = r15;
        PagedList.Config r16 = new PagedList.Config.Builder().setPageSize(r13.u).setPrefetchDistance(r13.v).setInitialLoadSizeHint(0).setEnablePlaceholders(false).build();
        final LivePromotionListDataSourceFactory r17 = new LivePromotionListDataSourceFactory(r13, this.h, this.i, new LivePromotionListRepository$generateObservablePagedList$pagingDataSourceFactory$1(this), new LivePromotionListRepository$generateObservablePagedList$pagingDataSourceFactory$2(this), new LivePromotionListRepository$generateObservablePagedList$pagingDataSourceFactory$3(this), this.r, (RoomContextController) this.q.invoke());
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r1 = this.h;
        RoomContextController r2 = (RoomContextController) this.q.invoke();
        this.b = new i(r1, new LivePromotionListRepository$generateObservablePagedList$1(this));
        this.c = new d(r13, this.h, this.i, new LivePromotionListRepository$generateObservablePagedList$2(this), new LivePromotionListRepository$generateObservablePagedList$3(this), new LivePromotionListRepository$generateObservablePagedList$4(this), this.r, this.n);
        this.e = r17.a;
        final LiveData<PagedList<mj2.c>> r18 = new LivePagedListBuilder(r17, r16).setInitialLoadKey(Integer.valueOf(r13.c)).build();
        this.d = r18;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r19 = this.h;
        Function0<List<? extends ql.a>> r0 = new LivePromotionListRepository$generateObservablePagedList$5(r18);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r0, "callback");
        r19.b = r0;
        return new mj2.i(r18, new LivePromotionListRepository$generateObservablePagedList$6(this), new LivePromotionListRepository$generateObservablePagedList$7(r17));
    }

    @Override // tj2.f
    public final void c(final String r3, final int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        if (r5 == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.room.utils.g r6 = this.l;
        Function0<Unit> r0 = new LivePromotionListRepository$getPromotionById$1(this, r4, r3);
        int r7 = com.bytedance.android.livesdk.livecommerce.room.utils.g.c;
        r6.c(r3, 0, true, r0);
        return;
    L5:
        L(r4, CollectionsKt.listOf(r3));
    }

    @Override // lj2.a
    public final void t(String r5, final String r6, final Map<String, String> r7) {
        if (this.g == true) goto L6;
        return;
    L6:
        if (r5 == null) goto L8;
        String r8 = a2.d(r5);
    L10:
        if (r8 == null) goto L14;
        final c r9 = this.a;
        if (r9 == null) goto L26;
        com.bytedance.android.livesdk.livecommerce.room.utils.g r0 = this.l;
        Function0<Unit> r3 = new LivePromotionListRepository$updateExplainPromotionFromMessage$$inlined$let$lambda$1(r9, this, r6, r7);
        int r10 = com.bytedance.android.livesdk.livecommerce.room.utils.g.c;
        r0.c("update_explain_promotion", 0, true, r3);
        return;
    L26:
        return;
    L14:
        this.l.f("update_explain_promotion");
        Disposable r11 = this.j;
        if (r11 != null) goto L17;
    L22:
        ql.a r12 = this.h.e;
        M(null, null);
        Iterator r13 = ((ArrayList) this.n).iterator();
    L24:
        if (r13.hasNext() == false) goto L29;
        ((rj2.b) r13.next()).b();
        goto L24
    L29:
        return;
    L17:
        if ((!r11.isDisposed()) == true) goto L20;
        r11 = null;
    L20:
        if (r11 == null) goto L22;
        r11.dispose();
        goto L22
    L8:
        r8 = null;
        goto L10
    }

    @Override // tj2.f
    public final void n(String r3, String r4, String r5, LivePromotionListViewModel.h r6) {
        this.i.getClass();
        CompositeDisposable r0 = CoreRequests.a;
        String r1 = vi2.h.a;
        vi2.h.e(null, null, si2.g.N, new vi2.d0(r3, r4, r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r6), new r(r6));
    }

    @Override // tj2.f
    public final void p(final String r8, final String r9, final String r10, boolean r11, final Function1<? super ECPromotionListTopData, Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        Function0<Unit> r0 = new LivePromotionListRepository$getListInteraction$action$1(this, r8, r9, r10, r12);
        if (r11 == false) goto L5;
        r0.invoke();
        return;
    L5:
        this.l.c("update_product_list_interaction", 1, true, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v20, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    @Override // tj2.g
    public final void x(c r11, mj2.e r12, int r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "reqParams");
        Intrinsics.checkNotNullParameter(r12, "data");
        if (this.f == false) goto L10;
        if (r14 == true) goto L10;
        tj2.a r16 = this.k;
        if (r16 == null) goto L173;
        r16.updatePromotionListTopData(r12);
        return;
    L173:
        return;
    L10:
        if (r12.u == true) goto L16;
        this.f = true;
        PromotionListController r1 = J();
        if (r1 == null) goto L16;
        LivePromotionListCacheCenter r2 = r1.F;
        if (r2 == null) goto L16;
        Handler r3 = k.a;
        r2.i(r11, r12, SystemClock.elapsedRealtime());
    L16:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r17 = this.h;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r12, "data");
        boolean r0 = false;
        Integer r4 = null;
        if (r13 != 0) goto L19;
    L30:
        ArrayList r18 = new ArrayList();
        LivePromotionPageCategoryData r5 = r12.p;
        if (r5 == null) goto L34;
        List<PromotionCategory> r6 = r5.getCategories();
        if (r6 == null) goto L34;
    L36:
        if (r6.size() > 15) goto L38;
        r18.addAll(r6);
    L39:
        int r7 = r12.h;
        LivePromotionPageCategoryData r8 = r12.p;
        if (r8 == null) goto L42;
        int r9 = r8.getShowCategoryProductCount();
    L43:
        if (r7 >= r9) goto L45;
    L46:
        r18.clear();
    L47:
        if (r15 == null) goto L71;
        if (r18.isEmpty() == true) goto L57;
        Iterator r10 = r18.iterator();
    L53:
        if (r10.hasNext() == false) goto L57;
        if (Intrinsics.areEqual(((PromotionCategory) r10.next()).getUniqueIndex(), r15) == false) goto L53;
        boolean r19 = true;
    L58:
        if (r19 == false) goto L71;
        Iterator r20 = r18.iterator();
    L61:
        if (r20.hasNext() == false) goto L65;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((PromotionCategory) r21).getUniqueIndex(), r15) == false) goto L61;
    L66:
        PromotionCategory r22 = (PromotionCategory) r21;
        if (r22 != null) goto L69;
        r22 = (PromotionCategory) CollectionsKt.firstOrNull(r18);
    L69:
        r17.l(r22);
    L75:
        Iterator r110 = r18.iterator();
    L77:
        if (r110.hasNext() == false) goto L83;
        PromotionCategory r23 = (PromotionCategory) r110.next();
        PromotionCategory r24 = r17.j;
        if (r24 == null) goto L81;
        String r25 = r24.getUniqueIndex();
    L82:
        r23.setSelected(Intrinsics.areEqual(r25, r23.getUniqueIndex()));
        goto L77
    L81:
        r25 = null;
        goto L82
    L83:
        Lazy r111 = LiveDynamicContext.c;
        LiveListTabResortAbility r112 = (LiveListTabResortAbility) LiveDynamicContext.a.a().a().get("tab_resort");
        List<PromotionCategory> r113 = r18;
        if (r112 == null) goto L86;
        r113 = r112.f(r18, true);
    L86:
        r17.k = r113;
    L87:
        ArrayList r26 = new ArrayList();
        LivePromotionPageHeaderData r114 = r12.m;
        if (r114 == null) goto L119;
        Map<String, List<ECRitTag>> r115 = r114.getAnchorTags();
        if (r115 == null) goto L119;
        if ((!r115.isEmpty()) == true) goto L95;
        r115 = null;
    L95:
        if (r115 == null) goto L119;
        LivePromotionPageHeaderData r116 = r12.m;
        if (r116 == null) goto L101;
        Map<String, List<ECRitTag>> r117 = r116.getAnchorTags();
        if (r117 == null) goto L101;
        List<ECRitTag> r118 = r117.get("live_room_good_list_header");
    L102:
        if (r118 == null) goto L119;
        List<ECRitTag> r119 = r118;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L105:
        if (r121.hasNext() == false) goto L107;
        r120.add(((ECRitTag) r121.next()).getLabelName());
        goto L105
    L107:
        ?? r122 = new ArrayList();
        Iterator r123 = r120.iterator();
    L109:
        if (r123.hasNext() == false) goto L120;
        Object r27 = r123.next();
        String r28 = (String) r27;
        ECRitTag.Companion.getClass();
        if (Intrinsics.areEqual(r28, "securebuy_room") == false) goto L113;
    L116:
        boolean r29 = true;
    L117:
        if (r29 == false) goto L109;
        r122.add(r27);
        goto L109
    L113:
        if (Intrinsics.areEqual(r28, "quality_verify") == true) goto L116;
        r29 = false;
    L120:
        if (r122 != 0) goto L122;
        r122 = CollectionsKt.emptyList();
    L122:
        r26.addAll((Collection) r122);
        LivePromotionPageHeaderData r124 = r12.m;
        if (r124 == null) goto L125;
        ECPromotionList.f r125 = r124.getAuthorShopInfo();
    L126:
        if (r125 == null) goto L128;
        boolean r30 = true;
    L129:
        ql.d r31 = new ql.d();
        LivePromotionPageHeaderData r126 = r12.m;
        if (r126 == null) goto L137;
        ECPromotionList.f r127 = r126.getAuthorShopInfo();
        if (r127 == null) goto L137;
        ECPromotionList.d r128 = r127.authorReputationInside;
        if (r128 == null) goto L137;
        String r129 = String.valueOf(r128.score);
        if (r129 == null) goto L137;
    L142:
        String r32 = r129;
    L145:
        if (EComABUtils.shouldShowFindSimilar() == false) goto L151;
        LivePromotionPageRoomInfo r130 = r12.j;
        if (r130 != null) goto L149;
    L150:
        r0 = true;
        goto L151
    L149:
        if (r130.getRoomType() != 2) goto L150;
    L151:
        String r131 = EComABUtils.getSimilarConfig().getTitle();
        LivePromotionListABConfig r33 = r12.k;
        if (r33 == null) goto L154;
        r4 = r33.getAddCartOpt();
    L154:
        r17.l = new mj2.d(r30, r26, r31, r32, new ECUIPromotionLiveListConfig(r0, r131, true, r4), r12.x);
        tj2.a r132 = this.k;
        if (r132 == null) goto L175;
        r132.updatePageResponse(r12, this.h.k, r13);
        return;
    L175:
        return;
    L137:
        LivePromotionPageHeaderData r133 = r12.m;
        if (r133 == null) goto L143;
        ECPromotionList.d r134 = r133.getAuthorReputation();
        if (r134 == null) goto L143;
        r129 = String.valueOf(r134.score);
    L143:
        r32 = null;
        goto L145
    L128:
        r30 = false;
        goto L129
    L125:
        r125 = null;
    L101:
        r118 = null;
    L119:
        r122 = 0;
        goto L120
    L65:
        r21 = null;
    L57:
        r19 = false;
    L71:
        if ((!r18.isEmpty()) == false) goto L73;
        PromotionCategory r135 = (PromotionCategory) ListProtector.get(r18, 0);
    L74:
        r17.l(r135);
        goto L75
    L73:
        r135 = null;
        goto L74
    L45:
        if (r18.size() >= 3) goto L47;
    L42:
        r9 = 0;
        goto L43
    L38:
        r18.addAll(r6.subList(0, 15));
    L34:
        r6 = CollectionsKt.emptyList();
        goto L36
    L19:
        if (r13 == 4) goto L30;
        if (r13 == 9) goto L30;
        if (r14 == true) goto L87;
        LivePromotionPageCategoryData r136 = r12.p;
        if (r136 == null) goto L28;
        List<PromotionCategory> r137 = r136.getCategories();
        if (r137 == null) goto L28;
    L29:
        r17.p(r137);
    L28:
        r137 = CollectionsKt.emptyList();
        goto L29
    }

    @Override // tj2.f
    public final void v(String r13, String r14, String r15, String r16, boolean r17, String r18, LivePromotionListViewModel.i r19) {
        this.i.getClass();
        int r10 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r15, r16);
        String r2 = vi2.h.a;
        com.bytedance.android.ec.core.async.a.a(vi2.h.e(r15, r16, si2.g.j, new q0(r13, r14, r15, r16, r17, r18, r10)).observeOn(Schedulers.io()).subscribe(new f(this, r19), new g(r19)), this.r);
    }

    @Override // tj2.f
    public final void y(int r13, Integer r14, String r15, int r16, boolean r17, boolean r18, boolean r19, Function0 r20) {
        Intrinsics.checkNotNullParameter(r15, "changedCategoryUniqueIndex");
        this.p.b(r13, r14, r15, true, r16, r17, r18, r19, null, r20);
    }
}
