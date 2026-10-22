package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class c {
    public String a;
    public final Action b;
    public final NodeType c;

    public final NodeType getType() {
        return this.c;
    }

    public c(Action r2, NodeType r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        this.b = r2;
        this.c = r3;
        this.a = "";
    }
}
