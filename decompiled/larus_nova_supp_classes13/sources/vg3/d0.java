package vg3;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface d0 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    Rect O();

    com.bytedance.android.shopping.prepurchase.arch.container.state.d R();

    void X0(Function0<Integer> r1);

    ProductDetailInfoComponent.b b();

    void f0(com.bytedance.android.shopping.anchorv3.widget.d r1);

    void p0(RecyclerView.OnScrollListener r1);

    void scrollTo(String r1);

    com.bytedance.android.shopping.prepurchase.arch.container.state.e<o0> x1();

    com.bytedance.android.shopping.prepurchase.arch.container.state.d z0();
}
