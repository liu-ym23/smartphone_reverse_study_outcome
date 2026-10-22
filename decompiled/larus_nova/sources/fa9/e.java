package fa9;

import android.os.Handler;
import android.os.Looper;
import com.larus.im.FlowRuntime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f476067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f476068b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Set<String>> f476069c = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((String) ((Map.Entry) r100).getKey(), (String) ((Map.Entry) r101).getKey());
        }
    }

    public e() {
    }

    public final synchronized String b() {
        monitor-enter(this);
        Map<String, Set<String>> r100 = f476069c;     // Catch: Throwable -> L10
        String r101 = CollectionsKt.joinToString$default(CollectionsKt.sortedWith(((LinkedHashMap) r100).entrySet(), new a()), ",", null, null, 0, null, new c(), 30, null);     // Catch: Throwable -> L10
        Iterator r102 = ((LinkedHashMap) r100).values().iterator();     // Catch: Throwable -> L10
        int r103 = 0;
    L5:
        if (r102.hasNext() == false) goto L7;
        r103 = r103 + ((Set) r102.next()).size();     // Catch: Throwable -> L10
        goto L5
    L7:
        String r104 = "activeOwners=" + r103 + " reasons=[" + r101 + ']';     // Catch: Throwable -> L10
        monitor-exit(this);
        return r104;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f476067a = new e();
        f476068b = LazyKt.lazy(new fa9.a());
        f476069c = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [fa9.b] */
    public static void c() {
        final ?? r100 = new b();
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.invoke();
        return;
    L5:
        ((Handler) f476068b.getValue()).post(new d(r100));
    }

    public static void e(String r100, Throwable r101) {
        if (r101 != null) goto L5;
        FlowRuntime.b().e().w("FlowKeepScreenOnGuard", r100);     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        FlowRuntime.b().e().w("FlowKeepScreenOnGuard", r100, r101);     // Catch: Throwable -> L7
    }

    public final synchronized void a(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r101, "owner");     // Catch: Throwable -> L13
        if (g(r100, r101, "acquire") == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        LinkedHashMap r102 = (LinkedHashMap) f476069c;     // Catch: Throwable -> L13
        Object r103 = r102.get(r100);     // Catch: Throwable -> L13
        if (r103 != null) goto L10;
        r103 = new LinkedHashSet();     // Catch: Throwable -> L13
        r102.put(r100, r103);     // Catch: Throwable -> L13
    L10:
        d("acquire", r100, r101, ((Set) r103).add(r101));     // Catch: Throwable -> L13
        c();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r101, "owner");     // Catch: Throwable -> L23
        if (g(r100, r101, "release") == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Map<String, Set<String>> r102 = f476069c;     // Catch: Throwable -> L23
        Set r103 = (Set) ((LinkedHashMap) r102).get(r100);     // Catch: Throwable -> L23
        boolean r104 = false;
        if (r103 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        Set r106 = (Set) ((LinkedHashMap) r102).get(r100);     // Catch: Throwable -> L23
        if (r106 != null) goto L16;
    L18:
        if (r104 == false) goto L20;
        r102.remove(r100);     // Catch: Throwable -> L23
    L20:
        d("release", r100, r101, r105);     // Catch: Throwable -> L23
        c();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if (r106.isEmpty() != true) goto L18;
        r104 = true;
        goto L18
    L10:
        if (r103.remove(r101) != true) goto L12;
        r105 = true;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean g(String r100, String r101, String r102) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
    L10:
        e(r102 + " ignored emptyReason=" + StringsKt.isBlank(r100) + " emptyOwner=" + StringsKt.isBlank(r101), null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return false;
    L7:
        if ((!StringsKt.isBlank(r101)) == false) goto L10;
        monitor-exit(this);
        return true;
    }

    public final synchronized void d(String r100, String r101, String r102, boolean r103) {
        monitor-enter(this);
        String r104 = r100 + " reason=" + r101 + " ownerHash=" + r102.hashCode() + " changed=" + r103 + ' ' + b();     // Catch: Throwable -> L11
        if (r103 == false) goto L8;
        FlowRuntime.b().e().i("FlowKeepScreenOnGuard", r104);     // Catch: Throwable -> L14
    L9:
        monitor-exit(this);
        return;
    L8:
        e(r104, null);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
