package le5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends XCoreBridgeMethod {
    public final String a;
    public final XBridgeMethod.Access b;

    public a() {
        this.a = "ccm.getFg";
        this.b = XBridgeMethod.Access.PROTECT;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public final Class<? extends com.bytedance.ies.xbridge.model.params.a> provideParamModel() {
        return b.class;
    }

    public final Class<? extends i66.a> provideResultModel() {
        return c.class;
    }

    public final void handle(XReadableMap r12, XBridgeMethod.Callback r13, XBridgePlatformType r14) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TYPE);
        int r15 = b.b;
        Intrinsics.checkNotNullParameter(r12, "params");
        v r16 = s.a(r12, "keys");
        LinkedHashMap r0 = null;
        if (r16 != null) goto L5;
    L11:
        b r2 = null;
    L12:
        if (r2 != null) goto L15;
        XCoreBridgeMethod.onFailure$default(this, r13, -3, "param is empty", null, 8, null);
        return;
    L15:
        c r17 = new c();
        LinkedHashMap r3 = new LinkedHashMap();
        List<String> r4 = r2.a;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("keys");
        r4 = null;
    L19:
        Iterator<String> r18 = r4.iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        String r5 = r18.next();
        r3.put(r5, Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.a.i(r5, false)));
        goto L21
    L23:
        r17.a = r3;
        int r19 = c.b;
        Intrinsics.checkNotNullParameter(r17, WikiFolderPushPlugin.DATA);
        if (r17.a != null) goto L26;
    L25:
        LinkedHashMap r6 = r0;
        if (r6 != null) goto L32;
        XCoreBridgeMethod.onFailure$default(this, r13, -5, "result is invalid", null, 8, null);
        return;
    L32:
        XCoreBridgeMethod.onSuccess$default(this, r13, r6, null, 4, null);
        return;
    L26:
        r0 = new LinkedHashMap();
        Map<String, Object> r110 = r17.a;
        if (r110 == null) goto L25;
        r0.put("fg", r110);
        goto L25
    L5:
        if (r16.size() <= 0) goto L11;
        r2 = new b();
        ArrayList r7 = new ArrayList();
        int r8 = r16.size();
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L10;
        r7.add(r16.getString(r9));
        r9 = r9 + 1;
        goto L8
    L10:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r2.a = r7;
        goto L12
    }
}
