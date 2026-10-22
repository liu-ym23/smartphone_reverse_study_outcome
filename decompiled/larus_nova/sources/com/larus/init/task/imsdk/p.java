package com.larus.init.task.imsdk;

import android.os.SystemClock;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.trace.api.IChatImTraceService;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements gd9.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f351392a = null;

    public p() {
    }

    static {
        f351392a = new p();
        ArrayList<String> r100 = o.f351391b;
        AppHost.f326268a.a().j(new n());
    }

    @Override // gd9.a0
    public final void a(String r100, ouc.d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r102 = r101.toString();
        if (r102 == null) goto L5;
        JSONObject r103 = com.flow.kmp.common.util.g.b(r102);
    L6:
        ArrayList<String> r104 = o.f351391b;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (o.f351391b.contains(r100) == false) goto L11;
        long r105 = SystemClock.elapsedRealtime() - o.f351390a;
        if (r103 == null) goto L11;
        r103.put("duration_from_foreground", r105);
    L11:
        IApplog.f287053a.reportEvent(r100, r103);
        IChatImTraceService r106 = (IChatImTraceService) ServiceManager.get().getService(IChatImTraceService.class);
        if (r106 == null) goto L14;
        r106.d(r100, r103);
    L14:
        com.larus.bmhome.utils.c.a(r100, r103, false);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // gd9.a0
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "param");
        yp9.d.f568725b.a(r100, r101);
    }
}
