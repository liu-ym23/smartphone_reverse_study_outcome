package com.larus.project;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniGetProjectRequest;
import com.larus.im.internal.jni.bean.OmniGetProjectSource;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.larus.im.internal.jni.bean.OmniSelectConversationGroupRequest;
import com.larus.im.internal.jni.bean.OmniSelectProjectListOrderByIndexRequest;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004*\u0001\u0017\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\fH\u0016J \u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0096@¢\u0006\u0004\b!\u0010\"J\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0016J\u001c\u0010*\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0082@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020$H\u0082@¢\u0006\u0002\u0010\"J\b\u00100\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\fH\u0002J\u001a\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00152\b\b\u0002\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010;J\"\u0010<\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0,H\u0082@¢\u0006\u0002\u0010.J\u0012\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001c0,*\u000208H\u0002J \u0010?\u001a\u00020$*\b\u0012\u0004\u0012\u00020\u001c0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0,H\u0002J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0,*\b\u0012\u0004\u0012\u00020\u001c0,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006D"}, d2 = {"Lcom/larus/project/ProjectListDataSourceImpl;", "Lcom/larus/bmhome/taskskill/service/IProjectListDataSource;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadMutex", "Lkotlinx/coroutines/sync/Mutex;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/taskskill/service/IProjectListDataSource$Listener;", "currentSnapshot", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "currentUserId", "", "currentCursor", "", "conversationSortType", "Lcom/larus/im/internal/jni/bean/OmniConversationSortType;", "loadGeneration", "hasLoadedSecondPage", "", "projectChangeListener", "com/larus/project/ProjectListDataSourceImpl$projectChangeListener$1", "Lcom/larus/project/ProjectListDataSourceImpl$projectChangeListener$1;", "getList", "getProject", "Lkotlin/Result;", "Lcom/larus/bmhome/taskskill/service/ProjectListItem;", "projectId", "getProject-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DitoNode.LOAD_MORE, "loadMore-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "updateConversationSortType", "sortType", "registerListener", "listener", "unregisterListener", "mergeChangedProjectsIntoMemory", "changedProjects", "", "Lcom/larus/im/internal/jni/bean/OmniProject;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLoadedRange", "ensureCurrentUser", "updateSnapshot", "snapshot", "pageSize", "isFirstPage", "isFirstLoadMore", "projectConversationFirstPageRequestLimit", "queryProjectPage", "Lcom/larus/project/ProjectListPage;", EffectConfiguration.KEY_CURSOR, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "(IILcom/larus/im/internal/jni/bean/OmniConversationSortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProjects", "projectIds", "toProjectListItems", "mergePageItems", "", "newItems", "sortedByProjectOrder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProjectListDataSourceImpl implements IProjectListDataSource {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f366962j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f366963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f366964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<IProjectListDataSource.a> f366965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile com.larus.bmhome.taskskill.service.i f366966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f366967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f366968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OmniConversationSortType f366969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f366970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f366971i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final com.larus.bmhome.taskskill.service.i getList() {
        if (Intrinsics.areEqual(this.f366967e, AccountService.f365697a.getUserId()) == false) goto L6;
        return this.f366966d;
    L6:
        return new com.larus.bmhome.taskskill.service.i(false, 7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.project.ProjectListDataSourceImpl$projectChangeListener$1] */
    public ProjectListDataSourceImpl() {
        this.f366963a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f366964b = kotlinx.coroutines.sync.b.a();
        this.f366965c = new CopyOnWriteArraySet();
        this.f366966d = new com.larus.bmhome.taskskill.service.i(false, 7);
        this.f366968f = Integer.MAX_VALUE;
        this.f366969g = OmniConversationSortType.OmniConversationSortType_UPDATE_TIME;
        ?? r100 = new ProjectListDataSourceImpl$projectChangeListener$1(this);
        com.larus.im.service.v.f350892a.getClass();
        com.larus.im.service.v.a.a().b(r100);
    }

    public static final void g(ProjectListDataSourceImpl r100) {
        r100.getClass();
        String r101 = AccountService.f365697a.getUserId();
        if (Intrinsics.areEqual(r100.f366967e, r101) == true) goto L7;
        r100.f366967e = r101;
        r100.f366968f = Integer.MAX_VALUE;
        r100.f366966d = new com.larus.bmhome.taskskill.service.i(false, 7);
        r100.f366971i = false;
        return;
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final Object a(Continuation<? super Unit> r100) {
        Object r101 = o(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final void b(IProjectListDataSource.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f366965c.remove(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final void c(IProjectListDataSource.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f366965c.add(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final Object d(Continuation<? super Result<com.larus.bmhome.taskskill.service.i>> r100) {
        if ((r100 instanceof ProjectListDataSourceImpl$loadMore$1) == false) goto L7;
        ProjectListDataSourceImpl$loadMore$1 r101 = (ProjectListDataSourceImpl$loadMore$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L19;
        if (r105 != 1) goto L18;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13 CancellationException -> L15
    L23:
    L30:
        return Result.m9449constructorimpl((com.larus.bmhome.taskskill.service.i) r103);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r103);
        MainCoroutineDispatcher r106 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L13 CancellationException -> L15
        ProjectListDataSourceImpl$loadMore$snapshot$1 r107 = new ProjectListDataSourceImpl$loadMore$snapshot$1(this, null);     // Catch: Throwable -> L13 CancellationException -> L15
        r101.label = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r103 != r104) goto L23;
        return r104;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        FLogger.f375446a.e("ProjectListDataSource", "loadMore failed cursor=" + this.f366968f, th);
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new ProjectListDataSourceImpl$loadMore$1(this, r100);
        goto L8
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final void e(OmniConversationSortType r100) {
        Intrinsics.checkNotNullParameter(r100, "sortType");
        if (this.f366969g != r100) goto L5;
        return;
    L5:
        this.f366969g = r100;
        if (this.f366966d.f314451c == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(this.f366963a, null, null, new ProjectListDataSourceImpl$updateConversationSortType$1(this, null), 3, null);
    }

    public final Object o(Continuation<? super Unit> r100) {
        if ((r100 instanceof ProjectListDataSourceImpl$refreshLoadedRange$1) == false) goto L7;
        ProjectListDataSourceImpl$refreshLoadedRange$1 r101 = (ProjectListDataSourceImpl$refreshLoadedRange$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L19;
        if (r105 != 1) goto L18;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13 CancellationException -> L15
    L27:
    L25:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r103);
        MainCoroutineDispatcher r106 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L13 CancellationException -> L15
        ProjectListDataSourceImpl$refreshLoadedRange$2 r107 = new ProjectListDataSourceImpl$refreshLoadedRange$2(this, null);     // Catch: Throwable -> L13 CancellationException -> L15
        r101.label = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        if (BuildersKt.withContext(r106, r107, r101) != r104) goto L27;
        return r104;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        FLogger.f375446a.e("ProjectListDataSource", "refreshLoadedRange failed", th);
    L7:
        r101 = new ProjectListDataSourceImpl$refreshLoadedRange$1(this, r100);
        goto L8
    }

    public static final List k(ProjectListDataSourceImpl r100, List r101) {
        return CollectionsKt.sortedWith(r101, new f());
    }

    public static final List l(ProjectListDataSourceImpl r100, h r110) {
        r100.getClass();
        List<OmniProject> r101 = r110.f367023a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L22;
        OmniProject r104 = (OmniProject) r103.next();
        String r105 = r104.projectId;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        List<wc9.e> r106 = r110.f367024b.get(r105);
        if (r106 != null) goto L11;
        r106 = CollectionsKt.emptyList();
    L11:
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<T> r108 = r106.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        r107.add(((wc9.e) r108.next()).f559198a);
        goto L13
    L15:
        Map<String, Message> r109 = r110.f367025c;
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator<Map.Entry<String, Message>> r112 = r109.entrySet().iterator();
    L17:
        if (r112.hasNext() == false) goto L21;
        Map.Entry<String, Message> r113 = r112.next();
        if (r107.contains(r113.getKey()) == false) goto L17;
        r111.put(r113.getKey(), r113.getValue());
        goto L17
    L21:
        r102.add(new com.larus.bmhome.taskskill.service.h(r104, r106, r111, r110.f367026d.contains(r105)));
        goto L4
    L22:
        return r102;
    }

    public static final void m(ProjectListDataSourceImpl r100, com.larus.bmhome.taskskill.service.i r101) {
        r100.f366966d = r101;
        Iterator<IProjectListDataSource.a> r102 = r100.f366965c.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r101);
        goto L4
    }

    public static int n(boolean r100, boolean r101) {
        b r102 = g.a(z2.f365865a.b4().f473642a, er9.a.f473641e.f473642a);
        if (r100 == false) goto L5;
        int r103 = r102.f367001a;
    L9:
        return RangesKt.coerceIn(r103, 1, 100);
    L5:
        if (r101 == false) goto L7;
        r103 = r102.f367002b;
        goto L9
    L7:
        r103 = r102.f367003c;
        goto L9
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectListDataSource
    public final Object f(String r100, Continuation<? super Result<com.larus.bmhome.taskskill.service.h>> r101) {
        if ((r101 instanceof ProjectListDataSourceImpl$getProject$1) == false) goto L7;
        ProjectListDataSourceImpl$getProject$1 r102 = (ProjectListDataSourceImpl$getProject$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25 CancellationException -> L28
    L23:
    L32:
        return Result.m9449constructorimpl((com.larus.bmhome.taskskill.service.h) r104);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        if (StringsKt.isBlank(r100) == true) goto L19;
        MainCoroutineDispatcher r108 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L25 CancellationException -> L28
        ProjectListDataSourceImpl$getProject$projectItem$1 r109 = new ProjectListDataSourceImpl$getProject$projectItem$1(this, r100, null);     // Catch: Throwable -> L25 CancellationException -> L28
        r102.L$0 = r100;     // Catch: Throwable -> L25 CancellationException -> L28
        r102.label = 1;     // Catch: Throwable -> L25 CancellationException -> L28
        r104 = BuildersKt.withContext(r108, r109, r102);     // Catch: Throwable -> L25 CancellationException -> L28
        if (r104 != r105) goto L23;
        return r105;
    L19:
        return Result.m9449constructorimpl(null);
    L28:
        e = move-exception;
        throw e;
    L25:
        th = move-exception;
        FLogger.f375446a.e("ProjectListDataSource", "getProject failed projectId=" + r100, th);
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ProjectListDataSourceImpl$getProject$1(this, r101);
        goto L8
    }

    public static final void h(ProjectListDataSourceImpl r100, List r101, List r102) {
        List r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
        int r106 = 0;
    L3:
        String r107 = "";
        if (r105.hasNext() == false) goto L13;
        Object r108 = r105.next();
        int r109 = r106 + 1;
        if (r106 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r110 = ((com.larus.bmhome.taskskill.service.h) r108).f314445a.projectId;
        if (r110 == null) goto L12;
        r107 = r110;
    L12:
        r104.add(TuplesKt.to(r107, Integer.valueOf(r106)));
        r106 = r109;
        goto L3
    L13:
        Map r111 = MapsKt.toMutableMap(MapsKt.toMap(r104));
        Iterator r112 = r102.iterator();
    L15:
        if (r112.hasNext() == false) goto L23;
        com.larus.bmhome.taskskill.service.h r113 = (com.larus.bmhome.taskskill.service.h) r112.next();
        String r114 = r113.f314445a.projectId;
        if (r114 != null) goto L19;
        r114 = "";
    L19:
        Integer r115 = (Integer) r111.get(r114);
        if (r115 == null) goto L21;
        ListProtector.set(r101, r115.intValue(), r113);
        goto L15
    L21:
        r111.put(r114, Integer.valueOf(r101.size()));
        r101.add(r113);
        goto L15
    }

    public static final Object j(ProjectListDataSourceImpl r100, List r101, Continuation r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        com.larus.im.service.v.f350892a.getClass();
        com.larus.im.service.v.a.a().f(new OmniGetProjectRequest(r101, OmniGetProjectSource.OmniGetProjectSource_MIXED), new e(r103));
        Object r104 = r103.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }

    public static final Object i(ProjectListDataSourceImpl r210, int r211, int r212, OmniConversationSortType r213, Continuation r214) {
        r210.getClass();
        if ((r214 instanceof ProjectListDataSourceImpl$queryProjectPage$1) == false) goto L7;
        ProjectListDataSourceImpl$queryProjectPage$1 r100 = (ProjectListDataSourceImpl$queryProjectPage$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r100.I$0;
        OmniConversationSortType r106 = (OmniConversationSortType) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        cd9.b r107 = (cd9.b) r102;
        List<cd9.a> r108 = r107.f23417a;
        if (r108 != null) goto L27;
        r108 = CollectionsKt.emptyList();
    L27:
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L28:
        boolean r111 = false;
        OmniProjectStatus r112 = null;
        if (r110.hasNext() == false) goto L38;
        Object r113 = r110.next();
        OmniProject r114 = ((cd9.a) r113).f23413a;
        if (r114 == null) goto L34;
        r112 = r114.status;
    L34:
        if (r112 == OmniProjectStatus.OmniProjectStatus_DELETED) goto L36;
        r111 = true;
    L36:
        if (r111 == false) goto L28;
        r109.add(r113);
        goto L28
    L38:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r109.iterator();
    L40:
        if (r116.hasNext() == false) goto L57;
        OmniProject r117 = ((cd9.a) r116.next()).f23413a;
        if (r117 == null) goto L54;
        String r118 = r117.projectId;
        if (r118 != null) goto L46;
    L49:
        boolean r119 = true;
    L51:
        if ((!r119) == false) goto L54;
    L55:
        if (r117 == null) goto L40;
        r115.add(r117);
        goto L40
    L46:
        if (r118.length() == 0) goto L49;
        r119 = false;
    L54:
        r117 = null;
        goto L55
    L57:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r109.iterator();
    L59:
        if (r121.hasNext() == false) goto L86;
        cd9.a r122 = (cd9.a) r121.next();
        OmniProject r123 = r122.f23413a;
        if (r123 == null) goto L83;
        String r124 = r123.projectId;
        if (r124 == null) goto L83;
        if (r124.length() <= 0) goto L67;
        boolean r125 = true;
    L68:
        if (r125 == true) goto L71;
        r124 = null;
    L71:
        if (r124 == null) goto L83;
        List<wc9.l> r126 = r122.f23414b;
        if (r126 != null) goto L76;
        r126 = CollectionsKt.emptyList();
    L76:
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r126.iterator();
    L78:
        if (r128.hasNext() == false) goto L82;
        wc9.e r129 = ((wc9.l) r128.next()).f559248a;
        if (r129 == null) goto L78;
        r127.add(r129);
        goto L78
    L82:
        Pair r130 = TuplesKt.to(r124, r127);
    L84:
        if (r130 == null) goto L59;
        r120.add(r130);
        goto L59
    L67:
        r125 = false;
    L83:
        r130 = null;
        goto L84
    L86:
        Map r131 = MapsKt.toMap(r120);
        ArrayList r132 = new ArrayList();
        Iterator r133 = r109.iterator();
    L88:
        if (r133.hasNext() == false) goto L93;
        List<wc9.l> r134 = ((cd9.a) r133.next()).f23414b;
        if (r134 != null) goto L92;
        r134 = CollectionsKt.emptyList();
    L92:
        CollectionsKt.addAll(r132, r134);
        goto L88
    L93:
        ArrayList r135 = new ArrayList();
        Iterator r136 = r132.iterator();
    L95:
        if (r136.hasNext() == false) goto L118;
        wc9.l r137 = (wc9.l) r136.next();
        wc9.e r138 = r137.f559248a;
        if (r138 == null) goto L115;
        String r139 = r138.f559198a;
        if (r139 == null) goto L115;
        if (r139.length() <= 0) goto L103;
        boolean r140 = true;
    L104:
        if (r140 == true) goto L107;
        r139 = null;
    L107:
        if (r139 == null) goto L115;
        List<Message> r141 = r137.f559249b;
        if (r141 == null) goto L115;
        Message r142 = (Message) CollectionsKt.firstOrNull(r141);
        if (r142 == null) goto L115;
        Pair r143 = TuplesKt.to(r139, r142);
    L116:
        if (r143 == null) goto L95;
        r135.add(r143);
        goto L95
    L103:
        r140 = false;
    L115:
        r143 = null;
        goto L116
    L118:
        Map r144 = MapsKt.toMap(r135);
        List<cd9.a> r145 = r107.f23417a;
        if (r145 != null) goto L121;
        r145 = CollectionsKt.emptyList();
    L121:
        cd9.a r146 = (cd9.a) CollectionsKt.lastOrNull(r145);
        if (r146 == null) goto L126;
        OmniProject r147 = r146.f23413a;
        if (r147 == null) goto L126;
        int r148 = r147.displayOrder;
    L127:
        LinkedHashSet r149 = new LinkedHashSet();
        Iterator r150 = r109.iterator();
    L129:
        if (r150.hasNext() == false) goto L149;
        cd9.a r151 = (cd9.a) r150.next();
        OmniProject r152 = r151.f23413a;
        if (r152 == null) goto L145;
        String r153 = r152.projectId;
        if (r153 == null) goto L145;
        if (r153.length() <= 0) goto L137;
        boolean r154 = true;
    L138:
        if (r154 == true) goto L140;
    L142:
        boolean r155 = false;
    L143:
        if (r155 == false) goto L145;
    L146:
        if (r153 == null) goto L129;
        r149.add(r153);
        goto L129
    L140:
        if (r151.f23416d == false) goto L142;
        r155 = true;
        goto L143
    L137:
        r154 = false;
    L145:
        r153 = null;
        goto L146
    L149:
        if (r107.f23418b == true) goto L151;
    L154:
        boolean r156 = false;
    L156:
        return new h(r115, r131, r144, r149, r148, r156);
    L151:
        if (r148 <= 0) goto L154;
        if (r148 == r105) goto L154;
        r156 = true;
    L126:
        r148 = r105;
        goto L127
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        int r157 = RangesKt.coerceIn(g.a(z2.f365865a.b4().f473643b, er9.a.f473641e.f473643b).f367001a, 1, 100);
        if (r157 >= 100) goto L18;
        r157 = r157 + 1;
    L18:
        r100.L$0 = r213;
        r100.I$0 = r211;
        r100.I$1 = r212;
        r100.I$2 = r157;
        r100.label = 1;
        kotlinx.coroutines.j r158 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r158.C();
        com.larus.im.service.v.f350892a.getClass();
        com.larus.im.service.v.a.a().a(new OmniSelectProjectListOrderByIndexRequest(OmniPinStatus.PinStatus_ALL, r211, RangesKt.coerceIn(r212, 1, 100), new OmniSelectConversationGroupRequest(OmniPinStatus.PinStatus_UNPIN, OmniArchiveStatus.ArchiveStatus_NO_BELONG_ARCHIVE, true, Long.MAX_VALUE, "", r213, r157)), new d(r158));
        r102 = r158.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L21:
        if (r102 == r103) goto L190;
        r105 = r211;
        goto L24
    L190:
        return r103;
    L7:
        r100 = new ProjectListDataSourceImpl$queryProjectPage$1(r210, r214);
        goto L8
    }
}
