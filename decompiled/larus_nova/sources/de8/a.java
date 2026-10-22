package de8;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f468083a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f468083a, ((a) r100).f468083a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f468083a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CameraResultFirstUpdateData(arguments=" + this.f468083a + ')';
    }

    public a(Bundle r100) {
        this.f468083a = r100;
    }
}
