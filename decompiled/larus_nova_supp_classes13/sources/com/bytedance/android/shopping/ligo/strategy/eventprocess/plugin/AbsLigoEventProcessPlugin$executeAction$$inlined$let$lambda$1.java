package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/ligo/strategy/eventprocess/plugin/AbsLigoEventProcessPlugin$executeAction$1$1"}, k = 3, mv = {1, 4, 3})
final class AbsLigoEventProcessPlugin$executeAction$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b93.a $callback;
    final /* synthetic */ c93.a $decision$inlined;
    final /* synthetic */ Function0 $onError$inlined;
    final /* synthetic */ Function0 $onIgnored$inlined;
    final /* synthetic */ Function0 $onSuccess$inlined;
    final /* synthetic */ a this$0;

    public AbsLigoEventProcessPlugin$executeAction$$inlined$let$lambda$1(b93.a r1, a r2, Function0 r3, Function0 r4, Function0 r5, c93.a r6) {
        this.$onSuccess$inlined = r3;
        this.$onError$inlined = r4;
        this.$onIgnored$inlined = r5;
        this.$decision$inlined = r6;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m952invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m952invoke() {
        ExecutorService r0 = a.a;
        throw null;
    }
}
