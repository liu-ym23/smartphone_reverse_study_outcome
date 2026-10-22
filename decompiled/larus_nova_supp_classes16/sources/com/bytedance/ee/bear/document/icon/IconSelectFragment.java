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
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.cover.CoverConstants$CoverSource;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u000206H\u0016J\b\u0010B\u001a\u00020&H\u0016J\u0010\u0010C\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\u0010\u0010D\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\u0010\u0010E\u001a\u0002062\u0006\u0010@\u001a\u00020:H\u0002J\b\u0010F\u001a\u000206H\u0002J\u0012\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010I\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010J\u001a\u00020&H\u0002J\"\u0010K\u001a\u0002062\u0018\b\u0002\u0010L\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010N\u0012\u0004\u0012\u000206\u0018\u00010MH\u0002J\b\u0010O\u001a\u000206H\u0002J\u0014\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010(H\u0002J\b\u0010S\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "iconImageAdapter", "Lcom/bytedance/ee/bear/document/icon/IconImageAdapter;", "statusbar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "disposable", "Lio/reactivex/disposables/Disposable;", "viewModel", "Lcom/bytedance/ee/bear/document/icon/IconViewModel;", "selectIconObserver", "Lcom/bytedance/ee/util/observer/DiffObserver;", "Lcom/bytedance/ee/bear/contract/icon/IconInfo;", "iconListObserver", "", "Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;", "connectionObserver", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "emptyMediator", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyMediator;", "emptyStateSource", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyStateSource;", "localeService", "Lcom/bytedance/ee/bear/contract/LocaleService;", "getLocaleService", "()Lcom/bytedance/ee/bear/contract/LocaleService;", "connectionService", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "getConnectionService", "()Lcom/bytedance/ee/bear/contract/ConnectionService;", "spanCount", "", "itemMargin", "loaded", "", "documentToken", "", "getDocumentToken", "()Ljava/lang/String;", "setDocumentToken", "(Ljava/lang/String;)V", "eventReport", "Lcom/bytedance/ee/bear/document/icon/IconEventReport;", "getEventReport", "()Lcom/bytedance/ee/bear/document/icon/IconEventReport;", "setEventReport", "(Lcom/bytedance/ee/bear/document/icon/IconEventReport;)V", "getItemCountPerRow", "getItemMargin", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onBackPressed", "initTitle", "initRecyclerView", "initEmptyView", "registerObservers", "clickIcon", "iconInfo", "clickIconWidthRandomOption", CoverConstants$CoverSource.RANDOM, "loadIconInfoIfNeed", "onError", "Lkotlin/Function1;", "", "randomSelect", "getEmptyViewConfig", "Lcom/bytedance/ee/bear/facade/common/empty/Config;", "language", "close", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconSelectFragment extends BaseFragment {
    public static final /* synthetic */ int s = 0;
    public RecyclerView e;
    public IconImageAdapter f;
    public xu5.b.a g;
    public Disposable h;
    public IconViewModel i;
    public IconSelectFragment$registerObservers$1 j;
    public IconSelectFragment$registerObservers$2 k;
    public IconSelectFragment$registerObservers$3 l;
    public EmptyStateSource m;
    public int n;
    public int o;
    public boolean p;
    public String q;
    public com.bytedance.ee.bear.document.icon.a r;

    public static final class a {
    }

    static {
    }

    public final void close() {
        IconViewModel r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.getActive().setValue(Boolean.FALSE);
    }

    public final int V90() {
        int r0 = n.v();
        int r2 = n.d(8);
        int r1 = n.d(8);
        int r3 = n.d(48);
        int r4 = (r0 - r2) - r1;
        int r5 = this.n;
        return (int) Math.floor((r4 - (r3 * r5)) / (r5 - 1.0f));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        close();
        return true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        xu5.b.a r1 = this.g;
        if (r1 == null) goto L9;
        r1.resetState();
        return;
    }

    public IconSelectFragment() {
    }

    public static void W90(final IconSelectFragment r6) {
        if (r6.p == true) goto L16;
        String r0 = r6.q;
        if (r0 == null) goto L15;
        EmptyStateSource r1 = r6.m;
        if (r1 == null) goto L10;
        r1.loading();
    L10:
        Function1<Throwable, Unit> r2 = new IconSelectFragment$loadIconInfoIfNeed$1$errorHandler$1(r6);
        Disposable r3 = r6.h;
        if (r3 == null) goto L13;
        r3.dispose();
    L13:
        IconListFetcher r4 = new IconListFetcher((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        r4.c = r0;
        r4.b = new IconSelectFragment$loadIconInfoIfNeed$1$1$1(r6);
        Intrinsics.checkNotNullParameter(r2, "onError");
        NetService.f r5 = new NetService.f("/space/api/icon/get");
        r5.c = 2;
        r5.b("token", r4.c);
        List r7 = CollectionsKt.listOf("2");
        ((HashMap) r5.f).put("icon_types", r7);
        NetService.c r8 = e.a;
        r6.h = r4.a.Vc(r8).a(r5).subscribe(new c(r4, r2), new d(r2));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.i = (IconViewModel) q.a(this, IconViewModel.class);
        int r5 = n.v();
        int r1 = n.d(8);
        this.n = (int) Math.floor((((r5 - r1) - n.d(8)) / n.d(48)) * 1.0f);
        int r6 = V90();
        this.o = r6;
        if (r6 >= n.d(4)) goto L6;
        this.n--;
        this.o = V90();
        return;
    }

    public final void U90(DocIconNetResult.Icon r9, boolean r10) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (r10 == false) goto L15;
        com.bytedance.ee.bear.document.icon.a r11 = this.r;
        if (r11 == null) goto L27;
        Integer r7 = Integer.valueOf(r9.id);
        Pair[] r6 = new Pair[2];
        if (r7 == null) goto L12;
        String r8 = r7.toString();
        if (r8 == null) goto L12;
    L13:
        r6[0] = TuplesKt.to("icon_id", r8);
        r6[1] = TuplesKt.to("icon_style", "");
        HashMap r1 = MapsKt.hashMapOf(r6);
        Map<String, String> r2 = r11.a("icon_random");
        ((HashMap) r2).putAll(r1);
        r11.a.v("docs_client_icon_change", r2);
    L12:
        r8 = "";
    L27:
        IconViewModel r12 = this.i;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L30:
        r12.setIcon(r9);
        close();
        return;
    L15:
        if (TextUtils.equals(r9.key, IconPlugin.NONE_ICON_KEY) == false) goto L19;
        com.bytedance.ee.bear.document.icon.a r13 = this.r;
        if (r13 == null) goto L27;
        Map<String, String> r3 = r13.a("icon_remove");
        r13.a.v("docs_client_icon_change", r3);
        goto L27
    L19:
        com.bytedance.ee.bear.document.icon.a r14 = this.r;
        if (r14 == null) goto L27;
        Integer r16 = Integer.valueOf(r9.id);
        Pair[] r17 = new Pair[2];
        if (r16 == null) goto L25;
        String r18 = r16.toString();
        if (r18 == null) goto L25;
    L26:
        r17[0] = TuplesKt.to("icon_id", r18);
        r17[1] = TuplesKt.to("icon_style", "");
        HashMap r4 = MapsKt.hashMapOf(r17);
        Map<String, String> r5 = r14.a("icon_choose");
        ((HashMap) r5).putAll(r4);
        r14.a.v("docs_client_icon_change", r5);
    L25:
        r18 = "";
        goto L26
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$3] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$1] */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.bytedance.ee.bear.document.icon.IconSelectFragment$registerObservers$2] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        FragmentActivity r8 = getActivity();
        IconViewModel r1 = null;
        if (r8 == null) goto L7;
        xu5.b.a r9 = xu5.b.b(r8, null);
        this.g = r9;
        r9.saveState();
        xu5.b.a r10 = this.g;
        if (r10 == null) goto L7;
        r10.d(2131103449, true);
    L7:
        BaseTitleBar r11 = r6.findViewById(2131369317);
        r11.setDividerVisible(false);
        r11.setLeftImageResource(2131254124);
        r11.setLeftClickListener(new g(this));
        r11.setTitle(2131887656);
        Context r2 = getContext();
        if (r2 == null) goto L11;
        CharSequence r3 = r2.getText(2131887668);
        if (r3 == null) goto L11;
    L12:
        r11.a(new h(this, r3), true);
        IconImageAdapter r12 = new IconImageAdapter();
        this.f = r12;
        r12.b = new IconSelectFragment$initRecyclerView$1(this);
        RecyclerView r13 = r6.findViewById(2131384962);
        this.e = r13;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L15:
        r13.setLayoutManager(new GridLayoutManager(getContext(), this.n));
        RecyclerView r14 = this.e;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r14 = null;
    L18:
        IconImageAdapter r4 = this.f;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("iconImageAdapter");
        r4 = null;
    L21:
        r14.setAdapter(r4);
        RecyclerView.ItemDecoration r16 = new IconSelectFragment$initRecyclerView$itemDecoration$1(this);
        RecyclerView r5 = this.e;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r5 = null;
    L24:
        r5.addItemDecoration(r16);
        EmptyView r17 = (EmptyView) r6.findViewById(2131371567);
        final String r18 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        final Context r19 = getContext();
        if (r19 == null) goto L27;
        Config r20 = com.bytedance.ee.bear.facade.common.empty.a.a(new IconSelectFragment$getEmptyViewConfig$1$1(r19, r18));
    L28:
        r17.setConfig(r20);
        Context r21 = r6.getContext();
        View r22 = this.e;
        if (r22 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r22 = null;
    L31:
        this.m = new com.bytedance.ee.bear.facade.common.empty.c(r21, this, r17, r22).c;
        r17.setOnRetryListener(new f(this));
        this.j = new IconSelectFragment$registerObservers$1(this);
        IconViewModel r23 = this.i;
        if (r23 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r23 = null;
    L34:
        MutableLiveData<IconInfo> r24 = r23.getSelectedIcon();
        IconSelectFragment$registerObservers$1 r0 = this.j;
        Intrinsics.checkNotNull(r0);
        r24.observe(this, r0);
        this.k = new IconSelectFragment$registerObservers$2(this);
        IconViewModel r26 = this.i;
        if (r26 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        MutableLiveData<List<DocIconNetResult.Icon>> r27 = r1.getIconInfoList();
        IconSelectFragment$registerObservers$2 r28 = this.k;
        Intrinsics.checkNotNull(r28);
        r27.observe(this, r28);
        this.l = new IconSelectFragment$registerObservers$3(this);
        LiveData<ConnectionService.NetworkState> r29 = j.a.a.a();
        IconSelectFragment$registerObservers$3 r30 = this.l;
        Intrinsics.checkNotNull(r30);
        r29.observe(this, r30);
        return;
    L37:
        r1 = r26;
        goto L38
    L27:
        r20 = null;
    L11:
        r3 = "";
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560082, r3, false);
    }
}
