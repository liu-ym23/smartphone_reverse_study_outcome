package dr2;

import com.bytedance.android.livehostapi.business.IHostWallet;

/* JADX INFO: loaded from: classes11.dex */
public final class b0 implements j, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostWallet f469741a;

    @Override // dr2.j
    public final boolean isFinancialVisible() {
        return true;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b0() {
        this.f469741a = (IHostWallet) jc1.k.f(IHostWallet.class);
    }
}
