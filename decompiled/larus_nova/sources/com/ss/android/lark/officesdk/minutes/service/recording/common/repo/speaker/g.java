package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f435092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f435093d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f435090a == r101.f435090a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435091b, r101.f435091b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435092c, r101.f435092c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435093d, r101.f435093d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f435090a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f435091b.hashCode()) * 31) + this.f435092c.hashCode()) * 31;
        c r102 = this.f435093d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("MmSpeakerMarkResult(success=");
        r100.append(this.f435090a);
        r100.append(", clusterId='");
        r100.append(this.f435091b);
        r100.append("', oldSpeaker=");
        r100.append(this.f435092c.f435069a);
        r100.append(", newSpeaker=");
        c r101 = this.f435093d;
        if (r101 == null) goto L5;
        String r102 = r101.f435069a;
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public /* synthetic */ g(String r100, c r101) {
        this(false, r100, r101, null);
    }

    public g(boolean r100, String r101, c r102, c r103) {
        Intrinsics.checkNotNullParameter(r101, "clusterId");
        Intrinsics.checkNotNullParameter(r102, "oldSpeaker");
        this.f435090a = r100;
        this.f435091b = r101;
        this.f435092c = r102;
        this.f435093d = r103;
    }
}
