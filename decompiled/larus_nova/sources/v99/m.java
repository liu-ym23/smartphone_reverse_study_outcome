package v99;

import androidx.fragment.app.Fragment;
import com.larus.feishu.office.im.impl.base.u0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m implements bya.a {
    public m() {
    }

    @Override // bya.a
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        w99.a r101 = u0.a(r100);
        if (r101 == null) goto L6;
        r101.LC();
        return;
    }

    @Override // bya.a
    public final void b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        w99.a r101 = u0.a(r100);
        if (r101 == null) goto L6;
        r101.wX();
        return;
    }
}
