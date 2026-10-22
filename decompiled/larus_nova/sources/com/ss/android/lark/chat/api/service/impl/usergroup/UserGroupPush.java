package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.n;
import a2b.o;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class UserGroupPush implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f411665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f411666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f411667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> f411668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Throwable, Unit> f411669e;

    public static final class a {
    }

    static {
    }

    @Override // a2b.n
    public final void C3(com.ss.android.lark.biz.im.api.usergroup.a r100) {
        if (this.f411666b.isEnabled() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> r101 = this.f411668d;
        if (r101.isEmpty() == false) goto L18;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (r101.isEmpty() == false) goto L13;
        this.f411665a.a(new UserGroupPush$startPush$1$1(this), this.f411669e);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
    L18:
        r101.add(r100);
    }

    @Override // a2b.n
    public final void vc(com.ss.android.lark.biz.im.api.usergroup.a r100) {
        if (this.f411666b.isEnabled() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> r101 = this.f411668d;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        if (r101.isEmpty() == false) goto L22;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (r101.isEmpty() == false) goto L17;
        this.f411665a.b();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Inject
    public UserGroupPush(b r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "pushRepo");
        Intrinsics.checkNotNullParameter(r101, "userGroupService");
        this.f411665a = r100;
        this.f411666b = r101;
        this.f411667c = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-user-group-push"));
        this.f411668d = new CopyOnWriteArrayList();
        this.f411669e = UserGroupPush$onError$1.INSTANCE;
    }
}
