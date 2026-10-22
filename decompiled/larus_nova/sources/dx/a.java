package dx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470406b;

    public final String toString() {
        return "LatchJSError(file='" + this.f470405a + "', errMessage='" + this.f470406b + "')";
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.f470405a = r100;
        this.f470406b = r101;
    }
}
