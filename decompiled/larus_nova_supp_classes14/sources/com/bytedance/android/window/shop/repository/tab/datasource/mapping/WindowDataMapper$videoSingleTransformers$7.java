package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.b0;
import com.bytedance.android.window.shop.repository.dto.j;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.tab.entity.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/b0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/b0;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$7 extends FunctionReferenceImpl implements Function1<b0, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$7(e r8) {
        super(1, r8, e.class, "videoCartHangingPlayableCardDto2Vo", "videoCartHangingPlayableCardDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowHangingProductVideoDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(b0 r10) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        ((e) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        int r0 = o.q;
        Intrinsics.checkNotNullParameter(r10, "dto");
        int r1 = com.bytedance.android.window.shop.repository.tab.entity.e.e;
        j r2 = r10.e();
        if (r2 != null) goto L6;
    L10:
        com.bytedance.android.window.shop.repository.tab.entity.e r4 = null;
    L17:
        if (r10.c() != null) goto L19;
        tq3.c r5 = null;
    L20:
        if (r5 == null) goto L24;
        fo.b r3 = ((WindowV2ProductItemVO) r5).C;
        if (r3 == null) goto L24;
        Integer r6 = (Integer) r3.b(wn.a.f, 207);
    L24:
        Boolean r7 = r10.d();
        Boolean r8 = Boolean.TRUE;
        return new o(r4, r5, Intrinsics.areEqual(r7, r8), Intrinsics.areEqual(r10.b(), r8), r10.a());
    L19:
        WindowV2ProductItemVO.a r9 = WindowV2ProductItemVO.P;
        s r11 = r10.c();
        int r12 = tq3.c.T;
        tq3.c r13 = tq3.c.a.a(r10.c());
        r9.getClass();
        WindowV2ProductItemVO.a.b(r11, r13);
        r5 = r13;
        goto L20
    L6:
        if (r2.f() == null) goto L10;
        if (r2.a() == null) goto L10;
        Long r14 = r2.d();
        if (r14 == null) goto L14;
        r14.longValue();
        com.bytedance.android.window.shop.repository.tab.entity.e r15 = new com.bytedance.android.window.shop.repository.tab.entity.e(r2.f(), r2.a(), r2.d().longValue(), r2.c());
    L15:
        r4 = r15;
        goto L17
    L14:
        r15 = null;
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b0) r1);
    }
}
