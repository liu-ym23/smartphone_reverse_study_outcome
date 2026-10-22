package sq3;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.m0;
import com.bytedance.android.window.shop.repository.dto.n0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uq3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends tq3.c {
    public static final /* synthetic */ int W = 0;
    public s U;
    public Long V;

    public static final class a {
        public static h a(m0 r4) {
            Intrinsics.checkNotNullParameter(r4, "dto");
            n0 r1 = r4.a();
            Long r2 = null;
            if (r1 == null) goto L7;
            WindowV2ProductItemDTO r3 = r1.a;
            if (r3 == null) goto L7;
            List r5 = r3.e();
        L8:
            h r0 = new h(r5);
            n0 r6 = r4.a();
            if (r6 == null) goto L13;
            WindowV2ProductItemDTO r7 = r6.a;
            if (r7 == null) goto L13;
            WindowV2ProductItemVO.P.getClass();
            WindowV2ProductItemVO.a.b(r7, r0);
        L13:
            n0 r8 = r4.a();
            if (r8 == null) goto L16;
            r2 = r8.a();
        L16:
            r0.V = r2;
            n0 r9 = r4.a();
            if (r9 == null) goto L21;
            com.bytedance.android.window.shop.repository.dto.g r10 = r9.b();
            if (r10 == null) goto L21;
            int r11 = s.c;
            r0.U = s.a.a(r10);
        L21:
            return r0;
        L7:
            r5 = null;
            goto L8
        }
    }

    static {
    }

    public h(List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r1) {
        super(r1);
    }
}
