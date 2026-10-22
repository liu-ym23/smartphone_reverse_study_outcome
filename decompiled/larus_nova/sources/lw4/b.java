package lw4;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.util.ui.h;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements MenuItem.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f511018a;

    public b(a r100) {
        this.f511018a = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r100, View r101) {
        if (h.a(500) == false) goto L6;
        this.f511018a.f511012a.onExpandItemClick();
        return;
    }
}
