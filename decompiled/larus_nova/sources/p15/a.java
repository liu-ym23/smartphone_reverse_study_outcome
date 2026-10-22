package p15;

import com.bytedance.ee.bear.document.render.preload.LarkDocsPreloadOptimize;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import etb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f527322a;

    static {
    }

    public static boolean a() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L10;
        Boolean r100 = f527322a;
        if (r100 != null) goto L7;
        LarkDocsPreloadOptimize r101 = (LarkDocsPreloadOptimize) ((b) LarkContext.spiByDwarf(b.class)).r("lark_docs_preload_optimize", LarkDocsPreloadOptimize.class, new LarkDocsPreloadOptimize());
        tt5.a.h("ForecastOptConfig", "isOfficeSdk is true, onlyPreloadCurrentType= " + r101.getOnlyPreloadCurrentType() + ", preloadWithUserBehavior = " + r101.getPreloadWithUserBehavior());
        f527322a = Boolean.valueOf(r101.getPreloadWithUserBehavior());
        return r101.getPreloadWithUserBehavior();
    L7:
        return Intrinsics.areEqual(r100, Boolean.TRUE);
    L10:
        tt5.a.h("ForecastOptConfig", "isEnableForecast: true");
        return true;
    }
}
