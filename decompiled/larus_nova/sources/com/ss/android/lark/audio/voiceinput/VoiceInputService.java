package com.ss.android.lark.audio.voiceinput;

import android.os.SystemClock;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.perf.VoiceInputAppreciablePerformance;
import com.ss.android.lark.audio.voiceinput.processor.ProcessType;
import com.ss.android.lark.audio.voiceinput.processor.VoiceDataProcessDispatcher;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceInputService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.processor.h f409180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f409181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VoiceDataProcessDispatcher f409182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.utils.a f409183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f409184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f409185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AsrSessionState f409186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f409187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f409188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.android.lark.audio.voiceinput.c f409189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f409190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VoiceInputService$_speechRecognitionEventPushListener$1 f409191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f409192m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409194a = null;

        static {
            int[] r100 = new int[VoiceInputMode.values().length];
            r100[VoiceInputMode.VoiceAndAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[VoiceInputMode.OnlyVoice.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[VoiceInputMode.SecondVoice.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[VoiceInputMode.OnlyAsr.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f409194a = r100;
        }
    }

    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInputService f409195a;

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void b() {
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void j() {
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void c() {
            j r100 = this.f409195a.f409180a.f409373n;
            if (r100 == null) goto L6;
            r100.c();
            return;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void d() {
            j r100 = this.f409195a.f409180a.f409373n;
            if (r100 == null) goto L5;
            r100.d();
        L5:
            VoiceInputAppreciablePerformance.f(true);
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void f() {
            i r100 = this.f409195a.f409180a.f409374o;
            if (r100 == null) goto L5;
            r100.c();
        L5:
            int r101 = VoiceInputAppreciablePerformance.f409284a;
            VoiceDataProcessDispatcher r102 = this.f409195a.f409182c;
            if (r102 == null) goto L8;
            String r103 = r102.i();
        L9:
            VoiceInputAppreciablePerformance.c(true, false, r103, null);
            return;
        L8:
            r103 = null;
            goto L9
        }

        public c(VoiceInputService r100) {
            this.f409195a = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void e(com.ss.android.lark.audio.voiceinput.c r100) {
            Intrinsics.checkNotNullParameter(r100, "asrResult");
            this.f409195a.f409180a.getClass();
            String r101 = r100.f409209c;
            boolean r102 = r100.f409210d;
            int r103 = r100.f409212f;
            VoiceInputService r104 = this.f409195a;
            r104.f409189j = r100;
            if (r104.f409186g.isAsrSessionRunning() == true) goto L6;
            Log.i("VoiceInputService", "[VoiceInputService]onAsrResult: asrSessionState is end, ignore this asr result");
            return;
        L6:
            VoiceInputAppreciablePerformance.d(r102, r101, r103);
            if (r102 == false) goto L9;
            this.f409195a.h(false, r100);
            return;
        L9:
            final VoiceInputService r105 = this.f409195a;
            if (r105.f409186g != AsrSessionState.AsrSessionWaitRecognizing) goto L31;
            String r106 = r105.f409187h;
            if (r106 == null) goto L31;
            String r107 = r100.f409207a;
            if (r107 == null) goto L31;
            if (Intrinsics.areEqual(r107, r106) == false) goto L31;
            r105.f409188i++;
            int r108 = ((Number) VoiceInputConstants.f409175b.getValue()).intValue();
            if (r108 <= 0) goto L31;
            if (r105.f409188i < r108) goto L31;
            r105.f409188i = 0;
            Log.i("VoiceInputService", "reset asr timeout and waiting tips, sourceId:" + r107 + ", sequenceId:" + r100.f409208b + ", threshold:" + r108);
            i r109 = r105.f409180a.f409374o;
            if (r109 == null) goto L30;
            r109.b();
        L30:
            r105.c(new VoiceInputService$resetAsrTimeoutAfterEnoughMiddleResultsIfNeeded$1(r105));
        L31:
            i r110 = this.f409195a.f409180a.f409374o;
            if (r110 == null) goto L36;
            r110.a(r100);
            return;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recordingDevice");
            this.f409195a.f409190k = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void h(int r100) {
            VoiceInputService r101 = this.f409195a;
            s r102 = r101.f409185f;
            if (r102 == null) goto L7;
            r102.f409392c = r100;
            j r103 = r101.f409180a.f409373n;
            if (r103 == null) goto L7;
            r103.e(r102);
        L7:
            VoiceInputAppreciablePerformance.f(false);
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void a(int r100, boolean r101) {
            j r102 = this.f409195a.f409180a.f409373n;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void k(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            j r102 = this.f409195a.f409180a.f409373n;
            if (r102 == null) goto L5;
            r102.f(r100, r101);
        L5:
            VoiceInputAppreciablePerformance.g(r100, r101, false);
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void l(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            VoiceInputAppreciablePerformance.f409295l = r101;
            VoiceInputAppreciablePerformance.f409294k = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void m(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            VoiceDataProcessDispatcher r103 = this.f409195a.f409182c;
            String r104 = null;
            if (r103 == null) goto L7;
            Map<ProcessType, com.ss.android.lark.audio.voiceinput.processor.d> r105 = r103.f409341a;
            LinkedHashMap r106 = (LinkedHashMap) r105;
            com.ss.android.lark.audio.voiceinput.processor.d r107 = (com.ss.android.lark.audio.voiceinput.processor.d) r106.get(r103.f409342b);
            if (r107 == null) goto L7;
            r104 = r107.getUploadId();
        L7:
            int r108 = VoiceInputAppreciablePerformance.f409284a;
            if (r104 != null) goto L10;
            String r109 = "";
        L11:
            VoiceInputAppreciablePerformance.f409285b = r109;
            VoiceInputAppreciablePerformance.f409288e.a();
            VoiceInputAppreciablePerformance.f409289f.d();
            VoiceInputService r110 = this.f409195a;
            r110.f409185f = new s(r100, r101, r104);
            VoiceInputService r111 = this.f409195a;
            if (r102 != null) goto L14;
            r102 = "";
        L14:
            r111.f409190k = r102;
            s r112 = r111.f409185f;
            if (r112 == null) goto L19;
            j r113 = r111.f409180a.f409373n;
            if (r113 == null) goto L19;
            r113.b(r112);
        L19:
            VoiceInputService r114 = this.f409195a;
            r114.f409186g = AsrSessionState.AsrSessionRecording;
            r114.f409183d.c();
            return;
        L10:
            r109 = r104;
            goto L11
        }

        @Override // com.ss.android.lark.audio.voiceinput.f
        public final void i(ByteBuffer r100, ByteBuffer r101, double r102, int r103, boolean r104, double r105) {
            int r106 = 0;
            if (r100 == null) goto L7;
            byte[] r107 = r100.array();
            if (r107 == null) goto L7;
            int r108 = r107.length;
        L8:
            if (r101 == null) goto L12;
            byte[] r109 = r101.array();
            if (r109 == null) goto L12;
            r106 = r109.length;
        L12:
            VoiceInputAppreciablePerformance.f409284a = Math.max(VoiceInputAppreciablePerformance.f409284a, (int) r105);
            VoiceInputAppreciablePerformance.f409302s += r108;
            VoiceInputAppreciablePerformance.f409303t += r106;
            VoiceInputService r110 = this.f409195a;
            s r111 = r110.f409185f;
            if (r111 == null) goto L17;
            r111.f409393d = r102;
            r111.f409392c = r103;
            r111.f409394e = r105;
            j r112 = r110.f409180a.f409373n;
            if (r112 == null) goto L17;
            r112.g(r111);
        L17:
            if (r100 == null) goto L20;
            this.f409195a.f409183d.a(r100);
            return;
        L20:
            return;
        L7:
            r108 = 0;
            goto L8
        }
    }

    static {
    }

    public final void d() {
        VoiceDataProcessDispatcher r100 = new VoiceDataProcessDispatcher(this.f409180a);
        c r101 = this.f409192m;
        com.ss.android.lark.audio.voiceinput.processor.h r102 = this.f409180a;
        this.f409181b = new d(r100, r101, r102.f409369j, true, r102.f409367h, r102.f409368i, null);
        this.f409182c = r100;
    }

    public final void g() {
        Log.i("VoiceInputService", "[VoiceInputService]unregisterListener");
        this.f409180a.f409363d.x4(this.f409191l);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.ss.android.lark.audio.voiceinput.VoiceInputService$_speechRecognitionEventPushListener$1] */
    public VoiceInputService(com.ss.android.lark.audio.voiceinput.processor.h r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputContext");
        this.f409180a = r100;
        this.f409183d = new com.ss.android.lark.audio.voiceinput.utils.a();
        this.f409186g = AsrSessionState.AsrSessionIdle;
        this.f409190k = "";
        this.f409191l = new VoiceInputService$_speechRecognitionEventPushListener$1(this);
        this.f409192m = new c(this);
    }

    public static final void a(VoiceInputService r110) {
        com.ss.android.lark.audio.voiceinput.c r100 = r110.f409189j;
        if (r100 != null) goto L10;
        VoiceDataProcessDispatcher r101 = r110.f409182c;
        String r102 = null;
        if (r101 == null) goto L9;
        Map<ProcessType, com.ss.android.lark.audio.voiceinput.processor.d> r103 = r101.f409341a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        com.ss.android.lark.audio.voiceinput.processor.d r105 = (com.ss.android.lark.audio.voiceinput.processor.d) r104.get(r101.f409342b);
        if (r105 == null) goto L9;
        r102 = r105.getUploadId();
    L9:
        r100 = new com.ss.android.lark.audio.voiceinput.c(r102, 1, "", true, null, 10000, null, com.ss.android.lark.widget.richtext.c.a(), null, null, false);
    L10:
        int r106 = VoiceInputAppreciablePerformance.f409284a;
        VoiceInputAppreciablePerformance.d(true, r100.f409209c, 10000);
        r110.h(true, r100);
    }

    public final void c(Function0<Unit> r100) {
        this.f409186g = AsrSessionState.AsrSessionWaitRecognizing;
        Job r101 = this.f409184e;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        this.f409184e = BuildersKt.launch$default(this.f409180a.f409360a, Dispatchers.getIO(), null, new VoiceInputService$delayTriggerAsrTimeOut$1(this, r100, null), 2, null);
    }

    public final void f(String r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "languageKey");
        this.f409186g = AsrSessionState.AsrSessionSwitchLanguage;
        this.f409189j = null;
        if (r101 == null) goto L13;
        d r102 = this.f409181b;
        if (r102 == null) goto L7;
        r102.f409218a.d(r102.f409238u);
    L7:
        VoiceDataProcessDispatcher r103 = this.f409182c;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r100, "languageKey");
        Map<ProcessType, com.ss.android.lark.audio.voiceinput.processor.d> r104 = r103.f409341a;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        com.ss.android.lark.audio.voiceinput.processor.d r106 = (com.ss.android.lark.audio.voiceinput.processor.d) r105.get(r103.f409342b);
        if (r106 == null) goto L15;
        r106.j(r101, r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void h(boolean r100, com.ss.android.lark.audio.voiceinput.c r101) {
        i r102 = this.f409180a.f409374o;
        if (r102 == null) goto L5;
        r102.e(r100, r101);
    L5:
        VoiceDataProcessDispatcher r103 = this.f409182c;
        if (r103 == null) goto L8;
        r103.d(null);
    L8:
        com.ss.android.lark.audio.voiceinput.c r104 = this.f409189j;
        if (r104 == null) goto L11;
        String r105 = r104.f409209c;
    L13:
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        AsrSessionState r107 = AsrSessionState.AsrSessionEndNoText;
    L22:
        this.f409186g = r107;
        if (r100 == false) goto L25;
        int r108 = VoiceInputAppreciablePerformance.f409284a;
        VoiceInputAppreciablePerformance.e(false, !r106, CancelAsrTimeoutState.CancelByAsrTimeOut.info());
    L26:
        this.f409187h = null;
        this.f409188i = 0;
        return;
    L25:
        int r109 = VoiceInputAppreciablePerformance.f409284a;
        VoiceInputAppreciablePerformance.e(true, !r106, CancelAsrTimeoutState.CancelByFinish.info());
        goto L26
    L21:
        r107 = AsrSessionState.AsrSessionEndWithText;
        goto L22
    L15:
        if (r105.length() == 0) goto L18;
        r106 = false;
        goto L19
    L11:
        r105 = null;
        goto L13
    }

    public final void b(CancelAsrTimeoutState r100, boolean r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "cancelingState");
        Job r103 = this.f409184e;
        if (r103 == null) goto L17;
        Log.i("VoiceInputService", "[VoiceInputService]cancelAsrTimeOut by " + r100.info());
        boolean r104 = true;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        if (r101 == false) goto L9;
        AsrSessionState r105 = AsrSessionState.AsrSessionEndWithText;
    L10:
        this.f409186g = r105;
        if (r100 == CancelAsrTimeoutState.CancelByReset) goto L17;
        int r106 = VoiceInputAppreciablePerformance.f409284a;
        if (r100 == CancelAsrTimeoutState.CancelByFinish) goto L16;
        r104 = false;
    L16:
        VoiceInputAppreciablePerformance.e(r104, r101, r100.info());
        goto L17
    L9:
        r105 = AsrSessionState.AsrSessionEndNoText;
    L17:
        this.f409184e = null;
        this.f409187h = null;
        this.f409188i = 0;
    }

    public final boolean e(p r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "voiceInputModeWithScene");
        d r100 = this.f409181b;
        if (r100 != null) goto L5;
    L66:
        return true;
    L5:
        if (this.f409180a.f409364e.b() == true) goto L8;
        Log.i("VoiceInputService", "[VoiceInputService]failed to occupy resource");
        return false;
    L8:
        VoiceInputAppreciablePerformance.h();
        VoiceInputMode r101 = r110.f409282a;
        int[] r102 = b.f409194a;
        int r103 = r102[r101.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 == 3) goto L16;
        if (r103 != 4) goto L15;
        boolean r104 = true;
    L18:
        Log.i("VoiceInputService", "[VoiceInputService]startRecord needPreemptiveOptimize:" + r111 + " mode:" + r110.f409282a.info() + " shouldStartWithAsr:" + r104 + ' ');
        VoiceInputAppreciablePerformance.f409305v = r104;
        String r113 = r110.f409283b.toString();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        VoiceInputAppreciablePerformance.f409306w = r113;
        Log.i("VoiceInputService", "[VoiceInputService]registerListener");
        this.f409180a.f409363d.M3(this.f409191l);
        int r114 = r102[r110.f409282a.ordinal()];
        if (r114 == 1) goto L37;
        if (r114 == 2) goto L30;
        if (r114 == 3) goto L26;
        if (r114 == 4) goto L26;
        throw new NoWhenBranchMatchedException();
    L26:
        VoiceDataProcessDispatcher r115 = this.f409182c;
        if (r115 == null) goto L47;
        ProcessType r105 = ProcessType.OnlyAsr;
        Intrinsics.checkNotNullParameter(r105, "type");
        r115.f409342b = r105;
    L47:
        d.C4754d r116 = r100.f409240w;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "voiceInputModeWithScene");
        d.a(r116.f409256a);
        if (r116.c() == true) goto L50;
        boolean r117 = false;
    L64:
        if (r117 == true) goto L66;
        return false;
    L50:
        com.ss.android.lark.audio.recorder.c r106 = r116.f409256a.f409225h.f409079e;
        if (r106 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mRecorderConfig");
        r106 = null;
    L53:
        AtomicReference<String> r107 = AudioRecordSettings.f409071a;
        r106.f409112d = AudioRecordSettings.b(r110.f409282a.getInputMode()).getAudioRecordDataRequestInterval();
        r116.f409256a.f409231n = SystemClock.elapsedRealtime();
        d r108 = r116.f409256a;
        r108.f409232o = 0;
        r108.f409228k = false;
        r108.f409237t = null;
        int r118 = d.C4754d.a.f409257a[r110.f409282a.ordinal()];
        if (r118 == 1) goto L62;
        if (r118 == 2) goto L61;
        if (r118 == 3) goto L61;
        if (r118 != 4) goto L60;
        d r119 = r116.f409256a;
        r119.f409226i = false;
        r119.f409227j = false;
    L63:
        r116.f409256a.f409229l = UUID.randomUUID().toString();
        r116.f409256a.f409230m = t.a().getRealPath() + '/' + r116.f409256a.f409229l;
        r116.f409256a.f409218a.b();
        d r120 = r116.f409256a;
        r120.f409218a.d(r120.f409238u);
        d r121 = r116.f409256a;
        r121.f409218a.f(r121.f409230m, r121.f409229l, r121.f409226i, r121.f409227j, r112);
        d r122 = r116.f409256a;
        r117 = r122.f409225h.e(r122.f409230m, r122.f409239v);
        goto L64
    L60:
        throw new NoWhenBranchMatchedException();
    L61:
        d r123 = r116.f409256a;
        r123.f409226i = true;
        r123.f409227j = true;
        goto L63
    L62:
        d r124 = r116.f409256a;
        r124.f409226i = r104;
        r124.f409227j = false;
        goto L63
    L30:
        if (this.f409180a.f409372m == false) goto L34;
        VoiceDataProcessDispatcher r125 = this.f409182c;
        if (r125 == null) goto L47;
        ProcessType r109 = ProcessType.OnlyVoice;
        Intrinsics.checkNotNullParameter(r109, "type");
        r125.f409342b = r109;
        goto L47
    L34:
        VoiceDataProcessDispatcher r126 = this.f409182c;
        if (r126 == null) goto L47;
        ProcessType r127 = ProcessType.Extend;
        Intrinsics.checkNotNullParameter(r127, "type");
        r126.f409342b = r127;
        goto L47
    L37:
        VoiceDataProcessDispatcher r128 = this.f409182c;
        if (r128 == null) goto L40;
        ProcessType r129 = ProcessType.VoiceWithAsr;
        Intrinsics.checkNotNullParameter(r129, "type");
        r128.f409342b = r129;
    L40:
        if (r104 == false) goto L44;
        VoiceDataProcessDispatcher r130 = this.f409182c;
        if (r130 == null) goto L47;
        r130.a(ProcessType.VoiceWithAsr);
        goto L47
    L44:
        VoiceDataProcessDispatcher r131 = this.f409182c;
        if (r131 == null) goto L47;
        r131.a(ProcessType.OnlyVoice);
        goto L47
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r104 = false;
        goto L18
    L17:
        r104 = r111;
        goto L18
    }
}
