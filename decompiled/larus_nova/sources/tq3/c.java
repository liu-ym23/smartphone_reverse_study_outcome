package tq3;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import to.d;

/* JADX INFO: loaded from: classes14.dex */
public class c extends WindowV2ProductItemVO {
    public static final /* synthetic */ int T = 0;
    public d Q;
    public to.b R;
    public final List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> S;

    public static final class a {
        public static c a(s r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            c r101 = new c(r100.e());
            int r102 = d.f546887c;
            r101.Q = d.a.a(r100.U());
            int r103 = to.b.f546882b;
            r101.R = to.b.a.a(r100.T());
            return r101;
        }
    }

    static {
    }

    public c(List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r100) {
        this.S = r100;
    }
}
