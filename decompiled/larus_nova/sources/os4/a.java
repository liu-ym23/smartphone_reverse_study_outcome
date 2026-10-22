package os4;

import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;
import ls4.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements b {

    /* JADX INFO: renamed from: os4.a$a, reason: collision with other inner class name */
    public static final class C7104a {
    }

    static {
    }

    public a() {
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r100, JSONObject r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        c.f510538a.getClass();
        Intrinsics.checkNotNullParameter(this, "api");
        Intrinsics.checkNotNullParameter("hideLoading", "apiName");
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        ILynxContainerContext r103 = r100.getContainerContext();
        ILynxContainerContext r104 = r100.getContainerContext();
        Object r105 = null;
        if (r104 == null) goto L5;
        Map<String, Object> r106 = r104.getBizExtra();
    L6:
        if (r106 == null) goto L9;
        r105 = r106.get(a.class.getName());
    L9:
        if ((r105 instanceof c) == false) goto L11;
        ((c) r105).a(r100, r101, r102);
        return;
    L11:
        boolean r107 = true;
        if (r102 == null) goto L14;
        int r108 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.c("hideLoading", "api handler not registered")});
    L14:
        StringBuilder r109 = new StringBuilder("No handler for api: ");
        r109.append(a.class);
        r109.append(", containerContext is null? ");
        if (r103 != null) goto L17;
        boolean r110 = true;
    L18:
        r109.append(r110);
        r109.append("bizExtra is null? ");
        if (r106 == null) goto L22;
        r107 = false;
    L22:
        r109.append(r107);
        tt5.a.d("IChartLynxApiHandler", r109.toString());
        return;
    L17:
        r110 = false;
        goto L18
    L5:
        r106 = null;
        goto L6
    }
}
