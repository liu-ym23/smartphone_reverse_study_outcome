package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public j(k r1, String r2, String r3, String r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r12) {
        List r13 = (List) r12;
        Intrinsics.checkNotNullParameter(r13, "entities");
        k r0 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        String r4 = this.d;
        long r5 = this.e;
        r0.getClass();
        long r7 = System.currentTimeMillis();
        io.c r14 = (io.c) CollectionsKt.firstOrNull(r13);
        if (r14 != null) goto L10;
        ap3.g r15 = ap3.g.a;
        io.c r16 = new io.c(r2, r3, r4, r7);
        Intrinsics.checkNotNullParameter(r16, "item");
        WindowDatabase r1 = go.a.b.a();
        if (r1 != null) goto L7;
        Observable r17 = Observable.just(-1L);
    L8:
        r17.subscribeOn(Schedulers.io()).subscribe();
    L17:
        boolean r18 = true;
    L19:
        return Boolean.valueOf(r18);
    L7:
        r17 = Observable.create(new ap3.e(r1, r16));
        goto L8
    L10:
        if (r14.d <= (r7 - r5)) goto L12;
        r18 = false;
        goto L19
    L12:
        ap3.g r19 = ap3.g.a;
        io.c r110 = new io.c(r2, r3, r4, r7);
        Intrinsics.checkNotNullParameter(r110, "item");
        WindowDatabase r6 = go.a.b.a();
        if (r6 != null) goto L15;
        Observable r111 = Observable.just(-1);
    L16:
        r111.subscribeOn(Schedulers.io()).subscribe();
        goto L17
    L15:
        r111 = Observable.create(new ap3.f(r6, r110));
        goto L16
    }
}
