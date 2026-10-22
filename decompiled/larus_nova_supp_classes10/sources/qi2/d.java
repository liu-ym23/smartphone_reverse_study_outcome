package qi2;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.refactor.EntranceShowStatusByRoomState;
import com.bytedance.android.livesdk.livecommerce.event.refactor.ReportWhenEnter;
import com.bytedance.android.livesdk.livecommerce.event.refactor.RequestLivePromotions;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.j;
import kh2.f;
import kh2.g;
import kh2.h;
import kh2.i;
import kotlin.jvm.internal.Intrinsics;
import sg2.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends a {
    public final RealRoomController a;
    public zk.a b;
    public u c;
    public com.bytedance.android.ec.adapter.api.state.a d;
    public EntryController e;

    public d(RealRoomController r1) {
        this.a = r1;
    }

    @Override // qi2.a
    public final boolean b(ee.b r5) {
        if (this.d != null) goto L5;
    L12:
        return false;
    L5:
        if (r5.getMsgType() != 10) goto L9;
        this.e.G = true;
        zk.a r0 = this.b;
        com.bytedance.android.ec.adapter.api.state.a r1 = this.d;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e.getClass();
        d(r0, com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.a(r1), r5);
        return true;
    L9:
        if (r5.getMsgType() != 11) goto L12;
        this.e.G = false;
        d(this.b, false, r5);
        return true;
    }

    @Override // qi2.a
    public final void c(j r2) {
        this.b = r2.h();
        this.c = r2.g();
        this.d = r2.e();
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        this.e = this.a.t;
        return;
    L6:
        if (r2.f().v() == false) goto L8;
        this.e = r2.f();
        return;
    L8:
        this.e = EntryController.a.b(r2.roomId(), r2.roomId());
    }

    public final void d(zk.a r11, boolean r12, ee.b r13) {
        int r0 = r13.getMsgType();
        u r1 = this.c;
        if (r1 == null) goto L5;
        r1.onPromotionsChangedWhenReceiveMsg(r12);
    L5:
        ECLiveEntranceMonitor.trace("receive msg isShowCart=" + r12, "ShoppingBagInterceptor", false);
        com.bytedance.android.ec.adapter.api.state.a r2 = this.d;
        if (r2.c == true) goto L27;
        f r3 = new f(r2);
        int r4 = kh2.b.b;
        kh2.b.a r5 = kh2.b.C0149b.a(r3);
        kh2.a r6 = new kh2.a(this.d);
        Intrinsics.checkNotNullParameter(r6, "value");
        r5.a = r6;
        kh2.d r7 = new kh2.d(this.d);
        Intrinsics.checkNotNullParameter(r7, "value");
        r5.b = r7;
        r5.b(ReportWhenEnter.NO);
        kh2.j r8 = new kh2.j(this.d);
        Intrinsics.checkNotNullParameter(r8, "value");
        r5.f = r8;
        i r9 = new i(this.d);
        Intrinsics.checkNotNullParameter(r9, "value");
        r5.g = r9;
        r5.c(RequestLivePromotions.NO);
        com.bytedance.android.livesdk.livecommerce.message.a r10 = null;
        g r14 = new g(null);
        Intrinsics.checkNotNullParameter(r14, "value");
        r5.i = r14;
        h r15 = new h(null);
        Intrinsics.checkNotNullParameter(r15, "value");
        r5.j = r15;
        if (r12 == false) goto L10;
        EntranceShowStatusByRoomState r16 = EntranceShowStatusByRoomState.YES;
    L11:
        r5.a(r16);
        kh2.c r17 = new kh2.c("msgType:" + r0);
        Intrinsics.checkNotNullParameter(r17, "value");
        r5.d = r17;
        new kh2.b(r5).a();
        int r18 = com.bytedance.android.livesdk.livecommerce.message.a.i;
        TraceTimeMetric r19 = r13.d();
        if (r19 == null) goto L20;
        long r20 = r19.opTimestamp;
        if (r20 <= 0) goto L20;
        long r21 = r19.msgSendTimestamp;
        if (r21 <= 0) goto L20;
        r10 = new com.bytedance.android.livesdk.livecommerce.message.a();
        r10.b = r20;
        r10.c = r19.producerDuration;
        r10.d = r19.consumerDuration;
        r10.e = r21;
        r10.g = String.valueOf(r13.getMsgType());
    L20:
        if (r10 == null) goto L22;
        r10.b("shop_entrance");
    L22:
        if (r11 == null) goto L24;
        r11.h(new si2.d(false, r12));
    L24:
        if (r10 == null) goto L28;
        r10.a();
        return;
    L28:
        return;
    L10:
        r16 = EntranceShowStatusByRoomState.NO;
        goto L11
    }
}
