package mr2;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.player.k;
import com.bytedance.android.live.profit.player.n;
import com.bytedance.android.livesdk.message.model.gb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements gb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f514976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f514977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f514978c;

    @Override // com.bytedance.android.livesdk.message.model.gb.b
    public final void a() {
        this.f514978c.f88344d.onStart();
    }

    @Override // com.bytedance.android.livesdk.message.model.gb.b
    public final void b() {
        this.f514978c.f88344d.onStop();
    }

    public b(n r100) {
        this.f514978c = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb.b
    public final void d(gb.c r100) {
        Intrinsics.checkNotNullParameter(r100, "geometry");
        k r101 = this.f514978c.f88344d.b(this.f514976a, this.f514977b);
        if ((r101 instanceof k.b) == false) goto L6;
        r100.f153648c = 0;
        r100.f153649d = 0;
        r100.f153646a = s1.y();
        r100.f153647b = s1.w() - s1.A();
        return;
    L6:
        if ((r101 instanceof k.a) == false) goto L10;
        k.a r102 = (k.a) r101;
        r100.f153648c = r102.f88336a;
        r100.f153649d = r102.f88337b;
        r100.f153646a = r102.f88338c;
        r100.f153647b = r102.f88339d;
        return;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb.b
    public final void onError(Throwable r100) {
        this.f514978c.f88344d.a(r100);
    }

    @Override // com.bytedance.android.livesdk.message.model.gb.b
    public final void c(int r100, int r101) {
        this.f514976a = r100;
        this.f514977b = r101;
        this.f514978c.f88344d.onLoad();
    }
}
