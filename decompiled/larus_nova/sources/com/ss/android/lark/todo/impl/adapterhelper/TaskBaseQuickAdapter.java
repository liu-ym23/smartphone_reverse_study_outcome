package com.ss.android.lark.todo.impl.adapterhelper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;
import com.ss.android.lark.todo.impl.adapterhelper.viewholder.TaskBaseViewHolder;
import com.ss.android.lark.todo.impl.adapterhelper.viewholder.TaskListUpdateCallback;
import j7c.b;
import j7c.c;
import j7c.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020 H\u0016J\u0018\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020 H\u0016J&\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020 2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0010\u00105\u001a\u00020 2\u0006\u00101\u001a\u00020 H\u0016J\b\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020\rH\u0002J,\u00108\u001a\u00020*2\u000e\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00142\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\rH\u0007J\b\u0010=\u001a\u00020\rH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006?"}, d2 = {"Lcom/ss/android/lark/todo/impl/adapterhelper/TaskBaseQuickAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/adapterhelper/viewholder/TaskBaseViewHolder;", "differCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemProvider", "Lcom/ss/android/lark/todo/impl/adapterhelper/itembinding/TaskBaseItemProvider;", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/ss/android/lark/todo/impl/adapterhelper/itembinding/TaskBaseItemProvider;)V", "getItemProvider", "()Lcom/ss/android/lark/todo/impl/adapterhelper/itembinding/TaskBaseItemProvider;", "isUseEmpty", "", "()Z", "setUseEmpty", "(Z)V", "isUseLoadingMore", "setUseLoadingMore", "mData", "", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mLoadMoreModule", "Lcom/ss/android/lark/todo/impl/adapterhelper/loadmodule/PageLoadMoreModule;", "getMLoadMoreModule", "()Lcom/ss/android/lark/todo/impl/adapterhelper/loadmodule/PageLoadMoreModule;", "loadMoreViewPosition", "", "getLoadMoreViewPosition", "()I", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onAttachedToRecyclerView", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "getItemViewType", "getItemCount", "isEmptyView", "updateData", "list", "loadMoreStatus", "Lcom/ss/android/lark/todo/impl/adapterhelper/loadmodule/PageLoadingStatus;", "useDiffer", "hasLoadingMoreView", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskBaseQuickAdapter extends RecyclerView.Adapter<TaskBaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i7c.a f441363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f441364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f441365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends MultiItemEntity> f441366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f441367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f441368f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = 0;
        if (this.f441364b == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return 1;
    L10:
        int r102 = this.f441366d.size();
        if (this.f441364b == true) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L21;
        if (this.f441365c == false) goto L21;
        r100 = 1;
    L21:
        return r102 + r100;
    L13:
        if (this.f441366d.isEmpty() == false) goto L15;
        r103 = true;
        goto L16
    L5:
        if (this.f441366d.isEmpty() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        if (this.f441364b == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return 0;
    L11:
        if (r100 < this.f441366d.size()) goto L14;
        return 1;
    L14:
        return ((MultiItemEntity) ListProtector.get(this.f441366d, r100)).getItemType();
    L5:
        if (this.f441366d.isEmpty() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f441368f = r100;
    }

    public TaskBaseQuickAdapter(DiffUtil.ItemCallback<? extends MultiItemEntity> r100, i7c.a r101) {
        Intrinsics.checkNotNullParameter(r100, "differCallback");
        Intrinsics.checkNotNullParameter(r101, "itemProvider");
        this.f441363a = r101;
        this.f441366d = CollectionsKt.emptyList();
        new AsyncListDiffer(new TaskListUpdateCallback(this), new AsyncDifferConfig.Builder(r100).build());
        this.f441367e = new b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((TaskBaseViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        i7c.a r102 = this.f441363a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L7;
        if (r101 == 1) goto L6;
        TaskBaseViewHolder r103 = r102.f(r100, r101);
    L8:
        if (r101 != 1) goto L10;
        b r104 = this.f441367e;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewHolder");
        r103.itemView.setOnClickListener(new d(r104));
    L10:
        return r103;
    L6:
        i7c.a.C6237a r105 = r102.f488525a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r106 = LayoutInflater.from(r100.getContext());
        r105.f488526a.getClass();
        r103 = new TaskBaseViewHolder(r106.inflate(R.layout.task_default_loading_more_view, r100, false));
        goto L8
    L7:
        int r107 = r102.b(r101);
        r103 = new TaskBaseViewHolder(LayoutInflater.from(r100.getContext()).inflate(r107, r100, false));
        goto L8
    }

    public final void y2(TaskBaseViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r102 = false;
        if (this.f441364b == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
    L12:
        if (r102 == true) goto L14;
    L34:
        int r104 = r100.getItemViewType();
        if (r104 == 0) goto L39;
        if (r104 == 1) goto L38;
        this.f441363a.c(r100, (MultiItemEntity) ListProtector.get(this.f441366d, r101));
        return;
    L38:
        this.f441363a.e(r100, this.f441367e.f497661e);
        return;
    L39:
        this.f441363a.d(r100);
        return;
    L14:
        if (this.f441367e.f497659c == false) goto L16;
    L17:
        b r105 = this.f441367e;
        PageLoadingStatus r106 = r105.f497661e;
        if (r106 == PageLoadingStatus.END) goto L34;
        PageLoadingStatus r107 = PageLoadingStatus.LOADING_NEXT;
        if (r106 == r107) goto L34;
        if (r106 == PageLoadingStatus.LOADING_NEXT_FAIL) goto L34;
        if (r101 < (r105.f497657a.getItemCount() - r105.f497660d)) goto L34;
        r105.f497661e = r107;
        RecyclerView r108 = r105.f497657a.f441368f;
        if (r108 == null) goto L31;
        r108.post(new c(r105));
        goto L34
    L31:
        j7c.a r109 = r105.f497658b;
        if (r109 == null) goto L34;
        r109.onLoadMore();
        goto L34
    L16:
        if (r100.getItemViewType() != 1) goto L34;
    L10:
        if (this.f441365c == false) goto L12;
        r102 = true;
        goto L12
    L5:
        if (this.f441366d.isEmpty() == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        TaskBaseViewHolder r103 = (TaskBaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        y2(r103, r101);
        return;
    L5:
        int r104 = r103.getItemViewType();
        if (r104 != 0) goto L8;
        y2(r103, r101);
        return;
    L8:
        if (r104 == 1) goto L10;
        r103.U3((MultiItemEntity) ListProtector.get(this.f441366d, r101), r102);
        return;
    L10:
        y2(r103, r101);
    }

    public static void z2(TaskBaseQuickAdapter r100, List r101, PageLoadingStatus r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = PageLoadingStatus.END;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r102, "loadMoreStatus");
        Log.i("TaskBaseQuickAdapter", "submit list, from " + r100.f441366d.size() + " to " + r101.size() + ", loadStatus=" + r102.name());
        r100.f441366d = r101;
        b r104 = r100.f441367e;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r104.f497661e = r102;
        r100.notifyDataSetChanged();
    }
}
