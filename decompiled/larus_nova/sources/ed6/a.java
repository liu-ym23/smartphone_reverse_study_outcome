package ed6;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue<T> f472215a;

    public a(Comparator r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        this.f472215a = new PriorityBlockingQueue(10, r100);
    }
}
