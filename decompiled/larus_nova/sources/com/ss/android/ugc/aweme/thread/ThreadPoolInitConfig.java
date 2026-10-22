package com.ss.android.ugc.aweme.thread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public class ThreadPoolInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ThreadPoolType> f454314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f454315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f454317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454318e;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ThreadPoolType> f454319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f454320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f454321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f454322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f454323e;

        private Builder() {
            List<ThreadPoolType> r100 = Collections.emptyList();
            ThreadPoolInitConfig.a(r100);
            this.f454319a = r100;
            List<String> r101 = Collections.emptyList();
            ThreadPoolInitConfig.a(r101);
            this.f454320b = r101;
            TimeUnit r102 = TimeUnit.MINUTES;
            this.f454321c = r102.toMillis(5);
            this.f454322d = r102.toMillis(5);
            this.f454323e = r102.toMillis(15);
        }

        public /* synthetic */ Builder(int r100) {
            this();
        }
    }

    public ThreadPoolInitConfig(Builder r100) {
        List<ThreadPoolType> r101 = r100.f454319a;
        a(r101);
        this.f454314a = r101;
        List<String> r102 = r100.f454320b;
        a(r102);
        this.f454315b = r102;
        long r103 = r100.f454321c;
        b(r103);
        this.f454316c = r103;
        long r104 = r100.f454322d;
        b(r104);
        this.f454317d = r104;
        long r105 = r100.f454323e;
        b(r105);
        this.f454318e = r105;
    }

    public static void a(Object r100) {
        if (r100 == null) goto L4;
        return;
    L4:
        IllegalStateException r101 = new IllegalStateException("should not be null!");
        r101.printStackTrace();
        throw r101;
    }

    public static void b(long r100) {
        if (r100 == 0) goto L5;
        return;
    L5:
        IllegalStateException r101 = new IllegalStateException("should not be zero!");
        r101.printStackTrace();
        throw r101;
    }
}
