package x56;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f562515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562516b;

    /* JADX INFO: renamed from: x56.a$a, reason: collision with other inner class name */
    public static final class C8196a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f562517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f562518b;

        public C8196a(a r100, XBridgeMethod.Callback r101) {
            this.f562517a = r100;
            this.f562518b = r101;
        }

        public final void a(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f562517a.onSuccess(this.f562518b, r103, r101);
        }
    }

    public a() {
        this.f562515a = XBridgeMethod.Access.PUBLIC;
        this.f562516b = "x.publishEvent";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f562515a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f562516b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b66.a> provideParamModel() {
        return b66.a.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = b66.a.f17850d;
        Intrinsics.checkNotNullParameter(r110, "source");
        String r101 = s.f(r110, "eventName", "");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        String r113 = null;
        if (r102 == false) goto L10;
    L16:
        b66.a r114 = null;
    L20:
        if (r114 != null) goto L23;
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L23:
        C8196a r103 = new C8196a(this, r111);
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r104 = r114.f17851a;
        if (r104 == null) goto L26;
        r113 = r104;
    L27:
        EventCenter.enqueueEvent(new Event(r113, r114.f17852b, r114.f17853c));
        r103.a(new i66.b(), "");
        return;
    L26:
        Intrinsics.throwUninitializedPropertyAccessException("eventName");
        goto L27
    L10:
        if (r110.hasKey("timestamp") == false) goto L16;
        t r105 = r110.get("timestamp");
        int r115 = b66.a.C0270a.C0271a.f17854a[r105.getType().ordinal()];
        if (r115 != 1) goto L15;
        double r106 = r105.asDouble();
    L19:
        XReadableMap r107 = s.e(r110, "params");
        r114 = new b66.a();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r114.f17851a = r101;
        r114.f17852b = (long) r106;
        r114.f17853c = r107;
        goto L20
    L15:
        if (r115 != 2) goto L16;
        r106 = r105.asDouble();
        goto L19
    L5:
        r102 = false;
        goto L6
    }
}
