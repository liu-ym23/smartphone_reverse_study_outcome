package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.d;
import java.util.Set;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import l0c.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f438293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.impl.v2.action.a f438294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f438295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<d> f438296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f438297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l0c.d f438298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f438299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f438300h;

    @Inject
    public a(g r100, com.ss.android.lark.passportc.impl.v2.action.a r101, f r102, Set<d> r103, p r104, l0c.d r105, t r106, c r107) {
        Intrinsics.checkNotNullParameter(r100, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "backgroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r102, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r103, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r104, "userDataSource");
        Intrinsics.checkNotNullParameter(r105, "taskMonitor");
        Intrinsics.checkNotNullParameter(r106, "executors");
        Intrinsics.checkNotNullParameter(r107, "userFlowMonitor");
        this.f438293a = r100;
        this.f438294b = r101;
        this.f438295c = r102;
        this.f438296d = r103;
        this.f438297e = r104;
        this.f438298f = r105;
        this.f438299g = r106;
        this.f438300h = r107;
    }
}
