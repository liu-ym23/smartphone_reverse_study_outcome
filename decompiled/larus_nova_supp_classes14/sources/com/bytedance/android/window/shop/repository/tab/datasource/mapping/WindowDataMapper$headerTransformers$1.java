package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.window.shop.repository.dto.c0;
import com.bytedance.android.window.shop.repository.dto.m;
import com.bytedance.android.window.shop.repository.dto.s0;
import com.bytedance.android.window.shop.repository.dto.x;
import com.bytedance.android.window.shop.repository.dto.x0;
import com.bytedance.android.window.shop.repository.vo.PopularRankInfoVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uq3.k;
import uq3.q;
import uq3.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$1 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$1(h r8) {
        super(1, r8, h.class, "authorInfo2Vo", "authorInfo2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((h) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        int r0 = oq3.a.x;
        c0 r10 = (c0) r9;
        Intrinsics.checkNotNullParameter(r10, "dto");
        oq3.a r1 = new oq3.a();
        r1.k = r10.b();
        com.bytedance.android.window.shop.repository.dto.e r2 = r10.n();
        if (r2 == null) goto L14;
        PopularRankInfoVO.Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "dto");
        String r3 = r2.b();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        PopularRankInfoVO r5 = new PopularRankInfoVO();
        r5.setRankId(r2.a());
        r5.setRankText(r2.c());
        r5.setRankSchema(r2.b());
        r5.setTrackId(r2.d());
        goto L14
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
    L14:
        WindowAuthorReputationVO.a r6 = WindowAuthorReputationVO.Companion;
        AuthorReputationDTO r7 = r10.o();
        r6.getClass();
        WindowAuthorReputationVO.a.a(r7);
        s0 r8 = r10.m();
        ArrayList r11 = null;
        if (r8 == null) goto L17;
        int r12 = q.c;
        Intrinsics.checkNotNullParameter(r8, "dto");
        q r13 = new q();
        r13.a = r8.b();
        r13.b = r8.a();
    L18:
        r1.l = r13;
        x r14 = r10.d();
        if (r14 == null) goto L21;
        int r15 = k.b;
        k r16 = k.a.a(r14);
    L22:
        r1.m = r16;
        r1.t = r10.f();
        r1.v = r10.g();
        List<x0> r17 = r10.i();
        if (r17 == null) goto L28;
        List<x0> r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L26:
        if (r20.hasNext() == false) goto L29;
        x0 r21 = (x0) r20.next();
        int r22 = r.d;
        Intrinsics.checkNotNullParameter(r21, "dto");
        r r23 = new r();
        r23.a = r21.a();
        r23.b = r21.c();
        r23.c = r21.b();
        r19.add(r23);
    L29:
        r1.o = r19;
        List<m> r24 = r10.l();
        if (r24 == null) goto L37;
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r24.iterator();
    L33:
        if (r26.hasNext() == false) goto L38;
        m r27 = (m) r26.next();
        int r28 = uq3.d.d;
        uq3.d r29 = uq3.d.a.a(r27);
        if (r29 == null) goto L33;
        r25.add(r29);
    L38:
        r1.p = r25;
        List<m> r30 = r10.k();
        if (r30 == null) goto L46;
        ArrayList r31 = new ArrayList();
        Iterator<T> r32 = r30.iterator();
    L42:
        if (r32.hasNext() == false) goto L47;
        m r33 = (m) r32.next();
        int r34 = uq3.d.d;
        uq3.d r35 = uq3.d.a.a(r33);
        if (r35 == null) goto L42;
        r31.add(r35);
    L47:
        r1.q = r31;
        List<m> r36 = r10.j();
        if (r36 == null) goto L55;
        r11 = new ArrayList();
        Iterator<T> r37 = r36.iterator();
    L51:
        if (r37.hasNext() == false) goto L55;
        m r38 = (m) r37.next();
        int r39 = uq3.d.d;
        uq3.d r40 = uq3.d.a.a(r38);
        if (r40 == null) goto L51;
        r11.add(r40);
    L55:
        r1.r = r11;
        r1.n = r10.h();
        r1.w = r10.c();
        r1.u = r10.e();
        r1.s = r10.a();
        return r1;
    L46:
        r31 = null;
        goto L47
    L37:
        r25 = null;
        goto L38
    L28:
        r19 = null;
        goto L29
    L21:
        r16 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m912invoke(Object r1) {
        return invoke(r1);
    }
}
