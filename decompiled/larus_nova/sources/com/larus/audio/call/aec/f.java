package com.larus.audio.call.aec;

import android.os.Handler;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAecContextParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f288968l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SAMICore f288969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f288971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> f288972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super byte[], Unit> f288973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f288974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f288975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f288976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f288977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f288978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f288979k;

    public static final class a {
        public static String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(com.larus.audio.call.f.c().appContext().getContext().getFilesDir().getAbsolutePath());
            r100.append(File.separator);
            if (t68.a.f544678a.c() == false) goto L5;
            String r101 = "speech_kws_model/aec_p_micro5_bin_20k_260901_multich_v4.0.model";
        L6:
            r100.append(r101);
            return r100.toString();
        L5:
            r101 = "aec_doubao_micro5_bin_20k_260418_v3.7.model";
            goto L6
        }
    }

    static {
    }

    public final void a() {
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[destroy]");
        Handler r100 = this.f288977i;
        if (r100 == null) goto L5;
        r100.post(new e(this));
    L5:
        this.f288978j.quitSafely();
    }

    public f() {
        this.f288969a = new SAMICore();
        this.f288970b = "AecModel";
        this.f288975g = true;
        this.f288978j = new PthreadHandlerThreadV2("background_aec");
        File r100 = com.larus.audio.call.f.c().appContext().getContext().getExternalFilesDir(null);
        if (r100 == null) goto L6;
        String r101 = r100.getAbsolutePath();
        if (r101 == null) goto L6;
    L7:
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        String r103 = File.separator;
        r102.append(r103);
        r102.append("audio");
        r102.append(r103);
        r102.append("speech-dump");
        r102.append(r103);
        this.f288979k = r102.toString();
        return;
    L6:
        r101 = "";
        goto L7
    }

    public final void b(v58.a r100, com.larus.audio.call.play.b r101, boolean r102, Function1<? super byte[], Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordConfig");
        Intrinsics.checkNotNullParameter(r101, "audioPlayConfig");
        Intrinsics.checkNotNullParameter(r103, "onAudioDataReceived");
        if (this.f288974f == false) goto L6;
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[init] return");
        return;
    L6:
        this.f288973e = r103;
        ThreadMethodProxy.start(this.f288978j);
        this.f288977i = new Handler(this.f288978j.getLooper());
        SAMICoreVoiceAssistantAecContextParameter r104 = new SAMICoreVoiceAssistantAecContextParameter();
        r104.modelPath = com.larus.audio.call.f.c().k();
        r104.refSampleRate = r101.f289297c;
        int r105 = 2;
        if (r101.f289298d != 12) goto L9;
        int r106 = 2;
    L10:
        r104.refNumberChannel = r106;
        r104.srcSampleRate = r100.f553275a;
        buc.a r107 = t68.a.f544678a;
        if (r107.c() == true) goto L13;
    L15:
        r105 = 1;
    L16:
        r104.srcNumberChannel = r105;
        if (r107.c() == true) goto L19;
    L21:
        int r108 = 1;
    L22:
        r104.enableFluteEngine = r108;
        if (com.larus.audio.call.f.d().f289127c.f289098a == false) goto L28;
        String r109 = com.larus.audio.call.f.d().f289127c.f289103f;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);
        if (r110.exists() == true) goto L27;
        r110.mkdirs();
    L27:
        r104.audioDumpPath = r109;
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[initSamiCore] dump enable: " + r109);
    L29:
        if (r102 == false) goto L39;
        HashMap<String, Object> r111 = com.larus.audio.call.f.d().f289139o;
        if (r111.containsKey("refFrameSize") == true) goto L34;
        r111.put("refFrameSize", Integer.valueOf(com.larus.audio.call.f.d().f289136l / 100));
    L34:
        if (r111.containsKey("selector_dump_path") == false) goto L36;
    L38:
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[initSamiCore] mic selector config" + r111);
        r104.micSelectConfig = GsonProtectorUtils.toJson(new Gson(), r111);
        goto L39
    L36:
        if (com.larus.audio.call.f.d().f289127c.f289098a == false) goto L38;
        r111.put("selector_dump_path", this.f288979k);
    L39:
        this.f288969a.setEnableSyncInterface(com.larus.audio.call.f.d().f289134j);
        int r112 = this.f288969a.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_RealtimeCall_Aec, r104);
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[initSamiCore] ret" + r112);
        if (r112 != 0) goto L44;
        this.f288974f = true;
        return;
    L44:
        return;
    L28:
        com.larus.audio.call.util.e.f289645a.i(this.f288970b, "[initSamiCore] dump not enable");
        goto L29
    L19:
        if (r100.f553276b != 12) goto L21;
        r108 = 4;
        goto L22
    L13:
        if (r100.f553276b != 12) goto L15;
    L9:
        r106 = 1;
        goto L10
    }
}
