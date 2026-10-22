package qg7;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    static {
    }

    public static b a(int r100, Cert r101) {
        IRulerBusinessService r102 = (IRulerBusinessService) ServiceManager.get().getServiceForReal(IRulerBusinessService.class);
        String r103 = r101.certToken();
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        HashMap r104 = new HashMap();
        r104.put("source", "clipboard_suite");
        r104.put("api_id", Integer.valueOf(r100));
        r104.put(LocationMonitorConst.CERT_TOKEN, r103);
        if (r102 == null) goto L9;
        com.bytedance.ruler.base.models.f r105 = r102.b(r104);
    L10:
        if (r105 == null) goto L12;
        ArrayList<com.bytedance.ruler.base.models.c> r106 = r105.f267674i;
    L14:
        if (r106 != null) goto L16;
    L19:
        if (r106 == null) goto L45;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L45;
        com.bytedance.ruler.base.models.c r108 = (com.bytedance.ruler.base.models.c) r107.next();
        JsonElement r109 = r108.f267665e;
        if (r109 == null) goto L26;
        JsonObject r110 = r109.getAsJsonObject();
    L27:
        if (r110 == null) goto L31;
        JsonElement r111 = r110.get("action");
        if (r111 == null) goto L31;
        String r112 = r111.getAsString();
    L32:
        com.bytedance.ruler.base.models.e r113 = r108.f267663c;
        if (r108.f267661a != 0) goto L22;
        if (Intrinsics.areEqual(r112, "fuse") == false) goto L22;
        if (r113 == null) goto L41;
        String r114 = r113.c();
        if (r114 == null) goto L41;
    L43:
        return new b(true, r114, r103, -6011);
    L41:
        r114 = "intercept by rule engine";
    L31:
        r112 = null;
        goto L32
    L26:
        r110 = null;
    L45:
        return new b(false, "", r103, 0);
    L16:
        if (r106.isEmpty() != true) goto L19;
        return new b(false, "", r103, 0);
    L12:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    }
}
