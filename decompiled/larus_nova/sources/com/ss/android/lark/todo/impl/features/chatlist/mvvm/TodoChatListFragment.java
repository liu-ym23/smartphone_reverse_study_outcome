package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.todo.impl.features.chatlist.adapter.TodoChatListAdapter;
import com.ss.android.lark.todo.impl.features.chatlist.item.TodoDisplayItem;
import com.ss.android.lark.todo.impl.features.chatlist.recyclerView.PinnedHeaderItemDecoration;
import com.ss.android.lark.todo.impl.features.chatlist.recyclerView.PinnedHeaderRecyclerView;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001K\b\u0016\u0018\u0000 m2\u00020\u0001:\u0001mB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0016J&\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u001a\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020N2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010W\u001a\u000208H\u0002J\u0010\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u0002082\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010\\\u001a\u000208H\u0002J\b\u0010]\u001a\u000208H\u0002J\b\u0010^\u001a\u000208H\u0002J\u0010\u0010_\u001a\u0002082\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u000208H\u0002J\u0006\u0010f\u001a\u000208J\b\u0010g\u001a\u000208H\u0002J\b\u0010j\u001a\u000208H\u0002J\b\u0010k\u001a\u000208H\u0002J\b\u0010l\u001a\u000208H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010,8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u0004\u0018\u0001028FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010?\u001a\u0004\bG\u0010HR\u0010\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0004\n\u0002\u0010LR\u001a\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0e0dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "todoLoadingContainerFromXml", "Landroid/widget/RelativeLayout;", "getTodoLoadingContainerFromXml", "()Landroid/widget/RelativeLayout;", "setTodoLoadingContainerFromXml", "(Landroid/widget/RelativeLayout;)V", "todoPtrLayoutFromXml", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "getTodoPtrLayoutFromXml", "()Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "setTodoPtrLayoutFromXml", "(Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;)V", "emptyContainerFromXml", "getEmptyContainerFromXml", "setEmptyContainerFromXml", "todoLottieLoadingAnimFromXml", "Lcom/airbnb/lottie/LottieAnimationView;", "getTodoLottieLoadingAnimFromXml", "()Lcom/airbnb/lottie/LottieAnimationView;", "setTodoLottieLoadingAnimFromXml", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "todoLoadingErrorLlFromXml", "Landroid/widget/LinearLayout;", "getTodoLoadingErrorLlFromXml", "()Landroid/widget/LinearLayout;", "setTodoLoadingErrorLlFromXml", "(Landroid/widget/LinearLayout;)V", "todoListFromXml", "Lcom/ss/android/lark/todo/impl/features/chatlist/recyclerView/PinnedHeaderRecyclerView;", "getTodoListFromXml", "()Lcom/ss/android/lark/todo/impl/features/chatlist/recyclerView/PinnedHeaderRecyclerView;", "setTodoListFromXml", "(Lcom/ss/android/lark/todo/impl/features/chatlist/recyclerView/PinnedHeaderRecyclerView;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "todoChatListAppendViewFromXml", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "getTodoChatListAppendViewFromXml", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "setTodoChatListAppendViewFromXml", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;)V", "createBtFromXml", "Landroid/widget/ImageView;", "getCreateBtFromXml", "()Landroid/widget/ImageView;", "setCreateBtFromXml", "(Landroid/widget/ImageView;)V", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mListAdapter", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter;", "getMListAdapter", "()Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter;", "mListAdapter$delegate", "addCenterAction", "Lcom/ss/android/lark/ui/IActionTitlebar$TextAction;", "getAddCenterAction", "()Lcom/ss/android/lark/ui/IActionTitlebar$TextAction;", "addCenterAction$delegate", "exitAction", "com/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListFragment$exitAction$1", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListFragment$exitAction$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initBackGround", "showActiveConfirmDialog", "todoDisplayItem", "Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem;", "showCompleteConfirmDialog", "initPtrLayout", "initTodoList", "addListScrollListener", "preloadingList", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setAnimationAttr", "refreshListObserver", "Landroidx/lifecycle/Observer;", "", "refreshAdapter", "initListLiveData", "mScrollToTopRunnable", "Ljava/lang/Runnable;", "initTitleBar", "initListener", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoChatListFragment extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f442324s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f442325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIPtrClassicFrameLayout f442326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f442327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LottieAnimationView f442328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f442329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PinnedHeaderRecyclerView f442330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommonTitleBar f442331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public UDShadowLayout f442332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f442333l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f442334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f442335n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f442336o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f442337p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f442338q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f442339r;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.export.offlineCacheClean.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoChatListFragment f442342a;

        @Override // com.ss.android.lark.chat.export.offlineCacheClean.b
        public final void a() {
            Context r100 = this.f442342a.getContext();
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (ForsetiConfig.a(r100) != true) goto L7;
        L8:
            if (r101 == false) goto L10;
            zab.a.a(this.f442342a);
            return;
        L10:
            this.f442342a.finish();
            return;
        L7:
            r101 = false;
            goto L8
        }

        public b(TodoChatListFragment r100) {
            this.f442342a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoChatListFragment f442343a;

        public c(TodoChatListFragment r100) {
            this.f442343a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.LayoutManager r100 = this.f442343a.V90().getLayoutManager();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.scrollToPosition(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoChatListFragment f442344a;

        public d(TodoChatListFragment r100) {
            this.f442344a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List<TodoDisplayItem> r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            TodoChatListFragment r102 = this.f442344a;
            int r103 = TodoChatListFragment.f442324s;
            r102.S90().f442207e.submitList(r101);
        }
    }

    static {
    }

    public final TodoChatListAdapter S90() {
        return (TodoChatListAdapter) this.f442335n.getValue();
    }

    public final TodoChatListViewModel T90() {
        return (TodoChatListViewModel) this.f442334m.getValue();
    }

    public final CommonTitleBar U90() {
        View r100 = this.f442331j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f442331j = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final PinnedHeaderRecyclerView V90() {
        View r100 = this.f442330i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_list);
    L8:
        this.f442330i = (PinnedHeaderRecyclerView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (PinnedHeaderRecyclerView) r100;
    }

    public final RelativeLayout W90() {
        View r100 = this.f442325d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_loading_container);
    L8:
        this.f442325d = (RelativeLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RelativeLayout) r100;
    }

    public final LottieAnimationView X90() {
        View r100 = this.f442328g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_lottie_loading_anim);
    L8:
        this.f442328g = (LottieAnimationView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LottieAnimationView) r100;
    }

    public final LKUIPtrClassicFrameLayout Y90() {
        View r100 = this.f442326e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_ptr_layout);
    L8:
        this.f442326e = (LKUIPtrClassicFrameLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LKUIPtrClassicFrameLayout) r100;
    }

    public TodoChatListFragment() {
        final Function0<Fragment> r100 = new TodoChatListFragment$special$$inlined$viewModels$default$1(this);
        this.f442334m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoChatListViewModel.class), new TodoChatListFragment$special$$inlined$viewModels$default$2(r100), new TodoChatListFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f442335n = LazyKt.lazy(new TodoChatListFragment$mListAdapter$2(this));
        this.f442336o = LazyKt.lazy(new TodoChatListFragment$addCenterAction$2(this));
        this.f442337p = new b(this);
        this.f442338q = new d(this);
        this.f442339r = new c(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        MutableLiveData<List<TodoDisplayItem>> r100 = T90().m8667getTodoChatListItem();
        if (r100 == null) goto L5;
        r100.removeObserver(this.f442338q);
    L5:
        UICallbackExecutor.removeCallbacks(this.f442339r);
        com.ss.android.lark.chat.export.offlineCacheClean.f.a().Ib(this.f442337p);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442325d = null;
        this.f442326e = null;
        this.f442327f = null;
        this.f442328g = null;
        this.f442329h = null;
        this.f442330i = null;
        this.f442331j = null;
        this.f442332k = null;
        this.f442333l = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        U90().setLeftClickListener(new c0(this));
        U90().setLeftImageResource(CommonTitleBarConstants.ICON_BACK);
        U90().setTitle(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_Tasks));
        U90().addAction((IActionTitlebar$TextAction) this.f442336o.getValue());
        View r102 = this.f442332k;
        View r103 = null;
        if (r102 != null) goto L9;
        View r104 = getView();
        if (r104 == null) goto L7;
        r102 = r104.findViewById(R.id.todo_chat_list_append_view);
    L8:
        this.f442332k = (UDShadowLayout) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        Drawable r105 = ((ImageView) ((UDShadowLayout) r102).findViewById(R.id.create_bt)).getDrawable();
        if ((r105 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r106 = (LayerDrawable) r105;
    L13:
        if (r106 == null) goto L19;
        Drawable r107 = r106.findDrawableByLayerId(R.id.add_bold);
        if (r107 == null) goto L19;
        Drawable r108 = r107.mutate();
        if (r108 == null) goto L19;
        r108.setTint(UIUtils.getColor(getContext(), R.color.static_white));
    L19:
        View r109 = this.f442333l;
        if (r109 != null) goto L25;
        View r110 = getView();
        if (r110 == null) goto L24;
        r103 = r110.findViewById(R.id.create_bt);
    L24:
        this.f442333l = (ImageView) r103;
        r109 = r103;
    L25:
        ((ImageView) r109).setOnClickListener(new a0(this));
        ChatWindowPtrLoadingHeader r111 = new ChatWindowPtrLoadingHeader(getContext());
        Y90().setFooterView(r111);
        Y90().addPtrUIHandler(r111);
        Y90().setMode(LKUIPtrFrameLayout.Mode.NONE);
        Y90().setPtrHandler(new b0(this));
        StableLinearLayoutManager r112 = new StableLinearLayoutManager(getContext());
        r112.setOrientation(1);
        V90().setLayoutManager(r112);
        V90().setChatTodoList$todo_productionChinaRelease(true);
        S90().f442206d = new d0(this);
        V90().setAdapter(S90());
        V90().addItemDecoration(new PinnedHeaderItemDecoration());
        T90().m8667getTodoChatListItem().observeForever(this.f442338q);
        T90().m8663getScrollToListTop().observe(this, new y(this));
        T90().m8659getCanFetchMore().observe(this, new z(this));
        RecyclerView.ItemAnimator r113 = V90().getItemAnimator();
        if (r113 == null) goto L28;
        r113.setAddDuration(0);
    L28:
        if (r113 == null) goto L30;
        r113.setChangeDuration(0);
    L30:
        if (r113 == null) goto L32;
        r113.setMoveDuration(0);
    L32:
        if (r113 == null) goto L35;
        r113.setRemoveDuration(0);
    L35:
        if ((r113 instanceof SimpleItemAnimator) == false) goto L37;
        ((SimpleItemAnimator) r113).setSupportsChangeAnimations(false);
    L37:
        V90().addOnScrollListener(new TodoChatListFragment$addListScrollListener$1(this));
        W90().setOnClickListener(new s(this));
        T90().m8660getDataFetchStatus().observe(this, new t(this));
        T90().m8662getNoTodoLabel().observe(this, new u(this));
        T90().m8666getShowToast().observe(this, new v(this));
        T90().m8664getShowActiveDialog().observe(this, new w(this));
        T90().m8665getShowCompleteDialog().observe(this, new x(this));
        T90().initData(getArguments());
        com.ss.android.lark.chat.export.offlineCacheClean.f.a().Wa(this.f442337p);
        return;
    L12:
        r106 = null;
        goto L13
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_chat_list_bg, r101, false);
    }
}
