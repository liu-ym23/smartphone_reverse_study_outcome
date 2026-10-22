package hs8;

import is8.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f487072b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487071a, r101.f487071a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487072b, r101.f487072b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f487071a.hashCode() * 31;
        l r101 = this.f487072b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "EngineUploadResult(remoteKey=" + this.f487071a + ", mediaMeta=" + this.f487072b + ')';
    }

    public a(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "remoteKey");
        this.f487071a = r100;
        this.f487072b = r101;
    }
}
