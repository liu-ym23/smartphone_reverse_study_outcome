package qe7;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f532700a;

    public e() {
        new CopyOnWriteArrayList();
        new AtomicBoolean(false);
        this.f532700a = new AtomicBoolean(true);
    }

    public final void a(boolean r100) {
        this.f532700a.set(r100);
    }
}
