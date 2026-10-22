package com.larus.chat.search.impl.chat;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.common.view.SearchHistoryItemView;
import com.larus.chat.search.impl.chat.section.SectionListAdapter;
import com.larus.chat.search.impl.databinding.LarusFragmentChatSearchBinding;
import com.larus.common_ui.paging.FPListAdapter;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import ic8.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import tx9.i3;
import tx9.x3;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001L\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\u0002\u0091\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010=\u001a\u00020\u00072\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016JB\u0010?\u001a\u00020\u000728\u0010>\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tH\u0016J\b\u0010N\u001a\u00020\u0007H\u0002J<\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020<2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010W\u001a\u00020\u00072\b\u0010X\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020[H\u0002J\u0018\u0010\\\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010]\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020[2\u0006\u0010^\u001a\u00020\nH\u0002J\u0012\u0010_\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010a\u001a\u0004\u0018\u00010:2\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u000eH\u0016J\u0012\u0010h\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\u000f\u0010i\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0007H\u0002J\u001a\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020:2\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\u001a\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020:2\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010s\u001a\u00020\u0007H\u0016J\b\u0010t\u001a\u00020\u0007H\u0016J\b\u0010u\u001a\u00020\u0007H\u0016J\u0010\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\nH\u0002J\b\u0010z\u001a\u00020\nH\u0002J\u001c\u0010{\u001a\u00020\u00072\b\b\u0002\u0010|\u001a\u00020\u00102\b\b\u0002\u0010}\u001a\u00020\u0010H\u0002J\u0011\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0010H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J#\u0010\u008a\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u008e\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020\u00072\u0007\u0010Z\u001a\u00030\u0090\u0001H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0018\u001a\u0004\bH\u0010IR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/chat/search/api/IChatSearchFragment;", "<init>", "()V", "customCloseAction", "Lkotlin/Function0;", "", "customNavigateAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", CloudControlInf.ROUTE, "Landroid/os/Bundle;", "bundle", "", "binding", "Lcom/larus/chat/search/impl/databinding/LarusFragmentChatSearchBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/chat/search/impl/chat/ChatSearchViewModel;", "getModel", "()Lcom/larus/chat/search/impl/chat/ChatSearchViewModel;", "model$delegate", "Lkotlin/Lazy;", "sectionModel", "Lcom/larus/chat/search/impl/chat/ChatSectionViewModel;", "getSectionModel", "()Lcom/larus/chat/search/impl/chat/ChatSectionViewModel;", "sectionModel$delegate", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "globalSearchResultAdapter", "Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;", "keyword", "keywordId", "lastKeyword", "canSectionRename", "searchInCvsId", "botId", "chatType", "chatPassThroughParams", "Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "getChatPassThroughParams", "()Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "enableSmallWindowTopInsetAdaptation", "getEnableSmallWindowTopInsetAdaptation", "()Z", "imePadding", "", "decorViewRect", "Landroid/graphics/Rect;", "smallWindowPaddingAdaptationRoot", "Landroid/view/View;", "searchResultStartTime", "", "setCloseAction", "action", "setNavigateAction", "sectionListAdapter", "Lcom/larus/chat/search/impl/chat/section/SectionListAdapter;", "currentItemList", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "skipNextSectionResumeRefresh", "searchHistoryRepo", "Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "getSearchHistoryRepo", "()Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "searchHistoryRepo$delegate", "conversationListObserver", "com/larus/chat/search/impl/chat/ChatSearchFragment$conversationListObserver$1", "Lcom/larus/chat/search/impl/chat/ChatSearchFragment$conversationListObserver$1;", "tryHideSoftKeyboard", "openChat", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "localIndex", "messageId", "searchHighlightKeyword", "openSubConversation", "conversationId", "switchConversation", "params", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "openRoute", "getCommonBundle", "pageName", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewStateRestored", "setImeHeightListener", "()Lkotlin/Unit;", "resetPadding", RootDescription.ROOT_ELEMENT, "insets", "Landroidx/core/view/WindowInsetsCompat;", "setupSmallWindowPaddingAdaptation", "clearSmallWindowPaddingAdaptation", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "loadStatus", "Lcom/larus/paging/LoadState;", "setDataSource", "enterMethod", "getQuery", "updateLoadingView", DyPayConstant.KEY_SHOW_LOADING, "showEmpty", "recordClickHistory", "loadHistoryOrSectionList", "init", "clickSearchSection", "data", "clickSubConversation", "loadSectionList", "refreshSectionConversationsOnResume", "loadSearchHistory", "reportItemShow", "index", "reportSectionItemShow", "reportStayTime", "query", "queryId", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSearchFragment extends TraceFragment {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentChatSearchBinding f325454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f325455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f325456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final et3.c f325457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f325458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ChatSearchResultAdapter f325459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f325460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f325461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f325462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f325463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f325464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f325465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f325466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f325467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f325468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f325469t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SectionListAdapter f325470u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<SectionItemData> f325471v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f325472w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f325473x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f325474y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f325475z;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.z<List<? extends wc9.e>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatSearchFragment f325476a;

        public b(ChatSearchFragment r100) {
            this.f325476a = r100;
        }

        @Override // com.larus.im.service.z
        public final void c(List<? extends wc9.e> r210) {
            List<? extends wc9.e> r100 = r210;
            Intrinsics.checkNotNullParameter(r100, "conversation");
            List<SectionItemData> r101 = this.f325476a.f325471v;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L43;
            Iterator r103 = ((ArrayList) this.f325476a.f325471v).iterator();
        L12:
            String r104 = null;
            if (r103.hasNext() == false) goto L21;
            Object r105 = r103.next();
            String r106 = ((SectionItemData) r105).getConversationId();
            wc9.e r107 = (wc9.e) CollectionsKt.getOrNull(r100, 0);
            if (r107 == null) goto L17;
            String r108 = r107.f559198a;
        L19:
            if (Intrinsics.areEqual(r106, r108) == false) goto L12;
        L22:
            SectionItemData r109 = (SectionItemData) r105;
            if (r109 == null) goto L41;
            String r110 = r109.getSectionName();
            wc9.e r111 = (wc9.e) CollectionsKt.getOrNull(r100, 0);
            if (r111 == null) goto L27;
            String r112 = r111.f559200c;
        L29:
            if (Intrinsics.areEqual(r110, r112) == true) goto L44;
            int r113 = ((ArrayList) this.f325476a.f325471v).indexOf(r109);
            ((ArrayList) this.f325476a.f325471v).remove(r109);
            List<SectionItemData> r114 = this.f325476a.f325471v;
            wc9.e r115 = (wc9.e) CollectionsKt.getOrNull(r100, 0);
            if (r115 == null) goto L34;
            r104 = r115.f559200c;
        L34:
            ListProtector.add(r114, r113, SectionItemData.copy$default(r109, 0, null, null, r104, 0, 0, null, false, null, 0, null, 2039, null));
            ChatSearchFragment r116 = this.f325476a;
            SectionListAdapter r117 = r116.f325470u;
            if (r117 == null) goto L42;
            r117.submitList(r116.f325471v);
            return;
        L42:
            return;
        L44:
            return;
        L27:
            r112 = null;
            goto L29
        L41:
            return;
        L17:
            r108 = null;
            goto L19
        L21:
            r105 = null;
            goto L22
        L43:
            return;
        L5:
            if (((ArrayList) r101).isEmpty() == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    public static final class c implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatSearchFragment f325477a;

        @Override // com.larus.chat.search.impl.chat.z
        public final void j() {
            ChatSearchFragment r100 = this.f325477a;
            int r101 = ChatSearchFragment.A;
            r100.ga0();
            this.f325477a.X90().loadConversation(this.f325477a.f325460k, false);
        }

        @Override // com.larus.chat.search.impl.chat.z
        public final void k() {
            ChatSearchFragment r100 = this.f325477a;
            int r101 = ChatSearchFragment.A;
            r100.X90().loadMessage(this.f325477a.f325460k, false);
        }

        public c(ChatSearchFragment r100) {
            this.f325477a = r100;
        }

        @Override // com.larus.chat.search.impl.chat.z
        public final void l(t r210) {
            Intrinsics.checkNotNullParameter(r210, "result");
            wc9.e r100 = r210.f325548c;
            BotModel r101 = r210.f325549d;
            long r102 = r210.f325555j;
            ChatSearchFragment r103 = this.f325477a;
            int r104 = ChatSearchFragment.A;
            r103.Y90().a(this.f325477a.f325460k);
            this.f325477a.ga0();
            String r110 = null;
            if (r210.getType() != 1) goto L5;
            String r105 = r210.f325546a;
        L7:
            if (r210.getType() != 1) goto L9;
            String r106 = r210.f325559n;
        L10:
            this.f325477a.ca0(r100, r101, r102, r105, r106);
            String r111 = IAIChatService.f365899a.U7(r210.f325548c);
            if (r210.getType() != 0) goto L13;
            String r107 = "chat";
        L14:
            String r112 = r107;
            Boolean r108 = r210.f325558m;
            if (r108 != null) goto L18;
        L21:
            i3.e(null, r111, null, null, null, null, null, r112, r110, null, null, this.f325477a, 29693);
            return;
        L18:
            if (Intrinsics.areEqual(r108, Boolean.TRUE) == false) goto L20;
            r110 = "user";
            goto L21
        L20:
            r110 = "bot";
            goto L21
        L13:
            r107 = "chat_history";
            goto L14
        L9:
            r106 = null;
            goto L10
        L5:
            r105 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    public final void ba0() {
        this.f325472w = false;
        LarusFragmentChatSearchBinding r100 = this.f325454e;
        if (r100 == null) goto L7;
        RecyclerView r101 = r100.f325576g;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        LarusFragmentChatSearchBinding r102 = this.f325454e;
        if (r102 == null) goto L12;
        LinearLayout r103 = r102.f325574e;
        if (r103 == null) goto L12;
        r103.removeAllViews();
    L12:
        LarusFragmentChatSearchBinding r104 = this.f325454e;
        if (r104 == null) goto L17;
        ScrollView r105 = r104.f325573d;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
    L17:
        Context r106 = getContext();
        if (r106 != null) goto L20;
        return;
    L20:
        Iterator r107 = ((ArrayList) Y90().f487717d).iterator();
    L22:
        if (r107.hasNext() == false) goto L29;
        final String r108 = (String) r107.next();
        SearchHistoryItemView r109 = new SearchHistoryItemView(r106, null);
        r109.a(r108);
        r109.setOnItemClickListener(new i(this, r108));
        r109.setOnRemoveClickListener(new j(this, r108));
        LarusFragmentChatSearchBinding r110 = this.f325454e;
        if (r110 == null) goto L22;
        LinearLayout r111 = r110.f325574e;
        if (r111 == null) goto L22;
        r111.addView(r109);
        goto L22
    L29:
        if ((!((ArrayList) Y90().f487717d).isEmpty()) == true) goto L31;
        return;
    L31:
        if (((ArrayList) Y90().f487717d).size() <= 2) goto L46;
        LarusFragmentChatSearchBinding r112 = this.f325454e;
        if (r112 == null) goto L47;
        LinearLayout r113 = r112.f325574e;
        if (r113 == null) goto L48;
        TextView r114 = new TextView(getContext());
        r114.setText(r114.getContext().getText(R.string.larus_search_history_clear));
        r114.setTextSize(1, 14.0f);
        r114.setTextColor(ContextCompat.getColor(r114.getContext(), v19.c.b(R.attr.larus_neutral_50, r114.getContext(), R.color.larus_neutral_50)));
        r114.setGravity(17);
        r114.setOnClickListener(new k(this));
        r113.addView(r114, new LinearLayout.LayoutParams(-1, i5.d0()));
        return;
    L48:
        return;
    L47:
        return;
    }

    public final ChatSearchViewModel X90() {
        return (ChatSearchViewModel) this.f325455f.getValue();
    }

    public final hz8.a Y90() {
        return (hz8.a) this.f325473x.getValue();
    }

    public final ChatSectionViewModel Z90() {
        return (ChatSectionViewModel) this.f325456g.getValue();
    }

    public final void ga0() {
        LarusFragmentChatSearchBinding r100 = this.f325454e;
        if (r100 == null) goto L8;
        SearchBar r101 = r100.f325572c;
        if (r101 == null) goto L9;
        ViewExtKt.g(r101);
        return;
    L9:
        return;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        String r100 = this.f325463n;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return "chat_list_search";
    L11:
        return "bot_setting_search";
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        View r100 = this.f325468s;
        if (r100 == null) goto L5;
        ViewCompat.setOnApplyWindowInsetsListener(r100, null);
    L5:
        this.f325468s = null;
        super.onDestroyView();
        ((com.larus.im.service.q) this.f325458i.getValue()).unRegisterConversationChangeListener(this.f325474y);
        this.f325454e = null;
    }

    public ChatSearchFragment() {
        final Function0<Fragment> r100 = new ChatSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f325455f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatSearchViewModel.class), new ChatSearchFragment$special$$inlined$viewModels$default$2(r100), new ChatSearchFragment$special$$inlined$viewModels$default$3(r100, this));
        final Function0<Fragment> r101 = new ChatSearchFragment$special$$inlined$viewModels$default$4(this);
        this.f325456g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatSectionViewModel.class), new ChatSearchFragment$special$$inlined$viewModels$default$5(r101), new ChatSearchFragment$special$$inlined$viewModels$default$6(r101, this));
        this.f325457h = new et3.c("List_ChatSearch", false, null);
        this.f325458i = LazyKt.lazy(new l());
        this.f325459j = new ChatSearchResultAdapter(new c(this));
        this.f325460k = "";
        this.f325467r = new Rect();
        this.f325471v = new ArrayList();
        this.f325473x = LazyKt.lazy(new m(this));
        this.f325474y = new b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        LarusFragmentChatSearchBinding r100 = this.f325454e;
        boolean r101 = false;
        if (r100 == null) goto L9;
        RecyclerView r102 = r100.f325575f;
        if (r102 == null) goto L9;
        if (r102.getVisibility() != 0) goto L9;
        r101 = true;
    L9:
        if (r101 == true) goto L11;
        return;
    L11:
        if (this.f325459j.getItemCount() <= 0) goto L15;
        ea0(this.f325460k, this.f325461l);
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusFragmentChatSearchBinding r100 = this.f325454e;
        if (r100 == null) goto L8;
        RelativeLayout r101 = r100.f325570a;
        if (r101.isAttachedToWindow() == false) goto L7;
        fa0(r101, ViewCompat.getRootWindowInsets(r101));
        goto L8
    L7:
        r101.addOnAttachStateChangeListener(new q(r101, this));
    L8:
        LarusFragmentChatSearchBinding r102 = this.f325454e;
        if (r102 == null) goto L15;
        RecyclerView r103 = r102.f325575f;
        if (r103 == null) goto L15;
        if (r103.getVisibility() != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L21;
        if (this.f325459j.getItemCount() <= 0) goto L21;
        this.f325469t = SystemClock.elapsedRealtime();
    L21:
        if (this.f325470u != null) goto L24;
        return;
    L24:
        if (this.f325472w == false) goto L26;
        this.f325472w = false;
        return;
    L26:
        ChatSectionViewModel.refreshCurrentConversations$default(Z90(), "onResume", false, 2, null);
        return;
    L15:
        r104 = false;
        goto L16
    }

    public static final void U90(ChatSearchFragment r100) {
        r100.X90().updateKeyWord(r100.f325460k);
        if (r100.f325460k.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r100.f325460k) == true) goto L41;
        LarusFragmentChatSearchBinding r102 = r100.f325454e;
        if (r102 == null) goto L15;
        RecyclerView r103 = r102.f325575f;
        if (r103 == null) goto L15;
        y6.i(r103);
    L15:
        LarusFragmentChatSearchBinding r104 = r100.f325454e;
        int r105 = 8;
        if (r104 == null) goto L20;
        ScrollView r106 = r104.f325573d;
        if (r106 == null) goto L20;
        r106.setVisibility(8);
    L20:
        LarusFragmentChatSearchBinding r107 = r100.f325454e;
        if (r107 == null) goto L25;
        RecyclerView r108 = r107.f325576g;
        if (r108 == null) goto L25;
        r108.setVisibility(8);
    L25:
        LarusFragmentChatSearchBinding r109 = r100.f325454e;
        if (r109 == null) goto L33;
        LoadingWithRetryView r110 = r109.f325571b;
        if (r110 == null) goto L33;
        if (Intrinsics.areEqual(null, com.larus.paging.u.b.f363921b) == false) goto L32;
        r105 = 0;
    L32:
        r110.setVisibility(r105);
    L33:
        LarusFragmentChatSearchBinding r111 = r100.f325454e;
        if (r111 == null) goto L38;
        RecyclerView r112 = r111.f325575f;
        if (r112 == null) goto L38;
        r112.setVisibility(0);
    L38:
        ChatSearchResultAdapter r113 = r100.f325459j;
        r113.f325487b = 0;
        r113.submitList(CollectionsKt.emptyList());
        r113.notifyDataSetChanged();
        r100.X90().loadFirstPageData(r100.f325460k, r100.f325463n);
        ha0(r100, true, false, 2);
        return;
    L41:
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.chat.search.impl.chat.a] */
    public final void aa0(boolean r100) {
        ChatSearchResultAdapter r101 = this.f325459j;
        r101.f325487b = 0;
        r101.submitList(CollectionsKt.emptyList());
        r101.notifyDataSetChanged();
        LarusFragmentChatSearchBinding r102 = this.f325454e;
        if (r102 == null) goto L7;
        RecyclerView r103 = r102.f325575f;
        if (r103 == null) goto L7;
        r103.setVisibility(8);
    L7:
        LarusFragmentChatSearchBinding r104 = this.f325454e;
        if (r104 == null) goto L12;
        LoadingWithRetryView r105 = r104.f325571b;
        if (r105 == null) goto L12;
        r105.setVisibility(8);
    L12:
        z2 r106 = z2.f365865a;
        r106.w3();
        r106.w3();
        if (o0.d(this.f325463n) == true) goto L15;
    L32:
        ba0();
        return;
    L15:
        if (this.f325462m == false) goto L32;
        if (r100 == false) goto L22;
        this.f325472w = true;
        ChatSectionViewModel r107 = Z90();
        String r108 = this.f325463n;
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r107.loadFirstData(r108);
    L22:
        LarusFragmentChatSearchBinding r109 = this.f325454e;
        if (r109 == null) goto L27;
        ScrollView r110 = r109.f325573d;
        if (r110 == null) goto L27;
        r110.setVisibility(8);
    L27:
        LarusFragmentChatSearchBinding r111 = this.f325454e;
        if (r111 == null) goto L34;
        RecyclerView r112 = r111.f325576g;
        if (r112 == null) goto L35;
        SectionListAdapter r113 = new SectionListAdapter(new FPListAdapter.a(new com.larus.chat.search.impl.chat.a(this)), new p(this));
        this.f325470u = r113;
        r112.setVisibility(0);
        r112.setItemAnimator(null);
        r112.setAdapter(r113);
        r112.setLayoutManager(new LinearLayoutManager(getContext()));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new ChatSearchFragment$loadSectionList$1$1(this, r113, null));
        r112.addOnScrollListener(new ChatSearchFragment$loadSectionList$1$2(this));
        y6.d(r112, new g(this), null, null, new h(this), 13);
        return;
    L35:
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        r100.putIfNull("query", this.f325460k);
        r100.putIfNull("query_id", this.f325461l);
        r100.putIfNull("function_type", "chat_search");
        if (o0.d(this.f325464o) == false) goto L6;
        r100.putIfNull("bot_id", this.f325464o);
    L6:
        if (o0.d(this.f325465p) == false) goto L9;
        r100.putIfNull("chat_type", this.f325465p);
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("key.search.in.conv.id");
    L6:
        this.f325463n = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        boolean r105 = r104.getBoolean("key.search.in.can.section.rename");
    L10:
        this.f325462m = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        String r107 = r106.getString("key.search.bot.id");
    L14:
        this.f325464o = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L17;
        r102 = r108.getString("key.search.chat.type");
    L17:
        this.f325465p = r102;
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        LarusFragmentChatSearchBinding r101 = this.f325454e;
        if (r101 == null) goto L7;
        SearchBar r102 = r101.f325572c;
        if (r102 == null) goto L7;
        boolean r103 = ViewExtKt.h(r102);
    L8:
        r100.putBoolean("show_ime", r103);
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L14;
        LarusFragmentChatSearchBinding r102 = this.f325454e;
        if (r102 == null) goto L15;
        SearchBar r103 = r102.f325572c;
        if (r103 == null) goto L16;
        r103.b();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r100.getBoolean("show_ime") != true) goto L7;
        r101 = true;
        goto L7
    }

    public static final void V90(ChatSearchFragment r100, ni8.e r101) {
        String r102 = r100.k();
        if (r101.f519356e == true) goto L5;
    L31:
        Integer r103 = r101.f519363l;
        if (r103 != null) goto L35;
    L37:
        x3.a("conversation_click", "chat_search_blocked", "conversation_type=" + r101.f519363l);
        return;
    L35:
        if (r103.intValue() != 3) goto L37;
        Bundle r104 = r100.W90(r101, r102);
        by7.h.k(r104, r100);
        r100.da0("//flow/chat_page", r104);
        return;
    L5:
        if (AccountService.f365697a.a() == true) goto L31;
        int r105 = 0;
        if (l0.a(r101.f519364m) == false) goto L26;
        Bundle r106 = r100.W90(r101, r102);
        ArrayList<Integer> r107 = new ArrayList();
        ConversationPage r108 = r101.f519359h;
        if (r108 == null) goto L13;
        List<Integer> r109 = r108.getPageList();
        if (r109 == null) goto L13;
    L14:
        r107.addAll(r109);
        Unit r110 = Unit.INSTANCE;
        r106.putIntegerArrayList("argument_multi_tab_list", r107);
        ConversationPage r111 = r101.f519359h;
        if (r111 == null) goto L19;
        Integer r112 = r111.getDefaultStatus();
        if (r112 == null) goto L19;
        int r113 = r112.intValue();
    L20:
        r106.putInt("argument_multi_tab_default_tab", r113);
        ConversationPage r114 = r101.f519359h;
        if (r114 == null) goto L25;
        Integer r115 = r114.getPagePosition();
        if (r115 == null) goto L25;
        r105 = r115.intValue();
    L25:
        r106.putInt("argument_multi_tab_title_style", r105);
        by7.h.k(r106, r100);
        r100.da0("//flow/chat_multi_tab", r106);
        return;
    L19:
        r113 = PageType.Chat.getType();
    L13:
        r109 = CollectionsKt.emptyList();
        goto L14
    L26:
        Bundle r116 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r102), TuplesKt.to("argConversationId", r101.f519352a), TuplesKt.to("argClickEnterFrom", r101.f519362k), TuplesKt.to("argBotId", r101.f519361j), TuplesKt.to("argBotType", r101.f519365n), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r101.f519360i)), TuplesKt.to(CommentPublishScene.CONVERSATION_PAGE, r101.f519359h), TuplesKt.to("default_tab", Integer.valueOf(r101.f519358g)), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r101.f519366o)), TuplesKt.to("target_middle_msg_id", r101.f519368q), TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r101.f519368q), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r101.f519369r), TuplesKt.to("search_highlight_keyword", r101.f519370s)});
        Bundle r117 = r100.getArguments();
        if (r117 == null) goto L29;
        ChatPassThroughParams r118 = ic8.k.a(r117);
    L30:
        ic8.k.b(r116, r118);
        by7.h.k(r116, r100);
        r100.da0("//flow/chat_page_double_tab", r116);
        return;
    L29:
        r118 = null;
        goto L30
    }

    public final Bundle W90(ni8.e r100, String r101) {
        Boolean r102 = Boolean.TRUE;
        Bundle r103 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r101), TuplesKt.to("argConversationId", r100.f519352a), TuplesKt.to("argBotId", r100.f519361j), TuplesKt.to("argBotType", r100.f519365n), TuplesKt.to("argClickEnterFrom", r100.f519362k), TuplesKt.to("argCvsBgImgUrl", r100.f519353b), TuplesKt.to("argCvsBgImgColor", r100.f519354c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r100.f519355d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r100.f519360i)), TuplesKt.to("enter_method", "search_result_click"), TuplesKt.to("enter_from", "search_result_click"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r100.f519366o)), TuplesKt.to("target_middle_msg_id", r100.f519368q), TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r100.f519368q), TuplesKt.to("is_single_mode", r102), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r100.f519369r), TuplesKt.to("search_highlight_keyword", r100.f519370s), TuplesKt.to("argBotConversationType", Integer.valueOf(r100.f519373v)), TuplesKt.to("arg_is_from_search", r102)});
        Bundle r104 = getArguments();
        if (r104 == null) goto L5;
        ChatPassThroughParams r105 = ic8.k.a(r104);
    L6:
        ic8.k.b(r103, r105);
        return r103;
    L5:
        r105 = null;
        goto L6
    }

    public final void da0(String r100, Bundle r101) {
        com.bytedance.router.i r102 = SmartRouter.buildRoute(getContext(), r100);
        r102.f267554c.putExtras(r101);
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.d();
    }

    public final void ea0(String r110, String r111) {
        if (this.f325469t != 0) goto L5;
        return;
    L5:
        i3.g(Long.valueOf(SystemClock.elapsedRealtime() - this.f325469t), r110, r111, null, this, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_FRAME_MILLISECOND);
        this.f325469t = 0;
    }

    public final void fa0(View r100, WindowInsetsCompat r101) {
        int r102 = 0;
        if (r101 == null) goto L7;
        Insets r103 = r101.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r103 == null) goto L7;
        int r104 = r103.bottom;
    L8:
        Bundle r105 = getArguments();
        boolean r106 = true;
        if (r105 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        Bundle r108 = getArguments();
        if (r108 != null) goto L17;
    L19:
        r106 = false;
    L20:
        if (r107 == false) goto L23;
        if (r106 == false) goto L23;
    L27:
        int r109 = r100.getPaddingStart();
        int r110 = r100.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r100.getClass().getSimpleName() + ",source:resetPadding,start:" + r109 + ",top:" + r102 + ",end:" + r110 + ",bottom:" + r104);
        r100.setPaddingRelative(r109, r102, r110, r104);
        return;
    L23:
        if (r101 == null) goto L27;
        Insets r111 = r101.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r111 == null) goto L27;
        r102 = r111.top;
        goto L27
    L17:
        if (r108.getBoolean("disable_top_padding", false) != true) goto L19;
    L11:
        if (r105.getBoolean("argIsHalfScreen", false) != true) goto L13;
        r107 = true;
    L7:
        r104 = 0;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.search.impl.chat.n] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        X90().getSearchResultLv().observe(getViewLifecycleOwner(), new s.a(new n(this)));
        final LarusFragmentChatSearchBinding r112 = this.f325454e;
        Boolean r113 = null;
        if (r112 == null) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatSearchFragment$onViewCreated$2$1(r112, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatSearchFragment$onViewCreated$2$2(r112, this, null), 3, null);
        r112.f325575f.setItemAnimator(null);
        r112.f325575f.setLayoutManager(new LinearLayoutManager(getContext()));
        LarusFragmentChatSearchBinding r100 = this.f325454e;
        if (r100 == null) goto L9;
        RecyclerView r101 = r100.f325575f;
        if (r101 == null) goto L9;
        r101.setAdapter(this.f325459j);
    L9:
        r112.f325575f.addOnScrollListener(new ChatSearchFragment$onViewCreated$2$3(r112, this));
        y6.d(r112.f325575f, new o(this), null, null, new com.larus.chat.search.impl.chat.b(this), 13);
        r112.f325571b.a();
    L10:
        Bundle r114 = getArguments();
        boolean r102 = false;
        if (r114 == null) goto L17;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        ChatPassThroughParams r115 = ic8.k.a(r114);
        if (r115 == null) goto L15;
        r113 = Boolean.valueOf(r115.getEnableSmallWindowTopInsetAdaptation());
    L15:
        if (r113 == null) goto L17;
        boolean r116 = r113.booleanValue();
    L23:
        if (r116 == false) goto L34;
        LarusFragmentChatSearchBinding r117 = this.f325454e;
        if (r117 == null) goto L34;
        RelativeLayout r118 = r117.f325570a;
        if (r118 == null) goto L34;
        this.f325468s = r118;
        ViewCompat.setOnApplyWindowInsetsListener(r118, new d(this));
        if (r118.isAttachedToWindow() == false) goto L33;
        ViewCompat.requestApplyInsets(r118);
        goto L34
    L33:
        r118.addOnAttachStateChangeListener(new r(r118));
    L34:
        LarusFragmentChatSearchBinding r119 = this.f325454e;
        if (r119 != null) goto L37;
    L56:
        aa0(true);
        LarusFragmentChatSearchBinding r120 = this.f325454e;
        if (r120 == null) goto L69;
        SearchBar r121 = r120.f325572c;
        if (r121 == null) goto L69;
        String r122 = this.f325463n;
        if (r122 != null) goto L63;
    L64:
        r102 = true;
    L65:
        if (r102 == false) goto L67;
        int r123 = R.string.larus_search_bar_search_chat;
    L68:
        r121.setHint(getString(r123));
        z2.f365865a.w3();
        r121.b();
        r121.setCustomCancelClickAction(new com.larus.chat.search.impl.chat.c(this));
        goto L69
    L67:
        r123 = R.string.larus_search_chat_history;
        goto L68
    L63:
        if (r122.length() != 0) goto L65;
    L69:
        ((com.larus.im.service.q) this.f325458i.getValue()).registerConversationChangeListener(this.f325474y);
        return;
    L37:
        if (Build.VERSION.SDK_INT >= 30) goto L54;
        final FragmentActivity r124 = getActivity();
        if (r124 == null) goto L55;
        Window r125 = r124.getWindow();
        if (r125 == null) goto L55;
        final View r126 = r125.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L48;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L48;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L48:
        if (r126 == null) goto L55;
        View r104 = r126.findViewById(android.R.id.content);
        if (r104 == null) goto L55;
        r104.getViewTreeObserver().addOnGlobalLayoutListener(new e(r126, this, r124));
    L55:
        Unit r127 = Unit.INSTANCE;
        goto L56
    L54:
        ViewExtKt.a(r119.f325570a, new f(this));
    L17:
        Bundle r128 = getArguments();
        if (r128 != null) goto L20;
    L22:
        r116 = false;
        goto L23
    L20:
        if (r128.getBoolean("enable_small_window_top_inset_adaptation", false) != true) goto L22;
        r116 = true;
        goto L23
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_fragment_chat_search, r110, false);
        int r112 = R.id.loading_view;
        LoadingWithRetryView r102 = (LoadingWithRetryView) ViewBindings.findChildViewById(r101, R.id.loading_view);
        if (r102 == null) goto L20;
        r112 = R.id.search_bar;
        SearchBar r103 = (SearchBar) ViewBindings.findChildViewById(r101, R.id.search_bar);
        if (r103 == null) goto L20;
        r112 = R.id.search_history_container;
        ScrollView r104 = (ScrollView) ViewBindings.findChildViewById(r101, R.id.search_history_container);
        if (r104 == null) goto L20;
        r112 = R.id.search_history_list;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.search_history_list);
        if (r105 == null) goto L20;
        r112 = R.id.search_result_list;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.search_result_list);
        if (r106 == null) goto L20;
        r112 = R.id.search_section_list;
        RecyclerView r107 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.search_section_list);
        if (r107 == null) goto L20;
        RelativeLayout r108 = (RelativeLayout) r101;
        this.f325454e = new LarusFragmentChatSearchBinding(r108, r102, r103, r104, r105, r106, r107);
        if (r108 == null) goto L17;
        r108.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r108;
    L17:
        return null;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }

    public static void ha0(ChatSearchFragment r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        LarusFragmentChatSearchBinding r104 = r100.f325454e;
        if (r104 != null) goto L11;
        return;
    L11:
        if (r101 == false) goto L13;
        r104.f325571b.b();
        r104.f325573d.setVisibility(8);
        r104.f325576g.setVisibility(8);
        r104.f325575f.setVisibility(8);
        return;
    L13:
        if (r102 == false) goto L15;
        r104.f325571b.d(Integer.valueOf(R.string.larus_inapp_search_no_result));
        r104.f325575f.setVisibility(8);
        r104.f325573d.setVisibility(8);
        r104.f325576g.setVisibility(8);
        return;
    L15:
        r104.f325575f.setVisibility(0);
        r104.f325571b.setVisibility(8);
        r104.f325573d.setVisibility(8);
        r104.f325576g.setVisibility(8);
        r100.f325469t = SystemClock.elapsedRealtime();
    }

    public final void ca0(wc9.e r110, BotModel r111, long r112, String r210, String r211) {
        if (r110 != null) goto L5;
        return;
    L5:
        ConversationPage r100 = r110.f559204g;
        if (r100 == null) goto L8;
        List<Integer> r101 = r100.getPageList();
    L9:
        boolean r102 = l0.b(r101);
        FLogger r103 = FLogger.f375446a;
        r103.i("ChatSearchFragment", "name is >>> " + r110.f559200c);
        r103.i("ChatSearchFragment", "botConversationType is >>> " + r110.f559219v);
        r103.d("search_landing", "open chat from chat search conversationId=" + r110.f559198a + ", messageId=" + r210 + ", localIndex=" + r112 + ", highlight=" + s.a(r211) + ", query=" + s.a(this.f325460k) + ", isShowTab=" + r102);
        Integer r104 = r110.f559219v;
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        r103.i("ChatSearchFragment", "current conversation is douyin");
        SmartRouter.buildRoute(getContext(), "//flow/douyin_bot").d();
        return;
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatSearchFragment$openChat$1(r110, r111, this, r102, r112, r210, r211, null), 3, null);
        return;
    L13:
        if (r104.intValue() != 4) goto L15;
        r105 = true;
        goto L16
    L8:
        r101 = null;
        goto L9
    }
}
