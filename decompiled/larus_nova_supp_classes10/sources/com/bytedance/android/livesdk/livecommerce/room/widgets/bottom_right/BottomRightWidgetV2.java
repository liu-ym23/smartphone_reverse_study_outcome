package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.livesdk.livecommerce.event.o0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.ExplainCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightWidgetV2 extends ak2.b implements IECWidgetType, IWidgetType, h {
    public Disposable a;
    public final com.bytedance.android.livesdk.livecommerce.room.model.g b;
    public final BottomRightCardManager c;
    public final pk2.c d;
    public boolean e;
    public final ECContext f;
    public final com.bytedance.android.livesdk.livecommerce.room.api.e g;
    public final RoomContextController h;
    public final LiveRoomParams i;

    public static final class a {
    }

    public static final class b implements cf.i {
        public final /* synthetic */ BottomRightWidgetV2 a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Pair c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ Map e;
            public final /* synthetic */ String f;

            public a(b r1, Function1 r2, Pair r3, boolean r4, Map r5, String r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final void accept(Object r9) {
                ECCurrentPromotion r10 = (ECCurrentPromotion) r9;
                int r0 = ((com.bytedance.android.ec.model.g) r10).statusCode;
                if (r0 != 0) goto L6;
                this.b.invoke(r10);
                return;
            L6:
                if (r0 != 300010001) goto L11;
                int r11 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
                Intrinsics.checkNotNullParameter("pop_card_message", "scene");
                Pair r12 = this.c;
                if (r12 != null) goto L10;
                this.b.invoke(null);
                return;
            L10:
                long r1 = ((Number) r12.getFirst()).longValue();
                long r2 = ((Number) this.c.getSecond()).longValue();
                long r4 = (long) (r1 + ((r2 - r1) * new Random().nextFloat()));
                dm.a.a("BottomRightWidgetV2").i("delayMaxMS " + r2 + " delayMinMS " + r1 + " delay " + r4);
                new o0().k();
                this.a.a.a = Observable.timer(r4, TimeUnit.MILLISECONDS).subscribe(new f(this));
                return;
            L11:
                this.b.invoke(null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightWidgetV2$b$b, reason: collision with other inner class name */
        public static final class C0107b<T> implements Consumer {
            public final /* synthetic */ Function1 a;

            public C0107b(Function1 r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                this.a.invoke(null);
            }
        }

        public b(BottomRightWidgetV2 r1) {
            this.a = r1;
        }

        public final void a(String r9, boolean r10, Pair<Long, Long> r11, s r12, String r13, Map<String, String> r14, Function1<? super ECCurrentPromotion, Unit> r15) {
            Intrinsics.checkNotNullParameter(r15, "callback");
            if (r13 == null) goto L11;
            if (r13.length() <= 0) goto L7;
            boolean r16 = true;
        L8:
            if (r16 != true) goto L11;
        L15:
            Disposable r17 = this.a.a;
            if (r17 == null) goto L18;
            r17.dispose();
        L18:
            BottomRightWidgetV2 r18 = this.a;
            String r6 = r13;
            r18.a = bg4.b.b(pk2.a.C0160a.a(r18.d, r18.b, false, r10, r12, r14, r6, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE)).subscribe(new a(this, r15, r11, r10, r14, r6), new C0107b(r15));
            return;
        L7:
            r16 = false;
        L11:
            if (this.a.h.v() == false) goto L13;
            String r19 = "/live/promotions/pop/preview/";
        L14:
            r13 = r19;
            goto L15
        L13:
            r19 = null;
            goto L14
        }
    }

    public static final class c implements cf.c {
        public c() {
        }

        public final String a() {
            return "c2627.d4434";
        }

        public final String b() {
            return "c2627.d6587";
        }

        public final String c() {
            return "c2627.d661279";
        }

        public final String d() {
            return "c2627.d969730";
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BottomRightWidgetV2 a;

        public d(BottomRightWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (t.j == true) goto L6;
            this.a.q(r3.booleanValue());
            return;
        }
    }

    static {
    }

    @Override // ak2.b
    public final void onHide() {
    }

    @Override // ak2.b
    public final void onLoad() {
        this.e = true;
    }

    @Override // ak2.b
    public final void onShow() {
    }

    @Override // ak2.b
    public final void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final View getView() {
        return this.c.getView();
    }

    public final void load() {
        ECLiveEntranceMonitor.trace$default("load", "BottomRightWidgetV2", false, 4, null);
        this.f.isBottomCardVisible().a().subscribe(new d(this));
        BottomRightCardManager r0 = this.c;
        boolean r1 = r0 instanceof i;
        if (r1 == false) goto L9;
        if (r1 == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L10;
        dm.a.a("LiveCardLoad").i("try show related card on room enter");
        r0.t();
        dm.a.a("LiveCardLoad").i("try show explain card on room enter");
        i.a.a(r0, new BottomRightWidgetV2$load$$inlined$also$lambda$1(this), false, null, 125);
        return;
    L10:
        return;
    }

    public final void onDestroy() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c.onDestroy();
    }

    @Override // ak2.b
    public final void onUnload() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e = false;
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        return IWidgetType.ExternalWidgetType.ECOMMERCE_POP_CARD;
    }

    public final IECWidgetType.ECExternalWidgetType j() {
        return IECWidgetType.ECExternalWidgetType.ECOMMERCE_POP_CARD;
    }

    @Override // ak2.b
    public final void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h
    public final void q(boolean r6) {
        ECLiveEntranceMonitor.trace$default("isBottomCardVisible=" + r6 + " hasLoaded=" + this.e, "BottomRightWidgetV2", false, 4, null);
        if (r6 == true) goto L5;
        this.g.K(this);     // Catch: Exception -> L10
        return;
    L5:
        if (this.e == true) goto L7;
        this.g.L(this, xd.b.a);     // Catch: Exception -> L10
    L7:
        OptCardUtil.b(null, "call requestShow");     // Catch: Exception -> L10
        this.g.O(this);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("BottomRightWidgetV2").b("setBottomCardVisibility error", e);
    }

    public BottomRightWidgetV2(Context r10, ECContext r11, com.bytedance.android.livesdk.livecommerce.room.api.e r12, RoomContextController r13, LiveRoomParams r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ecContext");
        Intrinsics.checkNotNullParameter(r12, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r13, "roomContextController");
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        com.bytedance.android.livesdk.livecommerce.room.model.g r3 = new com.bytedance.android.livesdk.livecommerce.room.model.g(r11, r13);
        this.b = r3;
        BottomRightCardManager r15 = new BottomRightCardManager(r10, r3, r14, new b(this), 0, new c(), r13);
        ExplainCardWidgetController r16 = r15.b;
        RelatedCardWidgetController r17 = null;
        if ((r16 instanceof ExplainCardWidgetController) == true) goto L5;
        r16 = null;
    L5:
        if (r16 == null) goto L7;
        r16.c = this;
    L7:
        RelatedCardWidgetController r18 = r15.c;
        if ((r18 instanceof RelatedCardWidgetController) == false) goto L11;
        r17 = r18;
    L11:
        if (r17 == null) goto L13;
        r17.b = this;
    L13:
        this.c = r15;
        this.d = new pk2.c();
    }
}
