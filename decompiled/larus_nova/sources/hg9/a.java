package hg9;

import com.bytedance.keva.Keva;
import gb6.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f485034a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        this.f485034a = Keva.getRepo(r100, 0);
    }

    @Override // gb6.c
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f485034a.getLong(r100, r101);
    }

    @Override // gb6.c
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return this.f485034a.getString(r100, r101);
    }

    @Override // gb6.c
    public final void storeLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f485034a.storeLong(r100, r101);
    }

    @Override // gb6.c
    public final void storeString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f485034a.storeString(r100, r101);
    }
}
