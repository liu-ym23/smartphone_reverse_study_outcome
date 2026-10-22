package pz1;

import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends AbsPanel<b1> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f531054i;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((b1) this.f126620h).getText();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((b1) this.f126620h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String f() {
        return ((b1) this.f126620h).getTitle();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return this.f531054i;
    }

    public c(b1 r100) {
        super(3, r100);
        this.f531054i = r100.getImage();
    }
}
