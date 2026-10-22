package eub;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadDeleteReason;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskEventOrigin;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.f f474121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MmMinutesFileUploadTaskEventOrigin f474122c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f474120a, r101.f474120a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474121b, r101.f474121b) == true) goto L15;
            return false;
        L15:
            if (this.f474122c == r101.f474122c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f474120a.hashCode() * 31) + this.f474121b.hashCode()) * 31) + this.f474122c.hashCode();
        }

        public final String toString() {
            return "Added(taskId=" + this.f474120a + ", param=" + this.f474121b + ", origin=" + this.f474122c + ')';
        }

        public a(String r100, eub.f r101, MmMinutesFileUploadTaskEventOrigin r102) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, PlayerResolution.SDKKEY.ORIGIN);
            this.f474120a = r100;
            this.f474121b = r101;
            this.f474122c = r102;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MmMinutesFileUploadDeleteReason f474124b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f474123a, r101.f474123a) == true) goto L12;
            return false;
        L12:
            if (this.f474124b == r101.f474124b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f474123a.hashCode() * 31) + this.f474124b.hashCode();
        }

        public final String toString() {
            return "Deleted(taskId=" + this.f474123a + ", reason=" + this.f474124b + ')';
        }

        public b(String r100, MmMinutesFileUploadDeleteReason r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f474123a = r100;
            this.f474124b = r101;
        }
    }

    /* JADX INFO: renamed from: eub.c$c, reason: collision with other inner class name */
    public static final class C5821c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5821c f474125a = null;

        static {
            f474125a = new C5821c();
        }

        public C5821c() {
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.f f474127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eub.g f474128c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f474126a, r101.f474126a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474127b, r101.f474127b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f474128c, r101.f474128c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f474126a.hashCode() * 31) + this.f474127b.hashCode()) * 31) + this.f474128c.hashCode();
        }

        public final String toString() {
            return "PrepareSucceeded(taskId=" + this.f474126a + ", param=" + this.f474127b + ", status=" + this.f474128c + ')';
        }

        public d(String r100, eub.f r101, eub.g r102) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, "status");
            this.f474126a = r100;
            this.f474127b = r101;
            this.f474128c = r102;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474129a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f474129a, ((e) r100).f474129a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f474129a.hashCode();
        }

        public final String toString() {
            return "Prepared(userId=" + this.f474129a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f474129a = r100;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.g f474131b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f474130a, r101.f474130a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474131b, r101.f474131b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f474130a.hashCode() * 31) + this.f474131b.hashCode();
        }

        public final String toString() {
            return "ProgressUpdated(taskId=" + this.f474130a + ", status=" + this.f474131b + ')';
        }

        public f(String r100, eub.g r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "status");
            this.f474130a = r100;
            this.f474131b = r101;
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.f f474133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eub.b f474134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final eub.g f474135d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f474132a, r101.f474132a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474133b, r101.f474133b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f474134c, r101.f474134c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f474135d, r101.f474135d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f474132a.hashCode() * 31) + this.f474133b.hashCode()) * 31) + this.f474134c.hashCode()) * 31) + this.f474135d.hashCode();
        }

        public final String toString() {
            return "UploadFailed(taskId=" + this.f474132a + ", param=" + this.f474133b + ", error=" + this.f474134c + ", status=" + this.f474135d + ')';
        }

        public g(String r100, eub.f r101, eub.b r102, eub.g r103) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, "error");
            Intrinsics.checkNotNullParameter(r103, "status");
            this.f474132a = r100;
            this.f474133b = r101;
            this.f474134c = r102;
            this.f474135d = r103;
        }
    }

    public static final class h extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.f f474137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MmMinutesFileUploadDeleteReason f474138c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f474136a, r101.f474136a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474137b, r101.f474137b) == true) goto L15;
            return false;
        L15:
            if (this.f474138c == r101.f474138c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f474136a.hashCode() * 31) + this.f474137b.hashCode()) * 31) + this.f474138c.hashCode();
        }

        public final String toString() {
            return "UploadItemDeleted(taskId=" + this.f474136a + ", param=" + this.f474137b + ", reason=" + this.f474138c + ')';
        }

        public h(String r100, eub.f r101, MmMinutesFileUploadDeleteReason r102) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.f474136a = r100;
            this.f474137b = r101;
            this.f474138c = r102;
        }
    }

    public static final class i extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f474139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eub.f f474140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eub.g f474141c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f474139a, r101.f474139a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474140b, r101.f474140b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f474141c, r101.f474141c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f474139a.hashCode() * 31) + this.f474140b.hashCode()) * 31) + this.f474141c.hashCode();
        }

        public final String toString() {
            return "UploadSuccess(taskId=" + this.f474139a + ", param=" + this.f474140b + ", status=" + this.f474141c + ')';
        }

        public i(String r100, eub.f r101, eub.g r102) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, "status");
            this.f474139a = r100;
            this.f474140b = r101;
            this.f474141c = r102;
        }
    }

    public c() {
    }
}
