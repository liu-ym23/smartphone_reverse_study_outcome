package ot4;

import android.view.View;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.TitleMenuItem;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends BaseTitleBar.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ MenuItem f526679g;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f526679g.onClick(r100);
    }

    public e(TitleMenuItem r100, MenuItem r101) {
        this.f526679g = r101;
        super(r100);
    }
}
