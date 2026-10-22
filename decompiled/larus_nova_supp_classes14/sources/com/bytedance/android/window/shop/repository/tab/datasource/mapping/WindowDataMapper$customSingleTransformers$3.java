package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.dto.q;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.l0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/l0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/e0;", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/l0;)Lcom/bytedance/android/window/shop/repository/tab/entity/e0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$3 extends FunctionReferenceImpl implements Function1<l0, e0> {
    public WindowDataMapper$customSingleTransformers$3(e0.a r8) {
        super(1, r8, e0.a.class, "create", "create(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowToolbarDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductToolBarVO;", 0);
    }

    public final e0 invoke(l0 r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((e0.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "dto");
        int r1 = d0.k;
        List<q> r2 = r4.b();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        d0 r3 = d0.a.a(r2);
        WindowLayoutType.a r5 = WindowLayoutType.Companion;
        Integer r6 = r4.a();
        r5.getClass();
        WindowLayoutType r7 = WindowLayoutType.a.a(r6);
        if (r7 != null) goto L9;
        r7 = WindowLayoutType.SINGLECOLUMN;
    L9:
        return new e0(r3, r7, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((l0) r1);
    }
}
