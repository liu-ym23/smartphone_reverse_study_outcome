package kb7;

import com.bytedance.sdk.account.impl.b0;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements xqa.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jb7.a.InterfaceC6411a f502223a;

    @Override // xqa.b.a
    public final void onFail() {
        ((b0) this.f502223a).a(false, false, null);
    }

    @Override // xqa.b.a
    public final void onSuccess() {
        ((b0) this.f502223a).a(true, true, null);
    }

    public b(b0 r100) {
        this.f502223a = r100;
    }
}
