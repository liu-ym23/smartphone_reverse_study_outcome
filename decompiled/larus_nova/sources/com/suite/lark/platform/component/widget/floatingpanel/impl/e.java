package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f460712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f460713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f460714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f460715d;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f460716a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            e r101 = this.f460716a;
            ReentrantLock r102 = r101.f460712a;
            r102.lock();
        L23:
            th = move-exception;
            r102.unlock();
            throw th;
        L4:
            if (r101.f460713b == false) goto L9;
            r102.unlock();
            return;
        L9:
            if (r100.what == 1) goto L12;
            r102.unlock();
            return;
        L12:
            Object r103 = r100.obj;     // Catch: Throwable -> L23
            if ((r103 instanceof String) == false) goto L16;
            String r104 = (String) r103;     // Catch: Throwable -> L23
        L17:
            if (r104 != null) goto L20;
            r102.unlock();
            return;
        L20:
            e.a(r101, r104);     // Catch: Throwable -> L23
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L23
            r102.unlock();
            return;
        L16:
            r104 = null;
            goto L17
        }

        public c(e r100, Looper r101) {
            this.f460716a = r100;
            super(r101);
        }
    }

    static {
    }

    public e() {
        this.f460712a = new ReentrantLock();
        this.f460714c = new LinkedHashMap();
        this.f460715d = new c(this, Looper.getMainLooper());
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ReentrantLock r101 = this.f460712a;
        r101.lock();
        this.f460715d.removeMessages(1, r100);     // Catch: Throwable -> L6
        this.f460714c.remove(r100);     // Catch: Throwable -> L6
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public static final void a(e r100, String r101) {
        ReentrantLock r102 = r100.f460712a;
        r102.lock();
        r100.f460714c.containsKey(r101);     // Catch: Throwable -> L9
        b r103 = (b) ((LinkedHashMap) r100.f460714c).get(r101);     // Catch: Throwable -> L9
        if (r103 != null) goto L6;
        r102.unlock();
        return;
    L6:
        r103.a();     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r102.unlock();
        return;
    L9:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public final void c(String r100, long r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "listener");
        ReentrantLock r103 = this.f460712a;
        r103.lock();
    L15:
        th = move-exception;
        r103.unlock();
        throw th;
    L4:
        if (this.f460713b == false) goto L7;
        r103.unlock();
        return;
    L7:
        this.f460715d.removeMessages(1, r100);     // Catch: Throwable -> L15
        this.f460714c.remove(r100);     // Catch: Throwable -> L15
        if (r101 > 0) goto L12;
        r102.a();     // Catch: Throwable -> L15
        r103.unlock();
        return;
    L12:
        this.f460714c.put(r100, r102);     // Catch: Throwable -> L15
        Message r104 = this.f460715d.obtainMessage(1, r100);     // Catch: Throwable -> L15
        this.f460715d.sendMessageDelayed(r104, r101);     // Catch: Throwable -> L15
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r103.unlock();
    }
}
