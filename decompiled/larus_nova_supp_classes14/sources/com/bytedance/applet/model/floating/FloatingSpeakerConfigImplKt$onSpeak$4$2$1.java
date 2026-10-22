package com.bytedance.applet.model.floating;

import android.app.Activity;
import android.view.Window;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.o0;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.floating.FloatingSpeakerConfigImplKt$onSpeak$4$2$1", f = "FloatingSpeakerConfigImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FloatingSpeakerConfigImplKt$onSpeak$4$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y4.c $ability;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $currentTaskId;
    final /* synthetic */ JSONObject $it;
    final /* synthetic */ Message $msg;
    final /* synthetic */ long $startTimeStamp;
    int label;

    public FloatingSpeakerConfigImplKt$onSpeak$4$2$1(String r1, wc9.e r2, y4.c r3, Message r4, JSONObject r5, long r6, Continuation<? super FloatingSpeakerConfigImplKt$onSpeak$4$2$1> r8) {
        this.$currentTaskId = r1;
        this.$conversation = r2;
        this.$ability = r3;
        this.$msg = r4;
        this.$it = r5;
        this.$startTimeStamp = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FloatingSpeakerConfigImplKt$onSpeak$4$2$1(this.$currentTaskId, this.$conversation, this.$ability, this.$msg, this.$it, this.$startTimeStamp, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r27);
        a4.a.getClass();
        a4.a(a4.b);
        String r1 = this.$currentTaskId;
        FloatingSpeakerConfigImplKt.e();
        z r2 = new z("FloatingSpeakerConfig-" + r1, z2.a.enableKeepScreenOnGuardLegacyScenes());
        FloatingSpeakerConfigImplKt.a = r2;
        if (r2.b == false) goto L7;
        fa9.e.a.a("voice_input", r2.a);
    L12:
        wc9.e r3 = this.$conversation;
        if (r3 == null) goto L16;
        String r4 = r3.a;
        if (r4 == null) goto L16;
    L17:
        String r6 = r4;
        boolean r5 = true;
        if (r3 == null) goto L26;
        Integer r7 = r3.f;
        if (r7 != null) goto L23;
    L25:
        r5 = false;
        goto L26
    L23:
        if (r7.intValue() != 1) goto L25;
    L26:
        AudioServiceDelegate r8 = AudioServiceDelegate.a;
        r8.x().f(r5);
        this.$ability.f = this.$currentTaskId;
        o0.a.b(r8.h0(), this.$msg, this.$currentTaskId, r6, null, zh8.a.c.S0(), this.$it, false, (String) this.$ability.b.invoke(), false, null, null, null, this.$startTimeStamp, null, null, null, null, 0, null, 520008);
        return Unit.INSTANCE;
    L16:
        r4 = "";
        goto L17
    L7:
        Activity r9 = AppHost.a.a().getCurrentActivity();
        if (r9 == null) goto L12;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L12;
        r10.addFlags(128);
        goto L12
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
