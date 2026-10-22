package com.bytedance.nita.schduler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsSchduler implements d, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f265995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ArrayList<Function0<Unit>>> f265996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<String> f265997c;

    @Override // com.bytedance.nita.schduler.d
    public void a(Context r100) {
    }

    public AbsSchduler() {
        this.f265995a = new Handler(Looper.getMainLooper(), this);
        this.f265996b = new ConcurrentHashMap();
        this.f265997c = new ArrayList();
    }

    @Override // com.bytedance.nita.schduler.d
    public void c(String r100) {
        ConcurrentHashMap<String, ArrayList<Function0<Unit>>> r101 = this.f265996b;
        monitor-enter(r101);
        ArrayList<Function0<Unit>> r102 = this.f265996b.remove(r100);     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.clear();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static Function0 d(final com.bytedance.nita.api.c r100, final int r110, final Context r111, final Function0 r112) {
        if ((r111 instanceof p37.a) == false) goto L5;
        final Function0<Context> r101 = new AbsSchduler$getInflateFunc$2(r111);
    L6:
        final Function0<Unit> r102 = new AbsSchduler$getInflateFunc$inflate$1(r101, r100, r110);
        return new AbsSchduler$getInflateFunc$func$1(r101, r100, r112, r102, r110, r111);
    L5:
        final WeakReference r103 = new WeakReference(r111);
        r101 = new AbsSchduler$getInflateFunc$3(r103);
        goto L6
    }
}
