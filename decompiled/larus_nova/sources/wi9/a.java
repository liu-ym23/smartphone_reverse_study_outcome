package wi9;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostRouterDepend;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f559863b;

    /* JADX INFO: renamed from: wi9.a$a, reason: collision with other inner class name */
    public static final class C8117a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f559864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f559865b;

        public final void a() {
            Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
            XCoreBridgeMethod.onFailure$default(this.f559864a, this.f559865b, 0, "Context not provided in host", null, 8, null);
        }

        public C8117a(a r100, XBridgeMethod.Callback r101) {
            this.f559864a = r100;
            this.f559865b = r101;
        }

        public final void b(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f559864a.onSuccess(this.f559865b, r103, r101);
        }
    }

    public a() {
        this.f559862a = "x.open";
        this.f559863b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f559863b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f559862a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<c> provideParamModel() {
        return c.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r210) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r210, "type");
        int r100 = c.f559866e;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = s.f(r110, "schema", "");
        if (r101.length() != 0) goto L5;
        boolean r112 = true;
    L7:
        if (r112 == false) goto L9;
        c r113 = null;
    L10:
        if (r113 != null) goto L13;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L13:
        C8117a r102 = new C8117a(this, r111);
        b r114 = (b) this;
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r210, "type");
        String r103 = r113.f559867a;
        if (r103 == null) goto L16;
        String r104 = r103;
    L17:
        boolean r105 = r113.f559868b;
        boolean r106 = r113.f559869c;
        Context r115 = (Context) r114.provideContext(Context.class);
        if (r115 != null) goto L20;
        r102.a();
        Unit r107 = Unit.INSTANCE;
    L20:
        Pair[] r108 = new Pair[3];
        r108[0] = TuplesKt.to("useSysBrowser", Boolean.valueOf(r106));
        XReadableMap r109 = r113.f559870d;
        if (r109 == null) goto L24;
        Map<String, Object> r116 = r109.toMap();
        if (r116 == null) goto L24;
    L25:
        r108[1] = TuplesKt.to("extra", r116);
        r108[2] = TuplesKt.to("open_schema_with_replace", Boolean.valueOf(r105));
        Map<String, ? extends Object> r117 = MapsKt.mapOf(r108);
        r56.c r118 = (r56.c) r114.provideContext(r56.c.class);
        if (r118 == null) goto L29;
        IHostRouterDepend r119 = r118.f536316d;
        if (r119 == null) goto L29;
    L33:
        if (r119 == null) goto L36;
        r119.openSchema(r114.getContextProviderFactory(), r104, r117, r210, r115);
    L36:
        if (r105 == false) goto L47;
        r56.c r120 = (r56.c) r114.provideContext(r56.c.class);
        if (r120 == null) goto L41;
        IHostRouterDepend r121 = r120.f536316d;
        if (r121 == null) goto L41;
    L45:
        if (r121 == null) goto L47;
        r121.closeView(r114.getContextProviderFactory(), r210, null, false);
    L41:
        r56.c r122 = r56.c.f536312g;
        if (r122 == null) goto L44;
        r121 = r122.f536316d;
        goto L45
    L44:
        r121 = null;
    L47:
        r102.b(new i66.b(), "");
        return;
    L29:
        r56.c r123 = r56.c.f536312g;
        if (r123 == null) goto L32;
        r119 = r123.f536316d;
        goto L33
    L32:
        r119 = null;
    L24:
        r116 = MapsKt.emptyMap();
        goto L25
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("schema");
        r104 = null;
        goto L17
    L9:
        r113 = new c();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r113.f559867a = r101;
        r113.f559868b = s.b(r110, "replace", false);
        r113.f559869c = s.b(r110, "useSysBrowser", false);
        r113.f559870d = s.e(r110, "extra");
        goto L10
    L5:
        r112 = false;
        goto L7
    }
}
