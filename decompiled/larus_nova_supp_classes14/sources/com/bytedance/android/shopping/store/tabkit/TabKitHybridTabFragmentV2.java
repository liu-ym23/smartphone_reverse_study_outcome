package com.bytedance.android.shopping.store.tabkit;

import android.os.Bundle;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.n;
import com.bytedance.android.btm.api.model.o;
import com.bytedance.android.shopping.store.tabkit.model.TabVisibleFrom;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragmentV2;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "", "visible", "Lcom/bytedance/android/shopping/store/tabkit/model/TabVisibleFrom;", "showFrom", "sendVisibleEvent", "com/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragmentV2$b", "btmPageCallback", "Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragmentV2$b;", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "btmShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitHybridTabFragmentV2 extends TabKitHybridTabFragment {
    public static final a Companion = null;
    private final String TAG;
    private final b btmPageCallback;
    private final AtomicBoolean btmShow;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends bd.a {
        public final /* synthetic */ TabKitHybridTabFragmentV2 a;

        public b(TabKitHybridTabFragmentV2 r1) {
            this.a = r1;
        }

        public final void onPageResumed(Object r3) {
            TabKitHybridTabFragmentV2 r0 = this.a;
            if (r3 != r0) goto L6;
            int r4 = mk3.a.a;
            Map r5 = MapsKt.mapOf(TuplesKt.to("tabs_container_id", r0.getTabKitViewModel().getTabsContainerId()));
            Intrinsics.checkNotNullParameter(r0, "fragment");
            Intrinsics.checkNotNullParameter(r5, "params");
            BtmSDK.INSTANCE.unregisterBtmPageCallback(this);
            return;
        }
    }

    static {
        Companion = new a();
        BtmHostDependManager r0 = BtmSDK.INSTANCE.getDepend();
        com.bytedance.android.btm.api.i r1 = new com.bytedance.android.btm.api.i(TabKitHybridTabFragmentV2.class, null, 2);
        r0.getClass();
        BtmHostDependManager.h(r1);
    }

    public TabKitHybridTabFragmentV2() {
        this.btmPageCallback = new b(this);
        this.TAG = "TabKitHybridTabFragmentV2";
        this.btmShow = new AtomicBoolean(false);
    }

    public void onDestroy() {
        super.onDestroy();
        BtmSDK.INSTANCE.unregisterBtmPageCallback(this.btmPageCallback);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitHybridTabFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        BtmSDK.INSTANCE.registerBtmPageCallback(this.btmPageCallback);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitHybridTabFragment
    public void sendVisibleEvent(boolean r11, TabVisibleFrom r12) {
        Intrinsics.checkNotNullParameter(r12, "showFrom");
        if (this.btmShow.compareAndSet(!r11, r11) == false) goto L11;
        if (r11 == true) goto L6;
        BtmSDK.onPageHide$default(BtmSDK.INSTANCE, this, null, 2, null);
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.TAG).i("BtmSDK.onPageHide " + this);
        goto L11
    L6:
        if (r12 != TabVisibleFrom.Enter) goto L8;
        BtmSDK r1 = BtmSDK.INSTANCE;
        Boolean r2 = Boolean.TRUE;
        o r3 = new o();
        ((n) r3).a = true;
        Unit r4 = Unit.INSTANCE;
        r1.onPageShow(this, r2, r3);
    L9:
        dm.a.b r5 = dm.a.a;
        dm.a.a(this.TAG).i("BtmSDK.onPageShow " + this);
        goto L11
    L8:
        BtmSDK r6 = BtmSDK.INSTANCE;
        o r7 = new o();
        ((n) r7).a = true;
        Unit r8 = Unit.INSTANCE;
        BtmSDK.onPageShow$default(r6, this, null, r7, 2, null);
    L11:
        super.sendVisibleEvent(r11, r12);
    }
}
