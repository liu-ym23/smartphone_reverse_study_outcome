package cw4;

import com.bytedance.ee.bear.contract.d;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465575a = 0;

    static {
    }

    public static void a(String r100, long r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        if (r102 != null) goto L5;
        r102 = new LinkedHashMap();
    L5:
        r102.put("stage", r100);
        r102.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r101));
        r102.put("version", "2.0.3");
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("clip_stage_duration_dev", r102);
        tt5.a.h("DocsClip#ClipReport", "event: docs_dev_clip_stage_duration, params: " + r102);
    }
}
