package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "T", "isCancelled", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncExec$workloadWrapper$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ boolean $isInMainThread;
    final /* synthetic */ Function0<Object> $workload;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncExec$workloadWrapper$1(o r1, Function0<Object> r2, boolean r3, Function1<Object, Unit> r4) {
        this.this$0 = r1;
        this.$workload = r2;
        this.$isInMainThread = r3;
        this.$callback = r4;
        super(1);
    }

    public final Object invoke(boolean r5) {
        if (r5 == false) goto L5;
        return null;
    L5:
        this.this$0.b.a();
        final Object r6 = this.$workload.invoke();
        this.this$0.b.b();
        if (this.$isInMainThread == false) goto L8;
        int r1 = r.a;
        final Function1<Object, Unit> r2 = this.$callback;
        Function1<Boolean, Object> r3 = new AnonymousClass1(r2, r6);
        Intrinsics.checkNotNullParameter(r3, "workload");
        r.a.a(r3, i.c, 0.0d);
    L9:
        return null;
    L8:
        this.$callback.invoke(r6);
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Boolean) r1).booleanValue());
    }
}
