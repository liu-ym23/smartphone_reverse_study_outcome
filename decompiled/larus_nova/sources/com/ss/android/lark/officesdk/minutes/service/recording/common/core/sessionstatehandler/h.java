package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((MmRecordingUploadTask) r100).f434500b), Integer.valueOf(((MmRecordingUploadTask) r101).f434500b));
    }
}
