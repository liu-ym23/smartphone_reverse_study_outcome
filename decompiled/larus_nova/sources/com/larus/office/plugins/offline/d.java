package com.larus.office.plugins.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.office.plugins.offline.a f363086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f363087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f363088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f363089d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f363090e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.larus.office.plugins.offline.b f363091f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f363086a, r101.f363086a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363087b, r101.f363087b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f363088c, r101.f363088c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f363089d, r101.f363089d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f363090e, r101.f363090e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f363091f, r101.f363091f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f363086a.hashCode() * 31;
            String r101 = this.f363087b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f363088c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((((r104 + r102) * 31) + this.f363089d.hashCode()) * 31) + this.f363090e.hashCode()) * 31) + this.f363091f.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CompensateCreate(snapshot=" + this.f363086a + ", realToken=" + this.f363087b + ", useMessageContent=" + this.f363088c + ", failReason=" + this.f363089d + ", trigger=" + this.f363090e + ", state=" + this.f363091f + ')';
        }

        public a(com.larus.office.plugins.offline.a r100, String r101, Boolean r102, String r103, String r104, com.larus.office.plugins.offline.b r105) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r103, "failReason");
            Intrinsics.checkNotNullParameter(r104, "trigger");
            Intrinsics.checkNotNullParameter(r105, "state");
            this.f363086a = r100;
            this.f363087b = r101;
            this.f363088c = r102;
            this.f363089d = r103;
            this.f363090e = r104;
            this.f363091f = r105;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.office.plugins.offline.a f363092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f363093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f363094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f363095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.larus.office.plugins.offline.b f363096e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f363092a, r101.f363092a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363093b, r101.f363093b) == true) goto L15;
            return false;
        L15:
            if (this.f363094c == r101.f363094c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f363095d, r101.f363095d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f363096e, r101.f363096e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f363092a.hashCode() * 31) + this.f363093b.hashCode()) * 31;
            if (this.f363094c == false) goto L5;
            int r101 = 1231;
        L7:
            return ((((r100 + r101) * 31) + this.f363095d.hashCode()) * 31) + this.f363096e.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "FormalCreate(snapshot=" + this.f363092a + ", realToken=" + this.f363093b + ", useMessageContent=" + this.f363094c + ", trigger=" + this.f363095d + ", state=" + this.f363096e + ')';
        }

        public b(com.larus.office.plugins.offline.a r100, String r101, String r102, com.larus.office.plugins.offline.b r103) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r101, "realToken");
            Intrinsics.checkNotNullParameter(r102, "trigger");
            Intrinsics.checkNotNullParameter(r103, "state");
            this.f363092a = r100;
            this.f363093b = r101;
            this.f363094c = false;
            this.f363095d = r102;
            this.f363096e = r103;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f363097a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f363097a, ((c) r100).f363097a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f363097a.hashCode();
        }

        public final String toString() {
            return "Noop(reason=" + this.f363097a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f363097a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.office.plugins.offline.d$d, reason: collision with other inner class name */
    public static final class C4447d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.office.plugins.offline.a f363098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f363099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f363100c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4447d) == true) goto L8;
            return false;
        L8:
            C4447d r101 = (C4447d) r100;
            if (Intrinsics.areEqual(this.f363098a, r101.f363098a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363099b, r101.f363099b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f363100c, r101.f363100c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f363098a.hashCode() * 31;
            String r101 = this.f363099b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f363100c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RetryOpen(snapshot=" + this.f363098a + ", realToken=" + this.f363099b + ", trigger=" + this.f363100c + ')';
        }

        public C4447d(com.larus.office.plugins.offline.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter("offline_create_fail", "trigger");
            this.f363098a = r100;
            this.f363099b = r101;
            this.f363100c = "offline_create_fail";
        }
    }

    public d() {
    }
}
