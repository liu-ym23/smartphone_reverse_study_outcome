package z2;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class t implements i3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f569763a = null;

    public static final class a {
    }

    public t() {
    }

    @Override // i3.b
    public final int getPriority() {
        return 100;
    }

    @Override // i3.b
    public final void reset() {
    }

    static {
        f569763a = SetsKt.setOf(new String[]{"doubao.navigateTo", "doubao.navigateBack", "doubao.redirectTo", "doubao.reLaunch", "doubao.postMessage"});
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "invocation");
        if (f569763a.contains(r100.f488076a) == false) goto L6;
        return null;
    L6:
        return new AIBridgeMethod.Error(-1, "method " + r100.f488076a + " is not allowed in WebView context", null, f3.a.f475271l);
    }
}
