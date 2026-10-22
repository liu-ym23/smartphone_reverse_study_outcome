package nh3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.shopping.sku.common.slice.element.SkuCommonTagFlowLayout;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends BaseSlcViewGroupManager<SkuCommonTagFlowLayout> {
    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public final void I0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "styles");
    }

    public g(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ((BaseSlcViewGroupManager) this).O3 = false;
        return new SkuCommonTagFlowLayout(r5, null, 6, 0);
    }
}
