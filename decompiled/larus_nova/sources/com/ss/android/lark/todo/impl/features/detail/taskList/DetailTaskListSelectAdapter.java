package com.ss.android.lark.todo.impl.features.detail.taskList;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l8c.b;
import l8c.c;
import l8c.g;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u001e\u0010\u001b\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/TaskListSelectItem;", "queryKey", "", "itemClickListener", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter$IDetailTaskListListener;", "getItemClickListener", "()Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter$IDetailTaskListListener;", "setItemClickListener", "(Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter$IDetailTaskListListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "updateData", "ViewHolder", "IDetailTaskListListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetailTaskListSelectAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<g> f443476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f443477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f443478c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskListSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443479a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443479a = r100;
        }
    }

    public interface a {
        void a(String r100);

        void b(String r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443476a.size();
    }

    public DetailTaskListSelectAdapter() {
        this.f443476a = CollectionsKt.emptyList();
        this.f443477b = "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        g r101 = (g) CollectionsKt.getOrNull(this.f443476a, r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (r101.f508094b != true) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        g r111 = (g) ListProtector.get(this.f443476a, r110);
        if (r111.f508094b == false) goto L5;
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        i r103 = i.f444291a;
        r102.append(r103.g(R.string.Todo_ManageTaskList_CreateList_Button));
        int r104 = r102.length();
        r102.append(" " + r111.f508093a.name);
        final int r105 = r103.a(R.color.text_title);
        r102.setSpan(new AnonymousClass2(r105), r104, r102.length(), 33);
        ((TextView) r101.f443479a.findViewById(R.id.create_text)).setText(r102);
        r101.f443479a.findViewById(R.id.create_container).setOnClickListener(new c(this, r111));
        View r106 = r101.f443479a.findViewById(R.id.divide_line);
        boolean r107 = true;
        if (this.f443476a.size() == 1) goto L19;
        r107 = false;
    L19:
        com.larksuite.framework.section.utils.a.d(r106, r107);
        return;
    L5:
        if (TextUtils.isEmpty(r111.f508093a.name) == false) goto L7;
        String r108 = i.f444291a.g(R.string.Todo_TaskList_UntitledList_Title);
    L8:
        SpannableString r109 = new SpannableString(r108);
        if (TextUtils.isEmpty(this.f443477b) == true) goto L14;
        int r112 = StringsKt.indexOf$default(r109, this.f443477b, 0, false, 4, null);
    L12:
        if (r112 == (-1)) goto L14;
        r109.setSpan(new ForegroundColorSpan(i.f444291a.a(R.color.primary_fill_default)), r112, this.f443477b.length() + r112, 33);
        String r113 = this.f443477b;
        r112 = StringsKt.indexOf$default(r109, r113, r113.length() + r112, false, 4, null);
    L14:
        ((TextView) r101.f443479a.findViewById(R.id.task_container_name)).setText(r109);
        r101.f443479a.findViewById(R.id.task_container_name).setOnClickListener(new b(this, r111));
        return;
    L7:
        r108 = StringsKt.trim(r111.f508093a.name).toString();
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L6;
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.detail_task_list_dialog_create_item, r100, false));
    L6:
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.detail_task_list_dialog_item, r100, false));
    }
}
