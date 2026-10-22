package com.bytedance.android.shopping.orderlist.search.viewmodel;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\r\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nJ\b\u0010\u000e\u001a\u00020\bH\u0014R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/viewmodel/OrderSearchResultViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/OrderSearchResultState;", "defaultState", "Landroid/content/Context;", "context", "Lig3/a;", "monitorManager", "", "doFirstScreenQuery", "", "", "newData", "updateSchemaMap", "onCleared", "Lcom/bytedance/android/btm/api/model/PageFinder;", "btmPageFinder", "Lcom/bytedance/android/btm/api/model/PageFinder;", "getBtmPageFinder", "()Lcom/bytedance/android/btm/api/model/PageFinder;", "setBtmPageFinder", "(Lcom/bytedance/android/btm/api/model/PageFinder;)V", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/d;", "staticState", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/d;", "getStaticState", "()Lcom/bytedance/android/shopping/orderlist/search/viewmodel/d;", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/c;", "requestUseCase", "Lcom/bytedance/android/shopping/orderlist/search/viewmodel/c;", "getRequestUseCase", "()Lcom/bytedance/android/shopping/orderlist/search/viewmodel/c;", "Llg3/a;", "tracker", "Llg3/a;", "getTracker", "()Llg3/a;", "Lgg3/d;", "silentRequestState$delegate", "Lkotlin/Lazy;", "getSilentRequestState", "()Lgg3/d;", "silentRequestState", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultViewModel extends JediViewModel<OrderSearchResultState> {
    private PageFinder btmPageFinder;
    private final c requestUseCase;
    private final Lazy silentRequestState$delegate;
    private final d staticState;
    private final lg3.a tracker;

    public final gg3.d getSilentRequestState() {
        return (gg3.d) this.silentRequestState$delegate.getValue();
    }

    public OrderSearchResultState defaultState() {
        return new OrderSearchResultState(0);
    }

    public OrderSearchResultViewModel() {
        this.staticState = new d(null);
        this.requestUseCase = new c(this);
        this.tracker = new lg3.a(this);
        this.silentRequestState$delegate = LazyKt.lazy(OrderSearchResultViewModel$silentRequestState$2.INSTANCE);
    }

    public void onCleared() {
        super.onCleared();
        Map<String, ig3.a> r0 = ig3.a.h;
        String r1 = this.staticState.c;
        if (r1 == null) goto L6;
        ig3.a.h.remove(r1);
        return;
    }

    public final PageFinder getBtmPageFinder() {
        return this.btmPageFinder;
    }

    public final c getRequestUseCase() {
        return this.requestUseCase;
    }

    public final d getStaticState() {
        return this.staticState;
    }

    public final lg3.a getTracker() {
        return this.tracker;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m2451defaultState() {
        return defaultState();
    }

    public final void setBtmPageFinder(PageFinder r1) {
        this.btmPageFinder = r1;
    }

    public final void updateSchemaMap(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "newData");
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r5.next();
        OrderSearchResultParams r1 = this.staticState.g;
        if (r1 == null) goto L4;
        Map<String, String> r2 = r1.getSchemaParamsMap();
        if (r2 == null) goto L4;
        r2.put(r0.getKey(), r0.getValue());
        goto L4
    }

    public final void doFirstScreenQuery(final Context r3, final ig3.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OrderCommonErrorMonitorKt.c(this.tracker, "OrderSearchViewModel-queryData", new AnonymousClass1(this, r4, r3));
    }
}
