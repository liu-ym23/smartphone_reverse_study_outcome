package com.ss.android.lark.passportc.impl.v2.action;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f438218a;

    public d(c... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        this.f438218a = ArraysKt.toList(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        UserState r103 = (UserState) r101;
        UserState r104 = (UserState) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "from");
        Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.TO);
        j0c.a r105 = com.ss.android.lark.passportc.task.i.f438529a;
        Iterator<c> r106 = this.f438218a.iterator();
    L4:
        if (r106.hasNext() == false) goto L21;
        c r107 = r106.next();
        h0c.a<UserState, UpdateUserContext, j0c.a> r108 = r100.f438259h;
        if (r108 == null) goto L8;
        r108.b(r107);
    L8:
        h0c.b r109 = r107.a(r100, r103, r104);
        T r110 = r109.f483504a;
        j0c.a r111 = com.ss.android.lark.passportc.task.i.f438529a;
        if (r110 == r111) goto L15;
        j0c.a r112 = (j0c.a) r110;
        if (r112 == null) goto L14;
        r111 = r112;
    L14:
        r105 = r111;
    L15:
        h0c.a<UserState, UpdateUserContext, j0c.a> r113 = r100.f438259h;
        if (r113 == null) goto L19;
        r113.a(r100, r107, r109);
    L19:
        if (r105.f496839a == true) goto L4;
        int r114 = h0c.b.f483503b;
        return new h0c.b.C6088b(r105);
    L21:
        int r115 = h0c.b.f483503b;
        return new h0c.b.c(r105);
    }
}
