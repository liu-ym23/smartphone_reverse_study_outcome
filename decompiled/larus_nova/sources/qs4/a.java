package qs4;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ls4.b {

    /* JADX INFO: renamed from: qs4.a$a, reason: collision with other inner class name */
    public static final class C7387a {
    }

    static {
    }

    public a() {
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
        if (r102 == null) goto L21;
        int r105 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.c("getStorage", "key is null").a()});
        return;
    L21:
        return;
    L14:
        String r106 = ay4.b.d(DocumentType.BITABLE_NAME, 6).getString("bitable_lynx_1_" + r103, null);
        if (r102 == null) goto L22;
        Object[] r107 = new Object[1];
        int r108 = ls4.a.f510532f;
        if (r106 != null) goto L19;
        r106 = "";
    L19:
        r107[0] = ls4.a.C6732a.b("getStorage", r106).a();
        r102.invoke(r107);
        return;
    L22:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
