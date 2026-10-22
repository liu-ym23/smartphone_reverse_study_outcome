package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u00022\u00020\u0004:\u0003\"#$B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016J,\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\bH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionAdapter;", "M", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionAdapter$OptionViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemTouchHelperCallback$OnItemTouchCallbackListener;", "<init>", "()V", "mOldItemCount", "", "mNewItemCount", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onBindViewHolder", "holder", "position", "payloads", "", "", "getItemList", "getItemCount", "onSelectedChanged", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isSelected", "", "onMove", "fromPos", "toPos", "onItemCountsChanged", "oldItemCount", "newItemCount", "OptionViewHolder", "AnyChangedObserver", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OptionAdapter<M> extends RecyclerView.Adapter<OptionViewHolder<M>> implements OptionItemTouchHelperCallback.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f211729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f211730b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionAdapter$OptionViewHolder;", "M", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemView;)V", "onBindView", "", "optionBean", "(Ljava/lang/Object;)V", "onDeleteBtnClicked", "position", "", "onStateChanged", "selected", "", "setDividerVisible", "visible", "setDeletable", "deletable", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class OptionViewHolder<M> extends RecyclerView.ViewHolder {
        public abstract void T3(M r100);

        public abstract void U3(int r100);

        public OptionViewHolder(OptionItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            r100.setDeleteMenuClickEvent(new AnonymousClass1(this));
        }
    }

    public static class a extends RecyclerView.AdapterDataObserver {
        public void b() {
        }

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            b();
        }
    }

    public static final class b {
    }

    static {
    }

    public abstract List<M> y2();

    public OptionAdapter() {
        this.f211729a = -1;
        this.f211730b = -1;
        registerAdapterDataObserver(new AnonymousClass1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<M> r100 = y2();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        r100.addOnScrollListener(new C105071());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        r100.clearOnScrollListeners();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionItemTouchHelperCallback.a
    public final void V(RecyclerView.ViewHolder r100, boolean r101) {
        if ((r100 instanceof OptionViewHolder) == false) goto L6;
        ((OptionViewHolder) r100).itemView.setSelected(r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        OptionViewHolder r102 = (OptionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<M> r103 = y2();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101 >= r103.size()) goto L20;
        r102.T3(ListProtector.get(r103, r101));
        boolean r104 = true;
        if (r101 < (getItemCount() - 1)) goto L11;
        r104 = false;
    L11:
        View r105 = r102.itemView;
        if ((r105 instanceof OptionItemView) == false) goto L14;
        OptionItemView r106 = (OptionItemView) r105;
    L15:
        if (r106 == null) goto L19;
        r106.setDividerVisible(r104);
        return;
    L19:
        return;
    L14:
        r106 = null;
        goto L15
    }

    public void onMove(int r100, int r101) {
        List<M> r102 = y2();
        if (r102 == null) goto L11;
        if (r100 != r101) goto L6;
        return;
    L6:
        if (r100 < r102.size()) goto L8;
        return;
    L8:
        if (r101 >= r102.size()) goto L14;
        Collections.swap(r102, r100, r101);
        notifyItemMoved(r100, r101);
        notifyItemChanged(r100, 1);
        notifyItemChanged(r101, 1);
        return;
    L14:
        return;
    }

    public void z2(int r100, int r101) {
        notifyItemRangeChanged(0, getItemCount(), 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        OptionViewHolder r103 = (OptionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r104 = true;
        if (r102.contains(1) == true) goto L5;
        super.onBindViewHolder(r103, r101, r102);
        return;
    L5:
        if (r101 < (getItemCount() - 1)) goto L8;
        r104 = false;
    L8:
        View r105 = r103.itemView;
        if ((r105 instanceof OptionItemView) == false) goto L11;
        OptionItemView r106 = (OptionItemView) r105;
    L12:
        if (r106 == null) goto L16;
        r106.setDividerVisible(r104);
        return;
    L16:
        return;
    L11:
        r106 = null;
        goto L12
    }
}
