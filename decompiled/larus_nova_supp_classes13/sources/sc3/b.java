package sc3;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.data.api.ChainPoint;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b {
    HashMap<ChainPoint, Long> a();

    String b(String r1);

    void c(ChainPoint r1, Long r2);

    void d(IOrderSchema r1);
}
