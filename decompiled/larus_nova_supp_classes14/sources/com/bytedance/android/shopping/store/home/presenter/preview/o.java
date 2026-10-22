package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.event.StoreUserActionEvent;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface o extends com.bytedance.android.shopping.store.home.frame.presenter.f {
    void a(StoreV3LiveRoomVO r1);

    void b(ShopStatus r1);

    boolean c(String r1, View r2);

    void d(boolean r1);

    void doEventAction(String r1, Pair<String, String>... r2);

    void e();

    void f(StoreUserActionEvent r1);

    void g(String r1, Function1<? super ECCurrentPromotion, Unit> r2);

    void h(View r1, String r2);

    void i();
}
