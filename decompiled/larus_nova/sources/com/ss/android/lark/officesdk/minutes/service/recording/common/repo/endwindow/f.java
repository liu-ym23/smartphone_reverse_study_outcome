package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f434959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f434960b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434961a = null;

        static {
            int[] r100 = new int[MmRecordingSource.values().length];
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f434961a = r100;
        }
    }

    static {
        f434959a = new e(MmRecordingEndWindowReasonMode.DEFAULT_ALLOW_LIST, SetsKt.emptySet(), false, false);
        f434960b = new e(MmRecordingEndWindowReasonMode.ALL_EXCEPT_BLOCKED, SetsKt.setOf(EndRecordingReason.HARDWARE_RESTARTED_BY_GESTURE), true, true);
    }
}
