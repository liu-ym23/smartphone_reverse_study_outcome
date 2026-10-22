package dd6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468022a;

    public final String toString() {
        return "DownloadRequest{mUrl='" + this.f468022a + "', mRange=0}";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f468022a = r100;
    }
}
