package com.larus.business.multitask_management.impl.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import ll9.t;
import ll9.v;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0017\b\u0000\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J(\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0016\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010)H\u0016J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006H\u0002J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\u0018\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u00066"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/PinnedServicesFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/business/multitask_management/impl/component/IPinnedServicesAbility;", "<init>", "()V", EffectConfiguration.KEY_CURSOR, "", "hasMore", "", "firstLoaded", "firstPageHasMore", "pinnedServices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/business/multitask_management/impl/component/QuickAccessListData;", "firstPageSize", "", "loadMorePageSize", "maxPinCount", "isLoading", "job", "Lkotlinx/coroutines/Job;", "pinChanged", "pinListener", "com/larus/business/multitask_management/impl/component/PinnedServicesFeature$pinListener$1", "Lcom/larus/business/multitask_management/impl/component/PinnedServicesFeature$pinListener$1;", "getPinnedServices", "Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "onResume", LiveCommonConstants.REASON_ON_DEDTROY, DitoNode.LOAD_MORE, "refresh", "clearData", "pin", "node", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "unpin", "isPinned", "onRemotePinnedResult", "Lkotlin/Function1;", "removeLocalPinnedNode", "nodeType", "Lcom/larus/multitask_management/api/data/quick_access/NodeType;", "referenceId", "requestPinnedServices", "pageSize", "enablePrefetch", "schedulePinnedPrefetchIfNeeded", "increaseFoldThreshold", "current", "delta", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinnedServicesFeature extends ComponentFeature implements c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j f320778t = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f320779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f320780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f320781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f320782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final StateFlowImpl f320783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f320784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f320785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f320786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f320787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Job f320788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f320789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PinnedServicesFeature$pinListener$1 f320790s;

    public static final class a {
    }

    static {
        int r100 = j0.f375426a;
        f320778t = new j(j0.d(R.string.larus_appEntryManage_bottomSheet_option_pin), false, 2, SectionCardStyle.SMALL, v19.c.b(R.attr.larus_dp_28, null, R.dimen.larus_dp_28), 96);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        N2(this.f320784m, true);
        il9.b r100 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r100 == null) goto L6;
        r100.s2(this.f320790s);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        il9.b r100 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r100 == null) goto L6;
        r100.w0(this.f320790s);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        FLogger.f375446a.i("multitask-PinnedServicesFeature", "onResume, pinChanged = " + this.f320789r);
        if (this.f320789r == false) goto L6;
        this.f320789r = false;
        J(false);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c.class);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.business.multitask_management.impl.component.PinnedServicesFeature$pinListener$1] */
    public PinnedServicesFeature() {
        il9.b r100 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r100 == null) goto L5;
        v r101 = r100.g2();
    L7:
        if (r101 == null) goto L12;
        List<t> r102 = r101.f509787a;
        if (r102 == null) goto L12;
        List r103 = CollectionsKt.filterNotNull(r102);
        if (r103 == null) goto L12;
    L13:
        if (r101 == null) goto L15;
        boolean r104 = Intrinsics.areEqual(r101.f509788b, Boolean.TRUE);
    L16:
        this.f320783l = j1.a(new i(r103, 6, r104));
        this.f320784m = 50;
        z2 r105 = z2.f365865a;
        this.f320785n = r105.getMultiTaskManagementConfig().e();
        this.f320786o = r105.getMultiTaskManagementConfig().d();
        this.f320790s = new PinnedServicesFeature$pinListener$1(this);
        return;
    L15:
        r104 = false;
    L12:
        r103 = CollectionsKt.emptyList();
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    public final void a() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PinnedServicesFeature$loadMore$1(this, null), 3, null);
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    public final StateFlowImpl HO() {
        return this.f320783l;
    }

    public static final void L2(PinnedServicesFeature r100) {
        if (r100.f320781j == true) goto L5;
        return;
    L5:
        if (r100.f320787p == false) goto L8;
        return;
    L8:
        if (r100.f320780i == true) goto L10;
    L12:
        int r101 = RangesKt.coerceAtLeast(((i) r100.f320783l.getValue()).f320812a.size() - ((i) r100.f320783l.getValue()).f320813b, 0);
        if (r100.f320780i == true) goto L15;
        return;
    L15:
        if (r101 >= 6) goto L21;
        FLogger.f375446a.i("multitask-PinnedServicesFeature", "prefetch pinned list, remainingBuffer = " + r101 + ", cursor = " + r100.f320779h);
        r100.N2(r100.f320785n, false);
        return;
    L21:
        return;
    L10:
        if (r100.f320779h != null) goto L12;
        FLogger.f375446a.e("multitask-PinnedServicesFeature", "skip prefetch: hasMore=true but cursor is null");
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    public final void J(boolean r100) {
        this.f320779h = null;
        this.f320780i = false;
        this.f320781j = false;
        N2(this.f320784m, true);
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    public final void Lv(t r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        FLogger.f375446a.i("multitask-PinnedServicesFeature", "unpin node " + r110);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PinnedServicesFeature$unpin$1(this, r110, null), 3, null);
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void mo8547do(t r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        FLogger.f375446a.i("multitask-PinnedServicesFeature", "pin node " + r110);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PinnedServicesFeature$pin$1(this, r110, null), 3, null);
    }

    public final void N2(int r110, boolean r111) {
        Job r100 = this.f320788q;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f320788q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PinnedServicesFeature$requestPinnedServices$1(this, r111, r110, null), 3, null);
    }

    @Override // com.larus.business.multitask_management.impl.component.c
    public final boolean w90(t r110, com.larus.business.multitask_management.impl.sheet.t r111) {
        Intrinsics.checkNotNullParameter(r110, "node");
        List<t> r100 = ((i) this.f320783l.getValue()).f320812a;
        boolean r101 = false;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        t r103 = (t) r102.next();
        if (r103.f509774a == r110.f509774a) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L9;
        r101 = true;
        goto L18
    L13:
        if (Intrinsics.areEqual(r103.f509775b, r110.f509775b) == false) goto L15;
        r104 = true;
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PinnedServicesFeature$isPinned$1(r111, r110, null), 3, null);
        return r101;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public static final void F2(PinnedServicesFeature r100, final NodeType r101, final String r102) {
        List r103 = CollectionsKt.toMutableList(((i) r100.f320783l.getValue()).f320812a);
        boolean r104 = CollectionsKt.removeAll(r103, new h(r101, r102));
        FLogger.f375446a.i("multitask-PinnedServicesFeature", "removeLocalPinnedNode " + r101 + ' ' + r102 + ", removed = " + r104);
        if (r104 == false) goto L8;
        StateFlowImpl r105 = r100.f320783l;
        r105.setValue(i.a((i) r105.getValue(), r103, 0, 6));
        il9.b r106 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r106 == null) goto L9;
        r106.z(new v(CollectionsKt.take(((i) r100.f320783l.getValue()).f320812a, r100.f320784m), Boolean.valueOf(r100.f320782k)));
        return;
    L9:
        return;
    }
}
