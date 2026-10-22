package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements cf.i {
    public final /* synthetic */ RelatedCardWidgetController a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((ECCurrentPromotion) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.invoke(null);
            ECExceptionMonitor.e((Throwable) r3);
        }
    }

    public s(RelatedCardWidgetController r1) {
        this.a = r1;
    }

    public final void a(String r9, boolean r10, Pair<Long, Long> r11, com.bytedance.android.ec.model.response.s r12, String r13, Map<String, String> r14, Function1<? super ECCurrentPromotion, Unit> r15) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        RelatedCardWidgetController r16 = this.a;
        RoomContextController r17 = r16.r;
        ml.b r18 = r16.m;
        String r19 = null;
        if (r18 == null) goto L5;
        String r20 = r18.roomId();
    L6:
        String r5 = ControllerExtensionsKt.c(r17, r20).A().t.M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD);
        ml.b r21 = this.a.m;
        if (r21 == null) goto L9;
        String r0 = r21.roomId();
    L10:
        String r1 = this.a.r.D();
        ml.b r22 = this.a.m;
        if (r22 == null) goto L13;
        String r2 = r22.c();
    L14:
        ml.b r23 = this.a.m;
        if (r23 == null) goto L17;
        String r3 = r23.d();
    L18:
        ml.b r24 = this.a.m;
        if ((r24 instanceof com.bytedance.android.livesdk.livecommerce.room.model.e) == false) goto L21;
        jf.b.h r110 = jf.b.h.b;
        String r4 = ((com.bytedance.android.livesdk.livecommerce.room.model.e) r24).e("live_popup_related");
    L22:
        ml.b r25 = this.a.m;
        if ((r25 instanceof com.bytedance.android.livesdk.livecommerce.room.model.e) == false) goto L25;
        r19 = ((com.bytedance.android.livesdk.livecommerce.room.model.e) r25).getGroupId();
    L25:
        bk2.c.a(bg4.b.b(vi2.h.m(r0, r1, r2, r3, r4, r5, false, r19)).subscribe(new a(r15), new b(r15)), (bk2.d) this.a.c.getValue());
        return;
    L21:
        r4 = null;
        goto L22
    L17:
        r3 = null;
        goto L18
    L13:
        r2 = null;
        goto L14
    L9:
        r0 = null;
        goto L10
    L5:
        r20 = null;
        goto L6
    }
}
