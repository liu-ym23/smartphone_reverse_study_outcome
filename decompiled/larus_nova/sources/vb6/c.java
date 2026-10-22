package vb6;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f554065a;

    public c() {
        this.f554065a = new CopyOnWriteArrayList();
    }

    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "linkManager");
        r100.attach();
        this.f554065a.add(r100);
    }
}
