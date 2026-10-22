package com.bytedance.ee.bear.document.icon;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u000206H\u0016J\b\u0010B\u001a\u00020&H\u0016J\u0010\u0010C\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\u0010\u0010D\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\u0010\u0010E\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\b\u0010F\u001a\u000206H\u0002J\u0012\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010I\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010J\u001a\u00020&H\u0002J\"\u0010K\u001a\u0002062\u0018\b\u0002\u0010L\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010N\u0012\u0004\u0012\u000206\u0018\u00010MH\u0002J\b\u0010O\u001a\u000206H\u0002J\u0014\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010(H\u0002J\b\u0010S\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "iconImageAdapter", "Lcom/bytedance/ee/bear/document/icon/IconImageAdapter;", "statusbar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "disposable", "Lio/reactivex/disposables/Disposable;", "viewModel", "Lcom/bytedance/ee/bear/document/icon/IconViewModel;", "selectIconObserver", "Lcom/bytedance/ee/util/observer/DiffObserver;", "Lcom/bytedance/ee/bear/contract/icon/IconInfo;", "iconListObserver", "", "Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;", "connectionObserver", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "emptyMediator", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyMediator;", "emptyStateSource", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyStateSource;", "localeService", "Lcom/bytedance/ee/bear/contract/LocaleService;", "getLocaleService", "()Lcom/bytedance/ee/bear/contract/LocaleService;", "connectionService", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "getConnectionService", "()Lcom/bytedance/ee/bear/contract/ConnectionService;", "spanCount", "", "itemMargin", "loaded", "", "documentToken", "", "getDocumentToken", "()Ljava/lang/String;", "setDocumentToken", "(Ljava/lang/String;)V", "eventReport", "Lcom/bytedance/ee/bear/document/icon/IconEventReport;", "getEventReport", "()Lcom/bytedance/ee/bear/document/icon/IconEventReport;", "setEventReport", "(Lcom/bytedance/ee/bear/document/icon/IconEventReport;)V", "getItemCountPerRow", "getItemMargin", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onBackPressed", "initTitle", "initRecyclerView", "initEmptyView", "registerObservers", "clickIcon", "iconInfo", "clickIconWidthRandomOption", "random", "loadIconInfoIfNeed", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function1;", "", "randomSelect", "getEmptyViewConfig", "Lcom/bytedance/ee/bear/facade/common/empty/Config;", "language", "close", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconSelectFragment extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f219967s = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f219968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IconImageAdapter f219969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xu5.b.a f219970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f219971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IconViewModel f219972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IconSelectFragment$registerObservers$1 f219973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IconSelectFragment$registerObservers$2 f219974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IconSelectFragment$registerObservers$3 f219975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EmptyStateSource f219976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f219977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f219978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f219979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f219980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.ee.bear.document.icon.a f219981r;

    public static final class a {
    }

    static {
    }

    public final void close() {
        IconViewModel r100 = this.f219972i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.getActive().setValue(Boolean.FALSE);
    }

    public final int V90() {
        int r100 = n.v();
        int r101 = n.d(8);
        int r102 = n.d(8);
        int r103 = n.d(48);
        int r104 = (r100 - r101) - r102;
        int r105 = this.f219977n;
        return (int) Math.floor((r104 - (r103 * r105)) / (r105 - 1.0f));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        close();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Disposable r100 = this.f219971h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        xu5.b.a r101 = this.f219970g;
        if (r101 == null) goto L9;
        r101.resetState();
        return;
    }

    public IconSelectFragment() {
    }

    public static void W90(final IconSelectFragment r100) {
        if (r100.f219979p == true) goto L16;
        String r101 = r100.f219980q;
        if (r101 == null) goto L15;
        EmptyStateSource r102 = r100.f219976m;
        if (r102 == null) goto L10;
        r102.loading();
    L10:
        Function1<Throwable, Unit> r103 = new IconSelectFragment$loadIconInfoIfNeed$1$errorHandler$1(r100);
        Disposable r104 = r100.f219971h;
        if (r104 == null) goto L13;
        r104.dispose();
    L13:
        IconListFetcher r105 = new IconListFetcher((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        r105.f219964c = r101;
        r105.f219963b = new IconSelectFragment$loadIconInfoIfNeed$1$1$1(r100);
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        NetService.f r106 = new NetService.f("/space/api/icon/get");
        r106.f216906c = 2;
        r106.b("token", r105.f219964c);
        List r107 = CollectionsKt.listOf("2");
        ((HashMap) r106.f216909f).put("icon_types", r107);
        NetService.c r108 = e.f219992a;
        r100.f219971h = r105.f219962a.Vc(r108).a(r106).subscribe(new c(r105, r103), new d(r103));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f219972i = (IconViewModel) q.a(this, IconViewModel.class);
        int r101 = n.v();
        int r102 = n.d(8);
        this.f219977n = (int) Math.floor((((r101 - r102) - n.d(8)) / n.d(48)) * 1.0f);
        int r103 = V90();
        this.f219978o = r103;
        if (r103 >= n.d(4)) goto L6;
        this.f219977n--;
        this.f219978o = V90();
        return;
    }

    public final void U90(DocIconNetResult.Icon r100, boolean r110) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110 == false) goto L15;
        com.bytedance.ee.bear.document.icon.a r111 = this.f219981r;
        if (r111 == null) goto L27;
        Integer r101 = Integer.valueOf(r100.f219956id);
        Pair[] r102 = new Pair[2];
        if (r101 == null) goto L12;
        String r103 = r101.toString();
        if (r103 == null) goto L12;
    L13:
        r102[0] = TuplesKt.to("icon_id", r103);
        r102[1] = TuplesKt.to("icon_style", "");
        HashMap r104 = MapsKt.hashMapOf(r102);
        Map<String, String> r105 = r111.a("icon_random");
        ((HashMap) r105).putAll(r104);
        r111.f219986a.v("docs_client_icon_change", r105);
    L12:
        r103 = "";
    L27:
        IconViewModel r112 = this.f219972i;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r112 = null;
    L30:
        r112.setIcon(r100);
        close();
        return;
    L15:
        if (TextUtils.equals(r100.key, IconPlugin.NONE_ICON_KEY) == false) goto L19;
        com.bytedance.ee.bear.document.icon.a r113 = this.f219981r;
        if (r113 == null) goto L27;
        Map<String, String> r106 = r113.a("icon_remove");
        r113.f219986a.v("docs_client_icon_change", r106);
        goto L27
    L19:
        com.bytedance.ee.bear.document.icon.a r114 = this.f219981r;
        if (r114 == null) goto L27;
        Integer r107 = Integer.valueOf(r100.f219956id);
        Pair[] r108 = new Pair[2];
        if (r107 == null) goto L25;
        String r109 = r107.toString();
        if (r109 == null) goto L25;
    L26:
        r108[0] = TuplesKt.to("icon_id", r109);
        r108[1] = TuplesKt.to("icon_style", "");
        HashMap r115 = MapsKt.hashMapOf(r108);
        Map<String, String> r116 = r114.a("icon_choose");
        ((HashMap) r116).putAll(r115);
        r114.f219986a.v("docs_client_icon_change", r116);
    L25:
        r109 = "";
        goto L26
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$3] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$1] */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$2] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentActivity r102 = getActivity();
        IconViewModel r103 = null;
        if (r102 == null) goto L7;
        xu5.b.a r104 = xu5.b.b(r102, null);
        this.f219970g = r104;
        r104.saveState();
        xu5.b.a r105 = this.f219970g;
        if (r105 == null) goto L7;
        r105.d(R.color.lkui_N00, true);
    L7:
        BaseTitleBar r106 = (BaseTitleBar) r100.findViewById(R.id.doc_icon_select_title_bar);
        r106.setDividerVisible(false);
        r106.setLeftImageResource(R.drawable.ud_icon_close_small_outlined);
        r106.setLeftClickListener(new g(this));
        r106.setTitle(R.string.Doc_Doc_ChooseIcon);
        Context r107 = getContext();
        if (r107 == null) goto L11;
        CharSequence r108 = r107.getText(R.string.Doc_Doc_IconRandom);
        if (r108 == null) goto L11;
    L12:
        r106.a(new h(this, r108), true);
        IconImageAdapter r109 = new IconImageAdapter();
        this.f219969f = r109;
        r109.f219958b = new IconSelectFragment$initRecyclerView$1(this);
        RecyclerView r110 = (RecyclerView) r100.findViewById(R.id.rv_icon_container);
        this.f219968e = r110;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r110 = null;
    L15:
        r110.setLayoutManager(new GridLayoutManager(getContext(), this.f219977n));
        RecyclerView r111 = this.f219968e;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r111 = null;
    L18:
        IconImageAdapter r112 = this.f219969f;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("iconImageAdapter");
        r112 = null;
    L21:
        r111.setAdapter(r112);
        RecyclerView.ItemDecoration r113 = new IconSelectFragment$initRecyclerView$itemDecoration$1(this);
        RecyclerView r114 = this.f219968e;
        if (r114 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r114 = null;
    L24:
        r114.addItemDecoration(r113);
        EmptyView r115 = (EmptyView) r100.findViewById(R.id.emptyView);
        final String r116 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        final Context r117 = getContext();
        if (r117 == null) goto L27;
        Config r118 = com.bytedance.ee.bear.facade.common.empty.a.a(new IconSelectFragment$getEmptyViewConfig$1$1(r117, r116));
    L28:
        r115.setConfig(r118);
        Context r119 = r100.getContext();
        RecyclerView r120 = this.f219968e;
        if (r120 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r120 = null;
    L31:
        this.f219976m = new com.bytedance.ee.bear.facade.common.empty.c(r119, this, r115, r120).f226424c;
        r115.setOnRetryListener(new f(this));
        this.f219973j = new IconSelectFragment$registerObservers$1(this);
        IconViewModel r121 = this.f219972i;
        if (r121 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r121 = null;
    L34:
        MutableLiveData<IconInfo> r122 = r121.getSelectedIcon();
        IconSelectFragment$registerObservers$1 r123 = this.f219973j;
        Intrinsics.checkNotNull(r123);
        r122.observe(this, r123);
        this.f219974k = new IconSelectFragment$registerObservers$2(this);
        IconViewModel r124 = this.f219972i;
        if (r124 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        MutableLiveData<List<DocIconNetResult.Icon>> r125 = r103.getIconInfoList();
        IconSelectFragment$registerObservers$2 r126 = this.f219974k;
        Intrinsics.checkNotNull(r126);
        r125.observe(this, r126);
        this.f219975l = new IconSelectFragment$registerObservers$3(this);
        LiveData<ConnectionService.NetworkState> r127 = j.a.f217090a.a();
        IconSelectFragment$registerObservers$3 r128 = this.f219975l;
        Intrinsics.checkNotNull(r128);
        r127.observe(this, r128);
        return;
    L37:
        r103 = r124;
        goto L38
    L27:
        r118 = null;
    L11:
        r108 = "";
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_icon_select_fragment, r101, false);
    }
}
