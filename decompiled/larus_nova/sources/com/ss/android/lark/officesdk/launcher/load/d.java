package com.ss.android.lark.officesdk.launcher.load;

import android.content.Context;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j28.a f433471a;

    public static final class a {
    }

    public static final class b {
        public b() {
        }

        public final void a(Set<? extends Class<? extends ILaunchTask<?>>> r100) {
            Intrinsics.checkNotNullParameter(r100, "remainingTasks");
            Log.e("OfficeLoadTaskRunner", "load task dependency cycle or unresolved dependency in " + r100);
        }

        public final void c(ILaunchTask<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Log.i("OfficeLoadTaskRunner", "execute load task start, taskName=" + r100.f());
        }

        public final void d(ILaunchTask<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Log.i("OfficeLoadTaskRunner", "execute load task success, taskName=" + r100.f());
        }

        public final void b(ILaunchTask<?> r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("OfficeLoadTaskRunner", "[" + r100.f() + "] load task failed", r101);
        }
    }

    static {
    }

    public d() {
        this.f433471a = new j28.a();
    }

    public final boolean a(Context r110, List<? extends ILaunchTask<?>> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "tasks");
        j28.a r100 = this.f433471a;
        b r101 = new b();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "tasks");
        Intrinsics.checkNotNullParameter(r111, "tasks");
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r111.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ILaunchTask r104 = (ILaunchTask) r103.next();
        r102.put(r104.getClass(), r104);
        goto L4
    L6:
        ArrayList r105 = new ArrayList();
    L8:
        if ((!r102.isEmpty()) == false) goto L36;
        Collection r106 = r102.values();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        List<Class<? extends ILaunchTask>> r112 = ((ILaunchTask) r109).e();
        if (r112 != null) goto L15;
        r112 = CollectionsKt.emptyList();
    L15:
        List<Class<? extends ILaunchTask>> r113 = r112;
        if ((r113 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r114 = r113.iterator();
    L22:
        if (r114.hasNext() == false) goto L26;
        if (r102.containsKey((Class) r114.next()) == false) goto L22;
        boolean r115 = false;
    L27:
        if (r115 == false) goto L11;
        r107.add(r109);
    L26:
        r115 = true;
        goto L27
    L18:
        if (r113.isEmpty() == false) goto L20;
    L30:
        if (r107.isEmpty() == true) goto L31;
        Iterator r116 = r107.iterator();
    L34:
        if (r116.hasNext() == false) goto L8;
        ILaunchTask r117 = (ILaunchTask) r116.next();
        Intrinsics.checkNotNull(r117);
        r105.add(r117);
        r102.remove(r117.getClass());
        goto L34
    L31:
        r105 = null;
    L36:
        if (r105 != null) goto L42;
        LinkedHashSet r118 = new LinkedHashSet();
        Iterator<T> r119 = r111.iterator();
    L39:
        if (r119.hasNext() == false) goto L41;
        r118.add(((ILaunchTask) r119.next()).getClass());
        goto L39
    L41:
        r101.a(r118);
    L50:
        return false;
    L42:
        Iterator r120 = r105.iterator();
    L44:
        if (r120.hasNext() == false) goto L69;
        ILaunchTask<?> r121 = (ILaunchTask) r120.next();
        r101.c(r121);     // Catch: Throwable -> L48
        r121.a(r110);     // Catch: Throwable -> L48
        r101.d(r121);     // Catch: Throwable -> L48
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        r101.b(r121, th);
        goto L50
    L69:
        return true;
    }
}
