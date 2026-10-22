package com.bytedance.ee.bear.more.pageview2;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.m;
import fo5.d;
import io.reactivex.Flowable;
import java.util.HashMap;
import tj5.i;
import tj5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public final /* synthetic */ HashMap c;
    public final /* synthetic */ PageViewFragment.b d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        ((wi5.a) org.koin.java.a.a(wi5.a.class)).b("operation_records", "ccm_space_all_contents_view");
        PageViewFragment.b r6 = this.d;
        FragmentActivity r0 = r6.E.getActivity();
        if (r0 == null) goto L6;
        PageViewFragment r1 = r6.E;
        b r2 = new b(r6, r0);
        r1.x = r2;
        m.b(r2, 400);
    L6:
        PageViewFragment r7 = this.d.E;
        zk5.b r3 = (zk5.b) org.koin.java.a.a(zk5.b.class);
        PageViewFragment r4 = this.d.E;
        Flowable r8 = r3.a(r4.p, r4.o).observeOn(d.d());
        final HashMap r9 = this.c;
        r7.z = r8.subscribe(new i(this, r9), new j(this, r9));
    }

    public a(PageViewFragment.b r1, HashMap r2) {
        this.d = r1;
        this.c = r2;
    }
}
