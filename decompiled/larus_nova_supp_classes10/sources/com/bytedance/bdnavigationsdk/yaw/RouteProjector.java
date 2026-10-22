package com.bytedance.bdnavigationsdk.yaw;

import com.bytedance.bdnavigationsdk.network.route.i;
import com.bytedance.bdnavigationsdk.pojo.ProjectionResult;
import com.bytedance.bdnavigationsdk.pojo.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RouteProjector {
    public final List<d> a;
    public final t84.c b;
    public final List<b> c;
    public int d;
    public final List<ProjectionResult> e;
    public final List<ProjectionResult> f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdnavigationsdk/yaw/RouteProjector$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "GO_BACK", "DIST_FARAWAY", "CROSS_CORNER", "PENDING_HOLD", "PENDING_CONFIRMED", "TUNNEL_ACCEPT", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Decision extends Enum<Decision> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Decision[] $VALUES = null;
        public static final Decision CROSS_CORNER = null;
        public static final Decision DIST_FARAWAY = null;
        public static final Decision GO_BACK = null;
        public static final Decision NORMAL = null;
        public static final Decision PENDING_CONFIRMED = null;
        public static final Decision PENDING_HOLD = null;
        public static final Decision TUNNEL_ACCEPT = null;

        public static EnumEntries<Decision> getEntries() {
            return $ENTRIES;
        }

        static {
            Decision r0 = new Decision("NORMAL", 0);
            NORMAL = r0;
            Decision r1 = new Decision("GO_BACK", 1);
            GO_BACK = r1;
            Decision r3 = new Decision("DIST_FARAWAY", 2);
            DIST_FARAWAY = r3;
            Decision r5 = new Decision("CROSS_CORNER", 3);
            CROSS_CORNER = r5;
            Decision r7 = new Decision("PENDING_HOLD", 4);
            PENDING_HOLD = r7;
            Decision r9 = new Decision("PENDING_CONFIRMED", 5);
            PENDING_CONFIRMED = r9;
            Decision r11 = new Decision("TUNNEL_ACCEPT", 6);
            TUNNEL_ACCEPT = r11;
            Decision[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            $VALUES = r13;
            $ENTRIES = EnumEntriesKt.enumEntries(r13);
        }

        public static Decision[] values() {
            return (Decision[]) $VALUES.clone();
        }

        public static Decision valueOf(String r1) {
            return (Decision) r27.a.a(Decision.class, r1);
        }

        public Decision(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "LegInfo(index=" + this.a + ", stepStartIndex=" + this.b + ", stepEndIndex=" + this.c + ", segmentStartIndex=" + this.d + ", segmentEndIndex=" + this.e + ")";
        }

        public b(int r1, int r2, int r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProjectionResult.Position.values().length];
            r0[ProjectionResult.Position.BEFORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ProjectionResult.Position.ON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ProjectionResult.Position.AFTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ProjectionResult.Position.DEFAULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final ProjectionResult c() {
        if (((ArrayList) this.e).isEmpty() == false) goto L6;
        return null;
    L6:
        List<ProjectionResult> r0 = this.e;
        return (ProjectionResult) ListProtector.get(r0, ((ArrayList) r0).size() - 1);
    }

    public static ProjectionResult d(ProjectionResult r12, ProjectionResult r13) {
        com.bytedance.bdnavigationsdk.pojo.a r1 = r13.b;
        com.bytedance.bdnavigationsdk.pojo.a r2 = r13.c;
        com.bytedance.bdnavigationsdk.pojo.a r3 = r13.d;
        int r4 = r13.e;
        int r5 = r13.f;
        int r0 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r6 = r12.a;
        Intrinsics.checkNotNull(r6);
        com.bytedance.bdnavigationsdk.pojo.a r7 = r13.d;
        Intrinsics.checkNotNull(r7);
        return ProjectionResult.a(r12, r1, r2, r3, r4, r5, w84.b.a(r6, r7), r13.h, r13.i, r12.l, 1537);
    }

    public final void a(ProjectionResult r3, ProjectionResult r4) {
    L3:
        if (((ArrayList) this.f).size() < 10) goto L5;
        CollectionsKt.removeFirst(this.f);
        goto L3
    L5:
        ((ArrayList) this.f).add(r3);
    L7:
        if (((ArrayList) this.e).size() < 10) goto L9;
        CollectionsKt.removeFirst(this.e);
        goto L7
    L9:
        ((ArrayList) this.e).add(r4);
        this.d = r4.e;
    }

    public final float b(ProjectionResult r3, ProjectionResult r4) {
        return Math.abs(((((d) ListProtector.get(this.a, r3.e)).g + r3.h) - ((d) ListProtector.get(this.a, r4.e)).g) - r4.h);
    }

    public RouteProjector(List<d> r9, t84.c r10, List<i> r11) {
        Intrinsics.checkNotNullParameter(r9, "plannedRoute");
        Intrinsics.checkNotNullParameter(r10, "thresholds");
        Intrinsics.checkNotNullParameter(r11, "routeLegs");
        this.a = r9;
        this.b = r10;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
        int r14 = 0;
        int r1 = 0;
    L4:
        if (r13.hasNext() == false) goto L18;
        int r6 = r1 + 1;
        i r0 = (i) r13.next();
        int r4 = r14;
    L7:
        if (r4 >= this.a.size()) goto L11;
        if (((d) ListProtector.get(this.a, r4)).d >= r0.a) goto L11;
        r4 = r4 + 1;
    L11:
        r14 = r4;
    L13:
        if (r14 >= this.a.size()) goto L17;
        if (((d) ListProtector.get(this.a, r14)).d >= r0.b) goto L17;
        r14 = r14 + 1;
    L17:
        r12.add(new b(r1, r0.a, r0.b, r4, r14));
        r1 = r6;
        goto L4
    L18:
        this.c = r12;
        this.e = new ArrayList();
        this.f = new ArrayList();
    }
}
