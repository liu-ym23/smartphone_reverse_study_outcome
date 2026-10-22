package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopTabKitCompatPresenter$reportTabShowEvent$1 implements Runnable {
    public final /* synthetic */ ECShopTabKitCompatPresenter a;
    public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k b;

    public ECShopTabKitCompatPresenter$reportTabShowEvent$1(ECShopTabKitCompatPresenter r1, com.bytedance.android.shopping.store.tabkit.model.k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        uj3.j r0 = this.a.T().getTab(this.b.n());
        if (r0 != null) goto L5;
        return;
    L5:
        uj3.j r1 = this.a.T().getCurrentTab();
        if (r1 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r1, r0) == true) goto L16;
        uj3.j r2 = r1.a;
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L18:
        if (r0.d != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L27;
        if (r3 == true) goto L27;
        WeakHashMap<Object, ArrayList<String>> r4 = com.bytedance.android.shopping.store.utils.w.a;
        ECShopTabKitCompatPresenter r5 = this.a;
        Function0<Unit> r6 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("show_consultation", "tag");
        Intrinsics.checkNotNullParameter(r6, "work");
        WeakHashMap<Object, ArrayList<String>> r7 = com.bytedance.android.shopping.store.utils.w.a;
        if (r7.containsKey(r5) == false) goto L23;
        ArrayList<String> r8 = r7.get(r5);
        Intrinsics.checkNotNull(r8);
        ArrayList<String> r9 = r8;
    L25:
        if (r9.contains("show_consultation") == true) goto L27;
        r6.invoke();
        r9.add("show_consultation");
        goto L27
    L23:
        ArrayList<String> r10 = new ArrayList();
        r7.put(r5, r10);
        r9 = r10;
    L27:
        if (r3 == true) goto L37;
        ECShopTabKitCompatPresenter r11 = this.a;
        r11.getClass();
        Lazy r12 = ECTaskManager.b;
        ECTaskManager r13 = ECTaskManager.a.a();
        ECShopTabKitCompatPresenter$reportTabEvent$1 r14 = new ECShopTabKitCompatPresenter$reportTabEvent$1(r11, "commodity_source_tab_show", r0, null);
        r13.getClass();
        ECTaskManager.b(r14);
        if (r0.h() == false) goto L38;
        ECShopTabKitCompatPresenter r15 = this.a;
        String r16 = r0.a(r15.y());
        Map<String, ? extends Object> r17 = MapsKt.emptyMap();
        StoreV3LiveRoomVO r18 = (StoreV3LiveRoomVO) r15.T().getLiveInfo().getValue();
        if (r18 == null) goto L34;
        String r19 = r18.getRoomId();
        if (r19 == null) goto L34;
    L35:
        r15.T().doAnyEventActionWithBtm(r16, PageFinder.via(r15.y()), "livesdk_live_show", r17, new Pair[]{TuplesKt.to("enter_from_merge", "store_page"), TuplesKt.to("enter_method", "shop_live_tab"), TuplesKt.to("room_id", r19), TuplesKt.to("pass_through_log_data", r15.T().getPassThroughLogData())});
        return;
    L34:
        r19 = "";
        goto L35
    L38:
        return;
    L37:
        return;
    L13:
        if (Intrinsics.areEqual(r2, r0) == false) goto L15;
    L16:
        r3 = true;
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
