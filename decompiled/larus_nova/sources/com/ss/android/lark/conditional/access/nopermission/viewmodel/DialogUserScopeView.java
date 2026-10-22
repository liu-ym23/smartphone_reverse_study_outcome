package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.RustClientException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
public final class DialogUserScopeView implements c, d0c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserSession f418411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f418412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f418413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f418414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConditionalAccessNetDependency f418415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k8b.c f418416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yyb.b f418417g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return this.f418411a;
    }

    @Override // d0c.a
    public Context getContext() {
        return this.f418412b;
    }

    public DialogUserScopeView(UserSession r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "ctx");
        this.f418411a = r100;
        this.f418412b = r101;
        this.f418413c = new CompositeDisposable();
        this.f418414d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f418415e = (ConditionalAccessNetDependency) k.b(d0c.b.b(this), ConditionalAccessNetDependency.class);
        this.f418416f = (k8b.c) k.b(d0c.b.b(this), k8b.c.class);
        this.f418417g = (yyb.b) k.b(d0c.b.b(this), yyb.b.class);
    }

    public static final void a(DialogUserScopeView r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof RustClientException) == false) goto L25;
        LarkError r102 = ((RustClientException) r101).getRustError();
        if (r102 == null) goto L7;
        Integer r103 = r102.code;
    L8:
        if (r103 != null) goto L11;
    L12:
        if (r103 != null) goto L15;
    L16:
        if (r103 != null) goto L19;
    L21:
        boolean r104 = false;
    L23:
        if (r104 == false) goto L25;
        UDToast.show(LarkContext.getApplication(), R.string.Lark_Conditions_PoorNetworkConditions_Error);
        return;
    L19:
        if (r103.intValue() != 100054) goto L21;
    L22:
        r104 = true;
        goto L23
    L15:
        if (r103.intValue() == 100052) goto L22;
    L11:
        if (r103.intValue() == (-1001)) goto L22;
    L7:
        r103 = null;
    L25:
        UDToast.show(LarkContext.getApplication(), R.string.Lark_Conditions_SystemError_Error);
    }

    public final Object c(String r100, final int r101, Continuation<? super Boolean> r102) {
        final SafeContinuation r103 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        ScsLogger.d("DialogUserScopeView", "userConfirm");
        t4c.a.b(t4c.a.a(this.f418415e.d(r100)), this.f418413c, new DialogUserScopeView$userConfirm$2$1(r101, r103), new DialogUserScopeView$userConfirm$2$2(this, r103));
        Object r104 = r103.getOrThrow();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }

    public final Object b(Activity r100, String r101, JSONObject r102, String r103, final int r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof DialogUserScopeView$mfa$1) == false) goto L7;
        DialogUserScopeView$mfa$1 r104 = (DialogUserScopeView$mfa$1) r111;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r112 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        String r108 = (String) r104.L$1;
        String r109 = (String) r104.L$0;
        ResultKt.throwOnFailure(r112);
    L33:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = r104.I$0;
        r103 = (String) r104.L$3;
        JSONObject r113 = (JSONObject) r104.L$2;
        String r114 = (String) r104.L$1;
        Activity r115 = (Activity) r104.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        Object r116 = ((Result) r112).m9458unboximpl();
        if (Result.m9455isFailureimpl(r116) == false) goto L24;
        r116 = null;
    L24:
        String r117 = (String) r116;
        if (r117 == null) goto L27;
        r104.L$0 = r103;
        r104.L$1 = r117;
        r104.L$2 = null;
        r104.L$3 = null;
        r104.I$0 = r110;
        r104.label = 2;
        final SafeContinuation r118 = new SafeContinuation(IntrinsicsKt.intercepted(r104));
        t4c.a.b(t4c.a.a(this.f418415e.c(r117, r103)), this.f418413c, new DialogUserScopeView$mfa$2$1(r110, r118), new DialogUserScopeView$mfa$2$2(r118, this));
        r112 = r118.getOrThrow();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L31:
        if (r112 != r106) goto L33;
        return r106;
    L27:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r112);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.L$3 = r103;
        r104.I$0 = r110;
        r104.label = 1;
        final SafeContinuation r119 = new SafeContinuation(IntrinsicsKt.intercepted(r104));
        ScsLogger.d("DialogUserScopeView", "startNewMfaAuth");
        this.f418417g.a(r100, r101, r102, new DialogUserScopeView$mfa$mfaRes$1$1(r119));
        r112 = r119.getOrThrow();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L19:
        if (r112 != r106) goto L21;
        return r106;
    L7:
        r104 = new DialogUserScopeView$mfa$1(this, r111);
        goto L8
    }
}
