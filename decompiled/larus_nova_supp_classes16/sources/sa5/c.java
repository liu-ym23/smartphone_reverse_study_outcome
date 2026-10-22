package sa5;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements b {
    public final List<d> a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new ArrayList();
    }

    @Override // sa5.b
    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "backListener");
        ((ArrayList) this.a).remove(r2);
    }

    @Override // sa5.b
    public final void e(d r2) {
        Intrinsics.checkNotNullParameter(r2, "backListener");
        if (((ArrayList) this.a).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r2);
    }
}
