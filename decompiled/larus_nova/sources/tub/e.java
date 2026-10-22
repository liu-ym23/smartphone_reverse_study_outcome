package tub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingRejectReason;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecordingPriorityStartMode f547647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<d> f547648c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f547646a, r101.f547646a) == true) goto L12;
            return false;
        L12:
            if (this.f547647b == r101.f547647b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f547648c, r101.f547648c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f547646a.hashCode() * 31) + this.f547647b.hashCode()) * 31) + this.f547648c.hashCode();
        }

        public final String toString() {
            return "CanStart(sceneInstanceId=" + this.f547646a + ", startMode=" + this.f547647b + ", interruptInstances=" + this.f547648c + ')';
        }

        public a(String r100, RecordingPriorityStartMode r101, List<d> r102) {
            Intrinsics.checkNotNullParameter(r100, "sceneInstanceId");
            Intrinsics.checkNotNullParameter(r101, "startMode");
            Intrinsics.checkNotNullParameter(r102, "interruptInstances");
            this.f547646a = r100;
            this.f547647b = r101;
            this.f547648c = r102;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecordingRejectReason f547650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<d> f547651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f547652d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f547649a, r101.f547649a) == true) goto L12;
            return false;
        L12:
            if (this.f547650b == r101.f547650b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f547651c, r101.f547651c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f547652d, r101.f547652d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f547649a.hashCode() * 31) + this.f547650b.hashCode()) * 31) + this.f547651c.hashCode()) * 31;
            String r101 = this.f547652d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Reject(sceneInstanceId=" + this.f547649a + ", reason=" + this.f547650b + ", blockingInstances=" + this.f547651c + ", errorDisplayMsg=" + this.f547652d + ')';
        }

        public b(String r100, RecordingRejectReason r101, List<d> r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "sceneInstanceId");
            Intrinsics.checkNotNullParameter(r101, "reason");
            Intrinsics.checkNotNullParameter(r102, "blockingInstances");
            this.f547649a = r100;
            this.f547650b = r101;
            this.f547651c = r102;
            this.f547652d = r103;
        }
    }

    public e() {
        RecordingPriorityStartMode r100 = RecordingPriorityStartMode.NORMAL;
    }
}
