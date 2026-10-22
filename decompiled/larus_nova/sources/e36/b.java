package e36;

import com.bytedance.ies.bullet.core.kit.bridge.c;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.stopRecord", owner = "zhaoxin")
public final class b extends c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBridgeMethod.Access f470925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470926d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f470925c;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f470926d;
    }

    public b(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f470925c = IBridgeMethod.Access.PRIVATE;
        this.f470926d = "bullet.stopRecord";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = r100.optString("key");
        if (r102 != null) goto L5;
        return;
    L5:
        if (d36.a.e(false, r102) == false) goto L7;
        JSONObject r103 = new JSONObject();
        r103.put("code", 1);
        r101.onComplete(r103);
        return;
    L7:
        JSONObject r104 = new JSONObject();
        r104.put("code", 0);
        r101.onComplete(r104);
    }
}
