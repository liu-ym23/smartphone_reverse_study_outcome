package ps4;

import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements b {

    /* JADX INFO: renamed from: ps4.a$a, reason: collision with other inner class name */
    public static final class C7233a {
    }

    static {
    }

    public a() {
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r100, JSONObject r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        String r103 = r101.optString("content", "");
        String r104 = r101.optString("level");
        if (r104 == null) goto L22;
        int r105 = r104.hashCode();
        if (r105 == 3237038) goto L20;
        if (r105 == 3641990) goto L16;
        if (r105 != 96784904) goto L22;
        if (r104.equals("error") == false) goto L22;
        tt5.a.d("BitableChartLynx", r103);
    L23:
        if (r102 == null) goto L26;
        int r106 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.a("log").a()});
        return;
    L26:
        return;
    L16:
        if (r104.equals("warn") == false) goto L22;
        tt5.a.k("BitableChartLynx", r103);
        goto L23
    L20:
        if (r104.equals("info") == false) goto L22;
        tt5.a.h("BitableChartLynx", r103);
    L22:
        tt5.a.b("BitableChartLynx", r103);
        goto L23
    }
}
