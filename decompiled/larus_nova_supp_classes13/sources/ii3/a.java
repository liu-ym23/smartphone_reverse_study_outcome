package ii3;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import fi3.c0;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this.a.getView());     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        SlcTemplateContext r1 = r0.a;     // Catch: Throwable -> L9
    L6:
        if (r1 == null) goto L12;
        int r2 = c0.e;     // Catch: Throwable -> L9
        SlcTemplateContext.e(r1, c0.a.a("BaseInfoPrice", MapsKt.mapOf(TuplesKt.to("should_sec_line", Boolean.TRUE)), null, 10), this.a.getView(), null, null, 24);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r1 = null;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
