package rj5;

import io.reactivex.Scheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements nc5.a<Boolean> {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.bytedance.ee.bear.contract.c0.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ g d;

    @Override // nc5.a
    public final void onFailure(final Throwable r9) {
        Scheduler r0 = fo5.d.d();
        final com.bytedance.ee.bear.contract.c0.a r4 = this.b;
        final String r5 = this.a;
        final int r6 = this.c;
        r0.scheduleDirect(new h(this, r9, r4, r5, r6));
    }

    @Override // nc5.a
    public final void onSuccess(Boolean r6) {
        final Boolean r7 = r6;
        Scheduler r0 = fo5.d.d();
        final String r1 = this.a;
        final com.bytedance.ee.bear.contract.c0.a r2 = this.b;
        final int r3 = this.c;
        r0.scheduleDirect(new i(r7, r1, r2, r3));
    }

    public j(g r1, String r2, com.bytedance.ee.bear.contract.c0.a r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
