package s05;

import android.content.Context;
import com.bytedance.ee.bear.document.doccomponent.impl.AbsDocComponentImpl;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.bytedance.ee.bear.route.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsDocComponentImpl f540014a;

    public a(AbsDocComponentImpl r100) {
        this.f540014a = r100;
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        AbsDocComponentImpl r103 = this.f540014a;
        if (r101 == null) goto L5;
        String r104 = r101.f222564e;
    L6:
        r103.a(new sz4.c(r104, 2));
        return false;
    L5:
        r104 = null;
        goto L6
    }
}
