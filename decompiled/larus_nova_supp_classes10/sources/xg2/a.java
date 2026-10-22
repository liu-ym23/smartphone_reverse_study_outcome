package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.ErrorType;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends c {
    public final ErrorType d;
    public final int e;
    public final String f;

    public a(Action r2, ErrorType r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "errorType");
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        super(r2, NodeType.FAILURE);
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
