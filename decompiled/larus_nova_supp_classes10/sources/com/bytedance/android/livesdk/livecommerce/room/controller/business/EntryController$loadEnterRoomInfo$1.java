package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import com.bytedance.android.livesdk.livecommerce.room.coupon.LocalEnterRoomInfoState;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import vi2.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class EntryController$loadEnterRoomInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isEcom;
    final /* synthetic */ EntryController this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ EntryController$loadEnterRoomInfo$1 a;

        public a(EntryController$loadEnterRoomInfo$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.ec.model.response.r r6 = (com.bytedance.android.ec.model.response.r) r5;
            this.a.this$0.A().m.f = r6.d();
            PromotionListController r0 = this.a.this$0.A().r;
            n1 r1 = r6.d();
            if (r1 == null) goto L9;
            List r2 = r1.a();
            if (r2 == null) goto L9;
            boolean r3 = true;
            if ((!r2.isEmpty()) != true) goto L9;
        L10:
            r0.I = Boolean.valueOf(r3);
            this.a.this$0.l0(r6.e(), LiveRoomRedirectPriority.ENTER_ROOM);
            Lazy r4 = EnterRequestHandler.a;
            EnterRequestHandler.i(r6, this.a.this$0.C());
            String r7 = r6.c();
            if (r7 == null) goto L13;
            this.a.this$0.M().i(r7, IRelatedInfoManager$FromSource.ENTER_ROOM_API);
        L13:
            List r8 = r6.getActions();
            if (r8 == null) goto L19;
            Iterator<T> r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L21;
            final j0 r10 = (j0) r9.next();
            UtilityKotlinExtentionsKt.j(0, new EntryController$loadEnterRoomInfo$1$1$$special$$inlined$forEach$lambda$1(r10, this), 3);
            goto L17
        L21:
            return;
        L19:
            return;
        L9:
            r3 = false;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public EntryController$loadEnterRoomInfo$1(EntryController r1, boolean r2) {
        this.this$0 = r1;
        this.$isEcom = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1095invoke() {
        if (this.this$0.v() == false) goto L10;
        LiveRoomParams r0 = this.this$0.l();
        if (r0 == null) goto L9;
        JSONObject r1 = r0.getEntranceInfo();
        if (r1 == null) goto L9;
        String r2 = r1.toString();
    L11:
        String r10 = r2;
    L12:
        Lazy r3 = EnterRequestHandler.a;
        LocalEnterRoomInfoState r4 = EnterRequestHandler.b;
        if (r4 == null) goto L57;
    L18:
        EnterRequestHandler.b = r4;
        JSONObject r5 = EnterRequestHandler.h();
        Map<String, String> r6 = this.this$0.p();
        String r15 = this.this$0.B();
        String r14 = this.this$0.D();
        String r7 = this.this$0.y();
        String r9 = this.this$0.z();
        boolean r8 = this.this$0.q().isLinkmic();
        if (r5 == null) goto L24;
        String r11 = r5.toString();
        if (r11 == null) goto L24;
        String r12 = r11;
    L25:
        String r13 = r6.get("enter_room_extra");
        boolean r16 = this.$isEcom;
        String r17 = this.this$0.M().f(IRelatedInfoManager$Scene.ENTER_ROOM_API);
        LiveRoomParams r18 = this.this$0.l();
        if (r18 == null) goto L28;
        String r19 = r18.getGroupId();
    L29:
        String r110 = r6.get("preview_button_info");
        this.this$0.getClass();
        List<String> r20 = EComABUtils.getCouponPassthroughParamsKeyConfig();
        if (r6.isEmpty() == false) goto L32;
    L54:
        String r111 = null;
    L55:
        String r21 = vi2.h.a;
        bk2.c.a(vi2.h.e(r15, r14, si2.g.P, new l0(r15, r14, r7, r8, r16, r9, r10, r12, r13, r17, r19, r110, r111)).subscribe(new a(this), b.a), (bk2.d) this.this$0.o().getDisposableContext().getValue());
        return;
    L32:
        if (r20.isEmpty() == true) goto L54;
        JSONObject r22 = new JSONObject();
        Iterator r23 = r20.iterator();
    L36:
        if (r23.hasNext() == false) goto L52;
        String r24 = (String) r23.next();
        if (r24 != null) goto L40;
    L43:
        boolean r112 = true;
    L44:
        if (r112 == false) goto L46;
        Iterator r113 = r23;
    L50:
        r23 = r113;
        goto L36
    L46:
        r113 = r23;
        String r25 = r6.get(r24);
        if (r25 == null) goto L50;
        r22.put(r24, r25);
        goto L50
    L40:
        if (r24.length() == 0) goto L43;
        r112 = false;
        goto L44
    L52:
        if (r22.length() <= 0) goto L54;
        r111 = r22.toString();
        goto L55
    L28:
        r19 = null;
    L24:
        r12 = "";
        goto L25
    L57:
        r4 = (LocalEnterRoomInfoState) u0.b(com.bytedance.android.ec.sdk.helper.q.a.getString((String) EnterRequestHandler.a.getValue(), ""), LocalEnterRoomInfoState.class);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r4 = null;
    L9:
        r10 = null;
        goto L12
    L10:
        ECEventUtilsV2.b.getClass();
        r2 = ECEventUtilsV2.a(null);
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1095invoke();
        return Unit.INSTANCE;
    }
}
