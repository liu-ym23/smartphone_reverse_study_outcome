package com.bytedance.ee.bear.list.delete;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ DeleteExecutor a;
    public final /* synthetic */ Function2<String, io.reactivex.disposables.a, Unit> b;
    public final /* synthetic */ io.reactivex.disposables.a c;
    public final /* synthetic */ Function1<Throwable, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(DeleteExecutor r1, Function2<? super String, ? super io.reactivex.disposables.a, Unit> r2, io.reactivex.disposables.a r3, Function1<? super Throwable, Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r5) {
        Result r6 = (Result) r5;
        tt5.a.h(this.a.b, " create task result, code=" + r6.code);
        DeleteTaskResult r0 = (DeleteTaskResult) r6.data;
        if (r0 == null) goto L5;
        String r1 = r0.getTaskId();
    L7:
        if (r6.code != 0) goto L16;
        if (r1 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L16;
        this.b.invoke(r1, this.c);
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r7 = false;
    L16:
        this.d.invoke(new Exception("failed,taskId:" + r1));
        return;
    L5:
        r1 = null;
        goto L7
    }
}
