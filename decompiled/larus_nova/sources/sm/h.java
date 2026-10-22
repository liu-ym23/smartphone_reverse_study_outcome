package sm;

import android.view.View;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes44.dex */
public interface h {
    String a();

    Function3<String, String, Long, Unit> b();

    LayoutTypes c();

    String d();

    Function1<Integer, Unit> e();

    xm.c f();

    String g();

    boolean h(StoreV2ProductItemVO r100);

    void i(View r100);

    boolean isClickable();

    r j(Integer r100);

    qn.a<ECVideoPlayer> k();

    long l();

    boolean m(StoreV2ProductItemVO r100);

    Integer n();

    xm.c o();

    r p(Integer r100);

    jm.a<ej3.a> q();
}
