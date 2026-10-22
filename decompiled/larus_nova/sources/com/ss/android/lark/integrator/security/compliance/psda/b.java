package com.ss.android.lark.integrator.security.compliance.psda;

import android.app.Application;
import com.bytedance.supervisor.runtime.common.Logger;
import com.bytedance.supervisor.token.TokenConfig;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;
import mf7.c;
import mf7.e;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public static void a() {
        lf7.b r100 = d.f509087a;
        Application r101 = LarkContext.getApplication();
        lf7.b r102 = new lf7.b(SensitiveApiManageModule$init$1.INSTANCE);
        Intrinsics.checkNotNullParameter(r101, "application");
        Intrinsics.checkNotNullParameter(r102, "config");
        d.f509087a = r102;
        if (nf7.a.a() == true) goto L5;
        Logger.c("SensitiveApiSupervisor", "SensitiveApiSupervisor disable");
        nf7.d.a("SensitiveApiSupervisor", "SensitiveApiSupervisor disable");
        return;
    L5:
        ConcurrentHashMap<String, TokenConfig> r103 = com.bytedance.supervisor.runtime.config.b.f270342b;
        com.bytedance.supervisor.runtime.config.b.d(r101);
        List<c> r104 = mf7.b.f513645a;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new mf7.d());
        r105.add(new e());
        r105.add(new mf7.a());
    }
}
