package tj2;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.LivePromotionListLocalDataSourceUpdateDelegate;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    PromotionCategory b();

    void e(String r1);

    List<ql.a> f();

    ql.a g();

    void i();

    void j(String r1, List<? extends ql.a> r2, int r3, int r4, int r5, List<j> r6);

    LivePromotionListLocalDataSourceUpdateDelegate k();

    void l(PromotionCategory r1);

    void m();

    LivePromotionListTabPromotionData n(String r1);

    void o(boolean r1, boolean r2, int r3, int r4, boolean r5, List r6, Function0 r7);

    List<PromotionCategory> p(List<PromotionCategory> r1);

    Pair<List<ql.a>, List<j>> q(String r1, String r2, mj2.e r3, int r4);

    mj2.e r();

    void s(List<? extends ql.a> r1);
}
