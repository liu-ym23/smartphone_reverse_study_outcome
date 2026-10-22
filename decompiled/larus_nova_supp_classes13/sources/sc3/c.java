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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ String a(c r11, Uri r12, FragmentManager r13, UltimateBuyParams r14, UltimateBuyStyleParams r15, String r16, Object r17, Function1 r18, Function1 r19, Function1 r20, int r21) {
            if ((r21 & 1) == 0) goto L5;
            Uri r2 = null;
        L7:
            return r11.d(r2, r14, r15, r16, r17, r18, r19, r20, false);
        L5:
            r2 = r12;
            goto L7
        }
    }

    String a(Uri r1, UltimateBuyParams r2, UltimateBuyStyleParams r3, String r4);

    void b(IOrderSchema r1);

    void c();

    String d(Uri r1, UltimateBuyParams r2, UltimateBuyStyleParams r3, String r4, Object r5, Function1 r6, Function1 r7, Function1 r8, boolean r9);

    com.bytedance.android.shopping.skubuy.start_flow.a e();

    void f(String r1, String r2);

    void g(Context r1, IOrderSchema r2);

    String h(Uri r1, UltimateBuyParams r2, UltimateBuyStyleParams r3, String r4);

    void i(IOrderSchema r1);

    void j(String r1, String r2);

    String k(IOrderSchema r1);

    void l(ql.a r1, l r2, BuyNowPrefetchType r3);

    String m(Context r1, IOrderSchema r2);

    com.bytedance.android.shopping.buynow.monitor.firstscreen.a n(com.bytedance.android.ec.model.d r1);

    com.bytedance.android.shopping.buynow.monitor.firstscreen.a o();

    void p(IOrderSchema r1);

    String q(String r1, EntranceInfoScene r2);

    String r(Context r1, IOrderSchema r2);
}
