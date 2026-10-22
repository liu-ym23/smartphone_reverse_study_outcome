package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface d extends l, k {
    void A(l1.a r1);

    Integer B();

    boolean C();

    BottomButtonMeta D();

    Rect O();

    SkuRestoreState P();

    void Q();

    void R();

    void S();

    void T();

    void U(BottomButtonComponent r1, Object r2);

    j73.m V();

    void W(BottomTipComponent.a r1);

    ActivityVO X();

    LinkedTreeMap<String, Object> b();

    V4NativeParams c();

    boolean e();

    String f();

    void g(Disposable r1);

    int getStatusBarHeight();

    void h(List<String> r1);

    Boolean i();

    boolean j();

    void k(SkuRestoreState r1);

    void l();

    void m(IAction r1, View r2);

    long p();

    int r();

    void refresh(String r1);
}
