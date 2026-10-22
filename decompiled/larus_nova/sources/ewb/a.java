package ewb;

import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
public interface a {

    /* JADX INFO: renamed from: ewb.a$a, reason: collision with other inner class name */
    public static final class C5827a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5827a f474612a = null;

        static {
            f474612a = new C5827a();
        }

        public C5827a() {
        }

        @Override // ewb.a
        public final void a(b r100, MmRecordingNotificationRepo r101, RecordingSessionType r102, CoroutineScope r103) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "notificationRepo");
            Intrinsics.checkNotNullParameter(r102, InteractConst.WAKEUP_SESSION_TYPE);
            Intrinsics.checkNotNullParameter(r103, "scope");
        }

        @Override // ewb.a
        public final void clearAll() {
        }
    }

    void a(b r100, MmRecordingNotificationRepo r101, RecordingSessionType r102, CoroutineScope r103);

    void clearAll();
}
