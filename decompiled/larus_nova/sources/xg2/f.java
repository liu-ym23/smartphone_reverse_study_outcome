package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends c {
    public f(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100, NodeType.SUCCESS);
    }
}
