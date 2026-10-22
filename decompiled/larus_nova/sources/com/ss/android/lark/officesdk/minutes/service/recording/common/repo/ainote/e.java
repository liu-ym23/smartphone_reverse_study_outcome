package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434843c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f434841a, r101.f434841a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434842b, r101.f434842b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434843c, r101.f434843c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f434841a.hashCode() * 31) + this.f434842b.hashCode()) * 31) + this.f434843c.hashCode();
    }

    public final String toString() {
        return "MmRecordingAINoteFishBoneMarkSyncPayload(action=" + this.f434841a + ", type=" + this.f434842b + ", id=" + this.f434843c + ')';
    }

    public final String getType() {
        return this.f434842b;
    }

    public e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "id");
        this.f434841a = r100;
        this.f434842b = r101;
        this.f434843c = r102;
    }
}
