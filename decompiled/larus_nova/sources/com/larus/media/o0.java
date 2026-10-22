package com.larus.media;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f359131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f359132b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f359133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f359134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f359135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f359136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<String> f359137e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f359133a, r101.f359133a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359134b, r101.f359134b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f359135c, r101.f359135c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f359136d, r101.f359136d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f359137e, r101.f359137e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f359133a.hashCode() * 31) + this.f359134b.hashCode()) * 31) + this.f359135c.hashCode()) * 31) + this.f359136d.hashCode()) * 31) + this.f359137e.hashCode();
        }

        public final String toString() {
            return "SceneConfig(interruptScenes=" + this.f359133a + ", rejectScenes=" + this.f359134b + ", mixableScenes=" + this.f359135c + ", waitScenes=" + this.f359136d + ", specialPauseScenes=" + this.f359137e + ')';
        }

        public a(Set<String> r100, Set<String> r101, Set<String> r102, Set<String> r103, Set<String> r104) {
            Intrinsics.checkNotNullParameter(r100, "interruptScenes");
            Intrinsics.checkNotNullParameter(r101, "rejectScenes");
            Intrinsics.checkNotNullParameter(r102, "mixableScenes");
            Intrinsics.checkNotNullParameter(r103, "waitScenes");
            Intrinsics.checkNotNullParameter(r104, "specialPauseScenes");
            this.f359133a = r100;
            this.f359134b = r101;
            this.f359135c = r102;
            this.f359136d = r103;
            this.f359137e = r104;
        }

        public /* synthetic */ a(Set r100, Set r101, Set r102, Set r110, Set r111, int r112) {
            if ((r112 & 8) == 0) goto L5;
            r110 = SetsKt.emptySet();
        L5:
            Set r103 = r110;
            if ((r112 & 16) == 0) goto L8;
            r111 = SetsKt.emptySet();
        L8:
            this(r100, r101, r102, r103, r111);
        }
    }

    public o0() {
    }

    static {
        Map<String, a> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to(MediaScene.DORA, new a(SetsKt.setOf(new String[]{MediaScene.UGC_VOICE, "VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.DORA_ONBOARDING, "asr", MediaScene.O_IM_ASR, MediaScene.CALL_TTS_PLAY, "CALL", MediaScene.O_CALL, MediaScene.NEWS, MediaScene.NAVIGATION, MediaScene.AI_NOTE}), SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), SetsKt.setOf(new String[]{"music", "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.STREAM_PLAYER, MediaScene.SYSTEM, MediaScene.OBRIC_DORA}), null, null, 24)), TuplesKt.to("CALL", new a(SetsKt.setOf(MediaScene.DORA), SetsKt.emptySet(), SetsKt.emptySet(), null, null, 24)), TuplesKt.to(MediaScene.O_CALL, new a(SetsKt.setOf(MediaScene.DORA), SetsKt.emptySet(), SetsKt.emptySet(), null, null, 24)), TuplesKt.to(MediaScene.CALL_TTS_PLAY, new a(SetsKt.setOf(MediaScene.DORA), SetsKt.setOf(new String[]{MediaScene.NEWS, MediaScene.STREAM_PLAYER}), SetsKt.setOf(new String[]{MediaScene.SYSTEM, "plugin_background_audio", MediaScene.MUSIC_GEN, "VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), null, null, 24)), TuplesKt.to(MediaScene.NAVIGATION, new a(SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.CALL_TTS_PLAY, "CALL", MediaScene.O_CALL, MediaScene.DORA_ONBOARDING, MediaScene.AI_NOTE}), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.SYSTEM, "asr", MediaScene.O_IM_ASR, MediaScene.TTS_SAMPLE, MediaScene.UGC_VOICE, "music", "plugin_background_audio", MediaScene.AUTO_MUSIC, MediaScene.MUSIC_GEN, "VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), null, null, 24)), TuplesKt.to("music", new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC}), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.TTS_SAMPLE, MediaScene.NAVIGATION, MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.OBRIC_TTS, MediaScene.AI_NOTE, MediaScene.O_IM_ASR, MediaScene.O_CALL}), null, SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.OBRIC_TTS, MediaScene.SYSTEM, "asr", MediaScene.UGC_VOICE, MediaScene.AI_NOTE, "CALL", MediaScene.VOICE_COMPONENT}), 8)), TuplesKt.to("plugin_background_audio", new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, "music", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC}), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.TTS_SAMPLE, MediaScene.NAVIGATION, MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.AI_NOTE, MediaScene.O_IM_ASR, MediaScene.O_CALL}), null, SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.SYSTEM, "CALL", "asr", MediaScene.UGC_VOICE, MediaScene.AI_NOTE, MediaScene.VOICE_COMPONENT}), 8)), TuplesKt.to("plugin_inner_audio", new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, "music", "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC, MediaScene.STREAM_PLAYER}), SetsKt.emptySet(), SetsKt.emptySet(), null, SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.SYSTEM, "CALL", "asr", MediaScene.UGC_VOICE, MediaScene.AI_NOTE}), 8)), TuplesKt.to(MediaScene.NEWS, new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, "music", "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC, MediaScene.STREAM_PLAYER}), SetsKt.emptySet(), SetsKt.setOf(MediaScene.TTS_SAMPLE), null, SetsKt.setOf(new String[]{MediaScene.SYSTEM, "asr", MediaScene.O_IM_ASR, MediaScene.UGC_VOICE, MediaScene.DORA, MediaScene.NAVIGATION, "CALL", MediaScene.O_CALL, MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.OBRIC_TTS, MediaScene.AI_NOTE}), 8)), TuplesKt.to("VIDEO", new a(SetsKt.setOf(new String[]{"music", "plugin_background_audio", MediaScene.AUTO_MUSIC, MediaScene.MUSIC_GEN, MediaScene.NEWS, MediaScene.AI_NOTE}), SetsKt.emptySet(), SetsKt.setOf(MediaScene.TTS_SAMPLE), null, SetsKt.setOf(new String[]{MediaScene.SYSTEM, "asr", MediaScene.O_IM_ASR, MediaScene.O_CALL, MediaScene.UGC_VOICE, MediaScene.DORA, MediaScene.NAVIGATION, "CALL", MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), 8)), TuplesKt.to(MediaScene.LOCAL_LIFE_VIDEO, new a(SetsKt.setOf(new String[]{"music", "plugin_background_audio", MediaScene.AUTO_MUSIC, MediaScene.MUSIC_GEN, MediaScene.NEWS, MediaScene.AI_NOTE}), SetsKt.emptySet(), SetsKt.setOf(MediaScene.TTS_SAMPLE), null, SetsKt.setOf(new String[]{MediaScene.SYSTEM, "asr", MediaScene.O_IM_ASR, MediaScene.O_CALL, MediaScene.UGC_VOICE, MediaScene.DORA, MediaScene.NAVIGATION, "CALL", MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), 8)), TuplesKt.to(MediaScene.AI_NOTE, new a(SetsKt.setOf(new String[]{MediaScene.DORA, "VIDEO", MediaScene.LOCAL_LIFE_VIDEO, "CALL", MediaScene.O_CALL, MediaScene.CALL_TTS_PLAY, MediaScene.UGC_VOICE, MediaScene.NAVIGATION}), SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), SetsKt.setOf(new String[]{"music", "plugin_background_audio", MediaScene.AUTO_MUSIC, MediaScene.NEWS, MediaScene.SYSTEM}), null, SetsKt.emptySet(), 8)), TuplesKt.to(MediaScene.TTS_SAMPLE, new a(SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.OBRIC_TTS}), SetsKt.emptySet(), SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, MediaScene.NAVIGATION, "music", "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC}), null, null, 24)), TuplesKt.to(MediaScene.IM_TTS, new a(SetsKt.setOf(MediaScene.DORA), SetsKt.emptySet(), SetsKt.setOf(new String[]{"music", "plugin_background_audio", MediaScene.AUTO_MUSIC}), null, SetsKt.setOf(MediaScene.DORA), 8)), TuplesKt.to(MediaScene.OBRIC_TTS, new a(SetsKt.setOf(new String[]{MediaScene.DORA, "asr", MediaScene.O_IM_ASR}), SetsKt.setOf(MediaScene.IM_TTS), SetsKt.setOf(new String[]{"music", MediaScene.AUTO_MUSIC}), SetsKt.setOf(MediaScene.IM_TTS), SetsKt.setOf(MediaScene.DORA))), TuplesKt.to(MediaScene.OBRIC_DORA, new a(SetsKt.setOf(new String[]{"asr", MediaScene.O_IM_ASR}), SetsKt.setOf(MediaScene.IM_TTS), SetsKt.setOf(new String[]{MediaScene.DORA, "music", MediaScene.AUTO_MUSIC}), SetsKt.setOf(MediaScene.IM_TTS), null, 16)), TuplesKt.to(MediaScene.AUTO_MUSIC, new a(SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.NAVIGATION, MediaScene.CALL_TTS_PLAY, MediaScene.O_CALL, MediaScene.DORA_ONBOARDING, MediaScene.IM_TTS, MediaScene.TTS_SAMPLE, MediaScene.AI_NOTE}), null, null, 24)), TuplesKt.to(MediaScene.MUSIC_GEN, new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, "music", MediaScene.AUTO_MUSIC, MediaScene.IM_TTS}), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.NAVIGATION, MediaScene.CALL_TTS_PLAY, MediaScene.AI_NOTE}), null, SetsKt.setOf(new String[]{MediaScene.SYSTEM, "CALL", "asr", MediaScene.UGC_VOICE, MediaScene.AI_NOTE, MediaScene.VOICE_COMPONENT}), 8)), TuplesKt.to(MediaScene.STREAM_PLAYER, new a(SetsKt.setOf(new String[]{"VIDEO", MediaScene.LOCAL_LIFE_VIDEO, MediaScene.NEWS, "music", "plugin_background_audio", MediaScene.MUSIC_GEN, MediaScene.AUTO_MUSIC}), SetsKt.emptySet(), SetsKt.setOf(new String[]{MediaScene.DORA, MediaScene.NAVIGATION, MediaScene.CALL_TTS_PLAY, MediaScene.IM_TTS, MediaScene.AI_NOTE}), null, SetsKt.setOf(new String[]{MediaScene.IM_TTS, MediaScene.SYSTEM, "CALL", "asr", MediaScene.UGC_VOICE, MediaScene.AI_NOTE, MediaScene.VOICE_COMPONENT}), 8))});
        f359131a = r100;
        if (AppHost.f326268a.isDebug() == false) goto L21;
        Iterator<Map.Entry<String, a>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L21;
        Map.Entry<String, a> r102 = r101.next();
        String r103 = r102.getKey();
        a r104 = r102.getValue();
        if (CollectionsKt.intersect(r104.f359133a, r104.f359134b).isEmpty() == false) goto L20;
        if (CollectionsKt.intersect(r104.f359133a, r104.f359135c).isEmpty() == false) goto L18;
        if (CollectionsKt.intersect(r104.f359136d, r104.f359135c).isEmpty() == true) goto L7;
        throw new IllegalStateException(("[" + r103 + "] waitScenes & mixableScenes repeat: " + CollectionsKt.intersect(r104.f359136d, r104.f359135c)).toString());
    L18:
        throw new IllegalStateException(("[" + r103 + "] interruptScenes & mixableScenes repeat: " + CollectionsKt.intersect(r104.f359133a, r104.f359135c)).toString());
    L20:
        throw new IllegalStateException(("[" + r103 + "] interruptScenes & rejectScenes repeat: " + CollectionsKt.intersect(r104.f359133a, r104.f359134b)).toString());
    L21:
        f359132b = SetsKt.setOf(new String[]{"music", MediaScene.AUTO_MUSIC, MediaScene.MUSIC_GEN, MediaScene.STREAM_PLAYER});
    }

    public static boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "currentScene");
        Intrinsics.checkNotNullParameter(r101, "targetScene");
        a r102 = f359131a.get(r100);
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r102.f359135c.contains(r101) != true) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(r101, "CALL") == true) goto L13;
    L17:
        return false;
    L13:
        if (f359132b.contains(r100) == false) goto L17;
        if (z2.f365865a.realtimeCallAllSceneMixEnable() == false) goto L17;
        return true;
    L7:
        r103 = false;
        goto L8
    }

    public static MediaOccupyStrategy b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "currentScene");
        Intrinsics.checkNotNullParameter(r101, "targetScene");
        a r102 = f359131a.get(r100);
        if (r102 == null) goto L13;
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r102.f359133a.contains(r101) == false) goto L8;
        MediaOccupyStrategy r103 = MediaOccupyStrategy.INTERRUPT;
    L11:
        if (r103 == null) goto L13;
        return r103;
    L8:
        if (r102.f359134b.contains(r101) == false) goto L10;
        r103 = MediaOccupyStrategy.REJECT;
        goto L11
    L10:
        r103 = MediaOccupyStrategy.PAUSE;
    L13:
        return MediaOccupyStrategy.PAUSE;
    }

    public static boolean c(String r100, String r101) {
        Function0 r102 = new n0();
        Intrinsics.checkNotNullParameter(r100, "currentScene");
        Intrinsics.checkNotNullParameter(r101, "targetScene");
        Intrinsics.checkNotNullParameter(r102, "specialsRule");
        a r103 = f359131a.get(r100);
        if (r103 == null) goto L9;
        Set<String> r104 = r103.f359137e;
        if (r104 == null) goto L9;
        if (r104.contains(r101) != true) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L12;
        return false;
    L12:
        if (Boolean.TRUE.booleanValue() == false) goto L16;
        return true;
    L16:
        return false;
    L9:
        r105 = false;
        goto L10
    }
}
