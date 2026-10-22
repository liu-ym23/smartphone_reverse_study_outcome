package com.bytedance.android.shopping.deepfeed;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "routeType", "p2", "schema", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DeepFeedProductFragment$onCreate$3$2$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public DeepFeedProductFragment$onCreate$3$2$1(com.bytedance.android.shopping.deepfeed.event.a r8) {
        super(2, r8, com.bytedance.android.shopping.deepfeed.event.a.class, "markRouteStarted", "markRouteStarted(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "p1");
        Intrinsics.checkNotNullParameter(r25, "p2");
        com.bytedance.android.shopping.deepfeed.event.a r3 = (com.bytedance.android.shopping.deepfeed.event.a) ((CallableReference) this).receiver;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r24, "routeType");
        Intrinsics.checkNotNullParameter(r25, "schema");
        String r4 = null;
        r3.f = null;
        Object r5 = "";
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Uri r0 = UriProtector.parse(r25);     // Catch: Throwable -> L11
        String r7 = r0.getHost();     // Catch: Throwable -> L11
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        String r1 = r0.getPath();     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        Object r2 = Result.constructor-impl(r7.concat(r1));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r2) == true) goto L17;
        r5 = r2;
    L17:
        String r8 = (String) r5;
        if (StringsKt.equals(r24, "add_cart", true) == false) goto L21;
    L95:
        if (r4 == null) goto L118;
        com.bytedance.android.shopping.deepfeed.event.a.d r9 = r3.c;
        if (Intrinsics.areEqual(r4, "product_detail") == false) goto L105;
        if (r9 == null) goto L105;
        if (r9.m != true) goto L105;
        if (r3.f(r9) == false) goto L105;
        String r10 = "drag";
    L106:
        long r14 = r3.b + 1;
        r3.b = r14;
        String r16 = r4;
        String r21 = r10;
        r3.f = new com.bytedance.android.shopping.deepfeed.event.a.e(r14, r16, System.currentTimeMillis(), SystemClock.elapsedRealtime(), r21, r3.e);
        if (Intrinsics.areEqual(r4, "product_detail") == true) goto L109;
        return;
    L109:
        if (Intrinsics.areEqual(r10, "drag") == false) goto L116;
        if (r9 == null) goto L117;
        r3.b();
        r9.n = "enter_detail";
        return;
    L117:
        return;
    L116:
        return;
    L105:
        r10 = "click";
        goto L106
    L118:
        return;
    L21:
        if (StringsKt.equals(r24, "product_detail", true) == false) goto L24;
    L77:
        r4 = "product_detail";
        goto L95
    L24:
        if (StringsKt.equals(r24, "cart", true) == false) goto L27;
    L65:
        r4 = "cart";
        goto L95
    L27:
        if (StringsKt.equals(r24, "comment", true) == false) goto L30;
    L92:
        r4 = "comment";
        goto L95
    L30:
        if (StringsKt.equals(r24, "shop", true) == false) goto L33;
    L91:
        r4 = "shop";
        goto L95
    L33:
        if (StringsKt.equals(r24, "search", true) == false) goto L36;
    L85:
        r4 = "search";
        goto L95
    L36:
        if (StringsKt.equals(r24, "pause_search", true) == true) goto L85;
        if (StringsKt.equals(r24, "live", true) == false) goto L42;
    L90:
        r4 = "live";
        goto L95
    L42:
        if (StringsKt.equals(r24, "buy", true) == false) goto L45;
    L93:
        r4 = "order_submit";
        goto L95
    L45:
        if (StringsKt.equals(r24, "coupon_list", true) == false) goto L47;
    L94:
        r4 = "coupon_list";
        goto L95
    L47:
        if (StringsKt.equals(r24, "coupon_waist", true) == true) goto L94;
        if (StringsKt.contains(r8, "order_submit", true) == true) goto L93;
        if (StringsKt.contains(r8, "confirm_order", true) == true) goto L93;
        if (StringsKt.contains(r8, "coupon", true) == false) goto L62;
        if (StringsKt.contains(r8, "list", true) == true) goto L94;
        if (StringsKt.contains(r8, "receive", true) == true) goto L94;
    L62:
        if (StringsKt.contains(r8, "cart", true) == false) goto L67;
        if (StringsKt.contains(r8, "add_cart", true) == false) goto L65;
    L67:
        if (StringsKt.contains(r8, "comment", true) == true) goto L92;
        if (StringsKt.contains(r8, "evaluation", true) == true) goto L92;
        if (StringsKt.contains(r8, "product", true) == false) goto L79;
        if (StringsKt.contains(r8, "detail", true) == true) goto L77;
        if (StringsKt.contains(r8, "anchorv3", true) == true) goto L77;
    L79:
        if (StringsKt.contains(r8, "shop", true) == true) goto L91;
        if (StringsKt.contains(r8, "store", true) == true) goto L91;
        if (StringsKt.contains(r8, "search", true) == true) goto L85;
        if (StringsKt.contains(r8, "live", true) == true) goto L90;
        if (StringsKt.contains(r8, "room", true) == false) goto L95;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
