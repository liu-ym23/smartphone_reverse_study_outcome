package uq3;

import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f551240b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.ec.window.base.repository.vo.d f551241a;

    public static final class a {
        public static l a(WindowFollowCommitDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            l r101 = new l();
            r100.getFollowSuccessMsg();
            com.bytedance.android.ec.window.base.repository.dto.s r102 = r100.getHybridComponentDTO();
            if (r102 == null) goto L5;
            int r103 = com.bytedance.android.ec.window.base.repository.vo.d.f49497a;
            com.bytedance.android.ec.window.base.repository.vo.d r104 = com.bytedance.android.ec.window.base.repository.vo.d.a.a(r102);
        L6:
            r101.f551241a = r104;
            return r101;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    public l() {
    }
}
