package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements e {
    public final /* synthetic */ DynamicFeatureComponent a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.e
    public final SlcTemplateViewHelper b() {
        o r0 = this.a.b2();
        r0.getClass();
        SlcTemplateViewHelper r1 = new SlcTemplateViewHelper(null);
        r1.f(r0.a);
        return r1;
    }

    public b(DynamicFeatureComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.e
    public final View c(c r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "sliceKey");
        o r2 = this.a.b2();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "sliceKey");
        r2.a.getClass();
        return SlcRenderContext.f(r4, r5);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.e
    public final void d(com.bytedance.android.ecom.arch.slice.g r3, IAction r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "slice");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        this.a.b2().O0(r3, r4, r5, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.e
    public final l a(Context r10, String r11, FrameLayout r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schema");
        Intrinsics.checkNotNullParameter(r12, "lynxContainer");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.o r0 = new com.bytedance.android.shopping.prepurchase.arch.container.ability.o(r10, r11, r12, r13, false, null, 48);
        return this.a.a2().p(r0);
    }
}
