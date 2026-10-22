package com.bytedance.android.shopping.store.lifecycle;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECStorePerfMonitor$onPageAsyncShow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JSONObject $category;
    final /* synthetic */ JSONObject $metric;
    final /* synthetic */ ECStoreParam $storeParam;
    final /* synthetic */ StoreTabConfig $tabConfig;
    final /* synthetic */ ECStorePerfMonitor this$0;

    public ECStorePerfMonitor$onPageAsyncShow$1(ECStorePerfMonitor r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5) {
        this.this$0 = r1;
        this.$tabConfig = r2;
        this.$storeParam = r3;
        this.$category = r4;
        this.$metric = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m262invoke() {
        ECStorePerfMonitor.U(this.this$0, this.$tabConfig, this.$storeParam, this.$category, this.$metric);
        ECStorePerfMonitor r0 = this.this$0;
        r0.getClass();
        r0.getClass();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m262invoke();
        return Unit.INSTANCE;
    }
}
