package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.f;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class AudioFileSaver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f289618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f289619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, FileOutputStream> f289620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, File> f289621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f289622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f289623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f289624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f289625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f289626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f289627k;

    public static final class a {
    }

    static {
    }

    public final String e() {
        if (this.f289618b == false) goto L6;
        return f.d().f289127c.f289102e;
    L6:
        return f.d().f289127c.f289100c;
    }

    public final void i() {
        g(new AudioFileSaver$release$1(this, null));
    }

    public static long d(File r110) {
        long r100 = 0;
        if (r110.isDirectory() == true) goto L5;
        return 0;
    L5:
        File[] r111 = r110.listFiles();
        int r101 = 0;
        if (r111 != null) goto L8;
        r111 = new File[0];
    L8:
        int r102 = r111.length;
    L9:
        if (r101 >= r102) goto L19;
        File r103 = r111[r101];
        if (r103.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r103);
        long r104 = d(r103);
    L15:
        if (r104 <= (Long.MAX_VALUE - r100)) goto L17;
        r100 = Long.MAX_VALUE;
    L18:
        r101 = r101 + 1;
        goto L9
    L17:
        r100 = r100 + r104;
        goto L18
    L13:
        r104 = r103.length();
        goto L15
    L19:
        return r100;
    }

    public final void g(Function2 r100) {
        BuildersKt.launch$default((CoroutineScope) this.f289627k.getValue(), null, null, r100, 3, null);
    }

    public AudioFileSaver(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f289617a = r100;
        this.f289618b = r101;
        this.f289619c = "AudioFileSaver";
        this.f289620d = new LinkedHashMap();
        this.f289621e = new LinkedHashMap();
        this.f289622f = new LinkedHashMap();
        this.f289623g = new LinkedHashSet();
        this.f289625i = f.d().f289127c.f289101d;
        Intrinsics.checkNotNullParameter("avkit#dump", "name");
        this.f289626j = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new q68.e("avkit#dump")));
        this.f289627k = LazyKt.lazy(new com.larus.audio.call.tracer.a(this));
    }

    public static boolean f(File r100, PolarisFileWrapper r101) {
        return StringsKt.startsWith$default(r100.getAbsolutePath(), StringsKt.trimEnd(r101.getAbsolutePath(), new char[]{File.separatorChar}) + File.separator, false, 2, null);
    }

    public final void h(String r100, String r101) {
        if (this.f289623g.add(r101 + ':' + r100) == false) goto L6;
        com.larus.audio.call.util.e.f289645a.w(this.f289619c, "skip audio dump because " + r101 + " quota is reached");
        return;
    }

    public static final String b(AudioFileSaver r100, int r101, String r102) {
        r100.getClass();
        switch(r101) {
            case 0: goto L25;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L4;
            case 18: goto L29;
            case 19: goto L28;
            case 20: goto L27;
            default: goto L4;
        };
    L4:
        return null;
    L27:
        return r100.e() + File.separator + r102 + "_backtrace_record.pcm";
    L28:
        return r100.e() + File.separator + r102 + "_audio_track.pcm";
    L29:
        return r100.e() + File.separator + r102 + "_backtrace_aec_out.pcm";
    L30:
        return f.d().f289127c.f289105h + File.separator + r102 + "_si_play_merge.pcm";
    L31:
        return f.d().f289127c.f289105h + File.separator + r102 + "_si_play_right.pcm";
    L32:
        return f.d().f289127c.f289105h + File.separator + r102 + "_si_play_left.pcm";
    L33:
        return r100.e() + File.separator + r102 + "_opus_record_send.pcm";
    L34:
        return r100.e() + File.separator + r102 + "_first_frame.pcm";
    L35:
        return r100.f289625i + File.separator + "stream_player_" + r102 + Global.SUFFIX_PCM_FILE;
    L36:
        return r100.e() + File.separator + r102 + "_play_processed_with_silent.pcm";
    L37:
        return r100.e() + File.separator + r102 + "_play_raw_with_silent.pcm";
    L38:
        return r100.e() + File.separator + r102 + "_play_processed.pcm";
    L39:
        return r100.e() + File.separator + r102 + "_all_tts_raw.pcm";
    L40:
        return r100.e() + File.separator + r102 + "_produce_empty.pcm";
    L41:
        return r100.e() + File.separator + r102 + "_play_raw.pcm";
    L42:
        return r100.e() + File.separator + r102 + "_ref.pcm";
    L43:
        return r100.e() + File.separator + r102 + "_all_tts.pcm";
    L44:
        return r100.e() + File.separator + r102 + "_play.pcm";
    L45:
        return r100.e() + File.separator + r102 + "_tts.pcm";
    L25:
        return r100.e() + File.separator + r102 + "_mic.pcm";
    }

    public final void j(int r100, byte[] r101, String r110) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (this.f289618b == false) goto L5;
    L7:
        g(new AudioFileSaver$startSavingFile$1(r110, r100, this, r101, null));
        return;
    L5:
        if (c78.a.f22657a == true) goto L7;
    }

    public final void k(int r100, byte[] r101, String r110) {
        Intrinsics.checkNotNullParameter(r101, "data");
        g(new AudioFileSaver$startSavingFileForO$1(r110, r100, this, r101, null));
    }

    public static final boolean a(AudioFileSaver r110, String r111, File r112, int r113) {
        r110.getClass();
        com.larus.audio.call.d r100 = f.d().f289127c;
        Long r101 = (Long) ((LinkedHashMap) r110.f289622f).get(r111);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        boolean r103 = r110.f289618b;
        if (r103 == true) goto L19;
        long r114 = r100.f289106i;
        if (r114 > 0) goto L11;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        r110.h(r111, "file");
    L37:
        return false;
    L11:
        if (r114 == Long.MAX_VALUE) goto L16;
        if (r102 <= (r114 - ((long) r113))) goto L16;
        r104 = true;
    L19:
        if (r103 == false) goto L21;
    L38:
        return true;
    L21:
        if (f(r112, new PolarisFileWrapper(r110.e())) == false) goto L38;
        Long r105 = r110.f289624h;
        if (r105 == null) goto L25;
        long r106 = r105.longValue();
    L26:
        long r115 = r100.f289107j;
        if (r115 > 0) goto L29;
    L34:
        boolean r107 = false;
    L35:
        if (r107 == false) goto L38;
        r110.h(r111, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        goto L37
    L29:
        if (r115 == Long.MAX_VALUE) goto L34;
        if (r106 <= (r115 - ((long) r113))) goto L34;
        r107 = true;
        goto L35
    L25:
        r106 = d(new PolarisFileWrapper(r110.e()));
        r110.f289624h = Long.valueOf(r106);
        goto L26
    L5:
        r102 = r112.length();
        goto L6
    }

    public static final void c(AudioFileSaver r100, String r110, File r111, int r112) {
        Map<String, Long> r101 = r100.f289622f;
        Long r102 = (Long) ((LinkedHashMap) r101).get(r110);
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        long r104 = r112;
        long r105 = Long.MAX_VALUE;
        if (r104 <= (Long.MAX_VALUE - r103)) goto L9;
        long r106 = Long.MAX_VALUE;
    L10:
        r101.put(r110, Long.valueOf(r106));
        if (f(r111, new PolarisFileWrapper(r100.e())) == false) goto L22;
        Long r113 = r100.f289624h;
        if (r113 == null) goto L15;
        long r114 = r113.longValue();
    L17:
        if (r104 > (Long.MAX_VALUE - r114)) goto L20;
        r105 = r114 + r104;
    L20:
        r100.f289624h = Long.valueOf(r105);
        return;
    L15:
        r114 = 0;
        goto L17
    L22:
        return;
    L9:
        r106 = r103 + r104;
        goto L10
    L5:
        r103 = r111.length();
        goto L6
    }
}
