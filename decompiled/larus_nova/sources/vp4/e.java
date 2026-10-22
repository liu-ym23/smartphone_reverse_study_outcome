package vp4;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.view.cell.location.LocationCellViewHolder;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.location.d f556636c;

    public e(com.bytedance.ee.bear.bitable.card.view.cell.location.d r100) {
        this.f556636c = r100;
        super(800);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        com.bytedance.ee.bear.bitable.card.view.cell.location.d r101 = this.f556636c;
        if (r101.f207913k == true) goto L6;
        tt5.a.h("BaseLocationPanel", "showLocation mFieldLocationEnable is false");
        return;
    L6:
        if (r101.f207906d.canEdit() == false) goto L8;
        ((LocationCellViewHolder) r101.f207905c).a4();
        return;
    L8:
        com.bytedance.ee.bear.bitable.card.view.cell.location.e.a r102 = r101.f207905c;
        LocationCellViewHolder r103 = (LocationCellViewHolder) r102;
        r103.W4(r101.f207908f);
    }
}
