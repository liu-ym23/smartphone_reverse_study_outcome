package lw4;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.util.ui.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements MenuItem.b {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r1, View r2) {
        if (h.a(500) == false) goto L6;
        this.a.a.onExpandItemClick();
        return;
    }
}
