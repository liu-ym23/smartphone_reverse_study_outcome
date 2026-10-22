package iq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.selector.RootSelectAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ p c;
    public final /* synthetic */ RootSelectAdapter d;
    public final /* synthetic */ int e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        p r3 = this.c;
        if ((r3 instanceof q) == false) goto L8;
        r r4 = this.d.b;
        if (r4 == null) goto L23;
        r4.c(this.e);
        return;
    L23:
        return;
    L8:
        if ((r3 instanceof d0) == false) goto L13;
        r r5 = this.d.b;
        if (r5 == null) goto L25;
        r5.d(this.e);
        return;
    L25:
        return;
    L13:
        if ((r3 instanceof e0) == false) goto L18;
        r r6 = this.d.b;
        if (r6 == null) goto L27;
        r6.b(this.e);
        return;
    L27:
        return;
    L18:
        if ((r3 instanceof com.bytedance.ee.bear.wikiv2.selector.o) == false) goto L29;
        r r7 = this.d.b;
        if (r7 == null) goto L30;
        r7.a();
        return;
    L30:
        return;
    }

    public t(p r1, RootSelectAdapter r2, int r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
