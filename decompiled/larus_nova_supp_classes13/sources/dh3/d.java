package dh3;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.feed.event.u0;
import com.bytedance.android.shopping.sameproduct.event.SameTrackerProvider;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import jd3.u;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rd3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r3, rd3.a r4) {
        Integer r1 = null;
        u0 r0 = new u0(null);
        r0.v = "guess_you_like_product";
        if (r4 == null) goto L7;
        g r2 = r4.d();
        if (r2 == null) goto L7;
        String r5 = r2.a();
    L8:
        r0.F = r5;
        if (r4 == null) goto L11;
        String r6 = r4.d;
    L12:
        r0.S = r6;
        if (r4 == null) goto L15;
        Integer r7 = Integer.valueOf(r4.f);
    L16:
        r0.w = String.valueOf(r7);
        if (r4 == null) goto L25;
        Promotion r8 = r4.f();
        if (r8 == null) goto L25;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L25;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L25;
        String r11 = r10.getProductId();
    L26:
        r0.t = r11;
        if (r4 == null) goto L35;
        Promotion r12 = r4.f();
        if (r12 == null) goto L35;
        PromotionProductStruct r13 = r12.getPromotionInfo();
        if (r13 == null) goto L35;
        PromotionProductBaseStruct r14 = r13.getBaseInfo();
        if (r14 == null) goto L35;
        String r15 = r14.getPromotionId();
    L36:
        r0.c = r15;
        if (r4 == null) goto L45;
        Promotion r16 = r4.f();
        if (r16 == null) goto L45;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L45;
        PromotionProductBaseStruct r18 = r17.getBaseInfo();
        if (r18 == null) goto L45;
        r1 = r18.getPromotionSource();
    L45:
        r0.d = String.valueOf(r1);
        Unit r19 = Unit.INSTANCE;
        d(r0, r3);
        return;
    L35:
        r15 = null;
    L25:
        r11 = null;
        goto L26
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
    L7:
        r5 = null;
        goto L8
    }

    public static void c(com.bytedance.android.ec.core.event.a r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$postWithBase");
        SameTrackerProvider.a r0 = SameTrackerProvider.Companion;
        if (r3 != null) goto L5;
        e r4 = null;
    L11:
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.appendExtraParams(r4.a);
    L13:
        r2.post(null, null);
        return;
    L5:
        FragmentActivity r5 = d0.a.getActivity(r3);
        if (r5 == null) goto L16;
        Object r6 = ((SameTrackerProvider) ViewModelProviders.of(r5).get(SameTrackerProvider.class)).getTracker();
        if ((r6 instanceof e) == true) goto L10;
        r6 = null;
    L10:
        r4 = (e) r6;
        goto L11
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public static void d(com.bytedance.android.ec.core.event.a r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$postWithBaseParams");
        SameTrackerProvider.a r0 = SameTrackerProvider.Companion;
        if (r3 != null) goto L5;
        e r4 = null;
    L11:
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.appendBaseParams(r4.a);
    L13:
        r2.post(null, null);
        return;
    L5:
        FragmentActivity r5 = d0.a.getActivity(r3);
        if (r5 == null) goto L16;
        Object r6 = ((SameTrackerProvider) ViewModelProviders.of(r5).get(SameTrackerProvider.class)).getTracker();
        if ((r6 instanceof e) == true) goto L10;
        r6 = null;
    L10:
        r4 = (e) r6;
        goto L11
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public static void b(Context r3, SameProductViewModel r4, rd3.a r5) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        if (r5 == null) goto L12;
        Promotion r0 = r5.f();
        if (r0 == null) goto L12;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L12;
        PromotionProductBaseStruct r2 = r1.getBaseInfo();
        if (r2 == null) goto L12;
        String r6 = r2.getProductId();
        if (r6 == null) goto L12;
    L14:
        if (r4.getShowedProductIds().contains(r6) == false) goto L16;
        return;
    L16:
        r4.getShowedProductIds().add(r6);
        u r7 = new u();
        r7.o = "guess_you_like_product";
        Integer r8 = null;
        if (r5 == null) goto L21;
        g r9 = r5.d();
        if (r9 == null) goto L21;
        String r10 = r9.a();
    L22:
        r7.t = r10;
        if (r5 == null) goto L25;
        String r11 = r5.d;
    L26:
        r7.u = r11;
        if (r5 == null) goto L29;
        String r12 = String.valueOf(r5.f);
    L30:
        r7.p = r12;
        r7.l = r6;
        if (r5 == null) goto L39;
        Promotion r13 = r5.f();
        if (r13 == null) goto L39;
        PromotionProductStruct r14 = r13.getPromotionInfo();
        if (r14 == null) goto L39;
        PromotionProductBaseStruct r15 = r14.getBaseInfo();
        if (r15 == null) goto L39;
        String r16 = r15.getPromotionId();
    L40:
        r7.c = r16;
        if (r5 == null) goto L49;
        Promotion r17 = r5.f();
        if (r17 == null) goto L49;
        PromotionProductStruct r18 = r17.getPromotionInfo();
        if (r18 == null) goto L49;
        PromotionProductBaseStruct r19 = r18.getBaseInfo();
        if (r19 == null) goto L49;
        r8 = r19.getPromotionSource();
    L49:
        r7.d = String.valueOf(r8);
        Unit r20 = Unit.INSTANCE;
        d(r7, r3);
        return;
    L39:
        r16 = null;
        goto L40
    L29:
        r12 = null;
        goto L30
    L25:
        r11 = null;
    L21:
        r10 = null;
    L12:
        r6 = "";
        goto L14
    }
}
