package com.bytedance.android.shopping.mall.feed.opt;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.google.gson.Gson;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements ECHybridNetworkTask.a {
    public final /* synthetic */ SaasHomepagePrefetch a;

    public final void d(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
    }

    public d(SaasHomepagePrefetch r1) {
        this.a = r1;
    }

    public final void c(String r3, String r4, ECHybridNetworkVO r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "requestVO");
        Object r7 = this.a.b;
        monitor-enter(r7);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r3, "homepage") == true) goto L8;
    L23:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r7);
        return;
    L8:
        if (r4.length() <= 0) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L23;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        Gson r11 = p.a;     // Catch: Throwable -> L20
        HomePageDTO r12 = (HomePageDTO) p.a(r4, HomePageDTO.class);     // Catch: Throwable -> L20
        if (r12 == null) goto L18;
        SaasHomepagePrefetch r0 = this.a;     // Catch: Throwable -> L20
        Function2<? super String, ? super HomePageDTO, Unit> r1 = r0.e;     // Catch: Throwable -> L20
        if (r1 == null) goto L17;
        Unit r13 = (Unit) r1.invoke(r4, r12);     // Catch: Throwable -> L20
        SaasHomepagePrefetch r14 = this.a;     // Catch: Throwable -> L20
        r14.e = null;     // Catch: Throwable -> L20
        r14.f = null;     // Catch: Throwable -> L20
        goto L18
    L17:
        r0.c = new Pair(r4, r12);     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.a.d = false;     // Catch: Throwable -> L26
        goto L23
    L20:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L22
    L10:
        r9 = false;
        goto L11
    }

    public final void e(String r1, Throwable r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "t");
        Object r5 = this.a.b;
        monitor-enter(r5);
        SaasHomepagePrefetch r6 = this.a;     // Catch: Throwable -> L11
        Function0<Unit> r7 = r6.f;     // Catch: Throwable -> L11
        if (r7 == null) goto L8;
        if (r7 == null) goto L9;
        Unit r8 = (Unit) r7.invoke();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r5);
        return;
    L8:
        r6.d = false;     // Catch: Throwable -> L11
        this.a.c = null;     // Catch: Throwable -> L11
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        ECHybridNetworkTask.a.a.b(r1, r2, r3);
    }
}
