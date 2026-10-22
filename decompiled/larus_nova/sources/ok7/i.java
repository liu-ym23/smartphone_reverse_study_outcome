package ok7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements XBridgeMethod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Callback f523691a;

    public i(XBridgeMethod.Callback r100) {
        this.f523691a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
    public final void invoke(Map<String, Object> r100) {
        Application r101 = rk7.m.f538347a;
        if (rk7.m.f538357k == false) goto L15;
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, Object> r103 = r102.next();
        StringBuilder r104 = new StringBuilder("key: ");
        Object r105 = null;
        if (r103 == null) goto L10;
        String r106 = r103.getKey();
    L11:
        r104.append(r106);
        r104.append(" value : ");
        if (r103 == null) goto L14;
        r105 = r103.getValue();
    L14:
        r104.append(r105);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckycatXBridge", r104.toString());
        goto L6
    L10:
        r106 = null;
    L15:
        this.f523691a.invoke(r100);
    }

    public final void a(int r100, JSONObject r101, String r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<String> r104 = r101.keys();
    L4:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L8;
        Object r106 = r101.opt(r105);
    L9:
        if (r106 == null) goto L4;
        r103.put(r105, r106);
        goto L4
    L8:
        r106 = null;
        goto L9
    L11:
        invoke(c.a(r103, r102));
    }

    public static /* synthetic */ void b(i r100, int r101, JSONObject r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.a(r101, r102, r103);
    }
}
