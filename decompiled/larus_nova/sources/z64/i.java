package z64;

import com.bytedance.badger.data.ReportStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f570475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f570476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ReportStage f570477c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L17:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f570475a, r101.f570475a) == false) goto L16;
            if (this.f570476b != r101.f570476b) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L16;
            if (Intrinsics.areEqual(this.f570477c, r101.f570477c) == false) goto L16;
        L11:
            r102 = false;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            Throwable r100 = this.f570475a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            boolean r104 = this.f570476b;
            ?? r105 = r104;
            if (r104 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r103 + r105) * 31;
            ReportStage r107 = this.f570477c;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            return r106 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Failure(error=" + this.f570475a + ", isReportGenerated=" + this.f570476b + ", reportStage=" + this.f570477c + ")";
        }

        public /* synthetic */ a(Throwable r100, boolean r101) {
            this(r100, r101, ReportStage.FINAL);
        }

        public a(Throwable r100, boolean r101, ReportStage r102) {
            this.f570475a = r100;
            this.f570476b = r101;
            this.f570477c = r102;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f570478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f570479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f570480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ReportStage f570481d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L22:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L21;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f570478a, r101.f570478a) == false) goto L21;
            if (this.f570479b != r101.f570479b) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L21;
            if (this.f570480c != r101.f570480c) goto L16;
            boolean r103 = true;
        L17:
            if (r103 == false) goto L21;
            if (Intrinsics.areEqual(this.f570481d, r101.f570481d) == false) goto L21;
        L16:
            r103 = false;
            goto L17
        L11:
            r102 = false;
        L21:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public final int hashCode() {
            String r100 = this.f570478a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f570479b) * 31;
            boolean r104 = this.f570480c;
            ?? r105 = r104;
            if (r104 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r103 + r105) * 31;
            ReportStage r107 = this.f570481d;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            return r106 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(logId=" + this.f570478a + ", sceneId=" + this.f570479b + ", isFull=" + this.f570480c + ", reportStage=" + this.f570481d + ")";
        }

        public /* synthetic */ b(int r100) {
            this("", r100, true, ReportStage.FINAL);
        }

        public b(String r100, int r101, boolean r102, ReportStage r103) {
            this.f570478a = r100;
            this.f570479b = r101;
            this.f570480c = r102;
            this.f570481d = r103;
        }
    }

    public i() {
    }
}
