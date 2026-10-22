package fhc;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lock f477212f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f477213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<d> f477214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d[] f477215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f477216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f477217e;

    static {
        f477212f = new ReentrantLock();
    }

    public c() {
        this.f477213a = -1.0d;
        this.f477214b = new ArrayBlockingQueue(10);
        this.f477215c = new d[10];
        new ArrayList();
        a r100 = new a();
        this.f477217e = r100;
        this.f477216d = r100;
    }
}
