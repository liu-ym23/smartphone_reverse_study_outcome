package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception.MmCreateRecordingException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmCreateRecordingException f434452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f434453b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f434452a, r101.f434452a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434453b, r101.f434453b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434452a.hashCode() * 31) + this.f434453b.hashCode();
    }

    public final String toString() {
        return "MmRecordingCreateFailureDecision(exception=" + this.f434452a + ", feedback=" + this.f434453b + ')';
    }

    public a(MmCreateRecordingException r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r101, "feedback");
        this.f434452a = r100;
        this.f434453b = r101;
    }
}
