package sc3;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public interface i {
    void a(Context r100, Uri r101, boolean r102, ea3.b r103);

    boolean b(int r100);

    boolean c(int r100, int r101, int r102);

    void d(Uri r100, ea3.b r101, String r102, boolean r103);

    void e(IOrderSchema r100, nl.f r101, Function0<Unit> r102);

    String f(SkuParams r100, int r101);

    String g(String r100, nl.f r101, Function0<Unit> r102);

    xh3.a h(String r100);

    qh3.d i(FragmentManager r100, SkuParams r101, l r102, Object r103, Function2 r104, Function1 r105, Function1 r106, Function1 r107, Function1 r108, Function1 r110, ul.i r111, Function0 r112, Context r113);

    boolean j(FragmentManager r100, Uri r101, int r102, int r103, String r104);

    com.bytedance.android.shopping.sku.inner.ultimate.c k(FragmentManager r100, SkuParams r101, l r102, Object r103, Function1 r104, Function1 r105, Function1 r106, int r107);

    boolean l(String r100);

    @Deprecated(message = "已全量，diff方法下线")
    void m(Uri r100);

    @Deprecated(message = "已全量，diff方法下线")
    void n(SkuParams r100);

    boolean o(FragmentManager r100, IOrderSchema r101, int r102, int r103, String r104);
}
