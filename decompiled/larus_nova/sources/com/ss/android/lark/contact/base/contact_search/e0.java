package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: classes35.dex */
public final class e0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f418801a;

    public e0(b0 r100) {
        this.f418801a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f418801a.getClass();
        Statistics.sendEvent("invite_people_external_search_nomatch_invite", InvHitPoint.b(null));
        this.f418801a.f418776b.H4();
    }
}
