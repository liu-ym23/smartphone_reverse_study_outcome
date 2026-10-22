package com.bytedance.lark.lark_biz_feed_android_wrapper;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.g0;
import com.bytedance.lark.lark_biz_feed_android.o;
import com.bytedance.lark.molten_livequery_wrapper.h;
import com.bytedance.lark.view_flow_wrapper.MoltenViewModel;
import com.bytedance.lark.view_flow_wrapper.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u001a\"\b\b\u0000\u0010\u001c*\u00020\u001e\"\b\b\u0001\u0010\u001d*\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0 H\u0016J(\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H!0\u001a\"\b\b\u0000\u0010!*\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016R\u0014\u0010\u0010\u001a\u00020\u0002X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android_wrapper/LarkFeedListViewModel;", "Lcom/bytedance/lark/view_flow_wrapper/MoltenViewModel;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow;", "creator", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ProviderCreator;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListContextWrapped;", "initialAction", "Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;", "(Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ProviderCreator;Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListContextWrapped;Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;)V", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function1;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$Companion;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$Provider;", "Lkotlin/ExtensionFunctionType;", "(Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;Lkotlin/jvm/functions/Function1;)V", "viewFlow", "getViewFlow", "()Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow;", "action", "Lcom/bytedance/lark/view_flow_wrapper/Completable;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowError;", "key", "action-vFDjHp0", "(Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribe", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Item", "KeyChange", "", "liveQueryType", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ViewObjectType$LiveQuery;", "Inner", "objectType", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/ILarkFeedListViewFlow$ViewObjectType$Nullable;", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LarkFeedListViewModel extends MoltenViewModel<ILarkFeedListViewFlow> implements ILarkFeedListViewFlow {
    private final ILarkFeedListViewFlow viewFlow;

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    /* JADX INFO: renamed from: action-vFDjHp0 */
    public Object mo8372actionvFDjHp0(o r100, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r101) {
        return m8373actionvFDjHp0$suspendImpl(this, r100, r101);
    }

    @Override // com.bytedance.lark.view_flow_wrapper.MoltenViewModel
    public /* bridge */ /* synthetic */ i getViewFlow() {
        return getViewFlow();
    }

    @Override // com.bytedance.lark.view_flow_wrapper.MoltenViewModel
    public ILarkFeedListViewFlow getViewFlow() {
        return this.viewFlow;
    }

    public <Inner> i1<Inner> subscribe(ILarkFeedListViewFlow.c.d<Inner> r100) {
        Intrinsics.checkNotNullParameter(r100, "objectType");
        i1<Inner> r101 = subscribe(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<Inner of com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow.subscribe>");
        return r101;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public <Item, KeyChange> i1<h<Item, KeyChange>> subscribe(ILarkFeedListViewFlow.c.C3603c<Item, KeyChange> r100) {
        Intrinsics.checkNotNullParameter(r100, "liveQueryType");
        return getViewFlow().subscribe(r100);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow
    public <Inner> i1<Inner> subscribe(ILarkFeedListViewFlow.c.e<Inner> r100) {
        Intrinsics.checkNotNullParameter(r100, "objectType");
        return getViewFlow().subscribe(r100);
    }

    public LarkFeedListViewModel(o r100, Function1<? super ILarkFeedListViewFlow.Companion, ILarkFeedListViewFlow.a> r101) {
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        ILarkFeedListViewFlow r102 = (ILarkFeedListViewFlow) ((i) r101.invoke(ILarkFeedListViewFlow.f253217w1).f253232a.invoke());
        if (r100 == null) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LarkFeedListViewModel$viewFlow$1$1$1(this, r100, null), 3, null);
    L5:
        this.viewFlow = r102;
    }

    public LarkFeedListViewModel(final ILarkFeedListViewFlow.b r100, final g0 r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r102, new AnonymousClass1(r100, r101));
    }

    /* JADX INFO: renamed from: action-vFDjHp0$suspendImpl, reason: not valid java name */
    public static /* synthetic */ Object m8373actionvFDjHp0$suspendImpl(LarkFeedListViewModel r100, o r101, Continuation<? super com.bytedance.lark.view_flow_wrapper.d<? extends ViewFlowError>> r102) {
        if ((r102 instanceof LarkFeedListViewModel$action$1) == false) goto L7;
        LarkFeedListViewModel$action$1 r103 = (LarkFeedListViewModel$action$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((com.bytedance.lark.view_flow_wrapper.d) r105).f254423a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ILarkFeedListViewFlow r108 = r100.getViewFlow();
        r103.label = 1;
        Object r109 = r108.mo8372actionvFDjHp0(r101, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new LarkFeedListViewModel$action$1(r100, r102);
        goto L8
    }

    public /* synthetic */ LarkFeedListViewModel(o r100, Function1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101);
    }

    public /* synthetic */ LarkFeedListViewModel(ILarkFeedListViewFlow.b r100, g0 r101, o r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
