package com.ss.android.ugc.route_monitor.impl;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.route_monitor.utils.r;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<ActivityInfo> f454402a = null;

    /* JADX INFO: renamed from: com.ss.android.ugc.route_monitor.impl.a$a, reason: collision with other inner class name */
    public static final class RunnableC5450a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f454403a;

        public RunnableC5450a(Ref.ObjectRef r100) {
            this.f454403a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<ActivityInfo> r100 = a.f454402a;     // Catch: Throwable -> L4
            a.b((String) this.f454403a.element);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f454402a = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static void a(ResolveInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        String r102 = "";
        r101.element = "";
        ActivityInfo r103 = r100.activityInfo;
        ?? r104 = r102;
        if (r103 == null) goto L9;
        String r105 = r103.name;
        r104 = r102;
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r101.element = r104;
        if (r104.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L16;
        f454402a.add(r100.activityInfo);
        r.a(new RunnableC5450a(r101), 3000);
        return;
    L16:
        return;
    L12:
        r106 = false;
        goto L13
    }

    public static void b(String r100) {
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        ArrayList<ActivityInfo> r103 = f454402a;
        int r104 = r103.size();
    L9:
        if (r101 >= r104) goto L18;
        ihc.f r105 = com.ss.android.ugc.route_monitor.c.a();
        ActivityInfo r106 = (ActivityInfo) ListProtector.get(r103, r101);
        if (r106 == null) goto L13;
        String r107 = r106.name;
    L14:
        r105.getClass();
        if (Intrinsics.areEqual(r107, r100) == true) goto L19;
        r101 = r101 + 1;
    L19:
        if (r101 >= 0) goto L21;
        return;
    L21:
        if (r101 >= r103.size()) goto L27;
        ListProtector.remove(r103, r101);
        return;
    L27:
        return;
    L13:
        r107 = null;
        goto L14
    L18:
        r101 = -1;
        goto L19
    L5:
        r102 = false;
        goto L6
    }
}
