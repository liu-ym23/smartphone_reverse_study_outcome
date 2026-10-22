package lb6;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f508351a;

    public c() {
        this.f508351a = new CopyOnWriteArrayList();
    }

    public final void n(d r100) {
        Intrinsics.checkNotNullParameter(r100, "linkManager");
        r100.attach();
        this.f508351a.add(r100);
    }
}
