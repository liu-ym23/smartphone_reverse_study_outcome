package e88;

import com.larus.platform.api.o0;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.VideoEngineInfos;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audioplayer.impl.music.a f471379a;

    public g(com.larus.audioplayer.impl.music.a r100) {
        this.f471379a = r100;
    }

    @Override // com.larus.platform.api.o0
    public final void a(yq9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (Intrinsics.areEqual(r100.f568873a, VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE) == false) goto L10;
        FLogger.f375446a.i("MusicPlayEngine", "music media hit cache info: " + r100);
        com.larus.audioplayer.impl.music.a r101 = this.f471379a;
        long r102 = r100.f568876d;
        if (r102 <= 0) goto L7;
        boolean r103 = true;
    L8:
        r101.f290285t = r103;
        a88.e r104 = r101.f290266a;
        i1.k(r104.f2201m, r104.f2189a, r103, r102, null, 48);
        return;
    L7:
        r103 = false;
        goto L8
    }
}
