package ad5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends t {
    public final /* synthetic */ HomeSubMenuView c;

    public b(HomeSubMenuView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        tt5.a.h("HomeSubMenuView", "on click iv filter");
        wc5.f.a r3 = this.c.f;
        if (r3 == null) goto L6;
        r3.eF();
        return;
    }
}
