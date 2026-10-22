package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.e;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import eu5.h;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u001a\u0010#\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0016J\u0018\u0010&\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020 H\u0016J\u0018\u0010(\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "context", "Landroid/content/Context;", "catalogItemAdapter", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;", JSEventListener.ACTION, "", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getCatalogItemAdapter", "()Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;", "getAction", "()Ljava/lang/String;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "startIndex", "", "Ljava/lang/Integer;", "lastIndex", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", "fromViewHolder", "toViewHolder", "onSelectedChanged", "", "actionState", "clearView", "isLongPressDragEnabled", "onSwiped", "direction", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogItemTouchCallback extends ItemTouchHelper.Callback {
    public final Context a;
    public final CatalogItemAdapter b;
    public final String c;
    public gv4.a d;
    public Integer e;
    public Integer f;

    public static final class a {
    }

    static {
    }

    public final boolean isLongPressDragEnabled() {
        return true;
    }

    public final void onSwiped(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "viewHolder");
    }

    public final Context getContext() {
        return this.a;
    }

    public final void clearView(RecyclerView r5, RecyclerView.ViewHolder r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        super.clearView(r5, r6);
        tt5.a.h("CatalogItemTouchCallback", "clearView end: " + r6.getAbsoluteAdapterPosition());
        this.f = Integer.valueOf(r6.getAbsoluteAdapterPosition());
        View r7 = r6.itemView;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemView");
        ((CatalogItemView) r7).setActivated(false);
        Integer r8 = this.e;
        if (r8 == null) goto L22;
        int r9 = r8.intValue();
        CatalogItemModel r0 = (CatalogItemModel) this.b.getItem(r6.getAbsoluteAdapterPosition());
        Integer r1 = this.e;
        if (r1 != null) goto L8;
    L9:
        Integer r2 = this.f;
        if (r2 != null) goto L13;
    L14:
        gv4.a r3 = this.d;
        if (r3 != null) goto L17;
        return;
    L17:
        if (r0 == null) goto L19;
        String r4 = r0.getId();
    L20:
        r3.a(new SortAction(r4, this.c, r9, r6.getAbsoluteAdapterPosition()));
        return;
    L19:
        r4 = null;
        goto L20
    L13:
        if (r2.intValue() != (-1)) goto L14;
        return;
    L8:
        if (r1.intValue() != (-1)) goto L9;
        return;
    }

    public final int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public final void onSelectedChanged(RecyclerView.ViewHolder r4, int r5) {
        super.onSelectedChanged(r4, r5);
        Context r0 = this.a;
        int r1 = e.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        h.a(r0, 10, 50);
        if (r5 != 2) goto L17;
        StringBuilder r6 = new StringBuilder("onSelectedChanged start: ");
        View r2 = null;
        if (r4 == null) goto L7;
        Integer r3 = Integer.valueOf(r4.getAbsoluteAdapterPosition());
    L8:
        r6.append(r3);
        tt5.a.h("CatalogItemTouchCallback", r6.toString());
        if (r4 == null) goto L11;
        Integer r7 = Integer.valueOf(r4.getAbsoluteAdapterPosition());
    L12:
        this.e = r7;
        if (r4 == null) goto L15;
        r2 = r4.itemView;
    L15:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemView");
        ((CatalogItemView) r2).setActivated(true);
        return;
    L11:
        r7 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public CatalogItemTouchCallback(Context r2, CatalogItemAdapter r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "catalogItemAdapter");
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = -1;
        this.f = -1;
    }

    public final boolean onMove(RecyclerView r5, RecyclerView.ViewHolder r6, RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r6, "fromViewHolder");
        Intrinsics.checkNotNullParameter(r7, "toViewHolder");
        Context r8 = this.a;
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        h.a(r8, 10, 50);
        int r9 = r6.getAbsoluteAdapterPosition();
        int r10 = r7.getAbsoluteAdapterPosition();
        tt5.a.h("CatalogItemTouchCallback", "onMove " + r9 + ' ' + r10);
        CatalogItemAdapter r11 = this.b;
        List r1 = r11.getData();
        if (r9 >= r10) goto L7;
        int r2 = r9;
    L5:
        if (r2 >= r10) goto L13;
        int r3 = r2 + 1;
        Collections.swap(r1, r2, r3);
        r2 = r3;
    L13:
        r11.notifyItemMoved(r9, r10);
        return true;
    L7:
        int r4 = r10 + 1;
        if (r4 > r9) goto L13;
        int r12 = r9;
    L10:
        int r13 = r12 - 1;
        Collections.swap(r1, r12, r13);
        if (r12 == r4) goto L13;
        r12 = r13;
        goto L10
    }
}
