package oq6;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f524886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f524888c;

    public a() {
        this(-1, -1, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f524886a == r101.f524886a) goto L12;
        return false;
    L12:
        if (this.f524887b == r101.f524887b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f524888c, r101.f524888c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f524886a * 31) + this.f524887b) * 31;
        Bundle r101 = this.f524888c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DitoRouterConfig(enterAnim=" + this.f524886a + ", exitAnim=" + this.f524887b + ", args=" + this.f524888c + ')';
    }

    public a(int r100, int r101, Bundle r102) {
        this.f524886a = r100;
        this.f524887b = r101;
        this.f524888c = r102;
    }
}
