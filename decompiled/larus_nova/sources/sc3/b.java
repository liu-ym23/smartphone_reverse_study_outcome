package sc3;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.data.api.ChainPoint;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public interface b {
    HashMap<ChainPoint, Long> a();

    String b(String r100);

    void c(ChainPoint r100, Long r101);

    void d(IOrderSchema r100);
}
