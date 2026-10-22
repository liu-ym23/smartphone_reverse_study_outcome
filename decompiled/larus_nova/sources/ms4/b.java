package ms4;

import com.lynx.react.bridge.Callback;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
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
    public final void a(ILynxBridgeContext r100, JSONObject r110, Callback r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        JSONArray r101 = r110.optJSONArray("keys");
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L7:
        if (r102 > 0) goto L11;
        if (r111 == null) goto L33;
        int r103 = ls4.a.f510532f;
        r111.invoke(new Object[]{ls4.a.C6732a.c("getSettingsConfig", "keys is empty").a()});
        return;
    L33:
        return;
    L11:
        if (r111 == null) goto L34;
        Object[] r104 = new Object[1];
        int r105 = ls4.a.f510532f;
        JSONObject r106 = new JSONObject();
        int r107 = r101.length();
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L28;
        String r109 = r101.optString(r108);
        if (r109 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r112 == true) goto L27;
        String r113 = SettingManager.getInstance().getSettingConfig(r109, true);
        if (r113 != null) goto L26;
        r113 = "";
    L26:
        r106.put(r109, r113);
    L27:
        r108 = r108 + 1;
        goto L13
    L17:
        if (r109.length() == 0) goto L20;
        r112 = false;
        goto L21
    L28:
        Unit r114 = Unit.INSTANCE;
        r104[0] = ls4.a.C6732a.b("getSettingsConfig", r106.toString()).a();
        r111.invoke(r104);
        return;
    L34:
        return;
    L5:
        r102 = 0;
        goto L7
    }
}
