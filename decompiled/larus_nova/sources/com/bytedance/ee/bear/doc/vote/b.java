package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.reminder.ReminderViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ReminderViewModel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeVotePlugin.c f218434b;

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void h() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void k() {
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void onClose() {
        OfficeVotePlugin.access$700(this.f218434b.f218380a).setActive(false);
    }

    @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
    public final void i(com.bytedance.ee.bear.reminder.model.a r100) {
        if (r100 != null) goto L4;
    L6:
        OfficeVotePlugin.access$700(this.f218434b.f218380a).setActive(false);
        return;
    L4:
        if (this.f218433a == null) goto L6;
        OfficeVotePlugin.SelectVoteExpirationDateResult r101 = new OfficeVotePlugin.SelectVoteExpirationDateResult(null);
        r101.setExpireTime(r100.f236476b);
        this.f218433a.a(r101);
        goto L6
    }

    public b(OfficeVotePlugin.c r100, tb5.m r101) {
        this.f218434b = r100;
        this.f218433a = r101;
    }
}
