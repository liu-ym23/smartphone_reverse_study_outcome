package tj2;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.LivePromotionListLocalDataSourceUpdateDelegate;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import mj2.j;

/* JADX INFO: loaded from: classes10.dex */
public interface b {
    PromotionCategory b();

    void e(String r100);

    List<ql.a> f();

    ql.a g();

    void i();

    void j(String r100, List<? extends ql.a> r101, int r102, int r103, int r104, List<j> r105);

    LivePromotionListLocalDataSourceUpdateDelegate k();

    void l(PromotionCategory r100);

    void m();

    LivePromotionListTabPromotionData n(String r100);

    void o(boolean r100, boolean r101, int r102, int r103, boolean r104, List r105, Function0 r106);

    List<PromotionCategory> p(List<PromotionCategory> r100);

    Pair<List<ql.a>, List<j>> q(String r100, String r101, mj2.e r102, int r103);

    mj2.e r();

    void s(List<? extends ql.a> r100);
}
