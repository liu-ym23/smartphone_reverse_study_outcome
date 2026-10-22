package ra2;

import com.bytedance.android.live.base.model.message.g3;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f536826a = null;

    static {
        f536826a = new n();
    }

    public n() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        g3 r102 = (g3) r100;
        g3 r103 = (g3) r101;
        Intrinsics.checkNotNullParameter(r102, "msg1");
        Intrinsics.checkNotNullParameter(r103, "msg2");
        return (r102.getSequenceId() > r103.getSequenceId() ? 1 : (r102.getSequenceId() == r103.getSequenceId() ? 0 : -1));
    }
}
