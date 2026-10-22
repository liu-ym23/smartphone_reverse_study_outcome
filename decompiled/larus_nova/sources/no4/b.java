package no4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519902b;

    public static final class a extends com.bytedance.ies.xbridge.model.params.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f519903c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f519904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f519905b;

        /* JADX INFO: renamed from: no4.b$a$a, reason: collision with other inner class name */
        public static final class C6950a {
        }

        static {
        }

        @Override // com.bytedance.ies.xbridge.model.params.a
        public final List<String> provideParamList() {
            return CollectionsKt.listOf(new String[]{"code", "message"});
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f519904a = r100;
            this.f519905b = r101;
        }
    }

    public b() {
        this.f519902b = "bitable.showErrorView";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519902b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<? extends com.bytedance.ies.xbridge.model.params.a> provideParamModel() {
        return a.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        int r111 = a.f519903c;
        Intrinsics.checkNotNullParameter(r100, "params");
        a r102 = new a(s.d(r100, "code", 0), s.f(r100, "message", ""));
        d r103 = (d) getBridgeService(d.class);
        if (r103 == null) goto L5;
        r103.a(r102.f519904a, r102.f519905b);
    L5:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
    }
}
