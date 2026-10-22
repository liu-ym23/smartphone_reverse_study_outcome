package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class z extends AbstractCoroutineContextElement implements u1<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f505164a = null;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a implements CoroutineContext.Key<z> {
        public a() {
        }
    }

    static {
        f505164a = new a();
    }

    public z() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L9;
        return false;
    L9:
        ((z) r100).getClass();
        return true;
    }

    public final int hashCode() {
        return (int) 0;
    }

    public final String toString() {
        return "CoroutineId(0)";
    }

    @Override // kotlinx.coroutines.u1
    public final String updateThreadContext(CoroutineContext r100) {
        a0 r101 = (a0) r100.get(a0.f504617b);
        if (r101 == null) goto L6;
        String r102 = r101.f504618a;
        if (r102 == null) goto L6;
    L7:
        Thread r103 = ThreadMethodProxy.currentThread();
        String r104 = r103.getName();
        int r105 = StringsKt.lastIndexOf$default(r104, " @", 0, false, 6, null);
        if (r105 >= 0) goto L10;
        r105 = r104.length();
    L10:
        StringBuilder r106 = new StringBuilder((r102.length() + r105) + 10);
        r106.append(r104.substring(0, r105));
        r106.append(" @");
        r106.append(r102);
        r106.append("#0");
        ThreadMethodProxy.setName(r103, r106.toString());
        return r104;
    L6:
        r102 = "coroutine";
        goto L7
    }

    @Override // kotlinx.coroutines.u1
    public final void restoreThreadContext(CoroutineContext r100, String r101) {
        Thread r102 = ThreadMethodProxy.currentThread();
        ThreadMethodProxy.setName(r102, r101);
    }
}
