package h78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f483998a;

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "codes");
        this.f483998a = r100;
    }

    @Override // h78.b
    public final boolean a(String r100) {
        if (this.f483998a.contains(r100) == false) goto L5;
        return true;
    L5:
        return false;
    }
}
