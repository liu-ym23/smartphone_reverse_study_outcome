package com.ss.android.lark.todo.impl.features.detail.dependent.dialog;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
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
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.richtext.RichText;
import g7c.t;
import i8c.c;
import i8c.d;
import i8c.e;
import iec.f;
import iec.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003+,-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0018H\u0016J\u0014\u0010(\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130*R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter$ViewHolder;", "todoCanEdit", "", "<init>", "(Z)V", "getTodoCanEdit", "()Z", "itemClickListener", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter$ITaskDependentClickListener;", "getItemClickListener", "()Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter$ITaskDependentClickListener;", "setItemClickListener", "(Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter$ITaskDependentClickListener;)V", "timeFormatDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ITimeFormatDependency;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "isPositionInvalid", "bindTitleText", "view", "Landroid/view/View;", IOfflineExtraParser.ParserType.TODO, "bindView", "bindCompleteCheckBox", "bindCheckbox", "canCompleteByPermission", "targetTodo", "getItemCount", "updateData", "datas", "", "ViewHolder", "ITaskDependentClickListener", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDependentAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TaskDependentAdapter$Companion$DIFF_CALLBACK$1 f443069e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f443071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f443072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncListDiffer<Todo> f443073d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443074a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443074a = r100;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100);

        void b(String r100);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.detail.dependent.dialog.TaskDependentAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f443069e = new TaskDependentAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443073d.getCurrentList().size();
    }

    public TaskDependentAdapter(boolean r100) {
        this.f443070a = r100;
        this.f443072c = TodoDependencyHolder.a().timeFormatDependency();
        this.f443073d = new AsyncListDiffer(this, f443069e);
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
        Todo r102 = (Todo) ListProtector.get(this.f443073d.getCurrentList(), r211);
        ((LKUILightTextView) r100.f443074a.findViewById(R.id.title_rich_text)).setShouldLayoutZeroLengthText(true);
        View r103 = r100.f443074a;
        ViewGroup.LayoutParams r104 = ((RelativeLayout) r103.findViewById(R.id.complete_checkbox_container)).getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        r105.gravity = 48;
        ((RelativeLayout) r103.findViewById(R.id.complete_checkbox_container)).setLayoutParams(r105);
        View r106 = r100.f443074a;
        Intrinsics.checkNotNull(r102);
        r106.findViewById(R.id.content_container_view).setOnClickListener(new c(this, r102));
        int r107 = 8;
        if (this.f443070a == false) goto L14;
        ((AppCompatImageView) r106.findViewById(R.id.btn_dependent_delete)).setVisibility(0);
        r106.findViewById(R.id.btn_dependent_delete).setOnClickListener(new d(this, r102));
    L15:
        LinearLayout r108 = (LinearLayout) r106.findViewById(R.id.ll_todo_content_container);
        i r110 = i.f444291a;
        r108.setBackground(r110.c(R.drawable.task_search_unselect_round));
        View r109 = r106.findViewById(R.id.item_finish_line);
        if (r102.completed_milli_time.longValue() <= 0) goto L18;
        int r111 = 0;
    L19:
        r109.setVisibility(r111);
        int r112 = com.ss.android.lark.todo.impl.features.common.helper.b.f442448a;
        EndTimeTextAttribute r113 = com.ss.android.lark.todo.impl.features.common.helper.b.c(LarkContext.getApplication(), r102.start_milli_time.longValue(), r102.due_time.longValue() * ((long) 1000), r102.is_all_day.booleanValue(), this.f443072c.c(), false, 96);
        if (r113.getEndTimeStr().length() != 0) goto L22;
        boolean r114 = true;
    L24:
        if (r114 == false) goto L26;
        String r115 = "";
    L27:
        r113.setEndTimeStr(r115);
        if (r102.completed_milli_time.longValue() <= 0) goto L30;
        int r116 = r110.a(R.color.text_caption);
    L31:
        ((TextView) r106.findViewById(R.id.tv_end_time)).setText(r113.getEndTimeStr());
        ((TextView) r106.findViewById(R.id.tv_end_time)).setTextColor(r116);
        LinearLayout r117 = (LinearLayout) r106.findViewById(R.id.ll_end_time);
        if (TextUtils.isEmpty(r113.getEndTimeStr()) == true) goto L34;
        r107 = 0;
    L34:
        r117.setVisibility(r107);
        List<TodoAssignee> r118 = r102.assignees;
        if (r118 == null) goto L52;
        ((TaskUDAvatarList) r106.findViewById(R.id.task_owners)).setVisibility(0);
        TaskUDAvatarList r119 = (TaskUDAvatarList) r106.findViewById(R.id.task_owners);
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r118.iterator();
    L38:
        if (r121.hasNext() == false) goto L51;
        TodoAssignee r122 = (TodoAssignee) r121.next();
        String r123 = r122.assignee_id;
        TodoAssignee.User r124 = r122.user;
        TodoUser r125 = r124.user;
        if (r125 == null) goto L43;
        String r126 = r125.avatar_key;
        if (r126 == null) goto L43;
    L45:
        if (r124.completed_milli_time.longValue() <= 0) goto L49;
        int r127 = MultiCompleteHelper.f442436a;
        if (MultiCompleteHelper.e(r102.source, r102.mode) == false) goto L49;
        boolean r128 = true;
    L50:
        r120.add(new com.ss.android.lark.todo.impl.features.detail.sections.c(r123, r126, r128, 0));
    L49:
        r128 = false;
    L43:
        r126 = "";
        goto L45
    L51:
        r119.setAdapter(new e(r120));
    L52:
        View r129 = r100.f443074a;
        Boolean r130 = r102.is_milestone;
        ImageView r131 = (ImageView) r129.findViewById(R.id.complete_checkbox);
        if (r102.completed_milli_time.longValue() <= 0) goto L67;
        if (y2(r102) == false) goto L61;
        ((RelativeLayout) r129.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        i r132 = i.f444291a;
        if (r130.booleanValue() == false) goto L59;
        int r133 = R.drawable.todo_svg_icon_milestone_checked_new;
    L60:
        Drawable r134 = r132.c(r133);
    L78:
        r131.setImageDrawable(r134);
        ((ImageView) r129.findViewById(R.id.complete_checkbox)).setScaleType(ImageView.ScaleType.CENTER);
        View r135 = r100.f443074a;
        TodoItemPermission r136 = r102.self_permission;
        if (r136 == null) goto L81;
        boolean r137 = Intrinsics.areEqual(r136.is_readable, Boolean.FALSE);
    L82:
        if (r137 == false) goto L84;
        RichText r138 = com.ss.android.lark.widget.richtext.c.c(i.f444291a.g(R.string.Todo_Tasks_BlockingTasksNoPermissionView_Text));
    L87:
        i r139 = i.f444291a;
        if (r102.completed_milli_time.longValue() <= 0) goto L90;
        int r140 = R.color.text_caption;
    L91:
        int r141 = r139.a(r140);
        int r142 = (int) UIHelper.sp2px(16.0f);
        int r143 = (int) UIHelper.sp2px(20.0f);
        g.a r144 = new g.a();
        r144.f489531d.f489512a = false;
        iec.a r145 = r144.f489532e;
        r145.f489508a = true;
        r145.f489511d = r141;
        r144.b(new f(r135.getContext(), r143, r142));
        g r146 = r144.a();
        Intrinsics.checkNotNull(r138);
        p8c.a.b(r138);
        CharSequence r147 = com.ss.android.lark.widget.richtext.i.d(r138, r146);
        ((LKUILightTextView) r135.findViewById(R.id.title_rich_text)).setMaxLines(1);
        ((LKUILightTextView) r135.findViewById(R.id.title_rich_text)).setEllipsize(TextUtils.TruncateAt.END);
        ((LKUILightTextView) r135.findViewById(R.id.title_rich_text)).setTextColor(r141);
        ((LKUILightTextView) r135.findViewById(R.id.title_rich_text)).setTextSize(r142);
        LKUILightTextView r148 = (LKUILightTextView) r135.findViewById(R.id.title_rich_text);
        Intrinsics.checkNotNull(r147);
        r148.setContentText(r147);
        return;
    L90:
        r140 = R.color.text_title;
        goto L91
    L84:
        r138 = j8c.f.a(r102.rich_summary);
        if (com.ss.android.lark.widget.richtext.i.l(r138) == false) goto L87;
        r138 = com.ss.android.lark.widget.richtext.c.c(i.f444291a.g(R.string.Todo_Task_NoTitlePlaceholder));
        goto L87
    L81:
        r137 = false;
        goto L82
    L59:
        r133 = R.drawable.todo_svg_icon_checked_new;
        goto L60
    L61:
        ((RelativeLayout) r129.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        i r149 = i.f444291a;
        if (r130.booleanValue() == false) goto L64;
        int r150 = R.drawable.todo_svg_icon_milestone_disable_checked_new;
    L65:
        r134 = r149.c(r150);
        goto L78
    L64:
        r150 = R.drawable.todo_svg_icon_checked_dis_new;
        goto L65
    L67:
        if (y2(r102) == true) goto L73;
        ((RelativeLayout) r129.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        i r151 = i.f444291a;
        if (r130.booleanValue() == false) goto L71;
        int r152 = R.drawable.todo_svg_icon_milestone_disable;
    L72:
        r134 = r151.c(r152);
        goto L78
    L71:
        r152 = R.drawable.todo_svg_icon_uncheckable_new;
        goto L72
    L73:
        ((RelativeLayout) r129.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        i r153 = i.f444291a;
        if (r130.booleanValue() == false) goto L76;
        int r154 = R.drawable.todo_svg_icon_milestone_unchecked;
    L77:
        r134 = r153.c(r154);
        goto L78
    L76:
        r154 = R.drawable.todo_svg_icon_uncheck_new;
        goto L77
    L30:
        r116 = r113.getEndTimeColor();
        goto L31
    L26:
        r115 = i.d(R.string.Todo_Task_TimeDue, "Time", r113.getEndTimeStr());
        goto L27
    L22:
        r114 = false;
        goto L24
    L18:
        r111 = 4;
        goto L19
    L14:
        ((AppCompatImageView) r106.findViewById(R.id.btn_dependent_delete)).setVisibility(8);
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
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.task_dependent_item_bg, r100, false));
    }
}
