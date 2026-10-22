package s05;

import android.content.Context;
import com.bytedance.ee.bear.document.doccomponent.impl.AbsDocComponentImpl;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.route.d {
    public final /* synthetic */ AbsDocComponentImpl a;

    public a(AbsDocComponentImpl r1) {
        this.a = r1;
    }

    public final boolean b(Context r2, BearUrl r3, RouteBean r4) {
        AbsDocComponentImpl r5 = this.a;
        if (r3 == null) goto L5;
        String r6 = r3.e;
    L6:
        r5.a(new sz4.c(r6, 2));
        return false;
    L5:
        r6 = null;
        goto L6
    }
}
