package io.ktor.util.debug;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.management.ManagementFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntellijIdeaDebugDetector$isDebuggerConnected$2 extends Lambda implements Function0<Boolean> {
    public static final IntellijIdeaDebugDetector$isDebuggerConnected$2 INSTANCE = null;

    static {
        INSTANCE = new IntellijIdeaDebugDetector$isDebuggerConnected$2();
    }

    public IntellijIdeaDebugDetector$isDebuggerConnected$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean r100 = false;
        r100 = StringsKt.contains$default(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false, 2, null);     // Catch: Throwable -> L6
    L5:
        return Boolean.valueOf(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
