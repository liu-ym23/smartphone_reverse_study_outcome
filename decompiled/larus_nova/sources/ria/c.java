package ria;

import android.content.Context;
import android.media.SoundPool;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f537921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f537922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f537923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f537924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, Integer> f537925e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Integer, Integer> f537926f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SoundPool f537927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f537928h = null;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [ria.b] */
    static {
        f537921a = new c();
        f537923c = -1;
        f537925e = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, Integer.valueOf(R.raw.sva_sfx_voiceprint_recording_feedback_1)), TuplesKt.to(1, Integer.valueOf(R.raw.sva_sfx_voiceprint_recording_feedback_2)), TuplesKt.to(2, Integer.valueOf(R.raw.sva_sfx_voiceprint_recording_feedback_3)), TuplesKt.to(3, Integer.valueOf(R.raw.sva_sfx_voiceprint_recording_feedback_4)), TuplesKt.to(4, Integer.valueOf(R.raw.sva_sfx_voiceprint_recording_feedback_5))});
        f537926f = new LinkedHashMap();
        f537928h = new b();
    }

    public final Context getContext() {
        return f537922b;
    }

    public final synchronized void a(int r100, float r101) {
        monitor-enter(this);
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L14
        r102.i("SoundPlayer", "playSound soundId = " + r100 + ", playingSoundId = " + f537923c);     // Catch: Throwable -> L14
        if (r100 == f537923c) goto L8;
        monitor-exit(this);
        return;
    L8:
        r102.i("SoundPlayer", "do play sound id = " + r100);     // Catch: Throwable -> L14
        SoundPool r103 = f537927g;     // Catch: Throwable -> L14
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("soundPool");     // Catch: Throwable -> L14
        r103 = null;
    L11:
        r103.play(r100, r101, r101, 0, 0, 1.0f);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
