package we9;

import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k implements xe9.c, xe9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TriggerMode f559436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559437b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f559436a == r101.f559436a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559437b, r101.f559437b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559436a.hashCode() * 31;
        String r101 = this.f559437b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "Trigger(mode=" + this.f559436a + ", content=" + this.f559437b + ')';
    }

    public k(TriggerMode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f559436a = r100;
        this.f559437b = r101;
    }
}
