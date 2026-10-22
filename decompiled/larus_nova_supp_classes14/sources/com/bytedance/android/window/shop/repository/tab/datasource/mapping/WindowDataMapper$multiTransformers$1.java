package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.SyncType;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.z0;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "p1", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$multiTransformers$1 extends FunctionReferenceImpl implements Function1<Object, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> {
    public WindowDataMapper$multiTransformers$1(a r8) {
        super(1, r8, a.class, "productSyncDto2VoList", "productSyncDto2VoList(Ljava/lang/Object;)Ljava/util/List;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<com.bytedance.android.window.shop.repository.tab.entity.f> m924invoke(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        z0 r10 = (z0) r9;
        ArrayList r0 = new ArrayList();
        String r2 = r10.c();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        List<WindowV2ProductItemDTO> r3 = r10.a();
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.size();
    L9:
        r0.add(new k0(r2, r5, r10.b()));
        List<WindowV2ProductItemDTO> r1 = r10.a();
        if (r1 == null) goto L21;
        Iterator<T> r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        WindowV2ProductItemDTO r11 = (WindowV2ProductItemDTO) r7;
        int r12 = b0.k;
        Intrinsics.checkNotNullParameter(r11, "dto");
        WindowV2ProductItemVO.a r13 = WindowV2ProductItemVO.P;
        tq3.c r14 = new tq3.c(r11.e());
        r13.getClass();
        WindowV2ProductItemVO.a.b(r11, r14);
        b0 r15 = new b0(r14);
        fo.b r16 = ((WindowV2ProductItemVO) r15.j).C;
        r16.b(wn.a.d, "product_card");
        r16.b(wn.a.a, "product_card");
        r16.b(wn.a.t, Boolean.TRUE);
        r16.b(wn.a.C, Integer.valueOf(r8));
        SyncType r17 = r10.b();
        if (r17 == null) goto L20;
        String r18 = (String) r16.b(wn.a.e, r17.getType());
    L20:
        r0.add(r15);
        r4 = r8;
    L21:
        return r0;
    L8:
        r5 = 0;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return m924invoke(r1);
    }
}
