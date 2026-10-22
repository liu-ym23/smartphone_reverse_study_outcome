package lr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.IEShoppingCommonService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class n0 implements IEShoppingCommonService {
    public n0() {
    }

    @Override // com.bytedance.android.ec.common.api.IEShoppingCommonService
    public final void asyncInflate(Context r100, Map<Integer, Integer> r101) {
    }

    @Override // com.bytedance.android.ec.common.api.IEShoppingCommonService
    public final boolean asyncInflateViewRes(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.android.ec.common.api.IEShoppingCommonService
    public final View asyncInflateViewResult(Context r100, int r101, ViewGroup r102, boolean r103) {
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.IEShoppingCommonService
    public final Class<? extends mf.b> getOrderSchemaService(long r100) {
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.IEShoppingCommonService
    public final void releaseSliceTemplateCache(int r100) {
    }
}
