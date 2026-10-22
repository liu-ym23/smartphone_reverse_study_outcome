package la5;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends BaseTitleBar.e {
    public final /* synthetic */ MenuItem j;

    public final void performAction(View r2) {
        this.j.onClick(r2);
    }

    public e(CharSequence r1, MenuItem r2) {
        this.j = r2;
        super(r1);
    }
}
