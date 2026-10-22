package com.ss.android.lark.todo.impl.features.detail.dependent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.emm.design.edittext.SCEditText;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0006\u00105\u001a\u00020#J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\u0006\u0010<\u001a\u00020#R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006>"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "loadingImageFromXml", "Landroid/widget/ImageView;", "getLoadingImageFromXml", "()Landroid/widget/ImageView;", "setLoadingImageFromXml", "(Landroid/widget/ImageView;)V", "taskListsFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getTaskListsFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setTaskListsFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "selectTitleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getSelectTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setSelectTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "searchTextFromXml", "Lcom/suite/lark/emm/design/edittext/SCEditText;", "getSearchTextFromXml", "()Lcom/suite/lark/emm/design/edittext/SCEditText;", "setSearchTextFromXml", "(Lcom/suite/lark/emm/design/edittext/SCEditText;)V", "emptyContainerFromXml", "Landroid/widget/LinearLayout;", "getEmptyContainerFromXml", "()Landroid/widget/LinearLayout;", "setEmptyContainerFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "initLoading", DyPayConstant.KEY_SHOW_LOADING, "", "initRecyclerView", "initTitleBar", "initSearchText", "initViewObserver", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskDependentSearchFragment extends BaseFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f443049j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f443050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f443051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonTitleBar f443052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SCEditText f443053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f443054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f443055i;

    public static final class a {
    }

    static {
    }

    public final LinearLayout S90() {
        View r100 = this.f443054h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.empty_container);
    L8:
        this.f443054h = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final ImageView T90() {
        View r100 = this.f443050d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.loading_image);
    L8:
        this.f443050d = (ImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ImageView) r100;
    }

    public final CommonTitleBar U90() {
        View r100 = this.f443052f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.select_title_bar);
    L8:
        this.f443052f = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final RecyclerView V90() {
        View r100 = this.f443051e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.task_lists);
    L8:
        this.f443051e = (RecyclerView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RecyclerView) r100;
    }

    public final TaskDependentSearchViewModel W90() {
        return (TaskDependentSearchViewModel) this.f443055i.getValue();
    }

    public TaskDependentSearchFragment() {
        final Function0<Fragment> r100 = new TaskDependentSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f443055i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TaskDependentSearchViewModel.class), new TaskDependentSearchFragment$special$$inlined$viewModels$default$2(r100), new TaskDependentSearchFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f443050d = null;
        this.f443051e = null;
        this.f443052f = null;
        this.f443053g = null;
        this.f443054h = null;
    }

    public final void X90(boolean r100) {
        ImageView r101 = T90();
        if (r101 == null) goto L5;
        com.larksuite.framework.section.utils.a.d(r101, r100);
    L5:
        if (r100 == false) goto L9;
        RotateAnimation r102 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r102.setDuration(400);
        r102.setInterpolator(new LinearInterpolator());
        r102.setRepeatCount(-1);
        r102.setRepeatMode(1);
        ImageView r103 = T90();
        if (r103 == null) goto L13;
        r103.startAnimation(r102);
        return;
    L13:
        return;
    L9:
        ImageView r104 = T90();
        if (r104 == null) goto L15;
        r104.clearAnimation();
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        W90().initData(getArguments());
        CommonTitleBar r102 = U90();
        View r103 = null;
        if (r102 == null) goto L9;
        d r104 = new d(this, UIHelper.getString(R.string.Todo_Task_Confirm));
        com.ss.android.lark.todo.impl.utils.i r105 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        Drawable r106 = r105.c(R.drawable.ud_icon_close_outlined);
        if (r106 == null) goto L7;
        r106.setTint(r105.a(R.color.icon_n1));
    L8:
        r102.setLeftImageDrawable(r106);
        r102.setLeftClickListener(new c(this));
        r102.addAction(r104);
        goto L9
    L7:
        r106 = null;
    L9:
        View r107 = this.f443053g;
        if (r107 != null) goto L15;
        View r108 = getView();
        if (r108 == null) goto L14;
        r103 = r108.findViewById(R.id.search_text);
    L14:
        this.f443053g = (SCEditText) r103;
        r107 = r103;
    L15:
        SCEditText r109 = (SCEditText) r107;
        if (r109 == null) goto L18;
        r109.addTextChangedListener(new b(this));
    L18:
        RecyclerView r110 = V90();
        if (r110 == null) goto L21;
        r110.setVisibility(8);
    L21:
        LinearLayoutManager r111 = new LinearLayoutManager(getContext());
        r111.setOrientation(1);
        RecyclerView r112 = V90();
        if (r112 == null) goto L24;
        r112.setLayoutManager(r111);
    L24:
        RecyclerView r113 = V90();
        if (r113 == null) goto L27;
        TaskSearchListAdapter r114 = new TaskSearchListAdapter();
        r114.f443059a = new com.ss.android.lark.todo.impl.features.detail.dependent.a(this);
        r113.setAdapter(r114);
    L27:
        X90(false);
        W90().getDependentTypeLv().observe(this, new e(this));
        W90().isQueryEndLv().observe(this, new f(this));
        W90().getSearchTasksLv().observe(this, new g(this));
        W90().getSelectTasksLv().observe(this, new h(this));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_dependent_select, r101, false);
    }
}
