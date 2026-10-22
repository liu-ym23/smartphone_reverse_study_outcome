package up4;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordCreateManager;
import com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordsFetchManager;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.OpenDiscussPanelType;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.panel.LinkTablePickerViewState;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UpdateStrategy;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final up4.a f551028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f551029o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f551030p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f551031q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public uu5.d<String> f551032r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final BitableLinkRecordCreateManager f551033s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f551034t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public cp4.b f551035u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f551036v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f551037w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C7911b f551038x;

    public static final class a {
    }

    /* JADX INFO: renamed from: up4.b$b, reason: collision with other inner class name */
    public static final class C7911b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551039a;

        public C7911b(b r100) {
            this.f551039a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h
        public final void c(int r100) {
            this.f551039a.f551028n.a(r100);
        }
    }

    static {
    }

    public final void j() {
        tt5.a.h("LinkTableRecordPickerPresenter", "destroy hasChanged = " + this.f551036v + ", isError = " + this.f551037w);
        if (this.f551036v == true) goto L5;
    L7:
        this.f207860d.f(this.f551038x);
        uu5.d<String> r100 = this.f551032r;
        if (r100 == null) goto L10;
        r100.a();
    L10:
        Disposable r101 = this.f551031q;
        if (r101 == null) goto L13;
        r101.dispose();
    L13:
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207863g.destroyLinkTableDataModel(this.f207861e);
        return;
    L5:
        if (this.f551037w == true) goto L7;
        this.f207860d.c(this.f551029o.toArray(new String[0]), "cover", CollectionsKt.emptyList());
        goto L7
    }

    public final void k() {
        m(LinkTablePickerViewState.LOADING, null, null);
        com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.d r100 = new com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.d(this);
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207861e.e(r100);
        boolean r102 = this.f207863g.checkIsActiveModel(this.f207861e);
        this.f207861e.k(r102);
    }

    public final void l() {
        tt5.a.b("LinkTableRecordPickerPresenter", "onSelectItemViewChanged()... selectRecordIds = " + this.f551029o);
        this.f551028n.m(this.f551029o);
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
        r105.setShowNoMarginDivider(true);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void g(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f207866j = r100;
        fp4.d r101 = r100.f538844a;
        String r102 = null;
        if (this.f551035u != null) goto L8;
        if (r101 == null) goto L8;
        if (this.f551031q != null) goto L8;
        this.f551031q = BitableLinkRecordsFetchManager.fetchLinkTable$default(this.f207864h, r101, null, 2, null).subscribe(new c(this), d.f551041a);
    L8:
        fp4.d r103 = r100.f538844a;
        boolean r104 = false;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
        tt5.a.h("LinkTableRecordPickerPresenter", "show linkTableIsDelete");
        m(LinkTablePickerViewState.ERROR, Integer.valueOf(R.drawable.ccm_empty_neutral_no_content), n.x(this.f207857a, R.string.Bitable_Relation_LinkedTableWasDeleted));
        return;
    L17:
        if (r103 != null) goto L19;
    L21:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L25;
        tt5.a.h("LinkTableRecordPickerPresenter", "show !isLinkTableVisible");
        m(LinkTablePickerViewState.ERROR, Integer.valueOf(R.drawable.ccm_empty_neutral_no_access), n.x(this.f207857a, R.string.Bitable_Relation_NoPermissionToViewLinkedTable));
        return;
    L25:
        int r107 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r108 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.mobile.link_filter_field_deny_enable") == false) goto L35;
        fp4.d r109 = r100.f538844a;
        if (r109 != null) goto L30;
    L32:
        boolean r110 = false;
    L33:
        if (r110 == false) goto L35;
        tt5.a.h("LinkTableRecordPickerPresenter", "show isLinkFilterFieldDeny");
        m(LinkTablePickerViewState.ERROR, Integer.valueOf(R.drawable.ccm_empty_neutral_no_access), n.x(this.f207857a, R.string.Bitable_SingleOption_NoPermToAccessOptions));
        return;
    L30:
        if (r109.f478244r != true) goto L32;
        r110 = true;
    L35:
        fp4.d r111 = r100.f538844a;
        if (r111 == null) goto L38;
        FilterInfo r112 = r111.f478245s;
    L39:
        if (r112 == null) goto L56;
        if (r111 == null) goto L44;
        FilterInfo r113 = r111.f478245s;
        if (r113 == null) goto L44;
        FilterCondition[] r114 = r113.getConditions();
    L45:
        if (r114 == null) goto L56;
        fp4.d r115 = r100.f538844a;
        if (r115 == null) goto L49;
        String r116 = r115.f478262i;
    L51:
        if (TextUtils.isEmpty(r116) == true) goto L56;
        tt5.a.h("LinkTableRecordPickerPresenter", "show fieldWarning");
        LinkTablePickerViewState r117 = LinkTablePickerViewState.ERROR;
        Integer r118 = Integer.valueOf(R.drawable.ccm_empty_neutral_no_content);
        fp4.d r119 = r100.f538844a;
        if (r119 == null) goto L55;
        r102 = r119.f478262i;
    L55:
        m(r117, r118, r102);
        return;
    L49:
        r116 = null;
    L44:
        r114 = null;
    L56:
        tt5.a.h("LinkTableRecordPickerPresenter", "show normal");
        m(LinkTablePickerViewState.DATA_LOADED, null, null);
        this.f551028n.d(r100);
        if (this.f207869m == true) goto L70;
        rp4.a r120 = this.f207866j;
        if (r120 == null) goto L67;
        cp4.a r121 = r120.f538845b;
        if (r121 == null) goto L67;
        cp4.b r122 = r121.f464634a;
        if (r122 == null) goto L67;
        if (r122.D != true) goto L67;
        boolean r123 = true;
    L68:
        if (r123 == false) goto L70;
        r104 = true;
    L67:
        r123 = false;
    L70:
        if (r104 == false) goto L77;
        h(c());
        return;
    L77:
        return;
    L38:
        r112 = null;
        goto L39
    L19:
        if (r103.f478242p == true) goto L21;
        r106 = true;
        goto L23
    L11:
        if (r103.f478247u != true) goto L13;
        r105 = true;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void h(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.h(r100);
        if (this.f551037w == false) goto L6;
        tt5.a.h("LinkTableRecordPickerPresenter", "handleViewDataChange() failed... isError = true");
        return;
    L6:
        m(LinkTablePickerViewState.VIEW_LOADED, null, null);
        BitableNativeViewData r101 = r100.f538848a.getValue();
        if (r101 == null) goto L15;
        BaseViewData<?, ?> r102 = r101.getData();
        if (r102 == null) goto L15;
        UpdateStrategy r103 = r102.getUpdateStrategy();
        if (r103 == null) goto L15;
        boolean r104 = true;
        if (r103.isRebuildUpdate() != true) goto L15;
    L16:
        tt5.a.b("LinkTableRecordPickerPresenter", "handleViewDataChange, isRebuild = " + r104);
        this.f551028n.c(r100);
        if (r104 == false) goto L20;
        l();
        return;
    L20:
        return;
    L15:
        r104 = false;
        goto L16
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.a
    public final void f(String r100, OpenDiscussPanelType r101) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, "openDiscussPanelType");
        boolean r102 = true;
        this.f551036v = true;
        this.f551028n.hideKeyboard();
        rp4.a r103 = this.f207866j;
        if (r103 == null) goto L7;
        fp4.d r104 = r103.f538844a;
        if (r104 == null) goto L7;
        boolean r105 = r104.f478241o;
    L9:
        if (this.f551029o.contains(r100) == false) goto L11;
        this.f551029o.remove(r100);
    L21:
        l();
        return;
    L11:
        int r106 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (this.f551029o.size() >= this.f207867k) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L18;
        i();
        return;
    L18:
        if (r105 == false) goto L20;
        this.f551029o.add(r100);
        goto L21
    L20:
        this.f551029o.clear();
        this.f551029o.add(r100);
    L7:
        r105 = false;
        goto L9
    }

    public final void m(LinkTablePickerViewState r100, Integer r101, String r102) {
        if (r100 != LinkTablePickerViewState.ERROR) goto L6;
        this.f551037w = true;
    L6:
        if (r100 == LinkTablePickerViewState.DATA_LOADED) goto L8;
    L10:
        tt5.a.h("LinkTableRecordPickerPresenter", "updateLoadingState()... state = " + r100);
        this.f551028n.i(r100, r101, r102);
        return;
    L8:
        if (this.f551037w == false) goto L10;
        this.f551037w = false;
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.f207861e.d(true);
        goto L10
    }

    public b(Context r100, gp4.h r101, g r110, tp4.a r111, up4.a r112, List<String> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardDelegate");
        Intrinsics.checkNotNullParameter(r110, "editDelegate");
        Intrinsics.checkNotNullParameter(r111, "dataModelDelegate");
        Intrinsics.checkNotNullParameter(r112, "viewDelegate");
        Intrinsics.checkNotNullParameter(r113, "selectRecordIds");
        Intrinsics.checkNotNullParameter(r114, "openLinkRecordPickerPanel");
        super(r100, MobileViewContainerType.LinkedSearchTable, r101, r110, r111);
        this.f551028n = r112;
        this.f551029o = r113;
        this.f551030p = r114;
        this.f551034t = "";
        C7911b r102 = new C7911b(this);
        this.f551038x = r102;
        this.f551033s = (BitableLinkRecordCreateManager) q.a(r101.getFragment(), BitableLinkRecordCreateManager.class);
        this.f207860d.b(r102);
    }
}
