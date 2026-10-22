package lr;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class o1 implements IVisitUnit {
    public o1() {
    }

    @Override // com.bytedance.android.ec.common.api.debugtool.IVisitUnit
    public final void hookToDirectCall(String r100, Function0<? extends JSONObject> r101) {
    }

    @Override // com.bytedance.android.ec.common.api.debugtool.IVisitUnit
    public final void hookToRequest(String r100, Function0<? extends JSONObject> r101) {
    }

    @Override // com.bytedance.android.ec.common.api.debugtool.IVisitUnit
    public final void hookToSchema(String r100, Function0<String> r101) {
    }

    @Override // com.bytedance.android.ec.common.api.debugtool.IVisitUnit
    public final void startDisplayRoutesDebug(FrameLayout r100, Function0<? extends JSONObject> r101) {
    }

    @Override // com.bytedance.android.ec.common.api.debugtool.IVisitUnit
    public final void startDisplayRoutesRecords(Context r100) {
    }
}
