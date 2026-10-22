package k1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import e1c.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<g1c.b<T>> f501418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e1c.b f501419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501420c;

    /* JADX INFO: renamed from: k1c.a$a, reason: collision with other inner class name */
    public static final class C6502a {
    }

    static {
    }

    public abstract T n();

    public a() {
        this.f501418a = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f501420c = getClass().getSimpleName();
    }

    @Override // k1c.b
    public final void h(g1c.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        this.f501418a.add(r100);
        o(n());
    }

    public final void o(T r100) {
        HashSet r101 = new HashSet();
        HashSet r102 = new HashSet();
        HashSet r103 = new HashSet();
        HashSet r104 = new HashSet();
        Iterator<T> r105 = this.f501418a.iterator();
    L4:
        if (r105.hasNext() == false) goto L20;
        g1c.b r106 = (g1c.b) r105.next();
        r106.setValue(r100);
        if (r106.c() == false) goto L4;
        if (r106.isValid() == false) goto L4;
        if ((r106 instanceof i1c.a) == true) goto L11;
        if ((r106 instanceof h1c.a) == false) goto L4;
        h1c.a r107 = (h1c.a) r106;
        if (r107.isInterrupted() == true) goto L16;
        if (r107.d() == false) goto L4;
        r103.add(r106);
        goto L4
    L16:
        r102.add(r106);
        goto L4
    L11:
        r101.add(r106);
        goto L4
    L20:
        e1c.b r108 = null;
        if ((!r101.isEmpty()) == false) goto L27;
        e1c.b r109 = this.f501419b;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r109 = null;
    L25:
        r109.f(r101);
    L27:
        if ((!r102.isEmpty()) == false) goto L33;
        e1c.b r110 = this.f501419b;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r110 = null;
    L31:
        r110.i(r102);
    L33:
        if ((!r103.isEmpty()) == false) goto L39;
        e1c.b r111 = this.f501419b;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
        r111 = null;
    L37:
        r111.a(r103);
    L39:
        if ((!r104.isEmpty()) == false) goto L45;
        e1c.b r112 = this.f501419b;
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadManager");
    L44:
        r108.h(r104);
        goto L45
    L43:
        r108 = r112;
    L45:
        Log.d("AbsDetector", "onConditionChanged:" + this.f501420c + ", value:" + r100 + ", triggerCondition:" + r101.size() + ", interruptCondition:" + r102.size() + ", recoverCondition:" + r103.size() + ", cleanCondition:" + r104.size());
    }

    @Override // k1c.b
    public void j(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "manager");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f501419b = r101;
    }
}
