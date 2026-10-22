package pf9;

import com.larus.im.service.audio.z0;

/* JADX INFO: loaded from: classes30.dex */
public final class e0 implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f528900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528901b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f528900a == r101.f528900a) goto L12;
        return false;
    L12:
        if (this.f528901b == r101.f528901b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f528900a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f528901b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowLLMReplyEndEvent(noContent=" + this.f528900a + ", noReply=" + this.f528901b + ')';
    }

    public e0(boolean r100, boolean r101) {
        this.f528900a = r100;
        this.f528901b = r101;
    }
}
