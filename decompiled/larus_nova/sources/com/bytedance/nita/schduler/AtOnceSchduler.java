package com.bytedance.nita.schduler;

import android.content.Context;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class AtOnceSchduler extends AbsSchduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f266000d;

    /* JADX INFO: loaded from: classes21.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtOnceSchduler f266001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.nita.api.c f266002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f266003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f266004d;

        public a(AtOnceSchduler r100, com.bytedance.nita.api.c r101, int r102, Context r103) {
            this.f266001a = r100;
            this.f266002b = r101;
            this.f266003c = r102;
            this.f266004d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AtOnceSchduler r100 = this.f266001a;     // Catch: Throwable -> L4
            com.bytedance.nita.api.c r101 = this.f266002b;     // Catch: Throwable -> L4
            int r102 = this.f266003c;     // Catch: Throwable -> L4
            Context r103 = this.f266004d;     // Catch: Throwable -> L4
            AbsSchduler$getInflateFunc$1 r104 = AbsSchduler$getInflateFunc$1.INSTANCE;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            AbsSchduler.d(r101, r102, r103, r104).invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        return true;
    }

    public AtOnceSchduler() {
        this.f266000d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.nita.schduler.AbsSchduler, com.bytedance.nita.schduler.d
    public final void c(String r100) {
        this.f266000d.put(r100, 1);
    }

    @Override // com.bytedance.nita.schduler.d
    public final void b(final com.bytedance.nita.api.c r100, Context r101, int r102) {
        o37.b r103 = o37.a.f521912a;
        if ((o37.a.a() & 1) == 0) goto L5;
        AbsSchduler.d(r100, r102, r101, new AtOnceSchduler$commitInflate$1(this, r100)).invoke();
        return;
    L5:
        r37.b.f535884e.b().postDelayed(new a(this, r100, r102, r101), 5);
    }
}
