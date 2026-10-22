package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbortSignal$Companion$rts_timeout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $controller;

    public AbortSignal$Companion$rts_timeout$1(a r1) {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1418invoke() {
        new RuntimeException("TimeoutError");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1418invoke();
        return Unit.INSTANCE;
    }
}
