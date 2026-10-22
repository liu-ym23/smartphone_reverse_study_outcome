package xg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.NodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f563596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action f563597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NodeType f563598c;

    public final NodeType getType() {
        return this.f563598c;
    }

    public c(Action r100, NodeType r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f563597b = r100;
        this.f563598c = r101;
        this.f563596a = "";
    }
}
