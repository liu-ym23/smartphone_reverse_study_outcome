package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.f0;
import com.bytedance.android.window.shop.repository.dto.n;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$4 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$4(h r8) {
        super(1, r8, h.class, "bubble2Vo", "bubble2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ((h) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        int r0 = oq3.b.k;
        f0 r6 = (f0) r5;
        Intrinsics.checkNotNullParameter(r6, "dto");
        oq3.b r1 = new oq3.b();
        List<n> r7 = r6.a();
        if (r7 == null) goto L8;
        List<n> r8 = r7;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L9;
        n r3 = (n) r9.next();
        int r4 = uq3.e.h;
        r2.add(uq3.e.a.a(r3));
    L9:
        r1.j = r2;
        return r1;
    L8:
        r2 = null;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m915invoke(Object r1) {
        return invoke(r1);
    }
}
