package w00;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements o, q00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q00.b f557778a;

    @Override // q00.a
    public final boolean a() {
        return this.f557778a.a();
    }

    @Override // q00.a
    public final boolean c() {
        return this.f557778a.c();
    }

    @Override // q00.a
    public final void d(boolean r100) {
        this.f557778a.d(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalCommerceEffectService onStart");
    }

    public c() {
        this.f557778a = new q00.b();
    }
}
