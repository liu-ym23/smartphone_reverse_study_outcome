package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoFetchStatus;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import com.ss.android.lark.todo.impl.features.common.share.entity.ShareEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u00011\u0018\u0000 E2\u00020\u0001:\u0001EB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u000206H\u0002J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u000206H\u0016J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\b\u0010A\u001a\u000206H\u0002J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b2\u00103¨\u0006F"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/ListView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "view", "Landroid/view/View;", "maskView", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/ListViewState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/ListViewAction;", "<init>", "(Landroid/view/View;Landroid/view/View;Landroidx/fragment/app/Fragment;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getView", "()Landroid/view/View;", "getMaskView", "getFragment", "()Landroidx/fragment/app/Fragment;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "todoRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sectionSortDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "isInUpdateSectionSort", "", "itemListener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$IListClickListener;", "listAdapter", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter;", "getListAdapter", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter;", "listAdapter$delegate", "Lkotlin/Lazy;", "scrollShineLogic", "Lcom/ss/android/lark/todo/impl/features/center/v3/ListScrollShineLogic;", "getScrollShineLogic", "()Lcom/ss/android/lark/todo/impl/features/center/v3/ListScrollShineLogic;", "scrollShineLogic$delegate", "layoutManager", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/StickyLinearLayoutManager;", "getLayoutManager", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/StickyLinearLayoutManager;", "layoutManager$delegate", "itemTouchHelper", "com/ss/android/lark/todo/impl/features/center/v3/view/ListView$itemTouchHelper$2$1", "getItemTouchHelper", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/ListView$itemTouchHelper$2$1;", "itemTouchHelper$delegate", "initViewAction", "", "resetListItemState", "setAnimationAttr", "initViewObserver", "initViewState", "loadingStatus", "status", "Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoFetchStatus;", "startLoading", "loadingFailed", "loadingDeleted", "loadingNoPermission", "showToast", "toastUnit", "Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoListToastUnit;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListView implements ISubView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f441857n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f441859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f441860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lifecycle f441861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SubViewModel<t7c.d, m7c.g> f441862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f441863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDDialog f441864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f441865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v f441866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f441867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f441868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f441869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f441870m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441871a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f441872b = null;

        static {
            int[] r100 = new int[TodoFetchStatus.values().length];
            r100[TodoFetchStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r100[TodoFetchStatus.FIRST_PAGE_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L38:
            r100[TodoFetchStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L28:
            r100[TodoFetchStatus.DELETED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r100[TodoFetchStatus.NO_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L10:
            f441871a = r100;
            int[] r101 = new int[OperationToastHelper.ToastType.values().length];
            r101[OperationToastHelper.ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L24:
            r101[OperationToastHelper.ToastType.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L32:
            r101[OperationToastHelper.ToastType.PROMPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L14:
            f441872b = r101;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f441873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListView f441874b;

        public c(ListView r100) {
            this.f441874b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f441873a;
            long r102 = System.currentTimeMillis();
            this.f441873a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            this.f441874b.f441862e.handleAction(m7c.g.a.f512404a, null);
        }
    }

    public static final class d implements StickyLinearLayoutManager.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441875a;

        @Override // com.ss.android.lark.todo.impl.features.center.v3.view.StickyLinearLayoutManager.a
        public final void b() {
        }

        @Override // com.ss.android.lark.todo.impl.features.center.v3.view.StickyLinearLayoutManager.a
        public final void c() {
        }

        public d(ListView r100) {
            this.f441875a = r100;
        }

        @Override // com.ss.android.lark.todo.impl.features.center.v3.view.StickyLinearLayoutManager.a
        public final void a(RecyclerView.ViewHolder r100) {
            ListView r101 = this.f441875a;
            int r102 = ListView.f441857n;
            if (r101.c() != null) goto L5;
            return;
        L5:
            if ((r100 instanceof SectionItemViewHolder) == false) goto L7;
            SectionItemViewHolder r103 = (SectionItemViewHolder) r100;
        L8:
            if (r103 == null) goto L12;
            SectionItemViewHolder r104 = (SectionItemViewHolder) r100;
            r104.f441893a.findViewById(R.id.divider_todo_item).setVisibility(8);
            View r105 = r104.f441893a;
            r105.setBackground(y9c.d.e(r105.getContext(), R.drawable.todo_main_fragment_title_bg_round));
            return;
        L12:
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    public static final class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441876a;

        public e(ListView r100) {
            this.f441876a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            ListView r102 = this.f441876a;
            int r103 = ListView.f441857n;
            r102.c().y2();
            ((com.ss.android.lark.todo.impl.features.center.v3.c) this.f441876a.f441868k.getValue()).a();
            return false;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441877a;

        public f(ListView r100) {
            this.f441877a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ListView.a(this.f441877a);
            ListView r101 = this.f441877a;
            r101.f441863f.postDelayed(new u(r101, (String) r100), 200);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441878a;

        public g(ListView r100) {
            this.f441878a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            n7c.a r101 = (n7c.a) r100;
            ListView r102 = this.f441878a;
            Intrinsics.checkNotNull(r101);
            int r103 = ListView.f441857n;
            r102.getClass();
            OperationToastHelper.ToastType r104 = r101.getType();
            int r105 = b.f441872b[r104.ordinal()];
            if (r105 != 1) goto L5;
            OperationToastHelper r106 = OperationToastHelper.f442443a;
            OperationToastHelper.f(r102.f441858a.getContext(), r101.f518234a, null, null, null, 124);
            return;
        L5:
            if (r105 != 2) goto L7;
            OperationToastHelper r107 = OperationToastHelper.f442443a;
            OperationToastHelper.b(r102.f441858a.getContext(), r101.f518234a, null, null, null, 60);
            return;
        L7:
            if (r105 != 3) goto L10;
            OperationToastHelper r108 = OperationToastHelper.f442443a;
            OperationToastHelper.c(r102.f441858a.getContext(), r101.f518234a, r101.f518236c, 56);
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441879a;

        public h(ListView r100) {
            this.f441879a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ShareEntity r101 = (ShareEntity) r100;
            int r102 = com.ss.android.lark.todo.impl.features.common.share.helper.a.f442481a;
            Context r103 = this.f441879a.f441858a.getContext();
            Intrinsics.checkNotNull(r101);
            com.ss.android.lark.todo.impl.features.common.share.helper.a.a(r103, r101);
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441880a;

        public i(ListView r100) {
            this.f441880a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            ListView r101 = this.f441880a;
            int r102 = ListView.f441857n;
            r101.c().y2();
            return;
        L5:
            ListView r103 = this.f441880a;
            int r104 = ListView.f441857n;
            r103.c().f283058a.b(false);
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441887a;

        public j(ListView r100) {
            this.f441887a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ListView r102 = this.f441887a;
            int r103 = ListView.f441857n;
            ((com.ss.android.lark.todo.impl.features.center.v3.c) r102.f441868k.getValue()).a();
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441888a;

        public k(ListView r100) {
            this.f441888a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            TodoFetchStatus r111 = (TodoFetchStatus) r110;
            ListView r100 = this.f441888a;
            Intrinsics.checkNotNull(r111);
            int r101 = ListView.f441857n;
            r100.getClass();
            int r112 = b.f441871a[r111.ordinal()];
            if (r112 != 1) goto L5;
            ((RelativeLayout) r100.f441858a.findViewById(R.id.todo_loading_container)).setVisibility(0);
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_lottie_loading_container)).setVisibility(0);
            ((LottieAnimationView) r100.f441858a.findViewById(R.id.todo_lottie_loading_anim)).playAnimation();
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setVisibility(8);
            return;
        L5:
            if (r112 != 2) goto L7;
            ((RelativeLayout) r100.f441858a.findViewById(R.id.todo_loading_container)).setVisibility(0);
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_lottie_loading_container)).setVisibility(8);
            ((LottieAnimationView) r100.f441858a.findViewById(R.id.todo_lottie_loading_anim)).cancelAnimation();
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setVisibility(0);
            ((ImageView) r100.f441858a.findViewById(R.id.todo_error_iv)).setImageResource(R.drawable.illustration_placeholder_common_load_failed);
            ((TextView) r100.f441858a.findViewById(R.id.todo_error_tv)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Lark_Legacy_LoadFailedRetryTip));
            r100.f441858a.findViewById(R.id.todo_loading_error_ll).setOnClickListener(new w(r100));
            return;
        L7:
            if (r112 != 3) goto L9;
            ((RelativeLayout) r100.f441858a.findViewById(R.id.todo_loading_container)).setVisibility(8);
            return;
        L9:
            if (r112 != 4) goto L11;
            ((RelativeLayout) r100.f441858a.findViewById(R.id.todo_loading_container)).setVisibility(0);
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_lottie_loading_container)).setVisibility(8);
            ((LottieAnimationView) r100.f441858a.findViewById(R.id.todo_lottie_loading_anim)).cancelAnimation();
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setVisibility(0);
            ((ImageView) r100.f441858a.findViewById(R.id.todo_error_iv)).setImageResource(R.drawable.illustration_placeholder_common_load_failed);
            ((TextView) r100.f441858a.findViewById(R.id.todo_error_tv)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_ListCard_ListHasBeenDeleted_Empty));
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setOnClickListener(null);
            return;
        L11:
            if (r112 != 5) goto L23;
            ((RelativeLayout) r100.f441858a.findViewById(R.id.todo_loading_container)).setVisibility(0);
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_lottie_loading_container)).setVisibility(8);
            ((LottieAnimationView) r100.f441858a.findViewById(R.id.todo_lottie_loading_anim)).cancelAnimation();
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setVisibility(0);
            ((ImageView) r100.f441858a.findViewById(R.id.todo_error_iv)).setImageResource(R.drawable.illustration_empty_neutral_no_access);
            ((TextView) r100.f441858a.findViewById(R.id.todo_error_tv)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_List_NoPermission_EmptyTitle));
            ((LinearLayout) r100.f441858a.findViewById(R.id.todo_loading_error_ll)).setOnClickListener(null);
            return;
        }
    }

    public static final class l<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441889a;

        public l(ListView r100) {
            this.f441889a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ListView r102 = this.f441889a;
            int r103 = ListView.f441857n;
            r102.c().f441955j = true;
        }
    }

    public static final class m<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441890a;

        public m(ListView r100) {
            this.f441890a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            UDDialog r102 = this.f441890a.f441864g;
            if (r102 == null) goto L21;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r104 == null) goto L18;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L7:
            if (Looper.myLooper() == r103.getLooper()) goto L9;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        }
    }

    public static final class n<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f441891a;

        public n(ListView r100) {
            this.f441891a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.larksuite.framework.section.utils.a.d(this.f441891a.f441858a, !((Boolean) r100).booleanValue());
        }
    }

    static {
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void MD() {
        ListViewModel.b r100 = (ListViewModel.b) this.f441862e.getSubViewEventStore();
        if (r100 == null) goto L6;
        r100.g().observe(this, new f(this));
        r100.j().observe(this, new g(this));
        r100.f().observe(this, new h(this));
        r100.d().observe(this, new i(this));
        r100.c().observe(this, new j(this));
        r100.e().observe(this, new k(this));
        r100.i().observe(this, new l(this));
        r100.b().observe(this, new m(this));
        r100.a().observe(this, new n(this));
        return;
    }

    public final StickyLinearLayoutManager b() {
        return (StickyLinearLayoutManager) this.f441869l.getValue();
    }

    public final TaskListAdapter c() {
        return (TaskListAdapter) this.f441867j.getValue();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void oM() {
        com.larksuite.arch.jack.f.a.h(this, this.f441862e, new ListView$initViewState$1(this));
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void S10() {
        StickyLinearLayoutManager r100 = b();
        d r101 = new d(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.f441905f = r101;
        a0 r102 = r100.f441901b;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r102.f441995g = r101;
    L5:
        this.f441863f.setLayoutManager(b());
        this.f441863f.setAdapter(c());
        View r103 = this.f441859b;
        if (r103 == null) goto L8;
        r103.setOnTouchListener(new e(this));
    L8:
        this.f441863f.addOnScrollListener(new ListView$initViewAction$3(this));
        c().registerAdapterDataObserver(new ListView$initViewAction$4(this));
        ((ListView$itemTouchHelper$2.AnonymousClass1) this.f441870m.getValue()).attachToRecyclerView(this.f441863f);
        ((LinearLayout) this.f441858a.findViewById(R.id.archive_header_layout)).findViewById(R.id.archive_cancel_button).setOnClickListener(new c(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return e();
    }

    public final Lifecycle e() {
        return this.f441861d;
    }

    public static final void a(ListView r100) {
        r100.c().y2();
        ((com.ss.android.lark.todo.impl.features.center.v3.c) r100.f441868k.getValue()).a();
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, com.larksuite.arch.jack.l r102, Function1 r103) {
        return ISubView.a.b(this, r100, r101, r102, r103);
    }

    public ListView(View r100, View r101, Fragment r102, Lifecycle r103, ListViewModel r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r104, "viewModel");
        this.f441858a = r100;
        this.f441859b = r101;
        this.f441860c = r102;
        this.f441861d = r103;
        this.f441862e = r104;
        this.f441863f = (RecyclerView) r100.findViewById(R.id.todo_new_center_list);
        this.f441866i = new v(this);
        this.f441867j = LazyKt.lazy(new ListView$listAdapter$2(this));
        this.f441868k = LazyKt.lazy(new ListView$scrollShineLogic$2(this));
        this.f441869l = LazyKt.lazy(new ListView$layoutManager$2(this));
        this.f441870m = LazyKt.lazy(new ListView$itemTouchHelper$2(this));
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, com.larksuite.arch.jack.l r103, Function1 r104) {
        return ISubView.a.c(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, com.larksuite.arch.jack.l r104, Function1 r105) {
        return ISubView.a.d(this, r100, r101, r102, r103, r104, r105);
    }
}
