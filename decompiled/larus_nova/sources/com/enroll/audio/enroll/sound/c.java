package com.enroll.audio.enroll.sound;

import android.media.SoundPool;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f273811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f273812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f273813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, Integer> f273814d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SoundPool f273815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f273816f = null;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.enroll.audio.enroll.sound.b] */
    static {
        f273811a = new c();
        f273812b = -1;
        f273814d = new LinkedHashMap();
        f273816f = new b();
    }

    public static void a(int r100, float r101) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SoundPlayer$playAsync$1(r100, r101, false, null), 3, null);
    }
}
