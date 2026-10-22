package vg3;

import android.graphics.Rect;
import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface i0 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    com.bytedance.android.shopping.prepurchase.business.pdp.view.i H(String r1);

    View K(String r1);

    View N();

    void R0();

    Rect a1();

    j73.g b();

    View getContentView();

    void h(List<String> r1);

    Boolean i();

    void j0(View r1);

    com.bytedance.android.shopping.prepurchase.arch.container.state.d q1();

    void r1(Function1<? super Rect, Unit> r1);
}
