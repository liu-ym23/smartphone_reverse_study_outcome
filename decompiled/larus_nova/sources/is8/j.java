package is8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495683a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495683a, ((a) r100).f495683a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495683a.hashCode();
        }

        public final String toString() {
            return "Cancelled(reason=" + this.f495683a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f495683a = r100;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f495684a = null;

        static {
            f495684a = new b();
        }

        public b() {
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AuthMode f495685a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f495685a == ((c) r100).f495685a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495685a.hashCode();
        }

        public final String toString() {
            return "CredentialPreparing(authMode=" + this.f495685a + ')';
        }

        public c(AuthMode r100) {
            Intrinsics.checkNotNullParameter(r100, "authMode");
            this.f495685a = r100;
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final is8.d f495686a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495686a, ((d) r100).f495686a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495686a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f495686a + ')';
        }

        public d(is8.d r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f495686a = r100;
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f495687a;

        public e() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495687a, ((e) r100).f495687a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f495687a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Preprocessing(progress=" + this.f495687a + ')';
        }

        public e(int r100) {
            this.f495687a = null;
        }
    }

    public static final class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final is8.a f495689b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f495688a, r101.f495688a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f495689b, r101.f495689b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f495688a.hashCode() * 31) + this.f495689b.hashCode();
        }

        public final String toString() {
            return "Registering(remoteKey=" + this.f495688a + ", route=" + this.f495689b + ')';
        }

        public f(String r100, is8.a r101) {
            Intrinsics.checkNotNullParameter(r100, "remoteKey");
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
            this.f495688a = r100;
            this.f495689b = r101;
        }
    }

    public static final class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final is8.h f495690a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495690a, ((g) r100).f495690a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495690a.hashCode();
        }

        public final String toString() {
            return "Success(result=" + this.f495690a + ')';
        }

        public g(is8.h r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f495690a = r100;
        }
    }

    public static final class h extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f495691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final is8.a f495692b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f495691a == r101.f495691a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f495692b, r101.f495692b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f495691a * 31) + this.f495692b.hashCode();
        }

        public final String toString() {
            return "Uploading(progress=" + this.f495691a + ", route=" + this.f495692b + ')';
        }

        public h(int r100, is8.a r101) {
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
            this.f495691a = r100;
            this.f495692b = r101;
        }
    }

    public j() {
    }
}
