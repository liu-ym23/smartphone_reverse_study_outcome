package x56;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f562523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562524b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f562525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f562526b;

        public a(c r100, XBridgeMethod.Callback r101) {
            this.f562525a = r100;
            this.f562526b = r101;
        }

        public final void a(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f562525a.onSuccess(this.f562526b, r103, r101);
        }
    }

    public abstract void e(b66.c r100, a r101, XBridgePlatformType r102);

    public c() {
        this.f562523a = XBridgeMethod.Access.PUBLIC;
        this.f562524b = "x.unsubscribeEvent";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f562523a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f562524b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b66.c> provideParamModel() {
        return b66.c.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        int r102 = b66.c.f17859b;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r103 = s.f(r100, "eventName", "");
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        b66.c r105 = null;
    L9:
        if (r105 != null) goto L12;
        XCoreBridgeMethod.onFailure$default(this, r101, -3, null, null, 12, null);
        return;
    L12:
        e(r105, new a(this, r101), r110);
        return;
    L8:
        b66.c r106 = new b66.c();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r106.f17860a = r103;
        r105 = r106;
        goto L9
    L5:
        r104 = false;
        goto L6
    }
}
