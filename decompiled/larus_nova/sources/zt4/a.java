package zt4;

import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.load.e f573581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f573583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f573584d;

    public void a() {
    }

    public void b() {
    }

    public String d() {
        return null;
    }

    public boolean e() {
        return this instanceof b;
    }

    public abstract boolean f();

    public abstract boolean g();

    public boolean h() {
        return this instanceof e;
    }

    public void i() {
    }

    public final boolean c() {
        if (this.f573583c.getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        this.f573581a = r100;
        this.f573582b = "AbsBitableDataLoader";
        this.f573583c = new CountDownLatch(1);
    }
}
