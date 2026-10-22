package com.larus.bmhome.chat.component.bottom.voice.service;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.bmhome.utils.a4;
import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService$startVoiceMixInput$1", f = "VoiceMixInputService.kt", i = {}, l = {109, 145}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputService$startVoiceMixInput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function0<Unit> $onBeforeStart;
    final /* synthetic */ Function0<Unit> $onBeforeStop;
    final /* synthetic */ Function0<Unit> $onError;
    final /* synthetic */ Function0<Unit> $onTimeout;
    final /* synthetic */ f $param;
    final /* synthetic */ String $textContext;
    int label;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$startVoiceMixInput$1(VoiceMixInputService r100, Function0<Unit> r101, String r102, f r103, FragmentActivity r104, Function0<Unit> r105, Function0<Unit> r106, Function0<Unit> r107, Continuation<? super VoiceMixInputService$startVoiceMixInput$1> r108) {
        this.this$0 = r100;
        this.$onBeforeStart = r101;
        this.$textContext = r102;
        this.$param = r103;
        this.$activity = r104;
        this.$onTimeout = r105;
        this.$onError = r106;
        this.$onBeforeStop = r107;
        super(2, r108);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new VoiceMixInputService$startVoiceMixInput$1(this.this$0, this.$onBeforeStart, this.$textContext, this.$param, this.$activity, this.$onTimeout, this.$onError, this.$onBeforeStop, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceMixInputService$startVoiceMixInput$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.bmhome.chat.component.bottom.voice.service.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.larus.bmhome.chat.component.bottom.voice.service.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.larus.bmhome.chat.component.bottom.voice.service.j] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.bmhome.chat.component.bottom.voice.service.c0, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L28:
        int r102 = d0.f300410d;
        d0.a.a("real startVoiceMixInput");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L25:
        final VoiceMixInputManager r103 = (VoiceMixInputManager) this.this$0.f300462b.getValue();
        final String r111 = this.$textContext;
        final f r104 = this.$param;
        final String r105 = r104.f300483a;
        final String r106 = r104.f300484b;
        final String r107 = r104.f300485c;
        final FragmentActivity r112 = this.$activity;
        final VoiceMixInputService r108 = this.this$0;
        final Function0<Unit> r113 = this.$onTimeout;
        final ?? r114 = new y(r108, r104, r113, r111);
        final ?? r115 = new z(r108);
        final ?? r116 = new a0(r111, r108);
        final ?? r109 = new b0(r108, r111);
        final Function0<Unit> r117 = this.$onError;
        final Function0<Unit> r118 = this.$onBeforeStop;
        final ?? r119 = new c0(r117, r108, r118);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r111, "textContext");
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        Intrinsics.checkNotNullParameter(r106, "itemId");
        Intrinsics.checkNotNullParameter(r107, "botId");
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(r114, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r115, "onAudioData");
        Intrinsics.checkNotNullParameter(r116, "onStream");
        Intrinsics.checkNotNullParameter(r109, "onSuccess");
        Intrinsics.checkNotNullParameter(r119, "onFail");
        int r120 = d0.f300410d;
        d0.a.a("start voice mix input");
        final ?? r121 = new j(r103, r105, r106, r107, r112, r111, r114, r115, r116, r109, r119);
        List<String> r122 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        i2.f365748b.a(r112, r122, new n(r121, r119));
        a4.f314971a.getClass();
        a4.a(a4.f314972b);
        z0<g> r123 = this.this$0.c();
        this.this$0.getClass();
        g r124 = new g(true, VoiceMixInputService.d());
        this.label = 2;
        if (r123.emit(r124, this) != r100) goto L28;
        return r100;
    L10:
        ResultKt.throwOnFailure(r110);
        g r125 = this.this$0.c().getValue();
        if (r125 != null) goto L13;
    L15:
        boolean r126 = false;
    L16:
        if (r126 == true) goto L18;
        this.$onBeforeStart.invoke();
        VoiceMixInputService r127 = this.this$0;
        this.label = 1;
        Object r128 = ((z0) r127.f300463c.getValue()).emit(new byte[0], this);
        if (r128 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r128 = Unit.INSTANCE;
    L23:
        if (r128 != r100) goto L25;
        return r100;
    L18:
        return Unit.INSTANCE;
    L13:
        if (r125.f300488a != true) goto L15;
        r126 = true;
        goto L16
    }

    public static final /* synthetic */ Object access$invokeSuspend$lambda$4$suspendConversion0(Function0 r100, Continuation r101) {
        r100.invoke();
        return Unit.INSTANCE;
    }
}
