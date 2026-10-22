package nh3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.sku.common.slice.element.SkuCommonTagFlowLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends com.bytedance.android.ecom.arch.slice.render.elements.a<SkuCommonTagFlowLayout> {
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void I0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
    }

    public h(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.a
    public final ViewGroup K1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new SkuCommonTagFlowLayout(r100, null, 6, 0);
    }
}
