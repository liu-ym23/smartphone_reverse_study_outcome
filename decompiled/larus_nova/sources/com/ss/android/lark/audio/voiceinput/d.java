package com.ss.android.lark.audio.voiceinput;

import android.media.AudioRecord;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.audio.recorder.AudioRecordConfigBuilder;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.recorder.ErrorInfo;
import com.ss.android.lark.audio.recorder.LarkAudioRecorder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.utils.CarUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.processor.c f409218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f409219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f409220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f409221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f409223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f409224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LarkAudioRecorder f409225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f409226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f409227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f409228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f409229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f409230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f409231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f409232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f409233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList<Double> f409234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f409235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f409236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f409237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f409238u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f409239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final C4754d f409240w;

    public static final class a {
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f409241a;

        @Override // com.ss.android.lark.audio.voiceinput.e
        public final void b() {
            this.f409241a.f409219b.b();
        }

        @Override // com.ss.android.lark.audio.voiceinput.e
        public final void f() {
            this.f409241a.f409219b.f();
        }

        public b(d r100) {
            this.f409241a = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.e
        public final void e(com.ss.android.lark.audio.voiceinput.c r100) {
            Intrinsics.checkNotNullParameter(r100, "asrResult");
            this.f409241a.f409219b.e(r100);
        }

        @Override // com.ss.android.lark.audio.voiceinput.e
        public final void g(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            this.f409241a.f409219b.l(r100, r101);
        }
    }

    public static final class c implements com.ss.android.lark.audio.recorder.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f409242a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f409243a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f409244b;

            public a(d r100, String r101) {
                this.f409243a = r100;
                this.f409244b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f409243a.f409219b.g(this.f409244b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f409245a;

            public b(d r100) {
                this.f409245a = r100;
            }

            public final void a() {
                d r100 = this.f409245a;
                r100.f409219b.m(r100.f409230m, r100.f409229l, r100.f409237t);
                d r101 = this.f409245a;
                r101.f409218a.c(r101.f409230m, r101.f409229l, r101.f409226i);
                Function0<Unit> r102 = this.f409245a.f409224g;
                if (r102 == null) goto L6;
                r102.invoke();
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.audio.voiceinput.d$c$c, reason: collision with other inner class name */
        public static final class RunnableC4752c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f409246a;

            public RunnableC4752c(d r100) {
                this.f409246a = r100;
            }

            public final void a() {
                d r100 = this.f409246a;
                if (r100.f409232o >= 1000) goto L5;
                boolean r101 = true;
            L7:
                if (r100.f409221d == true) goto L22;
                String r102 = fwa.a.f479017a;
                if (r100.f409228k == true) goto L12;
                if (r101 == true) goto L12;
                int r103 = 1;
            L13:
                fwa.a.f479041y = System.currentTimeMillis();
                if (fwa.a.f479023g != 0) goto L16;
                fwa.a.b(ErrorInfo.ERR_PCM_SIZE_ZERO);
                goto L22
            L16:
                String r104 = fwa.a.f479017a;
                if (r104 == null) goto L22;
                AppreciableKit r105 = AppreciableKit.Companion.getInstance();
                Map<String, ? extends Object> r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("hardware_latency", Long.valueOf(fwa.a.f479020d)), TuplesKt.to("press_time", Long.valueOf(fwa.a.f479040x))});
                Map<String, ? extends Object> r110 = MapsKt.mapOf(new Pair[]{TuplesKt.to("max_volume", Integer.valueOf(fwa.a.f479022f)), TuplesKt.to("pcm_file_size", Integer.valueOf(fwa.a.f479023g)), TuplesKt.to("upload_file_size", Integer.valueOf(fwa.a.f479024h)), TuplesKt.to("success_piece_count", Integer.valueOf(fwa.a.f479025i)), TuplesKt.to("failed_piece_count", Integer.valueOf(fwa.a.f479026j)), TuplesKt.to("request_count", Integer.valueOf(fwa.a.f479027k))});
                Pair[] r111 = new Pair[3];
                r111[0] = TuplesKt.to(EventConstant.Key.IS_FINISH, Integer.valueOf(r103));
                String r107 = fwa.a.f479021e;
                if (r107 != null) goto L21;
                r107 = "";
            L21:
                r111[1] = TuplesKt.to("upload_id", r107);
                r111[2] = TuplesKt.to("open_type", fwa.a.f479042z);
                r105.end(r104, null, r106, null, r110, MapsKt.mapOf(r111));
            L12:
                r103 = 0;
            L22:
                d r108 = this.f409246a;
                f r109 = r108.f409219b;
                if (r108.f409228k == false) goto L25;
                r109.j();
                r108.f409218a.e();
                return;
            L25:
                if (r101 == true) goto L27;
                r109.h(r108.f409232o);
                r108.f409218a.g(r108.f409230m, r108.f409229l, r108.f409232o, r108.f409226i);
                return;
            L27:
                if (r108.f409226i == false) goto L29;
                r108.f409218a.g(r108.f409230m, r108.f409229l, r108.f409232o, true);
            L29:
                r109.d();
                return;
            L5:
                r101 = false;
                goto L7
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.audio.voiceinput.d$c$d, reason: collision with other inner class name */
        public static final class RunnableC4753d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f409247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ErrorInfo f409248b;

            public RunnableC4753d(d r100, ErrorInfo r101) {
                this.f409247a = r100;
                this.f409248b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            L3:
                if (this.f409247a.f409221d == true) goto L5;
                String r100 = fwa.a.f479017a;     // Catch: Throwable -> L7
                fwa.a.b(this.f409248b);     // Catch: Throwable -> L7
            L5:
                this.f409247a.f409219b.k(this.f409248b.getErrorCode(), this.f409248b.getErrorMessage());     // Catch: Throwable -> L7
            }
        }

        public static final class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f409249a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f409250b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<ByteBuffer> f409251c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f409252d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ double f409253e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ double f409254f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f409255g;

            public e(d r100, int r101, Ref.ObjectRef<ByteBuffer> r102, ByteBuffer r103, double r104, double r105, int r106) {
                this.f409249a = r100;
                this.f409250b = r101;
                this.f409251c = r102;
                this.f409252d = r103;
                this.f409253e = r104;
                this.f409254f = r105;
                this.f409255g = r106;
            }

            public final void a() {
                d r100 = this.f409249a;
                int r101 = this.f409250b;
                r100.f409232o = r101;
                f r110 = r100.f409219b;
                Ref.ObjectRef<ByteBuffer> r102 = this.f409251c;
                ByteBuffer r111 = this.f409252d;
                double r112 = this.f409253e;
                double r113 = this.f409254f;
                int r103 = this.f409255g;
                int r104 = r100.f409233p;
                if (r101 < (r104 - 10000)) goto L5;
                boolean r114 = true;
            L6:
                int r105 = RangesKt.coerceAtMost(((r104 - r101) / 1000) + 1, 10);
                r110.i(r102.element, r111, r112, r100.f409232o, r114, r113);
                if (r103 <= 0) goto L10;
                r100.f409218a.h(r111, r100.f409232o, r112, r100.f409226i);
            L10:
                if (r100.f409232o < r100.f409233p) goto L12;
                r100.f409240w.stopRecord();
                r110.c();
                return;
            L12:
                if (r114 == false) goto L19;
                if (r105 < 10) goto L15;
                boolean r106 = true;
            L16:
                r110.a(r105, r106);
                return;
            L15:
                r106 = false;
                goto L16
            L19:
                return;
            L5:
                r114 = false;
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void j() {
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void n() {
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void a1() {
            String r100 = fwa.a.f479017a;
            if (fwa.a.f479017a == null) goto L6;
            fwa.a.f479020d = System.currentTimeMillis() - fwa.a.f479019c;
        L6:
            UICallbackExecutor.execute(new b(this.f409242a));
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void m() {
            UICallbackExecutor.executeDelayed(new RunnableC4752c(this.f409242a), 50);
        }

        public c(d r100) {
            this.f409242a = r100;
        }

        public final void a(boolean r110) {
            if (this.f409242a.f409234q.size() > 10) goto L5;
            if (r110 == true) goto L5;
            return;
        L5:
            StringBuffer r111 = new StringBuffer();
            CopyOnWriteArrayList<Double> r100 = this.f409242a.f409234q;
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
            Iterator<T> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            r101.add(((Double) r102.next()).toString());
            goto L7
        L9:
            r111.append(CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null));
            Log.i("VoiceInputService", "audioVolumesDb:[" + r111 + ']');
            this.f409242a.f409234q.clear();
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recordingDevice");
            d r101 = this.f409242a;
            r101.f409237t = r100;
            UICallbackExecutor.execute(new a(r101, r100));
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void h(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, "pcmData");
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void i(ErrorInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "errorInfo");
            Log.e("VoiceInputService", "[onTerminateRecord]errorCode:" + r100.getErrorCode() + " errorMsg:" + r100.getErrorMessage());
            UICallbackExecutor.execute(new RunnableC4753d(this.f409242a, r100));
            a(true);
        }

        @Override // com.ss.android.lark.audio.recorder.k
        public final void l(ByteBuffer r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            boolean r102 = this.f409242a.f409235r;
            if (r102 == false) goto L19;
            if (r102 == false) goto L20;
            Log.i("VoiceInputService", "increase volume");
            if (r101 <= 0) goto L21;
            int r103 = 0;
        L10:
            if (r103 >= r101) goto L22;
            r100.putShort(r103, (short) RangesKt.coerceAtMost(r100.getShort(r103) * 2, 32767));     // Catch: Exception -> L13
            r103 = r103 + 2;
        L13:
            e = move-exception;
            Log.e("VoiceInputService", "increase volume failed", e);
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        }

        /* JADX WARN: Type inference failed for: r2v6, types: [T, java.nio.ByteBuffer] */
        @Override // com.ss.android.lark.audio.recorder.k
        public final void k(int r110, double r111, ByteBuffer r112, ByteBuffer r210) {
            if (r112 == null) goto L5;
            int r100 = r112.remaining();
        L6:
            if (r210 == null) goto L8;
            int r113 = r210.remaining();
        L9:
            if (r112 == null) goto L11;
            byte[] r101 = r112.array();
        L12:
            double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r101 != null) goto L15;
        L14:
            double r114 = 0.0d;
        L25:
            this.f409242a.f409234q.add(Double.valueOf(r114));
            a(false);
            Ref.ObjectRef r103 = new Ref.ObjectRef();
            if (r112 != null) goto L28;
        L31:
            String r104 = fwa.a.f479017a;
            int r105 = MathKt.roundToInt(r114);
            fwa.a.f479022f = Math.max(fwa.a.f479022f, r105);
            fwa.a.f479038v = Math.max(fwa.a.f479038v, r105);
            fwa.a.f479023g += r100;
            fwa.a.f479024h += r113;
            UICallbackExecutor.execute(new e(this.f409242a, r110, r103, r210, r111, r114, r113));
            return;
        L28:
            if (r112.position() == 0) goto L30;
            r112.flip();
        L30:
            ?? r106 = ByteBuffer.allocate(r112.limit());
            r103.element = r106;
            ByteBuffer r107 = (ByteBuffer) r106;
            r106.put(r112);
            goto L31
        L15:
            int r108 = r101.length;
            if (r108 < 2) goto L14;
            int r109 = r108 / 2;
            int[] r115 = new int[r109];
            int r116 = 0;
            int r117 = 0;
        L19:
            if (r116 >= r109) goto L21;
            int r118 = r115[r116];
            int r119 = r117 * 2;
            byte r120 = r101[r119];
            r115[r117] = (r101[r119 + 1] & UByte.MAX_VALUE) | ((r120 >> 8) & 255);
            r116 = r116 + 1;
            r117 = r117 + 1;
            goto L19
        L21:
            int r121 = 0;
        L22:
            if (r121 >= r109) goto L24;
            int r122 = r115[r121];
            r102 = r102 + ((double) (r122 * r122));
            r121 = r121 + 1;
            goto L22
        L24:
            r114 = Math.log10((r102 / ((double) r109)) + 1.0d) * 10.0d;
            goto L25
        L11:
            r101 = null;
            goto L12
        L8:
            r113 = 0;
            goto L9
        L5:
            r100 = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.audio.voiceinput.d$d, reason: collision with other inner class name */
    public static final class C4754d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f409256a;

        /* JADX INFO: renamed from: com.ss.android.lark.audio.voiceinput.d$d$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f409257a = null;

            static {
                int[] r100 = new int[VoiceInputMode.values().length];
                r100[VoiceInputMode.VoiceAndAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[VoiceInputMode.OnlyAsr.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[VoiceInputMode.SecondVoice.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[VoiceInputMode.OnlyVoice.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f409257a = r100;
            }
        }

        @Override // com.ss.android.lark.audio.voiceinput.g
        public final void a() {
            Log.i("VoiceInputService", "cancelRecord");
            if (fwa.a.f479017a == null) goto L6;
            fwa.a.f479040x = System.currentTimeMillis() - fwa.a.f479019c;
        L6:
            d r100 = this.f409256a;
            r100.f409228k = true;
            r100.f409225h.f();
        }

        public final boolean c() {
            if (this.f409256a.f409231n > 0) goto L5;
            return true;
        L5:
            if ((SystemClock.elapsedRealtime() - this.f409256a.f409231n) >= 1000) goto L10;
            Log.w("VoiceInputService", "startRecord but last record task is stopping, interval = " + (SystemClock.elapsedRealtime() - this.f409256a.f409231n));
            return false;
        L10:
            return true;
        }

        @Override // com.ss.android.lark.audio.voiceinput.g
        public final boolean isRecording() {
            com.ss.android.lark.audio.recorder.p r100 = this.f409256a.f409225h.b();
            boolean r101 = false;
            if (r100 == null) goto L16;
            int r102 = r100.e();
            AudioRecord r103 = r100.f409137c;
            if (r103 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            if (r104 == true) goto L12;
        L14:
            r101 = true;
        L15:
            Log.i("LarkAudioRecorder", "isRecording state:" + r100.e() + HTTP.HEADER_LINE_DELIM + r101);
        L17:
            return r101;
        L12:
            if (r102 == 2) goto L14;
            if (r102 != 1) goto L15;
        L7:
            if (r103.getAudioSessionId() != (-1)) goto L9;
            r104 = true;
            goto L10
        L16:
            Log.i("LarkAudioRecorder", "isRecording is false");
            goto L17
        }

        @Override // com.ss.android.lark.audio.voiceinput.g
        public final void stopRecord() {
            Log.i("VoiceInputService", "stopRecord");
            if (fwa.a.f479017a == null) goto L6;
            fwa.a.f479040x = System.currentTimeMillis() - fwa.a.f479019c;
        L6:
            this.f409256a.f409225h.f();
        }

        public C4754d(d r100) {
            this.f409256a = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.g
        public final boolean b(AudioPluginFeature r210, String r211, boolean r212) {
            Intrinsics.checkNotNullParameter(r210, "audioPluginFeature");
            d.a(this.f409256a);
            if (c() == true) goto L5;
            return false;
        L5:
            d r100 = this.f409256a;
            if (r210 == AudioPluginFeature.RECORD) goto L8;
            boolean r101 = true;
        L9:
            r100.f409226i = r101;
            if (r210 != AudioPluginFeature.RECOGNIZE) goto L12;
            boolean r102 = true;
        L13:
            r100.f409227j = r102;
            com.ss.android.lark.audio.recorder.c r103 = r100.f409225h.f409079e;
            if (r103 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mRecorderConfig");
            r103 = null;
        L16:
            AtomicReference<String> r104 = AudioRecordSettings.f409071a;
            r103.f409112d = AudioRecordSettings.b(r210.getIndex()).getAudioRecordDataRequestInterval();
            this.f409256a.f409231n = SystemClock.elapsedRealtime();
            String r105 = fwa.a.f479017a;
            boolean r106 = this.f409256a.f409220c;
            if (r212 == false) goto L19;
            String r107 = "press_panel";
        L20:
            Intrinsics.checkNotNullParameter(r210, "feature");
            Intrinsics.checkNotNullParameter(r107, "openType");
            fwa.a.f479017a = null;
            fwa.a.f479019c = -1;
            fwa.a.f479020d = -1;
            fwa.a.f479021e = null;
            fwa.a.f479022f = 0;
            fwa.a.f479023g = 0;
            fwa.a.f479024h = 0;
            fwa.a.f479025i = 0;
            fwa.a.f479026j = 0;
            fwa.a.f479027k = 0;
            String r108 = "speech_to_text";
            if (r106 == true) goto L23;
            String r109 = "recording_view_not_upload";
        L32:
            fwa.a.f479042z = r107;
            fwa.a.f479019c = System.currentTimeMillis();
            AppreciableKit.Companion r110 = AppreciableKit.Companion;
            AppreciableKit r111 = r110.getInstance();
            Biz r213 = Biz.Messenger;
            Scene r214 = Scene.Chat;
            Event r112 = Event.audio_record;
            Pair[] r113 = new Pair[2];
            r113[0] = TuplesKt.to(BytedCertConstant.IntentKey.VIEW_TYPE, r109);
            List<com.ss.android.lark.media.Scene> r114 = MediaMutex.f431631r.a();
            if (r114 == null) goto L35;
            boolean r115 = r114.contains(com.ss.android.lark.media.Scene.VC_MEETING);
        L36:
            r113[1] = TuplesKt.to("is_start_with_meeting", Boolean.valueOf(r115));
            fwa.a.f479017a = r111.start(r213, r214, r112, null, false, null, null, null, MapsKt.mapOf(r113));
            d r116 = this.f409256a;
            if (r116.f409226i == true) goto L39;
        L60:
            d r117 = this.f409256a;
            r117.f409232o = 0;
            r117.f409228k = false;
            r117.f409237t = null;
            r117.f409229l = UUID.randomUUID().toString();
            this.f409256a.f409230m = t.a().getRealPath() + '/' + this.f409256a.f409229l;
            this.f409256a.f409218a.b();
            d r118 = this.f409256a;
            r118.f409218a.d(r118.f409238u);
            d r119 = this.f409256a;
            r119.f409218a.f(r119.f409230m, r119.f409229l, r119.f409226i, r119.f409227j, r211);
            d r120 = this.f409256a;
            return r120.f409225h.e(r120.f409230m, r120.f409239v);
        L39:
            if (r116.f409221d == true) goto L60;
            Intrinsics.checkNotNullParameter(r210, "feature");
            if (fwa.a.f479018b == null) goto L54;
            int r121 = o.f409281a;
            if (CarUtils.a() == false) goto L46;
        L51:
            boolean r122 = true;
        L52:
            if (r122 == true) goto L54;
            fwa.a.a(false, BasicTestActionHandler.TEST_ACTION_RESET);
            goto L54
        L46:
            if (AudioRecordSettings.e().contains("im.messenger.new_voice_input") == true) goto L51;
            if (o.a("im.messenger.new_voice_input") == true) goto L51;
            r122 = false;
        L54:
            Log.d("AudioAppreciablePerformanceV2", "startRecognition");
            int r123 = fwa.a.C5957a.f479043a[r210.ordinal()];
            if (r123 == 1) goto L58;
            if (r123 == 3) goto L59;
            r108 = "unknown";
        L59:
            fwa.a.f479018b = r110.getInstance().start(r213, r214, Event.audio_recognition, null, true, null, null, null, MapsKt.mapOf(TuplesKt.to("from_type", r108)));
            fwa.a.f479028l = System.currentTimeMillis();
            goto L60
        L58:
            r108 = "speech_plus_text";
            goto L59
        L35:
            r115 = false;
            goto L36
        L23:
            int r124 = fwa.a.C5957a.f479043a[r210.ordinal()];
            if (r124 == 1) goto L31;
            if (r124 == 2) goto L30;
            if (r124 != 3) goto L29;
            r109 = "speech_to_text";
            goto L32
        L29:
            throw new NoWhenBranchMatchedException();
        L30:
            r109 = "recording_view";
            goto L32
        L31:
            r109 = "speech_plus_text";
            goto L32
        L19:
            r107 = "tap_panel";
            goto L20
        L12:
            r102 = false;
            goto L13
        L8:
            r101 = false;
            goto L9
        }
    }

    static {
    }

    public static final void a(d r110) {
        if (r110.f409236s == true) goto L17;
        AudioRecordConfigBuilder r100 = AudioRecordConfigBuilder.IM;
        if (r110.f409223f.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        LarkAudioRecorder r102 = r110.f409225h;
        com.ss.android.lark.audio.recorder.c r103 = r100.getAudioRecordConfig();
        AudioRecordDelegateImplKt.a(r103);
        r102.c(r103);
    L15:
        r110.f409236s = true;
        return;
    L11:
        LarkAudioRecorder r104 = r110.f409225h;
        com.ss.android.lark.audio.recorder.c r111 = new com.ss.android.lark.audio.recorder.c(r110.f409222e, r100.getAudioRecordConfig().f409110b, r110.f409223f, r100.getAudioRecordConfig().f409112d, false, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT);
        AudioRecordDelegateImplKt.a(r111);
        if (CarUtils.a() == false) goto L14;
        r111.f409118j = 7;
    L14:
        r104.c(r111);
        goto L15
    L8:
        r101 = false;
        goto L9
    }

    public d(com.ss.android.lark.audio.voiceinput.processor.c r100, f r101, boolean r102, boolean r103, String r104, String r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordDataProcessor");
        Intrinsics.checkNotNullParameter(r101, "audioDataCallback");
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r105, "psdaRecordToken");
        this.f409218a = r100;
        this.f409219b = r101;
        this.f409220c = r102;
        this.f409221d = r103;
        this.f409222e = r104;
        this.f409223f = r105;
        this.f409224g = r106;
        this.f409225h = new LarkAudioRecorder();
        this.f409229l = "";
        this.f409230m = "";
        this.f409233p = 300000;
        this.f409234q = new CopyOnWriteArrayList();
        this.f409235r = o.a("messenger.keyboard.increase_audio_volume");
        int r107 = com.ss.android.lark.audio.opus.m.f409066a;
        o.a("messenger.audio.support.single.encoder");
        this.f409238u = new b(this);
        this.f409239v = new c(this);
        this.f409240w = new C4754d(this);
    }
}
