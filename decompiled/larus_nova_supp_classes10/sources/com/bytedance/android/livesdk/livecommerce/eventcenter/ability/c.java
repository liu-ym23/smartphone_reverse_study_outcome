package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "add_cart", description = "自动加购", service = {"LiveBase"})
public final class c extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.b> {
    public static final /* synthetic */ int b = 0;
    public com.bytedance.android.livesdk.livecommerce.eventcenter.ability.a a;

    public static final class a {
        public a() {
        }

        public static void a(Context r36, int r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, boolean r47, boolean r48, String r49, String r50, boolean r51, String r52, com.bytedance.android.btm.api.model.l r53, String r54, Integer r55, cf.a r56) {
            int r0 = c.b;
            Intrinsics.checkNotNullParameter(r36, "context");
            Intrinsics.checkNotNullParameter(r38, "originType");
            Intrinsics.checkNotNullParameter(r39, "originId");
            Intrinsics.checkNotNullParameter(r40, "promotionId");
            Intrinsics.checkNotNullParameter(r41, "productId");
            Intrinsics.checkNotNullParameter(r42, "authorId");
            Intrinsics.checkNotNullParameter(r44, "roomId");
            Intrinsics.checkNotNullParameter(r45, "shopId");
            Intrinsics.checkNotNullParameter(r46, "trackExtra");
            int r1 = ECSdk.a;
            IECCommonService r2 = (IECCommonService) ECSdk.a(IECCommonService.class);
            if (r2 == null) goto L5;
            r2.addCartDirectly(r36, 201, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, null, null, r48, r49, r50, r51, r52, r53, false, null, r54, r55, null, null, null, null, r56, null, null, null, null);
        L5:
            if (r50 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == false) goto L14;
            ECExceptionMonitor.c("直播间加购缺少combo_id");
            return;
        L14:
            return;
        L7:
            if (r50.length() == 0) goto L10;
            r3 = false;
            goto L11
        }
    }

    static {
        new a();
    }

    public c() {
    }

    public static final com.bytedance.android.livesdk.livecommerce.eventcenter.ability.a c(c r2, sl.b r3) {
        r2.getClass();
        if (r3 == null) goto L7;
        Map r4 = r3.a();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("source_page");
    L8:
        jf.e.c r1 = jf.e.c.b;
        if (Intrinsics.areEqual(r5, String.valueOf(1)) == true) goto L13;
        jf.e.f r6 = jf.e.f.b;
        Intrinsics.areEqual(r5, String.valueOf(5));
        return null;
    L13:
        return r2.a;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(final Context r12, sl.b r13, Object r14, final il2.a r15, final com.bytedance.android.livesdk.livecommerce.ability.e r16) {
        final sl.b r8 = r13;
        dm.a.a("Atomic_AddCart").i("execute with " + r8);
        if (r15 == null) goto L5;
        il2.a.C0145a.a(r15, "add_cart_atomic", MapsKt.mapOf(TuplesKt.to("params", r8)), false, null, null, null, 60);
    L5:
        ql.a r9 = null;
        if (r8 == null) goto L8;
        ql.a r0 = r8.d();
    L10:
        if (r0 != null) goto L15;
        if (r15 == null) goto L15;
        il2.a r1 = il2.a.C0145a.a(r15, "add_cart_atomic", null, false, "promotion_model_null", null, null, 48);
        if (r1 == null) goto L15;
        ((LiveActionTracker) r1).e(false);
    L15:
        if (r8 != null) goto L17;
    L19:
        final int r3 = 0;
    L20:
        if (r8 == null) goto L22;
        r9 = r8.d();
    L22:
        UtilityKotlinExtentionsKt.f(r9, r12, new LiveAddCartAbility$execute$1(this, r8, r3, r12, r16, r15));
        return;
    L17:
        if (r8.c() != true) goto L19;
        r3 = -1;
        goto L20
    L8:
        r0 = null;
        goto L10
    }
}
