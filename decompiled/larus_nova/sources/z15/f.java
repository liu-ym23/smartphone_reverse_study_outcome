package z15;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f569668a;

    public static final class a {
    }

    static {
    }

    public f() {
        CopyOnWriteArrayList<e> r100 = new CopyOnWriteArrayList();
        this.f569668a = r100;
        d r101 = (d) LarkContext.spiByDwarf(d.class);
        if (r101 == null) goto L8;
        List<e> r102 = r101.a();
        if (r102 == null) goto L9;
        r100.addAll(r102);
        return;
    L9:
        return;
    }

    public final boolean a(String r100, BasePlugin r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "menuId");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r102, "view");
        Iterator<e> r103 = this.f569668a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        e r104 = r103.next();
        if (r104.c(r100, r101, r102) == false) goto L4;
        tt5.a.h("TitleMenuHighPriorityInterceptor", "dispatchHighPriorityIntercept()...interceptor = " + r104);
        return true;
    L9:
        return false;
    }
}
