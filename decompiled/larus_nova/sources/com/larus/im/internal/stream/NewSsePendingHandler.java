package com.larus.im.internal.stream;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NewSsePendingHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NewSsePendingHandler f350070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f350071b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vt7.a<String, d> f350072c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final NewSsePendingHandler$globalSyncStreamObserver$1 f350073d = null;

    /* JADX INFO: loaded from: classes30.dex */
    public interface a {
        String getMessageId();
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f350074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f350075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f350076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f350077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f350078e;

        @Override // com.larus.im.internal.stream.NewSsePendingHandler.a
        public final String getMessageId() {
            return this.f350074a;
        }

        public b(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f350074a = r100.getMessageId();
            this.f350075b = r100.getReplyId();
            r100.getServerIndex();
            this.f350076c = com.larus.im.bean.message.a.y0(r100);
            this.f350077d = com.larus.im.bean.message.a.x0(r100);
            this.f350078e = com.larus.im.bean.message.a.w(r100);
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f350079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<a, Long, Unit> f350080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f350081c;

        public c(b r100, Function2 r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "block");
            this.f350079a = r100;
            this.f350080b = r101;
            this.f350081c = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<c> f350082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f350083b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f350082a, r101.f350082a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f350083b, r101.f350083b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f350082a.hashCode() * 31) + this.f350083b.hashCode();
        }

        public final String toString() {
            return "TaskWrapper(source=" + this.f350082a + ", lock=" + this.f350083b + ')';
        }

        public d(CopyOnWriteArrayList<c> r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "lock");
            this.f350082a = r100;
            this.f350083b = r101;
        }
    }

    public NewSsePendingHandler() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.im.internal.stream.NewSsePendingHandler$globalSyncStreamObserver$1] */
    static {
        f350070a = new NewSsePendingHandler();
        f350071b = new CopyOnWriteArrayList();
        f350072c = new vt7.a();
        f350073d = new NewSsePendingHandler$globalSyncStreamObserver$1();
    }

    public static boolean c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.f350075b;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (f350071b.contains(r101) == true) goto L8;
    L14:
        return false;
    L8:
        if (r100.f350078e == true) goto L14;
        if (r100.f350076c == true) goto L14;
        if (r100.f350077d == true) goto L14;
        return true;
    }

    public static final void a(NewSsePendingHandler r100, String r101) {
        r100.getClass();
        CopyOnWriteArrayList<String> r102 = f350071b;
        if (r102.contains(r101) == false) goto L5;
        return;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r101, "0") == true) goto L16;
        r102.clear();
        r102.add(r101);
        return;
    L16:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static final void b(NewSsePendingHandler r100, String r101, String r110) {
        r100.getClass();
        if (f350071b.contains(r110) == true) goto L30;
        d r102 = f350072c.get(r110);
        if (r102 == null) goto L39;
        Object r103 = r102.f350083b;
        monitor-enter(r103);
        c r104 = (c) CollectionsKt.firstOrNull(r102.f350082a);     // Catch: Throwable -> L27
        if (r104 == null) goto L22;
        String r105 = r104.f350079a.getMessageId();     // Catch: Throwable -> L27
        CopyOnWriteArrayList<c> r106 = r102.f350082a;     // Catch: Throwable -> L27
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L27
        Iterator<T> r108 = r106.iterator();     // Catch: Throwable -> L27
    L13:
        if (r108.hasNext() == false) goto L17;
        Object r109 = r108.next();     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(((c) r109).f350079a.getMessageId(), r105) == false) goto L13;
        r107.add(r109);     // Catch: Throwable -> L27
        goto L13
    L17:
        com.larus.im.internal.delegate.a.f348188b.i("NewSsePendingHandler", "run, from:" + r101 + ",questionId:" + r110 + ",answerId:" + r105 + ",tasks:" + r107.size());     // Catch: Throwable -> L27
        Iterator r111 = r107.iterator();     // Catch: Throwable -> L27
    L19:
        if (r111.hasNext() == false) goto L22;
        c r112 = (c) r111.next();     // Catch: Throwable -> L27
        r112.f350080b.invoke(r112.f350079a, Long.valueOf(com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r112.f350081c));     // Catch: Throwable -> L27
        r102.f350082a.remove(r112);     // Catch: Throwable -> L27
    L22:
        if (r102.f350082a.isEmpty() == false) goto L24;
        f350072c.remove(r110);     // Catch: Throwable -> L27
    L24:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r103);
        return;
    L27:
        th = move-exception;
        throw th;
    L39:
        return;
    }

    public static void d(String r100, b r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "block");
        String r103 = r101.f350075b;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r104 = "from:" + r100 + ",questionId=" + r103 + ",answerId=" + r101.f350074a;
        if (c(r101) == true) goto L9;
        com.larus.im.internal.delegate.a.f348188b.i("NewSsePendingHandler", "no need pending, " + r104);
        r102.invoke(r101, 0L);
        return;
    L9:
        com.larus.im.internal.delegate.a r105 = com.larus.im.internal.delegate.a.f348188b;
        r105.i("NewSsePendingHandler", "need pending, " + r104);
        vt7.a<String, d> r106 = f350072c;
        d r107 = r106.get(r103);
        if (r107 != null) goto L12;
        r107 = new d(new CopyOnWriteArrayList(), new Object());
        r106.put(r103, r107);
    L12:
        Object r108 = r107.f350083b;
        monitor-enter(r108);
        r107.f350082a.add(new c(r101, r102));     // Catch: Throwable -> L20
        if (r107.f350082a.size() != 1) goto L17;
        f350070a.getClass();     // Catch: Throwable -> L20
        r105.i("NewSsePendingHandler", "loop start, questionId:".concat(r103));     // Catch: Throwable -> L20
        CoroutineExtKt.a(new NewSsePendingHandler$loop$1(r103, null));     // Catch: Throwable -> L20
    L17:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r108);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
