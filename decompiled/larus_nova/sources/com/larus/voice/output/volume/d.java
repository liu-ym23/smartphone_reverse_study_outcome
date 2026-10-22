package com.larus.voice.output.volume;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements o78.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f376040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f376041b = null;

    public d() {
    }

    @Override // o78.b
    public final void b(String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    static {
        f376040a = new d();
        f376041b = new ArrayList();
    }

    public static void f(a r100) {
        ArrayList r101 = (ArrayList) f376041b;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public static void e(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        int r102 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[onPlayTriggered] scene: ".concat(r100));
        z2 r103 = z2.f365865a;
        c r104 = new c(r103.T2(), r103.enableAutoPlayAudioZeroVolumeToast(), r100, r101);
        Iterator r105 = ((ArrayList) f376041b).iterator();
    L4:
        if (r105.hasNext() == false) goto L12;
        a r106 = (a) r105.next();
        if (r106.b(r104) == false) goto L4;
        r106.a(r104);
        return;
    }

    @Override // o78.b
    public final void c(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.TTS_IM, "scene");
        Intrinsics.checkNotNullParameter(r100, "uniId");
        if (Intrinsics.areEqual(GlobalAudioSceneEnum.TTS_IM, GlobalAudioSceneEnum.TTS_IM) == false) goto L6;
        e(GlobalAudioSceneEnum.TTS_IM, r101);
        return;
    }

    @Override // o78.b
    public final void a(String r100, GlobalAudioStateEnum r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
        int r103 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "onPlaybackStateChanged scene: " + r100 + ", playbackState: " + r101);
        if (r101 == GlobalAudioStateEnum.PLAYING) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, GlobalAudioSceneEnum.TTS_REAL_TIME_CALL) == true) goto L9;
        e(r100, r102);
        return;
    }

    @Override // o78.b
    public final void d(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniId");
        int r103 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "onPlayTriggered scene: " + r100 + ", uniId: " + r101);
    }
}
