package tj2;

import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ Observable a(e r7, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r8, int r9, int r10, int r11, boolean r12) {
            return r7.a(r8, r9, r10, r11, false, r12);
        }
    }

    Observable<vj2.b> a(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, int r2, int r3, int r4, boolean r5, boolean r6);

    Observable<ECPromotionListTopData> b(String r1, String r2, String r3, String r4);

    Observable<vj2.a> c(String r1, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2, List<vj2.d> r3, Map<String, String> r4);

    void d(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, int r2, int r3, boolean r4, com.bytedance.android.ec.core.async.b r5, Function2 r6, Function0 r7);

    @Deprecated(message = "尽量不要直接调用此方法, 可以直接使用包含了向下重试能力的标准能力", replaceWith = @ReplaceWith(expression = "requestFirstPageDataWithProductBlockingCheck", imports = {}))
    void e(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, int r2, int r3, int r4, com.bytedance.android.ec.core.async.b r5, Function3<? super Boolean, ? super Integer, ? super vj2.b, Unit> r6);
}
