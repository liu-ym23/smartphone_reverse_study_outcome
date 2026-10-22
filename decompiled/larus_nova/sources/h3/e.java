package h3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.utils.g;
import d3.z;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f483652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<TargetEntity.Scope> f483653b = null;

    public e() {
    }

    static {
        f483652a = new e();
        f483653b = CollectionsKt.listOf(TargetEntity.Scope.Main);
    }

    @Override // h3.f
    public final boolean a(ProtocolMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "protocolMessage");
        List<TargetEntity.Scope> r101 = f483653b;
        TargetEntity r102 = r100.g();
        if (r102 == null) goto L5;
        TargetEntity.Scope r103 = r102.b();
    L7:
        return CollectionsKt.contains(r101, r103);
    L5:
        r103 = null;
        goto L7
    }

    @Override // h3.f
    public final void b(e3.a r100, ProtocolMessage r101, final d3.b r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "protocolMessage");
        Intrinsics.checkNotNullParameter(r102, "resultCallback");
        TargetEntity r103 = r101.g();
        if (r103 != null) goto L7;
        r102.invoke(null);
        return;
    L7:
        if (r103.b() == TargetEntity.Scope.Main) goto L9;
    L16:
        r102.invoke(null);
        return;
    L9:
        if (r103.c() != TargetEntity.Target.Self) goto L16;
        z r104 = (z) r100.d(z.class);
        if (r104 != null) goto L14;
        g.f37637a.e("AIBridgeWorkerHandler", "appletRuntimeProvider is null");
        r102.invoke(null);
        return;
    L14:
        r104.a(new d(r102));
    }
}
