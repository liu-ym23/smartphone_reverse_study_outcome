package com.ss.android.lark.screenprotect;

import android.app.Activity;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.c;
import com.ss.android.lark.screenprotect.legacy.SwitchData;
import com.ss.android.lark.screenprotect.legacy.e;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import qzb.b;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.screenprotect.ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1", f = "ScreenshotProtectionModule.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $context;
    int label;

    public ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1(b r100, Continuation<? super ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1(null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ScreenshotProtectionModule$onUserSwitchListener$1$onUserSwitchBegin$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        MutableLiveData<Boolean> r102 = SwitchData.f439788a;
        throw null;
    L5:
        if (r101 != 1) goto L18;
        ResultKt.throwOnFailure(r100);
        if (((Boolean) r100).booleanValue() == false) goto L14;
        e.b r103 = e.f439794a;
        Activity r104 = c.a.f408832a.a();
        if (r104 == null) goto L13;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L13;
        r105.addFlags(8192);
    L13:
        AppLifecycle r106 = AppLifecycle.a.f408803a;
        r106.j(e.f439795b);
        r106.b(e.f439794a);
        MutableLiveData<Boolean> r107 = SwitchData.f439788a;
        ScsLogger.d("ScreenshotProtection", "banScreenshots: done");
    L16:
        return Unit.INSTANCE;
    L14:
        e.a(false);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
