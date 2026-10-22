package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingAutoSaveDecisionScene f436175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingAutoSaveDialogReason f436176b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f436175a == r101.f436175a) goto L12;
        return false;
    L12:
        if (this.f436176b == r101.f436176b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f436175a.hashCode() * 31) + this.f436176b.hashCode();
    }

    public final String toString() {
        return "MmRecordingAutoSaveDialogInfo(scene=" + this.f436175a + ", reason=" + this.f436176b + ')';
    }

    public b(MmRecordingAutoSaveDecisionScene r100, MmRecordingAutoSaveDialogReason r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f436175a = r100;
        this.f436176b = r101;
    }
}
