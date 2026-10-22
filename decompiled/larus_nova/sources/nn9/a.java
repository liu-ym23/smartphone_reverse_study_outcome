package nn9;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public interface a {

    /* JADX INFO: renamed from: nn9.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC6944a {

        /* JADX INFO: renamed from: nn9.a$a$a, reason: collision with other inner class name */
        public static final class C6945a extends AbstractC6944a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f519678a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C6945a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f519678a, ((C6945a) r100).f519678a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f519678a.hashCode();
            }

            public final String toString() {
                return "Failed(reason=" + this.f519678a + ')';
            }

            public C6945a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f519678a = r100;
            }
        }

        /* JADX INFO: renamed from: nn9.a$a$b */
        public static final class b extends AbstractC6944a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f519679a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f519679a, ((b) r100).f519679a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f519679a.hashCode();
            }

            public final String toString() {
                return "Processing(taskId=" + this.f519679a + ')';
            }

            public b(String r100) {
                Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
                this.f519679a = r100;
            }
        }

        /* JADX INFO: renamed from: nn9.a$a$c */
        public static final class c extends AbstractC6944a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f519680a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f519680a, ((c) r100).f519680a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f519680a.hashCode();
            }

            public final String toString() {
                return "Ready(url=" + this.f519680a + ')';
            }

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "url");
                this.f519680a = r100;
            }
        }

        public AbstractC6944a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: nn9.a$b$a, reason: collision with other inner class name */
        public static final class C6946a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f519681a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C6946a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f519681a, ((C6946a) r100).f519681a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f519681a.hashCode();
            }

            public final String toString() {
                return "Failed(reason=" + this.f519681a + ')';
            }

            public C6946a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f519681a = r100;
            }
        }

        /* JADX INFO: renamed from: nn9.a$b$b, reason: collision with other inner class name */
        public static final class C6947b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C6947b f519682a = null;

            static {
                f519682a = new C6947b();
            }

            public C6947b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f519683a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f519683a, ((c) r100).f519683a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f519683a.hashCode();
            }

            public final String toString() {
                return "Ready(url=" + this.f519683a + ')';
            }

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "url");
                this.f519683a = r100;
            }
        }

        public b() {
        }
    }

    Object a(String r100, Continuation<? super b> r101);
}
