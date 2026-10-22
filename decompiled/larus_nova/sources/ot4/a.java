package ot4;

import android.view.View;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.container.BitableFullTableFragment;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.browser.plugin.MenuItem;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements MenuItem.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Icon f526669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f526670b;

    public a(Icon r100, BitableFullTableFragment.c r101) {
        this.f526669a = r100;
        this.f526670b = r101;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r100, View r101) {
        String r102 = this.f526669a.getClickAction();
        if (r102 == null) goto L6;
        this.f526670b.a(new Action(null, r102, 1, null));
        return;
    }
}
