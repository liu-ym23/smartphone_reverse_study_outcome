package vi9;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.utils.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f555354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f555355b;

    /* JADX INFO: renamed from: vi9.a$a, reason: collision with other inner class name */
    public static final class C8012a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f555356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f555357b;

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            XCoreBridgeMethod.onFailure$default(this.f555356a, this.f555357b, 0, r100, null, 8, null);
        }

        public C8012a(a r100, XBridgeMethod.Callback r101) {
            this.f555356a = r100;
            this.f555357b = r101;
        }
    }

    public a() {
        this.f555354a = XBridgeMethod.Access.PRIVATE;
        this.f555355b = "x.logout";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f555354a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f555355b;
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
        int r103 = c.f555358b;
        Intrinsics.checkNotNullParameter(r100, "params");
        XReadableMap r104 = s.e(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c r105 = new c();
        if (r104 == null) goto L5;
        r105.f555359a = r104;
    L5:
        C8012a r106 = new C8012a(this, r101);
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
    }
}
