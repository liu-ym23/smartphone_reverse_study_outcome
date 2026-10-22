package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "viewModel", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "clearNavBarItems", "addNavBarItem", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "close", "onDestroyView", "onBackPressed", "", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetCardTitleBarFragment extends BaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, Integer> f237400h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f237401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetCardTitleBarViewModel f237402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xu5.b.a f237403g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetCardTitleBarFragment f237404a;

        public b(SheetCardTitleBarFragment r100) {
            this.f237404a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Map<String, Integer> r101 = SheetCardTitleBarFragment.f237400h;
            tt5.a.b("SheetCardTitleBarFragment", "back view clicked...");
            HashMap r102 = new HashMap();
            r102.put("click", "close");
            r102.put(PickerReporterConstants.KEY.TARGET, "none");
            qm5.b.b("ccm_space_docs_topbar_click", r102);
            this.f237404a.close();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetCardTitleBarFragment f237405a;

        public c(SheetCardTitleBarFragment r100) {
            this.f237405a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            CardNavBarData r111 = (CardNavBarData) r110;
            if (r111 == null) goto L62;
            SheetCardTitleBarFragment r100 = this.f237405a;
            if (r111.getBgColor() == null) goto L63;
            String r101 = r111.getBgColor();
            Intrinsics.checkNotNull(r101);
            int r102 = ColorUtils.h(r101);
            BaseTitleBar r103 = r100.f237401e;
            BaseTitleBar r104 = null;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r103 = null;
        L10:
            r103.setBackgroundColor(r102);
            xu5.b.a r105 = r100.f237403g;
            if (r105 == null) goto L13;
            r105.b(r102, true);
        L13:
            String r106 = r111.getTitle();
            if (r106 == null) goto L19;
            BaseTitleBar r107 = r100.f237401e;
            if (r107 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r107 = null;
        L18:
            r107.setTitle(r106);
        L19:
            CardNavBarItem r108 = r111.getItems();
            if (r108 == null) goto L24;
            NavBarItem[] r109 = r108.getLeft();
            if (r109 == null) goto L24;
            NavBarItem r112 = (NavBarItem) ArraysKt.firstOrNull(r109);
        L25:
            if (r112 == null) goto L27;
            String r113 = r112.getId();
        L29:
            if (Intrinsics.areEqual(r113, "back") == true) goto L31;
            Map<String, Integer> r114 = SheetCardTitleBarFragment.f237400h;
            tt5.a.d("SheetCardTitleBarFragment", "setCardNavBar leftItem's id is not 'back'!!");
        L31:
            BaseTitleBar r115 = r100.f237401e;
            if (r115 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r115 = null;
        L34:
            r115.f();
            BaseTitleBar r116 = r100.f237401e;
            if (r116 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r116 = null;
        L37:
            r116.g();
            CardNavBarItem r117 = r111.getItems();
            if (r117 == null) goto L53;
            NavBarItem[] r118 = r117.getRight();
            if (r118 == null) goto L53;
            int r119 = r118.length;
            int r120 = 0;
        L42:
            if (r120 >= r119) goto L53;
            NavBarItem r121 = r118[r120];
            Integer r122 = SheetCardTitleBarFragment.f237400h.get(r121.getId());
            if (r122 == null) goto L52;
            com.bytedance.ee.bear.sheet.cardmodetitlebar.a r123 = new com.bytedance.ee.bear.sheet.cardmodetitlebar.a(r122.intValue(), r100, r121);
            BaseTitleBar r124 = r100.f237401e;
            if (r124 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r124 = null;
        L48:
            View r125 = r124.a(r123, true);
            String r126 = r121.getId();
            if (r126 != null) goto L51;
            r126 = "";
        L51:
            r125.setTag(r126);
        L52:
            r120 = r120 + 1;
        L53:
            BaseTitleBar r127 = r100.f237401e;
            if (r127 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        L57:
            r104.setActionIconTint(R.color.icon_n1);
            return;
        L56:
            r104 = r127;
            goto L57
        L27:
            r113 = null;
        L24:
            r112 = null;
            goto L25
        L63:
            return;
        }
    }

    static {
        f237400h = MapsKt.mapOf(new Pair[]{TuplesKt.to(BrowserDependency.UrlClickType.CARD, Integer.valueOf(R.drawable.ud_icon_sheet_cardmodel_outlined)), TuplesKt.to("list", Integer.valueOf(R.drawable.ud_icon_disorder_list_outlined)), TuplesKt.to("more", Integer.valueOf(R.drawable.ud_icon_more_outlined))});
    }

    public final void close() {
        SheetCardTitleBarViewModel r100 = this.f237402f;
        SheetCardTitleBarViewModel r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.getActive().setValue(Boolean.FALSE);
        SheetCardTitleBarViewModel r102 = this.f237402f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        SheetCardTitleBarViewModel.a r103 = r101.getDelegate();
        if (r103 == null) goto L13;
        r103.a("back");
        return;
    L13:
        return;
    L8:
        r101 = r102;
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        close();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        xu5.b.a r100 = this.f237403g;
        if (r100 == null) goto L6;
        r100.resetState();
        return;
    }

    public SheetCardTitleBarFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f237402f = (SheetCardTitleBarViewModel) q.a(this, SheetCardTitleBarViewModel.class);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = n.f243167a;
        BaseTitleBar r103 = (BaseTitleBar) r100.findViewById(R.id.card_title_bar);
        this.f237401e = r103;
        SheetCardTitleBarViewModel r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r103 = null;
    L5:
        r103.setLeftImageResource(R.drawable.ud_icon_close_small_outlined);
        BaseTitleBar r105 = this.f237401e;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r105 = null;
    L8:
        r105.setLeftClickListener(new b(this));
        qm5.b.b("ccm_space_docs_topbar_view", new HashMap());
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L11;
        this.f237403g = xu5.b.b(r106, null);
    L11:
        xu5.b.a r107 = this.f237403g;
        if (r107 == null) goto L14;
        r107.saveState();
    L14:
        SheetCardTitleBarViewModel r108 = this.f237402f;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r104.getNavBar().observe(this, new c(this));
        return;
    L17:
        r104 = r108;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.sheet_card_navbar_fragment, r101, false);
    }
}
