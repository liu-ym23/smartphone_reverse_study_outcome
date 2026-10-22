package com.ss.android.lark.todo.impl.features.common.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter$ViewHolder;", "sectionItems", "", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/SectionHeaderItem;", "listener", "Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter$ITaskListSectionSortItemListener;", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter$ITaskListSectionSortItemListener;)V", "getSectionItems", "()Ljava/util/List;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter$ITaskListSectionSortItemListener;", "sectionRankMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSectionRankMap", "()Ljava/util/HashMap;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "onMove", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PickerReporterConstants.KEY.TARGET, "Companion", "ITaskListSectionSortItemListener", "ViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListSectionSortAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SectionHeaderItem> f442418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f442419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f442420c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListSectionSortAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442421a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442421a = r100;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(ViewHolder r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442418a.size();
    }

    public TaskListSectionSortAdapter(List r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionItems");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f442418a = r100;
        this.f442419b = r101;
        this.f442420c = new HashMap();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        SectionHeaderItem r103 = (SectionHeaderItem) r102.next();
        this.f442420c.put(r103.f441435a, r103.f441437c);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = ((SectionHeaderItem) ListProtector.get(this.f442418a, r101)).f441436b;
        ((TextView) r102.f442421a.findViewById(R.id.section_name)).setText(r103);
        View r104 = r102.f442421a.findViewById(R.id.line_divider);
        boolean r105 = true;
        if (r101 < (this.f442418a.size() - 1)) goto L6;
        r105 = false;
    L6:
        com.larksuite.framework.section.utils.a.d(r104, r105);
        ((ImageView) r102.f442421a.findViewById(R.id.drag_icon)).setOnLongClickListener(new d(this, r102));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.task_list_section_sort_item, r100, false));
    }
}
