package tj2;

import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListRepository;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mj2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface f {
    List<ql.a> A();

    ql.a B();

    void D(boolean r1);

    i E(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, a r2, LivePromotionListViewModel.f r3);

    List<ql.a> F();

    void G();

    PromotionCategory b();

    void c(String r1, int r2, boolean r3);

    void e(String r1);

    List<ql.a> f();

    ql.a g();

    void i();

    void j(PromotionCategory r1);

    void k();

    int l();

    void n(String r1, String r2, String r3, LivePromotionListViewModel.h r4);

    void o();

    void p(String r1, String r2, String r3, boolean r4, Function1<? super ECPromotionListTopData, Unit> r5);

    LivePromotionListRepository q();

    ECUIPromotionLiveListConfig r();

    LivePromotionListRepository s();

    void u(rj2.b r1);

    void v(String r1, String r2, String r3, String r4, boolean r5, String r6, LivePromotionListViewModel.i r7);

    void y(int r1, Integer r2, String r3, int r4, boolean r5, boolean r6, boolean r7, Function0 r8);
}
