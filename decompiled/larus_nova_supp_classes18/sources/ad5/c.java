package ad5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ HomeSubMenuView c;

    public c(HomeSubMenuView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        tt5.a.h("HomeSubMenuView", "on click grid");
        HomeSubMenuView r3 = this.c;
        r3.e = !r3.e;
        r3.d();
        HomeSubMenuView r4 = this.c;
        wc5.f.a r0 = r4.f;
        if (r0 == null) goto L6;
        r0.WU(r4.e);
        return;
    }
}
