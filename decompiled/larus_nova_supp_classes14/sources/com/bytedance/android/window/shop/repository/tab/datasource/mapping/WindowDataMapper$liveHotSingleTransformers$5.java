package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.q0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sq3.k;
import uq3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$5 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$5(c r8) {
        super(1, r8, c.class, "liveTopSellingProductDto2Vo", "liveTopSellingProductDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ((c) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        q0 r6 = (q0) r5;
        int r0 = k.k;
        Intrinsics.checkNotNullParameter(r6, "dto");
        int r2 = sq3.h.W;
        Intrinsics.checkNotNullParameter(r6, "dto");
        WindowV2ProductItemDTO r3 = r6.a;
        if (r3 == null) goto L5;
        List r4 = r3.e();
    L6:
        sq3.h r1 = new sq3.h(r4);
        WindowV2ProductItemDTO r7 = r6.a;
        if (r7 == null) goto L9;
        WindowV2ProductItemVO.P.getClass();
        WindowV2ProductItemVO.a.b(r7, r1);
    L9:
        com.bytedance.android.window.shop.repository.dto.g r8 = r6.a();
        if (r8 == null) goto L12;
        int r9 = s.c;
        r1.U = s.a.a(r8);
    L12:
        k r10 = new k(r1);
        sq3.h r11 = r10.j;
        if (r11 == null) goto L17;
        fo.b r12 = ((WindowV2ProductItemVO) r11).C;
        if (r12 == null) goto L17;
        String r13 = (String) r12.b(wn.a.a, "live_order");
    L17:
        sq3.h r14 = r10.j;
        if (r14 == null) goto L22;
        fo.b r15 = ((WindowV2ProductItemVO) r14).C;
        if (r15 == null) goto L22;
        String r16 = (String) r15.b(wn.a.e, "112002");
    L22:
        sq3.h r17 = r10.j;
        if (r17 == null) goto L27;
        fo.b r18 = ((WindowV2ProductItemVO) r17).C;
        if (r18 == null) goto L27;
        com.bytedance.android.window.shop.repository.tab.entity.f r19 = (com.bytedance.android.window.shop.repository.tab.entity.f) r18.b(wn.a.D, r10);
    L27:
        return r10;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m921invoke(Object r1) {
        return invoke(r1);
    }
}
