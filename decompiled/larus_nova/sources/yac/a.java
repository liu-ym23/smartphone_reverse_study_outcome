package yac;

import com.ss.android.lark.voiceinput.api.data.model.VoiceRecordFailureReason;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface a {

    /* JADX INFO: renamed from: yac.a$a, reason: collision with other inner class name */
    public static final class C8321a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f567049a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8321a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f567049a, ((C8321a) r100).f567049a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f567049a.hashCode();
        }

        public final String toString() {
            return "AsrFailed(taskId=" + this.f567049a + ')';
        }

        @Override // yac.a
        public final String getTaskId() {
            return this.f567049a;
        }

        public C8321a(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            this.f567049a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f567050a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f567050a, ((b) r100).f567050a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f567050a.hashCode();
        }

        public final String toString() {
            return "AsrTimedOut(taskId=" + this.f567050a + ')';
        }

        @Override // yac.a
        public final String getTaskId() {
            return this.f567050a;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            this.f567050a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f567051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VoiceRecordFailureReason f567052b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f567051a, r101.f567051a) == true) goto L12;
            return false;
        L12:
            if (this.f567052b == r101.f567052b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f567051a.hashCode() * 31) + this.f567052b.hashCode();
        }

        public final String toString() {
            return "RecordFailed(taskId=" + this.f567051a + ", reason=" + this.f567052b + ')';
        }

        @Override // yac.a
        public final String getTaskId() {
            return this.f567051a;
        }

        public c(String r100, VoiceRecordFailureReason r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f567051a = r100;
            this.f567052b = r101;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f567053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f567054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f567055c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f567053a, r101.f567053a) == true) goto L12;
            return false;
        L12:
            if (this.f567054b == r101.f567054b) goto L15;
            return false;
        L15:
            if (this.f567055c == r101.f567055c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f567053a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f567054b;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f567055c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RecordTimeLimitReached(taskId=" + this.f567053a + ", durationMs=" + this.f567054b + ", maxDurationMs=" + this.f567055c + ')';
        }

        @Override // yac.a
        public final String getTaskId() {
            return this.f567053a;
        }

        public d(String r100, long r101, long r102) {
            this.f567053a = r100;
            this.f567054b = r101;
            this.f567055c = r102;
        }
    }

    public static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f567056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f567057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f567058c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f567056a, r101.f567056a) == true) goto L12;
            return false;
        L12:
            if (this.f567057b == r101.f567057b) goto L15;
            return false;
        L15:
            if (this.f567058c == r101.f567058c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f567056a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f567057b;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f567058c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RecordTooShort(taskId=" + this.f567056a + ", durationMs=" + this.f567057b + ", minDurationMs=" + this.f567058c + ')';
        }

        @Override // yac.a
        public final String getTaskId() {
            return this.f567056a;
        }

        public e(String r100, long r101, long r102) {
            this.f567056a = r100;
            this.f567057b = r101;
            this.f567058c = r102;
        }
    }

    String getTaskId();
}
