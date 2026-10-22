package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.TopCategoryView;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.skin.f;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryListAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    public List<PromotionCategory> a;
    public Function2<? super PromotionCategory, ? super Integer, Unit> b;
    public int c;
    public CategoryViewHolder d;
    public int e;
    public final Set<String> f;
    public final Context g;
    public final il.a h;
    public final String i;
    public final f j;
    public final gi2.a k;

    public static final class a {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final PromotionCategory z2() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((PromotionCategory) r1).getSelected() == false) goto L4;
    L10:
        return (PromotionCategory) r1;
    L8:
        r1 = null;
        goto L10
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        final CategoryViewHolder r6 = (CategoryViewHolder) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        super.onViewAttachedToWindow(r6);
        this.h.c("livesdk_list_tab_show", ((PromotionCategory) ListProtector.get(this.a, r6.getAdapterPosition())).getUniqueIndex(), new AnonymousClass1(this, r6));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, final int r8) {
        final CategoryViewHolder r0 = (CategoryViewHolder) r7;
        Intrinsics.checkNotNullParameter(r0, "holder");
        final int r9 = r0.getAdapterPosition();     // Catch: Exception -> L23
        if (((PromotionCategory) ListProtector.get(this.a, r9)).getSelected() == false) goto L6;
        this.d = r0;     // Catch: Exception -> L23
        this.c = r9;     // Catch: Exception -> L23
    L6:
        boolean r1 = false;
        if (r9 == 0) goto L9;
    L11:
        PromotionCategory r2 = (PromotionCategory) CollectionsKt.getOrNull(this.a, r9);     // Catch: Exception -> L23
        if (r2 != null) goto L14;
    L21:
        r0.T3((PromotionCategory) ListProtector.get(this.a, r9), this.e, this.i, this.j, new AnonymousClass3(this, r9, r0, r8));     // Catch: Exception -> L23
        return;
    L14:
        if (r2.getEnhanceType() <= 0) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L21;
        this.f.add(r2.getUniqueIndex());     // Catch: Exception -> L23
        goto L21
    L9:
        if (this.d != null) goto L11;
        this.d = r0;     // Catch: Exception -> L23
        this.c = 0;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new CategoryViewHolder(new TopCategoryView(this.g, null, 6, 0));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List r5) {
        CategoryViewHolder r6 = (CategoryViewHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        Object r0 = CollectionsKt.firstOrNull(r5);
        if (r0 != null) goto L5;
    L10:
        super.onBindViewHolder(r6, r4, r5);
        Unit r7 = Unit.INSTANCE;
        return;
    L5:
        if ((r0 instanceof a) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        int r8 = ((a) r0).a;
        r6.a.d(r8);
    }

    public static final void y2(CategoryListAdapter r6, boolean r7, List r8, int r9, Boolean r10) {
        r6.getClass();
        oh.a.c("ECLiveListTabShowClickEvent", new com.bytedance.android.livesdk.livecommerce.iron.category.a(r6, r7, (PromotionCategory) ListProtector.get(r8, r9), r8, r10));
    }

    public CategoryListAdapter(Context r2, il.a r3, int r4, String r5, f r6, gi2.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eventMap");
        this.g = r2;
        this.h = r3;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.a = new ArrayList();
        this.e = r4;
        this.f = new LinkedHashSet();
    }
}
