package com.larus.bmhome.chat.model.repo;

import com.larus.audio.AudioServiceDelegate;
import com.larus.im.bean.IMCmd;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 implements t1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f307836g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f307837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<IMCmd> f307838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f307839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1 f307840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f307841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f2a.d f307842f;

    public static final class a {
    }

    static {
    }

    public static com.larus.audio.v0 d() {
        return AudioServiceDelegate.f288288a.N();
    }

    @Override // com.larus.bmhome.chat.model.repo.t1
    public final x1 a() {
        return this.f307840d;
    }

    @Override // com.larus.bmhome.chat.model.repo.t1
    public final x1 c() {
        return this.f307840d;
    }

    public n0(ExecutorCoroutineDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatcher");
        this.f307837a = CoroutineScopeKt.CoroutineScope(CoroutineScopeKt.MainScope().getCoroutineContext().plus(r100));
        this.f307838b = SharedFlowKt.MutableSharedFlow$default(1, 1, null, 4, null);
        this.f307839c = LazyKt.lazy(new m0());
        x1.f307866a.getClass();
        this.f307840d = x1.a.a();
        this.f307842f = new f2a.d("Chat", "ChatReceiver");
        com.larus.im.d.b().addProcessor(new com.larus.bmhome.chat.model.o1());
    }

    public static JSONObject e(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        return (JSONObject) r102;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.repo.t1
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        RepoDispatcher.f307729a.getClass();
        IConversationRepoService.a.f(RepoDispatcher.f307734f, r100, false, false, null, 14);
    }
}
