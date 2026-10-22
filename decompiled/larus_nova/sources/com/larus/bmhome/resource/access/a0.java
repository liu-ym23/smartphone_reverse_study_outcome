package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a0 {

    public static final class a extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResourceCancelReason f313615a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f313615a == ((a) r100).f313615a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313615a.hashCode();
        }

        public final String toString() {
            return "Cancelled(reason=" + this.f313615a + ')';
        }

        public a(ResourceCancelReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f313615a = r100;
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f313616a = null;

        static {
            f313616a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return -486198261;
        }

        public final String toString() {
            return "Created";
        }

        public b() {
        }
    }

    public static final class c extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f313617a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313617a, ((c) r100).f313617a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313617a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f313617a + ')';
        }

        public c(r r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f313617a = r100;
        }
    }

    public static final class d extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0 f313618a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313618a, ((d) r100).f313618a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313618a.hashCode();
        }

        public final String toString() {
            return "Ready(artifact=" + this.f313618a + ')';
        }

        public d(f0 r100) {
            Intrinsics.checkNotNullParameter(r100, "artifact");
            this.f313618a = r100;
        }
    }

    public static final class e extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResourcePhase f313619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f313620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j0 f313621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f313622d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f313619a == r101.f313619a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f313620b, r101.f313620b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f313621c, r101.f313621c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f313622d, r101.f313622d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f313619a.hashCode() * 31) + this.f313620b.hashCode()) * 31;
            j0 r101 = this.f313621c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f313622d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Running(stage=" + this.f313619a + ", nodeKey=" + this.f313620b + ", resourceInput=" + this.f313621c + ", attributes=" + this.f313622d + ')';
        }

        public e(ResourcePhase r100, String r101, j0 r102, Map<String, String> r103) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            Intrinsics.checkNotNullParameter(r101, "nodeKey");
            Intrinsics.checkNotNullParameter(r103, "attributes");
            this.f313619a = r100;
            this.f313620b = r101;
            this.f313621c = r102;
            this.f313622d = r103;
        }
    }

    public static final class f extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f313623a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f313623a == ((f) r100).f313623a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f313623a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Uploading(progress=" + this.f313623a + ')';
        }

        public f(long r100) {
            this.f313623a = r100;
        }
    }

    public a0() {
    }
}
