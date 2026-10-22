package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.os.SystemClock;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.PromotionToutiao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements r34.e<Pair<? extends String, ? extends List<? extends DetailPromotion>>> {
    public final /* synthetic */ Function1<Pair<String, ? extends List<DetailPromotion>>, Unit> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1<String, Unit> c;

    public final void onFail(Exception r2) {
        Function1<String, Unit> r0 = this.c;
        if (r2 == null) goto L6;
        String r3 = r2.getMessage();
        if (r3 == null) goto L6;
    L7:
        r0.invoke(r3);
        return;
    L6:
        r3 = "error";
        goto L7
    }

    public final void onSuccess(Object r9) {
        Pair r10 = (Pair) r9;
        Intrinsics.checkNotNullParameter(r10, "data");
        List<DetailPromotion> r0 = (List) r10.getSecond();     // Catch: Throwable -> L35
        List<DetailPromotion> r1 = r0;     // Catch: Throwable -> L35
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        this.a.invoke(TuplesKt.to("", CollectionsKt.emptyList()));     // Catch: Throwable -> L35
        return;
    L12:
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L35
    L14:
        if (r3.hasNext() == false) goto L27;
        Object r4 = r3.next();     // Catch: Throwable -> L35
        DetailPromotion r6 = (DetailPromotion) r4;     // Catch: Throwable -> L35
        if (com.bytedance.awemeopen.apps.framework.utils.a0.b(r6) == true) goto L24;
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L35
        PromotionToutiao r7 = r6.getToutiao();     // Catch: Throwable -> L35
        if (r7 == null) goto L20;
        boolean r8 = Intrinsics.areEqual(r7.getNeedCheck(), Boolean.FALSE);     // Catch: Throwable -> L35
    L21:
        if (r8 == true) goto L24;
        boolean r11 = false;
    L25:
        if (r11 == false) goto L14;
    L28:
        if (r4 == null) goto L32;
        HashMap<String, List<DetailPromotion>> r5 = PromotionManageCenter.b;     // Catch: Throwable -> L35
        if (r5.get(this.b) == null) goto L33;
        r5.put(this.b, null);     // Catch: Throwable -> L35
    L33:
        this.a.invoke(TuplesKt.to(r10.getFirst(), r0));     // Catch: Throwable -> L35
        return;
    L32:
        PromotionManageCenter.b.put(this.b, r0);     // Catch: Throwable -> L35
        PromotionManageCenter.c.put(this.b, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L35
        goto L33
    L20:
        r8 = false;
    L24:
        r11 = true;
        goto L25
    L27:
        r4 = null;
        goto L28
    L6:
        if (r1.isEmpty() == true) goto L9;
        r2 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Pair<String, ? extends List<DetailPromotion>>, Unit> r1, String r2, Function1<? super String, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
