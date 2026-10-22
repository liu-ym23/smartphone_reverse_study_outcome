package tq3;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import to.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c extends WindowV2ProductItemVO {
    public static final /* synthetic */ int T = 0;
    public d Q;
    public to.b R;
    public final List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> S;

    public static final class a {
        public static c a(s r2) {
            Intrinsics.checkNotNullParameter(r2, "dto");
            c r0 = new c(r2.e());
            int r1 = d.c;
            r0.Q = d.a.a(r2.U());
            int r3 = to.b.b;
            r0.R = to.b.a.a(r2.T());
            return r0;
        }
    }

    static {
    }

    public c(List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r1) {
        this.S = r1;
    }
}
