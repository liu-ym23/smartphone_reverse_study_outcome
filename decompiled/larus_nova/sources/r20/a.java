package r20;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f535709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f535710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f535711c;

    public final String toString() {
        return this.f535711c.toString();
    }

    public a(Uri r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "originUri");
        Intrinsics.checkNotNullParameter(r101, "finalUri");
        this.f535710b = r100;
        this.f535711c = r101;
    }
}
