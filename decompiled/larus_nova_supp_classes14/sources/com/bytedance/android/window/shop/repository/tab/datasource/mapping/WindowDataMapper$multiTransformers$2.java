package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.m0;
import com.bytedance.android.window.shop.repository.dto.t0;
import com.bytedance.android.window.shop.repository.dto.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "p1", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$multiTransformers$2 extends FunctionReferenceImpl implements Function1<Object, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> {
    public WindowDataMapper$multiTransformers$2(a r8) {
        super(1, r8, a.class, "hotsaleProductListDto2VoList", "hotsaleProductListDto2VoList(Ljava/lang/Object;)Ljava/util/List;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<com.bytedance.android.window.shop.repository.tab.entity.f> m925invoke(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        u0 r10 = (u0) r9;
        ArrayList r1 = new ArrayList();
        t0 r2 = r10.b();
        boolean r3 = false;
        if (r2 == null) goto L19;
        String r5 = r2.b();
        String r6 = "";
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        String r7 = r2.c();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        String r4 = r2.a();
        if (r4 == null) goto L14;
        r6 = r4;
    L14:
        List<m0> r8 = r10.c();
        if (r8 == null) goto L17;
        int r11 = r8.size();
    L18:
        r1.add(new sq3.d(r5, r7, r6, r11));
        goto L19
    L17:
        r11 = 0;
    L19:
        List<m0> r12 = r10.c();
        if (r12 == null) goto L25;
        Iterator<T> r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        m0 r14 = (m0) r13.next();
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r14, "item");
        int r15 = sq3.a.p;
        int r16 = sq3.h.W;
        sq3.h r17 = sq3.h.a.a(r14);
        ((WindowV2ProductItemVO) r17).y = r14.b();
        ((WindowV2ProductItemVO) r17).C.b(wn.a.C, Integer.valueOf(r14.b()));
        Unit r18 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "vo");
        r1.add(new sq3.a(r17));
    L25:
        Iterator r0 = r1.iterator();
    L26:
        Object r19 = null;
        if (r0.hasNext() == false) goto L31;
        Object r20 = r0.next();
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r20) instanceof sq3.a) == false) goto L26;
    L33:
        if ((r20 instanceof sq3.a) == false) goto L36;
        r19 = r20;
    L36:
        sq3.a r21 = (sq3.a) r19;
        if (r21 == null) goto L42;
        Boolean r22 = r10.a();
        if (r22 == null) goto L41;
        r3 = r22.booleanValue();
    L41:
        r21.o = r3;
    L42:
        return r1;
    L31:
        r20 = null;
        goto L33
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return m925invoke(r1);
    }
}
