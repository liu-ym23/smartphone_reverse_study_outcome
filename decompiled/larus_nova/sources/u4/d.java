package u4;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f548634a;

    public d() {
        this.f548634a = new ConcurrentHashMap();
    }

    @Override // u4.c
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        ConcurrentHashMap<String, String> r102 = this.f548634a.get(r100);
        if (r102 == null) goto L6;
        String r103 = r102.remove(r101);
        return;
    }

    @Override // u4.c
    public final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        ConcurrentHashMap<String, String> r103 = this.f548634a.get(r100);
        if (r103 == null) goto L9;
        String r104 = r103.get(r101);
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }

    @Override // u4.c
    public final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        ConcurrentHashMap<String, String> r103 = this.f548634a.get(r100);
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
    L5:
        r103.put(r101, r102);
        this.f548634a.put(r100, r103);
    }
}
