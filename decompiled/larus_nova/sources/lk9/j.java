package lk9;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedDeque<CopyOnWriteArrayList<f>> f509632a;

    public final CopyOnWriteArrayList<f> a() {
        return this.f509632a.peek();
    }

    public j() {
        this.f509632a = new ConcurrentLinkedDeque();
    }
}
