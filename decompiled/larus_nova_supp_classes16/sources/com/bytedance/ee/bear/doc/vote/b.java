package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.reminder.ReminderViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ReminderViewModel.a {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ OfficeVotePlugin.c b;

    public final void a() {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void j() {
    }

    public final void k() {
    }

    public final void onClose() {
        OfficeVotePlugin.access$700(this.b.a).setActive(false);
    }

    public final void i(com.bytedance.ee.bear.reminder.model.a r4) {
        if (r4 != null) goto L4;
    L6:
        OfficeVotePlugin.access$700(this.b.a).setActive(false);
        return;
    L4:
        if (this.a == null) goto L6;
        OfficeVotePlugin.SelectVoteExpirationDateResult r0 = new OfficeVotePlugin.SelectVoteExpirationDateResult(null);
        r0.setExpireTime(r4.b);
        this.a.a(r0);
        goto L6
    }

    public b(OfficeVotePlugin.c r1, tb5.m r2) {
        this.b = r1;
        this.a = r2;
    }
}
