package com.ss.android.lark.integrator.security.compliance.export;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.lark.android.encryption.utils.MonitorStatus;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f428091a = null;

    static {
        f428091a = new f();
    }

    public f() {
    }

    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ikc.b r101 = ikc.f.f490295a.f490293b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source", "officesdk_api"), TuplesKt.to(WikiFolderPushPlugin.OPT, r100.f428086a), TuplesKt.to("result", Boolean.valueOf(r100.f428087b))});
        Integer r103 = r100.f428089d;
        if (r103 == null) goto L5;
        r102.put("error_code", Integer.valueOf(r103.intValue()));
    L5:
        String r104 = r100.f428090e;
        if (r104 == null) goto L8;
        r102.put("failure_reason", r104);
    L8:
        Map r105 = MapsKt.mapOf(TuplesKt.to("duration_ms", Long.valueOf(r100.f428088c)));
        if (r100.f428087b == false) goto L11;
        MonitorStatus r106 = MonitorStatus.SUCCESS;
    L12:
        ikc.a.a(r101, "scs_file_stream_encryption", r102, r105, r106.getValue(), 8);
        return;
    L11:
        r106 = MonitorStatus.FAILED;
        goto L12
    }
}
