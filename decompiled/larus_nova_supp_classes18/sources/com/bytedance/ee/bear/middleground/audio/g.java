package com.bytedance.ee.bear.middleground.audio;

import android.app.Application;
import com.bytedance.ee.bear.contract.i0;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.VoiceInputService;
import com.ss.android.lark.audio.voiceinput.m;
import com.ss.android.lark.audio.voiceinput.n;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.audio.voiceinput.processor.VoiceDataProcessDispatcher;
import com.ss.android.lark.audio.voiceinput.r;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.service.o;
import com.ss.android.lark.log.Log;
import e0c.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements i {
    public static final g a = null;
    public static r b;
    public static CoroutineScope c;
    public static final String d = null;

    public static final class a implements com.ss.android.lark.audio.voiceinput.i {
        public final /* synthetic */ Function3<String, Boolean, int[], Unit> a;

        public final void b() {
        }

        public final void c() {
            tt5.a.h("AudioRecordSdk", "startAudioRecord(), onSessionBegin");
        }

        public final void d() {
            tt5.a.h("AudioRecordSdk", "startAudioRecord(), onLastAsrRequest");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function3<? super String, ? super Boolean, ? super int[], Unit> r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.audio.voiceinput.c r4) {
            Intrinsics.checkNotNullParameter(r4, "asrResult");
            tt5.a.h("AudioRecordSdk", "startAudioRecord(),onUpdateAsrResult, code = " + r4.f + ", msg = " + r4.c);
            Function3<String, Boolean, int[], Unit> r0 = this.a;
            String r1 = r4.c;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            Boolean r2 = Boolean.valueOf(r4.d);
            int[] r5 = r4.e;
            if (r5 != null) goto L8;
            r5 = new int[0];
        L8:
            r0.invoke(r1, r2, r5);
        }

        public final void e(boolean r3, com.ss.android.lark.audio.voiceinput.c r4) {
            Intrinsics.checkNotNullParameter(r4, "asrResult");
            Intrinsics.checkNotNullParameter(r4, "asrResult");
            tt5.a.h("AudioRecordSdk", "onSessionEnded, code = " + r4.f + ", msg = " + r4.c);
            Function3<String, Boolean, int[], Unit> r5 = this.a;
            String r0 = r4.c;
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            Boolean r1 = Boolean.valueOf(r4.d);
            int[] r6 = r4.e;
            if (r6 != null) goto L8;
            r6 = new int[0];
        L8:
            r5.invoke(r0, r1, r6);
        }
    }

    public g() {
    }

    static {
        a = new g();
        String r0 = "zh_cn";
        d = "zh_cn";
        String r1 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        d = r0;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void u() {
        tt5.a.h("AudioRecordSdk", "stopAudioRecord()");
        r r0 = b;
        if (r0 == null) goto L11;
        VoiceInputService r1 = r0.b;
        if (r1 == null) goto L9;
        com.ss.android.lark.audio.voiceinput.d r2 = r1.b;
        if (r2 == null) goto L9;
        r1.a.e.a();
        r2.w.stopRecord();
    L9:
        Log.i("VoiceInputSdk", "[VoiceInputSdk]stop");
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void v() {
        tt5.a.h("AudioRecordSdk", "cancelAudioRecord()");
        r r0 = b;
        if (r0 == null) goto L11;
        VoiceInputService r1 = r0.b;
        if (r1 == null) goto L9;
        com.ss.android.lark.audio.voiceinput.d r2 = r1.b;
        if (r2 == null) goto L9;
        r1.a.e.a();
        r2.w.a();
    L9:
        Log.i("VoiceInputSdk", "[VoiceInputSdk]cancel");
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void w() {
        tt5.a.h("AudioRecordSdk", "initAudioRecord(), isUseNewAudioRecord = true");
        if (b == null) goto L6;
        return;
    L6:
        if (c != null) goto L17;
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    L17:
        Application r1 = com.larksuite.framework.utils.b.a;     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L14
        IAudioService r7 = (IAudioService) k.a(r1, IAudioService.class);     // Catch: Exception -> L14
        l r8 = (l) k.a(r1, l.class);     // Catch: Exception -> L14
        o r9 = (o) k.a(r1, o.class);     // Catch: Exception -> L14
        CoroutineScope r4 = c;     // Catch: Exception -> L14
        if (r4 != null) goto L11;
        CoroutineScope r6 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));     // Catch: Exception -> L14
    L12:
        n r2 = new n(r6, r7, r8, r9, new f());     // Catch: Exception -> L14
        m r3 = new m();     // Catch: Exception -> L14
        r r5 = new r();     // Catch: Exception -> L14
        b = r5;     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r2, "dependency");     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r3, "config");     // Catch: Exception -> L14
        r5.d = r3;     // Catch: Exception -> L14
        r5.c = r2;     // Catch: Exception -> L14
        return;
    L11:
        r6 = r4;
    L14:
        e = move-exception;
        tt5.a.d("AudioRecordSdk", "init voice input sdk failed, e = " + e.getMessage());
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void x() {
        tt5.a.h("AudioRecordSdk", "destroyAudioRecord()");
        r r1 = b;
        if (r1 != null) goto L6;
        tt5.a.h("AudioRecordSdk", "destroyAudioRecord(), voiceInputSdk is null");
        return;
    L6:
        VoiceInputService r0 = r1.b;
        if (r0 == null) goto L15;
        com.ss.android.lark.audio.voiceinput.d r2 = r0.b;
        if (r2 == null) goto L11;
        r2.h.a();
        r2.a.onDestroy();
    L11:
        VoiceDataProcessDispatcher r3 = r0.c;
        if (r3 == null) goto L14;
        r3.onDestroy();
    L14:
        r0.g();
        r0.g = AsrSessionState.AsrSessionIdle;
        r0.h = null;
        r0.i = 0;
    L15:
        Log.i("VoiceInputSdk", "[VoiceInputSdk]destroy");
        b = null;
        CoroutineScope r4 = c;
        if (r4 == null) goto L18;
        CoroutineScopeKt.cancel$default(r4, null, 1, null);
    L18:
        c = null;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void y(String r26, Function3<? super String, ? super Boolean, ? super int[], Unit> r27) {
        Intrinsics.checkNotNullParameter(r26, "speechLocale");
        Intrinsics.checkNotNullParameter(r27, "askCallCallBack");
        r r1 = b;
        String r2 = "AudioRecordSdk";
        if (r1 != null) goto L6;
        tt5.a.h("AudioRecordSdk", "startAudioRecord(), voiceInputSdk == null");
        return;
    L6:
        a r3 = new a(r27);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.a = r3;
        r r0 = b;
        if (r0 == null) goto L28;
        p r4 = new p(VoiceInputMode.OnlyAsr, VoiceInputScene.UniverseSearch);
        String r11 = d;
        int r5 = r.e;
        Intrinsics.checkNotNullParameter(r4, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r11, "appLocale");
        Intrinsics.checkNotNullParameter("LARK-PSDA-messenger_record_audio", "psdaToken");
        n r6 = r0.c;
        if (r6 == null) goto L25;
        m r7 = r0.d;
        if (r7 == null) goto L25;
        if (r0.b != null) goto L20;
        CoroutineScope r8 = r6.a;
        IAudioService r9 = r6.b;
        l r10 = r6.c;
        o r12 = r6.d;
        com.ss.android.lark.audio.voiceinput.h r13 = r6.e;
        String r14 = r7.c;
        String r15 = r4.b.toString();
        boolean r16 = r7.a;
        boolean r17 = r7.b;
        Boolean r18 = r7.e;
        if (r18 == null) goto L18;
        boolean r19 = r18.booleanValue();
    L19:
        String r20 = "VoiceInputSdk";
        VoiceInputService r110 = new VoiceInputService(new com.ss.android.lark.audio.voiceinput.processor.h(r8, r9, r10, r12, r13, r11, r14, r15, "LARK-PSDA-messenger_record_audio", r16, r17, r19, true, null, r0.a, r7.f, r7.g));
        r110.d();
        r0.b = r110;
    L21:
        VoiceInputService r21 = r0.b;
        if (r21 == null) goto L26;
        Log.i(r20, "[VoiceInputSdk]start");
        boolean r22 = r21.e(r4, false, "un_auto");
    L27:
        Boolean r23 = Boolean.valueOf(r22);
    L29:
        tt5.a.h(r2, "startAudioRecord() ,startResult = " + r23);
        return;
    L26:
        r22 = false;
        goto L27
    L18:
        r19 = true;
        goto L19
    L20:
        r20 = "VoiceInputSdk";
    L25:
        r2 = "AudioRecordSdk";
        Log.e("VoiceInputSdk", "VoiceInputDependency or VoiceInputConfig is null");
        goto L26
    L28:
        r2 = "AudioRecordSdk";
        r23 = null;
        goto L29
    }
}
