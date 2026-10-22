package nh3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.sku.common.slice.element.SkuCommonTagFlowLayout;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.ecom.arch.slice.render.elements.a<SkuCommonTagFlowLayout> {
    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public final void I0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "styles");
    }

    public h(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final ViewGroup K1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new SkuCommonTagFlowLayout(r5, null, 6, 0);
    }
}
