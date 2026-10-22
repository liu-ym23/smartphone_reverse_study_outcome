package com.ss.android.lark.usersetting.service.badgestyle;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f444635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserSetting f444636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f444637c;

    public final void a() {
        UserSetting r100 = this.f444635a;
        if (r100 != null) goto L5;
        return;
    L5:
        BadgeStyle r101 = r100.getBadgeStyle();
        UserSetting r102 = this.f444636b;
        if (r102 != null) goto L8;
        BadgeStyle r103 = null;
    L9:
        a.a(this.f444637c, r103, r101);
        UserSetting r104 = this.f444636b;
        if (r104 != null) goto L12;
        a.b(this.f444637c, null, Boolean.valueOf(this.f444635a.isShowNavMuteBadge()));
        return;
    L12:
        a.b(this.f444637c, Boolean.valueOf(r104.isShowNavMuteBadge()), Boolean.valueOf(this.f444635a.isShowNavMuteBadge()));
        return;
    L8:
        r103 = r102.getBadgeStyle();
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, UserSetting r101, UserSetting r102) {
        this.f444637c = r100;
        this.f444635a = r101;
        this.f444636b = r102;
    }
}
