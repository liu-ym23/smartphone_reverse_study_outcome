package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 extends f04.a<Unit> {
    public final a14.a d;
    public final o24.b e;
    public final LinearLayout f;
    public final ImageView g;
    public final DuxTextView h;
    public boolean i;
    public boolean j;
    public b0 k;

    @Override // f04.a
    public final void k() {
        b0 r0 = this.k;
        if (r0 == null) goto L6;
        this.e.T(r0);
        return;
    }

    public final void m() {
        AppCompatTextView r0 = this.h;
        o24.b r1 = this.e;
        Activity r2 = this.d.getActivity();
        Intrinsics.checkNotNull(r2);
        x04.a.b(r0, r1.q(r2, this.d.a), this.h.getContext().getResources().getString(2131894197));
        o24.b r3 = this.e;
        Activity r4 = this.d.getActivity();
        Intrinsics.checkNotNull(r4);
        boolean r5 = r3.v1(r4, this.d.a);
        this.g.setSelected(r5);
    }

    public c0(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        d14.a r3 = b14.a.a;
        this.e = b14.a.a(o24.b.class);
        this.f = (LinearLayout) i(2131378639);
        this.g = (ImageView) i(2131376117);
        this.h = (DuxTextView) i(2131390330);
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        m();
        this.i = false;
        this.j = false;
        this.f.setOnClickListener(new a0(this));
        b0 r3 = new b0(this);
        this.k = r3;
        o24.b r0 = this.e;
        Intrinsics.checkNotNull(r3);
        r0.l2(r3);
    }
}
