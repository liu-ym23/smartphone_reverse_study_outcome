package dd3;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends dd3.a {

    public static final class a {
    }

    static {
    }

    @Override // dd3.d
    public final void a(com.bytedance.android.shopping.deepfeed.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // dd3.d
    public final void b(Lifecycle r100, ConstraintLayout r101, String r102, com.bytedance.android.shopping.deepfeed.action.b r103) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r103, "deepFeedContext");
    }

    @Override // dd3.d
    public final void c() {
    }

    public b() {
    }
}
