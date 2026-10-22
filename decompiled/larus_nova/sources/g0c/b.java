package g0c;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.impl.v2.action.h;
import com.ss.android.lark.passportc.impl.v2.d;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends h<l> {
    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        UserState r103 = (UserState) r101;
        UserState r104 = (UserState) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "from");
        Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.TO);
        d r105 = r100.f438258g;
        if (r105 == null) goto L5;
        r105.m(r100, r103, r104);
    L5:
        h0c.b<j0c.a> r106 = super.b(r100, r103, r104);
        d r107 = r100.f438258g;
        if (r107 == null) goto L8;
        r107.k(r100, r103, r104, (h0c.b.c) r106);
    L8:
        return r106;
    }

    public b(g r100, l0c.d r101, t r110, l0c.c r111) {
        Intrinsics.checkNotNullParameter(r100, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "taskMonitor");
        Intrinsics.checkNotNullParameter(r110, "executors");
        Intrinsics.checkNotNullParameter(r111, "userFlowMonitor");
        super(r100, r101, r110, r111, true);
    }
}
