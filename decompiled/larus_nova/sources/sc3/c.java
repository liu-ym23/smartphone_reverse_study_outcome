package sc3;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import kotlin.jvm.functions.Function1;
import tf3.l;

/* JADX INFO: loaded from: classes13.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ String a(c r110, Uri r111, FragmentManager r112, UltimateBuyParams r113, UltimateBuyStyleParams r114, String r115, Object r116, Function1 r117, Function1 r118, Function1 r210, int r211) {
            if ((r211 & 1) == 0) goto L5;
            Uri r100 = null;
        L7:
            return r110.d(r100, r113, r114, r115, r116, r117, r118, r210, false);
        L5:
            r100 = r111;
            goto L7
        }
    }

    String a(Uri r100, UltimateBuyParams r101, UltimateBuyStyleParams r102, String r103);

    void b(IOrderSchema r100);

    void c();

    String d(Uri r100, UltimateBuyParams r101, UltimateBuyStyleParams r102, String r103, Object r104, Function1 r105, Function1 r106, Function1 r107, boolean r108);

    com.bytedance.android.shopping.skubuy.start_flow.a e();

    void f(String r100, String r101);

    void g(Context r100, IOrderSchema r101);

    String h(Uri r100, UltimateBuyParams r101, UltimateBuyStyleParams r102, String r103);

    void i(IOrderSchema r100);

    void j(String r100, String r101);

    String k(IOrderSchema r100);

    void l(ql.a r100, l r101, BuyNowPrefetchType r102);

    String m(Context r100, IOrderSchema r101);

    com.bytedance.android.shopping.buynow.monitor.firstscreen.a n(com.bytedance.android.ec.model.d r100);

    com.bytedance.android.shopping.buynow.monitor.firstscreen.a o();

    void p(IOrderSchema r100);

    String q(String r100, EntranceInfoScene r101);

    String r(Context r100, IOrderSchema r101);
}
