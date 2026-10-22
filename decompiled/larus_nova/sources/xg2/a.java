package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.ErrorType;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorType f563592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f563593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f563594f;

    public a(Action r100, ErrorType r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "errorType");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        super(r100, NodeType.FAILURE);
        this.f563592d = r101;
        this.f563593e = r102;
        this.f563594f = r103;
    }
}
