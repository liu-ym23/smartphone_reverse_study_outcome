package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final ConstraintLayout e;
    public final DmtTextView f;
    public final ConstraintLayout g;
    public final DmtTextView h;
    public final DmtTextView i;
    public final DmtTextView j;
    public User k;
    public final y24.d l;
    public final i m;

    @Override // f04.a
    public final void k() {
        this.d.b.getServerUserInfo().removeObserver(this.m);
    }

    public final void m() {
        User r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0.k()) == true) goto L7;
        this.i.setText(r0.k());
        return;
    L7:
        this.i.setText(this.l.w0(this.k));
    }

    /* JADX WARN: Type inference failed for: r2v23, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.i] */
    public j(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = i(2131369097);
        this.f = (DmtTextView) i(2131369093);
        this.g = i(2131373125);
        this.h = (DmtTextView) i(2131373122);
        this.i = (DmtTextView) i(2131373116);
        this.j = (DmtTextView) i(2131383207);
        d14.a r3 = b14.a.a;
        this.l = b14.a.a(y24.d.class);
        this.m = new i(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.d.b.getServerUserInfo().observe(this.d.c, this.m);
    }
}
