package cw4;

import com.bytedance.ee.bear.contract.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, long r2, Map r4) {
        Intrinsics.checkNotNullParameter(r1, "stage");
        if (r4 != null) goto L5;
        r4 = new LinkedHashMap();
    L5:
        r4.put("stage", r1);
        r4.put("cost", Long.valueOf(r2));
        r4.put("version", "2.0.3");
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("clip_stage_duration_dev", r4);
        tt5.a.h("DocsClip#ClipReport", "event: docs_dev_clip_stage_duration, params: " + r4);
    }
}
