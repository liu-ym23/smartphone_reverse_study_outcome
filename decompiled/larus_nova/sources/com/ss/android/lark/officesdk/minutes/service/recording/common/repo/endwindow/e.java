package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingEndWindowReasonMode f434954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<EndRecordingReason> f434955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f434956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f434957d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434958a = null;

        static {
            int[] r100 = new int[MmRecordingEndWindowReasonMode.values().length];
            r100[MmRecordingEndWindowReasonMode.DEFAULT_ALLOW_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmRecordingEndWindowReasonMode.ALL_EXCEPT_BLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f434958a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f434954a == r101.f434954a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434955b, r101.f434955b) == true) goto L15;
        return false;
    L15:
        if (this.f434956c == r101.f434956c) goto L18;
        return false;
    L18:
        if (this.f434957d == r101.f434957d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f434954a.hashCode() * 31) + this.f434955b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f434956c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f434957d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingEndWindowPolicy(reasonMode=" + this.f434954a + ", blockedReasons=" + this.f434955b + ", requireAppForeground=" + this.f434956c + ", initializeWithoutRecordingPage=" + this.f434957d + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(MmRecordingEndWindowReasonMode r100, Set<? extends EndRecordingReason> r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "reasonMode");
        Intrinsics.checkNotNullParameter(r101, "blockedReasons");
        this.f434954a = r100;
        this.f434955b = r101;
        this.f434956c = r102;
        this.f434957d = r103;
    }
}
