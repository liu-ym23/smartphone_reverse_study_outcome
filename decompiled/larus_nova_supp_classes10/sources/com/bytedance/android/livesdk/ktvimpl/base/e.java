package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public static final Map<KtvConflictScene, List<f>> a = null;

    static {
        KtvConflictScene r1 = KtvConflictScene.SCENE_ANCHOR_GAME;
        KtvConflictScene r3 = KtvConflictScene.SCENE_KSONG;
        KtvConflictScene r2 = KtvConflictScene.SCENE_SOUND_EFFECT;
        KtvConflictScene r8 = KtvConflictScene.SCENE_KTV;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, CollectionsKt.listOf(new f(r3, 0))), TuplesKt.to(r2, CollectionsKt.listOf(new f[]{new f(r3, 2131922630), new f(r8, 2131918541), new f(KtvConflictScene.SCENE_KTV_CHORUS, 2131915797)})), TuplesKt.to(r3, CollectionsKt.listOf(new f[]{new f(r1, 2131918619), new f(r2, 2131918357), new f(r8, 0)})), TuplesKt.to(KtvConflictScene.SCENE_INTERACTIVE_SONG, CollectionsKt.listOf(new f(r8, 0))), TuplesKt.to(r8, CollectionsKt.listOf(new f(r2, 2131918540))), TuplesKt.to(KtvConflictScene.SCENE_PAUSE_LIVE, CollectionsKt.listOf(new f[]{new f(r3, 2131915353), new f(r8, 2131915354)})), TuplesKt.to(KtvConflictScene.SCENE_WGAME, CollectionsKt.listOf(new f[]{new f(r3, 2131916808), new f(r8, 2131916809)}))});
    }
}
