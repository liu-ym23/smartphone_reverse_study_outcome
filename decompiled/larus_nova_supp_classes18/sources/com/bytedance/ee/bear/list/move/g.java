package com.bytedance.ee.bear.list.move;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public g(long r1, String r3, String r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final Object apply(Object r5) {
        Intrinsics.checkNotNullParameter((Long) r5, "it");
        if ((SystemClock.elapsedRealtime() - this.a) >= 30000) goto L7;
        NetService.f r6 = new NetService.f("/space/api/explorer/v3/task/");
        String r0 = this.b;
        String r1 = this.c;
        ((NetService.e) r6).c = 2;
        r6.b("task_id", r0);
        r6.b("task_type", r1);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f.c()).a(r6).toObservable();
    L7:
        return Observable.error(new TimeoutException("move task polling timeout, taskId=" + this.b));
    }
}
