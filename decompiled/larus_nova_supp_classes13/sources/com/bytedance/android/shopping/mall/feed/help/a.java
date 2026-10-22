package com.bytedance.android.shopping.mall.feed.help;

import android.os.Build;
import android.os.Debug;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.ss.android.common.lib.AppLogNewUtils;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final int e = 0;
    public int a;
    public int b;
    public final ECHybridListEngine c;
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.a$a, reason: collision with other inner class name */
    public static final class C0085a {
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Result<? extends Unit> call() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            if (Build.VERSION.SDK_INT <= 23) goto L12;
            long r1 = Runtime.getRuntime().totalMemory();     // Catch: Throwable -> L14
            long r2 = Runtime.getRuntime().maxMemory();     // Catch: Throwable -> L14
            double r4 = r1 / r2;     // Catch: Throwable -> L14
            ECHybridListEngine r6 = this.a.c;     // Catch: Throwable -> L14
            int r7 = 0;
            if (r6 == null) goto L7;
            int r8 = r6.i();     // Catch: Throwable -> L14
        L8:
            Integer r9 = StringsKt.toIntOrNull(Debug.getRuntimeStat("art.gc.gc-count"));     // Catch: Throwable -> L14
            if (r9 == null) goto L11;
            r7 = r9.intValue();     // Catch: Throwable -> L14
        L11:
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L14
            r10.putOpt("used_memory", Long.valueOf(r1));     // Catch: Throwable -> L14
            r10.putOpt("max_memory", Long.valueOf(r2));     // Catch: Throwable -> L14
            r10.putOpt("used_percent", Double.valueOf(r4));     // Catch: Throwable -> L14
            r10.putOpt("item_count", Integer.valueOf(r8));     // Catch: Throwable -> L14
            r10.putOpt("gc_count", Integer.valueOf(r7 - this.a.a));     // Catch: Throwable -> L14
            r10.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, this.a.d);     // Catch: Throwable -> L14
            AppLogNewUtils.onEventV3("ec_mall_memory_monitor", r10);     // Catch: Throwable -> L14
            goto L12
        L7:
            r8 = 0;
        L12:
            Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L17:
            return Result.box-impl(r3);
        L14:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        int r0 = s93.c.a;
        Object r1 = 50;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_memory_check_item_interval", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_memory_check_item_interval, Value: " + r1);
        e = ((Number) r1).intValue();
    }

    public final void a() {
        Single.fromCallable(new b(this)).subscribeOn(Schedulers.single()).subscribe();
    }

    public a(ECHybridListEngine r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        this.c = r2;
        this.d = r3;
    }
}
