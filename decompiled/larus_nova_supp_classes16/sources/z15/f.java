package z15;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final CopyOnWriteArrayList<e> a;

    public static final class a {
    }

    static {
    }

    public f() {
        CopyOnWriteArrayList<e> r0 = new CopyOnWriteArrayList();
        this.a = r0;
        d r1 = (d) LarkContext.spiByDwarf(d.class);
        if (r1 == null) goto L8;
        List<e> r2 = r1.a();
        if (r2 == null) goto L9;
        r0.addAll(r2);
        return;
    L9:
        return;
    }

    public final boolean a(String r4, BasePlugin r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "menuId");
        Intrinsics.checkNotNullParameter(r5, "plugin");
        Intrinsics.checkNotNullParameter(r6, "view");
        Iterator<e> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        e r1 = r0.next();
        if (r1.c(r4, r5, r6) == false) goto L4;
        tt5.a.h("TitleMenuHighPriorityInterceptor", "dispatchHighPriorityIntercept()...interceptor = " + r1);
        return true;
    L9:
        return false;
    }
}
