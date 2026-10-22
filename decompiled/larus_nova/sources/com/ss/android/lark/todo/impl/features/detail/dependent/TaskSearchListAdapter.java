package com.ss.android.lark.todo.impl.features.detail.dependent;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.todo.v1.Commit;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoItemPermission;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.common.entity.EndTimeTextAttribute;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.richtext.RichText;
import g7c.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004./01B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u0014H\u0016J\"\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$ViewHolder;", "<init>", "()V", "itemClickListener", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$ISearchTaskClickListener;", "getItemClickListener", "()Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$ISearchTaskClickListener;", "setItemClickListener", "(Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$ISearchTaskClickListener;)V", "timeFormatDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ITimeFormatDependency;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$SearchTodoItem;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "isPositionInvalid", "", "bindTitleText", "view", "Landroid/view/View;", IOfflineExtraParser.ParserType.TODO, "Lcom/bytedance/lark/pb/todo/v1/Todo;", "bindView", "bindCompleteCheckBox", "bindCheckbox", "bindBackground", "isSelect", "canCompleteByPermission", "targetTodo", "getItemCount", "updateData", "datas", "", "selectItemGuids", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "ViewHolder", "ISearchTaskClickListener", "Companion", "SearchTodoItem", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSearchListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TaskSearchListAdapter$Companion$DIFF_CALLBACK$1 f443058d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f443059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f443060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncListDiffer<c> f443061c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskSearchListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443062a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443062a = r100;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Todo f443063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f443064b;

        public c(Todo r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
            this.f443063a = r100;
            this.f443064b = r101;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.detail.dependent.TaskSearchListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f443058d = new TaskSearchListAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443061c.getCurrentList().size();
    }

    public TaskSearchListAdapter() {
        this.f443060b = TodoDependencyHolder.a().timeFormatDependency();
        this.f443061c = new AsyncListDiffer(this, f443058d);
    }

    public final boolean y2(Todo r100) {
        TodoItemPermission r101 = r100.self_permission;
        if (r101 == null) goto L15;
        Map<Integer, Boolean> r102 = r101.can_edit_commit_keys;
        if (r102 == null) goto L15;
        int r103 = MultiCompleteHelper.f442436a;
        if (MultiCompleteHelper.d(r100.source, r100.mode) == false) goto L18;
        if (MultiCompleteHelper.c(r102, Commit.Key.TODO_COMPLETED_MILLI_TIME) == false) goto L12;
    L13:
        return true;
    L12:
        if (MultiCompleteHelper.c(r102, Commit.Key.TODO_USERS_COMPLETED_MILLI_TIME) == false) goto L15;
    L18:
        return MultiCompleteHelper.c(r102, Commit.Key.TODO_COMPLETED_TIME);
    L15:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        ViewHolder r100 = (ViewHolder) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r211 != (-1)) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L96;
        c r102 = (c) ListProtector.get(this.f443061c.getCurrentList(), r211);
        ((LKUILightTextView) r100.f443062a.findViewById(R.id.title_rich_text)).setShouldLayoutZeroLengthText(true);
        View r103 = r100.f443062a;
        boolean r104 = r102.f443064b;
        ViewGroup.LayoutParams r105 = ((LinearLayout) r103.findViewById(R.id.content_container_view)).getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r110 = 8;
        ((LinearLayout.LayoutParams) r105).setMargins(0, 8, 0, 0);
        if (r104 == false) goto L14;
        ((LinearLayout) r103.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.task_search_select_round));
    L15:
        View r106 = r100.f443062a;
        ViewGroup.LayoutParams r107 = ((RelativeLayout) r106.findViewById(R.id.complete_checkbox_container)).getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
        r108.gravity = 48;
        ((RelativeLayout) r106.findViewById(R.id.complete_checkbox_container)).setLayoutParams(r108);
        View r109 = r100.f443062a;
        Todo r111 = r102.f443063a;
        r109.findViewById(R.id.content_container_view).setOnClickListener(new i(r111, this));
        View r112 = r109.findViewById(R.id.item_finish_line);
        if (r111.completed_milli_time.longValue() <= 0) goto L18;
        int r113 = 0;
    L19:
        r112.setVisibility(r113);
        int r114 = com.ss.android.lark.todo.impl.features.common.helper.b.f442448a;
        com.ss.android.lark.todo.impl.utils.i r115 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        EndTimeTextAttribute r116 = com.ss.android.lark.todo.impl.features.common.helper.b.c(LarkContext.getApplication(), r111.start_milli_time.longValue(), 1000 * r111.due_time.longValue(), r111.is_all_day.booleanValue(), this.f443060b.c(), false, 96);
        if (r116.getEndTimeStr().length() != 0) goto L22;
        boolean r117 = true;
    L24:
        if (r117 == false) goto L26;
        String r118 = "";
    L27:
        r116.setEndTimeStr(r118);
        if (r111.completed_milli_time.longValue() <= 0) goto L30;
        int r119 = r115.a(R.color.text_caption);
    L31:
        ((TextView) r109.findViewById(R.id.tv_end_time)).setText(r116.getEndTimeStr());
        ((TextView) r109.findViewById(R.id.tv_end_time)).setTextColor(r119);
        LinearLayout r120 = (LinearLayout) r109.findViewById(R.id.ll_end_time);
        if (TextUtils.isEmpty(r116.getEndTimeStr()) == true) goto L34;
        r110 = 0;
    L34:
        r120.setVisibility(r110);
        List<TodoAssignee> r121 = r111.assignees;
        if (r121 == null) goto L52;
        ((TaskUDAvatarList) r109.findViewById(R.id.task_owners)).setVisibility(0);
        TaskUDAvatarList r122 = (TaskUDAvatarList) r109.findViewById(R.id.task_owners);
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r121.iterator();
    L38:
        if (r124.hasNext() == false) goto L51;
        TodoAssignee r125 = (TodoAssignee) r124.next();
        String r126 = r125.assignee_id;
        TodoAssignee.User r127 = r125.user;
        TodoUser r128 = r127.user;
        if (r128 == null) goto L43;
        String r129 = r128.avatar_key;
        if (r129 == null) goto L43;
    L45:
        if (r127.completed_milli_time.longValue() <= 0) goto L49;
        int r130 = MultiCompleteHelper.f442436a;
        if (MultiCompleteHelper.e(r111.source, r111.mode) == false) goto L49;
        boolean r131 = true;
    L50:
        r123.add(new com.ss.android.lark.todo.impl.features.detail.sections.c(r126, r129, r131, 0));
    L49:
        r131 = false;
    L43:
        r129 = "";
        goto L45
    L51:
        r122.setAdapter(new j(r123));
    L52:
        View r132 = r100.f443062a;
        Todo r133 = r102.f443063a;
        Boolean r134 = r133.is_milestone;
        ImageView r135 = (ImageView) r132.findViewById(R.id.complete_checkbox);
        if (r133.completed_milli_time.longValue() <= 0) goto L67;
        if (y2(r133) == false) goto L61;
        ((RelativeLayout) r132.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        com.ss.android.lark.todo.impl.utils.i r136 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r134.booleanValue() == false) goto L59;
        int r137 = R.drawable.todo_svg_icon_milestone_checked_new;
    L60:
        Drawable r138 = r136.c(r137);
    L78:
        r135.setImageDrawable(r138);
        ((ImageView) r132.findViewById(R.id.complete_checkbox)).setScaleType(ImageView.ScaleType.CENTER);
        View r139 = r100.f443062a;
        Todo r140 = r102.f443063a;
        TodoItemPermission r141 = r140.self_permission;
        if (r141 == null) goto L81;
        boolean r142 = Intrinsics.areEqual(r141.is_readable, Boolean.FALSE);
    L82:
        if (r142 == false) goto L84;
        RichText r143 = com.ss.android.lark.widget.richtext.c.c(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Tasks_BlockingTasksNoPermissionView_Text));
    L87:
        com.ss.android.lark.todo.impl.utils.i r144 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r140.completed_milli_time.longValue() <= 0) goto L90;
        int r145 = R.color.text_caption;
    L91:
        int r146 = r144.a(r145);
        int r147 = (int) UIHelper.sp2px(16.0f);
        int r148 = (int) UIHelper.sp2px(20.0f);
        iec.g.a r149 = new iec.g.a();
        r149.f489531d.f489512a = false;
        iec.a r150 = r149.f489532e;
        r150.f489508a = true;
        r150.f489511d = r146;
        r149.b(new iec.f(r139.getContext(), r148, r147));
        iec.g r151 = r149.a();
        Intrinsics.checkNotNull(r143);
        p8c.a.b(r143);
        CharSequence r152 = com.ss.android.lark.widget.richtext.i.d(r143, r151);
        ((LKUILightTextView) r139.findViewById(R.id.title_rich_text)).setMaxLines(1);
        ((LKUILightTextView) r139.findViewById(R.id.title_rich_text)).setEllipsize(TextUtils.TruncateAt.END);
        ((LKUILightTextView) r139.findViewById(R.id.title_rich_text)).setTextColor(r146);
        ((LKUILightTextView) r139.findViewById(R.id.title_rich_text)).setTextSize(r147);
        LKUILightTextView r153 = (LKUILightTextView) r139.findViewById(R.id.title_rich_text);
        Intrinsics.checkNotNull(r152);
        r153.setContentText(r152);
        return;
    L90:
        r145 = R.color.text_title;
        goto L91
    L84:
        r143 = j8c.f.a(r140.rich_summary);
        if (com.ss.android.lark.widget.richtext.i.l(r143) == false) goto L87;
        r143 = com.ss.android.lark.widget.richtext.c.c(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_NoTitlePlaceholder));
        goto L87
    L81:
        r142 = false;
        goto L82
    L59:
        r137 = R.drawable.todo_svg_icon_checked_new;
        goto L60
    L61:
        ((RelativeLayout) r132.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        com.ss.android.lark.todo.impl.utils.i r154 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r134.booleanValue() == false) goto L64;
        int r155 = R.drawable.todo_svg_icon_milestone_disable_checked_new;
    L65:
        r138 = r154.c(r155);
        goto L78
    L64:
        r155 = R.drawable.todo_svg_icon_checked_dis_new;
        goto L65
    L67:
        if (y2(r133) == true) goto L73;
        ((RelativeLayout) r132.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        com.ss.android.lark.todo.impl.utils.i r156 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r134.booleanValue() == false) goto L71;
        int r157 = R.drawable.todo_svg_icon_milestone_disable;
    L72:
        r138 = r156.c(r157);
        goto L78
    L71:
        r157 = R.drawable.todo_svg_icon_uncheckable_new;
        goto L72
    L73:
        ((RelativeLayout) r132.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        com.ss.android.lark.todo.impl.utils.i r158 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r134.booleanValue() == false) goto L76;
        int r159 = R.drawable.todo_svg_icon_milestone_unchecked;
    L77:
        r138 = r158.c(r159);
        goto L78
    L76:
        r159 = R.drawable.todo_svg_icon_uncheck_new;
        goto L77
    L30:
        r119 = r116.getEndTimeColor();
        goto L31
    L26:
        r118 = com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_Task_TimeDue, "Time", r116.getEndTimeStr());
        goto L27
    L22:
        r117 = false;
        goto L24
    L18:
        r113 = 4;
        goto L19
    L14:
        ((LinearLayout) r103.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.task_search_unselect_round));
        goto L15
    L96:
        return;
    L5:
        if (r211 >= getItemCount()) goto L8;
        r101 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.task_search_item_bg, r100, false));
    }

    public final void z2(List<Todo> r100, CopyOnWriteArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "datas");
        Intrinsics.checkNotNullParameter(r101, "selectItemGuids");
        ArrayList r102 = new ArrayList();
        Iterator<Todo> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Todo r104 = r103.next();
        r102.add(new c(r104, r101.contains(r104.guid)));
        goto L4
    L6:
        this.f443061c.submitList(r102);
    }
}
