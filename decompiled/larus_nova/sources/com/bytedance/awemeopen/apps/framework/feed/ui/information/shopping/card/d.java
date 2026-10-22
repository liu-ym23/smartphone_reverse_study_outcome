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

/* JADX INFO: loaded from: classes14.dex */
public final class d implements r34.e<Pair<? extends String, ? extends List<? extends DetailPromotion>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Pair<String, ? extends List<DetailPromotion>>, Unit> f196420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f196421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f196422c;

    @Override // r34.e
    public final void onFail(Exception r100) {
        Function1<String, Unit> r101 = this.f196422c;
        if (r100 == null) goto L6;
        String r102 = r100.getMessage();
        if (r102 == null) goto L6;
    L7:
        r101.invoke(r102);
        return;
    L6:
        r102 = "error";
        goto L7
    }

    @Override // r34.e
    public final void onSuccess(Pair<? extends String, ? extends List<? extends DetailPromotion>> r100) {
        Pair<? extends String, ? extends List<? extends DetailPromotion>> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        List<? extends DetailPromotion> r102 = r101.getSecond();     // Catch: Throwable -> L35
        List<? extends DetailPromotion> r103 = r102;     // Catch: Throwable -> L35
        if (r103 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        this.f196420a.invoke(TuplesKt.to("", CollectionsKt.emptyList()));     // Catch: Throwable -> L35
        return;
    L12:
        Iterator<T> r105 = r102.iterator();     // Catch: Throwable -> L35
    L14:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();     // Catch: Throwable -> L35
        DetailPromotion r107 = (DetailPromotion) r106;     // Catch: Throwable -> L35
        if (com.bytedance.awemeopen.apps.framework.utils.a0.b(r107) == true) goto L24;
        Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Throwable -> L35
        PromotionToutiao r108 = r107.getToutiao();     // Catch: Throwable -> L35
        if (r108 == null) goto L20;
        boolean r109 = Intrinsics.areEqual(r108.getNeedCheck(), Boolean.FALSE);     // Catch: Throwable -> L35
    L21:
        if (r109 == true) goto L24;
        boolean r110 = false;
    L25:
        if (r110 == false) goto L14;
    L28:
        if (r106 == null) goto L32;
        HashMap<String, List<DetailPromotion>> r111 = PromotionManageCenter.f196363b;     // Catch: Throwable -> L35
        if (r111.get(this.f196421b) == null) goto L33;
        r111.put(this.f196421b, null);     // Catch: Throwable -> L35
    L33:
        this.f196420a.invoke(TuplesKt.to(r101.getFirst(), r102));     // Catch: Throwable -> L35
        return;
    L32:
        PromotionManageCenter.f196363b.put(this.f196421b, (List<DetailPromotion>) r102);     // Catch: Throwable -> L35
        PromotionManageCenter.f196364c.put(this.f196421b, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L35
        goto L33
    L20:
        r109 = false;
    L24:
        r110 = true;
        goto L25
    L27:
        r106 = null;
        goto L28
    L6:
        if (r103.isEmpty() == true) goto L9;
        r104 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Pair<String, ? extends List<DetailPromotion>>, Unit> r100, String r101, Function1<? super String, Unit> r102) {
        this.f196420a = r100;
        this.f196421b = r101;
        this.f196422c = r102;
    }
}
