package lnc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import fu3.h;
import fu3.i;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements com.suite.component.logger.api.d {
    public b() {
    }

    @Override // com.suite.component.logger.api.d
    public final void a(com.suite.component.logger.api.d.a r100, com.suite.component.logger.b r101, com.suite.component.logger.c r102) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "entity");
        r100.a(r101, r102);
        fu3.b r103 = fu3.b.g();
        String r104 = r102.f460116b;
        r103.getClass();
        if (r104 != null) goto L6;
        return;
    L6:
        if (r103.f478861b == true) goto L13;
        if (com.bytedance.apm.d.j() == true) goto L10;
        return;
    L10:
        if (r103.f478879t == false) goto L30;
        r103.f478879t = false;
        return;
    L30:
        return;
    L13:
        if (r103.f478873n.f478895i < 10000) goto L15;
    L17:
        ArrayList<h> r105 = i.f478903a.get();
        if (((h) ListProtector.get(r105, 0)).f478902e == true) goto L21;
        h r106 = (h) ListProtector.get(r105, 0);
    L24:
        if (r106 != null) goto L26;
        r106 = new h(r104);
    L27:
        r106.f478902e = true;
        r103.f(r106);
        return;
    L26:
        r106.f478900c = "Log";
        r106.f478901d = r104;
        goto L27
    L21:
        if (((h) ListProtector.get(r105, 1)).f478902e == true) goto L23;
        r106 = (h) ListProtector.get(r105, 1);
        goto L24
    L23:
        r106 = null;
        goto L24
    L15:
        if ((System.nanoTime() % 10000) < r103.f478873n.f478895i) goto L17;
    }
}
