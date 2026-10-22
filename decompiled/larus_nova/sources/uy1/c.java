package uy1;

import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.scope.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f552066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ty1.b f552067b;

    public c(e r100, ty1.b r101) {
        this.f552066a = r100;
        this.f552067b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        k r102 = this.f552066a.f552076g;
        m r103 = m.f163449e;
        com.bytedance.android.livesdk.revenue.service.sti.a r104 = (com.bytedance.android.livesdk.revenue.service.sti.a) r103.d(r102, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        int r105 = 0;
        if (r104 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r106 = r104.cd();
        if (r106 == null) goto L9;
        Integer r107 = r106.getValue();
        if (r107 == null) goto L9;
        int r108 = r107.intValue();
    L10:
        com.bytedance.android.livesdk.revenue.service.sti.a r109 = (com.bytedance.android.livesdk.revenue.service.sti.a) r103.d(this.f552066a.f552076g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r109 == null) goto L17;
        com.bytedance.live.datacontext.m<Integer> r110 = r109.sh();
        if (r110 == null) goto L17;
        Integer r111 = r110.getValue();
        if (r111 == null) goto L17;
        r105 = r111.intValue();
    L17:
        e.a(this.f552066a, r108, r101.intValue(), r105, this.f552067b.getType());
        return;
    L9:
        r108 = 0;
        goto L10
    }
}
