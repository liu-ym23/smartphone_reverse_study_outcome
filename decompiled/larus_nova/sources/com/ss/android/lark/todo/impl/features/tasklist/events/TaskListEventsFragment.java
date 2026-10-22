package com.ss.android.lark.todo.impl.features.tasklist.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "fragmentContainerFromXml", "Landroid/widget/FrameLayout;", "getFragmentContainerFromXml", "()Landroid/widget/FrameLayout;", "setFragmentContainerFromXml", "(Landroid/widget/FrameLayout;)V", "eventsContainerFromXml", "Landroid/view/View;", "getEventsContainerFromXml", "()Landroid/view/View;", "setEventsContainerFromXml", "(Landroid/view/View;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "viewModelManager", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventModelManager;", "getViewModelManager", "()Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventModelManager;", "viewModelManager$delegate", "Lkotlin/Lazy;", "loadingFragment", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListsEventLoadingFragment;", "isLoadingFragmentShow", "", "onViewCreated", "view", "initLoadingFragment", "taskListEventsViewModel", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsViewModel;", "getTaskListEventsViewModel", "()Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsViewModel;", "taskListEventsViewModel$delegate", "initView", "initTitle", "EventCategory", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskListEventsFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f444032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f444033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonTitleBar f444034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f444035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TaskListsEventLoadingFragment f444036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f444037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f444038j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsFragment$EventCategory;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "TASK_LIST", "TASK", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventCategory extends Enum<EventCategory> {
        public static final a Companion = null;
        public static final EventCategory TASK = null;
        public static final EventCategory TASK_LIST = null;
        public static final EventCategory UNKNOWN = null;
        public static final EventCategory USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventCategory[] f444039a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444040b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<EventCategory> getEntries() {
            return f444040b;
        }

        static {
            EventCategory r100 = new EventCategory("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            EventCategory r101 = new EventCategory(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            EventCategory r102 = new EventCategory("TASK_LIST", 2, 2);
            TASK_LIST = r102;
            EventCategory r103 = new EventCategory("TASK", 3, 3);
            TASK = r103;
            EventCategory[] r104 = {r100, r101, r102, r103};
            f444039a = r104;
            f444040b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static EventCategory[] values() {
            return (EventCategory[]) f444039a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static EventCategory valueOf(String r100) {
            return (EventCategory) r27.a.a(EventCategory.class, r100);
        }

        public EventCategory(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public static final class a {
    }

    public static final class b implements TaskListsEventLoadingFragment.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListEventsFragment f444041a;

        @Override // com.ss.android.lark.todo.impl.features.tasklist.events.TaskListsEventLoadingFragment.a
        public final void reload() {
            ((TaskListEventModelManager) this.f444041a.f444035g.getValue()).loadTaskListEvent(true);
        }

        public b(TaskListEventsFragment r100) {
            this.f444041a = r100;
        }
    }

    static {
    }

    public final FrameLayout S90() {
        View r100 = this.f444032d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.fragment_container);
    L8:
        this.f444032d = (FrameLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (FrameLayout) r100;
    }

    public final CommonTitleBar T90() {
        View r100 = this.f444034f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f444034f = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public TaskListEventsFragment() {
        this.f444035g = LazyKt.lazy(new TaskListEventsFragment$viewModelManager$2(this));
        this.f444036h = new TaskListsEventLoadingFragment(new b(this));
        this.f444037i = true;
        this.f444038j = LazyKt.lazy(new TaskListEventsFragment$taskListEventsViewModel$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f444032d = null;
        this.f444033e = null;
        this.f444034f = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = null;
        int r103 = 0;
        if (isActive() == false) goto L13;
        S90().setVisibility(0);
        TaskListsEventLoadingFragment r104 = this.f444036h;
        if (r104 == null) goto L12;
        FragmentTransaction r105 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.fragment_container) == true) goto L11;
        r105 = r105.add(R.id.fragment_container, r104);
    L11:
        r105.commitAllowingStateLoss();
    L12:
        getChildFragmentManager().executePendingTransactions();
    L13:
        EventCategory.a r106 = EventCategory.Companion;
        Bundle r107 = getArguments();
        if (r107 == null) goto L16;
        r103 = r107.getInt("task_list_event_category", 0);
    L16:
        r106.getClass();
        if (r103 != 0) goto L19;
        EventCategory r108 = EventCategory.UNKNOWN;
    L30:
        if (r108 != EventCategory.TASK) goto L32;
        T90().setTitle(R.string.Todo_Task_Changelog);
    L33:
        T90().setLeftClickListener(new f(this));
        View r109 = this.f444033e;
        if (r109 != null) goto L39;
        View r110 = getView();
        if (r110 == null) goto L38;
        r102 = r110.findViewById(R.id.events_container);
    L38:
        this.f444033e = r102;
        r109 = r102;
    L39:
        ISubView.a.a(new TaskListEventsView(r109, this, getLifecycle(), (TaskListEventsViewModel) this.f444038j.getValue()));
        return;
    L32:
        T90().setTitle(R.string.Todo_Updates_Title);
        goto L33
    L19:
        if (r103 != 1) goto L21;
        r108 = EventCategory.USER;
        goto L30
    L21:
        if (r103 != 2) goto L23;
        r108 = EventCategory.TASK_LIST;
        goto L30
    L23:
        if (r103 == 3) goto L25;
        r108 = EventCategory.UNKNOWN;
        goto L30
    L25:
        r108 = EventCategory.TASK;
        goto L30
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.task_list_events_activity, r101, false);
    }
}
