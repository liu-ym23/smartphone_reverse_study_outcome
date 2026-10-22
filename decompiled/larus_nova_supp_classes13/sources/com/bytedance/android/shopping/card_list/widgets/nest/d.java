package com.bytedance.android.shopping.card_list.widgets.nest;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.card_list.eventcenter.event.ScrollMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.shopping.card_list.components.c {
    public final LifecycleOwner b;
    public final com.bytedance.android.shopping.card_list.widgets.b c;
    public final MutableLiveData<Unit> d;
    public final MutableLiveData<Integer> e;
    public Function1<? super Integer, Boolean> f;
    public final MutableLiveData<Unit> g;
    public final MutableLiveData<Unit> h;
    public final MutableLiveData<Pair<Integer, ScrollMode>> i;
    public final MutableLiveData<Unit> j;
    public Function0<Boolean> k;
    public final MutableLiveData<Boolean> l;
    public final MutableLiveData<Integer> m;
    public Function0<Boolean> n;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.b;
    }

    public d(LifecycleOwner r14) {
        com.bytedance.android.shopping.card_list.widgets.b r0 = new com.bytedance.android.shopping.card_list.widgets.b(r14);
        MutableLiveData<Unit> r1 = new MutableLiveData();
        MutableLiveData<Integer> r2 = new MutableLiveData(0);
        CardListTwoRevViewState$1 r4 = CardListTwoRevViewState$1.INSTANCE;
        MutableLiveData<Unit> r5 = new MutableLiveData();
        MutableLiveData<Unit> r6 = new MutableLiveData();
        MutableLiveData<Pair<Integer, ScrollMode>> r7 = new MutableLiveData();
        MutableLiveData<Unit> r8 = new MutableLiveData();
        CardListTwoRevViewState$2 r9 = CardListTwoRevViewState$2.INSTANCE;
        MutableLiveData<Boolean> r10 = new MutableLiveData();
        MutableLiveData<Integer> r11 = new MutableLiveData(0);
        CardListTwoRevViewState$3 r3 = CardListTwoRevViewState$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "gulState");
        Intrinsics.checkNotNullParameter(r1, "jumpToTop");
        Intrinsics.checkNotNullParameter(r2, "outerHeight");
        Intrinsics.checkNotNullParameter(r4, "canScrollVerticallyAsMultiList");
        Intrinsics.checkNotNullParameter(r5, "jumpToCardRevList");
        Intrinsics.checkNotNullParameter(r6, "justify");
        Intrinsics.checkNotNullParameter(r7, "scrollToPosition");
        Intrinsics.checkNotNullParameter(r8, "scrollToCardListForLoadMoreEnd");
        Intrinsics.checkNotNullParameter(r9, "canScrollDown");
        Intrinsics.checkNotNullParameter(r10, "setViewAccessibility");
        Intrinsics.checkNotNullParameter(r11, "setLoadMoreFooterViewHeight");
        Intrinsics.checkNotNullParameter(r3, "isFirstRevAtTop");
        super(r14);
        this.b = r14;
        this.c = r0;
        this.d = r1;
        this.e = r2;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r3;
    }
}
