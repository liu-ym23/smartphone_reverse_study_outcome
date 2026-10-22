package ui9;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.utils.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f550214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550215b;

    /* JADX INFO: renamed from: ui9.a$a, reason: collision with other inner class name */
    public static final class C7888a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f550216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f550217b;

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            XCoreBridgeMethod.onFailure$default(this.f550216a, this.f550217b, 0, r100, null, 8, null);
        }

        public C7888a(a r100, XBridgeMethod.Callback r101) {
            this.f550216a = r100;
            this.f550217b = r101;
        }
    }

    public a() {
        this.f550214a = XBridgeMethod.Access.PROTECT;
        this.f550215b = "x.login";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f550214a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f550215b;
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
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = c.f550218b;
        Intrinsics.checkNotNullParameter(r100, "params");
        XReadableMap r104 = s.e(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        s.b(r100, "keepOpen", true);
        c r105 = new c();
        if (r104 == null) goto L5;
        r105.f550219a = r104;
    L5:
        C7888a r106 = new C7888a(this, r101);
        b r107 = (b) this;
        Intrinsics.checkNotNullParameter(r105, "params");
        Intrinsics.checkNotNullParameter(r106, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r108 = (Context) r107.provideContext(Context.class);
        if (r108 != null) goto L9;
        r106.a("context is null");
        return;
    L9:
        if (f.f249557a.getActivity(r108) != null) goto L11;
        r106.a("context can not convert to activity");
        return;
    L11:
        r56.c r109 = (r56.c) r107.provideContext(r56.c.class);
        r56.c r110 = r56.c.f536312g;
        r106.a("hostUserDepend is null");
        Unit r111 = Unit.INSTANCE;
    }
}
