package com.bytedance.speech.speechengine;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.Build;
import android.view.SurfaceView;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.speech.speechengine.bridge.SpeechBridge;
import com.bytedance.speech.speechengine.bridge.SpeechBridgeCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements SpeechEngine, SpeechBridgeCallback {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static gf7.a f270320l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpeechEngine.SpeechListener f270321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f270322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f270323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f270324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f270325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f270326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f270327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f270328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f270329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f270330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SpeechBridge f270331k;

    public final synchronized boolean b() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.f270324d == true) goto L8;
        monitor-exit(this);
        return true;
    L8:
        Context r100 = this.f270326f;     // Catch: Throwable -> L21
        if (r100 != null) goto L12;
    L19:
        monitor-exit(this);
        return true;
    L12:
        if (r100.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0) goto L15;
        monitor-exit(this);
        return false;
    L15:
        if (((AudioManager) this.f270326f.getSystemService("audio")).getMode() == 0) goto L19;
        monitor-exit(this);
        return false;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized long createEngine() {
        monitor-enter(this);
        destroyEngine(this.f270325e);     // Catch: Throwable -> L6
        long r100 = this.f270331k.createEngineToNative(this);     // Catch: Throwable -> L6
        this.f270325e = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void destroyEngine() {
        monitor-enter(this);
        long r100 = this.f270325e;     // Catch: Throwable -> L13
        if (r100 == (-1)) goto L6;
        this.f270331k.destroyEngineToNative(r100);     // Catch: Throwable -> L13
        this.f270325e = -1;     // Catch: Throwable -> L13
        gf7.a r101 = f270320l;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        r101.b(this.f270322b, -1, "", 0);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L6:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int initEngine() {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L10;
        monitor-exit(this);
        return -1;
    L10:
        if (this.f270327g == false) goto L12;
        AssetManager r100 = this.f270326f.getResources().getAssets();     // Catch: Throwable -> L42
    L14:
        if (this.f270328h == 8192) goto L16;
    L18:
        Context r101 = this.f270326f;     // Catch: Throwable -> L42
        if (r101 == null) goto L21;
        setOptionString("tracking_data_path", r101.getFilesDir().getPath());     // Catch: Throwable -> L42
        setOptionString("settings_file_dir", this.f270326f.getFilesDir().getPath());     // Catch: Throwable -> L42
    L21:
        int r102 = this.f270328h;     // Catch: Throwable -> L42
        if (r102 != 1024) goto L24;
    L34:
        int r103 = this.f270331k.initEngineToNative(this.f270325e, r100);     // Catch: Throwable -> L42
        if (r103 != 0) goto L37;
        setOptionString("device_info", hf7.a.f484925a);     // Catch: Throwable -> L42
    L37:
        gf7.a r104 = f270320l;     // Catch: Throwable -> L42
        if (r104 == null) goto L40;
        r104.b(this.f270322b, 0, "", r103);     // Catch: Throwable -> L42
    L40:
        monitor-exit(this);
        return r103;
    L24:
        if (r102 == 16384) goto L34;
        if (this.f270330j != SpeechEngineDefines.AUTHENTICATE_TYPE_LATE_BIND) goto L34;
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L42
        if (r105 < 26) goto L34;
        if (r105 >= 29) goto L34;
        if (this.f270326f.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) goto L34;
        goto L34
    L16:
        if (this.f270329i == false) goto L18;
        setOptionInt(SpeechEngineDefines.PARAMS_KEY_TTS_WITH_FRONTEND_INT, 1);     // Catch: Throwable -> L42
        setOptionString(SpeechEngineDefines.PARAMS_KEY_TTS_FRONTEND_TYPE_STRING, "tnSimple");     // Catch: Throwable -> L42
        goto L18
    L12:
        r100 = null;
        goto L14
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int resetEngine() {
        monitor-enter(this);
        long r100 = this.f270325e;     // Catch: Throwable -> L12
        if (r100 != (-1)) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        int r101 = this.f270331k.resetEngineToNative(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setRemoteView(SurfaceView r100) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public static synchronized gf7.a d() {
        monitor-enter(a.class);
        gf7.a r100 = f270320l;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final String getVersion() {
        return this.f270331k.getVersionToNative();
    }

    static {
        SpeechEngineLoader.getInstance().load();
    }

    public a() {
        this.f270321a = null;
        this.f270322b = "";
        this.f270323c = SpeechEngineDefines.RECORDER_TYPE_RECORDER;
        this.f270324d = true;
        this.f270325e = -1;
        this.f270326f = null;
        this.f270327g = false;
        this.f270328h = 1024;
        this.f270329i = true;
        this.f270330j = "";
        this.f270331k = SpeechEngineLoader.getInstance().createBridge();
    }

    public static synchronized void a(gf7.a r100) {
        monitor-enter(a.class);
        f270320l = r100;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean c(int r100) {
        if (this.f270323c.equals(SpeechEngineDefines.RECORDER_TYPE_RECORDER) == true) goto L5;
        return false;
    L5:
        String r101 = this.f270322b;
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case -1511396501: goto L37;
            case -1332085432: goto L33;
            case -1018583194: goto L29;
            case -799233858: goto L25;
            case 3124: goto L21;
            case 96896: goto L17;
            case 3046114: goto L13;
            case 1331753737: goto L9;
            default: goto L40;
        };
    L40:
        switch(r102) {
            case 0: goto L47;
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L43;
            case 5: goto L43;
            case 6: goto L43;
            case 7: goto L43;
            default: goto L41;
        };
    L41:
        return false;
    L43:
        if (r100 != 1000) goto L52;
        return true;
    L52:
        return false;
    L47:
        if (r100 != 2011) goto L49;
    L50:
        return true;
    L49:
        if (r100 == 2012) goto L50;
        return false;
    L9:
        if (r101.equals(SpeechEngineDefines.FULLLINK_ENGINE) == false) goto L40;
        r102 = 7;
        goto L40
    L13:
        if (r101.equals(SpeechEngineDefines.CAPT_ENGINE) == false) goto L40;
        r102 = 6;
        goto L40
    L17:
        if (r101.equals("asr") == false) goto L40;
        r102 = 5;
        goto L40
    L21:
        if (r101.equals(SpeechEngineDefines.AU_ENGINE) == false) goto L40;
        r102 = 4;
        goto L40
    L25:
        if (r101.equals(SpeechEngineDefines.RECORDER_ENGINE) == false) goto L40;
        r102 = 3;
        goto L40
    L29:
        if (r101.equals(SpeechEngineDefines.VOICECONV_ENGINE) == false) goto L40;
        r102 = 2;
        goto L40
    L33:
        if (r101.equals("dialog") == false) goto L40;
        r102 = 1;
        goto L40
    L37:
        if (r101.equals(SpeechEngineDefines.VOICECLONE_ENGINE) == false) goto L40;
        r102 = 0;
        goto L40
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void destroyEngine(long r100) {
        monitor-enter(this);
        destroyEngine();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized String fetchResult(int r100) {
        monitor-enter(this);
        long r101 = this.f270325e;     // Catch: Throwable -> L11
        if (r101 == (-1)) goto L6;
        String r102 = this.f270331k.fetchStringResultToNative(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L6:
        monitor-exit(this);
        return "{\"err_code\":-1}";
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final String getVersion(long r100) {
        return getVersion();
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int initEngine(long r100) {
        monitor-enter(this);
        int r101 = initEngine();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized boolean isEngineSupported(String r100) {
        monitor-enter(this);
        boolean r101 = SpeechEngineLoader.getInstance().createBridge().isEngineSupportedToNative(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int resetEngine(long r100) {
        monitor-enter(this);
        int r101 = resetEngine();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setContext(Context r100) {
        monitor-enter(this);
        this.f270326f = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setListener(SpeechEngine.SpeechListener r100) {
        monitor-enter(this);
        this.f270321a = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int feedAudio(byte[] r100, int r101) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L10;
        monitor-exit(this);
        return -1;
    L10:
        if (this.f270322b.equals(SpeechEngineDefines.AFP_ENGINE) == false) goto L14;
        int r102 = this.f270331k.processAudioToNative(this.f270325e, r100, r101, true);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r102;
    L14:
        int r103 = this.f270331k.feedAudioToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r103;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int fetchResult(long r100, byte[] r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f270322b.equals(SpeechEngineDefines.AFP_ENGINE) == false) goto L8;
        int r102 = fetchResult(1200, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        monitor-exit(this);
        return SpeechEngineDefines.ERR_UNKNOWN_RESULT_TYPE;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int sendDirective(int r100, String r101) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L10;
        monitor-exit(this);
        return -1;
    L10:
        if (c(r100) == true) goto L12;
    L14:
        int r102 = this.f270331k.sendDirectiveToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L20
    L15:
        gf7.a r103 = f270320l;     // Catch: Throwable -> L20
        if (r103 == null) goto L18;
        r103.b(this.f270322b, r100, r101, r102);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r102;
    L12:
        if (b() == true) goto L14;
        r102 = SpeechEngineDefines.ERR_REC_CHECK_ENVIRONMENT_FAILED;
        goto L15
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionBoolean(String r100, boolean r101) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (this.f270325e == (-1)) goto L6;
        if (r100 == null) goto L10;
        int r102 = r100.hashCode();     // Catch: Throwable -> L32
        if (r102 == 941586385) goto L21;
        if (r102 == 1724100682) goto L18;
    L23:
        byte r103 = -1;
    L24:
        if (r103 == 0) goto L28;
        if (r103 != 1) goto L29;
        this.f270329i = r101;     // Catch: Throwable -> L32
    L29:
        this.f270331k.setOptionBooleanToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L28:
        this.f270324d = r101;     // Catch: Throwable -> L32
        goto L29
    L18:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_ENABLE_CHECK_RECORD_PERMISSION_BOOL) == false) goto L23;
        r103 = 0;
        goto L24
    L21:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_TTS_ENABLE_PLAYER_BOOL) == false) goto L23;
        r103 = 1;
        goto L24
    L10:
        monitor-exit(this);
        return;
    L6:
        monitor-exit(this);
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionDouble(String r100, double r101) {
        monitor-enter(this);
        long r102 = this.f270325e;     // Catch: Throwable -> L14
        if (r102 != (-1)) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.f270331k.setOptionDoubleToNative(r102, r100, r101);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionInt(String r100, int r101) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r102 = r100.hashCode();     // Catch: Throwable -> L30
        if (r102 == (-1782938240)) goto L20;
        if (r102 == 1524111045) goto L17;
    L22:
        byte r103 = -1;
    L23:
        if (r103 == 0) goto L27;
        if (r103 != 1) goto L27;
        this.f270328h = r101;     // Catch: Throwable -> L30
    L27:
        this.f270331k.setOptionIntToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L17:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_TTS_WORK_MODE_INT) == false) goto L22;
        r103 = 1;
        goto L23
    L20:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_RECORDER_PRESET_INT) == false) goto L22;
        r103 = 0;
        goto L23
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionString(String r100, String r101) {
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100 == null) goto L43;
        if (r101 == null) goto L43;
        switch(r100.hashCode()) {
            case -1875173788: goto L27;
            case -1288521830: goto L24;
            case -1269912457: goto L21;
            case -1174706902: goto L18;
            case 1700942440: goto L15;
            default: goto L29;
        };     // Catch: Throwable -> L45
    L29:
        byte r102 = -1;
    L30:
        if (r102 == 0) goto L39;
        if (r102 == 1) goto L38;
        if (r102 == 2) goto L37;
        if (r102 == 3) goto L37;
        if (r102 != 4) goto L40;
        this.f270330j = r101;     // Catch: Throwable -> L45
    L40:
        this.f270331k.setOptionStringToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L45
        monitor-exit(this);
        return;
    L37:
        this.f270327g = r101.startsWith("android_asset://");     // Catch: Throwable -> L45
        goto L40
    L38:
        this.f270323c = r101;     // Catch: Throwable -> L45
        goto L40
    L39:
        this.f270322b = r101;     // Catch: Throwable -> L45
        goto L40
    L15:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING) == false) goto L29;
        r102 = 0;
        goto L30
    L18:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_RECORDER_TYPE_STRING) == false) goto L29;
        r102 = 1;
        goto L30
    L21:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_AED_RESOURCE_PATH_STRING) == false) goto L29;
        r102 = 2;
        goto L30
    L24:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_TTS_OFFLINE_RESOURCE_PATH_STRING) == false) goto L29;
        r102 = 3;
        goto L30
    L27:
        if (r100.equals(SpeechEngineDefines.PARAMS_KEY_AUTHENTICATE_TYPE_STRING) == false) goto L29;
        r102 = 4;
    L43:
        monitor-exit(this);
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int fetchResult(int r100, byte[] r101) {
        monitor-enter(this);
        long r102 = this.f270325e;     // Catch: Throwable -> L12
        if (r102 != (-1)) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        int r103 = this.f270331k.fetchResultToNative(r102, r100, r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int feedAudio(long r100, byte[] r101, int r102) {
        monitor-enter(this);
        int r103 = feedAudio(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridgeCallback
    public final void onSpeechMessage(int r210, byte[] r211, int r212) {
        SpeechEngine.SpeechListener r100 = this.f270321a;
        if (r100 == null) goto L139;
        r100.onSpeechMessage(r210, r211, r212);
        gf7.a r101 = f270320l;
        if (r101 == null) goto L140;
        String r102 = this.f270322b;
        if (r210 != 1210) goto L9;
        String r110 = "speech_sdk_asr_all_audio_data";
    L67:
        if (r110.isEmpty() == true) goto L141;
        String r111 = new String(r211);
        JSONObject r112 = new JSONObject();
        r112.put(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, r102);     // Catch: JSONException -> L97
        r112.put("host_aid", r101.f481066a);     // Catch: JSONException -> L97
        r112.put("timestamp", Long.toString(System.currentTimeMillis()));     // Catch: JSONException -> L97
        if (r210 != 1001) goto L75;
    L89:
        r101.f481068c = r111;     // Catch: JSONException -> L97
    L90:
        r112.put("reqid", r101.f481068c);     // Catch: JSONException -> L97
        if (r210 != 1002) goto L93;
    L95:
        r101.f481068c = "";     // Catch: JSONException -> L97
    L99:
        boolean r103 = true;
        if (r210 == 1001) goto L120;
        if (r210 == 1003) goto L120;
        if (r210 != 1204) goto L106;
        JSONObject r104 = new JSONObject(r111);     // Catch: JSONException -> L117
        if (r104.has("reqid") == false) goto L120;
        r111 = JSONObjectProtectorUtils.getString(r104, "reqid");     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        e.printStackTrace();
        goto L120
    L106:
        if (r210 == 1206) goto L120;
        if (r210 == 2000) goto L120;
        if (r210 == 2406) goto L120;
        switch(r210) {
            case 2010: goto L120;
            case 2011: goto L120;
            case 2012: goto L120;
            case 2013: goto L120;
            case 2014: goto L120;
            case 2015: goto L120;
            default: goto L112;
        };
    L112:
        r103 = false;
    L120:
        if (r103 == true) goto L122;
    L130:
        JSONObject r105 = null;
    L131:
        SDKMonitorUtils.getInstance("4060").monitorEvent(r110, r112, null, r105);
        return;
    L122:
        if (r111.isEmpty() == true) goto L130;
        r105 = new JSONObject();
        r105.put("host_aid", r101.f481066a);     // Catch: JSONException -> L128
        r105.put("device_id", r101.f481067b);     // Catch: JSONException -> L128
        r105.put(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, r102);     // Catch: JSONException -> L128
        r105.put("msg_data", r111);     // Catch: JSONException -> L128
    L128:
        e = move-exception;
        e.printStackTrace();
        goto L131
    L93:
        if (r210 == 1404) goto L95;
    L75:
        if (r210 != 1003) goto L77;
        JSONObject r106 = new JSONObject(r111);     // Catch: JSONException -> L97
        if (r106.has("err_code") == false) goto L90;
        r112.put("error_code", JSONObjectProtectorUtils.getInt(r106, "err_code"));     // Catch: JSONException -> L97
        goto L90
    L77:
        if (r210 != 1100) goto L79;
        JSONObject r107 = new JSONObject(r111);     // Catch: JSONException -> L97
        if (r107.has("type") == false) goto L90;
        r112.put("wakeup_type", JSONObjectProtectorUtils.getInt(r107, "type"));     // Catch: JSONException -> L97
        goto L90
    L79:
        if (r210 == 1403) goto L89;
    L97:
        e = move-exception;
        e.printStackTrace();
        goto L99
    L141:
        return;
    L9:
        if (r210 != 1211) goto L11;
        r110 = "speech_sdk_all_partial_result";
        goto L67
    L11:
        if (r210 != 1700) goto L13;
        r110 = "speech_sdk_recorder_begin";
        goto L67
    L13:
        if (r210 == 1701) goto L62;
        switch(r210) {
            case 1001: goto L18;
            case 1002: goto L17;
            case 1003: goto L16;
            default: goto L19;
        };
    L16:
        r110 = "speech_sdk_engine_error";
        goto L67
    L17:
        r110 = "speech_sdk_engine_stopped";
        goto L67
    L18:
        r110 = "speech_sdk_engine_started";
        goto L67
    L19:
        if (r210 == 1100) goto L61;
        if (r210 == 1204) goto L60;
        if (r210 != 1206) goto L23;
        r110 = "speech_sdk_asr_statistics";
        goto L67
    L23:
        if (r210 != 1300) goto L25;
        r110 = "speech_sdk_nlu_result";
        goto L67
    L25:
        if (r210 != 1409) goto L27;
        r110 = "speech_sdk_audio_data_end";
        goto L67
    L27:
        if (r210 != 1801) goto L29;
        r110 = "speech_sdk_vad_end";
        goto L67
    L29:
        if (r210 == 1805) goto L55;
        if (r210 != 2000) goto L32;
        r110 = "speech_sdk_engine_log";
        goto L67
    L32:
        if (r210 == 2406) goto L53;
        switch(r210) {
            case 1401: goto L41;
            case 1402: goto L40;
            case 1403: goto L39;
            case 1404: goto L38;
            case 1405: goto L37;
            default: goto L34;
        };
    L34:
        switch(r210) {
            case 2010: goto L49;
            case 2011: goto L48;
            case 2012: goto L47;
            case 2013: goto L46;
            case 2014: goto L45;
            case 2015: goto L44;
            case 2016: goto L43;
            case 2017: goto L42;
            default: goto L35;
        };
    L35:
        switch(r210) {
            case 2300: goto L52;
            case 2301: goto L51;
            case 2302: goto L50;
            default: goto L36;
        };
    L36:
        r110 = "";
        goto L67
    L50:
        r110 = "speech_sdk_end_connection";
        goto L67
    L51:
        r110 = "speech_sdk_connected";
        goto L67
    L52:
        r110 = "speech_sdk_start_connection";
        goto L67
    L42:
        r110 = "speech_sdk_voiceclone_audio_time_limit_exceeded";
        goto L67
    L43:
        r110 = "speech_sdk_voiceclone_record_process_end";
        goto L67
    L44:
        r110 = "speech_sdk_voiceclone_delete_data_result";
        goto L67
    L45:
        r110 = "speech_sdk_voiceclone_submit_task_result";
        goto L67
    L46:
        r110 = "speech_sdk_voiceclone_query_status_result";
        goto L67
    L47:
        r110 = "speech_sdk_voiceclone_record_voice_result";
        goto L67
    L48:
        r110 = "speech_sdk_voiceclone_check_env_result";
        goto L67
    L49:
        r110 = "speech_sdk_voiceclone_get_task_result";
        goto L67
    L37:
        r110 = "speech_sdk_finish_audio_dump";
        goto L67
    L38:
        r110 = "speech_sdk_tts_synthesis_end";
        goto L67
    L39:
        r110 = "speech_sdk_tts_synthesis_begin";
        goto L67
    L40:
        r110 = "speech_sdk_finish_playing";
        goto L67
    L41:
        r110 = "speech_sdk_start_playing";
        goto L67
    L53:
        r110 = "speech_sdk_au_statistics";
        goto L67
    L55:
        r110 = "speech_sdk_vad_real_end";
        goto L67
    L60:
        r110 = "speech_sdk_final_result";
        goto L67
    L61:
        r110 = "speech_sdk_wakeup_result";
        goto L67
    L62:
        r110 = "speech_sdk_recorder_end";
        goto L67
    L140:
        return;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int processAudio(byte[] r100, int r101, boolean r102) {
        monitor-enter(this);
        long r103 = this.f270325e;     // Catch: Throwable -> L12
        if (r103 != (-1)) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        int r104 = this.f270331k.processAudioToNative(r103, r100, r101, r102);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r104;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int sendDirective(int r100, String r101, Cert r102) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.f270325e != (-1)) goto L10;
        monitor-exit(this);
        return -1;
    L10:
        if (c(r100) == true) goto L12;
    L14:
        String r103 = "sendDirective";
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L36
        int r104 = -710;
    L31:
        gf7.a r105 = f270320l;     // Catch: Throwable -> L36
        if (r105 == null) goto L34;
        r105.b(this.f270322b, r100, r101, r104);     // Catch: Throwable -> L36
    L34:
        monitor-exit(this);
        return r104;
    L16:
        if (c(r100) == false) goto L19;
        r103 = "sendDirectiveStartCapture";
    L25:
        com.bytedance.bpea.entry.common.a.f202195a.getClass();     // Catch: BPEAException -> L29 Throwable -> L36
        com.bytedance.bpea.entry.common.a.C2920a.a(r102, new String[]{"audio"}, "SpeechSDK", r103);     // Catch: BPEAException -> L29 Throwable -> L36
        if (r101 != null) goto L28;
        r101 = "";
    L28:
        r104 = this.f270331k.sendDirectiveToNative(this.f270325e, r100, r101);     // Catch: Throwable -> L36
        goto L31
    L19:
        if (r100 != 2001) goto L21;
    L24:
        r103 = "sendDirectiveStopCapture";
        goto L25
    L21:
        if (r100 == 1001) goto L24;
        if (r100 != 1100) goto L25;
    L12:
        if (b() == true) goto L14;
        r104 = SpeechEngineDefines.ERR_REC_CHECK_ENVIRONMENT_FAILED;
        goto L31
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionBoolean(long r100, String r101, boolean r102) {
        monitor-enter(this);
        setOptionBoolean(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionInt(long r100, String r101, int r102) {
        monitor-enter(this);
        setOptionInt(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized void setOptionString(long r100, String r101, String r102) {
        monitor-enter(this);
        setOptionString(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int sendDirective(long r100, int r101, String r102) {
        monitor-enter(this);
        int r103 = sendDirective(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine
    public final synchronized int sendDirective(long r100, int r101, String r102, Cert r103) {
        monitor-enter(this);
        int r104 = sendDirective(r101, r102, r103);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r104;
    L6:
        th = move-exception;
        throw th;
    }
}
