package qa0;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements o, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f532213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.core.b f532214b;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        f r100 = new f(this.f532214b);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = k.f470908a;
        this.f532213a = r100;
        l.a(r100);
        b r102 = c.f532211a;
        Intrinsics.checkNotNullParameter(this, "impl");
        c.f532211a = this;
    }

    public d(com.bytedance.android.live.recharge.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeScope");
        this.f532214b = r100;
    }

    @Override // qa0.b
    public final <T extends a> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        m r101 = m.f163449e;
        f r102 = this.f532213a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("incentiveScope");
    L6:
        return (T) r101.d(r102, r100);
    }
}
