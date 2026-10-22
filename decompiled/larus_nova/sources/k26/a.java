package k26;

import com.bytedance.ies.bullet.core.kit.bridge.c;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "anniex.preInit", owner = "zhenghanfeng")
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBridgeMethod.Access f501570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f501571d;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f501570c;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f501571d;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f501570c = IBridgeMethod.Access.PUBLIC;
        this.f501571d = "anniex.preInit";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onComplete(new JSONObject());
    }
}
