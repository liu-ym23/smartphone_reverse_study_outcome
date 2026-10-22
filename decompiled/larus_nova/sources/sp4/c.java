package sp4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import gp4.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends f implements sa5.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f542832s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public cp4.b f542833t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f542834u;

    @Override // sa5.d
    public final boolean onBackPressed() {
        BitableCardViewModel r100 = this.f207862f;
        cp4.b r101 = this.f542833t;
        ETableType r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f464658b;
    L6:
        if (r101 == null) goto L8;
        String r104 = r101.f464660d;
    L9:
        if (r101 == null) goto L11;
        r102 = r101.f464675s;
    L11:
        r100.backwardTable(r103, r104, r102);
        return true;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f
    public final void j() {
        super.j();
        this.f207859c.u(this);
        BitableCardViewModel r100 = this.f207862f;
        cp4.b r101 = this.f542833t;
        if (r101 == null) goto L6;
        String r102 = r101.f464660d;
        if (r102 == null) goto L6;
    L7:
        r100.clearLinkTableDisposable(r102);
        this.f207860d.f(this.f542834u);
        return;
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f
    public final void k() {
        super.k();
        this.f207860d.b(this.f542834u);
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
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.getFooter() != null) goto L13;
        r102.setFooter(new SimpleItemModel());
    L13:
        SimpleItemModel r104 = r102.getFooter();
        if (r104 == null) goto L18;
        r104.setStyle("footerAutoHeight");
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.f, com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void g(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.g(r100);
        this.f542832s.b();
        a r101 = this.f542832s;
        fp4.d r102 = r100.f538844a;
        if (r102 == null) goto L6;
        String r103 = r102.f478256c;
        if (r103 == null) goto L6;
    L7:
        r101.a(r103);
        int r104 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (this.f207869m == true) goto L11;
        h(c());
        return;
    L11:
        return;
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void h(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.h(r100);
        this.f542832s.F(r100);
    }

    public c(Context r100, h r101, d.a r110, tp4.a r111, a r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardDelegate");
        Intrinsics.checkNotNullParameter(r110, "editDelegate");
        Intrinsics.checkNotNullParameter(r111, "dataModelDelegate");
        Intrinsics.checkNotNullParameter(r112, "viewDelegate");
        super(r100, MobileViewContainerType.LinkedFullTable, r101, r110, r111);
        this.f542832s = r112;
        r101.K(this);
        this.f542834u = new b(this);
    }
}
