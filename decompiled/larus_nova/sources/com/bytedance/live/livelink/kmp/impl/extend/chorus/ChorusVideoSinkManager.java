package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
public final class ChorusVideoSinkManager implements com.bytedance.live.livelink.kmp.impl.extend.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f255559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, oi6.b> f255560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f255561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExtendContext f255562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f255563e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255562d;
    }

    public final void a(String r100) {
        k0 r101 = new k0(com.bytedance.live.livelink.kmp.impl.extend.c.e(this), r100, LiveWrappedStreamIndex.STREAM_INDEX_MAIN);
        fg2.b r102 = new fg2.b();
        r102.a((LiveWrappedVideoPixelFormat) this.f255561c.getValue());
        mi6.a r103 = com.bytedance.live.livelink.kmp.impl.extend.c.f(this);
        if (r103 == null) goto L5;
        r103.z(r101, com.bytedance.live.livelink.kmp.impl.extend.c.l(this, r100), r102);
    L5:
        int r104 = ej6.a.f472874a;
        ej6.a.a("ChorusVideoSinkManager", "multi_chorus_livelink setRemoteVideoSink to origin, interactId: " + r100);
    }

    public ChorusVideoSinkManager(ExtendContext r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        Intrinsics.checkNotNullParameter(r101, "chorusScope");
        this.f255562d = r100;
        this.f255563e = r101;
        this.f255559a = new ArrayList();
        this.f255560b = new LinkedHashMap();
        this.f255561c = LazyKt.lazy(new ChorusVideoSinkManager$pixelFormat$2(this));
    }
}
