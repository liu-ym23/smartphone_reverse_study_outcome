package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.NoneSymmetryDecoration;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowEveryoneTalkCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowEveryoneTalkCard extends ConstraintLayout {
    public ECDraweeView a;
    public RecyclerView b;
    public View c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.a = (ECDraweeView) findViewById(2131393285);
        this.c = findViewById(2131393283);
        this.b = findViewById(2131393284);
    }

    public WindowEveryoneTalkCard(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(List<uq3.p> r10, final Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "impressionWords");
        RecyclerView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L5:
        r0.setAdapter(new WindowAutoScrollViewAdapter());
        RecyclerView r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L8:
        r1.setLayoutManager(new ECWindowInfoLinearManager());
        RecyclerView r2 = this.b;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L11:
        r2.addItemDecoration(new NoneSymmetryDecoration(getContext(), 0.0f, com.bytedance.android.shopping.extensions.b.b(4), 0.0f, WindowEveryoneTalkCard$initRecycleView$1.INSTANCE));
        RecyclerView r3 = this.b;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L14:
        RecyclerView.Adapter r4 = r3.getAdapter();
        if (r4 == null) goto L28;
        WindowAutoScrollViewAdapter r5 = (WindowAutoScrollViewAdapter) r4;
        Function1<String, Unit> r6 = new WindowEveryoneTalkCard$initRecycleView$2(r11);
        Intrinsics.checkNotNullParameter(r10, "list");
        r5.b = r6;
        ((ArrayList) r5.a).clear();
        r5.notifyDataSetChanged();
        ((ArrayList) r5.a).addAll(r10);
        r5.notifyItemRangeInserted(0, r10.size());
        RecyclerView r7 = this.b;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L19:
        r7.post(new u(this, r10));
        View r12 = this.c;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("entrance");
    L22:
        r12.setOnClickListener(new s(r11));
        GenericDraweeView r13 = this.a;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L25:
        r13.setOnClickListener(new t(r11));
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter");
    }
}
