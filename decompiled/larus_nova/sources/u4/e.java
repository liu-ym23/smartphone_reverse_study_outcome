package u4;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements c {
    public e() {
    }

    @Override // u4.c
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        Keva.getRepo(r100).erase(r101);
    }

    @Override // u4.c
    public final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        return Keva.getRepo(r100).getString(r101, r102);
    }

    @Override // u4.c
    public final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        Intrinsics.checkNotNullParameter(r101, "key");
        Keva.getRepo(r100).storeString(r101, r102);
    }
}
