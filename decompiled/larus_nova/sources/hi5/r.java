package hi5;

import android.content.Context;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements com.bytedance.ee.bear.middleground_permission_export.model.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.a f485327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f485328b;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void b(Throwable r100) {
        this.f485327a.onComplete();
        x.h(this.f485328b, r100);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void c(int r100) {
        this.f485327a.onComplete();
    }

    public r(com.bytedance.ee.bear.middleground_permission_export.model.a r100, Context r101) {
        this.f485327a = r100;
        this.f485328b = r101;
    }
}
