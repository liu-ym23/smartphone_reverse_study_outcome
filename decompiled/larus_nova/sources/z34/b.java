package z34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T extends v34.b<T>> implements y34.a<T> {
    public b() {
    }

    @Override // y34.a
    public final y34.b a(AosAwemePreloadModel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = r100.getRetryTimes();
        int r102 = b44.a.f17520a;
        if (r101 <= 2) goto L6;
        return new y34.b(true, "PreloadModel alreadyTouchMaxFailedRetryTimes 2! been discard!");
    L6:
        return new y34.b(false, "");
    }
}
