package com.bytedance.applet.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class NavigationCardSessionState {
    public long a;
    public a b;
    public Phase c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/applet/task/NavigationCardSessionState$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAITING_FOR_START", "STARTING", "ACTIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase ACTIVE = null;
        public static final Phase IDLE = null;
        public static final Phase STARTING = null;
        public static final Phase WAITING_FOR_START = null;
        public static final /* synthetic */ Phase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Phase> getEntries() {
            return b;
        }

        static {
            Phase r0 = new Phase("IDLE", 0);
            IDLE = r0;
            Phase r1 = new Phase("WAITING_FOR_START", 1);
            WAITING_FOR_START = r1;
            Phase r3 = new Phase("STARTING", 2);
            STARTING = r3;
            Phase r5 = new Phase("ACTIVE", 3);
            ACTIVE = r5;
            Phase[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Phase[] values() {
            return (Phase[]) a.clone();
        }

        public static Phase valueOf(String r1) {
            return (Phase) r27.a.a(Phase.class, r1);
        }

        public Phase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "Owner(generation=" + this.a + ", navigationId=" + this.b + ')';
        }

        public a(long r1, String r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public NavigationCardSessionState() {
        this.c = Phase.IDLE;
    }

    public final synchronized boolean a(a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "expected");     // Catch: Throwable -> L6
        boolean r3 = Intrinsics.areEqual(this.b, r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
