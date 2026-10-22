package com.bytedance.android.shopping.orderlist.list.container;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.orderlist.common.eventcenter.core.OrderCommonEventCenter;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final Lazy a;
    public final OrderCommonEventCenter b;
    public final Activity c;
    public final OrderListFragment d;
    public final OrderListViewModel e;
    public final AndroidYaTaInstance f;
    public final OrderListLinkedScrollView g;

    public d(FragmentActivity r2, OrderListFragment r3, OrderListViewModel r4, AndroidYaTaInstance r5, OrderListLinkedScrollView r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "linkedScrollView");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = LazyKt.lazy(new OrderListEventCenter$scrollStrategyController$2(this));
        this.b = new OrderCommonEventCenter(r2, r3, r5, new OrderListEventCenter$baseEventCenter$1(this));
    }
}
