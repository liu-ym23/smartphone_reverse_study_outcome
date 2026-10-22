package com.obric.update.impl.v2.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.update.impl.v2.m;
import com.obric.update.impl.v2.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes34.dex */
public final class ObricInstallHandler implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f404081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final goa.a f404082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final goa.b f404083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f404084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f404085e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.update.impl.v2.handler.ObricInstallHandler$onAppForeground$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.update.impl.v2.handler.ObricInstallHandler$onAppForeground$1", f = "ObricInstallHandler.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricInstallHandler this$0;

        public AnonymousClass1(ObricInstallHandler r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L11;
            if (r102 != 1) goto L10;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7
        L15:
            this.this$0.a();     // Catch: Exception -> L7
            this.this$0.f404082b.f481958i = false;     // Catch: Exception -> L7
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r100);
            this.label = 1;     // Catch: Exception -> L7
            if (DelayKt.delay(3000, this) != r101) goto L15;
            return r101;
        L7:
            e = move-exception;
            FLogger.f375446a.e("ObricInstallHandler", "onAppForeground check install job error: " + e);
            goto L19
        }
    }

    static {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    public final void a() {
        m.d(this.f404084d, "apk_install", null, 6);     // Catch: Exception -> L17
        if (this.f404082b.f481950a == true) goto L7;
        FLogger.f375446a.i("ObricInstallHandler", "installWhenPossible deferred (background)");     // Catch: Exception -> L17
        this.f404082b.f481958i = true;     // Catch: Exception -> L17
        this.f404084d.c("apk_install", "app_background", null);     // Catch: Exception -> L17
        return;
    L7:
        this.f404081a.f404131a.getClass();     // Catch: Exception -> L17
        PolarisFileWrapper r100 = com.obric.update.impl.v2.gateway.f.b();     // Catch: Exception -> L17
        if (r100 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L15;
        this.f404081a.f404132b.getClass();     // Catch: Exception -> L17
        com.obric.update.impl.v2.gateway.b.a(r100);     // Catch: Exception -> L17
        m.e(this.f404084d, "apk_install", null, 6);     // Catch: Exception -> L17
        return;
    L15:
        FLogger.f375446a.i("ObricInstallHandler", "installWhenPossible ignored: file does not exist");     // Catch: Exception -> L17
        this.f404084d.c("apk_install", "apk_missing", null);     // Catch: Exception -> L17
        this.f404082b.f481958i = false;     // Catch: Exception -> L17
        this.f404083c.b(1);     // Catch: Exception -> L17
        return;
    L10:
        if (r100.exists() != true) goto L12;
        r101 = true;
    L17:
        e = move-exception;
        FLogger.f375446a.e("ObricInstallHandler", "installWhenPossible error: " + e);
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i("ObricInstallHandler", "handleAppBackground");     // Catch: Exception -> L15
        boolean r100 = false;
        this.f404082b.f481950a = false;     // Catch: Exception -> L15
        Job r101 = this.f404085e;     // Catch: Exception -> L15
        if (r101 == null) goto L9;
        if (r101.isCompleted() == true) goto L9;
        r100 = true;
    L9:
        if (r100 == false) goto L13;
        Job r102 = this.f404085e;     // Catch: Exception -> L15
        if (r102 == null) goto L13;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);     // Catch: Exception -> L15
    L13:
        this.f404085e = null;     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("ObricInstallHandler", "onAppBackground error: " + e);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        this.f404082b.f481950a = true;     // Catch: Exception -> L6
        if (this.f404082b.f481958i == false) goto L11;
        this.f404085e = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.e("ObricInstallHandler", "onAppForeground error: " + e);
    }

    public ObricInstallHandler(o r100, goa.a r101, goa.b r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "gateways");
        Intrinsics.checkNotNullParameter(r101, "flowContext");
        Intrinsics.checkNotNullParameter(r102, "stateHolder");
        Intrinsics.checkNotNullParameter(r103, "pipelineReporter");
        this.f404081a = r100;
        this.f404082b = r101;
        this.f404083c = r102;
        this.f404084d = r103;
        AppHost.Companion r104 = AppHost.f326268a;
        r101.f481950a = !r104.a().isAppBackground();
        r104.a().j(new i(this));
    }
}
