package com.ss.android.lark.passportc.impl.v2.action;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.ComponentTaskScheduler;
import com.ss.android.lark.passportc.task.TaskType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class i<Component> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<Component> f438229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.ss.android.lark.passportc.task.d> f438230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0c.d f438231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f438232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l0c.c f438233e;

    @Override // i0c.b
    public /* bridge */ /* synthetic */ h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        return b(r100, (UserState) r101, (UserState) r102);
    }

    public h0c.b<j0c.a> b(UpdateUserContext r110, UserState r111, UserState r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.TO);
        com.ss.android.lark.passportc.api.d r113 = r110.f438256e;
        User r114 = r110.f438254c;
        UserSession r115 = r110.f438261j;
        if (r115 == null) goto L18;
        Set r100 = SetsKt.plus(this.f438230b, this.f438229a.c(r115));
        j0c.e r101 = new j0c.e(new f0c.g(r114, r115), r113.f438115d, null);
        if (r100.isEmpty() == false) goto L19;
        int r116 = h0c.b.f483503b;
        return new h0c.b.C6088b(new j0c.a(false, "online task is empty, userId:" + r114.userId, null, null, 28));
    L19:
        j0c.a r117 = new ComponentTaskScheduler(r100, TaskType.ONLINE, this.f438229a.g(), this.f438232d, this.f438231c, this.f438233e).b(r101, r113.f438113b, r113.f438114c).blockingFirst();     // Catch: NoSuchElementException -> L10
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type com.ss.android.lark.passportc.task.entity.ExecuteTaskResult");     // Catch: NoSuchElementException -> L10
        j0c.a r118 = r117;     // Catch: NoSuchElementException -> L10
    L13:
        if (r118.f496839a == false) goto L15;
        int r119 = h0c.b.f483503b;
        return new h0c.b.c(r118);
    L15:
        int r120 = h0c.b.f483503b;
        return new h0c.b.C6088b(r118);
    L10:
        e = move-exception;
        Log.e("ComponentTask", "get execute task error :" + e.getMessage());
        r118 = new j0c.a(false, "online transfer error :" + e.getMessage(), null, null, 28);
        goto L13
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public i(m<Component> r100, Set<com.ss.android.lark.passportc.task.d> r101, l0c.d r102, t r103, l0c.c r104) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r102, "taskMonitor");
        Intrinsics.checkNotNullParameter(r103, "executors");
        Intrinsics.checkNotNullParameter(r104, "userFlowMonitor");
        this.f438229a = r100;
        this.f438230b = r101;
        this.f438231c = r102;
        this.f438232d = r103;
        this.f438233e = r104;
    }
}
