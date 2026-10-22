package com.bytedance.android.shopping.orderlist.list.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.orderlist.common.controller.n;
import com.bytedance.android.shopping.orderlist.list.network.OrderListRequestViewModel;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import gg3.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001c\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J\b\u0010\t\u001a\u00020\u0007H\u0014J\u001f\u0010\u000e\u001a\u00020\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\b\fJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010*\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R:\u00109\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020807078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/viewmodel/OrderListViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/orderlist/list/viewmodel/OrderListState;", "defaultState", "", "", "newData", "", "updateSchemaMap", "onCleared", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/orderlist/list/viewmodel/a;", "Lkotlin/ExtensionFunctionType;", "update", "setTabState", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "updateTrackerCommonParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "btmPageFinder", "Lcom/bytedance/android/btm/api/model/PageFinder;", "getBtmPageFinder", "()Lcom/bytedance/android/btm/api/model/PageFinder;", "setBtmPageFinder", "(Lcom/bytedance/android/btm/api/model/PageFinder;)V", "staticState", "Lcom/bytedance/android/shopping/orderlist/list/viewmodel/a;", "getStaticState", "()Lcom/bytedance/android/shopping/orderlist/list/viewmodel/a;", "Lcom/bytedance/android/shopping/orderlist/list/tracker/OrderListTracker;", "tracker", "Lcom/bytedance/android/shopping/orderlist/list/tracker/OrderListTracker;", "getTracker", "()Lcom/bytedance/android/shopping/orderlist/list/tracker/OrderListTracker;", "Lgg3/d;", "silentRequestState$delegate", "Lkotlin/Lazy;", "getSilentRequestState", "()Lgg3/d;", "silentRequestState", "", "isFirstEnter", "Z", "()Z", "setFirstEnter", "(Z)V", "", "firstQueryLatestVersion", "I", "getFirstQueryLatestVersion", "()I", "setFirstQueryLatestVersion", "(I)V", "isSplitMode", "setSplitMode", "", "", "customDynamicParams", "Ljava/util/Map;", "getCustomDynamicParams", "()Ljava/util/Map;", "setCustomDynamicParams", "(Ljava/util/Map;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListViewModel extends JediViewModel<OrderListState> {
    private PageFinder btmPageFinder;
    private Map<String, Map<String, Object>> customDynamicParams;
    private int firstQueryLatestVersion;
    private boolean isFirstEnter;
    private boolean isSplitMode;
    private final Lazy silentRequestState$delegate;
    private final a staticState;
    private final OrderListTracker tracker;

    public final d getSilentRequestState() {
        return (d) this.silentRequestState$delegate.getValue();
    }

    public OrderListState defaultState() {
        return new OrderListState(0);
    }

    public OrderListViewModel() {
        this.staticState = new a(null, null, null, null, null, null, 67108863);
        this.tracker = new OrderListTracker(this);
        this.silentRequestState$delegate = LazyKt.lazy(OrderListViewModel$silentRequestState$2.INSTANCE);
        this.isFirstEnter = true;
        this.customDynamicParams = new LinkedHashMap();
    }

    public void onCleared() {
        super.onCleared();
        Map<String, ig3.a> r0 = ig3.a.h;
        String r1 = this.staticState.b;
        if (r1 == null) goto L5;
        ig3.a.h.remove(r1);
    L5:
        Map<String, OrderListRequestViewModel> r2 = OrderListRequestViewModel.z;
        String r3 = this.staticState.b;
        Map<String, OrderListRequestViewModel> r4 = OrderListRequestViewModel.z;
        if (r4 == null) goto L12;
        OrderListRequestViewModel r5 = (OrderListRequestViewModel) TypeIntrinsics.asMutableMap(r4).remove(r3);
        if (r5 == null) goto L13;
        String r6 = n.a;
        r5.doClear();
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final PageFinder getBtmPageFinder() {
        return this.btmPageFinder;
    }

    public final Map<String, Map<String, Object>> getCustomDynamicParams() {
        return this.customDynamicParams;
    }

    public final int getFirstQueryLatestVersion() {
        return this.firstQueryLatestVersion;
    }

    public final a getStaticState() {
        return this.staticState;
    }

    public final OrderListTracker getTracker() {
        return this.tracker;
    }

    public final boolean isFirstEnter() {
        return this.isFirstEnter;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m2269defaultState() {
        return defaultState();
    }

    public final void setBtmPageFinder(PageFinder r1) {
        this.btmPageFinder = r1;
    }

    public final void setCustomDynamicParams(Map<String, Map<String, Object>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.customDynamicParams = r2;
    }

    public final void setFirstEnter(boolean r1) {
        this.isFirstEnter = r1;
    }

    public final void setFirstQueryLatestVersion(int r1) {
        this.firstQueryLatestVersion = r1;
    }

    public final void setSplitMode(boolean r1) {
        this.isSplitMode = r1;
    }

    public final void setTabState(Function1<? super a, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "update");
        r3.invoke(this.staticState);
        OrderListTracker r4 = this.tracker;
        Map<String, ? extends Object> r0 = this.staticState.a();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        r4.a.appendEventParams(r0);
    }

    public final void updateSchemaMap(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "newData");
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r5.next();
        OrderListParams r1 = this.staticState.g;
        if (r1 == null) goto L4;
        Map<String, String> r2 = r1.getSchemaParamsMap();
        if (r2 == null) goto L4;
        r2.put(r0.getKey(), r0.getValue());
        goto L4
    }

    public final void updateTrackerCommonParams(c r3) {
        Object r0 = null;
        if (r3 == null) goto L7;
        Map r4 = r3.g();
        if (r4 == null) goto L7;
        Object r5 = r4.get("tracker_common_params");
    L9:
        if (TypeIntrinsics.isMutableMap(r5) == false) goto L12;
        r0 = r5;
    L12:
        Map<String, ? extends Object> r1 = (Map) r0;
        if (r1 != null) goto L15;
        r1 = new LinkedHashMap();
    L15:
        r1.isEmpty();
        OrderListTracker r6 = this.tracker;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        r6.a.appendEventParams(r1);
        return;
    L7:
        r5 = null;
        goto L9
    }
}
