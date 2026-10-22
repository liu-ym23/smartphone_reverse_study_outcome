package qf3;

import com.bytedance.android.shopping.mall.LynxMallFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f532726a;

    public h(LynxMallFragment.b r100) {
        this.f532726a = r100;
    }

    @Override // qf3.g
    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        g r101 = this.f532726a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
