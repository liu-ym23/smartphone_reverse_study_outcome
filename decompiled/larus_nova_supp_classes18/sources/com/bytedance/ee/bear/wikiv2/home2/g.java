package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.u0;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpacesResp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ WikiHomeFragment2 a;

    public g(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        cu5.b.c r6 = (cu5.b) r5;
        if ((r6 instanceof cu5.b.b) == false) goto L8;
        com.bytedance.ee.bear.list.loadstateview.h r7 = this.a.X90().e;
        if (r7 == null) goto L25;
        r7.j();
        return;
    L25:
        return;
    L8:
        if ((r6 instanceof cu5.b.c) == false) goto L17;
        com.bytedance.ee.bear.wikiv2.home2.model.l r8 = (com.bytedance.ee.bear.wikiv2.home2.model.l) r6.a;
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        ((k) r0.k.getValue()).a(r8.b);
        this.a.X90().setData(r8);
        if (r8.c != WikiSpacesResp.Origin.Cache) goto L12;
        String r9 = "load_db_data";
    L13:
        gq5.b.b(this.a.r, r9);
        u0 r10 = this.a.o;
        if (r10 == null) goto L27;
        r10.a();
        return;
    L27:
        return;
    L12:
        r9 = "load_from_network";
        goto L13
    L17:
        if ((r6 instanceof cu5.b.a) == false) goto L24;
        WikiHomeFragment2 r2 = this.a;
        int r3 = WikiHomeFragment2.s;
        ((k) r2.k.getValue()).a(false);
        WikiHomeRecentSpaceView r4 = this.a.X90();
        cu5.b.a r11 = (cu5.b.a) r6;
        Throwable r12 = r11.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r12, "throwable");
        com.bytedance.ee.bear.list.loadstateview.h r13 = r4.e;
        if (r13 == null) goto L21;
        r13.b(r12);
    L21:
        gq5.b.a(this.a.r, 1, Integer.valueOf(tp5.b.a(r11.a)), null, 8);
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
