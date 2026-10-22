package kotlinx.coroutines.debug.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;", "kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements Function1<c.a<?>, DebuggerInfo> {
    public DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DebuggerInfo invoke2(c.a<?> r100) {
        c.f504729a.getClass();
        r100.getClass();
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, kotlinx.coroutines.debug.internal.DebuggerInfo] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DebuggerInfo invoke(c.a<?> r100) {
        return invoke2(r100);
    }
}
