package com.bytedance.live.livelink.kmp.impl.extend.spatialaudio;

import com.bytedance.live.livelink.kmp.api.base.interceptor.InterceptModule;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.InterceptorCallExtendKt;
import com.bytedance.live.livelink.kmp.impl.extend.b;
import com.bytedance.live.livelink.kmp.impl.extend.c;
import com.bytedance.revenue.platform.api.core.rx.f;
import hi6.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class SpatialAudioManager implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f255599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.a> f255600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExtendContext f255601c;

    public static final class a {
    }

    static {
    }

    public final void d() {
        InterceptModule r100 = InterceptModule.STREAM_MIX;
        f.a(InterceptorCallExtendKt.a(this, r100, j.d.f485358b, new SpatialAudioManager$init$1(this)), this.f255599a);
        f.a(InterceptorCallExtendKt.a(this, r100, j.e.f485359b, new SpatialAudioManager$init$2(this)), this.f255599a);
        f.a(InterceptorCallExtendKt.a(this, r100, j.b.f485356b, new SpatialAudioManager$init$3(this)), this.f255599a);
        f.a(InterceptorCallExtendKt.a(this, r100, j.f.f485360b, new SpatialAudioManager$init$4(this)), this.f255599a);
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255601c;
    }

    public SpatialAudioManager(ExtendContext r100) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        this.f255601c = r100;
        this.f255599a = new CompositeDisposable();
        this.f255600b = new LinkedHashMap();
    }

    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        c.n(this, "SpatialAudioManager disableRemoteOrientation", new SpatialAudioManager$disableRemoteOrientation$1(this, r100));
    }

    public final void b(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        c.n(this, "SpatialAudioManager enableSpatialAudioRender", new SpatialAudioManager$enableSpatialAudioRender$1(this, r100, r101));
    }

    public final void e(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        Intrinsics.checkNotNullParameter(r101, "uid");
        c.n(this, "SpatialAudioManager removeRemotePosition", new SpatialAudioManager$removeRemotePosition$1(this, r100, r101));
    }

    public final void g(final String r100, final aj6.a r101) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        Intrinsics.checkNotNullParameter(r101, "rtcPositionInfo");
        c.n(this, "SpatialAudioManager updateSelfPosition", new SpatialAudioManager$updateSelfPosition$1(this, r100, r101));
    }

    public final void f(final String r100, final String r101, final aj6.a r102) {
        Intrinsics.checkNotNullParameter(r100, "roomID");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "rtcPositionInfo");
        c.n(this, "SpatialAudioManager updateRemotePosition", new SpatialAudioManager$updateRemotePosition$1(this, r100, r101, r102));
    }
}
