package com.larus.bmhome.double_post.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.gson.Gson;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import com.larus.bmhome.double_post.AwemeDoublePostInnerPushManager;
import com.larus.bmhome.double_post.adapter.AwemeRecommendAdapter;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.d3;
import com.larus.platform.api.f3;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u0002:\u0004\u0097\u0001\u0098\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020EH\u0002J\u000e\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020\u000eJ\u0006\u0010K\u001a\u00020EJ\u0010\u00108\u001a\u00020E2\b\u0010L\u001a\u0004\u0018\u000109J\u000e\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u00020\u000eJ\u0010\u0010O\u001a\u00020E2\b\u0010:\u001a\u0004\u0018\u00010\u001eJ&\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010V\u001a\u00020E2\u0006\u0010W\u001a\u00020Q2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010X\u001a\u00020E2\u0006\u0010Y\u001a\u00020ZH\u0017J\b\u0010[\u001a\u00020EH\u0002J\u0006\u0010\\\u001a\u00020EJ\u0006\u0010]\u001a\u00020EJ\b\u0010^\u001a\u00020EH\u0002J\b\u0010_\u001a\u00020EH\u0002J\u0016\u0010`\u001a\u00020E2\u000e\u0010a\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010bJ\f\u0010c\u001a\b\u0012\u0004\u0012\u0002020dJ\f\u0010e\u001a\b\u0012\u0004\u0012\u0002020bJ\u000e\u0010f\u001a\u00020E2\u0006\u0010g\u001a\u00020\u001eJ\u0014\u0010h\u001a\u00020E2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002020bJ\u0016\u0010j\u001a\u00020E2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010bJ\u0016\u0010l\u001a\u00020E2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010bJ\u000e\u0010n\u001a\u00020E2\u0006\u0010@\u001a\u00020AJ\u0018\u0010h\u001a\u00020E2\u0006\u0010o\u001a\u00020p2\b\b\u0002\u0010q\u001a\u00020\u000eJ\b\u0010r\u001a\u0004\u0018\u00010sJ\u000e\u0010t\u001a\u00020E2\u0006\u0010u\u001a\u00020\u000eJ\u000e\u0010v\u001a\u00020E2\u0006\u0010w\u001a\u00020\u0010J\b\u0010x\u001a\u00020\u000eH\u0016J\b\u0010y\u001a\u00020\u001eH\u0016J\u0010\u0010z\u001a\u00020E2\u0006\u0010{\u001a\u00020\u001eH\u0016J\u0010\u0010|\u001a\u00020E2\u0006\u0010}\u001a\u00020\u001eH\u0016J\n\u0010~\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010\u007f\u001a\u00020E2\u0006\u0010o\u001a\u00020pH\u0016J\u0017\u0010\u0082\u0001\u001a\u00020E2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0081\u0001J\u0016\u0010\u0085\u0001\u001a\u00020E2\r\u0010@\u001a\t\u0012\u0004\u0012\u00020E0\u0081\u0001J\u0013\u0010\u0086\u0001\u001a\u00020E2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u0012H\u0002J\u0007\u0010\u008a\u0001\u001a\u00020\u0012J\t\u0010\u008b\u0001\u001a\u00020EH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020E2\b\b\u0002\u0010{\u001a\u00020\u001eJ\u0011\u0010\u008d\u0001\u001a\u00020E2\b\b\u0002\u0010{\u001a\u00020\u001eJ\u0019\u0010\u008e\u0001\u001a\u00020E2\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0006\u0010}\u001a\u00020\u001eJ\u0018\u0010\u0091\u0001\u001a\u00020E2\u0006\u0010a\u001a\u0002022\u0007\u0010\u0092\u0001\u001a\u00020\u001eJ\u0007\u0010\u0095\u0001\u001a\u00020EJ\t\u0010\u0096\u0001\u001a\u00020EH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010 R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\f\u001a\u0004\b5\u00106R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\f\u001a\u0004\b=\u0010>R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0014R\u0018\u0010\u0080\u0001\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/video/IAwemeDoublePostFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentAwemeDoublePostBinding;", "viewModel", "Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostViewModel;", "getViewModel", "()Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pageVisible", "", "itemActionListener", "Lcom/larus/bmhome/double_post/adapter/AwemeRecommendViewHolderAction;", "spanCount", "", "getSpanCount", "()I", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "listAdapter", "Lcom/larus/bmhome/double_post/adapter/AwemeRecommendAdapter;", "sortScene", "Lcom/larus/bmhome/video/SortScene;", "getSortScene", "()Lcom/larus/bmhome/video/SortScene;", "recommendType", "", "getRecommendType", "()Ljava/lang/String;", "disableLoadMore", "disableReportShow", "enablePrefetchImage", "hostEnterFrom", "getHostEnterFrom", "useChatWidth", "loadingSpaceHeight", "isLandingTab", "showViewMore", "getShowViewMore", "()Z", "setShowViewMore", "(Z)V", "canShowViewMore", "relatedVideoEnabled", "Ljava/lang/Boolean;", "tempLastData", "Lcom/larus/bmhome/video/Content;", "chatAwemeFeedConfig", "Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "getChatAwemeFeedConfig", "()Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "chatAwemeFeedConfig$delegate", "enterFromMessage", "Lcom/larus/im/bean/message/Message;", "searchId", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "callback", "Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostFragmentCallback;", "mBottomOffsetFourCard", "getMBottomOffsetFourCard", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initParams", "enableLoadMore", "enable", "invalidateSpanAssignments", "message", "setRelatedVideoEnabled", "enabled", "setSearchId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initViews", "dispatchLoadMoreForStaggeredGridLayoutManager", "resetViewMoreStatus", "controlViewVisible", "initViewModel", "setPendingData", "data", "", "getAllData", "", "getUnreadData", "prefetchFirstScreenData", "messageId", "refreshData", "newData", "setReplyItemIdList", "replyItemIdList", "setLastItemIdList", "lastItemIdList", "setCallback", "requestType", "Lcom/larus/bmhome/video/SortRequestType;", "needRetry", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setPageVisible", "visible", "setItemActionListener", "listener", "autoLogEnterPage", "getCurrentPageName", "enterPage", "enterMethod", "leavePage", "leaveMethod", "getLastData", "scrollTopAndRefresh", "attachCallBack", "Lkotlin/Function0;", "setOnAttachCallback", "callBack", "onListTouched", "setOnListTouchedCallback", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getCoverWidth", "getAvailableHeight", "logEnterPage", "trackEnterPage", "trackFeedLoadMore", "trackLeavePage", "pageStayDuration", "", "trackCloseRelatedVideoClick", "status", "mdTimeoutWatchdog", "Lcom/larus/bmhome/double_post/fragment/AwemeDoublePostFragment$CmdTimeoutWatchdog;", "startWatchdog", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "CmdTimeoutWatchdog", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeDoublePostFragment extends TraceFragment implements com.larus.bmhome.video.c {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentAwemeDoublePostBinding f311545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f311546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f311547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FPagingAdapter.a f311548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AwemeRecommendAdapter f311549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f311550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f311551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f311552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f311553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f311554n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f311555o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f311556p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f311557q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Content f311558r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f311559s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Message f311560t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f311561u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f311562v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f311563w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function0<Unit> f311564x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Unit> f311565y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f311566z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f311567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f311568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f311569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f311570d;

        public a() {
            this.f311567a = 10000;
            this.f311568b = new Handler(Looper.getMainLooper());
        }
    }

    public static final class b {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f311571a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f311571a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f311571a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f311571a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final void T90() {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "feed";
    }

    public final void V90() {
        LarusFragmentAwemeDoublePostBinding r100 = this.f311545e;
        if (r100 == null) goto L14;
        TextView r101 = r100.f310892c;
        int r102 = 0;
        if (this.f311555o == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        RecyclerView r104 = r100.f310891b;
        if ((!this.f311555o) == true) goto L12;
        r102 = 8;
    L12:
        r104.setVisibility(r102);
        e1.d(r100.f310892c, new i(this));
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public final int W90() {
        if (e2.f365734a.isPad() == true) goto L5;
    L7:
        int r100 = com.larus.utils.i.d(AppHost.f326268a.getApplication());
    L8:
        Lazy r101 = com.larus.bmhome.video.b.f315193a;
        return com.larus.bmhome.video.b.d(r100, Y90(), 4);
    L5:
        if (this.f311553m == false) goto L7;
        r100 = f3.a.a();
        goto L8
    }

    public final SortScene X90() {
        Message r100 = this.f311560t;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        return SortScene.WelcomeBack;
    L10:
        return SortScene.Recommend;
    L5:
        if (com.larus.bmhome.chat.bean.d.W(r100) != true) goto L7;
        r101 = true;
        goto L7
    }

    public final int Y90() {
        Lazy r100 = com.larus.bmhome.video.b.f315193a;
        return ((Number) com.larus.bmhome.video.b.a().getSecond()).intValue();
    }

    public final AwemeDoublePostViewModel Z90() {
        return (AwemeDoublePostViewModel) this.f311546f.getValue();
    }

    public AwemeDoublePostFragment() {
        final Function0<Fragment> r100 = new AwemeDoublePostFragment$special$$inlined$viewModels$default$1(this);
        this.f311546f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AwemeDoublePostViewModel.class), new AwemeDoublePostFragment$special$$inlined$viewModels$default$2(r100), new AwemeDoublePostFragment$special$$inlined$viewModels$default$3(r100, this));
        FPagingAdapter.a r101 = new FPagingAdapter.a(z2.f365865a.getAwemeVideoFeedConfig().f(), new j(this));
        this.f311548h = r101;
        this.f311549i = new AwemeRecommendAdapter(r101, 0, false, null, 28);
        this.f311559s = LazyKt.lazy(new k());
        this.f311562v = LazyKt.lazy(new l());
        this.f311566z = new a();
    }

    @Override // com.larus.bmhome.video.c
    public final Content iy() {
        if (isAdded() == true) goto L5;
        return null;
    L5:
        if (isDetached() == false) goto L7;
        return null;
    L7:
        if (isRemoving() == false) goto L9;
        return null;
    L9:
        if (this.f311549i.getItemCount() <= 0) goto L15;
        AwemeRecommendAdapter r100 = this.f311549i;
        return r100.A2(r100.getItemCount() - 1);
    L15:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a r100 = this.f311566z;
        r100.f311570d = false;
        o r101 = r100.f311569c;
        if (r101 == null) goto L5;
        r100.f311568b.removeCallbacks(r101);
    L5:
        r100.f311569c = null;
    }

    public static final String U90(AwemeDoublePostFragment r100) {
        r100.getClass();
        int r101 = qr8.a.f534622a;
        Message r102 = r100.f311560t;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (com.larus.bmhome.chat.bean.d.W(r102) != true) goto L7;
    L8:
        if (r103 == false) goto L10;
        return "wcb_feed";
    L10:
        return "chat_feed";
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.larus.bmhome.video.c
    public final void Ko(SortRequestType r100) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (isRemoving() == true) goto L9;
        isDetached();
        return;
    }

    public final void ba0(final List<Content> r110) {
        Intrinsics.checkNotNullParameter(r110, "newData");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L55
        if (isAdded() == true) goto L6;
    L53:
        FLogger.f375446a.w("AwemeDoublePostFragment", "refreshData called on a detached or removing fragment. Aborting.");     // Catch: Throwable -> L55
        return;
    L6:
        if (isDetached() == true) goto L53;
        if (isRemoving() == true) goto L53;
        if (r110.isEmpty() == true) goto L52;
        String r101 = ((Gson) this.f311562v.getValue()).toJson(r110);     // Catch: Throwable -> L55
        if (r101 == null) goto L23;
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L55
        if (r102 == null) goto L23;
        r2 r103 = r102.A0();     // Catch: Throwable -> L55
        if (r103 == null) goto L23;
        Message r104 = this.f311560t;     // Catch: Throwable -> L55
        if (r104 == null) goto L21;
        String r105 = r104.getMessageId();     // Catch: Throwable -> L55
    L22:
        r103.b(r105, r101);     // Catch: Throwable -> L55
        goto L23
    L21:
        r105 = null;
    L23:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L55
        Iterator<T> r107 = r110.iterator();     // Catch: Throwable -> L55
    L25:
        if (r107.hasNext() == false) goto L48;
        Content r108 = (Content) r107.next();     // Catch: Throwable -> L55
        String r109 = r108.getItemId();     // Catch: Throwable -> L55
        boolean r111 = true;
        if (r109 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == false) goto L35;
        pr9.a r113 = null;
    L46:
        if (r113 == null) goto L25;
        r106.add(r113);     // Catch: Throwable -> L55
        goto L25
    L35:
        String r114 = r108.getItemId();     // Catch: Throwable -> L55
        if (r114 != null) goto L38;
        r114 = "";
    L38:
        Integer r115 = r108.getItemType();     // Catch: Throwable -> L55
        int r116 = ItemType.ARTICLE.getValue();     // Catch: Throwable -> L55
        if (r115 != null) goto L42;
    L44:
        r111 = false;
    L45:
        r113 = new pr9.a(r114, r111, 12);     // Catch: Throwable -> L55
        goto L46
    L42:
        if (r115.intValue() != r116) goto L44;
    L29:
        if (r109.length() == 0) goto L32;
        r112 = false;
        goto L33
    L48:
        qr9.c r117 = VideoFeedProviderDelegate.f365695b.b();     // Catch: Throwable -> L55
        if (r117 == null) goto L51;
        r117.b(r106);     // Catch: Throwable -> L55
    L51:
        this.f311558r = (Content) CollectionsKt.lastOrNull(r110);     // Catch: Throwable -> L55
    L52:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L66:
        Z90().resetPageCount();     // Catch: Throwable -> L62
        a r118 = this.f311566z;     // Catch: Throwable -> L62
        r118.f311570d = false;     // Catch: Throwable -> L62
        o r119 = r118.f311569c;     // Catch: Throwable -> L62
        if (r119 == null) goto L60;
        r118.f311568b.removeCallbacks(r119);     // Catch: Throwable -> L62
    L60:
        r118.f311569c = null;     // Catch: Throwable -> L62
        y.c(new m(this, r110));     // Catch: Throwable -> L62
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
        return;
    L62:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L55:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    }

    public final void da0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        LarusFragmentAwemeDoublePostBinding r101 = this.f311545e;
        boolean r102 = true;
        if (r101 == null) goto L12;
        TextView r103 = r101.f310892c;
        if (r103 == null) goto L12;
        if (r103.getVisibility() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 != true) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        return;
    L15:
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        Message r108 = this.f311560t;
        if (r108 != null) goto L18;
    L20:
        r102 = false;
    L21:
        if (r102 == false) goto L23;
        String r109 = "wcb_feed";
    L24:
        r107.put("current_page", r109);
        r107.put("previous_page", "chat");
        Message r110 = this.f311560t;
        String r111 = null;
        if (r110 == null) goto L31;
        String r112 = r110.getMessageId();
        if (r112 == null) goto L31;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L31;
        String r114 = r113.toString();
    L32:
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r114);
        Message r115 = this.f311560t;
        if (r115 == null) goto L35;
        r111 = r115.getReplyId();
    L35:
        r107.put(NoticeInfo.KEY_REPLY_ID, r111);
        r107.put("enter_method", r100);
        Unit r116 = Unit.INSTANCE;
        r106.reportEvent("feed_load_more", r107);
        return;
    L31:
        r114 = null;
        goto L32
    L23:
        r109 = "chat_feed";
        goto L24
    L18:
        if (com.larus.bmhome.chat.bean.d.W(r108) != true) goto L20;
    L9:
        r104 = false;
    L12:
        r105 = false;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        Function0<Unit> r101 = this.f311564x;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        this.f311564x = null;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (e2.f365734a.a(getActivity(), r100) == false) goto L20;
        LarusFragmentAwemeDoublePostBinding r101 = this.f311545e;
        if (r101 == null) goto L16;
        RecyclerView r102 = r101.f310891b;
        if (r102 == null) goto L16;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if (r103 == null) goto L16;
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L13;
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r103;
    L14:
        if (r104 == null) goto L16;
        r104.setSpanCount(Y90());
        goto L16
    L13:
        r104 = null;
    L16:
        AwemeRecommendAdapter r105 = this.f311549i;
        r105.f311398f = W90();
        this.f311549i.notifyDataSetChanged();
        u r106 = this.f311563w;
        if (r106 == null) goto L21;
        r106.b();
        return;
    L21:
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.getBoolean("bundle_key_disable_report_show");
    L6:
        this.f311551k = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        boolean r105 = r104.getBoolean("bundle_key_enable_prefetch_image");
    L10:
        this.f311552l = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        boolean r107 = r106.getBoolean("bundle_key_use_chat_width");
    L14:
        this.f311553m = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L17;
        int r109 = r108.getInt("bundle_key_loading_space_height", i5.d0());
    L18:
        this.f311554n = r109;
        Bundle r110 = getArguments();
        if (r110 == null) goto L21;
        r110.getBoolean("argument_multi_tab_child_is_landing_tab", false);
    L21:
        Bundle r111 = getArguments();
        if (r111 == null) goto L24;
        r102 = r111.getBoolean("bundle_key_show_view_more", false);
    L24:
        this.f311556p = r102;
        this.f311555o = r102;
        Z90().setScene(X90());
        Z90().setPrefetchImage(this.f311552l);
        Z90().setFunctionGetItemIdList(new com.larus.bmhome.double_post.fragment.a(this));
        return;
    L17:
        r109 = i5.d0();
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.larus.bmhome.video.c
    public final void vq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (isDetached() == false) goto L7;
        return;
    L7:
        if (isRemoving() == true) goto L12;
        FLogger.f375446a.i("AwemeDoublePostFragment", "enterPage: enterMethod(" + r100 + ')');
        this.f311547g = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AwemeDoublePostFragment$enterPage$1(null), 3, null);
        return;
    }

    @Override // com.larus.bmhome.video.c
    public final void zW(String r100) {
        Intrinsics.checkNotNullParameter(r100, "leaveMethod");
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (isDetached() == false) goto L7;
        return;
    L7:
        if (isRemoving() == true) goto L12;
        FLogger.f375446a.i("AwemeDoublePostFragment", "leavePage: leaveMethod(" + r100 + ')');
        this.f311547g = false;
        AwemeDoublePostInnerPushManager r101 = AwemeDoublePostInnerPushManager.f311395a;
        d3.f365092a.d();
        return;
    }

    public final void aa0(SortRequestType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Z90().refreshData(r100, true);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void ca0(Content r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "status");
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("video_id", r100.getItemId());
        r103.put("req_id", r100.getRequestId());
        Message r104 = this.f311560t;
        if (r104 == null) goto L9;
        String r105 = r104.getMessageId();
        if (r105 == null) goto L9;
        Long r106 = StringsKt.toLongOrNull(r105);
        if (r106 == null) goto L9;
        String r107 = r106.toString();
    L10:
        r103.put("last_message_id", r107);
        r103.put("status", r101);
        Unit r108 = Unit.INSTANCE;
        r102.reportEvent("close_related_video_status", r103);
        return;
    L9:
        r107 = null;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusFragmentAwemeDoublePostBinding r102 = this.f311545e;
        if (r102 == null) goto L8;
        final RecyclerView r103 = r102.f310891b;
        StaggeredGridLayoutManager r104 = new StaggeredGridLayoutManager(Y90(), 1);
        r104.setGapStrategy(0);
        r103.setLayoutManager(r104);
        Lazy r105 = com.larus.bmhome.video.b.f315193a;
        int r106 = com.larus.bmhome.video.b.b(false);
        r103.setPadding(r106, 0, r106, 0);
        AwemeRecommendAdapter r107 = this.f311549i;
        r107.f311398f = W90();
        this.f311549i.setHasStableIds(true);
        AwemeRecommendAdapter r108 = this.f311549i;
        r108.f311399g = this.f311554n;
        r108.f311403k = new s(this, r103);
        r103.setAdapter(r108);
        if (this.f311551k == true) goto L7;
        Intrinsics.checkNotNull(r103);
        y6.g(r103, new n(this), 1, new com.larus.bmhome.double_post.fragment.b(this));
    L7:
        r103.addOnScrollListener(new AwemeDoublePostFragment$initViews$1$1$5(r103, this));
    L8:
        V90();
        Z90().getAwemeContentList().observe(getViewLifecycleOwner(), new c(new f(this)));
        Z90().getAwemeRefreshList().observe(getViewLifecycleOwner(), new c(new g(this)));
        Z90().getAwemeLoadMoreList().observe(getViewLifecycleOwner(), new c(new h(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_aweme_double_post, r101, false);
        int r104 = R.id.aweme_post_list;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.aweme_post_list);
        if (r105 == null) goto L12;
        r104 = R.id.view_more;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.view_more);
        if (r106 == null) goto L12;
        FrameLayout r107 = (FrameLayout) r103;
        this.f311545e = new LarusFragmentAwemeDoublePostBinding(r107, r105, r106);
        if (r107 == null) goto L9;
        r107.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r107;
    L9:
        return null;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
