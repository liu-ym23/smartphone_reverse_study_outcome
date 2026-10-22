package com.bytedance.applet.view;

import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.applet.databinding.LarusAppletWebBrowserBinding;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$floatingSpeakerController$1$updateInputPlaceHolder$1", f = "AppletFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletFragment$floatingSpeakerController$1$updateInputPlaceHolder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    int label;
    final /* synthetic */ AppletFragment this$0;

    public AppletFragment$floatingSpeakerController$1$updateInputPlaceHolder$1(String r1, AppletFragment r2, Continuation<? super AppletFragment$floatingSpeakerController$1$updateInputPlaceHolder$1> r3) {
        this.$content = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletFragment$floatingSpeakerController$1$updateInputPlaceHolder$1(this.$content, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        FLogger.a.d("FloatingSpeaker", "updateInputPlaceHolder " + this.$content);
        LarusAppletWebBrowserBinding r4 = this.this$0.f;
        if (r4 == null) goto L10;
        FloatingSpeakerView r5 = r4.f;
        if (r5 == null) goto L10;
        r5.setPlaceHolder(this.$content);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
