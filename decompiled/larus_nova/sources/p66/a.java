package p66;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import i66.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527916a;

    /* JADX INFO: renamed from: p66.a$a, reason: collision with other inner class name */
    public static final class C7156a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f527918b;

        public final void a() {
            Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
            XCoreBridgeMethod.onFailure$default(this.f527917a, this.f527918b, 0, "Context not provided in host", null, 8, null);
        }

        public C7156a(a r100, XBridgeMethod.Callback r101) {
            this.f527917a = r100;
            this.f527918b = r101;
        }

        public final void b(b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = b.f488436a;
            Map<String, Object> r103 = b.a.a(r100);
            this.f527917a.onSuccess(this.f527918b, r103, r101);
        }
    }

    public abstract void e(q66.a r100, C7156a r101, XBridgePlatformType r102);

    public a() {
        this.f527916a = "x.close";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f527916a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<q66.a> provideParamModel() {
        return q66.a.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b> provideResultModel() {
        return b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = q66.a.f531804b;
        Intrinsics.checkNotNullParameter(r100, "params");
        String r104 = s.f(r100, "containerID", "");
        s.b(r100, GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, false);
        v r105 = s.a(r100, "containerIDs");
        q66.a r106 = new q66.a();
        r104.length();
        if (r105 == null) goto L10;
        List<Object> r107 = r105.toList();
        if (r107 == null) goto L10;
        List<Object> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L8:
        if (r110.hasNext() == false) goto L11;
        r109.add(String.valueOf(r110.next()));
    L11:
        r106.f531805a = r109;
        e(r106, new C7156a(this, r101), r102);
        return;
    L10:
        r109 = null;
        goto L11
    }
}
