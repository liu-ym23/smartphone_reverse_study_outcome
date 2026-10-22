package com.bytedance.locallife.live.goodsshelves.helper;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Map<String, String>> f259631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f259632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f259633c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends Map<String, String>> r100, Function1<? super Boolean, Unit> r101, Map<String, String> r102) {
        this.f259631a = r100;
        this.f259632b = r101;
        this.f259633c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        List<Map<String, String>> r102 = this.f259631a;
        if (r102 == null) goto L8;
        Map<String, String> r103 = this.f259633c;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map r105 = (Map) r104.next();
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("collect_status", "fail");
        r106.put("collect_status_text", "很抱歉优惠券已抢光");
        r106.putAll(r105);
        AutoCollectCouponHelper.a(r106, r103);
    L8:
        this.f259632b.invoke(Boolean.FALSE);
    }
}
