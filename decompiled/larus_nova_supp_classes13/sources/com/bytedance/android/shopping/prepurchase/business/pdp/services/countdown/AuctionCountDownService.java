package com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown;

import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.frontier.WsConnectionManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.a1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.anchorv3.auction.f;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.j1;
import com.bytedance.android.shopping.anchorv4.vm.d;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityTime;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoDisplay;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.h;
import vg3.k0;
import vg3.u;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AuctionCountDownService extends b0 implements h {
    public static final /* synthetic */ int r = 0;
    public final Lazy i;
    public final Lazy j;
    public final List<l1.a> k;
    public boolean l;
    public Disposable m;
    public d n;
    public f o;
    public com.bytedance.android.ec.core.frontier.c p;
    public long q;

    public static final class a<T> implements g {
        public final /* synthetic */ AuctionCountDownService a;

        public a(AuctionCountDownService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r24) {
            vg3.b r1 = (vg3.b) r24;
            Intrinsics.checkNotNullParameter(r1, "it");
            boolean r3 = false;
            if (r1.b != null) goto L13;
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r2 = r1.a;
            if (r2 != null) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r4 == false) goto L13;
            return;
        L7:
            if (r2.isEmpty() == true) goto L10;
            r4 = false;
        L13:
            AuctionCountDownService r5 = this.a;
            ((ArrayList) r5.k).clear();
            r5.b2().c();
            this.a.getClass();
            ActivityVO r6 = r1.b;
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r7 = r1.a;
            Long r8 = null;
            if (r7 == null) goto L23;
            Iterator<T> r9 = r7.iterator();
        L17:
            if (r9.hasNext() == false) goto L21;
            T r10 = r9.next();
            if ((((com.bytedance.android.ecom.arch.slice.adapter.b) r10) instanceof com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) == false) goto L17;
        L22:
            com.bytedance.android.ecom.arch.slice.adapter.b r11 = (com.bytedance.android.ecom.arch.slice.adapter.b) r10;
        L25:
            if ((r11 instanceof com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) == true) goto L27;
            r11 = null;
        L27:
            com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c r12 = (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) r11;
            if (r12 == null) goto L32;
            AnchorV4BaseInfoDisplay r13 = r12.b;
            if (r13 == null) goto L32;
            ActivityVO r14 = r13.getActivityInfo();
        L33:
            if (r6 != null) goto L35;
            r6 = r14;
        L35:
            AuctionCountDownService r15 = this.a;
            r15.getClass();
            if (r6 == null) goto L38;
            Long r16 = Long.valueOf(r6.getAuctionStatus());
        L40:
            if (r16 != null) goto L43;
        L44:
            if (r16 != null) goto L47;
        L48:
            Disposable r17 = r15.m;
            if (r17 != null) goto L51;
        L56:
            PageMeta r18 = (PageMeta) r15.O1().d().getData().b.a();
            if (r18 == null) goto L61;
            CommonMeta r19 = r18.getCommonMeta();
            if (r19 == null) goto L61;
            ActivityVO r20 = r19.getActivityInfo();
        L63:
            if (r20 != null) goto L65;
        L66:
            if (r20 != null) goto L68;
        L71:
            if (r20 != null) goto L73;
        L75:
            AuctionCountDownService r21 = this.a;
            if (r6 != null) goto L78;
            r21.getClass();
        L146:
            AuctionCountDownService r22 = this.a;
            d r23 = r22.n;
            if (r23 == null) goto L149;
            Long r25 = r23.a;
        L150:
            if (r25 != null) goto L153;
        L218:
            AuctionCountDownService r26 = this.a;
            if (r6 == null) goto L221;
            r8 = Long.valueOf(r6.getAuctionStatus());
        L221:
            r26.n = new d(r8);
            return;
        L153:
            if (r25.longValue() != 2) goto L218;
            if (r6 == null) goto L156;
            Long r27 = Long.valueOf(r6.getAuctionStatus());
        L158:
            if (r22.a2().getNativeParams().getFullMode() == false) goto L203;
            FragmentActivity r110 = r22.O1().getContainerAbility().mo2525getContext();
            if (r110 == null) goto L218;
            if (r27 != null) goto L165;
        L166:
            if (r27 != null) goto L169;
        L171:
            Intrinsics.checkNotNullParameter(r110, "context");
            if (r6 == null) goto L174;
            Long r28 = Long.valueOf(r6.getAuctionStatus());
        L175:
            Control r111 = r22.O1().d().getData().c();
            if (r111 != null) goto L178;
        L180:
            boolean r112 = false;
        L181:
            CommonMeta r113 = r22.O1().d().getData().a().a();
            if (r112 == false) goto L218;
            if (r28 != null) goto L186;
        L187:
            if (r28 == null) goto L218;
            if (r28.longValue() != 1) goto L218;
        L191:
            WeakReference r29 = new WeakReference(r110);
            if (r113 != null) goto L194;
        L196:
            r22.o = new f(r29, r3);
            if (r113 == null) goto L199;
            String r30 = r113.getProductId();
        L200:
            com.bytedance.android.ec.core.frontier.c r31 = new com.bytedance.android.ec.core.frontier.c("EcomGoodsDetail", r30);
            r22.p = r31;
            f r32 = r22.o;
            if (r32 == null) goto L218;
            WsConnectionManager.e.getClass();
            WsConnectionManager.a(r31, r32);
            goto L218
        L199:
            r30 = null;
            goto L200
        L194:
            if (r113.getFromLive() != true) goto L196;
            r3 = true;
            goto L196
        L186:
            if (r28.longValue() == 2) goto L191;
        L178:
            if (r111.getLongConnectionEnabled() != true) goto L180;
            r112 = true;
            goto L181
        L174:
            r28 = null;
            goto L175
        L169:
            if (r27.longValue() != 7) goto L171;
        L170:
            UIUtils.displayToast(r110, 2131896333);
            goto L171
        L165:
            if (r27.longValue() == 4) goto L170;
        L203:
            if (r27 != null) goto L206;
        L207:
            if (r27 != null) goto L210;
        L211:
            if (r27 == null) goto L218;
            if (r27.longValue() != 7) goto L218;
        L215:
            u r33 = (u) r22.N1(u.class);
            if (r33 == null) goto L218;
            r33.v0(new k0(false, false, 7));
            goto L218
        L210:
            if (r27.longValue() == 4) goto L215;
        L206:
            if (r27.longValue() == 3) goto L215;
        L156:
            r27 = null;
            goto L158
        L149:
            r25 = null;
            goto L150
        L78:
            com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.b r114 = (com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.b) r21.j.getValue();
            com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.a r34 = new com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.a(r21);
            ActivityTime r35 = r6.getActivityTime();
            if (r35 == null) goto L81;
            long r115 = r35.getCountdownInterval();
        L82:
            r114.getClass();
            Intrinsics.checkNotNullParameter(r34, "listener");
            ActivityTime r36 = r6.getActivityTime();
            if (r36 == null) goto L146;
            r114.a = r36.getServerTime() - (SystemClock.elapsedRealtime() / 1000);
            if (r36.getServerTime() <= 0) goto L107;
            if (r36.getPreStartTime() <= 0) goto L107;
            if (r36.getStartTime() <= 0) goto L107;
            if (r36.getEndTime() <= 0) goto L107;
            if (r36.getServerTime() < r36.getPreStartTime()) goto L146;
            if (r36.getServerTime() > r36.getEndTime()) goto L146;
            if (r36.getServerTime() < r36.getPreStartTime()) goto L102;
            if (r36.getServerTime() >= r36.getStartTime()) goto L102;
            r114.a(r36.getStartTime(), r34, r115);
        L102:
            if (r36.getServerTime() < r36.getStartTime()) goto L146;
            if (r36.getServerTime() >= r36.getEndTime()) goto L146;
            r114.a(r36.getEndTime(), r34, r115);
        L107:
            if (r36.getPreStartTime() > 0) goto L116;
            if (r36.getEndTime() <= 0) goto L116;
            if (r36.getStartTime() > 0) goto L116;
            if (r36.getServerTime() >= r36.getEndTime()) goto L146;
            r114.a(r36.getEndTime(), r34, r115);
        L116:
            if (r36.getPreStartTime() > 0) goto L123;
            if (r36.getEndTime() > 0) goto L123;
            if (r36.getStartTime() < r36.getServerTime()) goto L146;
            r114.a(r36.getStartTime(), r34, r115);
        L123:
            if (r36.getServerTime() <= 0) goto L136;
            if (r36.getStartTime() <= 0) goto L136;
            if (r36.getEndTime() <= 0) goto L136;
            if (r36.getPreStartTime() > 0) goto L136;
            if (r36.getStartTime() >= r36.getServerTime()) goto L146;
            if (r36.getServerTime() >= r36.getEndTime()) goto L146;
            r114.a(r36.getEndTime(), r34, r115);
        L136:
            if (r36.getPreStartTime() <= 0) goto L146;
            if (r36.getServerTime() <= 0) goto L146;
            if (r36.getStartTime() > 0) goto L146;
            if (r36.getEndTime() > 0) goto L146;
            if (r36.getPreStartTime() < r36.getServerTime()) goto L146;
            r114.a(r36.getPreStartTime(), r34, r115);
            goto L146
        L81:
            r115 = 1000;
            goto L82
        L73:
            if (r20.isGroupBuying() != true) goto L75;
            r15.c2(15);
            goto L75
        L68:
            if (r20.getAuctionStatus() != 2) goto L71;
        L70:
            r15.c2(3);
            goto L71
        L65:
            if (r20.getAuctionStatus() == 1) goto L70;
        L61:
            r20 = null;
            goto L63
        L51:
            if ((!r17.isDisposed()) == true) goto L54;
            r17 = null;
        L54:
            if (r17 == null) goto L56;
            r17.dispose();
            goto L56
        L47:
            if (r16.longValue() == 1) goto L56;
        L43:
            if (r16.longValue() == 2) goto L56;
        L38:
            r16 = null;
        L32:
            r14 = null;
            goto L33
        L21:
            r10 = null;
            goto L22
        L23:
            r11 = null;
            goto L25
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AuctionCountDownService a;

        public b(AuctionCountDownService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            x r7 = (x) this.a.N1(x.class);
            if (r7 == null) goto L6;
            x.a.a(r7, false, "activity_change", null, 28);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ECExceptionMonitor.f((Throwable) r2, "dynamic fetch error");
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{x.class, u.class});
    }

    public final ActivityCountDownTimer b2() {
        return (ActivityCountDownTimer) this.i.getValue();
    }

    public AuctionCountDownService() {
        this.i = LazyKt.lazy(AuctionCountDownService$activityTimer$2.INSTANCE);
        this.j = LazyKt.lazy(new AuctionCountDownService$tickManager$2(this));
        this.k = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        l1 r0 = b2().b;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, h.class, this, false, 12);
        O1().e().r().J1(h.class, this);
        e.a.a((e) O1().d().getData().E.getValue(), this, new a(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        com.bytedance.android.ec.core.frontier.c r0 = this.p;
        f r1 = this.o;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        WsConnectionManager.e.getClass();
        WsConnectionManager.c(r0, r1);
    L6:
        b2().c();
        Disposable r2 = this.m;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((!r2.isDisposed()) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L16;
        r2.dispose();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        l1 r0 = b2().b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // vg3.h
    public final void A(l1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "tickWatch");
        if (this.l == true) goto L6;
        ((ArrayList) this.k).add(r2);
        return;
    }

    public final void c2(long r8) {
        Disposable r0 = this.m;
        if (r0 != null) goto L5;
    L12:
        this.q = r8;
        int r1 = a1.a;
        TimeUnit r5 = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(r5, "unit");
        this.m = a1.a(r8, r8, r5, Schedulers.computation()).subscribe(new b(this), c.a);
        return;
    L5:
        if (r0.isDisposed() == true) goto L12;
        if (this.q > r8) goto L9;
        return;
    L9:
        Disposable r2 = this.m;
        if (r2 == null) goto L12;
        r2.dispose();
        goto L12
    }

    @Override // vg3.h
    public final void k0(l1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "tickWatch");
        if (((ArrayList) this.k).contains(r2) == false) goto L5;
        return;
    L5:
        if (this.l == true) goto L9;
        ((ArrayList) this.k).add(r2);
        return;
    }

    @Override // vg3.h
    public final void K0(long r9, long r11, j1 r13) {
        Intrinsics.checkNotNullParameter(r13, "listener");
        ActivityCountDownTimer r1 = b2();
        Lazy r0 = ActivityCountDownTimer.c;
        r1.a(r9, r11, r13, null);
    }
}
