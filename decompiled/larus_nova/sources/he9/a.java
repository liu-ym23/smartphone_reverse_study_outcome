package he9;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public interface a {

    /* JADX INFO: renamed from: he9.a$a, reason: collision with other inner class name */
    public static final class C6134a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f484894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f484895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f484896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f484897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f484898e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f484899f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f484900g;

        /* JADX INFO: renamed from: he9.a$a$a, reason: collision with other inner class name */
        public static final class C6135a {
        }

        static {
        }

        public final String toString() {
            return "FrameExtra(source=" + Arrays.toString(this.f484894a) + ", extra=" + this.f484895b + ", silent=" + this.f484896c + ", sentenceId=" + this.f484897d + ", queryRound=" + this.f484898e + ", replyRound=" + this.f484899f + ", taskId=" + this.f484900g + ')';
        }

        public final int a() {
            d0 r100 = this.f484895b;
            if (r100 != null) goto L5;
            return 0;
        L5:
            return sf9.a.b(r100, "status", 0);
        }

        public final int hashCode() {
            byte[] r100 = this.f484894a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = Arrays.hashCode(r100);
        L6:
            int r103 = r102 * 31;
            d0 r104 = this.f484895b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            if (this.f484896c == false) goto L12;
            int r106 = 1231;
        L14:
            return ((r105 + r106) * 31) + this.f484897d.hashCode();
        L12:
            r106 = 1237;
            goto L14
        L5:
            r102 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6134a) == true) goto L8;
            return false;
        L8:
            byte[] r101 = this.f484894a;
            if (r101 == null) goto L17;
            byte[] r102 = ((C6134a) r100).f484894a;
            if (r102 != null) goto L14;
            return false;
        L14:
            if (Arrays.equals(r101, r102) == true) goto L19;
            return false;
        L19:
            C6134a r103 = (C6134a) r100;
            if (Intrinsics.areEqual(this.f484895b, r103.f484895b) == true) goto L23;
            return false;
        L23:
            if (this.f484896c == r103.f484896c) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.f484897d, r103.f484897d) == true) goto L28;
            return false;
        L28:
            return true;
        L17:
            if (((C6134a) r100).f484894a == null) goto L19;
            return false;
        }

        public C6134a(byte[] r100, d0 r101, boolean r102, String r103, long r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r103, "sentenceId");
            Intrinsics.checkNotNullParameter(r105, "replyRound");
            Intrinsics.checkNotNullParameter(r106, DBDefinition.TASK_ID);
            this.f484894a = r100;
            this.f484895b = r101;
            this.f484896c = r102;
            this.f484897d = r103;
            this.f484898e = r104;
            this.f484899f = r105;
            this.f484900g = r106;
        }
    }

    c a();

    ge9.d.c b();
}
