package com.obric.assistant.util;

import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrResultValue;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes33.dex */
public final class k2 implements com.larus.bmhome.chat.component.bottom.core.speaker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f393759a;

    public k2() {
        this.f393759a = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.b
    public final void a(y58.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.b
    public final void q(AsrLifeState r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "lifeState");
        if (r100 == AsrLifeState.ASR_RESULT) goto L5;
        this.f393759a = true;
        return;
    L5:
        if (r102 == null) goto L7;
        String r103 = r102.get("res_text");
    L8:
        if (r102 == null) goto L10;
        String r104 = r102.get("res_type");
    L12:
        if (Intrinsics.areEqual(r104, AsrResultValue.FINAL_ASR.getValue()) == false) goto L20;
        if (com.larus.utils.o0.d(r103) == false) goto L20;
        IAgentVoiceInteractionIDL r105 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r105 == null) goto L18;
        r105.onAsrEnd();
    L18:
        this.f393759a = true;
        return;
    L20:
        if (this.f393759a == true) goto L22;
        return;
    L22:
        if (com.larus.utils.o0.d(r103) == false) goto L30;
        this.f393759a = false;
        IAgentVoiceInteractionIDL r106 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r106 == null) goto L31;
        r106.onAsrStart(null);
        return;
    L31:
        return;
    L30:
        return;
    L10:
        r104 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    }
}
