package com.larus.avlink.update;

import android.app.Activity;
import com.bytedance.keva.Keva;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import lq9.t;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.update.TemporaryDoraGUpdateManager$showUpdateDialog$1", f = "TemporaryDoraGUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemporaryDoraGUpdateManager$showUpdateDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $source;
    int label;

    public TemporaryDoraGUpdateManager$showUpdateDialog$1(int r100, Continuation<? super TemporaryDoraGUpdateManager$showUpdateDialog$1> r101) {
        this.$source = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TemporaryDoraGUpdateManager$showUpdateDialog$1(this.$source, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TemporaryDoraGUpdateManager$showUpdateDialog$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_avlink_update_TemporaryDoraGUpdateManager$showUpdateDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(c r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.avlink.update.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.avlink.update.f] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r100);
        if (h.f294717c == false) goto L8;
        n1.d("TemporaryDoraGUpdateManager", "no show dialog due to isDialogShowing");
        return Unit.INSTANCE;
    L8:
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        Boolean r102 = null;
        String r103 = null;
        if (r101 != null) goto L11;
    L30:
        StringBuilder r104 = new StringBuilder("no show dialog due to activity is ");
        r104.append(r101);
        r104.append(">>>> ");
        if (r101 == null) goto L33;
        r102 = Boxing.boxBoolean(r101.isFinishing());
    L33:
        r104.append(r102);
        r104.append(", ");
        n1.d("TemporaryDoraGUpdateManager", r104.toString());
        return Unit.INSTANCE;
    L11:
        if (r101.isFinishing() == true) goto L30;
        h r105 = h.f294715a;
        t r106 = h.c().f510342b;
        if (r106 == null) goto L16;
        String r107 = r106.f510355a;
    L17:
        t r108 = h.c().f510342b;
        if (r108 == null) goto L20;
        String r109 = r108.f510356b;
    L21:
        t r110 = h.c().f510342b;
        if (r110 == null) goto L24;
        String r111 = r110.f510358d;
    L25:
        t r112 = h.c().f510342b;
        if (r112 == null) goto L28;
        r103 = r112.f510357c;
    L28:
        i r113 = new i(r107, r109, r111, r103);
        final int r114 = this.$source;
        c r115 = new c(r101, r113, new e(r114), new f(r114));
        r115.setOnDismissListener(new g());
        new WeakReference(r115);
        h.f294717c = true;
        Keva r116 = DoraConfig.f331707a;
        DoraConfig.f331707a.storeLong("key_g_update_cancel_time", System.currentTimeMillis());
        INVOKEVIRTUAL_com_larus_avlink_update_TemporaryDoraGUpdateManager$showUpdateDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r115);
        return Unit.INSTANCE;
    L24:
        r111 = null;
        goto L25
    L20:
        r109 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
