package com.ss.android.lark.flow.chat.statistics.perf;

import android.os.SystemClock;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import mkb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements mkb.a, com.ss.android.lark.statistics.perf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f423021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f423022b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, C4990a> f423023c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f423024d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f423025e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f423026f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f423027g = null;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.statistics.perf.a$a, reason: collision with other inner class name */
    public static final class C4990a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f423028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f423029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f423030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f423031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f423032e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4990a) == true) goto L8;
            return false;
        L8:
            C4990a r101 = (C4990a) r100;
            if (this.f423028a == r101.f423028a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f423029b, r101.f423029b) == true) goto L15;
            return false;
        L15:
            if (this.f423030c == r101.f423030c) goto L18;
            return false;
        L18:
            if (this.f423031d == r101.f423031d) goto L21;
            return false;
        L21:
            if (this.f423032e == r101.f423032e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f423028a;
            int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f423029b.hashCode()) * 31) + this.f423030c) * 31;
            int r102 = 1231;
            if (this.f423031d == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r101 + r103) * 31;
            if (this.f423032e == true) goto L11;
            r102 = 1237;
        L11:
            return r104 + r102;
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingStart(tSendStart=" + this.f423028a + ", chatId=" + this.f423029b + ", chatType=" + this.f423030c + ", hasEnterBackground=" + this.f423031d + ", hasPageInvisible=" + this.f423032e + ')';
        }

        public C4990a(long r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "chatId");
            this.f423028a = r100;
            this.f423029b = r101;
            this.f423030c = r102;
            this.f423031d = false;
            this.f423032e = false;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f423033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f423034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f423035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f423036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f423037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f423038f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f423039g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f423040h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f423041i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile boolean f423042j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile boolean f423043k;

        public b(String r100, String r101, int r102, String r103, long r104, long r105, boolean r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "chatId");
            this.f423033a = r101;
            this.f423034b = r102;
            this.f423035c = r103;
            this.f423036d = r104;
            this.f423037e = r105;
            this.f423038f = null;
            this.f423039g = null;
            this.f423040h = 0;
            this.f423041i = 0;
            this.f423042j = r110;
            this.f423043k = r111;
        }
    }

    public static final class c implements okb.a.b {
        public c() {
        }

        @Override // okb.a.b
        public final void a() {
            Iterator<T> r100 = a.f423023c.values().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((C4990a) r100.next()).f423031d = true;
            goto L4
        L6:
            Iterator r101 = SequencesKt.sequence(new DoubaoReplyLatencyTracker$markAllInFlightBackground$2(null)).iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((b) r101.next()).f423042j = true;
            goto L8
        }
    }

    public a() {
    }

    @Override // mkb.a
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        Intrinsics.checkNotNullParameter(r101, "cId");
    }

    static {
        f423021a = new a();
        f423022b = new AtomicBoolean(false);
        f423023c = new ConcurrentHashMap();
        f423024d = new ConcurrentHashMap();
        f423025e = new ConcurrentHashMap();
        f423026f = new ConcurrentHashMap();
        f423027g = new c();
    }

    @JvmStatic
    public static final void g() {
        if (f423022b.compareAndSet(false, true) == false) goto L12;
        a r100 = f423021a;
        CopyOnWriteArrayList<mkb.a> r101 = d.f514353a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<mkb.a> r102 = d.f514353a;
        if (r102.contains(r100) == true) goto L7;
        r102.add(r100);
    L7:
        CopyOnWriteArrayList<com.ss.android.lark.statistics.perf.a> r103 = com.ss.android.lark.statistics.perf.b.f440768a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<com.ss.android.lark.statistics.perf.a> r104 = com.ss.android.lark.statistics.perf.b.f440768a;
        if (r104.contains(r100) == true) goto L10;
        r104.add(r100);
    L10:
        ImSdkProxy.b().d(f423027g);
        return;
    }

    @Override // mkb.a
    public final void f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        f423024d.remove(r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // mkb.a
    public final void a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        Intrinsics.checkNotNullParameter(r101, "serverId");
        b r103 = f423024d.remove(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        r103.f423038f = r101;
        r103.f423040h = r102;
        f423025e.put(r101, r103);
    }

    @Override // com.ss.android.lark.statistics.perf.a
    public final void b(String r100, MessageInfo r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "messageInfo");
        Message r103 = r101.getMessage();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.getType() == Message.Type.DOUBAO) goto L8;
        return;
    L8:
        Map<Class<?>, Object> r104 = r103.getExtras();
        if (r104 != null) goto L11;
        return;
    L11:
        Object r105 = r104.get(g5b.a.class);
        if ((r105 instanceof g5b.a) == false) goto L14;
        g5b.a r106 = (g5b.a) r105;
    L15:
        if (r106 != null) goto L17;
        return;
    L17:
        String r107 = r103.getId();
        if (r107.length() != 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        return;
    L23:
        String r109 = String.valueOf(r106.f480107b);
        b r110 = f423025e.remove(r109);
        if (r110 != null) goto L26;
        return;
    L26:
        r110.f423039g = r107;
        r110.f423041i = r102;
        f423026f.put(r107, r110);
        return;
    L20:
        r108 = false;
        goto L21
    L14:
        r106 = null;
        goto L15
    }

    @Override // mkb.a
    public final void c(String r100, String r101, int r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        ConcurrentHashMap<String, C4990a> r104 = f423023c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r104.put(r100, new C4990a(r103, r101, r102));
    }

    @Override // mkb.a
    public final void d(String r110, String r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "contextId");
        Intrinsics.checkNotNullParameter(r111, "cId");
        C4990a r100 = f423023c.remove(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        b r114 = new b(r111, r100.f423029b, r100.f423030c, r112, r100.f423028a, SystemClock.elapsedRealtime(), r100.f423031d, r100.f423032e);
        ConcurrentHashMap<String, b> r101 = f423024d;
        r101.put(r111, r114);
        final long r102 = SystemClock.elapsedRealtime();
        Function1<b, Boolean> r103 = new DoubaoReplyLatencyTracker$cleanupExpired$isExpired$1(r102);
        CollectionsKt.removeAll(r101.values(), r103);
        CollectionsKt.removeAll(f423025e.values(), r103);
        CollectionsKt.removeAll(f423026f.values(), r103);
    }
}
