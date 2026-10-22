package com.bytedance.ies.ezpermission.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ies.ezpermission.core.result.ResultWrapper;
import com.bytedance.ies.ezpermission.core.task.NormalPermissionRequestTask;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements CoroutineScope, com.bytedance.ies.ezpermission.core.task.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f248560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ies.ezpermission.core.task.c f248561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResultWrapper f248562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f248563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ies.ezpermission.core.task.d f248564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NormalPermissionRequestTask f248565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f248566g;

    public final class a implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineExceptionHandler.Key f248567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f248568b;

        @Override // kotlin.coroutines.CoroutineContext.Element
        public final CoroutineContext.Key getKey() {
            return this.f248567a;
        }

        public a(d r100) {
            this.f248568b = r100;
            this.f248567a = CoroutineExceptionHandler.Key;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return (E) CoroutineContext.Element.DefaultImpls.get(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final CoroutineContext plus(CoroutineContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return CoroutineContext.Element.DefaultImpls.plus(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
            return (R) CoroutineContext.Element.DefaultImpls.fold(this, r100, r101);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            n46.a r102 = n46.a.f517060b;
            String r103 = "$" + Log.getStackTraceString(r101);
            r102.getClass();
            n46.a.c(r103);
            this.f248568b.f248566g.getClass();
        }
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public Activity getActivity() {
        Activity r100 = this.f248566g.getActivity();
        if (r100 != null) goto L9;
        Fragment r101 = this.f248566g.f248570b;
        if (r101 == null) goto L8;
        r100 = r101.getActivity();
        goto L9
    L8:
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        return r100;
    L12:
        throw new RuntimeException("Can not find activity");
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public Context getContext() {
        Context r100 = this.f248566g.getActivity();
        if (r100 != null) goto L9;
        Fragment r101 = this.f248566g.f248570b;
        if (r101 == null) goto L8;
        r100 = r101.getContext();
        goto L9
    L8:
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        return r100;
    L12:
        throw new RuntimeException("Can not find context");
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final e b() {
        return this.f248566g;
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final ResultWrapper c() {
        return this.f248562c;
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final boolean f() {
        return this.f248563d;
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final com.bytedance.ies.ezpermission.core.task.c g() {
        return this.f248561b;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f248560a;
    }

    public d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f248566g = r100;
        this.f248560a = Dispatchers.getMain().getImmediate().plus(JobKt.Job$default(null, 1, null)).plus(new a(this));
        this.f248561b = new com.bytedance.ies.ezpermission.core.task.c(null, null, 15);
        this.f248565f = new NormalPermissionRequestTask(this);
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final void a(com.bytedance.ies.ezpermission.core.task.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f248561b = r100;
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final Object d(Continuation<? super Unit> r100) {
        this.f248563d = true;
        Object r101 = this.f248565f.b(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ies.ezpermission.core.task.a
    public final void e(ResultWrapper r100) {
        this.f248562c = r100;
    }
}
