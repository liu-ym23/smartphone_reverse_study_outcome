package ar3;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final List<d> a;
    public final Function1<WindowHybridTabDataListResponseDTO, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super WindowHybridTabDataListResponseDTO, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final boolean a(WindowV2ProductItemVO r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "itemVO");
        Intrinsics.checkNotNullParameter(r15, "categoryId");
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L38;
        d r2 = (d) r1.next();
        if (r2.c(r14, r15) == false) goto L4;
        Intrinsics.checkNotNullParameter(r14, "itemVO");
        com.bytedance.android.window.shop.repository.tab.entity.f r3 = d.a(r14);
        WindowHybridTabDataListResponseDTO r5 = null;
        if (r3 == null) goto L31;
        ECWindowViewModel r6 = r2.b;
        WindowHybridTabViewModel r7 = r2.c;
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "tabViewModel");
        Intrinsics.checkNotNullParameter(r3, "itemVO");
        com.bytedance.android.window.shop.repository.tab.entity.g r8 = com.bytedance.android.window.shop.repository.tab.entity.g.b;
        monitor-enter(r8);
        com.bytedance.android.window.shop.repository.tab.entity.g.a++;     // Catch: Throwable -> L35
        long r9 = com.bytedance.android.window.shop.repository.tab.entity.g.a;     // Catch: Throwable -> L35
        monitor-exit(r8);
        String.valueOf(r9);
        fo.b r10 = r3.f;
        fo.a<Map<String, String>> r11 = m0.a;
        Map r12 = (Map) r10.a(r11);
        if (r12 == null) goto L17;
        Map r13 = MapsKt.toMutableMap(r12);
        r13.put("card_type", r2.b().getVaneType());
        r3.f.d(r11, r13);
    L17:
        String r4 = r14.a;
        Intrinsics.checkNotNullParameter(r4, "currentProductId");
        Intrinsics.checkNotNullParameter(r3, "$this$removeInsertRequestKey");
        Map<String, String> r16 = (Map) r3.f.c(r11);
        if (r16 == null) goto L20;
        r3.f.d(m0.b, r16);
    L20:
        if (r16 != null) goto L22;
        WindowHybridTabDataListResponseDTO r17 = null;
    L23:
        if (r17 == null) goto L31;
        ECHybridListDTO r18 = r17.getFeed();
        if (r18 == null) goto L31;
        Map r19 = r18.getItemConfigs();
        if (r19 == null) goto L31;
        if ((!r19.isEmpty()) != true) goto L31;
        r5 = r17;
        goto L31
    L22:
        String r20 = r6.getShopParam().getSecAuthorId();
        Set<String> r110 = r7.getExcludedList(r4);
        int r21 = zq3.d.a;
        r17 = r7.prefetchInsertData(r20, r16, r110, zq3.d.a(r6.getShopParam(), z1.g(r6.getEntranceInfo())), (String) r6.getShopParam().getPassThroughParam("pass_through_api"));
    L35:
        th = move-exception;
        throw th;
    L31:
        if (r5 == null) goto L4;
        Observable.create(new e(r5)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.a);
        return true;
    L38:
        return false;
    }
}
