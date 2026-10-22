package t3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.scan.AbsScanCodeMethodIDL;
import com.bytedance.ai.bridge.service.ScanCodeCallback;
import com.bytedance.ai.bridge.service.ScanCodeResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a2 implements ScanCodeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsScanCodeMethodIDL.b> f544243a;

    public a2(f3.h<AbsScanCodeMethodIDL.b> r100) {
        this.f544243a = r100;
    }

    @Override // com.bytedance.ai.bridge.service.ScanCodeCallback
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.bytedance.ai.utils.g r101 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r102 = new StringBuilder("call failed, errNo=");
        f3.a r103 = f3.a.f475265f;
        r102.append(r103.f475285a);
        r102.append(", msg=");
        r102.append(r100);
        r101.e("AISDK_JSB_ScanCodeMethod", r102.toString());
        f3.h.a.a(this.f544243a, r100, r103, null, 10);
    }

    @Override // com.bytedance.ai.bridge.service.ScanCodeCallback
    public final void onSuccess(ScanCodeResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_ScanCodeMethod", "call success");
        f3.h<AbsScanCodeMethodIDL.b> r101 = this.f544243a;
        Intrinsics.checkNotNullParameter(AbsScanCodeMethodIDL.b.class, "<this>");
        BaseModel r102 = k3.c.a(AbsScanCodeMethodIDL.b.class);
        AbsScanCodeMethodIDL.b r103 = (AbsScanCodeMethodIDL.b) r102;
        r103.setCharacterSet(r100.getCharacterSet());
        r103.setPath(r100.getPath());
        r103.setRawData(r100.getRawData());
        r103.setResult(r100.getResult());
        r103.setScanType(r100.getScanType());
        f3.h.a.b(r101, (ResultModel) r102);
    }
}
