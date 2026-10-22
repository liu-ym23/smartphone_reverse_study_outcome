package p15;

import com.bytedance.ee.bear.document.render.preload.LarkDocsPreloadOptimize;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import etb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static Boolean a;

    static {
    }

    public static boolean a() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L10;
        Boolean r0 = a;
        if (r0 != null) goto L7;
        LarkDocsPreloadOptimize r1 = (LarkDocsPreloadOptimize) ((b) LarkContext.spiByDwarf(b.class)).r("lark_docs_preload_optimize", LarkDocsPreloadOptimize.class, new LarkDocsPreloadOptimize());
        tt5.a.h("ForecastOptConfig", "isOfficeSdk is true, onlyPreloadCurrentType= " + r1.getOnlyPreloadCurrentType() + ", preloadWithUserBehavior = " + r1.getPreloadWithUserBehavior());
        a = Boolean.valueOf(r1.getPreloadWithUserBehavior());
        return r1.getPreloadWithUserBehavior();
    L7:
        return Intrinsics.areEqual(r0, Boolean.TRUE);
    L10:
        tt5.a.h("ForecastOptConfig", "isEnableForecast: true");
        return true;
    }
}
