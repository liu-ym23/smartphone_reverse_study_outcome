package vg3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VH;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface l extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    void B0(TopNavigationComponentV1.c r1);

    float B1();

    void D(Function1<? super Result<Rect>, Unit> r1);

    void G1(Function1<? super Boolean, Unit> r1);

    float I1();

    boolean J();

    com.bytedance.android.shopping.prepurchase.arch.container.state.d L0();

    HeaderComponent.HeaderDependencyV2.a P();

    boolean a();

    List<ECUrlModel> c();

    String f();

    RecyclerView k1();

    void m1(TopNavigationComponentV1.c r1);

    Rect m9();

    AnchorV4HeadV2VH n(ViewGroup r1);

    boolean s();

    void t(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0 r1);

    void x(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p r1);

    void z(View r1, String r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4);

    void z5(boolean r1);
}
