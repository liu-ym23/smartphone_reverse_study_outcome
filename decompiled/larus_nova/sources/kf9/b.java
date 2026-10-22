package kf9;

import com.larus.im.internal.trace.manager.definition.AVConditionType;
import com.larus.im.internal.trace.stable.p;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<AVConditionType> f503212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f503213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<AVConditionType, Boolean> f503214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f503215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f503216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantReadWriteLock f503217f;

    public b(Set r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "requiredConditions");
        Intrinsics.checkNotNullParameter(r101, "trigger");
        this.f503212a = r100;
        this.f503213b = r101;
        this.f503214c = new HashMap();
        this.f503216e = new LinkedHashMap();
        this.f503217f = new ReentrantReadWriteLock();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        AVConditionType r103 = (AVConditionType) r102.next();
        this.f503214c.put(r103, Boolean.FALSE);
        goto L4
    }

    public static void a(b r100, AVConditionType r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "condition");
        ReentrantReadWriteLock.WriteLock r104 = r100.f503217f.writeLock();
        r104.lock();
    L24:
        th = move-exception;
        r104.unlock();
        throw th;
    L7:
        if (r100.f503212a.contains(r101) == false) goto L22;
        Boolean r105 = r100.f503214c.get(r101);     // Catch: Throwable -> L24
        Boolean r106 = Boolean.TRUE;     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r105, r106) == true) goto L20;
        r100.f503214c.put(r101, r106);     // Catch: Throwable -> L24
        fe9.a r107 = fe9.a.f476620a;     // Catch: Throwable -> L24
        r107.f("AVConditionTrigger", "markConditionCompleted, condition replace success: " + r101);     // Catch: Throwable -> L24
        if (r102 == true) goto L19;
        int r108 = r100.f503215d + 1;     // Catch: Throwable -> L24
        r100.f503215d = r108;     // Catch: Throwable -> L24
        if (r108 == r100.f503212a.size()) goto L19;
        r107.f("AVConditionTrigger", "markConditionCompleted, not completed: " + r101 + ", size: " + r100.f503215d);     // Catch: Throwable -> L24
    L21:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L19:
        r107.f("AVConditionTrigger", "markConditionCompleted, trigger: " + r101 + ", size: " + r100.f503215d + ", forceTrigger: " + r102);     // Catch: Throwable -> L24
        r100.f503213b.invoke();     // Catch: Throwable -> L24
        goto L21
    L20:
        fe9.a.f476620a.f("AVConditionTrigger", "markConditionCompleted, condition already completed: " + r101);     // Catch: Throwable -> L24
    L22:
        r104.unlock();
    }
}
