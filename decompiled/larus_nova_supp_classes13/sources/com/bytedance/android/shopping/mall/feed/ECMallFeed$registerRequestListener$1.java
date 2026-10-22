package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.bytedance.android.shopping.mall.feed.help.ECMallGulRefresh;
import com.bytedance.common.utility.Logger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed$registerRequestListener$1 implements com.bytedance.android.shopping.mall.opt.e {
    public final /* synthetic */ ECMallFeed a;

    public ECMallFeed$registerRequestListener$1(ECMallFeed r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.mall.opt.e
    public final void a(com.bytedance.android.shopping.mall.opt.d r5, JSONObject r6, com.bytedance.android.shopping.mall.opt.g r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "pitayaOrigin");
        Logger.i("gul_prefetch", "on pitaya handle end " + r5);
        JSONObject r0 = r6.optJSONObject("actions");
        if (r5.a <= 0) goto L24;
        Lazy r8 = ECMallGulPrefetch.h;
        Integer r9 = ECMallGulPrefetch.Companion.a().d();
        if (r9 != null) goto L8;
    L22:
        ECMallFeed.g0(this.a, new ECMallFeed$registerRequestListener$1$onPitayaHandleEnd$1(this));
        return;
    L8:
        if (r9.intValue() != 1) goto L22;
        ECMallGulPrefetch r10 = this.a.v();
        if (r10 == null) goto L53;
        Object r11 = r10.a;
        monitor-enter(r11);
        Logger.i("gul_prefetch", " clear and save cache info ");     // Catch: Throwable -> L19
        r93.b r12 = r10.b();     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        r10.f = r12;     // Catch: Throwable -> L19
    L16:
        r10.g = "init";     // Catch: Throwable -> L19
        r10.b = null;     // Catch: Throwable -> L19
        r10.e = null;     // Catch: Throwable -> L19
        r10.d = null;     // Catch: Throwable -> L19
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r11);
        return;
    L19:
        th = move-exception;
        throw th;
    L53:
        return;
    L24:
        if (r5.b == true) goto L26;
        return;
    L26:
        if (this.a.T0 == false) goto L31;
        if (r7 == null) goto L29;
        r7.a(false, 1, 1001);
    L29:
        this.a.M0 = null;
        return;
    L31:
        if (r0 == null) goto L33;
        int r14 = r0.length();
    L34:
        if (r14 == 0) goto L44;
        Integer r15 = this.a.R;
        if (r15 != null) goto L38;
    L40:
        this.a.M0 = null;
        Lazy r16 = ECMallGulRefresh.g;
        if (Intrinsics.areEqual(ECMallGulRefresh.Companion.a().b(), Boolean.TRUE) == false) goto L43;
        this.a.j1 = r6;
    L43:
        ECMallFeed r17 = this.a;
        r17.m(r17.j1, r17.r(ECMallGulRefresh.Companion.a().c()), false, r7);
        return;
    L38:
        if (r15.intValue() == 0) goto L40;
    L44:
        if (r7 == null) goto L46;
        r7.a(false, 1, 1003);
    L46:
        Function0<Unit> r18 = this.a.M0;
        if (r18 == null) goto L49;
        Unit r19 = (Unit) r18.invoke();
    L49:
        this.a.M0 = null;
        return;
    L33:
        r14 = 0;
        goto L34
    }
}
