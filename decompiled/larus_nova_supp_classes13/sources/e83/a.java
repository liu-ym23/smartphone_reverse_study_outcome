package e83;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.n;
import com.bytedance.android.shopping.anchorv4.voavhs.head.c;
import com.bytedance.android.shopping.anchorv4.voavhs.head.event.HeadEventSubscribe;
import fa3.d;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements d {
    public static final HashMap<String, List<Pair<n, Method>>> b = null;
    public static Function0<? extends List<c>> c;
    public static final a d = null;
    public final /* synthetic */ fa3.b a;

    /* JADX INFO: renamed from: e83.a$a, reason: collision with other inner class name */
    public static final class C0192a implements CompletableOnSubscribe {
        public final /* synthetic */ n a;

        public C0192a(n r1) {
            this.a = r1;
        }

        public final void subscribe(CompletableEmitter r10) {
            Intrinsics.checkNotNullParameter(r10, "it");
            Method[] r0 = this.a.getClass().getDeclaredMethods();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L21;
            Method r4 = r0[r3];
            Annotation[] r5 = r4.getAnnotations();
            int r6 = r5.length;
            int r7 = 0;
        L5:
            if (r7 >= r6) goto L10;
            if ((r5[r7] instanceof HeadEventSubscribe) == true) goto L8;
            r7 = r7 + 1;
            goto L5
        L8:
            boolean r8 = true;
        L11:
            if (r8 == false) goto L20;
            Class r9 = (Class) ArraysKt.firstOrNull(r4.getParameterTypes());
            if (r9 == null) goto L20;
            HashMap<String, List<Pair<n, Method>>> r11 = a.b;
            HashMap<String, List<Pair<n, Method>>> r12 = a.b;
            if (r12.get(r9.getName()) != null) goto L17;
            r12.put(r9.getName(), new ArrayList());
        L17:
            List<Pair<n, Method>> r13 = r12.get(r9.getName());
            if (r13 == null) goto L20;
            r13.add(new Pair(this.a, r4));
        L20:
            r3 = r3 + 1;
            goto L3
        L10:
            r8 = false;
            goto L11
        L21:
            r10.onComplete();
        }
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.add(r2);
        return r2;
    }

    static {
        d = new a();
        b = new HashMap();
    }

    public static List a() {
        Function0<? extends List<c>> r0 = c;
        if (r0 == null) goto L7;
        List r1 = (List) r0.invoke();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public a() {
        this.a = new fa3.b();
    }

    public static void c(b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        List<Pair<n, Method>> r0 = b.get(b.class.getName());
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        Pair r2 = (Pair) r1.next();
        ((Method) r2.getSecond()).invoke(r2.getFirst(), new Object[]{r5});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }

    private final void registerReceiver(n r2) {
        fa3.c.a(Completable.create(new C0192a(r2)).subscribeOn(Schedulers.single()).subscribe(), this);
    }

    public static void b(List r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "headDataFetcher");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        n r0 = (n) r4.next();
        if (r0.n() == false) goto L4;
        d.registerReceiver(r0);
        goto L4
    L8:
        c = r3;
    }
}
