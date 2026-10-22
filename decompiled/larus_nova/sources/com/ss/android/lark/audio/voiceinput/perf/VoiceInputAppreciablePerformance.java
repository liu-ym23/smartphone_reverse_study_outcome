package com.ss.android.lark.audio.voiceinput.perf;

import android.media.AudioRecord;
import android.os.SystemClock;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.audio.recorder.AudioRecordConfigBuilder;
import com.ss.android.lark.audio.recorder.ErrorInfo;
import com.ss.android.lark.media.MediaMutex;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceInputAppreciablePerformance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f409284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f409285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static EndState f409286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f409287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f409288e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f409289f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f409290g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f409291h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f409292i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f409293j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f409294k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f409295l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f409296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f409297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f409298o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f409299p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f409300q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f409301r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f409302s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f409303t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Map<String, Object> f409304u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f409305v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f409306w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f409307x = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/perf/VoiceInputAppreciablePerformance$EndState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Unknown", "TooShort", "Success", "key", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EndState extends Enum<EndState> {
        public static final EndState Success = null;
        public static final EndState TooShort = null;
        public static final EndState Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EndState[] f409308a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f409309b = null;
        private final String value;

        public static EnumEntries<EndState> getEntries() {
            return f409309b;
        }

        public final String key() {
            return "end_state";
        }

        static {
            EndState r100 = new EndState("Unknown", 0, "unknown");
            Unknown = r100;
            EndState r101 = new EndState("TooShort", 1, "too_short");
            TooShort = r101;
            EndState r102 = new EndState("Success", 2, "success");
            Success = r102;
            EndState[] r103 = {r100, r101, r102};
            f409308a = r103;
            f409309b = EnumEntriesKt.enumEntries(r103);
        }

        public static EndState[] values() {
            return (EndState[]) f409308a.clone();
        }

        public final String value() {
            return this.value;
        }

        public static EndState valueOf(String r100) {
            return (EndState) r27.a.a(EndState.class, r100);
        }

        public EndState(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/perf/VoiceInputAppreciablePerformance$StopState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Unknown", "Record", "Cancel", "Recognize", "key", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StopState extends Enum<StopState> {
        public static final StopState Cancel = null;
        public static final StopState Recognize = null;
        public static final StopState Record = null;
        public static final StopState Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopState[] f409310a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f409311b = null;
        private final String value;

        public static EnumEntries<StopState> getEntries() {
            return f409311b;
        }

        public final String key() {
            return "stop_state";
        }

        static {
            StopState r100 = new StopState("Unknown", 0, "unknown");
            Unknown = r100;
            StopState r101 = new StopState("Record", 1, "record");
            Record = r101;
            StopState r102 = new StopState("Cancel", 2, "cancel");
            Cancel = r102;
            StopState r103 = new StopState("Recognize", 3, "recognize");
            Recognize = r103;
            StopState[] r104 = {r100, r101, r102, r103};
            f409310a = r104;
            f409311b = EnumEntriesKt.enumEntries(r104);
        }

        public static StopState[] values() {
            return (StopState[]) f409310a.clone();
        }

        public final String value() {
            return this.value;
        }

        public static StopState valueOf(String r100) {
            return (StopState) r27.a.a(StopState.class, r100);
        }

        public StopState(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f409312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f409313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f409314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f409315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f409316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f409317f;

        public a() {
            this.f409312a = Integer.MIN_VALUE;
            this.f409315d = -1;
            this.f409316e = new b();
        }

        public final void a(String r100) {
            boolean r101 = false;
            if (this.f409316e.f409318a == (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L8;
            return;
        L8:
            String r103 = this.f409317f;
            if (r103 != null) goto L11;
        L13:
            if (r101 == false) goto L15;
            return;
        L15:
            this.f409316e.a();
            int r104 = (int) this.f409316e.b();
            this.f409312a = Math.max(r104, this.f409312a);
            this.f409313b += r104;
            this.f409314c++;
            this.f409316e.d();
            this.f409317f = r100;
            return;
        L11:
            if (r103.equals(r100) != true) goto L13;
            r101 = true;
            goto L13
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f409318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f409319b;

        public final long b() {
            long r100 = this.f409318a;
            boolean r101 = true;
            if (r100 == (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L17;
            long r103 = this.f409319b;
            if (r103 != (-1)) goto L11;
            r101 = false;
        L11:
            if (r101 == false) goto L17;
            if (r100 > r103) goto L17;
            return r103 - r100;
        L17:
            return -1;
        L5:
            r102 = false;
            goto L6
        }

        public final void c() {
            this.f409318a = -1;
            this.f409319b = -1;
        }

        public b() {
            this.f409318a = -1;
            this.f409319b = -1;
        }

        public final void a() {
            this.f409319b = SystemClock.uptimeMillis();
        }

        public final void d() {
            this.f409318a = SystemClock.uptimeMillis();
        }
    }

    public static final class c implements fwa.b {
        public c() {
        }

        @Override // fwa.b
        public final c a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            VoiceInputAppreciablePerformance.f409304u.put(r100, r101);
            return this;
        }
    }

    static {
        f409286c = EndState.Unknown;
        f409288e = new b();
        f409289f = new b();
        f409290g = new b();
        f409291h = new b();
        f409292i = new b();
        f409293j = new b();
        f409294k = 1161;
        f409295l = "";
        f409296m = 10000;
        f409299p = new a();
        f409300q = new a();
        new LinkedHashMap();
        f409304u = new LinkedHashMap();
        f409306w = "";
        f409307x = new c();
    }

    public static Map b() {
        Pair[] r100 = new Pair[12];
        r100[0] = TuplesKt.to("first_result_latency", Long.valueOf(f409291h.b()));
        r100[1] = TuplesKt.to("last_recognize_latency", Long.valueOf(f409290g.b()));
        r100[2] = TuplesKt.to("max_volume", Integer.valueOf(f409284a));
        r100[3] = TuplesKt.to("record_time", Long.valueOf(f409289f.b()));
        String r101 = f409287d;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[4] = TuplesKt.to("recognize_id", r101);
        r100[5] = TuplesKt.to("stop_to_recognized_latency", Long.valueOf(f409292i.b()));
        r100[6] = TuplesKt.to("stop_to_send_finish_latency", Long.valueOf(f409293j.b()));
        a r102 = f409299p;
        int r103 = r102.f409312a;
        int r104 = -1;
        if (r103 != Integer.MIN_VALUE) goto L8;
        r103 = -1;
    L8:
        r100[7] = TuplesKt.to("result_change_interval_max", Integer.valueOf(r103));
        int r105 = r102.f409314c;
        if (r105 != 0) goto L11;
        int r106 = r102.f409315d;
    L12:
        r100[8] = TuplesKt.to("result_change_interval_avg", Integer.valueOf(r106));
        a r107 = f409300q;
        int r108 = r107.f409312a;
        if (r108 == Integer.MIN_VALUE) goto L16;
        r104 = r108;
    L16:
        r100[9] = TuplesKt.to("result_change_interval_last_max", Integer.valueOf(r104));
        int r109 = r107.f409314c;
        if (r109 != 0) goto L19;
        int r110 = r107.f409315d;
    L20:
        r100[10] = TuplesKt.to("result_change_interval_last_avg", Integer.valueOf(r110));
        r100[11] = TuplesKt.to("asr_result_length", Integer.valueOf(f409301r));
        return MapsKt.mapOf(r100);
    L19:
        r110 = (r107.f409313b - r107.f409312a) / r109;
        goto L20
    L11:
        r106 = (r102.f409313b - r102.f409312a) / r105;
        goto L12
    }

    public static void i() {
        f409287d = "";
        f409285b = "";
        f409297n = null;
        f409298o = null;
        f409294k = 1161;
        f409295l = "";
        f409296m = 10000;
        a r100 = f409299p;
        r100.f409312a = Integer.MIN_VALUE;
        r100.f409313b = 0;
        r100.f409314c = 0;
        r100.f409315d = -1;
        r100.f409316e.c();
        r100.f409317f = null;
        a r101 = f409300q;
        r101.f409312a = Integer.MIN_VALUE;
        r101.f409313b = 0;
        r101.f409314c = 0;
        r101.f409315d = -1;
        r101.f409316e.c();
        r101.f409317f = null;
        f409301r = 0;
        f409302s = 0;
        f409303t = 0;
        f409284a = 0;
        f409288e.c();
        f409289f.c();
        f409290g.c();
        f409291h.c();
        f409292i.c();
        f409293j.c();
        f409306w = "";
        f409305v = false;
    }

    public static void h() {
        i();
        f409288e.d();
        AppreciableKit r100 = AppreciableKit.Companion.getInstance();
        Biz r101 = Biz.Messenger;
        Scene r102 = Scene.Chat;
        Event r103 = Event.audio_input_record;
        Pair[] r104 = new Pair[1];
        List<com.ss.android.lark.media.Scene> r110 = MediaMutex.f431631r.a();
        if (r110 == null) goto L5;
        boolean r111 = r110.contains(com.ss.android.lark.media.Scene.VC_MEETING);
    L6:
        r104[0] = TuplesKt.to("is_start_with_meeting", Boolean.valueOf(r111));
        f409297n = r100.start(r101, r102, r103, null, false, null, null, null, MapsKt.mutableMapOf(r104));
        return;
    L5:
        r111 = false;
        goto L6
    }

    public static void f(boolean r110) {
        f409292i.d();
        f409293j.d();
        b r100 = f409289f;
        r100.a();
        if (r110 == false) goto L5;
        EndState r111 = EndState.TooShort;
    L6:
        f409286c = r111;
        if (f409302s != 0) goto L10;
        ErrorInfo r112 = ErrorInfo.ERR_PCM_SIZE_ZERO;
        g(r112.getErrorCode(), r112.getErrorMessage(), false);
        return;
    L10:
        AudioRecordConfigBuilder r113 = AudioRecordConfigBuilder.IM;
        com.ss.android.lark.audio.recorder.c r101 = r113.getAudioRecordConfig();
        int r102 = AudioRecord.getMinBufferSize(r101.f409115g, r101.f409116h, r101.f409117i);
        int r114 = r113.getAudioRecordConfig().f409110b.f409107a.invoke(Integer.valueOf(r102)).intValue();
        String r103 = f409297n;
        if (r103 == null) goto L24;
        AppreciableKit r104 = AppreciableKit.Companion.getInstance();
        Pair[] r105 = new Pair[9];
        r105[0] = TuplesKt.to("hardware_latency", Long.valueOf(f409288e.b()));
        r105[1] = TuplesKt.to("record_time", Long.valueOf(r100.b()));
        r105[2] = TuplesKt.to("max_volume", Integer.valueOf(f409284a));
        String r106 = f409285b;
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r105[3] = TuplesKt.to("upload_id", r106);
        r105[4] = TuplesKt.to("pcm_file_size", Integer.valueOf(f409302s));
        r105[5] = TuplesKt.to("upload_file_size", Integer.valueOf(f409303t));
        r105[6] = TuplesKt.to("min_buffer_size", Integer.valueOf(r102));
        r105[7] = TuplesKt.to("final_buffer_size", Integer.valueOf(r114));
        if (f409306w.length() <= 0) goto L18;
        boolean r115 = true;
    L20:
        if (r115 == false) goto L22;
        Pair r116 = TuplesKt.to("scene", f409306w);
    L23:
        r105[8] = r116;
        Map r107 = MapsKt.mapOf(r105);
        Map r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(f409286c.key(), f409286c.value())});
        r108.putAll(f409304u);
        Unit r109 = Unit.INSTANCE;
        AppreciableKit.end$default(r104, r103, null, r107, null, null, r108, 24, null);
        goto L24
    L22:
        r116 = TuplesKt.to("scene", "unknown");
        goto L23
    L18:
        r115 = false;
    L24:
        f409297n = null;
        f409302s = 0;
        f409303t = 0;
        return;
    L5:
        r111 = EndState.Success;
        goto L6
    }

    public static Map a(boolean r100, String r101) {
        Pair[] r102 = new Pair[8];
        boolean r103 = true;
        if (r100 == false) goto L5;
        int r104 = 1;
    L6:
        r102[0] = TuplesKt.to("is_end_response_on_screen", Integer.valueOf(r104));
        r102[1] = TuplesKt.to("recognize_error_code", Integer.valueOf(f409294k));
        r102[2] = TuplesKt.to("recognize_error_msg", f409295l);
        r102[3] = TuplesKt.to("recognize_service_error_code", Integer.valueOf(f409296m));
        r102[4] = TuplesKt.to(f409286c.key(), f409286c.value());
        r102[5] = TuplesKt.to("session_stop_reason", r101);
        r102[6] = TuplesKt.to("is_always_recognize", Boolean.valueOf(f409305v));
        if (f409306w.length() > 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        Pair r105 = TuplesKt.to("scene", f409306w);
    L14:
        r102[7] = r105;
        Map r106 = MapsKt.mutableMapOf(r102);
        r106.putAll(f409304u);
        return r106;
    L13:
        r105 = TuplesKt.to("scene", "unknown");
        goto L14
    L5:
        r104 = -1;
        goto L6
    }

    public static void d(boolean r100, String r101, int r110) {
        b r102 = f409291h;
        boolean r103 = true;
        int r104 = 0;
        if (r102.f409318a == (-1)) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L8;
    L22:
        if (r100 == false) goto L24;
        f409290g.a();
    L24:
        f409299p.a(r101);
        f409300q.a(r101);
        f409296m = r110;
        if (r101 == null) goto L27;
        r104 = r101.length();
    L27:
        f409301r = r104;
        return;
    L8:
        if (r102.f409319b == (-1)) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L22;
        if (r101 != null) goto L14;
    L19:
        r103 = false;
    L20:
        if (r103 == false) goto L22;
        r102.a();
        a r107 = f409299p;
        r107.f409317f = r101;
        r107.f409316e.d();
        goto L22
    L14:
        if (r101.length() <= 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 != true) goto L19;
    L16:
        r108 = false;
        goto L17
    L10:
        r106 = false;
        goto L11
    L5:
        r105 = false;
        goto L6
    }

    public static void e(boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "sessionStopReason");
        f409292i.a();
        if (r111 == false) goto L8;
        String r100 = f409298o;
        if (r100 == null) goto L10;
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r100, null, b(), null, null, a(r110, r112), 24, null);
    L10:
        i();
        return;
    L8:
        if (f409298o == null) goto L10;
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Chat, Event.audio_input_recognition, ErrorType.SDK, ErrorLevel.Fatal, 0, null, null, "Empty result", Boolean.TRUE, null, b(), a(r110, r112)));
        goto L10
    }

    public static void g(int r110, String r111, boolean r112) {
        if (r111 != null) goto L4;
        String r100 = "";
    L5:
        f409295l = r100;
        f409294k = r110;
        if (f409297n == null) goto L19;
        AppreciableKit r113 = AppreciableKit.Companion.getInstance();
        Biz r101 = Biz.Messenger;
        Scene r102 = Scene.Chat;
        Event r103 = Event.audio_input_record;
        ErrorType r104 = ErrorType.Other;
        ErrorLevel r105 = ErrorLevel.Fatal;
        Boolean r114 = Boolean.FALSE;
        Pair[] r106 = new Pair[4];
        Pair r107 = TuplesKt.to(f409286c.key(), f409286c.value());
        boolean r108 = false;
        r106[0] = r107;
        Pair r109 = TuplesKt.to("is_other_audio_play", Boolean.valueOf(r112));
        boolean r115 = true;
        r106[1] = r109;
        if (f409306w.length() > 0) goto L12;
        r115 = false;
    L12:
        if (r115 == false) goto L14;
        Pair r116 = TuplesKt.to("scene", f409306w);
    L15:
        r106[2] = r116;
        List<com.ss.android.lark.media.Scene> r117 = MediaMutex.f431631r.a();
        if (r117 == null) goto L18;
        r108 = r117.contains(com.ss.android.lark.media.Scene.VC_MEETING);
    L18:
        r106[3] = TuplesKt.to("is_start_with_meeting", Boolean.valueOf(r108));
        Map r118 = MapsKt.mutableMapOf(r106);
        r118.putAll(f409304u);
        Unit r119 = Unit.INSTANCE;
        r113.error(new ErrorParams(r101, r102, r103, r104, r105, r110, null, null, r111, r114, null, null, r118));
        goto L19
    L14:
        r116 = TuplesKt.to("scene", "unknown");
    L19:
        f409297n = null;
        return;
    L4:
        r100 = r111;
        goto L5
    }

    public static void c(boolean r110, boolean r111, String r112, String r113) {
        if (r110 == false) goto L4;
        f409291h.d();
        f409298o = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.audio_input_recognition, null, true, null, null, null, null, 256, null);
    L4:
        if (r111 == false) goto L6;
        f409290g.d();
        f409293j.a();
        a r114 = f409300q;
        r114.f409317f = r113;
        r114.f409316e.d();
    L6:
        if (r112 != null) goto L8;
        r112 = "";
    L8:
        f409287d = r112;
    }
}
