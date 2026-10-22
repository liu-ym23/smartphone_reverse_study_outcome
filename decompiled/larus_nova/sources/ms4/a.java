package ms4;

import com.bytedance.ee.bear.bitable.core.usercomponent.d;
import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ls4.b {

    /* JADX INFO: renamed from: ms4.a$a, reason: collision with other inner class name */
    public static final class C6847a {
    }

    static {
    }

    public a() {
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r100, JSONObject r101, Callback r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        JSONArray r102 = r101.optJSONArray("keys");
        if (r102 == null) goto L5;
        int r103 = r102.length();
    L7:
        if (r103 > 0) goto L11;
        if (r110 == null) goto L18;
        int r104 = ls4.a.f510532f;
        r110.invoke(new Object[]{ls4.a.C6732a.c("getFgConfig", "keys is empty").a()});
        return;
    L18:
        return;
    L11:
        if (r110 == null) goto L19;
        Object[] r105 = new Object[1];
        int r106 = ls4.a.f510532f;
        JSONObject r107 = new JSONObject();
        int r108 = r102.length();
        int r109 = 0;
    L13:
        if (r109 >= r108) goto L15;
        String r111 = r102.optString(r109);
        Intrinsics.checkNotNull(r111);
        int r112 = d.f210603a;
        Intrinsics.checkNotNullParameter(r111, "key");
        r107.put(r111, com.bytedance.ee.bear.bitable.core.usercomponent.b.d(r111));
        r109 = r109 + 1;
        goto L13
    L15:
        Unit r113 = Unit.INSTANCE;
        r105[0] = ls4.a.C6732a.b("getFgConfig", r107.toString()).a();
        r110.invoke(r105);
        return;
    L19:
        return;
    L5:
        r103 = 0;
        goto L7
    }
}
