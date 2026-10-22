package d68;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f467212a = null;

    static {
        f467212a = LazyKt.lazy(new b());
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = c68.b.f22600a;
        c68.b.d("FlowTtsMobHelper", "FlowTtsMobHelper addTtsToAudioPlayStepStart msgId=".concat(r100));
        ((List) f467212a.getValue()).add(r100);
    }
}
