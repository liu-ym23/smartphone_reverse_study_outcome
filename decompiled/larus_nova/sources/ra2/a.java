package ra2;

import com.bytedance.android.live.base.model.message.g3;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f536811a = null;

    static {
        f536811a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        g3 r102 = (g3) r100;
        g3 r103 = (g3) r101;
        Intrinsics.checkNotNullParameter(r102, "msg1");
        Intrinsics.checkNotNullParameter(r103, "msg2");
        return (r102.getCount() > r103.getCount() ? 1 : (r102.getCount() == r103.getCount() ? 0 : -1));
    }
}
