package com.bytedance.live.livelink.kmp.impl.core.audio;

import android.os.Handler;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mf2.a f255371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile StringBuilder f255372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f255373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f255374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mf2.h f255375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PthreadHandlerThreadV2 f255376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f255377g;

    public static final class a {
    }

    static {
    }

    public f(String r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f255373c = 10;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r104 = ILiveWrappedAudio.a.a();
        if (r104 == null) goto L5;
        mf2.h r105 = r104.newSAMICoreProperty();
    L6:
        this.f255375e = r105;
        int r106 = r101 / 100;
        JSONObject r107 = new JSONObject(r103);     // Catch: Exception -> L15
        JSONObject r108 = new JSONObject(JSONObjectProtectorUtils.getString(r107, "SamiDiagnosisSwitch"));     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getBoolean(r108, "enable_score_report");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getBoolean(r108, "enable_cutoff_frequency_report");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getBoolean(r108, "enable_loudness_report");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getBoolean(r108, "enable_rms_stats_report");     // Catch: Exception -> L15
        int r109 = JSONObjectProtectorUtils.getInt(r108, "diagnosis_process_duration");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getInt(r108, "diagnosis_process_interval");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getInt(r108, "diagnosis_process_max_count");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getInt(r108, "diagnosis_process_start_time");     // Catch: Exception -> L15
        String r110 = JSONObjectProtectorUtils.getString(r107, "SamiDiagnosisParameters");     // Catch: Exception -> L15
        JSONObjectProtectorUtils.getString(r107, "SamiDiagnosisThresholds");     // Catch: Exception -> L15
        this.f255374d = JSONObjectProtectorUtils.getBoolean(r107, "SamiEnableDiagnosis");     // Catch: Exception -> L15
        JSONObject r111 = new JSONObject(r110);     // Catch: Exception -> L15
        r111.put(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r101);     // Catch: Exception -> L15
        r111.put("num_channel", r102);     // Catch: Exception -> L15
        r111.toString();     // Catch: Exception -> L15
        int r112 = JSONObjectProtectorUtils.getInt(r111, "duration");     // Catch: Exception -> L15
        this.f255373c = r112;     // Catch: Exception -> L15
        if (r112 >= 10) goto L11;
        this.f255373c = 10;     // Catch: Exception -> L15
    L13:
        int r113 = this.f255373c;     // Catch: Exception -> L15
        int r114 = ((r109 + r113) - 1) / r113;     // Catch: Exception -> L15
        return;
    L11:
        if (r112 <= 100) goto L13;
        this.f255373c = 100;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        int r115 = ej6.a.f472874a;
        ej6.a.b("SAMICoreCEAudioMetrics", "construct parse params error: " + e.getMessage());
        return;
    L5:
        r105 = null;
        goto L6
    }
}
