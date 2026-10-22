package com.bytedance.monitor.collector;

import android.util.Pair;
import f27.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f265560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f265561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f265562d;

    /* JADX INFO: loaded from: classes21.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RunMode {
        public static final int ASCRIBE = 3;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 2;
        public static final int TURNOFF = 0;
    }

    public Pair<String, ?> a() {
        return null;
    }

    public Pair<String, ?> b(long r100, long r101) {
        return null;
    }

    public abstract void d(int r100);

    public void c() {
        if (this.f265560b < 0) goto L7;
        this.f265560b = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    public AbsMonitor(int r100, String r101) {
        this.f265560b = 0;
        this.f265559a = r101;
        this.f265561c = r100;
        c r102 = c.e();
        if (((CopyOnWriteArrayList) r102.f265643a).contains(this) == true) goto L7;
        ((CopyOnWriteArrayList) r102.f265643a).add(this);
        if (r102.f265645c == false) goto L7;
        c();
    L7:
        Object r103 = d.f475214f;
        this.f265562d = d.a.f475222a;
    }
}
