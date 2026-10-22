package d15;

import com.bytedance.ee.bear.document.editionmanager.panel.EditionListFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends CommonActionPanelLayout.b {
    public final /* synthetic */ EditionListFragment a;

    public final void b() {
        this.a.h.updateActive(false);
        this.a.h.reportEditionSavedVersionClick();
    }

    public g(EditionListFragment r1) {
        this.a = r1;
    }
}
