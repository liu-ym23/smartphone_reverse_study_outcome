package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.doc.impl.offline.a f331245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f331246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f331247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.larus.doc.impl.offline.b f331248d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f331245a, r101.f331245a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f331246b, r101.f331246b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f331247c, r101.f331247c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f331248d, r101.f331248d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f331245a.hashCode() * 31) + this.f331246b.hashCode()) * 31) + this.f331247c.hashCode()) * 31) + this.f331248d.hashCode();
        }

        public final String toString() {
            return "CompensateCreate(snapshot=" + this.f331245a + ", failReason=" + this.f331246b + ", trigger=" + this.f331247c + ", createDocByMessageState=" + this.f331248d + ')';
        }

        public a(com.larus.doc.impl.offline.a r100, String r101, String r102, com.larus.doc.impl.offline.b r103) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r101, "failReason");
            Intrinsics.checkNotNullParameter(r102, "trigger");
            Intrinsics.checkNotNullParameter(r103, "createDocByMessageState");
            this.f331245a = r100;
            this.f331246b = r101;
            this.f331247c = r102;
            this.f331248d = r103;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.doc.impl.offline.a f331249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f331250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.doc.impl.offline.b f331251c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f331249a, r101.f331249a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f331250b, r101.f331250b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f331251c, r101.f331251c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f331249a.hashCode() * 31) + this.f331250b.hashCode()) * 31) + this.f331251c.hashCode();
        }

        public final String toString() {
            return "FormalCreate(snapshot=" + this.f331249a + ", trigger=" + this.f331250b + ", createDocByMessageState=" + this.f331251c + ')';
        }

        public b(com.larus.doc.impl.offline.a r100, String r101, com.larus.doc.impl.offline.b r102) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r101, "trigger");
            Intrinsics.checkNotNullParameter(r102, "createDocByMessageState");
            this.f331249a = r100;
            this.f331250b = r101;
            this.f331251c = r102;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f331252a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f331252a, ((c) r100).f331252a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f331252a.hashCode();
        }

        public final String toString() {
            return "Noop(reason=" + this.f331252a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f331252a = r100;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f331253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f331254b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f331253a, r101.f331253a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f331254b, r101.f331254b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f331253a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f331254b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "RetryOpen(docRealToken=" + this.f331253a + ", reason=" + this.f331254b + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter("offline_create_fail", "reason");
            this.f331253a = r100;
            this.f331254b = "offline_create_fail";
        }
    }

    public e() {
    }
}
