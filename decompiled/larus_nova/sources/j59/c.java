package j59;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f497476a;

    public c(Keva r100) {
        Intrinsics.checkNotNullParameter(r100, "keva");
        this.f497476a = r100;
    }

    @Override // j59.d
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f497476a.getInt(r100, 0);
    }

    @Override // j59.d
    public final long getLong(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f497476a.getLong(r100, 0);
    }

    @Override // j59.d
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f497476a.storeInt(r100, r101);
    }

    @Override // j59.d
    public final void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f497476a.storeLong(r100, r101);
    }
}
