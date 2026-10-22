package com.ss.android.lark.todo.impl.features.detail.sections;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.TaskContainerPermission;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.blockit.hashtag.widget.RecyclerSwipeAdapter;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u001cH\u0016J\u001c\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter;", "Lcom/larksuite/component/blockit/hashtag/widget/RecyclerSwipeAdapter;", "Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter$ViewHolder;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/todo/impl/features/detail/sections/TaskListSectionItem;", "listener", "Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter$IDetailTaskListsItemListener;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter$IDetailTaskListsItemListener;", "setListener", "(Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter$IDetailTaskListsItemListener;)V", "canEdit", "", "getCanEdit", "()Z", "setCanEdit", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "viewHolder", "position", "updateData", "data", "", "isCanEdit", "getItemCount", "getSwipeLayoutResourceId", "ViewHolder", "IDetailTaskListsItemListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetailTaskListsAdapter extends RecyclerSwipeAdapter<ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f443228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncListDiffer<o1> f443229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f443230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f443231e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailTaskListsAdapter;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "getSwipeLayout", "Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443232a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443232a = r100;
        }
    }

    public interface a {
        void a(String r100, String r101);

        void b(View r100, MotionEvent r101);

        void c(String r100);

        void d(String r100);
    }

    @Override // py7.a
    public final int B0() {
        return R.id.task_list_item_swipelayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443229c.getCurrentList().size();
    }

    public DetailTaskListsAdapter(TodoDetailFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f443228b = r100;
        this.f443229c = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(new DetailTaskListsAdapter$mDiffer$1()).build());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "viewHolder");
        o1 r100 = (o1) ListProtector.get(this.f443229c.getCurrentList(), r111);
        boolean r101 = true;
        boolean r102 = false;
        if (this.f443231e == false) goto L12;
        TaskContainerPermission r103 = r100.f443414a.current_user_permission;
        if (r103 == null) goto L9;
        Map<Integer, Boolean> r104 = r103.permissions;
        if (r104 == null) goto L9;
        boolean r105 = Intrinsics.areEqual(r104.get(Integer.valueOf(TaskContainerPermission.Action.EDIT_TASK.getValue())), Boolean.TRUE);
    L10:
        if (r105 == false) goto L12;
        boolean r106 = true;
    L13:
        ((SwipeLayout) r112.f443232a.findViewById(R.id.task_list_item_swipelayout)).setSwipeEnabled(r106);
        ((SwipeLayout) r112.f443232a.findViewById(R.id.task_list_item_swipelayout)).setIsUseBoundCache(false);
        ((SwipeLayout) r112.f443232a.findViewById(R.id.task_list_item_swipelayout)).setShowMode(SwipeLayout.ShowMode.LayDown);
        ViewGroup.LayoutParams r107 = ((LinearLayout) r112.f443232a.findViewById(R.id.detail_task_list_item_container)).getLayoutParams();
        if ((r107 instanceof LinearLayout.LayoutParams) == false) goto L16;
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
    L18:
        if (r111 == 0) goto L20;
    L23:
        if (r111 != 0) goto L29;
        if (r111 != (this.f443229c.getCurrentList().size() - 1)) goto L29;
        if (r108 == null) goto L34;
        r108.setMargins(0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_8), 0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_8));
    L34:
        View r109 = r112.f443232a.findViewById(R.id.first_icon);
        if (r111 == 0) goto L38;
        r101 = false;
    L38:
        com.larksuite.framework.section.utils.a.d(r109, r101);
        TextView r113 = (TextView) r112.f443232a.findViewById(R.id.container_tv);
        if (TextUtils.isEmpty(r100.f443414a.name) == false) goto L41;
        String r114 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_TaskList_UntitledList_Title);
    L42:
        r113.setText(r114);
        TextView r115 = (TextView) r112.f443232a.findViewById(R.id.section_tv);
        StringBuilder r116 = new StringBuilder();
        TaskSection r117 = r100.f443415b;
        if (r117 == null) goto L45;
        String r118 = r117.name;
    L47:
        if (TextUtils.isEmpty(r118) == true) goto L52;
        TaskSection r119 = r100.f443415b;
        if (r119 == null) goto L51;
        String r120 = r119.name;
    L58:
        r116.append(r120);
        r116.append(' ');
        r115.setText(r116.toString());
        if (r100.f443415b != null) goto L61;
        ((TextView) r112.f443232a.findViewById(R.id.section_tv)).setText(" ");
    L61:
        Drawable r121 = UDIconUtils.getIconDrawable(r112.f443232a.getContext(), R.drawable.ud_icon_down_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n1), new UDDimension.b(14));
        if (r106 == false) goto L64;
        ((TextView) r112.f443232a.findViewById(R.id.section_tv)).setCompoundDrawables(null, null, r121, null);
    L65:
        r112.f443232a.findViewById(R.id.section_tv).setOnClickListener(new r0(r106, this, r100, r112));
        r112.f443232a.findViewById(R.id.container_tv).setOnClickListener(new s0(r112, this, r100));
        r112.f443232a.findViewById(R.id.behind_delete_view).setOnClickListener(new t0(r106, this, r100));
        r112.f443232a.setOnTouchListener(new u0(this));
        this.f283058a.a(r112.f443232a, r111);
        return;
    L64:
        ((TextView) r112.f443232a.findViewById(R.id.section_tv)).setCompoundDrawables(null, null, null, null);
        goto L65
    L51:
        r120 = null;
        goto L58
    L52:
        TaskSection r122 = r100.f443415b;
        if (r122 == null) goto L55;
        r102 = Intrinsics.areEqual(r122.is_default, Boolean.TRUE);
    L55:
        if (r102 == false) goto L57;
        r120 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Section_NoSection_Title);
        goto L58
    L57:
        r120 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_UntitledSection_Title);
        goto L58
    L45:
        r118 = null;
        goto L47
    L41:
        r114 = r100.f443414a.name;
    L29:
        if (r111 != (this.f443229c.getCurrentList().size() - 1)) goto L32;
        if (r108 == null) goto L34;
        r108.setMargins(0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_4), 0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_8));
        goto L34
    L32:
        if (r108 == null) goto L34;
        r108.setMargins(0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_4), 0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_4));
        goto L34
    L20:
        if (r111 == (this.f443229c.getCurrentList().size() - 1)) goto L23;
        if (r108 == null) goto L34;
        r108.setMargins(0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_8), 0, y9c.d.d(r112.f443232a.getContext(), R.dimen.dp_4));
        goto L34
    L16:
        r108 = null;
    L9:
        r105 = false;
    L12:
        r106 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_task_list_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
