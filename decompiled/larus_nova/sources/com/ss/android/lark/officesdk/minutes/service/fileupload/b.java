package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<MmRecordingSource> f433755a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f433755a, ((b) r100).f433755a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f433755a.hashCode();
    }

    public final String toString() {
        return "MmMinutesFileUploadForegroundConfig(enabledSources=" + this.f433755a + ')';
    }

    public b(Object r100) {
        Set<MmRecordingSource> r101 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r101, "enabledSources");
        this.f433755a = r101;
    }
}
