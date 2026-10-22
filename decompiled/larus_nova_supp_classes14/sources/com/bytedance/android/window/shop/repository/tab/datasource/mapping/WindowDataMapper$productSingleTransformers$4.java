package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.l0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/l0;", "p1", "Ltq3/b;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/l0;)Ltq3/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$4 extends FunctionReferenceImpl implements Function1<l0, tq3.b> {
    public WindowDataMapper$productSingleTransformers$4(tq3.b.a r8) {
        super(1, r8, tq3.b.a.class, "transFromDto", "transFromDto(Lcom/bytedance/android/window/shop/repository/dto/WindowHintTextDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/product/WindowHintTextVO;", 0);
    }

    public final tq3.b invoke(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((tq3.b.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "dto");
        String r3 = r2.a();
        if (r3 != null) goto L6;
        return null;
    L6:
        return new tq3.b(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((l0) r1);
    }
}
