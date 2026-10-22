package ql7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: ql7.a$a, reason: collision with other inner class name */
    public static final class C7356a {
    }

    static {
    }

    public a() {
    }

    @BridgeMethod("luckycatDeleteUnionInfo")
    public final void deleteUnionInfo(@BridgeContext IBridgeContext r100, @BridgeParam("activity_id") String r101) {
        if (r100 == null) goto L5;
        mk7.a.b.f514328a.b(r101);
        r100.callback(pk7.a.a(1, null, "success"));
        return;
    }
}
