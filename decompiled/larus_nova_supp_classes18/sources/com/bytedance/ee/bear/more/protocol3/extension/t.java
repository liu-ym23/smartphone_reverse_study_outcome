package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {

    public static final class a extends MoreGroupItem {
        @Override // com.bytedance.ee.bear.more.protocol3.g
        public final com.bytedance.ee.bear.more.protocol3.k a() {
            com.bytedance.ee.bear.more.protocol3.i r0 = b().a();
            return com.bytedance.ee.bear.more.protocol3.g.i(this, new com.bytedance.ee.bear.more.protocol3.f.i("grid_group", 0, null, 30), new com.bytedance.ee.bear.more.protocol3.e.a(r0), CollectionsKt.listOf(new BizChecker(!r0.a.isEmpty())), null, null, 24);
        }

        public a() {
        }
    }

    public static final class b extends MoreGroupItem {
        @Override // com.bytedance.ee.bear.more.protocol3.g
        public final com.bytedance.ee.bear.more.protocol3.k a() {
            com.bytedance.ee.bear.more.protocol3.i r0 = b().a();
            return com.bytedance.ee.bear.more.protocol3.g.i(this, new com.bytedance.ee.bear.more.protocol3.f.i("linear_group", 0, null, 30), new com.bytedance.ee.bear.more.protocol3.e.d(r0, this.c), CollectionsKt.listOf(new BizChecker(!r0.a.isEmpty())), null, null, 24);
        }

        public b() {
        }
    }

    public static final void a(MoreItems r1, Function1<? super MoreGroupItem, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "initializer");
        a r0 = new a();
        r2.invoke(r0);
        r1.add(r0);
    }

    public static final void b(MoreItems r1, Function1<? super MoreGroupItem, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "initializer");
        b r0 = new b();
        r2.invoke(r0);
        r1.add(r0);
    }

    public static final com.bytedance.ee.bear.more.protocol3.c c(com.bytedance.ee.bear.more.protocol3.h r1, Function1<? super MoreItems, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "initializer");
        MoreItems r0 = new MoreItems();
        com.bytedance.ee.bear.more.protocol3.l r3 = r1.b;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiItemFactory");
        r3 = null;
    L6:
        r0.add(r3.buildHeader());
        r2.invoke(r0);
        return new com.bytedance.ee.bear.more.protocol3.c(r0);
    }
}
