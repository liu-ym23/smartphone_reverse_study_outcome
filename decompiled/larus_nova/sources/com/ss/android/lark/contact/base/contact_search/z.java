package com.ss.android.lark.contact.base.contact_search;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;

/* JADX INFO: loaded from: classes35.dex */
public final class z implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f418845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f418846b;

    public z(b0 r100, String r101) {
        this.f418846b = r100;
        this.f418845a = r101;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.s.a
    public final void a(String r100, boolean r101, boolean r102) {
        this.f418846b.f418776b.v3(r100, r101);
        InvHitPoint.e(r102);
        b0 r103 = this.f418846b;
        String r104 = this.f418845a;
        r103.getClass();
        if (r104.contains("@") == false) goto L5;
        InvHitPoint.c(InvHitPoint.ShareMethod.INVITE_EMAIL, r103.f418776b.getUniqueId());
        return;
    L5:
        InvHitPoint.c(InvHitPoint.ShareMethod.INVITE_MESSAGE, r103.f418776b.getUniqueId());
    }
}
