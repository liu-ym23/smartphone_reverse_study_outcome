package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cl.d;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.shopping.anchorv4.helper.JisooManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.b;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;
import vg3.i;
import vg3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductDetailDebugComponent extends m implements i {
    public static final /* synthetic */ int n = 0;
    public final Lazy m;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(f0.class);
    }

    public ProductDetailDebugComponent() {
        this.m = LazyKt.lazy(new ProductDetailDebugComponent$jissoAbility$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        d r0 = k.a();
        if (r0 == null) goto L5;
        r0.q();
    L5:
        b.a(this, "initLightLeakTool: customOpt=false");
        boolean r1 = ECServiceManager.a;
        ((IECHostService) ECServiceManager.c(IECHostService.class)).initECLightLeakTool(false);
        AbsComponent.Y1(this, i.class, this, false, 12);
        AbsComponent.Y1(this, o.class, (a) this.m.getValue(), false, 12);
        a r2 = (a) this.m.getValue();
        r2.getClass();
        Disposable r3 = JisooManager.a;
        JisooManager.a(r2.a);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        a r0 = (a) this.m.getValue();
        r0.getClass();
        Disposable r1 = JisooManager.a;
        JisooManager.c(r0.a);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "container");
        FrameLayout r5 = new FrameLayout(r3.getContext());
        TextView r0 = new TextView(r3.getContext());
        r0.setText("组件化商详");
        r0.setTextColor(-16776961);
        r0.setTextSize(5.0f);
        r0.setAlpha(0.2f);
        r5.addView(r0, new FrameLayout.LayoutParams(-2, -2));
        return r5;
    }
}
