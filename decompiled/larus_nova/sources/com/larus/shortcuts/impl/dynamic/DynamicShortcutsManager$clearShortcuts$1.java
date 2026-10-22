package com.larus.shortcuts.impl.dynamic;

import android.content.pm.ShortcutManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.shortcuts.impl.dynamic.DynamicShortcutsManager$clearShortcuts$1", f = "DynamicShortcutsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DynamicShortcutsManager$clearShortcuts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DynamicShortcutsManager$clearShortcuts$1(Continuation<? super DynamicShortcutsManager$clearShortcuts$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DynamicShortcutsManager$clearShortcuts$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DynamicShortcutsManager$clearShortcuts$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        ShortcutManager r101 = (ShortcutManager) AppHost.f326268a.getApplication().getApplicationContext().getSystemService("shortcut");     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        r101.removeAllDynamicShortcuts();     // Catch: Exception -> L9
    L12:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        FLogger.f375446a.e("DynamicShortcutsManager", "clear shortcut exception: " + e.getMessage());
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
