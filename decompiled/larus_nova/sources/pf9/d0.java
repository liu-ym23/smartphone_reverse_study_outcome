package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d0 implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f528899d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f528896a, r101.f528896a) == true) goto L12;
        return false;
    L12:
        if (this.f528897b == r101.f528897b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528898c, r101.f528898c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528899d, r101.f528899d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528896a.hashCode() * 31;
        if (this.f528897b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f528898c.hashCode()) * 31;
        t r103 = this.f528899d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowLLMReplyBeginEvent(modelType=" + this.f528896a + ", isModelProactiveSpeak=" + this.f528897b + ", linkState=" + this.f528898c + ", quotaExceededEvent=" + this.f528899d + ')';
    }

    public d0(String r100, boolean r101, String r102, t r103) {
        Intrinsics.checkNotNullParameter(r100, "modelType");
        Intrinsics.checkNotNullParameter(r102, "linkState");
        this.f528896a = r100;
        this.f528897b = r101;
        this.f528898c = r102;
        this.f528899d = r103;
    }
}
