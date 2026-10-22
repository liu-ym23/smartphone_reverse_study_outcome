package com.bytedance.android.shopping.card_list.widgets.nest;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListTwoRevViewAction implements q {
    public final Function1<Integer, Unit> a;
    public final Function0<String> b;
    public final Function0<String> c;
    public final Function1<Integer, Unit> d;
    public final Function2<Float, Float, Unit> e;
    public final com.bytedance.android.shopping.card_list.widgets.a f;

    public /* synthetic */ CardListTwoRevViewAction(com.bytedance.android.shopping.card_list.widgets.a r8) {
        this(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE, AnonymousClass5.INSTANCE, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListTwoRevViewAction(Function1<? super Integer, Unit> r2, Function0<String> r3, Function0<String> r4, Function1<? super Integer, Unit> r5, Function2<? super Float, ? super Float, Unit> r6, com.bytedance.android.shopping.card_list.widgets.a r7) {
        Intrinsics.checkNotNullParameter(r2, "onNestedPreScroll");
        Intrinsics.checkNotNullParameter(r3, "getSessionId");
        Intrinsics.checkNotNullParameter(r4, "getMonitorId");
        Intrinsics.checkNotNullParameter(r5, "backToTop");
        Intrinsics.checkNotNullParameter(r6, "onScroll");
        Intrinsics.checkNotNullParameter(r7, "gulAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
