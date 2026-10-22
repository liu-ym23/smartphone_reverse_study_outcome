package com.larus.bmhome.social.page.datasource.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.larus.bmhome.social.page.datasource.event.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003*\b\b\u0002\u0010\u0004*\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00040\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0001H\u0086@¢\u0006\u0002\u0010 J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\"\u001a\u00020#2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH$J%\u0010$\u001a\u00020\u001e2\u001d\u0010%\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0004\u0012\u00020\u001e0&¢\u0006\u0002\b'J\u0017\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010)\u001a\u00020\bH\u0004¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\bJ\u0014\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.J\u0014\u0010/\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.J\u001d\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00028\u00022\u0006\u0010)\u001a\u00020\bH\u0017¢\u0006\u0002\u00102J+\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00028\u00022\u0006\u0010)\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0017¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u00108\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/social/page/datasource/adapter/PagingAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Event", "Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "prefetchDistance", "", "diff", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "<init>", "(ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;)V", "dataSource", "", "getDataSource", "()Ljava/util/List;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "differ", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "getDiffer", "()Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "differ$delegate", "Lkotlin/Lazy;", "prefetcher", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingPrefetch;", "collectEvent", "", "event", "(Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDiff", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "safeNotify", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getItem", "position", "(I)Ljava/lang/Object;", "getItemCount", "registerDataSourceObserver", "observer", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "unregisterDataSourceObserver", "onBindViewHolder", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PagingAdapter<T, Event extends a<T>, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        getItemCount();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        super.onBindViewHolder(r100, r101, r102);
    }
}
