package zl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantLock f572753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedDeque<Integer> f572754b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, b> f572755c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentLinkedDeque<Integer> f572756d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, b> f572757e = null;

    static {
        f572753a = new ReentrantLock();
        f572754b = new ConcurrentLinkedDeque();
        f572755c = new ConcurrentHashMap();
        f572756d = new ConcurrentLinkedDeque();
        f572757e = new ConcurrentHashMap();
    }
}
