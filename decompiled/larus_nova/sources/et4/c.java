package et4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f473923a = null;

    static {
        f473923a = new c();
    }

    public c() {
    }

    @Override // et4.b
    public final int groupLength() {
        return 0;
    }

    @Override // et4.b
    public final boolean isCollapsed(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
        return false;
    }
}
