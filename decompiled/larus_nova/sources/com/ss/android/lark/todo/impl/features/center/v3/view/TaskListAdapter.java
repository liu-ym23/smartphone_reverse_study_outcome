package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.DueTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.StartTimeGroupCategory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.blockit.hashtag.widget.RecyclerSwipeAdapter;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004`abcB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0019H\u0016J\u0010\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106J\b\u00107\u001a\u00020\u0019H\u0016J\u0010\u00108\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\u0019J\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180@2\u0006\u0010A\u001a\u00020%J\u0016\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u000206J\u001e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u0002062\u0006\u0010E\u001a\u000206J(\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\u0015H\u0002J(\u0010N\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020OH\u0002J(\u0010P\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\u0010H\u0002J\u0018\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0015H\u0002J\u0018\u0010T\u001a\u0002012\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0015H\u0002J\u0018\u0010U\u001a\u0002012\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0015H\u0002J\u0018\u0010V\u001a\u0002012\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0015H\u0002J\u000e\u0010W\u001a\u0002012\u0006\u00105\u001a\u00020DJ\u0006\u0010X\u001a\u000201J\u001e\u0010Y\u001a\u0002012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00100:2\b\b\u0002\u0010[\u001a\u00020\u001dJ\u0006\u0010\\\u001a\u000201J\u0006\u0010]\u001a\u000201Jd\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0012j\b\u0012\u0004\u0012\u00020\u0010`\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150:2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100:0_H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0012j\b\u0012\u0004\u0012\u00020\u0010`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0012j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000RJ\u0010\u001b\u001a>\u0012\u0004\u0012\u00020\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0012j\b\u0012\u0004\u0012\u00020\u0010`\u00130\u0017j\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0012j\b\u0012\u0004\u0012\u00020\u0010`\u0013`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006d"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter;", "Lcom/larksuite/component/blockit/hashtag/widget/RecyclerSwipeAdapter;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/AdapterDataProvider;", "listener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$IListClickListener;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$IListClickListener;Landroidx/fragment/app/Fragment;)V", "getListener", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$IListClickListener;", "getFragment", "()Landroidx/fragment/app/Fragment;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "mCurrentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sections", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/SectionHeaderItem;", "sectionMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "sectionItemMap", "isInDragState", "", "()Z", "setInDragState", "(Z)V", "canRefreshFromUpdate", "getCanRefreshFromUpdate", "setCanRefreshFromUpdate", "dragFromItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem;", "getDragFromItem", "()Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem;", "setDragFromItem", "(Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem;)V", "itemListener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "reviseHeaderView", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "getSwipeLayoutResourceId", "adapterData", "", "getAdapterData", "()Ljava/util/List;", "getItemViewType", "getItem", "getTaskItemInSectionPosition", "Lkotlin/Pair;", "dragItem", "canDropOver", "fromViewHolder", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskItemViewHolder;", "toViewHolder", "move", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "moveOverSectionHeaderItem", "fromPosition", "toPosition", "fromItem", "toItem", "moveOverInlineCreateItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/InlineCreateItem;", "moveOverTaskItem", "reviseTaskItemWithSectionItem", "todoItem", "sectionItem", "reviseTaskItemWithDueTimeSectionItem", "reviseTaskItemWithStartTimeSectionItem", "reviseTaskItemWithOwnerSectionItem", "startDrag", "endDrag", "updateData", "data", "needScrollTop", "refreshList", "reviseSectionSortList", "getCurrentList", "", "Companion", "IListClickListener", "ShineViewHolder", "BaseViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListAdapter extends RecyclerSwipeAdapter<BaseViewHolder> implements com.ss.android.lark.todo.impl.features.center.v3.view.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final TaskListAdapter$Companion$DIFF_CALLBACK$1 f441946m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f441947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f441948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncListDiffer<com.ss.android.lark.todo.impl.features.center.v3.data.a> f441949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<com.ss.android.lark.todo.impl.features.center.v3.data.a> f441950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<SectionHeaderItem> f441951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, Integer> f441952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, ArrayList<com.ss.android.lark.todo.impl.features.center.v3.data.a>> f441953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f441954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f441955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TaskItem f441956k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u0 f441957l;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "getBackgroundRes", "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        public static final class a {
        }

        static {
        }

        public abstract void T3(com.ss.android.lark.todo.impl.features.center.v3.data.a r100);

        public BaseViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }

        public static int U3(com.ss.android.lark.todo.impl.features.center.v3.data.a r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            if (r100.f() == false) goto L8;
            if (r100.a() == false) goto L8;
            return R.drawable.bg_setting_group_item_round;
        L8:
            if (r100.f() == false) goto L11;
            return R.drawable.bg_setting_group_item_round_top;
        L11:
            if (r100.a() == false) goto L13;
            return R.drawable.bg_setting_group_item_round_bottom;
        L13:
            return R.drawable.bg_setting_group_item_rectangle;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$ShineViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "setContainerViewBackground", "", "drawable", "Landroid/graphics/drawable/Drawable;", "shine", "", "shineTodoGuid", "", "getShineTodoGuid", "()Ljava/lang/String;", "setShineTodoGuid", "(Ljava/lang/String;)V", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ShineViewHolder extends BaseViewHolder {
        public abstract String V3();

        public abstract void W3(Drawable r100, boolean r101);

        public abstract void X3(String r100);

        public ShineViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100);

        void b(String r100, String r101);

        void c(String r100);

        void d(String r100, String r101);

        void e(String r100, String r101);

        void f(String r100, Fragment r101);

        void g(String r100, SimpleSubTodoData r101);

        void h(String r100);

        void i(String r100);

        void j(String r100, TaskItem.CompleteType r101, boolean r102);

        void k(String r100);

        void l(String r100);

        void m(String r100, boolean r101);

        void n(String r100, String r101);

        void o(TaskItemViewHolder r100, String r101);

        void p(List<SectionHeaderItem> r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441958a = null;

        static {
            int[] r100 = new int[TaskFieldType.values().length];
            r100[TaskFieldType.ASSIGNEE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L4:
            f441958a = r100;
            int[] r101 = new int[DueTimeGroupCategory.values().length];
            r101[DueTimeGroupCategory.UNSCHEDULED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L47:
            r101[DueTimeGroupCategory.OVERDUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L61:
            r101[DueTimeGroupCategory.TODAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L37:
            r101[DueTimeGroupCategory.TOMORROW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L55:
            r101[DueTimeGroupCategory.NEXT_SEVEN_DAYS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L45:
            r101[DueTimeGroupCategory.LATER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L16:
            int[] r102 = new int[StartTimeGroupCategory.values().length];
            r102[StartTimeGroupCategory.START_UNSCHEDULED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L53:
            r102[StartTimeGroupCategory.ALREADY_STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L41:
            r102[StartTimeGroupCategory.START_TODAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L51:
            r102[StartTimeGroupCategory.START_TOMORROW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L39:
            r102[StartTimeGroupCategory.START_NEXT_SEVEN_DAYS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L49:
            r102[StartTimeGroupCategory.START_LATER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
            return;
        }
    }

    @Override // py7.a
    public final int B0() {
        return R.id.swipeLayout;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f441946m = new TaskListAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.a
    public final List<com.ss.android.lark.todo.impl.features.center.v3.data.a> G() {
        return this.f441949d.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f441949d.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        com.ss.android.lark.todo.impl.features.center.v3.data.a r101 = (com.ss.android.lark.todo.impl.features.center.v3.data.a) CollectionsKt.getOrNull(this.f441949d.getCurrentList(), r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.c();
    }

    public TaskListAdapter(v r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.f441947b = r100;
        this.f441948c = r101;
        this.f441949d = new AsyncListDiffer(this, f441946m);
        this.f441950e = new ArrayList();
        this.f441951f = new ArrayList();
        this.f441952g = new HashMap();
        this.f441953h = new HashMap();
        this.f441955j = true;
        this.f441957l = new u0(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((com.ss.android.lark.todo.impl.features.center.v3.data.a) ListProtector.get(this.f441949d.getCurrentList(), r101));
        if ((r102 instanceof TaskItemViewHolder) == false) goto L5;
        TaskItemViewHolder r103 = (TaskItemViewHolder) r102;
    L6:
        if (r103 == null) goto L9;
        this.f283058a.a(((TaskItemViewHolder) r102).f441924a, r101);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L5;
        int r102 = SectionItemViewHolder.f441892c;
        u0 r103 = this.f441957l;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r103, "listener");
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.section_item_bg, r100, false);
        Intrinsics.checkNotNull(r104);
        return new SectionItemViewHolder(r104, r103);
    L5:
        if (r101 != 1) goto L7;
        int r105 = TaskItemViewHolder.f441923j;
        u0 r106 = this.f441957l;
        Fragment r107 = this.f441948c;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r106, "listener");
        Intrinsics.checkNotNullParameter(r107, WidgetService.PARAM_FRAGMENT);
        View r108 = LayoutInflater.from(r100.getContext()).inflate(R.layout.task_item_bg, r100, false);
        Intrinsics.checkNotNull(r108);
        return new TaskItemViewHolder(r108, r106, r100, r107);
    L7:
        if (r101 == 3) goto L9;
        int r109 = InlineCreateItemViewHolder.f441851c;
        u0 r110 = this.f441957l;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, "listener");
        View r111 = LayoutInflater.from(r100.getContext()).inflate(R.layout.section_inline_create_bg, r100, false);
        Intrinsics.checkNotNull(r111);
        return new InlineCreateItemViewHolder(r111, r110);
    L9:
        int r112 = TaskSkeletonItemViewHolder.f441979c;
        u0 r113 = this.f441957l;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r113, "listener");
        View r114 = LayoutInflater.from(r100.getContext()).inflate(R.layout.task_list_task_item_skeleton, r100, false);
        Intrinsics.checkNotNull(r114);
        return new TaskSkeletonItemViewHolder(r114, r113);
    }

    public static ArrayList A2(List r110, HashMap r111, Map r112) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = r110.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L21;
        int r103 = r102 + 1;
        SectionHeaderItem r104 = (SectionHeaderItem) r101.next();
        r111.put(r104.f441435a, Integer.valueOf(r102));
        r104.f441452r = true;
        r104.f441453s = false;
        r100.add(r104);
        List r105 = (List) r112.get(r104.f441435a);
        if (r105 != null) goto L8;
        r105 = CollectionsKt.emptyList();
    L8:
        Iterator r106 = r105.iterator();
        int r107 = 0;
    L10:
        if (r106.hasNext() == false) goto L19;
        com.ss.android.lark.todo.impl.features.center.v3.data.a r108 = (com.ss.android.lark.todo.impl.features.center.v3.data.a) r106.next();
        r108.b(false);
        r108.g(false);
        if (r104.f441442h == false) goto L15;
        r100.add(r108);
    L15:
        if ((r108 instanceof TaskItem) == true) goto L18;
        if ((r108 instanceof com.ss.android.lark.todo.impl.features.center.v3.data.g) == false) goto L10;
    L18:
        r107 = r107 + 1;
        goto L10
    L19:
        r104.f441438d = r107;
        ((com.ss.android.lark.todo.impl.features.center.v3.data.a) ListProtector.get(r100, r100.size() - 1)).g(true);
        r102 = r103;
        goto L4
    L21:
        if (r110.isEmpty() == false) goto L32;
        List r113 = (List) r112.get("");
        if (r113 != null) goto L25;
        r113 = CollectionsKt.emptyList();
    L25:
        Iterator r114 = r113.iterator();
    L27:
        if (r114.hasNext() == false) goto L30;
        com.ss.android.lark.todo.impl.features.center.v3.data.a r115 = (com.ss.android.lark.todo.impl.features.center.v3.data.a) r114.next();
        r115.b(false);
        r115.g(false);
        r100.add(r115);
        goto L27
    L30:
        if ((!r100.isEmpty()) == false) goto L32;
        ((com.ss.android.lark.todo.impl.features.center.v3.data.a) ListProtector.get(r100, 0)).b(true);
        ((com.ss.android.lark.todo.impl.features.center.v3.data.a) ListProtector.get(r100, r100.size() - 1)).g(true);
    L32:
        return r100;
    }
}
