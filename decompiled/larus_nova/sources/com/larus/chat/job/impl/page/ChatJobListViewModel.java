package com.larus.chat.job.impl.page;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings;
import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.job.AIJobServiceImpl;
import com.larus.im.service.IAIJobService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\u001aJ8\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0(\u0012\u0004\u0012\u00020\u00140'H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0-2\u0006\u00100\u001a\u00020\u0010H\u0002J4\u00101\u001a\u00020\u00142\f\u00102\u001a\b\u0012\u0004\u0012\u00020.032\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0-H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\"\u001a\u0004\u0018\u00010\u001a*\u00020\u001d2\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "aiJobService", "Lcom/larus/im/service/IAIJobService;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/chat/job/impl/page/ChatJobListUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loader", "Lcom/larus/chat/job/impl/page/ChatJobListLoader;", "isCleared", "", "isLarkEventEnabled", "settingsUpdateListener", "Lkotlin/Function0;", "", EventConstant.Value.RETRY, "refresh", "refreshByPull", "loadMoreLocalJobs", "reason", "", "pauseJob", "job", "Lcom/larus/im/bean/job/AIJob;", "resumeJob", "runJob", "onSuccess", "deleteJob", "resolveRecommendPrompt", "jobTemplateId", "mutateJob", "action", "request", "Lkotlin/Function2;", "Lcom/larus/im/callback/IIMCallback;", ChameleonOpenTracker.Stage.RENDER, "snapshot", "Lcom/larus/chat/job/impl/page/ChatJobListLoadSnapshot;", "buildItems", "", "Lcom/larus/chat/job/impl/page/ChatJobListItem;", "jobs", "showRecommendJobs", "appendSection", "result", "", "key", "title", "isVisibleRecommendJob", "shouldHandleCallback", WikiFolderPushPlugin.OPT, "onCleared", "JobCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobListViewModel extends ViewModel {
    private static final String ACTION_PAUSE = "pause";
    private static final String ACTION_RESUME = "resume";
    private static final a Companion = null;
    private static final int EMPTY_JOB_RESPONSE_CODE = -103;
    private static final String EMPTY_JOB_RESPONSE_TIPS = "data.job is empty";
    private static final int RECOMMEND_STATUS_VISIBLE = 1;
    private static final String TAG = "ChatJobListViewModel";
    private final z0<y> _uiState;
    private final IAIJobService aiJobService;
    private boolean isCleared;
    private boolean isLarkEventEnabled;
    private final ChatJobListLoader loader;
    private final Function0<Unit> settingsUpdateListener;
    private final i1<y> uiState;

    public static final class a {
        public a() {
        }

        public static String c(String r100) {
            String r101 = StringsKt.takeLast(r100, 6);
            if (StringsKt.isBlank(r101) == false) goto L6;
            return "blank";
        L6:
            return r101;
        }

        public static final String a(a r100, AIJob r101) {
            r100.getClass();
            return "id=" + c(r101.getJobId()) + ",type=" + r101.getJobType() + ",status=" + r101.getStatus() + ",contentLength=" + r101.getContent().length() + ",extLength=" + r101.getExt().length();
        }

        public static final String b(a r100, IIMError r101) {
            r100.getClass();
            StringBuilder r102 = new StringBuilder("code=");
            r102.append(r101.getCode());
            r102.append(" tips=");
            r102.append(r101.getTips());
            r102.append(" exception=");
            Throwable r103 = r101.getException();
            if (r103 == null) goto L5;
            String r104 = r103.getClass().getSimpleName();
        L6:
            r102.append(r104);
            return r102.toString();
        L5:
            r104 = null;
            goto L6
        }
    }

    public final class b implements IIMCallback<AIJob> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f325130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AIJob f325131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChatJobListViewModel f325132c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325132c, "mutateJob failure") == true) goto L5;
            return;
        L5:
            FLogger r101 = FLogger.f375446a;
            r101.e(ChatJobListViewModel.TAG, "mutateJob failed action=" + this.f325130a + " source=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.f325131b) + ' ' + a.b(ChatJobListViewModel.access$getCompanion$p(), r100));
            gz8.h.b(r100);
            ChatJobListViewModel.access$getCompanion$p().getClass();
            boolean r102 = false;
            if (r100.getCode() != (-103)) goto L15;
            String r103 = r100.getTips();
            if (r103 != null) goto L10;
        L12:
            boolean r104 = false;
        L13:
            if (r104 == false) goto L15;
            r102 = true;
            goto L15
        L10:
            if (StringsKt.contains$default(r103, ChatJobListViewModel.EMPTY_JOB_RESPONSE_TIPS, false, 2, null) != true) goto L12;
            r104 = true;
        L15:
            if (r102 == false) goto L18;
            ChatJobListLoader r105 = ChatJobListViewModel.access$getLoader$p(this.f325132c);
            String r106 = this.f325130a;
            AIJob r107 = this.f325131b;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "action");
            Intrinsics.checkNotNullParameter(r107, "sourceJob");
            StringBuilder r108 = new StringBuilder("mutateJob empty job response, sync job chain action=");
            r108.append(r106);
            r108.append(" source=");
            int r109 = ChatJobListLoader.f325083t;
            r108.append(ChatJobListLoader.a.c(r107));
            r101.i("ChatJobListLoader", r108.toString());
            r105.f325084a.pullJobChain(100, new x(r106, r105));
            return;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJob r110) {
            AIJob r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "result");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325132c, "mutateJob success") == false) goto L31;
            FLogger.f375446a.i(ChatJobListViewModel.TAG, "mutateJob success action=" + this.f325130a + " source=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.f325131b) + " result=" + a.a(ChatJobListViewModel.access$getCompanion$p(), r111));
            ChatJobListLoader r100 = ChatJobListViewModel.access$getLoader$p(this.f325132c);
            StringBuilder r101 = new StringBuilder("mutate:");
            r101.append(this.f325130a);
            String r102 = r101.toString();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r102, "reason");
            Intrinsics.checkNotNullParameter(r111, "job");
            Iterator<T> r103 = r100.f325089f.iterator();
        L6:
            String r104 = null;
            if (r103.hasNext() == false) goto L11;
            Object r105 = r103.next();
            if (Intrinsics.areEqual(((AIJob) r105).getJobId(), r111.getJobId()) == false) goto L6;
        L12:
            AIJob r106 = (AIJob) r105;
            List<AIJob> r107 = r100.f325089f;
            ArrayList r108 = new ArrayList();
            Iterator<T> r109 = r107.iterator();
        L14:
            if (r109.hasNext() == false) goto L18;
            Object r112 = r109.next();
            if (Intrinsics.areEqual(((AIJob) r112).getJobId(), r111.getJobId()) == true) goto L14;
            r108.add(r112);
            goto L14
        L18:
            List<AIJob> r113 = CollectionsKt.plus(r108, r111);
            FLogger r114 = FLogger.f375446a;
            StringBuilder r115 = new StringBuilder("applyLocalJob reason=");
            r115.append(r102);
            r115.append(" old=");
            int r116 = ChatJobListLoader.f325083t;
            if (r106 == null) goto L21;
            r104 = ChatJobListLoader.a.c(r106);
        L21:
            r115.append(r104);
            r115.append(" new=");
            r115.append(ChatJobListLoader.a.c(r111));
            r115.append(" before=");
            r115.append(ChatJobListLoader.a.b(r100.f325089f));
            r115.append(" after=");
            r115.append(ChatJobListLoader.a.b(r113));
            r114.i("ChatJobListLoader", r115.toString());
            r100.f325089f = r113;
            r100.d();
            return;
        L11:
            r105 = null;
            goto L12
        }

        public b(ChatJobListViewModel r100, String r101, AIJob r102) {
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r102, "sourceJob");
            this.f325132c = r100;
            this.f325130a = r101;
            this.f325131b = r102;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((AIJob) r101).getCreateTime()), Long.valueOf(((AIJob) r100).getCreateTime()));
        }
    }

    public static final class d implements IIMCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatJobListViewModel f325133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIJob f325134b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325133a, "deleteJob failure") == true) goto L5;
            return;
        L5:
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("deleteJob failed jobId=");
            a r103 = ChatJobListViewModel.access$getCompanion$p();
            String r104 = this.f325134b.getJobId();
            r103.getClass();
            r102.append(a.c(r104));
            r102.append(' ');
            r102.append(a.b(ChatJobListViewModel.access$getCompanion$p(), r100));
            r101.e(ChatJobListViewModel.TAG, r102.toString());
            gz8.h.b(r100);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Boolean r100) {
            boolean r101 = r100.booleanValue();
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325133a, "deleteJob success") == false) goto L10;
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("deleteJob success result=");
            r103.append(r101);
            r103.append(" jobId=");
            a r104 = ChatJobListViewModel.access$getCompanion$p();
            String r105 = this.f325134b.getJobId();
            r104.getClass();
            r103.append(a.c(r105));
            r102.i(ChatJobListViewModel.TAG, r103.toString());
            if (r101 == true) goto L9;
            gz8.h.a();
            return;
        L9:
            return;
        }

        public d(ChatJobListViewModel r100, AIJob r101) {
            this.f325133a = r100;
            this.f325134b = r101;
        }
    }

    public static final class e implements IIMCallback<AIJob> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatJobListViewModel f325135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f325136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AIJob f325137c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325135a, "runJob failure") == true) goto L5;
            return;
        L5:
            FLogger.f375446a.e(ChatJobListViewModel.TAG, "runJob failed job=" + a.a(ChatJobListViewModel.access$getCompanion$p(), this.f325137c) + ' ' + a.b(ChatJobListViewModel.access$getCompanion$p(), r100));
            gz8.h.b(r100);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJob r100) {
            AIJob r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (ChatJobListViewModel.access$shouldHandleCallback(this.f325135a, "runJob success") == false) goto L10;
            FLogger.f375446a.i(ChatJobListViewModel.TAG, "runJob success job=" + a.a(ChatJobListViewModel.access$getCompanion$p(), r101));
            Function0<Unit> r102 = this.f325136b;
            if (r102 == null) goto L9;
            r102.invoke();
            return;
        L9:
            return;
        }

        public e(ChatJobListViewModel r100, Function0<Unit> r101, AIJob r102) {
            this.f325135a = r100;
            this.f325136b = r101;
            this.f325137c = r102;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(ChatJobListViewModel r100, AIJob r101, String r102, IIMCallback r103) {
        return pauseJob$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ String No(ChatJobListViewModel r100, String r101, i.a r102) {
        return resolveRecommendPrompt$lambda$5(r100, r101, r102);
    }

    public static /* synthetic */ boolean Oo(i.a r100) {
        return resolveRecommendPrompt$lambda$4(r100);
    }

    public static /* synthetic */ Unit Po(ChatJobListViewModel r100) {
        return settingsUpdateListener$lambda$0(r100);
    }

    public static /* synthetic */ Unit yo(ChatJobListViewModel r100, AIJob r101, String r102, IIMCallback r103) {
        return resumeJob$lambda$2(r100, r101, r102, r103);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.isCleared = true;
        z2.f365865a.p3(this.settingsUpdateListener);
        this.aiJobService.unregisterObserver(this.loader);
        super.onCleared();
    }

    public final void refresh() {
        this.loader.k(false);
    }

    public final void refreshByPull() {
        ChatJobListLoader r100 = this.loader;
        if (r100.c().f325383b == false) goto L5;
    L8:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("pull refresh skipped loading=");
        r102.append(r100.c().f325383b);
        r102.append(" pullRefreshRequests=");
        Set<? extends AIJobRequestType> r103 = r100.f325094k;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(((AIJobRequestType) r105.next()).name());
        goto L10
    L12:
        r102.append(r104);
        r101.i("ChatJobListLoader", r102.toString());
        return;
    L5:
        if ((!r100.f325094k.isEmpty()) == true) goto L8;
        r100.k(true);
    }

    public final void retry() {
        this.loader.k(false);
    }

    public ChatJobListViewModel() {
        int r100 = com.larus.im.d.f347134a;
        AIJobServiceImpl r101 = AIJobServiceImpl.INSTANCE;
        this.aiJobService = r101;
        StateFlowImpl r102 = j1.a(new y(0));
        this._uiState = r102;
        this.uiState = r102;
        ChatJobListLoader r103 = new ChatJobListLoader(r101, new ChatJobListViewModel$loader$1(this));
        this.loader = r103;
        int r104 = g0.f325370a;
        ChatJobLarkEventSettings.f325056a.getClass();
        this.isLarkEventEnabled = ChatJobLarkEventSettings.a();
        Function0<Unit> r105 = new c0(this);
        this.settingsUpdateListener = r105;
        r101.registerObserver(r103);
        z2.f365865a.i2(r105);
        r103.k(false);
    }

    public static final /* synthetic */ a access$getCompanion$p() {
        return Companion;
    }

    public final i1<y> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ ChatJobListLoader access$getLoader$p(ChatJobListViewModel r100) {
        return r100.loader;
    }

    private final boolean isVisibleRecommendJob(AIJob r100) {
        if (r100.getStatus() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void render(j r100) {
        if (this.isCleared == false) goto L5;
        return;
    L5:
        List<i> r101 = buildItems(r100.f325382a, r100.f325386e);
        z0<y> r102 = this._uiState;
        boolean r103 = r100.f325383b;
        boolean r104 = r100.f325384c;
        if (r103 == true) goto L11;
        if (r104 == true) goto L11;
        if (r101.isEmpty() == false) goto L11;
        boolean r105 = true;
    L12:
        r102.setValue(new y(r101, r103, r104, r105, r100.f325385d));
        return;
    L11:
        r105 = false;
        goto L12
    }

    private static final boolean resolveRecommendPrompt$lambda$4(i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.f325376b;
    }

    private static final Unit settingsUpdateListener$lambda$0(ChatJobListViewModel r100) {
        if (r100.isCleared == true) goto L8;
        int r101 = g0.f325370a;
        ChatJobLarkEventSettings.f325056a.getClass();
        boolean r102 = ChatJobLarkEventSettings.a();
        if (r100.isLarkEventEnabled == r102) goto L8;
        r100.isLarkEventEnabled = r102;
        FLogger.f375446a.i(TAG, "lark event settings changed enabled=" + r102);
        r100.loader.d();
    L8:
        return Unit.INSTANCE;
    }

    private final boolean shouldHandleCallback(String r100) {
        if (this.isCleared == true) goto L6;
        return true;
    L6:
        FLogger.f375446a.i(TAG, "skip " + r100 + " callback after onCleared");
        return false;
    }

    public final void deleteJob(AIJob r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        if (g0.c(r100) == true) goto L6;
        FLogger.f375446a.i(TAG, "deleteJob skipped: unavailable task type=" + r100.getJobType());
        return;
    L6:
        FLogger.f375446a.i(TAG, "deleteJob job=" + a.a(Companion, r100));
        this.aiJobService.deleteJob(r100.getJobId(), r100.getJobType(), new d(this, r100));
    }

    public final void loadMoreLocalJobs(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        ChatJobListLoader r100 = this.loader;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "reason");
        boolean r101 = r100.f325086c;
        if (r101 == true) goto L5;
    L20:
        boolean r102 = false;
    L21:
        if (r102 == false) goto L23;
        r100.i(r110);
        return;
    L23:
        if (r101 == true) goto L25;
        return;
    L25:
        if (r100.f325087d == false) goto L27;
        return;
    L27:
        if (r100.f325092i == true) goto L29;
        return;
    L29:
        if (r100.f325090g == true) goto L47;
        ChatJobListLoader.b r103 = r100.f325093j;
        String r104 = null;
        if (r103 == null) goto L37;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("loadMoreLocalJobs query jobType=");
        r106.append(r103.f325103a);
        r106.append(" status=");
        r106.append(r103.f325104b);
        r106.append(" anchorCreateTime=");
        r106.append(r103.f325105c);
        r106.append(" anchorJobId=");
        String r107 = r103.f325106d;
        if (r107 == null) goto L36;
        int r108 = ChatJobListLoader.f325083t;
        r104 = ChatJobListLoader.a.e(r107);
    L36:
        r106.append(r104);
        r105.i("ChatJobListLoader", r106.toString());
    L38:
        if (r103 != null) goto L40;
        r100.f325092i = false;
        FLogger.f375446a.i("ChatJobListLoader", "loadMoreLocalJobs skipped, no anchor reason=" + r110);
        return;
    L40:
        r100.f325090g = true;
        r100.h(r110, r103, true, true, true, null);
        return;
    L37:
        r103 = null;
        goto L38
    L47:
        return;
    L5:
        if (r100.f325087d == true) goto L20;
        if (r100.f325092i == true) goto L20;
        if (r100.f325090g == true) goto L20;
        if (r100.f325097n == true) goto L13;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L20;
        r102 = true;
        goto L21
    L13:
        if (r100.f325098o == true) goto L17;
        if (r100.f325099p == true) goto L17;
        r109 = true;
        goto L18
    }

    public final void pauseJob(final AIJob r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        mutateJob("pause", r100, new z(this, r100));
    }

    public final String resolveRecommendPrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jobTemplateId");
        final String r101 = StringsKt.trim(r100).toString();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L12;
        return null;
    L12:
        Sequence r103 = SequencesKt.filter(CollectionsKt.asSequence(this._uiState.getValue().f325402a), ChatJobListViewModel$resolveRecommendPrompt$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(r103, new a0()), new b0(this, r101)));
    L5:
        r102 = false;
        goto L7
    }

    public final void resumeJob(final AIJob r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        mutateJob(ACTION_RESUME, r100, new d0(this, r100));
    }

    public static final /* synthetic */ void access$render(ChatJobListViewModel r100, j r101) {
        r100.render(r101);
    }

    public static final /* synthetic */ boolean access$shouldHandleCallback(ChatJobListViewModel r100, String r101) {
        return r100.shouldHandleCallback(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.chat.job.impl.page.ChatJobListViewModel] */
    private final List<i> buildItems(List<AIJob> r110, boolean r111) {
        List<AIJob> r112 = r110;
        int r100 = g0.f325370a;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r112.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (g0.c((AIJob) r103) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList();
        Iterator r113 = r112.iterator();
    L9:
        boolean r105 = false;
        if (r113.hasNext() == false) goto L16;
        Object r106 = r113.next();
        if (((AIJob) r106).getJobType() != 2) goto L14;
        r105 = true;
    L14:
        if (r105 == false) goto L9;
        r104.add(r106);
        goto L9
    L16:
        if (r111 == false) goto L23;
        ?? r114 = new ArrayList();
        Iterator r115 = r104.iterator();
    L19:
        if (r115.hasNext() == false) goto L24;
        Object r107 = r115.next();
        if (isVisibleRecommendJob((AIJob) r107) == false) goto L19;
        r114.add(r107);
    L24:
        ArrayList r116 = new ArrayList();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r101.iterator();
    L26:
        if (r109.hasNext() == false) goto L36;
        Object r117 = r109.next();
        AIJob r118 = (AIJob) r117;
        if (r118.getStatus() != 1) goto L30;
    L33:
        boolean r119 = true;
    L34:
        if (r119 == false) goto L26;
        r108.add(r117);
        goto L26
    L30:
        if (r118.getStatus() == (-1)) goto L33;
        r119 = false;
        goto L34
    L36:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r101.iterator();
    L38:
        if (r121.hasNext() == false) goto L45;
        Object r122 = r121.next();
        if (((AIJob) r122).getStatus() != 2) goto L42;
        boolean r123 = true;
    L43:
        if (r123 == false) goto L38;
        r120.add(r122);
        goto L38
    L42:
        r123 = false;
        goto L43
    L45:
        ArrayList r124 = new ArrayList();
        Iterator r125 = r101.iterator();
    L47:
        if (r125.hasNext() == false) goto L54;
        Object r126 = r125.next();
        if (((AIJob) r126).getStatus() != 3) goto L51;
        boolean r127 = true;
    L52:
        if (r127 == false) goto L47;
        r124.add(r126);
        goto L47
    L51:
        r127 = false;
        goto L52
    L54:
        appendSection(r116, "running", gz8.f.b("scheduledTasks_header_ongoing"), r108);
        appendSection(r116, "paused", gz8.f.b("scheduledTasks_header_paused"), r120);
        appendSection(r116, "completed", gz8.f.b("scheduledTasks_header_completed"), r124);
        appendSection(r116, "recommend", gz8.f.b("scheduledTasks_header_recommended"), r114);
        return r116;
    L23:
        r114 = CollectionsKt.emptyList();
        goto L24
    }

    private final String resolveRecommendPrompt(AIJob r100, String r101) {
        boolean r102 = true;
        if (r100.getStatus() == 1) goto L29;
        return null;
    L29:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100.getContent()));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r104) == false) goto L12;
        r104 = null;
    L12:
        JSONObject r105 = (JSONObject) r104;
        if (r105 == null) goto L31;
        JSONObject r106 = r105.optJSONObject("recommend_job");
        if (r106 == null) goto L32;
        String r107 = r106.optString(Ext.KEY_JOB_ID);
        if (StringsKt.isBlank(r107) == false) goto L20;
        r107 = r100.getJobId();
    L20:
        if (Intrinsics.areEqual(r107, r101) == true) goto L22;
        return null;
    L22:
        String r108 = StringsKt.trim(r106.optString(EventConstant.Key.RETAIN_PROMPT)).toString();
        if (r108.length() > 0) goto L26;
        r102 = false;
    L26:
        if (r102 == true) goto L28;
        return null;
    L28:
        return r108;
    L32:
        return null;
    L31:
        return null;
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void runJob(AIJob r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "job");
        if (r100.getJobType() == 1) goto L6;
        FLogger.f375446a.i(TAG, "runJob skipped: unsupported type=" + r100.getJobType());
        return;
    L6:
        FLogger.f375446a.i(TAG, "runJob request job=" + a.a(Companion, r100) + " currentStatuses=" + ChatJobListLoader.a.b(this.loader.f325089f));
        this.aiJobService.runJob(r100.getJobId(), new e(this, r101, r100));
    }

    private final void mutateJob(String r100, AIJob r101, Function2<? super String, ? super IIMCallback<AIJob>, Unit> r102) {
        if (g0.c(r101) == true) goto L6;
        FLogger.f375446a.i(TAG, "mutateJob skipped: unavailable task type=" + r101.getJobType());
        return;
    L6:
        FLogger.f375446a.i(TAG, "mutateJob request action=" + r100 + " job=" + a.a(Companion, r101) + " currentStatuses=" + ChatJobListLoader.a.b(this.loader.f325089f));
        r102.invoke(r101.getJobId(), new b(this, r100, r101));
    }

    private static final String resolveRecommendPrompt$lambda$5(ChatJobListViewModel r100, String r101, i.a r102) {
        Intrinsics.checkNotNullParameter(r102, "it");
        return r100.resolveRecommendPrompt(r102.f325375a, r101);
    }

    private final void appendSection(List<i> r100, String r101, String r102, List<AIJob> r103) {
        if (r103.isEmpty() == false) goto L5;
        return;
    L5:
        List<i> r104 = r100;
        r104.add(new i.b(r101, r102));
        List r105 = CollectionsKt.sortedWith(r103, new c());
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        r106.add(new i.a((AIJob) r107.next(), Intrinsics.areEqual(r101, "recommend")));
        goto L7
    L9:
        CollectionsKt.addAll(r104, r106);
    }

    private static final Unit pauseJob$lambda$1(ChatJobListViewModel r100, AIJob r101, String r102, IIMCallback r103) {
        Intrinsics.checkNotNullParameter(r102, "jobId");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r100.aiJobService.pauseJob(r102, r101.getJobType(), r103);
        return Unit.INSTANCE;
    }

    private static final Unit resumeJob$lambda$2(ChatJobListViewModel r100, AIJob r101, String r102, IIMCallback r103) {
        Intrinsics.checkNotNullParameter(r102, "jobId");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r100.aiJobService.resumeJob(r102, r101.getJobType(), r103);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runJob$default(ChatJobListViewModel r100, AIJob r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.runJob(r101, r102);
    }
}
