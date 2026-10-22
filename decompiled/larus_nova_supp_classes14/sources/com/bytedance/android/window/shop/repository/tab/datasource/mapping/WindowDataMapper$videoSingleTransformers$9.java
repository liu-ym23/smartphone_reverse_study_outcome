package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.dto.t;
import com.bytedance.android.window.shop.repository.tab.entity.ProductVideoVO;
import com.bytedance.android.window.shop.repository.tab.entity.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/t;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/t;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$9 extends FunctionReferenceImpl implements Function1<t, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$9(e r8) {
        super(1, r8, e.class, "playableExplainProductCardDto2Vo", "playableExplainProductCardDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowExplainProductVideoDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(t r13) {
        Intrinsics.checkNotNullParameter(r13, "p1");
        ((e) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        int r0 = k.t;
        Intrinsics.checkNotNullParameter(r13, "dto");
        int r1 = ProductVideoVO.i;
        ProductVideoVO r7 = ProductVideoVO.a.a(r13.j());
        s r2 = r13.g();
        if (r2 == null) goto L5;
        WindowV2ProductItemVO.a r3 = WindowV2ProductItemVO.P;
        int r4 = tq3.c.T;
        tq3.c r5 = tq3.c.a.a(r2);
        r3.getClass();
        WindowV2ProductItemVO.a.b(r2, r5);
        tq3.c r11 = r5;
    L6:
        String r6 = r13.f();
        if (r6 != null) goto L9;
        String r8 = "";
    L10:
        String r9 = r13.i();
        if (r9 != null) goto L13;
        String r10 = "";
    L14:
        String r12 = r13.e();
        if (r12 != null) goto L17;
        String r14 = "";
    L18:
        String r15 = r13.h();
        if (r15 != null) goto L21;
        String r16 = "";
    L22:
        String r17 = r13.d();
        if (r17 != null) goto L25;
        String r18 = "";
    L27:
        return new k(r8, r10, r14, r16, r18, r7, r13.a(), r13.b(), r13.c(), r11);
    L25:
        r18 = r17;
        goto L27
    L21:
        r16 = r15;
        goto L22
    L17:
        r14 = r12;
        goto L18
    L13:
        r10 = r9;
        goto L14
    L9:
        r8 = r6;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((t) r1);
    }
}
