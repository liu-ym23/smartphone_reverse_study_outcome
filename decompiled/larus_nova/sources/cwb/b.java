package cwb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingAutoSaveDialogReason;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465669a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f465670a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f465671b = null;

        static {
            int[] r100 = new int[MmRecordingAutoSaveDialogReason.values().length];
            r100[MmRecordingAutoSaveDialogReason.NoQuota.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MmRecordingAutoSaveDialogReason.WindowLimited5H.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[MmRecordingAutoSaveDialogReason.WindowLimited7D.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f465670a = r100;
            int[] r101 = new int[MmRecordingAutoSaveDecisionScene.values().length];
            r101[MmRecordingAutoSaveDecisionScene.TOKEN_READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[MmRecordingAutoSaveDecisionScene.RECORD_FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f465671b = r101;
        }
    }

    static {
    }
}
