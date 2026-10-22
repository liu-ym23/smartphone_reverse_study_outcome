package vn2;

import com.bytedance.android.livesdk.config.ig0;
import com.bytedance.android.livesdk.config.s31;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f556428a;

    @Override // vn2.f
    public final void a() {
        this.f556428a.a();
    }

    @Override // vn2.f
    public final d b() {
        return this.f556428a.b();
    }

    @Override // vn2.f
    public final void c() {
        this.f556428a.c();
    }

    @Override // vn2.f
    public final Map<String, Long> d() {
        return this.f556428a.d();
    }

    @Override // vn2.f
    public final s31 getConfig() {
        return this.f556428a.getConfig();
    }

    public b() {
        if (ig0.f120451a.getValue().e() == false) goto L5;
        f r100 = new a();
    L6:
        this.f556428a = r100;
        return;
    L5:
        r100 = new g();
        goto L6
    }
}
