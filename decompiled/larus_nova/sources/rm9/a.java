package rm9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.disk.api.c;
import com.larus.utils.r;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f538613b;

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.OFFLINE_RESOURCE;
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return this.f538613b.getAbsolutePath();
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        if (this.f538613b.exists() == true) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(r.r(this.f538613b), 0);
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return this.f538612a;
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }

    public a(PolarisFileWrapper r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceRoot");
        Intrinsics.checkNotNullParameter(r101, "cacheBizTag");
        this.f538612a = r101;
        this.f538613b = r100.getCanonicalFile();
    }
}
