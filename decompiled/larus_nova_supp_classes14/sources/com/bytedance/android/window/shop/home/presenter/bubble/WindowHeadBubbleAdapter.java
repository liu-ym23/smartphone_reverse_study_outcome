package com.bytedance.android.window.shop.home.presenter.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import uq3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/bubble/WindowHeadBubbleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/home/presenter/bubble/WindowBubbleHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleAdapter extends RecyclerView.Adapter<WindowBubbleHolder> {
    public final List<e> a;
    public Function1<? super String, Unit> b;
    public Function2<? super String, ? super String, Unit> c;
    public Function4<? super View, ? super e, ? super Integer, ? super Function0<Unit>, Unit> d;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public WindowHeadBubbleAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        WindowBubbleHolder r10 = (WindowBubbleHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        if (((ArrayList) this.a).size() == 0) goto L13;
        e r2 = (e) ListProtector.get(this.a, r9);
        Function1<? super String, Unit> r3 = this.b;
        Function2<? super String, ? super String, Unit> r4 = this.c;
        Function4<? super View, ? super e, ? super Integer, ? super Function0<Unit>, Unit> r5 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "vo");
        if (r9 == 0) goto L10;
        if (r9 == 1) goto L9;
        int r6 = 3;
    L11:
        r10.a.R5(r2, r3, r4, r5, r6);
        return;
    L9:
        r6 = 2;
        goto L11
    L10:
        r6 = 1;
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Object r5 = LayoutInflater.from(r3.getContext()).inflate(2131560994, r3, false);
        if (r5 == null) goto L7;
        return new WindowBubbleHolder((WindowHeadBubbleBaseCard) r5);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard");
    }
}
