package d15;

import com.bytedance.ee.bear.document.editionmanager.panel.EditionListFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditionListFragment f466382a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        this.f466382a.f219657h.updateActive(false);
        this.f466382a.f219657h.reportEditionSavedVersionClick();
    }

    public g(EditionListFragment r100) {
        this.f466382a = r100;
    }
}
