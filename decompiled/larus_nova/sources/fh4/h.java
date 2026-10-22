package fh4;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f477039b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f477040a;

    public final String toString() {
        return "EventConfig{sampledService=" + this.f477040a + ", isAllSample=false}";
    }

    public h(Set<String> r100) {
        this.f477040a = r100;
    }

    public final boolean a(String r100) {
        if (f477039b == false) goto L5;
        return false;
    L5:
        Set<String> r101 = this.f477040a;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
