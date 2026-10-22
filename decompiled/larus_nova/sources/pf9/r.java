package pf9;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TriggerMode f528967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528968b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f528967a == r101.f528967a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528968b, r101.f528968b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528967a.hashCode() * 31;
        String r101 = this.f528968b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowLLMCustomEvent(type=" + this.f528967a + ", eventBody=" + this.f528968b + ')';
    }

    public final TriggerMode getType() {
        return this.f528967a;
    }

    public r(TriggerMode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f528967a = r100;
        this.f528968b = r101;
    }
}
