package wk0;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.live.kmp.core.KmpEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import qh0.d;
import qh0.f;
import qh0.g;
import vm2.i;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends vb6.b implements bc6.a {

    /* JADX INFO: renamed from: wk0.a$a, reason: collision with other inner class name */
    public static final class C8124a {
    }

    public static final class b implements d<rh0.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc6.b f560067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f560068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OperateType f560069c;

        @Override // qh0.d
        public final void b(BaseCheckException r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            bc6.b r101 = this.f560067a;
            if (r101 == null) goto L6;
            r101.c1(dc6.a.a(this.f560068b), this.f560069c, r100);
            return;
        }

        @Override // qh0.d
        public final void onResult(rh0.a r100) {
            bc6.b r101 = this.f560067a;
            if (r101 == null) goto L6;
            r101.W(dc6.a.a(this.f560068b), this.f560069c);
            return;
        }

        public b(bc6.b r100, long r101, OperateType r102) {
            this.f560067a = r100;
            this.f560068b = r101;
            this.f560069c = r102;
        }
    }

    static {
    }

    public a() {
    }

    @Override // bc6.a
    public final void E(Context r110, OperateType r111, int r210, bc6.b r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "operateType");
        KmpEnv r100 = KmpEnv.f255139a;
        if (v.a() == true) goto L5;
    L8:
        long r101 = SystemClock.elapsedRealtime();
        ArrayList r102 = new ArrayList();
        r102.add(g.a(r111, r210));
        r102.add(new f.g(r110, r111, r210));
        r102.add(new f.c(r110, r111, r210));
        r102.add(new f.a(r110));
        r102.add(new f.d(r110, r111, r210, true));
        r102.add(new f.C7326f(r110, r111, r210, true));
        r102.add(new f.e(r110, r111));
        f.a(r102).a(new b(r211, r101, r111));
        return;
    L5:
        if (i.h().L5() == false) goto L8;
        LinkMonitor.a("LinkPermissionM", "mock check link failed", null, null, null, false, 124);
        r211.c1(0, r111, new BaseCheckException(r210, r111, BaseCheckException.CheckType.AndroidPermission, "mock no android permission", null, 16, null));
    }
}
