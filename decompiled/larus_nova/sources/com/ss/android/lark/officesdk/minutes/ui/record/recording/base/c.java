package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f436177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f436178b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436179a = null;

        static {
            int[] r100 = new int[MmRecordingAutoSaveDecisionScene.values().length];
            r100[MmRecordingAutoSaveDecisionScene.TOKEN_READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmRecordingAutoSaveDecisionScene.RECORD_FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436179a = r100;
        }
    }

    static {
    }

    public c() {
    }

    public static MmRecordingAutoSaveDialogReason b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d r100) {
        if (r100 == null) goto L4;
        String r101 = r100.a();
    L6:
        if (Intrinsics.areEqual(r101, "WINDOW_LIMITED") == false) goto L8;
        String r102 = r100.b();
        if (Intrinsics.areEqual(r102, "5h") == false) goto L13;
        return MmRecordingAutoSaveDialogReason.WindowLimited5H;
    L13:
        if (Intrinsics.areEqual(r102, "7d") == false) goto L16;
        return MmRecordingAutoSaveDialogReason.WindowLimited7D;
    L16:
        return MmRecordingAutoSaveDialogReason.NoQuota;
    L8:
        return MmRecordingAutoSaveDialogReason.NoQuota;
    L4:
        r101 = null;
        goto L6
    }

    public final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g r100) {
        Intrinsics.checkNotNullParameter(r100, "decision");
        MmRecordingAutoSaveDecisionScene r101 = r100.f434892a;
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 != (-1)) goto L8;
    L28:
        return null;
    L8:
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L18;
        if (this.f436178b == true) goto L28;
        if (r100.f434893b == false) goto L28;
        this.f436178b = true;
        return new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b(MmRecordingAutoSaveDecisionScene.RECORD_FINISH, b(r100.f434896e));
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (this.f436177a == true) goto L28;
        if (r100.f434893b == false) goto L28;
        if (r100.f434894c != MmAudioSaveType.SAVE.getValue()) goto L28;
        this.f436177a = true;
        return new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b(MmRecordingAutoSaveDecisionScene.TOKEN_READY, b(r100.f434896e));
    L5:
        r102 = b.f436179a[r101.ordinal()];
        goto L6
    }
}
