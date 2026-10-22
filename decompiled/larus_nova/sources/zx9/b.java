package zx9;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<Pair<String, wx9.a>>> f573903a;

    @Override // io.opentelemetry.context.c
    public final io.opentelemetry.context.b root() {
        return io.opentelemetry.context.a.f492696b;
    }

    @Override // io.opentelemetry.context.c
    public final io.opentelemetry.context.b current() {
        wx9.b r100 = wx9.b.f561852c;
        return wx9.b.f561852c;
    }

    public b() {
        this.f573903a = new ConcurrentHashMap();
    }

    @Override // zx9.a
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "spanId");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r102 = this.f573903a.get(r100);     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        Iterator<Pair<String, wx9.a>> r103 = r102.iterator();     // Catch: Throwable -> L22
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r103.next().getFirst(), r101) == true) goto L14;
        r104 = r104 + 1;     // Catch: Throwable -> L22
    L14:
        if (r104 == (-1)) goto L17;
        r102.remove(r104);     // Catch: Throwable -> L22
    L17:
        if (r102.isEmpty() == false) goto L19;
        this.f573903a.remove(r100);     // Catch: Throwable -> L22
        goto L19
    L13:
        r104 = -1;
    L19:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public final wx9.a c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "tag");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r102 = this.f573903a.get(r100);     // Catch: Throwable -> L21
        wx9.a r103 = null;
        if (r102 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L21
    L11:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(((wx9.a) ((Pair) r105).getSecond()).c().f370170h, r101) == false) goto L11;
    L16:
        Pair r106 = (Pair) r105;     // Catch: Throwable -> L21
        if (r106 == null) goto L19;
        r103 = (wx9.a) r106.getSecond();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return r103;
    L15:
        r105 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public wx9.a getContext(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "spanId");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r102 = this.f573903a.get(r100);     // Catch: Throwable -> L21
        wx9.a r103 = null;
        if (r102 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L21
    L11:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(((Pair) r105).getFirst(), r101) == false) goto L11;
    L16:
        Pair r106 = (Pair) r105;     // Catch: Throwable -> L21
        if (r106 == null) goto L19;
        r103 = (wx9.a) r106.getSecond();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return r103;
    L15:
        r105 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public final void a(String r100, String r101, wx9.a r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "spanId");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        monitor-enter(this);
        List<Pair<String, wx9.a>> r103 = this.f573903a.get(r100);     // Catch: Throwable -> L25
        Pair<String, wx9.a> r104 = TuplesKt.to(r101, r102);     // Catch: Throwable -> L25
        boolean r105 = true;
        if (r103 != null) goto L7;
        this.f573903a.put(r100, CollectionsKt.mutableListOf(new Pair[]{r104}));     // Catch: Throwable -> L25
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L7:
        Iterator<Pair<String, wx9.a>> r107 = r103.iterator();     // Catch: Throwable -> L25
        int r108 = 0;
    L9:
        if (r107.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(r107.next().getFirst(), r101) == true) goto L15;
        r108 = r108 + 1;     // Catch: Throwable -> L25
    L15:
        if (r108 == (-1)) goto L18;
        r105 = false;
    L18:
        if (r105 == true) goto L21;
        r103 = null;
    L21:
        if (r103 == null) goto L23;
        r103.add(r104);     // Catch: Throwable -> L25
        goto L23
    L14:
        r108 = -1;
    L25:
        th = move-exception;
        throw th;
    }
}
