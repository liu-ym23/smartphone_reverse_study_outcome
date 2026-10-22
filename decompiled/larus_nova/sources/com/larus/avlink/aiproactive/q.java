package com.larus.avlink.aiproactive;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface q {

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f291598a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f291598a, ((a) r100).f291598a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f291598a.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.f291598a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f291598a = r100;
        }
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f291599a = null;

        static {
            f291599a = new b();
        }

        public b() {
        }
    }

    public static final class c implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f291600a = null;

        static {
            f291600a = new c();
        }

        public c() {
        }
    }

    public static final class d implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<t88.n> f291601a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f291601a, ((d) r100).f291601a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f291601a.hashCode();
        }

        public final String toString() {
            return "Success(taskList=" + this.f291601a + ')';
        }

        public d(List<t88.n> r100) {
            Intrinsics.checkNotNullParameter(r100, "taskList");
            this.f291601a = r100;
        }
    }
}
