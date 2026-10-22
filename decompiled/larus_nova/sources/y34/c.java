package y34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T extends v34.b<T>> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<T>> f565850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565851b;

    @Override // y34.a
    public final /* bridge */ /* synthetic */ b a(AosAwemePreloadModel r100) {
        return b(r100);
    }

    public final b b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f565851b >= this.f565850a.size()) goto L16;
        int r101 = this.f565851b;
        if (r101 < 0) goto L16;
        a r102 = (a) ListProtector.get(this.f565850a, r101);
        if (this.f565851b == (this.f565850a.size() - 1)) goto L9;
        c r103 = new c(this.f565850a, this.f565851b + 1);
        b r104 = r102.a((AosAwemePreloadModel) r100);
        if (r104.f565848a == false) goto L14;
        return r104;
    L14:
        return r103.b(r100);
    L9:
        return r102.a((AosAwemePreloadModel) r100);
    L16:
        throw new RuntimeException("invalidate index");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends a<T>> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        this.f565850a = r100;
        this.f565851b = r101;
    }
}
