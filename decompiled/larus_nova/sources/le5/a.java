package le5;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f508919b;

    public a() {
        this.f508918a = "ccm.getFg";
        this.f508919b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f508919b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f508918a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<? extends com.bytedance.ies.xbridge.model.params.a> provideParamModel() {
        return b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<? extends i66.a> provideResultModel() {
        return c.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r113 = b.f508920b;
        Intrinsics.checkNotNullParameter(r110, "params");
        v r114 = s.a(r110, "keys");
        LinkedHashMap r100 = null;
        if (r114 != null) goto L5;
    L11:
        b r101 = null;
    L12:
        if (r101 != null) goto L15;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, "param is empty", null, 8, null);
        return;
    L15:
        c r115 = new c();
        LinkedHashMap r102 = new LinkedHashMap();
        List<String> r103 = r101.f508921a;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("keys");
        r103 = null;
    L19:
        Iterator<String> r116 = r103.iterator();
    L21:
        if (r116.hasNext() == false) goto L23;
        String r104 = r116.next();
        r102.put(r104, Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.f206237a.i(r104, false)));
        goto L21
    L23:
        r115.f508923a = r102;
        int r117 = c.f508922b;
        Intrinsics.checkNotNullParameter(r115, "data");
        if (r115.f508923a != null) goto L26;
    L25:
        LinkedHashMap r105 = r100;
        if (r105 != null) goto L32;
        XCoreBridgeMethod.onFailure$default(this, r111, -5, "result is invalid", null, 8, null);
        return;
    L32:
        XCoreBridgeMethod.onSuccess$default(this, r111, r105, null, 4, null);
        return;
    L26:
        r100 = new LinkedHashMap();
        Map<String, Object> r118 = r115.f508923a;
        if (r118 == null) goto L25;
        r100.put(AppConstants.APP_FG, r118);
        goto L25
    L5:
        if (r114.size() <= 0) goto L11;
        r101 = new b();
        ArrayList r106 = new ArrayList();
        int r107 = r114.size();
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L10;
        r106.add(r114.getString(r108));
        r108 = r108 + 1;
        goto L8
    L10:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r101.f508921a = r106;
        goto L12
    }
}
