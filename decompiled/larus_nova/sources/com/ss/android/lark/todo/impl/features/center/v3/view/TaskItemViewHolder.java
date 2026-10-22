package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.Progress;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import com.ss.android.lark.todo.impl.features.common.entity.EndTimeTextAttribute;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0002JKB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001bH\u0002J\u0018\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u00100\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u001bH\u0002J\u0018\u00102\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u001bH\u0002J\u0018\u00103\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00107\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0018\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u0006L"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskItemViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$ShineViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "parentView", "Landroid/view/ViewGroup;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;Landroid/view/ViewGroup;Landroidx/fragment/app/Fragment;)V", "getView", "()Landroid/view/View;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "getParentView", "()Landroid/view/ViewGroup;", "getFragment", "()Landroidx/fragment/app/Fragment;", "shineTodoGuid", "", "getShineTodoGuid", "()Ljava/lang/String;", "setShineTodoGuid", "(Ljava/lang/String;)V", "isShine", "", "dueTimeLength", "", "textPaint", "Landroid/graphics/Paint;", "taskGuid", "getTaskGuid", "setTaskGuid", "bind", "", "baseItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "bindBackground", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem;", "getItemChecked", "showCompleteDialog", "isSlide", "showRevokeDialog", "goCompleteAction", "bindCheckbox", "bindCheckboxAction", "isChecked", "bindMileStoneTodoCheckAction", "bindNormalTodoCheckAction", "bindSummary", "bindOwner", "shouldShowTime", "bindDueTime", "bindThirdLine", "getRealWindowWidth", "bindBehind", "getSwipeBehindView", "swipeType", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskItemViewHolder$SwipeType;", "getBehindShareView", "getBehindDeleteView", "getBehindQuitView", "getBehindCompleteOrRevokeView", "getBehindOwnerView", "getBehindDueTimeView", "getCountText", "count", "setContainerViewBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "shine", "Companion", "SwipeType", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskItemViewHolder extends TaskListAdapter.ShineViewHolder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f441923j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f441925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f441926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f441927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f441928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f441929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f441930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f441931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f441932i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskItemViewHolder$SwipeType;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "QUIT", "SHARE", "DUE_TIME", "OWNER", "COMPLETE", "RESTORE", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SwipeType extends Enum<SwipeType> {
        public static final SwipeType COMPLETE = null;
        public static final SwipeType DELETE = null;
        public static final SwipeType DUE_TIME = null;
        public static final SwipeType OWNER = null;
        public static final SwipeType QUIT = null;
        public static final SwipeType RESTORE = null;
        public static final SwipeType SHARE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SwipeType[] f441933a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441934b = null;

        public static EnumEntries<SwipeType> getEntries() {
            return f441934b;
        }

        static {
            SwipeType r100 = new SwipeType("DELETE", 0);
            DELETE = r100;
            SwipeType r101 = new SwipeType("QUIT", 1);
            QUIT = r101;
            SwipeType r102 = new SwipeType("SHARE", 2);
            SHARE = r102;
            SwipeType r103 = new SwipeType("DUE_TIME", 3);
            DUE_TIME = r103;
            SwipeType r104 = new SwipeType("OWNER", 4);
            OWNER = r104;
            SwipeType r105 = new SwipeType("COMPLETE", 5);
            COMPLETE = r105;
            SwipeType r110 = new SwipeType("RESTORE", 6);
            RESTORE = r110;
            SwipeType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f441933a = r111;
            f441934b = EnumEntriesKt.enumEntries(r111);
        }

        public static SwipeType[] values() {
            return (SwipeType[]) f441933a.clone();
        }

        public static SwipeType valueOf(String r100) {
            return (SwipeType) r27.a.a(SwipeType.class, r100);
        }

        public SwipeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441935a = null;

        static {
            int[] r100 = new int[SwipeType.values().length];
            r100[SwipeType.SHARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[SwipeType.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[SwipeType.QUIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[SwipeType.COMPLETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[SwipeType.RESTORE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[SwipeType.OWNER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[SwipeType.DUE_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f441935a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f441936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskItemViewHolder f441937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskItem f441938c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f441936a;
            long r102 = System.currentTimeMillis();
            this.f441936a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            TaskItemViewHolder r103 = this.f441937b;
            r103.f441925b.f(this.f441938c.f441483a, r103.f441927d);
        }

        public c(TaskItemViewHolder r100, TaskItem r101) {
            this.f441937b = r100;
            this.f441938c = r101;
        }
    }

    public static final class d extends com.larksuite.component.blockit.hashtag.widget.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f441939a;

        public d() {
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void c(SwipeLayout r100) {
            int r101 = a9c.a.f2310a;
            if (this.f441939a <= 0) goto L5;
            boolean r102 = true;
        L6:
            z5c.r r103 = z5c.r.f570318c3;
            if (r102 == false) goto L9;
            String r104 = "left_swipe";
        L10:
            a9c.a.c("todo_center_task_list_click", s5c.d.b.c(r103.a(r104)));
            return;
        L9:
            r104 = "right_swipe";
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.a, com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void onUpdate(int r100) {
            this.f441939a = r100;
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskItem f441940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskItemViewHolder f441941b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f441942a = null;

            static {
                int[] r100 = new int[TaskItem.DragState.values().length];
                r100[TaskItem.DragState.UNEDITABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[TaskItem.DragState.INVALID_SORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[TaskItem.DragState.INVALID_SECTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[TaskItem.DragState.CAN_DRAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f441942a = r100;
            }
        }

        public e(TaskItem r100, TaskItemViewHolder r101) {
            this.f441940a = r100;
            this.f441941b = r101;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            TaskItem.DragState r101 = this.f441940a.f441504v;
            int r102 = a.f441942a[r101.ordinal()];
            if (r102 != 1) goto L5;
            OperationToastHelper r103 = OperationToastHelper.f442443a;
            OperationToastHelper.c(this.f441941b.f441924a.getContext(), R.string.Todo_UnableCustomSortDueToPermissions_Toast, null, 60);
        L15:
            return true;
        L5:
            if (r102 != 2) goto L7;
            OperationToastHelper r104 = OperationToastHelper.f442443a;
            OperationToastHelper.c(this.f441941b.f441924a.getContext(), R.string.Todo_UnableDragAndDropInThisSort_Toast, null, 60);
            goto L15
        L7:
            if (r102 != 3) goto L9;
            OperationToastHelper r105 = OperationToastHelper.f442443a;
            OperationToastHelper.c(this.f441941b.f441924a.getContext(), R.string.Todo_UnableDragAndDropInThisSection_Toast, null, 60);
            goto L15
        L9:
            if (r102 != 4) goto L15;
            TaskItemViewHolder r106 = this.f441941b;
            r106.f441925b.o(r106);
            goto L15
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f441943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskItem f441944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskItemViewHolder f441945c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f441943a;
            long r102 = System.currentTimeMillis();
            this.f441943a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            TaskItem r103 = this.f441944b;
            if (r103.f441501s == null) goto L8;
            TaskItemViewHolder.Y3(this.f441945c, r103);
            return;
        L8:
            TaskItem.CompleteType r104 = r103.f441500r;
            if (r104 != TaskItem.CompleteType.TaskRevokeDialog) goto L12;
            TaskItemViewHolder.a4(this.f441945c, r103, true);
            return;
        L12:
            if (r104 != TaskItem.CompleteType.TaskCompleteDialog) goto L14;
            TaskItemViewHolder.Z3(this.f441945c, r103, true);
            return;
        L14:
            this.f441945c.f441925b.j(r103.f441483a, r104, true);
        }

        public f(TaskItem r100, TaskItemViewHolder r101) {
            this.f441944b = r100;
            this.f441945c = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.ShineViewHolder
    public final String V3() {
        return this.f441928e;
    }

    public static boolean c4(TaskItem r100) {
        TaskItem.CompleteType r101 = r100.f441500r;
        if (r101 != TaskItem.CompleteType.TaskComplete) goto L5;
    L9:
        return false;
    L5:
        if (r101 == TaskItem.CompleteType.UserComplete) goto L9;
        if (r101 == TaskItem.CompleteType.TaskCompleteDialog) goto L9;
        return true;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.BaseViewHolder
    public final void T3(com.ss.android.lark.todo.impl.features.center.v3.data.a r210) {
        Intrinsics.checkNotNullParameter(r210, "baseItem");
        if ((r210 instanceof TaskItem) == false) goto L5;
        TaskItem r100 = (TaskItem) r210;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        X3(r100.f441483a);
        this.f441932i = r100.f441483a;
        ViewGroup.LayoutParams r101 = this.f441924a.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r100.f441507y == false) goto L11;
        int r103 = y9c.d.a(16);
    L12:
        r102.setMargins(0, 0, 0, r103);
        this.f441924a.setLayoutParams(r102);
        if (this.f441929f == true) goto L15;
        ((LinearLayout) this.f441924a.findViewById(R.id.container_view)).setBackground(y9c.d.e(this.f441924a.getContext(), TaskListAdapter.BaseViewHolder.U3(r100)));
    L15:
        this.f441929f = false;
        View r104 = this.f441924a;
        r104.setBackground(y9c.d.e(r104.getContext(), TaskListAdapter.BaseViewHolder.U3(r100)));
        com.larksuite.framework.section.utils.a.d(this.f441924a.findViewById(R.id.divider_todo_item), !r100.f441507y);
        boolean r105 = c4(r100);
        boolean r106 = r100.f441505w;
        ImageView r107 = (ImageView) this.f441924a.findViewById(R.id.complete_checkbox);
        boolean r110 = r100.f441499q;
        if (r110 == false) goto L23;
        if (r105 == false) goto L23;
        com.ss.android.lark.todo.impl.utils.i r111 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r106 == false) goto L21;
        int r108 = R.drawable.todo_svg_icon_milestone_checked_new;
    L22:
        Drawable r109 = r111.c(r108);
    L42:
        r107.setImageDrawable(r109);
        ((ImageView) this.f441924a.findViewById(R.id.complete_checkbox)).setScaleType(ImageView.ScaleType.CENTER);
        if (r100.f441505w == false) goto L45;
        this.f441924a.findViewById(R.id.complete_checkbox_container).setOnClickListener(new g0(r100, this, r105));
    L46:
        TextView r112 = (TextView) this.f441924a.findViewById(R.id.title_rich_text);
        r112.setText(r100.f441485c);
        Context r113 = this.f441924a.getContext();
        if (c4(r100) == false) goto L49;
        int r114 = R.color.text_placeholder;
    L50:
        r112.setTextColor(y9c.d.c(r113, r114));
        if (c4(r100) == false) goto L53;
        int r115 = 16 | r112.getPaintFlags();
    L54:
        r112.setPaintFlags(r115);
        if (r100.f441486d.isEmpty() == false) goto L57;
        ((TaskUDAvatarList) this.f441924a.findViewById(R.id.task_owners)).setVisibility(8);
    L58:
        ((LinearLayout) this.f441924a.findViewById(R.id.time_icon_container)).setVisibility(8);
        this.f441930g = 0;
        if (r100.f441487e == 0) goto L62;
    L60:
        boolean r116 = true;
    L66:
        if (r116 == true) goto L68;
        ((LinearLayout) this.f441924a.findViewById(R.id.time_container)).setVisibility(8);
    L78:
        Progress r117 = r100.f441496n;
        if (r117 == null) goto L83;
        Integer r118 = r117.total;
        if (r118 == null) goto L83;
        int r119 = r118.intValue();
    L84:
        if (r119 <= 0) goto L86;
        boolean r120 = true;
    L88:
        if (r100.f441497o <= 0) goto L90;
        boolean r121 = true;
    L92:
        if (r100.f441498p <= 0) goto L94;
        boolean r122 = true;
    L95:
        ((LinearLayout) this.f441924a.findViewById(R.id.second_icon_container)).setVisibility(8);
        ((LinearLayout) this.f441924a.findViewById(R.id.third_icon_container)).setVisibility(8);
        if (r120 == true) goto L100;
        if (r121 == true) goto L100;
        if (r122 == true) goto L100;
    L158:
        View r123 = this.f441924a;
        int r124 = R.id.behind_left_view;
        ((LinearLayout) r123.findViewById(R.id.behind_left_view)).removeAllViews();
        ((LinearLayout) this.f441924a.findViewById(R.id.behind_right_view)).removeAllViews();
        float r125 = UIHelper.sp2px(10.0f);
        Iterator<T> r126 = r100.f441502t.iterator();
        int r127 = 0;
    L160:
        if (r126.hasNext() == false) goto L172;
        int r128 = r127 + 1;
        SwipeType r129 = (SwipeType) r126.next();
        LinearLayout r130 = (LinearLayout) this.f441924a.findViewById(r124);
        View r131 = d4(r100, r129);
        r131.setLayoutParams(new LinearLayout.LayoutParams((int) UIHelper.sp2px(88.0f), -1, 1.0f / r100.f441502t.size()));
        if (r127 != 0) goto L171;
        if (r100.f441507y == false) goto L171;
        Drawable r132 = r131.getBackground();
        if ((r132 instanceof GradientDrawable) == false) goto L168;
        GradientDrawable r133 = (GradientDrawable) r132;
    L169:
        if (r133 == null) goto L171;
        r133.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r125, r125});
        goto L171
    L168:
        r133 = null;
    L171:
        r130.addView(r131);
        r127 = r128;
        r124 = R.id.behind_left_view;
        goto L160
    L172:
        Iterator<T> r134 = r100.f441503u.iterator();
        int r135 = 0;
    L174:
        if (r134.hasNext() == false) goto L187;
        int r136 = r135 + 1;
        SwipeType r137 = (SwipeType) r134.next();
        LinearLayout r138 = (LinearLayout) this.f441924a.findViewById(R.id.behind_right_view);
        View r139 = d4(r100, r137);
        r139.setLayoutParams(new LinearLayout.LayoutParams((int) UIHelper.sp2px(88.0f), -1, 1.0f / r100.f441503u.size()));
        if (r135 != (r100.f441503u.size() - 1)) goto L186;
        if (r100.f441507y == false) goto L186;
        Drawable r140 = r139.getBackground();
        if ((r140 instanceof GradientDrawable) == false) goto L182;
        GradientDrawable r141 = (GradientDrawable) r140;
    L183:
        if (r141 == null) goto L186;
        r141.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r125, r125, 0.0f, 0.0f});
        goto L186
    L182:
        r141 = null;
    L186:
        r138.addView(r139);
        r135 = r136;
        goto L174
    L187:
        ((SwipeLayout) this.f441924a.findViewById(R.id.swipeLayout)).setSwipeEnabled(true);
        ((ArrayList) ((SwipeLayout) this.f441924a.findViewById(R.id.swipeLayout)).f283068j).add(new d());
        ((SwipeLayout) this.f441924a.findViewById(R.id.swipeLayout)).setIsUseBoundCache(false);
        ((SwipeLayout) this.f441924a.findViewById(R.id.swipeLayout)).setShowMode(SwipeLayout.ShowMode.LayDown);
        this.f441924a.findViewById(R.id.container_view).setOnClickListener(new c(this, r100));
        ((LinearLayout) this.f441924a.findViewById(R.id.container_view)).setOnLongClickListener(new e(r100, this));
        this.f441924a.setElevation(0.0f);
        return;
    L100:
        int r142 = (int) UIHelper.sp2px(25.0f);
        View r143 = View.inflate(this.f441924a.getContext(), R.layout.task_list_item_icon_count, null);
        com.larksuite.framework.section.utils.a.d(r143.findViewById(R.id.subtask_progress), r120);
        StringBuilder r144 = new StringBuilder();
        Progress r145 = r100.f441496n;
        if (r145 == null) goto L105;
        Integer r146 = r145.completed;
        if (r146 == null) goto L105;
        int r147 = r146.intValue();
    L106:
        r144.append(r147);
        r144.append('/');
        Progress r148 = r100.f441496n;
        if (r148 == null) goto L111;
        Integer r149 = r148.total;
        if (r149 == null) goto L111;
        int r150 = r149.intValue();
    L112:
        r144.append(r150);
        String r151 = r144.toString();
        ((TextView) r143.findViewById(R.id.subtask_progress_text)).setText(r151);
        if (r120 == false) goto L115;
        r142 = r142 + ((int) UIHelper.sp2px(18.0f));
    L115:
        int r152 = r142 + ((int) this.f441931h.measureText(r151));
        com.larksuite.framework.section.utils.a.d(r143.findViewById(R.id.attachment), r121);
        int r153 = r100.f441497o;
        String r154 = "99+";
        if (r153 >= 100) goto L118;
        String r155 = String.valueOf(r153);
    L119:
        ((TextView) r143.findViewById(R.id.attachment_count)).setText(r155);
        if (r121 == false) goto L124;
        if (r120 == false) goto L123;
        r152 = r152 + ((int) UIHelper.sp2px(8.0f));
    L123:
        r152 = (r152 + ((int) UIHelper.sp2px(16.0f))) + ((int) this.f441931h.measureText(r155));
    L124:
        com.larksuite.framework.section.utils.a.d(r143.findViewById(R.id.comment), r122);
        int r156 = r100.f441498p;
        if (r156 >= 100) goto L127;
        r154 = String.valueOf(r156);
    L127:
        ((TextView) r143.findViewById(R.id.comment_count)).setText(r154);
        if (r122 == false) goto L133;
        if (r120 == true) goto L131;
        if (r121 == true) goto L131;
    L132:
        r152 = (r152 + ((int) UIHelper.sp2px(16.0f))) + ((int) this.f441931h.measureText(r154));
    L131:
        r152 = r152 + ((int) UIHelper.sp2px(8.0f));
    L133:
        r143.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if ((((this.f441926c.getWidth() - UIHelper.getDimens(R.dimen.dp_40)) - UIHelper.getDimens(R.dimen.dp_28)) - this.f441930g) <= r152) goto L143;
        ((LinearLayout) this.f441924a.findViewById(R.id.second_icon_container)).removeAllViews();
        ((LinearLayout) this.f441924a.findViewById(R.id.second_icon_container)).setVisibility(0);
        LinearLayout r157 = (LinearLayout) this.f441924a.findViewById(R.id.second_icon_container);
        View r158 = r143.findViewById(R.id.icon_divider);
        if (r100.f441487e == 0) goto L139;
    L137:
        boolean r159 = true;
    L142:
        com.larksuite.framework.section.utils.a.d(r158, r159);
        r157.addView(r143);
    L144:
        View r160 = this.f441924a.findViewById(R.id.time_icon_container);
        if (this.f441924a.findViewById(R.id.time_container).getVisibility() != 0) goto L147;
        boolean r161 = true;
    L148:
        if (r161 == false) goto L150;
    L156:
        boolean r162 = true;
    L157:
        com.larksuite.framework.section.utils.a.d(r160, r162);
        this.f441924a.invalidate();
        goto L158
    L150:
        if (this.f441924a.findViewById(R.id.second_icon_container).getVisibility() != 0) goto L152;
        boolean r163 = true;
    L153:
        if (r163 == true) goto L156;
        r162 = false;
        goto L157
    L152:
        r163 = false;
        goto L153
    L147:
        r161 = false;
        goto L148
    L139:
        if (r100.f441488f != 0) goto L137;
        r159 = false;
        goto L142
    L143:
        ((LinearLayout) this.f441924a.findViewById(R.id.third_icon_container)).removeAllViews();
        ((LinearLayout) this.f441924a.findViewById(R.id.third_icon_container)).setVisibility(0);
        LinearLayout r164 = (LinearLayout) this.f441924a.findViewById(R.id.third_icon_container);
        r143.findViewById(R.id.icon_divider).setVisibility(8);
        r164.addView(r143);
        goto L144
    L118:
        r155 = "99+";
    L111:
        r150 = 0;
    L105:
        r147 = 0;
        goto L106
    L94:
        r122 = false;
        goto L95
    L90:
        r121 = false;
        goto L92
    L86:
        r120 = false;
    L83:
        r119 = 0;
        goto L84
    L68:
        ((LinearLayout) this.f441924a.findViewById(R.id.time_icon_container)).setVisibility(0);
        ((LinearLayout) this.f441924a.findViewById(R.id.time_container)).setVisibility(0);
        int r165 = com.ss.android.lark.todo.impl.features.common.helper.b.f442448a;
        EndTimeTextAttribute r166 = com.ss.android.lark.todo.impl.features.common.helper.b.c(this.f441924a.getContext(), r100.f441488f, r100.f441487e, r100.f441493k, r100.f441508z, true, 64);
        ((TextView) this.f441924a.findViewById(R.id.time_text)).setText(r166.getEndTimeStr());
        if (c4(r100) == false) goto L71;
        int r167 = com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_caption);
    L72:
        ((TextView) this.f441924a.findViewById(R.id.time_text)).setTextColor(r167);
        this.f441930g += (int) this.f441931h.measureText(r166.getEndTimeStr());
        com.larksuite.framework.section.utils.a.d(this.f441924a.findViewById(R.id.repeat_icon), r100.f441495m);
        ((AppCompatImageView) this.f441924a.findViewById(R.id.repeat_icon)).setImageDrawable(UDIconUtils.getIconDrawable(this.f441924a.getContext(), R.drawable.ud_icon_repeat_outlined, r167));
        if (r100.f441495m == false) goto L75;
        this.f441930g += (int) UIHelper.sp2px(19.0f);
    L75:
        com.larksuite.framework.section.utils.a.d(this.f441924a.findViewById(R.id.remind_icon), r100.f441494l);
        ((AppCompatImageView) this.f441924a.findViewById(R.id.remind_icon)).setImageDrawable(UDIconUtils.getIconDrawable(this.f441924a.getContext(), R.drawable.ud_icon_bell_outlined, r167));
        if (r100.f441494l == false) goto L78;
        this.f441930g += (int) UIHelper.sp2px(19.0f);
        goto L78
    L71:
        r167 = r166.getEndTimeColor();
        goto L72
    L62:
        if (r100.f441488f != 0) goto L60;
        r116 = false;
        goto L66
    L57:
        ((TaskUDAvatarList) this.f441924a.findViewById(R.id.task_owners)).setVisibility(0);
        ((TaskUDAvatarList) this.f441924a.findViewById(R.id.task_owners)).setAdapter(new k0(r100.f441486d));
        goto L58
    L53:
        r115 = r112.getPaintFlags() & (-17);
        goto L54
    L49:
        r114 = R.color.text_title;
        goto L50
    L45:
        this.f441924a.findViewById(R.id.complete_checkbox_container).setOnClickListener(new h0(r100, this, r105));
        goto L46
    L21:
        r108 = R.drawable.todo_svg_icon_checked_new;
    L23:
        if (r110 == true) goto L30;
        if (r105 == false) goto L30;
        com.ss.android.lark.todo.impl.utils.i r168 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r106 == false) goto L28;
        int r169 = R.drawable.todo_svg_icon_milestone_disable_checked_new;
    L29:
        r109 = r168.c(r169);
        goto L42
    L28:
        r169 = R.drawable.todo_svg_icon_checked_dis_new;
    L30:
        if (r110 == false) goto L37;
        if (r105 == true) goto L37;
        com.ss.android.lark.todo.impl.utils.i r170 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r106 == false) goto L35;
        int r171 = R.drawable.todo_svg_icon_milestone_unchecked;
    L36:
        r109 = r170.c(r171);
        goto L42
    L35:
        r171 = R.drawable.todo_svg_icon_uncheck_new;
    L37:
        com.ss.android.lark.todo.impl.utils.i r172 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r106 == false) goto L40;
        int r173 = R.drawable.todo_svg_icon_milestone_disable;
    L41:
        r109 = r172.c(r173);
        goto L42
    L40:
        r173 = R.drawable.todo_svg_icon_uncheckable_new;
        goto L41
    L11:
        r103 = 0;
        goto L12
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.ShineViewHolder
    public final void X3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f441928e = r100;
    }

    public static final void Y3(TaskItemViewHolder r100, TaskItem r101) {
        r100.getClass();
        if (r101.f441501s == null) goto L6;
        int r102 = com.ss.android.lark.todo.impl.features.common.helper.a.f442447a;
        com.ss.android.lark.todo.impl.features.common.helper.a.a(r100.f441924a.getContext(), r101.f441501s, new q0(r100));
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.ShineViewHolder
    public final void W3(Drawable r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f441929f = r101;
        ((LinearLayout) this.f441924a.findViewById(R.id.container_view)).setBackground(r100);
    }

    public final View b4(TaskItem r100, SwipeType r101) {
        View r102 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r103.setColor(r104.a(R.color.colorful_turquoise));
        r102.setBackground(r103);
        AppCompatImageView r105 = (AppCompatImageView) r102.findViewById(R.id.behind_item_icon);
        SwipeType r106 = SwipeType.RESTORE;
        if (r101 != r106) goto L5;
        int r107 = R.drawable.ud_icon_undo_outlined;
    L6:
        r105.setImageResource(r107);
        TextView r108 = (TextView) r102.findViewById(R.id.behind_item_text);
        if (r101 != r106) goto L9;
        int r109 = R.string.Todo_New_ReopenATask_Button;
    L10:
        r108.setText(r104.g(r109));
        Intrinsics.checkNotNull(r102);
        r102.setOnClickListener(new f(r100, this));
        return r102;
    L9:
        r109 = R.string.Todo_Common_DoneButton;
        goto L10
    L5:
        r107 = R.drawable.ud_icon_done_outlined;
        goto L6
    }

    public final View d4(TaskItem r100, SwipeType r101) {
        switch(b.f441935a[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        View r102 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r103.setColor(r104.a(R.color.ud_O300));
        r102.setBackground(r103);
        ((AppCompatImageView) r102.findViewById(R.id.behind_item_icon)).setImageResource(R.drawable.ud_icon_calendar_date_outlined);
        ((TextView) r102.findViewById(R.id.behind_item_text)).setText(r104.g(R.string.Todo_New_DueTime_Text));
        Intrinsics.checkNotNull(r102);
        r102.setOnClickListener(new m0(this, r100));
        return r102;
    L7:
        View r105 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r106 = new GradientDrawable();
        r106.setShape(0);
        com.ss.android.lark.todo.impl.utils.i r107 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r106.setColor(r107.a(R.color.ud_P300));
        r105.setBackground(r106);
        ((AppCompatImageView) r105.findViewById(R.id.behind_item_icon)).setImageResource(R.drawable.ud_icon_member_outlined);
        ((TextView) r105.findViewById(R.id.behind_item_text)).setText(r107.g(R.string.Todo_New_Owner_Text));
        Intrinsics.checkNotNull(r105);
        r105.setOnClickListener(new n0(this, r100));
        return r105;
    L10:
        View r108 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r109 = new GradientDrawable();
        r109.setShape(0);
        com.ss.android.lark.todo.impl.utils.i r110 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r109.setColor(r110.a(R.color.ud_R400));
        r108.setBackground(r109);
        ((AppCompatImageView) r108.findViewById(R.id.behind_item_icon)).setImageResource(R.drawable.ud_icon_logout_outlined);
        ((TextView) r108.findViewById(R.id.behind_item_text)).setText(r110.g(R.string.Todo_LeaveTask_Button));
        Intrinsics.checkNotNull(r108);
        r108.setOnClickListener(new o0(this, r100));
        return r108;
    L11:
        View r111 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r112 = new GradientDrawable();
        r112.setShape(0);
        com.ss.android.lark.todo.impl.utils.i r113 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r112.setColor(r113.a(R.color.ud_R400));
        r111.setBackground(r112);
        ((TextView) r111.findViewById(R.id.behind_item_text)).setText(r113.g(R.string.Todo_common_Delete));
        ((AppCompatImageView) r111.findViewById(R.id.behind_item_icon)).setImageResource(R.drawable.ud_icon_delete_trash_outlined);
        Intrinsics.checkNotNull(r111);
        r111.setOnClickListener(new l0(this, r100));
        return r111;
    L12:
        View r114 = View.inflate(this.f441924a.getContext(), R.layout.task_behind_item, null);
        GradientDrawable r115 = new GradientDrawable();
        r115.setShape(0);
        r115.setColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.primary_fill_default));
        r114.setBackground(r115);
        Intrinsics.checkNotNull(r114);
        r114.setOnClickListener(new p0(this, r100));
        return r114;
    L5:
        throw new NoWhenBranchMatchedException();
    L16:
        return b4(r100, r101);
    L17:
        return b4(r100, r101);
    }

    public static final void Z3(TaskItemViewHolder r100, TaskItem r101, boolean r102) {
        r100.getClass();
        int r103 = MultiCompleteHelper.f442436a;
        MultiCompleteHelper.g(r100.f441924a.getContext(), new r0(r100, r101, r102));
    }

    public static final void a4(TaskItemViewHolder r100, TaskItem r101, boolean r102) {
        r100.getClass();
        int r103 = MultiCompleteHelper.f442436a;
        MultiCompleteHelper.f(r100.f441924a.getContext(), new s0(r100, r101, r102));
    }

    public TaskItemViewHolder(View r100, u0 r101, ViewGroup r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "parentView");
        Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f441924a = r100;
        this.f441925b = r101;
        this.f441926c = r102;
        this.f441927d = r103;
        this.f441928e = "";
        Paint r104 = new Paint();
        r104.setTextSize(UIHelper.sp2px(14.0f));
        this.f441931h = r104;
        this.f441932i = "";
    }
}
