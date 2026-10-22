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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface i {
    void a(Context r1, Uri r2, boolean r3, ea3.b r4);

    boolean b(int r1);

    boolean c(int r1, int r2, int r3);

    void d(Uri r1, ea3.b r2, String r3, boolean r4);

    void e(IOrderSchema r1, nl.f r2, Function0<Unit> r3);

    String f(SkuParams r1, int r2);

    String g(String r1, nl.f r2, Function0<Unit> r3);

    xh3.a h(String r1);

    qh3.d i(FragmentManager r1, SkuParams r2, l r3, Object r4, Function2 r5, Function1 r6, Function1 r7, Function1 r8, Function1 r9, Function1 r10, ul.i r11, Function0 r12, Context r13);

    boolean j(FragmentManager r1, Uri r2, int r3, int r4, String r5);

    com.bytedance.android.shopping.sku.inner.ultimate.c k(FragmentManager r1, SkuParams r2, l r3, Object r4, Function1 r5, Function1 r6, Function1 r7, int r8);

    boolean l(String r1);

    @Deprecated(message = "已全量，diff方法下线")
    void m(Uri r1);

    @Deprecated(message = "已全量，diff方法下线")
    void n(SkuParams r1);

    boolean o(FragmentManager r1, IOrderSchema r2, int r3, int r4, String r5);
}
