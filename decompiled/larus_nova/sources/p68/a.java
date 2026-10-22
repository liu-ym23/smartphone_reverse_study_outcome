package p68;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: p68.a$a, reason: collision with other inner class name */
    public static final class C7157a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f527919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f527920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f527921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f527922d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7157a) == true) goto L8;
            return false;
        L8:
            C7157a r101 = (C7157a) r100;
            if (Intrinsics.areEqual(this.f527919a, r101.f527919a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f527920b, r101.f527920b) == true) goto L15;
            return false;
        L15:
            if (this.f527921c == r101.f527921c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f527922d, r101.f527922d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f527919a.hashCode() * 31) + this.f527920b.hashCode()) * 31;
            long r101 = this.f527921c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Integer r103 = this.f527922d;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "AsrFailure(taskId=" + this.f527919a + ", recordPath=" + this.f527920b + ", duration=" + this.f527921c + ", errorCode=" + this.f527922d + ')';
        }

        public C7157a(String r100, String r101, long r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "recordPath");
            this.f527919a = r100;
            this.f527920b = r101;
            this.f527921c = r102;
            this.f527922d = r103;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f527923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f527924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f527925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f527926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f527927e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f527923a, r101.f527923a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f527924b, r101.f527924b) == true) goto L15;
            return false;
        L15:
            if (this.f527925c == r101.f527925c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f527926d, r101.f527926d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f527927e, r101.f527927e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f527923a.hashCode() * 31) + this.f527924b.hashCode()) * 31;
            long r101 = this.f527925c;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f527926d.hashCode()) * 31;
            String r103 = this.f527927e;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "AsrSuccess(taskId=" + this.f527923a + ", content=" + this.f527924b + ", duration=" + this.f527925c + ", vid=" + this.f527926d + ", logId=" + this.f527927e + ')';
        }

        public b(String r100, String r101, long r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r103, "vid");
            this.f527923a = r100;
            this.f527924b = r101;
            this.f527925c = r102;
            this.f527926d = r103;
            this.f527927e = r104;
        }
    }

    public a() {
    }
}
