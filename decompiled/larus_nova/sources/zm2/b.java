package zm2;

import com.bytedance.android.live.network.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements um0.a {
    public b() {
    }

    @Override // um0.a
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        int r101 = go0.a.f481868a;
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) c.b().e(r100);
    }
}
