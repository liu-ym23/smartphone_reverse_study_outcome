package com.obric.assistant.audio;

import com.larus.media.MediaOccupyStrategy;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f385654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, MediaOccupyStrategy> f385655b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f385656c = null;

    static {
        f385654a = LazyKt.lazy(new r());
        MediaOccupyStrategy r100 = MediaOccupyStrategy.INTERRUPT;
        f385655b = MapsKt.mapOf(new Pair[]{TuplesKt.to(MapRouteService.MapPackageName.PACKAGE_NAME_AMAP, MediaOccupyStrategy.PAUSE), TuplesKt.to("com.luna.music", r100), TuplesKt.to("com.obric.recorder", r100), TuplesKt.to("com.tencent.mm", r100), TuplesKt.to("com.ss.android.lark", r100), TuplesKt.to("com.android.server.telecom", r100), TuplesKt.to("com.tencent.qqmusic", r100), TuplesKt.to("com.ss.android.ugc.aweme", r100)});
        f385656c = SetsKt.setOf("com.ss.android.ugc.aweme");
    }
}
