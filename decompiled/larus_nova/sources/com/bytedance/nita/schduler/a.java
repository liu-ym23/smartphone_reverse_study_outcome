package com.bytedance.nita.schduler;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AbsSchduler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f266005f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f266006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f266007e;

    /* JADX INFO: renamed from: com.bytedance.nita.schduler.a$a, reason: collision with other inner class name */
    public static final class C3721a {
    }

    public final class b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageQueue f266008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f266009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f266010c;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.f266010c.e();
            int r100 = a.f266005f;
            this.f266009b = true;
            return true;
        }

        public b(a r100, MessageQueue r101) {
            this.f266010c = r100;
            this.f266008a = r101;
        }
    }

    static {
    }

    public final void e() {
        ConcurrentHashMap<String, ArrayList<Function0<Unit>>> r100 = this.f265996b;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f265997c.size() <= 0) goto L17;
        String r101 = this.f265997c.remove(0);     // Catch: Throwable -> L20
        ArrayList<Function0<Unit>> r102 = this.f265996b.get(r101);     // Catch: Throwable -> L20
        if (r102 == null) goto L13;
        if (r102.size() <= 0) goto L11;
        r102.remove(0).invoke();     // Catch: Throwable -> L20
        goto L13
    L11:
        this.f265996b.remove(r101);     // Catch: Throwable -> L20
    L13:
        if (this.f265996b.size() <= 0) goto L17;
        if (this.f265995a.hasMessages(1) == true) goto L17;
        Message r103 = this.f265995a.obtainMessage();     // Catch: Throwable -> L20
        r103.what = 1;     // Catch: Throwable -> L20
        r103.obj = null;     // Catch: Throwable -> L20
        this.f265995a.removeMessages(1);     // Catch: Throwable -> L20
        this.f265995a.sendMessageDelayed(r103, 5000);     // Catch: Throwable -> L20
    L17:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r100);
    }

    public a() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        MessageQueue r100 = Looper.getMainLooper().getQueue();
        b r101 = new b(this, r100);
        this.f266006d = r101;
        if (r101.f266009b == true) goto L20;
        r100.addIdleHandler(r101);
        r101.f266009b = true;
    L20:
        this.f266007e = new ConcurrentHashMap();
        return;
    L8:
        Handler r102 = this.f265995a;
    L14:
        e = move-exception;
        e.printStackTrace();
        Object r103 = null;
    L16:
        MessageQueue r104 = (MessageQueue) r103;
        if (r104 == null) goto L19;
        r104.addIdleHandler(new com.bytedance.nita.schduler.b(this));
        goto L20
    L19:
        new Handler(Looper.getMainLooper()).post(new c(this));
        goto L20
    L10:
        if (r37.f.f535889a != null) goto L12;
        r37.f.f535889a = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L14
    L12:
        Field r105 = (Field) r37.f.f535889a.invoke(r102.getClass(), new Object[]{"mQueue"});     // Catch: Exception -> L14
        r105.setAccessible(true);     // Catch: Exception -> L14
        r103 = r105.get(r102);     // Catch: Exception -> L14
        goto L16
    }

    @Override // com.bytedance.nita.schduler.AbsSchduler, com.bytedance.nita.schduler.d
    public final void a(Context r100) {
        String r101 = this.f266007e.get(Integer.valueOf(r100.hashCode()));
        if (r101 == null) goto L15;
        ConcurrentHashMap<String, ArrayList<Function0<Unit>>> r102 = this.f265996b;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f265997c.size() <= 0) goto L9;
        this.f265996b.remove(r101);     // Catch: Throwable -> L12
        this.f265997c.remove(r101);     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r102);
        return;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        e();
        return true;
    }

    @Override // com.bytedance.nita.schduler.d
    public final void b(com.bytedance.nita.api.c r100, Context r101, int r102) {
        ConcurrentHashMap<String, ArrayList<Function0<Unit>>> r103 = this.f265996b;
        monitor-enter(r103);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.f265996b.get(r100.h()) != null) goto L7;
        this.f265996b.put(r100.h(), new ArrayList());     // Catch: Throwable -> L27
    L7:
        ArrayList<Function0<Unit>> r104 = this.f265996b.get(r100.h());     // Catch: Throwable -> L27
        if (r104 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L27
    L10:
        r104.add(AbsSchduler.d(r100, r102, r101, AbsSchduler$getInflateFunc$1.INSTANCE));     // Catch: Throwable -> L27
        this.f265997c.add(r100.h());     // Catch: Throwable -> L27
        monitor-exit(r103);
        if (this.f265996b.size() != 0) goto L15;
        return;
    L15:
        if ((r101 instanceof p37.a) == true) goto L18;
        this.f266007e.put(Integer.valueOf(r101.hashCode()), r100.h());
    L18:
        if (this.f265995a.hasMessages(1) == true) goto L20;
        Message r105 = this.f265995a.obtainMessage();
        r105.what = 1;
        r105.obj = null;
        this.f265995a.removeMessages(1);
        this.f265995a.sendMessageDelayed(r105, 5000);
    L20:
        b r106 = this.f266006d;
        if (r106 != null) goto L23;
        return;
    L23:
        if (r106.f266009b == true) goto L34;
        r106.f266008a.addIdleHandler(r106);
        r106.f266009b = true;
        return;
    }
}
