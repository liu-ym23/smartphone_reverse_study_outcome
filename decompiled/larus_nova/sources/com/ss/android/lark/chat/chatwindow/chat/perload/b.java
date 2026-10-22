package com.ss.android.lark.chat.chatwindow.chat.perload;

import android.util.LruCache;
import com.larksuite.framework.thread.n;
import com.larksuite.framework.thread.p;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import u3b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f413460e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f413461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, e> f413462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, u3b.d> f413463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f413464d;

    static {
        f413460e = Runtime.getRuntime().availableProcessors() + 3;
    }

    public b() {
        this.f413464d = new ReentrantLock();
        this.f413461a = new p("DataPreLoadEngine", 2, f413460e, 30, new LinkedBlockingDeque(128), new n("DataPreLoadEngine", 3));
        this.f413462b = new ConcurrentHashMap();
        this.f413463c = new LruCache(20);
    }

    public final void a(final u3b.d r100, final com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r101) {
        final String r102 = r100.f548628a;
        this.f413463c.put(r102, r100);
        Log.i("DataPreLoadEngine", "Execute：" + r102);
        this.f413461a.execute(new a(this, r101, r100, r102));
    }
}
