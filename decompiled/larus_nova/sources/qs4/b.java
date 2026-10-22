package qs4;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements ls4.b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r100, JSONObject r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        String r103 = r101.optString("key");
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L14;
        if (r102 == null) goto L23;
        int r105 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.c("setStorage", "key is null").a()});
        return;
    L23:
        return;
    L14:
        String r106 = r101.optString("data");
        if (r106 != null) goto L19;
        if (r102 == null) goto L24;
        int r107 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.c("setStorage", "data is null").a()});
        return;
    L24:
        return;
    L19:
        ay4.b.d(DocumentType.BITABLE_NAME, 6).putString("bitable_lynx_1_" + r103, r106);
        if (r102 == null) goto L25;
        int r108 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.a("setStorage").a()});
        return;
    L25:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
