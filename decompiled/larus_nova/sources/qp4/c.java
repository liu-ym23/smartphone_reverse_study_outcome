package qp4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f534343s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f534344t;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f
    public final void j() {
        super.j();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207860d.f(this.f534344t);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f
    public final void k() {
        super.k();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207860d.b(this.f534344t);
        BitableAnalytic r101 = this.f207859c.q0();
        String r102 = b();
        r101.getClass();
        HashMap r103 = new HashMap();
        r103.put("field_type", r102);
        r101.t("ccm_bitable_relation_field_card_inside_view", r103);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void a(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "viewData");
        BitableNativeViewData r101 = r100.f538848a.getValue();
        GridViewData r102 = null;
        if (r101 == null) goto L5;
        BaseViewData<?, ?> r103 = r101.getData();
    L7:
        if ((r103 instanceof GridViewData) == false) goto L9;
        r102 = (GridViewData) r103;
    L9:
        if (r102 == null) goto L14;
        SimpleItemModel r104 = new SimpleItemModel();
        r104.setStyle("footerHide");
        r102.setFooter(r104);
        GridSetting r105 = r102.getSetting();
        if (r105 == null) goto L15;
        r105.setCalculateViewWidth(true);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f, com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void g(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.g(r100);
        this.f534343s.A();
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (this.f207869m == true) goto L6;
        h(c());
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void h(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.h(r100);
        this.f534343s.A();
        this.f534343s.F(r100);
    }

    public c(Context r100, gp4.h r101, h r110, tp4.a r111, a r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardDelegate");
        Intrinsics.checkNotNullParameter(r110, "editDelegate");
        Intrinsics.checkNotNullParameter(r111, "dataModelDelegate");
        Intrinsics.checkNotNullParameter(r112, "viewDelegate");
        super(r100, MobileViewContainerType.LinkedCellTable, r101, r110, r111);
        this.f534343s = r112;
        this.f534344t = new b(this);
    }
}
