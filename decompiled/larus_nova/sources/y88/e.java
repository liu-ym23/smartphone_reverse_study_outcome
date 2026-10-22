package y88;

import com.larus.avlink.business.api.DoraAvlinkSessionState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f566921a = null;

        static {
            f566921a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 1779673730;
        }

        public final String toString() {
            return "ClientSummonNotice";
        }

        public a() {
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f566922a = null;

        static {
            f566922a = new b();
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
            return -1796697296;
        }

        public final String toString() {
            return "CompanionModeStarted";
        }

        public b() {
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566923a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f566923a == ((c) r100).f566923a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f566923a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ConversationChanged(inConversation=" + this.f566923a + ')';
        }

        public c(boolean r100) {
            this.f566923a = r100;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566924a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f566924a == ((d) r100).f566924a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f566924a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "LiveAiModeChanged(inLiveAiMode=" + this.f566924a + ')';
        }

        public d(boolean r100) {
            this.f566924a = r100;
        }
    }

    /* JADX INFO: renamed from: y88.e$e, reason: collision with other inner class name */
    public static final class C8315e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566925a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8315e) == true) goto L9;
            return false;
        L9:
            if (this.f566925a == ((C8315e) r100).f566925a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f566925a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "RadioEnded(ended=" + this.f566925a + ')';
        }

        public C8315e(boolean r100) {
            this.f566925a = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraAvlinkSessionState f566926a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f566926a == ((f) r100).f566926a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f566926a.hashCode();
        }

        public final String toString() {
            return "StateChanged(current=" + this.f566926a + ')';
        }

        public f(DoraAvlinkSessionState r100) {
            Intrinsics.checkNotNullParameter(r100, "current");
            this.f566926a = r100;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraAvlinkSessionState f566928b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f566927a == r101.f566927a) goto L12;
            return false;
        L12:
            if (this.f566928b == r101.f566928b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f566927a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f566928b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "TimeoutTimerChanged(active=" + this.f566927a + ", current=" + this.f566928b + ')';
        }

        public g(boolean r100, DoraAvlinkSessionState r101) {
            Intrinsics.checkNotNullParameter(r101, "current");
            this.f566927a = r100;
            this.f566928b = r101;
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f566929a = null;

        static {
            f566929a = new h();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            h r101 = (h) r100;
            return true;
        }

        public final int hashCode() {
            return -539036829;
        }

        public final String toString() {
            return "VuiReset";
        }

        public h() {
        }
    }

    public e() {
    }
}
