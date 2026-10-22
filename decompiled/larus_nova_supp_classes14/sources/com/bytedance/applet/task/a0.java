package com.bytedance.applet.task;

import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.navigation.api.NavigationServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 implements il9.c {
    public a0() {
    }

    public final void b(kl9.u r1, kl9.u r2) {
    }

    public final void a(List<kl9.u> r13) {
        Intrinsics.checkNotNullParameter(r13, "tasks");
        int r0 = com.larus.navigation.api.c.a;
        StringBuilder r1 = new StringBuilder("legacyTaskObserver: fired tasks=");
        r1.append(r13.size());
        r1.append(" details=[");
        List<kl9.u> r14 = r13;
        r1.append(CollectionsKt.joinToString$default(r14, null, null, null, 0, null, new y(), 31, null));
        r1.append(']');
        com.larus.navigation.api.c.d("nav_multitask_map", r1.toString());
        String r2 = NavigationMultitaskCard.d;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        com.larus.navigation.api.c.d("nav_multitask_map", "legacyTaskObserver: skip preempt — new card has no active session");
        return;
    L12:
        ArrayList r5 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L22;
        Object r6 = r15.next();
        if (((kl9.u) r6).g != TaskStatus.RUNNING) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L14;
        r5.add(r6);
        goto L14
    L18:
        r7 = false;
        goto L19
    L22:
        if (r5.isEmpty() == false) goto L25;
        com.larus.navigation.api.c.d("nav_multitask_map", "legacyTaskObserver: skip preempt — no RUNNING legacy (all tasks non-RUNNING)");
        return;
    L25:
        int r16 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "legacyTaskObserver: preempting — RUNNING legacy detected (activeIds=[" + CollectionsKt.joinToString$default(r5, null, null, null, 0, null, new z(), 31, null) + "], myTaskId=" + r2 + "), stopping SDK + removing own card + publishing flow.onMapNavigationCanceled to new FE");
        NavigationServiceDelegate.b.a("preempted_by_legacy");
        NavigationMultitaskCard.a.getClass();
        Intrinsics.checkNotNullParameter("preempted_by_legacy", "reason");
        NavigationMultitaskCard.j("preempted_by_legacy", null);
        Lazy r3 = l3.d.a;
        l3.d.c(new l3.a("flow.onMapNavigationCanceled", null, 6));
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
