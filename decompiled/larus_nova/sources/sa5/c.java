package sa5;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f541166a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f541166a = new ArrayList();
    }

    @Override // sa5.b
    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "backListener");
        ((ArrayList) this.f541166a).remove(r100);
    }

    @Override // sa5.b
    public final void e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "backListener");
        if (((ArrayList) this.f541166a).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f541166a).add(r100);
    }
}
