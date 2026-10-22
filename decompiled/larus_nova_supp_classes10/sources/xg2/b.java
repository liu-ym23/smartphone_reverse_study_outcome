package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends c {
    public final Map<String, String> d;

    public b(Action r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.INFO);
        super(r2, NodeType.INFO);
        this.d = r3;
    }
}
