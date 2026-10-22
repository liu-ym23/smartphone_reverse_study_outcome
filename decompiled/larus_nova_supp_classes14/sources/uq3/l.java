package uq3;

import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final /* synthetic */ int b = 0;
    public com.bytedance.android.ec.window.base.repository.vo.d a;

    public static final class a {
        public static l a(WindowFollowCommitDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "dto");
            l r0 = new l();
            r2.getFollowSuccessMsg();
            com.bytedance.android.ec.window.base.repository.dto.s r3 = r2.getHybridComponentDTO();
            if (r3 == null) goto L5;
            int r1 = com.bytedance.android.ec.window.base.repository.vo.d.a;
            com.bytedance.android.ec.window.base.repository.vo.d r4 = com.bytedance.android.ec.window.base.repository.vo.d.a.a(r3);
        L6:
            r0.a = r4;
            return r0;
        L5:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    public l() {
    }
}
