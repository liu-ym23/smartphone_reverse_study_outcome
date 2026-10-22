package vd7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getSettings")
public final class e extends b {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        b.c r102 = (b.c) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        List<b.InterfaceC7984b> r103 = r102.getKeys();
        ArrayList r104 = new ArrayList();
        LinkedHashSet r105 = new LinkedHashSet();
        Iterator<T> r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L17;
        b.InterfaceC7984b r107 = (b.InterfaceC7984b) r106.next();
        String r108 = r107.getKey();
        String r109 = r107.getBiz();
        SettingValueType.a r111 = SettingValueType.Companion;
        String r112 = r107.getType();
        r111.getClass();
        SettingValueType r113 = SettingValueType.a.a(r112);
        if (r108.length() <= 0) goto L8;
        boolean r114 = true;
    L9:
        if (r114 == false) goto L4;
        if (r113 == SettingValueType.UNSUPPORTED) goto L4;
        re7.a r115 = new re7.a(r108, r113);
        if (r109 == null) goto L15;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
    L15:
        r104.add(r115);
        r105.add(r108);
        goto L4
    L8:
        r114 = false;
        goto L9
    L17:
        if (r104.isEmpty() == false) goto L20;
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, "empty key or unsupported key type in params", null, 4, null);
        return;
    L20:
        if (r105.size() >= r104.size()) goto L22;
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, "duplicate keys in params", null, 4, null);
        return;
    L22:
        XBaseRuntime.f270095a.getClass();
        IHostContextDepend r116 = XBaseRuntime.f270100f;
        if (r116 == null) goto L25;
        List<re7.b> r117 = r116.getSettings(r104);
    L26:
        if (r117 != null) goto L28;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "getSettings not implemented in host", null, 4, null);
        return;
    L28:
        XBaseModel r118 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.d.class));
        b.d r119 = (b.d) r118;
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<T> r121 = r117.iterator();
    L30:
        if (r121.hasNext() == false) goto L32;
        re7.b r122 = (re7.b) r121.next();
        r120.put(r122.f537435a, r122.f537436b);
        goto L30
    L32:
        r119.setSettings(r120);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r118, null, 2, null);
        return;
    L25:
        r117 = null;
        goto L26
    }
}
