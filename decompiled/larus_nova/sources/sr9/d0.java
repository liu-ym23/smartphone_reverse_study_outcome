package sr9;

import com.larus.platform.api.IVideoController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 implements ps8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f543238a = null;

    static {
        f543238a = new d0();
    }

    public d0() {
    }

    @Override // ps8.a
    public final IVideoController a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "subTag");
        return null;
    }

    @Override // ps8.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // ps8.a
    public final IVideoController c(String r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "subTag");
        return null;
    }
}
