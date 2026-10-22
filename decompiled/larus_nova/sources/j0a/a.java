package j0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface a {

    /* JADX INFO: renamed from: j0a.a$a, reason: collision with other inner class name */
    public static final class C6380a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6380a f496836a = null;

        static {
            f496836a = new C6380a();
        }

        public C6380a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6380a) == true) goto L9;
            return false;
        L9:
            C6380a r101 = (C6380a) r100;
            return true;
        }

        public final int hashCode() {
            return 339691341;
        }

        public final String toString() {
            return "Deleted";
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f496837a = null;

        static {
            f496837a = new b();
        }

        public b() {
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
            return 1172817545;
        }

        public final String toString() {
            return "Failed";
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UserCreation f496838a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f496838a, ((c) r100).f496838a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f496838a.hashCode();
        }

        public final String toString() {
            return "Hit(creation=" + this.f496838a + ')';
        }

        public c(UserCreation r100) {
            Intrinsics.checkNotNullParameter(r100, "creation");
            this.f496838a = r100;
        }
    }
}
