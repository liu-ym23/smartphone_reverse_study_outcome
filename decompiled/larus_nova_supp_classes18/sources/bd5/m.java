package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m extends t {
    public final /* synthetic */ SubMenuView c;

    public m(SubMenuView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        SubMenuView r3 = this.c;
        boolean r0 = !r3.g;
        r3.g = r0;
        r3.b(r0);
        SubMenuView r4 = this.c;
        wc5.f.a r1 = r4.e;
        if (r1 == null) goto L6;
        r1.WU(r4.g);
        return;
    }
}
