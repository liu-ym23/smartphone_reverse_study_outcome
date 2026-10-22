package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.tab.entity.j0;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/j0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/k0;", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/j0;)Lcom/bytedance/android/window/shop/repository/tab/entity/k0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$1 extends FunctionReferenceImpl implements Function1<j0, k0> {
    public WindowDataMapper$customSingleTransformers$1(k0.a r8) {
        super(1, r8, k0.a.class, "create", "create(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowSyncBannerNoticeDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowSyncNoticeBannerVO;", 0);
    }

    public final k0 invoke(j0 r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((k0.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "dto");
        String r1 = r4.a();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Integer r2 = r4.b();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L10:
        return new k0(r1, r3, r4.c());
    L8:
        r3 = 0;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((j0) r1);
    }
}
