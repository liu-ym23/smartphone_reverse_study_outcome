package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LynxGlobalEventEmitter$on$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ Function1<Map<String, Object>, Unit> $listener;
    final /* synthetic */ m0 this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxGlobalEventEmitter$on$1(m0 r100, String r101, Function1<? super Map<String, Object>, Unit> r102) {
        this.this$0 = r100;
        this.$eventName = r101;
        this.$listener = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        EventEmitter r100 = this.this$0.f405549a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        r100 = null;
    L5:
        r100.h(this.$eventName, this.$listener);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
