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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class h<Component> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<Component> f438224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0c.d f438225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f438226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0c.c f438227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f438228e;

    public h0c.b<j0c.a> b(UpdateUserContext r110, UserState r111, UserState r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.TO);
        com.ss.android.lark.passportc.api.d r113 = r110.f438256e;
        User r114 = r110.f438254c;
        UserSession r100 = r110.f438261j;
        if (r100 == null) goto L23;
        Set<com.ss.android.lark.passportc.task.c> r101 = this.f438224a.b(r100);
        String r115 = "foreground";
        if (r101.isEmpty() == false) goto L11;
        StringBuilder r116 = new StringBuilder();
        if (this.f438228e == true) goto L10;
        r115 = "background";
    L10:
        r116.append(r115);
        r116.append(" offline task is empty :");
        r116.append(r113.f438113b);
        String r102 = r116.toString();
        Log.i("ComponentTask", r102);
        j0c.a r117 = new j0c.a(false, r102, null, null, 28);
    L20:
        int r118 = h0c.b.f483503b;
        return new h0c.b.c(r117);
    L11:
        j0c.e r103 = new j0c.e(new f0c.g(r114, r100), r113.f438115d, r110.f438257f);
        r117 = new ComponentTaskScheduler(r101, TaskType.OFFLINE, this.f438224a.f(), this.f438226c, this.f438225b, this.f438227d).b(r103, r113.f438113b, r113.f438114c).blockingFirst();     // Catch: NoSuchElementException -> L14
    L14:
        e = move-exception;
        StringBuilder r119 = new StringBuilder();
        if (this.f438228e == true) goto L19;
        r115 = "background";
    L19:
        r119.append(r115);
        r119.append(" offline execute task  result error :");
        r119.append(e.getMessage());
        String r104 = r119.toString();
        Log.e("ComponentTask", r104);
        r117 = new j0c.a(false, r104, null, null, 28);
        goto L20
    L23:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public h(m<Component> r100, l0c.d r101, t r102, l0c.c r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "taskMonitor");
        Intrinsics.checkNotNullParameter(r102, "executors");
        Intrinsics.checkNotNullParameter(r103, "userFlowMonitor");
        this.f438224a = r100;
        this.f438225b = r101;
        this.f438226c = r102;
        this.f438227d = r103;
        this.f438228e = r104;
    }
}
