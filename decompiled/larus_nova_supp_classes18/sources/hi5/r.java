package hi5;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements com.bytedance.ee.bear.middleground_permission_export.model.j {
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.a a;
    public final /* synthetic */ Context b;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void b(Throwable r2) {
        this.a.onComplete();
        x.h(this.b, r2);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void c(int r1) {
        this.a.onComplete();
    }

    public r(com.bytedance.ee.bear.middleground_permission_export.model.a r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
