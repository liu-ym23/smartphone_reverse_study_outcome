package si9;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.bytedance.ies.xbridge.base.runtime.model.SettingValueType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f542240b;

    /* JADX INFO: renamed from: si9.a$a, reason: collision with other inner class name */
    public static final class C7618a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f542241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f542242b;

        public C7618a(a r100, XBridgeMethod.Callback r101) {
            this.f542241a = r100;
            this.f542242b = r101;
        }

        public final void a(int r100, String r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            XCoreBridgeMethod.onFailure$default(this.f542241a, this.f542242b, r100, r110, null, 8, null);
        }

        public final void b(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f542248b;
            Intrinsics.checkNotNullParameter(r100, "data");
            if (r100.f542249a != null) goto L5;
            LinkedHashMap r103 = null;
        L9:
            if (r103 != null) goto L12;
            XCoreBridgeMethod.onFailure$default(this.f542241a, this.f542242b, -5, null, null, 12, null);
            return;
        L12:
            this.f542241a.onSuccess(this.f542242b, r103, r101);
            return;
        L5:
            LinkedHashMap r104 = new LinkedHashMap();
            Map<String, Object> r105 = r100.f542249a;
            if (r105 == null) goto L8;
            r104.put("settings", r105);
        L8:
            r103 = r104;
            goto L9
        }
    }

    public a() {
        this.f542239a = "x.getSettings";
        this.f542240b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f542240b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f542239a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<c> provideParamModel() {
        return c.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d> provideResultModel() {
        return d.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r210, XBridgePlatformType r211) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        Intrinsics.checkNotNullParameter(r211, "type");
        int r100 = c.f542243b;
        Intrinsics.checkNotNullParameter(r110, "params");
        v r101 = s.a(r110, "keys");
        if (r101 != null) goto L5;
        c r111 = null;
    L23:
        if (r111 != null) goto L26;
        XCoreBridgeMethod.onFailure$default(this, r210, -3, null, null, 12, null);
        return;
    L26:
        C7618a r102 = new C7618a(this, r210);
        b r103 = (b) this;
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r211, "type");
        List<c.b> r104 = r111.f542244a;
        if (r104 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("keys");
        r104 = null;
    L30:
        ArrayList r105 = new ArrayList();
        LinkedHashSet r106 = new LinkedHashSet();
        Iterator<T> r107 = r104.iterator();
    L32:
        if (r107.hasNext() == false) goto L46;
        c.b r108 = (c.b) r107.next();
        String r109 = r108.f542245a;
        String r112 = r108.f542247c;
        SettingValueType.a r113 = SettingValueType.Companion;
        String r114 = r108.getType();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "type");
        SettingValueType r115 = SettingValueType.valueOf(r114.toUpperCase(Locale.getDefault()));     // Catch: IllegalArgumentException -> L36
    L38:
        if (r109.length() <= 0) goto L40;
        boolean r116 = true;
    L41:
        if (r116 == false) goto L32;
        if (r115 == SettingValueType.UNSUPPORTED) goto L32;
        s56.a r117 = new s56.a(r109, r115);
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r105.add(r117);
        r106.add(r109);
        goto L32
    L40:
        r116 = false;
    L36:
        r115 = SettingValueType.UNSUPPORTED;
        goto L38
    L46:
        if (r105.isEmpty() == false) goto L49;
        r102.a(-3, "empty key or unsupported key type in params");
        return;
    L49:
        if (r106.size() >= r105.size()) goto L51;
        r102.a(-3, "duplicate keys in params");
        return;
    L51:
        r56.c r118 = (r56.c) r103.provideContext(r56.c.class);
        if (r118 == null) goto L55;
        IHostContextDepend r119 = r118.f536314b;
        if (r119 == null) goto L55;
    L59:
        if (r119 == null) goto L61;
        List<s56.b> r120 = r119.getSettings(r105);
    L62:
        if (r120 != null) goto L64;
        r102.a(0, "getSettings not implemented in host");
        return;
    L64:
        d r121 = new d();
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator<T> r123 = r120.iterator();
    L66:
        if (r123.hasNext() == false) goto L68;
        ((s56.b) r123.next()).getClass();
        r122.put(null, null);
        goto L66
    L68:
        r121.f542249a = r122;
        r102.b(r121, "");
        return;
    L61:
        r120 = null;
    L55:
        r56.c r124 = r56.c.f536312g;
        if (r124 == null) goto L58;
        r119 = r124.f536314b;
        goto L59
    L58:
        r119 = null;
        goto L59
    L5:
        r111 = new c();
        ArrayList r125 = new ArrayList();
        int r126 = r101.size();
        int r127 = 0;
    L6:
        if (r127 >= r126) goto L22;
        XReadableMap r128 = r101.getMap(r127);
        if (r128 == null) goto L20;
        String r129 = s.f(r128, "key", "");
        v r130 = r101;
        String r131 = s.f(r128, "type", "");
        int r132 = r126;
        String r133 = s.f(r128, "biz", "");
        if (r129.length() <= 0) goto L12;
        boolean r134 = true;
    L13:
        if (r134 == false) goto L21;
        if (r131.length() <= 0) goto L17;
        boolean r135 = true;
    L18:
        if (r135 == false) goto L21;
        c.b r136 = new c.b(r129, r131);
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        r136.f542247c = r133;
        r125.add(r136);
        goto L21
    L17:
        r135 = false;
    L21:
        r127 = r127 + 1;
        r101 = r130;
        r126 = r132;
        goto L6
    L12:
        r134 = false;
        goto L13
    L20:
        r130 = r101;
        r132 = r126;
        goto L21
    L22:
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r111.f542244a = r125;
        goto L23
    }
}
