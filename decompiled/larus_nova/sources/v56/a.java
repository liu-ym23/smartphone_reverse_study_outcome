package v56;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements CompletionBlock<XBaseResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<XBaseParamModel, XBaseResultModel> f553269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod.a f553270b;

    @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
    public final void onRawSuccess(XBaseResultModel r100) {
        if (r100 == null) goto L5;
        Map<String, ? extends Object> r101 = r100.convert();
        if (r101 == null) goto L5;
    L6:
        this.f553270b.invoke(r101);
        return;
    L5:
        r101 = new LinkedHashMap();
        goto L6
    }

    public a(c<XBaseParamModel, XBaseResultModel> r100, IDLXBridgeMethod.a r101) {
        this.f553269a = r100;
        this.f553270b = r101;
    }

    @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Map<String, Object> r102 = r100.convert();
        if (r102 != null) goto L5;
        r102 = new LinkedHashMap();
    L5:
        c<XBaseParamModel, XBaseResultModel> r103 = this.f553269a;
        IDLXBridgeMethod.a r104 = this.f553270b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "callback");
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "msg");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("code", 1);
        r105.put("msg", r101);
        r105.put("data", r102);
        r104.invoke(r105);
    }

    @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L6;
        Map<String, Object> r103 = r102.convert();
        if (r103 == null) goto L6;
    L7:
        c<XBaseParamModel, XBaseResultModel> r104 = this.f553269a;
        IDLXBridgeMethod.a r105 = this.f553270b;
        r104.getClass();
        c.f(r105, r100, r101, r103);
        return;
    L6:
        r103 = new LinkedHashMap();
        goto L7
    }
}
