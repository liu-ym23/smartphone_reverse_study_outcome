package com.ss.android.lark.contact.base.contact_list.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.mvp.g;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import rcc.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w8b.a f418637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalContactAdapter2 f418638b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        ContactHitPoint.b("member_avatar");
        e.a.f537201a.getClass();
        r100.getLocationInWindow(new int[2]);
        r100.getTop();
        r100.getRight();
        r100.getWidth();
        r100.getHeight();
        r100.getLocationOnScreen(new int[2]);
        ExternalContactAdapter2.a r101 = this.f418638b.f418616e;
        if (r101 == null) goto L6;
        final String r102 = this.f418637a.f558707e;
        final g r103 = (g) r101;
        qqb.c.c(new com.ss.android.lark.contact.base.contact_list.mvp.e(r103, r102));
        return;
    }

    public b(ExternalContactAdapter2 r100, w8b.a r101) {
        this.f418638b = r100;
        this.f418637a = r101;
    }
}
