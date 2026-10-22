package g0c;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.impl.v2.action.i;
import com.ss.android.lark.passportc.impl.v2.d;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.l;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends i<l> {
    @Override // com.ss.android.lark.passportc.impl.v2.action.i, i0c.b
    public final /* bridge */ /* synthetic */ h0c.b a(UpdateUserContext r100, Object r101, Object r102) {
        return b(r100, (UserState) r101, (UserState) r102);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.i
    public final h0c.b<j0c.a> b(UpdateUserContext r100, UserState r101, UserState r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        d r103 = r100.f438258g;
        if (r103 == null) goto L5;
        r103.p(r100, r101, r102);
    L5:
        h0c.b<j0c.a> r104 = super.b(r100, r101, r102);
        d r105 = r100.f438258g;
        if (r105 == null) goto L8;
        r105.g(r100, r101, r102, r104);
    L8:
        return r104;
    }

    public c(g r100, Set<com.ss.android.lark.passportc.task.d> r101, l0c.d r102, t r103, l0c.c r104) {
        Intrinsics.checkNotNullParameter(r100, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r102, "taskMonitor");
        Intrinsics.checkNotNullParameter(r103, "executors");
        Intrinsics.checkNotNullParameter(r104, "userFlowMonitor");
        super(r100, r101, r102, r103, r104);
    }
}
