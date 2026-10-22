package com.larus.doc.impl.offline;

import android.os.Looper;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.doc.sdk.api.SyncedDocInfoSource;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0014\u0010\u001b\u001a\u00020\u00182\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u00100\u001a\u0004\u0018\u00010\u0014*\u00020\u0012H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u00106\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u000209H\u0002J*\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u00142\b\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010;\u001a\u0002022\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/doc/impl/offline/OfflineDocCreateComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/offline/IOfflineDocCreateAbility;", "<init>", "()V", "coordinator", "Lcom/larus/doc/impl/offline/OfflineDocCreateCoordinator;", "componentScope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Lcom/larus/doc/impl/offline/OfflineDocCreateConfig;", "startInvoked", "", "hasRefreshedRemoteBinding", "shouldSkipUpdateDocumentBrief", "hostAbility", "Lcom/larus/doc/impl/offline/IOfflineDocCreateHostAbility;", "createDocumentResult", "Lcom/bytedance/ee/bear/list/DocumentListInfo;", "createDocumentError", "", "createDocumentFinishSignal", "Ljava/util/concurrent/CountDownLatch;", "onAttach", "", "initialize", "startIfNeeded", "handleCreateDocumentStartFailure", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCreateDocResp", "buildCreateDocResp", "Lorg/json/JSONObject;", "waitCreateDocumentFinishIfNeeded", "notifyOfflineCreateState", "state", "", "offlineCreateFail", "onSyncedDocInfo", "source", "Lcom/larus/doc/sdk/api/SyncedDocInfoSource;", "onChatInputReady", "onHostDestroy", "compensateEnabled", "isOfflineDocCreateFlow", LiveCommonConstants.REASON_ON_DEDTROY, "currentRealToken", "firstRealToken", "buildSnapshot", "Lcom/larus/doc/impl/offline/CreateDocByMessageSnapshot;", "docRealToken", "applyRealTokenAndRefreshBinding", "realToken", "resourceType", "executeAction", "action", "Lcom/larus/doc/impl/offline/OfflineDocCreateAction;", "executeCreateDocByMessage", "snapshot", "trigger", "failReason", "createDocByMessageState", "Lcom/larus/doc/impl/offline/CreateDocByMessageState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineDocCreateComponent extends Component implements c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f331208v = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OfflineDocCreateCoordinator f331209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CoroutineScope f331210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile f f331211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f331212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f331213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f331214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile d f331215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile DocumentListInfo f331216s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile String f331217t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CountDownLatch f331218u;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331219a = null;

        static {
            int[] r100 = new int[SyncedDocInfoSource.values().length];
            r100[SyncedDocInfoSource.USER_CHANGES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SyncedDocInfoSource.OFFLINE_SYNC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SyncedDocInfoSource.CHAT_INPUT_HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f331219a = r100;
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f331215r = null;
        this.f331218u.countDown();
        CoroutineScopeKt.cancel$default(this.f331210m, null, 1, null);
    }

    @Override // com.larus.doc.impl.offline.c
    public final boolean BK() {
        f r100 = this.f331211n;
        if (r100 == null) goto L5;
        String r101 = r100.f331256b;
    L7:
        return Intrinsics.areEqual(r101, "fake_offline_doc_id");
    L5:
        r101 = null;
        goto L7
    }

    public final JSONObject N2() {
        DocumentListInfo r100 = this.f331216s;
        String r101 = null;
        if (r100 == null) goto L13;
        ArrayList<Document> r102 = r100.getDocumentList();
        if (r102 == null) goto L13;
        Document r103 = (Document) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L13;
        String r104 = r103.f227873d;
        if (r104 == null) goto L13;
        if ((!StringsKt.isBlank(r104)) == false) goto L13;
    L15:
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L22:
        if (r105 == true) goto L25;
        JSONObject r106 = new JSONObject();
        r106.put("objToken", r104);
        r106.put("code", 0);
        return r106;
    L25:
        JSONObject r107 = new JSONObject();
        r107.put("code", -1);
        String r108 = this.f331217t;
        if (r108 != null) goto L28;
    L31:
        r101 = "create_document_missing_obj_token";
    L32:
        r107.put("msg", r101);
        return r107;
    L28:
        if ((true ^ StringsKt.isBlank(r108)) == false) goto L30;
        r101 = r108;
    L30:
        if (r101 != null) goto L32;
    L17:
        if (StringsKt.isBlank(r104) == true) goto L20;
        r105 = false;
    L13:
        r104 = null;
        goto L15
    }

    public final String U2() {
        String r100 = this.f331209l.d();
        if (r100 != null) goto L13;
        d r101 = this.f331215r;
        if (r101 == null) goto L12;
        String r102 = r101.ei();
        if (r102 == null) goto L12;
        if ((!Intrinsics.areEqual(r102, "fake_offline_doc_id")) == false) goto L12;
        return r102;
    L12:
        return null;
    L13:
        return r100;
    }

    public final void Y2() {
        f r100 = this.f331211n;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f331212o == false) goto L8;
        return;
    L8:
        if (BK() == false) goto L22;
        this.f331212o = true;
        OfflineDocCreateCoordinator r101 = this.f331209l;
        monitor-enter(r101);
        OfflineDocCreateCoordinator.a r102 = r101.f331222a;     // Catch: Throwable -> L16
        OfflineDocCreateCoordinator.CreateDocumentStatus r103 = OfflineDocCreateCoordinator.CreateDocumentStatus.WAITING_CALLBACK;     // Catch: Throwable -> L16
        r102.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r103, "<set-?>");     // Catch: Throwable -> L16
        r102.f331225a = r103;     // Catch: Throwable -> L16
        new e.c("create_document_started");     // Catch: Throwable -> L16
        monitor-exit(r101);
        BuildersKt.launch$default(this.f331210m, null, null, new OfflineDocCreateComponent$startIfNeeded$1(this, r100, null), 3, null);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.f331215r = (d) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(d.class);
    }

    public OfflineDocCreateComponent() {
        this.f331209l = new OfflineDocCreateCoordinator();
        this.f331210m = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f331218u = new CountDownLatch(1);
    }

    @Override // com.larus.doc.impl.offline.c
    public final void FN() {
        com.larus.doc.impl.offline.a r100 = P2(U2());
        if (r100 != null) goto L5;
        return;
    L5:
        OfflineDocCreateCoordinator r101 = this.f331209l;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "snapshot");     // Catch: Throwable -> L11
        r101.c(r100);     // Catch: Throwable -> L11
        r101.f331222a.f331226b = true;     // Catch: Throwable -> L11
        e r102 = r101.b("frontend_linked");     // Catch: Throwable -> L11
        monitor-exit(r101);
        X2(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.doc.impl.offline.c
    public final void g60() {
        if (BK() == true) goto L5;
        return;
    L5:
        f r100 = this.f331211n;
        if (r100 != null) goto L8;
        return;
    L8:
        L2(U2(), r100.f331259e, "chatInputReady");
    }

    @Override // com.larus.doc.impl.offline.c
    public final String getCreateDocResp() {
        if (BK() == false) goto L35;
        Y2();
        if (this.f331218u.getCount() == 0) goto L35;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        int r100 = m39.b.f511804a;
        m39.b.d("skip", "main_thread");
        goto L35
    L11:
        int r101 = m39.b.f511804a;
        m39.b.d("before_get_create_doc_resp", null);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        this.f331218u.await();     // Catch: Throwable -> L14
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L35;
        if ((r104 instanceof InterruptedException) == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
    L21:
        int r105 = m39.b.f511804a;
        m39.b.d("interrupted", r104.getMessage());
        FLogger.f375446a.e("OfflineDocCreateComponent", "[offlineCreate] wait createDocument finish interrupted", r104);
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L35:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L24
        Object r108 = Result.m9449constructorimpl(N2().toString());     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L34;
        int r110 = m39.b.f511804a;
        Intrinsics.checkNotNullParameter(r109, "error");
        String r111 = r109.getMessage();
        if (r111 != null) goto L32;
        r111 = "";
    L32:
        m39.b.a("序列化创建离线文档结果失败, 错误:".concat(r111));
        FLogger.f375446a.e("OfflineDocCreateComponent", "[offlineCreate] serialize createDocument response failed", r109);
        r108 = "{\"code\":-1,\"msg\":\"serialize_create_document_response_failed\"}";
    L34:
        return (String) r108;
    L24:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.doc.impl.offline.c
    public final void offlineCreateFail() {
        com.larus.doc.impl.offline.a r100 = P2(U2());
        if (r100 != null) goto L5;
        return;
    L5:
        OfflineDocCreateCoordinator r101 = this.f331209l;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "snapshot");     // Catch: Throwable -> L21
        r101.c(r100);     // Catch: Throwable -> L21
        OfflineDocCreateCoordinator.a r102 = r101.f331222a;     // Catch: Throwable -> L21
        if (r102.f331230f == false) goto L10;
        e r103 = new e.c("offline_create_fail:create_doc_by_message_started");     // Catch: Throwable -> L21
    L18:
        monitor-exit(r101);
        X2(r103);
        return;
    L10:
        r102.f331230f = true;     // Catch: Throwable -> L21
        String r104 = r102.f331231g;     // Catch: Throwable -> L21
        if (r104 != null) goto L13;
    L15:
        r104 = null;
    L17:
        r103 = new e.d(r104);     // Catch: Throwable -> L21
        goto L18
    L13:
        if ((true ^ StringsKt.isBlank(r104)) == false) goto L15;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.doc.impl.offline.c
    public final boolean wL() {
        return this.f331214q;
    }

    public final com.larus.doc.impl.offline.a P2(String r110) {
        f r100 = this.f331211n;
        if (r100 != null) goto L5;
        return null;
    L5:
        Long r101 = r100.f331258d;
        if (r101 != null) goto L8;
    L12:
        int r111 = m39.b.f511804a;
        String r112 = r100.f331257c;
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        m39.b.a("创建卡片参数快照缺失, convId:" + r112 + ", messageId:" + r101);
        return null;
    L8:
        if (StringsKt.isBlank(r100.f331257c) == true) goto L12;
        return new com.larus.doc.impl.offline.a(r100.f331257c, r101.longValue(), r100.f331259e, r100.f331260f, r100.f331261g, r110, null);
    }

    @Override // com.larus.doc.impl.offline.c
    public final void QN(f r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f331211n = r100;
        Y2();
    }

    public final void X2(e r110) {
        if ((r110 instanceof e.c) == false) goto L6;
        int r100 = m39.b.f511804a;
        String r101 = ((e.c) r110).f331252a;
        Intrinsics.checkNotNullParameter(r101, "stage");
        m39.b.a("卡片补偿决策, 是否补偿:false, 动作:无操作, 当前阶段:" + r101);
        return;
    L6:
        if ((r110 instanceof e.b) == false) goto L13;
        int r102 = m39.b.f511804a;
        e.b r103 = (e.b) r110;
        String r104 = r103.f331250b;
        com.larus.doc.impl.offline.a r105 = r103.f331249a;
        m39.b.b(r104, r105.f331239f, r105.f331240g, null, r103.f331251c);
        d r106 = this.f331215r;
        if (r106 == null) goto L10;
        r106.dM(r103.f331251c);
    L11:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineDocCreateComponent$executeCreateDocByMessage$1(r103.f331249a, r103.f331250b, this, r103.f331251c, null, null), 2, null);
        return;
    L10:
        m39.b.e(r103.f331251c, null, 6);
        goto L11
    L13:
        if ((r110 instanceof e.a) == false) goto L28;
        int r107 = m39.b.f511804a;
        e.a r108 = (e.a) r110;
        String r109 = r108.f331247c;
        com.larus.doc.impl.offline.a r111 = r108.f331245a;
        m39.b.b(r109, r111.f331239f, r111.f331240g, r108.f331246b, r108.f331248d);
        d r112 = this.f331215r;
        if (r112 == null) goto L17;
        r112.dM(r108.f331248d);
    L18:
        com.larus.doc.impl.offline.a r113 = r108.f331245a;
        com.larus.doc.impl.offline.b r114 = r108.f331248d;
        if (r114.f331241a == CreateDocByMessageActionType.COMPENSATE) goto L21;
    L25:
        boolean r115 = false;
    L26:
        this.f331214q = r115;
        com.larus.doc.impl.offline.a r116 = r108.f331245a;
        String r117 = r108.f331247c;
        String r118 = r108.f331246b;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineDocCreateComponent$executeCreateDocByMessage$1(r116, r117, this, r108.f331248d, r118, null), 2, null);
        return;
    L21:
        if (r114.f331242b == false) goto L25;
        if (Intrinsics.areEqual(r113.f331240g, Boolean.FALSE) == false) goto L25;
        r115 = true;
        goto L26
    L17:
        m39.b.e(r108.f331248d, null, 6);
        goto L18
    L28:
        if ((r110 instanceof e.d) == false) goto L34;
        int r119 = m39.b.f511804a;
        e.d r120 = (e.d) r110;
        String r121 = r120.f331254b;
        String r122 = r120.f331253a;
        Intrinsics.checkNotNullParameter(r121, "stage");
        m39.b.a("卡片补偿决策, 是否补偿:false, 动作:重新在线打开, 当前阶段:" + r121 + ", realToken:" + m39.b.f(r122));
        d r123 = this.f331215r;
        if (r123 == null) goto L38;
        r123.ic(r120.f331253a);
        return;
    L38:
        return;
    L34:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.doc.impl.offline.c
    public final void b10(boolean r110) {
        boolean r100 = BK();
        boolean r101 = false;
        if (r100 == false) goto L46;
        if (r110 == false) goto L46;
        com.larus.doc.impl.offline.a r102 = P2(U2());
        if (r102 == null) goto L8;
        boolean r103 = true;
    L9:
        if (r102 == null) goto L45;
        OfflineDocCreateCoordinator r111 = this.f331209l;
        monitor-enter(r111);
        Intrinsics.checkNotNullParameter(r102, "snapshot");     // Catch: Throwable -> L42
        OfflineDocCreateCoordinator.a r104 = r111.f331222a;     // Catch: Throwable -> L42
        r104.f331232h = r102;     // Catch: Throwable -> L42
        r104.f331233i = r102;     // Catch: Throwable -> L42
        r104.f331229e = true;     // Catch: Throwable -> L42
        if (r104.f331225a != OfflineDocCreateCoordinator.CreateDocumentStatus.NOT_STARTED) goto L18;
        e r105 = new e.c("create_document_not_started");     // Catch: Throwable -> L42
        monitor-exit(r111);
    L41:
        X2(r105);
        goto L45
    L18:
        if (r104.f331230f == false) goto L22;
        r105 = new e.c("create_doc_by_message_started");     // Catch: Throwable -> L42
        monitor-exit(r111);
        goto L41
    L22:
        String r106 = r104.f331231g;     // Catch: Throwable -> L42
        if (r106 != null) goto L25;
    L26:
        r101 = true;
    L28:
        if ((!r101) == true) goto L35;
        if (r111.f331222a.f331225a != OfflineDocCreateCoordinator.CreateDocumentStatus.WAITING_CALLBACK) goto L35;
        r105 = new e.c("wait_create_document_callback");     // Catch: Throwable -> L42
        monitor-exit(r111);
    L35:
        if (r111.f331222a.f331225a != OfflineDocCreateCoordinator.CreateDocumentStatus.FAILED) goto L39;
        r105 = r111.e(r102, null, null, "create_doc_by_message_not_started", "destroy_after_create_document_failed");     // Catch: Throwable -> L42
        monitor-exit(r111);
        goto L41
    L39:
        r105 = r111.a("destroy_exit");     // Catch: Throwable -> L42
        monitor-exit(r111);
        goto L41
    L25:
        if (StringsKt.isBlank(r106) == false) goto L28;
    L42:
        th = move-exception;
        throw th;
    L45:
        r101 = r103;
        goto L46
    L8:
        r103 = false;
    L46:
        int r107 = m39.b.f511804a;
        m39.b.a("宿主销毁, 是否离线创建链路:" + r100 + ", 是否开启退出补偿:" + r110 + ", 是否有参数快照:" + r101);
        this.f331215r = null;
    }

    @Override // com.larus.doc.impl.offline.c
    public final void onSyncedDocInfo(SyncedDocInfoSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        d r101 = this.f331215r;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L35;
        if (r100 == SyncedDocInfoSource.CHAT_INPUT_HIDDEN) goto L35;
        com.larus.doc.impl.offline.a r103 = P2(U2());
        if (r103 != null) goto L15;
        return;
    L15:
        int r104 = b.f331219a[r100.ordinal()];
        if (r104 != 1) goto L18;
        int r105 = m39.b.f511804a;
        Intrinsics.checkNotNullParameter(r100, "source");
        m39.b.a("文档已开始同步, source:" + r100);
        OfflineDocCreateCoordinator r106 = this.f331209l;
        monitor-enter(r106);
        Intrinsics.checkNotNullParameter(r103, "snapshot");     // Catch: Throwable -> L31
        r106.c(r103);     // Catch: Throwable -> L31
        r106.f331222a.f331227c = true;     // Catch: Throwable -> L31
        e.c r107 = new e.c("user_changes");     // Catch: Throwable -> L31
        monitor-exit(r106);
        X2(r107);
        return;
    L31:
        th = move-exception;
        throw th;
    L18:
        if (r104 != 2) goto L20;
        int r108 = m39.b.f511804a;
        Intrinsics.checkNotNullParameter(r100, "source");
        m39.b.a("文档同步完成, source:" + r100);
        X2(this.f331209l.f(r103));
        return;
    L20:
        if (r104 != 3) goto L23;
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L35:
        if (r100 != SyncedDocInfoSource.CHAT_INPUT_HIDDEN) goto L42;
        int r109 = m39.b.f511804a;
        Intrinsics.checkNotNullParameter(r100, "source");
        m39.b.a("文档可编辑, source:" + r100);
        return;
    L42:
        return;
    L5:
        if (r101.PM() != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final void F2(OfflineDocCreateComponent r100, Exception r101) {
        r100.getClass();
        String r102 = r101.getMessage();
        if (r102 != null) goto L5;
    L9:
        r102 = "create_document_start_failed";
    L10:
        r100.f331216s = null;
        r100.f331217t = r102;
        r100.f331218u.countDown();
        int r103 = m39.b.f511804a;
        m39.b.a("创建离线文档失败, 错误:".concat(r102));
        FLogger.f375446a.e("OfflineDocCreateComponent", "[offlineCreate] start createDocument failed", r101);
        r100.X2(r100.f331209l.g(r102));
        return;
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L10;
        goto L9
    }

    public final void L2(String r110, int r111, String r112) {
        if (r110 != null) goto L4;
    L7:
        boolean r100 = true;
    L8:
        if (r100 == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default(this.f331210m, null, null, new OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(this, r110, r112, r111, null), 3, null);
        return;
    L4:
        if (StringsKt.isBlank(r110) == true) goto L7;
        r100 = false;
        goto L8
    }
}
