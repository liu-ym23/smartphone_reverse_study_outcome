package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class StartAnimationMethod extends com.bytedance.locallife.live.lynx.syncjsb.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f260581d = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "startAnimation";
    }

    public StartAnimationMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(final HashMap<String, Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        final LiveLocalLifeLynxView r100 = this.f260600b;
        if (r100 == null) goto L5;
        Integer r101 = w.b(r110, "type");
        if (r101 == null) goto L19;
        final int r102 = r101.intValue();
        Float r103 = w.a(r110, "end_value");
        if (r103 == null) goto L17;
        final float r104 = r103.floatValue();
        Long r105 = w.c(r110, "duration");
        if (r105 == null) goto L15;
        final long r106 = r105.longValue();
        j0.h(new StartAnimationMethod$handleMethod$1(r110, r102, r100, r104, r106, this));
        return com.bytedance.locallife.live.lynx.syncjsb.a.d(this, null, 3);
    L15:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("duration is null");
    L17:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("end_value is null");
    L19:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("type is null");
    L5:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("targetView is null");
    }

    public static final void g(StartAnimationMethod r100, LiveLocalLifeLynxView r101, int r102) {
        r100.getClass();
        r101.c("animationEvent", CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("event", Integer.valueOf(r102)))));
    }
}
