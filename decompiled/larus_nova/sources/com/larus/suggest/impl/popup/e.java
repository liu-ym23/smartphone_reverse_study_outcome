package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.NexPulseCandidate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NexPulseCandidate f369874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f369875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369877d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f369874a, r101.f369874a) == true) goto L12;
        return false;
    L12:
        if (this.f369875b == r101.f369875b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f369876c, r101.f369876c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f369877d, r101.f369877d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        NexPulseCandidate r100 = this.f369874a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f369875b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f369876c;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return ((r105 + r101) * 31) + this.f369877d.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DialogReadyState(candidate=" + this.f369874a + ", mediaReady=" + this.f369875b + ", campaignTag=" + this.f369876c + ", pcGuideSource=" + this.f369877d + ')';
    }

    public e(NexPulseCandidate r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "pcGuideSource");
        this.f369874a = r100;
        this.f369875b = r101;
        this.f369876c = r102;
        this.f369877d = r103;
    }
}
