package com.ss.android.lark.biz.im.api.extension.list;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.scaffold.Component2;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 _*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001_B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\u0016\u0010.\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\u001c\u00106\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020908\u0012\u0004\u0012\u00020907H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u00020(H\u0014J\b\u0010?\u001a\u00020(H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020(H\u0002J\f\u0010E\u001a\u00060Fj\u0002`GH\u0016J\u0010\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020(H\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020(2\u0006\u0010N\u001a\u00020OH\u0016J\u0016\u0010Q\u001a\u00020(2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000RH\u0016J\u0016\u0010S\u001a\u00020(2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000RH\u0016J-\u0010T\u001a\u0004\u0018\u0001HU\"\u000e\b\u0002\u0010U*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010V\u001a\b\u0012\u0004\u0012\u0002HU08H\u0016¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020(H\u0014J\u0016\u0010[\u001a\u00020(2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u0010\u0010]\u001a\u00020(2\u0006\u0010N\u001a\u000205H\u0016J\u0010\u0010^\u001a\u00020(2\u0006\u0010N\u001a\u000205H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR)\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/list/ListComponent;", "VO", "K", "Lcom/ss/android/lark/scaffold/Component2;", "Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/biz/im/api/extension/list/IListViewModel;", "getViewModel", "()Lcom/ss/android/lark/biz/im/api/extension/list/IListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapterProxy", "Lcom/ss/android/lark/biz/im/api/extension/list/IAdapterProxy;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getAdapterProxy", "()Lcom/ss/android/lark/biz/im/api/extension/list/IAdapterProxy;", "adapterProxy$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "refreshLayout", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "getRefreshLayout", "()Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "setRefreshLayout", "(Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;)V", "listAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "getListAdapter", "()Landroidx/recyclerview/widget/ListAdapter;", "setListAdapter", "(Landroidx/recyclerview/widget/ListAdapter;)V", "pendingActionsAfterInit", "", "Lkotlin/Function0;", "", "itemDetector", "Lcom/ss/android/lark/biz/im/api/extension/list/SimpleRecyclerViewItemDetector;", "scrollDispatcher", "Lcom/ss/android/lark/biz/im/api/extension/list/ScrollDispatcherV2;", "onCreateViewModel", "onCreateAdapterProxy", "itemDataKeyProvider", "Lcom/ss/android/lark/biz/im/api/extension/list/ItemDataKeyProvider;", "getItemDataKeyProvider", "()Lcom/ss/android/lark/biz/im/api/extension/list/ItemDataKeyProvider;", "listCommitListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent$ListCommitListener;", "provideComponents", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/scaffold/IComponent;", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_CREATE, "initView", "onCreateLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initRecyclerViewItemDetector", "getActionHandlerManager", "Lcom/ss/android/lark/scaffold/action/ActionManager;", "Lcom/ss/android/lark/biz/im/api/extension/list/action/ActionHandlerManager;", "removeItemDecoration", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "addItemDecoration", "invalidateItemDecorations", "addOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "removeOnScrollListener", "addItemDetectedListener", "Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent$ItemDetectedListener;", "removeItemDetectedListener", "getListViewModel", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/Class;)Lcom/ss/android/lark/biz/im/api/extension/list/IListViewModel;", "getScrollDispatcher", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollDispatcher;", LiveCommonConstants.REASON_ON_DEDTROY, "doAfterInit", "action", "addListCommitListener", "removeListCommitListener", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ListComponent<VO, K> extends Component2 implements IListComponent<VO> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f410153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f410154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Function0<Unit>> f410155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<IListComponent.b> f410156f;

    public static final class a {
    }

    static {
    }

    public abstract com.ss.android.lark.biz.im.api.extension.list.a<VO, ? extends RecyclerView.ViewHolder> b();

    public abstract b<VO> e();

    public final b<VO> a() {
        return (b) this.f410153c.getValue();
    }

    public ListComponent() {
        this.f410153c = LazyKt.lazy(new ListComponent$viewModel$2(this));
        this.f410154d = LazyKt.lazy(new ListComponent$adapterProxy$2(this));
        this.f410155e = new ArrayList();
        new e();
        this.f410156f = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.biz.im.api.extension.list.IListComponent
    public final void Q60(IListComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f410156f.remove(r100);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.list.IListComponent
    public final void uj(IListComponentKt$listCommitFlow$1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f410156f.add(r100);
    }
}
