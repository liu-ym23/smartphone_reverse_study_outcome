package com.larus.audio.call.aec;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f288966a;

    public /* synthetic */ d(f r100) {
        this.f288966a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f288966a;
        if (r100.f288971c == false) goto L5;
        return;
    L5:
        if (r100.f288976h == true) goto L11;
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        String r102 = r100.f288970b;
        StringBuilder r103 = new StringBuilder("[startProcess] running, queue is null: ");
        if (r100.f288972d != null) goto L9;
        boolean r104 = true;
    L10:
        r103.append(r104);
        r101.i(r102, r103.toString());
        r100.f288976h = true;
        goto L11
    L9:
        r104 = false;
    L11:
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r105 = r100.f288972d;
        if (r105 == null) goto L14;
    L16:
        if (r105 != null) goto L18;
    L20:
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r106 = r100.f288972d;
        if (r106 == null) goto L46;
        SAMICoreVoiceAssistantAudioData r107 = r106.poll();
        if (r107 == null) goto L52;
        SAMICoreBlock r108 = new SAMICoreBlock();
        r108.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r108.audioData = new SAMICoreVoiceAssistantAudioData[]{r107};
        r108.numberAudioData = 1;
        SAMICoreBlock r109 = new SAMICoreBlock();
        if (r100.f288971c == false) goto L30;
        com.larus.audio.call.util.e.f289645a.i(r100.f288970b, "[startProcess] destroy");
        Function1<? super byte[], Unit> r110 = r100.f288973e;
        if (r110 == null) goto L47;
        r110.invoke(null);
        return;
    L47:
        return;
    L30:
        int r111 = r100.f288969a.SAMICoreProcess(r108, r109);
        if (r111 == 0) goto L38;
        if (r111 == 150009) goto L38;
        com.larus.audio.call.util.e.f289645a.i(r100.f288970b, "[startProcess] fail");
        Function1<? super byte[], Unit> r112 = r100.f288973e;
        if (r112 == null) goto L38;
        r112.invoke(null);
    L38:
        if (r109.dataType != SAMICoreDataType.SAMICoreDataType_AudioBin) goto L49;
        Object[] r113 = r109.audioData;
        if (r113 == null) goto L50;
        Object r114 = r113[0];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.mammon.audiosdk.structures.SAMICoreAudioBin");
        SAMICoreAudioBin r115 = (SAMICoreAudioBin) r114;
        Function1<? super byte[], Unit> r116 = r100.f288973e;
        if (r116 == null) goto L51;
        r116.invoke(r115.audioData);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    L46:
        return;
    L18:
        if (r100.f288975g == true) goto L20;
        com.larus.audio.call.util.e.f289645a.e(r100.f288970b, "[startProcess] queue valid");
        r100.f288975g = true;
        goto L20
    L14:
        if (r100.f288975g == false) goto L16;
        com.larus.audio.call.util.e.f289645a.e(r100.f288970b, "[startProcess] queue error");
        r100.f288975g = false;
        goto L20
    }
}
