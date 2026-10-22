package com.obric.aiagent.ipc.utils;

import android.os.IBinder;
import android.os.IInterface;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f384740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IInterface>, IInterface> f384741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> f384742c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IInterface>, Pair<IBinder, IBinder.DeathRecipient>> f384743d = null;

    public static final class a<S extends IInterface> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<S> f384744a;

        public a(b<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f384744a = r100;
        }
    }

    public interface b<S> {
        void a(S r100);
    }

    public static final class c implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class<Object> f384745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBinder f384746b;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ConcurrentHashMap<Class<? extends IInterface>, Pair<IBinder, IBinder.DeathRecipient>> r100 = g.f384743d;
            Class<Object> r101 = this.f384745a;
            IBinder r102 = this.f384746b;
            monitor-enter(r100);
            Pair<IBinder, IBinder.DeathRecipient> r103 = r100.get(r101);     // Catch: Throwable -> L23
            if (r103 != null) goto L7;
        L21:
            monitor-exit(r100);
            return;
        L7:
            if (r103.getFirst() != r102) goto L21;
            if (r103.getSecond() != this) goto L21;
            r100.remove(r101, r103);     // Catch: Throwable -> L23
            monitor-exit(r100);
            ConcurrentHashMap<Class<? extends IInterface>, IInterface> r104 = g.f384741b;
            Class<Object> r105 = this.f384745a;
            monitor-enter(r104);
            IInterface r106 = r104.remove(r105);     // Catch: Throwable -> L18
            monitor-exit(r104);
            return;
        L18:
            th = move-exception;
            throw th;
        L23:
            th = move-exception;
            throw th;
        }

        public c(Class<Object> r100, IBinder r101) {
            this.f384745a = r100;
            this.f384746b = r101;
        }
    }

    public g() {
    }

    static {
        f384740a = new g();
        f384741b = new ConcurrentHashMap();
        f384742c = new ConcurrentHashMap();
        f384743d = new ConcurrentHashMap();
    }

    public static IInterface b(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r101 = f384741b;
        monitor-enter(r101);
        IInterface r102 = r101.get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = null;
    L8:
        monitor-exit(r101);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void c(Class r100, IInterface r101) {
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r102 = f384742c;
        CopyOnWriteArrayList<a<?>> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new CopyOnWriteArrayList();
        r102.put(r100, r103);
    L5:
        Iterator<a<?>> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        a<?> r105 = r104.next();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, RXScreenCaptureService.KEY_INDEX);
        r105.f384744a.a((S) r101);
        if (Unit.INSTANCE == null) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L7;
        r103.remove(r105);
        goto L7
    L11:
        r106 = false;
        goto L12
    }

    public static void d(Class r100, IInterface r101) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Intrinsics.checkNotNullParameter(r101, "stub");
        IBinder r102 = r101.asBinder();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        c r104 = new c(r100, r102);     // Catch: Throwable -> L27
        ConcurrentHashMap<Class<? extends IInterface>, Pair<IBinder, IBinder.DeathRecipient>> r105 = f384743d;     // Catch: Throwable -> L27
        monitor-enter(r105);     // Catch: Throwable -> L27
        Pair<IBinder, IBinder.DeathRecipient> r106 = r105.get(r100);     // Catch: Throwable -> L24
        r102.linkToDeath(r104, 0);     // Catch: Throwable -> L24
        r105.put(r100, TuplesKt.to(r102, r104));     // Catch: Throwable -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r105);     // Catch: Throwable -> L27
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r108 = f384741b;     // Catch: Throwable -> L27
        monitor-enter(r108);     // Catch: Throwable -> L27
        r108.put(r100, r101);     // Catch: Throwable -> L21
        monitor-exit(r108);     // Catch: Throwable -> L27
        c(r100, r101);     // Catch: Throwable -> L27
        Pair<IBinder, IBinder.DeathRecipient> r109 = r106;     // Catch: Throwable -> L27
        if (r109 != null) goto L58;
        Result r110 = null;
    L20:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L27
    L30:
        if (Result.m9452exceptionOrNullimpl(r111) == null) goto L69;
        ConcurrentHashMap<Class<? extends IInterface>, Pair<IBinder, IBinder.DeathRecipient>> r112 = f384743d;
        monitor-enter(r112);
        Pair<IBinder, IBinder.DeathRecipient> r113 = r112.get(r100);     // Catch: Throwable -> L53
        if (r113 != null) goto L37;
    L43:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r112);
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r115 = f384741b;
        monitor-enter(r115);
        IInterface r116 = r115.remove(r100);     // Catch: Throwable -> L50
        monitor-exit(r115);
        return;
    L50:
        th = move-exception;
        throw th;
    L37:
        if (r113.getFirst() != r102) goto L43;
        r112.remove(r100, r113);     // Catch: Throwable -> L53
        Result.m9449constructorimpl(Boolean.valueOf(r102.unlinkToDeath(r113.getSecond(), 0)));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L53
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L69:
        return;
    L58:
        Object r118 = Result.m9449constructorimpl(Boolean.valueOf(r109.getFirst().unlinkToDeath(r109.getSecond(), 0)));     // Catch: Throwable -> L16
    L18:
        r110 = Result.m9448boximpl(r118);     // Catch: Throwable -> L27
        goto L20
    L16:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L27
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L18
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static void e(Class r100, final b r101) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Intrinsics.checkNotNullParameter(r101, "action");
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r102 = f384742c;
        CopyOnWriteArrayList<a<?>> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new CopyOnWriteArrayList();
        r102.put(r100, r103);
    L5:
        CollectionsKt.removeAll(r103, new f(r101));
    }

    public static void a(Class r100, b r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Intrinsics.checkNotNullParameter(r101, "action");
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r103 = f384742c;
        CopyOnWriteArrayList<a<?>> r104 = r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new CopyOnWriteArrayList();
        r103.put(r100, r104);
    L5:
        r104.add(new a(r101));
        if (r102 == false) goto L11;
        IInterface r105 = b(r100);
        if (r105 == null) goto L12;
        ILogDepend.f384986a.i("IPCManager", "addRegisterAction, immediate, " + r100 + ", " + r101);
        r101.a(r105);
        return;
    L12:
        return;
    }
}
