package la5;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends BaseTitleBar.c {
    public final /* synthetic */ MenuItem k;

    public final void performAction(View r2) {
        this.k.onClick(r2);
    }

    public d(Drawable r1, MenuItem r2) {
        this.k = r2;
        super(r1);
    }
}
