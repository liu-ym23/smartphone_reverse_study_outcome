package dd3;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends dd3.a {

    public static final class a {
    }

    static {
    }

    @Override // dd3.d
    public final void a(com.bytedance.android.shopping.deepfeed.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // dd3.d
    public final void b(Lifecycle r2, ConstraintLayout r3, String r4, com.bytedance.android.shopping.deepfeed.action.b r5) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "deepFeedContext");
    }

    @Override // dd3.d
    public final void c() {
    }

    public b() {
    }
}
