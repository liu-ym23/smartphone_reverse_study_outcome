package se6;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes20.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.sdk.e f541589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f541590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f541591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f541592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f541593e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Command f541594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f541595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f541596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f541597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StreamDataSource f541598e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.ss.android.lark.sdk.h f541599f;

        public a(Command r100, byte[] r101, long r102, String r103, StreamDataSource r104, com.ss.android.lark.sdk.h r105) {
            this.f541594a = r100;
            this.f541595b = r101;
            this.f541596c = r102;
            this.f541597d = r103;
            this.f541598e = r104;
            this.f541599f = r105;
        }
    }

    public p(com.bytedance.lark.sdk.e r100) {
        this.f541590b = new CountDownLatch(1);
        this.f541591c = new AtomicInteger(1);
        this.f541592d = new ReentrantLock();
        this.f541593e = new ConcurrentLinkedQueue();
        this.f541589a = r100;
    }

    public final boolean a(Command r100) {
        com.ss.android.lark.sdk.d r101 = com.ss.android.lark.sdk.i.f439882b;
        if (r101 == null) goto L12;
        r101.b();
        if (this.f541591c.get() != 2) goto L8;
        return false;
    L8:
        if (r101.c(r100) == false) goto L10;
        return false;
    L10:
        return true;
    L12:
        return false;
    }
}
