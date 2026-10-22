package com.larus.audio.tts;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.audio.r0;
import com.larus.audio.repo.AudioConfigRepo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioDowngradeManager implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioDowngradeManager f289820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f289821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<x78.a> f289822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlowImpl f289823d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f289824e = null;

    public AudioDowngradeManager() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.audio.tts.a] */
    static {
        f289820a = new AudioDowngradeManager();
        f289821b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f289823d = j1.a(0);
        f289824e = new a();
        List<x78.a> r100 = (List) new Gson().fromJson(AudioConfigRepo.f289782b.getString("key_audio_downgrade_config_string", ""), new com.larus.audio.repo.d().getType());     // Catch: Exception -> L5
    L7:
        f289822c = r100;
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("AudioConfigRepo", "[getDowngradeConfig] error: " + e.getMessage());
        r100 = null;
        goto L7
    }

    public static void b() {
        String r100 = VoiceCallServiceDelegate.f377087a.k(true);
        if (o0.d(r100) == true) goto L11;
        g(CollectionsKt.emptyList());
        return;
    L11:
        List r101 = ArraysKt.toList((Object[]) new Gson().fromJson(r100, x78.a[].class));     // Catch: Exception -> L6
    L8:
        g(r101);
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.i("AudioDowngradeManager", "fetchDowngradeConfig Gson parse error=" + e);
        r101 = CollectionsKt.emptyList();
        goto L8
    }

    public static void c() {
        BuildersKt.launch$default(f289821b, null, null, new AudioDowngradeManager$getDowngradeConfig$1(null), 3, null);
    }

    public static boolean d() {
        List<x78.a> r100 = f289822c;
        if (r100 == null) goto L11;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((x78.a) r101.next()).a(), DowngradeType.TTS_AUTOPLAY_DOWNGRADE.getType()) == false) goto L6;
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlayHardDowngrade true");
        return true;
    L11:
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlayHardDowngrade false");
        return false;
    }

    public static boolean e() {
        List<x78.a> r100 = f289822c;
        boolean r101 = false;
        String r102 = "";
        if (r100 == null) goto L30;
        Iterator<T> r103 = r100.iterator();
        String r104 = "";
        boolean r105 = false;
    L6:
        if (r103.hasNext() == false) goto L29;
        x78.a r106 = (x78.a) r103.next();
        if (Intrinsics.areEqual(r106.a(), DowngradeType.TTS_SOFT_DOWNGRADE.getType()) == false) goto L6;
        AudioConfigRepo r107 = AudioConfigRepo.f289781a;
        Keva r108 = AudioConfigRepo.f289782b;
        r104 = r108.getString("KEY_AUDIO_SOFT_DOWNGRADE_VERSION", "");
        boolean r109 = true;
        if (Intrinsics.areEqual(r106.b(), r104) == true) goto L15;
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlaySoftDowngrade01 true");
        r104 = r106.b();
        if (r104 != null) goto L26;
        r104 = "";
    L26:
        if (r109 == false) goto L28;
        r108.storeBoolean("key_audio_downgrade_version_last_soft", false);
    L28:
        r105 = r109;
        goto L6
    L15:
        if (o0.d(r104) == false) goto L20;
        if (r108.getBoolean("key_audio_downgrade_version_last_soft", false) == true) goto L20;
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlaySoftDowngrade02 true");
    L20:
        if (o0.d(r104) == true) goto L22;
    L24:
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlaySoftDowngrade02 false");
        r104 = "";
    L25:
        r109 = false;
        goto L26
    L22:
        if (r108.getBoolean("key_audio_downgrade_version_last_soft", false) == false) goto L24;
        FLogger.f375446a.i("AudioDowngradeManager", "isAutoPlaySoftDowngrade01 false");
        goto L25
    L29:
        r101 = r105;
        r102 = r104;
    L30:
        AudioConfigRepo.f289782b.storeString("KEY_AUDIO_SOFT_DOWNGRADE_VERSION", r102);
        return r101;
    }

    public static boolean f() {
        List<x78.a> r100 = f289822c;
        if (r100 == null) goto L11;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((x78.a) r101.next()).a(), DowngradeType.TTS_MANUALPLAY_DOWNGRADE.getType()) == false) goto L6;
        FLogger.f375446a.i("AudioDowngradeManager", "isManualPlayHardDowngrade true");
        return true;
    L11:
        FLogger.f375446a.i("AudioDowngradeManager", "isManualPlayHardDowngrade false");
        return false;
    }

    public static void g(List r100) {
        AudioConfigRepo r101 = AudioConfigRepo.f289781a;
        String r102 = new Gson().toJson(r100);     // Catch: Exception -> L8
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        AudioConfigRepo.f289782b.storeString("key_audio_downgrade_config_string", r102);     // Catch: Exception -> L8
    L10:
        f289822c = r100;
        StateFlowImpl r103 = f289823d;
        r103.setValue(Integer.valueOf(((Number) r103.getValue()).intValue() + 1));
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("AudioConfigRepo", "[setDowngradeConfig] error: " + e.getMessage());
        goto L10
    }

    @Override // com.larus.audio.r0
    public final void a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.get("checkpoint");
        String r102 = "";
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        Keva r103 = AudioConfigRepo.f289782b;
        String r104 = r103.getString("key_audio_downgrade_version_from_cmd", "");
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        FLogger.f375446a.i("AudioDowngradeManager", "getDowngradeConfigWhenVersionChanged downgradeVersion=" + r101 + " downgradeVersionKeva=" + r102);
        if (Intrinsics.areEqual(r101, r102) == false) goto L14;
        return;
    L14:
        r103.storeString("key_audio_downgrade_version_from_cmd", r101);
        c();
    }
}
