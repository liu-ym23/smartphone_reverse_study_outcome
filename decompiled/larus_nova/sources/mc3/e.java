package mc3;

import com.bytedance.android.shopping.commentv3.data.SortType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f512879a;

    public final SortType a() {
        SortType.a r100 = SortType.Companion;
        Map<String, Object> r101 = this.f512879a;
        SortType r102 = SortType.DEFAULT;
        int r103 = nc3.a.b(r101, com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, r102.getType());
        r100.getClass();
        SortType r104 = SortType.LATEST;
        if (r103 == r104.getType()) goto L5;
        return r102;
    L5:
        return r104;
    }

    public e(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f512879a = r100;
    }
}
