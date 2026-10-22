package jh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f499117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f499118b;

    public /* synthetic */ h() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f499117a, r101.f499117a) == true) goto L12;
        return false;
    L12:
        if (this.f499118b == r101.f499118b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499117a.hashCode() * 31;
        if (this.f499118b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "UgcVoiceRepoTransition(state=" + this.f499117a + ", failedVoiceCacheChanged=" + this.f499118b + ')';
    }

    public h(f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f499117a = r100;
        this.f499118b = r101;
    }
}
