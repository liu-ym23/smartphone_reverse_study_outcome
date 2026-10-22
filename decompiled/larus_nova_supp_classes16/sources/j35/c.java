package j35;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements h {
    public final DocBridgeWebViewV2 a;

    public abstract Flowable<Boolean> b(boolean r1, String r2);

    public c(DocBridgeWebViewV2 r1) {
        this.a = r1;
    }

    public static void a(final boolean r2) {
        LarkBuildConfig r0 = LarkAppContext.inst().buildConfig();
        if (r0.getDebug() == true) goto L5;
    L8:
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new a(r2), new b());
        return;
    L5:
        if (r0.getLynxDebug() == false) goto L8;
        tt5.a.h("AbsDocPreloader", "enable lynx debug");
    }
}
