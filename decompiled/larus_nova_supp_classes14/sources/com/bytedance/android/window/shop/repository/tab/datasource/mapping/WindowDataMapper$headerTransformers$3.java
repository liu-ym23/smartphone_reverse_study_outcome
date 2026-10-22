package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.h0;
import com.bytedance.android.window.shop.repository.dto.r0;
import com.bytedance.android.window.shop.repository.dto.x;
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
import uq3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$3 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$3(h r8) {
        super(1, r8, h.class, "everyoneTalkDto2Vo", "everyoneTalkDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((h) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        int r0 = oq3.c.l;
        h0 r10 = (h0) r9;
        Intrinsics.checkNotNullParameter(r10, "dto");
        oq3.c r1 = new oq3.c();
        List<r0> r2 = r10.b();
        k r3 = null;
        if (r2 == null) goto L8;
        List<r0> r4 = r2;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        r0 r7 = (r0) r6.next();
        int r8 = p.c;
        Intrinsics.checkNotNullParameter(r7, "dto");
        p r11 = new p();
        r11.a = r7.b();
        r11.b = r7.a();
        r5.add(r11);
    L9:
        r1.j = r5;
        x r12 = r10.a();
        if (r12 == null) goto L12;
        int r13 = k.b;
        r3 = k.a.a(r12);
    L12:
        r1.k = r3;
        return r1;
    L8:
        r5 = null;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m914invoke(Object r1) {
        return invoke(r1);
    }
}
