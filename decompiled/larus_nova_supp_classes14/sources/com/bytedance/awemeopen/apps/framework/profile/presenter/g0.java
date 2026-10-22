package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final ConstraintLayout e;
    public final DampScrollableLayout f;
    public e0 g;
    public int h;
    public User i;
    public final d0 j;

    @Override // f04.a
    public final void k() {
        this.d.b.getServerUserInfo().removeObserver(this.j);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.d0] */
    public g0(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = i(2131383197);
        this.f = (DampScrollableLayout) i(2131385230);
        this.j = new d0(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.d.b.getServerUserInfo().observe(this.d.c, this.j);
    }

    public final View m(int r5, int r6, int r7) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131558691, this.e, false);
        ((ImageView) r0.findViewById(2131375008)).setImageResource(r5);
        ((TextView) r0.findViewById(2131388877)).setText(r6);
        ((TextView) r0.findViewById(2131367826)).setText(r7);
        return r0;
    }
}
