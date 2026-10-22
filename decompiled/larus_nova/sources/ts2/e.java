package ts2;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Configuration f547343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f547344b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f547343a, r101.f547343a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547344b, r101.f547344b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Configuration r100 = this.f547343a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f547344b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnConfigurationChangedData(newConfig=" + this.f547343a + ", isInPictureInPictureMode=" + this.f547344b + ")";
    }

    public e() {
        this(null, Boolean.FALSE);
    }

    public e(Configuration r100, Boolean r101) {
        this.f547343a = r100;
        this.f547344b = r101;
    }
}
