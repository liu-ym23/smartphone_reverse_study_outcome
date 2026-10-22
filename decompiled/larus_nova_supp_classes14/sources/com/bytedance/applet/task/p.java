package com.bytedance.applet.task;

import com.google.gson.JsonObject;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kl9.l0;
import kl9.p0;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static String a;
    public static q b;
    public static final b c = null;
    public static a d;
    public static boolean e;

    public static final class a {
        public final String a;
        public final String b;
        public final Integer c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "UpdateData(title=" + this.a + ", content=" + this.b + ", customIconId=" + this.c + ", iconUrl=" + this.d + ')';
        }

        public a(String r2, String r3, Integer r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b implements il9.d {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TaskStatus.values().length];
                r0[TaskStatus.CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b() {
        }

        public final void a(String r4, TaskDisplayStatus r5) {
            Intrinsics.checkNotNullParameter(r4, "taskId");
            Intrinsics.checkNotNullParameter(r5, "taskDisplayStatus");
            FLogger.a.i("NavigationControlTask", "onRequestTaskDisplayStatusChange: " + r4 + ", " + r5);
        }

        public final void b(String r5, TaskStatus r6) {
            Intrinsics.checkNotNullParameter(r5, "taskId");
            Intrinsics.checkNotNullParameter(r6, "taskStatus");
            FLogger r0 = FLogger.a;
            r0.i("NavigationControlTask", "onRequestTaskStatusChange: " + r5 + ", " + r6);
            if (Intrinsics.areEqual(r5, p.a) == true) goto L7;
            r0.i("NavigationControlTask", "onRequestTaskStatusChange: " + r5 + " is not our task");
            return;
        L7:
            if (a.a[r6.ordinal()] != 1) goto L9;
            r0.i("NavigationControlTask", "cancelNavigation");
            Lazy r7 = l3.d.a;
            l3.d.c(new l3.a("flow.onNavigationCanceled", null, 6));
            return;
        L9:
            r0.e("NavigationControlTask", "onRequestTaskStatusChange: Unknown status " + r6);
        }

        public final boolean c(kl9.u r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "task");
            Intrinsics.checkNotNullParameter(r6, "currentPage");
            FLogger r7 = FLogger.a;
            r7.i("NavigationControlTask", "onInterceptTaskClick: " + r5);
            if (Intrinsics.areEqual(r5.a, p.a) == true) goto L6;
            r7.i("NavigationControlTask", "onInterceptTaskClick: " + r5 + " is not our task");
            return false;
        L6:
            r7.i("NavigationControlTask", "openNavigationDetail");
            Lazy r8 = l3.d.a;
            JsonObject r9 = new JsonObject();
            r9.addProperty("pageId", "ll_nav_detail");
            JsonObject r10 = new JsonObject();
            r10.addProperty("from", "multi_task");
            Unit r0 = Unit.INSTANCE;
            r9.add("pageData", r10);
            l3.d.c(new l3.a("flow.onOpenPageDemand", r9, 4));
            return true;
        }
    }

    public p() {
    }

    static {
        c = new b();
        e = true;
    }

    public static void c() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NavigationControlTask$updateNavigationToStop$1(null), 3, null);
    }

    public static final void a(boolean r10) {
        if (e == r10) goto L23;
        e = r10;
        String r0 = a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L24;
        FLogger.a.i("NavigationControlTask", "visible changed to " + r10);
        il9.a r11 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r11 == null) goto L25;
        String r2 = a;
        if (r2 != null) goto L18;
        r2 = "";
    L18:
        if (e == false) goto L20;
        TaskDisplayStatus r3 = TaskDisplayStatus.DISPLAYED;
    L21:
        r11.P(new p0(r2, null, new l0(null, r3, null, null, 4093)), false);
        return;
    L20:
        r3 = TaskDisplayStatus.HIDDEN;
        goto L21
    L25:
        return;
    L24:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    public static void b(String r10, String r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "title");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NavigationControlTask$updateNavigation$1(r10, r11, r12, r13, null), 3, null);
    }
}
