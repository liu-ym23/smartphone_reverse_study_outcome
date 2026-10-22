package com.bytedance.android.window.shop.innerflow.holder.element.commentlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wp3.b;
import zp3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/commentlist/CommentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/innerflow/holder/element/commentlist/CommentListItemHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListAdapter extends RecyclerView.Adapter<CommentListItemHolder> {
    public List<b.C0182b> a;

    public final int getItemCount() {
        if (this.a.size() <= 1) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return this.a.size();
    }

    public CommentListAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        CommentListItemHolder r8 = (CommentListItemHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        List<b.C0182b> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L30;
        List<b.C0182b> r2 = this.a;
        b.C0182b r3 = (b.C0182b) ListProtector.get(r2, r7 % r2.size());
        SimpleDraweeView r4 = r8.a;
        if (r3 == null) goto L14;
        String r5 = r3.a;
    L15:
        r4.setImageURI(r5);
        if (r8.b.getWidth() <= 0) goto L18;
        r8.T3(r3);
    L19:
        List<b.C0182b> r9 = this.a;
        b.C0182b r10 = (b.C0182b) ListProtector.get(r9, (r7 + 1) % r9.size());
        if (r10 == null) goto L27;
        String r11 = r10.a;
        if (r11 == null) goto L28;
        ImageRequest r12 = ImageRequest.fromUri(r11);
        if (Fresco.getImagePipeline().isInBitmapMemoryCache(r12) == true) goto L29;
        Fresco.getImagePipeline().prefetchToBitmapCache(r12, null);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L18:
        r8.b.post(new a(r8, r3));
        goto L19
    L14:
        r5 = null;
        goto L15
    L30:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ShoppingAsyncInflater.a r5 = ShoppingAsyncInflater.e;
        Context r6 = th.a.e(r3.getContext(), true);
        r5.getClass();
        View r7 = c.a(ShoppingAsyncInflater.a.a(r6), 2131560884, null, 4);
        r7.setLayoutParams(new RecyclerView.LayoutParams(-1, r7.getContext().getResources().getDimensionPixelSize(2131166419)));
        return new CommentListItemHolder(r7);
    }
}
