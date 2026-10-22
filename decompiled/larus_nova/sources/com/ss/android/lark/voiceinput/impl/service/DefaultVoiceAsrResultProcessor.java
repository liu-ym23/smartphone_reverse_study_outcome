package com.ss.android.lark.voiceinput.impl.service;

import com.ss.android.lark.voiceinput.api.data.context.VoiceScene;
import com.ss.android.lark.voiceinput.impl.service.repository.VoiceRepository;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class DefaultVoiceAsrResultProcessor implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xac.a f445082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceRepository f445083b;

    public DefaultVoiceAsrResultProcessor(xac.a r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceContext");
        this.f445082a = r100;
        this.f445083b = new VoiceRepository();
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.f
    public final Object a(zac.a r100, Continuation<? super zac.a> r110) {
        if ((r110 instanceof DefaultVoiceAsrResultProcessor$postProcessFinalResult$1) == false) goto L7;
        DefaultVoiceAsrResultProcessor$postProcessFinalResult$1 r101 = (DefaultVoiceAsrResultProcessor$postProcessFinalResult$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        zac.c r105 = (zac.c) r101.L$1;
        zac.a r106 = (zac.a) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L38:
        RichText r112 = (RichText) r111;
        if (r112 != null) goto L41;
        return r106;
    L41:
        r105.f571117b = r112;
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        VoiceRepository r113 = this.f445083b;
        if (r113 != null) goto L17;
        return r100;
    L17:
        String r107 = r100.f571111b.f571116a;
        if (r107 == null) goto L43;
        String r108 = null;
        if ((!StringsKt.isBlank(r107)) == true) goto L23;
        r107 = null;
    L23:
        if (r107 == null) goto L43;
        String r109 = this.f445082a.b("conversation_id");
        if (r109 == null) goto L43;
        if ((!StringsKt.isBlank(r109)) == false) goto L30;
        r108 = r109;
    L30:
        if (r108 == null) goto L43;
        VoiceScene r114 = (VoiceScene) this.f445082a.a("voice_scene", Reflection.getOrCreateKotlinClass(VoiceScene.class));
        if (r114 != null) goto L34;
        r114 = VoiceScene.Default;
    L34:
        zac.c r115 = r100.f571111b;
        r101.L$0 = r100;
        r101.L$1 = r115;
        r101.label = 1;
        r111 = r113.a(r108, r107, r114, r101);
        if (r111 != r103) goto L37;
        return r103;
    L37:
        r106 = r100;
        r105 = r115;
    L43:
        return r100;
    L7:
        r101 = new DefaultVoiceAsrResultProcessor$postProcessFinalResult$1(this, r110);
        goto L8
    }
}
