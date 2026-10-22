package sq3;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.m0;
import com.bytedance.android.window.shop.repository.dto.n0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uq3.s;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends tq3.c {
    public static final /* synthetic */ int W = 0;
    public s U;
    public Long V;

    public static final class a {
        public static h a(m0 r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            n0 r101 = r100.a();
            Long r102 = null;
            if (r101 == null) goto L7;
            WindowV2ProductItemDTO r103 = r101.f189423a;
            if (r103 == null) goto L7;
            List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r104 = r103.e();
        L8:
            h r105 = new h(r104);
            n0 r106 = r100.a();
            if (r106 == null) goto L13;
            WindowV2ProductItemDTO r107 = r106.f189423a;
            if (r107 == null) goto L13;
            WindowV2ProductItemVO.P.getClass();
            WindowV2ProductItemVO.a.b(r107, r105);
        L13:
            n0 r108 = r100.a();
            if (r108 == null) goto L16;
            r102 = r108.a();
        L16:
            r105.V = r102;
            n0 r109 = r100.a();
            if (r109 == null) goto L21;
            com.bytedance.android.window.shop.repository.dto.g r110 = r109.b();
            if (r110 == null) goto L21;
            int r111 = s.f551283c;
            r105.U = s.a.a(r110);
        L21:
            return r105;
        L7:
            r104 = null;
            goto L8
        }
    }

    static {
    }

    public h(List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r100) {
        super(r100);
    }
}
