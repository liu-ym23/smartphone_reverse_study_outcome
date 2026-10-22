package d3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProtocolMessage f466659a;

    public x(String r100, ProtocolMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "protocolMessage");
        this.f466659a = r101;
        System.currentTimeMillis();
    }
}
