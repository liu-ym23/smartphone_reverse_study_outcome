package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a f433635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f433636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f433637c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f433635a, r101.f433635a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433636b, r101.f433636b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f433637c, r101.f433637c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f433635a.hashCode() * 31) + this.f433636b.hashCode()) * 31) + this.f433637c.hashCode();
    }

    public final String toString() {
        return "AIInterpretationContext(operator=" + this.f433635a + ", recordingId=" + this.f433636b + ", meetingId=" + this.f433637c + ')';
    }

    public a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r101, "recordingId");
        Intrinsics.checkNotNullParameter(r102, "meetingId");
        this.f433635a = r100;
        this.f433636b = r101;
        this.f433637c = r102;
    }
}
