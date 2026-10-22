package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f563595d;

    public b(Action r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "info");
        super(r100, NodeType.INFO);
        this.f563595d = r101;
    }
}
